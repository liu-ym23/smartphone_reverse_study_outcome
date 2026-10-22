package com.bytedance.awemeopen.bizmodels.share;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/share/ShareResult;", "", "Success", CheckStatus.FAIL, "Cancel", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum ShareResult extends Enum<ShareResult> {
    public static final ShareResult Cancel = null;
    public static final ShareResult Fail = null;
    public static final ShareResult Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareResult[] f198213a = null;

    public static ShareResult valueOf(String r100) {
        return (ShareResult) a.a(ShareResult.class, r100);
    }

    public static ShareResult[] values() {
        return (ShareResult[]) f198213a.clone();
    }

    static {
        ShareResult r100 = new ShareResult("Success", 0);
        Success = r100;
        ShareResult r101 = new ShareResult(CheckStatus.FAIL, 1);
        Fail = r101;
        ShareResult r102 = new ShareResult("Cancel", 2);
        Cancel = r102;
        f198213a = new ShareResult[]{r100, r101, r102};
    }

    public ShareResult(String r100, int r101) {
        super(r100, r101);
    }
}
