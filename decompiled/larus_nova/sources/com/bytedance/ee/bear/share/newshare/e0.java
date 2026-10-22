package com.bytedance.ee.bear.share.newshare;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f237211a;

    public void a(View r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
    }

    public abstract View b(ViewGroup r100);

    public d0 c() {
        return null;
    }

    public boolean d(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return false;
    }

    public e0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f237211a = r100;
    }
}
