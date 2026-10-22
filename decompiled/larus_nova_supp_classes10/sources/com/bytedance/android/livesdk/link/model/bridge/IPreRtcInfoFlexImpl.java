package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.PreRTCInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IPreRtcInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "", "", "Lcom/bytedance/android/livesdk/link/model/bridge/IPreRTCLinkUserInfoFlexImpl;", "preRtcUserInfo$delegate", "Ljava/lang/Object;", "getPreRtcUserInfo", "()Ljava/util/Map;", "preRtcUserInfo", "version$delegate", "getVersion", "()J", "version", "", "rtcJoinChannel$delegate", "getRtcJoinChannel", "()Z", "rtcJoinChannel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPreRtcInfoFlexImpl extends FlexModelBase<b2> implements b2, vh7.h {

    @SerializedName("pre_rtc_user_info")
    protected Map<Long, IPreRTCLinkUserInfoFlexImpl> _$$preRtcUserInfo;

    @SerializedName("rtc_join_channel")
    protected boolean _$$rtcJoinChannel;

    @SerializedName("version")
    protected long _$$version;

    public IPreRtcInfoFlexImpl() {
        super(b2.class);
        this._$$rtcJoinChannel = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final Map<Long, IPreRTCLinkUserInfoFlexImpl> getPreRtcUserInfo() {
        return this._$$preRtcUserInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final boolean getRtcJoinChannel() {
        return this._$$rtcJoinChannel;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final long getVersion() {
        return this._$$version;
    }

    public IPreRtcInfoFlexImpl(am3.g r14) {
        super(b2.class);
        this._$$preRtcUserInfo = new HashMap();
        setThreadSafe(false);
        long r1 = r14.c();
        int r3 = 0;
    L3:
        int r4 = r14.f();
        if (r4 == (-1)) goto L30;
        am3.g.a r8 = decodeExtensionFields(r4, r14);
        if (r4 != 1) goto L8;
        long r9 = r14.c();
        Long r5 = null;
        IPreRTCLinkUserInfoFlexImpl r10 = null;
    L15:
        int r11 = r14.f();
        if (r11 == (-1)) goto L22;
        if (r11 != 1) goto L18;
        r5 = Long.valueOf(r14.j());
        goto L15
    L18:
        if (r11 != 2) goto L19;
        r10 = new IPreRTCLinkUserInfoFlexImpl(r14);
        goto L15
    L19:
        am3.h.e(r14);
        goto L15
    L22:
        r14.d(r9);
        Map<Long, IPreRTCLinkUserInfoFlexImpl> r6 = this._$$preRtcUserInfo;
        if (r5 == null) goto L29;
        if (r10 == null) goto L27;
        r6.put(r5, r10);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r4 != 3) goto L10;
        this._$$version = r14.j();
        r3 = r3 | 1;
        goto L3
    L10:
        if (r4 != 4) goto L11;
        this._$$rtcJoinChannel = am3.h.a(r14);
        r3 = r3 | 2;
        goto L3
    L11:
        am3.h.d(r8, r14);
        goto L3
    L30:
        r14.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L57;
        this._$$rtcJoinChannel = false;
        return;
    }
}
