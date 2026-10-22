package ita;

import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495747a = 0;

    static {
        new String[]{"mac_address", "oaid", "openudid", ST.UUID_DEVICE, "imei"};
    }

    public static String a(int r100, String r110, List r111) throws Exception {
        eta.c r101 = new eta.c();
        if (StringUtils.isEmpty(r110) == false) goto L5;
        r101.setResult(null);
    L19:
        return r101.f473957a;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        Pair<String, String> r112 = UrlUtils.parseUrl(r110, r102);
        if (r112 != null) goto L8;
        r101.setResult(null);
        goto L19
    L8:
        String r103 = (String) r112.first;
        String r104 = (String) r112.second;
        INetworkApi r105 = (INetworkApi) RetrofitUtils.createSsService(r103, INetworkApi.class);
        LinkedList r106 = new LinkedList();
        if (r111 != null) goto L11;
    L16:
        if (r105 == null) goto L19;
        SsResponse<String> r107 = r105.doGet(true, r100, r104, r102, r106, null).execute();
        r101.setResult(r107.body());
        r107.code();
        goto L19
    L11:
        if (r111.isEmpty() == true) goto L16;
        Iterator r113 = r111.iterator();
    L14:
        if (r113.hasNext() == false) goto L16;
        cua.b r114 = (cua.b) r113.next();
        r106.add(new Header(r114.getName(), r114.getValue()));
        goto L14
    }

    public static String b(int r100, String r110, byte[] r111, NetworkUtils.CompressType r112, String r113) throws Exception {
        if (StringUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        if (r111 != null) goto L9;
        new Pair(r111, null);
    L9:
        if (r111 != null) goto L56;
        int r101 = 0;
    L13:
        if (NetworkUtils.CompressType.GZIP != r112) goto L26;
        if (r101 <= 128) goto L26;
        ByteArrayOutputStream r114 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L34
        GZIPOutputStream r102 = new GZIPOutputStream(r114);     // Catch: Throwable -> L34
        r102.write(r111);     // Catch: Throwable -> L19
        r102.close();     // Catch: Throwable -> L34
        r111 = r114.toByteArray();     // Catch: Throwable -> L34
        String r115 = DownloadHelper.GZIP;
    L37:
        Pair r116 = new Pair(r111, r115);
    L38:
        byte[] r117 = (byte[]) r116.first;
        String r118 = (String) r116.second;
        ArrayList r103 = new ArrayList();
        if (r118 == null) goto L41;
        r103.add(new Header("Content-Encoding", r118));
    L41:
        if (r113 != null) goto L43;
    L45:
        LinkedHashMap r104 = new LinkedHashMap();
        Pair<String, String> r119 = UrlUtils.parseUrl(r110, r104);
        if (r119 != null) goto L48;
        return null;
    L48:
        String r120 = (String) r119.first;
        String r105 = (String) r119.second;
        INetworkApi r106 = (INetworkApi) RetrofitUtils.createSsService(r120, INetworkApi.class);
        if (r106 != null) goto L51;
        return null;
    L51:
        return r106.postBody(r100, r105, r104, new TypedByteArray(null, r117, new String[0]), r103).execute().body();
    L43:
        if (r113.length() <= 0) goto L45;
        r103.add(new Header("Content-Type", r113));
        goto L45
    L19:
        th = move-exception;
        Logger.w("NetworkUtils", "compress with gzip exception: " + th);     // Catch: Throwable -> L22
        r116 = new Pair(r111, null);     // Catch: Throwable -> L22
        r102.close();     // Catch: Throwable -> L34
        goto L38
    L22:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
    L36:
        r115 = null;
    L26:
        if (NetworkUtils.CompressType.DEFLATER != r112) goto L36;
        if (r101 <= 128) goto L36;
        ByteArrayOutputStream r121 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L34
        Deflater r107 = new Deflater();     // Catch: Throwable -> L34
        r107.setInput(r111);     // Catch: Throwable -> L34
        r107.finish();     // Catch: Throwable -> L34
        byte[] r108 = new byte[8192];     // Catch: Throwable -> L34
    L30:
        if (r107.finished() == true) goto L32;
        r121.write(r108, 0, r107.deflate(r108));     // Catch: Throwable -> L34
        goto L30
    L32:
        r107.end();     // Catch: Throwable -> L34
        r111 = r121.toByteArray();     // Catch: Throwable -> L34
        r115 = "deflate";
        goto L37
    L56:
        r101 = r111.length;     // Catch: Throwable -> L34
        goto L13
    }
}
