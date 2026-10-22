package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes20.dex */
@ProtoMessage("webcast.api.ktv.ReportMidiScoreResponse.UserInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR/\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/IReportMidiScoreResponseUserInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/livesdk/ktvcommon/api/c;", "", "<set-?>", "uidString$delegate", "Ljava/lang/Object;", "getUidString", "()Ljava/lang/String;", "setUidString", "(Ljava/lang/String;)V", "uidString", "secUid$delegate", "getSecUid", "setSecUid", "secUid", "nickName$delegate", "getNickName", "setNickName", "nickName", "Lpy/k;", "avatar$delegate", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "avatar", "openId$delegate", "getOpenId", "setOpenId", "openId", "", "uid$delegate", "getUid", "()Ljava/lang/Long;", "setUid", "(Ljava/lang/Long;)V", "uid", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IReportMidiScoreResponseUserInfoFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("avatar")
    protected k _$$avatar;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String _$$nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$openId;

    @SerializedName("sec_uid")
    protected String _$$secUid;

    @SerializedName("uid")
    protected Long _$$uid;

    @SerializedName("uid_str")
    protected String _$$uidString;

    public IReportMidiScoreResponseUserInfoFlexImpl() {
        super(c.class);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final k getAvatar() {
        return this._$$avatar;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final String getNickName() {
        return this._$$nickName;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final String getOpenId() {
        return this._$$openId;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final String getSecUid() {
        return this._$$secUid;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final Long getUid() {
        return this._$$uid;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final String getUidString() {
        return this._$$uidString;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IReportMidiScoreResponseUserInfoFlexImpl(am3.g r100) {
        super(c.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$uid = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$nickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$avatar = vh7.f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$uidString = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$secUid = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._$$openId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setAvatar(k r100) {
        this._$$avatar = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setNickName(String r100) {
        this._$$nickName = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setOpenId(String r100) {
        this._$$openId = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setSecUid(String r100) {
        this._$$secUid = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setUid(Long r100) {
        this._$$uid = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.c
    public final void setUidString(String r100) {
        this._$$uidString = r100;
    }
}
