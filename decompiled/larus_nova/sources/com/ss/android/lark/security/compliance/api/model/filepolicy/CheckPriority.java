package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CheckPriority;", "", "<init>", "(Ljava/lang/String;I)V", "CacheFirst", "RemoteFirst", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CheckPriority extends Enum<CheckPriority> {
    public static final CheckPriority CacheFirst = null;
    public static final CheckPriority RemoteFirst = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckPriority[] f440392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440393b = null;

    public static EnumEntries<CheckPriority> getEntries() {
        return f440393b;
    }

    static {
        CheckPriority r100 = new CheckPriority("CacheFirst", 0);
        CacheFirst = r100;
        CheckPriority r101 = new CheckPriority("RemoteFirst", 1);
        RemoteFirst = r101;
        CheckPriority[] r102 = {r100, r101};
        f440392a = r102;
        f440393b = EnumEntriesKt.enumEntries(r102);
    }

    public static CheckPriority[] values() {
        return (CheckPriority[]) f440392a.clone();
    }

    public static CheckPriority valueOf(String r100) {
        return (CheckPriority) r27.a.a(CheckPriority.class, r100);
    }

    public CheckPriority(String r100, int r101) {
        super(r100, r101);
    }
}
