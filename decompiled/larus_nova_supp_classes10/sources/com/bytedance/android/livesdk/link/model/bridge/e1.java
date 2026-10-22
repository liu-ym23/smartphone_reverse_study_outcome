package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdk.message.model.ec;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/e1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "", "Lcom/bytedance/android/livesdk/message/model/ec;", "getUserContributeList", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "quickInteract", "", "getUserIdStr", "()Ljava/lang/String;", "userIdStr", "", "getResetVersion", "()J", "resetVersion", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e1 extends vh7.c<e1>, com.bytedance.android.live.base.model.message.t {
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ boolean currUserIsAnchor();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    com.bytedance.android.live.liveinteract.plantform.model.l getQuickInteract();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    long getResetVersion();

    /* synthetic */ long getRoomId();

    /* synthetic */ long getTimestamp();

    /* synthetic */ long getTotalScore();

    /* synthetic */ String getTotalScoreRealStr();

    /* synthetic */ String getTotalScoreStr();

    List<ec> getUserContributeList();

    String getUserIdStr();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isCurrentRoom(long r1);

    /* synthetic */ boolean isFirstHistoryMessage();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isFromOtherIntercomRoom();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isInsert();

    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFirstHistoryMessage(boolean r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setLocalInsertMsg(boolean r1);

    /* synthetic */ void setMessageMethod(String r1);

    void setQuickInteract(com.bytedance.android.live.liveinteract.plantform.model.l r1);

    /* synthetic */ void setReceiveTime(long r1);

    /* synthetic */ void setTooMuchMsg(boolean r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    /* synthetic */ boolean supportDisplayText();
}
