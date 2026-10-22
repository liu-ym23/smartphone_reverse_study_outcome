package com.ss.ugc.live.sdk.message.stream;

import r27.a;
import tlc.d;

/* JADX INFO: loaded from: classes36.dex */
public interface IStreamMessage extends d {

    public static final enum DelayMode extends Enum<DelayMode> {
        public static final DelayMode CLEAR = null;
        public static final DelayMode DEFAULT = null;
        public static final DelayMode NOW = null;
        public static final DelayMode SEI_DIFF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DelayMode[] f458179a = null;

        static {
            DelayMode r100 = new DelayMode("DEFAULT", 0);
            DEFAULT = r100;
            DelayMode r101 = new DelayMode("CLEAR", 1);
            CLEAR = r101;
            DelayMode r102 = new DelayMode("NOW", 2);
            NOW = r102;
            DelayMode r103 = new DelayMode("SEI_DIFF", 3);
            SEI_DIFF = r103;
            f458179a = new DelayMode[]{r100, r101, r102, r103};
        }

        public static DelayMode[] values() {
            return (DelayMode[]) f458179a.clone();
        }

        public static DelayMode valueOf(String r100) {
            return (DelayMode) a.a(DelayMode.class, r100);
        }

        public DelayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    DelayMode getDelayMode();

    long getProcessAtSeiTs();

    long getServerDelay();

    long getTargetSei();

    boolean ignoreCondition();

    boolean isStreamMessage();
}
