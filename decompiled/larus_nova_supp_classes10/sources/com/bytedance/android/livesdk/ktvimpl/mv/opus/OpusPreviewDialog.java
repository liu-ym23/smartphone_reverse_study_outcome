package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import com.bytedance.android.live.ktv.common.view.h;
import com.bytedance.android.live.ktv.common.view.viewholder.OpusPreviewViewHolder;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.i;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.view.OpusPreviewErrorView;
import com.bytedance.android.livesdk.message.model.KtvTypetv;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.x8;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusPreviewDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/i;", "Lcom/bytedance/android/livesdk/message/model/od;", "", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewDialog extends BaseKtvDialogFragment implements i<od> {
    public final g A;
    public final k B;
    public final KtvMvPlayer g;
    public OpusPreviewErrorView h;
    public Function2<? super Integer, ? super Boolean, Unit> i;
    public Function2<? super String, ? super Boolean, Unit> j;
    public Function3<? super String, ? super Boolean, ? super Boolean, Unit> k;
    public View l;
    public CommomKtvButton m;
    public final f n;
    public IMvPreviewViewHolder<od> o;
    public Pair<Integer, od> p;
    public IMvPreviewViewHolder<od> q;
    public OpusPreviewViewModel r;
    public final ArrayList<OpusPreviewViewHolder> s;
    public com.bytedance.android.live.ktv.common.view.i t;
    public Function1<? super k, Boolean> u;
    public FrameLayout v;
    public Function0<Unit> w;
    public final OpusPreviewDialog$previewListViewHolderProvider$1 x;
    public final int y;
    public boolean z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OpusPreviewDialog a;

        public b(OpusPreviewDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            OpusPreviewDialog r0 = this.a;
            r0.aa0((List) r3, KtvTypetv.KTVMVType_OFFICIAl.ordinal());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ OpusPreviewDialog a;

        public c(OpusPreviewDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            OpusPreviewDialog r0 = this.a;
            r0.aa0((ArrayList) r3, KtvTypetv.KTVMVType_PERSONAL.ordinal());
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ OpusPreviewDialog a;

        public d(OpusPreviewDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            od r6 = (od) r5;
            Iterator<OpusPreviewViewHolder> r0 = this.a.s.iterator();
        L4:
            if (r0.hasNext() == false) goto L15;
            OpusPreviewViewHolder r1 = r0.next();
            if (Intrinsics.areEqual(r6, r1.g) == true) goto L7;
            r1.W3();
            goto L4
        L7:
            ((RecyclerView.ViewHolder) r1).itemView.performClick();
            OpusPreviewDialog r2 = this.a;
            Function1<? super k, Boolean> r3 = r2.u;
            if (r3 == null) goto L12;
            boolean r4 = ((Boolean) r3.invoke(r2.B)).booleanValue();
            boolean r7 = true;
            if (r4 != true) goto L12;
        L13:
            r1.X3(r7);
        L12:
            r7 = false;
            goto L13
        L15:
            OpusPreviewDialog r8 = this.a;
            Pair<Integer, od> r9 = r8.p;
            if (r9 == null) goto L18;
            od r10 = (od) r9.getSecond();
        L19:
            r8.Y90(Intrinsics.areEqual(r6, r10));
            return;
        L18:
            r10 = null;
            goto L19
        }
    }

    static {
    }

    public final String S90() {
        return "MvCoverPreviewDialog";
    }

    public final int getLayoutId() {
        return 0;
    }

    public final View getContentView() {
        final Context r1 = getContext();
        View r6 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        this.r = ViewModelProviders.of(this, new OpusPreviewDialog$initViewModel$1(this)).get(OpusPreviewViewModel.class);
        LinearLayout r7 = new LinearLayout(r1);
        r7.setOrientation(1);
        r7.setGravity(17);
        r7.setBackgroundResource(2131247401);
        Intrinsics.checkNotNullParameter(r1, "context");
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setGravity(17);
        r2.setHorizontalGravity(17);
        TextView r3 = new TextView(r1);
        r3.setText(2131920648);
        r3.setTextColor(-16777216);
        r3.setTextSize(1, 16.0f);
        Unit r4 = Unit.INSTANCE;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        r5.topMargin = s1.f(13.0f);
        r5.bottomMargin = s1.f(13.0f);
        r2.addView(r3, r5);
        View r0 = new View(r1);
        r0.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r2.addView(r0, new LinearLayout.LayoutParams(-1, 1));
        r7.addView(r2);
        FrameLayout r12 = new FrameLayout(r1);
        this.v = r12;
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OpusPreviewViewModel r8 = this.r;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L8:
        final h r13 = new h(r1, r8);
        com.bytedance.android.live.ktv.common.view.i r14 = new com.bytedance.android.live.ktv.common.view.i(r1, r13.d, this.x, this, new OpusPreviewDialog$getContentView$$inlined$apply$lambda$1(r13, this, r1));
        this.t = r14;
        Intrinsics.checkNotNullParameter(r14, "p");
        r13.c.add(r14);
        ViewGroup r9 = r13.b;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L11:
        r9.addView(((com.bytedance.android.live.ktv.common.view.g) r14).d);
        NestedScrollView r10 = r13.a;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
    L14:
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(550.0f)));
        FrameLayout r11 = this.v;
        if (r11 == null) goto L17;
        r11.addView(r10);
    L17:
        Context r15 = getContext();
        if (r15 == null) goto L21;
        FrameLayout r16 = new FrameLayout(r15);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-1, s1.f(85.0f));
        r17.gravity = 80;
        r16.setLayoutParams(r17);
        r16.setBackgroundColor(-16777216);
        TextView r18 = new TextView(r15);
        r18.setText(s1.B(2131918505));
        r18.setTextColor(-1);
        this.l = r18;
        r18.setTextSize(1, 15.0f);
        int r19 = s1.f(5.0f);
        r18.setPadding(r19, r19, r19, r19);
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-2, -2);
        r20.gravity = 19;
        r20.leftMargin = s1.f(10.0f);
        r18.setLayoutParams(r20);
        r18.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.mv.opus.a(this));
        r16.addView(r18);
        CommomKtvButton r21 = new CommomKtvButton(r15);
        r21.setText(s1.B(2131918501));
        this.m = r21;
        r21.setTextSize(1, 15.0f);
        r21.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.mv.opus.b(this));
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(s1.f(140.0f), s1.f(38.0f));
        r22.gravity = 21;
        r22.rightMargin = s1.f(10.0f);
        r16.addView(r21, r22);
        r6 = r16;
    L21:
        if (r6 == null) goto L23;
        r12.addView(r6);
    L23:
        r7.addView(r12);
        return r7;
    }

    public static View X90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void Y90(boolean r5) {
        if (this.z != r5) goto L5;
        return;
    L5:
        View r0 = this.l;
        float r1 = 1.0f;
        if (r0 == null) goto L11;
        if (r5 == false) goto L9;
        float r3 = 0.4f;
    L10:
        r0.setAlpha(r3);
        goto L11
    L9:
        r3 = 1.0f;
    L11:
        CommomKtvButton r2 = this.m;
        if (r2 == null) goto L16;
        if (r5 == false) goto L15;
        r1 = 0.4f;
    L15:
        r2.setAlpha(r1);
    L16:
        this.z = r5;
    }

    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        Dialog r11 = getDialog();
        boolean r0 = true;
        if (r11 == null) goto L18;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        int r4 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L16:
        r12.setLayout(r4, -1);
        goto L18
    L15:
        r4 = -1;
        goto L16
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r3 = false;
    L18:
        if (PadConfigUtils.c() == false) goto L85;
        Dialog r13 = getDialog();
        View r5 = null;
        if (r13 == null) goto L41;
        RadiusLayout r6 = r13.findViewById(2131389519);
        if (r6 == null) goto L41;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = -2;
        r7.width = -1;
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L26;
        ViewGroup.LayoutParams r2 = null;
    L27:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r2;
        if (r8 == null) goto L31;
        r8.setMargins(0, 0, 0, 0);
    L31:
        if ((r7 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        ViewGroup.LayoutParams r9 = null;
    L34:
        CoordinatorLayout.LayoutParams r14 = (CoordinatorLayout.LayoutParams) r9;
        if (r14 == null) goto L38;
        r14.gravity = 85;
    L38:
        if ((r6 instanceof RadiusLayout) == false) goto L40;
        r6.setMaxHeight(0);
    L40:
        r6.setLayoutParams(r7);
        goto L41
    L33:
        r9 = r7;
        goto L34
    L26:
        r2 = r7;
    L41:
        if (r13 == null) goto L46;
        Window r15 = r13.getWindow();
        if (r15 == null) goto L46;
        r15.setNavigationBarColor(s1.h(2131106784));
    L46:
        if (s1.getResources().getConfiguration().orientation == 2) goto L49;
        r0 = false;
    L49:
        if (r0 == false) goto L79;
        if (r13 == null) goto L54;
        View r1 = r13.findViewById(2131389483);
        if (r1 == null) goto L54;
        r1.setFitsSystemWindows(false);
        r1.setPadding(0, 0, 0, 0);
    L54:
        if (r13 == null) goto L58;
        View r16 = r13.findViewById(2131389519);
        if (r16 == null) goto L58;
        r16.setFitsSystemWindows(false);
        r16.setPadding(0, 0, 0, 0);
    L58:
        if (r13 == null) goto L64;
        Window r17 = r13.getWindow();
        if (r17 == null) goto L64;
        View r18 = X90(r17);
        if (r18 == null) goto L64;
        r18.setFitsSystemWindows(false);
        r18.setPadding(0, 0, 0, 0);
    L64:
        if (r13 == null) goto L68;
        Window r19 = r13.getWindow();
        if (r19 == null) goto L68;
        View r20 = X90(r19);
    L70:
        if ((r20 instanceof ViewGroup) == false) goto L73;
        r5 = r20;
    L73:
        ViewGroup r21 = (ViewGroup) r5;
        if (r21 == null) goto L78;
        View r22 = r21.getChildAt(0);
        if (r22 == null) goto L78;
        r22.setFitsSystemWindows(false);
        r22.setPadding(0, 0, 0, 0);
    L78:
        x8.b(r13);
    L68:
        r20 = null;
    L79:
        if (r13 == null) goto L85;
        Window r110 = r13.getWindow();
        if (r110 == null) goto L85;
        View r111 = X90(r110);
        if (r111 == null) goto L85;
        r111.invalidate();
    L85:
        Dialog r112 = getDialog();
        if (r112 == null) goto L91;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L92;
        r113.setGravity(85);
        return;
    L92:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public OpusPreviewDialog(g r4, k r5) {
        Intrinsics.checkNotNullParameter(r4, "opusServie");
        Intrinsics.checkNotNullParameter(r5, "songInfo");
        this.A = r4;
        this.B = r5;
        KtvMvPlayer r0 = new KtvMvPlayer(jc1.a.b(), null);
        r0.setLooping(true);
        r0.o().setIsMute(true);
        Unit r1 = Unit.INSTANCE;
        this.g = r0;
        this.n = r4.l(r5.e, r5.f);
        this.s = new ArrayList();
        this.x = new OpusPreviewDialog$previewListViewHolderProvider$1(this);
        this.y = 3;
    }

    public final boolean G70(int r2, Object r3) {
        od r4 = (od) r3;
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.INFO);
        Pair<Integer, od> r0 = this.p;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (((Number) r0.getFirst()).intValue() != r2) goto L13;
        Pair<Integer, od> r5 = this.p;
        if (r5 == null) goto L9;
        od r6 = (od) r5.getSecond();
    L11:
        if (Intrinsics.areEqual(r6, r4) == false) goto L13;
        return true;
    L9:
        r6 = null;
        goto L11
    }

    public final void Z90(IMvPreviewViewHolder<od> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "vh");
        Pair<Integer, od> r8 = this.p;
        if (r8 == null) goto L5;
        od r9 = (od) r8.getSecond();
    L7:
        if (Intrinsics.areEqual(r9, (od) this.n.e().getValue()) == false) goto L9;
        return;
    L9:
        Function1<? super k, Boolean> r0 = this.u;
        if (r0 == null) goto L14;
        boolean r1 = true;
        if (((Boolean) r0.invoke(this.B)).booleanValue() != true) goto L14;
    L15:
        if (r9 == null) goto L19;
        this.A.e(this.B, r9.f(), r9.e(), r1);
        Function3<? super String, ? super Boolean, ? super Boolean, Unit> r2 = this.k;
        if (r2 == null) goto L19;
        Unit r10 = (Unit) r2.invoke(r9.f(), Boolean.valueOf(r9.g()), Boolean.valueOf(r7));
    L19:
        if (r1 == false) goto L29;
        dismiss();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L30;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r1 = false;
        goto L15
    L5:
        r9 = null;
        goto L7
    }

    public final void aa0(List<od> r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "infoList");
        if (r6 != KtvTypetv.KTVMVType_OFFICIAl.ordinal()) goto L23;
        od r0 = null;
        if ((!r5.isEmpty()) == false) goto L7;
        List<od> r7 = r5;
    L8:
        if (r7 != null) goto L10;
        return;
    L10:
        od r1 = (od) this.n.e().getValue();
        if (r1 != null) goto L13;
    L19:
        com.bytedance.android.live.ktv.common.view.i r8 = this.t;
        if (r8 == null) goto L24;
        r8.b(r7.subList(0, Math.min(this.y, r7.size())));
        return;
    L24:
        return;
    L13:
        if (r1.g() == false) goto L15;
        r0 = r1;
    L15:
        if (r0 == null) goto L19;
        if (r5.contains(r0) == true) goto L19;
        r7 = new ArrayList(r5);
        ListProtector.add(r7, 0, r0);
        ListProtector.remove(r7, CollectionsKt.getLastIndex(r7));
        goto L19
    L7:
        r7 = null;
        goto L8
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r8, r9);
        OpusPreviewViewModel r10 = this.r;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L5:
        r10.getOfficialMvList().observe(this, new b(this));
        OpusPreviewViewModel r11 = this.r;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L8:
        r11.getOpusMvList().observe(this, new c(this));
        this.n.e().observe(this, new d(this));
        OpusPreviewViewModel r1 = this.r;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L11:
        OpusPreviewViewModel.requestMvList$default(r1, true, false, new OpusPreviewDialog$getNewMvList$1(this), 2, null);
    }

    public final void G80(int r2, Object r3, IMvPreviewViewHolder r4, Function0 r5) {
        od r6 = (od) r3;
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.INFO);
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "unSelectedCb");
        Function0<Unit> r0 = this.w;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        this.o = r4;
        this.w = r5;
        this.p = new Pair(Integer.valueOf(r2), r6);
        Y90(Intrinsics.areEqual(r6, (od) this.n.e().getValue()));
    }
}
