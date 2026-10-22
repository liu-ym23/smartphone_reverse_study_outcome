package com.larus.audio.bean;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/bean/RECORD_STATUS;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", ErrorCode.INIT, State.RECORDING, "ERROR", "FINISH", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RECORD_STATUS extends Enum<RECORD_STATUS> {
    public static final RECORD_STATUS ERROR = null;
    public static final RECORD_STATUS FINISH = null;
    public static final RECORD_STATUS INIT = null;
    public static final RECORD_STATUS RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RECORD_STATUS[] f288724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288725b = null;
    private final int value;

    public static EnumEntries<RECORD_STATUS> getEntries() {
        return f288725b;
    }

    static {
        RECORD_STATUS r100 = new RECORD_STATUS(ErrorCode.INIT, 0, 0);
        INIT = r100;
        RECORD_STATUS r101 = new RECORD_STATUS(State.RECORDING, 1, 1);
        RECORDING = r101;
        RECORD_STATUS r102 = new RECORD_STATUS("ERROR", 2, 2);
        ERROR = r102;
        RECORD_STATUS r103 = new RECORD_STATUS("FINISH", 3, 3);
        FINISH = r103;
        RECORD_STATUS[] r104 = {r100, r101, r102, r103};
        f288724a = r104;
        f288725b = EnumEntriesKt.enumEntries(r104);
    }

    public static RECORD_STATUS[] values() {
        return (RECORD_STATUS[]) f288724a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RECORD_STATUS valueOf(String r100) {
        return (RECORD_STATUS) a.a(RECORD_STATUS.class, r100);
    }

    public RECORD_STATUS(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
