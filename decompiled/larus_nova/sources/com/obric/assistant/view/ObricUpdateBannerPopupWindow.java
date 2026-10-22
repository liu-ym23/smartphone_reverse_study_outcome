package com.obric.assistant.view;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;
import com.obric.assistant.impl.databinding.ObricUpdateBannerBinding;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricUpdateBannerPopupWindow {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f393995m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PopupWindow f393997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f393998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f393999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f394000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f394001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObricUpdateBannerBinding f394002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f394003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h0 f394004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ObricUpdateBannerPopupWindow$obricUpdateListener$1 f394005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f394006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f394007l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394008a = null;

        static {
            int[] r100 = new int[ObricBannerType.values().length];
            r100[ObricBannerType.AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ObricBannerType.DOWNLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ObricBannerType.WIFI_DOWNLOADING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ObricBannerType.STATE_DOWNLOADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f394008a = r100;
        }
    }

    static {
    }

    public ObricUpdateBannerPopupWindow() {
        this("default");
    }

    public static ObricBannerType e() {
        IObricUpdateService r100 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r100 == null) goto L7;
        ObricBannerType r101 = r100.getBannerType();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return ObricBannerType.UNKNOWN;
    }

    public final void c() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("dismissBanner, hostId=");
        r101.append(this.f393996a);
        r101.append(", isShowing=");
        PopupWindow r102 = this.f393997b;
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.isShowing());
    L6:
        r101.append(r103);
        r100.i("ObricUpdateBannerPopupWindow", r101.toString());
        IObricUpdateService r104 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r104 == null) goto L9;
        r104.i(this.f394005j);
    L9:
        h0 r105 = this.f394004i;
        if (r105 == null) goto L16;
        View r106 = this.f394003h;
        if (r106 == null) goto L15;
        r106.removeOnAttachStateChangeListener(r105);
    L15:
        this.f394004i = null;
        this.f394003h = null;
    L16:
        PopupWindow r107 = this.f393997b;
        if (r107 != null) goto L19;
    L21:
        this.f393997b = null;
        this.f394002g = null;
        this.f394007l = null;
        this.f394006k = -1;
        return;
    L19:
        if (r107.isShowing() == false) goto L21;
        PopupWindowLancet.handleDismissBeforeOrigin(r107);
        r107.dismiss();
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    public final boolean f() {
        PopupWindow r100 = this.f393997b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void h() {
        ObricBannerType r100 = e();
        IObricUpdateService r101 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r101 == null) goto L5;
        int r102 = r101.l();
    L6:
        String r103 = this.f394007l;
        if (r103 != null) goto L57;
        IObricUpdateService r104 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r104 == null) goto L55;
        String r105 = r104.versionName();
        String r106 = AppHost.f326268a.getApplication().getString(R.string.obric_update_banner_sub_title_prefix);
        Long r107 = Long.valueOf(r104.o());
        if (r107.longValue() <= 0) goto L14;
        boolean r110 = true;
    L15:
        if (r110 == true) goto L18;
        r107 = null;
    L18:
        if (r107 == null) goto L20;
        String r108 = ((int) ((r107.longValue() / 1024.0d) / 1024.0d)) + "MB";
    L21:
        StringBuilder r111 = new StringBuilder();
        if (r105 != null) goto L24;
    L27:
        boolean r112 = true;
    L28:
        if (r112 == true) goto L30;
        r111.append(r106);
        r111.append(r105);
    L30:
        if (r108 != null) goto L32;
    L35:
        boolean r109 = true;
    L36:
        if (r109 == true) goto L54;
        if (r105 != null) goto L39;
    L42:
        boolean r113 = true;
    L43:
        if (r113 == true) goto L45;
        r111.append("（");
    L45:
        r111.append(r108);
        if (r105 != null) goto L48;
    L51:
        boolean r114 = true;
    L52:
        if (r114 == true) goto L54;
        r111.append("）");
        goto L54
    L48:
        if (r105.length() == 0) goto L51;
        r114 = false;
        goto L52
    L39:
        if (r105.length() == 0) goto L42;
        r113 = false;
    L54:
        this.f394007l = r111.toString();
        goto L55
    L32:
        if (r108.length() == 0) goto L35;
        r109 = false;
        goto L36
    L24:
        if (r105.length() == 0) goto L27;
        r112 = false;
        goto L28
    L20:
        r108 = null;
        goto L21
    L14:
        r110 = false;
    L55:
        r103 = this.f394007l;
    L57:
        if (r102 != this.f394006k) goto L60;
        FLogger.f375446a.i("ObricUpdateBannerPopupWindow", "setupButton skipped, hostId=" + this.f393996a + ", currentState=" + r102 + ", bannerShowType=" + r100);
        return;
    L60:
        this.f394006k = r102;
        FLogger r115 = FLogger.f375446a;
        r115.i("ObricUpdateBannerPopupWindow", "setupButton, hostId=" + this.f393996a + ", currentState=" + r102 + ", bannerShowType=" + r100 + ", packageSize=" + r103);
        if (r102 == 1) goto L107;
        int r116 = R.string.obric_update_banner_title_downloading;
        int r117 = R.string.obric_update_banner_title_wifi_downloading;
        if (r102 == 2) goto L95;
        if (r102 == 3) goto L82;
        if (r102 != 4) goto L67;
        b(R.string.obric_update_banner_title_downloaded, r103);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r118 = this.f394002g;
        if (r118 == null) goto L112;
        TextView r119 = r118.f389611c;
        if (r119 == null) goto L112;
        r119.setText(AppHost.f326268a.getApplication().getString(R.string.obric_update_banner_button_install_hint));
    L112:
        if (r102 == (-1)) goto L131;
        r115.i("ObricUpdateBannerPopupWindow", "reportObricUpgradeBannerShow, hostId=" + this.f393996a + ", bannerType=" + r100 + ", window=" + this);
        IObricUpdateService r120 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r120 == null) goto L116;
        String r121 = r120.m();
    L117:
        int r122 = b.f394008a[r100.ordinal()];
        if (r122 == 1) goto L126;
        if (r122 == 2) goto L125;
        if (r122 == 3) goto L124;
        if (r122 == 4) goto L123;
        String r123 = "unknown";
    L127:
        IObricUpdateService r124 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r124 == null) goto L132;
        JSONObject r125 = new JSONObject();
        r125.put("source", r121);
        r125.put("banner_type", r123);
        Unit r126 = Unit.INSTANCE;
        r124.h("obric_upgrade_banner_show", r125);
        return;
    L132:
        return;
    L123:
        r123 = "obric_upgrade_ready_to_install_banner";
        goto L127
    L124:
        r123 = "obric_upgrade_auto_downloading_banner";
        goto L127
    L125:
        r123 = "obric_upgrade_downloading_banner";
        goto L127
    L126:
        r123 = "obric_upgrade_new_version_banner";
        goto L127
    L116:
        r121 = null;
        goto L117
    L131:
        return;
    L67:
        if (r102 == 6) goto L71;
        ObricUpdateBannerBinding r127 = this.f394002g;
        if (r127 == null) goto L112;
        r127.f389618j.setVisibility(8);
        r127.f389617i.setVisibility(8);
        r127.f389610b.setVisibility(8);
        r127.f389614f.setVisibility(8);
        r127.f389613e.setVisibility(8);
        r127.f389615g.setVisibility(8);
        goto L112
    L71:
        b(R.string.obric_update_banner_title_fail, null);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r128 = this.f394002g;
        if (r128 == null) goto L112;
        TextView r129 = r128.f389611c;
        if (r129 == null) goto L112;
        r129.setText(AppHost.f326268a.getApplication().getString(R.string.obric_update_banner_title_retry_hint));
        goto L112
    L82:
        if (r100 != ObricBannerType.WIFI_DOWNLOADING) goto L93;
        IObricUpdateService r130 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r130 != null) goto L86;
    L88:
        boolean r131 = false;
    L89:
        if (r131 == true) goto L92;
        r117 = R.string.obric_update_banner_title_wifi_pause;
    L92:
        b(r117, r103);
        a(this, false, false, true, 11);
        goto L112
    L86:
        if (r130.j() != true) goto L88;
        r131 = true;
        goto L89
    L93:
        b(R.string.obric_update_banner_title_downloading, r103);
        a(this, false, false, true, 11);
        goto L112
    L95:
        if (r100 == ObricBannerType.DOWNLOADING) goto L106;
        IObricUpdateService r132 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r132 != null) goto L100;
    L102:
        boolean r133 = false;
    L103:
        if (r133 == true) goto L106;
        r116 = R.string.obric_update_banner_title_wifi_downloading;
        goto L106
    L100:
        if (r132.j() != true) goto L102;
        r133 = true;
    L106:
        b(r116, r103);
        a(this, false, true, false, 13);
        goto L112
    L107:
        b(R.string.obric_update_banner_title_available, r103);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r134 = this.f394002g;
        if (r134 == null) goto L112;
        TextView r135 = r134.f389611c;
        if (r135 == null) goto L112;
        r135.setText(AppHost.f326268a.getApplication().getString(R.string.obric_update_banner_button_update));
        goto L112
    L5:
        r102 = -1;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.view.ObricUpdateBannerPopupWindow$obricUpdateListener$1] */
    public ObricUpdateBannerPopupWindow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostId");
        this.f393996a = r100;
        this.f394005j = new ObricUpdateBannerPopupWindow$obricUpdateListener$1(this);
        this.f394006k = -1;
    }

    public static void d(Function0 r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        if (NetworkUtils.isNetworkAvailable(r101.getApplication()) == true) goto L7;
        i(R.string.obric_update_network_unavailable_toast);
        return;
    L7:
        if (NetworkUtils.isWifi(r101.getApplication()) == false) goto L9;
        i(R.string.obric_update_using_wifi_toast);
    L10:
        r100.invoke();
        return;
    L9:
        i(R.string.obric_update_using_mobile_toast);
        goto L10
    }

    public static void g(String r100) {
        IObricUpdateService r101 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        ObricBannerType r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.m();
    L6:
        IObricUpdateService r104 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r104 == null) goto L9;
        r102 = r104.getBannerType();
    L9:
        if (r102 != null) goto L11;
        int r105 = -1;
    L13:
        if (r105 != 1) goto L15;
        String r106 = "obric_upgrade_new_version_banner";
    L25:
        IObricUpdateService r107 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r107 == null) goto L29;
        JSONObject r108 = new JSONObject();
        r108.put("source", r103);
        r108.put("banner_type", r106);
        r108.put("action_type", r100);
        Unit r109 = Unit.INSTANCE;
        r107.h("obric_upgrade_banner_click", r108);
        return;
    L29:
        return;
    L15:
        if (r105 != 2) goto L17;
        r106 = "obric_upgrade_downloading_banner";
        goto L25
    L17:
        if (r105 != 3) goto L19;
        r106 = "obric_upgrade_auto_downloading_banner";
        goto L25
    L19:
        if (r105 == 4) goto L21;
        r106 = "unknown";
        goto L25
    L21:
        r106 = "obric_upgrade_ready_to_install_banner";
        goto L25
    L11:
        r105 = b.f394008a[r102.ordinal()];
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public static void i(int r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        Toast.makeText(r101.getApplication(), r101.getApplication().getString(r100), 0).show();
    }

    public static String j(View r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getClass().getSimpleName());
        r101.append('@');
        r101.append(Integer.toHexString(System.identityHashCode(r100)));
        r101.append("[shown=");
        r101.append(r100.isShown());
        r101.append(",attached=");
        r101.append(r100.isAttachedToWindow());
        r101.append(",bounds=");
        r101.append(r100.getLeft());
        r101.append(',');
        r101.append(r100.getTop());
        r101.append('-');
        r101.append(r100.getRight());
        r101.append(',');
        r101.append(r100.getBottom());
        r101.append(",root=");
        View r102 = r100.getRootView();
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.getWidth());
    L6:
        r101.append(r104);
        r101.append(Permission.EXECUTE);
        View r105 = r100.getRootView();
        if (r105 == null) goto L9;
        r103 = Integer.valueOf(r105.getHeight());
    L9:
        r101.append(r103);
        r101.append(']');
        return r101.toString();
    L5:
        r104 = null;
        goto L6
    }

    public final void b(int r100, String r101) {
        ObricUpdateBannerBinding r102 = this.f394002g;
        if (r102 == null) goto L15;
        r102.f389618j.setVisibility(0);
        r102.f389616h.setText(AppHost.f326268a.getApplication().getString(r100));
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r102.f389617i.setVisibility(8);
        return;
    L13:
        r102.f389617i.setText(r101);
        r102.f389617i.setVisibility(0);
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
        goto L11
    }

    public static void a(ObricUpdateBannerPopupWindow r100, boolean r101, boolean r102, boolean r103, int r104) {
        int r105 = 0;
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = false;
    L11:
        ObricUpdateBannerBinding r106 = r100.f394002g;
        if (r106 == null) goto L31;
        ConstraintLayout r107 = r106.f389610b;
        if (r101 == false) goto L16;
        int r108 = 0;
    L17:
        r107.setVisibility(r108);
        TextView r109 = r106.f389611c;
        if (r101 == false) goto L20;
        int r110 = 0;
    L21:
        r109.setVisibility(r110);
        CustomUpdateCircleProgressBar r111 = r106.f389614f;
        if (r102 == false) goto L24;
        int r112 = 0;
    L25:
        r111.setVisibility(r112);
        ConstraintLayout r113 = r106.f389613e;
        if (r103 == true) goto L29;
        r105 = 8;
    L29:
        r113.setVisibility(r105);
        r106.f389615g.setVisibility(8);
        return;
    L24:
        r112 = 8;
        goto L25
    L20:
        r110 = 8;
        goto L21
    L16:
        r108 = 8;
        goto L17
    }
}
