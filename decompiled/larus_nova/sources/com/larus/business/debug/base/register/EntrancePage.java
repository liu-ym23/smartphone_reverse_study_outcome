package com.larus.business.debug.base.register;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/register/EntrancePage;", "", "index", "", "des", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getIndex", "()I", "getDes", "()Ljava/lang/String;", AccountType.ALL, "RECENTLY", "FAVORITE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntrancePage extends Enum<EntrancePage> {
    public static final EntrancePage ALL = null;
    public static final EntrancePage FAVORITE = null;
    public static final EntrancePage RECENTLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntrancePage[] f320066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320067b = null;
    private final String des;
    private final int index;

    public static EnumEntries<EntrancePage> getEntries() {
        return f320067b;
    }

    static {
        EntrancePage r100 = new EntrancePage(AccountType.ALL, 0, 0, "全部");
        ALL = r100;
        EntrancePage r101 = new EntrancePage("RECENTLY", 1, 1, "最近使用");
        RECENTLY = r101;
        EntrancePage r102 = new EntrancePage("FAVORITE", 2, 2, "收藏夹");
        FAVORITE = r102;
        EntrancePage[] r103 = {r100, r101, r102};
        f320066a = r103;
        f320067b = EnumEntriesKt.enumEntries(r103);
    }

    public static EntrancePage[] values() {
        return (EntrancePage[]) f320066a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getIndex() {
        return this.index;
    }

    public static EntrancePage valueOf(String r100) {
        return (EntrancePage) a.a(EntrancePage.class, r100);
    }

    public EntrancePage(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.index = r102;
        this.des = r103;
    }

    public /* synthetic */ EntrancePage(String r100, int r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "";
    L5:
        this(r100, r101, r102, r103);
    }
}
