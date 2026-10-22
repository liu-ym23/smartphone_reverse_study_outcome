package com.bytedance.android.window.shop.home.tab.tabplugin;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final a a;
    public final String b;

    public static final class a implements j {
        public final Function1<JSONObject, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super JSONObject, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a = r2;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.invoke(r2);
        }
    }

    public c(String r2, Function1<? super JSONObject, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        this.b = r2;
        this.a = new a(r3);
    }
}
