package nz5;

import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.api.consumer.AnchorExtra;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, RunnableC6996a> f521414a;

    /* JADX INFO: renamed from: nz5.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes19.dex */
    public final class RunnableC6996a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnchorInfoModel f521415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f521416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f521417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f521418d;

        public final void a() {
            hz5.k.b("Helios-Log-Detection-Task", "beginAnchorRunnable");
            if (this.f521418d.f(this.f521415a, this.f521416b, "Run") == false) goto L5;
            return;
        L5:
            long r100 = System.currentTimeMillis();
            ArrayMap<String, m> r101 = b.f521419a;
            Iterator<T> r102 = this.f521417c.iterator();
            boolean r103 = false;
        L7:
            if (r102.hasNext() == false) goto L73;
            m r104 = r101.get((String) r102.next());
            if (r104 == null) goto L7;
            List<PrivacyEvent> r105 = r104.b();
            if (r105 == null) goto L7;
            ArrayList r110 = new ArrayList();
            Iterator<T> r106 = r105.iterator();
        L13:
            boolean r111 = true;
            if (r106.hasNext() == false) goto L37;
            Object r112 = r106.next();
            PrivacyEvent r113 = (PrivacyEvent) r112;
            AnchorExtra r114 = r113.B;
            if (r114 == null) goto L18;
            int r115 = r114.getAnchorCheckCount();
        L20:
            if (r115 >= this.f521415a.g()) goto L22;
            boolean r116 = true;
        L23:
            AnchorExtra r117 = r113.B;
            if (r117 == null) goto L26;
            long r118 = r117.getLastAnchorCheckTime();
        L28:
            if ((r100 - r118) < this.f521415a.c()) goto L30;
            boolean r119 = true;
        L31:
            if (r116 == false) goto L34;
            if (r119 == false) goto L34;
        L35:
            if (r111 == false) goto L13;
            r110.add(r112);
        L34:
            r111 = false;
            goto L35
        L30:
            r119 = false;
            goto L31
        L26:
            r118 = 0;
            goto L28
        L22:
            r116 = false;
            goto L23
        L18:
            r115 = 0;
            goto L20
        L37:
            Iterator<T> r107 = this.f521418d.d(r110, this.f521415a, this.f521416b).iterator();
        L39:
            if (r107.hasNext() == false) goto L7;
            PrivacyEvent r108 = (PrivacyEvent) r107.next();
            Object r120 = this.f521416b;
            AnchorExtra r121 = r108.B;
            if (r121 == null) goto L72;
            r121.setAnchorCheckCount(r121.getAnchorCheckCount() + 1);
            r121.setLastAnchorCheckTime(r100);
            Set r122 = TypeIntrinsics.asMutableSet(r108.f245377n.get("anchor_types"));
            if (r122 != null) goto L46;
            r122 = new LinkedHashSet();
        L46:
            r122.add(this.f521418d.b());
            r108.f245377n.put("anchor_types", r122);
            r108.f245387x = true;
            r108.f245388y = true;
            hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + this.f521418d.b() + " handleResidueResourceEvent eventId=" + r108.f245366c + " eventName=" + r108.f245367d + " eventStartTime=" + r108.f245376m + " eventAnchorReportCount=" + r121.getAnchorCheckCount());
            if (r121.getAnchorCheckCount() != this.f521415a.g()) goto L70;
            r108.f245383t = 4;
            r108.f245384u.add("pair_not_close");
            r108.f245384u.remove("pair_delay_close");
            AnchorExtra r123 = r108.B;
            Set<Object> r124 = null;
            if (r123 == null) goto L51;
            Set<Object> r125 = r123.getHistoryFloatingViewEvents();
        L52:
            Set<Object> r126 = r125;
            if (r126 != null) goto L55;
        L58:
            boolean r127 = true;
        L59:
            if (r127 == true) goto L64;
            Map<String, Object> r128 = r108.f245377n;
            AnchorExtra r129 = r108.B;
            if (r129 == null) goto L63;
            r124 = r129.getHistoryFloatingViewEvents();
        L63:
            r128.put("floating_views", r124);
        L64:
            if (r120 != null) goto L66;
        L68:
            hz5.l.b(r108);
            goto L72
        L66:
            if ((r120 instanceof Fragment) == false) goto L68;
            r108.f245377n.put(WidgetService.PARAM_FRAGMENT, ((Fragment) r120).getClass().getName());
            goto L68
        L55:
            if (r126.isEmpty() == true) goto L58;
            r127 = false;
            goto L59
        L51:
            r125 = null;
            goto L52
        L70:
            if (r121.getAnchorCheckCount() >= this.f521415a.g()) goto L72;
            r108.f245384u.add("pair_delay_close");
        L72:
            r103 = true;
            goto L39
        L73:
            if (r103 == false) goto L92;
            com.bytedance.helios.common.utils.d.f().postDelayed(this, this.f521415a.c());
            hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + this.f521418d.b() + " continueAnchorCheck runnable=" + hashCode() + " model=" + this.f521415a);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6996a(a r100, AnchorInfoModel r101, Object r102, List<String> r103) {
            this.f521418d = r100;
            this.f521415a = r101;
            this.f521416b = r102;
            this.f521417c = r103;
        }
    }

    public abstract String b();

    public abstract boolean c(AnchorInfoModel r100, Object r101);

    public abstract boolean e();

    public a() {
        this.f521414a = new LinkedHashMap();
    }

    public void a(String r100, AnchorInfoModel r101, Object r102) {
        g(r100, r102, "addAnchorRunnable");
        if (f(r101, r102, "Add") == false) goto L5;
        return;
    L5:
        h(r100, r101, r102, r101.i());
    }

    public List<PrivacyEvent> d(List<PrivacyEvent> r100, AnchorInfoModel r101, Object r102) {
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (r101.j().contains(((PrivacyEvent) r105).f245374k) == false) goto L8;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        if (e() == true) goto L10;
    L12:
        r106 = false;
        goto L14
    L10:
        if (r101.j().isEmpty() == false) goto L12;
    L16:
        return r103;
    }

    public final boolean f(AnchorInfoModel r100, Object r101, String r102) {
        CopyOnWriteArrayList<g> r103 = h.f521423b;
        ArrayList r104 = new ArrayList();
        Iterator<g> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r105.next().getClass();
        CollectionsKt.addAll(r104, null);
        goto L4
    L6:
        Set r106 = CollectionsKt.toSet(r104);
        boolean r107 = r100.k().contains("floating_window_view");
        boolean r108 = true;
        boolean r109 = !CollectionsKt.intersect(r106, r100.j()).isEmpty();
        if (e() == true) goto L9;
    L13:
        boolean r110 = false;
    L14:
        if (r107 == false) goto L18;
        if (r109 == true) goto L20;
        if (r110 == false) goto L18;
    L20:
        if (r108 == false) goto L22;
        hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + b() + " needSkipAddOrRunAnchorCheck tag=" + r102 + " needSkipByFloatingView=" + r108 + " model=" + r100);
    L25:
        return r108;
    L22:
        r108 = c(r100, r101);
        if (r108 == false) goto L25;
        hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + b() + " needSkipAddOrRunAnchorCheck tag=" + r102 + " needCustomSkipAddOrRunAnchorCheck=" + r108 + " model=" + r100);
    L18:
        r108 = false;
        goto L20
    L9:
        if ((!r106.isEmpty()) == false) goto L13;
        if (r100.j().isEmpty() == false) goto L13;
        r110 = true;
        goto L14
    }

    public void g(String r100, Object r101, String r102) {
        RunnableC6996a r103 = (RunnableC6996a) ((LinkedHashMap) this.f521414a).get(r100);
        if (r103 == null) goto L6;
        com.bytedance.helios.common.utils.d.f().removeCallbacks(r103);
        this.f521414a.remove(r100);
        hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + b() + " removeAnchorRunnable key=" + r100 + " tag=" + r102);
        return;
    }

    public final void h(String r100, AnchorInfoModel r101, Object r102, List<String> r103) {
        RunnableC6996a r104 = new RunnableC6996a(this, r101, r102, r103);
        this.f521414a.put(r100, r104);
        com.bytedance.helios.common.utils.d.f().postDelayed(r104, r101.c());
        hz5.k.d("Helios-Log-Detection-Task", "anchorType=" + b() + " addAnchorRunnable key=" + r100 + " resourceIds=" + r103 + " model=" + r101);
    }
}
