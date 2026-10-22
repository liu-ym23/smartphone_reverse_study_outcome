package com.lynx.tasm.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxTextService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxTextService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxTextService r100) {
            return ILynxTextService.class;
        }
    }

    public static class LynxTextInfo {
        private final String[] content;
        private final double height;
        private final double width;

        public String[] getContent() {
            String[] r100 = this.content;
            if (r100 != null) goto L6;
            return null;
        L6:
            return (String[]) r100.clone();
        }

        public double getHeight() {
            return this.height;
        }

        public double getWidth() {
            return this.width;
        }

        public LynxTextInfo(double r100) {
            this(r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        }

        public LynxTextInfo(double r100, String[] r101) {
            this(r100, AudioStats.AUDIO_AMPLITUDE_NONE, r101);
        }

        public LynxTextInfo(double r100, double r101) {
            this(r100, r101, null);
        }

        public LynxTextInfo(double r100, double r101, String[] r102) {
            this.width = r100;
            this.height = r101;
            if (r102 != null) goto L5;
            String[] r103 = null;
        L6:
            this.content = r103;
            return;
        L5:
            r103 = (String[]) r102.clone();
            goto L6
        }
    }

    public interface a {
        int a();

        String b(int r100, int r101);

        float[] c(int r100, int r101);

        void d(Canvas r100, Drawable.Callback r101);

        void destroy();

        int[] e(float r100, float r101);

        int f(float r100, float r101);
    }

    a createPage(long r100);

    long createTextLayoutAPI(Object r100);

    void destroyTextLayoutAPI(long r100);

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    LynxTextInfo getTextInfo(String r100, String r101, String r102, String r103, int r104);
}
