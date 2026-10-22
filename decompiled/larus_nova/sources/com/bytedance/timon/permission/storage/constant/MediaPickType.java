package com.bytedance.timon.permission.storage.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/timon/permission/storage/constant/MediaPickType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "TYPE_IMAGE", "TYPE_VIDEO", "TYPE_AUDIO", "TYPE_IMAGE_AND_VIDEO", "TYPE_ALL", "permission-keeper-storage_release"}, k = 1, mv = {1, 7, 1})
public final enum MediaPickType extends Enum<MediaPickType> {
    public static final MediaPickType TYPE_ALL = null;
    public static final MediaPickType TYPE_AUDIO = null;
    public static final MediaPickType TYPE_IMAGE = null;
    public static final MediaPickType TYPE_IMAGE_AND_VIDEO = null;
    public static final MediaPickType TYPE_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaPickType[] f270652a = null;
    private final String value;

    public static MediaPickType valueOf(String r100) {
        return (MediaPickType) a.a(MediaPickType.class, r100);
    }

    public static MediaPickType[] values() {
        return (MediaPickType[]) f270652a.clone();
    }

    static {
        MediaPickType r100 = new MediaPickType("TYPE_IMAGE", 0, "image/*");
        TYPE_IMAGE = r100;
        MediaPickType r101 = new MediaPickType("TYPE_VIDEO", 1, "video/*");
        TYPE_VIDEO = r101;
        MediaPickType r102 = new MediaPickType("TYPE_AUDIO", 2, "audio/*");
        TYPE_AUDIO = r102;
        MediaPickType r103 = new MediaPickType("TYPE_IMAGE_AND_VIDEO", 3, "image/* video/*");
        TYPE_IMAGE_AND_VIDEO = r103;
        MediaPickType r104 = new MediaPickType("TYPE_ALL", 4, "*/*");
        TYPE_ALL = r104;
        f270652a = new MediaPickType[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public MediaPickType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
