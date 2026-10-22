package com.bytedance.android.livesdk.livecommerce.skin;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTabUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.tab.ECLiveSkinTabEnhanceElement;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public b() {
    }

    public static ECLiveSkinBaseViewUIConfig a(int r8, boolean r9, boolean r10) {
        ECLiveSkinUtil.l.getClass();
        if (ECLiveSkinUtil.j != null) goto L37;
        LinkedHashMap r0 = new LinkedHashMap();
        String r2 = (String) ECLiveSkinUtil.i.getValue();
        boolean r4 = true;
        if (r2.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r2 = null;
    L11:
        if (r2 != null) goto L14;
        r2 = "{\"1\":{\"style\":{\"unselected\":{\"text\":{\"color\":[\"#FF7075\",\"#FF3344\"],\"font_size\":13,\"font_weight\":600}}}}}";
    L14:
        if (r2.length() > 0) goto L17;
        r4 = false;
    L17:
        if (r4 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L37;
        JSONObject r5 = ECLiveSkinUtil.a(r2, "normal");
        if (r5 == null) goto L36;
        Iterator<String> r6 = r5.keys();
    L25:
        if (r6.hasNext() == false) goto L36;
        String r7 = r6.next();
        JSONObject r11 = r5.optJSONObject(r7);
        if (r11 == null) goto L25;
        String r12 = r11.toString();
        if (r12 == null) goto L25;
        int r13 = m0.a;     // Catch: Exception -> L34
        ECLiveSkinTabEnhanceElement r14 = (ECLiveSkinTabEnhanceElement) m0.a.a.fromJson(r12, ECLiveSkinTabEnhanceElement.class);     // Catch: Exception -> L34
        if (r14 == null) goto L25;
        r0.put(r7, r14);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L36:
        ECLiveSkinUtil.j = r0;
        goto L37
    L7:
        r3 = false;
    L37:
        Map<String, ECLiveSkinTabEnhanceElement> r1 = ECLiveSkinUtil.j;
        if (r1 == null) goto L40;
        ECLiveSkinTabEnhanceElement r15 = (ECLiveSkinTabEnhanceElement) ((LinkedHashMap) r1).get(String.valueOf(r8));
    L41:
        if (r15 != null) goto L43;
        return null;
    L43:
        if (r9 == true) goto L47;
        ECLiveSkinTabUIConfig r16 = r15.getStyle();
        if (r16 != null) goto L67;
        return null;
    L67:
        return r16.getDisabled();
    L47:
        if (r10 == false) goto L51;
        ECLiveSkinTabUIConfig r17 = r15.getStyle();
        if (r17 != null) goto L69;
        return null;
    L69:
        return r17.getSelected();
    L51:
        ECLiveSkinTabUIConfig r18 = r15.getStyle();
        if (r18 != null) goto L54;
        return null;
    L54:
        return r18.getUnselected();
    L40:
        r15 = null;
        goto L41
    }

    public final int[] b(int r1, boolean r2, boolean r3) {
        ECLiveSkinBaseViewUIConfig r4 = a(r1, r2, r3);
        if (r4 == null) goto L16;
        ECLiveSkinTextElement r5 = r4.getText();
        if (r5 == null) goto L23;
        List<String> r6 = r5.getColor();
        if (r6 == null) goto L24;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Integer r9 = s.b((String) r8.next());
        if (r9 == null) goto L10;
        r7.add(Integer.valueOf(r9.intValue()));
        goto L10
    L15:
        return CollectionsKt.toIntArray(r7);
    L24:
        return null;
    L23:
        return null;
    L16:
        return null;
    }

    public final Integer c(int r1, boolean r2, boolean r3) {
        ECLiveSkinBaseViewUIConfig r4 = a(r1, r2, r3);
        if (r4 == null) goto L7;
        ECLiveSkinTextElement r5 = r4.getText();
        if (r5 == null) goto L7;
        return Integer.valueOf(r5.getFontSize());
    L7:
        return null;
    }

    public final Integer d(int r1, boolean r2, boolean r3) {
        ECLiveSkinBaseViewUIConfig r4 = a(r1, r2, r3);
        if (r4 == null) goto L7;
        ECLiveSkinTextElement r5 = r4.getText();
        if (r5 == null) goto L7;
        return Integer.valueOf(r5.getFontWeight());
    L7:
        return null;
    }
}
