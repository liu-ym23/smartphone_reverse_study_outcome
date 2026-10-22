package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class LuckyFloatBarViewManager extends uo7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f271200b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LuckyFloatBarViewManager f271201c = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f271202a;

        public a(View r100) {
            this.f271202a = r100;
        }

        public final void a() {
            View r100 = this.f271202a;
            if (r100 == null) goto L5;
            r100.setVisibility(0);
        L5:
            LuckyFloatBarViewManager r101 = LuckyFloatBarViewManager.f271201c;
            View r102 = this.f271202a;
            r101.getClass();
            AnimatorSet r103 = new AnimatorSet();
            r103.setDuration(200);
            if (r102 == null) goto L9;
            List r104 = CollectionsKt.mutableListOf(new Animator[]{ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{UIUtils.getScreenWidth(r102.getContext()), 0.0f})});
            r104.add(ObjectAnimator.ofFloat(r102, "alpha", new float[]{r102.getAlpha(), 1.0f}));
            r103.playTogether(r104);
            r103.start();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f271199a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyFloatBarViewManager.class), "mViewMap", "getMViewMap()Ljava/util/Map;"))};
        LuckyFloatBarViewManager r100 = new LuckyFloatBarViewManager();
        f271201c = r100;
        to7.c.d(r100);
        f271200b = LazyKt.lazy(LuckyFloatBarViewManager$mViewMap$2.INSTANCE);
    }

    public final Map<String, WeakReference<View>> o() {
        Lazy r100 = f271200b;
        KProperty r101 = f271199a[0];
        return (Map) r100.getValue();
    }

    public LuckyFloatBarViewManager() {
    }

    public static void n(Uri r100) {
        StringBuffer r101 = new StringBuffer();
        if (UriProtector.getQueryParameter(r100, "left_margin") != null) goto L6;
        r101.append("需设置left_margin\n");
    L6:
        if (UriProtector.getQueryParameter(r100, "right_margin") != null) goto L8;
        r101.append("需设置right_margin\n");
    L8:
        String r102 = UriProtector.getQueryParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        if (r102 == null) goto L27;
        int r103 = r102.hashCode();
        if (r103 == (-1383228885)) goto L22;
        if (r103 != 115029) goto L27;
        if (r102.equals("top") == false) goto L27;
        if (UriProtector.getQueryParameter(r100, "top_margin") != null) goto L29;
        r101.append("gravity为top的时候，需设置top_margin\n");
    L29:
        String r104 = r101.toString();
        if (r104.length() <= 0) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L38;
        Activity r106 = to7.c.b();
        if (r106 == null) goto L39;
        Toast.makeText(r106, r104.substring(0, r104.length() - 1), 1).show();
        return;
    L39:
        return;
    L38:
        return;
    L32:
        r105 = false;
        goto L33
    L22:
        if (r102.equals("bottom") == false) goto L27;
        if (UriProtector.getQueryParameter(r100, "bottom_margin") != null) goto L29;
        r101.append("gravity为bottom的时候，需设置bottom_margin\n");
    L27:
        if (UriProtector.getQueryParameter(r100, "bottom_margin") != null) goto L29;
        r101.append("gravity缺省的时候为bottom，需设置bottom_margin\n");
        goto L29
    }

    @Override // uo7.c, uo7.a
    public final void onActivityDestroyed(Activity r100) {
        super.onActivityDestroyed(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, WeakReference<View>>> r102 = f271201c.o().entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, WeakReference<View>> r103 = r102.next();     // Catch: Throwable -> L15
        String r104 = r103.getKey();     // Catch: Throwable -> L15
        View r105 = r103.getValue().get();     // Catch: Throwable -> L15
        if (r105 == null) goto L9;
        Context r106 = r105.getContext();     // Catch: Throwable -> L15
    L11:
        if (Intrinsics.areEqual(r106, r100) == false) goto L5;
        f271201c.o().remove(r104);     // Catch: Throwable -> L15
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "activity onDestroy, removeView url: " + r104);     // Catch: Throwable -> L15
        goto L5
    L9:
        r106 = null;
        goto L11
    L13:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        StringBuilder r109 = new StringBuilder("onActivityDestroyed, ");
        r108.printStackTrace();
        r109.append(Unit.INSTANCE);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", r109.toString());
        return;
    L28:
        return;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @JvmStatic
    public static final boolean l(Context r110, String r111) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "addView");
        View r100 = null;
        if (r111 == null) goto L5;
        String r112 = StringsKt.replace$default(r111, "preload_popup", "show_on_success", false, 4, null);
    L7:
        if (r112 != null) goto L10;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "schema is null");
        return false;
    L10:
        LuckyFloatBarViewManager r101 = f271201c;
        if (r101.o().containsKey(r112) == false) goto L15;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "already exist, schema is ".concat(r112));
        return false;
    L15:
        if ((r110 instanceof Activity) == false) goto L17;
        Activity r113 = (Activity) r110;
    L18:
        if (r113 != null) goto L77;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "addView fail, null activity, schema is ".concat(r112));
        return false;
    L77:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L72
        si7.a r103 = nj7.a.f519460b.h0();     // Catch: Throwable -> L72
        if (r103 == null) goto L24;
        vi7.c r104 = r103.S(r113, new ij7.i(""));     // Catch: Throwable -> L72
    L25:
        if (r104 == null) goto L27;
        r100 = r104.h();     // Catch: Throwable -> L72
    L27:
        if (r100 != null) goto L30;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "real view is null");     // Catch: Throwable -> L72
        return false;
    L30:
        r100.setBackgroundColor(0);     // Catch: Throwable -> L72
        r100.setVisibility(4);     // Catch: Throwable -> L72
        Uri r105 = UriProtector.parse(r112);     // Catch: Throwable -> L72
        if (r105.getBooleanQueryParameter("show_on_success", false) == true) goto L33;
        r100.post(new a(r100));     // Catch: Throwable -> L72
    L33:
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -2);     // Catch: Throwable -> L72
        String r107 = UriProtector.getQueryParameter(r105, GXTemplateKey.GAIAX_LAYER_GRAVITY);     // Catch: Throwable -> L72
        if (r107 == null) goto L45;
        int r108 = r107.hashCode();     // Catch: Throwable -> L72
        if (r108 != (-1383228885)) goto L39;
        r107.equals("bottom");     // Catch: Throwable -> L72
        goto L45
    L39:
        if (r108 != 115029) goto L45;
        if (r107.equals("top") == false) goto L45;
        int r109 = 48;
    L46:
        r106.gravity = r109;     // Catch: Throwable -> L72
        String r114 = UriProtector.getQueryParameter(r105, "left_margin");     // Catch: Throwable -> L72
        if (r114 == null) goto L49;
        int r115 = CastIntegerProtector.parseInt(r114);     // Catch: Throwable -> L72
    L50:
        r106.leftMargin = r115;     // Catch: Throwable -> L72
        String r116 = UriProtector.getQueryParameter(r105, "right_margin");     // Catch: Throwable -> L72
        if (r116 == null) goto L53;
        int r117 = CastIntegerProtector.parseInt(r116);     // Catch: Throwable -> L72
    L54:
        r106.rightMargin = r117;     // Catch: Throwable -> L72
        if (r106.gravity != 48) goto L61;
        String r118 = UriProtector.getQueryParameter(r105, "top_margin");     // Catch: Throwable -> L72
        if (r118 == null) goto L59;
        int r119 = CastIntegerProtector.parseInt(r118);     // Catch: Throwable -> L72
    L60:
        r106.topMargin = r119;     // Catch: Throwable -> L72
    L67:
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271344l == false) goto L69;
        n(r105);     // Catch: Throwable -> L72
    L69:
        r100.setLayoutParams(r106);     // Catch: Throwable -> L72
        r104.g();     // Catch: Throwable -> L72
        FrameLayout r120 = (FrameLayout) r113.findViewById(R.id.content);     // Catch: Throwable -> L72
        r101.o().put(r112, new WeakReference(r100));     // Catch: Throwable -> L72
        r120.addView(r100);     // Catch: Throwable -> L72
        return true;
    L59:
        r119 = (int) UIUtils.dip2Px(r113, 10.0f);     // Catch: Throwable -> L72
        goto L60
    L61:
        String r121 = UriProtector.getQueryParameter(r105, "bottom_margin");     // Catch: Throwable -> L72
        if (r121 == null) goto L64;
        int r122 = CastIntegerProtector.parseInt(r121);     // Catch: Throwable -> L72
    L65:
        r106.bottomMargin = r122;     // Catch: Throwable -> L72
        goto L67
    L64:
        r122 = (int) UIUtils.dip2Px(r113, 60.0f);     // Catch: Throwable -> L72
        goto L65
    L53:
        r117 = (int) UIUtils.dip2Px(r113, 10.0f);     // Catch: Throwable -> L72
        goto L54
    L49:
        r115 = (int) UIUtils.dip2Px(r113, 10.0f);     // Catch: Throwable -> L72
    L45:
        r109 = 80;
        goto L46
    L24:
        r104 = null;
    L72:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Throwable r124 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r124 == null) goto L76;
        StringBuilder r125 = new StringBuilder("addView fail, ");
        r124.printStackTrace();
        r125.append(Unit.INSTANCE);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", r125.toString());
    L76:
        return false;
    L17:
        r113 = to7.c.b();
        goto L18
    L5:
        r112 = null;
        goto L7
    }

    @JvmStatic
    public static final void p(Activity r100, String r110) {
        View r101 = null;
        if (r110 == null) goto L5;
        String r111 = StringsKt.replace$default(r110, "preload_popup", "show_on_success", false, 4, null);
    L31:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r111) == false) goto L9;
        return;
    L9:
        LuckyFloatBarViewManager r103 = f271201c;     // Catch: Throwable -> L25
        WeakReference<View> r104 = r103.o().get(r111);     // Catch: Throwable -> L25
        if (r104 == null) goto L12;
        r101 = r104.get();     // Catch: Throwable -> L25
    L12:
        if (r100 != null) goto L15;
        r100 = to7.c.b();     // Catch: Throwable -> L25
    L15:
        FrameLayout r105 = (FrameLayout) r100.findViewById(R.id.content);     // Catch: Throwable -> L25
        if (r101 != null) goto L18;
    L20:
        Map<String, WeakReference<View>> r106 = r103.o();     // Catch: Throwable -> L25
        if (r106 == null) goto L24;
        TypeIntrinsics.asMutableMap(r106).remove(r111);     // Catch: Throwable -> L25
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "removeView url: " + r111);     // Catch: Throwable -> L25
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L28:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L32;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyBulletCardViewManager", "removeView fail");
        return;
    L32:
        return;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Throwable -> L25
    L18:
        if (r105.indexOfChild(r101) == (-1)) goto L20;
        r105.removeView(r101);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        r111 = null;
        goto L31
    }
}
