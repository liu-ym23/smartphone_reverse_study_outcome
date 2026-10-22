package qe9;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.service.audio.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pf9.i0;
import pf9.n;
import pf9.o;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f532704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Class<? extends z0.a>> f532705c;

    public c() {
        this.f532704b = new a();
        this.f532705c = CollectionsKt.listOf(new Class[]{n.class, o.class});
    }

    @Override // qe9.b
    public final List<z0.a> a(List<? extends z0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L18;
        z0.a r104 = (z0.a) r102.next();
        Iterator<T> r105 = this.f532705c.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((Class) r106).isInstance(r104) == false) goto L7;
    L12:
        if (r106 != null) goto L15;
        r103 = false;
    L15:
        if (r103 == true) goto L16;
        r101.add(r104);
        goto L3
    L16:
        a r107 = this.f532704b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r104, "cmd");
        ((ArrayList) r107.f532702a).add(r104);
        goto L3
    L11:
        r106 = null;
        goto L12
    L18:
        a r108 = this.f532704b;
        List<Class<? extends z0.a>> r109 = this.f532705c;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (((ArrayList) r108.f532702a).size() == r109.size()) goto L21;
    L20:
        r103 = false;
    L27:
        if (r103 == false) goto L29;
        r101.add(new i0());
        this.f532703a = false;
    L29:
        return r101;
    L21:
        int r110 = ((ArrayList) r108.f532702a).size();
        int r111 = 0;
    L22:
        if (r111 >= r110) goto L27;
        if (((Class) ListProtector.get(r109, r111)).isInstance(ListProtector.get(r108.f532702a, r111)) == false) goto L20;
        r111 = r111 + 1;
        goto L22
    }
}
