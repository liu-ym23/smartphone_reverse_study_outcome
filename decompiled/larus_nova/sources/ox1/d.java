package ox1;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final InnerContextEntity a(Activity r100, InnerContextEntity.InnerFloatExtra r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        InnerContextEntity r102 = new InnerContextEntity(r100);
        r102.setDataSource(c.a(r101));
        if (r101 == null) goto L5;
        HashMap<String, String> r103 = r101.getMobParams();
    L6:
        r102.setMobParams(r103);
        r102.setEnterExtra(r101);
        return r102;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final InnerContextEntity b(DialogFragment r100, FrameLayout r101, InnerContextEntity.InnerFloatExtra r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        InnerContextEntity r103 = new InnerContextEntity(r100, r101, r102);
        r103.setDataSource(c.a(r102));
        if (r102 == null) goto L5;
        HashMap<String, String> r104 = r102.getMobParams();
    L6:
        r103.setMobParams(r104);
        r103.setEnterExtra(r102);
        return r103;
    L5:
        r104 = null;
        goto L6
    }
}
