package com.larus.common.audit;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/common/audit/SecurityAuditStage;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", ErrorCode.CLOSED, "TTNET_INIT", "SECURITY_INIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SecurityAuditStage extends Enum<SecurityAuditStage> {
    public static final SecurityAuditStage CLOSED = null;
    public static final SecurityAuditStage SECURITY_INIT = null;
    public static final SecurityAuditStage TTNET_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecurityAuditStage[] f326271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326272b = null;
    private final int type;

    public static EnumEntries<SecurityAuditStage> getEntries() {
        return f326272b;
    }

    static {
        SecurityAuditStage r100 = new SecurityAuditStage(ErrorCode.CLOSED, 0, 0);
        CLOSED = r100;
        SecurityAuditStage r101 = new SecurityAuditStage("TTNET_INIT", 1, 1);
        TTNET_INIT = r101;
        SecurityAuditStage r102 = new SecurityAuditStage("SECURITY_INIT", 2, 2);
        SECURITY_INIT = r102;
        SecurityAuditStage[] r103 = {r100, r101, r102};
        f326271a = r103;
        f326272b = EnumEntriesKt.enumEntries(r103);
    }

    public static SecurityAuditStage[] values() {
        return (SecurityAuditStage[]) f326271a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static SecurityAuditStage valueOf(String r100) {
        return (SecurityAuditStage) a.a(SecurityAuditStage.class, r100);
    }

    public SecurityAuditStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
