package com.relax.relaxreact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/relax/relaxreact/GestureTypeInner;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Composed", "Pan", "Fling", "Default", "Tap", "Longpress", "Rotation", "Pinch", "Native", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum GestureTypeInner extends Enum<GestureTypeInner> {
    public static final GestureTypeInner Composed = null;
    public static final GestureTypeInner Default = null;
    public static final GestureTypeInner Fling = null;
    public static final GestureTypeInner Longpress = null;
    public static final GestureTypeInner Native = null;
    public static final GestureTypeInner Pan = null;
    public static final GestureTypeInner Pinch = null;
    public static final GestureTypeInner Rotation = null;
    public static final GestureTypeInner Tap = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureTypeInner[] f405409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405410b = null;
    private final int value;

    public static EnumEntries<GestureTypeInner> getEntries() {
        return f405410b;
    }

    public static GestureTypeInner valueOf(String r100) {
        return (GestureTypeInner) r27.a.a(GestureTypeInner.class, r100);
    }

    public static GestureTypeInner[] values() {
        return (GestureTypeInner[]) f405409a.clone();
    }

    static {
        GestureTypeInner r100 = new GestureTypeInner("Composed", 0, -1);
        Composed = r100;
        GestureTypeInner r101 = new GestureTypeInner("Pan", 1, 0);
        Pan = r101;
        GestureTypeInner r102 = new GestureTypeInner("Fling", 2, 1);
        Fling = r102;
        GestureTypeInner r103 = new GestureTypeInner("Default", 3, 2);
        Default = r103;
        GestureTypeInner r104 = new GestureTypeInner("Tap", 4, 3);
        Tap = r104;
        GestureTypeInner r105 = new GestureTypeInner("Longpress", 5, 4);
        Longpress = r105;
        GestureTypeInner r110 = new GestureTypeInner("Rotation", 6, 5);
        Rotation = r110;
        GestureTypeInner r111 = new GestureTypeInner("Pinch", 7, 6);
        Pinch = r111;
        GestureTypeInner r112 = new GestureTypeInner("Native", 8, 7);
        Native = r112;
        GestureTypeInner[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f405409a = r113;
        f405410b = EnumEntriesKt.enumEntries(r113);
    }

    public final int getValue() {
        return this.value;
    }

    public GestureTypeInner(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
