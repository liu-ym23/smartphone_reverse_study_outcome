package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$getBadge$1;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes36.dex */
public interface h {
    Map<String, ChatChatter> A2(String r100, List<String> r101);

    void E9(String r100, List<String> r101, IGetDataCallback<Map<String, ChatChatter>> r102);

    void F5(Chatter r100);

    ChatChatter H5(String r100, String r101);

    ChatChatter He(String r100, String r101);

    Map I3(String r100, List r101);

    void L2(NewFriendBadgeRepository$getBadge$1 r100);

    void N7(String r100, IGetDataCallback<Boolean> r101);

    void W8(OfficeExternalContactViewModel.AnonymousClass1 r100);

    Map<String, Chatter> a0(List<String> r100);

    void j1(String r100, IGetDataCallback<Chatter> r101);

    Map<String, Chatter> l0(List<String> r100);

    Chatter l7(String r100);

    Map<String, ChatChatter> ld(String r100, List<String> r101);

    void pd(String r100, IGetDataCallback<Chatter> r101);

    Pair<ChatChatter, OpenApp> qb(String r100, String r101);

    Chatter ue(String r100);

    void v3(List<String> r100, IGetDataCallback<Map<String, Chatter>> r101);

    ChatChatter x1(String r100);

    Chatter zb();
}
