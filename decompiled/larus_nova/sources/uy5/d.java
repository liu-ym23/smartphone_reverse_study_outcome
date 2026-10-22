package uy5;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f552137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552139c;

    public final Map<String, Long> c() {
        HashMap r100 = new HashMap();
        Map<String, a> r101 = this.f552137a;
        monitor-enter(r101);
        Collection r102 = ((HashMap) this.f552137a).values();     // Catch: Throwable -> L14
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r100;
    L8:
        Iterator r103 = r102.iterator();     // Catch: Throwable -> L14
    L10:
        if (r103.hasNext() == false) goto L12;
        a r104 = (a) r103.next();     // Catch: Throwable -> L14
        r100.put(r104.f552128c, r104.f552130e);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r100;
    L14:
        th = move-exception;
        throw th;
    }

    public final void e() throws Throwable {
        Map<String, a> r100 = this.f552137a;
        monitor-enter(r100);
        Iterator r101 = ((HashMap) this.f552137a).values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        ((a) r101.next()).c();     // Catch: Throwable -> L11
        goto L6
    L8:
        ((HashMap) this.f552137a).clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r100) throws Throwable {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        a r101 = b(r100.trim());
        b r102 = r101.b(false, r101.f552128c);
        String r103 = r100.substring(r101.f552128c.length() + 1);
        File r104 = r102.f552133a;
        StringBuilder r105 = new StringBuilder("res");
        String r106 = File.separator;
        r105.append(r106);
        r105.append(r103);
        if (new PolarisFileWrapper(r104, r105.toString()).exists() == false) goto L8;
        return true;
    L8:
        if (GkFSUtils.g(r103) == true) goto L16;
        String r107 = GkFSUtils.d(r102.f552134b, r102.f552135c, r103);
        if (r107 != null) goto L12;
        return false;
    L12:
        return new PolarisFileWrapper(r104, "res" + r106 + r107).exists();
    L16:
        return false;
    L14:
        throw new RuntimeException("relativePath is empty");
    }

    public final a b(String r100) {
        int r101 = r100.indexOf(HTTP.URL_DEFAULT);
        if (r101 == (-1)) goto L15;
        String r102 = r100.substring(0, r101);
        Map<String, a> r103 = this.f552137a;
        monitor-enter(r103);
        a r104 = (a) ((HashMap) this.f552137a).get(r102);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new a(this.f552138b, this.f552139c, r102);     // Catch: Throwable -> L11
        ((HashMap) this.f552137a).put(r102, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new RuntimeException("channel is needed：".concat(r100));
    }

    public final InputStream d(String r100) throws Throwable {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        a r101 = b(r100.trim());
        b r102 = r101.b(true, r101.f552128c);
        File r103 = r102.a(r102.f552133a, r100.substring(r101.f552128c.length() + 1));
        List<Function0<Unit>> r104 = GkFSUtils.f245072a;
        if (GkFSUtils.g(r103.getPath()) == false) goto L12;
        if (r103.exists() == false) goto L10;
        return new GkFSFileInputStream(r103, true);
    L10:
        throw new IOException(r103.getAbsolutePath() + " not exists!");
    L12:
        return new PolarisFileInputStreamWrapper(r103);
    L14:
        throw new RuntimeException("relativePath is empty");
    }

    public d(Context r100, String r101, File r102) {
        this.f552137a = new HashMap();
        if (TextUtils.isEmpty(r101) == true) goto L17;
        this.f552138b = r101;
        if (AppSettingsManager.b.f245071a.a() == false) goto L12;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r103 = GlobalManager.f250638g;
        if (r103 == null) goto L11;
        this.f552139c = new PolarisFileWrapper(r103.getRootDir(), r101).getAbsolutePath();
        return;
    L11:
        throw new RuntimeException("gecko not init");
    L12:
        if (r102 != null) goto L14;
        this.f552139c = new PolarisFileWrapper(r100.getFilesDir(), GeckoClient.GECKO_ROOT_DIR + File.separator + r101).getAbsolutePath();
        return;
    L14:
        this.f552139c = new PolarisFileWrapper(r102, r101).getAbsolutePath();
        return;
    L17:
        throw new RuntimeException("access key is empty");
    }
}
