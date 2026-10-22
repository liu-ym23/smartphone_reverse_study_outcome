package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActionBarPolicy {
    private Context mContext;

    public boolean showsOverflowMenuButton() {
        return true;
    }

    public boolean enableHomeButtonByDefault() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) goto L5;
        return true;
    L5:
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return INVOKEVIRTUAL_androidx_appcompat_view_ActionBarPolicy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration r0 = this.mContext.getResources().getConfiguration();
        int r1 = r0.screenWidthDp;
        int r2 = r0.screenHeightDp;
        if (r0.smallestScreenWidthDp > 600) goto L27;
        if (r1 <= 600) goto L6;
        return 5;
    L6:
        if (r1 <= 960) goto L8;
        if (r2 <= 720) goto L8;
        return 5;
    L8:
        if (r1 <= 720) goto L12;
        if (r2 <= 960) goto L12;
        return 5;
    L12:
        if (r1 < 500) goto L14;
        return 4;
    L14:
        if (r1 <= 640) goto L16;
        if (r2 <= 480) goto L16;
        return 4;
    L16:
        if (r1 <= 480) goto L20;
        if (r2 <= 640) goto L20;
        return 4;
    L20:
        if (r1 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(2131165198);
    }

    public int getTabContainerHeight() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(null, new int[]{2130968899, 2130968904, 2130968905, 2130969620, 2130969621, 2130969622, 2130969623, 2130969624, 2130969625, 2130969710, 2130969757, 2130969758, 2130969940, 2130970198, 2130970208, 2130970261, 2130970262, 2130970280, 2130970332, 2130970410, 2130972601, 2130972815, 2130973585, 2130973620, 2130973621, 2130974326, 2130974330, 2130974574, 2130974592}, 2130968715, 0);
        int r1 = r0.getLayoutDimension(13, 0);
        Resources r2 = this.mContext.getResources();
        if (hasEmbeddedTabs() == true) goto L5;
        r1 = Math.min(r1, r2.getDimensionPixelSize(2131165197));
    L5:
        r0.recycle();
        return r1;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(2131034112);
    }

    private ActionBarPolicy(Context r1) {
        this.mContext = r1;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_ActionBarPolicy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static ActionBarPolicy get(Context r1) {
        return new ActionBarPolicy(r1);
    }
}
