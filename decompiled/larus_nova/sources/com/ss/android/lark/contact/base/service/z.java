package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$acceptFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$applyFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$blockUser$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$deleteFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$updateChatApplicationMeRead$2$1;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface z {
    void a(String r100, OfficeProfileModel$acceptFriend$2$1 r101);

    void b(String r100, String r101, String r102, ContactSource r103, OfficeProfileModel$applyFriend$2$1 r104);

    void c(String r100, OfficeProfileModel$deleteFriend$2$1 r101);

    void d(List r100, OfficeProfileModel$updateChatApplicationMeRead$2$1 r101);

    void e(String r100, boolean r101, OfficeProfileModel$blockUser$2$1 r102);

    void f(long r100, GetMyGroupChatsRequest.Type r101, OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1 r102);

    void g(long r100, IGetDataCallback r101);

    void h(long r100, IGetDataCallback r101);

    void i(IGetDataCallback r100);
}
