package com.ss.android.lark.officesdk.integrator.im.impl;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements pmb.c {
    @Inject
    public c() {
    }

    @Override // pmb.c
    public final void pickGroupMember(Activity r100, String r110, List<String> r111, boolean r112, String r113, IGetDataCallback<List<ChatChatter>> r114) {
        IIMApi r101 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r101 == null) goto L6;
        r101.pickGroupMember(r100, r110, r111, r112, r113, r114);
        return;
    }

    @Override // pmb.c
    public final void pickTargetMember(Activity r100, List<String> r110, List<String> r111, boolean r112, String r113, IGetDataCallback<List<ChatChatter>> r114) {
        IIMApi r101 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r101 == null) goto L6;
        r101.pickTargetMember(r100, r110, r111, r112, r113, r114);
        return;
    }
}
