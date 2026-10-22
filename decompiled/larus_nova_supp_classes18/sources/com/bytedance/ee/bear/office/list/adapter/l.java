package com.bytedance.ee.bear.office.list.adapter;

import android.os.Bundle;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeListPageMenuCapabilityRegistry;
import dd5.c1;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public static final a a = null;

    public static final class a implements c1 {
        public a() {
        }

        @Override // dd5.c1
        public final OfficeDocumentAdapter a(String r35, boolean r36, LifeCycleFragment r37, ce5.a r38) {
            Intrinsics.checkNotNullParameter(r35, "module");
            Intrinsics.checkNotNullParameter(r38, "userComponentAbility");
            if (r37 != null) goto L5;
            return null;
        L5:
            Bundle r0 = r37.getArguments();
            if (r0 != null) goto L8;
            return null;
        L8:
            Serializable r1 = r0.getSerializable("office_list_tab");
            if ((r1 instanceof OfficeSpaceTab) == false) goto L11;
            OfficeSpaceTab r8 = (OfficeSpaceTab) r1;
        L12:
            if (r8 != null) goto L14;
            return null;
        L14:
            Serializable r2 = r0.getSerializable("office_list_config");
            if ((r2 instanceof OfficeListConfig) == false) goto L17;
            OfficeListConfig r3 = (OfficeListConfig) r2;
        L18:
            if (r3 != null) goto L20;
            OfficeListConfig r16 = new OfficeListConfig(null, false, false, false, null, null, 63, null);
        L21:
            String r17 = r0.getString("office_list_runtime_id");
            if ((r37 instanceof ed5.d) == false) goto L24;
            ed5.d r7 = (ed5.d) r37;
        L25:
            final WeakReference r6 = new WeakReference(r37);
            ed5.d r25 = r7;
            OfficeSpaceTab r14 = r8;
            OfficeDocumentAdapter r5 = new OfficeDocumentAdapter(r8, r16, r17, r35, r7, new OfficeListAdapterBridge$factory$1$createAdapter$adapter$1(r6), r38, OfficeListAdapterBridge$factory$1$createAdapter$adapter$2.INSTANCE);
            if (r5.p == r36) goto L32;
            OfficeListLongPressActionController r4 = r5.A;
            if (r4 == null) goto L31;
            r4.j("display_mode_changed");
        L31:
            r5.p = r36;
            r5.notifyDataSetChanged();
        L32:
            final WeakReference r9 = new WeakReference(r5);
            OfficeListPageMenuCapabilityRegistry r10 = OfficeListPageMenuCapabilityRegistry.a;
            if (r16.getEnableMultiSelect() == true) goto L35;
        L37:
            boolean r11 = false;
        L38:
            Function0<Boolean> r12 = new OfficeListAdapterBridge$factory$1$createAdapter$1(r9);
            com.bytedance.ee.bear.office.list.m r13 = new com.bytedance.ee.bear.office.list.m(new OfficeListAdapterBridge$factory$1$createAdapter$2(r9), new OfficeListAdapterBridge$factory$1$createAdapter$3(r9), new OfficeListAdapterBridge$factory$1$createAdapter$4(r9, r6), new OfficeListAdapterBridge$factory$1$createAdapter$5(r9), new OfficeListAdapterBridge$factory$1$createAdapter$6(r9), new OfficeListAdapterBridge$factory$1$createAdapter$7(r9), new OfficeListAdapterBridge$factory$1$createAdapter$8(r9));
            r10.getClass();
            Intrinsics.checkNotNullParameter(r14, "tab");
            Intrinsics.checkNotNullParameter(r35, "module");
            Intrinsics.checkNotNullParameter(r37, "ownerFragment");
            Intrinsics.checkNotNullParameter(r38, "userComponentAbility");
            OfficeListPageMenuCapabilityRegistry.a r15 = new OfficeListPageMenuCapabilityRegistry.a(OfficeListPageMenuCapabilityRegistry.e(r17), r14);
            WeakReference r18 = new WeakReference(r37);
            if (r25 == null) goto L41;
            WeakReference r19 = new WeakReference(r25);
        L42:
            boolean r20 = r11;
            OfficeListPageMenuCapabilityRegistry.b.compute(r15, new com.bytedance.ee.bear.office.list.j(r15, r14, r35, r37, r20, new com.bytedance.ee.bear.office.list.i(r35, r18, r38, r19, r20, r12, r13)));
            Intrinsics.checkNotNullParameter(r14, "tab");
            Intrinsics.checkNotNullParameter(r37, "ownerFragment");
            OfficeListPageMenuCapabilityRegistry.a r21 = new OfficeListPageMenuCapabilityRegistry.a(OfficeListPageMenuCapabilityRegistry.e(r17), r14);
            OfficeListPageMenuCapabilityRegistry.c.put(r21, new WeakReference(r37));
            tt5.a.h("OfficeListPageMenuCapabilityRegistry", "activate page menu owner, runtime=" + OfficeListPageMenuCapabilityRegistry.g(r21.a) + ", tab=" + r14 + ", owner=" + OfficeListPageMenuCapabilityRegistry.f(r37));
            return r5;
        L41:
            r19 = null;
            goto L42
        L35:
            if (r16.getMultiSelectEnabledTabs().contains(r14) == false) goto L37;
            r11 = true;
            goto L38
        L24:
            r7 = null;
            goto L25
        L20:
            r16 = r3;
            goto L21
        L17:
            r3 = null;
            goto L18
        L11:
            r8 = null;
            goto L12
        }
    }

    static {
        a = new a();
    }
}
