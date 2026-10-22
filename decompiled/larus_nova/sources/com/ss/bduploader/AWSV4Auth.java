package com.ss.bduploader;

import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes40.dex */
public class AWSV4Auth {
    private static String MAC_ALGORITHM = "HmacSHA256";
    protected static final char[] hexArray = null;
    private static Mac mMacInstance;
    private static MessageDigest mMessageDigest;
    private String accessKeyID;
    private TreeMap<String, String> awsHeaders;
    private boolean awsHeadersHasTimestamp;
    private String canonicalURI;
    private String currentDate;
    private boolean debug;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String strSignedHeader;
    private String xAmzDate;

    /* JADX INFO: renamed from: com.ss.bduploader.AWSV4Auth$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String accessKeyID;
        private TreeMap<String, String> awsHeaders;
        private String canonicalURI;
        private boolean debug;
        private String httpMethodName;
        private String payload;
        private TreeMap<String, ArrayList<String>> queryParameters;
        private String regionName;
        private String secretAccessKey;
        private String serviceName;

        public Builder debug() {
            this.debug = true;
            return this;
        }

        public AWSV4Auth build() {
            return new AWSV4Auth(this, null);
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.accessKeyID;
        }

        public static /* synthetic */ boolean access$1000(Builder r100) {
            return r100.debug;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.secretAccessKey;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.regionName;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.serviceName;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.httpMethodName;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.canonicalURI;
        }

        public static /* synthetic */ TreeMap access$700(Builder r100) {
            return r100.queryParameters;
        }

        public static /* synthetic */ TreeMap access$800(Builder r100) {
            return r100.awsHeaders;
        }

        public static /* synthetic */ String access$900(Builder r100) {
            return r100.payload;
        }

        public Builder awsHeaders(TreeMap<String, String> r100) {
            this.awsHeaders = r100;
            return this;
        }

        public Builder canonicalURI(String r100) {
            this.canonicalURI = r100;
            return this;
        }

        public Builder httpMethodName(String r100) {
            this.httpMethodName = r100;
            return this;
        }

        public Builder payload(String r100) {
            this.payload = r100;
            return this;
        }

        public Builder queryParameters(TreeMap<String, ArrayList<String>> r100) {
            this.queryParameters = r100;
            return this;
        }

        public Builder regionName(String r100) {
            this.regionName = r100;
            return this;
        }

        public Builder serviceName(String r100) {
            this.serviceName = r100;
            return this;
        }

