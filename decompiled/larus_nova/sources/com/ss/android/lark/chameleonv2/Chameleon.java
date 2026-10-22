package com.ss.android.lark.chameleonv2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class Chameleon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Chameleon f411115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f411116b = null;

    public Chameleon() {
    }

    static {
        f411115a = new Chameleon();
        f411116b = LazyKt.lazy(Chameleon$chameleon$2.INSTANCE);
    }

    public static void c(Chameleon r100, ChameleonConfig r101) {
        r100.getClass();
        ((IChameleonApi) f411116b.getValue()).preloadWebview(r101, null);
    }

    public static Fragment a(Context r100, ChameleonConfig r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ((IChameleonApi) f411116b.getValue()).getChameleonFragment(r100, r101, r102);
    }

    public static void b(Context r100, ChameleonConfig r101, List r102) {
        ((IChameleonApi) f411116b.getValue()).open(r100, r101, r102);
    }
}
