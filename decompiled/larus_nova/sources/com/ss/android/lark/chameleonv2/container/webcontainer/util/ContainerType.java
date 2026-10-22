package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/ContainerType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Full", "Left", "Right", "Top", "Bottom", "Web", "Title", "NestScrollTitle", "Root", "Content", "BusinessOverlay", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType Bottom = null;
    public static final ContainerType BusinessOverlay = null;
    public static final ContainerType Content = null;
    public static final ContainerType Full = null;
    public static final ContainerType Left = null;
    public static final ContainerType NestScrollTitle = null;
    public static final ContainerType Right = null;
    public static final ContainerType Root = null;
    public static final ContainerType Title = null;
    public static final ContainerType Top = null;
    public static final ContainerType Web = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f411283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411284b = null;
    private final int value;

    public static EnumEntries<ContainerType> getEntries() {
        return f411284b;
    }

    static {
        ContainerType r100 = new ContainerType("Full", 0, 0);
        Full = r100;
        ContainerType r101 = new ContainerType("Left", 1, 1);
        Left = r101;
        ContainerType r102 = new ContainerType("Right", 2, 2);
        Right = r102;
        ContainerType r103 = new ContainerType("Top", 3, 3);
        Top = r103;
        ContainerType r104 = new ContainerType("Bottom", 4, 4);
        Bottom = r104;
        ContainerType r105 = new ContainerType("Web", 5, 5);
        Web = r105;
        ContainerType r110 = new ContainerType("Title", 6, 6);
        Title = r110;
        ContainerType r111 = new ContainerType("NestScrollTitle", 7, 7);
        NestScrollTitle = r111;
        ContainerType r112 = new ContainerType("Root", 8, 8);
        Root = r112;
        ContainerType r113 = new ContainerType("Content", 9, 9);
        Content = r113;
        ContainerType r114 = new ContainerType("BusinessOverlay", 10, 10);
        BusinessOverlay = r114;
        ContainerType[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f411283a = r115;
        f411284b = EnumEntriesKt.enumEntries(r115);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f411283a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) r27.a.a(ContainerType.class, r100);
    }

    public ContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
