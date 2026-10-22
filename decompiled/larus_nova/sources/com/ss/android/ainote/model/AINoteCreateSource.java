package com.ss.android.ainote.model;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/ainote/model/AINoteCreateSource;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT", "HIGHLIGHT", SuggestActionType.PHOTO, "SUBTITLE_HIGHLIGHT", "AI_VISION_HIGHLIGHT", "EMPTY_STATE", "toEventValue", "", "Companion", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteCreateSource extends Enum<AINoteCreateSource> {
    public static final AINoteCreateSource AI_VISION_HIGHLIGHT = null;
    public static final a Companion = null;
    public static final AINoteCreateSource EMPTY_STATE = null;
    public static final AINoteCreateSource HIGHLIGHT = null;
    public static final AINoteCreateSource INPUT = null;
    public static final AINoteCreateSource PHOTO = null;
    public static final AINoteCreateSource SUBTITLE_HIGHLIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteCreateSource[] f407136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407137b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f407138a = null;

        static {
            int[] r100 = new int[AINoteCreateSource.values().length];
            r100[AINoteCreateSource.INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[AINoteCreateSource.HIGHLIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[AINoteCreateSource.PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[AINoteCreateSource.SUBTITLE_HIGHLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AINoteCreateSource.AI_VISION_HIGHLIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[AINoteCreateSource.EMPTY_STATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f407138a = r100;
        }
    }

    public static EnumEntries<AINoteCreateSource> getEntries() {
        return f407137b;
    }

    static {
        AINoteCreateSource r100 = new AINoteCreateSource("INPUT", 0);
        INPUT = r100;
        AINoteCreateSource r101 = new AINoteCreateSource("HIGHLIGHT", 1);
        HIGHLIGHT = r101;
        AINoteCreateSource r102 = new AINoteCreateSource(SuggestActionType.PHOTO, 2);
        PHOTO = r102;
        AINoteCreateSource r103 = new AINoteCreateSource("SUBTITLE_HIGHLIGHT", 3);
        SUBTITLE_HIGHLIGHT = r103;
        AINoteCreateSource r104 = new AINoteCreateSource("AI_VISION_HIGHLIGHT", 4);
        AI_VISION_HIGHLIGHT = r104;
        AINoteCreateSource r105 = new AINoteCreateSource("EMPTY_STATE", 5);
        EMPTY_STATE = r105;
        AINoteCreateSource[] r110 = {r100, r101, r102, r103, r104, r105};
        f407136a = r110;
        f407137b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static AINoteCreateSource[] values() {
        return (AINoteCreateSource[]) f407136a.clone();
    }

    public final String toEventValue() {
        switch(b.f407138a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "empty_state";
    L7:
        return "ai_vision_highlight";
    L8:
        return "subtitle_highlight";
    L9:
        return "photo";
    L10:
        return "highlight";
    L11:
        return "input";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static AINoteCreateSource valueOf(String r100) {
        return (AINoteCreateSource) r27.a.a(AINoteCreateSource.class, r100);
    }

    public AINoteCreateSource(String r100, int r101) {
        super(r100, r101);
    }
}
