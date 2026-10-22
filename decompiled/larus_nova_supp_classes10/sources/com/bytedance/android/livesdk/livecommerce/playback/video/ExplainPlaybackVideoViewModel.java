package com.bytedance.android.livesdk.livecommerce.playback.video;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import hh2.f;
import hh2.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/video/ExplainPlaybackVideoViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/playback/video/b;", "Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$a;", "event", "", "changeSpeed", "", "autoChangeSpeed", "Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$d;", "updateProgress", "", "playDuration", "setPlayDuration", "<set-?>", "I", "getPlayDuration", "()I", "", "isSpeedEnableAB", "Z", "()Z", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackVideoViewModel extends QStateViewModel<b> {
    public static final a Companion = null;
    public static final int LIVE_REPLAY_OPTIMIZE_JUST_HAS_LIVE = 2;
    public static final int LIVE_REPLAY_OPTIMIZE_JUST_HAS_SPEED = 1;
    public static final int LIVE_REPLAY_OPTIMIZE_JUST_HAS_SPEED_AND_LIVE = 3;
    public static final float SPEED_1D5X = 1.5f;
    public static final float SPEED_1X = 1.0f;
    public static final float SPEED_2X = 2.0f;
    public static final float SPEED_INVALID = -1.0f;
    private final boolean isSpeedEnableAB;
    private int playDuration;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.video.a.d, Unit> {
        public AnonymousClass1(ExplainPlaybackVideoViewModel r8) {
            super(1, r8, ExplainPlaybackVideoViewModel.class, "updateProgress", "updateProgress(Lcom/bytedance/android/livesdk/livecommerce/playback/video/ExplainPlaybackVideoEvent$ProgressEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.video.a.d r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackVideoViewModel.access$updateProgress((ExplainPlaybackVideoViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.video.a.d) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$a;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/video/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a, Unit> {
        public AnonymousClass2(ExplainPlaybackVideoViewModel r8) {
            super(1, r8, ExplainPlaybackVideoViewModel.class, "changeSpeed", "changeSpeed(Lcom/bytedance/android/livesdk/livecommerce/playback/video/ExplainPlaybackVideoEvent$ChangeSpeedEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackVideoViewModel.access$changeSpeed((ExplainPlaybackVideoViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ExplainPlaybackVideoViewModel() {
        boolean r1 = false;
        super(new b(0));
        if (ECSettingKeys.t0() != 1) goto L5;
    L13:
        r1 = true;
    L14:
        this.isSpeedEnableAB = r1;
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.video.a.d.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a.class), new AnonymousClass2(this));
        return;
    L5:
        if (ECSettingKeys.t0() == 3) goto L13;
        g r0 = f.a.a;
        if (r0 == null) goto L11;
        Boolean r2 = r0.g();
        if (r2 == null) goto L11;
        boolean r3 = r2.booleanValue();
    L12:
        if (r3 == false) goto L14;
    L11:
        r3 = false;
        goto L12
    }

    private final float autoChangeSpeed() {
        float r0 = ((b) getState()).c;
        if (r0 != 1.0f) goto L6;
        return 1.5f;
    L6:
        if (r0 != 1.5f) goto L8;
        return 2.0f;
    L8:
        return 1.0f;
    }

    public final int getPlayDuration() {
        return this.playDuration;
    }

    public final boolean isSpeedEnableAB() {
        return this.isSpeedEnableAB;
    }

    private final void changeSpeed(com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a r3) {
        float r4 = r3.a;
        final float r0 = 1.0f;
        if (r4 == 1.0f) goto L12;
        r0 = 1.5f;
        if (r4 == 1.5f) goto L12;
        r0 = 2.0f;
        if (r4 == 2.0f) goto L12;
        r0 = autoChangeSpeed();
    L12:
        int r5 = bj2.a.a;
        bj2.a.b("ExplainPlaybackVideoViewModel", "changeSpeed:" + r0);
        setState(new C02891(r0));
    }

    private final void updateProgress(final com.bytedance.android.livesdk.livecommerce.playback.video.a.d r2) {
        setState(new C02901(r2));
    }

    public final void setPlayDuration(int r1) {
        this.playDuration = r1;
    }

    public static final /* synthetic */ void access$changeSpeed(ExplainPlaybackVideoViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.video.a.C0084a r1) {
        r0.changeSpeed(r1);
    }

    public static final /* synthetic */ void access$updateProgress(ExplainPlaybackVideoViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.video.a.d r1) {
        r0.updateProgress(r1);
    }
}
