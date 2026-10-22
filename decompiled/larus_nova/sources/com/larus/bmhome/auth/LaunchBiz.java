package com.larus.bmhome.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/auth/LaunchBiz;", "", "<init>", "(Ljava/lang/String;I)V", "CORE", "BASIC", "IM", "AUDIO", "FULL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LaunchBiz extends Enum<LaunchBiz> {
    public static final LaunchBiz AUDIO = null;
    public static final LaunchBiz BASIC = null;
    public static final LaunchBiz CORE = null;
    public static final LaunchBiz FULL = null;
    public static final LaunchBiz IM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchBiz[] f295724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f295725b = null;

    public static EnumEntries<LaunchBiz> getEntries() {
        return f295725b;
    }

    static {
        LaunchBiz r100 = new LaunchBiz("CORE", 0);
        CORE = r100;
        LaunchBiz r101 = new LaunchBiz("BASIC", 1);
        BASIC = r101;
        LaunchBiz r102 = new LaunchBiz("IM", 2);
        IM = r102;
        LaunchBiz r103 = new LaunchBiz("AUDIO", 3);
        AUDIO = r103;
        LaunchBiz r104 = new LaunchBiz("FULL", 4);
        FULL = r104;
        LaunchBiz[] r105 = {r100, r101, r102, r103, r104};
        f295724a = r105;
        f295725b = EnumEntriesKt.enumEntries(r105);
    }

    public static LaunchBiz[] values() {
        return (LaunchBiz[]) f295724a.clone();
    }

    public static LaunchBiz valueOf(String r100) {
        return (LaunchBiz) r27.a.a(LaunchBiz.class, r100);
    }

    public LaunchBiz(String r100, int r101) {
        super(r100, r101);
    }
}
