package com.bytedance.interaction.game.ext.goldenFinger.predefine.meta;

import android.app.Application;
import com.bytedance.forest.Forest;
import com.bytedance.interaction.game.ext.goldenFinger.predefine.security.GoldenFingerFileValidate;
import j96.d;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class MetaManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap<String, d> f250902i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j96.a> f250903j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f250904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f250905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GoldenFingerFileValidate f250906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f250907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Forest f250908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Application f250909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f250910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f250911h;

    public static final class a {
    }

    static {
        f250902i = new HashMap();
        f250903j = new ConcurrentHashMap();
    }

    public final String a() {
        if (this.f250911h == false) goto L5;
        String r100 = "META_MODEL_DEBUG_KEY";
    L6:
        int r101 = f96.a.f475971a;
        f96.a.d("interactive_predefine", "getMetaKey", MapsKt.mapOf(new Pair[]{TuplesKt.to("metaKey", r100), TuplesKt.to("isDebug", Boolean.valueOf(this.f250911h)), TuplesKt.to("bidService", String.valueOf((h96.b) this.f250907d.getValue())), TuplesKt.to("bid", this.f250910g)}));
        return r100;
    L5:
        r100 = "META_MODEL_ONLINE_KEY";
        goto L6
    }

    public MetaManager(Application r100, String r101, boolean r102) {
        this.f250909f = r100;
        this.f250910g = r101;
        this.f250911h = r102;
        this.f250905b = new HashMap();
        this.f250906c = GoldenFingerFileValidate.f250923a;
        this.f250907d = LazyKt.lazy(new MetaManager$businessService$2(this));
        com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a r103 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250901b;
        Application r104 = this.f250909f;
        boolean r105 = this.f250911h;
        r103.getClass();
        Forest r106 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250900a;
        if (r106 != null) goto L8;
        com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.a(r104, r105);
        r106 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250900a;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forest");
    L8:
        this.f250908e = r106;
    }
}
