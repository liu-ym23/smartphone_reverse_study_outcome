package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.pb.videochat_my_ai.NotesBlock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406691a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406692a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f406693b = null;

        static {
            int[] r100 = new int[AINoteType.values().length];
            r100[AINoteType.REGULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L58:
            r100[AINoteType.SOFTWARE_MARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L66:
            r100[AINoteType.SUBTITLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L42:
            r100[AINoteType.FISH_BONE_TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L44:
            r100[AINoteType.FISH_BONE_CHART.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L52:
            r100[AINoteType.HARDWARE_MARK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L60:
            r100[AINoteType.HARDWARE_MARK_OFFLINE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L16:
            f406692a = r100;
            int[] r101 = new int[NotesBlock.NoteType.values().length];
            r101[NotesBlock.NoteType.REGULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L56:
            r101[NotesBlock.NoteType.SOFTWARE_MARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L64:
            r101[NotesBlock.NoteType.HARDWARE_MARK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L40:
            r101[NotesBlock.NoteType.SUBTITLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L46:
            r101[NotesBlock.NoteType.FISH_BONE_TEXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L54:
            r101[NotesBlock.NoteType.FISH_BONE_CHART.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L62:
            r101[NotesBlock.NoteType.HARDWARE_MARK_OFFLINE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L24:
            f406693b = r101;
        }
    }

    static {
    }

    public static NotesBlock.NoteType a(AINoteType r100) {
        Intrinsics.checkNotNullParameter(r100, "noteType");
        switch(a.f406692a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return NotesBlock.NoteType.HARDWARE_MARK_OFFLINE;
    L15:
        return NotesBlock.NoteType.HARDWARE_MARK;
    L16:
        return NotesBlock.NoteType.FISH_BONE_CHART;
    L17:
        return NotesBlock.NoteType.FISH_BONE_TEXT;
    L18:
        return NotesBlock.NoteType.SUBTITLE;
    L19:
        return NotesBlock.NoteType.SOFTWARE_MARK;
    L13:
        return NotesBlock.NoteType.REGULAR;
    }
}
