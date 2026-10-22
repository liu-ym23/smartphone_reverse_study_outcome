package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/AuthMode;", "", "<init>", "(Ljava/lang/String;I)V", "ResourceCenterPrepareUpload", "UploadAuthToken", "ProvidedCredential", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthMode extends Enum<AuthMode> {
    public static final AuthMode ProvidedCredential = null;
    public static final AuthMode ResourceCenterPrepareUpload = null;
    public static final AuthMode UploadAuthToken = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthMode[] f314808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314809b = null;

    public static EnumEntries<AuthMode> getEntries() {
        return f314809b;
    }

    static {
        AuthMode r100 = new AuthMode("ResourceCenterPrepareUpload", 0);
        ResourceCenterPrepareUpload = r100;
        AuthMode r101 = new AuthMode("UploadAuthToken", 1);
        UploadAuthToken = r101;
        AuthMode r102 = new AuthMode("ProvidedCredential", 2);
        ProvidedCredential = r102;
        AuthMode[] r103 = {r100, r101, r102};
        f314808a = r103;
        f314809b = EnumEntriesKt.enumEntries(r103);
    }

    public static AuthMode[] values() {
        return (AuthMode[]) f314808a.clone();
    }

    public static AuthMode valueOf(String r100) {
        return (AuthMode) a.a(AuthMode.class, r100);
    }

    public AuthMode(String r100, int r101) {
        super(r100, r101);
    }
}
