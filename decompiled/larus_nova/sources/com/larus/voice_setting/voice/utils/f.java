package com.larus.voice_setting.voice.utils;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p2a.p;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements p2a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f377023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f377024b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f377025c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f377026d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f377027e = null;

    public f() {
    }

    static {
        f377023a = new f();
        f377024b = LazyKt.lazy(new b());
        f377025c = LazyKt.lazy(new c());
        f377026d = LazyKt.lazy(new d());
        f377027e = LazyKt.lazy(new e());
    }

    @Override // p2a.a
    public final boolean a() {
        if (z2.f365865a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r100 = AuthModelDelegate.f297134b.x().getValue();
        if (r100 != null) goto L8;
        return false;
    L8:
        String r101 = f(r100);
        FeatureConfig r102 = r100.y0();
        if (r102 == null) goto L15;
        FeatureDetail r103 = r102.F0();
        if (r103 == null) goto L15;
        if (r103.b() != true) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L26;
        List<String> r105 = r100.d();
        if (r105 != null) goto L20;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        if (r105.contains(r101) != true) goto L22;
        r106 = true;
        goto L23
    L26:
        return false;
    L15:
        r104 = false;
        goto L16
    }

    @Override // p2a.a
    public final p c() {
        return (p) f377024b.getValue();
    }

    @Override // p2a.a
    public final boolean e() {
        if (z2.f365865a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r100 = AuthModelDelegate.f297134b.x().getValue();
        if (r100 != null) goto L9;
        return false;
    L9:
        if (FeatureKitDelegate.f295792b.w0().b() == false) goto L14;
        AudioUserConfig r101 = AudioServiceDelegate.f288288a.p().getValue();
        if (r101 == null) goto L13;
        boolean r102 = r101.getHasUgcVoiceRecord();
    L15:
        String r103 = f(r100);
        FeatureConfig r104 = r100.y0();
        if (r104 == null) goto L22;
        FeatureDetail r105 = r104.F0();
        if (r105 == null) goto L22;
        if (r105.b() != true) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L34;
        if (r102 == true) goto L32;
        List<String> r107 = r100.d();
        if (r107 != null) goto L28;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == true) goto L32;
        return false;
    L28:
        if (r107.contains(r103) != true) goto L30;
        r108 = true;
    L32:
        return true;
    L34:
        return false;
    L22:
        r106 = false;
        goto L23
    L13:
        return false;
    L14:
        r102 = r100.J0();
        goto L15
    }

    public final boolean g() {
        return ((Boolean) f377025c.getValue()).booleanValue();
    }

    public static String f(LaunchInfo r100) {
        if (AppHost.f326268a.isOversea() == true) goto L5;
    L7:
        AppLocaleUtils.f375332a.getClass();
        String r101 = AppLocaleUtils.c().getLanguage();
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        if (Intrinsics.areEqual(r100.i0(), Boolean.TRUE) == false) goto L7;
        String r102 = b0.f375362a;
        AppLocaleUtils.f375332a.getClass();
        return b0.c(AppLocaleUtils.c());
    }

    @Override // p2a.a
    public final boolean b(String r100) {
        if (z2.f365865a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r101 = AuthModelDelegate.f297134b.x().getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = h(r101, r100);
        if (r102 != null) goto L11;
        return false;
    L11:
        FeatureConfig r103 = r101.y0();
        if (r103 == null) goto L18;
        FeatureDetail r104 = r103.F0();
        if (r104 == null) goto L18;
        if (r104.b() != true) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L29;
        List<String> r106 = r101.d();
        if (r106 != null) goto L23;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        if (r106.contains(r102) != true) goto L25;
        r107 = true;
        goto L26
    L29:
        return false;
    L18:
        r105 = false;
        goto L19
    }

    @Override // p2a.a
    public final boolean d(String r100) {
        if (AppHost.f326268a.isOversea() == true) goto L5;
        return true;
    L5:
        LaunchInfo r101 = AuthModelDelegate.f297134b.x().getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = h(r101, r100);
        if (r102 != null) goto L11;
        return false;
    L11:
        List<String> r103 = r101.d();
        if (r103 != null) goto L14;
    L16:
        return false;
    L14:
        if (r103.contains(r102) != true) goto L16;
        return true;
    }

    public static String h(LaunchInfo r100, String r101) {
        if (AppHost.f326268a.isOversea() == true) goto L5;
        return r101;
    L5:
        if (Intrinsics.areEqual(r100.i0(), Boolean.TRUE) == false) goto L9;
        String r102 = b0.f375362a;
        AppLocaleUtils.f375332a.getClass();
        return b0.c(AppLocaleUtils.c());
    L9:
        return r101;
    }
}
