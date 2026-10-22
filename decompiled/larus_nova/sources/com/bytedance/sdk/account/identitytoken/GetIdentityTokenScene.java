package com.bytedance.sdk.account.identitytoken;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/account/identitytoken/GetIdentityTokenScene;", "", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "PRELOAD", EffectConstants.NORMAL, "RETRY", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
public final enum GetIdentityTokenScene extends Enum<GetIdentityTokenScene> {
    public static final GetIdentityTokenScene NORMAL = null;
    public static final GetIdentityTokenScene PRELOAD = null;
    public static final GetIdentityTokenScene RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetIdentityTokenScene[] f268894a = null;
    private final String label;

    static {
        GetIdentityTokenScene r100 = new GetIdentityTokenScene("PRELOAD", 0, "preload");
        PRELOAD = r100;
        GetIdentityTokenScene r101 = new GetIdentityTokenScene(EffectConstants.NORMAL, 1, "normal");
        NORMAL = r101;
        GetIdentityTokenScene r102 = new GetIdentityTokenScene("RETRY", 2, EventConstant.Value.RETRY);
        RETRY = r102;
        f268894a = new GetIdentityTokenScene[]{r100, r101, r102};
    }

    public static GetIdentityTokenScene valueOf(String r100) {
        return (GetIdentityTokenScene) r27.a.a(GetIdentityTokenScene.class, r100);
    }

    public static GetIdentityTokenScene[] values() {
        return (GetIdentityTokenScene[]) f268894a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public GetIdentityTokenScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.label = r102;
    }
}
