package com.ss.lark.android.avatar.ui;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.pb.users.UserUpdatePermissionInfo;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface u extends IModel {
    void H7(IGetDataCallback<String> r100);

    void I1(Context r100, String r101, IGetDataCallback<String> r102);

    void S4(AvatarSource r100, IGetDataCallback<List<UserUpdatePermissionInfo>> r101);

    void z3(Context r100, String r101, IGetDataCallback<String> r102);
}
