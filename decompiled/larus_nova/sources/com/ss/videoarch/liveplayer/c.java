package com.ss.videoarch.liveplayer;

import android.hardware.HardwareBuffer;

/* JADX INFO: loaded from: classes38.dex */
public interface c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f458808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f458809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f458810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f458811d;

        public a(HardwareBuffer r100, int[] r101, int r102, int r103) {
            this.f458808a = 0;
            this.f458809b = 0;
            this.f458810c = 0;
            this.f458811d = 0;
            int r104 = r101[2];
            if (r104 == 0) goto L7;
            int r105 = r101[3];
            if (r105 == 0) goto L7;
            this.f458809b = r104;
            this.f458811d = r105;
            this.f458808a = r101[0];
            this.f458810c = r101[1];
            boolean r106 = false;
        L8:
            if (r106 == false) goto L11;
            int r107 = r101[0];
            int r108 = r101[1];
            int r109 = r101[2];
            int r110 = r101[3];
            return;
        L11:
            return;
        L7:
            this.f458809b = 720;
            this.f458811d = 1280;
            this.f458808a = 0;
            this.f458810c = 0;
            r106 = true;
            goto L8
        }
    }

    void onDrawFrame(a r100);
}
