package vc0;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f554079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f554080b;

    public a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.f554080b = r100;
        if ((r100 instanceof xh6.c) == false) goto L5;
        r100 = ((xh6.c) r100).getReal();
    L5:
        this.f554079a = r100;
    }
}
