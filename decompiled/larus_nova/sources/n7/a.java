package n7;

import android.content.Context;
import com.bytedance.android.annie.param.k;
import com.bytedance.ies.bullet.web.pia.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import o7.l;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends s26.a implements b {
    @Override // com.bytedance.ies.bullet.web.pia.b
    public final String b0() {
        return l.b(new StringBuilder());
    }

    public a() {
    }

    @Override // com.bytedance.ies.bullet.web.pia.b
    public final String J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentTemplateUrl");
        return l.c(r100, null, "");
    }

    @Override // com.bytedance.ies.bullet.web.pia.b
    public final Map T(Context r100, String r101, String r102) {
        k r103 = com.bytedance.android.annie.a.a(r100, r101, false, r102, "host");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(com.bytedance.android.annie.param.b.b(r103));
        return r104;
    }
}
