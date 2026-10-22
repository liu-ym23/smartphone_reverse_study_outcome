package com.larksuite.component.card.protocol.data.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012,\b\u0002\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032,\b\u0002\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR>\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/protocol/data/action/ActionStatus;", "Ljava/io/Serializable;", "componentStatusByName", "", "", "componentStatusByActionID", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/Map;Ljava/util/HashMap;)V", "getComponentStatusByName", "()Ljava/util/Map;", "getComponentStatusByActionID", "()Ljava/util/HashMap;", "setComponentStatusByActionID", "(Ljava/util/HashMap;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionStatus implements Serializable {
    private HashMap<String, String> componentStatusByActionID;
    private final Map<String, String> componentStatusByName;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionStatus() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionStatus copy$default(ActionStatus r100, Map r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.componentStatusByName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.componentStatusByActionID;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.componentStatusByName;
    }

    public final HashMap<String, String> component2() {
        return this.componentStatusByActionID;
    }

    public final ActionStatus copy(Map<String, String> r100, HashMap<String, String> r101) {
        return new ActionStatus(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionStatus) == true) goto L8;
        return false;
    L8:
        ActionStatus r101 = (ActionStatus) r100;
        if (Intrinsics.areEqual(this.componentStatusByName, r101.componentStatusByName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentStatusByActionID, r101.componentStatusByActionID) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.componentStatusByName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, String> r104 = this.componentStatusByActionID;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionStatus(componentStatusByName=" + this.componentStatusByName + ", componentStatusByActionID=" + this.componentStatusByActionID + ')';
    }

    public final HashMap<String, String> getComponentStatusByActionID() {
        return this.componentStatusByActionID;
    }

    public final Map<String, String> getComponentStatusByName() {
        return this.componentStatusByName;
    }

    public final void setComponentStatusByActionID(HashMap<String, String> r100) {
        this.componentStatusByActionID = r100;
    }

    public ActionStatus(Map<String, String> r100, HashMap<String, String> r101) {
        this.componentStatusByName = r100;
        this.componentStatusByActionID = r101;
    }

    public /* synthetic */ ActionStatus(Map r100, HashMap r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
