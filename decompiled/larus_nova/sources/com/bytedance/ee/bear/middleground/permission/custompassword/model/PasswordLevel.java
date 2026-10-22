package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PasswordLevel;", "", "<init>", "(Ljava/lang/String;I)V", "STRONG", "MIDDLE", "WEAK", "NO", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PasswordLevel extends Enum<PasswordLevel> {
    public static final PasswordLevel MIDDLE = null;
    public static final PasswordLevel NO = null;
    public static final PasswordLevel STRONG = null;
    public static final PasswordLevel WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PasswordLevel[] f233822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233823b = null;

    public static EnumEntries<PasswordLevel> getEntries() {
        return f233823b;
    }

    static {
        PasswordLevel r100 = new PasswordLevel("STRONG", 0);
        STRONG = r100;
        PasswordLevel r101 = new PasswordLevel("MIDDLE", 1);
        MIDDLE = r101;
        PasswordLevel r102 = new PasswordLevel("WEAK", 2);
        WEAK = r102;
        PasswordLevel r103 = new PasswordLevel("NO", 3);
        NO = r103;
        PasswordLevel[] r104 = {r100, r101, r102, r103};
        f233822a = r104;
        f233823b = EnumEntriesKt.enumEntries(r104);
    }

    public static PasswordLevel[] values() {
        return (PasswordLevel[]) f233822a.clone();
    }

    public static PasswordLevel valueOf(String r100) {
        return (PasswordLevel) a.a(PasswordLevel.class, r100);
    }

    public PasswordLevel(String r100, int r101) {
        super(r100, r101);
    }
}
