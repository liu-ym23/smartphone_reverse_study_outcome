package s0b;

import android.content.Context;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f540055a = 0;

    static {
    }

    public static VFSFile b() {
        VFSFile r100 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.k().subPath("gecko").toFile();
        if (r100.exists() == false) goto L5;
    L7:
        j.a("CML_TAG_ChameleonGeckoConfig", "getGeckoRootPath: " + r100.getAbsolutePath());
        return r100;
    L5:
        if (r100.mkdirs() == true) goto L7;
        j.f("CML_TAG_ChameleonGeckoConfig", "mkdir gecko Dir failed");
        goto L7
    }

    public static String a(Context r100, ResGeckoConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "resGeckoConfig");
        HashMap<String, String> r102 = r101.getAccessKey();
        int r103 = m.f437228a;
        if (m.a.a().isBoe() == false) goto L19;
        if (r102 != null) goto L6;
        return null;
    L6:
        return r102.get("boe");
    L19:
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        if (r102 != null) goto L23;
        return null;
    L23:
        return r102.get("debug");
    L15:
        if (r102 != null) goto L17;
        return null;
    L17:
        return r102.get("release");
    L11:
        r104 = false;
        goto L12
    }

    public static Map c(Context r100, ChameleonConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
        HashMap r102 = new HashMap();
        ResConfig r103 = r101.getResConfig();
        if (r103 == null) goto L5;
        ResGeckoConfig r104 = r103.getGeckoConfig();
    L6:
        if (r104 != null) goto L8;
    L20:
        return r102;
    L8:
        if (r104.getEnable() == true) goto L10;
        j.f("CML_TAG_ChameleonGeckoConfig", "!geckoConfig.enable");
    L10:
        String r105 = a(r100, r104);
        ArrayList r106 = new ArrayList();
        HashMap<String, String> r107 = r104.getChannels();
        if (r107 == null) goto L18;
        Collection<String> r108 = r107.values();
        if (r108 == null) goto L18;
        Iterator<T> r109 = r108.iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        r106.add(new CheckRequestBodyModel.TargetChannel((String) r109.next()));
    L18:
        if (r105 == null) goto L20;
        r102.put(r105, r106);
        goto L20
    L5:
        r104 = null;
        goto L6
    }
}
