package t6c;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f544842a = 0;

    public static final class a {
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public static f b(s6c.a r110) {
            Intrinsics.checkNotNullParameter(r110, "node");
            f r100 = new f(r110);
            ArrayList<s6c.a> r111 = r110.f540888i;
            int r101 = 0;
        L4:
            if (r101 >= r111.size()) goto L24;
            if (((s6c.a) ListProtector.get(r111, r101)).f540885f == false) goto L7;
            if (((s6c.a) ListProtector.get(r111, r101)).f540888i.isEmpty() == true) goto L10;
            if (((s6c.a) ListProtector.get(r111, r101)).f540888i.size() == 1) goto L13;
            s6c.a r102 = (s6c.a) ListProtector.get(r111, r101);
            int r103 = r102.f540888i.size();
            int r104 = 0;
        L18:
            if (r104 >= r103) goto L23;
            RectF r105 = r102.a();
            PointF r106 = new PointF(r105.left, r105.top);
            ((s6c.a) ListProtector.get(r102.f540888i, r104)).k(r106);
            if (r102.f540886g == false) goto L22;
            ((s6c.a) ListProtector.get(r102.f540888i, r104)).f540886g = true;
        L22:
            r104 = r104 + 1;
            goto L18
        L23:
            ArrayList<s6c.a> r107 = ((s6c.a) ListProtector.get(r111, r101)).f540888i;
            ListProtector.remove(r111, r101);
            r111.addAll(r101, r107);
            goto L4
        L13:
            RectF r108 = ((s6c.a) ListProtector.get(r111, r101)).a();
            PointF r109 = new PointF(r108.left, r108.top);
            ((s6c.a) ListProtector.get(((s6c.a) ListProtector.get(r111, r101)).f540888i, 0)).k(r109);
            if (((s6c.a) ListProtector.get(r111, r101)).f540886g == false) goto L16;
            ((s6c.a) ListProtector.get(((s6c.a) ListProtector.get(r111, r101)).f540888i, 0)).f540886g = true;
        L16:
            ListProtector.set(r111, r101, ListProtector.get(((s6c.a) ListProtector.get(r111, r101)).f540888i, 0));
            goto L4
        L10:
            Intrinsics.checkNotNull(ListProtector.remove(r111, r101));
            goto L4
        L7:
            r101 = r101 + 1;
            goto L4
        L24:
            Iterator<s6c.a> r112 = r111.iterator();
        L26:
            if (r112.hasNext() == false) goto L30;
            s6c.a r113 = r112.next();
            if (r113.f540886g == true) goto L26;
            r100.f544854b.add((f<TreeNode>) b(r113));
            goto L26
        L30:
            return r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(f r110, View r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r110, "renderTree");
            Intrinsics.checkNotNullParameter(r111, "view");
            s6c.a r100 = (s6c.a) r110.f544853a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r111, "view");
            s6c.b r101 = r100.f540882c;
            if (r101 == null) goto L5;
            r101.e(r111);
            boolean r102 = true;
        L6:
            if (r102 == true) goto L8;
            return;
        L8:
            if (r112 == true) goto L10;
        L11:
            ((s6c.a) r110.f544853a).n(r111);
            ((s6c.a) r110.f544853a).i();
        L13:
            if (((s6c.a) r110.f544853a).f540888i.isEmpty() == false) goto L16;
            return;
        L16:
            if ((r111 instanceof ViewGroup) == false) goto L75;
            ViewGroup r103 = (ViewGroup) r111;
            Intrinsics.checkNotNullParameter(r103, "view");
            HashMap r104 = new HashMap();
            int r105 = r103.getChildCount();
            int r106 = 0;
        L18:
            int r113 = R.id.view_class_name;
            if (r106 >= r105) goto L28;
            Object r114 = r103.getChildAt(r106).getTag(R.id.view_class_name);
            if (r114 == null) goto L27;
            String r115 = (String) r114;
            ArrayList r116 = (ArrayList) r104.get(r115);
            if (r116 != null) goto L26;
            r116 = new ArrayList();
            r104.put(r115, r116);
        L26:
            r116.add(Integer.valueOf(r106));
        L27:
            r106 = r106 + 1;
            goto L18
        L28:
            int r107 = r110.f544854b.size();
            int r108 = 0;
        L29:
            if (r108 >= r107) goto L65;
            s6c.a r117 = (s6c.a) ((f) ListProtector.get(r110.f544854b, r108)).f544853a;
            String r118 = r117.f540881b;
            Intrinsics.checkNotNullParameter(r118, "tag");
            ArrayList r119 = (ArrayList) r104.get(r118);
            if (r119 != null) goto L33;
        L36:
            boolean r120 = true;
        L37:
            if (r120 == false) goto L39;
            int r121 = -1;
        L40:
            if (r121 < 0) goto L52;
            if (r121 == r108) goto L49;
            View r122 = r103.getChildAt(r108);
            ArrayList r123 = (ArrayList) r104.get(r122.getTag(r113));
            if (r123 == null) goto L45;
            Integer r109 = (Integer) ListProtector.set(r123, r123.indexOf(Integer.valueOf(r108)), Integer.valueOf(r121));
        L45:
            View r124 = r103.getChildAt(r121);
            if (r121 <= r108) goto L48;
            r103.removeViewAt(r121);
            r103.addView(r124, r108);
            r103.removeView(r122);
            r103.addView(r122, r121);
            goto L49
        L48:
            r103.removeViewAt(r108);
            r103.addView(r122, r121);
            r103.removeView(r124);
            r103.addView(r124, r108);
        L49:
            View r125 = r103.getChildAt(r108);
            r111.setTag(R.id.virtual_node_id, r117.f540880a);
            Intrinsics.checkNotNull(r125);
            Intrinsics.checkNotNullParameter(r125, "view");
            s6c.b r126 = r117.f540882c;
            if (r126 == null) goto L64;
            r126.f();
        L64:
            r108 = r108 + 1;
            r113 = R.id.view_class_name;
            goto L29
        L52:
            View r127 = r117.d();
            if (r127 == null) goto L64;
            Intrinsics.checkNotNullParameter(r127, "subview");
            r103.addView(r127, r108);
            Collection r128 = r104.values();
            ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
            Iterator r130 = r128.iterator();
        L56:
            if (r130.hasNext() == false) goto L61;
            ArrayList r131 = (ArrayList) r130.next();
            int r132 = r131.size();
            int r133 = 0;
        L58:
            if (r133 >= r132) goto L60;
            ListProtector.set(r131, r133, Integer.valueOf(((Number) ListProtector.get(r131, r133)).intValue() + 1));
            r133 = r133 + 1;
            goto L58
        L60:
            r129.add(Unit.INSTANCE);
            goto L56
        L61:
            Intrinsics.checkNotNullParameter(r127, "view");
            s6c.b r134 = r117.f540882c;
            if (r134 == null) goto L64;
            r134.f();
            goto L64
        L39:
            int r135 = ((Number) CollectionsKt.first(r119)).intValue();
            r119.remove(Integer.valueOf(r135));
            r121 = r135;
            goto L40
        L33:
            if (r119.isEmpty() == true) goto L36;
            r120 = false;
            goto L37
        L65:
            int r136 = r103.getChildCount() - 1;
            if (r107 <= r136) goto L68;
        L72:
            int r137 = r110.f544854b.size();
            int r138 = 0;
        L73:
            if (r138 >= r137) goto L89;
            a((f) ListProtector.get(r110.f544854b, r138), r103.getChildAt(r138), r112);
            r138 = r138 + 1;
            goto L73
        L89:
            return;
        L68:
            if (r103.getChildAt(r136).getVisibility() == 8) goto L70;
            r103.removeViewAt(r136);
        L70:
            if (r136 == r107) goto L72;
            r136 = r136 - 1;
            goto L68
        L75:
            return;
        L10:
            if (((s6c.a) r110.f544853a).h() == false) goto L13;
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
    }
}
