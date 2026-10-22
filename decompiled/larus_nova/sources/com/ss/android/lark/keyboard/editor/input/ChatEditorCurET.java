package com.ss.android.lark.keyboard.editor.input;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/editor/input/ChatEditorCurET;", "Lcom/ss/android/lark/keyboard/event/Notify;", "", "<init>", "(Ljava/lang/String;I)V", "Title", "Content", "getTag", "", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatEditorCurET extends Enum<ChatEditorCurET> implements com.ss.android.lark.keyboard.event.q {
    public static final ChatEditorCurET Content = null;
    public static final ChatEditorCurET Title = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatEditorCurET[] f428845a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428846b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f428847a = null;

        static {
            int[] r100 = new int[ChatEditorCurET.values().length];
            r100[ChatEditorCurET.Title.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ChatEditorCurET.Content.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f428847a = r100;
        }
    }

    public static EnumEntries<ChatEditorCurET> getEntries() {
        return f428846b;
    }

    static {
        ChatEditorCurET r100 = new ChatEditorCurET("Title", 0);
        Title = r100;
        ChatEditorCurET r101 = new ChatEditorCurET("Content", 1);
        Content = r101;
        ChatEditorCurET[] r102 = {r100, r101};
        f428845a = r102;
        f428846b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatEditorCurET[] values() {
        return (ChatEditorCurET[]) f428845a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        int r100 = a.f428847a[ordinal()];
        if (r100 != 1) goto L5;
        return "title";
    L5:
        if (r100 != 2) goto L8;
        return "content";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static ChatEditorCurET valueOf(String r100) {
        return (ChatEditorCurET) r27.a.a(ChatEditorCurET.class, r100);
    }

    public ChatEditorCurET(String r100, int r101) {
        super(r100, r101);
    }
}
