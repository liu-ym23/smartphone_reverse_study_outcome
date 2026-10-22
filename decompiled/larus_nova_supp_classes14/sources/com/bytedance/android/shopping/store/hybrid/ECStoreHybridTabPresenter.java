package com.bytedance.android.shopping.store.hybrid;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.DefaultStoreTadLoadingStatusView;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.home.entity.p;
import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.StorePreviewPerfChecker;
import com.bytedance.android.shopping.store.hybrid.viewmodel.ECStoreHybridTabViewModel;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/ECStoreHybridTabPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabPresenter extends QFragmentPresenter implements LifecycleObserver {
    public static final /* synthetic */ int D = 0;
    public final k A;
    public final StoreTabConfig B;
    public final ECStoreViewModel C;
    public ECStoreHybridTabViewModel f;
    public ViewGroup g;
    public List<? extends HashMap<String, Object>> h;
    public JSONArray i;
    public ComponentsWrapper j;
    public String k;
    public ti.l l;
    public boolean m;
    public final float n;
    public boolean o;
    public final Lazy p;
    public StorePreviewPerfChecker q;
    public final Lazy r;
    public LynxView s;
    public final Lazy t;
    public final Function3<String, String, String, Unit> u;
    public final Lazy v;
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> w;
    public final d x;
    public final PthreadTimer y;
    public final j z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Integer r8 = (Integer) r7;
            int r0 = r8.intValue() & 16777215;
            View r1 = this.a;
            r1.setVisibility(0);
            GradientDrawable r3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r8.intValue(), r0});
            int r9 = qc3.a.a;
            Intrinsics.checkNotNullParameter(r1, "$this$setBackgroundCompat");
            r1.setBackground(r3);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ View a;

        public c(View r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            View r0 = this.a;
            if (Intrinsics.areEqual((Boolean) r3, Boolean.FALSE) == false) goto L5;
            int r4 = 8;
        L6:
            r0.setVisibility(r4);
            return;
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public d(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.optBoolean("success") == false) goto L6;
            ECStoreHybridTabPresenter.e0(this.a);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public e(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            float r4 = ((Float) r3).floatValue();
            ECStoreHybridTabPresenter r0 = this.a;
            if (r4 < r0.n) goto L5;
            r0.k0();
            return;
        L5:
            r0.Z().b(2131371150).f().setVisibility(8);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public f(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            ECStoreHybridTabPresenter.i0(this.a);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public g(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            int[] r2 = (int[]) r1;
            ECStoreHybridTabPresenter.j0(this.a);
        }
    }

    public static final class h extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public h(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            int r4 = com.bytedance.android.shopping.store.hybrid.k.a;
            ECStoreHybridTabPresenter r5 = this.a;
            int r6 = ECStoreHybridTabPresenter.D;
            return com.bytedance.android.shopping.store.hybrid.k.b(1, null, MapsKt.mapOf(TuplesKt.to("pagePattern", r5.l0())));
        }
    }

    public static final class i extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final JSONObject j(JSONObject r9, CallContext r10) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r10, "context");
            String r0 = r9.optString("key");
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == true) goto L11;
            String r4 = r9.optString("valueType", r9.optString("type", ""));
            if (r4 == null) goto L1055;
            String r5 = r4.toLowerCase();
            switch(r5.hashCode()) {
                case -1325958191: goto L704;
                case -1034364087: goto L701;
                case 104431: goto L537;
                case 3029738: goto L367;
                case 3327612: goto L203;
                case 64711720: goto L200;
                case 97526364: goto L21;
                case 1958052158: goto L18;
                default: goto L882;
            };
        L882:
            int r6 = n.a;
            Object r11 = r9.optString("defaultValue", "");
            int r7 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L1043
            Object r12 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L936
            if (r12 != null) goto L888;
        L933:
            Object r13 = null;
        L934:
            Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L936
        L938:
            Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L1043
            if (r15 == null) goto L942;
            EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L1043
        L942:
            if (Result.isFailure-impl(r14) == false) goto L945;
            r14 = null;
        L945:
            if ((r14 instanceof String) == true) goto L947;
            r14 = null;
        L947:
            Object r16 = (String) r14;     // Catch: Throwable -> L1043
            if (r16 != null) goto L954;
            Object r17 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L1043
            if ((r17 instanceof String) == true) goto L953;
            r17 = null;
        L953:
            r16 = (String) r17;     // Catch: Throwable -> L1043
        L954:
            if (r16 != null) goto L1052;
            int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L1043
            Object r19 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L1009
            if (r19 != null) goto L961;
        L1006:
            Object r20 = null;
        L1007:
            Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L1009
        L1011:
            Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L1034
            if (r22 == null) goto L1015;
            EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L1034
        L1015:
            if (Result.isFailure-impl(r21) == false) goto L1018;
            r21 = null;
        L1018:
            if ((r21 instanceof String) == true) goto L1020;
            r21 = null;
        L1020:
            r16 = (String) r21;     // Catch: Throwable -> L1034
            if (r16 != null) goto L1041;
            IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L1034
            if (r23 == null) goto L1026;
            Object r24 = r23.getHostABValue(r0, r11);     // Catch: Throwable -> L1034
        L1027:
            if (r24 != null) goto L1029;
        L1040:
            r16 = r11;
            goto L1041
        L1029:
            if ((r24 instanceof String) == true) goto L1031;
            r24 = null;
        L1031:
            r16 = (String) r24;     // Catch: Throwable -> L1034
            if (r16 != null) goto L1041;
        L1026:
            r24 = null;
        L1041:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L1043
            goto L1052
        L961:
            if ((r19 instanceof String) == true) goto L963;
            Object r25 = null;
        L964:
            r20 = (String) r25;     // Catch: Throwable -> L1009
            if (r20 != null) goto L1007;
            if ((r19 instanceof Number) == false) goto L994;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L976;
            Float r26 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L1009
            if ((r26 instanceof String) == true) goto L974;
            r26 = null;
        L974:
            r20 = (String) r26;     // Catch: Throwable -> L1009
            goto L1007
        L976:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L982;
            Double r27 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L1009
            if ((r27 instanceof String) == true) goto L980;
            r27 = null;
        L980:
            r20 = (String) r27;     // Catch: Throwable -> L1009
            goto L1007
        L982:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L988;
            Integer r28 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L1009
            if ((r28 instanceof String) == true) goto L986;
            r28 = null;
        L986:
            r20 = (String) r28;     // Catch: Throwable -> L1009
            goto L1007
        L988:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L994;
            Long r29 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L1009
            if ((r29 instanceof String) == true) goto L992;
            r29 = null;
        L992:
            r20 = (String) r29;     // Catch: Throwable -> L1009
        L994:
            if ((r19 instanceof JSONObject) == false) goto L996;
        L1066:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L1002
            Object r30 = SDKSettingsCacheManager.a().fromJson(r19.toString(), String.class);     // Catch: Throwable -> L1002
            if ((r30 instanceof String) == true) goto L1000;
            r30 = null;
        L1000:
            Object r31 = Result.constructor-impl((String) r30);     // Catch: Throwable -> L1002
        L1004:
            r20 = r31;
            if (Result.isFailure-impl(r20) == false) goto L1007;
        L1002:
            th = move-exception;
            Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L1009
            r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1009
            goto L1004
        L996:
            if ((r19 instanceof JSONArray) == false) goto L1006;
        L963:
            r25 = r19;
        L1034:
            th = move-exception;
            Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L1043
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1043
            Throwable r34 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L1043
            if (r34 == null) goto L1039;
            EnsureManager.ensureNotReachHere(r34);     // Catch: Throwable -> L1043
        L1039:
            if (Result.isFailure-impl(r16) == false) goto L1041;
        L1009:
            th = move-exception;
            Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L1034
            r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1034
        L1052:
            int r36 = com.bytedance.android.shopping.store.hybrid.k.a;
            return com.bytedance.android.shopping.store.hybrid.k.b(1, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r0), TuplesKt.to("value", r16)}));
        L888:
            if ((r12 instanceof String) == true) goto L890;
            Object r37 = null;
        L891:
            r13 = (String) r37;     // Catch: Throwable -> L936
            if (r13 != null) goto L934;
            if ((r12 instanceof Number) == false) goto L921;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L903;
            Float r38 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L936
            if ((r38 instanceof String) == true) goto L901;
            r38 = null;
        L901:
            r13 = (String) r38;     // Catch: Throwable -> L936
            goto L934
        L903:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L909;
            Double r39 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L936
            if ((r39 instanceof String) == true) goto L907;
            r39 = null;
        L907:
            r13 = (String) r39;     // Catch: Throwable -> L936
            goto L934
        L909:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L915;
            Integer r40 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L936
            if ((r40 instanceof String) == true) goto L913;
            r40 = null;
        L913:
            r13 = (String) r40;     // Catch: Throwable -> L936
            goto L934
        L915:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L921;
            Long r41 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L936
            if ((r41 instanceof String) == true) goto L919;
            r41 = null;
        L919:
            r13 = (String) r41;     // Catch: Throwable -> L936
        L921:
            if ((r12 instanceof JSONObject) == false) goto L923;
        L1087:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L929
            Object r42 = SDKSettingsCacheManager.a().fromJson(r12.toString(), String.class);     // Catch: Throwable -> L929
            if ((r42 instanceof String) == true) goto L927;
            r42 = null;
        L927:
            Object r43 = Result.constructor-impl((String) r42);     // Catch: Throwable -> L929
        L931:
            r13 = r43;
            if (Result.isFailure-impl(r13) == false) goto L934;
        L929:
            th = move-exception;
            Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L936
            r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L936
            goto L931
        L923:
            if ((r12 instanceof JSONArray) == false) goto L933;
        L890:
            r37 = r12;
        L936:
            th = move-exception;
            Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L1043
            r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1043
        L1043:
            th = move-exception;
            Result.Companion r46 = Result.Companion;
            Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r48 = Result.exceptionOrNull-impl(r47);
            if (r48 == null) goto L1048;
            EnsureManager.ensureNotReachHere(r48);
        L1048:
            if (Result.isFailure-impl(r47) == true) goto L1051;
        L1050:
            r11 = r47;
        L1051:
            r16 = r11;
            goto L1052
        L18:
            if (r5.equals("integer") == false) goto L882;
        L538:
            int r49 = n.a;
            r11 = Integer.valueOf(r9.optInt("defaultValue", 0));
            int r50 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L693
            Object r52 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L589
            if (r52 != null) goto L544;
        L586:
            Object r53 = null;
        L587:
            Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L589
        L591:
            Throwable r55 = Result.exceptionOrNull-impl(r54);     // Catch: Throwable -> L693
            if (r55 == null) goto L595;
            EnsureManager.ensureNotReachHere(r55);     // Catch: Throwable -> L693
        L595:
            if (Result.isFailure-impl(r54) == false) goto L598;
            r54 = null;
        L598:
            if ((r54 instanceof Integer) == true) goto L600;
            r54 = null;
        L600:
            r16 = (Integer) r54;     // Catch: Throwable -> L693
            if (r16 != null) goto L607;
            Object r56 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L693
            if ((r56 instanceof Integer) == true) goto L606;
            r56 = null;
        L606:
            r16 = (Integer) r56;     // Catch: Throwable -> L693
        L607:
            if (r16 != null) goto L1052;
            int r57 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L693
            Object r58 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L659
            if (r58 != null) goto L614;
        L656:
            Object r59 = null;
        L657:
            Object r60 = Result.constructor-impl(r59);     // Catch: Throwable -> L659
        L661:
            Throwable r61 = Result.exceptionOrNull-impl(r60);     // Catch: Throwable -> L684
            if (r61 == null) goto L665;
            EnsureManager.ensureNotReachHere(r61);     // Catch: Throwable -> L684
        L665:
            if (Result.isFailure-impl(r60) == false) goto L668;
            r60 = null;
        L668:
            if ((r60 instanceof Integer) == true) goto L670;
            r60 = null;
        L670:
            r16 = (Integer) r60;     // Catch: Throwable -> L684
            if (r16 != null) goto L691;
            IHybridHostService r62 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L684
            if (r62 == null) goto L676;
            Object r63 = r62.getHostABValue(r0, r11);     // Catch: Throwable -> L684
        L677:
            if (r63 != null) goto L679;
        L690:
            r16 = r11;
            goto L691
        L679:
            if ((r63 instanceof Integer) == true) goto L681;
            r63 = null;
        L681:
            r16 = (Integer) r63;     // Catch: Throwable -> L684
            if (r16 != null) goto L691;
        L684:
            th = move-exception;
            Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L693
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L693
            Throwable r65 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L693
            if (r65 == null) goto L689;
            EnsureManager.ensureNotReachHere(r65);     // Catch: Throwable -> L693
        L689:
            if (Result.isFailure-impl(r16) == false) goto L691;
        L676:
            r63 = null;
        L691:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L693
            goto L1052
        L614:
            if ((r58 instanceof Integer) == true) goto L616;
            Object r66 = null;
        L617:
            r59 = (Integer) r66;     // Catch: Throwable -> L659
            if (r59 != null) goto L657;
            if ((r58 instanceof Number) == false) goto L644;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L629;
            Float r67 = Float.valueOf(((Number) r58).floatValue());     // Catch: Throwable -> L659
            if ((r67 instanceof Integer) == true) goto L627;
            r67 = null;
        L627:
            r59 = (Integer) r67;     // Catch: Throwable -> L659
            goto L657
        L629:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L635;
            Double r68 = Double.valueOf(((Number) r58).doubleValue());     // Catch: Throwable -> L659
            if ((r68 instanceof Integer) == true) goto L633;
            r68 = null;
        L633:
            r59 = (Integer) r68;     // Catch: Throwable -> L659
            goto L657
        L635:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L638;
            r59 = Integer.valueOf(((Number) r58).intValue());     // Catch: Throwable -> L659
            goto L657
        L638:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L644;
            Long r69 = Long.valueOf(((Number) r58).longValue());     // Catch: Throwable -> L659
            if ((r69 instanceof Integer) == true) goto L642;
            r69 = null;
        L642:
            r59 = (Integer) r69;     // Catch: Throwable -> L659
        L644:
            if ((r58 instanceof JSONObject) == false) goto L646;
        L1079:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L652
            Object r70 = SDKSettingsCacheManager.a().fromJson(r58.toString(), Integer.class);     // Catch: Throwable -> L652
            if ((r70 instanceof Integer) == true) goto L650;
            r70 = null;
        L650:
            Object r71 = Result.constructor-impl((Integer) r70);     // Catch: Throwable -> L652
        L654:
            r59 = r71;
            if (Result.isFailure-impl(r59) == false) goto L657;
        L652:
            th = move-exception;
            Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L659
            r71 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L659
            goto L654
        L646:
            if ((r58 instanceof JSONArray) == false) goto L656;
        L616:
            r66 = r58;
        L659:
            th = move-exception;
            Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L684
            r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L684
            goto L661
        L544:
            if ((r52 instanceof Integer) == true) goto L546;
            Object r74 = null;
        L547:
            r53 = (Integer) r74;     // Catch: Throwable -> L589
            if (r53 != null) goto L587;
            if ((r52 instanceof Number) == false) goto L574;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L559;
            Float r75 = Float.valueOf(((Number) r52).floatValue());     // Catch: Throwable -> L589
            if ((r75 instanceof Integer) == true) goto L557;
            r75 = null;
        L557:
            r53 = (Integer) r75;     // Catch: Throwable -> L589
            goto L587
        L559:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L565;
            Double r76 = Double.valueOf(((Number) r52).doubleValue());     // Catch: Throwable -> L589
            if ((r76 instanceof Integer) == true) goto L563;
            r76 = null;
        L563:
            r53 = (Integer) r76;     // Catch: Throwable -> L589
            goto L587
        L565:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L568;
            r53 = Integer.valueOf(((Number) r52).intValue());     // Catch: Throwable -> L589
            goto L587
        L568:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L574;
            Long r77 = Long.valueOf(((Number) r52).longValue());     // Catch: Throwable -> L589
            if ((r77 instanceof Integer) == true) goto L572;
            r77 = null;
        L572:
            r53 = (Integer) r77;     // Catch: Throwable -> L589
        L574:
            if ((r52 instanceof JSONObject) == false) goto L576;
        L1112:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L582
            Object r78 = SDKSettingsCacheManager.a().fromJson(r52.toString(), Integer.class);     // Catch: Throwable -> L582
            if ((r78 instanceof Integer) == true) goto L580;
            r78 = null;
        L580:
            Object r79 = Result.constructor-impl((Integer) r78);     // Catch: Throwable -> L582
        L584:
            r53 = r79;
            if (Result.isFailure-impl(r53) == false) goto L587;
        L582:
            th = move-exception;
            Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L589
            r79 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L589
            goto L584
        L576:
            if ((r52 instanceof JSONArray) == false) goto L586;
        L546:
            r74 = r52;
        L589:
            th = move-exception;
            Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L693
            r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L693
        L693:
            th = move-exception;
            Result.Companion r82 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r83 = Result.exceptionOrNull-impl(r47);
            if (r83 == null) goto L698;
            EnsureManager.ensureNotReachHere(r83);
        L698:
            if (Result.isFailure-impl(r47) == false) goto L1050;
        L21:
            if (r5.equals("float") == false) goto L882;
            Object r84 = r9.opt("defaultValue");
            if ((r84 instanceof Number) == true) goto L25;
            Object r85 = null;
        L26:
            Number r86 = (Number) r85;
            if (r86 == null) goto L29;
            Float r87 = Float.valueOf(r86.floatValue());
        L34:
            if (r87 == null) goto L36;
            float r88 = r87.floatValue();
        L37:
            int r89 = n.a;
            r11 = Float.valueOf(r88);
            int r90 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r91 = Result.Companion;     // Catch: Throwable -> L192
            Object r92 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L88
            if (r92 != null) goto L43;
        L85:
            Object r93 = null;
        L86:
            Object r94 = Result.constructor-impl(r93);     // Catch: Throwable -> L88
        L90:
            Throwable r95 = Result.exceptionOrNull-impl(r94);     // Catch: Throwable -> L192
            if (r95 == null) goto L94;
            EnsureManager.ensureNotReachHere(r95);     // Catch: Throwable -> L192
        L94:
            if (Result.isFailure-impl(r94) == false) goto L97;
            r94 = null;
        L97:
            if ((r94 instanceof Float) == true) goto L99;
            r94 = null;
        L99:
            r16 = (Float) r94;     // Catch: Throwable -> L192
            if (r16 != null) goto L106;
            Object r96 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L192
            if ((r96 instanceof Float) == true) goto L105;
            r96 = null;
        L105:
            r16 = (Float) r96;     // Catch: Throwable -> L192
        L106:
            if (r16 != null) goto L1052;
            int r97 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L192
            Object r98 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L158
            if (r98 != null) goto L113;
        L155:
            Object r99 = null;
        L156:
            Object r100 = Result.constructor-impl(r99);     // Catch: Throwable -> L158
        L160:
            Throwable r101 = Result.exceptionOrNull-impl(r100);     // Catch: Throwable -> L183
            if (r101 == null) goto L164;
            EnsureManager.ensureNotReachHere(r101);     // Catch: Throwable -> L183
        L164:
            if (Result.isFailure-impl(r100) == false) goto L167;
            r100 = null;
        L167:
            if ((r100 instanceof Float) == true) goto L169;
            r100 = null;
        L169:
            r16 = (Float) r100;     // Catch: Throwable -> L183
            if (r16 != null) goto L190;
            IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L183
            if (r102 == null) goto L175;
            Object r103 = r102.getHostABValue(r0, r11);     // Catch: Throwable -> L183
        L176:
            if (r103 != null) goto L178;
        L189:
            r16 = r11;
            goto L190
        L178:
            if ((r103 instanceof Float) == true) goto L180;
            r103 = null;
        L180:
            r16 = (Float) r103;     // Catch: Throwable -> L183
            if (r16 != null) goto L190;
        L183:
            th = move-exception;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L192
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L192
            Throwable r105 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L192
            if (r105 == null) goto L188;
            EnsureManager.ensureNotReachHere(r105);     // Catch: Throwable -> L192
        L188:
            if (Result.isFailure-impl(r16) == false) goto L190;
        L175:
            r103 = null;
        L190:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L192
            goto L1052
        L113:
            if ((r98 instanceof Float) == true) goto L115;
            Object r106 = null;
        L116:
            r99 = (Float) r106;     // Catch: Throwable -> L158
            if (r99 != null) goto L156;
            if ((r98 instanceof Number) == false) goto L143;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L125;
            r99 = Float.valueOf(((Number) r98).floatValue());     // Catch: Throwable -> L158
            goto L156
        L125:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L131;
            Double r107 = Double.valueOf(((Number) r98).doubleValue());     // Catch: Throwable -> L158
            if ((r107 instanceof Float) == true) goto L129;
            r107 = null;
        L129:
            r99 = (Float) r107;     // Catch: Throwable -> L158
            goto L156
        L131:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L137;
            Integer r108 = Integer.valueOf(((Number) r98).intValue());     // Catch: Throwable -> L158
            if ((r108 instanceof Float) == true) goto L135;
            r108 = null;
        L135:
            r99 = (Float) r108;     // Catch: Throwable -> L158
            goto L156
        L137:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L143;
            Long r109 = Long.valueOf(((Number) r98).longValue());     // Catch: Throwable -> L158
            if ((r109 instanceof Float) == true) goto L141;
            r109 = null;
        L141:
            r99 = (Float) r109;     // Catch: Throwable -> L158
        L143:
            if ((r98 instanceof JSONObject) == false) goto L145;
        L1096:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L151
            Object r110 = SDKSettingsCacheManager.a().fromJson(r98.toString(), Float.class);     // Catch: Throwable -> L151
            if ((r110 instanceof Float) == true) goto L149;
            r110 = null;
        L149:
            Object r111 = Result.constructor-impl((Float) r110);     // Catch: Throwable -> L151
        L153:
            r99 = r111;
            if (Result.isFailure-impl(r99) == false) goto L156;
        L151:
            th = move-exception;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L158
            r111 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
            goto L153
        L145:
            if ((r98 instanceof JSONArray) == false) goto L155;
        L115:
            r106 = r98;
        L158:
            th = move-exception;
            Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L183
            r100 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L183
            goto L160
        L43:
            if ((r92 instanceof Float) == true) goto L45;
            Object r114 = null;
        L46:
            r93 = (Float) r114;     // Catch: Throwable -> L88
            if (r93 != null) goto L86;
            if ((r92 instanceof Number) == false) goto L73;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L55;
            r93 = Float.valueOf(((Number) r92).floatValue());     // Catch: Throwable -> L88
            goto L86
        L55:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L61;
            Double r115 = Double.valueOf(((Number) r92).doubleValue());     // Catch: Throwable -> L88
            if ((r115 instanceof Float) == true) goto L59;
            r115 = null;
        L59:
            r93 = (Float) r115;     // Catch: Throwable -> L88
            goto L86
        L61:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L67;
            Integer r116 = Integer.valueOf(((Number) r92).intValue());     // Catch: Throwable -> L88
            if ((r116 instanceof Float) == true) goto L65;
            r116 = null;
        L65:
            r93 = (Float) r116;     // Catch: Throwable -> L88
            goto L86
        L67:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L73;
            Long r117 = Long.valueOf(((Number) r92).longValue());     // Catch: Throwable -> L88
            if ((r117 instanceof Float) == true) goto L71;
            r117 = null;
        L71:
            r93 = (Float) r117;     // Catch: Throwable -> L88
        L73:
            if ((r92 instanceof JSONObject) == false) goto L75;
        L1058:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L81
            Object r118 = SDKSettingsCacheManager.a().fromJson(r92.toString(), Float.class);     // Catch: Throwable -> L81
            if ((r118 instanceof Float) == true) goto L79;
            r118 = null;
        L79:
            Object r119 = Result.constructor-impl((Float) r118);     // Catch: Throwable -> L81
        L83:
            r93 = r119;
            if (Result.isFailure-impl(r93) == false) goto L86;
        L81:
            th = move-exception;
            Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L88
            r119 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
            goto L83
        L75:
            if ((r92 instanceof JSONArray) == false) goto L85;
        L45:
            r114 = r92;
        L88:
            th = move-exception;
            Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L192
            r94 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L192
        L192:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r123 = Result.exceptionOrNull-impl(r47);
            if (r123 == null) goto L197;
            EnsureManager.ensureNotReachHere(r123);
        L197:
            if (Result.isFailure-impl(r47) == false) goto L1050;
        L36:
            r88 = 0.0f;
            goto L37
        L29:
            if (r84 == null) goto L33;
            String r124 = r84.toString();
            if (r124 == null) goto L33;
            r87 = StringsKt.toFloatOrNull(r124);
        L33:
            r87 = null;
            goto L34
        L25:
            r85 = r84;
            goto L26
        L200:
            if (r5.equals("boolean") == false) goto L882;
        L368:
            int r125 = n.a;
            r11 = Boolean.valueOf(r9.optBoolean("defaultValue", false));
            int r126 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L529
            Object r128 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L422
            if (r128 != null) goto L374;
        L419:
            Object r129 = null;
        L420:
            Object r130 = Result.constructor-impl(r129);     // Catch: Throwable -> L422
        L424:
            Throwable r131 = Result.exceptionOrNull-impl(r130);     // Catch: Throwable -> L529
            if (r131 == null) goto L428;
            EnsureManager.ensureNotReachHere(r131);     // Catch: Throwable -> L529
        L428:
            if (Result.isFailure-impl(r130) == false) goto L431;
            r130 = null;
        L431:
            if ((r130 instanceof Boolean) == true) goto L433;
            r130 = null;
        L433:
            r16 = (Boolean) r130;     // Catch: Throwable -> L529
            if (r16 != null) goto L440;
            Object r132 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L529
            if ((r132 instanceof Boolean) == true) goto L439;
            r132 = null;
        L439:
            r16 = (Boolean) r132;     // Catch: Throwable -> L529
        L440:
            if (r16 != null) goto L1052;
            int r133 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L529
            Object r134 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L495
            if (r134 != null) goto L447;
        L492:
            Object r135 = null;
        L493:
            Object r136 = Result.constructor-impl(r135);     // Catch: Throwable -> L495
        L497:
            Throwable r137 = Result.exceptionOrNull-impl(r136);     // Catch: Throwable -> L520
            if (r137 == null) goto L501;
            EnsureManager.ensureNotReachHere(r137);     // Catch: Throwable -> L520
        L501:
            if (Result.isFailure-impl(r136) == false) goto L504;
            r136 = null;
        L504:
            if ((r136 instanceof Boolean) == true) goto L506;
            r136 = null;
        L506:
            r16 = (Boolean) r136;     // Catch: Throwable -> L520
            if (r16 != null) goto L527;
            IHybridHostService r138 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L520
            if (r138 == null) goto L512;
            Object r139 = r138.getHostABValue(r0, r11);     // Catch: Throwable -> L520
        L513:
            if (r139 != null) goto L515;
        L526:
            r16 = r11;
            goto L527
        L515:
            if ((r139 instanceof Boolean) == true) goto L517;
            r139 = null;
        L517:
            r16 = (Boolean) r139;     // Catch: Throwable -> L520
            if (r16 != null) goto L527;
        L512:
            r139 = null;
        L527:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L529
            goto L1052
        L447:
            if ((r134 instanceof Boolean) == true) goto L449;
            Object r140 = null;
        L450:
            r135 = (Boolean) r140;     // Catch: Throwable -> L495
            if (r135 != null) goto L493;
            if ((r134 instanceof Number) == false) goto L480;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L462;
            Float r141 = Float.valueOf(((Number) r134).floatValue());     // Catch: Throwable -> L495
            if ((r141 instanceof Boolean) == true) goto L460;
            r141 = null;
        L460:
            r135 = (Boolean) r141;     // Catch: Throwable -> L495
            goto L493
        L462:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L468;
            Double r142 = Double.valueOf(((Number) r134).doubleValue());     // Catch: Throwable -> L495
            if ((r142 instanceof Boolean) == true) goto L466;
            r142 = null;
        L466:
            r135 = (Boolean) r142;     // Catch: Throwable -> L495
            goto L493
        L468:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L474;
            Integer r143 = Integer.valueOf(((Number) r134).intValue());     // Catch: Throwable -> L495
            if ((r143 instanceof Boolean) == true) goto L472;
            r143 = null;
        L472:
            r135 = (Boolean) r143;     // Catch: Throwable -> L495
            goto L493
        L474:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L480;
            Long r144 = Long.valueOf(((Number) r134).longValue());     // Catch: Throwable -> L495
            if ((r144 instanceof Boolean) == true) goto L478;
            r144 = null;
        L478:
            r135 = (Boolean) r144;     // Catch: Throwable -> L495
        L480:
            if ((r134 instanceof JSONObject) == false) goto L482;
        L1118:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L488
            Object r145 = SDKSettingsCacheManager.a().fromJson(r134.toString(), Boolean.class);     // Catch: Throwable -> L488
            if ((r145 instanceof Boolean) == true) goto L486;
            r145 = null;
        L486:
            Object r146 = Result.constructor-impl((Boolean) r145);     // Catch: Throwable -> L488
        L490:
            r135 = r146;
            if (Result.isFailure-impl(r135) == false) goto L493;
        L488:
            th = move-exception;
            Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L495
            r146 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L495
            goto L490
        L482:
            if ((r134 instanceof JSONArray) == false) goto L492;
        L449:
            r140 = r134;
        L520:
            th = move-exception;
            Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L529
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L529
            Throwable r149 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L529
            if (r149 == null) goto L525;
            EnsureManager.ensureNotReachHere(r149);     // Catch: Throwable -> L529
        L525:
            if (Result.isFailure-impl(r16) == false) goto L527;
        L495:
            th = move-exception;
            Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L520
            r136 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L520
            goto L497
        L374:
            if ((r128 instanceof Boolean) == true) goto L376;
            Object r151 = null;
        L377:
            r129 = (Boolean) r151;     // Catch: Throwable -> L422
            if (r129 != null) goto L420;
            if ((r128 instanceof Number) == false) goto L407;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L389;
            Float r152 = Float.valueOf(((Number) r128).floatValue());     // Catch: Throwable -> L422
            if ((r152 instanceof Boolean) == true) goto L387;
            r152 = null;
        L387:
            r129 = (Boolean) r152;     // Catch: Throwable -> L422
            goto L420
        L389:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L395;
            Double r153 = Double.valueOf(((Number) r128).doubleValue());     // Catch: Throwable -> L422
            if ((r153 instanceof Boolean) == true) goto L393;
            r153 = null;
        L393:
            r129 = (Boolean) r153;     // Catch: Throwable -> L422
            goto L420
        L395:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L401;
            Integer r154 = Integer.valueOf(((Number) r128).intValue());     // Catch: Throwable -> L422
            if ((r154 instanceof Boolean) == true) goto L399;
            r154 = null;
        L399:
            r129 = (Boolean) r154;     // Catch: Throwable -> L422
            goto L420
        L401:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L407;
            Long r155 = Long.valueOf(((Number) r128).longValue());     // Catch: Throwable -> L422
            if ((r155 instanceof Boolean) == true) goto L405;
            r155 = null;
        L405:
            r129 = (Boolean) r155;     // Catch: Throwable -> L422
        L407:
            if ((r128 instanceof JSONObject) == false) goto L409;
        L1074:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L415
            Object r156 = SDKSettingsCacheManager.a().fromJson(r128.toString(), Boolean.class);     // Catch: Throwable -> L415
            if ((r156 instanceof Boolean) == true) goto L413;
            r156 = null;
        L413:
            Object r157 = Result.constructor-impl((Boolean) r156);     // Catch: Throwable -> L415
        L417:
            r129 = r157;
            if (Result.isFailure-impl(r129) == false) goto L420;
        L415:
            th = move-exception;
            Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L422
            r157 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L422
            goto L417
        L409:
            if ((r128 instanceof JSONArray) == false) goto L419;
        L376:
            r151 = r128;
        L422:
            th = move-exception;
            Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L529
            r130 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L529
        L529:
            th = move-exception;
            Result.Companion r160 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r161 = Result.exceptionOrNull-impl(r47);
            if (r161 == null) goto L534;
            EnsureManager.ensureNotReachHere(r161);
        L534:
            if (Result.isFailure-impl(r47) == false) goto L1050;
        L203:
            if (r5.equals("long") == false) goto L882;
            int r162 = n.a;
            r11 = Long.valueOf(r9.optLong("defaultValue", 0));
            int r163 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L359
            Object r165 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L255
            if (r165 != null) goto L210;
        L252:
            Object r166 = null;
        L253:
            Object r167 = Result.constructor-impl(r166);     // Catch: Throwable -> L255
        L257:
            Throwable r168 = Result.exceptionOrNull-impl(r167);     // Catch: Throwable -> L359
            if (r168 == null) goto L261;
            EnsureManager.ensureNotReachHere(r168);     // Catch: Throwable -> L359
        L261:
            if (Result.isFailure-impl(r167) == false) goto L264;
            r167 = null;
        L264:
            if ((r167 instanceof Long) == true) goto L266;
            r167 = null;
        L266:
            r16 = (Long) r167;     // Catch: Throwable -> L359
            if (r16 != null) goto L273;
            Object r169 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L359
            if ((r169 instanceof Long) == true) goto L272;
            r169 = null;
        L272:
            r16 = (Long) r169;     // Catch: Throwable -> L359
        L273:
            if (r16 != null) goto L1052;
            int r170 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L359
            Object r171 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L325
            if (r171 != null) goto L280;
        L322:
            Object r172 = null;
        L323:
            Object r173 = Result.constructor-impl(r172);     // Catch: Throwable -> L325
        L327:
            Throwable r174 = Result.exceptionOrNull-impl(r173);     // Catch: Throwable -> L350
            if (r174 == null) goto L331;
            EnsureManager.ensureNotReachHere(r174);     // Catch: Throwable -> L350
        L331:
            if (Result.isFailure-impl(r173) == false) goto L334;
            r173 = null;
        L334:
            if ((r173 instanceof Long) == true) goto L336;
            r173 = null;
        L336:
            r16 = (Long) r173;     // Catch: Throwable -> L350
            if (r16 != null) goto L357;
            IHybridHostService r175 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L350
            if (r175 == null) goto L342;
            Object r176 = r175.getHostABValue(r0, r11);     // Catch: Throwable -> L350
        L343:
            if (r176 != null) goto L345;
        L356:
            r16 = r11;
            goto L357
        L345:
            if ((r176 instanceof Long) == true) goto L347;
            r176 = null;
        L347:
            r16 = (Long) r176;     // Catch: Throwable -> L350
            if (r16 != null) goto L357;
        L350:
            th = move-exception;
            Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L359
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L359
            Throwable r178 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L359
            if (r178 == null) goto L355;
            EnsureManager.ensureNotReachHere(r178);     // Catch: Throwable -> L359
        L355:
            if (Result.isFailure-impl(r16) == false) goto L357;
        L342:
            r176 = null;
        L357:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L359
            goto L1052
        L280:
            if ((r171 instanceof Long) == true) goto L282;
            Object r179 = null;
        L283:
            r172 = (Long) r179;     // Catch: Throwable -> L325
            if (r172 != null) goto L323;
            if ((r171 instanceof Number) == false) goto L310;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L295;
            Float r180 = Float.valueOf(((Number) r171).floatValue());     // Catch: Throwable -> L325
            if ((r180 instanceof Long) == true) goto L293;
            r180 = null;
        L293:
            r172 = (Long) r180;     // Catch: Throwable -> L325
            goto L323
        L295:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L301;
            Double r181 = Double.valueOf(((Number) r171).doubleValue());     // Catch: Throwable -> L325
            if ((r181 instanceof Long) == true) goto L299;
            r181 = null;
        L299:
            r172 = (Long) r181;     // Catch: Throwable -> L325
            goto L323
        L301:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L307;
            Integer r182 = Integer.valueOf(((Number) r171).intValue());     // Catch: Throwable -> L325
            if ((r182 instanceof Long) == true) goto L305;
            r182 = null;
        L305:
            r172 = (Long) r182;     // Catch: Throwable -> L325
            goto L323
        L307:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L310;
            r172 = Long.valueOf(((Number) r171).longValue());     // Catch: Throwable -> L325
        L310:
            if ((r171 instanceof JSONObject) == false) goto L312;
        L1072:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L318
            Object r183 = SDKSettingsCacheManager.a().fromJson(r171.toString(), Long.class);     // Catch: Throwable -> L318
            if ((r183 instanceof Long) == true) goto L316;
            r183 = null;
        L316:
            Object r184 = Result.constructor-impl((Long) r183);     // Catch: Throwable -> L318
        L320:
            r172 = r184;
            if (Result.isFailure-impl(r172) == false) goto L323;
        L318:
            th = move-exception;
            Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L325
            r184 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L325
            goto L320
        L312:
            if ((r171 instanceof JSONArray) == false) goto L322;
        L282:
            r179 = r171;
        L325:
            th = move-exception;
            Result.Companion r186 = Result.Companion;     // Catch: Throwable -> L350
            r173 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L350
            goto L327
        L210:
            if ((r165 instanceof Long) == true) goto L212;
            Object r187 = null;
        L213:
            r166 = (Long) r187;     // Catch: Throwable -> L255
            if (r166 != null) goto L253;
            if ((r165 instanceof Number) == false) goto L240;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L225;
            Float r188 = Float.valueOf(((Number) r165).floatValue());     // Catch: Throwable -> L255
            if ((r188 instanceof Long) == true) goto L223;
            r188 = null;
        L223:
            r166 = (Long) r188;     // Catch: Throwable -> L255
            goto L253
        L225:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L231;
            Double r189 = Double.valueOf(((Number) r165).doubleValue());     // Catch: Throwable -> L255
            if ((r189 instanceof Long) == true) goto L229;
            r189 = null;
        L229:
            r166 = (Long) r189;     // Catch: Throwable -> L255
            goto L253
        L231:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L237;
            Integer r190 = Integer.valueOf(((Number) r165).intValue());     // Catch: Throwable -> L255
            if ((r190 instanceof Long) == true) goto L235;
            r190 = null;
        L235:
            r166 = (Long) r190;     // Catch: Throwable -> L255
            goto L253
        L237:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L240;
            r166 = Long.valueOf(((Number) r165).longValue());     // Catch: Throwable -> L255
        L240:
            if ((r165 instanceof JSONObject) == false) goto L242;
        L1104:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L248
            Object r191 = SDKSettingsCacheManager.a().fromJson(r165.toString(), Long.class);     // Catch: Throwable -> L248
            if ((r191 instanceof Long) == true) goto L246;
            r191 = null;
        L246:
            Object r192 = Result.constructor-impl((Long) r191);     // Catch: Throwable -> L248
        L250:
            r166 = r192;
            if (Result.isFailure-impl(r166) == false) goto L253;
        L248:
            th = move-exception;
            Result.Companion r193 = Result.Companion;     // Catch: Throwable -> L255
            r192 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L255
            goto L250
        L242:
            if ((r165 instanceof JSONArray) == false) goto L252;
        L212:
            r187 = r165;
        L255:
            th = move-exception;
            Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L359
            r167 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L359
        L359:
            th = move-exception;
            Result.Companion r195 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r196 = Result.exceptionOrNull-impl(r47);
            if (r196 == null) goto L364;
            EnsureManager.ensureNotReachHere(r196);
        L364:
            if (Result.isFailure-impl(r47) == false) goto L1050;
        L367:
            if (r5.equals("bool") == false) goto L882;
        L537:
            if (r5.equals("int") == false) goto L882;
        L701:
            if (r5.equals("number") == false) goto L882;
        L705:
            Object r197 = r9.opt("defaultValue");
            if ((r197 instanceof Number) == true) goto L708;
            Object r198 = null;
        L709:
            Number r199 = (Number) r198;
            if (r199 == null) goto L712;
            Double r200 = Double.valueOf(r199.doubleValue());
        L717:
            if (r200 == null) goto L719;
            double r201 = r200.doubleValue();
        L720:
            int r202 = n.a;
            r11 = Double.valueOf(r201);
            int r203 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r204 = Result.Companion;     // Catch: Throwable -> L875
            Object r205 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L771
            if (r205 != null) goto L726;
        L768:
            Object r206 = null;
        L769:
            Object r207 = Result.constructor-impl(r206);     // Catch: Throwable -> L771
        L773:
            Throwable r208 = Result.exceptionOrNull-impl(r207);     // Catch: Throwable -> L875
            if (r208 == null) goto L777;
            EnsureManager.ensureNotReachHere(r208);     // Catch: Throwable -> L875
        L777:
            if (Result.isFailure-impl(r207) == false) goto L780;
            r207 = null;
        L780:
            if ((r207 instanceof Double) == true) goto L782;
            r207 = null;
        L782:
            r16 = (Double) r207;     // Catch: Throwable -> L875
            if (r16 != null) goto L789;
            Object r209 = com.bytedance.android.ec.base.settings.d.b().get(r0);     // Catch: Throwable -> L875
            if ((r209 instanceof Double) == true) goto L788;
            r209 = null;
        L788:
            r16 = (Double) r209;     // Catch: Throwable -> L875
        L789:
            if (r16 != null) goto L1052;
            int r210 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L875
            Object r211 = com.bytedance.android.ec.base.settings.d.a().get(r0);     // Catch: Throwable -> L841
            if (r211 != null) goto L796;
        L838:
            Object r212 = null;
        L839:
            Object r213 = Result.constructor-impl(r212);     // Catch: Throwable -> L841
        L843:
            Throwable r214 = Result.exceptionOrNull-impl(r213);     // Catch: Throwable -> L866
            if (r214 == null) goto L847;
            EnsureManager.ensureNotReachHere(r214);     // Catch: Throwable -> L866
        L847:
            if (Result.isFailure-impl(r213) == false) goto L850;
            r213 = null;
        L850:
            if ((r213 instanceof Double) == true) goto L852;
            r213 = null;
        L852:
            r16 = (Double) r213;     // Catch: Throwable -> L866
            if (r16 != null) goto L873;
            IHybridHostService r215 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L866
            if (r215 == null) goto L858;
            Object r216 = r215.getHostABValue(r0, r11);     // Catch: Throwable -> L866
        L859:
            if (r216 != null) goto L861;
        L872:
            r16 = r11;
            goto L873
        L861:
            if ((r216 instanceof Double) == true) goto L863;
            r216 = null;
        L863:
            r16 = (Double) r216;     // Catch: Throwable -> L866
            if (r16 != null) goto L873;
        L866:
            th = move-exception;
            Result.Companion r217 = Result.Companion;     // Catch: Throwable -> L875
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L875
            Throwable r218 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L875
            if (r218 == null) goto L871;
            EnsureManager.ensureNotReachHere(r218);     // Catch: Throwable -> L875
        L871:
            if (Result.isFailure-impl(r16) == false) goto L873;
        L858:
            r216 = null;
        L873:
            com.bytedance.android.ec.base.settings.d.d(r0, r16);     // Catch: Throwable -> L875
            goto L1052
        L796:
            if ((r211 instanceof Double) == true) goto L798;
            Object r219 = null;
        L799:
            r212 = (Double) r219;     // Catch: Throwable -> L841
            if (r212 != null) goto L839;
            if ((r211 instanceof Number) == false) goto L826;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L811;
            Float r220 = Float.valueOf(((Number) r211).floatValue());     // Catch: Throwable -> L841
            if ((r220 instanceof Double) == true) goto L809;
            r220 = null;
        L809:
            r212 = (Double) r220;     // Catch: Throwable -> L841
            goto L839
        L811:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L814;
            r212 = Double.valueOf(((Number) r211).doubleValue());     // Catch: Throwable -> L841
            goto L839
        L814:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L820;
            Integer r221 = Integer.valueOf(((Number) r211).intValue());     // Catch: Throwable -> L841
            if ((r221 instanceof Double) == true) goto L818;
            r221 = null;
        L818:
            r212 = (Double) r221;     // Catch: Throwable -> L841
            goto L839
        L820:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L826;
            Long r222 = Long.valueOf(((Number) r211).longValue());     // Catch: Throwable -> L841
            if ((r222 instanceof Double) == true) goto L824;
            r222 = null;
        L824:
            r212 = (Double) r222;     // Catch: Throwable -> L841
        L826:
            if ((r211 instanceof JSONObject) == false) goto L828;
        L1102:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L834
            Object r223 = SDKSettingsCacheManager.a().fromJson(r211.toString(), Double.class);     // Catch: Throwable -> L834
            if ((r223 instanceof Double) == true) goto L832;
            r223 = null;
        L832:
            Object r224 = Result.constructor-impl((Double) r223);     // Catch: Throwable -> L834
        L836:
            r212 = r224;
            if (Result.isFailure-impl(r212) == false) goto L839;
        L834:
            th = move-exception;
            Result.Companion r225 = Result.Companion;     // Catch: Throwable -> L841
            r224 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L841
            goto L836
        L828:
            if ((r211 instanceof JSONArray) == false) goto L838;
        L798:
            r219 = r211;
        L841:
            th = move-exception;
            Result.Companion r226 = Result.Companion;     // Catch: Throwable -> L866
            r213 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L866
            goto L843
        L726:
            if ((r205 instanceof Double) == true) goto L728;
            Object r227 = null;
        L729:
            r206 = (Double) r227;     // Catch: Throwable -> L771
            if (r206 != null) goto L769;
            if ((r205 instanceof Number) == false) goto L756;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L741;
            Float r228 = Float.valueOf(((Number) r205).floatValue());     // Catch: Throwable -> L771
            if ((r228 instanceof Double) == true) goto L739;
            r228 = null;
        L739:
            r206 = (Double) r228;     // Catch: Throwable -> L771
            goto L769
        L741:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L744;
            r206 = Double.valueOf(((Number) r205).doubleValue());     // Catch: Throwable -> L771
            goto L769
        L744:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L750;
            Integer r229 = Integer.valueOf(((Number) r205).intValue());     // Catch: Throwable -> L771
            if ((r229 instanceof Double) == true) goto L748;
            r229 = null;
        L748:
            r206 = (Double) r229;     // Catch: Throwable -> L771
            goto L769
        L750:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Double.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L756;
            Long r230 = Long.valueOf(((Number) r205).longValue());     // Catch: Throwable -> L771
            if ((r230 instanceof Double) == true) goto L754;
            r230 = null;
        L754:
            r206 = (Double) r230;     // Catch: Throwable -> L771
        L756:
            if ((r205 instanceof JSONObject) == false) goto L758;
        L1064:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L764
            Object r231 = SDKSettingsCacheManager.a().fromJson(r205.toString(), Double.class);     // Catch: Throwable -> L764
            if ((r231 instanceof Double) == true) goto L762;
            r231 = null;
        L762:
            Object r232 = Result.constructor-impl((Double) r231);     // Catch: Throwable -> L764
        L766:
            r206 = r232;
            if (Result.isFailure-impl(r206) == false) goto L769;
        L764:
            th = move-exception;
            Result.Companion r233 = Result.Companion;     // Catch: Throwable -> L771
            r232 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L771
            goto L766
        L758:
            if ((r205 instanceof JSONArray) == false) goto L768;
        L728:
            r227 = r205;
        L771:
            th = move-exception;
            Result.Companion r234 = Result.Companion;     // Catch: Throwable -> L875
            r207 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L875
        L875:
            th = move-exception;
            Result.Companion r235 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r236 = Result.exceptionOrNull-impl(r47);
            if (r236 == null) goto L880;
            EnsureManager.ensureNotReachHere(r236);
        L880:
            if (Result.isFailure-impl(r47) == false) goto L1050;
        L719:
            r201 = 0.0d;
            goto L720
        L712:
            if (r197 == null) goto L716;
            String r237 = r197.toString();
            if (r237 == null) goto L716;
            r200 = StringsKt.toDoubleOrNull(r237);
        L716:
            r200 = null;
            goto L717
        L708:
            r198 = r197;
            goto L709
        L704:
            if (r5.equals("double") == false) goto L882;
        L1055:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L11:
            return com.bytedance.android.shopping.store.hybrid.k.a();
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r3 = false;
            goto L9
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object r1, CallContext r2) {
            return j((JSONObject) r1, r2);
        }
    }

    public static final class j extends TimerTask {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (((LoadStatus) ECStoreHybridTabPresenter.h0(this.a).getLoadStatus().a()) != LoadStatus.Initialize) goto L9;
            ECStoreHybridTabPresenter.h0(this.a).getLoadStatus().e(LoadStatus.InitializeSuccess);     // Catch: Throwable -> L6
            return;
        }

        public j(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ ECStoreHybridTabPresenter a;

        public k(ECStoreHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            ECStoreHybridTabPresenter r0 = this.a;
            boolean r7 = ((Boolean) r6).booleanValue();
            if (r7 == r0.o) goto L17;
            r0.o = r7;
            dm.a.b r1 = dm.a.a("ECStoreHybridTabPresenter");
            StringBuilder r2 = new StringBuilder("notifyVisibleChanged, tab:");
            StoreTabConfig r3 = r0.B;
            if (r3 == null) goto L8;
            Integer r4 = Integer.valueOf(r3.getTabType());
        L9:
            r2.append(r4.intValue());
            r2.append(", isVisible: ");
            r2.append(r7);
            r1.i(r2.toString());
            ti.l r5 = r0.l;
            if (r5 == null) goto L12;
            r5.sendJsEvent("H5_visibilityChange", new JSONObject().put("visible", r7));
        L12:
            ti.l r8 = r0.l;
            if (r8 == null) goto L16;
            r8.sendJsEvent("pageVisibilityChange", new JSONObject().put("visible", r7));
            return;
        L16:
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    static {
    }

    public final Map<String, Object> q0() {
        Pair[] r0 = new Pair[4];
        int r1 = t0.a;
        r0[0] = TuplesKt.to("components", GsonProtectorUtils.toJson(t0.a.a, this.h));
        r0[1] = TuplesKt.to("metaInfo", ((JSONObject) this.r.getValue()).toString());
        r0[2] = TuplesKt.to("rawData", this.k);
        ComponentsWrapper r2 = this.j;
        if (r2 == null) goto L5;
        JSONObject r3 = r2.blockJSONObject();
    L6:
        r0[3] = TuplesKt.to("block", r3);
        return MapsKt.mapOf(r0);
    L5:
        r3 = null;
        goto L6
    }

    public final void c0() {
        ECLiveHybridUtil.p("ecom.store.hybrid_tab_page_finish", this.x);
        this.y.cancel();
        ECStoreHybridTabViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.isVisible().f(this.A);
    }

    public final String l0() {
        ECStoreViewModel r0 = this.C;
        if (r0 != null) goto L5;
        return "full";
    L5:
        if (r0.isCroppedStyle() != true) goto L14;
        Integer r1 = (Integer) this.C.getCroppedState().getValue();
        if (r1 != null) goto L10;
        return "full";
    L10:
        if (r1.intValue() != 1) goto L15;
        return "cropped";
    L15:
        return "full";
    L14:
        return "full";
    }

    public final boolean n0() {
        Integer r0 = this.B.getContainerType();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    public final void k0() {
        View r0 = Z().b(2131371150).f();
        ECStoreViewModel r1 = this.C;
        if (r1 == null) goto L11;
        jm.a<com.bytedance.android.shopping.store.home.entity.n> r2 = r1.getHeaderArea();
        if (r2 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.n r3 = (com.bytedance.android.shopping.store.home.entity.n) r2.getValue();
        if (r3 == null) goto L11;
        p r4 = r3.h;
        if (r4 == null) goto L11;
        Integer r5 = r4.e();
    L13:
        if (this.B.getTabType() != TabEnum.BIGSALE_TAB.getType()) goto L36;
        int r6 = StoreUITheme.OLD.ordinal();
        if (r5 == null) goto L36;
        if (r5.intValue() != r6) goto L36;
        ECStoreViewModel r7 = this.C;
        if (r7 == null) goto L26;
        jm.a<Integer> r8 = r7.getBigSalePicFinalColor();
        if (r8 == null) goto L26;
        Integer r9 = (Integer) r8.getValue();
        if (r9 == null) goto L26;
        int r10 = r9.intValue();
        r0.setVisibility(0);
        GradientDrawable r11 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r10, 16777215 & r10});
        int r12 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r0, "$this$setBackgroundCompat");
        r0.setBackground(r11);
    L31:
        ECStoreViewModel r13 = this.C;
        if (r13 == null) goto L38;
        jm.a<Boolean> r14 = r13.getSlipEnterLive();
        if (r14 == null) goto L39;
        r14.a(o0(), new c(r0), false);
        return;
    L39:
        return;
    L38:
        return;
    L26:
        ECStoreViewModel r15 = this.C;
        if (r15 == null) goto L31;
        jm.a<Integer> r16 = r15.getBigSalePicFinalColor();
        if (r16 == null) goto L31;
        r16.a(o0(), new b(r0), false);
        Unit r17 = Unit.INSTANCE;
    L36:
        r0.setVisibility(8);
        return;
    L11:
        r5 = null;
        goto L13
    }

    public final LifecycleOwner o0() {
        return ECQuickUtilKt.a(Y());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        o0().getLifecycle().removeObserver(this);
    }

    public static final void d0(ECStoreHybridTabPresenter r2) {
        ViewGroup r0 = r2.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        r0.setVisibility(4);
        ti.l r1 = r2.l;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        ErrorDomain.CONTAINER.getCode();
        ErrorCode.ERROR_CODE_LOAD_SCHEMA.getCode();
        r2.m0(null, null);
        ECStoreHybridTabViewModel r3 = r2.f;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r3.getLoadStatus().g(LoadStatus.InitializeError);
    }

    public static final void e0(ECStoreHybridTabPresenter r2) {
        ViewGroup r0 = r2.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        r0.setVisibility(0);
        ECStoreHybridTabViewModel r3 = r2.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r3.getLoadStatus().g(LoadStatus.InitializeSuccess);
    }

    public static final /* synthetic */ ECStoreHybridTabViewModel h0(ECStoreHybridTabPresenter r1) {
        ECStoreHybridTabViewModel r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public static final void i0(ECStoreHybridTabPresenter r2) {
        ti.l r0 = r2.l;
        if (r0 == null) goto L6;
        r0.sendJsEvent("ecStorePagePatternChanged", MapsKt.mapOf(TuplesKt.to("pagePattern", r2.l0())));
        return;
    }

    public static final void j0(ECStoreHybridTabPresenter r4) {
        ECStoreViewModel r0 = r4.C;
        if (r0 == null) goto L7;
        jm.a<int[]> r1 = r0.getTabContainerSize();
        if (r1 == null) goto L7;
        int[] r2 = (int[]) r1.getValue();
    L8:
        if (r2 == null) goto L16;
        LynxView r3 = r4.s;
        if (r3 == null) goto L12;
        r3.updateScreenMetrics(r2[0], r2[1]);
    L12:
        LynxView r5 = r4.s;
        if (r5 == null) goto L17;
        r5.requestLayout();
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void b0(QModel r8) {
        ECLiveHybridUtil.m("ecom.store.hybrid_tab_page_finish", this.x);
        this.f = Y().g(ECStoreHybridTabViewModel.class);
        ViewStub r9 = (ViewStub) Z().b(2131392595).f();
        Integer r0 = this.B.getContainerType();
        if (r0 != null) goto L6;
    L8:
        int r1 = 2131560949;
    L9:
        r9.setLayoutResource(r1);
        View r10 = r9.inflate();
        if (r10 == null) goto L47;
        this.g = (ViewGroup) r10;
        Context r11 = Y().c();
        ViewGroup r2 = (ViewGroup) Z().b(2131387798).f();
        final LazyStatusView r3 = new LazyStatusView(r11, null);
        r2.addView(r3);
        r3.setCreators(MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ECStoreHybridTabPresenter$initOptStatusView$1(this, r3), null, 6))));
        r3.a(new DefaultStoreTadLoadingStatusView(r11).a());
        ECStoreHybridTabViewModel r12 = this.f;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r12.getLoadStatus().b(ECQuickUtilKt.a(Y()), new com.bytedance.android.shopping.store.hybrid.e(r2, r3));
        ECStoreHybridTabViewModel r13 = this.f;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r13.getHybridInitialData().a(ECQuickUtilKt.a(Y()), new com.bytedance.android.shopping.store.hybrid.d(this), false);
        ECStoreHybridTabViewModel r14 = this.f;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r14.isVisible().d(this.A);
        ECStoreViewModel r15 = this.C;
        if (r15 != null) goto L23;
    L24:
        ECStoreViewModel r16 = this.C;
        if (r16 != null) goto L27;
    L31:
        k0();
    L32:
        ECStoreViewModel r17 = this.C;
        if (r17 == null) goto L37;
        jm.a<Integer> r18 = r17.getCroppedState();
        if (r18 == null) goto L37;
        r18.a(o0(), new f(this), false);
    L37:
        ECStoreHybridTabViewModel r19 = this.f;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        r19.loadInitialData(this.B);
        o0().getLifecycle().addObserver(this);
        this.y.schedule(this.z, 5000);
        ECStoreViewModel r20 = this.C;
        if (r20 == null) goto L48;
        jm.a<int[]> r21 = r20.getTabContainerSize();
        if (r21 == null) goto L49;
        r21.a(o0(), new g(this), false);
        return;
    L49:
        return;
    L48:
        return;
    L27:
        if (r16.couldVideo() != true) goto L31;
    L29:
        if (this.C.isCroppedStyle() == true) goto L31;
        this.C.getCollapseFactor().a(o0(), new e(this), false);
        goto L32
    L23:
        if (r15.couldLive() == true) goto L29;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L6:
        if (r0.intValue() != 3) goto L8;
        r1 = 2131560966;
        goto L9
    }

    public final void m0(JSONObject r10, JSONObject r11) {
        if (this.m == false) goto L5;
        return;
    L5:
        if (this.C == null) goto L24;
        this.m = true;
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECStoreHybridTabViewModel r1 = this.f;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r1.getStoreParam().getLifecycleMonitorId()));
        if (r2 == null) goto L13;
        ECStoreViewModel r3 = this.C;
        com.bytedance.android.shopping.store.lifecycle.c.a.h(r2, r3, this.B, r3.getStoreParam(), r10, r11, 32);
    L13:
        ECStorePerfMonitor r12 = this.C.getPerfMonitor();
        if (r12 == null) goto L18;
        com.bytedance.android.shopping.store.lifecycle.g r13 = r12.k;
        if (r13 == null) goto L18;
        int r14 = com.bytedance.android.shopping.store.lifecycle.g.e;
        r13.c(100, null);
    L18:
        ECStoreHybridTabViewModel r15 = this.f;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r15.getStoreParam().getLifecycleMonitorId()));
        return;
    }

    public final void p0(View r5, int r6) {
        if (r6 <= 6) goto L6;
        return;
    L6:
        if ((r5 instanceof ViewGroup) == true) goto L8;
        return;
    L8:
        if ((r5 instanceof RecyclerView) == false) goto L10;
        ((RecyclerView) r5).addOnScrollListener(new ECStoreHybridTabPresenter$registerRecyclerViewScrollListener$1(this));
        return;
    L10:
        ViewGroup r7 = (ViewGroup) r5;
        int r0 = r7.getChildCount();
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L16;
        p0(r7.getChildAt(r1), r6 + 1);
        r1 = r1 + 1;
        goto L11
    }

    public ECStoreHybridTabPresenter(Fragment r2, StoreTabConfig r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        super(r2);
        this.B = r3;
        this.C = r4;
        this.n = 0.9f;
        this.p = LazyKt.lazy(new ECStoreHybridTabPresenter$jsbChecker$2(this));
        this.r = LazyKt.lazy(new ECStoreHybridTabPresenter$metaInfo$2(this));
        this.t = LazyKt.lazy(new ECStoreHybridTabPresenter$lynxCallback$2(this));
        this.u = new ECStoreHybridTabPresenter$jsbCheckerCallback$1(this);
        this.v = LazyKt.lazy(new ECStoreHybridTabPresenter$h5Callback$2(this));
        this.w = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ecStoreRequestPagePattern", new h(this)), TuplesKt.to("ecom.shop.get_ab_value", new i())});
        this.x = new d(this);
        this.y = new PthreadTimer("ECStoreHybridTabPresenter");
        this.z = new j(this);
        this.A = new k(this);
    }
}
