package g68;

import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.sami.v2.x;
import com.larus.audio.report.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import g78.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h68.e> f480171a = null;

    static {
        f480171a = new ConcurrentHashMap();
    }

    public static List d() {
        Collection<h68.e> r100 = f480171a.values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((h68.e) r103).d() == AsrState.ASR_STOP) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r106 = r101.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        r105.add(((h68.e) r106.next()).getTaskId());
        goto L13
    L15:
        return r105;
    }

    public static int e() {
        return f480171a.size();
    }

    public static y58.a c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        h68.e r102 = f480171a.get(r100);
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.getConfig();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        h68.e r102 = f480171a.get(r100);
        if (r102 != null) goto L14;
        return false;
    L14:
        return r102.b();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static long g(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return 0;
    L9:
        h68.e r102 = f480171a.get(r100);
        if (r102 != null) goto L12;
        return 0;
    L12:
        return r102.e();
    L5:
        r101 = false;
        goto L7
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        h68.e r102 = f480171a.get(r100);
        if (r102 == null) goto L12;
        r102.release();
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        h68.e r102 = f480171a.get(r100);
        if (r102 == null) goto L12;
        r102.start();
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        h68.e r102 = f480171a.get(r100);
        if (r102 == null) goto L12;
        r102.stop();
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(String r100, a0 r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        h68.e r103 = f480171a.get(r100);
        if (r103 == null) goto L14;
        r103.f(r101);
        return;
    L14:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static void b(String r100, w58.a r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L16;
        ConcurrentHashMap<String, h68.e> r104 = f480171a;
        if (r104.containsKey(r100) == false) goto L13;
        return;
    L13:
        int r105 = c68.b.f22600a;
        c68.b.a("AsrManager", "addAsrTask taskId: " + r100 + ", task size: " + r104.size());
        x r106 = new x(r100);
        r106.k(r101);
        r106.f288670z = r102;
        r104.put(r100, r106);
        return;
    L16:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static int k(String r100, byte[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "buffer");
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        return -1;
    L9:
        h68.e r104 = f480171a.get(r100);
        if (r104 != null) goto L12;
        return -1;
    L12:
        return r104.a(r101, r102);
    L5:
        r103 = false;
        goto L7
    }
}
