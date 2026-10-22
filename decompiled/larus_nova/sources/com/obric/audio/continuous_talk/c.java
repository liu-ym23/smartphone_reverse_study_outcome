package com.obric.audio.continuous_talk;

import java.util.Map;

/* JADX INFO: loaded from: classes33.dex */
public interface c extends m1a.a {

    public static final class a {
        public static /* synthetic */ void b(c r100, int r101, Integer r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            r100.Yd(r101, null, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r100, ObricContinuousTalkEndType r101, Map r102, boolean r103, boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = ObricContinuousTalkEndType.OTHER;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = true;
        L12:
            if ((r105 & 8) == 0) goto L14;
            r104 = false;
        L14:
            r100.f10(r101, r102, r103, r104);
        }
    }

    void Yd(int r100, Map<String, Object> r101, Integer r102);

    void f10(ObricContinuousTalkEndType r100, Map<String, Object> r101, boolean r102, boolean r103);

    boolean m0();

    boolean qO(int r100);
}
