package s32;

import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ImageRecognitionBusiness> f540446a = null;

    static {
        f540446a = new HashMap();
    }

    public static void a(int r100, ImageRecognitionBusiness r101) {
        Intrinsics.checkNotNullParameter(r101, "business");
        int r102 = b.f540445a;
        y00 r103 = y00.f121644a;
        if (r103.getValue().a() == false) goto L9;
        List<Integer> r104 = r103.getValue().f();
        boolean r105 = true;
        if (r104 != null) goto L7;
    L10:
        if (r105 == false) goto L12;
        ((HashMap) f540446a).put(Integer.valueOf(r100), new d(r101));
        int r106 = f.f540454a;
        f.b("register business for scene " + r100);
        return;
    L12:
        int r107 = f.f540454a;
        f.a("scene " + r100 + " is disabled");
        return;
    L7:
        if (r104.contains(Integer.valueOf(r100)) != true) goto L10;
    L9:
        r105 = false;
        goto L10
    }
}
