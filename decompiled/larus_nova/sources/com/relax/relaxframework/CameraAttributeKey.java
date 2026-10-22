package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/CameraAttributeKey;", "", "", "value", "I", "getValue", "()I", "Facing", ExifInterface.TAG_FLASH, "InitialZoom", "Resolution", "EnableZoomGesture", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CameraAttributeKey extends Enum<CameraAttributeKey> {
    public static final CameraAttributeKey EnableZoomGesture = null;
    public static final CameraAttributeKey Facing = null;
    public static final CameraAttributeKey Flash = null;
    public static final CameraAttributeKey InitialZoom = null;
    public static final CameraAttributeKey Resolution = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraAttributeKey[] f404693a = null;
    private final int value;

    public static CameraAttributeKey valueOf(String r100) {
        return (CameraAttributeKey) r27.a.a(CameraAttributeKey.class, r100);
    }

    public static CameraAttributeKey[] values() {
        return (CameraAttributeKey[]) f404693a.clone();
    }

    static {
        CameraAttributeKey r100 = new CameraAttributeKey("Facing", 0, 20281);
        Facing = r100;
        CameraAttributeKey r101 = new CameraAttributeKey(ExifInterface.TAG_FLASH, 1, 20285);
        Flash = r101;
        CameraAttributeKey r102 = new CameraAttributeKey("InitialZoom", 2, 20282);
        InitialZoom = r102;
        CameraAttributeKey r103 = new CameraAttributeKey("Resolution", 3, 20283);
        Resolution = r103;
        CameraAttributeKey r104 = new CameraAttributeKey("EnableZoomGesture", 4, 20284);
        EnableZoomGesture = r104;
        f404693a = new CameraAttributeKey[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public CameraAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
