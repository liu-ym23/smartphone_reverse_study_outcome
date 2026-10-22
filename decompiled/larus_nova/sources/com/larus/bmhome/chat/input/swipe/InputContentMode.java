package com.larus.bmhome.chat.input.swipe;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/input/swipe/InputContentMode;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "SPEAK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputContentMode extends Enum<InputContentMode> {
    public static final InputContentMode SPEAK = null;
    public static final InputContentMode TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputContentMode[] f303332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303333b = null;

    public static EnumEntries<InputContentMode> getEntries() {
        return f303333b;
    }

    static {
        InputContentMode r100 = new InputContentMode(CardAdapter.TEXT, 0);
        TEXT = r100;
        InputContentMode r101 = new InputContentMode("SPEAK", 1);
        SPEAK = r101;
        InputContentMode[] r102 = {r100, r101};
        f303332a = r102;
        f303333b = EnumEntriesKt.enumEntries(r102);
    }

    public static InputContentMode[] values() {
        return (InputContentMode[]) f303332a.clone();
    }

    public static InputContentMode valueOf(String r100) {
        return (InputContentMode) a.a(InputContentMode.class, r100);
    }

    public InputContentMode(String r100, int r101) {
        super(r100, r101);
    }
}
