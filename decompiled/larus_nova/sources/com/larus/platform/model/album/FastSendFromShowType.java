package com.larus.platform.model.album;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/album/FastSendFromShowType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EVERY_COLD_LAUNCH", "FIRST_COLD_LAUNCH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FastSendFromShowType extends Enum<FastSendFromShowType> {
    public static final FastSendFromShowType EVERY_COLD_LAUNCH = null;
    public static final FastSendFromShowType FIRST_COLD_LAUNCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FastSendFromShowType[] f365547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365548b = null;
    private final int type;

    public static EnumEntries<FastSendFromShowType> getEntries() {
        return f365548b;
    }

    static {
        FastSendFromShowType r100 = new FastSendFromShowType("EVERY_COLD_LAUNCH", 0, 0);
        EVERY_COLD_LAUNCH = r100;
        FastSendFromShowType r101 = new FastSendFromShowType("FIRST_COLD_LAUNCH", 1, 1);
        FIRST_COLD_LAUNCH = r101;
        FastSendFromShowType[] r102 = {r100, r101};
        f365547a = r102;
        f365548b = EnumEntriesKt.enumEntries(r102);
    }

    public static FastSendFromShowType[] values() {
        return (FastSendFromShowType[]) f365547a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static FastSendFromShowType valueOf(String r100) {
        return (FastSendFromShowType) a.a(FastSendFromShowType.class, r100);
    }

    public FastSendFromShowType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
