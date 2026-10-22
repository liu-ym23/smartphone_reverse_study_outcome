package d80;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LocalComponentXLoadConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f467383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f467384b;

    static {
        f467383a = "";
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (v.a() == true) goto L5;
        return;
    L5:
        f467384b++;
        f467383a += "_&_" + r100;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupKey");
        if (v.a() == true) goto L5;
        return;
    L5:
        e<ArrayList<LocalComponentXLoadConfig>> r101 = com.bytedance.android.livesdk.sharedpref.b.Q3;
        if (r101.getValue() != null) goto L8;
        f.d(r101, new ArrayList());
    L8:
        ArrayList<LocalComponentXLoadConfig> r102 = r101.getValue();
        LocalComponentXLoadConfig r103 = new LocalComponentXLoadConfig(null, null, 0, 7, null);
        r103.setBatch(r100);
        r103.setComponentListStr(f467383a);
        r103.setComponentCount(f467384b);
        Unit r104 = Unit.INSTANCE;
        r102.add(r103);
        ALogger.i("ComponentX_ComponentList", "当前加载的批次是 " + r100 + "  个数为: " + f467384b + " 个");
        ALogger.i("ComponentX_ComponentList", f467383a);
        f467383a = "";
        f467384b = 0;
    }
}
