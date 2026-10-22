package com.bytedance.android.shopping.mall.feed.ability;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallOpenSchemaJsb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final Context b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ability.a$a, reason: collision with other inner class name */
    public static final class C0080a {
    }

    static {
    }

    public a(String r2, FragmentActivity r3, ECMallOpenSchemaJsb r4) {
        Intrinsics.checkNotNullParameter(r2, "sceneID");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "openSchemaProxy");
        this.a = r2;
        this.b = r3;
    }
}
