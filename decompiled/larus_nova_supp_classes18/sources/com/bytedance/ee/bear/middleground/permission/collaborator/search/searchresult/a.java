package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    Flowable<SearchUserResult> R1(String r1);

    Flowable<String> Z5(String r1);

    Flowable<SearchUserResult> a();

    ArrayList<UserInfo> e();

    void i(UserInfo r1);

    void l(UserInfo r1);

    void registerChangeListener(dh5.c r1);

    void unregisterChangeListener(dh5.c r1);
}
