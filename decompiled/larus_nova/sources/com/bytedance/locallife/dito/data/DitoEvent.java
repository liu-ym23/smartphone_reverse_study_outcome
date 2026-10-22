package com.bytedance.locallife.dito.data;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB%\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J'\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/dito/data/DitoEvent;", "Ljava/io/Serializable;", "", "component1", "", "Lcom/bytedance/locallife/dito/data/DitoActionModel;", "component2", "name", SlcCommonAction.KEY_ACTIONS, "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoEvent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<DitoActionModel> actions;

    @SerializedName("name")
    private final String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DitoEvent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoEvent copy$default(DitoEvent r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.actions;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.name;
    }

    public final List<DitoActionModel> component2() {
        return this.actions;
    }

    public final DitoEvent copy(String r100, List<DitoActionModel> r101) {
        return new DitoEvent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoEvent) == true) goto L8;
        return false;
    L8:
        DitoEvent r101 = (DitoEvent) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<DitoActionModel> r104 = this.actions;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DitoEvent(name=" + this.name + ", actions=" + this.actions + ')';
    }

    public final List<DitoActionModel> getActions() {
        return this.actions;
    }

    public final String getName() {
        return this.name;
    }

    public DitoEvent(String r100, List<DitoActionModel> r101) {
        this.name = r100;
        this.actions = r101;
    }

    public /* synthetic */ DitoEvent(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
