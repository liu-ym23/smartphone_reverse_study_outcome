package com.bytedance.ee.bear.bitable.app.model;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ4\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/model/AppDrawerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "panelData", "", "", "", "closePanel", "", "<init>", "(Ljava/util/Map;Ljava/lang/Boolean;)V", "getPanelData", "()Ljava/util/Map;", "getClosePanel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/Map;Ljava/lang/Boolean;)Lcom/bytedance/ee/bear/bitable/app/model/AppDrawerModel;", "equals", "other", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppDrawerModel implements NonProguard {
    private final Boolean closePanel;
    private final Map<String, Object> panelData;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppDrawerModel copy$default(AppDrawerModel r100, Map r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.panelData;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.closePanel;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, Object> component1() {
        return this.panelData;
    }

    public final Boolean component2() {
        return this.closePanel;
    }

    public final AppDrawerModel copy(Map<String, ? extends Object> r100, Boolean r101) {
        return new AppDrawerModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppDrawerModel) == true) goto L8;
        return false;
    L8:
        AppDrawerModel r101 = (AppDrawerModel) r100;
        if (Intrinsics.areEqual(this.panelData, r101.panelData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.closePanel, r101.closePanel) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Map<String, Object> r100 = this.panelData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.closePanel;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppDrawerModel(panelData=" + this.panelData + ", closePanel=" + this.closePanel + ')';
    }

    public final Boolean getClosePanel() {
        return this.closePanel;
    }

    public final Map<String, Object> getPanelData() {
        return this.panelData;
    }

    public AppDrawerModel(Map<String, ? extends Object> r100, Boolean r101) {
        this.panelData = r100;
        this.closePanel = r101;
    }

    public /* synthetic */ AppDrawerModel(Map r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = Boolean.FALSE;
    L5:
        this(r100, r101);
    }
}
