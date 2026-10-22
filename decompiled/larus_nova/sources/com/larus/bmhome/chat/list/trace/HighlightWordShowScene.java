package com.larus.bmhome.chat.list.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/trace/HighlightWordShowScene;", "", "<init>", "(Ljava/lang/String;I)V", "LINK_META_INFO", "LINK_PHONE_NUMBER", "LINK_LONG_URL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HighlightWordShowScene extends Enum<HighlightWordShowScene> {
    public static final HighlightWordShowScene LINK_LONG_URL = null;
    public static final HighlightWordShowScene LINK_META_INFO = null;
    public static final HighlightWordShowScene LINK_PHONE_NUMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HighlightWordShowScene[] f306614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306615b = null;

    public static EnumEntries<HighlightWordShowScene> getEntries() {
        return f306615b;
    }

    static {
        HighlightWordShowScene r100 = new HighlightWordShowScene("LINK_META_INFO", 0);
        LINK_META_INFO = r100;
        HighlightWordShowScene r101 = new HighlightWordShowScene("LINK_PHONE_NUMBER", 1);
        LINK_PHONE_NUMBER = r101;
        HighlightWordShowScene r102 = new HighlightWordShowScene("LINK_LONG_URL", 2);
        LINK_LONG_URL = r102;
        HighlightWordShowScene[] r103 = {r100, r101, r102};
        f306614a = r103;
        f306615b = EnumEntriesKt.enumEntries(r103);
    }

    public static HighlightWordShowScene[] values() {
        return (HighlightWordShowScene[]) f306614a.clone();
    }

    public static HighlightWordShowScene valueOf(String r100) {
        return (HighlightWordShowScene) r27.a.a(HighlightWordShowScene.class, r100);
    }

    public HighlightWordShowScene(String r100, int r101) {
        super(r100, r101);
    }
}
