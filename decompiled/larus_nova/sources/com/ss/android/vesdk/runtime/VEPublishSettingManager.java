package com.ss.android.vesdk.runtime;

import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.vesdk.VEVideoEncodeSettings;

/* JADX INFO: loaded from: classes40.dex */
public class VEPublishSettingManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VEVideoEncodeSettings f455883a;

    public static final enum VEPublishSettingManagerSingleton extends Enum<VEPublishSettingManagerSingleton> {
        public static final VEPublishSettingManagerSingleton INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEPublishSettingManagerSingleton[] f455884a = null;
        private VEPublishSettingManager vePublishSettingManager;

        static {
            VEPublishSettingManagerSingleton r100 = new VEPublishSettingManagerSingleton();
            INSTANCE = r100;
            f455884a = new VEPublishSettingManagerSingleton[]{r100};
        }

        public VEPublishSettingManagerSingleton() {
            super("INSTANCE", 0);
            this.vePublishSettingManager = new VEPublishSettingManager();
        }

        public static VEPublishSettingManagerSingleton[] values() {
            return (VEPublishSettingManagerSingleton[]) f455884a.clone();
        }

        public VEPublishSettingManager getInstance() {
            return this.vePublishSettingManager;
        }

        public static VEPublishSettingManagerSingleton valueOf(String r100) {
            return (VEPublishSettingManagerSingleton) r27.a.a(VEPublishSettingManagerSingleton.class, r100);
        }
    }

    private native int nativeGetEnableRemuxErrorCode();

    private native boolean nativeIsCanRemuxVideo();

    private native boolean nativeIsUseFilterProcess();

    private native int nativeSetEditorStatus(long r100);

    private native int nativeSetVideoEncodeSettings(VEVideoEncodeSettings r100, long r101);

    private native void nativeUpdateVideoEncodeSettings();

    public static VEPublishSettingManager b() {
        return VEPublishSettingManagerSingleton.INSTANCE.getInstance();
    }

    public final VEVideoEncodeSettings f() {
        this.f455883a.setEnableRemuxVideo(nativeIsCanRemuxVideo());
        nativeUpdateVideoEncodeSettings();
        return this.f455883a;
    }

    public final int a() {
        return nativeGetEnableRemuxErrorCode();
    }

    public final boolean c() {
        return nativeIsCanRemuxVideo();
    }

    public final boolean d() {
        return nativeIsUseFilterProcess();
    }

    static {
        TENativeLibsLoader.loadLibrary();
    }

    public VEPublishSettingManager() {
    }

    public final void e(VEVideoEncodeSettings r100, long r101) {
        if (nativeSetVideoEncodeSettings(r100, r101) == 0) goto L5;
        return;
    L5:
        this.f455883a = r100;
    }
}
