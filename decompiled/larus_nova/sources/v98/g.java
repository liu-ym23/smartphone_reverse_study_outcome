package v98;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.gallery.view.y0;
import com.larus.avlink.gallery.view.z0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    public static final PopupWindow a(FragmentActivity r100, View r110, View r111, final y0 r112, final z0 r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "anchorView");
        Intrinsics.checkNotNullParameter(r111, "sharePanelView");
        Intrinsics.checkNotNullParameter(r112, "onClose");
        Intrinsics.checkNotNullParameter(r113, "onSelectAllClicked");
        View r101 = LayoutInflater.from(r100).inflate(R.layout.larus_page_album_share_panel, null);
        final PopupWindow r102 = new PopupWindow(r101, -1, -2, false);
        r102.setBackgroundDrawable(ContextCompat.getDrawable(r100, android.R.color.transparent));
        r102.setOutsideTouchable(false);
        r102.setAnimationStyle(R.style.larus_shadow_popup_window_slide);
        r101.findViewById(R.id.album_share_close).setOnClickListener(new e(r102, r112));
        r101.findViewById(R.id.album_select_title).setOnClickListener(new f(r113));
        FrameLayout r103 = (FrameLayout) r101.findViewById(R.id.album_share_container);
        if (r103 == null) goto L6;
        r111.setVisibility(0);
        r103.addView(r111, -1, -2);
    L6:
        if (PopupWindowLancet.hasSubWindowToken(r110) == false) goto L9;
    L15:
        return r102;
    L9:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r102) == false) goto L11;
        r102.showAtLocation(r110, 80, 0, 0);
        goto L15
    L11:
        OverlaySource r104 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r102, r110, r104, 80, 0, 0) == true) goto L15;
        r102.showAtLocation(r110, 80, 0, 0);
        PopupWindowLancet.trackAfterShow(r102, r104, r110);
        goto L15
    }
}
