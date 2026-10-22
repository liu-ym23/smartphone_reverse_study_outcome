package ve8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554419a = 0;

    static {
    }

    public static String a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }
}
