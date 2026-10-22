package hma;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.picker.reels.views.WheelView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f486018a;

    public static final class a implements d<c, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Consumer<b> f486019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f486020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f486021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<gma.a.b> f486022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<Integer, Integer> f486023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OReelPickerMulti f486024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final hma.b f486025g;

        /* JADX WARN: Type inference failed for: r0v2, types: [hma.b] */
        public a() {
            this.f486022d = new ArrayList();
            this.f486023e = new LinkedHashMap();
            this.f486025g = new hma.b(this);
        }

        @Override // hma.d
        public final c a(Context r100, AttributeSet r110, int r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ArrayList r101 = new ArrayList();
            Integer r102 = this.f486020b;
            if (r102 != null) goto L5;
            int r103 = -1;
        L6:
            Integer r104 = this.f486021c;
            if (r104 != null) goto L9;
            int r105 = -1;
        L10:
            Iterator r106 = ((ArrayList) this.f486022d).iterator();
        L12:
            if (r106.hasNext() == false) goto L14;
            gma.a.b r107 = (gma.a.b) r106.next();
            Intrinsics.checkNotNullParameter(r107, "reel");
            r101.add(r107);
            goto L12
        L14:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r103 != (-1)) goto L17;
            r103 = pla.d.c(r100, 328);
        L17:
            if (r105 != (-1)) goto L19;
            r105 = pla.d.c(r100, 240);
        L19:
            OReelPickerMulti r108 = new OReelPickerMulti(r100, r110, r111);
            r108.setLayoutParams(new LinearLayout.LayoutParams(r103, r105));
            int r109 = r105 - (pla.d.c(r100, 16) * 2);
            r101.size();
            ((ArrayList) r108.f402142b).clear();
            r108.f402141a.removeAllViews();
            Iterator r112 = r101.iterator();
        L20:
            int r113 = 0;
            if (r112.hasNext() == false) goto L27;
            Integer r114 = ((gma.a.b) r112.next()).f481780e;
            if (r114 == null) goto L25;
            LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(r114.intValue(), -1);
        L26:
            WheelView r116 = new WheelView(r108.getContext(), null, 6, r113);
            r116.setLayoutParams(r115);
            r116.setMinimumHeight(r109);
            r116.setCyclic(false);
            r108.f402141a.addView(r116);
            ((ArrayList) r108.f402142b).add(r116);
            goto L20
        L25:
            r115 = new LinearLayout.LayoutParams(-2, -1);
            goto L26
        L27:
            Iterator r117 = r101.iterator();
        L29:
            if (r117.hasNext() == false) goto L34;
            Object r118 = r117.next();
            int r119 = r113 + 1;
            if (r113 >= 0) goto L33;
            CollectionsKt.throwIndexOverflow();
        L33:
            r108.R5(r113, (gma.a.b) r118);
            r113 = r119;
            goto L29
        L34:
            this.f486024f = r108;
            c r120 = new c();
            r120.f486018a = this;
            return r120;
        L9:
            r105 = r104.intValue();
            goto L10
        L5:
            r103 = r102.intValue();
            goto L6
        }

        public static void b(a r100, Context r110, int r111, Integer r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            List r101 = ArraysKt.toList(DateFormatSymbols.getInstance().getAmPmStrings());
            if (r112 != null) goto L5;
            int r102 = 0;
        L6:
            h(r100, r111, r101, null, r102, null, null, r110, 80);
            return;
        L5:
            r102 = Math.max(0, Math.min(r112.intValue(), r101.size() - 1));
            goto L6
        }

        public static void c(a r110, Context r111, int r112, Integer r113) {
            Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r100 = h.f486051a;
            List r101 = h.d(1, 31, r111.getString(R.string.oui_reel_picker_day_tag), 0, 8);
            if (r113 != null) goto L5;
            int r114 = 0;
        L6:
            h(r110, r112, r101, null, r114, Integer.valueOf(pla.d.c(r111, 101)), null, null, 208);
            return;
        L5:
            r114 = Math.max(0, Math.min(r113.intValue() - 1, 30));
            goto L6
        }

        public final void f(Context r110, int r111, Integer r112, Integer r113) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r100 = h.f486051a;
            List r101 = h.b(r110);
            if (r112 != null) goto L5;
            int r102 = 0;
        L7:
            if (r113 != null) goto L9;
            int r114 = pla.d.c(r110, 101);
        L10:
            h(this, r111, r101, null, r102, Integer.valueOf(r114), null, null, 208);
            return;
        L9:
            r114 = r113.intValue();
            goto L10
        L5:
            r102 = Math.max(0, Math.min(r112.intValue() - 1, 11));
            goto L7
        }

        public static void e(a r100, Context r110, int r111, boolean r112, Integer r113) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            List r101 = h.d(0, 59, "", 0, 8);
            if (r112 == false) goto L5;
            String r102 = r110.getString(R.string.oui_reel_tag_minute);
        L6:
            if (r112 == false) goto L8;
            Integer r114 = Integer.valueOf(pla.d.c(r110, 2));
        L9:
            if (r113 != null) goto L11;
            int r115 = 0;
        L12:
            h(r100, r111, r101, r102, r115, null, r114, r110, 16);
            return;
        L11:
            r115 = Math.max(0, Math.min(r113.intValue(), 59));
            goto L12
        L8:
            r114 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }

        public static void d(a r100, Context r110, int r111, boolean r112, boolean r113, Integer r114) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r101 = !r112 ? 1 : 0;
            if (r112 == false) goto L5;
            int r115 = 23;
        L6:
            List r102 = h.d(r101, r115, "", 0, 8);
            Integer r116 = null;
            if (r113 == false) goto L9;
            String r103 = r110.getString(R.string.oui_reel_tag_hour);
        L10:
            if (r113 == false) goto L12;
            r116 = Integer.valueOf(pla.d.c(r110, 2));
        L12:
            Integer r104 = r116;
            if (r114 != null) goto L15;
            int r117 = 0;
        L16:
            h(r100, r111, r102, r103, r117, null, r104, r110, 16);
            return;
        L15:
            r117 = Math.max(0, Math.min(r114.intValue() - r101, ((ArrayList) r102).size() - 1));
            goto L16
        L9:
            r103 = null;
            goto L10
        L5:
            r115 = 12;
            goto L6
        }

        public static /* synthetic */ void j(a r100, Context r101, int r102, int r110, int r111, Integer r112) {
            r100.i(r101, r102, r110, r111, r112, null);
        }

        public final void i(Context r110, int r111, int r112, int r113, Integer r114, Integer r210) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r100 = h.f486051a;
            List r101 = h.d(r112, r113, r110.getString(R.string.oui_reel_picker_year_tag), 0, 8);
            if (r114 != null) goto L5;
            int r102 = 0;
        L7:
            if (r210 != null) goto L9;
            int r103 = pla.d.c(r110, 101);
        L10:
            h(this, r111, r101, null, r102, Integer.valueOf(r103), null, null, 208);
            return;
        L9:
            r103 = r210.intValue();
            goto L10
        L5:
            r102 = Math.max(0, Math.min(r114.intValue() - r112, ((ArrayList) r101).size() - 1));
            goto L7
        }

        public final void g(int r110, List r111, String r112, int r113, float r114, Integer r115, Integer r210, Context r211) {
            Intrinsics.checkNotNullParameter(r111, "entries");
            if (r115 != null) goto L11;
            if (r211 == null) goto L11;
            if (r112 != null) goto L9;
            if (r210 != null) goto L9;
            Integer r100 = Integer.valueOf(pla.d.c(r211, 72));
        L10:
            Integer r101 = r100;
        L12:
            List<gma.a.b> r102 = this.f486022d;
            ArrayList r103 = (ArrayList) r102;
            r103.add(new gma.a.b(r110, r111, r112, r114, r115, r101, r210, r113, this.f486025g));
            this.f486023e.put(Integer.valueOf(r110), Integer.valueOf(r113));
            return;
        L9:
            r100 = Integer.valueOf(pla.d.c(r211, 92));
        L11:
            r101 = r115;
            goto L12
        }

        public static /* synthetic */ void h(a r110, int r111, List r112, String r113, int r114, Integer r115, Integer r116, Context r117, int r210) {
            if ((r210 & 4) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r210 & 8) == 0) goto L9;
            int r101 = 0;
        L11:
            if ((r210 & 16) == 0) goto L13;
            float r102 = 1.0f;
        L15:
            if ((r210 & 32) == 0) goto L17;
            Integer r103 = null;
        L19:
            if ((r210 & 64) == 0) goto L21;
            Integer r118 = null;
        L23:
            if ((r210 & 128) == 0) goto L25;
            Context r119 = null;
        L26:
            r110.g(r111, r112, r100, r101, r102, r103, r118, r119);
            return;
        L25:
            r119 = r117;
            goto L26
        L21:
            r118 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = 0.0f;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Integer, Integer> f486026a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486026a, ((b) r100).f486026a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486026a.hashCode();
        }

        public final String toString() {
            return "PickedData(selections=" + this.f486026a + ')';
        }

        public b() {
            this(MapsKt.emptyMap());
        }

        public b(Map<Integer, Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "selections");
            this.f486026a = r100;
        }
    }

    public final OReelPickerMulti a() {
        a r100 = this.f486018a;
        if (r100 == null) goto L7;
        OReelPickerMulti r101 = r100.f486024f;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return null;
    }

    public final b b() {
        a r100 = this.f486018a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return new b(MapsKt.toMap(r100.f486023e));
    }

    public c() {
    }
}
