package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util;

import android.animation.ValueAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.liveinteract.f;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import ue2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveKtvMidiRenderElementFpsAnimator extends ValueAnimator {
    public long a;
    public ArrayList<ValueAnimator.AnimatorUpdateListener> b;
    public final a c;

    public @interface Method {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public long a;
        public final /* synthetic */ LiveKtvMidiRenderElementFpsAnimator b;

        public a(LiveKtvMidiRenderElementFpsAnimator r3) {
            this.b = r3;
            this.a = 0;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            long r0 = this.a;
            LiveKtvMidiRenderElementFpsAnimator r2 = this.b;
            if ((r0 % r2.a) != 0) goto L9;
            ArrayList<ValueAnimator.AnimatorUpdateListener> r1 = r2.b;
            if (r1 == null) goto L9;
            int r3 = r1.size();
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            ((ValueAnimator.AnimatorUpdateListener) ListProtector.get(this.b.b, r4)).onAnimationUpdate(r7);
            r4 = r4 + 1;
        L9:
            this.a++;
        }
    }

    public LiveKtvMidiRenderElementFpsAnimator() {
        this.a = 1;
        this.b = null;
        this.c = new a(this);
        SettingKey r0 = LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT;
        if (((Integer) f.b(r0)).intValue() <= 0) goto L6;
        this.a = ((Integer) f.b(r0)).intValue();
        return;
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        super.removeAllUpdateListeners();
        ArrayList<ValueAnimator.AnimatorUpdateListener> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clear();
        this.b = null;
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r2) {
        if (this.b != null) goto L5;
        this.b = new ArrayList();
        super.addUpdateListener(this.c);
    L5:
        this.b.add(r2);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r2) {
        ArrayList<ValueAnimator.AnimatorUpdateListener> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r2);
        if (this.b.size() != 0) goto L9;
        super.removeUpdateListener(this.c);
        this.b = null;
        return;
    }

    public static LiveKtvMidiRenderElementFpsAnimator a(final r r1, final String r2, float... r3) {
        LiveKtvMidiRenderElementFpsAnimator r0 = new LiveKtvMidiRenderElementFpsAnimator();
        r0.setFloatValues(r3);
        r0.addUpdateListener(new c(r1, r2));
        return r0;
    }
}
