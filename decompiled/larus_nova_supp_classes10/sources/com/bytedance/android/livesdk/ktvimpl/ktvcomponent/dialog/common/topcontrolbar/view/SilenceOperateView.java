package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/SilenceOperateView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SilenceOperateView extends MusicOperateView {
    public long f;
    public final long g;
    public final CompositeDisposable h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SilenceOperateView a;
        public final /* synthetic */ String b;

        public a(SilenceOperateView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Iterator<T> r5 = ((IRoomLinkMicSyncData) ((dc2.c.b) r4).b).getMLinkUsers().iterator();
        L3:
            Object r1 = null;
            if (r5.hasNext() == false) goto L11;
            T r0 = r5.next();
            IBaseUser r2 = ((com.bytedance.android.livesdk.link.model.bridge.k) r0).getBaseUser();
            if (r2 == null) goto L9;
            r1 = r2.getUserId();
        L9:
            if (Intrinsics.areEqual(r1, this.b) == false) goto L3;
            r1 = r0;
        L11:
            com.bytedance.android.livesdk.link.model.bridge.k r3 = (com.bytedance.android.livesdk.link.model.bridge.k) r1;
            if (r3 != null) goto L14;
            return;
        L14:
            if (r3.getSilenceStatus() != 0) goto L18;
            HSImageView r6 = this.a.getMusicOperateIv();
            if (r6 == null) goto L26;
            r6.setBackgroundResource(2131253174);
            return;
        L26:
            return;
        L18:
            HSImageView r7 = this.a.getMusicOperateIv();
            if (r7 == null) goto L28;
            r7.setBackgroundResource(2131253053);
            return;
        }
    }

    public static final class b implements MediaOperation.a {
        public final /* synthetic */ SilenceOperateView a;
        public final /* synthetic */ boolean b;

        public final void onError(Throwable r1) {
        }

        public final void onSuccess() {
            if (this.b == false) goto L7;
            HSImageView r0 = this.a.getMusicOperateIv();
            if (r0 == null) goto L11;
            r0.setBackgroundResource(2131253053);
            return;
        L11:
            return;
        L7:
            HSImageView r1 = this.a.getMusicOperateIv();
            if (r1 == null) goto L13;
            r1.setBackgroundResource(2131253174);
            return;
        }

        public b(SilenceOperateView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public static boolean l() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.user.e r2 = r0.user();
        if (r2 == null) goto L11;
        IBaseUser r3 = r2.b();
        if (r3 == null) goto L11;
        if (r1 == null) goto L11;
        return r1.isLinkerUserUnSilence(r3);
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void onRelease() {
        this.h.clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void e(MusicOperateType r7) {
        Intrinsics.checkNotNullParameter(r7, "musicOperateType");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.f) >= this.g) goto L5;
        return;
    L5:
        this.f = r0;
        boolean r8 = l();
        if (r8 == false) goto L8;
        String r1 = "mute";
    L9:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.c.a(r1);
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L13;
        r2.updateSelfSilenceStatus(r8, new b(this, r8));
        return;
    L13:
        return;
    L8:
        r1 = "cancel_mute";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public final void h(MusicOperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
        if (l() == false) goto L7;
        HSImageView r4 = getMusicOperateIv();
        if (r4 == null) goto L10;
        r4.setBackgroundResource(2131253174);
    L10:
        HSImageView r5 = getMusicOperateIv();
        if (r5 == null) goto L13;
        r5.setContentDescription(s1.B(2131918478));
    L13:
        String r6 = gh0.a.c();
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r0 == null) goto L27;
        LinkMicRoomDataSyncModel r1 = (LinkMicRoomDataSyncModel) r0.getValue();
        if (r1 == null) goto L28;
        dc2.c r2 = r1.getTalkRoomListUserInfoPb();
        if (r2 == null) goto L29;
        Observable r7 = r2.e;
        if (r7 == null) goto L30;
        Observable r8 = r7.distinctUntilChanged();
        if (r8 == null) goto L31;
        Disposable r9 = r8.subscribe(new a(this, r6));
        if (r9 == null) goto L32;
        RxUtilKt.c(r9, this.h);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L7:
        HSImageView r10 = getMusicOperateIv();
        if (r10 == null) goto L10;
        r10.setBackgroundResource(2131253053);
        goto L10
    }

    public SilenceOperateView(MusicOperateType r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.g = SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
        this.h = new CompositeDisposable();
    }
}
