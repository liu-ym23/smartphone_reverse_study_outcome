package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/PauseAndRestartItemView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PauseAndRestartItemView extends MusicOperateView {
    public static final /* synthetic */ int f = 0;

    public static final class a<T> implements Observer {
        public final /* synthetic */ PauseAndRestartItemView a;

        public a(PauseAndRestartItemView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StateMachine.c.b r3 = (StateMachine.c.b) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r3) != true) goto L9;
            PauseAndRestartItemView r4 = this.a;
            int r0 = PauseAndRestartItemView.f;
            r4.l();
            return;
        }
    }

    public static final class b<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ PauseAndRestartItemView a;

        public b(PauseAndRestartItemView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            jd2.c r4 = (jd2.c) r3;
            PauseAndRestartItemView r0 = this.a;
            int r1 = PauseAndRestartItemView.f;
            r0.getClass();
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.a != 3) goto L13;
            HSImageView r5 = r0.getMusicOperateIv();
            if (r5 == null) goto L10;
            r5.setBackgroundResource(2131252057);
        L10:
            HSImageView r6 = r0.getMusicOperateIv();
            if (r6 == null) goto L20;
            r6.setContentDescription(s1.B(2131918479));
            return;
        L20:
            return;
        L13:
            HSImageView r7 = r0.getMusicOperateIv();
            if (r7 == null) goto L16;
            r7.setBackgroundResource(2131252056);
        L16:
            HSImageView r8 = r0.getMusicOperateIv();
            if (r8 == null) goto L22;
            r8.setContentDescription(s1.B(2131918477));
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public static com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c m() {
        KtvContext.Companion.getClass();
        return (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
    }

    public final void l() {
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.e != true) goto L9;
        boolean r2 = true;
    L10:
        jd2.c r7 = null;
        if (r2 == false) goto L31;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r3 = VideoChorusDataContext.Companion.a();
        if (r3 == null) goto L15;
        r7 = r3.f();
    L15:
        if (r7 != null) goto L17;
    L24:
        HSImageView r4 = getMusicOperateIv();
        if (r4 == null) goto L27;
        r4.setBackgroundResource(2131252056);
    L27:
        HSImageView r5 = getMusicOperateIv();
        if (r5 == null) goto L75;
        r5.setContentDescription(s1.B(2131918477));
        return;
    L75:
        return;
    L17:
        if (r7.a != 3) goto L24;
        HSImageView r6 = getMusicOperateIv();
        if (r6 == null) goto L21;
        r6.setBackgroundResource(2131252057);
    L21:
        HSImageView r8 = getMusicOperateIv();
        if (r8 == null) goto L73;
        r8.setContentDescription(s1.B(2131918479));
        return;
    L73:
        return;
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r9 = m();
        if (r9 == null) goto L34;
        KtvRoomLyricsStateMachineConfig.d r10 = r9.getCurState();
    L35:
        boolean r11 = r10 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r12 = m();
        if (r12 == null) goto L38;
        r7 = r12.getCurState();
    L38:
        boolean r13 = r7 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        if (r11 == true) goto L50;
        if (r13 == true) goto L50;
        HSImageView r14 = getMusicOperateIv();
        if (r14 == null) goto L44;
        r14.setAlpha(0.5f);
    L44:
        HSImageView r15 = getMusicOperateIv();
        if (r15 == null) goto L47;
        r15.setEnabled(false);
    L47:
        HSImageView r16 = getMusicOperateIv();
        if (r16 == null) goto L76;
        r16.setTag(Boolean.FALSE);
        return;
    L76:
        return;
    L50:
        HSImageView r17 = getMusicOperateIv();
        if (r17 == null) goto L53;
        r17.setAlpha(1.0f);
    L53:
        HSImageView r18 = getMusicOperateIv();
        if (r18 == null) goto L56;
        r18.setEnabled(true);
    L56:
        HSImageView r19 = getMusicOperateIv();
        if (r19 == null) goto L59;
        r19.setTag(Boolean.TRUE);
    L59:
        if (r13 == false) goto L66;
        HSImageView r20 = getMusicOperateIv();
        if (r20 == null) goto L63;
        r20.setBackgroundResource(2131252057);
    L63:
        HSImageView r21 = getMusicOperateIv();
        if (r21 == null) goto L78;
        r21.setContentDescription(s1.B(2131918479));
        return;
    L78:
        return;
    L66:
        HSImageView r22 = getMusicOperateIv();
        if (r22 == null) goto L69;
        r22.setBackgroundResource(2131252056);
    L69:
        HSImageView r23 = getMusicOperateIv();
        if (r23 == null) goto L80;
        r23.setContentDescription(s1.B(2131918477));
        return;
    L80:
        return;
    L34:
        r10 = null;
    L9:
        r2 = false;
        goto L10
    }

    public final oe2.b o() {
        KtvContext.Companion.getClass();
        return (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void e(MusicOperateType r27) {
        Intrinsics.checkNotNullParameter(r27, "musicOperateType");
        if (ne2.a.a() == false) goto L6;
        f2.b(2131918251, 0);
        return;
    L6:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        boolean r2 = true;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
        if (r1 == null) goto L13;
        if (r1.e != true) goto L13;
        boolean r3 = true;
    L14:
        String r4 = null;
        if (r3 == false) goto L24;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r5 = VideoChorusDataContext.Companion.a();
        if (r5 == null) goto L23;
        jd2.c r6 = r5.f();
        if (r6 == null) goto L23;
        if (r6.a != 3) goto L23;
        boolean r7 = true;
    L29:
        ChorusContext.a r8 = ChorusContext.Companion;
        if (r8.c() == false) goto L37;
        ChorusContext r9 = r8.getContext();
        if (r9 == null) goto L36;
        List<MusicPanel> r10 = r9.getChorusNotSelfSeeingMusicList();
        if (r10 == null) goto L36;
        MusicPanel r11 = (MusicPanel) CollectionsKt.firstOrNull(r10);
    L38:
        if (r11 == null) goto L42;
        com.bytedance.android.live.ktv.common.music.download.m r12 = KtvMusicManager.a;
        Intrinsics.checkNotNullParameter(r11, "panel");
        r2 = KtvUtilsKt.m(r11);
    L42:
        if (r8.c() == true) goto L44;
    L49:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r13 = KtvComponentOrderSongDataContext.Companion.a();
        if (r13 == null) goto L52;
        r13.togglePause(!r7);
    L52:
        if (r11 == null) goto L78;
        KtvLoggerHelper r14 = KtvLoggerHelper.d;
        if (r7 == false) goto L56;
        String r15 = "resume";
    L57:
        String r16 = r15;
        String r17 = com.bytedance.android.live.ktv.common.util.j.d();
        String r18 = com.bytedance.android.live.ktv.common.util.j.a(null);
        String r19 = getRequestPage();
        String r20 = r11.d;
        String r21 = r11.a.getMTitle();
        if (r21 != null) goto L60;
        String r110 = "";
    L61:
        long r111 = r11.a.getMId();
        String r112 = com.bytedance.android.live.ktv.common.util.j.g();
        String r113 = r11.b();
        String r22 = r11.a.getMAuthor();
        if (r22 != null) goto L64;
        String r114 = "";
    L65:
        oe2.b r23 = o();
        if (r23 == null) goto L68;
        String r115 = r23.getEnterFrom();
    L69:
        oe2.b r24 = o();
        if (r24 == null) goto L72;
        String r25 = r24.c();
    L73:
        oe2.b r26 = o();
        if (r26 == null) goto L76;
        r4 = r26.a();
    L76:
        pb0.a.a.a(r14, r16, r17, r18, null, r19, r110, r111, r112, r20, r113, r114, r115, r25, r4, null, r11.A, r11, 34824);
        return;
    L72:
        r25 = null;
        goto L73
    L68:
        r115 = null;
        goto L69
    L64:
        r114 = r22;
        goto L65
    L60:
        r110 = r21;
        goto L61
    L56:
        r15 = "pause";
        goto L57
    L78:
        return;
    L44:
        if (r8.d() == false) goto L49;
        if (r2 == true) goto L49;
        if (r7 == true) goto L49;
        f2.b(2131918310, 0);
        return;
    L36:
        r11 = null;
        goto L38
    L37:
        KtvContext.Companion.getClass();
        r11 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
    L23:
        r7 = false;
        goto L29
    L24:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r28 = m();
        if (r28 == null) goto L27;
        KtvRoomLyricsStateMachineConfig.d r29 = r28.getCurState();
    L28:
        r7 = r29 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        goto L29
    L27:
        r29 = null;
    L13:
        r3 = false;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public final void h(MusicOperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
        l();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = m();
        if (r4 == null) goto L5;
        r4.observeState(this, new a(this), false);
    L5:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r5 = VideoChorusDataContext.Companion.a();
        if (r5 == null) goto L9;
        r5.l(this, new b(this));
        return;
    }

    public PauseAndRestartItemView(MusicOperateType r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }
}
