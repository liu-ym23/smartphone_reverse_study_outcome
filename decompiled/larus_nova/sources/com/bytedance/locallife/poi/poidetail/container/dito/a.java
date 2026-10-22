package com.bytedance.locallife.poi.poidetail.container.dito;

import android.content.Context;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.data.r;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.provider.h;
import com.bytedance.locallife.poi.newdetail.t;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f263831a;

    /* JADX INFO: renamed from: com.bytedance.locallife.poi.poidetail.container.dito.a$a, reason: collision with other inner class name */
    public static final class C3707a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.locallife.dito.provider.h
    public final BaseDitoModel<?> c(DitoViewModel r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "treeNode");
        BaseDitoModel<?> r102 = h.a.a(this, r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (this.f263831a == false) goto L9;
        r102.f258496e.put("fmp_invalid_tag", Boolean.TRUE);
        return r102;
    L9:
        return r102;
    }

    @Override // com.bytedance.locallife.dito.provider.h
    public final BaseDitoView<?> b(Context r100, m r101, DitoViewModel r102, BaseDitoModel<?> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "treeNode");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Map<String, ? extends r> r104 = a();
        DitoNode r105 = r101.f258221a;
        if (r105 == null) goto L5;
        String r106 = r105.getSubType();
    L6:
        r r107 = r104.get(r106);
        if (r107 == null) goto L11;
        Function2<Context, m, BaseDitoView<?>> r108 = r107.getCreateView();
        if (r108 == null) goto L11;
        BaseDitoView<?> r109 = r108.invoke(r100, r101);
    L12:
        Object r110 = ((LinkedHashMap) r103.f258496e).get("fmp_invalid_tag");
        if ((r110 instanceof Boolean) == false) goto L15;
        Boolean r111 = (Boolean) r110;
    L17:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L20;
        if (r109 == null) goto L20;
        t.b(r109);
    L20:
        if (r109 == null) goto L23;
        r109.W(r102, r103);
        return r109;
    L23:
        return null;
    L15:
        r111 = null;
    L11:
        r109 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }
}
