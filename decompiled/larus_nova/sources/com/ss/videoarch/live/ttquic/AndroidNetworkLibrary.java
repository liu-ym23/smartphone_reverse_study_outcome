package com.ss.videoarch.live.ttquic;

import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static final Set<String> sAutoDohDotServers = null;
    private static final Set<InetAddress> sAutoDohServers = null;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    public AndroidNetworkLibrary() {
    }

    public static boolean haveOnlyLoopbackAddresses() {
        return false;
    }

    static {
        HashSet r100 = new HashSet();
        sAutoDohServers = r100;
        HashSet r101 = new HashSet();
        sAutoDohDotServers = r101;
        r100.add(InetAddress.getByName("8.8.8.8"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("8.8.4.4"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2001:4860:4860::8888"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2001:4860:4860::8844"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("1.1.1.1"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("1.0.0.1"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2606:4700:4700::1111"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2606:4700:4700::1001"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("9.9.9.9"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("149.112.112.112"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2620:fe::fe"));     // Catch: UnknownHostException -> L6
        r100.add(InetAddress.getByName("2620:fe::9"));     // Catch: UnknownHostException -> L6
        r101.add("dns.google");
        r101.add("1dot1dot1dot1.cloudflare-dns.com");
        r101.add("cloudflare-dns.com");
        r101.add("dns.quad9.net");
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Failed to parse IP addresses", e);
    }

    public static String getMimeTypeFromExtension(String r100) {
        return URLConnection.guessContentTypeFromName("foo." + r100);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r100, String r101, String r102) {
        return X509Util.verifyServerCertificates(r100, r101, r102);
    L5:
        return new AndroidCertVerifyResult(CertVerifyStatusAndroid.FAILED);
    L9:
        return new AndroidCertVerifyResult(CertVerifyStatusAndroid.FAILED);
    L7:
        return new AndroidCertVerifyResult(CertVerifyStatusAndroid.FAILED);
    }
}
