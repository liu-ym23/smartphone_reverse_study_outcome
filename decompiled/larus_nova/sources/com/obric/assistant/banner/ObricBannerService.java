package com.obric.assistant.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;
import com.obric.assistant.impl.databinding.ObricUpdateBannerBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.t1;
import com.obric.assistant.view.ObricUpdateBannerPopupWindow;
import com.obric.assistant.view.a0;
import com.obric.assistant.view.b0;
import com.obric.assistant.view.h;
import com.obric.assistant.view.h0;
import com.obric.assistant.view.i;
import com.obric.assistant.view.j;
import com.obric.assistant.view.w;
import com.obric.assistant.view.y;
import com.obric.assistant.view.z;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sba.c;
import sba.d;
import sba.e;
import sba.f;
import sba.g;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0012H\u0002J\u0012\u0010!\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\"\u001a\u00020\u000f2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010#\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J \u0010&\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000fH\u0016J*\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J(\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000fH\u0016J*\u0010.\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)2\b\b\u0001\u0010\u001c\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000fH\u0002J(\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u000f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J\u001e\u00104\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b06H\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0016J(\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010A\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)H\u0002J6\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00170\u00162\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J!\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010CJ\f\u0010D\u001a\u00020\u000f*\u00020)H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/assistant/banner/ObricBannerService;", "Lcom/obric/assistant/banner/IObricBannerService;", "<init>", "()V", "obricBannerRepo", "Lcom/bytedance/keva/Keva;", "getObricBannerRepo", "()Lcom/bytedance/keva/Keva;", "obricBannerRepo$delegate", "Lkotlin/Lazy;", "isShowing", "", "()Z", "updateBannerWindowsByHost", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/view/ObricUpdateBannerPopupWindow;", "currentPopupBannerType", "", "Ljava/lang/Integer;", "suppressShowNextBannerCount", "currentBannersPriorityQueue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "currentBannersDataMap", "Lcom/obric/assistant/banner/bean/ObricBanner;", "registerBanner", "", "bannerType", "priority", "data", "getUpdateBannerKeyByConfig", "bannerShowType", "isNeedBannerShown", "getBannersKey", "getPriority", "forbiddenShowBanner", "getHighestPendingPriority", "canShowBanner", "hostId", "anchorView", "Landroid/view/View;", "showBanner", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "banner", "onBannerDismissed", "reportUpdateBannerPipeline", "result", "reason", "extra", "Lorg/json/JSONObject;", "showCustomDialog", "showDialogAction", "Lkotlin/Function0;", "setBannerUserDismissed", "updateBannerPosition", KtvSubElement.CONTAINER, "width", "height", "dismissAllBanner", "dismissBannerByHost", "dismissBannerByType", "isBannerShowing", "resetBannerFrequencyControl", "showNextBanner", "removeItemByBannerKey", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "toBannerAnchorLog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBannerService implements IObricBannerService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f385869g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f385870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ObricUpdateBannerPopupWindow> f385871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f385872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f385873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityQueue<Pair<Integer, Integer>> f385874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, tba.b> f385875f;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Comparable) ((Pair) r101).getSecond(), (Comparable) ((Pair) r100).getSecond());
        }
    }

    static {
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void c() {
        p(this.f385874e, 2);
        this.f385875f.remove(2);
        Integer r100 = this.f385872c;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.intValue() == 2) goto L8;
        return;
    L8:
        if (j.b() == false) goto L10;
        this.f385873d++;
    L10:
        j.a();
        this.f385872c = null;
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void g() {
        FLogger.f375446a.i("ObricBannerService", "dismissAllBanner, updateHostCount=" + this.f385871b.size());
        this.f385874e.clear();
        this.f385875f.clear();
        ConcurrentHashMap<String, ObricUpdateBannerPopupWindow> r100 = this.f385871b;
        int r101 = 0;
        if (r100.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, ObricUpdateBannerPopupWindow>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (r102.next().getValue().f() == false) goto L7;
        r101 = r101 + 1;
    L11:
        this.f385873d = r101 + (j.b() ? 1 : 0);
        Iterator<T> r103 = this.f385871b.values().iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((ObricUpdateBannerPopupWindow) r103.next()).c();
        goto L13
    L15:
        this.f385871b.clear();
        j.a();
        this.f385872c = null;
    }

    public final Keva i() {
        return (Keva) this.f385870a.getValue();
    }

    public final boolean m() {
        Collection<ObricUpdateBannerPopupWindow> r100 = this.f385871b.values();
        if (r100.isEmpty() == true) goto L11;
        Iterator<T> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (((ObricUpdateBannerPopupWindow) r101.next()).f() == false) goto L7;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L15:
        return true;
    L14:
        if (j.b() == true) goto L15;
        return false;
    L11:
        r102 = false;
        goto L12
    }

    public ObricBannerService() {
        this.f385870a = LazyKt.lazy(new sba.a());
        this.f385871b = new ConcurrentHashMap();
        this.f385874e = new PriorityQueue(10, new b());
        this.f385875f = new ConcurrentHashMap();
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void a() {
        i().storeString(k(ObricBannerType.AVAILABLE.getValue()), "0");
        i().storeString(k(ObricBannerType.WIFI_DOWNLOADING.getValue()), "0");
        i().storeString(k(ObricBannerType.STATE_DOWNLOADED.getValue()), "0");
    }

    public static int j(@com.obric.assistant.banner.bean.ObricBannerType int r100) {
        Integer r101 = tba.b.f545328h.getValue().get(Integer.valueOf(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    public static String k(int r100) {
        if (r100 != ObricBannerType.AVAILABLE.getValue()) goto L5;
    L14:
        String r101 = "user";
    L16:
        return "banner_is_shown_1_".concat(r101);
    L5:
        if (r100 == ObricBannerType.DOWNLOADING.getValue()) goto L14;
        if (r100 != ObricBannerType.WIFI_DOWNLOADING.getValue()) goto L11;
        r101 = "wifi_auto";
        goto L16
    L11:
        if (r100 != ObricBannerType.STATE_DOWNLOADED.getValue()) goto L13;
        r101 = "install";
        goto L16
    L13:
        r101 = "unknown";
        goto L16
    }

    public static String q(View r100) {
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

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostId");
        FLogger.f375446a.i("ObricBannerService", "dismissBannerByHost, hostId=" + r100 + ", hasWindow=" + this.f385871b.containsKey(r100));
        ObricUpdateBannerPopupWindow r101 = this.f385871b.remove(r100);
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostId");
        return n(r100, null);
    }

    public final boolean l(@com.obric.assistant.banner.bean.ObricBannerType int r110) {
        if (r110 != 1) goto L5;
        IObricUpdateService r111 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r111 == null) goto L15;
        ObricBannerType r112 = r111.getBannerType();
        if (r112 == null) goto L15;
        int r113 = r112.getValue();
    L16:
        long r100 = AppHost.f326268a.getAppClock().currentTimeMillis() - CastLongProtector.parseLong(i().getString(k(r113), "0"));
        long r101 = t1.f393353a.L0().getObricUpdateBannerShowInterval() * 1000;
        FLogger.f375446a.i("ObricBannerService", "isBannerShown, CHECK_UPDATE, bannerShowType:" + r113 + ",  gap: " + r100 + ", timeLimit: " + r101);
        if (r100 <= r101) goto L21;
    L18:
        return true;
    L21:
        return false;
    L15:
        r113 = 0;
        goto L16
    L5:
        if (r110 != 2) goto L7;
        FLogger.f375446a.i("ObricBannerService", "isNeedBannerShown, SET_DEFAULT_ASSISTANT skip frequency control");
        goto L18
    L7:
        if (i().contains("banner_is_shown_" + r110) == false) goto L18;
        return false;
    }

    public final boolean n(String r100, @com.obric.assistant.banner.bean.ObricBannerType Integer r101) {
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L17;
    L10:
        ObricUpdateBannerPopupWindow r102 = this.f385871b.get(r100);
        if (r102 != null) goto L13;
    L15:
        return false;
    L13:
        if (r102.f() != true) goto L15;
        return true;
    L17:
        return j.b();
    L6:
        if (r101.intValue() == 1) goto L10;
        goto L7
    }

    public final void p(PriorityQueue r100, @com.obric.assistant.banner.bean.ObricBannerType int r101) {
        FLogger.f375446a.i("ObricBannerService", "removeItemByBannerKey, " + r101 + ", current: " + this.f385874e);
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((Number) ((Pair) r103).getFirst()).intValue() != r101) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        Pair r105 = (Pair) r103;
        if (r105 == null) goto L21;
        r100.remove(r105);
        return;
    L21:
        return;
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void b(View r110, int r111, int r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r211, "hostId");
        ObricUpdateBannerPopupWindow r112 = this.f385871b.get(r211);
        if (r112 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        Object r113 = null;
        if (r100 == false) goto L48;
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricBannerService", "updateBannerPosition, hostId=" + r211 + ", anchor=" + q(r110) + ", width=" + r111 + ", height=" + r210);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L42
        PopupWindow r103 = r112.f393997b;     // Catch: Throwable -> L42
        if (r103 != null) goto L14;
    L16:
        boolean r114 = false;
    L17:
        if (r114 == false) goto L36;
        StringBuilder r104 = new StringBuilder("updatePosition, hostId=");     // Catch: Throwable -> L42
        r104.append(r112.f393996a);     // Catch: Throwable -> L42
        r104.append(", anchor=");     // Catch: Throwable -> L42
        r104.append(ObricUpdateBannerPopupWindow.j(r110));     // Catch: Throwable -> L42
        r104.append(", width=");     // Catch: Throwable -> L42
        r104.append(r111);     // Catch: Throwable -> L42
        r104.append(", height=");     // Catch: Throwable -> L42
        r104.append(r210);     // Catch: Throwable -> L42
        r104.append(", popupWidth=");     // Catch: Throwable -> L42
        PopupWindow r105 = r112.f393997b;     // Catch: Throwable -> L42
        if (r105 == null) goto L21;
        Integer r106 = Integer.valueOf(r105.getWidth());     // Catch: Throwable -> L42
    L22:
        r104.append(r106);     // Catch: Throwable -> L42
        r104.append(", popupHeight=");     // Catch: Throwable -> L42
        PopupWindow r107 = r112.f393997b;     // Catch: Throwable -> L42
        if (r107 == null) goto L25;
        Integer r108 = Integer.valueOf(r107.getHeight());     // Catch: Throwable -> L42
    L26:
        r104.append(r108);     // Catch: Throwable -> L42
        r101.i("ObricUpdateBannerPopupWindow", r104.toString());     // Catch: Throwable -> L42
        PopupWindow r115 = r112.f393997b;     // Catch: Throwable -> L42
        if (r115 == null) goto L40;
        int r116 = r112.f393999d;     // Catch: Throwable -> L42
        int r117 = -r112.f394000e;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r115) == false) goto L32;
        r115.update(r110, r116, r117, r111, r210);     // Catch: Throwable -> L42
    L35:
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L40
    L32:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r115, r110, r116, r117, r111, r210) == true) goto L35;
        r115.update(r110, r116, r117, r111, r210);     // Catch: Throwable -> L42
    L40:
        Object r109 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L42
    L44:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r109);
        if (r118 == null) goto L76;
        FLogger.f375446a.e("ObricUpdateBannerPopupWindow", "updatePosition error, hostId=" + r112.f393996a + ": " + r118.getMessage());
        return;
    L76:
        return;
    L25:
        r108 = null;
        goto L26
    L21:
        r106 = null;
        goto L22
    L36:
        StringBuilder r119 = new StringBuilder("updatePosition skipped, hostId=");     // Catch: Throwable -> L42
        r119.append(r112.f393996a);     // Catch: Throwable -> L42
        r119.append(", isShowing=");     // Catch: Throwable -> L42
        PopupWindow r120 = r112.f393997b;     // Catch: Throwable -> L42
        if (r120 == null) goto L39;
        r113 = Boolean.valueOf(r120.isShowing());     // Catch: Throwable -> L42
    L39:
        r119.append(r113);     // Catch: Throwable -> L42
        r119.append(", anchor=");     // Catch: Throwable -> L42
        r119.append(ObricUpdateBannerPopupWindow.j(r110));     // Catch: Throwable -> L42
        r101.i("ObricUpdateBannerPopupWindow", r119.toString());     // Catch: Throwable -> L42
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L40
    L14:
        if (r103.isShowing() != true) goto L16;
        r114 = true;
    L42:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L48:
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("updateBannerPosition skipped, hostId=");
        r123.append(r211);
        r123.append(", hasWindow=");
        if (r112 == null) goto L51;
        boolean r124 = true;
    L52:
        r123.append(r124);
        r123.append(", isShowing=");
        if (r112 == null) goto L55;
        r113 = Boolean.valueOf(r112.f());
    L55:
        r123.append(r113);
        r123.append(", anchor=");
        r123.append(q(r110));
        r122.i("ObricBannerService", r123.toString());
        if (j.b() == false) goto L77;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        PopupWindow r125 = j.f394295a;
        if (r125 != null) goto L60;
    L62:
        boolean r126 = false;
    L63:
        if (r126 == false) goto L78;
        PopupWindow r127 = j.f394295a;
        if (r127 == null) goto L79;
        int r128 = j.f394297c;
        int r129 = -j.f394298d;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r127) == false) goto L70;
        r127.update(r110, r128, r129, r111, r210);
        return;
    L70:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r127, r110, r128, r129, r111, r210) == true) goto L81;
        r127.update(r110, r128, r129, r111, r210);
        return;
    L81:
        return;
    L79:
        return;
    L78:
        return;
    L60:
        if (r125.isShowing() != true) goto L62;
        r126 = true;
        goto L63
    L77:
        return;
    L51:
        r124 = false;
        goto L52
    L5:
        if (r112.f() != true) goto L7;
        r100 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v70, types: [sba.e] */
    /* JADX WARN: Type inference failed for: r14v19, types: [sba.f] */
    /* JADX WARN: Type inference failed for: r15v2, types: [sba.g] */
    /* JADX WARN: Type inference failed for: r1v7, types: [sba.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [sba.c] */
    @Override // com.obric.assistant.banner.IObricBannerService
    public final boolean f(final Activity r310, final View r311, final tba.b r312, final String r313) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "anchorView");
        Intrinsics.checkNotNullParameter(r312, "banner");
        Intrinsics.checkNotNullParameter(r313, "hostId");
        FLogger r110 = FLogger.f375446a;
        r110.i("ObricBannerService", "showBanner start, hostId=" + r313 + ", bannerType=" + r312.f545329a + ", anchor=" + q(r311) + ", banner=" + r312);
        if (h(r313, r311, r312.f545329a, r312) == true) goto L10;
        r110.i("ObricBannerService", "showBanner blocked, hostId=" + r313 + ", banner=" + r312);
        if (r312.f545329a != 1) goto L9;
        JSONObject r100 = new JSONObject();
        r100.put("banner_is_show", n(r313, null));
        r100.put("global_banner_is_show", m());
        r100.put("banner_host_id", r313);
        Unit r101 = Unit.INSTANCE;
        IObricUpdateService r102 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r102 == null) goto L9;
        r102.a("blocked", "can_not_show_banner", r100);
    L9:
        return false;
    L10:
        int r103 = r312.f545329a;
        if (r103 == 1) goto L36;
        if (r103 == 2) goto L14;
        return true;
    L14:
        PopupWindow r104 = j.f394295a;
        String r111 = r312.f545330b;
        String r112 = r312.f545331c;
        final ?? r105 = new e(r312);
        final ?? r113 = new f(r312);
        final ?? r114 = new g(this, r310, r311, r312, r313);
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "anchorView");
        if (r310.isFinishing() == false) goto L17;
    L32:
        PopupWindow r115 = null;
    L33:
        if (r115 == null) goto L152;
        this.f385872c = Integer.valueOf(r312.f545329a);
        return true;
    L152:
        return true;
    L17:
        if (r310.isDestroyed() == true) goto L32;
        final View r106 = LayoutInflater.from(r310).inflate(R.layout.obric_addicon_banner, null, false);
        r106.setClipToOutline(true);
        r106.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Resources r107 = r310.getResources();
        j.f394296b = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).widthPixels;
        Resources r108 = r310.getResources();
        j.f394297c = (int) TypedValue.applyDimension(1, 0.0f, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));
        Resources r109 = r310.getResources();
        j.f394298d = (int) TypedValue.applyDimension(1, 24.0f, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()));
        Resources r116 = r310.getResources();
        j.f394299e = (int) TypedValue.applyDimension(1, 112.0f, WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()));
        PopupWindow r117 = new PopupWindow(r310);
        r117.setContentView(r106);
        r117.setWidth(j.f394296b - (j.f394297c * 2));
        r117.setHeight(j.f394299e);
        r117.setOutsideTouchable(false);
        r117.setFocusable(false);
        r117.setClippingEnabled(true);
        r117.setBackgroundDrawable(new ColorDrawable(0));
        r117.setAnimationStyle(0);
        r117.update();
        j.f394295a = r117;
        r117.setOnDismissListener(new com.obric.assistant.view.f(r114));
        if (r111 == null) goto L23;
        ((TextView) r106.findViewById(R.id.obric_banner_hint)).setText(r111);
    L23:
        if (r112 == null) goto L25;
        ((TextView) r106.findViewById(R.id.obric_banner_btn_add)).setText(r112);
    L25:
        ((TextView) r106.findViewById(R.id.obric_banner_btn_add)).setOnClickListener(new com.obric.assistant.view.g(r105, r106));
        r106.findViewById(R.id.obric_banner_btn_close).setOnClickListener(new h(r113));
        PopupWindow r118 = j.f394295a;
        if (r118 == null) goto L31;
        int r119 = j.f394297c;
        int r120 = -j.f394298d;
        OverlaySource r121 = PopupWindowLancet.resolveSource(r311);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r118, r311, r121) == true) goto L31;
        r118.showAsDropDown(r311, r119, r120);
        PopupWindowLancet.trackAfterShow(r118, r121, r311);
    L31:
        r311.addOnAttachStateChangeListener(new i(r311));
        r115 = j.f394295a;
        goto L33
    L36:
        ObricUpdateBannerPopupWindow r122 = this.f385871b.get(r313);
        if (r122 == null) goto L39;
        r122.c();
    L39:
        final ObricUpdateBannerPopupWindow r123 = new ObricUpdateBannerPopupWindow(r313);
        this.f385871b.put(r313, r123);
        IObricUpdateService r124 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r124 == null) goto L42;
        r124.a("success", null, null);
    L42:
        Function1 r125 = new sba.b(r313, r312);
        final ?? r126 = new c(r313, r312, this);
        final ?? r127 = new d(this, r310, r311, r312, r313);
        Intrinsics.checkNotNullParameter(r310, "activity");
        Intrinsics.checkNotNullParameter(r311, "anchorView");
        if (r310.isFinishing() == false) goto L45;
    L148:
        r110.i("ObricUpdateBannerPopupWindow", "show skipped, hostId=" + r123.f393996a + ", finishing=" + r310.isFinishing() + ", destroyed=" + r310.isDestroyed() + ", anchor=" + ObricUpdateBannerPopupWindow.j(r311));
        return true;
    L45:
        if (r310.isDestroyed() == true) goto L148;
        r123.c();
        View r128 = LayoutInflater.from(r310).inflate(R.layout.obric_update_banner, null, false);
        ConstraintLayout r210 = (ConstraintLayout) ViewBindings.findChildViewById(r128, R.id.group_obric_banner_btn_add);
        if (r210 == null) goto L145;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r128, R.id.obric_banner_btn_add);
        if (r211 == null) goto L144;
        ImageView r212 = (ImageView) ViewBindings.findChildViewById(r128, R.id.obric_banner_btn_close);
        if (r212 == null) goto L143;
        ConstraintLayout r213 = (ConstraintLayout) ViewBindings.findChildViewById(r128, R.id.obric_banner_btn_continue);
        if (r213 != null) goto L56;
        int r129 = R.id.obric_banner_btn_continue;
    L147:
        throw new NullPointerException("Missing required view with ID: ".concat(r128.getResources().getResourceName(r129)));
    L56:
        if (((TextView) ViewBindings.findChildViewById(r128, R.id.obric_banner_btn_continue_text)) == null) goto L141;
        CustomUpdateCircleProgressBar r214 = (CustomUpdateCircleProgressBar) ViewBindings.findChildViewById(r128, R.id.obric_banner_btn_update_progress);
        if (r214 == null) goto L140;
        ProgressBar r215 = (ProgressBar) ViewBindings.findChildViewById(r128, R.id.obric_loading_page);
        if (r215 != null) goto L62;
        r129 = R.id.obric_loading_page;
        goto L147
    L62:
        if (((TextView) ViewBindings.findChildViewById(r128, R.id.obric_update_banner_hint)) != null) goto L64;
        r129 = R.id.obric_update_banner_hint;
        goto L147
    L64:
        if (((ImageView) ViewBindings.findChildViewById(r128, R.id.obric_update_banner_icon)) == null) goto L137;
        TextView r216 = (TextView) ViewBindings.findChildViewById(r128, R.id.obric_update_banner_main_title);
        if (r216 == null) goto L136;
        TextView r217 = (TextView) ViewBindings.findChildViewById(r128, R.id.obric_update_banner_sub_title);
        if (r217 == null) goto L135;
        ConstraintLayout r218 = (ConstraintLayout) ViewBindings.findChildViewById(r128, R.id.obric_update_banner_with_subtitle_group);
        if (r218 == null) goto L134;
        ConstraintLayout r130 = (ConstraintLayout) r128;
        r123.f394002g = new ObricUpdateBannerBinding(r130, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        if (r130 == null) goto L75;
        r130.setClipToOutline(true);
        r130.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L75:
        if (r310.getResources().getConfiguration().orientation != 2) goto L77;
        boolean r131 = true;
    L78:
        if (r131 == true) goto L80;
        Resources r132 = r310.getResources();
        int r133 = WindowDisplayMetricsOverride.apply(r132, r132.getDisplayMetrics()).widthPixels;
    L84:
        r123.f393998c = r133;
        Resources r134 = r310.getResources();
        r123.f393999d = (int) TypedValue.applyDimension(1, 0.0f, WindowDisplayMetricsOverride.apply(r134, r134.getDisplayMetrics()));
        Resources r135 = r310.getResources();
        r123.f394000e = (int) TypedValue.applyDimension(1, 24.0f, WindowDisplayMetricsOverride.apply(r135, r135.getDisplayMetrics()));
        Resources r136 = r310.getResources();
        r123.f394001f = (int) TypedValue.applyDimension(1, 112.0f, WindowDisplayMetricsOverride.apply(r136, r136.getDisplayMetrics()));
        PopupWindow r137 = new PopupWindow(r310);
        ObricUpdateBannerBinding r138 = r123.f394002g;
        if (r138 == null) goto L87;
        ConstraintLayout r139 = r138.f389609a;
    L88:
        r137.setContentView(r139);
        r137.setWidth(r123.f393998c - (r123.f393999d * 2));
        r137.setHeight(r123.f394001f);
        r137.setOutsideTouchable(false);
        r137.setFocusable(false);
        r137.setClippingEnabled(true);
        r137.setBackgroundDrawable(new ColorDrawable(0));
        r137.setAnimationStyle(0);
        r137.update();
        r123.f393997b = r137;
        StringBuilder r140 = new StringBuilder("show prepare, hostId=");
        r140.append(r123.f393996a);
        r140.append(", isLandscape=");
        r140.append(r131);
        r140.append(", displayWidth=");
        Resources r141 = r310.getResources();
        r140.append(WindowDisplayMetricsOverride.apply(r141, r141.getDisplayMetrics()).widthPixels);
        r140.append(", screenWidth=");
        r140.append(r123.f393998c);
        r140.append(", marginPx=");
        r140.append(r123.f393999d);
        r140.append(", marginPy=");
        r140.append(r123.f394000e);
        r140.append(", heightInPx=");
        r140.append(r123.f394001f);
        r140.append(", popupWidth=");
        PopupWindow r142 = r123.f393997b;
        if (r142 == null) goto L91;
        Integer r143 = Integer.valueOf(r142.getWidth());
    L92:
        r140.append(r143);
        r140.append(", popupHeight=");
        PopupWindow r144 = r123.f393997b;
        if (r144 == null) goto L95;
        Integer r145 = Integer.valueOf(r144.getHeight());
    L96:
        r140.append(r145);
        r140.append(", anchor=");
        r140.append(ObricUpdateBannerPopupWindow.j(r311));
        r110.i("ObricUpdateBannerPopupWindow", r140.toString());
        r123.h();
        ObricUpdateBannerBinding r146 = r123.f394002g;
        if (r146 == null) goto L101;
        ConstraintLayout r147 = r146.f389610b;
        if (r147 == null) goto L101;
        final sba.b r148 = r125;
        r147.setOnClickListener(new w(r123, r148));
        final sba.b r149 = r148;
    L102:
        ObricUpdateBannerBinding r150 = r123.f394002g;
        if (r150 == null) goto L107;
        ConstraintLayout r151 = r150.f389613e;
        if (r151 == null) goto L107;
        r151.setOnClickListener(new y(r123, r149));
    L107:
        ObricUpdateBannerBinding r152 = r123.f394002g;
        if (r152 == null) goto L112;
        CustomUpdateCircleProgressBar r153 = r152.f389614f;
        if (r153 == null) goto L112;
        r153.setOnClickListener(new z(r123, r149));
    L112:
        ObricUpdateBannerBinding r154 = r123.f394002g;
        if (r154 == null) goto L117;
        ImageView r155 = r154.f389612d;
        if (r155 == null) goto L117;
        r155.setOnClickListener(new a0(r123, r310, r126));
    L117:
        IObricUpdateService r156 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r156 == null) goto L120;
        r156.f(r123.f394005j);
    L120:
        PopupWindow r157 = r123.f393997b;
        if (r157 == null) goto L123;
        r157.setOnDismissListener(new b0(r123, r311, r127));
    L123:
        PopupWindow r158 = r123.f393997b;
        if (r158 == null) goto L129;
        int r159 = r123.f393999d;
        int r160 = -r123.f394000e;
        OverlaySource r161 = PopupWindowLancet.resolveSource(r311);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r158, r311, r161) == true) goto L129;
        r158.showAsDropDown(r311, r159, r160);
        PopupWindowLancet.trackAfterShow(r158, r161, r311);
    L129:
        StringBuilder r162 = new StringBuilder("show done, hostId=");
        r162.append(r123.f393996a);
        r162.append(", isShowing=");
        PopupWindow r163 = r123.f393997b;
        if (r163 == null) goto L132;
        Boolean r164 = Boolean.valueOf(r163.isShowing());
    L133:
        r162.append(r164);
        r162.append(", anchor=");
        r162.append(ObricUpdateBannerPopupWindow.j(r311));
        r110.i("ObricUpdateBannerPopupWindow", r162.toString());
        r123.f394003h = r311;
        h0 r165 = new h0(r123);
        r311.addOnAttachStateChangeListener(r165);
        r123.f394004i = r165;
        return true;
    L132:
        r164 = null;
    L101:
        r149 = r125;
        goto L102
    L95:
        r145 = null;
        goto L96
    L91:
        r143 = null;
        goto L92
    L87:
        r139 = null;
        goto L88
    L80:
        View r166 = r311.getRootView();
        if (r166 == null) goto L83;
        r133 = r166.getWidth();
        goto L84
    L83:
        r133 = 0;
        goto L84
    L77:
        r131 = false;
        goto L78
    L134:
        r129 = R.id.obric_update_banner_with_subtitle_group;
        goto L147
    L135:
        r129 = R.id.obric_update_banner_sub_title;
        goto L147
    L136:
        r129 = R.id.obric_update_banner_main_title;
        goto L147
    L137:
        r129 = R.id.obric_update_banner_icon;
        goto L147
    L140:
        r129 = R.id.obric_banner_btn_update_progress;
        goto L147
    L141:
        r129 = R.id.obric_banner_btn_continue_text;
        goto L147
    L143:
        r129 = R.id.obric_banner_btn_close;
        goto L147
    L144:
        r129 = R.id.obric_banner_btn_add;
        goto L147
    L145:
        r129 = R.id.group_obric_banner_btn_add;
        goto L147
    }

    public final boolean h(String r110, View r111, int r112, tba.b r113) {
        boolean r100 = false;
        if (r112 >= 0) goto L7;
        FLogger.f375446a.i("ObricBannerService", "canShowBanner false, hostId=" + r110 + ", bannerType=" + r112 + ", reason=tip_type_invalid");
        return false;
    L7:
        if (l(r112) == true) goto L10;
        FLogger.f375446a.i("ObricBannerService", "canShowBanner false, hostId=" + r110 + ", bannerType=" + r112 + ", reason=frequency_control");
        return false;
    L10:
        Function0<Boolean> r101 = r113.f545335g;
        if (r101 != null) goto L13;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L19;
        FLogger.f375446a.i("ObricBannerService", "bannerType:" + r112 + ", canShowBanner:false, data.canShow false");
        return false;
    L19:
        int r103 = j(r112);
        PriorityQueue<Pair<Integer, Integer>> r104 = this.f385874e;
        if ((r104 instanceof Collection) == true) goto L22;
    L24:
        Iterator<Pair<Integer, Integer>> r105 = r104.iterator();
    L26:
        if (r105.hasNext() == false) goto L33;
        if (r105.next().getFirst().intValue() != r112) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L26;
        boolean r107 = true;
    L34:
        if (r107 == false) goto L36;
        this.f385875f.put(Integer.valueOf(r112), r113);
    L37:
        FLogger r114 = FLogger.f375446a;
        r114.i("ObricBannerService", "forbiddenShowBanner:" + r112 + ", can forbiddenShowBanner false");
        String r108 = null;
        if (n(r110, Integer.valueOf(r112)) == false) goto L44;
        StringBuilder r109 = new StringBuilder("canShowBanner false, hostId=");
        r109.append(r110);
        r109.append(", bannerType=");
        r109.append(r112);
        r109.append(", reason=same_host_showing, anchor=");
        if (r111 == null) goto L42;
        r108 = q(r111);
    L42:
        r109.append(r108);
        r109.append(", globalShowing=");
        r109.append(m());
        r114.i("ObricBannerService", r109.toString());
        return false;
    L44:
        int r115 = j(r112);
        PriorityQueue<Pair<Integer, Integer>> r116 = this.f385874e;
        ArrayList r117 = new ArrayList();
        Iterator<Pair<Integer, Integer>> r118 = r116.iterator();
    L46:
        if (r118.hasNext() == false) goto L50;
        Pair<Integer, Integer> r119 = r118.next();
        if (l(r119.getFirst().intValue()) == false) goto L46;
        r117.add(r119);
        goto L46
    L50:
        Iterator r120 = r117.iterator();
        if (r120.hasNext() == true) goto L53;
        Integer r121 = null;
    L59:
        if (r121 == null) goto L61;
        int r122 = r121.intValue();
    L62:
        if (r115 < r122) goto L64;
        r100 = true;
    L64:
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("canShowBanner ");
        r124.append(r100);
        r124.append(", hostId=");
        r124.append(r110);
        r124.append(", bannerType=");
        r124.append(r112);
        r124.append(", anchor=");
        if (r111 == null) goto L67;
        r108 = q(r111);
    L67:
        r124.append(r108);
        r124.append(", globalShowing=");
        r124.append(m());
        r123.i("ObricBannerService", r124.toString());
        return r100;
    L61:
        r122 = Integer.MIN_VALUE;
        goto L62
    L53:
        r121 = Integer.valueOf(((Number) ((Pair) r120.next()).getSecond()).intValue());
    L55:
        if (r120.hasNext() == false) goto L59;
        Integer r125 = Integer.valueOf(((Number) ((Pair) r120.next()).getSecond()).intValue());
        if (r121.compareTo(r125) >= 0) goto L55;
        r121 = r125;
        goto L55
    L36:
        FLogger r126 = FLogger.f375446a;
        r126.i("ObricBannerService", "registerBanner, " + r112 + ", " + r103 + ", " + r113);
        this.f385874e.offer(new Pair(Integer.valueOf(r112), Integer.valueOf(r103)));
        this.f385875f.put(Integer.valueOf(r112), r113);
        StringBuilder r127 = new StringBuilder("registerBanner, currentBannersPriorityQueue: ");
        r127.append(this.f385874e);
        r126.i("ObricBannerService", r127.toString());
        goto L37
    L30:
        r106 = false;
    L33:
        r107 = false;
        goto L34
    L22:
        if (r104.isEmpty() == false) goto L24;
    L13:
        if (r101.invoke().booleanValue() == true) goto L15;
        r102 = true;
        goto L16
    }

    public final void o(Activity r100, View r101, @com.obric.assistant.banner.bean.ObricBannerType int r102, String r103) {
        FLogger r104 = FLogger.f375446a;
        r104.i("ObricBannerService", "popupWindow dismissed, hostId=" + r103 + ", type=" + r102);
        if (r102 != 1) goto L5;
        this.f385871b.remove(r103);
    L5:
        Integer r105 = this.f385872c;
        if (r105 != null) goto L9;
    L11:
        p(this.f385874e, r102);
        this.f385875f.remove(Integer.valueOf(r102));
        int r106 = this.f385873d;
        if (r106 <= 0) goto L15;
        this.f385873d = r106 - 1;
        return;
    L15:
        r104.i("ObricBannerService", "showNextBanner, hostId=" + r103 + ", queue=" + this.f385874e);
    L17:
        if ((!this.f385874e.isEmpty()) == false) goto L28;
        Pair<Integer, Integer> r107 = this.f385874e.peek();
        if (r107 == null) goto L28;
        tba.b r108 = this.f385875f.get(r107.getFirst());
        if (r108 == null) goto L23;
        if (h(r103, r101, r107.getFirst().intValue(), r108) == true) goto L26;
        this.f385874e.remove();
        this.f385875f.remove(r107.getFirst());
        goto L17
    L26:
        f(r100, r101, r108, r103);
        return;
    L23:
        this.f385874e.remove();
    L28:
        FLogger.f375446a.i("ObricBannerService", "showNextBanner, no available to show, hostId=" + r103 + ", queue=" + this.f385874e);
        return;
    L9:
        if (r105.intValue() != r102) goto L11;
        this.f385872c = null;
        goto L11
    }
}
