package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.content.Context;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.Location;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements com.ss.android.lark.location.service.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<POIInfo, PoiInfo> f209432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f209433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f209434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ValueCallback<Boolean> f209435d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super POIInfo, ? extends PoiInfo> r100, e r101, Context r102, ValueCallback<Boolean> r103) {
        this.f209432a = r100;
        this.f209433b = r101;
        this.f209434c = r102;
        this.f209435d = r103;
    }

    @Override // com.ss.android.lark.location.service.h.a
    public final void a(POIInfo r100) {
        if (r100 == null) goto L8;
        PoiInfo r101 = this.f209432a.invoke(r100);
        e r102 = this.f209433b;
        double r103 = r101.getLatitude();
        double r104 = r101.getLongitude();
        r102.getClass();
        if (e.a(r103, r104) == true) goto L7;
        UDToast.show(this.f209434c, R.string.Bitable_Field_LocationDataErrorRetry);
        this.f209435d.onReceiveValue(Boolean.FALSE);
        return;
    L7:
        this.f209435d.onReceiveValue(Boolean.TRUE);
        this.f209433b.getClass();
        Location r105 = new Location(r101);
        this.f209433b.f209427b.c(r105);
        return;
    L8:
        UDToast.show(this.f209434c, R.string.Bitable_Field_UnableToLocateToast);
        this.f209435d.onReceiveValue(Boolean.FALSE);
    }
}
