package com.bytedance.ee.bear.drive.view.preview.video;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.bytedance.ee.bear.drive.view.preview.video.player.w;
import com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.ResolutionPopupWindow;
import com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.VideoResolutionAdapter;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.CarUtils;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import ea5.b;
import ea5.d;
import ea5.e;
import ea5.f;
import ea5.g;
import ea5.h;
import ea5.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public class TTVideoView extends VideoView {
    public static final /* synthetic */ int U = 0;
    public final LinkedHashMap<String, String> Q;
    public com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a R;
    public com.bytedance.ee.bear.widgets.a S;
    public UDDialog T;

    private List<String> getSortResolutions() {
        ArrayList r100 = new ArrayList(this.Q.keySet());
        Collections.sort(r100, new b());     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        tt5.a.f("DRIVE_VideoPlayer", e, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VideoView.d r100 = this.f225521v;
        if (r100 != null) goto L5;
        String r101 = "null";
    L6:
        tt5.a.h("DRIVE_VideoPlayer", "TTVideoView onDetachedFromWindow, ext=" + r101);
        super.onDetachedFromWindow();
        return;
    L5:
        r101 = r100.f225530d.f225834b;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, ea5.a
    public final void play() {
        tt5.a.h("DRIVE_VideoPlayer", "tt video play");
        PreviewViewModel r100 = this.f225522w;
        if (r100 == null) goto L6;
        r100.liveInnerReportMsg().a(new a0(11));
    L6:
        if (this.f225505f != null) goto L9;
        tt5.a.d("DRIVE_VideoPlayer", "uri is null, stop play video");
        return;
    L9:
        y();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, m85.a
    public final void onRelease() {
        super.onRelease();
        com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a r100 = this.R;
        boolean r101 = true;
        if (r100 == null) goto L12;
        ResolutionPopupWindow r102 = r100.f225609d;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, popup window still alive, dismiss popup window");
        ResolutionPopupWindow r104 = this.R.f225609d;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);
        r104.dismiss();
        goto L12
    L7:
        if (r102.isShowing() == false) goto L9;
        r103 = true;
    L12:
        com.bytedance.ee.bear.widgets.a r105 = this.S;
        if (r105 == null) goto L22;
        LKUIDialog r106 = r105.f240138d;
        if (r106 != null) goto L17;
    L19:
        r101 = false;
    L20:
        if (r101 == false) goto L22;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, action sheet still alive, dismiss action sheet");
        this.S.n();
        goto L22
    L17:
        if (r106.isShowing() == false) goto L19;
    L22:
        UDDialog r107 = this.T;
        if (r107 != null) goto L25;
        return;
    L25:
        if (r107.isShowing() == false) goto L29;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, v2 action panel still alive, dismiss action panel");
        B(this.T);
        return;
    }

    public TTVideoView(Context r100) {
        super(r100);
        this.Q = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void A(final TTVideoView r110) {
        r110.getClass();
        tt5.a.h("DRIVE_VideoPlayer", "video view Resolution click, mCurrentPlayMode=" + r110.f225500a);
        boolean r100 = false;
        if (r110.m() == true) goto L5;
        Context r101 = r110.getContext();
        final com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a r102 = new com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a(r101, r110.f225519t);
        if (r110.o() == true) goto L35;
    L37:
        int r103 = r110.Q.size();
        ResolutionPopupWindow r104 = new ResolutionPopupWindow();
        r102.f225609d = r104;
        r104.setFocusable(true);
        r102.f225609d.setContentView(r102.f225607b);
        int r105 = Math.max(r103 * r101.getResources().getDimensionPixelSize(R.dimen.space_kit_len_56), r101.getResources().getDimensionPixelSize(R.dimen.drive_video_resolution_popup_window_width));
        r102.f225609d.setHeight(r105);
        r102.f225609d.setWidth(r105);
        r102.f225607b.findViewById(R.id.drive_audio_view_root).setOnClickListener(new ja5.b(r102));
        r102.f225611f = r100;
        if (r100 == false) goto L40;
        r102.f225607b.setRotation(90.0f);
    L40:
        List<String> r106 = r110.getSortResolutions();
        h r107 = new h(r110, r102);
        VideoResolutionAdapter r108 = r102.f225608c;
        if (hu5.a.d(r106) == false) goto L43;
        tt5.a.d("DRIVE_VideoPlayer", "resolution keys list is empty or null");
        ArrayList r109 = new ArrayList();
    L56:
        r108.getClass();
        if (hu5.a.d(r109) == false) goto L59;
        tt5.a.d("DRIVE_VideoPlayer", "resolution list is empty or null");
    L60:
        r102.f225608c.f225601c = r107;
        ResolutionPopupWindow r111 = r102.f225609d;
        if (r111 == null) goto L63;
        r111.setOnDismissListener(new i(r110));
    L63:
        r110.R = r102;
        if (r102.f225609d != null) goto L67;
        tt5.a.d("DRIVE_VideoPlayer", "show popup window failed, mPopupWindow == null");
    L82:
        r110.setWindowAlpha(0.5f);
        return;
    L67:
        if (r102.f225611f == false) goto L69;
        int r112 = 83;
    L70:
        ResolutionPopupWindow r113 = r102.f225609d;
        int r114 = r102.f225610e.getResources().getDimensionPixelSize(R.dimen.drive_video_resolution_popup_window_x_position);
        int r115 = r102.f225610e.getResources().getDimensionPixelSize(R.dimen.drive_video_resolution_popup_window_y_position);
        if (PopupWindowLancet.hasSubWindowToken(r110) == true) goto L82;
        if ((r113 instanceof PopupWindow) == true) goto L76;
    L78:
        OverlaySource r116 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r113, r110, r116, r112, r114, r115) == true) goto L82;
        r113.showAtLocation(r110, r112, r114, r115);
        PopupWindowLancet.trackAfterShow(r113, r116, r110);
        goto L82
    L76:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r113) == false) goto L78;
        r113.showAtLocation(r110, r112, r114, r115);
        goto L82
    L69:
        r112 = 85;
        goto L70
    L59:
        ((ArrayList) r108.f225599a).clear();
        ((ArrayList) r108.f225599a).addAll(r109);
        r108.notifyDataSetChanged();
        goto L60
    L43:
        Collections.reverse(r106);
        ArrayList r117 = new ArrayList(r106.size());
        Iterator<String> r118 = r106.iterator();
    L45:
        if (r118.hasNext() == false) goto L55;
        String r119 = r118.next();
        if (TextUtils.isEmpty(r119) == false) goto L49;
    L53:
        String r120 = r119;
    L54:
        r117.add(new ja5.a(r119, r120, TextUtils.equals(r102.f225606a, r119)));
        goto L45
    L49:
        if (r119.contains("_") == false) goto L53;
        tt5.a.h("DRIVE_VideoPlayer", "get resolution");
        Pattern r121 = c.f569228a;
        String[] r122 = r119.split("_");
        if (r122 == null) goto L53;
        r120 = r122[r122.length - 1];
        goto L54
    L55:
        r109 = r117;
        goto L56
    L35:
        if (r110.m() == false) goto L37;
        r100 = true;
        goto L37
    L5:
        if (r110.K == false) goto L24;
        final List<String> r123 = r110.getSortResolutions();
        Collections.reverse(r123);
        final ArrayList r124 = new ArrayList(r123.size());
        Iterator<String> r125 = r123.iterator();
    L8:
        if (r125.hasNext() == false) goto L10;
        r124.add(D(r125.next()));
        goto L8
    L10:
        Dialog r126 = null;
        View r127 = View.inflate(r110.getContext(), R.layout.drive_video_resolution_action_footer_v2, null);
        final UDDialog r128 = ((UDActionPanelBuilder) ((UDActionPanelBuilder) ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(r110.getContext()).items(r124).rootLayoutRes(R.layout.drive_video_resolution_action_root_v2)).itemLayout(R.layout.drive_video_resolution_action_item_v2).itemClickListener(new d(r110, r123, r124)).marginInDp(0)).maskAlpha(0.6f)).adapter(new g(r110, r110.getContext(), r123)).footerLayout(r127)).build();     // Catch: RuntimeException -> L18
        r127.findViewById(R.id.drive_video_resolution_action_cancel).setOnClickListener(new e(r128));     // Catch: RuntimeException -> L18
        if (DialogLancet.shouldBlockDialogShow(r128) == false) goto L85;
        DialogLancet.handleBlockedDialogShow(r128);     // Catch: RuntimeException -> L18
    L17:
        r110.T = r128;
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r128);
        tt5.a.h("DRIVE_VideoPlayer", "showResolutionActionPanelV2 success, optionCount=" + r123.size());
        return;
    L85:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L16:
        DialogLancet.beforeDialogShow(r128);     // Catch: RuntimeException -> L18
        r128.show();     // Catch: RuntimeException -> L18
        DialogLancet.afterDialogShow(r128);     // Catch: RuntimeException -> L18
    L18:
        e = move-exception;
        if (0 != 0) goto L21;
    L23:
        tt5.a.e("DRIVE_VideoPlayer", "showResolutionActionPanelV2 failed, optionCount=" + r123.size(), e, false);
        return;
    L21:
        if (r126.isShowing() == false) goto L23;
        B(null);
        goto L23
    L24:
        com.bytedance.ee.bear.widgets.a r129 = new com.bytedance.ee.bear.widgets.a(r110.getContext());
        List<String> r130 = r110.getSortResolutions();
        Collections.reverse(r130);
        Iterator<String> r131 = r130.iterator();
    L26:
        if (r131.hasNext() == false) goto L31;
        final String r132 = r131.next();
        final String r133 = D(r132);
        View.OnClickListener r134 = new f(r110, r132, r133);
        if (TextUtils.equals(r110.f225519t, r132) == true) goto L29;
        r129.g(r133, r134);
        goto L26
    L29:
        Resources r135 = r110.getContext().getResources();
        Drawable r136 = r135.getDrawable(R.drawable.drive_video_checkmark);
        r136.setTint(r135.getColor(R.color.primary_fill_default));
        int r137 = r110.getContext().getResources().getColor(R.color.primary_fill_default);
        cp5.b r138 = new cp5.b();
        r138.f464689a = r133;
        r138.f464692d = false;
        r138.f464693e = r136;
        r138.f464694f = r134;
        r138.f464691c = true;
        r138.f464690b = r137;
        r138.f464695g = true;
        r138.f464696h = 1.0f;
        r138.f464697i = true;
        r129.f(r138);
        goto L26
    L31:
        r129.a();
        r110.S = r129;
        LKUIDialog r139 = r129.l();
        r110.S.q();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r139);
    }

    public static void B(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static /* synthetic */ void C(TTVideoView r100) {
        r100.setWindowAlpha(1.0f);
    }

    public static String D(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.contains("_") == false) goto L11;
        tt5.a.h("DRIVE_VideoPlayer", "get resolution");
        Pattern r101 = c.f569228a;
        String[] r102 = r100.split("_");
        if (r102 != null) goto L9;
        return r100;
    L9:
        return r102[r102.length - 1];
    L11:
        return r100;
    }

    private void setWindowAlpha(float r100) {
        if (CarUtils.a() == false) goto L6;
        return;
    L6:
        if ((getContext() instanceof Activity) == true) goto L8;
        return;
    L8:
        if (com.bytedance.ee.util.ui.b.b(getContext()) == false) goto L12;
        WindowManager.LayoutParams r101 = ((Activity) getContext()).getWindow().getAttributes();
        r101.alpha = r100;
        ((Activity) getContext()).getWindow().setAttributes(r101);
        return;
    }

    public final void F(String r100) {
        if (r100 == null) goto L12;
        w r101 = this.f225516q;
        if (r101 == null) goto L12;
        long r102 = r101.getCurrentPosition();
        tt5.a.h("DRIVE_VideoPlayer", "switchVideoResolution... currentPosition=" + r102);
        w r103 = this.f225516q;
        r103.f225561g = "";
        r103.b(UriProtector.parse(r100));
        setCustomHeaders(((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).oc(r100));
        if (r102 <= 0) goto L10;
        this.f225516q.setStartTime((int) r102);
    L10:
        y();
        return;
    L12:
        tt5.a.h("DRIVE_VideoPlayer", "uri == null switchVideoResolution failed");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView
    public final void i(VideoView.d r100) {
        super.i(r100);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView
    public final void k(VideoView.d r100) {
        this.Q.clear();
        this.Q.putAll(r100.f225529c);
        VideoPlayerControllerView r101 = this.f225504e;
        if (this.Q.size() <= 1) goto L5;
        boolean r102 = true;
    L6:
        r101.setResolutionVisible(r102);
        tt5.a.h("DRIVE_VideoPlayer", "preViewUrls.size() " + this.Q.size());
        if (this.Q.size() <= 1) goto L18;
        LinkedHashMap<String, String> r103 = this.Q;
        if (r103 != null) goto L11;
    L16:
        String r104 = "";
    L17:
        this.f225520u = r104;
        this.f225519t = r104;
        this.f225504e.setResolution(D(r104));
        goto L18
    L11:
        if (r103.isEmpty() == true) goto L16;
        r104 = "480p";
        if (r103.containsKey("480p") == true) goto L17;
        r104 = r103.keySet().iterator().next();
    L18:
        this.f225504e.setResolutionClickListener(new ea5.c(this));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public TTVideoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.Q = new LinkedHashMap();
    }

    public final void E(String r100, String r101) {
        if (TextUtils.equals(this.f225519t, r100) == false) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put(GearStrategyConsts.EV_QUALITY, this.f225519t);
        this.f225522w.liveInnerReportMsg().a(new a0(28, r102));
        this.f225504e.setResolution(r101);
        F(this.Q.get(r100));
        this.f225519t = r100;
    }

    public TTVideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.Q = new LinkedHashMap();
    }
}
