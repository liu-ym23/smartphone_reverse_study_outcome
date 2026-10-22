package com.ss.android.lark.keyboard.ime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "", "<init>", "(Ljava/lang/String;I)V", "Show", "Hide", "Enter", "Exit", "toString", "", "isEnterOrShow", "", "isHideOrExit", "isShowOrExit", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImeStateDetail extends Enum<ImeStateDetail> {
    public static final ImeStateDetail Enter = null;
    public static final ImeStateDetail Exit = null;
    public static final ImeStateDetail Hide = null;
    public static final ImeStateDetail Show = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImeStateDetail[] f429338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429339b = null;

    public static EnumEntries<ImeStateDetail> getEntries() {
        return f429339b;
    }

    static {
        ImeStateDetail r100 = new ImeStateDetail("Show", 0);
        Show = r100;
        ImeStateDetail r101 = new ImeStateDetail("Hide", 1);
        Hide = r101;
        ImeStateDetail r102 = new ImeStateDetail("Enter", 2);
        Enter = r102;
        ImeStateDetail r103 = new ImeStateDetail("Exit", 3);
        Exit = r103;
        ImeStateDetail[] r104 = {r100, r101, r102, r103};
        f429338a = r104;
        f429339b = EnumEntriesKt.enumEntries(r104);
    }

    public static ImeStateDetail[] values() {
        return (ImeStateDetail[]) f429338a.clone();
    }

    public final boolean isEnterOrShow() {
        if (this != Enter) goto L5;
    L8:
        return true;
    L5:
        if (this == Show) goto L8;
        return false;
    }

    public final boolean isHideOrExit() {
        if (this != Hide) goto L5;
    L8:
        return true;
    L5:
        if (this == Exit) goto L8;
        return false;
    }

    public final boolean isShowOrExit() {
        if (this != Show) goto L5;
    L8:
        return true;
    L5:
        if (this == Exit) goto L8;
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public static ImeStateDetail valueOf(String r100) {
        return (ImeStateDetail) r27.a.a(ImeStateDetail.class, r100);
    }

    public ImeStateDetail(String r100, int r101) {
        super(r100, r101);
    }
}
