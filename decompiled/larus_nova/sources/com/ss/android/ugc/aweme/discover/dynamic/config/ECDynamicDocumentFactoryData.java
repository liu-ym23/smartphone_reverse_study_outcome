package com.ss.android.ugc.aweme.discover.dynamic.config;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.dynamic.base.IDynamicHostControllerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/config/ECDynamicDocumentFactoryData;", "", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDynamicDocumentFactoryData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f450446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f450447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IDynamicHostControllerDelegate f450448d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECDynamicDocumentFactoryData) == false) goto L14;
        ECDynamicDocumentFactoryData r101 = (ECDynamicDocumentFactoryData) r100;
        if (Intrinsics.areEqual(this.f450445a, r101.f450445a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450446b, r101.f450446b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450447c, r101.f450447c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f450448d, r101.f450448d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f450445a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f450446b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Context r107 = this.f450447c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IDynamicHostControllerDelegate r110 = this.f450448d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECDynamicDocumentFactoryData(labelName=" + this.f450445a + ", fragment=" + this.f450446b + ", context=" + this.f450447c + ", hostControllerDelegate=" + this.f450448d + ")";
    }

    public final Context getContext() {
        return this.f450447c;
    }

    public ECDynamicDocumentFactoryData(String r100, Fragment r101, Context r102, IDynamicHostControllerDelegate r103) {
        Intrinsics.checkNotNullParameter(r100, "labelName");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f450445a = r100;
        this.f450446b = r101;
        this.f450447c = r102;
        this.f450448d = r103;
    }
}
