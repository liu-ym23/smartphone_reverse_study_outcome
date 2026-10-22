package com.ss.android.lark.language.loader;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.compress.utils.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseLanguageLoader {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f431074f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KVRepo f431075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f431076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f431077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f431078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f431079e;

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Integer> a();

    public LinkedHashMap<Locale, Integer> b() {
        LinkedHashMap<Locale, Integer> r100 = new LinkedHashMap();
        int r101 = ApkUtil.getAppVersionCode(com.larksuite.framework.utils.b.f285948a.getApplicationContext());
        int r102 = this.f431075a.getInt("sp_version_code_for_build_language", -1);
        if (r101 <= r102) goto L5;
        Log.i("LaunchLocaleWatch", "version update, curVersionCode: " + r101 + ", lastVersionCode: " + r102);
        this.f431075a.putInt("sp_version_code_for_build_language", r101);
        List r103 = new ArrayList();
    L13:
        if ((!r103.isEmpty()) == false) goto L15;
        Log.i("LaunchLocaleWatch", "get language config hit cache, config: " + r103);
    L31:
        Iterator r104 = r103.iterator();
    L33:
        if (r104.hasNext() == false) goto L37;
        String r105 = (String) r104.next();
        String r106 = (String) ListProtector.get(StringsKt.split$default(r105, new String[]{"-"}, false, 0, 6, null), 0);
        String r107 = (String) ListProtector.get(StringsKt.split$default(r105, new String[]{"-"}, false, 0, 6, null), 1);
        Integer r108 = (Integer) ((Map) this.f431076b.getValue()).get(r105);
        if (r108 == null) goto L33;
        r100.put(new Locale(r106, r107), Integer.valueOf(r108.intValue()));
        goto L33
    L37:
        return r100;
    L15:
        long r109 = System.currentTimeMillis();
        InputStream r110 = com.larksuite.framework.utils.b.f285948a.getAssets().open("lark_settings");     // Catch: Throwable -> L23 Exception -> L25
        String r111 = new JSONObject(new String(IOUtils.toByteArray(r110), StandardCharsets.UTF_8)).getJSONObject("client_build_language_config").getString("client_build_language_list");     // Catch: Exception -> L21 Throwable -> L38
        this.f431075a.putString("sp_client_build_language_list", r111);     // Catch: Exception -> L21 Throwable -> L38
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L21 Throwable -> L38
        List r112 = StringsKt.split$default(r111, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L21 Throwable -> L38
        Log.i("LaunchLocaleWatch", "parse language config success, config: " + r112);     // Catch: Exception -> L21 Throwable -> L38
        if (r110 == null) goto L20;
        r110.close();
    L20:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r109) + " ms.");
        r103 = r112;
    L21:
        e = e;
    L27:
        Log.e("LaunchLocaleWatch", "parse language config failed, error: " + e.getMessage());     // Catch: Throwable -> L38
        this.f431075a.putInt("sp_version_code_for_build_language", 0);     // Catch: Throwable -> L38
        if (r110 == null) goto L30;
        r110.close();
    L30:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r109) + " ms.");
        r103 = new ArrayList();
    L38:
        th = th;
    L39:
        if (r110 == null) goto L41;
        r110.close();
    L41:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r109) + " ms.");
        throw th;
    L25:
        e = e;
        r110 = null;
    L23:
        th = th;
        r110 = null;
        goto L39
    L5:
        String r113 = this.f431075a.getString("sp_client_build_language_list", "");
        if (r113 != null) goto L9;
        r103 = new ArrayList();
        goto L13
    L9:
        if (TextUtils.isEmpty(r113) == true) goto L11;
        r103 = StringsKt.split$default(r113, new String[]{","}, false, 0, 6, null);
        goto L13
    L11:
        r103 = new ArrayList();
        goto L13
    }

    public BaseLanguageLoader(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "globalCoreKVRepo");
        this.f431075a = r100;
        this.f431076b = LazyKt.lazy(new BaseLanguageLoader$localeMap$2(this));
        this.f431077c = LazyKt.lazy(new BaseLanguageLoader$locale2NameMap$2(this));
        this.f431078d = LazyKt.lazy(new BaseLanguageLoader$localeList$2(this));
        this.f431079e = LazyKt.lazy(new BaseLanguageLoader$resourceMap$2(this));
    }
}
