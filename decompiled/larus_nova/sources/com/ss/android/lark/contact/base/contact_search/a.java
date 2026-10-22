package com.ss.android.lark.contact.base.contact_search;

import com.bytedance.lark.pb.contact.v1.SendUserInvitationResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.IModel;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends IModel {
    void w4(String r100, boolean r101, IGetDataCallback<SendUserInvitationResponse> r102);

    <T> void x3(String r100, IGetDataCallback<T> r101);
}
