package com.bytedance.locallife.photo.photodraweeview.indicator;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.photo.album.model.PhotoPreviewData;
import com.bytedance.locallife.photo.album.model.PhotoPreviewModel;
import com.bytedance.locallife.photo.album.model.PoiPhotoPreviewLynxData;
import com.bytedance.locallife.photo.album.model.PoiPreviewPhotoModel;
import com.bytedance.locallife.photo.album.model.p;
import com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.locallife.photo.photodraweeview.MobEvent;
import com.bytedance.locallife.photo.photodraweeview.f;
import com.bytedance.locallife.photo.preview.uilayer.LynxUILayer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.event.PoiClickHeaderInfoEvent;
import f66.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import ux6.c;
import vn6.b;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\nB'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/indicator/PhotoPreviewDecorateView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/photo/internal/photodraweeview/IIndicatorView;", "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "Lux6/a;", "Lcom/ss/android/ugc/aweme/poi/event/PoiClickHeaderInfoEvent;", "event", "", "onEvent", "Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;", "getModel", "()Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;", "setModel", "(Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;)V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "", "", ce.f26395j, "Ljava/util/Map;", "getLynxCommonData", "()Ljava/util/Map;", "lynxCommonData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public class PhotoPreviewDecorateView extends FrameLayout implements IIndicatorView, JsEventSubscriber, ux6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoPreviewModel f262129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f262130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f262131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LynxUILayer f262132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LynxUILayer f262133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f262135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f262136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f262137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f262138j;

    public static final class a {
    }

    static {
    }

    public PhotoPreviewDecorateView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoPreviewDecorateView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void c(PhotoPreviewModel r100, p r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "data");
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView, com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionChanged(int r100, float r101) {
    }

    @Override // ux6.a
    public final void a() {
        EventCenter.unregisterJsEventSubscriber("photo_preview_close", this);
        EventCenter.unregisterJsEventSubscriber("photo_preview_page_collapse_to_index", this);
        LynxUILayer r100 = this.f262132d;
        if (r100 == null) goto L5;
        kp6.a<ICubeGlobalListener> r101 = Cube.f257155a;
        Cube.k(r100.d());
    L5:
        LynxUILayer r102 = this.f262133e;
        if (r102 == null) goto L8;
        kp6.a<ICubeGlobalListener> r103 = Cube.f257155a;
        Cube.k(r102.d());
    L8:
        this.f262130b = null;
        MobEvent r104 = MobEvent.MOB_EVENT_CLOSE;
        Map<String, String> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action_type", this.f262136h)});
        r105.putAll(this.f262137i);
        Unit r106 = Unit.INSTANCE;
        e(r104, r105);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.c(this);
    }

    public final Map<String, Object> getLynxCommonData() {
        return this.f262138j;
    }

    public final PhotoPreviewModel getModel() {
        return this.f262129a;
    }

    @Subscribe
    public final void onEvent(PoiClickHeaderInfoEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = r100.f451330b;
        PhotoPreviewModel r102 = this.f262129a;
        if (r102 == null) goto L5;
        String r103 = r102.getTraceSessionId();
    L7:
        if (TextUtils.equals(r101, r103) == false) goto L13;
        long r104 = System.currentTimeMillis();
        JSONObject r105 = new JSONObject();
        String r106 = r100.f451330b;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r105.put(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r106);
        Unit r107 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("photo_bounce_view_show", r104, new d(r105)));
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        r100.getEventName();
        XReadableMap r101 = r100.getParams();
        if (r101 == null) goto L5;
        Map<String, Object> r102 = r101.toMap();
    L6:
        Objects.toString(r102);
        String r103 = r100.getEventName();
        if (Intrinsics.areEqual(r103, "photo_preview_close") == false) goto L64;
        XReadableMap r104 = r100.getParams();
        if (r104 == null) goto L62;
        String r105 = s.f(r104, "session_id", "");
        if (r105 == null) goto L86;
        PhotoPreviewModel r106 = this.f262129a;
        if (r106 == null) goto L16;
        r106.getTraceSessionId();
    L16:
        PhotoPreviewModel r107 = this.f262129a;
        if (r107 == null) goto L19;
        String r108 = r107.getTraceSessionId();
    L21:
        if (Intrinsics.areEqual(r105, r108) == true) goto L23;
        return;
    L23:
        XReadableMap r109 = r100.getParams();
        if (r109 == null) goto L27;
        String r110 = s.f(r109, "action_type", "");
        if (r110 == null) goto L27;
    L28:
        this.f262136h = r110;
        XReadableMap r111 = r100.getParams();
        if (r111 == null) goto L43;
        XReadableMap r112 = s.e(r111, "mob_params");
        if (r112 == null) goto L43;
        Map<String, Object> r113 = r112.toMap();
        if (r113 == null) goto L43;
        Iterator<Map.Entry<String, Object>> r114 = r113.entrySet().iterator();
    L36:
        if (r114.hasNext() == false) goto L43;
        Map.Entry<String, Object> r115 = r114.next();
        Object r116 = r115.getValue();
        if ((r116 instanceof String) == false) goto L40;
        String r117 = (String) r116;
    L41:
        if (r117 == null) goto L36;
        this.f262137i.put(r115.getKey(), r117);
        goto L36
    L40:
        r117 = null;
    L43:
        c r118 = this.f262130b;
        if (r118 == null) goto L87;
        Handler r119 = DialogLancet.resolveDialogHandler(r118);
        if (r119 != null) goto L48;
    L50:
        DialogLancet.beforeDialogDismiss(r118);
        r118.dismiss();     // Catch: Throwable -> L53 Exception -> L55
    L59:
        DialogLancet.afterDialogDismiss(r118);
        return;
    L55:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L53
        Throwable r120 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L53
        if (r120 == null) goto L59;
        com.bytedance.crash.d.d(r120, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r118);
        throw th;
    L48:
        if (Looper.myLooper() == r119.getLooper()) goto L50;
        r119.post(DialogLancet.createDismissRunnable(r118));
        return;
    L87:
        return;
    L27:
        r110 = "click_other";
        goto L28
    L19:
        r108 = null;
        goto L21
    L86:
        return;
    L62:
        return;
    L64:
        if (Intrinsics.areEqual(r103, "photo_preview_page_collapse_to_index") == false) goto L90;
        XReadableMap r121 = r100.getParams();
        if (r121 == null) goto L68;
        int r122 = r121.getInt("photo_index");
    L69:
        if (r122 < 0) goto L91;
        c r123 = this.f262130b;
        if (r123 == null) goto L92;
        RecyclerView r124 = r123.f552005b;
        if (r124 == null) goto L93;
        RecyclerView.LayoutManager r125 = r124.getLayoutManager();
        if (r125 == null) goto L94;
        r125.scrollToPosition(r122);
        return;
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L68:
        r122 = -1;
        goto L69
    L90:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L8:
        setVisibility(8);
        return;
    L4:
        if (r100 == 1) goto L8;
        if (r100 == 3) goto L8;
    }

    public void onTransitionEnd(int r100) {
        if (r100 != 0) goto L4;
    L6:
        setVisibility(0);
        return;
    L4:
        if (r100 == 2) goto L6;
    }

    public final void setModel(PhotoPreviewModel r100) {
        this.f262129a = r100;
    }

    public final void d(PhotoPreviewModel r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f262129a = r100;
        r101.f552007d = this;
        this.f262130b = r101;
        String r102 = r100.getScene();
        if (r102 != null) goto L6;
    L12:
        PhotoPreviewModel r103 = this.f262129a;
        if (r103 == null) goto L26;
        String r104 = r103.getScene();
        if (r104 == null) goto L26;
        if (this.f262133e != null) goto L26;
        int r105 = wx6.c.f561838a;
        Intrinsics.checkNotNullParameter(r104, "scene");
        LynxUILayer r106 = new LynxUILayer();
        View r107 = r106.c(this);
        if (r107 == null) goto L25;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, -2);
        r108.gravity = 80;
        addView(r107, r108);
        if (this.f262131c == true) goto L25;
        r107.setVisibility(8);
    L25:
        this.f262133e = r106;
    L26:
        EventCenter.registerJsEventSubscriber("photo_preview_close", this);
        EventCenter.registerJsEventSubscriber("photo_preview_page_collapse_to_index", this);
        this.f262135g = r100.getDefaultIndex();
        PhotoPreviewData r109 = r100.getData();
        if (r109 == null) goto L31;
        List<PoiPreviewPhotoModel> r110 = r109.getPhotos();
        if (r110 == null) goto L31;
        int r111 = r110.size();
    L32:
        int r112 = this.f262135g;
        if (r112 < 0) goto L36;
        if (r112 >= r111) goto L36;
        boolean r113 = true;
    L37:
        if (r113 == true) goto L40;
        this.f262135g = 0;
        return;
    L40:
        return;
    L36:
        r113 = false;
    L31:
        r111 = 0;
        goto L32
    L6:
        if (this.f262132d != null) goto L12;
        int r114 = wx6.c.f561838a;
        Intrinsics.checkNotNullParameter(r102, "scene");
        LynxUILayer r115 = new LynxUILayer();
        View r116 = r115.c(this);
        if (r116 == null) goto L11;
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, -2);
        r117.setMargins(0, 0, 0, 0);
        addView(r116, r117);
    L11:
        this.f262132d = r115;
        goto L12
    }

    public final void e(MobEvent r100, Map<String, String> r101) {
        JsonObject r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        PhotoPreviewModel r104 = this.f262129a;     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        JsonObject r105 = r104.getLogParams();     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        JsonElement r106 = r105.get(r100.getEvent());     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        JsonObject r107 = r106.getAsJsonObject();     // Catch: Throwable -> L13
    L11:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == false) goto L18;
        r108 = null;
    L18:
        JsonObject r109 = (JsonObject) r108;
        if (r109 != null) goto L59;
        return;
    L59:
        Object r110 = Result.m9449constructorimpl(r109.get(ReportCardMonitorPlugin.EVENT_NAME).getAsString());     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r110) == false) goto L28;
        r110 = null;
    L28:
        String r111 = (String) r110;
        if (r111 != null) goto L31;
    L34:
        boolean r112 = true;
    L35:
        if (r112 == false) goto L57;
        return;
    L57:
        Object r113 = Result.m9449constructorimpl(r109.getAsJsonObject("mob_params"));     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r113) == false) goto L44;
        r113 = null;
    L44:
        int r114 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r115 = new LinkedHashMap();
        wx6.a r116 = wx6.a.f561836a;
        wx6.a.a(r116, (JsonObject) r113, r115);
        PhotoPreviewModel r117 = this.f262129a;
        if (r117 == null) goto L53;
        PhotoPreviewData r118 = r117.getData();
        if (r118 == null) goto L53;
        List<PoiPreviewPhotoModel> r119 = r118.getPhotos();
        if (r119 == null) goto L53;
        PoiPreviewPhotoModel r120 = (PoiPreviewPhotoModel) CollectionsKt.getOrNull(r119, this.f262135g);
        if (r120 == null) goto L53;
        r102 = r120.getTrakerData();
    L53:
        wx6.a.a(r116, r102, r115);
        r115.putAll(r101);
        Unit r121 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r111, r115);
        return;
    L39:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L31:
        if (StringsKt.isBlank(r111) == true) goto L34;
        r112 = false;
    L23:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        r107 = null;
    L13:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
    }

    public void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
    }

    public void onPageSelected(int r110, boolean r111) {
        this.f262134f = this.f262135g;
        this.f262135g = r110;
        PhotoPreviewModel r100 = this.f262129a;
        String r101 = null;
        if (r100 == null) goto L9;
        PhotoPreviewData r102 = r100.getData();
        if (r102 == null) goto L9;
        List<PoiPreviewPhotoModel> r103 = r102.getPhotos();
        if (r103 == null) goto L9;
        PoiPreviewPhotoModel r104 = (PoiPreviewPhotoModel) CollectionsKt.getOrNull(r103, r110);
    L10:
        LynxUILayer r105 = this.f262132d;
        if (r105 == null) goto L16;
        if (r104 == null) goto L14;
        JsonObject r106 = r104.getTrakerData();
    L15:
        r105.f262345c = r106;
        goto L16
    L14:
        r106 = null;
    L16:
        LynxUILayer r107 = this.f262133e;
        if (r107 == null) goto L23;
        if (r104 == null) goto L20;
        JsonObject r108 = r104.getTrakerData();
    L21:
        r107.f262345c = r108;
        goto L23
    L20:
        r108 = null;
    L23:
        if (r111 == false) goto L67;
        if (r104 == null) goto L46;
        PoiPhotoPreviewLynxData r109 = r104.getHeaderContainerUpdate();
        if (r109 == null) goto L46;
        LynxUILayer r112 = this.f262132d;
        if (r112 == null) goto L46;
        PhotoPreviewModel r113 = this.f262129a;
        if (r113 == null) goto L36;
        PhotoPreviewData r114 = r113.getData();
        if (r114 == null) goto L36;
        PoiPhotoPreviewLynxData r115 = r114.getHeaderContainer();
        if (r115 == null) goto L36;
        String r116 = r115.getLynxUrl();
    L37:
        int r117 = wx6.b.f561837a;
        String[] r118 = new String[2];
        PhotoPreviewModel r119 = this.f262129a;
        if (r119 == null) goto L44;
        PhotoPreviewData r120 = r119.getData();
        if (r120 == null) goto L44;
        PoiPhotoPreviewLynxData r121 = r120.getHeaderContainer();
        if (r121 == null) goto L44;
        String r122 = r121.getRawData();
    L45:
        r118[0] = r122;
        r118[1] = r109.getRawData();
        r112.a(r116, wx6.b.a(r118), com.bytedance.locallife.common.utils.d.c(this.f262138j));
    L44:
        r122 = null;
    L36:
        r116 = null;
    L46:
        if (r104 == null) goto L144;
        PoiPhotoPreviewLynxData r123 = r104.getBottomContainerUpdate();
        if (r123 == null) goto L144;
        LynxUILayer r124 = this.f262133e;
        if (r124 == null) goto L144;
        PhotoPreviewModel r125 = this.f262129a;
        if (r125 == null) goto L58;
        PhotoPreviewData r126 = r125.getData();
        if (r126 == null) goto L58;
        PoiPhotoPreviewLynxData r127 = r126.getBottomContainer();
        if (r127 == null) goto L58;
        String r128 = r127.getLynxUrl();
    L59:
        int r129 = wx6.b.f561837a;
        String[] r130 = new String[2];
        PhotoPreviewModel r131 = this.f262129a;
        if (r131 == null) goto L66;
        PhotoPreviewData r132 = r131.getData();
        if (r132 == null) goto L66;
        PoiPhotoPreviewLynxData r133 = r132.getBottomContainer();
        if (r133 == null) goto L66;
        r101 = r133.getRawData();
    L66:
        r130[0] = r101;
        r130[1] = r123.getRawData();
        r124.a(r128, wx6.b.a(r130), com.bytedance.locallife.common.utils.d.c(this.f262138j));
    L58:
        r128 = null;
    L144:
        if (r104 != null) goto L146;
    L148:
        boolean r134 = false;
    L149:
        if (r134 == true) goto L154;
        e(MobEvent.MOB_EVENT_SHOW, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pic_rank", String.valueOf(r110))}));
        if (r104 == null) goto L154;
        r104.setHasMob(true);
    L154:
        if (r111 == false) goto L157;
        e(MobEvent.MOB_EVENT_SLIDE, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("from_index", String.valueOf(this.f262134f)), TuplesKt.to("to_index", String.valueOf(this.f262135g))}));
        return;
    L157:
        return;
    L146:
        if (r104.getHasMob() != true) goto L148;
        r134 = true;
        goto L149
    L67:
        LynxUILayer r135 = this.f262132d;
        if (r135 == null) goto L106;
        PhotoPreviewModel r136 = this.f262129a;
        if (r136 == null) goto L76;
        JsonObject r137 = r136.getLogParams();
        if (r137 == null) goto L76;
        JsonElement r138 = r137.get(MobEvent.MOB_EVENT_LYNX.getEvent());
        if (r138 == null) goto L76;
        JsonObject r139 = r138.getAsJsonObject();
    L77:
        r135.f262344b = r139;
        PhotoPreviewModel r140 = this.f262129a;
        if (r140 == null) goto L84;
        PhotoPreviewData r141 = r140.getData();
        if (r141 == null) goto L84;
        PoiPhotoPreviewLynxData r142 = r141.getHeaderContainer();
        if (r142 == null) goto L84;
        String r143 = r142.getLynxUrl();
    L85:
        int r144 = wx6.b.f561837a;
        String[] r145 = new String[2];
        PhotoPreviewModel r146 = this.f262129a;
        if (r146 == null) goto L92;
        PhotoPreviewData r147 = r146.getData();
        if (r147 == null) goto L92;
        PoiPhotoPreviewLynxData r148 = r147.getHeaderContainer();
        if (r148 == null) goto L92;
        String r149 = r148.getRawData();
    L93:
        r145[0] = r149;
        PhotoPreviewModel r150 = this.f262129a;
        if (r150 == null) goto L104;
        PhotoPreviewData r151 = r150.getData();
        if (r151 == null) goto L104;
        List<PoiPreviewPhotoModel> r152 = r151.getPhotos();
        if (r152 == null) goto L104;
        PoiPreviewPhotoModel r153 = (PoiPreviewPhotoModel) CollectionsKt.getOrNull(r152, r110);
        if (r153 == null) goto L104;
        PoiPhotoPreviewLynxData r154 = r153.getHeaderContainerUpdate();
        if (r154 == null) goto L104;
        String r155 = r154.getRawData();
    L105:
        r145[1] = r155;
        r135.a(r143, wx6.b.a(r145), com.bytedance.locallife.common.utils.d.c(this.f262138j));
    L104:
        r155 = null;
    L92:
        r149 = null;
    L84:
        r143 = null;
    L76:
        r139 = null;
    L106:
        LynxUILayer r156 = this.f262133e;
        if (r156 == null) goto L144;
        PhotoPreviewModel r157 = this.f262129a;
        if (r157 == null) goto L115;
        JsonObject r158 = r157.getLogParams();
        if (r158 == null) goto L115;
        JsonElement r159 = r158.get(MobEvent.MOB_EVENT_LYNX.getEvent());
        if (r159 == null) goto L115;
        JsonObject r160 = r159.getAsJsonObject();
    L116:
        r156.f262344b = r160;
        PhotoPreviewModel r161 = this.f262129a;
        if (r161 == null) goto L123;
        PhotoPreviewData r162 = r161.getData();
        if (r162 == null) goto L123;
        PoiPhotoPreviewLynxData r163 = r162.getBottomContainer();
        if (r163 == null) goto L123;
        String r164 = r163.getLynxUrl();
    L124:
        int r165 = wx6.b.f561837a;
        String[] r166 = new String[2];
        PhotoPreviewModel r167 = this.f262129a;
        if (r167 == null) goto L131;
        PhotoPreviewData r168 = r167.getData();
        if (r168 == null) goto L131;
        PoiPhotoPreviewLynxData r169 = r168.getBottomContainer();
        if (r169 == null) goto L131;
        String r170 = r169.getRawData();
    L132:
        r166[0] = r170;
        PhotoPreviewModel r171 = this.f262129a;
        if (r171 == null) goto L143;
        PhotoPreviewData r172 = r171.getData();
        if (r172 == null) goto L143;
        List<PoiPreviewPhotoModel> r173 = r172.getPhotos();
        if (r173 == null) goto L143;
        PoiPreviewPhotoModel r174 = (PoiPreviewPhotoModel) CollectionsKt.getOrNull(r173, r110);
        if (r174 == null) goto L143;
        PoiPhotoPreviewLynxData r175 = r174.getBottomContainerUpdate();
        if (r175 == null) goto L143;
        r101 = r175.getRawData();
    L143:
        r166[1] = r101;
        r156.a(r164, wx6.b.a(r166), com.bytedance.locallife.common.utils.d.c(this.f262138j));
    L131:
        r170 = null;
    L123:
        r164 = null;
    L115:
        r160 = null;
    L9:
        r104 = null;
        goto L10
    }

    public PhotoPreviewDecorateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262131c = true;
        this.f262136h = "click_other";
        this.f262137i = new LinkedHashMap();
        this.f262138j = new LinkedHashMap();
    }

    public /* synthetic */ PhotoPreviewDecorateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
