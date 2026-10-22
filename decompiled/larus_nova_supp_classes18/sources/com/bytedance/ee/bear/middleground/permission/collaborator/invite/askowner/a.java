package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    void V(UserInfo r1);

    ArrayList<UserInfo> getUsers();

    Flowable<AskOwnerHelper.AskOwnerSendResult> z0(String r1);
}
