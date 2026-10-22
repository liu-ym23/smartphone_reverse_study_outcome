package com.ss.cast.discovery.mdns;

import android.net.nsd.NsdServiceInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.byted.cast.common.StringUtil;
import com.byted.cast.common.config.Config;
import com.ss.ttvideoengine.net.DNSParser;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class NsdService implements Parcelable {
    public static final Parcelable.Creator<NsdService> CREATOR = null;
    private final String domain;
    private int errorCode;
    private final InetAddress host;
    private final String hostIp;
    private String hostName;
    private Map<String, byte[]> mTxtRecord;
    private final String name;
    private final int port;
    private final String type;

    public class a implements Parcelable.Creator<NsdService> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NsdService createFromParcel(Parcel r100) {
            return new NsdService(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final NsdService[] newArray(int r100) {
            return new NsdService[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    private String txtRecordToString() {
        Map<String, byte[]> r100 = this.mTxtRecord;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.isEmpty() == true) goto L43;
        StringBuffer r101 = new StringBuffer("{");
        Iterator<Map.Entry<String, byte[]>> r102 = this.mTxtRecord.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L28;
        Map.Entry<String, byte[]> r103 = r102.next();
        byte[] r104 = r103.getValue();     // Catch: Throwable -> L26
        if (r104 == null) goto L9;
        if (r104.length <= 0) goto L9;
        String r105 = r103.getKey();     // Catch: Throwable -> L26
        String r106 = new String(r104);     // Catch: Throwable -> L26
        if (TextUtils.equals(DNSParser.DNS_RESULT_IP, r105) == true) goto L18;
    L24:
        r101.append(r105);     // Catch: Throwable -> L26
        r101.append(":");     // Catch: Throwable -> L26
        r101.append(r106);     // Catch: Throwable -> L26
        r101.append(i.f25853b);     // Catch: Throwable -> L26
        goto L9
    L18:
        if (TextUtils.equals("overseasPlug", "internal") == false) goto L20;
    L23:
        r106 = "xxx.xxx.xxx.xxx";
        goto L24
    L20:
        if (TextUtils.equals("overseas", "internal") == true) goto L23;
        r106 = StringUtil.base64(r106);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L28:
        r101.append(i.f25855d);
        return r101.toString();
    L43:
        return "";
    }

    public String getHostName() {
        if (this.hostName != null) goto L10;
        InetAddress r100 = this.host;
        if (r100 != null) goto L7;
        String r101 = "";
    L8:
        this.hostName = r101;
        goto L10
    L7:
        r101 = r100.getHostName();
    L10:
        return this.hostName;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.hostIp;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.hostName;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((r109 + r101) * 31) + this.port;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "name='" + this.name + "', type='" + this.type + "', domain='" + this.domain + "', hostIp='" + this.hostIp + "', hostName='" + this.hostName + "', port='" + this.port + "', errorCode='" + this.errorCode + "', mTxtRecord:" + txtRecordToString();
    }

    public Map<String, byte[]> getAttributes() {
        return this.mTxtRecord;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public InetAddress getHost() {
        return this.host;
    }

    public String getHostIp() {
        return this.hostIp;
    }

    public String getName() {
        return this.name;
    }

    public int getPort() {
        return this.port;
    }

    public String getType() {
        return this.type;
    }

    public NsdService(Parcel r100) {
        this.errorCode = 0;
        this.name = r100.readString();
        this.type = r100.readString();
        this.domain = r100.readString();
        this.hostIp = r100.readString();
        this.hostName = r100.readString();
        this.port = r100.readInt();
        this.host = (InetAddress) r100.readSerializable();
    }

    private Map<String, byte[]> convertTxtRecord(Map<String, String> r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue().getBytes());
        goto L7
    L9:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L44:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L44;
        NsdService r101 = (NsdService) r100;
        if (this.port == r101.port) goto L13;
        return false;
    L13:
        String r102 = this.name;
        if (r102 == null) goto L19;
        if (r102.equals(r101.name) == false) goto L20;
    L21:
        String r103 = this.type;
        if (r103 == null) goto L27;
        if (r103.equals(r101.type) == false) goto L28;
    L29:
        String r104 = this.hostIp;
        if (r104 == null) goto L35;
        if (r104.equals(r101.hostIp) == false) goto L36;
    L37:
        String r105 = this.hostName;
        String r106 = r101.hostName;
        if (r105 != null) goto L45;
        if (r106 == null) goto L46;
        return false;
    L46:
        return true;
    L45:
        return r105.equals(r106);
    L36:
        return false;
    L35:
        if (r101.hostIp == null) goto L37;
    L28:
        return false;
    L27:
        if (r101.type == null) goto L29;
    L20:
        return false;
    L19:
        if (r101.name == null) goto L21;
        goto L20
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public NsdService(NsdServiceInfo r100, Config r101) {
        this.errorCode = 0;
        this.name = r100.getServiceName();
        this.type = r100.getServiceType();
        this.domain = null;
        if (r100.getHost() != null) goto L5;
        this.hostIp = null;
    L9:
        this.port = r100.getPort();
        this.host = r100.getHost();
        this.mTxtRecord = r100.getAttributes();
        return;
    L5:
        if (r101.getHostAddressAdapter() == null) goto L7;
        this.hostIp = r101.getHostAddressAdapter().getHostAddress(r100.getHost());
        goto L9
    L7:
        this.hostIp = r100.getHost().getHostAddress();
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.name);
        r100.writeString(this.type);
        r100.writeString(this.hostIp);
        r100.writeString(this.hostName);
        r100.writeInt(this.port);
        r100.writeSerializable(this.host);
    }

    public NsdService(String r100, String r101, String r102) {
        this(r100, r101, r102, -1, null);
    }

    public NsdService(String r100, String r101, String r102, int r103, Map<String, String> r104) {
        this.errorCode = 0;
        this.name = r100;
        this.type = r101;
        this.domain = r102;
        this.port = r103;
        this.mTxtRecord = convertTxtRecord(r104);
        this.hostIp = null;
        this.hostName = null;
        this.host = null;
    }

    public NsdService(String r100, String r101, String r102, String r103, int r104, InetAddress r105) {
        this.errorCode = 0;
        this.name = r100;
        this.type = r101;
        this.domain = null;
        this.hostIp = r102;
        this.hostName = r103;
        this.port = r104;
        this.host = r105;
    }

    public NsdService(String r100, String r101, String r102, String r103, int r104, InetAddress r105, Map<String, String> r106) {
        this.errorCode = 0;
        this.name = r100;
        this.type = r101;
        this.domain = r102;
        this.hostIp = r103;
        this.port = r104;
        this.host = r105;
        this.mTxtRecord = convertTxtRecord(r106);
    }

    public NsdService(String r100, String r101, String r102, String r103, String r104, int r105, InetAddress r106, Map<String, byte[]> r107) {
        this.errorCode = 0;
        this.name = r100;
        this.type = r101.replace(".local.", "");
        this.domain = r102;
        this.hostIp = r103;
        this.hostName = r104;
        this.port = r105;
        this.host = r106;
        this.mTxtRecord = r107;
    }
}
