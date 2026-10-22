package xn0;

import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564607a = 0;

    static {
    }

    public static void a(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "kv");
        Iterator r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L21;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        String r104 = (String) r102.getValue();
        int r105 = r103.hashCode();
        if (r105 != (-1877291291)) goto L8;
        if (r103.equals("enable_push_so") == false) goto L4;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r106 = ILiveWrappedEffectSDKService.a.a();
        if (r106 == null) goto L4;
        r106.multiMediaEnv_diagnosis_setEnableLoadLibrariesFromDisk(Boolean.parseBoolean(r104));
        goto L4
    L8:
        if (r105 != 1343046286) goto L4;
        if (r103.equals("enable_vehook") == false) goto L4;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r107 = ILiveWrappedEffectSDKService.a.a();
        if (r107 == null) goto L4;
        r107.multiMediaEnv_diagnosis_setEnableVEHook(Boolean.parseBoolean(r104));
        goto L4
    }
}
