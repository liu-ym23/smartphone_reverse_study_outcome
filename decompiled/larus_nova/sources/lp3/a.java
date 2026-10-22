package lp3;

import com.ss.android.lark.camera_export.CameraParam;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6722a f510210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C6722a f510211b = null;

    /* JADX INFO: renamed from: lp3.a$a, reason: collision with other inner class name */
    public static final class C6722a extends hp3.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f510212b;

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.f510212b;
        }

        public C6722a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            super("windowBack");
            this.f510212b = MapsKt.mapOf(TuplesKt.to("type", r100));
        }
    }

    static {
        f510210a = new C6722a("click");
        f510211b = new C6722a(CameraParam.TYPE_SYSTEM_CAMERA);
    }
}
