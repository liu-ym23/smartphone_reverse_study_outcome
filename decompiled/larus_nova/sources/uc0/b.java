package uc0;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;

/* JADX INFO: loaded from: classes46.dex */
public class b extends ns0.b {
    public b() {
    }

    @Override // ns0.b
    public void modifyLayoutParamsIfIMButton(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r100 = null;
    L5:
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100;
        if (r101 == null) goto L9;
        r101.weight = LiveConfigSettingKeys.SETTINGS_IM_WIDTH_WEIGHT.getValue().floatValue();
        return;
    }
}
