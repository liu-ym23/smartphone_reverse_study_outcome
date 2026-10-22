package w12;

import com.bytedance.android.livesdk.gift.model.f2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f557890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f557891b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f2 f557892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f557893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f557894e;

    static {
        f557890a = new ArrayList();
        f557891b = new ArrayList();
        f557893d = true;
    }

    public static void a() {
        Iterator r100 = ((ArrayList) f557891b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        String r101 = (String) r100.next();
        ((ArrayList) f557890a).add(r101 + "/obj/");
        goto L4
    }

    public static void b(f2 r100) {
        Intrinsics.checkNotNullParameter(r100, "imageTemplate");
        f557892c = r100;
        List<String> r101 = r100.getDomainList();
        if (r101 == null) goto L6;
        ArrayList r102 = new ArrayList();
        r102.addAll(r101);
        ArrayList r103 = (ArrayList) f557891b;
        r103.clear();
        r103.addAll(r102);
        return;
    }
}
