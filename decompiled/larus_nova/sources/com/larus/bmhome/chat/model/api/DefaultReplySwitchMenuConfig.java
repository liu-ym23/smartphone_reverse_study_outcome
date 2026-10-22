package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "", "itemList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "exposeConfig", "Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "<init>", "(Ljava/util/List;Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;)V", "getItemList", "()Ljava/util/List;", "getExposeConfig", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplySwitchMenuConfig {

    @SerializedName("expose_config")
    private final DefaultReplyExposedConfig exposeConfig;

    @SerializedName("item_list")
    private final List<DefaultReplySwitchMenuItem> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultReplySwitchMenuConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuConfig copy$default(DefaultReplySwitchMenuConfig r100, List r101, DefaultReplyExposedConfig r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.itemList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exposeConfig;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<DefaultReplySwitchMenuItem> component1() {
        return this.itemList;
    }

    public final DefaultReplyExposedConfig component2() {
        return this.exposeConfig;
    }

    public final DefaultReplySwitchMenuConfig copy(List<DefaultReplySwitchMenuItem> r100, DefaultReplyExposedConfig r101) {
        return new DefaultReplySwitchMenuConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplySwitchMenuConfig) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuConfig r101 = (DefaultReplySwitchMenuConfig) r100;
        if (Intrinsics.areEqual(this.itemList, r101.itemList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeConfig, r101.exposeConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<DefaultReplySwitchMenuItem> r100 = this.itemList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DefaultReplyExposedConfig r104 = this.exposeConfig;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplySwitchMenuConfig(itemList=" + this.itemList + ", exposeConfig=" + this.exposeConfig + ')';
    }

    public final DefaultReplyExposedConfig getExposeConfig() {
        return this.exposeConfig;
    }

    public final List<DefaultReplySwitchMenuItem> getItemList() {
        return this.itemList;
    }

    public DefaultReplySwitchMenuConfig(List<DefaultReplySwitchMenuItem> r100, DefaultReplyExposedConfig r101) {
        this.itemList = r100;
        this.exposeConfig = r101;
    }

    public /* synthetic */ DefaultReplySwitchMenuConfig(List r100, DefaultReplyExposedConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
