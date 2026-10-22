package com.ss.android.lark.chat.message.menu.v2;

import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J!\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0006HÆ\u0003J;\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR.\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/PCActionGroup;", "", ActionList.ELEM_NAME, "", "", "childActionMap", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getActionList", "()Ljava/util/List;", "getChildActionMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PCActionGroup {

    @SerializedName("action_list")
    private final List<String> actionList;

    @SerializedName("child_action_map")
    private final Map<String, List<List<String>>> childActionMap;

    /* JADX WARN: Multi-variable type inference failed */
    public PCActionGroup() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PCActionGroup copy$default(PCActionGroup r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.actionList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.childActionMap;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.actionList;
    }

    public final Map<String, List<List<String>>> component2() {
        return this.childActionMap;
    }

    public final PCActionGroup copy(List<String> r100, Map<String, ? extends List<? extends List<String>>> r101) {
        Intrinsics.checkNotNullParameter(r100, ActionList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r101, "childActionMap");
        return new PCActionGroup(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PCActionGroup) == true) goto L8;
        return false;
    L8:
        PCActionGroup r101 = (PCActionGroup) r100;
        if (Intrinsics.areEqual(this.actionList, r101.actionList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.childActionMap, r101.childActionMap) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.actionList.hashCode() * 31) + this.childActionMap.hashCode();
    }

    public String toString() {
        return "PCActionGroup(actionList=" + this.actionList + ", childActionMap=" + this.childActionMap + ')';
    }

    public final List<String> getActionList() {
        return this.actionList;
    }

    public final Map<String, List<List<String>>> getChildActionMap() {
        return this.childActionMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PCActionGroup(List<String> r100, Map<String, ? extends List<? extends List<String>>> r101) {
        Intrinsics.checkNotNullParameter(r100, ActionList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r101, "childActionMap");
        this.actionList = r100;
        this.childActionMap = r101;
    }

    public /* synthetic */ PCActionGroup(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        this(r100, r101);
    }
}
