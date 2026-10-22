package com.bytedance.ee.bear.sheet.filter;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final /* synthetic */ OfficeFilterPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(OfficeFilterPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r5, tb5.m r6) {
            FilterData r7 = (FilterData) r5;
            Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
            tt5.a.b(OfficeFilterPlugin.TAG, "handle: FilterData = " + r7);
            FilterViewModel r0 = OfficeFilterPlugin.access$getFilterViewModel$p(this.a);
            FilterViewModel r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
            r0 = null;
        L5:
            r0.setDelegate(new u(r6));
            FilterViewModel r8 = OfficeFilterPlugin.access$getFilterViewModel$p(this.a);
            if (r8 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        L9:
            r1.updateFilterData(r7);
            return;
        L8:
            r1 = r8;
            goto L9
        }
    }

    public static final class c implements FilterViewModel.c {
        public final /* synthetic */ OfficeFilterPlugin a;

        public c(OfficeFilterPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.filter.FilterViewModel.c
        public final void a(int r3, String r4, int r5) {
            JSONObject r0 = new JSONObject();
            r0.put("current", Integer.valueOf(r3));
            r0.put("size", 2000);
            r0.put("sheetId", r4);
            r0.put("currentCol", Integer.valueOf(r5));
            tt5.a.b(OfficeFilterPlugin.TAG, "native pull paging data " + r0);
            OfficeFilterPlugin r6 = this.a;
            OfficeFilterPlugin.access$execJS(r6, OfficeFilterPlugin.GET_FILTER, r0, new v(r6));
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeFilterPlugin() {
    }

    public static final /* synthetic */ FilterViewModel access$getFilterViewModel$p(OfficeFilterPlugin r0) {
        return r0.filterViewModel;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_SHEET_SET_FILTER, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.filterViewModel = com.bytedance.ee.bear.browser.plugin.q.c(r3, FilterViewModel.class, null);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        FilterViewModel r4 = this.filterViewModel;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        r4 = null;
    L5:
        r4.setFilterValueDelegate(new c(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$execJS(OfficeFilterPlugin r0, String r1, JSONObject r2, ValueCallback r3) {
        r0.execJS(r1, r2, r3);
    }
}
