package sz5;

import com.bytedance.helios.api.consumer.AnchorExtra;
import com.bytedance.helios.api.consumer.EventHandler;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.bytedance.helios.sdk.detector.e;
import com.bytedance.helios.sdk.detector.f;
import com.bytedance.helios.sdk.detector.r;
import com.bytedance.helios.sdk.detector.u;
import com.bytedance.helios.sdk.region.FixSizeLinkedList;
import com.bytedance.locallife.cube.PrefetchTiming;
import gz5.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements EventHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f543945b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f543946a;

    /* JADX INFO: renamed from: sz5.a$a, reason: collision with other inner class name */
    public static final class C7673a {
        public static void a(PrivacyEvent r100) {
            Set<Object> r101 = r100.f245389z.getHitControlConfigs();
            if (r101 == null) goto L71;
            Set r102 = TypeIntrinsics.asMutableSet(r101);
            Set<Object> r103 = r100.f245389z.getRuleModels();
            if (r103 == null) goto L69;
            Set r104 = TypeIntrinsics.asMutableSet(r103);
            Iterator r105 = r102.iterator();
        L7:
            boolean r106 = false;
            if (r105.hasNext() == false) goto L26;
            l r107 = (l) r105.next();
            String r108 = r107.f();
            if (r108 != null) goto L12;
        L13:
            r106 = true;
        L14:
            if (r106 == true) goto L19;
            Set<String> r109 = r100.f245384u;
            String r110 = r107.f();
            if (r110 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            r109.add(r110);
        L19:
            Boolean r111 = r107.e();
            if (r111 == null) goto L22;
            r100.f245387x = r111.booleanValue();
        L22:
            Boolean r112 = r107.d();
            if (r112 == null) goto L7;
            r100.f245388y = r112.booleanValue();
            goto L7
        L12:
            if (StringsKt.isBlank(r108) == false) goto L14;
        L26:
            if ((!r102.isEmpty()) == false) goto L29;
            r100.f245377n.put("hit_control_configs", e06.c.c(r102));
        L29:
            if ((!r104.isEmpty()) == false) goto L31;
            r100.f245377n.put("ruleModes", e06.c.c(r104));
        L31:
            Set<Object> r113 = null;
            if (r100.f245384u.contains("cross_region") == false) goto L34;
        L35:
            Map<String, Object> r114 = r100.f245377n;
            FixSizeLinkedList<Map<String, Object>> r115 = uz5.c.f552189a;     // Catch: Exception -> L44
            if (r115 == null) goto L41;
            List r116 = CollectionsKt.toList(r115);     // Catch: Exception -> L44
            if (r116 == null) goto L41;
            List r117 = CollectionsKt.sortedWith(r116, new uz5.b());     // Catch: Exception -> L44
        L42:
            List r118 = r117;     // Catch: Exception -> L44
        L45:
            r114.put("location_timeline", e06.c.c(r118));
        L46:
            r100.f245377n.put("milestone_events", HeliosEnvImpl.get().f245471n);
            AnchorExtra r119 = r100.B;
            if (r119 == null) goto L49;
            int r120 = r119.getAnchorCheckCount();
        L51:
            if (r100.f245383t != 1) goto L79;
            if (r120 <= 0) goto L80;
            AnchorExtra r121 = r100.B;
            if (r121 == null) goto L56;
            Set<Object> r122 = r121.getHistoryFloatingViewEvents();
        L57:
            Set<Object> r123 = r122;
            if (r123 != null) goto L60;
        L61:
            r106 = true;
        L62:
            if (r106 == true) goto L81;
            Map<String, Object> r124 = r100.f245377n;
            AnchorExtra r125 = r100.B;
            if (r125 == null) goto L66;
            r113 = r125.getHistoryFloatingViewEvents();
        L66:
            r124.put("floating_views", r113);
            return;
        L81:
            return;
        L60:
            if (r123.isEmpty() == false) goto L62;
        L56:
            r122 = null;
            goto L57
        L80:
            return;
        L79:
            return;
        L49:
            r120 = 0;
        L41:
            r117 = null;
        L44:
            r118 = uz5.c.f552189a;
            goto L45
        L34:
            if (r100.f245384u.contains("location_region_limit") == false) goto L46;
        L69:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<com.bytedance.ruler.base.models.RuleModel>");
        L71:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<com.bytedance.helios.api.config.ControlConfig>");
        }

        public static void b(PrivacyEvent r100) {
            if (Intrinsics.areEqual(r100.D, PrefetchTiming.JSB) == false) goto L6;
            r100.f245384u.add(PrefetchTiming.JSB);
        L6:
            if (StringsKt.startsWith$default(r100.f245379p, "AppOpsException_", false, 2, null) == false) goto L28;
            r100.f245384u.add("app_ops");
            String r101 = r100.f245368e;
            switch(r101.hashCode()) {
                case -1671423430: goto L26;
                case -1220541694: goto L23;
                case -517868421: goto L20;
                case -210165041: goto L17;
                case 1191287187: goto L14;
                case 1528082064: goto L11;
                default: goto L28;
            };
        L11:
            if (r101.equals("android:camera") == false) goto L28;
            int[] r102 = f.f245522a;
            r100.F = "Camera";
            goto L28
        L14:
            if (r101.equals("android:record_audio") == false) goto L28;
            int[] r103 = com.bytedance.helios.sdk.detector.c.f245517a;
            r100.F = "AudioRecord";
            goto L28
        L17:
            if (r101.equals("android:fine_location") == false) goto L28;
        L27:
            int[] r104 = r.f245546a;
            r100.F = "Location";
            goto L28
        L20:
            if (r101.equals("android:read_phone_numbers") == false) goto L28;
        L24:
            int[] r105 = u.f245552a;
            r100.F = "PhoneState";
            goto L28
        L23:
            if (r101.equals("android:read_phone_state") == false) goto L28;
        L26:
            if (r101.equals("android:coarse_location") == true) goto L27;
        L28:
            String r106 = r100.f245365b;
            int[] r107 = e.f245521a;
            if (Intrinsics.areEqual(r106, "as") == false) goto L32;
            r100.f245384u.add("service");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final int stage() {
        return 5;
    }

    public a(b r100) {
        this.f543946a = r100;
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final void a(PrivacyEvent r100) {
        if (Intrinsics.areEqual(r100.f245379p, "SensitiveApiException") == false) goto L5;
        this.f543946a.a(r100);
    L5:
        C7673a.a(r100);
        C7673a.b(r100);
    }
}
