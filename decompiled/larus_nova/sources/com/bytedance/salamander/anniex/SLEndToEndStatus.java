package com.bytedance.salamander.anniex;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEndToEndStatus;", "", "", "value", "I", "getValue", "()I", "Success", CheckStatus.FAIL, "Cancel", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLEndToEndStatus extends Enum<SLEndToEndStatus> {
    public static final SLEndToEndStatus Cancel = null;
    public static final SLEndToEndStatus Fail = null;
    public static final SLEndToEndStatus Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLEndToEndStatus[] f267910a = null;
    private final int value;

    public static SLEndToEndStatus valueOf(String r100) {
        return (SLEndToEndStatus) r27.a.a(SLEndToEndStatus.class, r100);
    }

    public static SLEndToEndStatus[] values() {
        return (SLEndToEndStatus[]) f267910a.clone();
    }

    static {
        SLEndToEndStatus r100 = new SLEndToEndStatus("Success", 0, 0);
        Success = r100;
        SLEndToEndStatus r101 = new SLEndToEndStatus(CheckStatus.FAIL, 1, 1);
        Fail = r101;
        SLEndToEndStatus r102 = new SLEndToEndStatus("Cancel", 2, 2);
        Cancel = r102;
        f267910a = new SLEndToEndStatus[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public SLEndToEndStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
