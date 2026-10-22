package com.bytedance.android.shopping.service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.promotion.ECSimilarProductFunctionDescriptionViewUri;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.abtest.SettingKeys;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import com.bytedance.android.shopping.anchorv3.detail.vo.AuthorizationDialogImageInfo;
import com.bytedance.android.shopping.anchorv3.detail.vo.DialogImageInfo;
import com.bytedance.android.shopping.anchorv3.utils.purchaseV2.ECVideoPurchaseCallback;
import com.bytedance.android.shopping.anchorv4.launcher.PdpLauncher;
import com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaProcessor;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.qrcode.api.QrcodeApi;
import com.bytedance.android.shopping.qrcode.dto.BarCodeResponse;
import com.bytedance.android.shopping.qrcode.dto.CodeCheckResponseDTO;
import com.bytedance.android.shopping.router.ECAnchorV3Router;
import com.bytedance.android.shopping.router.e;
import com.bytedance.android.shopping.router.f;
import com.bytedance.android.shopping.router.g;
import com.bytedance.android.shopping.router.h;
import com.bytedance.android.shopping.router.i;
import com.bytedance.android.shopping.router.k;
import com.bytedance.android.shopping.searchsimilar.api.SimilarProductApi;
import com.bytedance.android.shopping.searchsimilar.model.QuerySimilarProductGuideResponse;
import com.bytedance.android.shopping.utils.z;
import com.bytedance.android.slice.api.ISliceInitService;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;
import n83.m;
import org.json.JSONException;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECAnchorV3Service implements p83.d {
    public static final CopyOnWriteArrayList<Function2<String, Float, Unit>> a = null;
    public static final CopyOnWriteArrayList<Function2<String, Integer, Unit>> b = null;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> c = null;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> d = null;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> e = null;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> f = null;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> g = null;
    public static final CopyOnWriteArrayList<Function2<String, String, Unit>> h = null;
    public static final ECAnchorV3Service i = null;

    public static final class a implements OnDismissListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ View c;

        public final void onDismiss(int r1) {
            this.b.invoke();
        }

        public a(List r1, Function0 r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ Function1 d;

        public b(Context r1, String r2, ViewGroup r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            ViewGroup r0 = null;
            JSONObject r1 = new JSONObject(this.b);     // Catch: JSONException -> L5
        L6:
            JSONObject r2 = new JSONObject();
            if (r1 == null) goto L9;
            JSONObject r4 = r1.optJSONObject("frame");
        L10:
            int r5 = com.bytedance.android.shopping.hybrid.b.a;
            if (r4 == null) goto L13;
            int r6 = r4.optInt("left", 0);
        L15:
            if ((r6 & 32768) <= 0) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == false) goto L20;
            int r9 = dg4.b.c();
        L21:
            Resources r10 = Resources.getSystem();
            int r11 = (int) (r9 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density);
            if ((r6 & 16384) <= 0) goto L24;
            boolean r12 = true;
        L25:
            int r7 = r6 & 16383;
            if (r12 == false) goto L28;
            int r13 = r11 - r7;
        L29:
            r2.put("x", r13);
            if (r4 == null) goto L32;
            int r14 = r4.optInt("top", 0);
        L34:
            if ((32768 & r14) <= 0) goto L36;
            boolean r15 = true;
        L37:
            if (r15 == false) goto L39;
            int r16 = dg4.b.b();
        L40:
            Resources r17 = Resources.getSystem();
            int r18 = (int) (r16 / WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()).density);
            if ((r14 & 16384) <= 0) goto L43;
            boolean r19 = true;
        L44:
            int r20 = r14 & 16383;
            if (r19 == false) goto L47;
            int r21 = r18 - r20;
        L48:
            r2.put("y", r21);
            int r22 = 100;
            if (r4 == null) goto L51;
            int r23 = r4.optInt("width", 100);
        L52:
            r2.put("width", r23);
            if (r4 == null) goto L55;
            r22 = r4.optInt("height", 100);
        L55:
            r2.put("height", r22);
            Map r24 = LynxTaskBanner.i;
            Context r25 = this.a;
            Pair[] r26 = new Pair[5];
            r26[0] = TuplesKt.to("frame", r2);
            if (r1 == null) goto L58;
            String r3 = r1.optString("task_enter_from");
        L59:
            r26[1] = TuplesKt.to("task_enter_from", r3);
            if (r1 == null) goto L62;
            String r27 = r1.optString("task_type");
        L63:
            r26[2] = TuplesKt.to("task_type", r27);
            r26[3] = TuplesKt.to("task_request_params", r1);
            if (r1 == null) goto L66;
            JSONObject r28 = r1.optJSONObject("log_extra");
        L67:
            r26[4] = TuplesKt.to("log_extra", r28);
            Map r29 = MapsKt.mapOf(r26);
            ViewGroup r30 = this.c;
            if ((r30 instanceof FrameLayout) == false) goto L71;
            r0 = r30;
        L71:
            LynxTaskBanner.a.a(r25, r29, (FrameLayout) r0);
            return;
        L66:
            r28 = null;
            goto L67
        L62:
            r27 = null;
            goto L63
        L58:
            r3 = null;
            goto L59
        L51:
            r23 = 100;
            goto L52
        L47:
            r21 = r18 + r20;
            goto L48
        L43:
            r19 = false;
            goto L44
        L39:
            r16 = 0;
            goto L40
        L36:
            r15 = false;
            goto L37
        L32:
            r14 = 0;
            goto L34
        L28:
            r13 = r11 + r7;
            goto L29
        L24:
            r12 = false;
            goto L25
        L20:
            r9 = 0;
            goto L21
        L17:
            r8 = false;
            goto L18
        L13:
            r6 = 0;
            goto L15
        L9:
            r4 = null;
        L5:
            r1 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements j {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ Function1 b;

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Function1 r0 = this.b;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(r2);
            return;
        }

        public c(ViewGroup r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ECAnchorV3Service() {
    }

    static {
        i = new ECAnchorV3Service();
        bf.a.a(new ECAnchorV3Router());
        bf.a.a(new h());
        bf.a.a(new com.bytedance.android.shopping.router.d());
        bf.a.a(new f());
        bf.a.a(new g());
        bf.a.a(new i());
        bf.a.a(new com.bytedance.android.shopping.router.j());
        bf.a.a(new com.bytedance.android.shopping.router.b());
        bf.a.a(new s63.a());
        bf.a.a(new com.bytedance.android.shopping.router.a());
        bf.a.a(new k());
        bf.a.a(new e());
        boolean r0 = ECServiceManager.a;
        ISliceInitService r1 = null;
        if (ECServiceManager.d(ISliceInitService.class) == false) goto L5;
        ISliceInitService r2 = (ISliceInitService) ECServiceManager.c(ISliceInitService.class);
    L6:
        if (r2 != null) goto L8;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        Object r4 = h().getMethod("getService", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L16
        if ((r4 instanceof ISliceInitService) == true) goto L14;
        r4 = null;
    L14:
        r1 = (ISliceInitService) r4;     // Catch: Exception -> L16
    L18:
        if (r1 != null) goto L20;
        Lazy r5 = UIUtils.a;
        UIUtils.c().postDelayed(new com.bytedance.android.shopping.service.b(r3), 30000);
    L20:
        if (r1 == null) goto L22;
        r1.initSlice();
        boolean r6 = ECServiceManager.a;
        ECServiceManager.e(ISliceInitService.class, r1);
    L22:
        Map r7 = xg.a.a;
        com.bytedance.android.shopping.anchorv4.schemav2.a r8 = new com.bytedance.android.shopping.anchorv4.schemav2.a();
        Intrinsics.checkNotNullParameter(r8, "router");
        xg.a.a.put("iesec_goods_detail", r8);
        com.lynx.tasm.behavior.shadow.text.g.a(com.bytedance.android.shopping.service.a.a);
        boolean r9 = ECServiceManager.a;
        ((cj.b) ECServiceManager.c(cj.b.class)).c();
        Lazy r10 = ECFontHelper.a;
        if (ECFontHelper.d == true) goto L26;
        ((Executor) ECFontHelper.a.getValue()).execute(com.bytedance.android.ec.core.utils.font.d.a);
    L26:
        a = new CopyOnWriteArrayList();
        b = new CopyOnWriteArrayList();
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArrayList();
        e = new CopyOnWriteArrayList();
        f = new CopyOnWriteArrayList();
        g = new CopyOnWriteArrayList();
        h = new CopyOnWriteArrayList();
        return;
    L16:
        e = move-exception;
        r3.element = e;
        goto L18
    L8:
        if (r2.hasInit() == true) goto L22;
        r2.initSlice();
        goto L22
    L5:
        r2 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.android.ec.slice.SliceInitService");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.slice.SliceInitService");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.slice.SliceInitService");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.android.ec.slice.SliceInitService");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.slice.SliceInitService");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.slice.SliceInitService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.slice.SliceInitService");
    }

    @Override // p83.d
    public final void clearRoomLifecycleData() {
        ArrayList r0 = l63.b.a;
        l63.b.b.clear();
    }

    @Override // p83.d
    public final void e() {
        ECVideoPurchaseCallback r0 = ECVideoPurchaseCallback.f;
        ECVideoPurchaseCallback.a.clear();
        ECVideoPurchaseCallback.b.clear();
        if (ECVideoPurchaseCallback.c.compareAndSet(true, false) == false) goto L6;
        s0.e(r0);
        ECLiveHybridUtil.p("ecom.sku.buynow", (ECVideoPurchaseCallback.ecomSkuBuyNowJsEvent.2.a) ECVideoPurchaseCallback.e.getValue());
        return;
    }

    @Override // p83.d
    public final View g() {
        WeakReference<View> r0 = com.bytedance.android.shopping.feed.utils.i.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // p83.d
    public final void requestShowSimilarProductGuide() {
        boolean r0 = com.bytedance.android.shopping.searchsimilar.utils.f.a;
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() != 2) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L25;
        SimilarProductApi.a.getClass();
        SimilarProductApi r2 = SimilarProductApi.a.a;
        if (r2 == null) goto L14;
        Observable<QuerySimilarProductGuideResponse> r3 = r2.queryShowSimilarProductGuide();
    L15:
        if (r3 == null) goto L22;
        Observable r4 = r3.subscribeOn(Schedulers.io());
        if (r4 == null) goto L23;
        Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L24;
        r5.subscribe(new com.bytedance.android.shopping.searchsimilar.utils.b());
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r3 = null;
        goto L15
    L25:
        return;
    L5:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() == 4) goto L8;
        r1 = false;
        goto L9
    }

    @Override // p83.d
    public final String getSearchSimilarBlackInstructionSchema() {
        ECSimilarProductFunctionDescriptionViewUri r0 = ECSettingKeys.K0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBlackBackgroundUri();
    }

    @Override // p83.d
    public final String getSearchSimilarWhiteInstructionSchema() {
        ECSimilarProductFunctionDescriptionViewUri r0 = ECSettingKeys.K0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWhiteBackgroundUri();
    }

    @Override // p83.d
    public final void f() {
        com.bytedance.android.shopping.feed.utils.i.a();
    }

    @Override // p83.d
    public final boolean checkQrcodePromotionSource(Context r11, String r12) {
        QrcodeApi.a.getClass();     // Catch: Exception -> L26
        if (QrcodeApi.a.a != null) goto L6;
        QrcodeApi.a.a = (QrcodeApi) n.a.create("https://ecom.snssdk.com", QrcodeApi.class);     // Catch: Exception -> L26
    L6:
        QrcodeApi r1 = QrcodeApi.a.a;     // Catch: Exception -> L26
        String r2 = null;
        if (r1 == null) goto L10;
        Observable<CodeCheckResponseDTO> r13 = r1.checkPromotionSource(r12);     // Catch: Exception -> L26
        if (r13 == null) goto L10;
    L11:
        BarCodeResponse r14 = ((CodeCheckResponseDTO) r13.subscribeOn(Schedulers.io()).blockingFirst()).getData();     // Catch: Exception -> L26
        if (r14 == null) goto L15;
        r2 = r14.getDetailUrl();     // Catch: Exception -> L26
    L15:
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L18;
        if (r11 == null) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L25;
        if (r11 == null) goto L25;
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        ECLiveHybridUtil.k(r11, r2, false, false, false, null, 252);     // Catch: Exception -> L26
    L25:
        return r15;
    L18:
        r15 = false;
    L10:
        CodeCheckResponseDTO.Companion.getClass();     // Catch: Exception -> L26
        r13 = Observable.just(new CodeCheckResponseDTO(null));     // Catch: Exception -> L26
    L29:
        return false;
    }

    @Override // p83.d
    public final void showSearchSimilarAuthorizationDialog(Context r7, String r8) {
        boolean r0 = com.bytedance.android.shopping.searchsimilar.utils.f.a;
        int r1 = ECSdk.a;
        s83.g r2 = (s83.g) ECSdk.a(s83.g.class);
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        s83.g r5 = (s83.g) ECSdk.a(s83.g.class);
        if (r5 == null) goto L12;
        Integer r6 = Integer.valueOf(r5.U());
    L13:
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.intValue() == 0) goto L19;
        return;
    L19:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() != 2) goto L21;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == true) goto L27;
        return;
    L27:
        if (Intrinsics.areEqual(r.a.getCurrentUserId(), r8) == true) goto L29;
        return;
    L29:
        if (com.bytedance.android.shopping.searchsimilar.utils.f.a == false) goto L47;
        if (r4 == false) goto L32;
        return;
    L32:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() != 1) goto L34;
    L36:
        AuthorizationDialogImageInfo r10 = SettingKeys.getSEARCH_SIMILAR_DIALOG_IMAGE();
        if (r10 == null) goto L49;
        DialogImageInfo r11 = r10.getValues();
        if (r11 == null) goto L50;
        if (r3 == false) goto L42;
        ECUrlModel r12 = r11.getCloseStatusImage();
    L43:
        y.n(r12, new com.bytedance.android.shopping.searchsimilar.utils.e(r3, r7));
        return;
    L42:
        r12 = r11.getOpenStatusImage();
        goto L43
    L50:
        return;
    L49:
        return;
    L34:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() == 2) goto L36;
        r3 = true;
        goto L36
    L47:
        return;
    L21:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() == 4) goto L24;
        r9 = false;
        goto L25
    L12:
        r6 = null;
        goto L13
    L5:
        if (r2.U() != 0) goto L8;
        r4 = false;
        goto L9
    }

    @Override // p83.d
    public final void a(Context r2, String r3, p83.h r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "pdpParams");
        new PdpLauncher(r2).c(UriProtector.parse(r3), r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        int r5 = z.a;
        z.c("ECAnchorV3Service.startPDP err=" + th.getMessage(), null, 6);
        throw th;
    }

    @Override // p83.d
    public final String c(Context r2, String r3, p83.h r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "pdpParams");
        PdpSchemaProcessor r0 = new PdpSchemaProcessor(r2, UriProtector.parse(r3));
        r0.a(r4);
        return r0.n();
    }

    @Override // p83.d
    public final void enterGalleryViewer(int r4, View r5, List<? extends com.bytedance.android.ec.model.k> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "dismissListener");
        GalleryViewer r0 = new GalleryViewer(r5.getContext(), new GalleryAdapter());
        r0.a(r6, false);
        r0.setOnDismissListener(new a(r6, r7, r5));
        r0.showAnimated(r4, r5);
    }

    @Override // p83.d
    public final void showAwemeDetailLynxWidget(Context r3, String r4, Function1<? super JSONObject, Unit> r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r4, "taskRequestParams");
        if (r3 == null) goto L13;
        new Handler().post(new b(r3, r4, r6, r5));
        final c r7 = new c(r6, r5);
        ECLiveHybridUtil.m("IESLiveKit_ecom_pendant_close_event", r7);
        if ((r3 instanceof FragmentActivity) == true) goto L7;
        r3 = null;
    L7:
        FragmentActivity r8 = (FragmentActivity) r3;
        if (r8 == null) goto L14;
        Lifecycle r9 = r8.getLifecycle();
        if (r9 == null) goto L15;
        r9.addObserver(new ECAnchorV3Service$showAwemeDetailLynxWidget$1$2(r7));
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // p83.d
    public final void d(FragmentActivity r11, ECOrderTrackerData r12, ProductPurchaseInfo r13, ProductDetailPageParams r14, BtmItemBuilder r15, com.bytedance.android.btm.api.model.d r16, nl.d r17, Function1<? super SkuProductDetailInfo, Unit> r18) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "trackerData");
        Intrinsics.checkNotNullParameter(r13, "purchaseInfo");
        com.bytedance.android.shopping.anchorv3.utils.purchase.a.e(r11, r12, r13, r14, r15, r16, r17, r18, 1792);
    }

    @Override // p83.d
    public final void b(Context r21, ECProductInfo r22, ECAwemeItemInfo r23, JSONObject r24, ECAdLogExtra r25, ECBoltParam r26, String r27, String r28, String r29, ECProductDetailPageShowStyle r30, ECLubanData r31, ECLogExtraData r32, JSONObject r33, ECUIParam r34, Boolean r35, m r36, String r37, Boolean r38) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "productInfo");
        Intrinsics.checkNotNullParameter(r23, "awemeInfo");
        Intrinsics.checkNotNullParameter(r24, "metaParam");
        Intrinsics.checkNotNullParameter(r30, "detailPageStyle");
        Intrinsics.checkNotNullParameter(r32, "logExtraData");
        ECAnchorV3Helper r0 = ECAnchorV3Helper.a;
        ECAnchorV3Helper.g(r21, r22, r23, r24, r25, r26, r27, r28, r37, r29, r30, r31, r32, r33, r34, r35, r36, r38);
    }
}
