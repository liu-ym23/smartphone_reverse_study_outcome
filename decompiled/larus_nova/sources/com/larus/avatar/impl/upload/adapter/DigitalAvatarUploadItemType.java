package com.larus.avatar.impl.upload.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avatar/impl/upload/adapter/DigitalAvatarUploadItemType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_IMAGE", "IMAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarUploadItemType extends Enum<DigitalAvatarUploadItemType> {
    public static final DigitalAvatarUploadItemType ADD_IMAGE = null;
    public static final DigitalAvatarUploadItemType IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarUploadItemType[] f291287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291288b = null;

    public static EnumEntries<DigitalAvatarUploadItemType> getEntries() {
        return f291288b;
    }

    static {
        DigitalAvatarUploadItemType r100 = new DigitalAvatarUploadItemType("ADD_IMAGE", 0);
        ADD_IMAGE = r100;
        DigitalAvatarUploadItemType r101 = new DigitalAvatarUploadItemType("IMAGE", 1);
        IMAGE = r101;
        DigitalAvatarUploadItemType[] r102 = {r100, r101};
        f291287a = r102;
        f291288b = EnumEntriesKt.enumEntries(r102);
    }

    public static DigitalAvatarUploadItemType[] values() {
        return (DigitalAvatarUploadItemType[]) f291287a.clone();
    }

    public static DigitalAvatarUploadItemType valueOf(String r100) {
        return (DigitalAvatarUploadItemType) a.a(DigitalAvatarUploadItemType.class, r100);
    }

    public DigitalAvatarUploadItemType(String r100, int r101) {
        super(r100, r101);
    }
}
