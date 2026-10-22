package okhttp3.ttnet;

import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class TTNetDnsResult {
    private final String mDnsInfoJson;
    private final List<InetAddress> mInetAddressList;

    public String getDnsInfoJson() {
        return this.mDnsInfoJson;
    }

    public List<InetAddress> getInetAddressList() {
        return this.mInetAddressList;
    }

    public TTNetDnsResult(List<InetAddress> r100, String r101) {
        this.mInetAddressList = r100;
        this.mDnsInfoJson = r101;
    }
}
