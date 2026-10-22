package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.anchor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KtvComponentProgressView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/anchor/AnchorKtvComponentStrategy;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "getContext", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorKtvComponentStrategy implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a, Observer<KVData> {
    public static final /* synthetic */ int n = 0;
    public com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b a;
    public TextView b;
    public View c;
    public final CompositeDisposable d;
    public LiveWidget e;
    public Function2<? super String, ? super JSONObject, Unit> f;
    public boolean g;
    public Integer h;
    public Integer i;
    public long j;
    public boolean k;
    public boolean l;
    public Function1<? super Long, Unit> m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;

        public b(AnchorKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r3;
            AnchorKtvComponentStrategy r0 = this.a;
            if (r0.k == false) goto L5;
            return;
        L5:
            if (r0.l == false) goto L9;
            r0.n(Integer.valueOf(r4.a), Integer.valueOf(r4.b));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;

        public c(AnchorKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r4;
            AnchorKtvComponentStrategy r0 = this.a;
            if (r0.l == true) goto L5;
            return;
        L5:
            if (r0.k == true) goto L7;
            r0.m(Integer.valueOf(r5.a), Integer.valueOf(r5.b));
        L7:
            AnchorKtvComponentStrategy r1 = this.a;
            r1.h = Integer.valueOf(r5.a);
            AnchorKtvComponentStrategy r2 = this.a;
            r2.i = Integer.valueOf(r5.b);
        }
    }

    public static final class d<T> implements Observer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void onChanged(Object r3) {
            StateMachine.c.b r4 = (StateMachine.c.b) r3;
            ChorusContext.a r0 = ChorusContext.Companion;
            if (r0.c() == true) goto L5;
            return;
        L5:
            if (r0.a() != 2) goto L44;
            KtvRoomLyricsStateMachineConfig.d r1 = null;
            if (r4 == null) goto L9;
            KtvRoomLyricsStateMachineConfig.d r2 = (KtvRoomLyricsStateMachineConfig.d) r4.a;
        L11:
            if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L17;
            if (r4 == null) goto L14;
            KtvRoomLyricsStateMachineConfig.d r5 = (KtvRoomLyricsStateMachineConfig.d) r4.c;
        L16:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L17;
        L32:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6 = KSongTuningPanelHelperKt.d();
            if (r6 == null) goto L45;
            r6.c();
            return;
        L45:
            return;
        L14:
            r5 = null;
        L17:
            if (r4 == null) goto L19;
            KtvRoomLyricsStateMachineConfig.d r7 = (KtvRoomLyricsStateMachineConfig.d) r4.a;
        L21:
            if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L35;
            if (r4 == null) goto L24;
            KtvRoomLyricsStateMachineConfig.d r8 = (KtvRoomLyricsStateMachineConfig.d) r4.a;
        L26:
            if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L35;
            if (r4 == null) goto L29;
            KtvRoomLyricsStateMachineConfig.d r9 = (KtvRoomLyricsStateMachineConfig.d) r4.c;
        L31:
            if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L35;
        L29:
            r9 = null;
            goto L31
        L24:
            r8 = null;
        L35:
            if (r4 == null) goto L38;
            r1 = (KtvRoomLyricsStateMachineConfig.d) r4.c;
        L38:
            if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L47;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = KSongTuningPanelHelperKt.d();
            if (r10 == null) goto L48;
            r10.C();
            return;
        L48:
            return;
        L47:
            return;
        L19:
            r7 = null;
            goto L21
        L9:
            r2 = null;
            goto L11
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;

        public e(AnchorKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Long r8 = (Long) r7;
            if (r8 == null) goto L5;
            long r2 = r8.longValue();
        L6:
            KtvComponentContext.a r9 = KtvComponentContext.Companion;
            KtvComponentContext r4 = r9.getContext();
            if (r4 == null) goto L9;
            long r5 = r4.getListenApplyUnreadCount();
        L10:
            KtvComponentContext r10 = r9.getContext();
            if (r10 == null) goto L20;
            n<KtvComponentUIContext> r11 = r10.getKtvComponentUIContext();
            if (r11 == null) goto L20;
            KtvComponentUIContext r12 = (KtvComponentUIContext) r11.getValue();
            if (r12 == null) goto L20;
            MutableLiveData<Long> r13 = r12.getUnreadMultiChorusApplyNum();
            if (r13 == null) goto L20;
            Long r14 = (Long) r13.getValue();
            if (r14 == null) goto L20;
        L21:
            AnchorKtvComponentStrategy.l(this.a, (r14.longValue() + r2) + r5);
            return;
        L20:
            r14 = 0L;
            goto L21
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;
        public final /* synthetic */ KtvComponentUIContext b;

        public f(AnchorKtvComponentStrategy r1, KtvComponentUIContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            Long r9 = (Long) r8;
            Long r0 = this.b.getSingApplyUnreadNum();
            long r1 = 0;
            if (r0 == null) goto L5;
            long r3 = r0.longValue();
        L6:
            KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
            if (r2 == null) goto L16;
            n<KtvComponentUIContext> r4 = r2.getKtvComponentUIContext();
            if (r4 == null) goto L16;
            KtvComponentUIContext r5 = (KtvComponentUIContext) r4.getValue();
            if (r5 == null) goto L16;
            MutableLiveData<Long> r6 = r5.getUnreadMultiChorusApplyNum();
            if (r6 == null) goto L16;
            Long r7 = (Long) r6.getValue();
            if (r7 == null) goto L16;
        L17:
            long r10 = r7.longValue();
            if (r9 == null) goto L20;
            r1 = r9.longValue();
        L20:
            AnchorKtvComponentStrategy.l(this.a, (r10 + r3) + r1);
            return;
        L16:
            r7 = 0L;
            goto L17
        L5:
            r3 = 0;
            goto L6
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;
        public final /* synthetic */ KtvComponentUIContext b;

        public g(AnchorKtvComponentStrategy r1, KtvComponentUIContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            Long r9 = (Long) r8;
            Long r0 = this.b.getSingApplyUnreadNum();
            long r1 = 0;
            if (r0 == null) goto L5;
            long r3 = r0.longValue();
        L6:
            KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
            if (r2 == null) goto L9;
            long r5 = r2.getListenApplyUnreadCount();
        L10:
            if (r9 == null) goto L12;
            r1 = r9.longValue();
        L12:
            AnchorKtvComponentStrategy.l(this.a, (r1 + r3) + r5);
            return;
        L9:
            r5 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;
        public final /* synthetic */ KtvComponentUIContext b;

        public h(AnchorKtvComponentStrategy r1, KtvComponentUIContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            KtvComponentUIContext r7 = this.b;
            long r0 = 0;
            if (r7 == null) goto L7;
            Long r8 = r7.getSingApplyUnreadNum();
            if (r8 == null) goto L7;
            long r2 = r8.longValue();
        L8:
            KtvComponentContext r9 = KtvComponentContext.Companion.getContext();
            if (r9 == null) goto L11;
            r0 = r9.getListenApplyUnreadCount();
        L11:
            AnchorKtvComponentStrategy.l(this.a, r0 + r2);
            return;
        L7:
            r2 = 0;
            goto L8
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvComponentUIContext a;

        public i(KtvComponentUIContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            KtvComponentUIContext r5 = this.a;
            if (r5 == null) goto L6;
            r5.setSingApplyUnreadNum(0);
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;

        public j(AnchorKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.k r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.k) r4;
            AnchorKtvComponentStrategy r0 = this.a;
            if (r0.k == false) goto L5;
            return;
        L5:
            if (r0.l == true) goto L7;
            return;
        L7:
            if (r5.c == false) goto L27;
            u r6 = o3.d();
            Integer r1 = null;
            if (r6 == null) goto L17;
            com.bytedance.live.datacontext.j r7 = r6.getVideoTalkRoomSubScene();
            if (r7 == null) goto L17;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
            if (r8 == null) goto L17;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = r8.h();
            if (r9 == null) goto L17;
            Integer r10 = Integer.valueOf(r9.a);
        L18:
            u r2 = o3.d();
            if (r2 == null) goto L28;
            com.bytedance.live.datacontext.j r3 = r2.getVideoTalkRoomSubScene();
            if (r3 == null) goto L28;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
            if (r11 == null) goto L28;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r11.h();
            if (r12 == null) goto L28;
            r1 = Integer.valueOf(r12.c);
        L28:
            this.a.n(r10, r1);
            return;
        L17:
            r10 = null;
            goto L18
        L27:
            Integer r13 = Integer.valueOf(r5.a);
            r1 = Integer.valueOf(r5.b);
            r10 = r13;
            goto L28
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AnchorKtvComponentStrategy a;

        public k(AnchorKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.k r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.k) r4;
            AnchorKtvComponentStrategy r0 = this.a;
            if (r0.l == true) goto L5;
            return;
        L5:
            if (r0.k == true) goto L7;
            r0.m(Integer.valueOf(r5.a), Integer.valueOf(r5.b));
        L7:
            AnchorKtvComponentStrategy r1 = this.a;
            r1.h = Integer.valueOf(r5.a);
            AnchorKtvComponentStrategy r2 = this.a;
            r2.i = Integer.valueOf(r5.b);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final int getLayoutId() {
        return 2131566474;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void j() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void c() {
        if (this.g == false) goto L5;
        ke2.b.e("sing_song", false);
    L5:
        this.g = false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void g() {
        if (this.g == false) goto L5;
        String r0 = "score";
    L6:
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        long r2 = 0;
        if (r1 == null) goto L20;
        n<KtvComponentUIContext> r3 = r1.getKtvComponentUIContext();
        if (r3 == null) goto L20;
        KtvComponentUIContext r4 = (KtvComponentUIContext) r3.getValue();
        if (r4 == null) goto L20;
        Long r5 = r4.getListenApplyUnreadNum();
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
    L16:
        Long r7 = r4.getSingApplyUnreadNum();
        if (r7 == null) goto L19;
        r2 = r7.longValue();
    L19:
        r2 = r2 + r6;
        goto L20
    L15:
        r6 = 0;
    L20:
        int r8 = ke2.b.a;
        ke2.b.d(r0, this.g, Long.valueOf(r2), null, 16);
        return;
    L5:
        r0 = "sing_song";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public Context getContext() {
        LiveWidget r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((Widget) r0).context;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final DataCenter getDataCenter() {
        LiveWidget r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDataCenter();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void onDestroy() {
        this.d.dispose();
        LiveWidget r0 = this.e;
        if (r0 == null) goto L8;
        DataCenter r1 = ((Widget) r0).dataCenter;
        if (r1 == null) goto L9;
        r1.removeObserver(this);
        return;
    L9:
        return;
    }

    public AnchorKtvComponentStrategy() {
        Unit r0 = Unit.INSTANCE;
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void b(Function1<? super Long, Unit> r1) {
        this.m = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void d(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L8;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void e(int r2) {
        if (this.g == true) goto L6;
        ke2.b.e("score", false);
        this.g = true;
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void f(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L8;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L8;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void i(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L8;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r5 = r4.getKey();
    L6:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.hashCode() == (-774172322)) goto L12;
        return;
    L12:
        if (r5.equals("cmd_dismiss_dialog_end") == false) goto L15;
        this.k = true;
        return;
    L15:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void l(AnchorKtvComponentStrategy r5, long r6) {
        r5.getClass();
        KtvContext.Companion.getClass();
        if (KtvContext.a.i() == false) goto L10;
        View r7 = r5.c;
        if (r7 == null) goto L7;
        r7.setVisibility(0);
    L7:
        TextView r8 = r5.b;
        if (r8 == null) goto L30;
        r8.setVisibility(8);
        return;
    L30:
        return;
    L10:
        View r0 = r5.c;
        if (r0 == null) goto L14;
        r0.setVisibility(8);
    L14:
        if (r6 != 0) goto L18;
        TextView r1 = r5.b;
        if (r1 == null) goto L24;
        r1.setVisibility(8);
    L24:
        LiveWidget r9 = r5.e;
        if (r9 == null) goto L32;
        DataCenter r10 = ((Widget) r9).dataCenter;
        if (r10 == null) goto L33;
        r10.put("data_ksong_unread_count", Integer.valueOf((int) r6));
        return;
    L33:
        return;
    L32:
        return;
    L18:
        TextView r2 = r5.b;
        if (r2 == null) goto L21;
        r2.setText(String.valueOf(r6));
    L21:
        TextView r3 = r5.b;
        if (r3 == null) goto L24;
        r3.setVisibility(0);
        goto L24
    }

    public final void m(Integer r4, Integer r5) {
        String r0 = KtvLoggerHelper.D(this.h, this.i);
        String r6 = KtvLoggerHelper.D(r4, r5);
        boolean r7 = Intrinsics.areEqual(r0, r6);
        boolean r1 = true;
        if ((!r7) == false) goto L34;
        long r2 = System.currentTimeMillis();
        this.j = r2;
        Function1<? super Long, Unit> r8 = this.m;
        if (r8 == null) goto L7;
        Unit r9 = (Unit) r8.invoke(Long.valueOf(r2));
    L7:
        KtvComponentContext.a r10 = KtvComponentContext.Companion;
        KtvComponentContext r3 = r10.getContext();
        Integer r11 = null;
        if (r3 == null) goto L12;
        n<Boolean> r12 = r3.isAudienceEnableSing();
        if (r12 == null) goto L12;
        Boolean r13 = (Boolean) r12.getValue();
    L13:
        KtvComponentContext r14 = r10.getContext();
        if (r14 == null) goto L18;
        n<Integer> r15 = r14.getOpenSource();
        if (r15 == null) goto L18;
        r11 = (Integer) r15.getValue();
    L18:
        if (r11 != null) goto L21;
    L23:
        r1 = false;
    L25:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L27;
        String r16 = "on";
    L28:
        int r17 = ke2.b.a;
        if (r1 == false) goto L31;
        String r18 = "auto";
    L32:
        ke2.b.f(r18, r16, r6, r6);
        return;
    L31:
        r18 = "function_switch";
        goto L32
    L27:
        r16 = "off";
        goto L28
    L21:
        if (r11.intValue() != 2) goto L23;
    L12:
        r13 = null;
        goto L13
    }

    public final void n(Integer r8, Integer r9) {
        String r5 = KtvLoggerHelper.D(r8, r9);
        long r2 = (System.currentTimeMillis() - this.j) / 1000;
        if (r2 <= 0) goto L32;
        KtvComponentContext.a r10 = KtvComponentContext.Companion;
        KtvComponentContext r11 = r10.getContext();
        if (r11 == null) goto L9;
        n<Boolean> r12 = r11.isAudienceEnableSing();
        if (r12 == null) goto L9;
        Boolean r13 = (Boolean) r12.getValue();
    L10:
        KtvComponentContext r14 = r10.getContext();
        if (r14 == null) goto L15;
        n<Integer> r15 = r14.getOpenSource();
        if (r15 == null) goto L15;
        Integer r16 = (Integer) r15.getValue();
    L16:
        if (r16 != null) goto L19;
    L21:
        boolean r17 = false;
    L23:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L25;
        String r18 = "on";
    L26:
        String r1 = r18;
        int r19 = ke2.b.a;
        if (r17 == false) goto L29;
        String r6 = "auto";
    L30:
        ke2.b.c("function_switch", r1, r2, r5, r5, r6);
        return;
    L29:
        r6 = null;
        goto L30
    L25:
        r18 = "off";
        goto L26
    L19:
        if (r16.intValue() != 2) goto L21;
        r17 = true;
    L15:
        r16 = null;
    L9:
        r13 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void k(LiveWidget r6, KtvComponentUIContext r7, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r8, Function2<? super String, ? super JSONObject, Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        Intrinsics.checkNotNullParameter(r8, "ktvComponentCommonUIViewHolder");
        Intrinsics.checkNotNullParameter(r9, "seiSender");
        this.j = System.currentTimeMillis();
        this.a = r8;
        this.f = r9;
        this.e = r6;
        ((Widget) r6).dataCenter.observe("cmd_dismiss_dialog_end", this);
        this.b = (TextView) r6.findViewById(2131376868);
        this.c = r6.findViewById(2131376928);
        ImageView r10 = (ImageView) r6.findViewById(2131376970);
        if (r10 == null) goto L5;
        r10.setImageResource(2131252047);
    L5:
        if (r7 == null) goto L9;
        NextLiveData<Long> r11 = r7.getApplySingUnreadNum();
        if (r11 == null) goto L9;
        r11.observe(r6, new e(this));
    L9:
        if (r7 == null) goto L13;
        NextLiveData<Long> r12 = r7.getApplyListenUnreadNum();
        if (r12 == null) goto L13;
        r12.observe(r6, new f(this, r7));
    L13:
        if (r7 == null) goto L17;
        MutableLiveData<Long> r13 = r7.getUnreadMultiChorusApplyNum();
        if (r13 == null) goto L17;
        r13.observe(r6, new g(this, r7));
    L17:
        KtvContext.Companion.getClass();
        KtvContext r14 = KtvContext.a.g();
        if (r14 == null) goto L24;
        n<Long> r15 = r14.getKtvAddDressVersion();
        if (r15 == null) goto L24;
        Observable r16 = r15.a();
        if (r16 == null) goto L24;
        r16.subscribe(new h(this, r7));
    L24:
        KtvComponentContext r17 = KtvComponentContext.Companion.getContext();
        if (r17 == null) goto L33;
        n<Boolean> r18 = r17.isAudienceEnableSing();
        if (r18 == null) goto L33;
        Observable r19 = r18.a();
        if (r19 == null) goto L33;
        Disposable r20 = r19.subscribe(new i(r7));
        if (r20 == null) goto L33;
        RxUtilKt.c(r20, this.d);
    L33:
        ViewGroup r21 = r8.f;
        if (r21 == null) goto L36;
        r21.setVisibility(0);
    L36:
        KtvComponentProgressView r22 = r8.g;
        if (r22 == null) goto L39;
        r22.setProgress(100.0f);
    L39:
        int r23 = ge2.a.a;
        float r0 = z0.b(true);
        Integer r2 = null;
        if (r0 > 0) goto L42;
    L44:
        boolean r1 = false;
    L45:
        if (r1 == true) goto L49;
        AbstractDraweeController r3 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(com.bytedance.android.live.ktv.common.util.n.a((String) vm2.h.m1.getValue(null, vm2.h.a[115(0x73, float:1.61E-43)])))).setAutoPlayAnimations(true).build();
        HSImageView r24 = r8.j;
        if (r24 == null) goto L61;
        r24.setController(r3);
    L61:
        ke2.b.e("sing_song", false);
        if (KtvContext.a.m() == false) goto L85;
        u r25 = o3.d();
        if (r25 == null) goto L74;
        com.bytedance.live.datacontext.j r26 = r25.getVideoTalkRoomSubScene();
        if (r26 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r27 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r26.getValue();
        if (r27 == null) goto L74;
        BehaviorSubject r28 = r27.i();
        if (r28 == null) goto L74;
        Disposable r29 = r28.subscribe(new j(this));
        if (r29 == null) goto L74;
        RxUtilKt.c(r29, this.d);
    L74:
        u r30 = o3.d();
        if (r30 == null) goto L107;
        com.bytedance.live.datacontext.j r31 = r30.getVideoTalkRoomSubScene();
        if (r31 == null) goto L107;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r31.getValue();
        if (r32 == null) goto L107;
        BehaviorSubject r33 = r32.d();
        if (r33 == null) goto L107;
        Disposable r34 = r33.subscribe(new k(this));
        if (r34 == null) goto L107;
        RxUtilKt.c(r34, this.d);
    L107:
        Observable r35 = xs2.b.a().b(zg1.j.class);
        if (r35 == null) goto L114;
        Observable r36 = r35.observeOn(AndroidSchedulers.mainThread());
        if (r36 == null) goto L114;
        final AnchorKtvComponentStrategy$onWidgetCreate$12 r4 = new AnchorKtvComponentStrategy$onWidgetCreate$12(this);
        Disposable r37 = r36.subscribe(new l(r4));
        if (r37 == null) goto L114;
        RxUtilKt.c(r37, this.d);
    L114:
        IInteractService r38 = jc1.k.f(IInteractService.class);
        if (r38 == null) goto L117;
        Integer r39 = Integer.valueOf(r38.getCurrentScene());
    L118:
        this.h = r39;
        IInteractService r40 = jc1.k.f(IInteractService.class);
        if (r40 == null) goto L121;
        r2 = Integer.valueOf(r40.getCurrentUiLayout());
    L121:
        this.i = r2;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r41 = KtvContext.a.g().getKtvCoreViewModel();
        if (r41 == null) goto L126;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r42 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r41.getValue();
        if (r42 == null) goto L126;
        r42.observeState(r6, d.a, false);
    L126:
        this.l = true;
        return;
    L117:
        r39 = null;
        goto L118
    L85:
        u r43 = o3.d();
        if (r43 == null) goto L96;
        com.bytedance.live.datacontext.j r44 = r43.s();
        if (r44 == null) goto L96;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r45 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r44.getValue();
        if (r45 == null) goto L96;
        BehaviorSubject r46 = r45.b();
        if (r46 == null) goto L96;
        Disposable r47 = r46.subscribe(new b(this));
        if (r47 == null) goto L96;
        RxUtilKt.c(r47, this.d);
    L96:
        u r48 = o3.d();
        if (r48 == null) goto L107;
        com.bytedance.live.datacontext.j r49 = r48.s();
        if (r49 == null) goto L107;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r50 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r49.getValue();
        if (r50 == null) goto L107;
        BehaviorSubject r51 = r50.a();
        if (r51 == null) goto L107;
        Disposable r52 = r51.subscribe(new c(this));
        if (r52 == null) goto L107;
        RxUtilKt.c(r52, this.d);
        goto L107
    L49:
        HSImageView r5 = r8.j;
        if (r5 == null) goto L52;
        ViewParent r53 = r5.getParent();
    L54:
        if ((r53 instanceof ViewGroup) == true) goto L56;
        r53 = null;
    L56:
        ViewGroup r54 = (ViewGroup) r53;
        if (r54 == null) goto L61;
        HSImageView r55 = r8.j;
        if (r55 == null) goto L61;
        r54.removeView(r55);
        goto L61
    L52:
        r53 = null;
        goto L54
    L42:
        if (r0 >= ((Number) vm2.h.c3.getValue(null, vm2.h.a[209(0xd1, float:2.93E-43)])).floatValue()) goto L44;
        r1 = true;
        goto L45
    }
}
