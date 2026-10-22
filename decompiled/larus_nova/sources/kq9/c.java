package kq9;

import com.baidu.platform.comapi.map.MapController;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Function2<d, Boolean, Unit>> f505615a = null;

    static {
        f505615a = new ConcurrentHashMap();
    }

    public static void a(String r100, d r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if ((!StringsKt.isBlank(r100)) == false) goto L8;
        Function2<d, Boolean, Unit> r103 = f505615a.get(r100);
        if (r103 == null) goto L9;
        r103.invoke(r101, Boolean.valueOf(r102));
        return;
    L9:
        return;
    }
}
