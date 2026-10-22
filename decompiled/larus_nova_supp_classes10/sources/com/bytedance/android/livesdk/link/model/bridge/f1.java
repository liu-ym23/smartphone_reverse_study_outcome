package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u001b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001b\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "Lvh7/c;", "", "", "getUserIdString", "()Ljava/lang/String;", "setUserIdString", "(Ljava/lang/String;)V", "userIdString", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "cityEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "matchEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "setMessageBoardInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;)V", "getMessageBoardInfo$annotations", "()V", "messageBoardInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getPreOnlineUsers", "()Ljava/util/List;", "setPreOnlineUsers", "(Ljava/util/List;)V", "getPreOnlineUsers$annotations", "preOnlineUsers", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo$annotations", "clientUiInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f1 extends vh7.c<f1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ int getApplyType();

    ICityEffect getCityEffect();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    /* synthetic */ List<k> getLinkUsers();

    /* synthetic */ Map<Long, g2> getLinkerContentMap();

    IMatchEffect getMatchEffect();

    @FieldName(name = "msg_board_item")
    IMessageBoardInfo getMessageBoardInfo();

    @FieldName(name = "pre_link_users")
    List<k> getPreOnlineUsers();

    String getUserIdString();

    /* synthetic */ long getVersion();

    /* synthetic */ void setApplyType(int r1);

    void setCityEffect(ICityEffect r1);

    /* synthetic */ void setLinkUsers(List<? extends k> r1);

    /* synthetic */ void setLinkerContentMap(Map<Long, ? extends g2> r1);

    void setMatchEffect(IMatchEffect r1);

    @FieldName(name = "msg_board_item#setter")
    void setMessageBoardInfo(IMessageBoardInfo r1);

    @FieldName(name = "pre_link_users#setter")
    void setPreOnlineUsers(List<? extends k> r1);

    void setUserIdString(String r1);

    /* synthetic */ void setVersion(long r1);
}
