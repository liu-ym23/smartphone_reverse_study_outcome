package com.ss.android.lark.keyboard.plugin.input.base;

import com.ss.android.lark.keyboard.event.c;
import com.ss.android.lark.keyboard.event.m;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/input/base/InputSupportType;", "Lcom/ss/android/lark/keyboard/event/ITransformable;", "", "<init>", "(Ljava/lang/String;I)V", "Text", "Post", "None", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputSupportType extends Enum<InputSupportType> implements m {
    public static final InputSupportType None = null;
    public static final InputSupportType Post = null;
    public static final InputSupportType Text = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputSupportType[] f429571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429572b = null;

    public static EnumEntries<InputSupportType> getEntries() {
        return f429572b;
    }

    static {
        InputSupportType r100 = new InputSupportType("Text", 0);
        Text = r100;
        InputSupportType r101 = new InputSupportType("Post", 1);
        Post = r101;
        InputSupportType r102 = new InputSupportType("None", 2);
        None = r102;
        InputSupportType[] r103 = {r100, r101, r102};
        f429571a = r103;
        f429572b = EnumEntriesKt.enumEntries(r103);
    }

    public static InputSupportType[] values() {
        return (InputSupportType[]) f429571a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        return c.a.a(this);
    }

    public static InputSupportType valueOf(String r100) {
        return (InputSupportType) a.a(InputSupportType.class, r100);
    }

    public InputSupportType(String r100, int r101) {
        super(r100, r101);
    }
}
