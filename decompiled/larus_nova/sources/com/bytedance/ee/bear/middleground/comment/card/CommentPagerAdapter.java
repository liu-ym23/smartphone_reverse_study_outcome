package com.bytedance.ee.bear.middleground.comment.card;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.HalfScreenCardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentPagerAdapter extends op5.a implements q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<CommentBean> f230735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.p f230736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Activity f230737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f230738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f230739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.z f230740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.y f230741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f230742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<View> f230743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Integer, View> f230744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FixPageTransformerViewPager f230745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SharePermissionViewModel f230746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f230747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f230748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CommentPagerAdapter$createWholeCommentTailDecoration$1 f230749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f230750r;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final Integer E() {
        FixPageTransformerViewPager r100 = this.f230745m;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r100 = null;
    L7:
        return Integer.valueOf(r100.getCurrentItem());
    }

    @Override // op5.a
    public final int b() {
        List<CommentBean> r100 = this.f230735c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // op5.a
    public final void f() {
        tt5.a.h("Comment#CommentPagerAdapter", "notifyDataSetChanged:");
        i(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.middleground.comment.card.CommentPagerAdapter$createWholeCommentTailDecoration$1] */
    public CommentPagerAdapter() {
        this.f230743k = new ArrayList();
        this.f230744l = new LinkedHashMap();
        this.f230749q = new CommentPagerAdapter$createWholeCommentTailDecoration$1(this);
        this.f230750r = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.doc.image_region_comment_view");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = ((LinkedHashMap) this.f230744l).get(r100);
        if ((r101 instanceof RecyclerView) == true) goto L8;
        return null;
    L8:
        return (RecyclerView) r101;
    }

    @Override // op5.a
    public final int c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator r101 = ((LinkedHashMap) this.f230744l).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        int r102 = ((Number) r101.next()).intValue();
        Map<Integer, View> r103 = this.f230744l;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        if (Intrinsics.areEqual(r104.get(Integer.valueOf(r102)), r100) == false) goto L4;
        List<CommentBean> r105 = this.f230735c;
        if (r105 == null) goto L10;
        int r106 = r105.size();
    L11:
        if (r102 >= r106) goto L4;
        return r102;
    L10:
        r106 = 0;
        goto L11
    L13:
        return -2;
    }

    public final void i(boolean r100) {
        tt5.a.h("Comment#CommentPagerAdapter", "notifyDataSetChanged:");
        Iterator r101 = ((LinkedHashMap) this.f230744l).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        int r102 = ((Number) r101.next()).intValue();
        List<CommentBean> r103 = this.f230735c;
        if (r103 == null) goto L8;
        int r104 = r103.size();
    L9:
        if (r102 >= r104) goto L4;
        Map<Integer, View> r105 = this.f230744l;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        Object r107 = r106.get(Integer.valueOf(r102));
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        j((RecyclerView) r107, r102, r100);
        goto L4
    L8:
        r104 = 0;
        goto L9
    L11:
        super.f();
    }

    @Override // op5.a
    public final Object d(ViewGroup r210, int r310) {
        Intrinsics.checkNotNullParameter(r210, KtvSubElement.CONTAINER);
        if (((ArrayList) this.f230743k).isEmpty() == true) goto L5;
        Object r100 = ListProtector.remove(this.f230743k, 0);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r101 = (RecyclerView) r100;
    L75:
        this.f230744l.put(Integer.valueOf(r310), r101);
        ViewGroup r102 = (ViewGroup) r101.getParent();
        if (r102 == null) goto L78;
        r102.removeView(r101);
    L78:
        r101.invalidateItemDecorations();
        j(r101, r310, true);
        r210.addView(r101);
        return r101;
    L5:
        Activity r103 = this.f230737e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r103 = null;
    L8:
        PointRecoderRecyclerView r104 = new PointRecoderRecyclerView(r103);
        r104.f448123h = false;
        final Activity r105 = this.f230737e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r105 = null;
    L11:
        r104.setLayoutManager(new CommentPagerAdapter$instantiateItem$recyclerView$1(r105));
        r104.addItemDecoration(this.f230749q);
        r104.setOverScrollMode(2);
        com.bytedance.ee.bear.middleground.comment.uitls.p r106 = this.f230736d;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r106 = null;
    L15:
        if (r106.f232243s == false) goto L20;
        if (this.f230750r == false) goto L20;
        r104.setItemViewCacheSize(8);
    L20:
        if (this.f230750r == false) goto L49;
        com.bytedance.ee.bear.middleground.comment.uitls.p r110 = this.f230736d;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r111 = null;
    L25:
        List<String> r107 = this.f230739g;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r112 = null;
    L29:
        com.bytedance.ee.bear.middleground.comment.control.z r108 = this.f230740h;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r113 = null;
    L33:
        com.bytedance.ee.bear.middleground.comment.control.y r109 = this.f230741i;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r114 = null;
    L37:
        SharePermissionViewModel r115 = this.f230746n;
        d r116 = this.f230747o;
        if (r116 != null) goto L40;
        r116 = new d();
    L40:
        d r117 = r116;
        String r118 = this.f230738f;
        if (r118 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r119 = null;
    L44:
        Function0<Unit> r120 = this.f230742j;
        if (r120 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r121 = null;
    L48:
        RecyclerView.Adapter r122 = new HalfScreenCardAdapter(r111, r112, r113, r114, r115, r117, r119, r121);
    L74:
        r104.setAdapter(r122);
        r104.setTouchViewListener(new f(this));
        r104.setItemAnimator(null);
        r104.addOnScrollListener(new CommentPagerAdapter$instantiateItem$recyclerView$3(this));
        r101 = r104;
        goto L75
    L47:
        r121 = r120;
        goto L48
    L43:
        r119 = r118;
        goto L44
    L36:
        r114 = r109;
        goto L37
    L32:
        r113 = r108;
        goto L33
    L28:
        r112 = r107;
        goto L29
    L24:
        r111 = r110;
        goto L25
    L49:
        com.bytedance.ee.bear.middleground.comment.uitls.p r123 = this.f230736d;
        if (r123 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r211 = null;
    L53:
        String r124 = this.f230738f;
        if (r124 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r212 = null;
    L57:
        List<String> r125 = this.f230739g;
        if (r125 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r213 = null;
    L61:
        com.bytedance.ee.bear.middleground.comment.control.z r126 = this.f230740h;
        if (r126 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r214 = null;
    L65:
        com.bytedance.ee.bear.middleground.comment.control.y r127 = this.f230741i;
        if (r127 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r215 = null;
    L69:
        Function0<Unit> r128 = this.f230742j;
        if (r128 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r216 = null;
    L73:
        r122 = new CardAdapter(r211, r212, r213, r214, r215, false, r216);
        goto L74
    L72:
        r216 = r128;
        goto L73
    L68:
        r215 = r127;
        goto L69
    L64:
        r214 = r126;
        goto L65
    L60:
        r213 = r125;
        goto L61
    L56:
        r212 = r124;
        goto L57
    L52:
        r211 = r123;
        goto L53
    }

    @Override // op5.a
    public final boolean e(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // op5.a
    public final void a(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r100.removeView((View) r102);
        this.f230744l.remove(Integer.valueOf(r101));
        ((ArrayList) this.f230743k).add(r102);
    }

    public final void j(final RecyclerView r100, int r101, final boolean r102) {
        tt5.a.b("Comment#CommentPagerAdapter", "notifyItemPageDataChanged: position = " + r101);
        List<CommentBean> r103 = this.f230735c;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        final CommentBean r104 = (CommentBean) ListProtector.get(r103, r101);
        Function0<List<CommentBean.CommentDetail>> r105 = new CommentPagerAdapter$notifyItemPageDataChanged$oldList$1(this, r100, r104, r102);
        CommentPagerAdapter$notifyItemPageDataChanged$oldList$2 r106 = new CommentPagerAdapter$notifyItemPageDataChanged$oldList$2(r100);
        Intrinsics.checkNotNullParameter(r105, "updateData");
        Intrinsics.checkNotNullParameter(r106, "refreshDecoration");
        List<CommentBean.CommentDetail> r107 = r105.invoke();
        r106.invoke();
        List<CommentBean.CommentDetail> r108 = r107;
        com.bytedance.ee.bear.middleground.comment.uitls.p r109 = this.f230736d;
        if (r109 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r109 = null;
    L5:
        r109.N.a(new ef5.x(r100, r104, r108));
    }

    public final void k(int r100, int r101, float r102) {
        RecyclerView r103 = P0(Integer.valueOf(r100));
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = null;
        if (r103 == null) goto L5;
        RecyclerView.Adapter r105 = r103.getAdapter();
    L7:
        if ((r105 instanceof CardAdapter2) == false) goto L9;
        CardAdapter2 r106 = (CardAdapter2) r105;
    L10:
        if (r106 != null) goto L13;
        return;
    L13:
        if (r102 >= 0.0f) goto L16;
        r102 = 0.0f;
    L18:
        com.bytedance.ee.bear.middleground.comment.uitls.p r107 = this.f230736d;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L22:
        RecyclerViewScrollHelper.SetSmoothScroller r108 = new RecyclerViewScrollHelper.SetSmoothScroller(r104.getActivity());
        r108.setTargetPosition(r101);
        r108.f232188a = -1;
        if (r102 >= 0.0f) goto L25;
    L28:
        RecyclerViewScrollHelper.b(P0(Integer.valueOf(r100)), r108);
        return;
    L25:
        if (r102 > 1.0f) goto L28;
        r108.f232191d = r102;
        goto L28
    L21:
        r104 = r107;
        goto L22
    L16:
        if (r102 <= 1.0f) goto L18;
        r102 = 1.0f;
        goto L18
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L7
    }
}
