package com.ss.android.lark.passport.signinsdk_api.contants;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/LogoutSource;", "", "value", "", "des", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDes", "()Ljava/lang/String;", "SETTING", "EXTERNAL", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogoutSource extends Enum<LogoutSource> {
    public static final a Companion = null;
    public static final LogoutSource EXTERNAL = null;
    public static final LogoutSource SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<LogoutSource[]> f438064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<LogoutSource> f438065b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LogoutSource[] f438066c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438067d = null;
    private final String des;
    private final int value;

    public static EnumEntries<LogoutSource> getEntries() {
        return f438067d;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.ss.android.lark.passport.signinsdk_api.contants.LogoutSource$a] */
    static {
        LogoutSource r100 = new LogoutSource("SETTING", 0, 1, "from setting");
        SETTING = r100;
        LogoutSource r101 = new LogoutSource("EXTERNAL", 1, 2, "from external");
        EXTERNAL = r101;
        LogoutSource[] r102 = {r100, r101};
        f438066c = r102;
        f438067d = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        f438064a = LazyKt.lazy(LogoutSource$Companion$values$2.INSTANCE);
        f438065b = CollectionsKt.listOf(new LogoutSource[]{r100, r101});
    }

    public static LogoutSource[] values() {
        return (LogoutSource[]) f438066c.clone();
    }

    public static final /* synthetic */ List access$getActiveLogoutSource$cp() {
        return f438065b;
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return f438064a;
    }

    public final String getDes() {
        return this.des;
    }

    public final int getValue() {
        return this.value;
    }

    public static LogoutSource valueOf(String r100) {
        return (LogoutSource) r27.a.a(LogoutSource.class, r100);
    }

    public LogoutSource(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.des = r103;
    }
}
