package com.ss.android.lark.chat.api.service;

import ccb.d;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.b;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface IChatService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChatChatterScene {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Condition {
        public static final int NON_DEPARTMENT = 2;
        public static final int NO_LIMIT = 1;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecallChatterSource {
        public static final int GROUP_MANAGE = 1;
        public static final int RECALL_FROM_INVITER = 2;
    }

    void Ac(String r100, UIGetDataCallback r101);

    void Dc(String r100, Iterable r101, Iterable r102, IGetDataCallback r103);

    b I0(String r100);

    void L9(String r100, String r101, IIMApiImpl.AnonymousClass1 r102);

    d M2(String r100, String r101, String r102, boolean r103);

    ImageHistoryResponse Ne(String r100, String r101, ImageHistoryResponse.Direction r102, int r103);

    void U6(String r100, IGetDataCallback<Boolean> r101);

    boolean checkLoginUserExistedInLocalChat(Chat r100);

    void f2(List<GroupRecallEntity> r100, String r101, IGetDataCallback<List<GroupRecallEntity>> r102);

    Chat getChatById(String r100);

    Chat getLocalChat(String r100);

    Chat getP2pChatByChatterId(String r100);

    void getP2pChatCreatedByChatterId(String r100, IGetDataCallback<Chat> r101);

    void h3(String r100, String r101, boolean r102, ChatNameRenderer$doTranslate$1 r103);

    void t8(String r100, int r101, int r102);

    void t9(String r100, String r101, UIGetDataCallback r102);

    void u2(List<String> r100, List<String> r101, SubscribeChatEventRequest.SubscriptionKey r102);

    void y3(String r100, ChatNameRenderer$doHideTranslate$1 r101);

    ImageHistoryResponse ze(String r100, String r101, ImageHistoryResponse.Direction r102);
}
