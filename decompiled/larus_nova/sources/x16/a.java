package x16;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Class<? extends IXResourceLoader>> f562120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f562121b = null;

    static {
        f562120a = new ArrayList();
        f562121b = new ArrayList();
    }

    public static Uri a(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        Iterator r102 = ((ArrayList) f562121b).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Uri r103 = ((b) r102.next()).a(r100, r101);
        if (r103 == null) goto L4;
        return r103;
    L8:
        return null;
    }

    public static void c(d1 r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "resInfo");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Iterator r102 = ((ArrayList) f562121b).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).c(r100, r101);
        goto L4
    }

    public static void d(d1 r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "resInfo");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Iterator r102 = ((ArrayList) f562121b).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).d(r100, r101);
        goto L4
    }

    public static void b(d1 r100, l r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "resInfo");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Intrinsics.checkNotNullParameter(r102, "e");
        Iterator r103 = ((ArrayList) f562121b).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b) r103.next()).b(r100, r101, r102);
        goto L4
    }
}
