package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/search/MoreInfo;", "Lcom/larus/im/bean/message/ItemData;", "searchUrl", "", "searchUrlApp", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSearchUrl", "()Ljava/lang/String;", "setSearchUrl", "(Ljava/lang/String;)V", "getSearchUrlApp", "setSearchUrlApp", "getId", "getSearchUrlCompat", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreInfo extends ItemData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ItemType f308599a;

    @SerializedName("search_url")
    private String searchUrl;

    @SerializedName("search_url_app")
    private String searchUrlApp;

    /* JADX WARN: Multi-variable type inference failed */
    public MoreInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MoreInfo copy$default(MoreInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.searchUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.searchUrlApp;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.searchUrl;
    }

    public final String component2() {
        return this.searchUrlApp;
    }

    public final MoreInfo copy(String r100, String r101) {
        return new MoreInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MoreInfo) == true) goto L8;
        return false;
    L8:
        MoreInfo r101 = (MoreInfo) r100;
        if (Intrinsics.areEqual(this.searchUrl, r101.searchUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchUrlApp, r101.searchUrlApp) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.searchUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.searchUrlApp;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MoreInfo(searchUrl=" + this.searchUrl + ", searchUrlApp=" + this.searchUrlApp + ')';
    }

    public final String getSearchUrlCompat() {
        String r100 = this.searchUrlApp;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return this.searchUrl;
    L12:
        return this.searchUrlApp;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.searchUrl;
    }

    @Override // com.larus.im.bean.message.ItemData
    public ItemType getSearchItemType() {
        return this.f308599a;
    }

    public final String getSearchUrl() {
        return this.searchUrl;
    }

    public final String getSearchUrlApp() {
        return this.searchUrlApp;
    }

    public final void setSearchUrl(String r100) {
        this.searchUrl = r100;
    }

    public final void setSearchUrlApp(String r100) {
        this.searchUrlApp = r100;
    }

    public MoreInfo(String r100, String r101) {
        this.searchUrl = r100;
        this.searchUrlApp = r101;
        this.f308599a = ItemType.TYPE_CARD_MORE;
    }

    public /* synthetic */ MoreInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
