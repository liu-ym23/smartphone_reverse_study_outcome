package com.bytedance.common.utility;

import android.util.Pair;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkClient {
    private static final int BYTE_ARRAY_OUTPUT_STREAM_SIZE = 8192;
    private static NetworkClient sDefault;

    /* JADX INFO: loaded from: classes3.dex */
    public static class ReqContext {
        public boolean addCommonParams;

        public ReqContext() {
        }
    }

    public NetworkClient() {
    }

    public abstract String get(String r100, Map<String, String> r101, ReqContext r102) throws Exception;

    public abstract String post(String r100, List<Pair<String, String>> r101, Map<String, String> r102, ReqContext r103) throws CommonHttpException;

    public abstract String post(String r100, byte[] r101, Map<String, String> r102, ReqContext r103) throws CommonHttpException;

    public byte[] postDataStream(String r100, byte[] r101, Map<String, String> r102, ReqContext r103) throws CommonHttpException {
        return null;
    }

    static {
        sDefault = new DummyNetworkClient();
    }

    public static NetworkClient getDefault() {
        return sDefault;
    }

    public static byte[] compressWithgzip(byte[] r100) throws Exception {
        GZIPOutputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L9
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: Throwable -> L9
        r103.write(r100);     // Catch: Throwable -> L7
        r103.close();     // Catch: Throwable -> L7
        return r102.toByteArray();
    L7:
        th = th;
        r101 = r103;
    L10:
        if (r101 == null) goto L12;
        r101.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void setDefault(NetworkClient r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100 == sDefault) goto L8;
        sDefault = r100;
        return;
    }

    public String get(String r100) throws Exception {
        ReqContext r101 = new ReqContext();
        r101.addCommonParams = true;
        return get(r100, null, r101);
    }

    public String post(String r100, List<Pair<String, String>> r101) throws CommonHttpException {
        ReqContext r102 = new ReqContext();
        r102.addCommonParams = true;
        return post(r100, r101, null, r102);
    }

    public String post(String r100, byte[] r101, boolean r102, String r103, boolean r104) throws CommonHttpException {
        HashMap r105 = new HashMap();
        if (r102 == false) goto L10;
        r101 = compressWithgzip(r101);     // Catch: Exception -> L6
        r105.put("Content-Encoding", DownloadHelper.GZIP);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L10:
        if (StringUtils.isEmpty(r103) == true) goto L12;
        r105.put("Content-Type", r103);
    L12:
        ReqContext r106 = new ReqContext();
        r106.addCommonParams = r104;
        return post(r100, r101, r105, r106);
    }
}
