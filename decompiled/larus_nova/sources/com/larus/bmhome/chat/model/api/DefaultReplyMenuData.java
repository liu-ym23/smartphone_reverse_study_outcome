package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.d1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "", "itemList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "exposeConfig", "Lcom/larus/bmhome/actionbar/model/ExposedConfig;", "<init>", "(Ljava/util/List;Lcom/larus/bmhome/actionbar/model/ExposedConfig;)V", "getItemList", "()Ljava/util/List;", "getExposeConfig", "()Lcom/larus/bmhome/actionbar/model/ExposedConfig;", "setExposeConfig", "(Lcom/larus/bmhome/actionbar/model/ExposedConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyMenuData {

    @SerializedName("expose_config")
    private d1 exposeConfig;

    @SerializedName("item_list")
    private final List<DefaultReplyMenuItem> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultReplyMenuData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuData copy$default(DefaultReplyMenuData r100, List r101, d1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.itemList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exposeConfig;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<DefaultReplyMenuItem> component1() {
        return this.itemList;
    }

    public final d1 component2() {
        return this.exposeConfig;
    }

    public final DefaultReplyMenuData copy(List<DefaultReplyMenuItem> r100, d1 r101) {
        return new DefaultReplyMenuData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyMenuData) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuData r101 = (DefaultReplyMenuData) r100;
        if (Intrinsics.areEqual(this.itemList, r101.itemList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeConfig, r101.exposeConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<DefaultReplyMenuItem> r100 = this.itemList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        d1 r104 = this.exposeConfig;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplyMenuData(itemList=" + this.itemList + ", exposeConfig=" + this.exposeConfig + ')';
    }

    public final d1 getExposeConfig() {
        return this.exposeConfig;
    }

    public final List<DefaultReplyMenuItem> getItemList() {
        return this.itemList;
    }

    public final void setExposeConfig(d1 r100) {
        this.exposeConfig = r100;
    }

    public DefaultReplyMenuData(List<DefaultReplyMenuItem> r100, d1 r101) {
        this.itemList = r100;
        this.exposeConfig = r101;
    }

    public /* synthetic */ DefaultReplyMenuData(List r100, d1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
