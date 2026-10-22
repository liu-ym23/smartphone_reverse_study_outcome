package kp3;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.tencent.open.SocialConstants;
import hp3.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Lifecycle.Event, b> f505495a = null;

    /* JADX INFO: renamed from: kp3.a$a, reason: collision with other inner class name */
    public static final class C6594a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f505496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lifecycle.Event f505497c;

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.f505496b;
        }

        public C6594a(Lifecycle.Event r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleEvent");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            super("windowLifecycleStateChanged");
            this.f505497c = r100;
            this.f505496b = MapsKt.mapOf(TuplesKt.to("event", r101));
        }
    }

    static {
        Intrinsics.checkNotNullParameter(Lifecycle.Event.ON_ANY, "lifecycleEvent");
        Intrinsics.checkNotNullParameter("", SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter("windowLifecycleStateChanged", "eventName");
        MapsKt.mapOf(TuplesKt.to("event", ""));
        List r100 = CollectionsKt.listOf(new C6594a[]{new C6594a(Lifecycle.Event.ON_CREATE, WidgetCostModule.TYPE_ON_CREATE), new C6594a(Lifecycle.Event.ON_RESUME, "onResume"), new C6594a(Lifecycle.Event.ON_PAUSE, "onPause"), new C6594a(Lifecycle.Event.ON_DESTROY, LiveCommonConstants.REASON_ON_DEDTROY)});
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(((C6594a) r103).f505497c, r103);
        goto L4
    L6:
        f505495a = r101;
    }
}
