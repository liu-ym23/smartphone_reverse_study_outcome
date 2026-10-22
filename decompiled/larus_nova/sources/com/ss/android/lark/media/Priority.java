package com.ss.android.lark.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/media/Priority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Low", "Default", "Medium", "High", "Companion", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Priority extends Enum<Priority> {
    public static final a Companion = null;
    public static final Priority Default = null;
    public static final Priority High = null;
    public static final Priority Low = null;
    public static final Priority Medium = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f431652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431653b = null;
    private final int value;

    public static EnumEntries<Priority> getEntries() {
        return f431653b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.media.Priority$a] */
    static {
        Priority r100 = new Priority("Low", 0, 0);
        Low = r100;
        Priority r101 = new Priority("Default", 1, 1);
        Default = r101;
        Priority r102 = new Priority("Medium", 2, 2);
        Medium = r102;
        Priority r103 = new Priority("High", 3, 3);
        High = r103;
        Priority[] r104 = {r100, r101, r102, r103};
        f431652a = r104;
        f431653b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static Priority[] values() {
        return (Priority[]) f431652a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Priority valueOf(String r100) {
        return (Priority) r27.a.a(Priority.class, r100);
    }

    public Priority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
