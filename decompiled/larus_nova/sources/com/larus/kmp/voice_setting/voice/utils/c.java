package com.larus.kmp.voice_setting.voice.utils;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.kmp.voice_setting.voice.bridge.r;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public static final b a() {
        r r100 = com.larus.kmp.voice_setting.voice.bridge.n.a(true);
        if (FeatureKitDelegate.f295792b.w0().b() == false) goto L7;
        AudioUserConfig r101 = AudioServiceDelegate.f288288a.p().getValue();
        if (r101 == null) goto L11;
        boolean r102 = r101.getHasUgcVoiceRecord();
    L12:
        AppLocaleUtils.f375332a.getClass();
        Locale r103 = AppLocaleUtils.c();
        if (AppHost.f326268a.isOversea() == false) goto L21;
        if (r100 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L21;
        boolean r105 = true;
    L22:
        boolean r106 = z2.f365865a.m3();
        if (r100 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        Set<String> r108 = null;
        if (r100 == null) goto L31;
        Set<String> r109 = r100.f351898g;
    L32:
        if (r109 != null) goto L34;
        r109 = SetsKt.emptySet();
    L34:
        Set<String> r110 = r109;
        if (r100 == null) goto L37;
        r108 = r100.f351899h;
    L37:
        if (r108 != null) goto L39;
        r108 = SetsKt.emptySet();
    L39:
        Set<String> r111 = r108;
        String r112 = r103.getLanguage();
        if (r105 == false) goto L42;
        String r113 = b0.c(r103);
    L43:
        String r114 = r113;
        Intrinsics.checkNotNull(r114);
        return new b(r106, r107, r102, r110, r111, r112, r114);
    L42:
        r113 = r103.getLanguage();
        goto L43
    L31:
        r109 = null;
        goto L32
    L25:
        if (r100.f351896e != true) goto L27;
        r107 = true;
        goto L28
    L16:
        if (r100.f351893b != true) goto L18;
        r104 = true;
    L21:
        r105 = false;
    L11:
        r102 = false;
        goto L12
    L7:
        if (r100 == null) goto L11;
        if (r100.f351897f != true) goto L11;
        r102 = true;
        goto L12
    }
}
