package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "visible", "", "referenceExist", "<init>", "(ZLjava/lang/Boolean;)V", "getVisible", "()Z", "getReferenceExist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(ZLjava/lang/Boolean;)Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedCcmPluginInfo implements NonProguard {

    @SerializedName("reference_exist")
    private final Boolean referenceExist;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public AssociatedCcmPluginInfo() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AssociatedCcmPluginInfo copy$default(AssociatedCcmPluginInfo r100, boolean r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.visible;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.referenceExist;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final Boolean component2() {
        return this.referenceExist;
    }

    public final AssociatedCcmPluginInfo copy(boolean r100, Boolean r101) {
        return new AssociatedCcmPluginInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AssociatedCcmPluginInfo) == true) goto L8;
        return false;
    L8:
        AssociatedCcmPluginInfo r101 = (AssociatedCcmPluginInfo) r100;
        if (this.visible == r101.visible) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.referenceExist, r101.referenceExist) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.visible == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Boolean r102 = this.referenceExist;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "AssociatedCcmPluginInfo(visible=" + this.visible + ", referenceExist=" + this.referenceExist + ')';
    }

    public final Boolean getReferenceExist() {
        return this.referenceExist;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public AssociatedCcmPluginInfo(boolean r100, Boolean r101) {
        this.visible = r100;
        this.referenceExist = r101;
    }

    public /* synthetic */ AssociatedCcmPluginInfo(boolean r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
