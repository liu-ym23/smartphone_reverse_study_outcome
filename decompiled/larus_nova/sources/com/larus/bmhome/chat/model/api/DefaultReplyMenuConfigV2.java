package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "", "modeList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;", "modelList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "defaultSelectModeMap", "", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMemory;", "useModeModelList", "", "<init>", "(Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;Ljava/util/Map;Ljava/lang/Boolean;)V", "getModeList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;", "getModelList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "getDefaultSelectModeMap", "()Ljava/util/Map;", "getUseModeModelList", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyMenuConfigV2 {

    @SerializedName("default_select_mode_map")
    private final Map<String, DefaultReplySwitchMemory> defaultSelectModeMap;

    @SerializedName("mode_list")
    private final DefaultReplySwitchModeConfig modeList;

    @SerializedName("model_list")
    private final DefaultReplySwitchMenuConfig modelList;

    @SerializedName("use_mode_model_list")
    private final Boolean useModeModelList;

    public DefaultReplyMenuConfigV2() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuConfigV2 copy$default(DefaultReplyMenuConfigV2 r100, DefaultReplySwitchModeConfig r101, DefaultReplySwitchMenuConfig r102, Map r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.modeList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.modelList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.defaultSelectModeMap;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.useModeModelList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final DefaultReplySwitchModeConfig component1() {
        return this.modeList;
    }

    public final DefaultReplySwitchMenuConfig component2() {
        return this.modelList;
    }

    public final Map<String, DefaultReplySwitchMemory> component3() {
        return this.defaultSelectModeMap;
    }

    public final Boolean component4() {
        return this.useModeModelList;
    }

    public final DefaultReplyMenuConfigV2 copy(DefaultReplySwitchModeConfig r100, DefaultReplySwitchMenuConfig r101, Map<String, DefaultReplySwitchMemory> r102, Boolean r103) {
        return new DefaultReplyMenuConfigV2(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyMenuConfigV2) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuConfigV2 r101 = (DefaultReplyMenuConfigV2) r100;
        if (Intrinsics.areEqual(this.modeList, r101.modeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelList, r101.modelList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultSelectModeMap, r101.defaultSelectModeMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.useModeModelList, r101.useModeModelList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        DefaultReplySwitchModeConfig r100 = this.modeList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DefaultReplySwitchMenuConfig r104 = this.modelList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, DefaultReplySwitchMemory> r107 = this.defaultSelectModeMap;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.useModeModelList;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplyMenuConfigV2(modeList=" + this.modeList + ", modelList=" + this.modelList + ", defaultSelectModeMap=" + this.defaultSelectModeMap + ", useModeModelList=" + this.useModeModelList + ')';
    }

    public final Map<String, DefaultReplySwitchMemory> getDefaultSelectModeMap() {
        return this.defaultSelectModeMap;
    }

    public final DefaultReplySwitchModeConfig getModeList() {
        return this.modeList;
    }

    public final DefaultReplySwitchMenuConfig getModelList() {
        return this.modelList;
    }

    public final Boolean getUseModeModelList() {
        return this.useModeModelList;
    }

    public DefaultReplyMenuConfigV2(DefaultReplySwitchModeConfig r100, DefaultReplySwitchMenuConfig r101, Map<String, DefaultReplySwitchMemory> r102, Boolean r103) {
        this.modeList = r100;
        this.modelList = r101;
        this.defaultSelectModeMap = r102;
        this.useModeModelList = r103;
    }

    public /* synthetic */ DefaultReplyMenuConfigV2(DefaultReplySwitchModeConfig r100, DefaultReplySwitchMenuConfig r101, Map r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
