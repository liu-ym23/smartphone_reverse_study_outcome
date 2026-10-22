package hy3;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b a;
    public final c b;
    public final String c;
    public final Map<String, View> d;
    public final a e;

    public b(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2, c r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "mPageOwner");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        Intrinsics.checkNotNullParameter(r4, "publishScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new LinkedHashMap();
        this.e = new a();
    }
}
