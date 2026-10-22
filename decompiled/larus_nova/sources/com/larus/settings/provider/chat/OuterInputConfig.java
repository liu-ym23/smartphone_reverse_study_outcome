package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/chat/OuterInputConfig;", "", "visibleTabList", "", "", "<init>", "(Ljava/util/List;)V", "getVisibleTabList", "()Ljava/util/List;", "setVisibleTabList", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OuterInputConfig {

    @SerializedName("input_visible_tab")
    private List<String> visibleTabList;

    /* JADX WARN: Multi-variable type inference failed */
    public OuterInputConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<String> getVisibleTabList() {
        return this.visibleTabList;
    }

    public OuterInputConfig(List<String> r100) {
        this.visibleTabList = r100;
    }

    public final void setVisibleTabList(List<String> r100) {
        this.visibleTabList = r100;
    }

    public /* synthetic */ OuterInputConfig(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
