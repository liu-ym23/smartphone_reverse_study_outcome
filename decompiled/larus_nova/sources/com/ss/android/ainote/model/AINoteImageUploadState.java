package com.ss.android.ainote.model;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ainote/model/AINoteImageUploadState;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "QUEUED", "UPLOADING", "UPLOADED", "FAILED_RETRYABLE", "FAILED_FATAL", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteImageUploadState extends Enum<AINoteImageUploadState> {
    public static final AINoteImageUploadState FAILED_FATAL = null;
    public static final AINoteImageUploadState FAILED_RETRYABLE = null;
    public static final AINoteImageUploadState LOCAL = null;
    public static final AINoteImageUploadState QUEUED = null;
    public static final AINoteImageUploadState UPLOADED = null;
    public static final AINoteImageUploadState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteImageUploadState[] f407139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407140b = null;

    public static EnumEntries<AINoteImageUploadState> getEntries() {
        return f407140b;
    }

    static {
        AINoteImageUploadState r100 = new AINoteImageUploadState(AccountType.LOCAL, 0);
        LOCAL = r100;
        AINoteImageUploadState r101 = new AINoteImageUploadState("QUEUED", 1);
        QUEUED = r101;
        AINoteImageUploadState r102 = new AINoteImageUploadState("UPLOADING", 2);
        UPLOADING = r102;
        AINoteImageUploadState r103 = new AINoteImageUploadState("UPLOADED", 3);
        UPLOADED = r103;
        AINoteImageUploadState r104 = new AINoteImageUploadState("FAILED_RETRYABLE", 4);
        FAILED_RETRYABLE = r104;
        AINoteImageUploadState r105 = new AINoteImageUploadState("FAILED_FATAL", 5);
        FAILED_FATAL = r105;
        AINoteImageUploadState[] r110 = {r100, r101, r102, r103, r104, r105};
        f407139a = r110;
        f407140b = EnumEntriesKt.enumEntries(r110);
    }

    public static AINoteImageUploadState[] values() {
        return (AINoteImageUploadState[]) f407139a.clone();
    }

    public static AINoteImageUploadState valueOf(String r100) {
        return (AINoteImageUploadState) a.a(AINoteImageUploadState.class, r100);
    }

    public AINoteImageUploadState(String r100, int r101) {
        super(r100, r101);
    }
}
