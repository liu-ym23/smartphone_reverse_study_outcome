package com.larus.office.plugins.slides.orientation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/office/plugins/slides/orientation/TitleBarStates;", "", "states", "", "<init>", "(Ljava/lang/String;II)V", "getStates", "()I", "VISIBLE", "GONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarStates extends Enum<TitleBarStates> {
    public static final TitleBarStates GONE = null;
    public static final TitleBarStates VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarStates[] f363453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363454b = null;
    private final int states;

    public static EnumEntries<TitleBarStates> getEntries() {
        return f363454b;
    }

    static {
        TitleBarStates r100 = new TitleBarStates("VISIBLE", 0, 1);
        VISIBLE = r100;
        TitleBarStates r101 = new TitleBarStates("GONE", 1, 0);
        GONE = r101;
        TitleBarStates[] r102 = {r100, r101};
        f363453a = r102;
        f363454b = EnumEntriesKt.enumEntries(r102);
    }

    public static TitleBarStates[] values() {
        return (TitleBarStates[]) f363453a.clone();
    }

    public final int getStates() {
        return this.states;
    }

    public static TitleBarStates valueOf(String r100) {
        return (TitleBarStates) r27.a.a(TitleBarStates.class, r100);
    }

    public TitleBarStates(String r100, int r101, int r102) {
        super(r100, r101);
        this.states = r102;
    }
}
