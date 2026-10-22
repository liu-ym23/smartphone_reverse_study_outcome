package com.ss.android.lark.time.format.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/time/format/entity/DisplayPattern;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "ABSOLUTE", "RELATIVE", "Companion", "time-format_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DisplayPattern extends Enum<DisplayPattern> {
    public static final DisplayPattern ABSOLUTE = null;
    public static final a Companion = null;
    public static final DisplayPattern RELATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayPattern[] f441330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441331b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DisplayPattern> getEntries() {
        return f441331b;
    }

    static {
        DisplayPattern r100 = new DisplayPattern("ABSOLUTE", 0, 0);
        ABSOLUTE = r100;
        DisplayPattern r101 = new DisplayPattern("RELATIVE", 1, 1);
        RELATIVE = r101;
        DisplayPattern[] r102 = {r100, r101};
        f441330a = r102;
        f441331b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static DisplayPattern[] values() {
        return (DisplayPattern[]) f441330a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final DisplayPattern forNumber(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return ABSOLUTE;
    L11:
        return RELATIVE;
    L9:
        return ABSOLUTE;
    }

    @JvmStatic
    public static final DisplayPattern valueOf(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return ABSOLUTE;
    L11:
        return RELATIVE;
    L9:
        return ABSOLUTE;
    }

    public static DisplayPattern valueOf(String r100) {
        return (DisplayPattern) r27.a.a(DisplayPattern.class, r100);
    }

    public DisplayPattern(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
