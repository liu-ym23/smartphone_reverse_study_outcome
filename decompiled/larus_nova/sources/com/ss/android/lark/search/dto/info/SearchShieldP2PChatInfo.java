package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R \u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchShieldP2PChatInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "setChatterType", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;)V", "chatterDescription", "Lcom/ss/android/lark/chat/entity/chatter/ChatterDescription;", "isRegistered", "", "()Z", "setRegistered", "(Z)V", "tenantId", "", "getTenantId", "()Ljava/lang/String;", "setTenantId", "(Ljava/lang/String;)V", "maiLAddress", "getMaiLAddress", "setMaiLAddress", "doNotDisturbEndTime", "", "getDoNotDisturbEndTime", "()Ljava/lang/Long;", "setDoNotDisturbEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "acceptSmsPhoneUrgent", "getAcceptSmsPhoneUrgent", "setAcceptSmsPhoneUrgent", "chatterId", "getChatterId", "setChatterId", "customStatus", "", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "getCustomStatus", "()Ljava/util/List;", "setCustomStatus", "(Ljava/util/List;)V", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchShieldP2PChatInfo extends SearchBaseInfo {
    private boolean acceptSmsPhoneUrgent;
    private final ChatterDescription chatterDescription;
    private String chatterId;
    private Chatter.ChatterType chatterType;
    private List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> customStatus;
    private Long doNotDisturbEndTime;
    private boolean isRegistered;
    private String maiLAddress;
    private String tenantId;

    public SearchShieldP2PChatInfo() {
        this.type = SearchCommonConstants.SearchResultType.SHIELD_P2P_CHAT;
        this.tenantId = "";
        this.maiLAddress = "";
        this.chatterId = "";
        this.customStatus = new ArrayList();
    }

    public final boolean getAcceptSmsPhoneUrgent() {
        return this.acceptSmsPhoneUrgent;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public final List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> getCustomStatus() {
        return this.customStatus;
    }

    public final Long getDoNotDisturbEndTime() {
        return this.doNotDisturbEndTime;
    }

    public final String getMaiLAddress() {
        return this.maiLAddress;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final boolean isRegistered() {
        return this.isRegistered;
    }

    public final void setAcceptSmsPhoneUrgent(boolean r100) {
        this.acceptSmsPhoneUrgent = r100;
    }

    public final void setChatterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chatterId = r100;
    }

    public final void setChatterType(Chatter.ChatterType r100) {
        this.chatterType = r100;
    }

    public final void setCustomStatus(List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customStatus = r100;
    }

    public final void setDoNotDisturbEndTime(Long r100) {
        this.doNotDisturbEndTime = r100;
    }

    public final void setMaiLAddress(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.maiLAddress = r100;
    }

    public final void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public final void setTenantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tenantId = r100;
    }
}
