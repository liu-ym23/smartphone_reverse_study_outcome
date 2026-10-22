package com.bytedance.ee.bear.share.newshare;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e0 {
    public final String a;

    public void a(View r1, List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "itemView");
    }

    public abstract View b(ViewGroup r1);

    public d0 c() {
        return null;
    }

    public boolean d(e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        return false;
    }

    public e0(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        this.a = r2;
    }
}
