package xf8;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.ivykit.plugin.TemplateInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements hi9.a<i> {
    public h() {
    }

    @Override // hi9.a
    public final boolean a(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return true;
    }

    @Override // hi9.a
    public final int b(ei9.f r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Iterator r102 = ((LinkedHashMap) j.f563527b).values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((TemplateInfo) r103).getTemplateId(), r101.f563525f.getTemplateId()) == false) goto L4;
    L10:
        if (((TemplateInfo) r103) != null) goto L12;
        j.f563526a++;
        j.f563527b.put(Integer.valueOf(j.f563526a), r101.f563525f);
    L12:
        Iterator r104 = ((LinkedHashMap) j.f563527b).entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L20;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (Intrinsics.areEqual(((TemplateInfo) r105.getValue()).getTemplateId(), r101.f563525f.getTemplateId()) == false) goto L14;
        return ((Number) r105.getKey()).intValue();
    L20:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L8:
        r103 = null;
        goto L10
    }
}
