package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.d3;
import com.bytedance.salamander.anniex.r3;
import com.bytedance.salamander.anniex.s3;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements CompletionBlock<jd7.a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<r3, Unit> f268554a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super r3, Unit> r100) {
        this.f268554a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        jd7.a.d r101 = (jd7.a.d) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        jd7.a.d r102 = (jd7.a.d) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function1<r3, Unit> r103 = this.f268554a;
        Boolean r104 = r102.isLogin();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        Boolean r106 = Boolean.valueOf(r105);
        Boolean r107 = r102.getHasLoggedIn();
        if (r107 == null) goto L9;
        r107.booleanValue();
    L9:
        jd7.a.b r108 = r102.getUserInfo();
        if (r108 == null) goto L12;
        String r109 = r108.getUserID();
        r108.getShortID();
        r108.getSecUserID();
        r108.getUniqueID();
        r108.getNickname();
        r108.getAvatarURL();
        r108.getHasBoundPhone();
        r108.isBoundPhone();
        r108.getBindPhone();
        d3 r110 = new d3(r109);
    L13:
        r103.invoke(new r3(1, r101, new s3(r106, r110)));
        return;
    L12:
        r110 = null;
        goto L13
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        jd7.a.d r103 = (jd7.a.d) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268554a.invoke(new r3(0, r101, null));
    }
}
