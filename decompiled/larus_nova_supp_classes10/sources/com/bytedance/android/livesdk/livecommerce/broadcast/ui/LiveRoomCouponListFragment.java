package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.multitype.MultiTypeAdapter;
import com.bytedance.android.livesdk.livecommerce.multitype.f;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdk.livecommerce.view.ECHostNoCouponLayout;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingLayout;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingStateView;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fh2.e;
import fh2.g;
import fh2.l;
import fh2.o;
import fh2.q;
import fh2.r;
import fh2.s;
import fh2.t;
import fh2.u;
import java.util.ArrayList;
import si2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LiveRoomCouponListFragment extends ECBaseDialogFragment<LiveRoomCouponListViewModel> {
    public static final /* synthetic */ int x = 0;
    public ImageView i;
    public RelativeLayout j;
    public ECFunctionGuideView k;
    public ImageView l;
    public View m;
    public RecyclerView n;
    public ECLoadingStateView o;
    public ECHostNoCouponLayout p;
    public ECLoadingLayout q;
    public TextView r;
    public ECAlertDialog s;
    public LinearLayoutManager t;
    public MultiTypeAdapter u;
    public String v;
    public String w;

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560723;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final boolean ha0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void da0() {
        this.o.setVisibility(0);
        ECLoadingStateView r0 = this.o;
        r0.e.showLoading();
        r0.d.setVisibility(8);
        r0.c.setVisibility(8);
        this.n.setVisibility(8);
        this.p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void dismiss() {
        LiveRoomCouponListViewModel r0 = (LiveRoomCouponListViewModel) this.g;
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L12;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ea0() {
        this.o.setVisibility(0);
        ECLoadingStateView r0 = this.o;
        r0.c.setVisibility(8);
        r0.d.setVisibility(0);
        r0.d.setBackgroundGray(false);
        r0.e.reset();
        this.n.setVisibility(8);
        this.p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void fa0() {
        if (this.u.getItemCount() <= ((this.u.d ? 1 : 0) + 0)) goto L5;
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.m.setVisibility(0);
    L6:
        this.r.setText(th.a.g(getContext(), 2131896731));
        this.o.setVisibility(8);
        return;
    L5:
        this.n.setVisibility(8);
        this.p.setBindNotice(((LiveRoomCouponListViewModel) this.g).getCouponBindNotice());
        this.p.setVisibility(0);
        this.m.setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, com.bytedance.android.livesdk.livecommerce.room.controller.z
    public final void onLiveEnd() {
        ECAlertDialog r0 = this.s;
        if (r0 != null) goto L5;
    L23:
        ECBaseDialogFragment.T90(this);
        return;
    L5:
        if (r0.isShowing() == false) goto L23;
        ECAlertDialog r1 = this.s;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
        goto L23
    L16:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        goto L23
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    public LiveRoomCouponListFragment() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog.b
    public final void Nc(ECBottomDialog.a r1) {
        super.Nc(r1);
        LiveRoomCouponListViewModel r2 = (LiveRoomCouponListViewModel) this.g;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void aa0(Bundle r2) {
        if (r2 == null) goto L5;
        this.v = r2.getString("room_id");
        this.w = r2.getString("anchor_id");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ga0(String r6) {
        this.o.setVisibility(0);
        ECLoadingStateView r0 = this.o;
        r0.b.setTextColor(r0.getContext().getResources().getColor(2131101622));
        r0.b.setText(r6);
        r0.d.setVisibility(8);
        r0.c.setVisibility(0);
        r0.e.reset();
        this.n.setVisibility(8);
        this.p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        ((LiveRoomCouponListViewModel) this.g).init(this.v, this.w, getContext());
        ((LiveRoomCouponListViewModel) this.g).setEnterFrom("");
        View r11 = getView();
        if (r11 == null) goto L19;
        this.j = (RelativeLayout) r11.findViewById(2131384720);
        TextView r0 = (TextView) r11.findViewById(2131390447);
        this.i = (ImageView) r11.findViewById(2131376031);
        this.l = (ImageView) r11.findViewById(2131376152);
        this.m = r11.findViewById(2131390221);
        this.n = r11.findViewById(2131384939);
        this.o = (ECLoadingStateView) r11.findViewById(2131371364);
        this.p = (ECHostNoCouponLayout) r11.findViewById(2131371360);
        this.q = (ECLoadingLayout) r11.findViewById(2131371363);
        this.k = r11.findViewById(2131392515);
        RecyclerView r12 = this.n;
        LinearLayoutManager r1 = new LinearLayoutManager(getActivity(), 1, false);
        this.t = r1;
        r12.setLayoutManager(r1);
        MultiTypeAdapter r2 = new MultiTypeAdapter();
        this.u = r2;
        LiveRoomNewCouponViewBinder r4 = new LiveRoomNewCouponViewBinder(this.g);
        com.bytedance.android.livesdk.livecommerce.multitype.d r5 = (com.bytedance.android.livesdk.livecommerce.multitype.d) r2.b;
        r5.getClass();
        boolean r6 = false;
    L6:
        int r7 = ((ArrayList) r5.a).indexOf(p.class);
        if (r7 == (-1)) goto L9;
        ListProtector.remove(r5.a, r7);
        ListProtector.remove(r5.b, r7);
        ListProtector.remove(r5.c, r7);
        r6 = true;
        goto L6
    L9:
        if (r6 == true) goto L11;
    L11:
        f r3 = r2.b;
        com.bytedance.android.livesdk.livecommerce.multitype.a r8 = new com.bytedance.android.livesdk.livecommerce.multitype.a();
        com.bytedance.android.livesdk.livecommerce.multitype.d r9 = (com.bytedance.android.livesdk.livecommerce.multitype.d) r3;
        r9.getClass();
        ((ArrayList) r9.a).add(p.class);
        ((ArrayList) r9.b).add(r4);
        ((ArrayList) r9.c).add(r8);
        if (getContext() == null) goto L15;
        this.r = new TextView(getContext());
        ViewGroup.MarginLayoutParams r13 = new ViewGroup.MarginLayoutParams(-1, -2);
        r13.topMargin = w0.a(3.0f);
        r13.bottomMargin = w0.a(5.0f);
        this.r.setTextSize(1, 13.0f);
        this.r.setLayoutParams(r13);
        this.r.setTextColor(th.a.a(getContext(), 2131101621));
        this.r.setGravity(17);
        this.r.setText(th.a.g(getContext(), 2131896639));
    L15:
        MultiTypeAdapter r14 = this.u;
        q r15 = new q(this);
        View r16 = r14.c;
        if (r16 == null) goto L18;
        r16.setVisibility(0);
    L18:
        r14.e = r15;
        r14.d = true;
        MultiTypeAdapter r17 = this.u;
        r17.f = new b(this);
        ((LiveRoomCouponListViewModel) this.g).bindDataAdapter(r17);
        r12.setAdapter(this.u);
        this.i.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.o.setRetryClickListener(new l(this));
        this.p.setBindCouponClickListener(new o(this));
        this.o.post(new fh2.p(this));
    L19:
        ((LiveRoomCouponListViewModel) this.g).getAdapterChangeData().observe(this, new r(this));
        ((LiveRoomCouponListViewModel) this.g).getAdapterAppendData().observe(this, new s(this));
        ((LiveRoomCouponListViewModel) this.g).getDistributeCouponData().observe(this, new t(this));
        ((LiveRoomCouponListViewModel) this.g).getFullLoadingData().observe(this, new u(this));
        ((LiveRoomCouponListViewModel) this.g).getFullLoadingFinishData().observe(this, new fh2.b(this));
        ((LiveRoomCouponListViewModel) this.g).getScrollData().observe(this, new fh2.c(this));
        ((LiveRoomCouponListViewModel) this.g).getCouponDetailGuideData().observe(this, new fh2.d(this));
        ((LiveRoomCouponListViewModel) this.g).getDismissFunctionGuideData().observe(this, new e(this));
        ((LiveRoomCouponListViewModel) this.g).getEndCouponGuideData().observe(this, new fh2.f(this));
        ((LiveRoomCouponListViewModel) this.g).getDistributeResponse().observe(this, new g(this));
        ((LiveRoomCouponListViewModel) this.g).start();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r3) {
        super.onClick(r3);
        if (r3 != this.i) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L19;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L11:
        if (r3 != this.l) goto L14;
        com.bytedance.android.livesdk.livecommerce.event.t r5 = new com.bytedance.android.livesdk.livecommerce.event.t();
        r5.f("room_id", this.v);
        r5.f("anchor_id", this.w);
        r5.f("button_for", "coupon_question");
        r5.f("page_name", "within_live");
        r5.k();
        ((LiveRoomCouponListViewModel) this.g).openDistributeCouponDescFragment(getContext(), getFragmentManager());
        return;
    L14:
        if (r3 != this.m) goto L22;
        ((LiveRoomCouponListViewModel) this.g).bindCoupon(getFragmentManager());
        return;
    }
}
