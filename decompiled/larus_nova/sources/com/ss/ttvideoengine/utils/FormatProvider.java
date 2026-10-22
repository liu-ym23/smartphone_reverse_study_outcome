package com.ss.ttvideoengine.utils;

/* JADX INFO: loaded from: classes35.dex */
public interface FormatProvider {
    public static final FormatProvider DEFAULT = null;
    public static final int FORMAT_M3U8 = 1;
    public static final int FORMAT_MPD = 2;
    public static final int FORMAT_NORMAL = 0;

    public static class Default implements FormatProvider {
        public Default() {
        }

        private static boolean isM3u8(String r100) {
            if (r100.contains(".m3u8?") == false) goto L5;
        L12:
            return true;
        L5:
            if (r100.endsWith(".m3u8") == true) goto L12;
            if (r100.contains(".m3u?") == true) goto L12;
            if (r100.endsWith(".m3u") == true) goto L12;
            return false;
        }

        private static boolean isMpd(String r100) {
            if (r100.endsWith(".mpd") == false) goto L5;
        L8:
            return true;
        L5:
            if (r100.contains(".mpd?") == true) goto L8;
            return false;
        }

        @Override // com.ss.ttvideoengine.utils.FormatProvider
        public int provideFormat(String r100) {
            if (r100 != null) goto L5;
            return 0;
        L5:
            String r101 = r100.toLowerCase();
            if (isM3u8(r101) == false) goto L10;
            return 1;
        L10:
            if (isMpd(r101) == false) goto L13;
            return 2;
        L13:
            return 0;
        }
    }

    public static class FormatProviderHolder {
        private static FormatProvider sInstance;

        public FormatProviderHolder() {
        }

        static {
            sInstance = FormatProvider.DEFAULT;
        }

        public static FormatProvider get() {
            FormatProvider r100 = sInstance;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FormatProvider.DEFAULT;
        }

        public static boolean isM3u8(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (get().provideFormat(r100) != 1) goto L9;
            return true;
        L9:
            return false;
        }

        public static boolean isMpd(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (get().provideFormat(r100) != 2) goto L9;
            return true;
        L9:
            return false;
        }

        public static void set(FormatProvider r100) {
            sInstance = r100;
        }
    }

    int provideFormat(String r100);

    static {
        DEFAULT = new Default();
    }
}
