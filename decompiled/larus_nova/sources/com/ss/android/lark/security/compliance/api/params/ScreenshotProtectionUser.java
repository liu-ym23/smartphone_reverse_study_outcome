package com.ss.android.lark.security.compliance.api.params;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/params/ScreenshotProtectionUser;", "", "<init>", "(Ljava/lang/String;I)V", "IM", "CCM", "Calendar", "VC", "Mail", "OpenPlatform", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScreenshotProtectionUser extends Enum<ScreenshotProtectionUser> {
    public static final ScreenshotProtectionUser CCM = null;
    public static final ScreenshotProtectionUser Calendar = null;
    public static final ScreenshotProtectionUser IM = null;
    public static final ScreenshotProtectionUser Mail = null;
    public static final ScreenshotProtectionUser OpenPlatform = null;
    public static final ScreenshotProtectionUser VC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenshotProtectionUser[] f440418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440419b = null;

    public static EnumEntries<ScreenshotProtectionUser> getEntries() {
        return f440419b;
    }

    static {
        ScreenshotProtectionUser r100 = new ScreenshotProtectionUser("IM", 0);
        IM = r100;
        ScreenshotProtectionUser r101 = new ScreenshotProtectionUser("CCM", 1);
        CCM = r101;
        ScreenshotProtectionUser r102 = new ScreenshotProtectionUser("Calendar", 2);
        Calendar = r102;
        ScreenshotProtectionUser r103 = new ScreenshotProtectionUser("VC", 3);
        VC = r103;
        ScreenshotProtectionUser r104 = new ScreenshotProtectionUser("Mail", 4);
        Mail = r104;
        ScreenshotProtectionUser r105 = new ScreenshotProtectionUser("OpenPlatform", 5);
        OpenPlatform = r105;
        ScreenshotProtectionUser[] r110 = {r100, r101, r102, r103, r104, r105};
        f440418a = r110;
        f440419b = EnumEntriesKt.enumEntries(r110);
    }

    public static ScreenshotProtectionUser[] values() {
        return (ScreenshotProtectionUser[]) f440418a.clone();
    }

    public static ScreenshotProtectionUser valueOf(String r100) {
        return (ScreenshotProtectionUser) a.a(ScreenshotProtectionUser.class, r100);
    }

    public ScreenshotProtectionUser(String r100, int r101) {
        super(r100, r101);
    }
}
