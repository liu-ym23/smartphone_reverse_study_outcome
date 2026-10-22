package com.ss.android.lark.picker.base.statistics;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.fg.PickerFgUtils;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.i;
import z5c.z2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0011J\u001c\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "", "biz", "", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "getScene", "hasTrackRecommendRender", "", "trackShow", "", "trackDestroy", "trackClickItem", "action", "Lcom/ss/android/lark/statistics/extensions/IParam;", "source", "trackSearch", "duration", "", "trackRecommendRender", "dataDuration", "uiDuration", "type", GXTemplateKey.GAIAX_TRACK, "eventName", "eventParams", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerTracker {
    private static final Companion Companion = null;
    private static final String TAG = "PickerTracker";
    private final String biz;
    private boolean hasTrackRecommendRender;
    private final String scene;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/statistics/PickerTracker$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void trackDestroy() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC120421(this));
    }

    public final void trackShow() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC120451(this));
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getScene() {
        return this.scene;
    }

    public PickerTracker(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.biz = r100;
        this.scene = r101;
    }

    public static final /* synthetic */ void access$setHasTrackRecommendRender$p(PickerTracker r100, boolean r101) {
        r100.hasTrackRecommendRender = r101;
    }

    private final void track(String r100, d r101) {
        if (PickerFgUtils.INSTANCE.isClosePickerTracker() == false) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        d r102 = d.b.b(i.f570217c.a(this.biz), z2.f570438k.a(this.scene));
    L8:
        Log.i(TAG, "eventName: " + r100 + "\neventParams: biz -- " + this.biz + ", scene -- " + this.scene);
        Statistics.sendEvent(r100, r102.toJson());
        return;
    L7:
        r102 = r101.plus(i.f570217c.a(this.biz)).plus(z2.f570438k.a(this.scene));
        goto L8
    }

    public final void trackClickItem(final d r100, final d r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "source");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(this, r100, r101));
    }

    public final void trackSearch(final d r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC120441(this, r100, r101));
    }

    public static final /* synthetic */ void access$track(PickerTracker r100, String r101, d r102) {
        r100.track(r101, r102);
    }

    public final void trackRecommendRender(final long r110, final long r111, final d r112) {
        Intrinsics.checkNotNullParameter(r112, "type");
        if (this.hasTrackRecommendRender == false) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC120431(this, r110, r111, r112));
    }

    public static /* synthetic */ void track$default(PickerTracker r100, String r101, d r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.track(r101, r102);
    }

    public static /* synthetic */ void trackSearch$default(PickerTracker r100, d r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.trackSearch(r101, r102);
    }
}
