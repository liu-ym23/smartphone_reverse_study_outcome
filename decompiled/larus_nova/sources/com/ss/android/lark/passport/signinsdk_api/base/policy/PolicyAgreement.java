package com.ss.android.lark.passport.signinsdk_api.base.policy;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/policy/PolicyAgreement;", "", "path", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "SERVICE_TERM", "PRIVACY", "FACE_INFO", "REAL_NAME", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PolicyAgreement extends Enum<PolicyAgreement> {
    public static final PolicyAgreement FACE_INFO = null;
    public static final PolicyAgreement PRIVACY = null;
    public static final PolicyAgreement REAL_NAME = null;
    public static final PolicyAgreement SERVICE_TERM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PolicyAgreement[] f438056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438057b = null;
    private final String path;

    public static EnumEntries<PolicyAgreement> getEntries() {
        return f438057b;
    }

    static {
        PolicyAgreement r100 = new PolicyAgreement("SERVICE_TERM", 0, "terms");
        SERVICE_TERM = r100;
        PolicyAgreement r101 = new PolicyAgreement("PRIVACY", 1, "privacy");
        PRIVACY = r101;
        PolicyAgreement r102 = new PolicyAgreement("FACE_INFO", 2, "face-id");
        FACE_INFO = r102;
        PolicyAgreement r103 = new PolicyAgreement("REAL_NAME", 3, DownloadHelper.IDENTITY);
        REAL_NAME = r103;
        PolicyAgreement[] r104 = {r100, r101, r102, r103};
        f438056a = r104;
        f438057b = EnumEntriesKt.enumEntries(r104);
    }

    public static PolicyAgreement[] values() {
        return (PolicyAgreement[]) f438056a.clone();
    }

    public final String getPath() {
        return this.path;
    }

    public static PolicyAgreement valueOf(String r100) {
        return (PolicyAgreement) a.a(PolicyAgreement.class, r100);
    }

    public PolicyAgreement(String r100, int r101, String r102) {
        super(r100, r101);
        this.path = r102;
    }
}
