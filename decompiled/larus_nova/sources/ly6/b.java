package ly6;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final void a(BulletContainerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        zt6.a r101 = HostServiceUtilsKt.c0();
        if (r101 == null) goto L5;
        r101.c();
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return;
    L8:
        String r103 = HostServiceUtilsKt.e().getBid();
        if ((true ^ StringsKt.isBlank(r103)) == false) goto L12;
        r100.d(r103);
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static final Drawable b(Function1<? super GradientDrawable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        GradientDrawable r101 = new GradientDrawable();
        r100.invoke(r101);
        return r101;
    }
}
