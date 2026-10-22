package com.bytedance.android.livesdk.linkvideo.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.linkvideo.AnchorLinkVideoListViewModel;
import com.bytedance.android.livesdk.linkvideo.AnchorLinkVideoListViewModelFactory;
import com.bytedance.android.livesdk.linkvideo.DialogLifecycleOwner;
import com.bytedance.android.livesdk.linkvideo.LoadMoreScrollListener;
import com.bytedance.android.livesdk.linkvideo.view.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/linkvideo/view/h;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkVideoDialog extends LiveDialogFragment implements h, View.OnClickListener {
    public static final String R = null;
    public LoadMoreScrollListener A;
    public LiveDoubleColorBallAnimationView B;
    public View C;
    public int D;
    public boolean E;
    public boolean F;
    public final WeakHandler G;
    public final MutableLiveData<gf2.a> H;
    public long I;
    public final Map<Integer, Long> J;
    public int K;
    public boolean L;
    public int M;
    public View N;
    public boolean O;
    public long P;
    public boolean Q;
    public int d;
    public String e;
    public long f;
    public final Lazy g;
    public final CompositeDisposable h;
    public AnchorLinkVideoListViewModel i;
    public View j;
    public View k;
    public View l;
    public HSImageView m;
    public Button n;
    public Button o;
    public Button p;
    public TextView q;
    public ImageView r;
    public ImageView s;
    public View t;
    public FrameLayout u;
    public TextView v;
    public View w;
    public View x;
    public RecyclerView y;
    public MultiTypeAdapter z;

    public static final class a {
    }

    public static final class b implements WeakHandler.IHandler {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void handleMsg(Message r1) {
        }
    }

    public static final class c implements IMiddlewareHostBusiness.AwemeQueryCallBack {
        public final /* synthetic */ LinkVideoDialog a;

        public final void onBatchSuccess(HashMap<Long, Object> r1) {
        }

        public c(LinkVideoDialog r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r8, long r9) {
            if (r8 == null) goto L25;
            LinkVideoDialog r10 = this.a;
            String r0 = LinkVideoDialog.R;
            r10.getClass();
            if (PadConfigUtils.c() == false) goto L7;
            int r1 = s1.k(2131169226);
        L8:
            IMiddlewareHostBusiness.AwemeVideoPlayFragmentV2 r11 = k.n(IMiddlewareHostBusiness.class).getLivePureVideoPlayFragmentV2(r8, r1, r10.getContext(), 0);
            Fragment r2 = null;
            if (r11 == null) goto L11;
            r11.setPlayOnResume(false);
            r11.setCallback(new com.bytedance.android.livesdk.linkvideo.ui.d(r10));
        L12:
            if (r11 == null) goto L14;
            r2 = r11.asFragment();
        L14:
            if (r2 == null) goto L24;
            FragmentManager r12 = r10.getChildFragmentManager();
            if (r12 == null) goto L24;
            FragmentTransaction r13 = r12.beginTransaction();
            if (r13 == null) goto L24;
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "LinkVideoDialogPreview", 2131378433) == true) goto L23;
            r13.add(2131378433, r2, "LinkVideoDialogPreview");
        L23:
            r13.commitAllowingStateLoss();
        L24:
            this.a.hideLoading();
            return;
        L11:
            r11 = null;
            goto L12
        L7:
            r1 = s1.k(2131169225) - (s1.f(484.0f) - r10.M);
            goto L8
        L25:
            f2.b(2131923104, 0);
            LinkVideoDialog r14 = this.a;
            String r15 = LinkVideoDialog.R;
            r14.hideLoading();
            this.a.Y90(1);
        }

        public final void onFailure(String r2, String r3, String r4) {
            if (TextUtils.isEmpty(r3) == true) goto L6;
            f2.c(r3, 0);
        L9:
            LinkVideoDialog r5 = this.a;
            String r6 = LinkVideoDialog.R;
            r5.hideLoading();
            this.a.Y90(1);
            return;
        L6:
            if (TextUtils.isEmpty(r4) == true) goto L8;
            f2.c(r4, 0);
            goto L9
        L8:
            f2.b(2131915225, 0);
            goto L9
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LinkVideoDialog a;

        public d(LinkVideoDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.C;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        R = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_comment_empty_list_image.png";
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final gf2.a J9() {
        MutableLiveData<gf2.a> r0 = this.H;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (gf2.a) r0.getValue();
    }

    public final void U90() {
        View r0 = this.w;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L26;
        View r1 = this.w;
        Integer r2 = null;
        if (r1 == null) goto L9;
        ViewParent r3 = r1.getParent();
    L10:
        if (r3 == null) goto L29;
        FragmentManager r4 = getChildFragmentManager();
        if (r4 == null) goto L27;
        Fragment r5 = r4.findFragmentByTag("LinkVideoDialogPreview");
        if (r5 == null) goto L28;
        FragmentManager r6 = getChildFragmentManager();
        if (r6 == null) goto L23;
        FragmentTransaction r7 = r6.beginTransaction();
        if (r7 == null) goto L23;
        FragmentTransaction r8 = r7.remove(r5);
        if (r8 == null) goto L23;
        r2 = Integer.valueOf(r8.commitAllowingStateLoss());
    L23:
        r2.intValue();
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void W90() {
        View r0 = this.l;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        ImageLoader.bindImage(this.m, R);
        IRoomModuleService r1 = k.f(IRoomModuleService.class);
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.linkvideo.b r2 = r1.getLinkVideoTea();
        if (r2 == null) goto L12;
        r2.f(this.F, v6.a());
        return;
    L12:
        return;
    }

    public final void hideLoading() {
        View r0 = this.j;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        LiveDoubleColorBallAnimationView r1 = this.B;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    public LinkVideoDialog() {
        this.d = 1;
        this.e = "";
        this.g = LazyKt.lazy(LinkVideoDialog$lifecycleOwner$2.INSTANCE);
        this.h = new CompositeDisposable();
        this.E = true;
        this.G = new WeakHandler(Looper.getMainLooper(), b.a);
        this.H = new MutableLiveData();
        this.J = new LinkedHashMap();
        this.O = true;
        this.Q = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.android.livesdk.f.d().f();
        AnchorLinkVideoListViewModel r0 = this.i;
        if (r0 == null) goto L5;
        r0.onDialogDismiss();
    L5:
        WeakHandler r1 = this.G;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.g.getValue()).a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        CompositeDisposable r2 = this.h;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        U90();
        IRoomModuleService r3 = k.f(IRoomModuleService.class);
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.linkvideo.b r4 = r3.getLinkVideoTea();
    L15:
        int r5 = this.K;
        if (r5 < 0) goto L33;
        int r6 = 0;
    L18:
        Long r7 = (Long) ((LinkedHashMap) this.J).get(Integer.valueOf(r6));
        if (r7 == null) goto L21;
        long r8 = r7.longValue();
    L23:
        if (r8 <= 0) goto L31;
        if (r4 == null) goto L31;
        boolean r9 = this.F;
        String r10 = v6.a();
        Long r11 = (Long) ((LinkedHashMap) this.J).get(Integer.valueOf(r6));
        if (r11 == null) goto L29;
        String r12 = String.valueOf(r11.longValue());
    L30:
        r4.b(r9, r10, r12);
        goto L31
    L29:
        r12 = null;
    L31:
        if (r6 == r5) goto L35;
        r6 = r6 + 1;
        goto L18
    L35:
        return;
    L21:
        r8 = 0;
        goto L23
    L33:
        return;
    L14:
        r4 = null;
        goto L15
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, s1.f(484.0f));
        return;
    L9:
        return;
    }

    public static TextureView S90(ViewGroup r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = r5.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L23;
        View r3 = r5.getChildAt(r2);
        if ((r3 instanceof TextureView) == true) goto L16;
        if ((r3 instanceof ViewGroup) == false) goto L15;
        TextureView r4 = S90((ViewGroup) r3);
        if (r4 == null) goto L15;
        return r4;
    L15:
        r2 = r2 + 1;
        goto L6
    L16:
        return (TextureView) r3;
    L23:
        return null;
    }

    public final gf2.a T90(long r6) {
        MultiTypeAdapter r0 = this.z;
        if (r0 == null) goto L17;
        List r1 = r0.a;
        if (r1 == null) goto L27;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L28;
        Object r3 = r2.next();
        if ((r3 instanceof gf2.a) == false) goto L8;
        gf2.a r4 = (gf2.a) r3;
        Long r5 = r4.b();
        if (r5 == null) goto L8;
        if (r5.longValue() != r6) goto L8;
        return r4;
    L28:
        return null;
    L27:
        return null;
    L17:
        return null;
    }

    public final void V90(boolean r4) {
        LoadMoreScrollListener r0 = this.A;
        if (r0 == null) goto L5;
        r0.b = 0;
    L5:
        MultiTypeAdapter r1 = this.z;
        List r2 = null;
        if (r1 == null) goto L8;
        List r3 = r1.a;
    L10:
        if (TypeIntrinsics.isMutableList(r3) == false) goto L13;
        r2 = r3;
    L13:
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.size() <= 0) goto L25;
        int r5 = r2.size() - 1;
        if ((ListProtector.get(r2, r5) instanceof com.bytedance.android.livesdk.linkvideo.view.f) == false) goto L26;
        ListProtector.remove(r2, r5);
        if (r4 == false) goto L27;
        MultiTypeAdapter r6 = this.z;
        if (r6 == null) goto L28;
        r6.notifyItemRemoved(r5);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r3 = null;
        goto L10
    }

    public final void X90(long r5) {
        if (r5 > 0) goto L6;
        f2.b(2131915225, 0);
        return;
    L6:
        this.P = r5;
        View r0 = this.j;
        if (r0 == null) goto L9;
        r0.setVisibility(0);
    L9:
        LiveDoubleColorBallAnimationView r1 = this.B;
        if (r1 == null) goto L12;
        r1.b();
    L12:
        Disposable r6 = k.n(IMiddlewareHostBusiness.class).queryAweme(r5, new c(this));
        if (r6 == null) goto L16;
        RxUtilKt.c(r6, this.h);
        return;
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final void XJ(long r4) {
        if (r4 > 0) goto L6;
        f2.b(2131915225, 0);
        return;
    L6:
        this.I = r4;
        Y90(2);
        X90(r4);
    }

    public final void Y90(int r5) {
        this.D = r5;
        if (r5 != 1) goto L5;
        ImageView r6 = this.r;
        if (r6 == null) goto L76;
        r6.setVisibility(0);
    L76:
        RecyclerView r7 = this.y;
        if (r7 == null) goto L79;
        r7.setVisibility(0);
    L79:
        ImageView r8 = this.s;
        if (r8 == null) goto L82;
        r8.setVisibility(0);
    L82:
        TextView r9 = this.q;
        if (r9 == null) goto L85;
        r9.setText(s1.B(2131915793));
    L85:
        Button r10 = this.n;
        if (r10 == null) goto L88;
        r10.setVisibility(8);
    L88:
        Button r11 = this.o;
        if (r11 == null) goto L91;
        r11.setVisibility(8);
    L91:
        Button r12 = this.p;
        if (r12 == null) goto L94;
        r12.setVisibility(8);
    L94:
        FrameLayout r13 = this.u;
        if (r13 == null) goto L97;
        r13.setVisibility(8);
    L97:
        TextView r14 = this.v;
        if (r14 == null) goto L101;
        r14.setVisibility(8);
    L101:
        if (this.d != 1) goto L103;
    L107:
        IRoomModuleService r15 = k.f(IRoomModuleService.class);
        if (r15 == null) goto L119;
        com.bytedance.android.livesdk.linkvideo.b r16 = r15.getLinkVideoTea();
        if (r16 == null) goto L120;
        r16.i(v6.a());
        return;
    L120:
        return;
    L119:
        return;
    L103:
        if (this.E == false) goto L107;
        AnchorLinkVideoListViewModel r17 = this.i;
        if (r17 == null) goto L107;
        r17.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        goto L107
    L5:
        if (r5 != 2) goto L7;
        ImageView r18 = this.r;
        if (r18 == null) goto L44;
        r18.setVisibility(0);
    L44:
        RecyclerView r19 = this.y;
        if (r19 == null) goto L47;
        r19.setVisibility(8);
    L47:
        ImageView r20 = this.s;
        if (r20 == null) goto L50;
        r20.setVisibility(8);
    L50:
        TextView r21 = this.q;
        if (r21 == null) goto L53;
        r21.setText(s1.B(2131921648));
    L53:
        Button r22 = this.n;
        if (r22 == null) goto L56;
        r22.setVisibility(0);
    L56:
        Button r23 = this.o;
        if (r23 == null) goto L59;
        r23.setVisibility(8);
    L59:
        Button r24 = this.p;
        if (r24 == null) goto L62;
        r24.setVisibility(8);
    L62:
        FrameLayout r25 = this.u;
        if (r25 == null) goto L65;
        r25.setVisibility(0);
    L65:
        TextView r26 = this.v;
        if (r26 == null) goto L68;
        r26.setVisibility(8);
    L68:
        this.Q = true;
        Z90(false);
        IRoomModuleService r27 = k.f(IRoomModuleService.class);
        if (r27 == null) goto L116;
        com.bytedance.android.livesdk.linkvideo.b r28 = r27.getLinkVideoTea();
        if (r28 == null) goto L117;
        r28.a("video_play", v6.a());
        return;
    L117:
        return;
    L116:
        return;
    L7:
        if (r5 != 3) goto L121;
        ImageView r29 = this.r;
        if (r29 == null) goto L12;
        r29.setVisibility(8);
    L12:
        RecyclerView r30 = this.y;
        if (r30 == null) goto L15;
        r30.setVisibility(8);
    L15:
        ImageView r31 = this.s;
        if (r31 == null) goto L18;
        r31.setVisibility(0);
    L18:
        TextView r32 = this.q;
        if (r32 == null) goto L21;
        r32.setText(s1.B(2131919888));
    L21:
        Button r33 = this.n;
        if (r33 == null) goto L24;
        r33.setVisibility(8);
    L24:
        Button r34 = this.o;
        if (r34 == null) goto L27;
        r34.setVisibility(0);
    L27:
        Button r35 = this.p;
        if (r35 == null) goto L30;
        r35.setVisibility(0);
    L30:
        FrameLayout r36 = this.u;
        if (r36 == null) goto L33;
        r36.setVisibility(0);
    L33:
        TextView r37 = this.v;
        if (r37 == null) goto L36;
        r37.setVisibility(0);
    L36:
        this.O = true;
        this.Q = true;
        Z90(false);
        IRoomModuleService r38 = k.f(IRoomModuleService.class);
        if (r38 == null) goto L113;
        com.bytedance.android.livesdk.linkvideo.b r39 = r38.getLinkVideoTea();
        if (r39 == null) goto L114;
        r39.i(v6.a());
        return;
    L114:
        return;
    L113:
        return;
    }

    public final void Z90(boolean r4) {
        View r0 = this.C;
        if (r0 == null) goto L8;
        if (r4 == false) goto L6;
        int r1 = 0;
    L7:
        r0.setVisibility(r1);
        goto L8
    L6:
        r1 = 8;
    L8:
        if (r4 == false) goto L13;
        WeakHandler r5 = this.G;
        if (r5 == null) goto L14;
        r5.postDelayed(new d(this), 5000);
        return;
    L14:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r12 = r11.getId();
        if (r12 != 2131364807) goto L9;
        AnchorLinkVideoListViewModel r13 = this.i;
        if (r13 == null) goto L128;
        r13.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        return;
    L128:
        return;
    L9:
        int r3 = 0;
        if (r12 != 2131376031) goto L28;
        int r14 = this.D;
        if (r14 == 1) goto L124;
        if (r14 != 2) goto L132;
        Y90(1);
        U90();
        Button r15 = this.n;
        if (r15 != null) goto L23;
        return;
    L23:
        if (J9() != null) goto L26;
        r3 = 8;
    L26:
        r15.setVisibility(r3);
        return;
    L132:
        return;
    L124:
        dismiss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L130;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L130:
        return;
    L28:
        if (r12 != 2131376533) goto L50;
        Context r17 = getContext();
        if ((r17 instanceof FragmentActivity) == true) goto L32;
        r17 = null;
    L32:
        FragmentActivity r18 = (FragmentActivity) r17;
        if (r18 == null) goto L44;
        FragmentManager r19 = r18.getSupportFragmentManager();
        if (r19 == null) goto L44;
        com.bytedance.android.livesdk.linkvideo.h r0 = com.bytedance.android.livesdk.linkvideo.h.a;
        String r1 = this.e;
        if (r1 != null) goto L39;
        r1 = "";
    L39:
        Intrinsics.checkNotNullParameter(r19, "manager");
        Intrinsics.checkNotNullParameter(r1, "pageData");
        ALogger.d("UILinkVideoManager", "介绍页面：goIntroduceDialog");
        String r2 = LinkVideoIntroduceDialog.l;
        Intrinsics.checkNotNullParameter(r19, "manager");
        Intrinsics.checkNotNullParameter(r1, "extra");
        LinkVideoIntroduceDialog.l = r1;
        LinkVideoIntroduceDialog.m = false;
        LinkVideoIntroduceDialog r4 = new LinkVideoIntroduceDialog();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "LinkVideoIntroduceDialog", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r4, r5) == true) goto L44;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L121
    L43:
        r4.show(r19, "LinkVideoIntroduceDialog");
    L44:
        IRoomModuleService r110 = k.f(IRoomModuleService.class);
        if (r110 == null) goto L135;
        com.bytedance.android.livesdk.linkvideo.b r111 = r110.getLinkVideoTea();
        if (r111 == null) goto L136;
        r111.c(v6.a());
        return;
    L136:
        return;
    L135:
        return;
    L50:
        if (r12 != 2131364750) goto L83;
        if (this.D != 2) goto L54;
        long r8 = this.I;
    L61:
        if (r8 > 0) goto L64;
        f2.b(2131915225, 0);
        return;
    L64:
        this.I = r8;
        IRoomModuleService r112 = k.f(IRoomModuleService.class);
        if (r112 == null) goto L69;
        com.bytedance.android.livesdk.linkvideo.a r113 = r112.getLinkVideoManager();
        if (r113 == null) goto L69;
        r113.b(r8);
    L69:
        f2.c(s1.B(2131918775), 0);
        IRoomModuleService r114 = k.f(IRoomModuleService.class);
        if (r114 == null) goto L79;
        com.bytedance.android.livesdk.linkvideo.b r115 = r114.getLinkVideoTea();
        if (r115 == null) goto L79;
        if (this.D != 1) goto L76;
        String r6 = "related_video";
    L77:
        r115.j(r6, v6.a(), String.valueOf(r8));
        goto L79
    L76:
        r6 = "video_play";
    L79:
        if (this.D != 2) goto L81;
        U90();
    L81:
        Y90(3);
        X90(r8);
        return;
    L54:
        gf2.a r116 = J9();
        if (r116 == null) goto L59;
        Long r117 = r116.b();
        if (r117 == null) goto L59;
        r8 = r117.longValue();
    L59:
        r8 = 0;
        goto L61
    L83:
        if (r12 != 2131364673) goto L101;
        IRoomModuleService r118 = k.f(IRoomModuleService.class);
        if (r118 == null) goto L126;
        com.bytedance.android.livesdk.linkvideo.a r119 = r118.getLinkVideoManager();
        if (r119 == null) goto L126;
        r119.a();
    L126:
        dismiss();     // Catch: Exception -> L91
    L95:
        f2.b(2131915452, 0);
        IRoomModuleService r120 = k.f(IRoomModuleService.class);
        if (r120 == null) goto L139;
        com.bytedance.android.livesdk.linkvideo.b r121 = r120.getLinkVideoTea();
        if (r121 == null) goto L140;
        r121.h(v6.a());
        return;
    L140:
        return;
    L139:
        return;
    L91:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r122 = DialogFragmentLancet.sLastShowStack;
        if (r122 == null) goto L95;
        com.bytedance.crash.d.d(r122, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L95
    L101:
        if (r12 != 2131364641) goto L142;
        this.F = true;
        IRoomModuleService r123 = k.f(IRoomModuleService.class);
        if (r123 == null) goto L107;
        com.bytedance.android.livesdk.linkvideo.a r124 = r123.getLinkVideoManager();
        if (r124 == null) goto L107;
        r124.a();
    L107:
        U90();
        Y90(1);
        if (this.d != 1) goto L110;
    L111:
        gf2.a r125 = T90(this.I);
        if (r125 != null) goto L114;
        r125 = new gf2.a(0);
        r125.d(Long.valueOf(this.I));
    L114:
        Ao(r125, false);
    L115:
        IRoomModuleService r126 = k.f(IRoomModuleService.class);
        if (r126 == null) goto L143;
        com.bytedance.android.livesdk.linkvideo.b r127 = r126.getLinkVideoTea();
        if (r127 == null) goto L144;
        r127.g(v6.a());
        return;
    L144:
        return;
    L143:
        return;
    L110:
        if (this.E == true) goto L115;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L7;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L7;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        setStyle(1, 2131954580);
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.g.getValue()).a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_START);
        MiddlewareRoomContext r8 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L14;
        i r9 = r8.isAnchor();
        if (r9 == null) goto L14;
        Boolean r10 = (Boolean) r9.getValue();
        if (r10 == null) goto L14;
        r10.booleanValue();
    L14:
        Context r11 = getContext();
        if ((r11 instanceof FragmentActivity) == true) goto L17;
        r11 = null;
    L17:
        FragmentActivity r12 = (FragmentActivity) r11;
        if (r12 == null) goto L34;
        AnchorLinkVideoListViewModel r13 = (AnchorLinkVideoListViewModel) ViewModelProviders.of(r12, new AnchorLinkVideoListViewModelFactory()).get(AnchorLinkVideoListViewModel.class);
        if (r13 == null) goto L23;
        r13.initData();
        Unit r0 = Unit.INSTANCE;
    L24:
        this.i = r13;
        if (r13 == null) goto L29;
        MutableLiveData<com.bytedance.android.livesdk.linkvideo.g> r14 = r13.getViewEvent();
        if (r14 == null) goto L29;
        r14.observe((DialogLifecycleOwner) this.g.getValue(), new com.bytedance.android.livesdk.linkvideo.ui.b(this));
    L29:
        MutableLiveData<gf2.a> r15 = this.H;
        if (r15 == null) goto L33;
        r15.setValue(null);
        r15.observe((DialogLifecycleOwner) this.g.getValue(), new com.bytedance.android.livesdk.linkvideo.ui.a(this));
        return;
    L33:
        return;
    L23:
        r13 = null;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final void Ao(gf2.a r12, boolean r13) {
        if (r12 == null) goto L5;
        boolean r2 = true;
    L6:
        long r3 = 0;
        if (r12 == null) goto L11;
        Long r5 = r12.b();
        if (r5 == null) goto L11;
        long r6 = r5.longValue();
    L12:
        if (r2 == false) goto L30;
        MultiTypeAdapter r4 = this.z;
        if (r4 == null) goto L40;
        List r7 = r4.a;
        if (r7 == null) goto L40;
        Iterator r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L40;
        Object r9 = r8.next();
        if ((r9 instanceof gf2.a) == false) goto L19;
        gf2.a r10 = (gf2.a) r9;
        Long r11 = r10.b();
        if (r11 != null) goto L26;
    L27:
        boolean r14 = true;
    L29:
        r10.a = r14;
        goto L19
    L26:
        if (r11.longValue() != r6) goto L27;
        r14 = false;
    L40:
        MutableLiveData<gf2.a> r0 = this.H;
        if (r0 == null) goto L43;
        r0.setValue(r12);
    L43:
        if (r13 == false) goto L65;
        IRoomModuleService r15 = k.f(IRoomModuleService.class);
        if (r15 == null) goto L66;
        com.bytedance.android.livesdk.linkvideo.b r16 = r15.getLinkVideoTea();
        if (r16 == null) goto L67;
        boolean r1 = this.F;
        String r17 = v6.a();
        if (r12 == null) goto L53;
        Long r18 = r12.b();
        if (r18 == null) goto L53;
        r3 = r18.longValue();
    L53:
        r16.e(r1, r17, String.valueOf(r3));
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L30:
        MultiTypeAdapter r19 = this.z;
        if (r19 == null) goto L40;
        List r20 = r19.a;
        if (r20 == null) goto L40;
        Iterator r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L40;
        Object r22 = r21.next();
        if ((r22 instanceof gf2.a) == false) goto L36;
        ((gf2.a) r22).a = false;
    L11:
        r6 = 0;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131565380, r10, true);
        this.t = r12;
        Dialog r13 = getDialog();
        ImageView r14 = null;
        if (r13 == null) goto L5;
        Window r15 = r13.getWindow();
    L6:
        if (r15 == null) goto L8;
        WindowManager.LayoutParams r1 = r15.getAttributes();
    L9:
        if (r1 == null) goto L11;
        r1.gravity = 80;
    L11:
        if (r15 == null) goto L13;
        r15.setAttributes(r1);
    L13:
        Bundle r16 = getArguments();
        if (r16 == null) goto L16;
        int r17 = r16.getInt("key_state", 1);
    L17:
        this.d = r17;
        Bundle r18 = getArguments();
        String r2 = "";
        if (r18 == null) goto L23;
        String r19 = r18.getString("key_extra", "");
        if (r19 == null) goto L23;
        r2 = r19;
    L23:
        this.e = r2;
        Bundle r110 = getArguments();
        if (r110 == null) goto L26;
        long r3 = r110.getLong("key_preview_id", 0);
    L27:
        this.f = r3;
        if (r12 == null) goto L90;
        this.j = r12.findViewById(2131372772);
        this.k = r12.findViewById(2131378823);
        Button r4 = (Button) r12.findViewById(2131364807);
        if (r4 == null) goto L33;
        r4.setOnClickListener(this);
        Unit r5 = Unit.INSTANCE;
    L33:
        this.l = r12.findViewById(2131378674);
        this.m = r12.findViewById(2131376208);
        this.y = r12.findViewById(2131392336);
        this.B = r12.findViewById(2131362959);
        this.C = r12.findViewById(2131366908);
        Button r6 = (Button) r12.findViewById(2131364750);
        if (r6 == null) goto L36;
        r6.setOnClickListener(this);
        Unit r7 = Unit.INSTANCE;
    L37:
        this.n = r6;
        Button r8 = (Button) r12.findViewById(2131364673);
        if (r8 == null) goto L40;
        r8.setOnClickListener(this);
        Unit r20 = Unit.INSTANCE;
    L41:
        this.o = r8;
        Button r21 = (Button) r12.findViewById(2131364641);
        if (r21 == null) goto L44;
        r21.setOnClickListener(this);
        Unit r22 = Unit.INSTANCE;
    L45:
        this.p = r21;
        this.x = r12.findViewById(2131366915);
        View r23 = r12.findViewById(2131366840);
        if (r23 == null) goto L48;
        r23.post(new com.bytedance.android.livesdk.linkvideo.ui.c(r23, this));
        Unit r24 = Unit.INSTANCE;
    L49:
        this.N = r23;
        this.q = (TextView) r12.findViewById(2131391606);
        this.u = (FrameLayout) r12.findViewById(2131378433);
        this.v = (TextView) r12.findViewById(2131390882);
        Drawable r25 = s1.m(2131251139);
        if (r25 == null) goto L54;
        r25.setBounds(s1.f(4.0f) + 0, 0, s1.f(12.0f) + s1.f(4.0f), s1.f(12.0f));
        TextView r26 = this.v;
        if (r26 == null) goto L54;
        r26.setCompoundDrawables(r25, null, null, null);
    L54:
        MultiTypeAdapter r27 = new MultiTypeAdapter();
        this.z = r27;
        r27.a = new ArrayList();
        MultiTypeAdapter r28 = this.z;
        if (r28 == null) goto L57;
        r28.z2(gf2.a.class, new com.bytedance.android.livesdk.linkvideo.view.a(this));
    L57:
        MultiTypeAdapter r29 = this.z;
        if (r29 == null) goto L60;
        r29.z2(com.bytedance.android.livesdk.linkvideo.view.f.class, new com.bytedance.android.livesdk.linkvideo.view.e());
    L60:
        final GridLayoutManager r30 = new GridLayoutManager(getContext(), 3);
        r30.setSpanSizeLookup(new LinkVideoDialog$initViews$7(this));
        RecyclerView r31 = this.y;
        if (r31 == null) goto L63;
        r31.setLayoutManager(r30);
    L63:
        RecyclerView r32 = this.y;
        if (r32 == null) goto L66;
        r32.addItemDecoration(new LinkVideoDialog$initViews$8());
    L66:
        RecyclerView r33 = this.y;
        if (r33 == null) goto L69;
        r33.setAdapter(this.z);
    L69:
        RecyclerView r34 = this.y;
        if (r34 == null) goto L72;
        r34.addOnScrollListener(new LinkVideoDialog$initViews$9(this, r30));
    L72:
        MultiTypeAdapter r35 = this.z;
        if (r35 == null) goto L75;
        r35.registerAdapterDataObserver(new LinkVideoDialog$initViews$10(this));
    L75:
        LoadMoreScrollListener r36 = new LoadMoreScrollListener(r30, new LinkVideoDialog$initViews$11(this));
        this.A = r36;
        RecyclerView r37 = this.y;
        if (r37 == null) goto L78;
        r37.addOnScrollListener(r36);
    L78:
        ImageView r38 = (ImageView) r12.findViewById(2131376031);
        if (r38 == null) goto L81;
        r38.setOnClickListener(this);
        Unit r39 = Unit.INSTANCE;
    L82:
        this.r = r38;
        ImageView r40 = (ImageView) r12.findViewById(2131376533);
        if (r40 == null) goto L85;
        r40.setOnClickListener(this);
        Unit r111 = Unit.INSTANCE;
        r14 = r40;
    L85:
        this.s = r14;
        if (this.d != 1) goto L90;
        AnchorLinkVideoListViewModel r112 = this.i;
        if (r112 == null) goto L90;
        r112.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        goto L90
    L81:
        r38 = null;
        goto L82
    L48:
        r23 = null;
        goto L49
    L44:
        r21 = null;
        goto L45
    L40:
        r8 = null;
        goto L41
    L36:
        r6 = null;
    L90:
        Y90(this.d);
        if (this.d == 1) goto L96;
        long r41 = this.f;
        if (r41 <= 0) goto L95;
        this.I = r41;
        X90(r41);
        goto L96
    L95:
        f2.b(2131915225, 0);
    L96:
        return r12;
    L26:
        r3 = 0;
        goto L27
    L16:
        r17 = 1;
        goto L17
    L8:
        r1 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }
}
