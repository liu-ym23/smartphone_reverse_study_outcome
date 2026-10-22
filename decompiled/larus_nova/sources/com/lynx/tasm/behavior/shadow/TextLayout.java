package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxUIOwner;
import y6a.p;

/* JADX INFO: loaded from: classes32.dex */
public class TextLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f382229a;

    public class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f382230a;

        public a(LynxUIOwner r100) {
            this.f382230a = r100;
        }

        @Override // y6a.p
        public final float[] c(int r100) {
            return this.f382230a.align(r100);
        }

        @Override // y6a.p
        public final void b(int r100, ReadableCompactArrayBuffer r101) {
            this.f382230a.dispatchLayoutBefore(r100, r101);
        }

        @Override // y6a.p
        public final float[] a(int r100, float r101, int r110, float r111, int r112, float[] r113) {
            return this.f382230a.measureText(r100, r101, r110, r111, r112, r113);
        }
    }

    public TextLayout(LynxUIOwner r100) {
        this.f382229a = new a(r100);
    }

    public float[] align(int r100) {
        TraceEvent.beginSection("TextLayout.align");
        float[] r101 = this.f382229a.c(r100);
        TraceEvent.endSection("TextLayout.align");
        return r101;
    }

    public TextLayout(p r100) {
        this.f382229a = r100;
    }

    public void dispatchLayoutBefore(int r100, ReadableCompactArrayBuffer r101) {
        TraceEvent.beginSection("TextLayout.dispatchLayoutBefore");
        this.f382229a.b(r100, r101);
        TraceEvent.endSection("TextLayout.dispatchLayoutBefore");
    }

    public float[] measureText(int r100, float r110, int r111, float r112, int r113, float[] r114) {
        TraceEvent.beginSection("TextLayout.measureText");
        float[] r101 = this.f382229a.a(r100, r110, r111, r112, r113, r114);
        TraceEvent.endSection("TextLayout.measureText");
        return r101;
    }
}
