package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface SurfaceProcessor {
    void onInputSurface(SurfaceRequest r1) throws ProcessingException;

    void onOutputSurface(SurfaceOutput r1) throws ProcessingException;
}
