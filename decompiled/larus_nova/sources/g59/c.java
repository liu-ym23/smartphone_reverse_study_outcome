package g59;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f480101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f480102b;

    public static final class a {
    }

    static {
    }

    public final d59.f a() {
        String r100 = ((Keva) this.f480101a.getValue()).getString("dora_lab_feature_config", null);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L20;
        FLogger.f375446a.i("DoraFeatureConfigRepository", "get success: " + r100);
        return (d59.f) ((Gson) this.f480102b.getValue()).fromJson(r100, d59.f.class);
    L14:
        e = move-exception;
        FLogger.f375446a.e("DoraFeatureConfigRepository", "get error", e);
        return null;
    L20:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public c() {
        this.f480101a = LazyKt.lazy(new g59.a());
        this.f480102b = LazyKt.lazy(new b());
    }

    public final void b(d59.f r100) {
        if (r100 != null) goto L10;
        return;
    L10:
        String r101 = ((Gson) this.f480102b.getValue()).toJson(r100);     // Catch: Exception -> L7
        ((Keva) this.f480101a.getValue()).storeString("dora_lab_feature_config", r101);     // Catch: Exception -> L7
        FLogger.f375446a.i("DoraFeatureConfigRepository", "save success: " + r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("DoraFeatureConfigRepository", "save error", e);
    }
}
