package com.bytedance.ee.bear.bitable.celleditor.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMenuType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Menu", "BottomSheet", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditorMenuType extends Enum<EditorMenuType> {
    public static final EditorMenuType BottomSheet = null;
    public static final EditorMenuType Menu = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditorMenuType[] f209316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209317b = null;
    private final int value;

    public static EnumEntries<EditorMenuType> getEntries() {
        return f209317b;
    }

    static {
        EditorMenuType r100 = new EditorMenuType("Menu", 0, 1);
        Menu = r100;
        EditorMenuType r101 = new EditorMenuType("BottomSheet", 1, 2);
        BottomSheet = r101;
        EditorMenuType[] r102 = {r100, r101};
        f209316a = r102;
        f209317b = EnumEntriesKt.enumEntries(r102);
    }

    public static EditorMenuType[] values() {
        return (EditorMenuType[]) f209316a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EditorMenuType valueOf(String r100) {
        return (EditorMenuType) a.a(EditorMenuType.class, r100);
    }

    public EditorMenuType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
