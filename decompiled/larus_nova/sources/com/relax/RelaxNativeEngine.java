package com.relax;

import android.content.Context;
import com.relax.runtime.gen.AnimationFrame;
import com.relax.runtime.gen.GlobalEventEmitter;
import com.relax.runtime.gen.MediaQuery;
import com.relax.runtime.gen.NativeLayoutProxy;
import com.relax.runtime.gen.NativeListProxy;
import com.relax.runtime.gen.RendererFunction;

/* JADX INFO: loaded from: classes34.dex */
public final class RelaxNativeEngine extends RelaxEngine {
    public AnimationFrame createAnimationFrame() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AnimationFrame(r100.getRelaxEnginePtr());
    }

    public GlobalEventEmitter createGlobalEventEmitter() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GlobalEventEmitter(r100.getRelaxEnginePtr());
    }

    public MediaQuery createMediaQuery() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MediaQuery(r100.getRelaxEnginePtr());
    }

    public NativeLayoutProxy createNativeLayoutProxy() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new NativeLayoutProxy(r100.getRelaxEnginePtr());
    }

    public NativeListProxy createNativeListProxy() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new NativeListProxy(r100.getRelaxEnginePtr());
    }

    public RendererFunction createRendererFunction() {
        if (this.f404544c.b() == true) goto L5;
        return null;
    L5:
        RelaxJNI r100 = this.f404543b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RendererFunction(r100.getRelaxEnginePtr());
    }

    public RelaxNativeEngine(Context r100, RuntimeType r101) {
        super(r100, r101, 1.0f);
    }

    public RelaxNativeEngine(Context r100, RuntimeType r101, float r102) {
        super(r100, r101, r102);
    }
}
