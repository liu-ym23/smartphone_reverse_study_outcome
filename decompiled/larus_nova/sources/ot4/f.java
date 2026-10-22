package ot4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.TitleMenuItem;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {
    public static final e a(Context r100, MenuItem r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ViewGroup.LayoutParams r102 = null;
        TitleMenuItem r103 = new TitleMenuItem(r100, null, 6, 0);
        r103.setId(r101.getId());
        boolean r104 = TextUtils.equals(r101.getId(), "base_drawer");
        if (r104 == false) goto L5;
        LayoutInflater.from(r103.getContext()).inflate(R.layout.title_menu_item_with_text, r103, true);     // Catch: Exception -> L7
        r103.f213698e = (TextView) r103.findViewById(R.id.widgetTitleMenuText);     // Catch: Exception -> L7
        r103.f213699f = (ImageView) r103.findViewById(R.id.widgetTitleMenuImg);     // Catch: Exception -> L7
        r103.f213700g = r103.findViewById(R.id.menu_item_container);     // Catch: Exception -> L7
    L6:
        r104 = true;
    L9:
        if (r104 == true) goto L11;
        return null;
    L11:
        if (r110 == false) goto L27;
        View r105 = r103.f213701h;
        if (r105 == null) goto L15;
        r105.setVisibility(8);
    L15:
        View r106 = r103.f213700g;
        if (r106 == null) goto L18;
        r106.setBackground(null);
    L18:
        int r107 = r103.getResources().getDimensionPixelSize(R.dimen.bitable_title_menu_without_background_icon_size);
        ImageView r111 = r103.f213699f;
        if (r111 == null) goto L24;
        ViewGroup.LayoutParams r108 = r111.getLayoutParams();
        if (r108 == null) goto L23;
        r108.width = r107;
        r108.height = r107;
        r102 = r108;
    L23:
        r111.setLayoutParams(r102);
    L24:
        TextView r109 = r103.f213698e;
        if (r109 == null) goto L27;
        r109.setTextSize(0, r109.getResources().getDimension(R.dimen.bitable_title_menu_without_background_text_size));
        r109.setTypeface(r109.getTypeface(), 1);
    L27:
        Drawable r112 = r101.getIcon();
        if (r112 == null) goto L30;
        r103.setIcon(r112);
    L30:
        r103.setBadgeStyle(r101.getBadgeStyle());
        r103.setBadge(Integer.valueOf(r101.getBadgeNum()));
        return new e(r103, r101);
    L5:
        LayoutInflater.from(r103.getContext()).inflate(R.layout.title_menu_item, r103, true);     // Catch: Exception -> L7
        r103.f213699f = (ImageView) r103.findViewById(R.id.widgetTitleMenuImg);     // Catch: Exception -> L7
        r103.f213701h = r103.findViewById(R.id.widgetTitleMenuImgBg);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e("TitleMenuItem", "Failed to inflate TitleMenuItem layout. enableTextMode=" + r104, e);
        r103.setVisibility(8);
        r104 = false;
        goto L9
    }
}
