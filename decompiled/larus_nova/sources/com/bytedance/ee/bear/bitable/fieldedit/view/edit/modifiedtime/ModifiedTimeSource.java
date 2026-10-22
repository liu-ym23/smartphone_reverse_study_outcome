package com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0000R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeSource;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "<init>", "()V", SlcCommonAction.KEY_PARAMS, "", "", "getFields", "()Ljava/util/List;", "setFields", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "clone", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifiedTimeSource implements NonProguard {
    private List<String> fields;

    public ModifiedTimeSource() {
    }

    public final ModifiedTimeSource clone() {
        ModifiedTimeSource r100 = new ModifiedTimeSource();
        List<String> r101 = this.fields;
        if (r101 == null) goto L5;
        List<String> r102 = CollectionsKt.toMutableList(r101);
    L6:
        r100.fields = r102;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public int hashCode() {
        List<String> r100 = this.fields;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final List<String> getFields() {
        return this.fields;
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(ModifiedTimeSource.class, r101) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeSource");
        List<String> r102 = this.fields;
        List<String> r103 = ((ModifiedTimeSource) r100).fields;
        if (r102 != null) goto L13;
        if (r103 != null) goto L13;
        return true;
    L13:
        if (r102 == null) goto L22;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r102.containsAll(r103) == true) goto L19;
        return false;
    L19:
        if (r103.containsAll(r102) == false) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final void setFields(List<String> r100) {
        this.fields = r100;
    }
}
