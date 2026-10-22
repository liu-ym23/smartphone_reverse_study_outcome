package fh6;

import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import qg6.f;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements ig6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<MultiLinkInfoType, ig6.b> f477059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f477060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f477061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fc6.a f477062d;

    @Override // ig6.a
    public final void b(MultiLinkInfoType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f477059a.remove(r100);
    }

    public a(f r100, fc6.a r101) {
        Intrinsics.checkNotNullParameter(r100, "hostService");
        Intrinsics.checkNotNullParameter(r101, "linkServiceHostService");
        this.f477061c = r100;
        this.f477062d = r101;
        this.f477059a = new LinkedHashMap();
        ArrayList r102 = new ArrayList();
        this.f477060b = r102;
        r102.add(new c());
    }

    @Override // ig6.a
    public final void a(MultiLinkInfoType r100, ig6.b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f477059a.put(r100, r101);
    }
}
