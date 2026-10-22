package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/u5;", "Lvh7/c;", "", "", "getAnchorUserId", "()Ljava/lang/String;", "anchorUserId", "getAnchorUserIdString", "anchorUserIdString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u5 extends vh7.c<u5> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    String getAnchorUserId();

    String getAnchorUserIdString();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkUsers();

    /* synthetic */ long getVersion();

    /* synthetic */ boolean isUseBackUp();
}
