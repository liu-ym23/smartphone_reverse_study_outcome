package com.larus.profile.impl;

import android.os.Bundle;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.larus.applog.api.IApplog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicBoolean f366062l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f366063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f366064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f366065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f366066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f366067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f366068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f366069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f366070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f366071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f366072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f366073k;

    public static final class a {
        public static a1 a(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "defaultVariant");
            if (r100 == null) goto L5;
            String r102 = r100.getString("profile_edit_perf_variant");
        L6:
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            if (StringsKt.isBlank(r102) == false) goto L11;
            String r103 = r101;
        L12:
            long r104 = 0;
            if (r100 == null) goto L15;
            r104 = r100.getLong("profile_edit_perf_open_start_ms", 0);
        L15:
            long r105 = r104;
            if (r100 == null) goto L18;
            boolean r106 = r100.getBoolean("profile_edit_perf_is_cold_start", false);
        L20:
            if (r100 == null) goto L22;
            boolean r107 = r100.getBoolean("profile_edit_perf_report_enabled", true);
        L24:
            return new a1(r103, r105, r106, r107);
        L22:
            r107 = true;
            goto L24
        L18:
            r106 = false;
            goto L20
        L11:
            r103 = r102;
            goto L12
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        f366062l = new AtomicBoolean(false);
    }

    public final void b(long r100) {
        long r101 = System.currentTimeMillis();
        if (r100 > 0) goto L5;
    L7:
        long r102 = -1;
    L8:
        this.f366069g = r102;
        return;
    L5:
        if (r101 < r100) goto L7;
        r102 = r101 - r100;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(long r110) {
        if (r110 >= 0) goto L5;
        return;
    L5:
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        r101.put("fcp", r110);
        r101.put("type", this.f366063a);
        r101.put("current_page", "profile_setting");
        r101.put("is_cold_start", this.f366065c ? 1 : 0);
        if (Intrinsics.areEqual(this.f366063a, "relax") == true) goto L8;
    L10:
        int r111 = 0;
    L11:
        r101.put("is_lynx_prewarm", r111);
        long r102 = this.f366068f;
        if (r102 < 0) goto L15;
        r101.put("load_template", r102);
    L15:
        if (Intrinsics.areEqual(this.f366063a, "native") == false) goto L23;
        double r103 = this.f366070h;
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        r101.put("native_measure", r103);
    L19:
        double r104 = this.f366071i;
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L23;
        r101.put("native_layout", r104);
    L23:
        if (Intrinsics.areEqual(this.f366063a, "relax") == false) goto L33;
        double r112 = this.f366070h;
        if (r112 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        r101.put("native_measure", r112);
    L27:
        long r113 = this.f366069g;
        if (r113 < 0) goto L30;
        r101.put("on_view_created", r113);
    L30:
        long r114 = this.f366067e;
        if (r114 < 0) goto L33;
        r101.put("create_lynx_view", r114);
    L33:
        Unit r115 = Unit.INSTANCE;
        r100.reportEvent("relax_profile_performance", r101);
        return;
    L8:
        if (this.f366072j == false) goto L10;
        r111 = 1;
        goto L11
    }

    public final void a(View r100, final com.larus.profile.impl.view.i r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "firstFrameTiming");
        if (this.f366073k == false) goto L5;
        return;
    L5:
        if (this.f366066d == false) goto L10;
        this.f366070h = r101.f366918b / 1000000.0d;
        this.f366071i = r101.f366919c / 1000000.0d;
        r100.post(new z0(this, r101));
        return;
    }

    public a1(String r100, long r101, boolean r102, boolean r103) {
        this.f366063a = r100;
        this.f366064b = r101;
        this.f366065c = r102;
        this.f366066d = r103;
        this.f366067e = -1;
        this.f366068f = -1;
        this.f366069g = -1;
        this.f366070h = -1.0d;
        this.f366071i = -1.0d;
    }
}
