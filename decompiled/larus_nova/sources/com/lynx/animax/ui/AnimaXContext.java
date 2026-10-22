package com.lynx.animax.ui;

import android.content.Context;
import android.content.res.Resources;
import com.lynx.animax.ability.BaseAbility;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseAbility f380432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f380433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f380434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f380435d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseAbility f380436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f380437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f380438c;

        public a(BaseAbility r100, Context r101) {
            this.f380438c = false;
            this.f380436a = r100;
            this.f380437b = r101;
        }
    }

    public boolean disablePlaybackOnAssetLoadFailure() {
        return y4a.a.e(y4a.a.b("ANIMAX_DISABLE_PLAYBACK_ON_ASSET_LOAD_FAILURE", this.f380432a));
    }

    public float getDeviceDensity() {
        if (this.f380435d > 0.0f) goto L6;
        Resources r100 = this.f380433b.getResources();
        this.f380435d = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
    L6:
        return this.f380435d;
    }

    public BaseAbility getAbility() {
        return this.f380432a;
    }

    public Context getContext() {
        return this.f380433b;
    }

    public boolean multiThreadAccelerate() {
        return this.f380434c;
    }

    public AnimaXContext(a r100) {
        this.f380435d = 0.0f;
        this.f380432a = r100.f380436a;
        this.f380433b = r100.f380437b;
        this.f380434c = r100.f380438c;
    }
}
