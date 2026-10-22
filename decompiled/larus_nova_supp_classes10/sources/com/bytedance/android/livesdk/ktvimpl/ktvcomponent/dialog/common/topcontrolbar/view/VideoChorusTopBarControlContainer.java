package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.videochorus.VideoChorusFirstLevelTabManager$initTopControlBarAction$1;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/VideoChorusTopBarControlContainer;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonTopBarControlContainer;", "", "getCurMusicProgress", "getCurMusicTotalTime", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvComponentOrderedSongDataContext;", "getOrderedSongContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvComponentOrderedSongDataContext;", "orderedSongContext", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getFirstOrderedSong", "()Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "firstOrderedSong", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusTopBarControlContainer extends KtvCommonTopBarControlContainer {
    public static final /* synthetic */ int s = 0;
    public final long q;
    public Disposable r;

    public static final class a {
    }

    public static final class b extends View.AccessibilityDelegate {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ VideoChorusTopBarControlContainer b;

        public b(TextView r1, VideoChorusTopBarControlContainer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r7, AccessibilityNodeInfo r8) {
            Intrinsics.checkNotNullParameter(r7, "host");
            Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.INFO);
            super.onInitializeAccessibilityNodeInfo(r7, r8);
            String r9 = this.a.getText().toString();
            VideoChorusTopBarControlContainer r10 = this.b;
            int r0 = VideoChorusTopBarControlContainer.s;
            r10.getClass();
            List r11 = StringsKt.split$default(r9, new String[]{":"}, false, 0, 6, null);
            if (r11.size() != 2) goto L8;
            Integer r1 = StringsKt.toIntOrNull((String) ListProtector.get(r11, 0));
            Integer r12 = StringsKt.toIntOrNull((String) ListProtector.get(r11, 1));
            if (r1 == null) goto L8;
            if (r12 == null) goto L8;
            String r13 = String.valueOf(r1.intValue()) + "分" + String.valueOf(r12.intValue()) + "秒";
        L9:
            this.a.setText(r9);
            this.a.setContentDescription(r13);
            return;
        L8:
            r13 = r9;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final long getCurMusicProgress() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = VideoChorusDataContext.Companion.a();
        if (r0 == null) goto L7;
        jd2.c r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return 0;
    }

    private final long getCurMusicTotalTime() {
        KtvMusic.a r0 = KtvMusic.Companion;
        MusicPanel r1 = getFirstOrderedSong();
        if (r1 == null) goto L5;
        KtvMusic r2 = r1.a;
    L6:
        r0.getClass();
        return KtvMusic.a.a(r2) * 1000;
    L5:
        r2 = null;
        goto L6
    }

    private final KtvComponentOrderedSongDataContext getOrderedSongContext() {
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    private final MusicPanel getFirstOrderedSong() {
        KtvComponentOrderedSongDataContext r0 = getOrderedSongContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvPublicFirstOrderedSong();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void b() {
        LinearLayout r0 = getMusicOperateContainer();
        if (r0 == null) goto L31;
        r0.removeAllViews();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L7;
    L20:
        MusicOperateType r1 = MusicOperateType.ADJUST;
        MusicOperateView r4 = ie2.b.a(r1, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r4.a = "request_song";
        Unit r5 = Unit.INSTANCE;
        a(r4, r1);
        MusicOperateType r2 = MusicOperateType.PAUSE_RESTART;
        MusicOperateView r6 = ie2.b.a(r2, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r6.a = "request_song";
        a(r6, r2);
    L22:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L29;
        MusicPanel r3 = getFirstOrderedSong();
        if (r3 == null) goto L32;
        KtvMusic r7 = r3.a;
        if (r7 != null) goto L28;
        return;
    L28:
        if (KtvUtilsKt.w(r7) == true) goto L29;
        return;
    L32:
        return;
    L29:
        MusicOperateType r8 = MusicOperateType.SILENCE;
        MusicOperateView r9 = ie2.b.a(r8, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r9.a = "request_song";
        Unit r10 = Unit.INSTANCE;
        a(r9, r8);
        return;
    L7:
        if (KtvUtilsKt.j() == true) goto L20;
        MusicPanel r11 = getFirstOrderedSong();
        if (r11 == null) goto L15;
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L15;
        if (KtvUtilsKt.w(r12) == true) goto L20;
    L15:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r13 = VideoChorusDataContext.Companion.a();
        if (r13 == null) goto L22;
        if (r13.i() != true) goto L22;
        MusicOperateType r14 = MusicOperateType.ADJUST;
        MusicOperateView r15 = ie2.b.a(r14, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r15.a = "request_song";
        Unit r16 = Unit.INSTANCE;
        a(r15, r14);
        goto L22
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void c() {
        TextView r0 = getBusinessSwitch();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        k();
    }

    public final void k() {
        HSImageView r0 = getMusicCoverIv();
        String r1 = null;
        if (r0 == null) goto L26;
        MusicPanel r2 = getFirstOrderedSong();
        if (r2 == null) goto L9;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L9;
        String r4 = r3.getMNewCoverUrl();
    L11:
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L26;
        int r6 = qy.a.a;
        MusicPanel r7 = getFirstOrderedSong();
        if (r7 == null) goto L24;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L24;
        String r9 = r8.getMNewCoverUrl();
    L25:
        ImageUtil.loadImageWithRadius(r0, qy.a.a(r9), 0, 4);
    L24:
        r9 = null;
        goto L25
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
    L9:
        r4 = null;
    L26:
        l(getCurMusicProgress(), getCurMusicTotalTime());
        TextView r10 = getMusicNameTv();
        if (r10 == null) goto L35;
        MusicPanel r11 = getFirstOrderedSong();
        if (r11 == null) goto L33;
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L33;
        r1 = r12.getMTitle();
    L33:
        r10.setText(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = VideoChorusDataContext.Companion.a();
        Disposable r1 = this.r;
        if (r1 != null) goto L5;
    L6:
        this.r = Observable.interval(0, this.q, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this, r0), s.a);
        return;
    L5:
        if (r1.isDisposed() == true) goto L6;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public static final /* synthetic */ long h(VideoChorusTopBarControlContainer r2) {
        return r2.getCurMusicProgress();
    }

    public static final /* synthetic */ long i(VideoChorusTopBarControlContainer r2) {
        return r2.getCurMusicTotalTime();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void e(boolean r10) {
        FrameLayout r0 = getUserInfoContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        py.k r1 = null;
        if (r10 == false) goto L43;
        getKtvCommonSingleAvatarView().setVisibility(0);
        FrameLayout r11 = getUserInfoContainer();
        if (r11 == null) goto L10;
        r11.addView(getKtvCommonSingleAvatarView());
    L10:
        MusicPanel r2 = getFirstOrderedSong();
        if (r2 == null) goto L19;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L19;
        OrderInfo r4 = r3.getOrderInfo();
        if (r4 == null) goto L19;
        InteractiveSongUserInfo r5 = r4.getTopUser();
        if (r5 == null) goto L19;
        py.k r6 = r5.getAvatarThumbFlex();
    L21:
        if ((r6 instanceof py.k) == false) goto L24;
        r1 = r6;
    L24:
        if (r1 != null) goto L26;
        r1 = qy.a.c();
    L26:
        MusicPanel r7 = getFirstOrderedSong();
        if (r7 == null) goto L36;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L36;
        OrderInfo r9 = r8.getOrderInfo();
        if (r9 == null) goto L36;
        InteractiveSongUserInfo r12 = r9.getTopUser();
        if (r12 == null) goto L36;
        String r13 = r12.getNickNameFlex();
        if (r13 == null) goto L36;
    L37:
        Pair r14 = new Pair(r1, r13);
        KtvCommonSingleAvatarView r15 = getKtvCommonSingleAvatarView();
        py.k r16 = (py.k) r14.getFirst();
        String r17 = (String) r14.getSecond();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "model");
        Intrinsics.checkNotNullParameter(r17, "userName");
        HSImageView r18 = r15.a;
        if (r18 == null) goto L40;
        ImageUtil.loadRoundImage(r18, r16);
    L40:
        TextView r19 = r15.b;
        if (r19 == null) goto L65;
        r19.setText(r17);
        return;
    L65:
        return;
    L36:
        r13 = "";
    L19:
        r6 = null;
        goto L21
    L43:
        getKtvCommonStackAvatarView().setVisibility(0);
        FrameLayout r110 = getUserInfoContainer();
        if (r110 == null) goto L46;
        r110.addView(getKtvCommonStackAvatarView());
    L46:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r111 = VideoChorusDataContext.Companion.a();
        if (r111 == null) goto L49;
        r1 = r111.o();
    L49:
        py.k r112 = qy.a.c();
        if (r1 == null) goto L53;
        Collection r20 = ((jd2.a) r1).c;
        if (r20 == null) goto L53;
    L54:
        List<? extends py.k> r21 = CollectionsKt.toMutableList(r20);
        r21.add(r112);
        KtvCommonStackAvatarView r22 = getKtvCommonStackAvatarView();
        if (r1 == null) goto L58;
        String r113 = ((jd2.a) r1).a;
        if (r113 == null) goto L58;
    L59:
        String r23 = r113;
        if (r1 == null) goto L62;
        int r24 = ((jd2.a) r1).b;
    L63:
        r22.r(r21, r23, r24, r21.size(), "scene_video_chorus_top_control");
        return;
    L62:
        r24 = 0;
    L58:
        r113 = BDLocationException.ERROR_TIMEOUT;
    L53:
        r20 = new ArrayList();
        goto L54
    }

    public final void j(jd2.c r1) {
        if (r1 != null) goto L4;
    L10:
        f(8);
        return;
    L4:
        if (r1.a == 0) goto L10;
        if (getFirstOrderedSong() == null) goto L10;
        k();
        f(0);
    }

    public VideoChorusTopBarControlContainer(VideoChorusFirstLevelTabManager$initTopControlBarAction$1.a r5, Context r6) {
        super(r5, r6);
        this.q = 1000;
        boolean r7 = false;
        f(0);
        VideoChorusDataContext.a r8 = VideoChorusDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = r8.a();
        if (r0 == null) goto L5;
        jd2.c r1 = r0.f();
    L6:
        j(r1);
        KtvComponentOrderedSongDataContext r2 = getOrderedSongContext();
        if (r2 == null) goto L11;
        Disposable r3 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r2, null, new n(this), 3);
        if (r3 == null) goto L11;
        RxUtilKt.c(r3, getCompositeDisposable());
    L11:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r4 = r8.a();
        if (r4 == null) goto L14;
        r4.l(this, new o(this));
    L14:
        IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L23;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L23;
        Observable r11 = r10.u();
        if (r11 == null) goto L23;
        Disposable r12 = r11.subscribe(new p(this));
        if (r12 == null) goto L23;
        RxUtilKt.c(r12, getCompositeDisposable());
    L23:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r13 = r8.a();
        if (r13 == null) goto L30;
        jd2.a r14 = r13.o();
        if (r14 == null) goto L30;
        if (r14.b != 1) goto L30;
        r7 = true;
    L30:
        e(r7);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r15 = r8.a();
        if (r15 == null) goto L34;
        r15.r(this, new q(this));
        return;
    L34:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void l(long r2, long r4) {
        long r5 = r4 - r2;
        if (r5 > 0) goto L6;
        r5 = 0;
    L6:
        SimpleDateFormat r3 = new SimpleDateFormat("mm:ss", Locale.US);
        TextView r6 = getMusicTimeTv();
        if (r6 == null) goto L10;
        r6.setText(s1.C(2131918358, new Object[]{r3.format(Long.valueOf(r5))}));
        r6.setAccessibilityDelegate(new b(r6, this));
        return;
    }
}
