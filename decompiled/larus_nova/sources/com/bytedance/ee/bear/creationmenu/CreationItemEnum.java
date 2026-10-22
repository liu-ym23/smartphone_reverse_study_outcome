package com.bytedance.ee.bear.creationmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationItemEnum;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "NEW_DOC", "UPLOAD", "TEMPLATE", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationItemEnum extends Enum<CreationItemEnum> {
    public static final CreationItemEnum NEW_DOC = null;
    public static final CreationItemEnum TEMPLATE = null;
    public static final CreationItemEnum UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationItemEnum[] f217263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f217264b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f217265id;

    public static EnumEntries<CreationItemEnum> getEntries() {
        return f217264b;
    }

    static {
        CreationItemEnum r100 = new CreationItemEnum("NEW_DOC", 0, 1);
        NEW_DOC = r100;
        CreationItemEnum r101 = new CreationItemEnum("UPLOAD", 1, 2);
        UPLOAD = r101;
        CreationItemEnum r102 = new CreationItemEnum("TEMPLATE", 2, 3);
        TEMPLATE = r102;
        CreationItemEnum[] r103 = {r100, r101, r102};
        f217263a = r103;
        f217264b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationItemEnum[] values() {
        return (CreationItemEnum[]) f217263a.clone();
    }

    public final int getId() {
        return this.f217265id;
    }

    public static CreationItemEnum valueOf(String r100) {
        return (CreationItemEnum) r27.a.a(CreationItemEnum.class, r100);
    }

    public CreationItemEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.f217265id = r102;
    }
}
