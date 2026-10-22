package rt4;

import android.widget.TextView;
import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static /* synthetic */ void b(TextView r100, IRenderFontStyle r101) {
        a(r100, r101, Boolean.TRUE);
    }

    public static final void a(TextView r100, IRenderFontStyle r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L13;
        Integer r103 = r101.getFontSize();
        if (r103 == null) goto L7;
        r100.setTextSize(r103.intValue());
    L7:
        String r104 = r101.getColor();
        if (r104 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L15;
        r100.setTextColor(ColorUtils.h(r104));
        return;
    L15:
        return;
    }
}
