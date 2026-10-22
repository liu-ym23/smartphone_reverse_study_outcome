package com.bytedance.ee.bear.sheet.filter;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeFilterPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "filterViewModel", "Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "FilterHandler", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFilterPlugin extends DocumentPluginV3 {
    private static final String BIZ_SHEET_SET_FILTER = "biz.sheet.setFilter";
    public static final a Companion = null;
    private static final String GET_FILTER = "javascript:window.lark.biz.sheet.getFilterValues";
    private static final String TAG = "FilterPlugin";
    private FilterViewModel filterViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<FilterData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeFilterPlugin f237740a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeFilterPlugin r100) {
            this.f237740a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            FilterData r102 = (FilterData) r100;
            Intrinsics.checkNotNullParameter(r102, "data");
            tt5.a.b(OfficeFilterPlugin.TAG, "handle: FilterData = " + r102);
            FilterViewModel r103 = OfficeFilterPlugin.access$getFilterViewModel$p(this.f237740a);
            FilterViewModel r104 = null;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
            r103 = null;
        L5:
            r103.setDelegate(new u(r101));
            FilterViewModel r105 = OfficeFilterPlugin.access$getFilterViewModel$p(this.f237740a);
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        L9:
            r104.updateFilterData(r102);
            return;
        L8:
            r104 = r105;
            goto L9
        }
    }

    public static final class c implements FilterViewModel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeFilterPlugin f237741a;

        public c(OfficeFilterPlugin r100) {
            this.f237741a = r100;
        }

        @Override // com.bytedance.ee.bear.sheet.filter.FilterViewModel.c
        public final void a(int r100, String r101, int r102) {
            JSONObject r103 = new JSONObject();
            r103.put("current", Integer.valueOf(r100));
            r103.put("size", 2000);
            r103.put("sheetId", r101);
            r103.put("currentCol", Integer.valueOf(r102));
            tt5.a.b(OfficeFilterPlugin.TAG, "native pull paging data " + r103);
            OfficeFilterPlugin r104 = this.f237741a;
            OfficeFilterPlugin.access$execJS(r104, OfficeFilterPlugin.GET_FILTER, r103, new v(r104));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public OfficeFilterPlugin() {
    }

    public static final /* synthetic */ FilterViewModel access$getFilterViewModel$p(OfficeFilterPlugin r100) {
        return r100.filterViewModel;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(BIZ_SHEET_SET_FILTER, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        this.filterViewModel = (FilterViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r100, FilterViewModel.class, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        super.onAttachToUIContainer(r100, r101);
        FilterViewModel r102 = this.filterViewModel;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        r102 = null;
    L5:
        r102.setFilterValueDelegate(new c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    public static final /* synthetic */ void access$execJS(OfficeFilterPlugin r100, String r101, JSONObject r102, ValueCallback r103) {
        r100.execJS(r101, r102, r103);
    }
}
