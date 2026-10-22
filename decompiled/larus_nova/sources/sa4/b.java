package sa4;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.texturerender.VideoSurfaceTexture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ta4.b f541164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f541165b;

    public b(File r100) {
        this.f541165b = r100;
    }

    public static ta4.b a(File r100) throws IOException, JSONException {
        int r101 = va4.a.f553939a;
        ArrayList r102 = null;
        if (r100.exists() == true) goto L6;
    L9:
        PolarisFileInputStreamWrapper r103 = null;
    L10:
        if (r103 == null) goto L34;
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r103));
        String r105 = TextStreamsKt.readText(r104);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r104, null);
        JSONObject r106 = new JSONObject(r105);
        ta4.b r107 = new ta4.b();
        JSONObject r108 = r106.optJSONObject("current");
        if (r108 == null) goto L16;
        int r109 = ta4.a.f545166c;
        ta4.a r110 = new ta4.a(JSONObjectProtectorUtils.getString(r108, "md5"), JSONObjectProtectorUtils.getLong(r108, VideoSurfaceTexture.KEY_TIME));
    L17:
        r107.f545170a = r110;
        JSONArray r111 = r106.optJSONArray("history");
        if (r111 == null) goto L26;
        int r112 = r111.length();
        ArrayList r113 = new ArrayList();
        int r114 = 0;
    L20:
        if (r114 >= r112) goto L22;
        r113.add(JSONArrayProtectorUtils.getJSONObject(r111, r114));
        r114 = r114 + 1;
        goto L20
    L22:
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L24:
        if (r115.hasNext() == false) goto L26;
        JSONObject r116 = (JSONObject) r115.next();
        int r117 = ta4.a.f545166c;
        r102.add(new ta4.a(JSONObjectProtectorUtils.getString(r116, "md5"), JSONObjectProtectorUtils.getLong(r116, VideoSurfaceTexture.KEY_TIME)));
    L26:
        if (r102 == null) goto L28;
        r107.f545171b.addAll(r102);
    L28:
        return r107;
    L16:
        r110 = null;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L34:
        return null;
    L6:
        if (r100.isFile() == false) goto L8;
        r103 = new PolarisFileInputStreamWrapper(r100);
        goto L10
    L8:
        FilesKt.deleteRecursively(r100);
        goto L9
    }

    public final void b(ta4.b r100) throws IOException, JSONException {
        int r101 = ta4.b.f545169c;
        JSONObject r102 = new JSONObject();
        ta4.a r103 = r100.f545170a;
        if (r103 == null) goto L5;
        JSONObject r104 = new JSONObject();
        r104.put("md5", r103.f545167a);
        r104.put(VideoSurfaceTexture.KEY_TIME, r103.f545168b);
        r102.put("current", r104);
    L5:
        List<ta4.a> r105 = r100.f545171b;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        ta4.a r108 = (ta4.a) r107.next();
        r108.getClass();
        JSONObject r109 = new JSONObject();
        r109.put("md5", r108.f545167a);
        r109.put(VideoSurfaceTexture.KEY_TIME, r108.f545168b);
        r106.add(r109);
        goto L7
    L9:
        JSONArray r110 = new JSONArray();
        int r111 = r106.size();
        int r112 = 0;
    L10:
        if (r112 >= r111) goto L12;
        r110.put(r112, ListProtector.get(r106, r112));
        r112 = r112 + 1;
        goto L10
    L12:
        r102.put("history", r110);
        int r113 = va4.a.f553939a;
        BufferedWriter r114 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f541165b)));
        r114.write(r102.toString());     // Catch: Throwable -> L16
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r114, null);
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);
        throw th;
    }
}
