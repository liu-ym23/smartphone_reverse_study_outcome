package com.ss.android.lark.keyboard.editor.input;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/editor/input/ChatEditorEnable;", "Lcom/ss/android/lark/keyboard/event/Notify;", "", "<init>", "(Ljava/lang/String;I)V", "Enable", "Disable", "getTag", "", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatEditorEnable extends Enum<ChatEditorEnable> implements com.ss.android.lark.keyboard.event.q {
    public static final ChatEditorEnable Disable = null;
    public static final ChatEditorEnable Enable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatEditorEnable[] f428848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428849b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f428850a = null;

        static {
            int[] r100 = new int[ChatEditorEnable.values().length];
            r100[ChatEditorEnable.Enable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ChatEditorEnable.Disable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f428850a = r100;
        }
    }

    public static EnumEntries<ChatEditorEnable> getEntries() {
        return f428849b;
    }

    static {
        ChatEditorEnable r100 = new ChatEditorEnable("Enable", 0);
        Enable = r100;
        ChatEditorEnable r101 = new ChatEditorEnable("Disable", 1);
        Disable = r101;
        ChatEditorEnable[] r102 = {r100, r101};
        f428848a = r102;
        f428849b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatEditorEnable[] values() {
        return (ChatEditorEnable[]) f428848a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        int r100 = a.f428850a[ordinal()];
        if (r100 != 1) goto L5;
        return "Enable";
    L5:
        if (r100 != 2) goto L8;
        return "Disable";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static ChatEditorEnable valueOf(String r100) {
        return (ChatEditorEnable) r27.a.a(ChatEditorEnable.class, r100);
    }

    public ChatEditorEnable(String r100, int r101) {
        super(r100, r101);
    }
}
