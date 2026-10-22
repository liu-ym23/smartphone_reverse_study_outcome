package com.bytedance.livesdk.ktvcommon.midi.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class LiveDegradeFpsAnimator extends ValueAnimator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f256059e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f256060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f256061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ValueAnimator.AnimatorUpdateListener> f256062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f256063d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/LiveDegradeFpsAnimator$Method;", "", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Method {
    }

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator$a$a, reason: collision with other inner class name */
        public static final class C3637a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f256064a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f256065b;

            public C3637a(String r100, View r101) {
                this.f256064a = r100;
                this.f256065b = r101;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                Object r101 = r100.getAnimatedValue();
                if (r101 == null) goto L27;
                float r102 = ((Float) r101).floatValue();
                int r103 = LiveDegradeFpsAnimator.f256059e;
                View r104 = this.f256065b;
                String r105 = this.f256064a;
                switch(r105.hashCode()) {
                    case -1225497657: goto L23;
                    case -1225497656: goto L20;
                    case -908189618: goto L17;
                    case -908189617: goto L14;
                    case -40300674: goto L11;
                    case 92909918: goto L8;
                    default: goto L39;
                };
            L39:
                return;
            L8:
                if (r105.equals("alpha") == false) goto L28;
                r104.setAlpha(r102);
                return;
            L28:
                return;
            L11:
                if (r105.equals("rotation") == false) goto L30;
                r104.setRotation(r102);
                return;
            L30:
                return;
            L14:
                if (r105.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_Y) == false) goto L32;
                r104.setScaleY(r102);
                return;
            L32:
                return;
            L17:
                if (r105.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_X) == false) goto L34;
                r104.setScaleX(r102);
                return;
            L34:
                return;
            L20:
                if (r105.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L36;
                r104.setTranslationY(r102);
                return;
            L36:
                return;
            L23:
                if (r105.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L38;
                r104.setTranslationX(r102);
                return;
            L38:
                return;
            L27:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public static LiveDegradeFpsAnimator a(View r100, String r101, float... r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            Intrinsics.checkNotNullParameter(r102, "values");
            LiveDegradeFpsAnimator r103 = new LiveDegradeFpsAnimator();
            r103.f256060a = r101;
            r103.setFloatValues(Arrays.copyOf(r102, r102.length));
            r103.addUpdateListener(new C3637a(r101, r100));
            return r103;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDegradeFpsAnimator f256066a;

        public b(LiveDegradeFpsAnimator r100) {
            this.f256066a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LiveDegradeFpsAnimator r101 = this.f256066a;
            if ((r101.f256063d % r101.f256061b) != 0) goto L8;
            Iterator r102 = CollectionsKt.toList(r101.f256062c).iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            ((ValueAnimator.AnimatorUpdateListener) r102.next()).onAnimationUpdate(r100);
        L8:
            this.f256066a.f256063d++;
        }
    }

    static {
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        this.f256063d = 0;
        super.cancel();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        ((ArrayList) this.f256062c).clear();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void start() {
        this.f256063d = 0;
        super.start();
    }

    public LiveDegradeFpsAnimator() {
        this.f256061b = 1;
        this.f256062c = new ArrayList();
        b r100 = new b(this);
        Integer r101 = (Integer) com.bytedance.android.live.liveinteract.f.b(LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT);
        if (r101.intValue() <= 0) goto L5;
        this.f256061b = r101.intValue();
    L5:
        super.addUpdateListener(r100);
    }

    public final void a(int r100) {
        if (r100 <= 0) goto L5;
        this.f256061b = r100;
        return;
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f256062c).add(r100);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f256062c).remove(r100);
    }
}
