package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.lark.pb.videochat_my_ai.NotesBlock;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f406746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f406747b = null;

    static {
        int[] r100 = new int[AINoteCreateSource.values().length];
        r100[AINoteCreateSource.INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
    L43:
        r100[AINoteCreateSource.HIGHLIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
    L57:
        r100[AINoteCreateSource.PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
    L45:
        r100[AINoteCreateSource.SUBTITLE_HIGHLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
    L47:
        r100[AINoteCreateSource.AI_VISION_HIGHLIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
    L35:
        r100[AINoteCreateSource.EMPTY_STATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
    L14:
        f406746a = r100;
        int[] r101 = new int[NotesBlock.CreateSource.values().length];
        r101[NotesBlock.CreateSource.INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
    L53:
        r101[NotesBlock.CreateSource.HIGHLIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
    L39:
        r101[NotesBlock.CreateSource.PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
    L51:
        r101[NotesBlock.CreateSource.SUBTITLE_HIGHLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
    L37:
        r101[NotesBlock.CreateSource.AI_VISION_HIGHLIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
    L49:
        r101[NotesBlock.CreateSource.EMPTY_STATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
    L21:
        f406747b = r101;
    }
}
