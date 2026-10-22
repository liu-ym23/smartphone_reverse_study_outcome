package com.ss.android.lark.chameleon;

import com.bytedance.ee.bear.browser.plugin.i;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/PluginProvider;", "Ljava/io/Serializable;", "pluginHostAbilitys", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "Lkotlin/collections/ArrayList;", "pluginListProvider", "Lcom/ss/android/lark/chameleon/ChameleonPluginListProvider;", "<init>", "(Ljava/util/ArrayList;Lcom/ss/android/lark/chameleon/ChameleonPluginListProvider;)V", "getPluginHostAbilitys", "()Ljava/util/ArrayList;", "setPluginHostAbilitys", "(Ljava/util/ArrayList;)V", "getPluginListProvider", "()Lcom/ss/android/lark/chameleon/ChameleonPluginListProvider;", "setPluginListProvider", "(Lcom/ss/android/lark/chameleon/ChameleonPluginListProvider;)V", "copy", "toString", "", "component1", "component2", "equals", "", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginProvider implements Serializable {
    private ArrayList<i> pluginHostAbilitys;
    private ChameleonPluginListProvider pluginListProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public PluginProvider() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginProvider copy$default(PluginProvider r100, ArrayList r101, ChameleonPluginListProvider r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pluginHostAbilitys;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.pluginListProvider;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<i> component1() {
        return this.pluginHostAbilitys;
    }

    public final ChameleonPluginListProvider component2() {
        return this.pluginListProvider;
    }

    public final PluginProvider copy(ArrayList<i> r100, ChameleonPluginListProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHostAbilitys");
        return new PluginProvider(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PluginProvider) == true) goto L8;
        return false;
    L8:
        PluginProvider r101 = (PluginProvider) r100;
        if (Intrinsics.areEqual(this.pluginHostAbilitys, r101.pluginHostAbilitys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pluginListProvider, r101.pluginListProvider) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.pluginHostAbilitys.hashCode() * 31;
        ChameleonPluginListProvider r101 = this.pluginListProvider;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final PluginProvider copy() {
        return new PluginProvider(new ArrayList(this.pluginHostAbilitys), this.pluginListProvider);
    }

    public String toString() {
        return "PluginProvider(pluginHostAbilitys=" + this.pluginHostAbilitys.size() + ", pluginListProvider=" + this.pluginListProvider + ')';
    }

    public final ArrayList<i> getPluginHostAbilitys() {
        return this.pluginHostAbilitys;
    }

    public final ChameleonPluginListProvider getPluginListProvider() {
        return this.pluginListProvider;
    }

    public final void setPluginHostAbilitys(ArrayList<i> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pluginHostAbilitys = r100;
    }

    public final void setPluginListProvider(ChameleonPluginListProvider r100) {
        this.pluginListProvider = r100;
    }

    public PluginProvider(ArrayList<i> r100, ChameleonPluginListProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHostAbilitys");
        this.pluginHostAbilitys = r100;
        this.pluginListProvider = r101;
    }

    public /* synthetic */ PluginProvider(ArrayList r100, ChameleonPluginListProvider r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
