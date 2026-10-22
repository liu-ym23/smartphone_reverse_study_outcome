package ix4;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2ViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.OfficeSelectColorPlugin;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements i<Highlight> {
    public m a;
    public final a b;

    public interface a {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public b(OfficeSelectColorPlugin.a r1) {
        this.b = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, m r4) {
        final Highlight r5 = (Highlight) r3;
        this.a = r4;
        if (r5 != null) goto L5;
        String r6 = "null";
    L6:
        tt5.a.h("SelectorColorModule#HighlightHandle", r6);
        if (r5 != null) goto L9;
        r5 = new Highlight();
    L9:
        r5.ensureItemType();
        OfficeSelectColorPlugin.a r7 = (OfficeSelectColorPlugin.a) this.b;
        if (OfficeSelectColorPlugin.access$200(r7.a) == null) goto L12;
        OfficeSelectColorPlugin.access$200(r7.a).a(r5);
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        tt5.a.h("SelectorColorModule#HighlightHandle", "interceptHandler() true, return it");
        return;
    L15:
        ((SelectColorV2ViewModel) q.b(((OfficeSelectColorPlugin.a) this.b).a, SelectColorV2ViewModel.class)).updateHighlight(r5);
        j.c(new ix4.a(this, r5));
        return;
    L12:
        r8 = false;
        goto L13
    L5:
        r6 = r5.toString();
        goto L6
    }

    public final void a(Highlight.ColorItem r5, Highlight.ColorItem r6, Highlight.ColorItem r7, Highlight.ColorItem r8) {
        if (this.a != null) goto L19;
        tt5.a.d("SelectorColorModule#HighlightHandle", "callback is null");
        return;
    L19:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L15
        if (r5 == null) goto L7;
        r5.setType(null);     // Catch: Exception -> L15
        r0.put(RectColorView.RectColorType.TYPE_BACKGROUND, r5);     // Catch: Exception -> L15
    L7:
        if (r6 == null) goto L9;
        r6.setType(null);     // Catch: Exception -> L15
        r0.put("text", r6);     // Catch: Exception -> L15
    L9:
        if (r7 == null) goto L11;
        r0.clear();     // Catch: Exception -> L15
        r7.setType(null);     // Catch: Exception -> L15
        r7.setValue(null);     // Catch: Exception -> L15
        r0.put(RectColorView.RectColorType.TYPE_CLEAR, r7);     // Catch: Exception -> L15
    L11:
        if (r8 == null) goto L13;
        r0.clear();     // Catch: Exception -> L15
        r8.setType(null);     // Catch: Exception -> L15
        r8.setValue(null);     // Catch: Exception -> L15
        r0.put("reset", r8);     // Catch: Exception -> L15
    L13:
        tt5.a.h("SelectorColorModule#HighlightHandle", r0.toJSONString());     // Catch: Exception -> L15
        this.a.b(r0);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.f("SelectorColorModule#HighlightHandle", e, false);
    }
}
