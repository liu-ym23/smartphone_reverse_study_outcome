package com.bytedance.salamander.anniex;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidateResultCode;", "", "", "value", "J", "getValue", "()J", "Success", CheckStatus.FAIL, "Invalid_input", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ValidateResultCode extends Enum<ValidateResultCode> {
    public static final ValidateResultCode Fail = null;
    public static final ValidateResultCode Invalid_input = null;
    public static final ValidateResultCode Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValidateResultCode[] f267926a = null;
    private final long value;

    public static ValidateResultCode valueOf(String r100) {
        return (ValidateResultCode) r27.a.a(ValidateResultCode.class, r100);
    }

    public static ValidateResultCode[] values() {
        return (ValidateResultCode[]) f267926a.clone();
    }

    static {
        ValidateResultCode r100 = new ValidateResultCode("Success", 0, 1);
        Success = r100;
        ValidateResultCode r101 = new ValidateResultCode(CheckStatus.FAIL, 1, -1);
        Fail = r101;
        ValidateResultCode r102 = new ValidateResultCode("Invalid_input", 2, -3);
        Invalid_input = r102;
        f267926a = new ValidateResultCode[]{r100, r101, r102};
    }

    public final long getValue() {
        return this.value;
    }

    public ValidateResultCode(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
