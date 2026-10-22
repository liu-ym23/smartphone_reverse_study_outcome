package com.bytedance.interaction.game.ext.goldenFinger.predefine.builtin;

import android.app.Application;
import com.bytedance.forest.Forest;
import com.bytedance.interaction.game.base.monitor.InteractiveMonitorReport;
import com.bytedance.interaction.game.ext.goldenFinger.predefine.security.GoldenFingerFileValidate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class BuiltInMetaManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoldenFingerFileValidate f250886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Forest f250887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f250888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f250889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f250890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f250891f;

    public final String a() {
        if (this.f250891f == false) goto L5;
        String r100 = "META_MODEL_BUILTIN_DEBUG_KEY";
    L6:
        int r101 = f96.a.f475971a;
        f96.a.d("interactive_predefine", "BuiltInMetaManager getMetaKey", MapsKt.mapOf(new Pair[]{TuplesKt.to("metaKey", r100), TuplesKt.to("isDebug", Boolean.valueOf(this.f250891f)), TuplesKt.to("bid", this.f250890e)}));
        return r100;
    L5:
        r100 = "META_MODEL_BUILTIN_ONLINE_KEY";
        goto L6
    }

    public final InteractiveMonitorReport b() {
        h96.b r100 = (h96.b) this.f250888c.getValue();
        if (r100 == null) goto L6;
        InteractiveMonitorReport r101 = r100.f484324a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        InteractiveMonitorReport r102 = InteractiveMonitorReport.f250880c;
        return InteractiveMonitorReport.f250880c;
    }

    public BuiltInMetaManager(Application r100, String r101, boolean r102) {
        this.f250889d = r100;
        this.f250890e = r101;
        this.f250891f = r102;
        this.f250886a = GoldenFingerFileValidate.f250923a;
        com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a r103 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250901b;
        Application r104 = this.f250889d;
        boolean r105 = this.f250891f;
        r103.getClass();
        Forest r106 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250900a;
        if (r106 != null) goto L8;
        com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.a(r104, r105);
        r106 = com.bytedance.interaction.game.ext.goldenFinger.predefine.forest.a.f250900a;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forest");
    L8:
        this.f250887b = r106;
        this.f250888c = LazyKt.lazy(new BuiltInMetaManager$businessService$2(this));
    }
}
