package com.bytedance.lark.policy.model;

import com.obric.miniapp.alarm.AccountType;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/policy/model/ResponseType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FAST_PASS", AccountType.LOCAL, "REMOTE", "DOWNGRADE", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResponseType extends Enum<ResponseType> {
    public static final ResponseType DOWNGRADE = null;
    public static final ResponseType FAST_PASS = null;
    public static final ResponseType LOCAL = null;
    public static final ResponseType REMOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResponseType[] f253840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253841b = null;
    private final String value;

    public static EnumEntries<ResponseType> getEntries() {
        return f253841b;
    }

    static {
        ResponseType r100 = new ResponseType("FAST_PASS", 0, "fastPass");
        FAST_PASS = r100;
        ResponseType r101 = new ResponseType(AccountType.LOCAL, 1, "local");
        LOCAL = r101;
        ResponseType r102 = new ResponseType("REMOTE", 2, "remote");
        REMOTE = r102;
        ResponseType r103 = new ResponseType("DOWNGRADE", 3, GearStrategyConsts.EV_DOWNGRADE_TYPE);
        DOWNGRADE = r103;
        ResponseType[] r104 = {r100, r101, r102, r103};
        f253840a = r104;
        f253841b = EnumEntriesKt.enumEntries(r104);
    }

    public static ResponseType[] values() {
        return (ResponseType[]) f253840a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResponseType valueOf(String r100) {
        return (ResponseType) r27.a.a(ResponseType.class, r100);
    }

    public ResponseType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
