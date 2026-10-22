package qm5;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.sheet.borderline.BorderLineFragment;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.bear.sheet.filter.FilterFragment;
import com.bytedance.ee.bear.sheet.filter.SubFilterColorFragment;
import com.bytedance.ee.bear.sheet.filter.SubFilterConditionFragment;
import com.bytedance.ee.bear.sheet.filter.SubFilterValueFragment;
import com.bytedance.ee.bear.sheet.panel.operation.FreezeFragment;
import com.bytedance.ee.bear.sheet.panel.oppanel.FabPanelFragment;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorFragment;
import com.bytedance.ee.bear.sheet.sort.SortFragment;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final Map<String, String> a = null;
    public static final MutableLiveData<Boolean> b = null;
    public static Uri c;
    public static String d;
    public static String e;
    public static List<String> f;
    public static String g;

    public interface a {
        void exit();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ FragmentManager b;
        public final /* synthetic */ Integer c;
        public final /* synthetic */ a d;

        public static final class a<T> implements Observer {
            public final /* synthetic */ Fragment a;
            public final /* synthetic */ FragmentManager b;
            public final /* synthetic */ Integer c;
            public final /* synthetic */ a d;

            public a(Fragment r1, FragmentManager r2, Integer r3, a r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void onChanged(Object r9) {
                if (Intrinsics.areEqual((Boolean) r9, Boolean.TRUE) == false) goto L61;
                tt5.a.b("SheetPanelRouter", this.a + " observed a valid uri : " + d.c);
                FabPanelFragment r10 = this.a;
                FragmentManager r0 = this.b;
                Integer r1 = this.c;
                a r2 = this.d;
                Iterator r3 = MapsKt.asSequence(d.a).iterator();
            L5:
                Fragment r5 = null;
                if (r3.hasNext() == false) goto L10;
                Object r4 = r3.next();
                if (Intrinsics.areEqual(((Map.Entry) r4).getValue(), r10.getClass().getName()) == false) goto L5;
            L11:
                Map.Entry r6 = (Map.Entry) r4;
                if (r6 == null) goto L15;
                String r7 = (String) r6.getKey();
                if (r7 == null) goto L15;
            L16:
                boolean r8 = false;
                if (Intrinsics.areEqual(r7, "oppanel") == false) goto L27;
                String r11 = d.g;
                if (r11 == null) goto L27;
                if ((r10 instanceof FabPanelFragment) == false) goto L23;
                FabPanelFragment r12 = r10;
            L24:
                if (r12 == null) goto L27;
                r12.sF(r11, false);
                goto L27
            L23:
                r12 = null;
            L27:
                if (Intrinsics.areEqual(CollectionsKt.lastOrNull(d.f), r7) == false) goto L30;
                j.d(e.a, 500);
                return;
            L30:
                if (d.f.contains(r7) == true) goto L32;
            L34:
                if (r8 == false) goto L56;
                Bundle r13 = new Bundle();
                int r14 = d.f.indexOf(r7);
                int r15 = r14 + 1;
                if (r14 != d.f.size()) goto L38;
                String r16 = null;
            L39:
                if (r16 == null) goto L67;
                if (r0 == null) goto L43;
                r5 = r0.findFragmentByTag(r16);
            L43:
                if (r0 == null) goto L63;
                FragmentTransaction r17 = r0.beginTransaction();
                if (r17 == null) goto L64;
                if (r5 != null) goto L55;
                if (r1 == null) goto L55;
                if (r10.getContext() == null) goto L55;
                PluginHost.writePluginHostToBundle(r10, r13);
                Fragment r18 = Fragment.instantiate(r10.requireContext(), r16, r13);
                int r19 = r1.intValue();
                Intrinsics.checkNotNull(r18);
                if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r16, r19) == true) goto L54;
                r17 = r17.add(r19, r18, r16);
            L54:
                r17.commitAllowingStateLoss();
                return;
            L55:
                Intrinsics.checkNotNull(r5);
                r17.show(r5).commitAllowingStateLoss();
                return;
            L64:
                return;
            L63:
                return;
            L67:
                return;
            L38:
                r16 = d.a.get((String) ListProtector.get(d.f, r15));
                goto L39
            L56:
                r2.exit();
                return;
            L32:
                if (Intrinsics.areEqual(CollectionsKt.lastOrNull(d.f), r7) == true) goto L34;
                r8 = true;
            L15:
                r7 = "";
                goto L16
            L10:
                r4 = null;
                goto L11
            }
        }

        public b(Fragment r1, FragmentManager r2, Integer r3, a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData<Boolean> r0 = d.b;     // Catch: Throwable -> L4
            Fragment r1 = this.a;     // Catch: Throwable -> L4
            r0.observe(r1, new a(r1, this.b, this.c, this.d));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("oppanel", FabPanelFragment.class.getName()), TuplesKt.to("color", SheetSelectColorFragment.class.getName()), TuplesKt.to("borderLine", BorderLineFragment.class.getName()), TuplesKt.to("freezeSheet", FreezeFragment.class.getName()), TuplesKt.to("filter", FilterFragment.class.getName()), TuplesKt.to("sort", SortFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_VALUE, SubFilterValueFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_COLOR, SubFilterColorFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_CONDITION, SubFilterConditionFragment.class.getName())});
        b = new MutableLiveData();
        f = new ArrayList();
    }

    public static void a(Fragment r2, FragmentManager r3, Integer r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "curFragment");
        Intrinsics.checkNotNullParameter(r5, "callBack");
        View r0 = r2.getView();
        if (r0 == null) goto L6;
        r0.post(new b(r2, r3, r4, r5));
        return;
    }
}
