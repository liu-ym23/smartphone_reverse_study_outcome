package com.ss.android.lark.mention.base.impl.atselector;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public interface d extends IModel {

    public interface a {
    }

    void N2(String r100, String r101, IGetDataCallback<ccb.d> r102);

    Map<String, ChatChatter> N4();

    boolean T0();

    void U0(String r100, List<BaseAtBean> r101);

    void U7(IGetDataCallback<List<BaseAtBean>> r100);

    Map<String, BaseAtBean> b3();

    void d1(Map<String, ChatterSensitiveInfo> r100, List<BaseAtBean> r101);

    String e5();

    List<UserGroupEntity> g2();

    void m2(List r100, String r101, IGetDataCallback r102);

    List<BaseAtBean> q3();

    void z1(String r100, String r101, IGetDataCallback<ccb.d> r102);
}
