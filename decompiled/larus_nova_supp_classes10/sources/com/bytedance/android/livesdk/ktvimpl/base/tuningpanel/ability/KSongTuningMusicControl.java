package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvMusicFeedbackDialog;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.h;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongTuningMusicControl implements ec0.a {
    public MusicPanel a;
    public final Lazy b;
    public final MutableLiveData<Boolean> c;
    public final Lazy d;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Consumer a;

        public b(Consumer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Consumer r0 = this.a;
            r0.accept((fd2.a) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Observer a;

        public c(Observer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Observer r0 = this.a;
            r0.onChanged((Boolean) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Observer a;

        public d(Observer r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            Observer r0 = this.a;
            boolean r1 = false;
            if (r4 == null) goto L5;
            int r5 = r4.size();
        L6:
            if (r5 <= 0) goto L8;
            r1 = true;
        L8:
            r0.onChanged(Boolean.valueOf(r1));
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    static {
    }

    public final boolean a() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPaused() != true) goto L7;
        return true;
    }

    public final boolean b() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L6;
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue()).booleanValue();
    L6:
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.H.getValue()).booleanValue();
    }

    public final long c() {
        KtvContext.Companion.getClass();
        i r0 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 == null) goto L7;
        Long r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public final void clearData() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener((com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b) this.d.getValue());
    L5:
        ((CompositeDisposable) this.b.getValue()).clear();
    }

    public final boolean d() {
        if (ChorusContext.Companion.c() == false) goto L7;
        f2.b(2131918309, 0);
        return false;
    L7:
        if (ne2.a.a() == false) goto L10;
        f2.b(2131918254, 0);
        return false;
    L10:
        MusicPanel r0 = this.a;
        if (r0 != null) goto L13;
    L16:
        f2.b(2131918461, 0);
        return false;
    L13:
        if (KtvUtilsKt.B(r0) != true) goto L16;
        return true;
    }

    public final boolean g() {
        MusicPanel r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (KtvUtilsKt.D(r0) != true) goto L7;
        return true;
    }

    public final boolean h() {
        MusicPanel r0 = this.a;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (KtvUtilsKt.B(r0) != true) goto L11;
        if (ChorusContext.Companion.c() == true) goto L11;
        if (ne2.a.a() == true) goto L11;
        return true;
    }

    public final void i() {
        pb0.a r0 = pb0.b.a;
        Intrinsics.checkNotNullParameter("tuning_panel", "requestPage");
        Intrinsics.checkNotNullParameter("", "eventPage");
        Intrinsics.checkNotNullParameter("tuning_panel", "iconType");
        pb0.a r1 = pb0.b.a;
        if (r1 == null) goto L5;
        pb0.a.a.b(r1, "tuning_panel", "", "tuning_panel", null, null, 16);
    L5:
        KtvContext.Companion.getClass();
        KtvContext.a.g().getOpenKtvRoomDialogEvent().post(new od2.b("tone_tuning", false, null));
        xs2.b.a().post(new ae2.a("go_order_song"));
    }

    public final void j() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        boolean r1 = r0.isPaused();
    L6:
        if (r1 == false) goto L8;
        String r2 = "resume";
    L9:
        KSongTuningPanelHelperKt.c(r2);
        if (ne2.a.a() == false) goto L13;
        f2.b(2131918251, 0);
        return;
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.e;
        if (r3 == null) goto L17;
        r3.togglePause(!r1);
        return;
    L17:
        return;
    L8:
        r2 = "pause";
        goto L9
    L5:
        r1 = true;
        goto L6
    }

    public final void k() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L6;
        r0.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_EFFECT, BaseCoreViewModel.CORE_TAG_STATE}), (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b) this.d.getValue(), false);
        return;
    }

    public final boolean l() {
        if (com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.h(this.a) == false) goto L7;
        f2.c(s1.B(2131897379), 0);
        return false;
    L7:
        if (g() == true) goto L19;
        MusicPanel r0 = this.a;
        if (r0 != null) goto L11;
    L13:
        MusicPanel r1 = this.a;
        if (r1 != null) goto L16;
    L18:
        return false;
    L16:
        if (KtvUtilsKt.o(r1) != true) goto L18;
        f2.b(2131918460, 0);
        goto L18
    L11:
        if (KtvUtilsKt.p(r0) != true) goto L13;
        f2.b(2131918458, 0);
        goto L18
    L19:
        return true;
    }

    public final long o() {
        KtvContext.Companion.getClass();
        i r0 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    public final MusicPanel e() {
        return this.a;
    }

    public KSongTuningMusicControl(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1) {
        this.e = r1;
        this.b = LazyKt.lazy(KSongTuningMusicControl$compositeDisposable$2.INSTANCE);
        this.c = new MutableLiveData();
        this.d = LazyKt.lazy(new KSongTuningMusicControl$ktvCoreListener$2(this));
    }

    public final void m(MusicPanel r1) {
        this.a = r1;
    }

    public final Disposable n(Consumer<fd2.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ALogger.d("ttlive_ktv_realTimeChorus_KSongTuningMusicControl", "observePlayProgressEvent");
        KtvContext.Companion.getClass();
        i r0 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 == null) goto L7;
        PublishSubject<fd2.a> r1 = r0.g;
        if (r1 == null) goto L7;
        return r1.subscribe(new b(r3));
    L7:
        return null;
    }

    public final void q(boolean r3) {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L10;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isMidiOpened();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r3));
    L9:
        e r2 = com.bytedance.android.livesdk.sharedpref.c.M;
        Boolean r4 = Boolean.valueOf(r3);
        r2.getClass();
        f.d(r2, r4);
    L20:
        if (r3 == false) goto L22;
        int r5 = 2131918571;
    L23:
        f2.b(r5, 0);
        return;
    L22:
        r5 = 2131918570;
        goto L23
    L10:
        KtvComponentContext r6 = KtvComponentContext.Companion.getContext();
        if (r6 == null) goto L19;
        n<KtvComponentUIContext> r7 = r6.getKtvComponentUIContext();
        if (r7 == null) goto L19;
        KtvComponentUIContext r8 = (KtvComponentUIContext) r7.getValue();
        if (r8 == null) goto L19;
        MutableLiveData<Boolean> r9 = r8.getScoreOpen();
        if (r9 == null) goto L19;
        r9.setValue(Boolean.valueOf(r3));
    L19:
        e r10 = com.bytedance.android.livesdk.sharedpref.c.H;
        Boolean r11 = Boolean.valueOf(r3);
        r10.getClass();
        f.d(r10, r11);
        goto L20
    }

    public final void s(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        long r0 = o();
        long r2 = LocationInfoConst.HALF_MINUTES;
        if (0 <= r0) goto L6;
    L26:
        KSongTuningPanelHelperKt.c("cut");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r10 = this.e;
        if (r10 == null) goto L29;
        r10.cutMusic();
    L29:
        xs2.b.a().post(new ae2.a("cut_song"));
        return;
    L6:
        if (r2 < r0) goto L26;
        KSongTuningPanelHelperKt.c("cut");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.e;
        if (r1 == null) goto L10;
        r1.cutMusic();
    L10:
        int r3 = KtvRoomFeedbackGuideDialog.k;
        MusicPanel r4 = this.a;
        String r5 = "";
        if (r4 == null) goto L16;
        KtvMusic r6 = r4.a;
        if (r6 == null) goto L16;
        String r7 = r6.getMTitle();
        if (r7 == null) goto L16;
    L17:
        MusicPanel r8 = this.a;
        if (r8 == null) goto L25;
        KtvMusic r11 = r8.a;
        if (r11 == null) goto L25;
        String r12 = r11.getMAuthor();
        if (r12 == null) goto L25;
        r5 = r12;
    L25:
        KtvRoomFeedbackGuideDialog.a.a(new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r7, r5), KtvMusicFeedbackDialog.FeedbackType.KSONG_SONG_INFO).U90(r9);
    L16:
        r7 = "";
        goto L17
    }

    public final void f(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L9;
        h r0 = (h) KtvContext.a.g().getBigEventHelper().getValue();
        if (r0 == null) goto L19;
        NextLiveData r1 = r0.e;
        if (r1 == null) goto L20;
        r1.observe(r2, r3);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        KtvComponentContext r4 = KtvComponentContext.Companion.getContext();
        if (r4 == null) goto L22;
        n<KtvComponentUIContext> r5 = r4.getKtvComponentUIContext();
        if (r5 == null) goto L23;
        KtvComponentUIContext r6 = (KtvComponentUIContext) r5.getValue();
        if (r6 == null) goto L24;
        MutableLiveData<Boolean> r7 = r6.getOriginOpen();
        if (r7 == null) goto L25;
        r7.observe(r2, r3);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void p(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.c.observe(r2, r3);
    }

    public final void r(LifecycleOwner r3, Observer<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L13;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r5 = KtvRoomContext.a.a();
        if (r5 == null) goto L22;
        m<Boolean> r6 = r5.isMidiOpened();
        if (r6 == null) goto L22;
        Observable r7 = r6.a();
        if (r7 == null) goto L22;
        Disposable r8 = r7.subscribe(new c(r4));
        if (r8 == null) goto L22;
        RxUtilKt.c(r8, (CompositeDisposable) this.b.getValue());
    L22:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = this.e;
        if (r9 == null) goto L30;
        OrderedSongDataContext r10 = r9.getOrderedSongDataContext();
        if (r10 == null) goto L31;
        Disposable r11 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r10, null, new d(r4), 3);
        if (r11 == null) goto L32;
        RxUtilKt.c(r11, (CompositeDisposable) this.b.getValue());
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L13:
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L22;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L22;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L22;
        MutableLiveData<Boolean> r12 = r2.getScoreOpen();
        if (r12 == null) goto L22;
        r12.observe(r3, r4);
        goto L22
    }
}
