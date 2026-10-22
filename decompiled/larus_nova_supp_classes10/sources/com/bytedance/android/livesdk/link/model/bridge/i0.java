package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/i0;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getICityEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getIMatchEffect", "", "isPaidLinkmic", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i0 extends vh7.c<i0> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ int getApplyType();

    ClientUIInfo getClientUIInfo();

    ICityEffect getICityEffect();

    IMatchEffect getIMatchEffect();

    /* synthetic */ List<k> getLinkedUsers();

    /* synthetic */ String getToken();

    /* synthetic */ long getVersion();

    boolean isPaidLinkmic();

    /* synthetic */ void setLinkedUsers(List<? extends k> r1);

    /* synthetic */ void setToken(String r1);
}
