package com.ss.android.lark.commonmark.parser;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum IncludeSourceSpans extends Enum<IncludeSourceSpans> {
    public static final IncludeSourceSpans BLOCKS = null;
    public static final IncludeSourceSpans BLOCKS_AND_INLINES = null;
    public static final IncludeSourceSpans NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IncludeSourceSpans[] f417274a = null;

    static {
        IncludeSourceSpans r100 = new IncludeSourceSpans(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        IncludeSourceSpans r101 = new IncludeSourceSpans("BLOCKS", 1);
        BLOCKS = r101;
        IncludeSourceSpans r102 = new IncludeSourceSpans("BLOCKS_AND_INLINES", 2);
        BLOCKS_AND_INLINES = r102;
        f417274a = new IncludeSourceSpans[]{r100, r101, r102};
    }

    public static IncludeSourceSpans[] values() {
        return (IncludeSourceSpans[]) f417274a.clone();
    }

    public static IncludeSourceSpans valueOf(String r100) {
        return (IncludeSourceSpans) a.a(IncludeSourceSpans.class, r100);
    }

    public IncludeSourceSpans(String r100, int r101) {
        super(r100, r101);
    }
}
