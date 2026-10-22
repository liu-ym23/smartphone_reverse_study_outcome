package com.ss.android.lark.split.window.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/split/window/entity/SplitWindowState$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "FULL", "split-window_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SplitWindowState$Mode extends Enum<SplitWindowState$Mode> {
    public static final SplitWindowState$Mode FULL = null;
    public static final SplitWindowState$Mode LEFT = null;
    public static final SplitWindowState$Mode RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SplitWindowState$Mode[] f440609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440610b = null;

    public static EnumEntries<SplitWindowState$Mode> getEntries() {
        return f440610b;
    }

    static {
        SplitWindowState$Mode r100 = new SplitWindowState$Mode("LEFT", 0);
        LEFT = r100;
        SplitWindowState$Mode r101 = new SplitWindowState$Mode("RIGHT", 1);
        RIGHT = r101;
        SplitWindowState$Mode r102 = new SplitWindowState$Mode("FULL", 2);
        FULL = r102;
        SplitWindowState$Mode[] r103 = {r100, r101, r102};
        f440609a = r103;
        f440610b = EnumEntriesKt.enumEntries(r103);
    }

    public static SplitWindowState$Mode[] values() {
        return (SplitWindowState$Mode[]) f440609a.clone();
    }

    public static SplitWindowState$Mode valueOf(String r100) {
        return (SplitWindowState$Mode) a.a(SplitWindowState$Mode.class, r100);
    }

    public SplitWindowState$Mode(String r100, int r101) {
        super(r100, r101);
    }
}
