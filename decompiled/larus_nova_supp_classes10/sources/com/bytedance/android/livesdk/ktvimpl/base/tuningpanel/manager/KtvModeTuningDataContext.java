package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/tuningpanel/manager/KtvModeTuningDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "mTuningCore", "Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "getMTuningCore", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "setMTuningCore", "(Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;)V", "Lec0/a;", "mTuningMusicControl", "Lec0/a;", "getMTuningMusicControl", "()Lec0/a;", "setMTuningMusicControl", "(Lec0/a;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvModeTuningDataContext extends DataContext {
    public static final b Companion = null;
    private final CompositeDisposable compositeDisposable;
    private com.bytedance.android.live.ktv.common.tuningpanel.ability.a mTuningCore;
    private ec0.a mTuningMusicControl;

    public static final class a implements Action {
        public final /* synthetic */ KtvModeTuningDataContext a;

        public a(KtvModeTuningDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.getMTuningCore();
            if (r0 == null) goto L5;
            r0.clearData();
        L5:
            ec0.a r1 = this.a.getMTuningMusicControl();
            if (r1 == null) goto L8;
            r1.clearData();
        L8:
            this.a.setMTuningCore(null);
            this.a.setMTuningMusicControl(null);
            KtvModeTuningDataContext.access$getCompositeDisposable$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static com.bytedance.android.live.ktv.common.tuningpanel.ability.a a() {
            DataContext r0 = d.d(KtvModeTuningDataContext.class);
            if ((r0 instanceof KtvModeTuningDataContext) == true) goto L5;
            r0 = null;
        L5:
            KtvModeTuningDataContext r1 = (KtvModeTuningDataContext) r0;
            if (r1 != null) goto L8;
            return null;
        L8:
            return r1.getMTuningCore();
        }
    }

    @JvmStatic
    public static final com.bytedance.android.live.ktv.common.tuningpanel.ability.a getTuningCore() {
        Companion.getClass();
        return b.a();
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final KtvModeTuningDataContext getDataContext() {
        Companion.getClass();
        DataContext r0 = d.d(KtvModeTuningDataContext.class);
        if ((r0 instanceof KtvModeTuningDataContext) == true) goto L6;
        r0 = null;
    L6:
        return (KtvModeTuningDataContext) r0;
    }

    @JvmStatic
    public static final ec0.a getTuningMusicControl() {
        Companion.getClass();
        DataContext r0 = d.d(KtvModeTuningDataContext.class);
        if ((r0 instanceof KtvModeTuningDataContext) == true) goto L5;
        r0 = null;
    L5:
        KtvModeTuningDataContext r1 = (KtvModeTuningDataContext) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getMTuningMusicControl();
    }

    public KtvModeTuningDataContext() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.compositeDisposable = r0;
        Disposable r1 = getOnCleared().subscribe(new a(this));
        if (r1 == null) goto L6;
        RxUtilKt.c(r1, r0);
        return;
    }

    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a getMTuningCore() {
        return this.mTuningCore;
    }

    public final ec0.a getMTuningMusicControl() {
        return this.mTuningMusicControl;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(KtvModeTuningDataContext r0) {
        return r0.compositeDisposable;
    }

    public final void setMTuningCore(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1) {
        this.mTuningCore = r1;
    }

    public final void setMTuningMusicControl(ec0.a r1) {
        this.mTuningMusicControl = r1;
    }
}
