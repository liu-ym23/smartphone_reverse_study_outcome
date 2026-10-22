package com.ss.android.lark.biz.im.api.extension.keyboard.editor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/editor/KeyboardHintPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NULL", "VC_ON_MEETING", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyboardHintPriority extends Enum<KeyboardHintPriority> {
    public static final a Companion = null;
    public static final KeyboardHintPriority NULL = null;
    public static final KeyboardHintPriority VC_ON_MEETING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyboardHintPriority[] f410143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410144b = null;
    private final int value;

    public static EnumEntries<KeyboardHintPriority> getEntries() {
        return f410144b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.biz.im.api.extension.keyboard.editor.KeyboardHintPriority$a] */
    static {
        KeyboardHintPriority r100 = new KeyboardHintPriority("NULL", 0, -1);
        NULL = r100;
        KeyboardHintPriority r101 = new KeyboardHintPriority("VC_ON_MEETING", 1, 0);
        VC_ON_MEETING = r101;
        KeyboardHintPriority[] r102 = {r100, r101};
        f410143a = r102;
        f410144b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static KeyboardHintPriority[] values() {
        return (KeyboardHintPriority[]) f410143a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static KeyboardHintPriority valueOf(String r100) {
        return (KeyboardHintPriority) r27.a.a(KeyboardHintPriority.class, r100);
    }

    public KeyboardHintPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
