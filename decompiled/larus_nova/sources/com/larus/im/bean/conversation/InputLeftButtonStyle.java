package com.larus.im.bean.conversation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/bean/conversation/InputLeftButtonStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ButtonStyle_None", "ButtonStyle_Camera", "ButtonStyle_Photo", "ButtonStyle_File_Icon1", "ButtonStyle_File_Icon2", "ButtonStyle_Call", "ButtonStyle_Instruction", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputLeftButtonStyle extends Enum<InputLeftButtonStyle> {
    public static final InputLeftButtonStyle ButtonStyle_Call = null;
    public static final InputLeftButtonStyle ButtonStyle_Camera = null;
    public static final InputLeftButtonStyle ButtonStyle_File_Icon1 = null;
    public static final InputLeftButtonStyle ButtonStyle_File_Icon2 = null;
    public static final InputLeftButtonStyle ButtonStyle_Instruction = null;
    public static final InputLeftButtonStyle ButtonStyle_None = null;
    public static final InputLeftButtonStyle ButtonStyle_Photo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputLeftButtonStyle[] f346539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346540b = null;
    private final int value;

    public static EnumEntries<InputLeftButtonStyle> getEntries() {
        return f346540b;
    }

    static {
        InputLeftButtonStyle r100 = new InputLeftButtonStyle("ButtonStyle_None", 0, 0);
        ButtonStyle_None = r100;
        InputLeftButtonStyle r101 = new InputLeftButtonStyle("ButtonStyle_Camera", 1, 1);
        ButtonStyle_Camera = r101;
        InputLeftButtonStyle r102 = new InputLeftButtonStyle("ButtonStyle_Photo", 2, 2);
        ButtonStyle_Photo = r102;
        InputLeftButtonStyle r103 = new InputLeftButtonStyle("ButtonStyle_File_Icon1", 3, 3);
        ButtonStyle_File_Icon1 = r103;
        InputLeftButtonStyle r104 = new InputLeftButtonStyle("ButtonStyle_File_Icon2", 4, 4);
        ButtonStyle_File_Icon2 = r104;
        InputLeftButtonStyle r105 = new InputLeftButtonStyle("ButtonStyle_Call", 5, 5);
        ButtonStyle_Call = r105;
        InputLeftButtonStyle r110 = new InputLeftButtonStyle("ButtonStyle_Instruction", 6, 6);
        ButtonStyle_Instruction = r110;
        InputLeftButtonStyle[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f346539a = r111;
        f346540b = EnumEntriesKt.enumEntries(r111);
    }

    public static InputLeftButtonStyle[] values() {
        return (InputLeftButtonStyle[]) f346539a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InputLeftButtonStyle valueOf(String r100) {
        return (InputLeftButtonStyle) a.a(InputLeftButtonStyle.class, r100);
    }

    public InputLeftButtonStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
