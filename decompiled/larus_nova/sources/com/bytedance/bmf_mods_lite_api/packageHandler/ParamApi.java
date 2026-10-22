package com.bytedance.bmf_mods_lite_api.packageHandler;

/* JADX INFO: loaded from: classes45.dex */
public interface ParamApi {

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_lite_api.packageHandler.ParamApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$clearData(ParamApi r100) {
            return -1;
        }

        public static String $default$dump(ParamApi r100) {
            return "";
        }

        public static int $default$erase(ParamApi r100, long r101) {
            return -1;
        }

        public static long $default$getNativePtr(ParamApi r100) {
            return 0;
        }

        public static boolean $default$hasKey(ParamApi r100, long r101) {
            return false;
        }

        public static double $default$optDouble(ParamApi r100, long r101, double r102) {
            return r102;
        }

        public static double[] $default$optDoubleList(ParamApi r100, long r101, double[] r102) {
            return r102;
        }

        public static float $default$optFloat(ParamApi r100, long r101, float r102) {
            return r102;
        }

        public static float[] $default$optFloatList(ParamApi r100, long r101, float[] r102) {
            return r102;
        }

        public static int $default$optInt(ParamApi r100, long r101, int r102) {
            return r102;
        }

        public static int[] $default$optIntList(ParamApi r100, long r101, int[] r102) {
            return r102;
        }

        public static long $default$optLong(ParamApi r100, long r101, long r102) {
            return r102;
        }

        public static long[] $default$optLongList(ParamApi r100, long r101, long[] r102) {
            return r102;
        }

        public static String $default$optString(ParamApi r100, long r101, String r102) {
            return "";
        }

        public static void $default$release(ParamApi r100) {
        }

        public static int $default$setDouble(ParamApi r100, long r101, double r102) {
            return -1;
        }

        public static int $default$setDoubleList(ParamApi r100, long r101, double[] r102) {
            return -1;
        }

        public static int $default$setFloat(ParamApi r100, long r101, float r102) {
            return -1;
        }

        public static int $default$setFloatList(ParamApi r100, long r101, float[] r102) {
            return -1;
        }

        public static int $default$setInt(ParamApi r100, long r101, int r102) {
            return -1;
        }

        public static int $default$setIntList(ParamApi r100, long r101, int[] r102) {
            return -1;
        }

        public static int $default$setLong(ParamApi r100, long r101, long r102) {
            return -1;
        }

        public static int $default$setLongList(ParamApi r100, long r101, long[] r102) {
            return -1;
        }

        public static int $default$setString(ParamApi r100, long r101, String r102) {
            return -1;
        }
    }

    int clearData();

    String dump();

    int erase(long r100);

    long getNativePtr();

    boolean hasKey(long r100);

    double optDouble(long r100, double r101);

    double[] optDoubleList(long r100, double[] r101);

    float optFloat(long r100, float r101);

    float[] optFloatList(long r100, float[] r101);

    int optInt(long r100, int r101);

    int[] optIntList(long r100, int[] r101);

    long optLong(long r100, long r101);

    long[] optLongList(long r100, long[] r101);

    String optString(long r100, String r101);

    void release();

    int setDouble(long r100, double r101);

    int setDoubleList(long r100, double[] r101);

    int setFloat(long r100, float r101);

    int setFloatList(long r100, float[] r101);

    int setInt(long r100, int r101);

    int setIntList(long r100, int[] r101);

    int setLong(long r100, long r101);

    int setLongList(long r100, long[] r101);

    int setString(long r100, String r101);
}
