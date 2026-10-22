package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/AdjustItemView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdjustItemView extends MusicOperateView {
    public final CompositeDisposable f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AdjustItemView a;

        public a(AdjustItemView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            AdjustItemView r4 = this.a;
            KtvContext.Companion.getClass();
            r4.c(KtvContext.a.g().isCurrentUserIsSinger());
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final oe2.b l() {
        KtvContext.Companion.getClass();
        return (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void onRelease() {
        this.f.clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void c(boolean r5) {
        ChorusContext.a r0 = ChorusContext.Companion;
        ChorusContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r2 = r1.getChorusSelectedSongList();
        if (r2 == null) goto L9;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        if (r5 == false) goto L14;
        KtvContext.Companion.getClass();
        if (((Boolean) KtvContext.a.g().getHasBgm().getValue()).booleanValue() == false) goto L14;
    L22:
        HSImageView r6 = getMusicOperateIv();
        if (r6 == null) goto L25;
        r6.setAlpha(1.0f);
    L25:
        HSImageView r7 = getMusicOperateIv();
        if (r7 == null) goto L28;
        r7.setTag(Boolean.TRUE);
    L28:
        setClickable(true);
        return;
    L14:
        if (r0.c() == true) goto L16;
    L18:
        MultiChorusContext.a r8 = MultiChorusContext.Companion;
        if (r8.c() == true) goto L21;
    L29:
        HSImageView r9 = getMusicOperateIv();
        if (r9 == null) goto L32;
        r9.setAlpha(0.5f);
    L32:
        HSImageView r10 = getMusicOperateIv();
        if (r10 == null) goto L35;
        r10.setTag(Boolean.FALSE);
    L35:
        setClickable(false);
        return;
    L21:
        if (r8.a() != 2) goto L29;
    L16:
        if (r0.a() != 2) goto L18;
        if (r4 != 0) goto L22;
    L9:
        r4 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void e(MusicOperateType r26) {
        Intrinsics.checkNotNullParameter(r26, "musicOperateType");
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r1 = r0.a();
        boolean r2 = true;
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r3 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1.getValue();
        if (r3 == null) goto L9;
        if (r3.e != true) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L21;
        VideoChorusDataContext r5 = VideoChorusDataContext.Companion.getContext();
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.j<fd2.d> r6 = r5.getChorusBizProxy();
        if (r6 == null) goto L16;
        fd2.d r7 = (fd2.d) r6.getValue();
    L17:
        if (r7 == null) goto L19;
        r7.b("top_control tuning entrance click", 1, false, getContext());
    L19:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.c.a("tune");
        return;
    L16:
        r7 = null;
        goto L17
    L21:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L32;
        if (ChorusContext.Companion.c() == true) goto L32;
        MultiChorusContext.a r8 = MultiChorusContext.Companion;
        if (r8.c() == true) goto L28;
    L30:
        r2 = false;
        goto L32
    L28:
        if (r8.a() != 2) goto L30;
    L32:
        if (r2 == false) goto L75;
        ChorusContext.a r9 = ChorusContext.Companion;
        if (r9.c() == false) goto L41;
        ChorusContext r10 = r9.getContext();
        if (r10 == null) goto L40;
        List<MusicPanel> r11 = r10.getChorusNotSelfSeeingMusicList();
        if (r11 == null) goto L40;
        MusicPanel r12 = (MusicPanel) CollectionsKt.firstOrNull(r11);
    L42:
        if (r12 == null) goto L62;
        KtvLoggerHelper r13 = KtvLoggerHelper.d;
        String r14 = com.bytedance.android.live.ktv.common.util.j.d();
        String r15 = com.bytedance.android.live.ktv.common.util.j.d();
        String r16 = getRequestPage();
        String r17 = r12.d;
        String r18 = r12.a.getMTitle();
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        long r19 = r12.a.getMId();
        String r110 = com.bytedance.android.live.ktv.common.util.j.g();
        String r111 = r12.b();
        String r20 = r12.a.getMAuthor();
        if (r20 != null) goto L49;
        r20 = "";
    L49:
        oe2.b r112 = l();
        if (r112 == null) goto L52;
        String r113 = r112.getEnterFrom();
    L53:
        oe2.b r114 = l();
        if (r114 == null) goto L56;
        String r115 = r114.c();
    L57:
        oe2.b r116 = l();
        if (r116 == null) goto L60;
        String r21 = r116.a();
    L61:
        String r117 = r20;
        pb0.a.a.a(r13, "tune", r14, r15, null, r16, r18, r19, r110, r17, r111, r117, r113, r115, r21, null, r12.A, r12, 34824);
        goto L62
    L60:
        r21 = null;
        goto L61
    L56:
        r115 = null;
        goto L57
    L52:
        r113 = null;
    L62:
        if (r12 != null) goto L65;
        f2.b(2131918276, 0);
        return;
    L65:
        KtvComponentContext r22 = r0.getContext();
        if (r22 == null) goto L74;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r23 = r22.getKtvComponentUIContext();
        if (r23 == null) goto L74;
        KtvComponentUIContext r24 = (KtvComponentUIContext) r23.getValue();
        if (r24 == null) goto L74;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a> r25 = r24.getShowOrHideAdjustDialogEvent();
        if (r25 == null) goto L74;
        r25.setValue(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a());
    L74:
        pd2.d.n.getClass();
        pd2.d.u("component_dialog");
        return;
    L40:
        r12 = null;
        goto L42
    L41:
        r12 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        goto L42
    L75:
        f2.b(2131918276, 0);
        return;
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public final void h(MusicOperateType r2) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
        HSImageView r3 = getMusicOperateIv();
        if (r3 == null) goto L5;
        r3.setBackgroundResource(2131252053);
    L5:
        HSImageView r4 = getMusicOperateIv();
        if (r4 == null) goto L8;
        r4.setContentDescription(s1.B(2131918475));
    L8:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r5 = KtvComponentContext.Companion.a();
        if (r5 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r6 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r5.getValue();
        if (r6 == null) goto L15;
        boolean r0 = true;
        if (r6.e != true) goto L15;
    L16:
        if (r0 == false) goto L18;
        return;
    L18:
        KtvContext.Companion.getClass();
        RxUtilKt.c(KtvContext.a.g().getHasBgm().a().subscribe(new a(this)), this.f);
        return;
    L15:
        r0 = false;
        goto L16
    }

    public AdjustItemView(MusicOperateType r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.f = new CompositeDisposable();
    }
}
