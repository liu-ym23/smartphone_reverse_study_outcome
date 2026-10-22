package ox5;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    List<String> getAbSdkVersion();

    int getAid();

    String getHttpDnsDomain();

    String[] getHttpDnsDomainHardCodeIps();

    String[] getHttpDnsPreloadDomains();

    void sendAppMonitorEvent(String r100, String r101);
}
