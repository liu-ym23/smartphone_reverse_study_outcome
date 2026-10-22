package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010s\u001a\u00020\u0002¢\u0006\u0004\bt\u0010uJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001R\u001c\u0010\u0014\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010)\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010+\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010&R \u0010.\u001a\u00060,j\u0002`-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00103\u001a\u0002028\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010;\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010=\u001a\u00060,j\u0002`-8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b<\u0010/R\u001e\u0010@\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b>\u0010&\"\u0004\b?\u0010(R\u001e\u0010C\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001c\u0010F\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010\u0013R\u001e\u0010L\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010R\u001a\u0004\u0018\u00010M8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010U\u001a\u00060,j\u0002`-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bS\u0010/\"\u0004\bT\u00101R\u001e\u0010[\u001a\u0004\u0018\u00010V8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010^\u001a\u00060,j\u0002`-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\\\u0010/\"\u0004\b]\u00101R\u001c\u0010a\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b_\u0010\u0011\"\u0004\b`\u0010\u0013R\u001c\u0010d\u001a\u0002028\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bb\u00104\"\u0004\bc\u00106R\u001c\u0010g\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\be\u0010\u0011\"\u0004\bf\u0010\u0013R\u001c\u0010j\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bh\u0010\u0011\"\u0004\bi\u0010\u0013R$\u0010o\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`k8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bl\u0010\u0017\"\u0004\bm\u0010nR\u001c\u0010r\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bp\u0010\u0011\"\u0004\bq\u0010\u0013¨\u0006v"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/android/livesdk/link/model/p;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getAnchorAuthRole", "getPkRole", "", "toSimpleString", "getApplyType", "()I", "setApplyType", "(I)V", "applyType", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getBaseUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "baseUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "cityEffect", "Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "getContent", "()Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "setContent", "(Lcom/bytedance/android/livesdk/link/model/bridge/k1;)V", "content", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "extra", "getInteractId", "interactId", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "isBackground", "()J", "setBackground", "(J)V", "", "isJoinUser", "()Z", "setJoinUser", "(Z)V", "getKSongUid", "()Ljava/lang/Long;", "setKSongUid", "(Ljava/lang/Long;)V", "kSongUid", "getLinkMicId", "linkMicId", "getLinkMicIdStr", "setLinkMicIdStr", "linkMicIdStr", "getLinkMicUniqueIdStr", "setLinkMicUniqueIdStr", "linkMicUniqueIdStr", "getLinkType", "setLinkType", "linkType", "Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "getListUserExtra", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "setListUserExtra", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/c;)V", "listUserExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "matchEffect", "getMcStatus", "setMcStatus", "mcStatus", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "micPosTagInfo", "getModifyTime", "setModifyTime", "modifyTime", "getRoleType", "setRoleType", "roleType", "getShowCityEffect", "setShowCityEffect", "showCityEffect", "getSilenceStatus", "setSilenceStatus", "silenceStatus", "getStatus", "setStatus", "status", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "getUserPosition", "setUserPosition", "userPosition", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/k;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorLinkUserExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.k, p> implements p, com.bytedance.android.livesdk.link.model.bridge.k {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.k $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.k>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.k>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getAnchorAuthRole() {
        return this.$$delegate_0.getAnchorAuthRole();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getApplyType() {
        return this.$$delegate_0.getApplyType();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public IBaseUser getBaseUser() {
        return this.$$delegate_0.getBaseUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public ICityEffect getCityEffect() {
        return this.$$delegate_0.getCityEffect();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public com.bytedance.android.livesdk.link.model.bridge.k1 getContent() {
        return this.$$delegate_0.getContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public String getExtra() {
        return this.$$delegate_0.getExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public String getInteractId() {
        return this.$$delegate_0.getInteractId();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public Long getKSongUid() {
        return this.$$delegate_0.getKSongUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public long getLinkMicId() {
        return this.$$delegate_0.getLinkMicId();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public String getLinkMicIdStr() {
        return this.$$delegate_0.getLinkMicIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public String getLinkMicUniqueIdStr() {
        return this.$$delegate_0.getLinkMicUniqueIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getLinkType() {
        return this.$$delegate_0.getLinkType();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public com.bytedance.android.live.liveinteract.multianchor.model.c getListUserExtra() {
        return this.$$delegate_0.getListUserExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public IMatchEffect getMatchEffect() {
        return this.$$delegate_0.getMatchEffect();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public long getMcStatus() {
        return this.$$delegate_0.getMcStatus();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public com.bytedance.android.live.liveinteract.plantform.model.g0 getMicPosTagInfo() {
        return this.$$delegate_0.getMicPosTagInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public long getModifyTime() {
        return this.$$delegate_0.getModifyTime();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getPkRole() {
        return this.$$delegate_0.getPkRole();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getRoleType() {
        return this.$$delegate_0.getRoleType();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public boolean getShowCityEffect() {
        return this.$$delegate_0.getShowCityEffect();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getSilenceStatus() {
        return this.$$delegate_0.getSilenceStatus();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getStatus() {
        return this.$$delegate_0.getStatus();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public IBaseUser getUser() {
        return this.$$delegate_0.getUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public int getUserPosition() {
        return this.$$delegate_0.getUserPosition();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public long isBackground() {
        return this.$$delegate_0.isBackground();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public boolean isJoinUser() {
        return this.$$delegate_0.isJoinUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setApplyType(int r2) {
        this.$$delegate_0.setApplyType(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setBackground(long r2) {
        this.$$delegate_0.setBackground(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setCityEffect(ICityEffect r2) {
        this.$$delegate_0.setCityEffect(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setContent(com.bytedance.android.livesdk.link.model.bridge.k1 r2) {
        this.$$delegate_0.setContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setExtra(String r2) {
        this.$$delegate_0.setExtra(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setJoinUser(boolean r2) {
        this.$$delegate_0.setJoinUser(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setKSongUid(Long r2) {
        this.$$delegate_0.setKSongUid(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setLinkMicIdStr(String r2) {
        this.$$delegate_0.setLinkMicIdStr(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setLinkMicUniqueIdStr(String r2) {
        this.$$delegate_0.setLinkMicUniqueIdStr(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setLinkType(int r2) {
        this.$$delegate_0.setLinkType(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setListUserExtra(com.bytedance.android.live.liveinteract.multianchor.model.c r2) {
        this.$$delegate_0.setListUserExtra(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setMatchEffect(IMatchEffect r2) {
        this.$$delegate_0.setMatchEffect(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setMcStatus(long r2) {
        this.$$delegate_0.setMcStatus(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setMicPosTagInfo(com.bytedance.android.live.liveinteract.plantform.model.g0 r2) {
        this.$$delegate_0.setMicPosTagInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setModifyTime(long r2) {
        this.$$delegate_0.setModifyTime(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setRoleType(int r2) {
        this.$$delegate_0.setRoleType(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setShowCityEffect(boolean r2) {
        this.$$delegate_0.setShowCityEffect(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setSilenceStatus(int r2) {
        this.$$delegate_0.setSilenceStatus(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setStatus(int r2) {
        this.$$delegate_0.setStatus(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setUser(IBaseUser r2) {
        this.$$delegate_0.setUser(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public void setUserPosition(int r2) {
        this.$$delegate_0.setUserPosition(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.p, com.bytedance.android.livesdk.link.model.bridge.k
    public String toSimpleString() {
        return this.$$delegate_0.toSimpleString();
    }

    public IAnchorLinkUserExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.k r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
