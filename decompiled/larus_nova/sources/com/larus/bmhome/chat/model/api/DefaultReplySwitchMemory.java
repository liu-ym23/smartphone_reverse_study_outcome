package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMemory;", "", "modeId", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "reasoningEffort", "", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/lang/Integer;)V", "getModeId", "()Ljava/lang/String;", "getModel", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "getReasoningEffort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMemory;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplySwitchMemory {

    @SerializedName("mode_id")
    private final String modeId;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final DefaultReplyModelItemIndex model;

    @SerializedName("reasoning_effort")
    private final Integer reasoningEffort;

    public DefaultReplySwitchMemory() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DefaultReplySwitchMemory copy$default(DefaultReplySwitchMemory r100, String r101, DefaultReplyModelItemIndex r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.modeId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.model;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.reasoningEffort;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.modeId;
    }

    public final DefaultReplyModelItemIndex component2() {
        return this.model;
    }

    public final Integer component3() {
        return this.reasoningEffort;
    }

    public final DefaultReplySwitchMemory copy(String r100, DefaultReplyModelItemIndex r101, Integer r102) {
        return new DefaultReplySwitchMemory(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplySwitchMemory) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMemory r101 = (DefaultReplySwitchMemory) r100;
        if (Intrinsics.areEqual(this.modeId, r101.modeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.reasoningEffort, r101.reasoningEffort) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.modeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DefaultReplyModelItemIndex r104 = this.model;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.reasoningEffort;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplySwitchMemory(modeId=" + this.modeId + ", model=" + this.model + ", reasoningEffort=" + this.reasoningEffort + ')';
    }

    public final String getModeId() {
        return this.modeId;
    }

    public final DefaultReplyModelItemIndex getModel() {
        return this.model;
    }

    public final Integer getReasoningEffort() {
        return this.reasoningEffort;
    }

    public DefaultReplySwitchMemory(String r100, DefaultReplyModelItemIndex r101, Integer r102) {
        this.modeId = r100;
        this.model = r101;
        this.reasoningEffort = r102;
    }

    public /* synthetic */ DefaultReplySwitchMemory(String r100, DefaultReplyModelItemIndex r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
