package com.larus.avatar.impl.upload.viewmodel;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avatar/impl/upload/viewmodel/CreateAvatarStatus;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "LOADING", "SUCCESS", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateAvatarStatus extends Enum<CreateAvatarStatus> {
    public static final CreateAvatarStatus FAIL = null;
    public static final CreateAvatarStatus INIT = null;
    public static final CreateAvatarStatus LOADING = null;
    public static final CreateAvatarStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateAvatarStatus[] f291327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291328b = null;

    public static EnumEntries<CreateAvatarStatus> getEntries() {
        return f291328b;
    }

    static {
        CreateAvatarStatus r100 = new CreateAvatarStatus(ErrorCode.INIT, 0);
        INIT = r100;
        CreateAvatarStatus r101 = new CreateAvatarStatus("LOADING", 1);
        LOADING = r101;
        CreateAvatarStatus r102 = new CreateAvatarStatus("SUCCESS", 2);
        SUCCESS = r102;
        CreateAvatarStatus r103 = new CreateAvatarStatus("FAIL", 3);
        FAIL = r103;
        CreateAvatarStatus[] r104 = {r100, r101, r102, r103};
        f291327a = r104;
        f291328b = EnumEntriesKt.enumEntries(r104);
    }

    public static CreateAvatarStatus[] values() {
        return (CreateAvatarStatus[]) f291327a.clone();
    }

    public static CreateAvatarStatus valueOf(String r100) {
        return (CreateAvatarStatus) r27.a.a(CreateAvatarStatus.class, r100);
    }

    public CreateAvatarStatus(String r100, int r101) {
        super(r100, r101);
    }
}
