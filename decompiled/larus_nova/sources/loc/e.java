package loc;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static joc.c f510168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static joc.b f510169b;

    static {
    }

    @JvmStatic
    public static final void a(ImageView r100, Context r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "url");
        ImageLoader.with(r101).load(r102).placeholder(R.drawable.ud_icon_loading_outlined).error(R.drawable.ud_icon_yes_outlined).into(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        r100.setColorFilter(UDColorUtils.getColor(r101, r103.intValue()), PorterDuff.Mode.SRC_IN);
    }
}
