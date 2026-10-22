package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.SetAccessTokenOnlyRequest;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends com.bytedance.ee.bear.contract.c {
    public final /* synthetic */ l b;

    public k(l r1) {
        this.b = r1;
    }

    public final void b(AccountService.Account r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.hasLogin() == false) goto L11;
        this.b.getClass();
        if (eu5.g.j() == true) goto L12;
        SetAccessTokenOnlyRequest.Builder r0 = new SetAccessTokenOnlyRequest.Builder();
        r0.access_token(r5.token);
        r0.user_id(r5.uid);
        SdkSender.asynSendRequestNonWrap(Command.SET_ACCESS_TOKEN_ONLY, r0, null, new a());
        tt5.a.h("BaseRustServiceImp", "setAccessTokenOnlyRequest by account... ok, uid=" + r5.uid + " token is empty=" + TextUtils.isEmpty(r5.token));
        return;
    L12:
        return;
    }
}
