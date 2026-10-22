package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.button.ECButton;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashNewFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashViewModel;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/o;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashNewFragment extends ECBaseDialogFragment<LiveFlashViewModel> implements o {
    public static final /* synthetic */ int w = 0;
    public Map<Integer, View> i;
    public RecyclerView j;
    public ECButton k;
    public LiveFlashListAdapter l;
    public s m;
    public boolean n;
    public boolean o;
    public Dialog p;
    public ECAlertDialog q;
    public ECAlertDialog r;
    public Dialog s;
    public Dialog t;
    public String u;
    public FlashController v;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ LiveFlashNewFragment a;

        public b(LiveFlashNewFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            r3.dismiss();
            LiveFlashNewFragment r5 = this.a;
            int r6 = LiveFlashNewFragment.w;
            LiveFlashViewModel r7 = (LiveFlashViewModel) r5.g;
            if (r7 == null) goto L7;
            q r8 = r7.getEventHelper();
            if (r8 == null) goto L7;
            new com.bytedance.android.livesdk.livecommerce.event.b0(r8.a, r8.b, r8.c).k();
        L7:
            LiveFlashNewFragment.ia0(this.a);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveFlashNewFragment a;

        public d(LiveFlashNewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ECTitleBar a;

        public e(ECTitleBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Context r4 = this.a.getContext();
            if (r4 == null) goto L6;
            String r0 = ECLiveABUtils.INSTANCE.getEC_LIVE_ANCHOR_FLASH_PANEL_EXPLAIN_URL();
            Handler r1 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
            com.bytedance.android.livesdk.livecommerce.room.f.b(r4, r0);
            return;
        }
    }

    public static final class f implements DialogInterface.OnKeyListener {
        public final /* synthetic */ LiveFlashNewFragment a;

        public f(LiveFlashNewFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r3.getKeyCode() == 4) goto L5;
            return false;
        L5:
            if (r3.getAction() == 0) goto L17;
            return false;
        L17:
            this.a.dismiss();     // Catch: Exception -> L9
            return true;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L19;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return true;
        L19:
            return true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560720;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void X90() {
        if (this.i != null) goto L5;
        this.i = new LinkedHashMap();
    L5:
        View r0 = (View) ((LinkedHashMap) this.i).get(2131370734);
        Object r2 = null;
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 == null) goto L12;
        r0 = r1.findViewById(2131370734);
        if (r0 == null) goto L12;
        this.i.put(2131370734, r0);
    L12:
        r0 = null;
    L13:
        ECTitleBar r3 = (ECTitleBar) r0;
        if (r3 == null) goto L16;
        r3.setLeftIconClickListener(new d(this));
        r3.setRightTextClickListener(new e(r3));
    L16:
        this.j = this.d.findViewById(2131384949);
        ECButton r4 = this.d.findViewById(2131364698);
        this.k = r4;
        if (r4 == null) goto L19;
        r4.setOnClickListener(this);
    L19:
        int r5 = com.bytedance.android.livesdk.livecommerce.utils.t.a;
        Context r6 = getContext();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L28
        if (r6 == null) goto L25;
        Resources r8 = th.a.f(r6);     // Catch: Throwable -> L28
        if (r8 == null) goto L25;
        Drawable r9 = r8.getDrawable(2131231881);     // Catch: Throwable -> L28
    L26:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L28
    L31:
        if (Result.exceptionOrNull-impl(r10) == null) goto L34;
        dm.a.a("ECLiveResourceUtils").i("safeGetResourceDrawable error!!!");
    L34:
        if (Result.isFailure-impl(r10) == true) goto L37;
        r2 = r10;
    L37:
        Drawable r11 = (Drawable) r2;
        if (r11 == null) goto L45;
        ECButton r12 = this.k;
        if (r12 == null) goto L46;
        r12.setBackground(r11);
        return;
    L46:
        return;
    L45:
        return;
    L25:
        r9 = null;
    L28:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void dismiss() {
        if (this.n == true) goto L5;
    L7:
        ia0(this);
        return;
    L5:
        if (this.o == true) goto L7;
        this.q = com.bytedance.android.livesdk.livecommerce.room.f.f(getContext(), 2131896557, 2131896558, 2131896419, new b(this), c.a);
    }

    public final boolean oa0() {
        if (this.m == null) goto L31;
        LiveFlashViewModel r0 = (LiveFlashViewModel) this.g;
        if (r0 == null) goto L9;
        MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> r1 = r0.getFlashItemList();
        if (r1 == null) goto L9;
        List r2 = (List) r1.getValue();
    L11:
        if (r2 != null) goto L13;
        boolean r3 = false;
    L21:
        if (r3 != true) goto L32;
        return true;
    L32:
        return false;
    L13:
        Iterator r4 = r2.iterator();
        r3 = true;
    L15:
        if (r4.hasNext() == false) goto L21;
        Object r5 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) r4.next();
        if ((r5 instanceof m) == false) goto L15;
        if (((m) r5).a() == false) goto L15;
        r3 = false;
    L9:
        r2 = null;
        goto L11
    L31:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, com.bytedance.android.livesdk.livecommerce.room.controller.z
    public final void onLiveEnd() {
        Dialog r0 = this.r;
        Dialog r1 = null;
        if (r0 != null) goto L5;
    L10:
        Dialog r2 = this.p;
        if (r2 != null) goto L13;
    L18:
        Dialog r3 = this.q;
        if (r3 != null) goto L21;
    L26:
        Dialog r4 = this.t;
        if (r4 != null) goto L29;
    L33:
        this.o = true;
        ECBaseDialogFragment.T90(this);
        return;
    L29:
        if (r4.isShowing() == false) goto L31;
        r1 = r4;
    L31:
        if (r1 == null) goto L33;
        ja0(r1);
        goto L33
    L21:
        if (r3.isShowing() == true) goto L24;
        r3 = null;
    L24:
        if (r3 == null) goto L26;
        ja0(r3);
        goto L26
    L13:
        if (r2.isShowing() == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        ja0(r2);
        goto L18
    L5:
        if (r0.isShowing() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        ja0(r0);
        goto L10
    }

    public LiveFlashNewFragment() {
        this.i = new LinkedHashMap();
        this.n = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.i).clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onResume() {
        super.onResume();
        com.bytedance.android.livesdk.livecommerce.utils.k.h(1);
    }

    public static void ia0(ECBaseDialogFragment r1) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void ja0(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void na0(LiveFlashNewFragment r0) {
        LiveFlashViewModel r1 = (LiveFlashViewModel) r0.g;
        if (r1 == null) goto L6;
        r1.genBarCode();
        return;
    }

    public static void ra0(LiveFlashNewFragment r0) {
        LiveFlashListAdapter r1 = r0.l;
        if (r1 == null) goto L6;
        r1.notifyDataSetChanged();
        return;
    }

    public final void ma0(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        com.bytedance.android.livesdk.livecommerce.utils.k.h(4);
        Dialog r0 = this.r;
        Dialog r1 = null;
        if (r0 != null) goto L5;
    L10:
        Dialog r2 = this.p;
        if (r2 != null) goto L13;
    L18:
        Dialog r3 = this.q;
        if (r3 != null) goto L21;
    L26:
        Dialog r5 = this.s;
        if (r5 != null) goto L29;
    L34:
        Dialog r6 = this.t;
        if (r6 != null) goto L37;
    L41:
        super.onDismiss(r4);
        return;
    L37:
        if (r6.isShowing() == false) goto L39;
        r1 = r6;
    L39:
        if (r1 == null) goto L41;
        ja0(r1);
        goto L41
    L29:
        if (r5.isShowing() == true) goto L32;
        r5 = null;
    L32:
        if (r5 == null) goto L34;
        ja0(r5);
        goto L34
    L21:
        if (r3.isShowing() == true) goto L24;
        r3 = null;
    L24:
        if (r3 == null) goto L26;
        ja0(r3);
        goto L26
    L13:
        if (r2.isShowing() == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        ja0(r2);
        goto L18
    L5:
        if (r0.isShowing() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        ja0(r0);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onActivityCreated(Bundle r18) {
        super.onActivityCreated(r18);
        AppCompatDialog r1 = Z90();
        if (r1 == null) goto L5;
        r1.setOnKeyListener(new f(this));
    L5:
        LiveFlashViewModel r2 = (LiveFlashViewModel) this.g;
        if (r2 == null) goto L17;
        Bundle r3 = getArguments();
        if (r3 == null) goto L17;
        String r4 = r3.getString("args_broadcast_id");
        String r5 = r3.getString("args_broadcast_sec_id");
        String r6 = r3.getString("args_room_id");
        String r7 = r3.getString("args_target_id");
        String r8 = r3.getString("args_category_name");
        String r9 = r3.getString("args_category_id");
        long r10 = r3.getLong("click_time");
        String r12 = r3.getString("args_shop_id");
        Serializable r13 = r3.getSerializable("args_properties");
        if ((r13 instanceof Map) == true) goto L12;
        r13 = null;
    L12:
        Map<String, ? extends List<String>> r14 = (Map) r13;
        String r15 = r3.getString("args_target_name");
        Boolean r16 = Boolean.valueOf(r3.getBoolean("args_need_barcode"));
        Integer r11 = Integer.valueOf(r3.getInt("args_barcode_state"));
        FlashController r17 = this.v;
        if (r17 != null) goto L15;
        int r19 = FlashController.f;
        FlashController r0 = ControllerCenter.c(null, null).p;
        Objects.toString(r0);
        FlashController r110 = r0;
    L16:
        r2.init(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r11, r110);
        goto L17
    L15:
        r110 = r17;
    L17:
        UtilityKotlinExtentionsKt.g(getContext(), this.g, this.u, new AnonymousClass3(this));
        LiveFlashViewModel r20 = (LiveFlashViewModel) this.g;
        if (r20 == null) goto L22;
        q r21 = r20.getEventHelper();
        if (r21 == null) goto L22;
        new com.bytedance.android.livesdk.livecommerce.event.d0(r21.a, r21.b, r21.c).k();
    L22:
        Context r22 = getContext();
        boolean r23 = true;
        if (r22 == null) goto L40;
        RecyclerView r24 = this.j;
        if (r24 == null) goto L27;
        r24.setLayoutManager(new LinearLayoutManager(r22, 1, false));
    L27:
        LiveFlashListAdapter r25 = new LiveFlashListAdapter(r22, (LiveFlashViewModel) this.g);
        this.l = r25;
        RecyclerView r26 = this.j;
        if (r26 == null) goto L30;
        r26.setAdapter(r25);
    L30:
        LiveFlashViewModel r27 = (LiveFlashViewModel) this.g;
        if (r27 == null) goto L39;
        MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> r28 = r27.getFlashItemList();
        if (r28 == null) goto L39;
        s r29 = this.m;
        if (r29 == null) goto L37;
        List<com.bytedance.android.livesdk.livecommerce.oldflash.b> r30 = r29.a(null, null, false);
    L38:
        r28.setValue(r30);
        goto L39
    L37:
        r30 = null;
    L39:
        boolean r31 = oa0();
        int r32 = com.bytedance.android.livesdk.livecommerce.utils.t.a;
        qa0(r31, com.bytedance.android.livesdk.livecommerce.utils.t.a(getContext(), 2131896551));
    L40:
        LiveFlashViewModel r33 = (LiveFlashViewModel) this.g;
        if (r33 == null) goto L45;
        MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.b> r34 = r33.getItemClickObserver();
        if (r34 == null) goto L45;
        r34.observe(this, new x(this));
    L45:
        LiveFlashViewModel r35 = (LiveFlashViewModel) this.g;
        if (r35 == null) goto L50;
        MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> r36 = r35.getFlashItemList();
        if (r36 == null) goto L50;
        r36.observe(this, new y(this));
    L50:
        LiveFlashViewModel r37 = (LiveFlashViewModel) this.g;
        if (r37 == null) goto L55;
        MutableLiveData<Pair<String, xi2.v>> r38 = r37.getPropertyLoadObserver();
        if (r38 == null) goto L55;
        r38.observe(this, new z(this));
    L55:
        LiveFlashViewModel r39 = (LiveFlashViewModel) this.g;
        if (r39 == null) goto L60;
        MutableLiveData<Void> r40 = r39.getFlashSuccessObserver();
        if (r40 == null) goto L60;
        r40.observe(this, new a0(this));
    L60:
        LiveFlashViewModel r41 = (LiveFlashViewModel) this.g;
        if (r41 == null) goto L65;
        MutableLiveData<xi2.o> r42 = r41.getFlashFailObserver();
        if (r42 == null) goto L65;
        r42.observe(this, new b0(this));
    L65:
        LiveFlashViewModel r43 = (LiveFlashViewModel) this.g;
        if (r43 == null) goto L70;
        MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.a> r44 = r43.getBarCodeClickObserver();
        if (r44 == null) goto L70;
        r44.observe(this, new c0(this));
    L70:
        LiveFlashViewModel r45 = (LiveFlashViewModel) this.g;
        if (r45 == null) goto L75;
        MutableLiveData<String> r46 = r45.getBarCodeLoadObserver();
        if (r46 == null) goto L75;
        r46.observe(this, new d0(this));
    L75:
        LiveFlashViewModel r47 = (LiveFlashViewModel) this.g;
        if (r47 == null) goto L80;
        LiveData<String[]> r48 = r47.getAlertDialogMessage();
        if (r48 == null) goto L80;
        r48.observe(this, new e0(this));
    L80:
        pa0(true);
        LiveFlashViewModel r49 = (LiveFlashViewModel) this.g;
        if (r49 != null) goto L83;
        return;
    L83:
        if (r49.isNeedBarCode() != true) goto L94;
        LiveFlashViewModel r50 = (LiveFlashViewModel) this.g;
        if (r50 != null) goto L87;
    L89:
        r23 = false;
    L90:
        if (r23 == false) goto L95;
        na0(this);
        return;
    L95:
        return;
    L87:
        if (r50.getBarCodeState() != 1) goto L89;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r11) {
        if (r11 == null) goto L5;
        Integer r1 = Integer.valueOf(r11.getId());
    L6:
        if (r1 != null) goto L9;
    L49:
        super.onClick(r11);
        return;
    L9:
        if (r1.intValue() != 2131364698) goto L49;
        LiveFlashViewModel r2 = (LiveFlashViewModel) this.g;
        if (r2 == null) goto L49;
        MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> r3 = r2.getFlashItemList();
        if (r3 == null) goto L49;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L49;
        if (la0(true, true) == false) goto L21;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L49;
        this.r = com.bytedance.android.livesdk.livecommerce.room.f.f(r5, 0, 2131896603, 2131896419, new LiveFlashNewFragment$startFlash$$inlined$apply$lambda$1(this), w.a);
        goto L49
    L21:
        s r6 = this.m;
        if (r6 == null) goto L49;
        RecyclerView r7 = this.j;
        if (r7 == null) goto L49;
        Iterator r8 = r4.iterator();
        int r9 = 0;
    L28:
        if (r8.hasNext() == false) goto L49;
        Object r10 = r8.next();
        int r12 = r9 + 1;
        if (r9 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        Object r13 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) r10;
        if ((r13 instanceof m) == true) goto L35;
        Object r14 = null;
    L36:
        m r15 = (m) r14;
        if (r15 == null) goto L48;
        if (r15.a() != true) goto L48;
        LinearLayoutManager r0 = r7.getLayoutManager();
        if (r0 != null) goto L43;
    L47:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r7.getContext(), ((m) r13).b(r6.p));
        goto L49
    L43:
        if (r9 >= r0.findFirstCompletelyVisibleItemPosition()) goto L45;
    L46:
        r7.smoothScrollToPosition(r9);
        goto L47
    L45:
        if (r9 <= r0.findLastCompletelyVisibleItemPosition()) goto L47;
    L48:
        r9 = r12;
        goto L28
    L35:
        r14 = r13;
        goto L36
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDismiss(DialogInterface r2) {
        ma0(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void pa0(boolean r6) {
        LiveFlashViewModel r0 = (LiveFlashViewModel) this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getCategoryId();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        Dialog r4 = null;
        if (r2 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L30;
        if (r6 == false) goto L18;
        r0.setCanLogShowSku(false);
    L18:
        r0.loadProperties(r1, r0.getShopId(), r0.getTargetId());
        Context r7 = getContext();
        if (r7 == null) goto L31;
        Dialog r3 = this.p;
        if (r3 != null) goto L23;
    L27:
        this.p = com.bytedance.android.livesdk.livecommerce.utils.k.m(r7, th.a.g(r7, 2131896590));
        return;
    L23:
        if (r3.isShowing() == false) goto L25;
        r4 = r3;
    L25:
        if (r4 == null) goto L27;
        ja0(r4);
        goto L27
    L31:
        return;
    L30:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public static final void ka0(final LiveFlashNewFragment r20, final com.bytedance.android.livesdk.livecommerce.oldflash.b r21) {
        r20.getClass();
        FragmentActivity r3 = null;
        if ((r21 instanceof k) == false) goto L6;
        k r4 = (k) r21;
        final InputArgs r2 = new InputArgs(r4.c(r20.getContext()), r4.g, null, r4.k, r4.b, r4.i, r4.j, r4.h, null, 4, null);
    L30:
        if (r2 == null) goto L54;
        FragmentActivity r5 = r20.getContext();
        if (r5 == null) goto L51;
        int r6 = LiveFlashEditDialog.l;
        Function1<String, Unit> r7 = new LiveFlashNewFragment$showEdit$$inlined$let$lambda$1(r20, r2, r21);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "args");
        Intrinsics.checkNotNullParameter(r7, "listener");
        LiveFlashEditDialog r8 = new LiveFlashEditDialog();
        r8.d = r2;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "listener");
        r8.e = r7;
        if ((r5 instanceof FragmentActivity) == false) goto L38;
        r3 = r5;
    L38:
        FragmentActivity r9 = r3;
        if (r9 == null) goto L52;
        FragmentManager r0 = r9.getSupportFragmentManager();
        if (r0 == null) goto L53;
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "EditDialogFragment", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r8, r1) == true) goto L55;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
    L46:
        r8.show(r0, "EditDialogFragment");
        return;
    L55:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L54:
        return;
    L6:
        if ((r21 instanceof l) == false) goto L29;
        si2.i r10 = s.s;
        int r11 = s.d.c();
        l r12 = (l) r21;
        String r13 = r12.c;
        if (r13 == null) goto L10;
        Integer r14 = Integer.valueOf(r13.length());
    L11:
        int r15 = r11 - com.bytedance.android.shopping.extensions.k.g(r14, 0);
        String r16 = "";
        if (r15 > 0) goto L21;
        Context r17 = r20.getContext();
        Context r18 = r20.getContext();
        if (r18 == null) goto L16;
        String r19 = th.a.h(r18, 2131896618, new Object[]{Integer.valueOf(s.d.c())});
    L17:
        if (r19 == null) goto L20;
        r16 = r19;
    L20:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r17, r16);
        goto L29
    L16:
        r19 = null;
        goto L17
    L21:
        Context r22 = r20.getContext();
        if (r22 == null) goto L24;
        String r23 = th.a.h(r22, 2131896583, new Object[]{Integer.valueOf(s.d.d()), Integer.valueOf(s.d.c())});
    L25:
        if (r23 != null) goto L27;
        String r24 = "";
    L28:
        r2 = new InputArgs(r24, r12.d, r12.c, 0, r12.b, r15, 0, new u(r20), null, 328, null);
        goto L30
    L27:
        r24 = r23;
        goto L28
    L24:
        r23 = null;
        goto L25
    L10:
        r14 = null;
    L29:
        r2 = null;
        goto L30
    }

    public final boolean la0(boolean r4, boolean r5) {
        boolean r0 = oa0();
        int r1 = com.bytedance.android.livesdk.livecommerce.utils.t.a;
        qa0(r0, com.bytedance.android.livesdk.livecommerce.utils.t.a(getContext(), 2131896551));
        if (r4 == true) goto L10;
        LiveFlashViewModel r6 = (LiveFlashViewModel) this.g;
        if (r6 == null) goto L10;
        if (r6.getShowErrorLine() == true) goto L10;
        return true;
    L10:
        LiveFlashViewModel r7 = (LiveFlashViewModel) this.g;
        if (r7 == null) goto L13;
        r7.setShowErrorLine(!r0);
    L13:
        if (r5 == false) goto L17;
        LiveFlashListAdapter r8 = this.l;
        if (r8 == null) goto L17;
        r8.notifyDataSetChanged();
    L17:
        return r0;
    }

    public final void qa0(boolean r2, String r3) {
        ECButton r0 = this.k;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        if (r3 == null) goto L10;
        ECButton r4 = this.k;
        if (r4 == null) goto L11;
        r4.setText(r3);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.o
    public final void show(Context r2, String r3) {
        this.u = r3;
        if ((r2 instanceof FragmentActivity) == true) goto L5;
        r2 = null;
    L5:
        FragmentActivity r4 = (FragmentActivity) r2;
        if (r4 == null) goto L18;
        FragmentManager r5 = r4.getSupportFragmentManager();
        if (r5 == null) goto L19;
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "LiveFlashFragment", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, this, r6) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        show(r5, "LiveFlashFragment");
        return;
    L20:
        return;
    L19:
        return;
    }
}
