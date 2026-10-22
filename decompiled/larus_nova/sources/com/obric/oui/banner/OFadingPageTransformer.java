package com.obric.oui.banner;

import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398852a;

    public static final class a {
    }

    static {
    }

    public OFadingPageTransformer() {
        this(0);
    }

    public OFadingPageTransformer(int r100) {
        this.f398852a = R.color.Transparent;
    }

    public final void a(Function0<Unit> r100, Function0<Unit> r101) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.invoke();
        return;
    L5:
        r101.invoke();
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(final View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        a(new AnonymousClass1(r100, this), AnonymousClass2.INSTANCE);
        if (r101 >= (-1.0f)) goto L6;
        a(new AnonymousClass3(r100), new AnonymousClass4(r100));
        return;
    L6:
        if (r101 > 1.0f) goto L8;
        final float r102 = Math.max(0.5f, 1 - Math.abs(r101));
        a(new AnonymousClass5(r100, r102), new AnonymousClass6(r100, r102));
        return;
    L8:
        a(new AnonymousClass7(r100), new AnonymousClass8(r100));
    }
}
