package io.ktor.http;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f491886c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k> f491888b;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        if (this.f491888b.isEmpty() == true) goto L21;
        int r100 = this.f491887a.length();
        Iterator<T> r101 = this.f491888b.iterator();
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r101.hasNext() == false) goto L9;
        k r104 = (k) r101.next();
        r103 = r103 + ((r104.f491883a.length() + r104.f491884b.length()) + 3);
        goto L7
    L9:
        StringBuilder r105 = new StringBuilder(r100 + r103);
        r105.append(this.f491887a);
        int r106 = CollectionsKt.getLastIndex(this.f491888b);
        if (r106 < 0) goto L18;
    L11:
        k r107 = (k) ListProtector.get(this.f491888b, r102);
        r105.append("; ");
        r105.append(r107.f491883a);
        r105.append(ContainerUtils.KEY_VALUE_DELIMITER);
        String r108 = r107.f491884b;
        if (m.a(r108) == false) goto L14;
        r105.append(m.b(r108));
    L15:
        if (r102 == r106) goto L18;
        r102 = r102 + 1;
        goto L11
    L14:
        r105.append(r108);
    L18:
        return r105.toString();
    L21:
        return this.f491887a;
    }

    public l(String r100, List<k> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "parameters");
        this.f491887a = r100;
        this.f491888b = r101;
    }
}
