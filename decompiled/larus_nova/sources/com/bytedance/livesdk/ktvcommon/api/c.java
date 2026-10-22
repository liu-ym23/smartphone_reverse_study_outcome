package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes20.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R*\u0010\u0019\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006R$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/c;", "Lvh7/c;", "", "getUidString", "()Ljava/lang/String;", "setUidString", "(Ljava/lang/String;)V", "getUidString$annotations", "()V", "uidString", "getSecUid", "setSecUid", "getSecUid$annotations", "secUid", "getNickName", "setNickName", "getNickName$annotations", "nickName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "getAvatar$annotations", "avatar", "getOpenId", "setOpenId", "getOpenId$annotations", "openId", "", "getUid", "()Ljava/lang/Long;", "setUid", "(Ljava/lang/Long;)V", "getUid$annotations", "uid", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar")
    k getAvatar();

    @FieldName(name = InstantPlayContext.NICKNAME)
    String getNickName();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getOpenId();

    @FieldName(name = "sec_uid")
    String getSecUid();

    @FieldName(name = "uid")
    Long getUid();

    @FieldName(name = "uid_str")
    String getUidString();

    @FieldName(name = "avatar#setter")
    void setAvatar(k r100);

    @FieldName(name = "nickname#setter")
    void setNickName(String r100);

    @FieldName(name = "open_id#setter")
    void setOpenId(String r100);

    @FieldName(name = "sec_uid#setter")
    void setSecUid(String r100);

    @FieldName(name = "uid#setter")
    void setUid(Long r100);

    @FieldName(name = "uid_str#setter")
    void setUidString(String r100);
}
