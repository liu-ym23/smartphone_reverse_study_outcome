package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerReplyContent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010h\u001a\u00020\u0002¢\u0006\u0004\bi\u0010jJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\rR\"\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000202\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0013R\u0014\u00109\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\rR\u0014\u0010;\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010-R\u0014\u0010=\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\rR\u0014\u0010A\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR4\u0010M\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0013R\u0016\u0010Q\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\rR\u0016\u0010U\u001a\u0004\u0018\u00010R8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR(\u0010_\u001a\u0004\u0018\u00010Z2\b\u0010H\u001a\u0004\u0018\u00010Z8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010a\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\rR\u0014\u0010c\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010-R\u0014\u0010e\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010-R\u0016\u0010g\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\r¨\u0006k"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerReplyContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerReplyContent;", "Lcom/bytedance/android/livesdk/link/model/k6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFromUid", "()Ljava/lang/String;", "fromUid", "getToUid", "toUid", "", "getFromRoomId", "()J", "fromRoomId", "Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkmicInfo", "()Lcom/bytedance/android/livesdk/link/model/j5;", "fromLinkmicInfo", "getToLinkmicInfo", "toLinkmicInfo", "getLinkType", "linkType", "getReplyStatus", "replyStatus", "Lcom/bytedance/android/livesdk/link/model/m6;", "getLinkerSetting", "()Lcom/bytedance/android/livesdk/link/model/m6;", "linkerSetting", "", "getBizJoinChannel", "()Z", "bizJoinChannel", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "", "getMultiPkMode", "()I", "multiPkMode", "getToast", "toast", "", "Lcom/bytedance/android/livesdk/link/model/b9;", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "getMatchType", "matchType", "getKickedUsersniqueId", "kickedUsersniqueId", "getSwitchToScene", "switchToScene", "getBattleConfigSettingStr", "battleConfigSettingStr", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getReplyVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "replyVersionInfo", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "layoutInfo", "", "Lcom/bytedance/android/livesdk/link/model/p;", "value", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "linkUsers", "getVersion", "version", "getClientAttachedInfoStr", "clientAttachedInfoStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "preRtcInfo", "getBattleAttachedInfoStr", "battleAttachedInfoStr", "getToBizType", "toBizType", "getBizType", "bizType", "getEventTrackingInfo", "eventTrackingInfo", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerReplyContent;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerReplyContentExtensionImpl extends ModelExtensionBase<ILinkerReplyContent, k6> implements k6, ILinkerReplyContent {
    private final /* synthetic */ ILinkerReplyContent $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.k6
    public <R extends vh7.e<ILinkerReplyContent>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public <R extends vh7.e<ILinkerReplyContent>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public j5 getFromLinkmicInfo() {
        return (j5) get(3, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public j5 getToLinkmicInfo() {
        return (j5) get(5, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getBattleAttachedInfoStr() {
        return (String) get(28, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getBattleConfigSettingStr() {
        return (String) get(21, k6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public boolean getBizJoinChannel() {
        return ((Boolean) get(9, k6.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public int getBizType() {
        return ((Number) get(30, k6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getClientAttachedInfoStr() {
        return (String) get(22, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getEventTrackingInfo() {
        return (String) get(32, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public long getFromRoomId() {
        return ((Number) get(2, k6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getFromUid() {
        return (String) get(5000, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getKickedUsersniqueId() {
        return (String) get(15, k6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public m getLayoutInfo() {
        return (m) get(24, k6.class, m.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public long getLinkType() {
        return ((Number) get(6, k6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public List<p> getLinkUsers() {
        return (List) get(19, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public Map<Long, b9> getLinkerContentMap() {
        return (Map) get(13, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public m6 getLinkerSetting() {
        return (m6) get(8, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public long getMatchType() {
        return ((Number) get(16, k6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public b7 getMultiChannelInfo() {
        return (b7) get(11, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(26, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public int getMultiPkMode() {
        return ((Number) get(10, k6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(25, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(27, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public long getReplyStatus() {
        return ((Number) get(7, k6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public com.bytedance.android.livesdk.link.model.bridge.k2 getReplyVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(23, k6.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public int getSwitchToScene() {
        return ((Number) get(20, k6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public int getToBizType() {
        return ((Number) get(29, k6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getToUid() {
        return (String) get(5001, k6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public String getToast() {
        return (String) get(12, k6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public long getVersion() {
        return ((Number) get(17, k6.class, 0L)).longValue();
    }

    public ILinkerReplyContentExtensionImpl(ILinkerReplyContent r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public void setLinkUsers(List<? extends p> r4) {
        set(19, "linked_users", k6.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.k6
    public void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r4) {
        set(27, "pre_rtc_info", k6.class, r4);
    }
}
