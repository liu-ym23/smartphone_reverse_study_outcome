package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.KtvComponentFirstLevelTabManager$initTopControlBarAction$1;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.BusinessSwitchState;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonTopBarControlContainer;", "com/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer$mKtvCoreListener$2$a", "s", "Lkotlin/Lazy;", "getMKtvCoreListener", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer$mKtvCoreListener$2$a;", "mKtvCoreListener", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "t", "getLinkPlayerStateObserver", "()Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkPlayerStateObserver", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentTopBarControlContainer extends KtvCommonTopBarControlContainer {
    public static final /* synthetic */ int u = 0;
    public boolean q;
    public Disposable r;
    public final Lazy s;
    public final Lazy t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentTopBarControlContainer a;

        public b(KtvComponentTopBarControlContainer r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            fd2.a r7 = (fd2.a) r6;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L12;
            KtvComponentTopBarControlContainer r0 = this.a;
            int r1 = KtvComponentTopBarControlContainer.u;
            r0.getClass();
            if ((r7 instanceof fd2.a.b) == false) goto L7;
        L10:
            r0.p(com.bytedance.android.livesdk.ktvimpl.multichorus.c.c(), com.bytedance.android.livesdk.ktvimpl.multichorus.c.d());
            return;
        L7:
            if ((r7 instanceof fd2.a.d) == true) goto L10;
            if ((r7 instanceof fd2.a.c) == true) goto L10;
            return;
        }
    }

    public static final class c extends View.AccessibilityDelegate {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ KtvComponentTopBarControlContainer b;

        public c(TextView r1, KtvComponentTopBarControlContainer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r7, AccessibilityNodeInfo r8) {
            Intrinsics.checkNotNullParameter(r7, "host");
            Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.INFO);
            super.onInitializeAccessibilityNodeInfo(r7, r8);
            String r9 = this.a.getText().toString();
            KtvComponentTopBarControlContainer r10 = this.b;
            int r0 = KtvComponentTopBarControlContainer.u;
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

    private final Observer<Integer> getLinkPlayerStateObserver() {
        return (Observer) this.t.getValue();
    }

    private final KtvComponentTopBarControlContainer$mKtvCoreListener$2.a getMKtvCoreListener() {
        return (KtvComponentTopBarControlContainer$mKtvCoreListener$2.a) this.s.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void k() {
        Disposable r0 = this.r;
        if (r0 == null) goto L5;
        getCompositeDisposable().remove(r0);
    L5:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r1 == null) goto L10;
        PublishSubject<fd2.a> r2 = r1.g;
        if (r2 == null) goto L10;
        Disposable r3 = r2.subscribe(new b(this));
    L11:
        this.r = r3;
        if (r3 == null) goto L15;
        getCompositeDisposable().add(r3);
        return;
    L15:
        return;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void b() {
        LinearLayout r0 = getMusicOperateContainer();
        if (r0 == null) goto L6;
        r0.removeAllViews();
        MusicOperateType r1 = MusicOperateType.ADJUST;
        MusicOperateView r2 = ie2.b.a(r1, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r2.a = "request_song";
        Unit r4 = Unit.INSTANCE;
        a(r2, r1);
        MusicOperateType r3 = MusicOperateType.PAUSE_RESTART;
        MusicOperateView r5 = ie2.b.a(r3, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r5.a = "request_song";
        a(r5, r3);
        MusicOperateType r6 = MusicOperateType.CHALLENGE;
        MusicOperateView r7 = ie2.b.a(r6, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r7.a = "request_song";
        a(r7, r6);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void c() {
        TextView r0 = getBusinessSwitch();
        if (r0 == null) goto L5;
        r0.setOnClickListener(x0.a(new KtvComponentTopBarControlContainer$bindOtherView$1(this)));
    L5:
        o();
    }

    public final void j() {
        o();
        com.bytedance.android.livesdk.ktvimpl.base.util.j r0 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        MusicPanel r1 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        List<MusicPanel> r2 = null;
        if (r1 == null) goto L5;
        KtvMusic r3 = r1.a;
    L6:
        r0.getClass();
        boolean r4 = com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r3);
        ChorusContext.a r5 = ChorusContext.Companion;
        boolean r6 = true;
        if (r5.c() == false) goto L20;
        ChorusContext r7 = r5.getContext();
        if (r7 == null) goto L11;
        r2 = r7.getChorusNotSelfSeeingMusicList();
    L11:
        List<MusicPanel> r8 = r2;
        if (r8 != null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 == false) goto L27;
    L25:
        r6 = false;
    L27:
        if (r6 == false) goto L40;
        if (r4 == false) goto L40;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L32;
    L39:
        f(0);
        return;
    L32:
        if (KtvUtilsKt.j() == true) goto L39;
        if (MultiChorusContext.Companion.c() == true) goto L39;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L39;
        f(8);
        return;
    L40:
        f(8);
        return;
    L14:
        if (r8.isEmpty() == true) goto L17;
        r9 = false;
        goto L18
    L20:
        KtvContext.Companion.getClass();
        List<MusicPanel> r10 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        if (r10 == null) goto L25;
        if ((!r10.isEmpty()) != true) goto L25;
    L5:
        r3 = null;
        goto L6
    }

    public final void m() {
        if (hd0.c.f().h() == false) goto L7;
        if (MultiChorusContext.Companion.b() == false) goto L7;
    L8:
        TextView r0 = getBusinessSwitch();
        if (r0 == null) goto L11;
        r0.setText(s1.B(2131918462));
    L11:
        TextView r1 = getBusinessSwitch();
        if (r1 == null) goto L14;
        r1.setTag(BusinessSwitchState.NOT_SING);
    L14:
        TextView r2 = getBusinessSwitch();
        if (r2 == null) goto L27;
        r2.setBackgroundResource(2131252016);
        return;
    L27:
        return;
    L7:
        if (this.q == true) goto L8;
        TextView r3 = getBusinessSwitch();
        if (r3 == null) goto L20;
        r3.setText(s1.B(2131918434));
    L20:
        TextView r4 = getBusinessSwitch();
        if (r4 == null) goto L23;
        r4.setTag(BusinessSwitchState.MULTI_CHORUS);
    L23:
        TextView r5 = getBusinessSwitch();
        if (r5 == null) goto L29;
        r5.setBackgroundResource(2131252017);
        return;
    }

    public final void o() {
        HSImageView r0 = getMusicCoverIv();
        String r1 = null;
        if (r0 == null) goto L26;
        MusicPanel r2 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
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
        MusicPanel r7 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
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
        p(com.bytedance.android.livesdk.ktvimpl.multichorus.c.c(), com.bytedance.android.livesdk.ktvimpl.multichorus.c.d());
        TextView r10 = getMusicNameTv();
        if (r10 == null) goto L35;
        MusicPanel r11 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r11 == null) goto L33;
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L33;
        r1 = r12.getMTitle();
    L33:
        r10.setText(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener(getMKtvCoreListener());
    L5:
        hd0.c.f().e(getLinkPlayerStateObserver());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void e(boolean r10) {
        FrameLayout r0 = getUserInfoContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        int r1 = 0;
        py.k r2 = null;
        if (r10 == false) goto L71;
        getKtvCommonSingleAvatarView().setVisibility(0);
        FrameLayout r11 = getUserInfoContainer();
        if (r11 == null) goto L10;
        r11.addView(getKtvCommonSingleAvatarView());
    L10:
        ChorusContext.a r12 = ChorusContext.Companion;
        String r3 = "";
        if (r12.c() == false) goto L36;
        ChorusContext r13 = r12.getContext();
        if (r13 == null) goto L19;
        List<MusicPanel> r14 = r13.getChorusNotSelfSeeingMusicList();
        if (r14 == null) goto L19;
        MusicPanel r15 = (MusicPanel) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L19;
        InteractiveSongUserInfo r16 = r15.f();
    L21:
        if (r16 == null) goto L23;
        py.k r4 = r16.getAvatarThumbFlex();
    L25:
        if ((r4 instanceof py.k) == false) goto L28;
        r2 = r4;
    L28:
        if (r2 != null) goto L30;
        r2 = qy.a.c();
    L30:
        if (r16 == null) goto L35;
        String r17 = r16.getNickNameFlex();
        if (r17 == null) goto L35;
        r3 = r17;
    L35:
        Pair r5 = new Pair(r2, r3);
    L65:
        KtvCommonSingleAvatarView r18 = getKtvCommonSingleAvatarView();
        py.k r6 = (py.k) r5.getFirst();
        String r7 = (String) r5.getSecond();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "userName");
        HSImageView r8 = r18.a;
        if (r8 == null) goto L68;
        ImageUtil.loadRoundImage(r8, r6);
    L68:
        TextView r19 = r18.b;
        if (r19 == null) goto L124;
        r19.setText(r7);
        return;
    L124:
        return;
    L23:
        r4 = null;
    L19:
        r16 = null;
        goto L21
    L36:
        KtvContext.Companion.getClass();
        MusicPanel r110 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r110 == null) goto L45;
        KtvMusic r111 = r110.a;
        if (r111 == null) goto L45;
        OrderInfo r112 = r111.getOrderInfo();
        if (r112 == null) goto L45;
        InteractiveSongUserInfo r113 = r112.getTopUser();
        if (r113 == null) goto L45;
        py.k r114 = r113.getAvatarThumbFlex();
    L47:
        if ((r114 instanceof py.k) == false) goto L50;
        r2 = r114;
    L50:
        if (r2 != null) goto L52;
        r2 = qy.a.c();
    L52:
        MusicPanel r115 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r115 == null) goto L64;
        KtvMusic r116 = r115.a;
        if (r116 == null) goto L64;
        OrderInfo r117 = r116.getOrderInfo();
        if (r117 == null) goto L64;
        InteractiveSongUserInfo r118 = r117.getTopUser();
        if (r118 == null) goto L64;
        String r119 = r118.getNickNameFlex();
        if (r119 == null) goto L64;
        r3 = r119;
    L64:
        r5 = new Pair(r2, r3);
    L45:
        r114 = null;
        goto L47
    L71:
        getKtvCommonStackAvatarView().setVisibility(0);
        FrameLayout r120 = getUserInfoContainer();
        if (r120 == null) goto L74;
        r120.addView(getKtvCommonStackAvatarView());
    L74:
        ArrayList r121 = new ArrayList();
        ArrayList r9 = new ArrayList();
        List<jd2.e> r20 = MultiChorusContext.Companion.k();
        if (r20 == null) goto L80;
        Iterator<T> r21 = r20.iterator();
    L78:
        if (r21.hasNext() == false) goto L80;
        r9.add((jd2.e) r21.next());
    L80:
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == true) goto L99;
        Iterator r22 = r9.iterator();
        int r23 = 0;
    L85:
        if (r22.hasNext() == false) goto L99;
        Object r24 = r22.next();
        int r25 = r23 + 1;
        if (r23 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        String r26 = ((jd2.e) r24).a;
        IMiddlewareUserService r27 = jc1.k.f(IMiddlewareUserService.class);
        if (r27 == null) goto L94;
        com.bytedance.android.livesdk.user.e r28 = r27.user();
        if (r28 == null) goto L94;
        String r29 = r28.n();
    L96:
        if (Intrinsics.areEqual(r26, r29) == true) goto L100;
        r23 = r25;
    L100:
        int r30 = r9.size();
        if (r23 < 0) goto L105;
        if (r30 <= r23) goto L105;
        ListProtector.add(r9, 1, ListProtector.remove(r9, r23));
    L105:
        Iterator r31 = r9.iterator();
    L107:
        if (r31.hasNext() == false) goto L112;
        py.k r32 = ((jd2.e) r31.next()).b;
        if (r32 == null) goto L107;
        r121.add(r32);
        goto L107
    L112:
        if (r20 == null) goto L114;
        r1 = r20.size();
    L114:
        Pair r33 = new Pair(r121, Integer.valueOf(r1));
        getKtvCommonStackAvatarView().r((List) r33.getFirst(), String.valueOf(((Number) r33.getSecond()).intValue()), ((Number) r33.getSecond()).intValue(), 5, "scene_ktv_component");
        return;
    L94:
        r29 = null;
    L99:
        r23 = -1;
        goto L100
    }

    public final void h(List<MusicPanel> r3) {
        boolean r0 = false;
        if (r3 == null) goto L5;
        int r4 = r3.size();
    L7:
        if (ChorusContext.Companion.c() == false) goto L16;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r1 = g(MusicOperateType.ADJUST);
        if (r1 == null) goto L17;
        if (r4 <= 0) goto L14;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L14;
        r0 = true;
    L14:
        r1.c(r0);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r4 = 0;
        goto L7
    }

    public final void i(boolean r5) {
        MultiChorusContext.a r0 = MultiChorusContext.Companion;
        List<jd2.e> r1 = r0.k();
        if (r1 == null) goto L5;
        int r2 = r1.size();
    L6:
        boolean r3 = true;
        if (r2 <= 1) goto L10;
        r3 = false;
    L10:
        e(r3);
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L62;
        if (KtvUtilsKt.j() == true) goto L62;
        if (r0.c() == false) goto L47;
        if (r5 == false) goto L30;
        TextView r4 = getBusinessSwitch();
        if (r4 == null) goto L21;
        r4.setVisibility(8);
    L21:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r6 = g(MusicOperateType.ADJUST);
        if (r6 == null) goto L24;
        r6.g(0);
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r7 = g(MusicOperateType.PAUSE_RESTART);
        if (r7 == null) goto L27;
        r7.g(0);
    L27:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r8 = g(MusicOperateType.CHALLENGE);
        if (r8 == null) goto L126;
        r8.g(8);
    L126:
        if (getMusicOperateContainer() == null) goto L136;
        Iterator<T> r9 = getMusicOperateViewMap().values().iterator();
    L129:
        if (r9.hasNext() == false) goto L142;
        KeyEvent.Callback r10 = (View) r9.next();
        if ((r10 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b) == true) goto L133;
        r10 = null;
    L133:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r11 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b) r10;
        if (r11 == null) goto L129;
        r11.c(r5);
        goto L129
    L142:
        return;
    L136:
        return;
    L30:
        TextView r12 = getBusinessSwitch();
        if (r12 == null) goto L33;
        r12.setVisibility(0);
    L33:
        m();
        if (r0.b() == false) goto L38;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r13 = g(MusicOperateType.ADJUST);
        if (r13 == null) goto L41;
        r13.g(0);
    L41:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r14 = g(MusicOperateType.PAUSE_RESTART);
        if (r14 == null) goto L44;
        r14.g(8);
    L44:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r15 = g(MusicOperateType.CHALLENGE);
        if (r15 == null) goto L126;
        r15.g(8);
        goto L126
    L38:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r16 = g(MusicOperateType.ADJUST);
        if (r16 == null) goto L41;
        r16.g(8);
        goto L41
    L47:
        if (r5 == false) goto L57;
        TextView r17 = getBusinessSwitch();
        if (r17 == null) goto L51;
        r17.setVisibility(8);
    L51:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r18 = g(MusicOperateType.ADJUST);
        if (r18 == null) goto L54;
        r18.g(0);
    L54:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r19 = g(MusicOperateType.PAUSE_RESTART);
        if (r19 == null) goto L58;
        r19.g(0);
    L58:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r20 = g(MusicOperateType.CHALLENGE);
        if (r20 == null) goto L126;
        r20.g(8);
        goto L126
    L57:
        f(8);
    L62:
        if (ChorusContext.Companion.c() == false) goto L78;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L78;
        TextView r21 = getBusinessSwitch();
        if (r21 == null) goto L68;
        r21.setVisibility(8);
    L68:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r22 = g(MusicOperateType.ADJUST);
        if (r22 == null) goto L71;
        r22.g(0);
    L71:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r23 = g(MusicOperateType.PAUSE_RESTART);
        if (r23 == null) goto L74;
        r23.g(0);
    L74:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r24 = g(MusicOperateType.CHALLENGE);
        if (r24 == null) goto L126;
        r24.g(8);
    L78:
        if (r0.c() == false) goto L109;
        if (r5 == false) goto L92;
        TextView r25 = getBusinessSwitch();
        if (r25 == null) goto L83;
        r25.setVisibility(8);
    L83:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r26 = g(MusicOperateType.ADJUST);
        if (r26 == null) goto L86;
        r26.g(0);
    L86:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r27 = g(MusicOperateType.PAUSE_RESTART);
        if (r27 == null) goto L89;
        r27.g(0);
    L89:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r28 = g(MusicOperateType.CHALLENGE);
        if (r28 == null) goto L126;
        r28.g(8);
        goto L126
    L92:
        TextView r29 = getBusinessSwitch();
        if (r29 == null) goto L95;
        r29.setVisibility(0);
    L95:
        m();
        if (r0.b() == false) goto L100;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r30 = g(MusicOperateType.ADJUST);
        if (r30 == null) goto L103;
        r30.g(0);
    L103:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r31 = g(MusicOperateType.PAUSE_RESTART);
        if (r31 == null) goto L106;
        r31.g(0);
    L106:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r32 = g(MusicOperateType.CHALLENGE);
        if (r32 == null) goto L126;
        r32.g(8);
        goto L126
    L100:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r33 = g(MusicOperateType.ADJUST);
        if (r33 == null) goto L103;
        r33.g(8);
        goto L103
    L109:
        TextView r34 = getBusinessSwitch();
        if (r34 == null) goto L112;
        r34.setVisibility(8);
    L112:
        if (r5 == false) goto L116;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r35 = g(MusicOperateType.ADJUST);
        if (r35 == null) goto L119;
        r35.g(0);
    L119:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r36 = g(MusicOperateType.PAUSE_RESTART);
        if (r36 == null) goto L122;
        r36.g(0);
    L122:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r37 = g(MusicOperateType.CHALLENGE);
        if (r37 == null) goto L126;
        r37.g(0);
        goto L126
    L116:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r38 = g(MusicOperateType.ADJUST);
        if (r38 == null) goto L119;
        r38.g(8);
        goto L119
    L5:
        r2 = 0;
        goto L6
    }

    public final void l(com.bytedance.android.livesdk.ktvapi.util.e r6) {
        boolean r1 = false;
        if (hd0.c.f().h() == true) goto L25;
        Long r0 = null;
        if (r6 == null) goto L11;
        MusicPanel r2 = r6.a;
        if (r2 == null) goto L11;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L11;
        Long r4 = Long.valueOf(r3.getMId());
    L12:
        MusicPanel r5 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r5 == null) goto L18;
        KtvMusic r7 = r5.a;
        if (r7 == null) goto L18;
        r0 = Long.valueOf(r7.getMId());
    L18:
        if (Intrinsics.areEqual(r4, r0) == false) goto L25;
        if (r6 != null) goto L21;
    L23:
        this.q = r1;
        return;
    L21:
        if (r6.b != true) goto L23;
        r1 = true;
    L11:
        r4 = null;
    L25:
        if (hd0.c.f().h() == true) goto L27;
        if (r6 == null) goto L27;
        return;
    L27:
        this.q = false;
    }

    public KtvComponentTopBarControlContainer(KtvComponentFirstLevelTabManager$initTopControlBarAction$1.a r9, Context r10) {
        super(r9, r10);
        this.s = LazyKt.lazy(new KtvComponentTopBarControlContainer$mKtvCoreListener$2(this));
        this.t = LazyKt.lazy(new KtvComponentTopBarControlContainer$linkPlayerStateObserver$2(this));
        MultiChorusContext.a r11 = MultiChorusContext.Companion;
        MultiChorusContext r12 = r11.getContext();
        List<MusicPanel> r0 = null;
        if (r12 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvapi.util.a> r13 = r12.m441getService();
        if (r13 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.a r14 = (com.bytedance.android.livesdk.ktvapi.util.a) r13.getValue();
        if (r14 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.e r15 = r14.bj();
    L10:
        l(r15);
        f(8);
        KtvContext.Companion.getClass();
        Disposable r16 = KtvContext.a.g().getKtvCoreController().a().subscribe(new f(this));
        if (r16 == null) goto L13;
        RxUtilKt.c(r16, getCompositeDisposable());
    L13:
        k();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r17 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r17 == null) goto L16;
        r17.observerOnProgress(this, new AnonymousClass2(this));
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r18 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r18 == null) goto L19;
        r18.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), getMKtvCoreListener(), false);
    L19:
        j();
        KtvComponentOrderedSongDataContext r19 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r19 == null) goto L24;
        Disposable r110 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r19, null, new g(this), 3);
        if (r110 == null) goto L24;
        RxUtilKt.c(r110, getCompositeDisposable());
    L24:
        ChorusContext.a r111 = ChorusContext.Companion;
        ChorusContext r1 = r111.getContext();
        if (r1 == null) goto L33;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r2 = r1.getChorusSelectedSongList();
        if (r2 == null) goto L33;
        Observable r3 = r2.a();
        if (r3 == null) goto L33;
        Disposable r4 = r3.subscribe(new h(this));
        if (r4 == null) goto L33;
        RxUtilKt.c(r4, getCompositeDisposable());
    L33:
        Disposable r5 = KtvContext.a.g().getHasBgm().a().subscribe(new i(this));
        if (r5 == null) goto L36;
        RxUtilKt.c(r5, getCompositeDisposable());
    L36:
        i(KtvContext.a.g().isCurrentUserIsSinger());
        Disposable r6 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new j(this), 3, null);
        if (r6 == null) goto L39;
        RxUtilKt.c(r6, getCompositeDisposable());
    L39:
        IMiddlewareUserService r7 = jc1.k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L48;
        com.bytedance.android.livesdk.user.e r8 = r7.user();
        if (r8 == null) goto L48;
        Observable r20 = r8.u();
        if (r20 == null) goto L48;
        Disposable r21 = r20.subscribe(new k(this));
        if (r21 == null) goto L48;
        RxUtilKt.c(r21, getCompositeDisposable());
    L48:
        ChorusContext r22 = r111.getContext();
        if (r22 == null) goto L53;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r23 = r22.getChorusSelectedSongList();
        if (r23 == null) goto L53;
        r0 = (List) r23.getValue();
    L53:
        h(r0);
        ChorusContext r24 = r111.getContext();
        if (r24 == null) goto L62;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r25 = r24.getChorusSelectedSongList();
        if (r25 == null) goto L62;
        Observable r26 = r25.a();
        if (r26 == null) goto L62;
        Disposable r27 = r26.subscribe(new l(this));
        if (r27 == null) goto L62;
        RxUtilKt.c(r27, getCompositeDisposable());
    L62:
        r11.h(this, new m(this));
        ChorusContext r112 = r111.getContext();
        if (r112 == null) goto L71;
        com.bytedance.live.datacontext.j<ChorusViewModel> r113 = r112.getChorusViewModel();
        if (r113 == null) goto L71;
        ChorusViewModel r114 = (ChorusViewModel) r113.getValue();
        if (r114 == null) goto L71;
        MutableLiveData<Boolean> r115 = r114.getOpenStatus();
        if (r115 == null) goto L71;
        r115.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.c(this));
    L71:
        Disposable r116 = r11.g(new d(this));
        if (r116 == null) goto L74;
        RxUtilKt.c(r116, getCompositeDisposable());
    L74:
        r11.i(this, new e(this));
        hd0.c.f().c(getLinkPlayerStateObserver());
        return;
    L9:
        r15 = null;
        goto L10
    }

    public final void p(long r2, long r4) {
        long r5 = r4 - r2;
        if (r5 > 0) goto L6;
        r5 = 0;
    L6:
        SimpleDateFormat r3 = new SimpleDateFormat("mm:ss", Locale.US);
        TextView r6 = getMusicTimeTv();
        if (r6 == null) goto L10;
        r6.setText(s1.C(2131918358, new Object[]{r3.format(Long.valueOf(r5))}));
        r6.setAccessibilityDelegate(new c(r6, this));
        return;
    }
}
