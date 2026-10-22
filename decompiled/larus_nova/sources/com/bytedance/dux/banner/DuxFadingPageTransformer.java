package com.bytedance.dux.banner;

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

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/banner/DuxFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f204877a;

    public static final class a {
    }

    static {
    }

    public DuxFadingPageTransformer() {
        this(0);
    }

    public DuxFadingPageTransformer(int r100) {
        this.f204877a = R.color.Transparent;
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
        if (r101 >= (-1)) goto L5;
        a(new AnonymousClass3(r100), new AnonymousClass4(r100));
        return;
    L5:
        float r102 = 1;
        if (r101 > r102) goto L8;
        final float r103 = Math.max(0.5f, r102 - Math.abs(r101));
        a(new AnonymousClass5(r100, r103), new AnonymousClass6(r100, r103));
        return;
    L8:
        a(new AnonymousClass7(r100), new AnonymousClass8(r100));
    }
}
