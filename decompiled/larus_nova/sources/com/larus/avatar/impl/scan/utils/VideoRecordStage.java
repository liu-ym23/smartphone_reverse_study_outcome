package com.larus.avatar.impl.scan.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/avatar/impl/scan/utils/VideoRecordStage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OPEN_CAMERA", "FRONT_FACE_GET_FRAME", "FRONT_FACE_ALGORITHM", "FRONT_FACE_PREGEN", "FINISH_RECORD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoRecordStage extends Enum<VideoRecordStage> {
    public static final VideoRecordStage FINISH_RECORD = null;
    public static final VideoRecordStage FRONT_FACE_ALGORITHM = null;
    public static final VideoRecordStage FRONT_FACE_GET_FRAME = null;
    public static final VideoRecordStage FRONT_FACE_PREGEN = null;
    public static final VideoRecordStage OPEN_CAMERA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoRecordStage[] f291133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291134b = null;
    private final int value;

    public static EnumEntries<VideoRecordStage> getEntries() {
        return f291134b;
    }

    static {
        VideoRecordStage r100 = new VideoRecordStage("OPEN_CAMERA", 0, 0);
        OPEN_CAMERA = r100;
        VideoRecordStage r101 = new VideoRecordStage("FRONT_FACE_GET_FRAME", 1, 1);
        FRONT_FACE_GET_FRAME = r101;
        VideoRecordStage r102 = new VideoRecordStage("FRONT_FACE_ALGORITHM", 2, 2);
        FRONT_FACE_ALGORITHM = r102;
        VideoRecordStage r103 = new VideoRecordStage("FRONT_FACE_PREGEN", 3, 3);
        FRONT_FACE_PREGEN = r103;
        VideoRecordStage r104 = new VideoRecordStage("FINISH_RECORD", 4, 4);
        FINISH_RECORD = r104;
        VideoRecordStage[] r105 = {r100, r101, r102, r103, r104};
        f291133a = r105;
        f291134b = EnumEntriesKt.enumEntries(r105);
    }

    public static VideoRecordStage[] values() {
        return (VideoRecordStage[]) f291133a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VideoRecordStage valueOf(String r100) {
        return (VideoRecordStage) r27.a.a(VideoRecordStage.class, r100);
    }

    public VideoRecordStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
