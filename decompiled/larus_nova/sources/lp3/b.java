package lp3;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f510213a = null;

    public static final class a extends hp3.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f510214b;

        public a() {
            Intrinsics.checkNotNullParameter("header", "action");
            super("windowEnterLiveRoom");
            this.f510214b = MapsKt.mapOf(TuplesKt.to("action", "header"));
        }

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.f510214b;
        }
    }

    static {
        f510213a = new a();
        Intrinsics.checkNotNullParameter("small_window", "action");
        Intrinsics.checkNotNullParameter("windowEnterLiveRoom", "eventName");
        MapsKt.mapOf(TuplesKt.to("action", "small_window"));
    }
}
