package com.larus.home.impl.main.side_bar.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SidebarHasAvatar;", "", "value", "", "<init>", "(Ljava/lang/String;IZ)V", "getValue", "()Z", "V2", "V3", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidebarHasAvatar extends Enum<SidebarHasAvatar> {
    public static final SidebarHasAvatar V2 = null;
    public static final SidebarHasAvatar V3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SidebarHasAvatar[] f344850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344851b = null;
    private final boolean value;

    public static EnumEntries<SidebarHasAvatar> getEntries() {
        return f344851b;
    }

    static {
        SidebarHasAvatar r100 = new SidebarHasAvatar("V2", 0, true);
        V2 = r100;
        SidebarHasAvatar r101 = new SidebarHasAvatar("V3", 1, false);
        V3 = r101;
        SidebarHasAvatar[] r102 = {r100, r101};
        f344850a = r102;
        f344851b = EnumEntriesKt.enumEntries(r102);
    }

    public static SidebarHasAvatar[] values() {
        return (SidebarHasAvatar[]) f344850a.clone();
    }

    public final boolean getValue() {
        return this.value;
    }

    public static SidebarHasAvatar valueOf(String r100) {
        return (SidebarHasAvatar) r27.a.a(SidebarHasAvatar.class, r100);
    }

    public SidebarHasAvatar(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.value = r102;
    }
}
