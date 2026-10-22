package com.larus.avatar.impl.upload.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avatar/impl/upload/adapter/DigitalAvatarUploadItemStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOADING", "SUCCESS", "UPLOAD_FAIL", "OTHER_FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarUploadItemStatus extends Enum<DigitalAvatarUploadItemStatus> {
    public static final DigitalAvatarUploadItemStatus OTHER_FAIL = null;
    public static final DigitalAvatarUploadItemStatus SUCCESS = null;
    public static final DigitalAvatarUploadItemStatus UPLOADING = null;
    public static final DigitalAvatarUploadItemStatus UPLOAD_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarUploadItemStatus[] f291285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291286b = null;

    public static EnumEntries<DigitalAvatarUploadItemStatus> getEntries() {
        return f291286b;
    }

    static {
        DigitalAvatarUploadItemStatus r100 = new DigitalAvatarUploadItemStatus("UPLOADING", 0);
        UPLOADING = r100;
        DigitalAvatarUploadItemStatus r101 = new DigitalAvatarUploadItemStatus("SUCCESS", 1);
        SUCCESS = r101;
        DigitalAvatarUploadItemStatus r102 = new DigitalAvatarUploadItemStatus("UPLOAD_FAIL", 2);
        UPLOAD_FAIL = r102;
        DigitalAvatarUploadItemStatus r103 = new DigitalAvatarUploadItemStatus("OTHER_FAIL", 3);
        OTHER_FAIL = r103;
        DigitalAvatarUploadItemStatus[] r104 = {r100, r101, r102, r103};
        f291285a = r104;
        f291286b = EnumEntriesKt.enumEntries(r104);
    }

    public static DigitalAvatarUploadItemStatus[] values() {
        return (DigitalAvatarUploadItemStatus[]) f291285a.clone();
    }

    public static DigitalAvatarUploadItemStatus valueOf(String r100) {
        return (DigitalAvatarUploadItemStatus) a.a(DigitalAvatarUploadItemStatus.class, r100);
    }

    public DigitalAvatarUploadItemStatus(String r100, int r101) {
        super(r100, r101);
    }
}
