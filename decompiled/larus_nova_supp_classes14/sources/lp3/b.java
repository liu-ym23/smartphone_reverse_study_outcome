package lp3;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final a a = null;

    public static final class a extends hp3.b {
        public final Map<String, String> b;

        public a() {
            Intrinsics.checkNotNullParameter("header", "action");
            super("windowEnterLiveRoom");
            this.b = MapsKt.mapOf(TuplesKt.to("action", "header"));
        }

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.b;
        }
    }

    static {
        a = new a();
        Intrinsics.checkNotNullParameter("small_window", "action");
        Intrinsics.checkNotNullParameter("windowEnterLiveRoom", "eventName");
        MapsKt.mapOf(TuplesKt.to("action", "small_window"));
    }
}
