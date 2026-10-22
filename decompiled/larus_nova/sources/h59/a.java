package h59;

import android.content.Context;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.impl.dynamic.a2;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.util.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a2> f483887a;

    /* JADX INFO: renamed from: h59.a$a, reason: collision with other inner class name */
    public static final class C6103a {
    }

    static {
    }

    public a() {
        this.f483887a = new LinkedHashMap();
    }

    public static String a(Context r100, String r101) {
        if (StringsKt.startsWith$default(r101, "PageData/DoraG/", false, 2, null) == false) goto L6;
        u.f338158a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "assetPath");
        return u.e(r100, DoraResourceDeviceType.G_SERIES, "assets/" + r101);
    L6:
        Reader r102 = new InputStreamReader(r100.getAssets().open(r101), Charsets.UTF_8);
        if ((r102 instanceof BufferedReader) == false) goto L9;
        BufferedReader r103 = (BufferedReader) r102;
    L18:
        String r104 = TextStreamsKt.readText(r103);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r103, null);
        return r104;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L9:
        r103 = new BufferedReader(r102, 8192);
        goto L18
    }

    public static String b(int r100, String r101) {
        if (r100 != ProductNameType.DORA_LITE.f204375id) goto L6;
        String r102 = "PageData/DoraLite/";
    L13:
        return r102.concat(r101);
    L6:
        if (r100 != ProductNameType.DORA_E.f204375id) goto L9;
        r102 = "PageData/DoraE/";
        goto L13
    L9:
        if (o59.a.o(Integer.valueOf(r100)) == false) goto L11;
        r102 = "PageData/DoraG/";
        goto L13
    L11:
        r102 = "PageData/";
        goto L13
    }
}
