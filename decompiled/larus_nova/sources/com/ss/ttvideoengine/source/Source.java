package com.ss.ttvideoengine.source;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public interface Source {
    public static final int KEY_COST_SAVING_FIRST = 1;
    public static final int KEY_HARDWARE_DECODE_FIRST = 2;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.Source$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean isCodecStrategyValid(int r100) {
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 == 2) goto L10;
            return false;
        L10:
            return true;
        }

        public static boolean $default$isCodecStrategyValid(Source r100) {
            return isCodecStrategyValid(r100.codecStrategy());
        }
    }

    public static final class EncodeType {
        public static final String BYTEVC1 = "bytevc1";
        public static final String BYTEVC2 = "bytevc2";
        public static final String H264 = "h264";

        public EncodeType() {
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type DIRECT_URL_SOURCE = null;
        public static final Type VIDEO_MODEL_SOURCE = null;
        public static final Type VID_PLAY_AUTH_TOKEN_SOURCE = null;

        static {
            Type r100 = new Type("DIRECT_URL_SOURCE", 0);
            DIRECT_URL_SOURCE = r100;
            Type r101 = new Type("VID_PLAY_AUTH_TOKEN_SOURCE", 1);
            VID_PLAY_AUTH_TOKEN_SOURCE = r101;
            Type r102 = new Type("VIDEO_MODEL_SOURCE", 2);
            VIDEO_MODEL_SOURCE = r102;
            $VALUES = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    int codecStrategy();

    boolean isCodecStrategyValid();

    Object tag();

    Type type();

    String vid();
}
