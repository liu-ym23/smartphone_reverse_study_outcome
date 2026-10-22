package f79;

import a49.d;
import android.content.SharedPreferences;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dorag.widget.model.DoraWidgetEntryContent;
import com.larus.platform.service.AccountService;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475777a = 0;

    static {
    }

    public static DoraWidgetEntryContent b() {
        SharedPreferences r100 = AppHost.f326268a.getApplication().getSharedPreferences(c(), 0);
        if (r100.contains("deviceName") == false) goto L56;
        String r101 = r100.getString("deviceName", "");
        if (r101 != null) goto L7;
        String r102 = "";
    L8:
        boolean r103 = r100.getBoolean("isConnected", false);
        boolean r104 = r100.getBoolean("isGlassCharging", false);
        boolean r105 = r100.getBoolean("isBoxCharging", false);
        int r106 = r100.getInt("glassBattery", -1);
        int r110 = r100.getInt("boxBattery", -1);
        String r107 = r100.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "");
        if (r107 != null) goto L11;
        String r111 = "";
    L12:
        String r108 = r100.getString("serialNumber", "");
        if (r108 != null) goto L15;
        String r112 = "";
    L16:
        int r113 = r100.getInt("productId", 16);
        long r114 = r100.getLong("date", -1);
        String r109 = r100.getString("latestDiaryId", "");
        if (r109 != null) goto L19;
        String r115 = "";
    L20:
        String r116 = r100.getString("latestDiaryDate", "");
        if (r116 != null) goto L23;
        String r117 = "";
    L24:
        long r118 = r100.getLong("latestDiaryCreateTime", 0);
        String r119 = r100.getString("latestDiaryTitle", "");
        if (r119 != null) goto L27;
        String r210 = "";
    L28:
        String r120 = r100.getString("latestDiaryContent", "");
        if (r120 != null) goto L31;
        String r211 = "";
    L32:
        String r121 = r100.getString("latestDiaryEmotion", "");
        if (r121 != null) goto L35;
        String r212 = "";
    L36:
        String r122 = r100.getString("latestDiaryEmotionUrl", "");
        if (r122 != null) goto L39;
        String r213 = "";
    L40:
        long r123 = r100.getLong("lastDiaryFetchTime", 0);
        String r124 = r100.getString("betaDate", "");
        if (r124 != null) goto L43;
        String r214 = "";
    L44:
        String r125 = r100.getString("betaTitle", "");
        if (r125 != null) goto L47;
        String r215 = "";
    L48:
        String r126 = r100.getString("betaText", "");
        if (r126 != null) goto L51;
        String r310 = "";
    L52:
        String r127 = r100.getString("betaImageUrl", "");
        if (r127 != null) goto L58;
        r127 = "";
    L58:
        return new DoraWidgetEntryContent(r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r117, r118, r210, r211, r212, r213, r123, r214, r215, r310, r127);
    L51:
        r310 = r126;
        goto L52
    L47:
        r215 = r125;
        goto L48
    L43:
        r214 = r124;
        goto L44
    L39:
        r213 = r122;
        goto L40
    L35:
        r212 = r121;
        goto L36
    L31:
        r211 = r120;
        goto L32
    L27:
        r210 = r119;
        goto L28
    L23:
        r117 = r116;
        goto L24
    L19:
        r115 = r109;
        goto L20
    L15:
        r112 = r108;
        goto L16
    L11:
        r111 = r107;
        goto L12
    L7:
        r102 = r101;
        goto L8
    L56:
        return null;
    }

    public static String c() {
        return "SPF_DORA_WIDGET-".concat(AccountService.f365697a.getUserId());
    }

    public static boolean a() {
        DoraWidgetEntryContent r100 = b();
        if (r100 != null) goto L5;
        r100 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r101 = DoraWidgetEntryContent.copy$default(r100, null, false, false, false, 0, 0, null, null, 0, 0, "", "", 0, "", "", "", "", 0, "", "", "", "", 132095, null);
        if (Intrinsics.areEqual(r101, r100) == false) goto L10;
        e();
        return false;
    L10:
        return f(DoraWidgetEntryContent.copy$default(r101, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    }

    public static boolean e() {
        DoraWidgetEntryContent r100 = b();
        if (r100 != null) goto L6;
        r100 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L6:
        return f(DoraWidgetEntryContent.copy$default(r100, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    }

    public static boolean d(d r510) {
        Intrinsics.checkNotNullParameter(r510, BrowserDependency.UrlClickType.CARD);
        DoraWidgetEntryContent r100 = b();
        if (r100 != null) goto L5;
        r100 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        String r101 = r510.a();
        if (r101 != null) goto L8;
        String r511 = "";
    L9:
        String r102 = r510.d();
        if (r102 != null) goto L12;
        String r512 = "";
    L13:
        String r103 = r510.c();
        if (r103 != null) goto L16;
        String r513 = "";
    L17:
        String r104 = r510.b();
        if (r104 != null) goto L20;
        String r514 = "";
    L21:
        DoraWidgetEntryContent r105 = DoraWidgetEntryContent.copy$default(r100, null, false, false, false, 0, 0, null, null, 0, 0, null, "", 0, "", "", "", "", 0, r511, r512, r513, r514, 133119, null);
        if (Intrinsics.areEqual(r105, r100) == false) goto L26;
        e();
        return false;
    L26:
        return f(DoraWidgetEntryContent.copy$default(r105, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    L20:
        r514 = r104;
        goto L21
    L16:
        r513 = r103;
        goto L17
    L12:
        r512 = r102;
        goto L13
    L8:
        r511 = r101;
        goto L9
    }

    public static boolean f(DoraWidgetEntryContent r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (Intrinsics.areEqual(b(), r100) == false) goto L5;
        return false;
    L5:
        SharedPreferences.Editor r101 = AppHost.f326268a.getApplication().getSharedPreferences(c(), 0).edit();
        r101.putString("deviceName", r100.getDeviceName());
        r101.putBoolean("isConnected", r100.isConnected());
        r101.putBoolean("isGlassCharging", r100.isGlassCharging());
        r101.putBoolean("isBoxCharging", r100.isBoxCharging());
        r101.putInt("glassBattery", r100.getGlassBattery());
        r101.putInt("boxBattery", r100.getBoxBattery());
        r101.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r100.getModel());
        r101.remove("sn");
        r101.putString("serialNumber", r100.getSerialNumber());
        r101.putInt("productId", r100.getProductId());
        r101.putLong("date", r100.getDate());
        r101.putString("latestDiaryId", r100.getLatestDiaryId());
        r101.putString("latestDiaryDate", r100.getLatestDiaryDate());
        r101.putLong("latestDiaryCreateTime", r100.getLatestDiaryCreateTime());
        r101.putString("latestDiaryTitle", r100.getLatestDiaryTitle());
        r101.putString("latestDiaryContent", r100.getLatestDiaryContent());
        r101.putString("latestDiaryEmotion", r100.getLatestDiaryEmotion());
        r101.putString("latestDiaryEmotionUrl", r100.getLatestDiaryEmotionUrl());
        r101.putLong("lastDiaryFetchTime", r100.getLastDiaryFetchTime());
        r101.putString("betaDate", r100.getBetaDate());
        r101.putString("betaTitle", r100.getBetaTitle());
        r101.putString("betaText", r100.getBetaText());
        r101.putString("betaImageUrl", r100.getBetaImageUrl());
        r101.apply();
        return true;
    }

    public static boolean g(String r410, String r411, long r412, String r413, String r414, String r510, String r511) {
        Intrinsics.checkNotNullParameter(r410, "id");
        Intrinsics.checkNotNullParameter(r411, "date");
        Intrinsics.checkNotNullParameter(r413, "title");
        Intrinsics.checkNotNullParameter(r414, "content");
        Intrinsics.checkNotNullParameter(r510, "emotion");
        Intrinsics.checkNotNullParameter(r511, "emotionUrl");
        DoraWidgetEntryContent r100 = b();
        if (r100 != null) goto L5;
        r100 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r101 = r100;
        return f(DoraWidgetEntryContent.copy$default(r101, null, false, false, false, 0, 0, null, null, 0, 0, r410, r411, r412, r413, r414, r510, r511, System.currentTimeMillis(), null, null, null, null, 3933183, null));
    }
}
