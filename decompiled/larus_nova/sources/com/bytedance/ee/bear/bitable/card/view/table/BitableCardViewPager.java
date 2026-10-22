package com.bytedance.ee.bear.bitable.card.view.table;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.ScrollControlViewPager;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.trace.CopyContentTypeString;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public class BitableCardViewPager extends FrameLayout implements sa5.d, qq4.b {
    public final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableCardViewModel f208811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gp4.h f208812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xu5.b.a f208813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f208814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FixPageTransformerViewPager f208815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f208816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f208817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f208818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f208819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppCompatImageView f208820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AnimatorSet f208821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public cp4.b f208822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public cp4.a f208823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f208824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f208825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f208826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f208827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public jq4.l f208828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f208829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k f208830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<Function0<Unit>> f208831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.table.d f208832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f208833w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Boolean[] f208834x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CompositeDisposable f208835y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f208836z;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableCardViewPager f208837c;

        public b(BitableCardViewPager r100) {
            this.f208837c = r100;
            super(350);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f208837c.getMBitableCardDelegate().U();
            BitableCardViewPager r101 = this.f208837c;
            p r102 = r101.f208816f;
            boolean r103 = true;
            if (r102 == null) goto L5;
            r102.f208894o = true;
        L5:
            int r104 = r101.getMCurrentPos() - 1;
            cp4.a r105 = this.f208837c.getMCurrentRecord();
            if (r105 != null) goto L8;
        L13:
            boolean r106 = false;
        L14:
            cp4.b r107 = this.f208837c.getMCurrentTable();
            if (r107 == null) goto L51;
            List<cp4.a> r108 = r107.f464668l;
            if (r108 == null) goto L52;
            BitableCardViewPager r109 = this.f208837c;
            if (r108.size() > r104) goto L21;
        L26:
            if (r106 == true) goto L28;
        L32:
            cp4.a r110 = r109.getMCurrentRecord();
            if (r110 == null) goto L42;
            String r111 = r110.f464654u;
            if (r111 == null) goto L42;
            if (r111.length() <= 0) goto L39;
            boolean r112 = true;
        L40:
            if (r112 != true) goto L42;
        L43:
            if (r103 == false) goto L56;
            Context r113 = r109.getContext();
            cp4.a r114 = r109.getMCurrentRecord();
            if (r114 == null) goto L48;
            String r115 = r114.f464654u;
            if (r115 == null) goto L48;
        L49:
            Toast.showText(r113, r115);
            return;
        L48:
            r115 = "";
            goto L49
        L56:
            return;
        L39:
            r112 = false;
        L42:
            r103 = false;
            goto L43
        L28:
            if (r109.f208834x[0].booleanValue() == true) goto L32;
            BitableCardViewPager.a(r109);
            if (com.bytedance.ee.bear.bitable.c.z() == false) goto L54;
            Toast.showText(r109.getContext(), R.string.Bitable_Record_LoadingCannotView_Mobile);
            return;
        L54:
            return;
        L21:
            if (r109.getMCurrentPos() <= 0) goto L26;
            ((com.bytedance.ee.bear.bitable.statistic.c) r109.getMBitableCardViewModel().getMonitorTrace().f207166k.getValue()).a(5000);
            FixPageTransformerViewPager r116 = r109.f208815e;
            if (r116 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            r116 = null;
        L25:
            r116.w(r104, true);
            return;
        L52:
            return;
        L51:
            return;
        L8:
            if (r105.f464653t == true) goto L11;
            r106 = r105.f464651r;
            goto L14
        L11:
            if (r105.f464644k <= 0) goto L13;
            r106 = true;
            goto L14
        }
    }

    public static final class c extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableCardViewPager f208838c;

        public c(BitableCardViewPager r100) {
            this.f208838c = r100;
            super(350);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f208838c.getMBitableCardDelegate().U();
            BitableCardViewPager r101 = this.f208838c;
            p r102 = r101.f208816f;
            boolean r103 = true;
            if (r102 == null) goto L5;
            r102.f208894o = true;
        L5:
            int r104 = r101.getMCurrentPos() + 1;
            cp4.b r105 = this.f208838c.getMCurrentTable();
            if (r105 == null) goto L8;
            int r106 = r105.f464679w;
        L9:
            cp4.a r107 = this.f208838c.getMCurrentRecord();
            if (r107 != null) goto L12;
        L17:
            boolean r108 = false;
        L18:
            cp4.b r109 = this.f208838c.getMCurrentTable();
            if (r109 == null) goto L56;
            List<cp4.a> r110 = r109.f464668l;
            if (r110 == null) goto L57;
            BitableCardViewPager r111 = this.f208838c;
            if (r110.size() <= r104) goto L30;
            if (r104 <= 0) goto L30;
            ((com.bytedance.ee.bear.bitable.statistic.c) r111.getMBitableCardViewModel().getMonitorTrace().f207166k.getValue()).a(5000);
            FixPageTransformerViewPager r112 = r111.f208815e;
            if (r112 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            r112 = null;
        L28:
            r112.w(r104, true);
            return;
        L30:
            if (r110.size() != r104) goto L37;
            if (r108 == false) goto L37;
            if (r111.f208834x[1].booleanValue() == true) goto L37;
            BitableCardViewPager.c(r111);
            if (com.bytedance.ee.bear.bitable.c.z() == false) goto L59;
            Toast.showText(r111.getContext(), R.string.Bitable_Record_LoadingCannotView_Mobile);
            return;
        L59:
            return;
        L37:
            cp4.a r113 = r111.getMCurrentRecord();
            if (r113 == null) goto L47;
            String r114 = r113.f464655v;
            if (r114 == null) goto L47;
            if (r114.length() <= 0) goto L44;
            boolean r115 = true;
        L45:
            if (r115 != true) goto L47;
        L48:
            if (r103 == false) goto L61;
            Context r116 = r111.getContext();
            cp4.a r117 = r111.getMCurrentRecord();
            if (r117 == null) goto L53;
            String r118 = r117.f464655v;
            if (r118 == null) goto L53;
        L54:
            Toast.showText(r116, r118);
            return;
        L53:
            r118 = "";
            goto L54
        L61:
            return;
        L44:
            r115 = false;
        L47:
            r103 = false;
            goto L48
        L57:
            return;
        L56:
            return;
        L12:
            if (r107.f464653t == true) goto L15;
            r108 = r107.f464652s;
            goto L18
        L15:
            if ((r107.f464644k + 1) >= r106) goto L17;
            r108 = true;
            goto L18
        L8:
            r106 = 0;
            goto L9
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableCardViewPager f208839a;

        public d(BitableCardViewPager r100) {
            this.f208839a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FixPageTransformerViewPager r100 = this.f208839a.f208815e;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.A();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e extends com.bytedance.ee.util.ui.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f208840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableCardViewPager f208841b;

        @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f208840a == false) goto L5;
            this.f208841b.getClass();
            this.f208841b.m();
            return;
        L5:
            this.f208841b.f();
        }

        @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f208840a == true) goto L6;
            this.f208841b.getClass();
            return;
        }

        public e(boolean r100, BitableCardViewPager r101) {
            this.f208840a = r100;
            this.f208841b = r101;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableCardViewPager f208842a;

        public f(BitableCardViewPager r100) {
            this.f208842a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f208842a.f208821k.start();     // Catch: Throwable -> L4
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
    }

    public int getPageRecordLayoutId() {
        return R.layout.bitable_card_page_view_pager;
    }

    private final BitableCardDragLayout.b getMScrollInterceptor() {
        return (BitableCardDragLayout.b) this.f208833w.getValue();
    }

    public final void f() {
        tt5.a.h("BitableCardViewPager", "dismiss()...");
        rcb.c.c(getContext());
        this.f208812b.u(this);
        BitableCardViewModel r100 = this.f208811a;
        cp4.b r101 = this.f208822l;
        ETableType r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f464658b;
    L6:
        if (r101 == null) goto L8;
        String r104 = r101.f464660d;
    L9:
        if (r101 == null) goto L11;
        r102 = r101.f464675s;
    L11:
        r100.backwardTable(r103, r104, r102);
        BitableCardViewModel r105 = this.f208811a;
        cp4.b r106 = this.f208822l;
        if (r106 == null) goto L15;
        String r107 = r106.f464660d;
        if (r107 == null) goto L15;
    L16:
        r105.clearLinkTableDisposable(r107);
        this.f208835y.dispose();
        return;
    L15:
        r107 = "";
        goto L16
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // qq4.b
    public int getCurrentRecordIndex() {
        FixPageTransformerViewPager r100 = this.f208815e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r100 = null;
    L6:
        return r100.getCurrentItem();
    }

    public final String getFieldHiddenStatus() {
        cp4.b r100 = this.f208822l;
        if (r100 == null) goto L16;
        Map<String, fp4.g> r101 = r100.f464665i;
        if (r101 == null) goto L22;
        Iterator<Map.Entry<String, fp4.g>> r102 = r101.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        if (r102.next().getValue().f478260g == false) goto L8;
        if (r100.f464676t == false) goto L14;
        return "close";
    L14:
        return "open";
    L23:
        return "none";
    L22:
        return "none";
    L16:
        return "none";
    }

    public void h() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.f208811a.getFirstRecordPageDrew().observe(this.f208812b.getFragment().getViewLifecycleOwner(), new BitableCardViewPager$initSwitchVisibility$1(this));
        int r100 = 8;
        if (this.f208811a.isNormalRecordShow() == true) goto L8;
    L12:
        View r101 = this.f208818h;
        if (r101 != null) goto L15;
        return;
    L15:
        if (i() == true) goto L18;
        r100 = 0;
    L18:
        r101.setVisibility(r100);
        return;
    L8:
        if (Intrinsics.areEqual(this.f208811a.getFirstRecordPageDrew().getValue(), Boolean.FALSE) == false) goto L12;
        View r102 = this.f208818h;
        if (r102 == null) goto L20;
        r102.setVisibility(8);
        return;
    }

    public boolean i() {
        cp4.b r100 = this.f208822l;
        if (r100 == null) goto L5;
        boolean r101 = r100.g();
    L6:
        if (r101 == true) goto L20;
        cp4.a r102 = this.f208823m;
        if (r102 == null) goto L10;
        boolean r103 = r102.f464639f;
    L11:
        if (r103 == true) goto L20;
        if (this.f208811a.getIsShowInRecord() == true) goto L20;
        BitableCardViewModel r104 = this.f208811a;
        cp4.b r105 = this.f208822l;
        if (r105 == null) goto L17;
        ETableType r106 = r105.f464675s;
    L19:
        if (r104.isTableAddType(r106) == true) goto L20;
        return false;
    L17:
        r106 = null;
        goto L19
    L10:
        r103 = false;
    L20:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public void m() {
        this.f208812b.q0().E(getFieldHiddenStatus(), this.f208811a.getIsShowInRecord(), false);
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        cp4.b r100 = this.f208822l;
        if (r100 == null) goto L5;
        boolean r101 = r100.g();
    L6:
        if (r101 == false) goto L8;
        this.f208811a.cancelAddRecord();
        return true;
    L8:
        n(false);
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public void q() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        BitableCardViewModel r101 = this.f208811a;
        cp4.b r102 = this.f208822l;
        cp4.a r103 = this.f208823m;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.f464635b;
    L6:
        r101.notifyTableActiveRecordIdChanged(r102, r105);
        cp4.b r106 = this.f208822l;
        if (r106 == null) goto L9;
        ETableType r107 = r106.f464675s;
    L10:
        int r108 = 0;
        if (r107 != ETableType.LINK) goto L29;
        String[] r109 = this.f208811a.getLinkRecordIds(r106);
        if (r109 == null) goto L15;
        int r110 = RangesKt.coerceAtLeast(r109.length, 1);
    L16:
        cp4.a r111 = this.f208823m;
        if (r111 == null) goto L19;
        r104 = r111.f464635b;
    L19:
        if (r109 == null) goto L21;
        int r112 = ArraysKt.indexOf(r109, r104);
    L22:
        if (r112 <= 0) goto L24;
        boolean r113 = true;
    L26:
        if ((r112 + 1) >= r110) goto L28;
        boolean r114 = true;
    L80:
        tt5.a.h("BitableCardViewPager", "record_index=" + r112 + ". hasLeftMore:" + r113 + ". hasRightMore:" + r114);
        AppCompatImageView r115 = this.f208819i;
        if (r115 == null) goto L83;
        r115.setEnabled(r113);
    L83:
        AppCompatImageView r116 = this.f208820j;
        if (r116 == null) goto L86;
        r116.setEnabled(r114);
    L86:
        cp4.a r117 = this.f208823m;
        if (r117 != null) goto L89;
    L91:
        boolean r118 = false;
    L93:
        if (r118 == false) goto L97;
        TextView r119 = this.f208817g;
        if (r119 == null) goto L103;
        r119.setVisibility(8);
    L103:
        View r120 = this.f208818h;
        if (r120 != null) goto L106;
        return;
    L106:
        if (i() == false) goto L108;
        r108 = 8;
    L108:
        r120.setVisibility(r108);
        return;
    L97:
        TextView r121 = this.f208817g;
        if (r121 == null) goto L100;
        r121.setVisibility(0);
    L100:
        TextView r122 = this.f208817g;
        if (r122 == null) goto L103;
        StringBuilder r123 = new StringBuilder();
        r123.append(r112 + 1);
        r123.append('/');
        r123.append(r110);
        r122.setText(r123.toString());
        goto L103
    L89:
        if (r117.f464653t == true) goto L91;
        r118 = true;
        goto L93
    L28:
        r114 = false;
        goto L80
    L24:
        r113 = false;
        goto L26
    L21:
        r112 = 0;
        goto L22
    L15:
        r110 = 1;
        goto L16
    L29:
        if (r106 == null) goto L31;
        r110 = RangesKt.coerceAtLeast(r106.f464679w, 1);
    L32:
        cp4.a r124 = this.f208823m;
        if (r124 == null) goto L35;
        int r125 = r124.f464644k;
    L36:
        if (r124 != null) goto L38;
    L56:
        boolean r126 = false;
    L57:
        cp4.a r127 = this.f208823m;
        if (r127 != null) goto L60;
    L78:
        r114 = false;
    L79:
        int r128 = r125;
        r113 = r126;
        r112 = r128;
        goto L80
    L60:
        if (r127.f464653t == true) goto L63;
        boolean r129 = r127.f464652s;
    L66:
        if (r129 == true) goto L77;
        String r130 = r127.f464655v;
        if (r130 != null) goto L70;
    L75:
        boolean r131 = false;
    L76:
        if (r131 == false) goto L78;
    L70:
        if (r130.length() <= 0) goto L72;
        boolean r132 = true;
    L73:
        if (r132 != true) goto L75;
        r131 = true;
        goto L76
    L72:
        r132 = false;
    L77:
        r114 = true;
        goto L79
    L63:
        if ((r127.f464644k + 1) >= r110) goto L65;
        r129 = true;
        goto L66
    L65:
        r129 = false;
        goto L66
    L38:
        if (r124.f464653t == true) goto L41;
        boolean r133 = r124.f464651r;
    L44:
        if (r133 == true) goto L55;
        String r134 = r124.f464654u;
        if (r134 != null) goto L48;
    L53:
        boolean r135 = false;
    L54:
        if (r135 == false) goto L56;
    L48:
        if (r134.length() <= 0) goto L50;
        boolean r136 = true;
    L51:
        if (r136 != true) goto L53;
        r135 = true;
        goto L54
    L50:
        r136 = false;
    L55:
        r126 = true;
        goto L57
    L41:
        if (r124.f464644k <= 0) goto L43;
        r133 = true;
        goto L44
    L43:
        r133 = false;
        goto L44
    L35:
        r125 = 0;
        goto L36
    L31:
        r110 = 1;
        goto L32
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    private final int getLayoutId() {
        return getPageRecordLayoutId();
    }

    public void g() {
        this.f208817g = (TextView) findViewById(R.id.record_index);
        FixPageTransformerViewPager r100 = this.f208815e;
        ScrollControlViewPager r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r100 = null;
    L6:
        if ((r100 instanceof ScrollControlViewPager) == false) goto L8;
        r101 = (ScrollControlViewPager) r100;
    L8:
        if (r101 == null) goto L10;
        r101.setCanScroll(false);
    L10:
        this.f208818h = findViewById(R.id.switch_card_view);
        AppCompatImageView r102 = (AppCompatImageView) findViewById(R.id.pre_record);
        this.f208819i = r102;
        if (r102 == null) goto L13;
        r102.setOnClickListener(new b(this));
    L13:
        AppCompatImageView r103 = (AppCompatImageView) findViewById(R.id.next_record);
        this.f208820j = r103;
        if (r103 == null) goto L17;
        r103.setOnClickListener(new c(this));
        return;
    }

    public final gp4.h getMBitableCardDelegate() {
        return this.f208812b;
    }

    public final BitableCardViewModel getMBitableCardViewModel() {
        return this.f208811a;
    }

    public final int getMCurrentPos() {
        return this.f208824n;
    }

    public final cp4.a getMCurrentRecord() {
        return this.f208823m;
    }

    public final cp4.b getMCurrentTable() {
        return this.f208822l;
    }

    public final View getMSwitchCardView() {
        return this.f208818h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public static final void a(BitableCardViewPager r100) {
        r100.getClass();
        tt5.a.h("BitableCardViewPager_async", "fetchRecordsPagingLeft");
        r100.f208834x[0] = Boolean.TRUE;
        Disposable r101 = r100.f208811a.fetchRecordsPagingLeft().subscribe(new com.bytedance.ee.bear.bitable.card.view.table.e(r100), new com.bytedance.ee.bear.bitable.card.view.table.f(r100));
        r100.f208835y.add(r101);
    }

    public static final void c(BitableCardViewPager r100) {
        r100.getClass();
        tt5.a.h("BitableCardViewPager_async", "fetchRecordsPagingRight");
        r100.f208834x[1] = Boolean.TRUE;
        Disposable r101 = r100.f208811a.fetchRecordsPagingRight().subscribe(new g(r100), new h(r100));
        r100.f208835y.add(r101);
    }

    private final void setBackgroundAlpha(float r100) {
        View r101 = this.f208814d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        r101 = null;
    L5:
        r101.getBackground().setAlpha((int) (255 * r100));
        setStatusBarAlpha(r100);
    }

    private final void setCurrentRecordView(jq4.l r100) {
        jq4.l r101 = this.f208828r;
        if (r100 == r101) goto L11;
        if (r101 == null) goto L6;
        r101.m(this.f208830t);
    L6:
        if (r100 == null) goto L8;
        r100.e(this.f208830t);
    L9:
        this.f208828r = r100;
        return;
    L8:
        r100 = null;
        goto L9
    }

    private final void setStatusBarAlpha(float r100) {
        xu5.b.a r101 = this.f208813c;
        if (r101 == null) goto L14;
        int r102 = (int) (r100 * 255);
        Resources r103 = getResources();
        cp4.b r104 = this.f208822l;
        if (r104 == null) goto L7;
        ETableType r105 = r104.f464675s;
    L9:
        if (r105 != ETableType.LINK) goto L11;
        int r106 = R.color.bg_body;
    L12:
        r101.b(ColorUtils.c(r102, r103.getColor(r106)), !h18.f.a(eu5.b.f474075a));
        return;
    L11:
        r106 = R.color.bg_base;
        goto L12
    L7:
        r105 = null;
        goto L9
    }

    @Override // qq4.b
    public final void d(String r100) {
        jq4.l r101 = this.f208828r;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void j(cp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
        tt5.a.h("BitableCardViewPager", "notifyDataChanged begin " + this.f208822l + ", " + r100);
        this.f208822l = r100;
        boolean r101 = true;
        if (this.A == true) goto L5;
    L9:
        cp4.b r102 = this.f208822l;
        ETableType r103 = null;
        if (r102 == null) goto L12;
        List<cp4.a> r104 = r102.f464668l;
    L13:
        int r105 = com.bytedance.ee.bear.bitable.c.f207079a;
        cp4.a r106 = this.f208823m;
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L39;
        cp4.a r108 = this.f208823m;
        if (r108 == null) goto L39;
        cp4.b r109 = this.f208822l;
        if (r109 == null) goto L27;
        r103 = r109.f464675s;
    L27:
        if (r103 != ETableType.LINK) goto L39;
        if (r104 != null) goto L30;
    L32:
        boolean r110 = false;
    L33:
        if (r110 == false) goto L39;
        if (this.f208826p == false) goto L37;
        tt5.a.h("BitableCardViewPager", "current showing record has been deleted");
        Toast.showText(getContext(), R.string.Bitable_Record_DeletedByOtherUser);
        n(false);
    L38:
        boolean r111 = true;
    L40:
        if (r111 == false) goto L43;
        return;
    L43:
        if (r100.f464678v != AsyncFetchResult.EResultState.LOADED) goto L53;
        List<cp4.a> r112 = r100.f464668l;
        if (r112 != null) goto L47;
    L50:
        if (r101 == false) goto L53;
        tt5.a.d("BitableCardViewPager", "notifyDataChanged()... records can not be empty!");
        int r113 = com.bytedance.ee.bear.bitable.card.performance.c.f207188l;
        com.bytedance.ee.bear.bitable.card.performance.c.b.f207189a.a(this.f208812b.a(), "native_fetch_table_data_records_empty", "records is empty when refresh card");
        return;
    L47:
        if (r112.isEmpty() == true) goto L50;
        r101 = false;
    L53:
        r(new BitableCardViewPager$notifyDataChanged$1(this));
        return;
    L37:
        this.f208832v = new com.bytedance.ee.bear.bitable.card.view.table.d(this);
        goto L38
    L30:
        if (r104.contains(r108) == true) goto L32;
        r110 = true;
    L39:
        r111 = false;
        goto L40
    L16:
        if (r106.f464635b.startsWith("MOCK_") != true) goto L18;
        r107 = true;
        goto L19
    L12:
        r104 = null;
        goto L13
    L5:
        if (this.f208811a.isNormalRecordShow() == false) goto L9;
        if (Intrinsics.areEqual(this.f208811a.getFirstRecordPageDrew().getValue(), Boolean.FALSE) == false) goto L9;
        this.f208827q = true;
        goto L9
    }

    public final void l(List<? extends cp4.a> r100) {
        StringBuilder r101 = new StringBuilder("onDataChanged mCurrentPos=");
        r101.append(this.f208824n);
        r101.append(" activeIndex=");
        cp4.b r102 = this.f208822l;
        FixPageTransformerViewPager r103 = null;
        FixPageTransformerViewPager r104 = null;
        cp4.a r105 = null;
        if (r102 == null) goto L5;
        Integer r106 = Integer.valueOf(r102.b());
    L6:
        r101.append(r106);
        r101.append(" size=");
        cp4.b r107 = this.f208822l;
        if (r107 == null) goto L11;
        List<cp4.a> r108 = r107.f464668l;
        if (r108 == null) goto L11;
        Integer r109 = Integer.valueOf(r108.size());
    L12:
        r101.append(r109);
        r101.append(" activeRecordId=");
        cp4.b r110 = this.f208822l;
        if (r110 == null) goto L15;
        String r111 = r110.f464669m;
    L16:
        r101.append(r111);
        tt5.a.h("BitableCardViewPager_async", r101.toString());
        p r112 = this.f208816f;
        boolean r113 = true;
        if (r112 == null) goto L33;
        cp4.b r114 = this.f208822l;
        if (r114 == null) goto L22;
        AsyncFetchResult.EResultState r115 = r114.f464678v;
        if (r115 == null) goto L22;
    L23:
        tt5.a.b("RecordPageAdapter", "updateRecords, records = " + r100);
        r112.f208886g = (ArrayList) r112.f208884e.clone();
        r112.f208887h = (AsyncFetchResult.EResultState[]) r112.f208885f.clone();
        r112.f208884e.clear();
        if (r100 == null) goto L29;
        if (r100.size() <= 0) goto L29;
        r112.f208884e.addAll(r100);
    L29:
        if (r112.f208884e.isEmpty() == false) goto L31;
        r112.f208885f[0] = r115;
    L32:
        r112.f();
        goto L33
    L31:
        AsyncFetchResult.EResultState[] r116 = r112.f208885f;
        AsyncFetchResult.EResultState r117 = AsyncFetchResult.EResultState.LOADED;
        r116[0] = r117;
        r116[1] = r117;
    L22:
        r115 = AsyncFetchResult.EResultState.LOADED;
    L33:
        if (r100 == null) goto L35;
        int r118 = r100.size();
    L36:
        cp4.b r119 = this.f208822l;
        if (r119 == null) goto L39;
        AsyncFetchResult.EResultState r120 = r119.f464678v;
    L41:
        if (r120 == AsyncFetchResult.EResultState.LOADED) goto L43;
    L60:
        if (r118 != 1) goto L65;
        this.f208824n = 0;
        if (r100 == null) goto L64;
        r105 = (cp4.a) ListProtector.get(r100, 0);
    L64:
        this.f208823m = r105;
    L87:
        q();
        this.f208811a.getIsShowInRecord();
        cp4.b r121 = this.f208822l;
        if (r121 != null) goto L90;
    L92:
        r113 = false;
    L93:
        if (r113 == false) goto L96;
        getMScrollInterceptor();
        return;
    L96:
        return;
    L90:
        if (r121.f464677u != true) goto L92;
    L65:
        cp4.a r122 = this.f208823m;
        if (r122 == null) goto L87;
        String r123 = r122.f464635b;
        if (r123 == null) goto L87;
        if (r119 == null) goto L87;
        cp4.a r124 = r119.e(r123);
        if (r124 == null) goto L87;
        this.f208823m = r124;
        cp4.b r125 = this.f208822l;
        if (r125 == null) goto L87;
        List<cp4.a> r126 = r125.f464668l;
        if (r126 == null) goto L87;
        int r127 = Integer.valueOf(r126.indexOf(r124)).intValue();
        if (r127 == this.f208824n) goto L79;
        boolean r128 = true;
    L80:
        this.f208824n = r127;
        if (r128 == false) goto L87;
        FixPageTransformerViewPager r129 = this.f208815e;
        if (r129 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L86:
        r103.w(r127, false);
        goto L87
    L85:
        r103 = r129;
        goto L86
    L79:
        r128 = false;
        goto L80
    L43:
        if (this.f208827q == false) goto L60;
        if (r118 <= 1) goto L60;
        if (r119 == null) goto L47;
        int r130 = r119.b();
    L48:
        this.f208824n = r130;
        cp4.b r131 = this.f208822l;
        if (r131 == null) goto L55;
        List<cp4.a> r132 = r131.f464668l;
        if (r132 == null) goto L55;
        int r133 = r132.size();
        int r134 = this.f208824n;
        if (r133 <= r134) goto L55;
        this.f208823m = (cp4.a) ListProtector.get(r132, r134);
    L55:
        FixPageTransformerViewPager r135 = this.f208815e;
        if (r135 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L59:
        r104.w(this.f208824n, false);
        this.f208827q = false;
        goto L87
    L58:
        r104 = r135;
        goto L59
    L47:
        r130 = 0;
        goto L48
    L39:
        r120 = null;
        goto L41
    L35:
        r118 = 0;
        goto L36
    L15:
        r111 = null;
    L11:
        r109 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }

    public final void n(boolean r100) {
        if (this.f208821k.isRunning() == false) goto L6;
        return;
    L6:
        if (this.f208811a.getIsShowInRecord() != true) goto L10;
        if (r100 == true) goto L10;
        f();
        return;
    L10:
        this.f208821k.setDuration(300);
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        View r104 = this.f208814d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        r104 = null;
    L13:
        float[] r105 = new float[2];
        float r106 = 0.0f;
        if (r100 == false) goto L16;
        float r107 = r103;
    L17:
        r105[0] = r107;
        if (r100 == false) goto L20;
        r103 = 0.0f;
    L20:
        r105[1] = r103;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, r105);
        float[] r109 = new float[2];
        if (r100 == false) goto L23;
        float r110 = 0.0f;
    L24:
        r109[0] = r110;
        if (r100 == false) goto L27;
        r106 = 1.0f;
    L27:
        r109[1] = r106;
        ObjectAnimator.ofFloat(this, "alpha", r109);
        this.f208821k.play(r108);
        this.f208821k.addListener(new e(r100, this));
        int r111 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (r100 == false) goto L30;
        com.bytedance.ee.util.ui.j.c(new f(this));
        return;
    L30:
        this.f208821k.start();
        return;
    L23:
        r110 = 1.0f;
        goto L24
    L16:
        r107 = 0.0f;
        goto L17
    }

    @Override // qq4.b
    public final boolean o(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        cp4.b r102 = this.f208822l;
        if (r102 == null) goto L14;
        String r103 = r102.f464660d;
    L16:
        return Intrinsics.areEqual(r100, r103);
    L14:
        r103 = null;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        FixPageTransformerViewPager r101 = this.f208815e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r101 = null;
    L5:
        r101.post(new d(this));
    }

    public final void r(Function0<Unit> r100) {
        if (this.f208825o != 0) goto L5;
        r100.invoke();
        return;
    L5:
        ((ArrayList) this.f208831u).add(r100);
    }

    public void setData(cp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
        tt5.a.h("BitableCardViewPager", "setData()...");
        this.f208822l = r100;
        if (r100.f464678v != AsyncFetchResult.EResultState.LOADED) goto L16;
        List<cp4.a> r101 = r100.f464668l;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        if (this.f208811a.isNormalRecordShow() == true) goto L16;
        tt5.a.d("BitableCardViewPager", "setData()... records can not be empty!");
        Toast.showFailureText(getContext(), R.string.Bitable_Error_SyetemErrorCommonTips_Mobile);
        int r103 = com.bytedance.ee.bear.bitable.card.performance.c.f207188l;
        com.bytedance.ee.bear.bitable.card.performance.c.b.f207189a.a(this.f208812b.a(), "native_fetch_table_data_records_empty", "records is empty when open card");
        f();
        return;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
    L16:
        tt5.a.h("BitableCardViewPager", "onBindData()...");
        cp4.b r104 = this.f208822l;
        FixPageTransformerViewPager r105 = null;
        if (r104 == null) goto L19;
        String r106 = r104.f464661e;
    L21:
        if (TextUtils.isEmpty(r106) == true) goto L23;
    L25:
        BitableCardViewModel r107 = this.f208811a;
        gp4.h r108 = this.f208812b;
        i r109 = new i(this);
        cp4.b r110 = this.f208822l;
        if (r110 == null) goto L28;
        String r111 = r110.f464669m;
    L29:
        p r112 = new p(r107, r108, r109, r111);
        this.f208816f = r112;
        r112.f208888i = new BitableCardViewPager$onBindData$2(this);
        FixPageTransformerViewPager r113 = this.f208815e;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r113 = null;
    L32:
        r113.setAdapter(this.f208816f);
        FixPageTransformerViewPager r114 = this.f208815e;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r114 = null;
    L35:
        r114.y(new z());
        FixPageTransformerViewPager r115 = this.f208815e;
        if (r115 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L39:
        r105.b(new j(this));
        cp4.b r116 = this.f208822l;
        if (r116 == null) goto L42;
        l(r116.f464668l);
    L42:
        this.f208830t = new k(this);
        if (this.f208812b.N() == true) goto L45;
        n(true);
    L45:
        h();
        return;
    L38:
        r105 = r115;
        goto L39
    L28:
        r111 = null;
        goto L29
    L23:
        if (this.f208836z == false) goto L25;
        getContext().getString(R.string.Bitable_AdvancedPermission_NotAccessibleTable);
        goto L25
    L19:
        r106 = null;
        goto L21
    }

    public final void setMCurrentPos(int r100) {
        this.f208824n = r100;
    }

    public final void setMCurrentRecord(cp4.a r100) {
        this.f208823m = r100;
    }

    public final void setMCurrentTable(cp4.b r100) {
        this.f208822l = r100;
    }

    public final void setMSwitchCardView(View r100) {
        this.f208818h = r100;
    }

    public void setSwitchCardViewVisibleOnScroll(boolean r100) {
        View r101 = this.f208818h;
        if (r101 == null) goto L12;
        if (r100 == false) goto L6;
    L9:
        int r102 = 8;
    L10:
        r101.setVisibility(r102);
        return;
    L6:
        if (i() == true) goto L9;
        r102 = 0;
        goto L10
    }

    public final void setUserVisibleHint(boolean r100) {
        this.f208826p = r100;
        if (r100 == false) goto L9;
        com.bytedance.ee.bear.bitable.card.view.table.d r101 = this.f208832v;
        if (r101 == null) goto L7;
        r101.run();
    L7:
        this.f208832v = null;
        return;
    }

    public static final /* synthetic */ void e(BitableCardViewPager r100, jq4.l r101) {
        r100.setCurrentRecordView(r101);
    }

    @Override // qq4.b
    public final void b(EFieldUIType r100, String r101) {
        p r102 = this.f208816f;
        if (r102 == null) goto L8;
        jq4.l r103 = r102.f208890k;
        if (r103 == null) goto L9;
        r103.b(r100, r101);
        return;
    L9:
        return;
    }

    @Override // qq4.b
    public final void k(String r100, String r101) {
        cp4.b r102 = this.f208822l;
        int r103 = 0;
        if (r102 == null) goto L26;
        List<cp4.a> r104 = r102.f464668l;
        if (r104 == null) goto L26;
        Iterator<cp4.a> r105 = r104.iterator();
        int r106 = 0;
    L8:
        if (r105.hasNext() == false) goto L25;
        cp4.a r107 = r105.next();
        if (TextUtils.equals(r107.f464635b, r100) == false) goto L21;
        if (r101 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
    L20:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L23;
        r106 = r106 + 1;
        goto L8
    L23:
        r103 = r106;
        goto L26
    L19:
        if (TextUtils.equals(r107.f464645l, r101) == false) goto L21;
    L13:
        if (r101.length() == 0) goto L16;
        r108 = false;
    L21:
        r109 = false;
        goto L22
    L25:
        r103 = -1;
    L26:
        tt5.a.b("BitableCardViewPager", "setCurrentRecordIndex recordId=" + r100 + " recordIndex=" + r103 + " groupId=" + r101 + ' ');
        FixPageTransformerViewPager r110 = this.f208815e;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r110 = null;
    L29:
        r110.w(r103, true);
    }

    @Override // qq4.b
    public final boolean p(String r100, String r101) {
        cp4.b r102 = this.f208822l;
        Object r103 = null;
        if (r102 == null) goto L25;
        List<cp4.a> r104 = r102.f464668l;
        if (r104 == null) goto L25;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L24;
        Object r106 = r105.next();
        cp4.a r107 = (cp4.a) r106;
        if (TextUtils.equals(r107.f464635b, r100) == false) goto L21;
        if (r101 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
    L20:
        boolean r109 = true;
    L22:
        if (r109 == false) goto L8;
        r103 = r106;
        goto L24
    L19:
        if (TextUtils.equals(r107.f464645l, r101) == false) goto L21;
    L13:
        if (r101.length() == 0) goto L16;
        r108 = false;
    L21:
        r109 = false;
    L24:
        r103 = (cp4.a) r103;
    L25:
        if (r103 != null) goto L34;
        return false;
    L34:
        return true;
    }

    public BitableCardViewPager(Context r100, BitableCardViewModel r101, gp4.h r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mBitableCardViewModel");
        Intrinsics.checkNotNullParameter(r102, "mBitableCardDelegate");
        super(r100);
        this.f208811a = r101;
        this.f208812b = r102;
        this.f208821k = new AnimatorSet();
        this.f208827q = true;
        this.f208831u = new ArrayList();
        this.f208833w = LazyKt.lazy(new BitableCardViewPager$mScrollInterceptor$2(this));
        Boolean r103 = Boolean.FALSE;
        this.f208834x = new Boolean[]{r103, r103};
        this.f208835y = new CompositeDisposable();
        com.bytedance.ee.bear.appsetting.c r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f208836z = r104.h("ccm.bitable.mobile.support_remote_compute");
        this.A = r104.h("bitable.record_card.ttv_opt.enable");
        r102.K(this);
        tt5.a.h("BitableCardViewPager", "onCreateView()...");
        View r105 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        r105.setBackgroundColor(r105.getResources().getColor(R.color.bg_base));
        r105.setClickable(true);
        this.f208814d = r105;
        r105.getBackground().mutate();
        this.f208815e = (FixPageTransformerViewPager) findViewById(R.id.bitable_card_view_pager);
        g();
        this.f208813c = xu5.b.b(r102.getActivity(), null);
        r101.getIsShowInRecord();
    }
}
