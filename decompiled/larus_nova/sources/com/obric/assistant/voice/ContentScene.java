package com.obric.assistant.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/voice/ContentScene;", "", "str", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "OAUTO_CALL_USER", "COMPLEX_ASK_USER", "PRIORITY_NOTIFICATION", "AI_ACTIVE_ASK", "UNKNOWN", "isValid", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentScene extends Enum<ContentScene> {
    public static final ContentScene AI_ACTIVE_ASK = null;
    public static final ContentScene COMPLEX_ASK_USER = null;
    public static final a Companion = null;
    public static final ContentScene OAUTO_CALL_USER = null;
    public static final ContentScene PRIORITY_NOTIFICATION = null;
    public static final ContentScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentScene[] f394356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394357b = null;
    private final String str;

    public static final class a {
        public a() {
        }

        public static ContentScene a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "str");
            ContentScene[] r101 = ContentScene.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ContentScene r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getStr(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return ContentScene.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static EnumEntries<ContentScene> getEntries() {
        return f394357b;
    }

    static {
        ContentScene r100 = new ContentScene("OAUTO_CALL_USER", 0, "oauto_askuser");
        OAUTO_CALL_USER = r100;
        ContentScene r101 = new ContentScene("COMPLEX_ASK_USER", 1, "complex_askuser");
        COMPLEX_ASK_USER = r101;
        ContentScene r102 = new ContentScene("PRIORITY_NOTIFICATION", 2, "notification");
        PRIORITY_NOTIFICATION = r102;
        ContentScene r103 = new ContentScene("AI_ACTIVE_ASK", 3, "ai_active_ask");
        AI_ACTIVE_ASK = r103;
        ContentScene r104 = new ContentScene("UNKNOWN", 4, "unknown");
        UNKNOWN = r104;
        ContentScene[] r105 = {r100, r101, r102, r103, r104};
        f394356a = r105;
        f394357b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ContentScene[] values() {
        return (ContentScene[]) f394356a.clone();
    }

    public final boolean isValid() {
        if (this == UNKNOWN) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getStr() {
        return this.str;
    }

    public static ContentScene valueOf(String r100) {
        return (ContentScene) r27.a.a(ContentScene.class, r100);
    }

    public ContentScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}
