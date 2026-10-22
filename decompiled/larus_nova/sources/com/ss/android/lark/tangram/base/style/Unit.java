package com.ss.android.lark.tangram.base.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/tangram/base/style/Unit;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "AUTO", "PIXCEL", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Unit extends Enum<Unit> {
    public static final Unit AUTO = null;
    public static final Unit PIXCEL = null;
    public static final Unit UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Unit[] f441165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441166b = null;
    private final int value;

    public static EnumEntries getEntries() {
        return f441166b;
    }

    static {
        Unit r100 = new Unit("UNDEFINED", 0, 17);
        UNDEFINED = r100;
        Unit r101 = new Unit("AUTO", 1, 18);
        AUTO = r101;
        Unit r102 = new Unit("PIXCEL", 2, 19);
        PIXCEL = r102;
        Unit[] r103 = {r100, r101, r102};
        f441165a = r103;
        f441166b = EnumEntriesKt.enumEntries(r103);
    }

    public static Unit[] values() {
        return (Unit[]) f441165a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Unit valueOf(String r100) {
        return (Unit) a.a(Unit.class, r100);
    }

    public Unit(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
