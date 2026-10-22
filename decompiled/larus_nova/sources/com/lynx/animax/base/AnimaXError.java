package com.lynx.animax.base;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum AnimaXError extends Enum<AnimaXError> {
    public static final AnimaXError BLOCK_DEVICE = null;
    public static final AnimaXError LIBRARY_INIT_ERROR = null;
    public static final AnimaXError NO_ERROR = null;
    public static final AnimaXError RESOURCE_NOT_FOUND = null;
    public static final AnimaXError VIDEO_PLAYER_ERROR = null;
    public static final AnimaXError VIDEO_PLAYER_ERROR_HAS_OCCURRED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimaXError[] f380255a = null;
    private final int errorCode;

    static {
        AnimaXError r100 = new AnimaXError("NO_ERROR", 0, 0);
        NO_ERROR = r100;
        AnimaXError r101 = new AnimaXError("RESOURCE_NOT_FOUND", 1, 1);
        RESOURCE_NOT_FOUND = r101;
        AnimaXError r102 = new AnimaXError("LIBRARY_INIT_ERROR", 2, 12);
        LIBRARY_INIT_ERROR = r102;
        AnimaXError r103 = new AnimaXError("VIDEO_PLAYER_ERROR", 3, 100);
        VIDEO_PLAYER_ERROR = r103;
        AnimaXError r104 = new AnimaXError("VIDEO_PLAYER_ERROR_HAS_OCCURRED", 4, 101);
        VIDEO_PLAYER_ERROR_HAS_OCCURRED = r104;
        AnimaXError r105 = new AnimaXError("BLOCK_DEVICE", 5, 200);
        BLOCK_DEVICE = r105;
        f380255a = new AnimaXError[]{r100, r101, r102, r103, r104, r105};
    }

    public static Map<String, Object> createBlockErrorParam() {
        HashMap r100 = new HashMap();
        r100.put("code", Integer.valueOf(BLOCK_DEVICE.ordinal()));
        r100.put("msg", "The device is not support.");
        return r100;
    }

    public static Map<String, Object> createLibraryInitErrorParam() {
        HashMap r100 = new HashMap();
        r100.put("code", Integer.valueOf(LIBRARY_INIT_ERROR.ordinal()));
        r100.put("msg", "Library init error.");
        return r100;
    }

    public static AnimaXError[] values() {
        return (AnimaXError[]) f380255a.clone();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static AnimaXError valueOf(String r100) {
        return (AnimaXError) a.a(AnimaXError.class, r100);
    }

    public AnimaXError(String r100, int r101, int r102) {
        super(r100, r101);
        this.errorCode = r102;
    }
}
