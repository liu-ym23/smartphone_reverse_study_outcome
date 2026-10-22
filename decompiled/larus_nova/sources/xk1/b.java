package xk1;

import android.app.Application;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.replay.cache.download.DownloadApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.live.extension.plugin.api.resourcemanager.ILiveWrappedResourceManagerService;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f564127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, o> f564128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<o> f564129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o[] f564130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f564131e;

    public class a extends xk1.a {
        public a(o r100, p r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: renamed from: xk1.b$b, reason: collision with other inner class name */
    public class C8246b implements o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f564132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f564133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f564134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f564135d;

        public final void a() {
            o r100 = this.f564132a;
            if (r100.f564175e == 1) goto L7;
            this.f564135d.f564130d[this.f564133b] = null;
            return;
        L7:
            if (r100.f564173c == this.f564134c) goto L10;
            this.f564135d.f564130d[this.f564133b] = null;
            return;
        L10:
            r100.c(6);
            p r101 = this.f564135d.f564131e;
            if (r101 == null) goto L13;
            String r102 = this.f564132a.a();
            ((i.a) r101).f564158a.h(r102, -1);
        L13:
            b r103 = this.f564135d;
            r103.f564130d[this.f564133b] = null;
            r103.b();
        }

        public C8246b(b r100, o r101, int r102, int r103, a r104) {
            this.f564135d = r100;
            this.f564132a = r101;
            this.f564133b = r102;
            this.f564134c = r103;
        }
    }

    public final void b() {
        if (this.f564129c.isEmpty() == true) goto L72;
        o[] r100 = this.f564130d;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (r100[r102] == null) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L93;
        int r104 = 0;
    L16:
        if (r104 >= this.f564127a) goto L94;
        if (this.f564130d[r104] != null) goto L71;
        int r105 = this.f564129c.size();
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L27;
        o r107 = this.f564129c.get(r106);
        if (r107 == null) goto L26;
        if (r107.f564175e == 2) goto L26;
        final o r110 = r107;
    L28:
        if (r110 == null) goto L29;
        this.f564129c.remove(r106);
        r110.f564171a = r104;
        this.f564130d[r104] = r110;
        a r108 = new a(r110, this.f564131e);
        int r109 = r110.f564173c + 1;
        r110.f564173c = r109;
        r110.c(1);
        p r111 = this.f564131e;
        if (r111 == null) goto L63;
        tp1.b r112 = r110.f564172b.f547013n;
        long r113 = r112.f547019b;
        if (r113 == 0) goto L35;
        long r114 = (r112.f547018a * 100) / r113;
    L35:
        String r115 = r110.a();
        tp1.b r116 = r110.f564172b.f547013n;
        long r117 = r116.f547018a;
        long r118 = r116.f547019b;
        i r119 = ((i.a) r111).f564158a;
        if (r119.f564145a == null) goto L63;
        tp1.a r120 = r119.f564145a.get(r115);
        if (r120 == null) goto L63;
        r120.f547013n.f547019b = r118;
        long r121 = r118 - r117;
        Application r122 = jc1.a.b();
        if (r122 != null) goto L44;
    L48:
        long r123 = -1;
    L50:
        if (r123 >= r121) goto L52;
        boolean r124 = true;
    L53:
        if (r124 == false) goto L55;
        r119.f564147c.d(r115);
        r119.h(r115, 32);
        goto L63
    L55:
        tp1.b r125 = r120.f547013n;
        r125.f547020c = 1;
        r125.f547018a = r117;
        r120.update();
        ArrayList<WeakReference<sp1.a>> r126 = r119.f564146b.get(r115);
        if (r126 == null) goto L63;
        Iterator r127 = new ArrayList(r126).iterator();
    L59:
        if (r127.hasNext() == false) goto L63;
        sp1.a r128 = (sp1.a) ((WeakReference) r127.next()).get();
        if (r128 == null) goto L59;
        r128.c(r120);
        goto L59
    L52:
        r124 = false;
        goto L53
    L44:
        if (Environment.getDataDirectory() == null) goto L48;
        StatFs r129 = new StatFs(r122.getFilesDir().getParent());     // Catch: IllegalArgumentException -> L73
        r123 = r129.getBlockSizeLong() * r129.getAvailableBlocksLong();
    L63:
        C8246b r130 = new C8246b(this, r110, r104, r109, r108);
        r110.f564174d = true;
        r110.f564177g = r130;
        if (r110.f564172b.f547009j == null) goto L66;
    L70:
        r110.b();
        goto L71
    L66:
        if (r.n().getService(DownloadApi.class) == null) goto L70;
        Object r131 = pm1.h.f529822d.c(fq1.k.class);
        Intrinsics.checkNotNull(r131);
        Observable<Response<Episode>> r132 = ((DownloadApi) ((fq1.k) r131).getService(DownloadApi.class)).refreshVideo(Long.valueOf(r110.f564172b.f547011l));
        if (r132 == null) goto L71;
        r132.subscribe(new m(r110), new n(r110));
        goto L71
    L29:
        return;
    L26:
        r106 = r106 + 1;
        goto L20
    L27:
        r110 = null;
        r106 = 0;
    L71:
        r104 = r104 + 1;
        goto L16
    L94:
        return;
    L93:
        return;
    L11:
        r103 = true;
        goto L12
    }

    public b() {
        this.f564128b = new LinkedHashMap();
        this.f564129c = new LinkedList();
        this.f564127a = 1;
        this.f564130d = new o[1];
        ILiveWrappedResourceManagerService.Companion.getClass();
        ((ILiveWrappedResourceManagerService) va1.b.a.f553922a.a(ILiveWrappedResourceManagerService.class)).getDownloadManager();
    }

    public final void d(String r100) {
        o r101 = (o) ((LinkedHashMap) this.f564128b).get(r100);
        if (r101 == null) goto L18;
        int r102 = r101.f564175e;
        if (r102 != 1) goto L13;
        if (r101.f564174d == false) goto L19;
        r101.c(2);
        p r103 = this.f564131e;
        if (r103 == null) goto L11;
        i.a r104 = (i.a) r103;
        r104.c(r101.a());
    L11:
        this.f564130d[r101.f564171a] = null;
        b();
        return;
    L19:
        return;
    L13:
        if (r102 != 3) goto L21;
        r101.c(2);
        p r105 = this.f564131e;
        if (r105 == null) goto L22;
        i.a r106 = (i.a) r105;
        r106.c(r101.a());
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void a(List<tp1.a> r100, boolean r101) {
        if (r100.size() == 0) goto L20;
        Iterator<tp1.a> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L33;
        tp1.a r103 = r102.next();
        if (r103 == null) goto L19;
        if (r103.f547013n.f547020c == 5) goto L19;
        if (this.f564128b.containsKey(r103.f547000a) == true) goto L15;
        o r104 = new o(r103);
        this.f564128b.put(r103.f547000a, r104);
        c(r101, r104, r103);
        goto L7
    L15:
        Map<String, o> r105 = this.f564128b;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        o r107 = (o) r106.get(r103.f547000a);
        if (r107 == null) goto L7;
        c(r101, r107, r103);
    L19:
        p r108 = this.f564131e;
        i.a r109 = (i.a) r108;
        r109.b(r103.f547000a, r103.f547013n.f547019b);
        goto L7
    L33:
        return;
    }

    public final void c(boolean r100, o r101, tp1.a r102) {
        if (r101.f564175e != 1) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        int r103 = 3;
    L9:
        r101.c(r103);
        p r104 = this.f564131e;
        if (r104 == null) goto L14;
        if (r100 == false) goto L13;
        i.a r105 = (i.a) r104;
        r105.d(r102.f547000a);
        goto L14
    L13:
        i.a r106 = (i.a) r104;
        r106.c(r102.f547000a);
    L14:
        this.f564128b.put(r101.a(), r101);
        this.f564129c.clear();
        Iterator r107 = ((LinkedHashMap) this.f564128b).entrySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L22;
        o r108 = (o) ((Map.Entry) r107.next()).getValue();
        if (r108 == null) goto L16;
        if (r108.f564175e != 3) goto L16;
        this.f564129c.add(r108);
        goto L16
    L22:
        b();
        return;
    L8:
        r103 = 2;
        goto L9
    }
}
