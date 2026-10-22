package ff4;

import android.net.Uri;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.TTPayAnnieContainerImpl;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.p;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends e {
    @Override // t36.e
    public final String getName() {
        return TTPayAnnieContainerImpl.CAIJING_BID;
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.e
    public final boolean b(d r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaData");
        r110.a("cj_open_time", new p(String.valueOf(System.currentTimeMillis())), false);
        String r100 = null;
        Boolean r101 = (Boolean) new y36.a(r110, "cj_enable_popup_event", null).f565862b;
        if (r101 == null) goto L5;
        r110.a("cj_enable_lifecycle_event", new y36.a(Boolean.valueOf(r101.booleanValue())), false);
    L5:
        String r102 = (String) new p(r110, "cj_popup_session_id", null).f565862b;
        if (r102 == null) goto L8;
        r110.a("cj_session_id", new p(r102), false);
    L8:
        String r103 = (String) new p(r110, "ttpay_annie_query", null).f565862b;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L31;
        Uri.Builder r105 = new Uri.Builder();
        Iterator r106 = ((LinkedHashMap) r110.f248139p).entrySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L24;
        Map.Entry r107 = (Map.Entry) r106.next();
        if (StringsKt.startsWith$default((String) r107.getKey(), "cj_", false, 2, null) == false) goto L18;
        if (r107.getValue() == null) goto L18;
        r105.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());
        goto L18
    L24:
        String r108 = r105.build().getEncodedQuery();
        if (r108 == null) goto L31;
        if ((!StringsKt.isBlank(r108)) == false) goto L29;
        r100 = r108;
    L29:
        if (r100 == null) goto L31;
        r110.a("ttpay_annie_query", new p(r100), false);
    L31:
        return true;
    L11:
        if (StringsKt.isBlank(r103) == true) goto L14;
        r104 = false;
        goto L15
    }
}
