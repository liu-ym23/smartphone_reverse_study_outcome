package x86;

import b96.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.c;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.d;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vy5.b;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562912a = 0;

    /* JADX INFO: renamed from: x86.a$a, reason: collision with other inner class name */
    public static final class C8203a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8203a f562913a = null;

        static {
            f562913a = new C8203a();
        }

        public C8203a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            return r100.isDirectory();
        }
    }

    static {
    }

    public static void a(String r100, String r101) {
        GeckoUpdateListener.GeckoParams r102 = new GeckoUpdateListener.GeckoParams(r100, r101, 0);     // Catch: Throwable -> L7
        Iterator r103 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L7
    L4:
        if (r103.hasNext() == false) goto L9;
        ((GeckoUpdateListener) r103.next()).onCleanRes(r102);     // Catch: Throwable -> L7
    L9:
        d r104 = new d(r100, r101);
        Iterator r105 = ((ConcurrentHashMap) IESGurdKit.f250623a).entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        ((c) ((Map.Entry) r105.next()).getValue()).a(r104);
        goto L11
    L13:
        return;
    L7:
        th = move-exception;
        GeckoLogger.w("GeckoUpdateListener onCleanRes exception: " + th.getMessage() + '-' + th.getStackTrace());
        goto L9
    }

    public static void b(String r100, String r101) {
        AtomicBoolean r102 = GlobalManager.f250632a;
        String r103 = GlobalManager.b(r100);
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r103 + '/' + r100 + '/' + r101);
        File[] r107 = r106.listFiles(C8203a.f562913a);
        if (r107 != null) goto L14;
    L20:
        if (r104 == false) goto L23;
        ez5.c.delete(r106);
        return;
    L23:
        return;
    L14:
        if (r107.length != 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L20;
        r104 = false;
        goto L20
    L16:
        r108 = false;
        goto L17
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static void c(String r100, String r101) {
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if (r101.length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == true) goto L21;
        GeckoLogger.d("CleanManager.cleanCache: " + r100 + '-' + r101);
        com.bytedance.iesgurd.meta.a.e(r100, r101);
        AtomicBoolean r104 = GlobalManager.f250632a;
        String r105 = GlobalManager.b(r100);
        if (r105 != null) goto L16;
        r105 = GlobalManager.c();
    L16:
        if (r105 == null) goto L20;
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        String r107 = File.separator;
        r106.append(r107);
        r106.append(r100);
        r106.append(r107);
        r106.append(r101);
        ez5.c.delete(new PolarisFileWrapper(r106.toString()));
        a(r100, r101);
        return;
    L20:
        return;
    L21:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static void e(String r110, Long r111) {
        int r100 = 0;
        List r101 = StringsKt.split$default(r110, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r101.size() < 2) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L83;
        Pair r103 = TuplesKt.to(ListProtector.get(r101, r101.size() - 2), CollectionsKt.last(r101));
        if (r103 == null) goto L84;
        ChannelMeta r104 = com.bytedance.iesgurd.meta.a.c((String) r103.component1(), (String) r103.component2());
        if (r104 != null) goto L16;
    L18:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r110);
        File[] r106 = r105.listFiles();
        if (r106 != null) goto L21;
    L27:
        boolean r107 = true;
    L28:
        if (r107 == false) goto L30;
        r105.delete();
        return;
    L30:
        ArrayList r108 = new ArrayList();
        int r109 = r106.length;
        int r112 = 0;
    L31:
        if (r112 >= r109) goto L37;
        File r113 = r106[r112];
        if (r113.isDirectory() == false) goto L35;
        r108.add(r113);
    L35:
        r112 = r112 + 1;
        goto L31
    L37:
        if (r108.isEmpty() == false) goto L40;
        return;
    L40:
        if (b.e(r110) == false) goto L87;
        List r114 = StringsKt.split$default(r110, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r114.size() < 2) goto L66;
        String r115 = (String) ListProtector.get(r114, r114.size() - 2);
        String r116 = (String) ListProtector.get(r114, r114.size() - 1);
        String r117 = String.valueOf(r111);
        if (r111 != null) goto L52;
        ChannelMeta r118 = com.bytedance.iesgurd.meta.a.c(r115, r116);
        if (r118 == null) goto L52;
        Long r119 = r118.getId();
        if (r119 == null) goto L52;
        r117 = String.valueOf(r119.longValue());
    L52:
        Iterator r120 = r108.iterator();
        int r121 = 0;
    L54:
        if (r120.hasNext() == false) goto L65;
        File r122 = (File) r120.next();
        String r123 = r122.getName();
        if (StringsKt.endsWith$default(r123, "--updating", false, 2, null) == true) goto L58;
        if ((!Intrinsics.areEqual(r123, r117)) == false) goto L54;
        com.bytedance.iesgurd.core.a.c(r122);
    L64:
        r121 = r121 + 1;
        goto L54
    L58:
        if (i.b(r115, r116) == true) goto L54;
        com.bytedance.iesgurd.core.a.c(r122);
        goto L64
    L65:
        r100 = r121;
    L66:
        b.f(r110);
        if (r100 <= 0) goto L69;
        com.bytedance.iesgurd.core.a.b();
    L69:
        GeckoLogger.d("channel version delete: " + r110 + ", newVersion: " + r111 + ", deleteCount: " + r100);
        return;
    L87:
        return;
    L21:
        if (r106.length != 0) goto L23;
        boolean r124 = true;
    L24:
        if (r124 == true) goto L27;
        r107 = false;
        goto L28
    L23:
        r124 = false;
        goto L24
    L16:
        if (Intrinsics.areEqual(r104.isMiniApp(), Boolean.TRUE) == false) goto L18;
        return;
    L84:
        return;
    L83:
        return;
    L5:
        r102 = false;
        goto L7
    }

    public static void d(String r110, String r111, long r112, CleanStrategy r113, int r114) {
        AtomicBoolean r100 = GlobalManager.f250632a;
        String r101 = GlobalManager.b(r110);
        if (r101 != null) goto L6;
        r101 = GlobalManager.c();
    L6:
        if (r101 == null) goto L43;
        Long r102 = Long.valueOf(r112);
        if (r112 != 0) goto L16;
        ChannelMeta r103 = com.bytedance.iesgurd.meta.a.c(r110, r111);
        if (r103 == null) goto L12;
        r102 = r103.getId();
    L13:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101 + '/' + r110 + '/' + r111);
        PrepareMetaManager.c(r110, r111, null);
        com.bytedance.iesgurd.meta.a.e(r110, r111);
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((ConcurrentHashMap) yy5.c.f569477a).get(r110);
        if (r105 == null) goto L33;
        r105.remove(r111);
        ((ConcurrentHashMap) yy5.c.f569479c).put(r110, Boolean.TRUE);
    L33:
        if (r104.exists() == true) goto L36;
        return;
    L36:
        if (com.bytedance.iesgurd.core.a.c(r104) == false) goto L40;
        if (r102 == null) goto L39;
        r102.longValue();
        a(r110, r111);
    L39:
        int r106 = 200;
    L41:
        new z86.a(r113, r114, r110, r111, r112, r106, 192).a();
        return;
    L40:
        r106 = 201;
        goto L41
    L12:
        r102 = null;
        goto L13
    L16:
        r104 = new PolarisFileWrapper(r101 + '/' + r110 + '/' + r111 + '/' + r112);
        Map<String, ConcurrentHashMap<String, PrepareMeta>> r107 = PrepareMetaManager.f250761a;
        PrepareMetaManager.c(r110, r111, Long.valueOf(r112));
        ConcurrentHashMap r108 = (ConcurrentHashMap) com.bytedance.iesgurd.meta.a.f250766c;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108.get(r110);
        if (r109 == null) goto L33;
        ChannelMeta r115 = (ChannelMeta) r109.get(r111);
        if (r115 == null) goto L33;
        Long r116 = r115.getId();
        if (r116 == null) goto L33;
        if (r116.longValue() != r112) goto L33;
        ConcurrentHashMap r117 = (ConcurrentHashMap) r108.get(r110);
        if (r117 == null) goto L28;
        ChannelMeta r118 = (ChannelMeta) r117.remove(r111);
    L28:
        Keva r119 = com.bytedance.iesgurd.meta.a.f250764a;
        if (r119 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L31:
        r119.erase(r110 + '@' + r111);
        goto L33
    }
}
