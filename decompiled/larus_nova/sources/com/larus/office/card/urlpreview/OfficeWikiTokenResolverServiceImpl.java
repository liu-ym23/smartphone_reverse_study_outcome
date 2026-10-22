package com.larus.office.card.urlpreview;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.im.FlowRuntime;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.IFlowOfficeWikiTokenResolver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeWikiTokenResolverServiceImpl;", "Lcom/larus/platform/api/IFlowOfficeWikiTokenResolver;", "<init>", "()V", "resolveObjectToken", "", WikiFolderPushPlugin.WIKI_TOKEN, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeWikiTokenResolverServiceImpl implements IFlowOfficeWikiTokenResolver {
    public OfficeWikiTokenResolverServiceImpl() {
    }

    @Override // com.larus.platform.api.IFlowOfficeWikiTokenResolver
    public final Object a(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1) == false) goto L7;
        OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1 r100 = (OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L20:
        dm9.a r113 = (dm9.a) r112;
        if ((r113 instanceof dm9.a.b) == false) goto L23;
        dm9.a.b r114 = (dm9.a.b) r113;
    L24:
        if (r114 == null) goto L41;
        BizResponse<T> r115 = r114.f469231a;
        if (r115 == 0) goto L45;
        m2 r116 = (m2) r115.getData();
        if (r115.getCode() != 0) goto L42;
        if (r116 == null) goto L32;
        boolean r117 = Intrinsics.areEqual(r116.b(), Boxing.boxBoolean(true));
    L33:
        if (r117 == false) goto L46;
        String r118 = r116.a();
        if (r118 != null) goto L38;
        return null;
    L38:
        if ((!StringsKt.isBlank(r118)) == true) goto L40;
        return null;
    L40:
        return r118;
    L46:
        return null;
    L32:
        r117 = false;
        goto L33
    L42:
        return null;
    L45:
        return null;
    L41:
        return null;
    L23:
        r114 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (StringsKt.isBlank(r110) == false) goto L17;
        return null;
    L17:
        WikiObjectApi.a r119 = WikiObjectApi.f361819a;
        OfficeWikiTokenResolverServiceImpl$resolveObjectToken$result$1 r105 = new OfficeWikiTokenResolverServiceImpl$resolveObjectToken$result$1(r110, null);
        r102.label = 1;
        r119.getClass();
        FlowHttpConnection r120 = FlowHttpConnection.f359975a;
        FlowRuntime.a().isOversea();
        r112 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, WikiObjectApi.class, r105, false, null, "https://www.feishu.cn", null, r102, 184);
        if (r112 != r103) goto L20;
        return r103;
    L7:
        r100 = new OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1(this, r111);
        goto L8
    }
}
