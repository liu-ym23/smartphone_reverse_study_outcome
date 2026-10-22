package com.ss.bduploader;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes40.dex */
public class BDAuthHelper {
    public static final int keyAccessKey = 0;
    public static final int keyAuthorization = 10;
    public static final int keyCanonicalURI = 5;
    public static final int keyHost = 7;
    public static final int keyHttpMethod = 4;
    public static final int keyPlayLoad = 6;
    public static final int keyQueryStr = 11;
    public static final int keyRegionName = 2;
    public static final int keySecretKey = 1;
    public static final int keyServiceName = 3;
    public static final int keyXAmzDate = 8;
    public static final int keyXAmzSecurityToken = 9;
    private String accessKeyID;
    private String authorization;
    private TreeMap<String, String> awsHeaders;
    private String canonicalURI;
    private boolean debug;
    private String host;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String queryStr;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String xAmzDate;
    private String xAmzSecurityToken;

    public Map<String, String> getSignature() {
        TreeMap<String, String> r100 = new TreeMap();
        r100.put(AWSV4AuthParams.AWSAmzDateKey, this.xAmzDate);
        r100.put(AWSV4AuthParams.AMZ_SECURITY_TOKEN_KEY, this.xAmzSecurityToken);
        parseAPIString(this.queryStr);
        Map<String, String> r101 = new AWSV4Auth.Builder(this.accessKeyID, this.secretAccessKey).regionName(this.regionName).serviceName(this.serviceName).httpMethodName(this.httpMethodName).canonicalURI(AWSV4AuthParams.CANONICAL_URI).queryParameters(this.queryParameters).awsHeaders(r100).payload(this.payload).build().getHeaders();
        this.authorization = r101.get("Authorization");
        return r101;
    }

    public BDAuthHelper() {
        this.debug = false;
    }

    private String parseAPIString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L26;
        return "parseAPIString:query string is empty";
    L26:
        String[] r101 = r100.split("[?]");     // Catch: Exception -> L22
        if (r101.length >= 2) goto L10;
        return "parseAPIString:query string param is empty";
    L10:
        String[] r102 = r101[1].split("&");     // Catch: Exception -> L22
        TreeMap<String, ArrayList<String>> r103 = new TreeMap();     // Catch: Exception -> L22
        int r104 = 0;
    L12:
        if (r104 >= r102.length) goto L20;
        String[] r105 = r102[r104].split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L22
        if (r105.length < 2) goto L19;
        if (r103.containsKey(r105[0]) == true) goto L18;
        ArrayList<String> r106 = new ArrayList();     // Catch: Exception -> L22
        r106.add(r105[1]);     // Catch: Exception -> L22
        r103.put(r105[0], r106);     // Catch: Exception -> L22
        goto L19
    L18:
        r103.get(r105[0]).add(r105[1]);     // Catch: Exception -> L22
    L19:
        r104 = r104 + 1;     // Catch: Exception -> L22
        goto L12
    L20:
        this.queryParameters = r103;     // Catch: Exception -> L22
        return null;
    L22:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getStringValue(int r100) {
        getSignature();
        if (r100 == 10) goto L7;
        return null;
    L7:
        return this.authorization;
    }

    public void setAwsHeaders(TreeMap<String, String> r100) {
        this.awsHeaders = r100;
    }

    public void setQueryParameters(TreeMap<String, ArrayList<String>> r100) {
        this.queryParameters = r100;
    }

    public void setStringValue(int r100, String r101) {
        switch(r100) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L26;
            case 11: goto L4;
            default: goto L26;
        };
    L4:
        this.queryStr = r101;
        return;
    L5:
        this.xAmzSecurityToken = r101;
        return;
    L6:
        this.xAmzDate = r101;
        return;
    L7:
        this.host = r101;
        return;
    L8:
        this.payload = r101;
        return;
    L9:
        this.canonicalURI = r101;
        return;
    L10:
        this.httpMethodName = r101;
        return;
    L11:
        this.serviceName = r101;
        return;
    L12:
        this.regionName = r101;
        return;
    L13:
        this.secretAccessKey = r101;
        return;
    L14:
        this.accessKeyID = r101;
        return;
    }
}
