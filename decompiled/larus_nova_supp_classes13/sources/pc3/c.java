package pc3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.b<pc3.a> {

    public static final class a {
    }

    static {
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        Object r0 = r4.get("videos_v2");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map<?, ?> r1 = (Map) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Object r5 = r4.get("play_btn_url");
        if ((r5 instanceof String) == false) goto L12;
        r2 = r5;
    L12:
        String r3 = (String) r2;
        if (r3 != null) goto L15;
        return;
    L15:
        ((pc3.a) l1()).c(r1, r3);
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new pc3.a(r2);
    }
}
