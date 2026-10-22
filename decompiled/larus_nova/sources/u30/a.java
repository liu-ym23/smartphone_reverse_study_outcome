package u30;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.h;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f548548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f548549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f548550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f548551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f548552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f548553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f548554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f548555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f548556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f548557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f548558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f548559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f548560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f548561o;

    @Override // u30.b
    public final void b() {
        Bundle r100 = new Bundle();
        r100.putBoolean("is_fullscreen", true);
        r100.putBoolean("hide_nav_bar", this.f548548b);
        r100.putBoolean("hide_status_bar", this.f548549c);
        r100.putBoolean(AppConstants.TRANS_STATUS_BAR, false);
        r100.putBoolean(AppConstants.BUNDLE_HIDE_POSTER, this.f548552f);
        r100.putString("title", this.f548547a);
        r100.putBoolean("show_progress", false);
        r100.putBoolean(AppConstants.BUNDLE_USE_WEBVIEW_TITLE, true);
        r100.putString(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, this.f548550d);
        r100.putString(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR, this.f548551e);
        r100.putInt(AppConstants.BUNDLE_WEB_VIEW_BACKGROUND_COLOR, s1.h(R.color.ttlive_bg_feed));
        r100.putInt("request_code", this.f548553g);
        r100.putBoolean(AppConstants.BUNDLE_SHOW_BACK, this.f548555i);
        r100.putBoolean(AppConstants.BUNDLE_ENABLE_SHARE, this.f548554h);
        r100.putString(AppConstants.BUNDLE_IS_EXTERNAL_SCENE, null);
        r100.putBoolean(AppConstants.BUNDLE_IS_EXTERNAL_URL, false);
        r100.putString(AppConstants.BUNDLE_ORIGINAL_SCHEME, null);
        r100.putBoolean(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, false);
        r100.putBoolean("use_annie", this.f548556j);
        r100.putBoolean("use_anniex_container", this.f548557k);
        r100.putBoolean("disable_bounces", this.f548558l);
        ((IRoomService) k.n(IRoomService.class)).setOnNeedMuteAudioFullPage(true);
        ((IHostAction) k.n(IHostAction.class)).openLiveBrowser(this.f548561o, r100, this.f548560n);
    }

    @Override // u30.b
    public final a a(int r100) {
        this.f548553g = r100;
        return this;
    }

    @Override // u30.b
    public final a d(boolean r100) {
        this.f548548b = r100;
        return this;
    }

    @Override // u30.b
    public final a setTitle(String r100) {
        this.f548547a = r100;
        return this;
    }

    public a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f548560n = r100;
        this.f548561o = r101;
        BrowserServiceImpl.Companion.getClass();
        s20.b r102 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r102.getClass();
        h r103 = r102.f540209b.f540210c.get();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f548559m = r103;
    }

    @Override // u30.b
    public final void c(WebHybridParamVo r100, Bundle r101) {
        if (r101 == null) goto L5;
        Bundle r102 = new Bundle(r101);
    L6:
        r102.putParcelable("hybrid_web_vo", r100);
        if (r100 == null) goto L9;
        BaseHybridParamVo r103 = r100.f100557h;
    L10:
        r102.putParcelable("hybrid_pop_vo", r103);
        r102.putString(AppConstants.BUNDLE_ORIGINAL_SCHEME, null);
        if (r100 == null) goto L13;
        boolean r104 = r100.f100558i;
    L14:
        r102.putBoolean("use_annie", r104);
        r102.putBoolean("create_by_router", true);
        r102.putLong("container_init_start_time", System.currentTimeMillis());
        ((IRoomService) k.n(IRoomService.class)).setOnNeedMuteAudioFullPage(true);
        ((IHostAction) k.n(IHostAction.class)).openLiveBrowser(this.f548561o, r102, this.f548560n);
        return;
    L13:
        r104 = this.f548556j;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = new Bundle();
        goto L6
    }
}
