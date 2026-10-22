package com.ss.android.lark.api.bean.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/api/bean/config/ForsetiPageType;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "ALL_PAGES_SPLITSCREEN", "ALL_PAGES_FULLSCREEN", "Companion", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiPageType extends Enum<ForsetiPageType> {
    public static final ForsetiPageType ALL_PAGES_FULLSCREEN = null;
    public static final ForsetiPageType ALL_PAGES_SPLITSCREEN = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ForsetiPageType f408663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ForsetiPageType[] f408664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408665c = null;
    private final String description;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ForsetiPageType> getEntries() {
        return f408665c;
    }

    static {
        ForsetiPageType r100 = new ForsetiPageType("ALL_PAGES_SPLITSCREEN", 0, "All pages split-screen except homepage");
        ALL_PAGES_SPLITSCREEN = r100;
        ForsetiPageType r101 = new ForsetiPageType("ALL_PAGES_FULLSCREEN", 1, "All pages fullscreen except homepage");
        ALL_PAGES_FULLSCREEN = r101;
        ForsetiPageType[] r102 = {r100, r101};
        f408664b = r102;
        f408665c = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        f408663a = r100;
    }

    public static ForsetiPageType[] values() {
        return (ForsetiPageType[]) f408664b.clone();
    }

    public static final /* synthetic */ ForsetiPageType access$getDEFAULT$cp() {
        return f408663a;
    }

    public final String getDescription() {
        return this.description;
    }

    public static ForsetiPageType valueOf(String r100) {
        return (ForsetiPageType) r27.a.a(ForsetiPageType.class, r100);
    }

    public ForsetiPageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
