package t0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.ChameleonResProvider;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import u0b.b;
import u0b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<? extends u0b.a> f544132a = null;

    static {
        f544132a = CollectionsKt.listOf(new u0b.a[]{new d(), new b()});
    }

    public static com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d a(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        Iterator<T> r104 = f544132a.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        u0b.a r105 = (u0b.a) r104.next();
        if (r105.d(r100, r101) == false) goto L4;
        return r105.b(r100, r101, r102, r103);
    L9:
        j.b(ChameleonResProvider.TAG, "getResource, no interceptor match");
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(null, null);
    }
}
