package com.bytedance.ee.bear.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/workspace/NewBaseEntry;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Homepage", "TemplateCenter", "CreateCopy", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NewBaseEntry extends Enum<NewBaseEntry> {
    public static final NewBaseEntry CreateCopy = null;
    public static final NewBaseEntry Homepage = null;
    public static final NewBaseEntry TemplateCenter = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NewBaseEntry[] f242619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242620b = null;
    private final String value;

    public static EnumEntries<NewBaseEntry> getEntries() {
        return f242620b;
    }

    static {
        NewBaseEntry r100 = new NewBaseEntry("Homepage", 0, "homepage");
        Homepage = r100;
        NewBaseEntry r101 = new NewBaseEntry("TemplateCenter", 1, "template_center");
        TemplateCenter = r101;
        NewBaseEntry r102 = new NewBaseEntry("CreateCopy", 2, "create_copy");
        CreateCopy = r102;
        NewBaseEntry[] r103 = {r100, r101, r102};
        f242619a = r103;
        f242620b = EnumEntriesKt.enumEntries(r103);
    }

    public static NewBaseEntry[] values() {
        return (NewBaseEntry[]) f242619a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NewBaseEntry valueOf(String r100) {
        return (NewBaseEntry) a.a(NewBaseEntry.class, r100);
    }

    public NewBaseEntry(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
