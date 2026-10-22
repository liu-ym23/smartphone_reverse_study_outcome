package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class u implements x38.g<FlowAccountThirdPartyAuthCore.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<t.b> f565898a;

    public u(CompletionBlock<t.b> r100) {
        this.f565898a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r110) {
        Intrinsics.checkNotNullParameter(r110, "error");
        if (r110.f562387a != FlowAccountThirdPartyAuthCore.Error.UNSUPPORTED_PLATFORM.getCode()) goto L9;
        CompletionBlock<t.b> r100 = this.f565898a;
        String r101 = r110.f562388b;
        if (r101 != null) goto L7;
        String r102 = "";
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r100, -3, r102, null, 4, null);
        return;
    L7:
        r102 = r101;
        goto L8
    L9:
        CompletionBlock<t.b> r111 = this.f565898a;
        String r103 = r110.f562388b;
        if (r103 != null) goto L12;
        String r112 = "";
    L13:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, r112, null, 4, null);
        return;
    L12:
        r112 = r103;
        goto L13
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountThirdPartyAuthCore.a r100) {
        FlowAccountThirdPartyAuthCore.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        CompletionBlock<t.b> r102 = this.f565898a;
        XBaseModel r103 = ne7.e.b(t.b.class);
        t.b r104 = (t.b) r103;
        r104.setCode(r101.f286353c);
        r104.setPlatform(r101.f286351a);
        r104.setPlatformAppId(r101.f286352b);
        r104.setOpenId(r101.f286354d);
        r104.setAccessToken(r101.f286355e);
        r104.setAccessTokenSecret(r101.f286356f);
        r104.setExpiresIn(r101.f286357g);
        r104.setErrorCode(r101.f286358h);
        r104.setRawData(r101.f286359i);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
    }
}
