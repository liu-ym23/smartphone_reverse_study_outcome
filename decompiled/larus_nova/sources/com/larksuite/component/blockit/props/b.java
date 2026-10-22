package com.larksuite.component.blockit.props;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f283110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f283111b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        JSONObject r101 = new JSONObject(this.f283111b);
        r101.put("tag_id", this.f283110a);     // Catch: JSONException -> L6
        r101.put("from", "view");     // Catch: JSONException -> L6
    L4:
        qy7.a.a("pano_panel_and_view_jump", r101);
        r100.getContext();
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).b();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setColor(UIHelper.getColor(R.color.lkui_B700));
        r100.setUnderlineText(false);
        r100.clearShadowLayer();
    }

    public b(String r100, String r101, Map<String, Object> r102) {
        this.f283110a = r101;
        this.f283111b = r102;
    }
}
