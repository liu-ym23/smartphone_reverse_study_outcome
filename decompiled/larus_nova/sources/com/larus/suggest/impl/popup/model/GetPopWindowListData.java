package com.larus.suggest.impl.popup.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/suggest/impl/popup/model/GetPopWindowListData;", "", "campaignTag", "", "popWindowList", "", "Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCampaignTag", "()Ljava/lang/String;", "getPopWindowList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPopWindowListData {

    @SerializedName("campaign_tag")
    private final String campaignTag;

    @SerializedName("pop_window_list")
    private final List<NexPulseCandidate> popWindowList;

    /* JADX WARN: Multi-variable type inference failed */
    public GetPopWindowListData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetPopWindowListData copy$default(GetPopWindowListData r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.campaignTag;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.popWindowList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.campaignTag;
    }

    public final List<NexPulseCandidate> component2() {
        return this.popWindowList;
    }

    public final GetPopWindowListData copy(String r100, List<NexPulseCandidate> r101) {
        return new GetPopWindowListData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetPopWindowListData) == true) goto L8;
        return false;
    L8:
        GetPopWindowListData r101 = (GetPopWindowListData) r100;
        if (Intrinsics.areEqual(this.campaignTag, r101.campaignTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.popWindowList, r101.popWindowList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.campaignTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<NexPulseCandidate> r104 = this.popWindowList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPopWindowListData(campaignTag=" + this.campaignTag + ", popWindowList=" + this.popWindowList + ')';
    }

    public final String getCampaignTag() {
        return this.campaignTag;
    }

    public final List<NexPulseCandidate> getPopWindowList() {
        return this.popWindowList;
    }

    public GetPopWindowListData(String r100, List<NexPulseCandidate> r101) {
        this.campaignTag = r100;
        this.popWindowList = r101;
    }

    public /* synthetic */ GetPopWindowListData(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
