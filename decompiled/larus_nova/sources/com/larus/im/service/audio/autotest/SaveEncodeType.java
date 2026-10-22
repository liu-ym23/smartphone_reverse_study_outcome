package com.larus.im.service.audio.autotest;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/service/audio/autotest/SaveEncodeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Raw", "H264", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SaveEncodeType extends Enum<SaveEncodeType> {
    public static final a Companion = null;
    public static final SaveEncodeType H264 = null;
    public static final SaveEncodeType Raw = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SaveEncodeType[] f350684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350685b = null;
    private final int value;

    public static EnumEntries<SaveEncodeType> getEntries() {
        return f350685b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.im.service.audio.autotest.SaveEncodeType$a] */
    static {
        SaveEncodeType r100 = new SaveEncodeType("Raw", 0, 0);
        Raw = r100;
        SaveEncodeType r101 = new SaveEncodeType("H264", 1, 1);
        H264 = r101;
        SaveEncodeType[] r102 = {r100, r101};
        f350684a = r102;
        f350685b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static SaveEncodeType[] values() {
        return (SaveEncodeType[]) f350684a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SaveEncodeType valueOf(String r100) {
        return (SaveEncodeType) r27.a.a(SaveEncodeType.class, r100);
    }

    public SaveEncodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
