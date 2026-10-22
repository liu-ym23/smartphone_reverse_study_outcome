package com.larus.im.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/im/constant/CompensateScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "COLD_LAUNCH", "FRONTIER_DISCONNECT", "FRONTIER_RECOVER", "ACCOUNT_SWITCH", "FRONTIER_NEW_MSG", "GET_MAIN_CONVERSATION", "ON_DATABASE_CORRUPTED", "DOWNGRADE_REFORM", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CompensateScene extends Enum<CompensateScene> {
    public static final CompensateScene ACCOUNT_SWITCH = null;
    public static final CompensateScene COLD_LAUNCH = null;
    public static final CompensateScene DOWNGRADE_REFORM = null;
    public static final CompensateScene FRONTIER_DISCONNECT = null;
    public static final CompensateScene FRONTIER_NEW_MSG = null;
    public static final CompensateScene FRONTIER_RECOVER = null;
    public static final CompensateScene GET_MAIN_CONVERSATION = null;
    public static final CompensateScene ON_DATABASE_CORRUPTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CompensateScene[] f347130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347131b = null;
    private final int value;

    public static EnumEntries<CompensateScene> getEntries() {
        return f347131b;
    }

    static {
        CompensateScene r100 = new CompensateScene("COLD_LAUNCH", 0, 0);
        COLD_LAUNCH = r100;
        CompensateScene r101 = new CompensateScene("FRONTIER_DISCONNECT", 1, 1);
        FRONTIER_DISCONNECT = r101;
        CompensateScene r102 = new CompensateScene("FRONTIER_RECOVER", 2, 2);
        FRONTIER_RECOVER = r102;
        CompensateScene r103 = new CompensateScene("ACCOUNT_SWITCH", 3, 3);
        ACCOUNT_SWITCH = r103;
        CompensateScene r104 = new CompensateScene("FRONTIER_NEW_MSG", 4, 4);
        FRONTIER_NEW_MSG = r104;
        CompensateScene r105 = new CompensateScene("GET_MAIN_CONVERSATION", 5, 5);
        GET_MAIN_CONVERSATION = r105;
        CompensateScene r110 = new CompensateScene("ON_DATABASE_CORRUPTED", 6, 6);
        ON_DATABASE_CORRUPTED = r110;
        CompensateScene r111 = new CompensateScene("DOWNGRADE_REFORM", 7, 8);
        DOWNGRADE_REFORM = r111;
        CompensateScene[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f347130a = r112;
        f347131b = EnumEntriesKt.enumEntries(r112);
    }

    public static CompensateScene[] values() {
        return (CompensateScene[]) f347130a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CompensateScene valueOf(String r100) {
        return (CompensateScene) a.a(CompensateScene.class, r100);
    }

    public CompensateScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
