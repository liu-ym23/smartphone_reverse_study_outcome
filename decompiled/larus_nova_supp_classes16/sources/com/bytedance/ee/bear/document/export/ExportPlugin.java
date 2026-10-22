package com.bytedance.ee.bear.document.export;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/export/ExportPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "onClickSheetLongImage", "", "onShowExportBadges", "panelName", "", "badge", "onClickExport", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExportPlugin extends DocumentPlugin {
    public static final String BIZ_SHEET_CLEAR_BADGES = "javascript:window.lark.biz.sheet.clearBadges";
    public static final String BIZ_SHEET_CLICK_EXPORT = "javascript:lark.biz.sheet.clickExport";
    public static final a Companion = null;
    public static final String EXPORT_ITEM_ID_EXPORTPANEL = "exportPanel";
    public static final String EXPORT_ITEM_ID_SHEETLONGIMAGE = "sheetLongImage";
    public static final String TAG = "ExportPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void onClickExport() {
        JSONObject r0 = new JSONObject();
        r0.put("id", EXPORT_ITEM_ID_EXPORTPANEL);
        execJS(BIZ_SHEET_CLICK_EXPORT, r0);
        tt5.a.h(TAG, "Click ExportPanel item.");
    }

    public final void onClickSheetLongImage() {
        JSONObject r0 = new JSONObject();
        r0.put("id", EXPORT_ITEM_ID_SHEETLONGIMAGE);
        execJS(BIZ_SHEET_CLICK_EXPORT, r0);
        tt5.a.h(TAG, "Click SheetLongImage item.");
    }

    public ExportPlugin() {
    }

    public final void onShowExportBadges(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "panelName");
        Intrinsics.checkNotNullParameter(r4, "badge");
        JSONObject r1 = new JSONObject();
        r1.put("panelName", r3);
        r1.put("badges", new String[]{r4});
        execJS(BIZ_SHEET_CLEAR_BADGES, r1);
        tt5.a.b(TAG, "clear badges: " + r1.toJSONString());
    }
}
