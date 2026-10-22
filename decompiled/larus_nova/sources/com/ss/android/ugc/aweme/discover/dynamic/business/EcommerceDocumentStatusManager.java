package com.ss.android.ugc.aweme.discover.dynamic.business;

import android.view.View;
import android.view.ViewParent;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.dynamic.core.DocumentStatusManager;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardEngine;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicDocument;
import com.ss.android.ugc.aweme.search.dynamic.core.EcomSearchShowReporterListener;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicDataKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/business/EcommerceDocumentStatusManager;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/DocumentStatusManager;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EcommerceDocumentStatusManager extends DocumentStatusManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f450435a = 0;

    public EcommerceDocumentStatusManager(DynamicDocument r100) {
        Intrinsics.checkNotNullParameter(r100, "document");
        super(r100);
    }

    public static void c(DynamicCardEngine r100) {
        StringBuilder r101 = new StringBuilder("show_stub真正曝光-- pos = ");
        DynamicData r102 = r100.f452608c;
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Integer r103 = (Integer) DynamicDataKt.b(r102, "position");
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        r101.append(r104);
        Logger.a("ItemShowReporter", r101.toString());
        JSONObject r105 = new JSONObject();
        r105.put("type", "show_stub");
        Unit r106 = Unit.INSTANCE;
        r100.A("pageScroll", r105);
        return;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.DocumentStatusManager
    public final void b(DynamicCardEngine r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "dynamicCardEngine");
        Intrinsics.checkNotNullParameter(r101, "type");
        super.b(r100, r101, r102);
        if (r102 == null) goto L11;
        ViewParent r103 = r102.getParent();
    L6:
        if (r103 == null) goto L11;
        if ((r103 instanceof EcomSearchShowReporterListener) == true) goto L9;
        r103 = r103.getParent();
        goto L6
    L9:
        EcomSearchShowReporterListener r104 = (EcomSearchShowReporterListener) r103;
    L12:
        if (r104 == null) goto L22;
        if (r102 == null) goto L22;
        if (Intrinsics.areEqual(r101, "onViewAttachedToWindow") == false) goto L22;
        DynamicData r105 = r100.f452608c;
        if (r105 == null) goto L21;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Integer r106 = (Integer) DynamicDataKt.b(r105, "position");
        if (r106 == null) goto L21;
        r106.intValue();
    L21:
        r104.a();
        return;
    L22:
        c(r100);
        return;
    L11:
        r104 = null;
        goto L12
    }
}
