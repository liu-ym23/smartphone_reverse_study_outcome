package k82;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface d {

    public static final class a {
        public static void a(VSInputSectionType r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "sectionType");
            Intrinsics.checkNotNullParameter(r101, "view");
        }
    }

    void a();

    VSInputSectionType b();

    c c();

    void d();

    void e();

    View g(h82.b r100);

    void h(VSInputSectionType r100, View r101);
}
