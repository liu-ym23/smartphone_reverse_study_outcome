package com.larus.bmhome.chat.markdown.reference;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/Stage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Searching", "Searched", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Stage extends Enum<Stage> {
    public static final Stage Searched = null;
    public static final Stage Searching = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Stage[] f307152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307153b = null;
    private final int value;

    public static EnumEntries<Stage> getEntries() {
        return f307153b;
    }

    static {
        Stage r100 = new Stage("Searching", 0, 1);
        Searching = r100;
        Stage r101 = new Stage("Searched", 1, 2);
        Searched = r101;
        Stage[] r102 = {r100, r101};
        f307152a = r102;
        f307153b = EnumEntriesKt.enumEntries(r102);
    }

    public static Stage[] values() {
        return (Stage[]) f307152a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Stage valueOf(String r100) {
        return (Stage) r27.a.a(Stage.class, r100);
    }

    public Stage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
