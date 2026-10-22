package et9;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.nova.R;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f473956a = 0;

    static {
    }

    public static void a(FlowSettingsScene r100, ItemGroup r101, final zs9.b r110) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "group");
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r102 = "";
        if (r110.f573496g != SettingsItemAction.TOGGLE) goto L22;
        final ItemTextToggle r103 = new ItemTextToggle(r101.getContext());
        r103.setTextFontWeight(500);
        r103.setBackgroundResource(R.drawable.larus_bg_item_selector);
        r101.addView(r103);
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        r105.width = -1;
        r105.height = -2;
        r103.setMinHeight(j19.c.c(56));
        String r106 = r110.f573492c;
        if (r106 != null) goto L7;
        r106 = "";
    L7:
        r103.setSubText(r106);
        String r107 = r110.f573491b;
        if (r107 == null) goto L10;
        r102 = r107;
    L10:
        r103.setText(r102);
        Integer r108 = r110.f573493d;
        if (r108 == null) goto L13;
        r103.setImageSrc(r108.intValue());
    L14:
        CustomSwitchCompat r109 = r103.getToggleView();
        Boolean r111 = r110.f573494e;
        if (r111 == null) goto L17;
        boolean r112 = r111.booleanValue();
    L18:
        r109.setChecked(r112);
        r103.getToggleView().setEnabled(r110.f573495f);
        if (r110.f573495f == false) goto L21;
        r103.getToggleView().setOnCheckedChangeListener(new a(r103, r110));
        return;
    L21:
        r103.getToggleView().f316954a = true;
        r103.setAlpha(0.3f);
        e1.d(r103, new b(r110));
        return;
    L17:
        r112 = false;
        goto L18
    L13:
        r103.S5(null);
        goto L14
    L22:
        ItemTextArrow r113 = new ItemTextArrow(r101.getContext());
        r113.setTextFontWeight(500);
        r113.setBackgroundResource(R.drawable.larus_bg_item_selector_middle);
        r101.addView(r113);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        r115.width = -1;
        r115.height = -2;
        r113.setMinHeight(j19.c.c(56));
        String r116 = r110.f573492c;
        if (r116 != null) goto L25;
        r116 = "";
    L25:
        r113.Z5(r116, null);
        Integer r117 = r110.f573493d;
        if (r117 == null) goto L28;
        r113.setImageSrc(r117.intValue());
    L29:
        String r118 = r110.f573491b;
        if (r118 == null) goto L32;
        r102 = r118;
    L32:
        r113.setText(r102);
        e1.d(r113, new c(r110));
        return;
    L28:
        r113.S5(null);
        goto L29
    }
}
