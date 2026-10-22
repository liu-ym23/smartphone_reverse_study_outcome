package o00;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521603a = 0;

    public a() {
    }

    static {
    }

    public static void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter("#1AFFFFFF", "color");
        if (r100 == null) goto L6;
        r100.setBackgroundColor(ColorProtector.parseColor("#1AFFFFFF"));
        return;
    }
}
