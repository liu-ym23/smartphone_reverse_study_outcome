package com.bytedance.awemeopen.share.serviceapi;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/share/serviceapi/AoShareResult;", "", "Success", CheckStatus.FAIL, "Cancel", "ao_share_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum AoShareResult extends Enum<AoShareResult> {
    public static final AoShareResult Cancel = null;
    public static final AoShareResult Fail = null;
    public static final AoShareResult Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AoShareResult[] f199009a = null;

    public static AoShareResult valueOf(String r100) {
        return (AoShareResult) a.a(AoShareResult.class, r100);
    }

    public static AoShareResult[] values() {
        return (AoShareResult[]) f199009a.clone();
    }

    static {
        AoShareResult r100 = new AoShareResult("Success", 0);
        Success = r100;
        AoShareResult r101 = new AoShareResult(CheckStatus.FAIL, 1);
        Fail = r101;
        AoShareResult r102 = new AoShareResult("Cancel", 2);
        Cancel = r102;
        f199009a = new AoShareResult[]{r100, r101, r102};
    }

    public AoShareResult(String r100, int r101) {
        super(r100, r101);
    }
}
