package lp3;

import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final C0143a a = null;
    public static final C0143a b = null;

    /* JADX INFO: renamed from: lp3.a$a, reason: collision with other inner class name */
    public static final class C0143a extends hp3.b {
        public final Map<String, String> b;

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.b;
        }

        public C0143a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            super("windowBack");
            this.b = MapsKt.mapOf(TuplesKt.to("type", r3));
        }
    }

    static {
        a = new C0143a(PinchEnterMethod.CLICK);
        b = new C0143a("system");
    }
}
