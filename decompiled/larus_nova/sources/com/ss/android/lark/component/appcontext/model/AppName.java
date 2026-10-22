package com.ss.android.lark.component.appcontext.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/AppName;", "", "rawName", "", "lowerCaseName", "camelCaseName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRawName", "()Ljava/lang/String;", "getLowerCaseName", "getCamelCaseName", "Lark", "Mempope", "OfficeSDK", "isLark", "", "isMempope", "isOfficeSDK", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppName extends Enum<AppName> {
    public static final AppName Lark = null;
    public static final AppName Mempope = null;
    public static final AppName OfficeSDK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppName[] f417276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417277b = null;
    private final String camelCaseName;
    private final String lowerCaseName;
    private final String rawName;

    public static EnumEntries<AppName> getEntries() {
        return f417277b;
    }

    static {
        AppName r100 = new AppName("Lark", 0, "Lark", "lark", "Lark");
        Lark = r100;
        AppName r101 = new AppName("Mempope", 1, "Mempope", "mempope", "MemPope");
        Mempope = r101;
        AppName r102 = new AppName("OfficeSDK", 2, "OfficeSDK", "officesdk", "OfficeSDK");
        OfficeSDK = r102;
        AppName[] r103 = {r100, r101, r102};
        f417276a = r103;
        f417277b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppName[] values() {
        return (AppName[]) f417276a.clone();
    }

    public final boolean isLark() {
        if (this != Lark) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMempope() {
        if (this != Mempope) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOfficeSDK() {
        if (this != OfficeSDK) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getCamelCaseName() {
        return this.camelCaseName;
    }

    public final String getLowerCaseName() {
        return this.lowerCaseName;
    }

    public final String getRawName() {
        return this.rawName;
    }

    public static AppName valueOf(String r100) {
        return (AppName) a.a(AppName.class, r100);
    }

    public AppName(String r100, int r101, String r102, String r103, String r104) {
        super(r100, r101);
        this.rawName = r102;
        this.lowerCaseName = r103;
        this.camelCaseName = r104;
    }
}
