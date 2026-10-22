package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public class PostStartupMethodOpt {

    public static final enum ProfileOptType extends Enum<ProfileOptType> {
        private static final /* synthetic */ ProfileOptType[] $VALUES = null;
        public static final ProfileOptType NOT_SKIP_ALL = null;
        public static final ProfileOptType SKIP_ALL = null;
        public static final ProfileOptType SKIP_POST_STARTUP = null;

        static {
            ProfileOptType r100 = new ProfileOptType("SKIP_POST_STARTUP", 0, 0);
            SKIP_POST_STARTUP = r100;
            ProfileOptType r101 = new ProfileOptType("SKIP_ALL", 1, 1);
            SKIP_ALL = r101;
            ProfileOptType r102 = new ProfileOptType("NOT_SKIP_ALL", 2, 2);
            NOT_SKIP_ALL = r102;
            $VALUES = new ProfileOptType[]{r100, r101, r102};
        }

        public static ProfileOptType[] values() {
            return (ProfileOptType[]) $VALUES.clone();
        }

        public static ProfileOptType valueOf(String r100) {
            return (ProfileOptType) a.a(ProfileOptType.class, r100);
        }

        private ProfileOptType(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    public PostStartupMethodOpt() {
    }

    public static native void delayProfileSaver(long r100);

    private static native void enlargeProfileOptInternal(int r100);

    private static native void writeProfileOptInternal(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void enlargeProfileOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        enlargeProfileOptInternal(r100);
    }

    public static void writeProfileOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        writeProfileOptInternal(r100);
    }
}
