package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lvh7/c;", "", "", "getAnchorIdString", "()Ljava/lang/String;", "anchorIdString", "", "getMVersion", "()J", "mVersion", "getLiveRoomMode", "liveRoomMode", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g2 extends vh7.c<g2> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    String getAnchorIdString();

    /* synthetic */ List<k> getLinkedUsers();

    long getLiveRoomMode();

    long getMVersion();

    /* synthetic */ int getRoomLinkSilenceStatus();

    /* synthetic */ long getVersion();

    /* synthetic */ long isGuestAnchorBackground();
}
