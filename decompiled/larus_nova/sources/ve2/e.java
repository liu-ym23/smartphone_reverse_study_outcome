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
import com.bytedance.android.livesdk.chatroom.model.c2;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.ktvimpl.multichorus.api.MultiChorusApi;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements ve2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f554324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f554325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f554326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f554327d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f554328a = null;

        static {
            f554328a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply success");
            hd0.c.f().k(0);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f554329a = null;

        static {
            f554329a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply failed " + ((Throwable) r100).getMessage());
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f554330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f554331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f554332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h80.a f554333d;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f554334a;

            public a(d r100) {
                this.f554334a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                this.f554334a.f554333d.accept(Boolean.TRUE);
                ALogger.w("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApplyPermit, success, " + ((com.bytedance.android.live.network.response.e) r100).logId);
                this.f554334a.f554330a.f554327d.put("cmd_ktv_component_init_link", new c2(8, 6));
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f554335a = null;

            static {
                f554335a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                ALogger.w("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApplyPermit, failure, logId=" + ke2.a.c(r101));
                if ((r101 instanceof ApiServerException) == false) goto L8;
                ApiServerException r102 = (ApiServerException) r101;
                if (r2.a(r102.getPrompt()) == false) goto L9;
                f2.c(r102.getPrompt(), 0);
                return;
            L9:
                return;
            }
        }

        public d(e r100, Ref.LongRef r101, IBaseUser r102, h80.a r103) {
            this.f554330a = r100;
            this.f554331b = r101;
            this.f554332c = r102;
            this.f554333d = r103;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            MultiChorusApi r102 = (MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class);
            if (r102 == null) goto L12;
            Observable<com.bytedance.android.live.network.response.e<Object>> r103 = r102.multiChorusPrepareApplyPermit(this.f554331b.element, d5.c(this.f554332c.getIdString()), this.f554332c.getIdString());
            if (r103 == null) goto L13;
            Observable<R> r104 = r103.compose(RxUtil.rxSchedulerHelper());
            if (r104 == 0) goto L14;
            Disposable r105 = r104.subscribe(new a(this), b.f554335a);
            if (r105 == null) goto L15;
            RxUtilKt.c(r105, this.f554330a.f554324a);
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
    public static final class DialogInterfaceOnClickListenerC7989e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h80.a f554336a;

        public DialogInterfaceOnClickListenerC7989e(h80.a r100) {
            this.f554336a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            this.f554336a.accept(Boolean.FALSE);
            int r102 = ke2.b.f503019a;
            ke2.b.a("cancel");
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f554326c;
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r100) {
        if (this.f554325b == true) goto L7;
        if (r100 == null) goto L15;
        r100.accept(Boolean.TRUE);
        return;
    L15:
        return;
    L7:
        o r101 = m.i();
        if (r101 == null) goto L16;
        com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L17;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L18;
        long r104 = r103.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "cancelMultiChorusPrepareApply -----------");
        RxUtilKt.c(((MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class)).multiChorusCancelPrepareApply(r104).compose(RxUtil.rxSchedulerHelper()).subscribe(b.f554328a, c.f554329a), this.f554324a);
        return;
    L18:
        return;
    L17:
        return;
    }

    public e(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f554326c = r100;
        this.f554327d = r101;
        this.f554324a = new CompositeDisposable();
    }

    @Override // ve2.a
    public final void a(MusicPanel r100, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, "music");
        Intrinsics.checkNotNullParameter(r101, "applyCallback");
        o r102 = m.i();
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L16;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L17;
        long r105 = r104.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply -----------");
        RxUtilKt.c(((MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class)).multiChorusPrepareApply(r105, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r101), new g(r101)), this.f554324a);
        IInteractService r106 = (IInteractService) k.f(IInteractService.class);
        if (r106 == null) goto L13;
        rj0.m r107 = r106.getVideoTalkService();
        if (r107 == null) goto L13;
        r107.x("推荐", LinkApplyType.KTV_MULTI_CHORUS);
    L13:
        int r108 = ke2.b.f503019a;
        ke2.b.i("live_chorus");
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // ve2.a
    public final void b(Context r100, IRoom r101, com.bytedance.android.livesdk.ktvimpl.multichorus.d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "listener");
        OperateType r103 = OperateType.PRE_APPLY;
        ArrayList r104 = new ArrayList();
        r104.add(qh0.g.a(r103, 2));
        r104.add(new qh0.f.g(r100, r103, 2));
        r104.add(new qh0.f.c(r100, r103, 2));
        r104.add(new qh0.f.a(r100));
        r104.add(new qh0.f.d(r100, r103, 2, true));
        r104.add(new qh0.f.C7326f(r100, r103, 2, true));
        r104.add(new qh0.f.e(r100, r103));
        qh0.f.a(r104).a(new h(r102));
    }

    @Override // ve2.a
    public final void i5(IBaseUser r100, h80.a<Boolean> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        Intrinsics.checkNotNullParameter(r102, "requestPage");
        Ref.LongRef r103 = new Ref.LongRef();
        o r104 = m.i();
        if (r104 == null) goto L10;
        com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();
        if (r105 == null) goto L11;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L12;
        r103.element = r106.getRoomId();
        c9.a r107 = new c9.a(this.f554326c);
        r107.d(R.string.ttlive_ktv_component_anchor_permit_dialog_title);
        r107.a(R.string.ttlive_ktv_component_anchor_permit_dialog_content);
        r107.c(R.string.ttlive_confirm, new d(this, r103, r100, r101));
        r107.b(R.string.ttlive_cancel, new DialogInterfaceOnClickListenerC7989e(r101));
        r107.e();
        return;
    L12:
        return;
    L11:
        return;
    }
}
