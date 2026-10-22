package com.oplus.util;

/* JADX INFO: loaded from: classes34.dex */
public class OplusHoraeThermalHelper {
    private static final String TAG = "HoraeHelper";

    /* JADX INFO: renamed from: com.oplus.util.OplusHoraeThermalHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonHolder {
        private static OplusHoraeThermalHelper instance;

        private SingletonHolder() {
        }

        static {
            instance = new OplusHoraeThermalHelper(null);
        }

        public static /* synthetic */ OplusHoraeThermalHelper access$000() {
            return instance;
        }
    }

    public float getCurrentThermal() {
        return -1.0f;
    }

    public static OplusHoraeThermalHelper getInstance() {
        return SingletonHolder.access$000();
    }

    private OplusHoraeThermalHelper() {
    }

    public /* synthetic */ OplusHoraeThermalHelper(AnonymousClass1 r100) {
        this();
    }
}
