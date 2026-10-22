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

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f533877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f533878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Uri f533879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f533880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f533881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<String> f533882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f533883g;

    public interface a {
        void exit();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f533884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f533885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f533886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f533887d;

        public static final class a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Fragment f533888a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f533889b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Integer f533890c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f533891d;

            public a(Fragment r100, FragmentManager r101, Integer r102, a r103) {
                this.f533888a = r100;
                this.f533889b = r101;
                this.f533890c = r102;
                this.f533891d = r103;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L61;
                tt5.a.b("SheetPanelRouter", this.f533888a + " observed a valid uri : " + d.f533879c);
                Fragment r101 = this.f533888a;
                FragmentManager r102 = this.f533889b;
                Integer r103 = this.f533890c;
                a r104 = this.f533891d;
                Iterator<T> r105 = MapsKt.asSequence(d.f533877a).iterator();
            L5:
                Fragment r106 = null;
                if (r105.hasNext() == false) goto L10;
                T r107 = r105.next();
                if (Intrinsics.areEqual(((Map.Entry) r107).getValue(), r101.getClass().getName()) == false) goto L5;
            L11:
                Map.Entry r108 = (Map.Entry) r107;
                if (r108 == null) goto L15;
                String r109 = (String) r108.getKey();
                if (r109 == null) goto L15;
            L16:
                boolean r110 = false;
                if (Intrinsics.areEqual(r109, "oppanel") == false) goto L27;
                String r111 = d.f533883g;
                if (r111 == null) goto L27;
                if ((r101 instanceof FabPanelFragment) == false) goto L23;
                FabPanelFragment r112 = (FabPanelFragment) r101;
            L24:
                if (r112 == null) goto L27;
                r112.sF(r111, false);
                goto L27
            L23:
                r112 = null;
            L27:
                if (Intrinsics.areEqual(CollectionsKt.lastOrNull(d.f533882f), r109) == false) goto L30;
                j.d(e.f533892a, 500);
                return;
            L30:
                if (d.f533882f.contains(r109) == true) goto L32;
            L34:
                if (r110 == false) goto L56;
                Bundle r113 = new Bundle();
                int r114 = d.f533882f.indexOf(r109);
                int r115 = r114 + 1;
                if (r114 != d.f533882f.size()) goto L38;
                String r116 = null;
            L39:
                if (r116 == null) goto L67;
                if (r102 == null) goto L43;
                r106 = r102.findFragmentByTag(r116);
            L43:
                if (r102 == null) goto L63;
                FragmentTransaction r117 = r102.beginTransaction();
                if (r117 == null) goto L64;
                if (r106 != null) goto L55;
                if (r103 == null) goto L55;
                if (r101.getContext() == null) goto L55;
                PluginHost.writePluginHostToBundle(r101, r113);
                Fragment r118 = Fragment.instantiate(r101.requireContext(), r116, r113);
                int r119 = r103.intValue();
                Intrinsics.checkNotNull(r118);
                if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r117, r118, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r116, r119) == true) goto L54;
                r117 = r117.add(r119, r118, r116);
            L54:
                r117.commitAllowingStateLoss();
                return;
            L55:
                Intrinsics.checkNotNull(r106);
                r117.show(r106).commitAllowingStateLoss();
                return;
            L64:
                return;
            L63:
                return;
            L67:
                return;
            L38:
                r116 = d.f533877a.get((String) ListProtector.get(d.f533882f, r115));
                goto L39
            L56:
                r104.exit();
                return;
            L32:
                if (Intrinsics.areEqual(CollectionsKt.lastOrNull(d.f533882f), r109) == true) goto L34;
                r110 = true;
            L15:
                r109 = "";
                goto L16
            L10:
                r107 = null;
                goto L11
            }
        }

        public b(Fragment r100, FragmentManager r101, Integer r102, a r103) {
            this.f533884a = r100;
            this.f533885b = r101;
            this.f533886c = r102;
            this.f533887d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData<Boolean> r100 = d.f533878b;     // Catch: Throwable -> L4
            Fragment r101 = this.f533884a;     // Catch: Throwable -> L4
            r100.observe(r101, new a(r101, this.f533885b, this.f533886c, this.f533887d));     // Catch: Throwable -> L4
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
        f533877a = MapsKt.mapOf(new Pair[]{TuplesKt.to("oppanel", FabPanelFragment.class.getName()), TuplesKt.to("color", SheetSelectColorFragment.class.getName()), TuplesKt.to("borderLine", BorderLineFragment.class.getName()), TuplesKt.to("freezeSheet", FreezeFragment.class.getName()), TuplesKt.to("filter", FilterFragment.class.getName()), TuplesKt.to("sort", SortFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_VALUE, SubFilterValueFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_COLOR, SubFilterColorFragment.class.getName()), TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_CONDITION, SubFilterConditionFragment.class.getName())});
        f533878b = new MutableLiveData();
        f533882f = new ArrayList();
    }

    public static void a(Fragment r100, FragmentManager r101, Integer r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, "curFragment");
        Intrinsics.checkNotNullParameter(r103, "callBack");
        View r104 = r100.getView();
        if (r104 == null) goto L6;
        r104.post(new b(r100, r101, r102, r103));
        return;
    }
}
