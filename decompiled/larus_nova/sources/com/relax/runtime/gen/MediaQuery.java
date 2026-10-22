package com.relax.runtime.gen;

import com.relax.relaxframework.v2;
import com.relax.relaxframework.w2;

/* JADX INFO: loaded from: classes34.dex */
public class MediaQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405693a;

    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeaddListener(long r100, GlobalStateChangeCallback r101, String r102);

    private native GlobalState nativefetchCurrentState(long r100, String r101);

    private native void nativeremoveAllListeners(long r100);

    private native void nativeremoveListener(long r100, GlobalStateChangeCallback r101);

    public final void a() {
        nativeDestroy(this.f405693a);
    }

    public MediaQuery() {
        this.f405693a = 0;
    }

    public final GlobalState c() {
        return nativefetchCurrentState(this.f405693a, "{\"type\":\"class\",\"class\":\"com.relax.runtime.gen.GlobalState\",\"fields\":{\"screenWidth\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"screenWidth\",\"index\":0},\"screenHeight\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"screenHeight\",\"index\":1},\"viewportWidth\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"viewportWidth\",\"index\":2},\"viewportHeight\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"viewportHeight\",\"index\":3},\"devicePixelRatio\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"devicePixelRatio\",\"index\":4},\"fontScale\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"fontScale\",\"index\":5},\"nightMode\":{\"type\":\"primitive\",\"class\":\"boolean\",\"name\":\"nightMode\",\"index\":6},\"platform\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"platform\",\"index\":7},\"relaxVersion\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"relaxVersion\",\"index\":8}}}");
    }

    public MediaQuery(long r100) {
        this.f405693a = 0;
        this.f405693a = nativeCreate(r100);
    }

    public final void b(v2 r100) {
        nativeaddListener(this.f405693a, r100, "{\"type\":\"class\",\"class\":\"com.relax.runtime.gen.GlobalState\",\"fields\":{\"screenWidth\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"screenWidth\",\"index\":0},\"screenHeight\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"screenHeight\",\"index\":1},\"viewportWidth\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"viewportWidth\",\"index\":2},\"viewportHeight\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"viewportHeight\",\"index\":3},\"devicePixelRatio\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"devicePixelRatio\",\"index\":4},\"fontScale\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"fontScale\",\"index\":5},\"nightMode\":{\"type\":\"primitive\",\"class\":\"boolean\",\"name\":\"nightMode\",\"index\":6},\"platform\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"platform\",\"index\":7},\"relaxVersion\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"relaxVersion\",\"index\":8}}}");
    }

    public final void d(w2 r100) {
        nativeremoveListener(this.f405693a, r100);
    }
}
