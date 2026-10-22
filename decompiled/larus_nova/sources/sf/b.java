package sf;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.shopping.extensions.k;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import lg.c;
import lg.h;
import lg.i;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements IECAPTService {
    public b() {
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void record(c r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        ArrayList<i> r101 = a.f541678a;
        a.a(r100);
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void registerPlugin(i r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        ArrayList<i> r101 = a.f541678a;
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        a.f541678a.add(r100);
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void diff(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ArrayList<i> r103 = a.f541678a;
        a.a(new h(r100 + "_old", k.w(r101)));
        a.a(new h(r100 + "_new", k.w(r102)));
    }
}