        public Builder(String r100, String r101) {
            this.debug = false;
            this.accessKeyID = r100;
            this.secretAccessKey = r101;
        }
    }

    static {
        mMacInstance = Mac.getInstance("HmacSHA256");     // Catch: NoSuchAlgorithmException -> L6
        mMessageDigest = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L6
    L4:
        hexArray = "0123456789ABCDEF".toCharArray();
    }

    private String findTimestampFromHeaderCaseInsensitive() {
        TreeMap<String, String> r100 = this.awsHeaders;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r101 = this.awsHeaders.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, String> r102 = r101.next();
        if (r102.getKey().toLowerCase().equals(AWSV4AuthParams.AWSAmzDateKey) == false) goto L8;
        return r102.getValue();
    L19:
        return null;
    L18:
        return null;
    }

    private String getTimeStamp() {
        SimpleDateFormat r100 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        r100.setTimeZone(TimeZone.getTimeZone("UTC"));
        return r100.format(new Date());
    }

    private String prepareCanonicalRequest() {
        String r100 = "";
        StringBuilder r101 = new StringBuilder("");
        r101.append(this.httpMethodName);
        r101.append("\n");
        String r102 = this.canonicalURI;
        if (r102 != null) goto L5;
    L8:
        String r103 = HTTP.URL_DEFAULT;
    L9:
        this.canonicalURI = r103;
        r101.append(r103);
        r101.append("\n");
        StringBuilder r104 = new StringBuilder("");
        TreeMap<String, ArrayList<String>> r105 = this.queryParameters;
        if (r105 != null) goto L12;
    L21:
        r104.append("\n");
    L22:
        r101.append(r104);
        StringBuilder r106 = new StringBuilder("");
        TreeMap<String, String> r107 = this.awsHeaders;
        if (r107 != null) goto L25;
    L35:
        r101.append("\n");
    L36:
        String r108 = r106.substring(0, r106.length() - 1);
        this.strSignedHeader = r108;
        r101.append(r108);
        r101.append("\n");
        String r109 = this.payload;
        if (r109 == null) goto L40;
        r100 = r109;
    L40:
        this.payload = r100;
        r101.append(generateHex(r100));
        if (this.debug == false) goto L44;
        System.out.println("##Canonical Request:\n" + r101.toString());
    L44:
        return r101.toString();
    L25:
        if (r107.isEmpty() == true) goto L35;
        TreeMap r110 = new TreeMap();
        Iterator<Map.Entry<String, String>> r111 = this.awsHeaders.entrySet().iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        Map.Entry<String, String> r112 = r111.next();
        r110.put(r112.getKey().toLowerCase(), r112.getValue().trim());
        goto L28
    L30:
        Iterator r113 = r110.entrySet().iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        Map.Entry r114 = (Map.Entry) r113.next();
        String r115 = ((String) r114.getKey()).toLowerCase();
        String r116 = ((String) r114.getValue()).trim();
        r106.append(r115);
        r106.append(i.f25853b);
        r101.append(r115);
        r101.append(":");
        r101.append(r116);
        r101.append("\n");
        goto L32
    L34:
        r101.append("\n");
        goto L36
    L12:
        if (r105.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, ArrayList<String>>> r117 = this.queryParameters.entrySet().iterator();
    L15:
        if (r117.hasNext() == false) goto L20;
        Map.Entry<String, ArrayList<String>> r118 = r117.next();
        String r119 = r118.getKey();
        ArrayList<String> r120 = r118.getValue();
        int r121 = 0;
    L18:
        if (r121 >= r120.size()) goto L15;
        r104.append(r119);
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r104.append(encodeParameter((String) ListProtector.get(r120, r121)));
        r104.append("&");
        String r122 = (String) ListProtector.get(r120, r121);
        r121 = r121 + 1;
        goto L18
    L20:
        r104.deleteCharAt(r104.lastIndexOf("&"));
        r104.append("\n");
        goto L22
    L5:
        if (r102.trim().isEmpty() == true) goto L8;
        r103 = this.canonicalURI;
        goto L9
    }

    private AWSV4Auth() {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
    }

    public Map<String, String> getHeaders() {
        String r100 = calculateSignature(prepareStringToSign(prepareCanonicalRequest()));
        if (r100 == null) goto L17;
        HashMap r101 = new HashMap(0);
        Iterator<Map.Entry<String, String>> r102 = this.awsHeaders.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L6
    L8:
        r101.put("Authorization", buildAuthorizationString(r100));
        if (this.debug == false) goto L15;
        System.out.println("##Signature:\n".concat(r100));
        System.out.println("##Header:");
        Iterator r104 = r101.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();
        System.out.println(((String) r105.getKey()) + " = " + ((String) r105.getValue()));
        goto L12
    L14:
        System.out.println("================================");
    L15:
        return r101;
    L17:
        if (this.debug == false) goto L23;
        System.out.println("##Signature:\n" + r100);
        return null;
    L23:
        return null;
    }

    private AWSV4Auth(Builder r100) {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
        this.accessKeyID = Builder.access$100(r100);
        this.secretAccessKey = Builder.access$200(r100);
        this.regionName = Builder.access$300(r100);
        this.serviceName = Builder.access$400(r100);
        this.httpMethodName = Builder.access$500(r100);
        this.canonicalURI = Builder.access$600(r100);
        this.queryParameters = Builder.access$700(r100);
        this.awsHeaders = Builder.access$800(r100);
        this.payload = Builder.access$900(r100);
        this.debug = Builder.access$1000(r100);
        if (this.awsHeaders != null) goto L5;
        this.awsHeaders = new TreeMap();
    L5:
        String r101 = findTimestampFromHeaderCaseInsensitive();
        this.xAmzDate = r101;
        if (r101 != null) goto L8;
        String r102 = getTimeStamp();
        this.xAmzDate = r102;
        this.awsHeaders.put(AWSV4AuthParams.AWSAmzDateKey, r102);
    L9:
        this.currentDate = getDateFromTimeStamp(this.xAmzDate);
        return;
    L8:
        this.awsHeadersHasTimestamp = true;
        goto L9
    }

    private String buildAuthorizationString(String r100) {
        return "AWS4-HMAC-SHA256 Credential=" + this.accessKeyID + HTTP.URL_DEFAULT + this.currentDate + HTTP.URL_DEFAULT + this.regionName + HTTP.URL_DEFAULT + this.serviceName + "/aws4_request,SignedHeaders=" + this.strSignedHeader + ",Signature=" + r100;
    }

    private String bytesToHex(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = hexArray;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101).toLowerCase();
    }

    private String calculateSignature(String r100) {
        return bytesToHex(SHA256UseMac(getSignatureKey(this.secretAccessKey, this.currentDate, this.regionName, this.serviceName), r100));
    L4:
        return null;
    }

    private String encodeParameter(String r100) {
        return URLEncoder.encode(r100, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20").replace("*", "%2A").replace("%7E", Constants.WAVE_SEPARATOR);
    L7:
        return r100;
    }

    private static synchronized String generateHex(String r100) {
        monitor-enter(AWSV4Auth.class);
        mMessageDigest.update(r100.getBytes("UTF-8"));     // Catch: Throwable -> L7 UnsupportedEncodingException -> L10
        String r101 = String.format("%064x", new Object[]{new BigInteger(1, mMessageDigest.digest())});     // Catch: Throwable -> L7 UnsupportedEncodingException -> L10
        monitor-exit(AWSV4Auth.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    L11:
        return null;
    }

    private String getDateFromTimeStamp(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() >= 8) goto L7;
        return null;
    L7:
        return r100.substring(0, 8);
    }

    private String prepareStringToSign(String r100) {
        String r101 = (("AWS4-HMAC-SHA256\n" + this.xAmzDate + "\n") + this.currentDate + HTTP.URL_DEFAULT + this.regionName + HTTP.URL_DEFAULT + this.serviceName + "/aws4_request\n") + generateHex(r100);
        if (this.debug == false) goto L5;
        System.out.println("##String to sign:\n" + r101);
    L5:
        return r101;
    }

    public /* synthetic */ AWSV4Auth(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    private static synchronized byte[] SHA256UseMac(byte[] r100, String r101) throws Exception {
        monitor-enter(AWSV4Auth.class);
        SecretKeySpec r102 = new SecretKeySpec(r100, MAC_ALGORITHM);     // Catch: Throwable -> L7
        mMacInstance.init(r102);     // Catch: Throwable -> L7
        byte[] r103 = r101.getBytes("UTF8");     // Catch: Throwable -> L7
        byte[] r104 = mMacInstance.doFinal(r103);     // Catch: Throwable -> L7
        monitor-exit(AWSV4Auth.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized byte[] getSignatureKey(String r100, String r101, String r102, String r103) throws Exception {
        monitor-enter(AWSV4Auth.class);
        byte[] r104 = SHA256UseMac(SHA256UseMac(SHA256UseMac(SHA256UseMac(("AWS4" + r100).getBytes("UTF8"), r101), r102), r103), AWSV4AuthParams.aws4Request);     // Catch: Throwable -> L7
        monitor-exit(AWSV4Auth.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }
}
