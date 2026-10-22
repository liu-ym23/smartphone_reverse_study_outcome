package com.larus.im.bean.message.block;

import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;
import nuc.i0;
import zc9.c;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/im/bean/message/block/AudioRecordStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_UNSPECIFIED", "STATUS_IDLE", "STATUS_RECORDING", "STATUS_GENERATING_SUMMARY", "STATUS_COMPLETED", "STATUS_RECORD_FAILED", "STATUS_PAUSED", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum AudioRecordStatus extends Enum<AudioRecordStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AudioRecordStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;
    public static final AudioRecordStatus STATUS_COMPLETED = null;
    public static final AudioRecordStatus STATUS_GENERATING_SUMMARY = null;
    public static final AudioRecordStatus STATUS_IDLE = null;
    public static final AudioRecordStatus STATUS_PAUSED = null;
    public static final AudioRecordStatus STATUS_RECORDING = null;
    public static final AudioRecordStatus STATUS_RECORD_FAILED = null;
    public static final AudioRecordStatus STATUS_UNSPECIFIED = null;
    private final int value;

    private static final /* synthetic */ AudioRecordStatus[] $values() {
        return new AudioRecordStatus[]{STATUS_UNSPECIFIED, STATUS_IDLE, STATUS_RECORDING, STATUS_GENERATING_SUMMARY, STATUS_COMPLETED, STATUS_RECORD_FAILED, STATUS_PAUSED};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<AudioRecordStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.im.bean.message.block.AudioRecordStatus$a] */
    static {
        STATUS_UNSPECIFIED = new AudioRecordStatus("STATUS_UNSPECIFIED", 0, 0);
        STATUS_IDLE = new AudioRecordStatus("STATUS_IDLE", 1, 1);
        STATUS_RECORDING = new AudioRecordStatus("STATUS_RECORDING", 2, 2);
        STATUS_GENERATING_SUMMARY = new AudioRecordStatus("STATUS_GENERATING_SUMMARY", 3, 3);
        STATUS_COMPLETED = new AudioRecordStatus("STATUS_COMPLETED", 4, 4);
        STATUS_RECORD_FAILED = new AudioRecordStatus("STATUS_RECORD_FAILED", 5, 5);
        STATUS_PAUSED = new AudioRecordStatus("STATUS_PAUSED", 6, 6);
        AudioRecordStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c());
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.b("com.larus.im.bean.message.block.AudioRecordStatus", values());
    }

    public static AudioRecordStatus[] values() {
        return (AudioRecordStatus[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final int getValue() {
        return this.value;
    }

    public static AudioRecordStatus valueOf(String r100) {
        return (AudioRecordStatus) r27.a.a(AudioRecordStatus.class, r100);
    }

    private AudioRecordStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
