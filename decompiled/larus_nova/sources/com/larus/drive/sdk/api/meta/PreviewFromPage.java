package com.larus.drive.sdk.api.meta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/drive/sdk/api/meta/PreviewFromPage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECENT", "MINE", "PICKER", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewFromPage extends Enum<PreviewFromPage> {
    public static final PreviewFromPage MINE = null;
    public static final PreviewFromPage PICKER = null;
    public static final PreviewFromPage RECENT = null;
    public static final PreviewFromPage UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewFromPage[] f341591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341592b = null;
    private final String value;

    public static EnumEntries<PreviewFromPage> getEntries() {
        return f341592b;
    }

    static {
        PreviewFromPage r100 = new PreviewFromPage("RECENT", 0, "recent");
        RECENT = r100;
        PreviewFromPage r101 = new PreviewFromPage("MINE", 1, "mine");
        MINE = r101;
        PreviewFromPage r102 = new PreviewFromPage("PICKER", 2, "picker");
        PICKER = r102;
        PreviewFromPage r103 = new PreviewFromPage("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        PreviewFromPage[] r104 = {r100, r101, r102, r103};
        f341591a = r104;
        f341592b = EnumEntriesKt.enumEntries(r104);
    }

    public static PreviewFromPage[] values() {
        return (PreviewFromPage[]) f341591a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PreviewFromPage valueOf(String r100) {
        return (PreviewFromPage) a.a(PreviewFromPage.class, r100);
    }

    public PreviewFromPage(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
