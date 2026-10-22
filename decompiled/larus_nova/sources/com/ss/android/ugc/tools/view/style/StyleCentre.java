package com.ss.android.ugc.tools.view.style;

import android.graphics.Typeface;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class StyleCentre {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f454921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xhc.a f454922b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final xhc.a f454923c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StyleCentre f454924d = null;

    static {
        f454921a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(StyleCentre.class, "fontSource", "getFontSource()Lcom/ss/android/ugc/tools/view/style/IFontSource;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StyleCentre.class, "defaultFontProvider", "getDefaultFontProvider()Lkotlin/jvm/functions/Function0;", 0))};
        f454924d = new StyleCentre();
        f454922b = new xhc.a(StyleCentre$fontSource$2.INSTANCE);
        f454923c = new xhc.a(StyleCentre$defaultFontProvider$2.INSTANCE);
    }

    public StyleCentre() {
    }

    @JvmStatic
    public static final Typeface a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fontName");
        StyleCentre r101 = f454924d;
        r101.getClass();
        b r102 = (b) f454922b.getValue(r101, f454921a[0]);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b();
    }
}
