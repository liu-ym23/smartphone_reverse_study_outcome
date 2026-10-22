package com.ss.android.lark.widget.photopickerimpl.view.large;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ldc.f;
import ldc.h;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class a<DATA extends Photo> extends odc.a<DATA> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f447848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final odc.b<DATA, e<DATA>> f447849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f<DATA, b<DATA>> f447850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f<DATA, b<DATA>> f447851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f447852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f447853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LargeShowVPagerAdapter<DATA> f447854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager f447855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f447856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f447857l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ldc.a f447858m;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopickerimpl.view.large.a$a, reason: collision with other inner class name */
    public static final class C5424a {
    }

    public interface b<DATA> {
        Photo a();

        void finish();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<DATA> f447859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f447860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.widget.photopickerimpl.bean.a f447861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f447862d;

        public c(a<DATA> r100, ViewPager r101, com.ss.android.lark.widget.photopickerimpl.bean.a r102, View r103) {
            this.f447859a = r100;
            this.f447860b = r101;
            this.f447861c = r102;
            this.f447862d = r103;
        }

        public final void a() {
            a<DATA> r100 = this.f447859a;
            ViewPager r101 = this.f447860b;
            com.ss.android.lark.widget.photopickerimpl.bean.a r102 = this.f447861c;
            View r103 = r100.f447853h;
            if (r103 == null) goto L5;
            r103.setVisibility(0);
        L5:
            r101.setPivotX(0.0f);
            r101.setPivotY(0.0f);
            boolean r104 = true;
            if (r101.getMeasuredWidth() != 0.0f) goto L8;
            boolean r105 = true;
        L10:
            if (r105 == false) goto L12;
        L18:
            r101.setScaleX(1.0f);
            r101.setScaleY(1.0f);
        L19:
            r101.setTranslationX(0.0f);
            r101.setTranslationY(0.0f);
            Float r106 = r102.f447747a;
            Intrinsics.checkNotNull(r106);
            r101.setTranslationX(r106.floatValue() - r101.getX());
            Float r107 = r102.f447748b;
            Intrinsics.checkNotNull(r107);
            r101.setTranslationY(r107.floatValue() - r101.getY());
            r101.animate().setListener(new qdc.a(r101)).translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(r100.f447856k).start();
            a.l(this.f447862d, 0, -16777216, this.f447859a.f447856k);
            return;
        L12:
            if (r101.getMeasuredHeight() == 0.0f) goto L15;
            r104 = false;
        L15:
            if (r104 == true) goto L18;
            Integer r108 = r102.f447749c;
            Intrinsics.checkNotNull(r108);
            r101.setScaleX(r108.intValue() / r101.getMeasuredWidth());
            Integer r109 = r102.f447750d;
            Intrinsics.checkNotNull(r109);
            r101.setScaleY(r109.intValue() / r101.getMeasuredHeight());
            goto L19
        L8:
            r105 = false;
            goto L10
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

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f447863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f447864b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f447863a.setBackgroundColor(this.f447864b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f447863a.setBackgroundColor(this.f447864b);
        }

        public d(View r100, int r101) {
            this.f447863a = r100;
            this.f447864b = r101;
        }
    }

    static {
    }

    @Override // odc.a
    public final void d() {
    }

    @Override // odc.a
    public final void f() {
        View r100 = this.f447853h;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        f<DATA, b<DATA>> r101 = this.f447850e;
        if (r101 == null) goto L8;
        r101.onStop();
    L8:
        f<DATA, b<DATA>> r102 = this.f447851f;
        if (r102 == null) goto L12;
        r102.onStop();
        return;
    }

    public final void i() {
        LargeShowVPagerAdapter<DATA> r100 = this.f447854i;
        if (r100 == null) goto L8;
        Iterator<Map.Entry<Integer, Fragment>> r101 = r100.f447845d.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().getValue().onPause();
    L8:
        ViewPager r102 = this.f447855j;
        View r103 = this.f447853h;
        ldc.a r104 = this.f447858m;
        if (r104 == null) goto L24;
        LargeShowVPagerAdapter<DATA> r105 = this.f447854i;
        if (r105 == null) goto L22;
        ArrayList<DATA> r106 = r105.f447847f;
        if (r106 == null) goto L22;
        if (r102 == null) goto L16;
        int r107 = r102.getCurrentItem();
    L17:
        Photo r108 = (Photo) CollectionsKt.getOrNull(r106, r107);
        if (r108 == null) goto L22;
        Integer r109 = r108.f447736a;
        if (r109 == null) goto L22;
        int r110 = r109.intValue();
    L23:
        com.ss.android.lark.widget.photopickerimpl.bean.a r111 = r104.a(r110);
    L25:
        if (r111 != null) goto L27;
    L41:
        odc.a.InterfaceC7038a r112 = this.f522914b;
        Intrinsics.checkNotNull(r112);
        r112.d(this);
        return;
    L27:
        if (r111.f447747a != null) goto L29;
    L35:
        boolean r113 = false;
    L36:
        if (r113 == false) goto L41;
        if (r102 == null) goto L41;
        if (r103 == null) goto L41;
        r102.setTranslationX(0.0f);
        r102.setTranslationY(0.0f);
        odc.a.InterfaceC7038a r114 = this.f522914b;
        Intrinsics.checkNotNull(r114);
        float[] r115 = r114.a(r102);
        r102.setPivotY(0.0f);
        r102.setPivotX(0.0f);
        ViewPropertyAnimator r116 = r102.animate().setListener(new qdc.b(this));
        Integer r117 = r111.f447749c;
        Intrinsics.checkNotNull(r117);
        ViewPropertyAnimator r118 = r116.scaleX(r117.intValue() / r102.getMeasuredWidth());
        Integer r119 = r111.f447750d;
        Intrinsics.checkNotNull(r119);
        ViewPropertyAnimator r120 = r118.scaleY(r119.intValue() / r102.getMeasuredHeight());
        Float r121 = r111.f447747a;
        Intrinsics.checkNotNull(r121);
        ViewPropertyAnimator r122 = r120.translationX(r121.floatValue() - r115[0]);
        Float r123 = r111.f447748b;
        Intrinsics.checkNotNull(r123);
        r122.translationY(r123.floatValue() - r115[1]).setDuration(this.f447856k).setInterpolator(new DecelerateInterpolator()).start();
        l(r103, -16777216, 0, this.f447856k);
        return;
    L29:
        if (r111.f447748b == null) goto L35;
        if (r111.f447749c == null) goto L35;
        if (r111.f447750d == null) goto L35;
        r113 = true;
        goto L36
    L16:
        r107 = 0;
    L22:
        r110 = -1;
        goto L23
    L24:
        r111 = null;
        goto L25
    }

    public final void j() {
        if (this.f447857l == false) goto L5;
        return;
    L5:
        odc.a.b r100 = this.f522913a;
        if (r100 == null) goto L9;
        r100.a();
        return;
    }

    @Override // odc.a
    public final void b() {
        i();
    }

    @Override // odc.a
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.pp_large_component_view, r100, false);
        Intrinsics.checkNotNull(r101);
        ViewPager r102 = (ViewPager) r101.findViewById(R.id.photo_picker_viewpager);
        LargeShowVPagerAdapter<DATA> r103 = new LargeShowVPagerAdapter(this.f447848c, this.f447849d, new com.ss.android.lark.widget.photopickerimpl.view.large.c(), new com.ss.android.lark.widget.photopickerimpl.view.large.d(r102));
        this.f447854i = r103;
        r102.setAdapter(r103);
        r102.addOnPageChangeListener(new LargeComponent$initViewPager$3(this));
        this.f447855j = r102;
        ViewGroup r104 = (ViewGroup) r101.findViewById(R.id.fl_top_container);
        ViewGroup r105 = (ViewGroup) r101.findViewById(R.id.fl_bottom_container);
        View r106 = r101.findViewById(R.id.photo_picker_viewpager);
        com.ss.android.lark.widget.photopickerimpl.view.large.b r107 = new com.ss.android.lark.widget.photopickerimpl.view.large.b(this);
        f<DATA, b<DATA>> r108 = this.f447850e;
        if (r108 == null) goto L5;
        r108.d(r107);
    L5:
        f<DATA, b<DATA>> r109 = this.f447851f;
        if (r109 == null) goto L8;
        r109.d(r107);
    L8:
        f<DATA, b<DATA>> r110 = this.f447850e;
        if (r110 == null) goto L13;
        Intrinsics.checkNotNull(r104);
        View r111 = r110.b(r104);
        if (r111 == null) goto L13;
        r104.addView(r111);
    L13:
        f<DATA, b<DATA>> r112 = this.f447851f;
        if (r112 == null) goto L25;
        Intrinsics.checkNotNull(r105);
        View r113 = r112.b(r105);
        if (r113 == null) goto L25;
        r105.addView(r113);
        if (Intrinsics.areEqual(r113.getTag(R.id.layout_photo_insert_message_new), Boolean.TRUE) == false) goto L25;
        ViewGroup.LayoutParams r114 = r106.getLayoutParams();
        if ((r114 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
    L23:
        if (r115 == null) goto L25;
        r115.bottomToTop = R.id.bottom_toolbar_content_anchor;
        r106.setLayoutParams(r115);
        goto L25
    L22:
        r115 = null;
    L25:
        r101.setVisibility(8);
        this.f447853h = r101;
        return r101;
    }

    @Override // odc.a
    public final void e(com.ss.android.lark.widget.photopickerimpl.bean.c r100) {
        View r101 = this.f447853h;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        f<DATA, b<DATA>> r102 = this.f447850e;
        if (r102 == null) goto L8;
        r102.onResume();
    L8:
        f<DATA, b<DATA>> r103 = this.f447851f;
        if (r103 == null) goto L11;
        r103.onResume();
    L11:
        if (r100 == null) goto L15;
        Integer r104 = (Integer) r100.a("showPosition");
        if (r104 == null) goto L15;
        int r105 = r104.intValue();
    L16:
        List r106 = null;
        if (r100 == null) goto L19;
        ldc.a r107 = (ldc.a) r100.a("infoProvider");
    L20:
        if (r100 == null) goto L22;
        com.ss.android.lark.widget.photopickerimpl.bean.a r108 = (com.ss.android.lark.widget.photopickerimpl.bean.a) r100.a("animInfo");
    L23:
        if (r100 == null) goto L25;
        r106 = (List) r100.a("showData");
    L25:
        if (r100 == null) goto L29;
        Boolean r109 = (Boolean) r100.a("isSelectMode");
        if (r109 == null) goto L29;
        boolean r110 = r109.booleanValue();
    L30:
        this.f447857l = r110;
        if (r106 == null) goto L37;
        g(CollectionsKt.toMutableList(r106), 0, false);
        if (r105 < r106.size()) goto L35;
        r105 = CollectionsKt.getLastIndex(r106);
    L35:
        if (r105 < 0) goto L37;
        k((Photo) ListProtector.get(r106, r105));
    L37:
        this.f447858m = r107;
        ViewPager r111 = this.f447855j;
        if (r111 == null) goto L40;
        r111.setCurrentItem(r105, false);
    L40:
        ViewPager r112 = this.f447855j;
        View r113 = this.f447853h;
        if (r108 != null) goto L43;
    L56:
        if (r113 == null) goto L58;
        r113.setVisibility(0);
    L58:
        Intrinsics.checkNotNull(r113);
        l(r113, 0, -16777216, this.f447856k);
        if (r112 == null) goto L61;
        r112.setScaleX(1.0f);
    L61:
        if (r112 == null) goto L64;
        r112.setScaleY(1.0f);
    L64:
        if (r112 == null) goto L66;
        r112.setTranslationX(0.0f);
    L66:
        if (r112 == null) goto L70;
        r112.setTranslationY(0.0f);
        return;
    L70:
        return;
    L43:
        if (r108.f447747a != null) goto L45;
    L51:
        boolean r114 = false;
    L52:
        if (r114 == false) goto L56;
        if (r112 == null) goto L56;
        if (r113 == null) goto L56;
        r112.post(new c(this, r112, r108, r113));
        return;
    L45:
        if (r108.f447748b == null) goto L51;
        if (r108.f447749c == null) goto L51;
        if (r108.f447750d == null) goto L51;
        r114 = true;
    L29:
        r110 = false;
        goto L30
    L22:
        r108 = null;
        goto L23
    L19:
        r107 = null;
    L15:
        r105 = 0;
        goto L16
    }

    public final void k(DATA r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = h.f508886a;
        String r102 = this.f447852g;
        String r103 = "onPageSelected , data = " + r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "msg");
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "msg");
        Log.d(r102, r103);
        f<DATA, b<DATA>> r104 = this.f447850e;
        if (r104 == null) goto L5;
        r104.a(r100);
    L5:
        f<DATA, b<DATA>> r105 = this.f447851f;
        if (r105 == null) goto L9;
        r105.a(r100);
        return;
    }

    @Override // odc.a
    public final void a(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        f<DATA, b<DATA>> r103 = this.f447850e;
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.onActivityResult(r100, r101, r102) != true) goto L7;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        f<DATA, b<DATA>> r105 = this.f447851f;
        if (r105 == null) goto L14;
        r105.onActivityResult(r100, r101, r102);
        return;
    L14:
        return;
    L7:
        r104 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    @Override // odc.a
    public final void g(List<DATA> r100, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ?? r101 = new ArrayList();
        boolean r102 = false;
        if (this.f447857l == false) goto L32;
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L34;
        Photo r104 = (Photo) r103.next();
        if ((r104 instanceof t) == false) goto L6;
        LargeShowVPagerAdapter<DATA> r105 = this.f447854i;
        if (r105 == null) goto L25;
        ArrayList<DATA> r106 = r105.f447847f;
        if (r106 == null) goto L25;
        if (r106.isEmpty() == true) goto L22;
        Iterator<DATA> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(r107.next().f447736a, r104.f447736a) == false) goto L18;
        boolean r108 = true;
    L23:
        if (r108 != true) goto L25;
        boolean r109 = true;
    L27:
        if (r109 == true) goto L28;
        if (((t) r104).f537388m == false) goto L6;
        Log.i(this.f447852g, "update select photo: id=" + r104.f447736a + ", path=" + r104.f447737b);
        r101.add(r104);
        goto L6
    L28:
        Log.i(this.f447852g, "update select photo: id=" + r104.f447736a + ", path=" + r104.f447737b);
        r101.add(r104);
    L22:
        r108 = false;
    L25:
        r109 = false;
    L34:
        if ((!r101.isEmpty()) == false) goto L42;
        String r112 = ((Photo) ListProtector.get(r101, 0)).f447737b;
        if (r112 != null) goto L38;
    L39:
        r102 = true;
    L40:
        if (r102 == false) goto L42;
        r101 = CollectionsKt.takeLast(r101, r101.size() - 1);
        goto L42
    L38:
        if (r112.length() != 0) goto L40;
    L42:
        Object r113 = null;
        if (r111 == false) goto L78;
        LargeShowVPagerAdapter<DATA> r114 = this.f447854i;
        if (r114 == null) goto L54;
        Iterator<Map.Entry<Integer, Fragment>> r115 = r114.f447845d.entrySet().iterator();
    L48:
        if (r115.hasNext() == false) goto L54;
        Map.Entry<Integer, Fragment> r116 = r115.next();
        int r117 = r116.getKey().intValue();
        Fragment r118 = r116.getValue();
        if (r117 >= r114.f447847f.size()) goto L48;
        e<DATA> r119 = r114.f447846e.get(r118);
        if (r119 == null) goto L48;
        r119.c((Photo) ListProtector.get(r114.f447847f, r117));
    L54:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        LargeShowVPagerAdapter<DATA> r120 = this.f447854i;
        if (r120 == null) goto L63;
        ArrayList<DATA> r121 = r120.f447847f;
        if (r121 == null) goto L63;
        ViewPager r122 = this.f447855j;
        if (r122 == null) goto L61;
        int r123 = r122.getCurrentItem();
    L62:
        Photo r124 = (Photo) CollectionsKt.getOrNull(r121, r123);
    L64:
        Iterator r125 = ((Iterable) r101).iterator();
    L66:
        if (r125.hasNext() == false) goto L74;
        Object r126 = r125.next();
        Integer r127 = ((Photo) r126).f447736a;
        if (r124 == null) goto L70;
        Integer r128 = r124.f447736a;
    L72:
        if (Intrinsics.areEqual(r127, r128) == false) goto L66;
        r113 = r126;
        goto L74
    L70:
        r128 = null;
    L74:
        Photo r129 = (Photo) r113;
        if (r129 != null) goto L77;
        return;
    L77:
        k(r129);
        return;
    L61:
        r123 = -1;
    L63:
        r124 = null;
        goto L64
    L78:
        if (r110 != 0) goto L98;
        LargeShowVPagerAdapter<DATA> r130 = this.f447854i;
        if (r130 == null) goto L84;
        ArrayList<DATA> r131 = r130.f447847f;
        if (r131 == null) goto L84;
        r131.clear();
    L84:
        LargeShowVPagerAdapter<DATA> r132 = this.f447854i;
        if (r132 == null) goto L89;
        ArrayList<DATA> r133 = r132.f447847f;
        if (r133 == null) goto L89;
        r133.addAll((Collection) r101);
    L89:
        LargeShowVPagerAdapter<DATA> r134 = this.f447854i;
        if (r134 == null) goto L92;
        r134.notifyDataSetChanged();
    L92:
        ViewPager r135 = this.f447855j;
        if (r135 == null) goto L95;
        r135.setAdapter(null);
    L95:
        ViewPager r136 = this.f447855j;
        if (r136 == null) goto L160;
        r136.setAdapter(this.f447854i);
        return;
    L160:
        return;
    L98:
        LargeShowVPagerAdapter<DATA> r137 = this.f447854i;
        if (r137 == null) goto L162;
        Intrinsics.checkNotNullParameter(r101, "data");
        r137.f447847f.clear();
        r137.f447847f.addAll((Collection) r101);
        if (r110 <= 0) goto L110;
        r137.notifyDataSetChanged();
        Iterator<Map.Entry<Integer, Fragment>> r138 = r137.f447845d.entrySet().iterator();
    L104:
        if (r138.hasNext() == false) goto L164;
        Map.Entry<Integer, Fragment> r139 = r138.next();
        int r140 = r139.getKey().intValue();
        Fragment r141 = r139.getValue();
        if (r140 >= r137.f447847f.size()) goto L104;
        e<DATA> r142 = r137.f447846e.get(r141);
        if (r142 == null) goto L104;
        r142.c((Photo) ListProtector.get(r137.f447847f, r140));
        goto L104
    L164:
        return;
    L110:
        if (r110 >= 0) goto L120;
        int r143 = -r110;
        Iterator<Map.Entry<Integer, Fragment>> r144 = r137.f447845d.entrySet().iterator();
    L113:
        if (r144.hasNext() == false) goto L119;
        Map.Entry<Integer, Fragment> r145 = r144.next();
        int r146 = r145.getKey().intValue();
        Fragment r147 = r145.getValue();
        int r148 = r146 + r143;
        if (r148 >= r137.f447847f.size()) goto L113;
        e<DATA> r149 = r137.f447846e.get(r147);
        if (r149 == null) goto L113;
        r149.c((Photo) ListProtector.get(r137.f447847f, r148));
        goto L113
    L119:
        r137.notifyDataSetChanged();
        r137.f447844c.a(r137.f447844c.getCurrentItem() - r110);
        return;
    L120:
        r137.notifyDataSetChanged();
        return;
    L162:
        return;
    L32:
        r101.addAll(r100);
        goto L34
    }

    public a(FragmentManager r100, rdc.f r101, sdc.d r102, sdc.a r103) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "mFactory");
        this.f447848c = r100;
        this.f447849d = r101;
        this.f447850e = r102;
        this.f447851f = r103;
        this.f447852g = "PP_LargeComponent";
        this.f447856k = 300;
    }

    public static void l(View r100, int r101, int r102, long r103) {
        ObjectAnimator r104 = ObjectAnimator.ofInt(r100, "backgroundColor", new int[]{r101, r102});
        r104.setDuration(r103);
        r104.setEvaluator(new ArgbEvaluator());
        r104.addListener(new d(r100, r102));
        r104.start();
    }
}
