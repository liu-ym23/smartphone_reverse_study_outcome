package com.larus.kmp.voice_setting.voice.editvoice;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f353259a = 0;

    static {
    }

    public static f a(String r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        if (StringsKt.isBlank(r100) == false) goto L6;
        return null;
    L6:
        wt7.c r101 = wt7.a.f561230a;
        juc.d<f> r102 = f.Companion.serializer();
        r101.getClass();
        return (f) wt7.c.a(r100, r102);
    }

    public static f b(Float r100, Float r101) {
        if (r100 == null) goto L21;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100.floatValue() >= (-30.0f)) goto L8;
    L11:
        float r102 = 0.0f;
    L13:
        if (r101.floatValue() >= 7.0f) goto L15;
    L18:
        float r103 = 10.0f;
    L20:
        return new f(r102 / 10.0f, r103 / 10.0f);
    L15:
        if (r101.floatValue() > 15.0f) goto L18;
        r103 = r101.floatValue();
        goto L20
    L8:
        if (r100.floatValue() > 30.0f) goto L11;
        r102 = r100.floatValue();
        goto L13
    L21:
        return null;
    }
}
