package com.bytedance.kmp.livesdk.gift.platform.aio.service.client;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/service/client/OperationResultCode;", "", "", "value", "I", "getValue", "()I", "Success", "KeyIsEmpty", "ListIsEmpty", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OperationResultCode extends Enum<OperationResultCode> {
    public static final OperationResultCode KeyIsEmpty = null;
    public static final OperationResultCode ListIsEmpty = null;
    public static final OperationResultCode Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationResultCode[] f252245a = null;
    private final int value;

    static {
        OperationResultCode r100 = new OperationResultCode("Success", 0, 0);
        Success = r100;
        OperationResultCode r101 = new OperationResultCode("KeyIsEmpty", 1, -1);
        KeyIsEmpty = r101;
        OperationResultCode r102 = new OperationResultCode("ListIsEmpty", 2, -2);
        ListIsEmpty = r102;
        f252245a = new OperationResultCode[]{r100, r101, r102};
    }

    public static OperationResultCode valueOf(String r100) {
        return (OperationResultCode) a.a(OperationResultCode.class, r100);
    }

    public static OperationResultCode[] values() {
        return (OperationResultCode[]) f252245a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OperationResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
