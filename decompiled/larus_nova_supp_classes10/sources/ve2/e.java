package ve2;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.c2;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.ktvimpl.multichorus.api.MultiChorusApi;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements ve2.a {
    public final CompositeDisposable a;
    public boolean b;
    public final Context c;
    public final DataCenter d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply success");
            hd0.c.f().k(0);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply failed " + ((Throwable) r3).getMessage());
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ IBaseUser c;
        public final /* synthetic */ h80.a d;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                this.a.d.accept(Boolean.TRUE);
                ALogger.w("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApplyPermit, success, " + ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r4)).logId);
                this.a.a.d.put("cmd_ktv_component_init_link", new c2(8, 6));
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r3) {
                ApiServerException r4 = (Throwable) r3;
                ALogger.w("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApplyPermit, failure, logId=" + ke2.a.c(r4));
                if ((r4 instanceof ApiServerException) == false) goto L8;
                ApiServerException r5 = r4;
                if (r2.a(r5.getPrompt()) == false) goto L9;
                f2.c(r5.getPrompt(), 0);
                return;
            L9:
                return;
            }
        }

        public d(e r1, Ref.LongRef r2, IBaseUser r3, h80.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            r7.dismiss();
            MultiChorusApi r0 = (MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class);
            if (r0 == null) goto L12;
            Observable<com.bytedance.android.live.network.response.e<Object>> r9 = r0.multiChorusPrepareApplyPermit(this.b.element, d5.c(this.c.getIdString()), this.c.getIdString());
            if (r9 == null) goto L13;
            Observable r10 = r9.compose(RxUtil.rxSchedulerHelper());
            if (r10 == null) goto L14;
            Disposable r11 = r10.subscribe(new a(this), b.a);
            if (r11 == null) goto L15;
            RxUtilKt.c(r11, this.a.a);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    /* JADX INFO: renamed from: ve2.e$e, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC0182e implements DialogInterface.OnClickListener {
        public final /* synthetic */ h80.a a;

        public DialogInterfaceOnClickListenerC0182e(h80.a r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.accept(Boolean.FALSE);
            int r3 = ke2.b.a;
            ke2.b.a("cancel");
        }
    }

    static {
    }

    public final Context getContext() {
        return this.c;
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r4) {
        if (this.b == true) goto L7;
        if (r4 == null) goto L15;
        r4.accept(Boolean.TRUE);
        return;
    L15:
        return;
    L7:
        o r5 = m.i();
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L17;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L18;
        long r0 = r7.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply -----------");
        RxUtilKt.c(((MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class)).multiChorusCancelPrepareApply(r0).compose(RxUtil.rxSchedulerHelper()).subscribe(b.a, c.a), this.a);
        return;
    L18:
        return;
    L17:
        return;
    }

    public e(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
    }

    @Override // ve2.a
    public final void a(MusicPanel r4, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r5) {
        Intrinsics.checkNotNullParameter(r4, "music");
        Intrinsics.checkNotNullParameter(r5, "applyCallback");
        o r6 = m.i();
        if (r6 == null) goto L15;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L16;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L17;
        long r0 = r8.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply -----------");
        RxUtilKt.c(((MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class)).multiChorusPrepareApply(r0, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r5), new g(r5)), this.a);
        IInteractService r9 = k.f(IInteractService.class);
        if (r9 == null) goto L13;
        rj0.m r10 = r9.getVideoTalkService();
        if (r10 == null) goto L13;
        r10.x("推荐", LinkApplyType.KTV_MULTI_CHORUS);
    L13:
        int r11 = ke2.b.a;
        ke2.b.i("live_chorus");
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // ve2.a
    public final void b(Context r5, IRoom r6, com.bytedance.android.livesdk.ktvimpl.multichorus.d r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.PRE_APPLY;
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r8, 2));
        r0.add(new qh0.f.g(r5, r8, 2));
        r0.add(new qh0.f.c(r5, r8, 2));
        r0.add(new qh0.f.a(r5));
        r0.add(new qh0.f.d(r5, r8, 2, true));
        r0.add(new qh0.f.f(r5, r8, 2, true));
        r0.add(new qh0.f.e(r5, r8));
        qh0.f.a(r0).a(new h(r7));
    }

    @Override // ve2.a
    public final void i5(IBaseUser r3, h80.a<Boolean> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "consumer");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Ref.LongRef r6 = new Ref.LongRef();
        o r0 = m.i();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        r6.element = r2.getRoomId();
        c9.a r7 = new c9.a(this.c);
        r7.d(2131918280);
        r7.a(2131918279);
        r7.c(2131915913, new d(this, r6, r3, r4));
        r7.b(2131915442, new DialogInterfaceOnClickListenerC0182e(r4));
        r7.e();
        return;
    L12:
        return;
    L11:
        return;
    }
}
