package com.larksuite.component.ui.tag;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/ui/tag/DrawableStateSet;", "", "stateSet", "", "<init>", "(Ljava/lang/String;I[I)V", "getStateSet", "()[I", "EMPTY", "SELECTED", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrawableStateSet extends Enum<DrawableStateSet> {
    public static final DrawableStateSet EMPTY = null;
    public static final DrawableStateSet SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrawableStateSet[] f284331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284332b = null;
    private final int[] stateSet;

    public static EnumEntries<DrawableStateSet> getEntries() {
        return f284332b;
    }

    static {
        DrawableStateSet r100 = new DrawableStateSet("EMPTY", 0, g.f284472a);
        EMPTY = r100;
        DrawableStateSet r101 = new DrawableStateSet("SELECTED", 1, g.f284473b);
        SELECTED = r101;
        DrawableStateSet[] r102 = {r100, r101};
        f284331a = r102;
        f284332b = EnumEntriesKt.enumEntries(r102);
    }

    public static DrawableStateSet[] values() {
        return (DrawableStateSet[]) f284331a.clone();
    }

    public final int[] getStateSet() {
        return this.stateSet;
    }

    public static DrawableStateSet valueOf(String r100) {
        return (DrawableStateSet) r27.a.a(DrawableStateSet.class, r100);
    }

    public DrawableStateSet(String r100, int r101, int[] r102) {
        super(r100, r101);
        this.stateSet = r102;
    }
}
