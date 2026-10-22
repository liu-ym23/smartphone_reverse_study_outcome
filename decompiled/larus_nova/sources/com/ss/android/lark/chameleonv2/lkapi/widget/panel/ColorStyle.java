package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/ColorStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Normal", "Desc", "Select", "Warning", "Disable", "TRANSLATE", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorStyle extends Enum<ColorStyle> {
    public static final ColorStyle Desc = null;
    public static final ColorStyle Disable = null;
    public static final ColorStyle Normal = null;
    public static final ColorStyle Select = null;
    public static final ColorStyle TRANSLATE = null;
    public static final ColorStyle Warning = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColorStyle[] f411466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411467b = null;
    private final int value;

    public static EnumEntries<ColorStyle> getEntries() {
        return f411467b;
    }

    static {
        ColorStyle r100 = new ColorStyle("Normal", 0, 1);
        Normal = r100;
        ColorStyle r101 = new ColorStyle("Desc", 1, 2);
        Desc = r101;
        ColorStyle r102 = new ColorStyle("Select", 2, 3);
        Select = r102;
        ColorStyle r103 = new ColorStyle("Warning", 3, 4);
        Warning = r103;
        ColorStyle r104 = new ColorStyle("Disable", 4, 5);
        Disable = r104;
        ColorStyle r110 = new ColorStyle("TRANSLATE", 5, 6);
        TRANSLATE = r110;
        ColorStyle[] r111 = {r100, r101, r102, r103, r104, r110};
        f411466a = r111;
        f411467b = EnumEntriesKt.enumEntries(r111);
    }

    public static ColorStyle[] values() {
        return (ColorStyle[]) f411466a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ColorStyle valueOf(String r100) {
        return (ColorStyle) r27.a.a(ColorStyle.class, r100);
    }

    public ColorStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
