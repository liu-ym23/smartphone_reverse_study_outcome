package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final LinearLayout a;
    public final com.bytedance.android.shopping.anchorv4.helper.n b;
    public final Map<String, Boolean> c;
    public final Context d;

    public final Context getContext() {
        return this.d;
    }

    public c(FragmentActivity r3, SlcContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcContext");
        this.d = r3;
        LinearLayout r0 = new LinearLayout(r3);
        r0.setOrientation(1);
        Unit r5 = Unit.INSTANCE;
        this.a = r0;
        this.b = new com.bytedance.android.shopping.anchorv4.helper.n(r0, r4, null);
        this.c = MapsKt.mapOf(TuplesKt.to("is_android", Boolean.TRUE));
    }
}
