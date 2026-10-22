package th;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.plugin.d;
import com.bytedance.android.ec.sdk.plugin.e;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final Resources f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pluginResources");
        return e(r100, true).getResources();
    }

    public static final int a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$color");
        return ContextCompat.getColor(e(r100, true), r101);
    }

    public static final Drawable b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$drawable");
        return ContextCompat.getDrawable(e(r100, true), r101);
    }

    public static final Context e(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$pluginContext");
        if (e.a() == false) goto L18;
        if (r101 == false) goto L14;
        boolean r102 = ECServiceManager.f42805a;
        Intrinsics.checkNotNullParameter(af.a.class, "clazz");
        Object r103 = ECServiceManager.f42806b.get(af.a.class);
        if ((r103 instanceof Object) == true) goto L8;
        r103 = null;
    L8:
        af.a r104 = (af.a) r103;
        if (r104 != null) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return r100;
    L11:
        r105 = r104.a(r100);
    L14:
        if ((r100 instanceof d) == false) goto L17;
        return r100;
    L17:
        return new d(r100);
    L18:
        return r100;
    }

    public static final String g(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$string");
        if (r101 != 0) goto L6;
        return "";
    L6:
        return e(r100, true).getString(r101);
    }

    public static final String h(Context r100, int r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$string");
        Intrinsics.checkNotNullParameter(r102, "formatArgs");
        return e(r100, true).getString(r101, Arrays.copyOf(r102, r102.length));
    }

    public static final View c(Context r100, int r101, ViewGroup r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$inflate");
        Context r104 = e(r100, true);
        return LayoutInflater.from(r104).inflate(r101, r102, r103);
    L5:
        e = move-exception;
        throw new Exception("Django ==> shopping plugin inflate fail: " + r104 + "， " + e, e);
    }

    public static /* synthetic */ View d(Context r100, int r101, ViewGroup r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return c(r100, r101, r102, false);
    }
}
