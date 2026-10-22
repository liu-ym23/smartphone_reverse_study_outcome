package v96;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f553806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k> f553807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f553809d;

    public final String a() {
        List<k> r100 = b(Constants.Keys.KEY_X_TT_LOGID);
        if (r100 == null) goto L8;
        k r101 = (k) CollectionsKt.getOrNull(r100, 0);
        if (r101 == null) goto L8;
        String r102 = r101.f553805b;
        if (r102 == null) goto L8;
        return r102;
    L8:
        List<k> r103 = b(NetResponse.HEADER_KEY_LOG_ID);
        if (r103 == null) goto L13;
        k r104 = (k) CollectionsKt.getOrNull(r103, 0);
        if (r104 == null) goto L13;
        return r104.f553805b;
    L13:
        return null;
    }

    public final List<k> b(String r100) {
        Iterator<k> r101 = this.f553807b.iterator();
        ArrayList r102 = null;
    L4:
        if (r101.hasNext() == false) goto L10;
        k r103 = r101.next();
        if (StringsKt.equals(r100, r103.f553804a, true) == false) goto L4;
        if (r102 != null) goto L9;
        r102 = new ArrayList();
    L9:
        r102.add(r103);
        goto L4
    L10:
        return r102;
    }

    public l(String r100, int r101, List<k> r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        this.f553806a = r101;
        this.f553807b = r102;
        this.f553808c = r103;
        this.f553809d = r104;
    }
}
