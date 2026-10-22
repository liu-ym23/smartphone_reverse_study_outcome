package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.c2;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rj0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentSingleBroadcastStrategy implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a {
    public final CompositeDisposable a;
    public boolean b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
        public final /* synthetic */ h80.a b;
        public final /* synthetic */ long c;

        public b(KtvComponentSingleBroadcastStrategy r1, h80.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_cancel_prepare_apply, success, " + ((ExtraResponse) r8).logId);
            h80.a r0 = this.b;
            if (r0 == null) goto L5;
            r0.accept(Boolean.TRUE);
        L5:
            this.a.b = false;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiCancelAddSongPrepareApply, System.currentTimeMillis() - this.c, ((ExtraResponse) r8).logId);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
        public final /* synthetic */ h80.a b;
        public final /* synthetic */ long c;

        public c(KtvComponentSingleBroadcastStrategy r1, h80.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_cancel_prepare_apply, failure, logId=" + ke2.a.c(r8));
            ExceptionUtils.handleException(this.a.f.getContext(), r8);
            h80.a r0 = this.b;
            if (r0 == null) goto L5;
            r0.accept(Boolean.FALSE);
        L5:
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiCancelAddSongPrepareApply, System.currentTimeMillis() - this.c, r8);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
        public final /* synthetic */ long b;
        public final /* synthetic */ IBaseUser c;
        public final /* synthetic */ h80.a d;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;
            public final /* synthetic */ long b;

            public a(d r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r7) {
                com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
                ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply_permit, success, " + ((ExtraResponse) r8).logId);
                d r0 = this.a;
                KtvComponentSingleBroadcastStrategy r1 = r0.a;
                r0.c.getIdString();
                DataCenter r2 = r1.f.getDataCenter();
                if (r2 == null) goto L5;
                r2.put("cmd_ktv_component_init_link", new c2(8, 6));
            L5:
                f2.b(2131918281, 0);
                this.a.d.accept(Boolean.TRUE);
                mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiAddSongPrepareApplyPermit, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ d a;
            public final /* synthetic */ long b;

            public b(d r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r7) {
                Throwable r8 = (Throwable) r7;
                ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply_permit, failure, logId=" + ke2.a.c(r8));
                ExceptionUtils.handleException(this.a.a.f.getContext(), r8);
                mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiAddSongPrepareApplyPermit, System.currentTimeMillis() - this.b, r8);
            }
        }

        public d(KtvComponentSingleBroadcastStrategy r1, long r2, IBaseUser r4, h80.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            r8.dismiss();
            int r10 = ke2.b.a;
            ke2.b.a("accept");
            long r11 = System.currentTimeMillis();
            KtvComponentApi r1 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
            if (r1 == null) goto L12;
            Observable<com.bytedance.android.live.network.response.e<Object>> r0 = r1.addSongPrepareApplyPermit(this.b, d5.c(this.c.getIdString()), this.c.getIdString());
            if (r0 == null) goto L13;
            Observable r2 = r0.compose(RxUtil.rxSchedulerHelper());
            if (r2 == null) goto L14;
            Disposable r12 = r2.subscribe(new a(this, r11), new b(this, r11));
            if (r12 == null) goto L15;
            RxUtilKt.c(r12, this.a.a);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ IBaseUser a;
        public final /* synthetic */ h80.a b;

        public e(IBaseUser r1, h80.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.b.accept(Boolean.FALSE);
            int r3 = ke2.b.a;
            ke2.b.a("cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void release() {
        this.a.dispose();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return com.bytedance.android.livesdk.ktvimpl.base.util.e.a.a();
    }

    public KtvComponentSingleBroadcastStrategy(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvUIStrategy");
        this.f = r2;
        this.a = new CompositeDisposable();
        this.d = LazyKt.lazy(new KtvComponentSingleBroadcastStrategy$kSongSettingKeyObserver$2(this));
        this.e = LazyKt.lazy(new KtvComponentSingleBroadcastStrategy$linkPlayerStateObserver$2(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r7) {
        long r0 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        long r2 = System.currentTimeMillis();
        RxUtilKt.c(((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).cancelAddSongPrepareApply(r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r7, r2), new c(this, r7, r2)), this.a);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void Fh(IBaseUser r9, h80.a<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r9, "user");
        Intrinsics.checkNotNullParameter(r10, "consumer");
        long r3 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.f.getContext());
        if (r0 == null) goto L6;
        c9.a r7 = new c9.a(r0);
        r7.d(2131918280);
        r7.a(2131918279);
        r7.c(2131915913, new d(this, r3, r9, r10));
        r7.b(2131915442, new e(r9, r10));
        r7.e();
        int r11 = ke2.b.a;
        LinkedHashMap r12 = new LinkedHashMap();
        ke2.b.j(r12);
        ke2.b.m(r12);
        ke2.b.l(r12);
        ke2.b.k(r12);
        j0.l().sendLog("livesdk_anchor_ksong_popup_show", r12, new Object[]{IRoom.class});
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r1, rj0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a.C0016a.a((BaseOrderSongViewModel.e) r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r2, IRoom r3, rj0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "listener");
        r4.onSuccess();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r7, String r8, LinkApplyType r9, tf0.b r10) {
        Intrinsics.checkNotNullParameter(r9, "applyType");
        boolean r0 = false;
        Object r1 = null;
        if (this.c == true) goto L9;
        this.c = true;
        KtvComponentOrderedSongDataContext r11 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r11 == null) goto L9;
        Disposable r12 = r11.observerKtvSongUniqueInfoListChange(null, false, new f(this));
        if (r12 == null) goto L9;
        RxUtilKt.c(r12, this.a);
    L9:
        String r13 = k.n(IMiddlewareUserService.class).user().n();
        KtvComponentOrderedSongDataContext r3 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r3 == null) goto L20;
        List<SongUniqueInfo> r4 = r3.getKtvPrivateSongUniqueInfoList();
        if (r4 == null) goto L20;
        Iterator<T> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r6).getUserId(), r13) == false) goto L15;
        r1 = r6;
    L19:
        r1 = (SongUniqueInfo) r1;
    L20:
        if (r1 == null) goto L22;
        r0 = true;
    L22:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: ktvApply, isInSelfSeeSelectedMusicList=" + r0 + " ;; isApplying = " + this.b);
        if (r0 == false) goto L25;
        return;
    L25:
        if (this.b == false) goto L28;
        return;
    L28:
        if (r9 != LinkApplyType.KTV_MULTI_CHORUS) goto L30;
        String r14 = "live_chorus";
    L31:
        int r2 = ke2.b.a;
        ke2.b.i(r14);
        IInteractService r15 = k.f(IInteractService.class);
        if (r15 == null) goto L38;
        m r16 = r15.getVideoTalkService();
        if (r16 == null) goto L38;
        if (r8 != null) goto L37;
        r8 = "推荐";
    L37:
        r16.x(r8, r9);
    L38:
        Context r17 = this.f.getContext();
        if (r17 == null) goto L46;
        OperateType r18 = OperateType.PRE_APPLY;
        ArrayList r19 = new ArrayList();
        r19.add(qh0.g.a(r18, 2));
        r19.add(new qh0.f.g(r17, r18, 2));
        r19.add(new qh0.f.c(r17, r18, 2));
        r19.add(new qh0.f.a(r17));
        r19.add(new qh0.f.d(r17, r18, 2, true));
        r19.add(new qh0.f.f(r17, r18, 2, true));
        r19.add(new qh0.f.e(r17, r18));
        qh0.f.a(r19).a(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.e(this, r7));
        return;
    L46:
        return;
    L30:
        r14 = "live_song";
        goto L31
    }
}
