package ga1;

import android.net.Uri;
import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public a() {
    }

    public final Parcelable a(ia1.b r310, boolean r311) {
        ja1.a r100 = r310.f488846d;
        if (r100 != null) goto L5;
        r100 = new ja1.a(r310.f488844b, r310.f488843a, r310.f488845c);
    L5:
        String r101 = r310.f488843a;
        if (r101 != null) goto L8;
        r101 = (String) r100.a("url", "");
    L8:
        String r210 = r101;
        String r110 = (String) r100.a(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, "");
        String r211 = (String) r100.a("inject_json_url", "");
        String r111 = (String) r100.a(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR, "");
        boolean r102 = false;
        int r212 = ((Number) r100.a("request_code", 0)).intValue();
        String r103 = (String) r100.a("enter_from", "");
        String r104 = (String) r100.a("is_out_url", "");
        String r213 = (String) r100.a("is_out_scene", "");
        int r214 = ((Number) r100.a(AppConstants.BUNDLE_WEB_VIEW_BACKGROUND_COLOR, -1)).intValue();
        String r215 = (String) r100.a("web_bg_color", "");
        String r105 = (String) r100.a(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_COLOR, "");
        int r106 = ((Number) r100.a(AppConstants.BUNDLE_PULL_DOWN_HEIGHT, 0)).intValue();
        boolean r112 = ((Boolean) r100.a("is_fullScreen", Boolean.FALSE)).booleanValue();
        String r216 = (String) r100.a("title", "");
        if (((Number) r100.a(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_NOT_SHOW, 0)).intValue() != 1) goto L11;
        boolean r113 = true;
    L13:
        if (((Number) r100.a("hide_loading", 1)).intValue() != 1) goto L15;
        boolean r217 = true;
    L17:
        if (((Number) r100.a(AppConstants.BUNDLE_SHOW_CLOSE, 0)).intValue() != 1) goto L19;
        boolean r114 = true;
    L21:
        if (((Number) r100.a(AppConstants.BUNDLE_HIDE_POSTER, 0)).intValue() != 1) goto L23;
        boolean r115 = true;
    L25:
        if (((Number) r100.a("hide_status_bar", 0)).intValue() != 1) goto L27;
        boolean r107 = true;
    L29:
        if (((Number) r100.a("hide_nav_bar", 0)).intValue() != 1) goto L31;
        boolean r116 = true;
    L33:
        if (((Number) r100.a(AppConstants.BUNDLE_ENABLE_SHARE, 0)).intValue() != 1) goto L35;
        boolean r117 = true;
    L37:
        if (((Number) r100.a(AppConstants.BUNDLE_SHOW_BACK, 0)).intValue() != 1) goto L39;
        boolean r118 = true;
    L41:
        if (((Number) r100.a(AppConstants.TRANS_STATUS_BAR, 0)).intValue() != 1) goto L43;
        boolean r218 = true;
    L45:
        if (((Number) r100.a(AppConstants.BUNDLE_PULL_DOWN_CLOSE, 0)).intValue() != 1) goto L47;
        boolean r108 = true;
    L49:
        if (((Number) r100.a("forbid_right_back", 0)).intValue() != 1) goto L51;
        boolean r109 = true;
    L52:
        boolean r312 = r116;
        if (((Number) r100.a(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, 0)).intValue() != 1) goto L55;
        boolean r119 = true;
    L56:
        Uri r120 = r310.f488844b;
        if (r120 == null) goto L60;
        String r121 = r120.toString();
        if (r121 == null) goto L60;
    L62:
        if (Intrinsics.areEqual("is_from_out_scene", r104) == false) goto L64;
    L65:
        r102 = true;
    L66:
        boolean r122 = r107;
        boolean r123 = r108;
        boolean r124 = r113;
        boolean r125 = r115;
        boolean r126 = r118;
        boolean r127 = r109;
        boolean r128 = r218;
        return new BaseHybridParamVo(r122, r123, r106, r124, r105, r125, r114, r126, r117, r127, r312, r112, r128, r110, r111, Boolean.valueOf(r102), r213, r216, r214, r215, r217, r212, r119, r211, r210, r121, 483342, 0);
    L64:
        if (Intrinsics.areEqual(MemorySourceLinkType.DEEPLINK, r103) == false) goto L66;
    L60:
        r121 = "";
        goto L62
    L55:
        r119 = false;
        goto L56
    L51:
        r109 = false;
        goto L52
    L47:
        r108 = false;
        goto L49
    L43:
        r218 = false;
        goto L45
    L39:
        r118 = false;
        goto L41
    L35:
        r117 = false;
        goto L37
    L31:
        r116 = false;
        goto L33
    L27:
        r107 = false;
        goto L29
    L23:
        r115 = false;
        goto L25
    L19:
        r114 = false;
        goto L21
    L15:
        r217 = false;
        goto L17
    L11:
        r113 = false;
        goto L13
    }
}
