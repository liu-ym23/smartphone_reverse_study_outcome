package com.ss.android.ainote.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ainote/model/AINoteType;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "SOFTWARE_MARK", "SUBTITLE", "FISH_BONE_TEXT", "FISH_BONE_CHART", "HARDWARE_MARK", "HARDWARE_MARK_OFFLINE", "isMark", "", "needsPolish", "initialContentState", "Lcom/ss/android/ainote/model/AINoteContentState;", "liveRewritingEnabled", "supportsRestoreOriginal", "shouldJumpByMarkId", "shouldDefaultAudioLocationToClientTime", "defaultCreateSource", "Lcom/ss/android/ainote/model/AINoteCreateSource;", "Companion", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteType extends Enum<AINoteType> {
    public static final a Companion = null;
    public static final AINoteType FISH_BONE_CHART = null;
    public static final AINoteType FISH_BONE_TEXT = null;
    public static final AINoteType HARDWARE_MARK = null;
    public static final AINoteType HARDWARE_MARK_OFFLINE = null;
    public static final AINoteType REGULAR = null;
    public static final AINoteType SOFTWARE_MARK = null;
    public static final AINoteType SUBTITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteType[] f407146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407147b = null;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.ainote.model.AINoteType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4706a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f407148a = null;

            static {
                int[] r100 = new int[AINoteScene.values().length];
                r100[AINoteScene.Hardware.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[AINoteScene.Meeting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[AINoteScene.Record.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[AINoteScene.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f407148a = r100;
            }
        }

        public a() {
        }

        public static AINoteType a(boolean r100, AINoteScene r101) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            if (r100 == false) goto L5;
            int r102 = C4706a.f407148a[r101.ordinal()];
            if (r102 == 1) goto L19;
            if (r102 == 2) goto L20;
            if (r102 == 3) goto L20;
            if (r102 == 4) goto L20;
            throw new NoWhenBranchMatchedException();
        L20:
            return AINoteType.SOFTWARE_MARK;
        L19:
            return AINoteType.HARDWARE_MARK;
        L5:
            return AINoteType.REGULAR;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f407149a = null;

        static {
            int[] r100 = new int[AINoteType.values().length];
            r100[AINoteType.FISH_BONE_TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[AINoteType.FISH_BONE_CHART.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[AINoteType.REGULAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AINoteType.SOFTWARE_MARK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AINoteType.SUBTITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[AINoteType.HARDWARE_MARK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[AINoteType.HARDWARE_MARK_OFFLINE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f407149a = r100;
        }
    }

    public static EnumEntries<AINoteType> getEntries() {
        return f407147b;
    }

    static {
        AINoteType r100 = new AINoteType("REGULAR", 0);
        REGULAR = r100;
        AINoteType r101 = new AINoteType("SOFTWARE_MARK", 1);
        SOFTWARE_MARK = r101;
        AINoteType r102 = new AINoteType("SUBTITLE", 2);
        SUBTITLE = r102;
        AINoteType r103 = new AINoteType("FISH_BONE_TEXT", 3);
        FISH_BONE_TEXT = r103;
        AINoteType r104 = new AINoteType("FISH_BONE_CHART", 4);
        FISH_BONE_CHART = r104;
        AINoteType r105 = new AINoteType("HARDWARE_MARK", 5);
        HARDWARE_MARK = r105;
        AINoteType r110 = new AINoteType("HARDWARE_MARK_OFFLINE", 6);
        HARDWARE_MARK_OFFLINE = r110;
        AINoteType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f407146a = r111;
        f407147b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static AINoteType[] values() {
        return (AINoteType[]) f407146a.clone();
    }

    public final AINoteCreateSource defaultCreateSource() {
        switch(b.f407149a[ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L12;
            case 7: goto L12;
            default: goto L5;
        };
    L8:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L11:
        return AINoteCreateSource.SUBTITLE_HIGHLIGHT;
    L12:
        return AINoteCreateSource.HIGHLIGHT;
    L10:
        return AINoteCreateSource.AI_VISION_HIGHLIGHT;
    }

    public final boolean isMark() {
        if (this == REGULAR) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean needsPolish() {
        switch(b.f407149a[ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L7:
        return false;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean shouldDefaultAudioLocationToClientTime() {
        switch(b.f407149a[ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L7:
        return false;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean shouldJumpByMarkId() {
        if (this != FISH_BONE_TEXT) goto L5;
    L8:
        return true;
    L5:
        if (this == FISH_BONE_CHART) goto L8;
        return false;
    }

    public final boolean supportsRestoreOriginal() {
        if (this != REGULAR) goto L5;
        return true;
    L5:
        return false;
    }

    public static AINoteType valueOf(String r100) {
        return (AINoteType) r27.a.a(AINoteType.class, r100);
    }

    public final AINoteContentState initialContentState(boolean r100) {
        switch(b.f407149a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L7;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            default: goto L5;
        };
    L7:
        if (r100 == false) goto L14;
        return AINoteContentState.NEED;
    L14:
        return AINoteContentState.NO_NEED;
    L5:
        throw new NoWhenBranchMatchedException();
    L12:
        return AINoteContentState.NEED;
    L11:
        return AINoteContentState.NO_NEED;
    }

    public AINoteType(String r100, int r101) {
        super(r100, r101);
    }
}
