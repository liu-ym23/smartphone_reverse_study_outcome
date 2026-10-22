package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.dto.business.FindSameGoodsStruct;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONObject;
import vg3.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r7) {
        com.bytedance.android.shopping.anchorv4.dto.business.d r8 = (com.bytedance.android.shopping.anchorv4.dto.business.d) r7;
        if (this.a.a2().getNativeParams().getFullMode() == false) goto L43;
        String r0 = null;
        if (r8 == null) goto L7;
        FindSameSource r1 = r8.getSourceType();
    L9:
        if (r1 != FindSameSource.DIALOG) goto L44;
        d r2 = this.a;
        List r9 = r8.getFeedStruct();
        if (r9 != null) goto L13;
        r2.getClass();
        return;
    L13:
        boolean r3 = false;
        if (r2.k == false) goto L17;
        r2.l = false;
        r2.k = false;
    L17:
        if (r2.l == true) goto L47;
        CommonMeta r4 = r2.O1().d().getData().a().a();
        if (r4 == null) goto L24;
        FindSameGoodsStruct r5 = r4.getFullScreenFindSame();
        if (r5 == null) goto L24;
        r0 = r5.getFindSameSchema();
    L24:
        if (r0 != null) goto L27;
        r0 = "";
    L27:
        if (r0.length() != 0) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L32;
        return;
    L32:
        if (r9.size() <= 3) goto L46;
        Uri.Builder r6 = UriProtector.parse(r0).buildUpon();
        JSONArray r10 = new JSONArray();
        Iterator<T> r11 = r9.iterator();
    L35:
        if (r11.hasNext() == false) goto L37;
        r10.put(tv5.a.a(u0.c(), (SameGoodsItem) r11.next()));
        goto L35
    L37:
        JSONObject r12 = new JSONObject();
        r12.put("products", r10);
        r12.put("identifier", AnchorV4DataManager.d);
        Unit r13 = Unit.INSTANCE;
        r6.appendQueryParameter("mega_object", r12.toString()).appendQueryParameter("click_lynx_time_stamp", String.valueOf(System.currentTimeMillis()));
        f0 r14 = (f0) r2.N1(f0.class);
        if (r14 == null) goto L40;
        r14.openSchema(r6.build().toString());
    L40:
        r2.l = true;
        return;
    L46:
        return;
    L47:
        return;
    L44:
        return;
    L7:
        r1 = null;
        goto L9
    }
}
