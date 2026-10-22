package com.obric.assistant.banner;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import tba.b;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\u001a\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H&J.\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\u0013H&J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u001c\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0012\u0010\u001e\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006 "}, d2 = {"Lcom/obric/assistant/banner/IObricBannerService;", "", "canShowBanner", "", "bannerType", "", "data", "Lcom/obric/assistant/banner/bean/ObricBanner;", "hostId", "", "showBanner", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "anchorView", "Landroid/view/View;", "banner", "showCustomDialog", "showDialogAction", "Lkotlin/Function0;", "", "setBannerUserDismissed", "bannerShowType", "updateBannerPosition", KtvSubElement.CONTAINER, "width", "height", "dismissAllBanner", "dismissBannerByHost", "dismissBannerByType", "isBannerShowing", "resetBannerFrequencyControl", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricBannerService {
    void a();

    void b(View r100, int r101, int r102, String r103);

    void c();

    void d(String r100);

    boolean e(String r100);

    boolean f(Activity r100, View r101, b r102, String r103);

    void g();
}
