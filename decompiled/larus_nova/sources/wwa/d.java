package wwa;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.batterymonitor.api.ConditionState;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AbsBatteryStrategy> f561752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<xwa.a> f561753b;

    public final void a(ConditionState r100) {
        if (CollectionUtils.isEmpty(this.f561752a) == false) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) this.f561753b).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        xwa.a r102 = (xwa.a) r101.next();
        if (r102 == null) goto L7;
        r102.d(r100);
        goto L7
    L11:
        Iterator r103 = ((ArrayList) this.f561752a).iterator();
    L13:
        if (r103.hasNext() == false) goto L18;
        AbsBatteryStrategy r104 = (AbsBatteryStrategy) r103.next();
        if (r104 == null) goto L13;
        r104.a(r100);
        goto L13
    }

    public d(List<AbsBatteryStrategy> r100, List<xwa.a> r101) {
        ArrayList r102 = new ArrayList();
        this.f561752a = r102;
        ArrayList r103 = new ArrayList();
        this.f561753b = r103;
        r102.addAll(r100);
        r103.addAll(r101);
    }
}
