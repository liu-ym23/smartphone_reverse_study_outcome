package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceRecordError;", "", "<init>", "(Ljava/lang/String;I)V", "WEAK_NET", "INTERRUPT", "RECORD_FAILED", "MEDIA_LOCK_FAILED", "REQUEST_TIMEOUT", "RECORD_TOO_SHORT", "HARDWARE_PREPARE_TOO_LONG", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AdvanceRecordError extends Enum<AdvanceRecordError> {
    public static final AdvanceRecordError HARDWARE_PREPARE_TOO_LONG = null;
    public static final AdvanceRecordError INTERRUPT = null;
    public static final AdvanceRecordError MEDIA_LOCK_FAILED = null;
    public static final AdvanceRecordError RECORD_FAILED = null;
    public static final AdvanceRecordError RECORD_TOO_SHORT = null;
    public static final AdvanceRecordError REQUEST_TIMEOUT = null;
    public static final AdvanceRecordError WEAK_NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdvanceRecordError[] f429832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429833b = null;

    public static EnumEntries<AdvanceRecordError> getEntries() {
        return f429833b;
    }

    static {
        AdvanceRecordError r100 = new AdvanceRecordError("WEAK_NET", 0);
        WEAK_NET = r100;
        AdvanceRecordError r101 = new AdvanceRecordError("INTERRUPT", 1);
        INTERRUPT = r101;
        AdvanceRecordError r102 = new AdvanceRecordError("RECORD_FAILED", 2);
        RECORD_FAILED = r102;
        AdvanceRecordError r103 = new AdvanceRecordError("MEDIA_LOCK_FAILED", 3);
        MEDIA_LOCK_FAILED = r103;
        AdvanceRecordError r104 = new AdvanceRecordError("REQUEST_TIMEOUT", 4);
        REQUEST_TIMEOUT = r104;
        AdvanceRecordError r105 = new AdvanceRecordError("RECORD_TOO_SHORT", 5);
        RECORD_TOO_SHORT = r105;
        AdvanceRecordError r110 = new AdvanceRecordError("HARDWARE_PREPARE_TOO_LONG", 6);
        HARDWARE_PREPARE_TOO_LONG = r110;
        AdvanceRecordError[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f429832a = r111;
        f429833b = EnumEntriesKt.enumEntries(r111);
    }

    public static AdvanceRecordError[] values() {
        return (AdvanceRecordError[]) f429832a.clone();
    }

    public static AdvanceRecordError valueOf(String r100) {
        return (AdvanceRecordError) r27.a.a(AdvanceRecordError.class, r100);
    }

    public AdvanceRecordError(String r100, int r101) {
        super(r100, r101);
    }
}
