package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface h {
    void Da(Context r100, GroupCreateInfo r101, List<? extends SearchBaseInfo> r102, IGetDataCallback<Chat> r103, CreateGroupScene r104, IGetDataCallback<w5b.a> r105, Fragment r106, hab.b r107);
}
