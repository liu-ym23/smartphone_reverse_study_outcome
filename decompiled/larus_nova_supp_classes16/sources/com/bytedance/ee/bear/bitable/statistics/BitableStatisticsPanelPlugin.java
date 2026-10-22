package com.bytedance.ee.bear.bitable.statistics;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.bear.bitable.common.viewmodel.TableInfoViewModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "analytic", "Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "viewModel", "Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "Companion", "GroupPanelHandler", "SendGroupDataHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticsPanelPlugin extends DocumentPluginV2 {
    public static final int ACTION_CLOSE_PANEL = 3;
    public static final String BIZ_OPEN_STAT_PANEL = "biz.bitable.openStatPanel";
    public static final String BIZ_SEND_GROUP_DATA = "biz.bitable.sendGroupData";
    public static final a Companion = null;
    public static final String TAG = "BitableStatisticsPlugin";
    public static final int TYPE_CLOSE_PANEL = 3;
    private BitableFieldEditAnalytic analytic;
    private m callback;
    private final Lazy viewModel$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {
        public final /* synthetic */ BitableStatisticsPanelPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableStatisticsPanelPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r21, m r22) {
            String r2 = (String) r21;
            tt5.a.b("GroupPanelHandler", "handle: " + r2);
            if (r22 == null) goto L8;
            BitableStatisticsPanelPlugin r9 = this.a;
            i5 r11 = BitableStatisticsPanelPlugin.access$getViewModel(r9).getLynxWebDelegate();
            if (r11 == null) goto L7;
            r11.c(BitableStatisticsPanelPlugin.BIZ_OPEN_STAT_PANEL, r22);
        L7:
            BitableStatisticsPanelPlugin.access$setCallback$p(r9, r22);
        L8:
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setPanelType(StatPanelType.UNKONW);
            if (r2 != null) goto L50;
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).getActive().setValue(Boolean.FALSE);
            return;
        L50:
            JSONObject r0 = new JSONObject(r2);     // Catch: Exception -> L45
            int r3 = r0.optInt("type");     // Catch: Exception -> L45
            int r12 = r0.optInt("panelType");     // Catch: Exception -> L45
            if (3 != r3) goto L13;
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).getActive().setValue(Boolean.FALSE);     // Catch: Exception -> L45
            return;
        L13:
            BitableFieldEditAnalytic r14 = BitableStatisticsPanelPlugin.access$getAnalytic$p(this.a);     // Catch: Exception -> L45
            if (r14 == null) goto L16;
            String r19 = "bitable";
            r14.N(r0.optString("baseId"), r0.optString("tableId"), r0.optString("viewId"), "grid", "bitable");     // Catch: Exception -> L45
        L16:
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).getActive().setValue(Boolean.TRUE);     // Catch: Exception -> L45
            LinkedHashMap r13 = new LinkedHashMap();     // Catch: Exception -> L45
            r13.put("pageType", Integer.valueOf(r12));     // Catch: Exception -> L45
            StatPanelType r16 = StatPanelType.GROUPING_STATISTICS_VIEW;     // Catch: Exception -> L45
            if (r12 != r16.getType()) goto L22;
            JSONObject r17 = JSONObjectProtectorUtils.getJSONObject(r0, "data");     // Catch: Exception -> L45
            String r18 = r17.optString("focusId");     // Catch: Exception -> L45
            r19 = "GroupPanelHandler";
            String r110 = "srcObjType";
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setFocusId((List) new GsonBuilder().create().fromJson(r18, List.class));     // Catch: Exception -> L43
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setFocusStatType(r17.optString("focusStatType"));     // Catch: Exception -> L43
            r13.put("groupingStatisticsCountViewData", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", Integer.valueOf(r3)), TuplesKt.to("data", r17.optJSONArray("groupData")), TuplesKt.to("focusId", JSONObjectProtectorUtils.getJSONArray(r17, "focusId")), TuplesKt.to("hasMoreData", r17.optJSONArray("hasMoreData")), TuplesKt.to("focusStatType", r17.optString("focusStatType")), TuplesKt.to("maxRecordSize", Integer.valueOf(r17.optInt("maxRecordSize")))}));     // Catch: Exception -> L43
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setPanelType(r16);     // Catch: Exception -> L43
        L28:
            BitableFieldEditAnalytic r4 = BitableStatisticsPanelPlugin.access$getAnalytic$p(this.a);     // Catch: Exception -> L43
            if (r4 == null) goto L32;
            Map r5 = r4.b();     // Catch: Exception -> L43
            if (r5 == null) goto L32;
        L33:
            JSONObject r6 = new JSONObject(r5);     // Catch: Exception -> L43
            GridViewLayoutType r7 = BitableStatisticsPanelPlugin.access$viewModel(this.a, TableInfoViewModel.class).getGridViewLayoutType();     // Catch: Exception -> L43
            if (r7 == null) goto L36;
            String r8 = r7.getTag();     // Catch: Exception -> L43
        L37:
            r6.put("mobile_grid_type", r8);     // Catch: Exception -> L43
            r13.put("reportCommonParams", r6);     // Catch: Exception -> L43
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setSrcObjToken(r0.optString("srcObjToken", null));     // Catch: Exception -> L43
            String r10 = r110;
            if (r0.optInt(r10, -1) != (-1)) goto L40;
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setSrcObjType(null);     // Catch: Exception -> L43
        L41:
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).getTemplateData().setValue(r13);     // Catch: Exception -> L43
            return;
        L40:
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setSrcObjType(Integer.valueOf(r0.optInt(r10)));     // Catch: Exception -> L43
            goto L41
        L36:
            r8 = null;
        L32:
            r5 = MapsKt.emptyMap();     // Catch: Exception -> L43
            goto L33
        L22:
            r110 = "srcObjType";
            r19 = "GroupPanelHandler";
            if (r12 != StatPanelType.TOTAL_STATISTICS_VIEW.getType()) goto L28;
            ArrayList r20 = new ArrayList();     // Catch: Exception -> L43
            JSONArray r23 = JSONObjectProtectorUtils.getJSONArray(r0, "data");     // Catch: Exception -> L43
            int r24 = r23.length();     // Catch: Exception -> L43
            int r26 = 0;
        L25:
            if (r26 >= r24) goto L27;
            r20.add(r23.get(r26).toString());     // Catch: Exception -> L43
            r26 = r26 + 1;     // Catch: Exception -> L43
            goto L25
        L27:
            r13.put("totalStatisticsData", MapsKt.mapOf(new Pair[]{TuplesKt.to("statDataList", r20), TuplesKt.to("type", Integer.valueOf(r3))}));     // Catch: Exception -> L43
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).setPanelType(StatPanelType.TOTAL_STATISTICS_VIEW);     // Catch: Exception -> L43
        L43:
            e = e;
        L47:
            tt5.a.e(r19, "handle, parse failed", e, false);
            return;
        L45:
            e = e;
            r19 = "GroupPanelHandler";
            goto L47
        }
    }

    public final class c implements i<String> {
        public final /* synthetic */ BitableStatisticsPanelPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableStatisticsPanelPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            tt5.a.b("SendGroupDataHandler", "handle: " + r4);
            if (Intrinsics.areEqual(BitableStatisticsPanelPlugin.access$getViewModel(this.a).getActive().getValue(), Boolean.TRUE) == false) goto L7;
            if (r4 == null) goto L8;
            BitableStatisticsPanelPlugin.access$getViewModel(this.a).getObtainGroupData().setValue(r4);
            return;
        L8:
            return;
        }
    }

    public static final class d implements BitableStatisticsPanelViewModel.a {
        public final /* synthetic */ BitableStatisticsPanelPlugin a;

        @Override // com.bytedance.ee.bear.bitable.statistics.BitableStatisticsPanelViewModel.a
        public final void onClose() {
            m r0 = BitableStatisticsPanelPlugin.access$getCallback$p(this.a);
            if (r0 == null) goto L6;
            com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject();
            r1.put(JSEventListener.ACTION, 3);
            r0.b(r1);
            return;
        }

        public d(BitableStatisticsPanelPlugin r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final BitableStatisticsPanelViewModel getViewModel() {
        return (BitableStatisticsPanelViewModel) this.viewModel$delegate.getValue();
    }

    public BitableStatisticsPanelPlugin() {
        this.viewModel$delegate = LazyKt.lazy(new BitableStatisticsPanelPlugin$viewModel$2(this));
    }

    public static final /* synthetic */ BitableFieldEditAnalytic access$getAnalytic$p(BitableStatisticsPanelPlugin r0) {
        return r0.analytic;
    }

    public static final /* synthetic */ m access$getCallback$p(BitableStatisticsPanelPlugin r0) {
        return r0.callback;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(BitableStatisticsPanelPlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ BitableStatisticsPanelViewModel access$getViewModel(BitableStatisticsPanelPlugin r0) {
        return r0.getViewModel();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_OPEN_STAT_PANEL, new b(this));
        r3.put(BIZ_SEND_GROUP_DATA, new c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r5) {
        super.onAttachToHost(r5);
        k r6 = getWebOrNull();
        if (r6 == null) goto L5;
        getViewModel().setLynxWebDelegate(new i5(r6));
        getViewModel().setDelegate(new d(this));
    L5:
        getViewModel().getActive().observe(getLifecycleOwner(), new AnonymousClass2(this));
        this.analytic = new BitableFieldEditAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), getDocumentMetadata().getBearUrl(), viewModel(TableInfoViewModel.class)));
        getViewModel().setAnalytic(this.analytic);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        BitableFieldEditAnalytic r0 = this.analytic;
        if (r0 == null) goto L9;
        if (r2 == null) goto L6;
        int r3 = r2.orientation;
    L7:
        r0.M(r3);
        return;
    L6:
        r3 = 1;
        goto L7
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(BitableStatisticsPanelPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setCallback$p(BitableStatisticsPanelPlugin r0, m r1) {
        r0.callback = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(BitableStatisticsPanelPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
