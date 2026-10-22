package ny7;

import android.text.Layout;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static final boolean a(UDButton r100) {
        if (r100.getVisibility() == 8) goto L16;
        Layout r101 = r100.getLayout();
        if (r101 == null) goto L13;
        int r102 = r101.getLineCount();
        if (r102 > 0) goto L10;
        return false;
    L10:
        if (r101.getEllipsisCount(r102 - 1) <= 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L16:
        return false;
    }
}
