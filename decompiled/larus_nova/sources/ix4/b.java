package ix4;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2ViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.OfficeSelectColorPlugin;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements i<Highlight> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f496357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f496358b;

    public interface a {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public b(OfficeSelectColorPlugin.a r100) {
        this.f496358b = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        final Highlight r102 = (Highlight) r100;
        this.f496357a = r101;
        if (r102 != null) goto L5;
        String r103 = "null";
    L6:
        tt5.a.h("SelectorColorModule#HighlightHandle", r103);
        if (r102 != null) goto L9;
        r102 = new Highlight();
    L9:
        r102.ensureItemType();
        OfficeSelectColorPlugin.a r104 = (OfficeSelectColorPlugin.a) this.f496358b;
        if (OfficeSelectColorPlugin.access$200(r104.f219582a) == null) goto L12;
        OfficeSelectColorPlugin.access$200(r104.f219582a).a(r102);
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        tt5.a.h("SelectorColorModule#HighlightHandle", "interceptHandler() true, return it");
        return;
    L15:
        ((SelectColorV2ViewModel) q.b(((OfficeSelectColorPlugin.a) this.f496358b).f219582a, SelectColorV2ViewModel.class)).updateHighlight(r102);
        j.c(new ix4.a(this, r102));
        return;
    L12:
        r105 = false;
        goto L13
    L5:
        r103 = r102.toString();
        goto L6
    }

    public final void a(Highlight.ColorItem r100, Highlight.ColorItem r101, Highlight.ColorItem r102, Highlight.ColorItem r103) {
        if (this.f496357a != null) goto L19;
        tt5.a.d("SelectorColorModule#HighlightHandle", "callback is null");
        return;
    L19:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L15
        if (r100 == null) goto L7;
        r100.setType(null);     // Catch: Exception -> L15
        r104.put2("background", r100);     // Catch: Exception -> L15
    L7:
        if (r101 == null) goto L9;
        r101.setType(null);     // Catch: Exception -> L15
        r104.put2("text", r101);     // Catch: Exception -> L15
    L9:
        if (r102 == null) goto L11;
        r104.clear();     // Catch: Exception -> L15
        r102.setType(null);     // Catch: Exception -> L15
        r102.setValue(null);     // Catch: Exception -> L15
        r104.put2("clear", r102);     // Catch: Exception -> L15
    L11:
        if (r103 == null) goto L13;
        r104.clear();     // Catch: Exception -> L15
        r103.setType(null);     // Catch: Exception -> L15
        r103.setValue(null);     // Catch: Exception -> L15
        r104.put2(BasicTestActionHandler.TEST_ACTION_RESET, r103);     // Catch: Exception -> L15
    L13:
        tt5.a.h("SelectorColorModule#HighlightHandle", r104.toJSONString());     // Catch: Exception -> L15
        this.f496357a.b(r104);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.f("SelectorColorModule#HighlightHandle", e, false);
    }
}
