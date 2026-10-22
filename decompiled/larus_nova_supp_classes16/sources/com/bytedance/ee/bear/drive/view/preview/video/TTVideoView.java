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
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.drive.view.preview.video.player.w;
import com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.ResolutionPopupWindow;
import com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.VideoResolutionAdapter;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.CarUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TTVideoView extends VideoView {
    public static final /* synthetic */ int U = 0;
    public final LinkedHashMap<String, String> Q;
    public com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a R;
    public com.bytedance.ee.bear.widgets.a S;
    public UDDialog T;

    private List<String> getSortResolutions() {
        ArrayList r0 = new ArrayList(this.Q.keySet());
        Collections.sort(r0, new b());     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.f("DRIVE_VideoPlayer", e, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VideoView.d r0 = this.v;
        if (r0 != null) goto L5;
        String r1 = "null";
    L6:
        tt5.a.h("DRIVE_VideoPlayer", "TTVideoView onDetachedFromWindow, ext=" + r1);
        super.onDetachedFromWindow();
        return;
    L5:
        r1 = r0.d.b;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, ea5.a
    public final void play() {
        tt5.a.h("DRIVE_VideoPlayer", "tt video play");
        PreviewViewModel r1 = this.w;
        if (r1 == null) goto L6;
        r1.liveInnerReportMsg().a(new a0(11));
    L6:
        if (this.f != null) goto L9;
        tt5.a.d("DRIVE_VideoPlayer", "uri is null, stop play video");
        return;
    L9:
        y();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView, m85.a
    public final void onRelease() {
        super.onRelease();
        com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a r0 = this.R;
        boolean r1 = true;
        if (r0 == null) goto L12;
        ResolutionPopupWindow r2 = r0.d;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, popup window still alive, dismiss popup window");
        ResolutionPopupWindow r4 = this.R.d;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
        goto L12
    L7:
        if (r2.isShowing() == false) goto L9;
        r3 = true;
    L12:
        com.bytedance.ee.bear.widgets.a r5 = this.S;
        if (r5 == null) goto L22;
        LKUIDialog r6 = r5.d;
        if (r6 != null) goto L17;
    L19:
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, action sheet still alive, dismiss action sheet");
        this.S.n();
        goto L22
    L17:
        if (r6.isShowing() == false) goto L19;
    L22:
        UDDialog r7 = this.T;
        if (r7 != null) goto L25;
        return;
    L25:
        if (r7.isShowing() == false) goto L29;
        tt5.a.h("DRIVE_VideoPlayer", "activity is destroyed, v2 action panel still alive, dismiss action panel");
        B(this.T);
        return;
    }

    public TTVideoView(Context r1) {
        super(r1);
        this.Q = new LinkedHashMap();
    }

    public static void A(final TTVideoView r11) {
        r11.getClass();
        tt5.a.h("DRIVE_VideoPlayer", "video view Resolution click, mCurrentPlayMode=" + r11.a);
        boolean r3 = false;
        if (r11.m() == true) goto L5;
        Context r4 = r11.getContext();
        final com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a r0 = new com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow.a(r4, r11.t);
        if (r11.o() == true) goto L35;
    L37:
        int r5 = r11.Q.size();
        ResolutionPopupWindow r6 = new ResolutionPopupWindow();
        r0.d = r6;
        r6.setFocusable(true);
        r0.d.setContentView(r0.b);
        int r2 = Math.max(r5 * r4.getResources().getDimensionPixelSize(2131168354), r4.getResources().getDimensionPixelSize(2131166339));
        r0.d.setHeight(r2);
        r0.d.setWidth(r2);
        r0.b.findViewById(2131370250).setOnClickListener(new ja5.b(r0));
        r0.f = r3;
        if (r3 == false) goto L40;
        r0.b.setRotation(90.0f);
    L40:
        List<String> r7 = r11.getSortResolutions();
        h r8 = new h(r11, r0);
        VideoResolutionAdapter r9 = r0.c;
        if (hu5.a.d(r7) == false) goto L43;
        tt5.a.d("DRIVE_VideoPlayer", "resolution keys list is empty or null");
        ArrayList r10 = new ArrayList();
    L56:
        r9.getClass();
        if (hu5.a.d(r10) == false) goto L59;
        tt5.a.d("DRIVE_VideoPlayer", "resolution list is empty or null");
    L60:
        r0.c.c = r8;
        ResolutionPopupWindow r12 = r0.d;
        if (r12 == null) goto L63;
        r12.setOnDismissListener(new i(r11));
    L63:
        r11.R = r0;
        if (r0.d != null) goto L67;
        tt5.a.d("DRIVE_VideoPlayer", "show popup window failed, mPopupWindow == null");
    L82:
        r11.setWindowAlpha(0.5f);
        return;
    L67:
        if (r0.f == false) goto L69;
        int r1 = 83;
    L70:
        ResolutionPopupWindow r13 = r0.d;
        int r14 = r0.e.getResources().getDimensionPixelSize(2131166340);
        int r16 = r0.e.getResources().getDimensionPixelSize(2131166341);
        if (PopupWindowLancet.hasSubWindowToken(r11) == true) goto L82;
        if ((r13 instanceof PopupWindow) == true) goto L76;
    L78:
        OverlaySource r17 = PopupWindowLancet.resolveSource(r11);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r13, r11, r17, r1, r14, r16) == true) goto L82;
        r13.showAtLocation(r11, r1, r14, r16);
        PopupWindowLancet.trackAfterShow(r13, r17, r11);
        goto L82
    L76:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r13) == false) goto L78;
        r13.showAtLocation(r11, r1, r14, r16);
        goto L82
    L69:
        r1 = 85;
        goto L70
    L59:
        ((ArrayList) r9.a).clear();
        ((ArrayList) r9.a).addAll(r10);
        r9.notifyDataSetChanged();
        goto L60
    L43:
        Collections.reverse(r7);
        ArrayList r18 = new ArrayList(r7.size());
        Iterator<String> r19 = r7.iterator();
    L45:
        if (r19.hasNext() == false) goto L55;
        String r20 = r19.next();
        if (TextUtils.isEmpty(r20) == false) goto L49;
    L53:
        String r21 = r20;
    L54:
        r18.add(new ja5.a(r20, r21, TextUtils.equals(r0.a, r20)));
        goto L45
    L49:
        if (r20.contains(OfflineDoc.DASH_DELIMITER) == false) goto L53;
        tt5.a.h("DRIVE_VideoPlayer", "get resolution");
        Pattern r22 = c.a;
        String[] r23 = r20.split(OfflineDoc.DASH_DELIMITER);
        if (r23 == null) goto L53;
        r21 = r23[r23.length - 1];
        goto L54
    L55:
        r10 = r18;
        goto L56
    L35:
        if (r11.m() == false) goto L37;
        r3 = true;
        goto L37
    L5:
        if (r11.K == false) goto L24;
        final List<String> r24 = r11.getSortResolutions();
        Collections.reverse(r24);
        final ArrayList r26 = new ArrayList(r24.size());
        Iterator<String> r27 = r24.iterator();
    L8:
        if (r27.hasNext() == false) goto L10;
        r26.add(D(r27.next()));
        goto L8
    L10:
        Dialog r28 = null;
        View r29 = View.inflate(r11.getContext(), 2131560247, null);
        final UDDialog r30 = new UDActionPanelBuilder(r11.getContext()).items(r26).rootLayoutRes(2131560249).itemLayout(2131560248).itemClickListener(new d(r11, r24, r26)).marginInDp(0).maskAlpha(0.6f).adapter(new g(r11, r11.getContext(), r24)).footerLayout(r29).build();     // Catch: RuntimeException -> L18
        r29.findViewById(2131370347).setOnClickListener(new e(r30));     // Catch: RuntimeException -> L18
        if (DialogLancet.shouldBlockDialogShow(r30) == false) goto L85;
        DialogLancet.handleBlockedDialogShow(r30);     // Catch: RuntimeException -> L18
    L17:
        r11.T = r30;
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r30);
        tt5.a.h("DRIVE_VideoPlayer", "showResolutionActionPanelV2 success, optionCount=" + r24.size());
        return;
    L85:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L16:
        DialogLancet.beforeDialogShow(r30);     // Catch: RuntimeException -> L18
        r30.show();     // Catch: RuntimeException -> L18
        DialogLancet.afterDialogShow(r30);     // Catch: RuntimeException -> L18
    L18:
        e = move-exception;
        if (0 != 0) goto L21;
    L23:
        tt5.a.e("DRIVE_VideoPlayer", "showResolutionActionPanelV2 failed, optionCount=" + r24.size(), e, false);
        return;
    L21:
        if (r28.isShowing() == false) goto L23;
        B(null);
        goto L23
    L24:
        com.bytedance.ee.bear.widgets.a r31 = new com.bytedance.ee.bear.widgets.a(r11.getContext());
        List<String> r32 = r11.getSortResolutions();
        Collections.reverse(r32);
        Iterator<String> r33 = r32.iterator();
    L26:
        if (r33.hasNext() == false) goto L31;
        final String r34 = r33.next();
        final String r36 = D(r34);
        View.OnClickListener r37 = new f(r11, r34, r36);
        if (TextUtils.equals(r11.t, r34) == true) goto L29;
        r31.g(r36, r37);
        goto L26
    L29:
        Resources r38 = r11.getContext().getResources();
        Drawable r39 = r38.getDrawable(2131234041);
        r39.setTint(r38.getColor(2131105548));
        int r40 = r11.getContext().getResources().getColor(2131105548);
        cp5.b r41 = new cp5.b();
        r41.a = r36;
        r41.d = false;
        r41.e = r39;
        r41.f = r37;
        r41.c = true;
        r41.b = r40;
        r41.g = true;
        r41.h = 1.0f;
        r41.i = true;
        r31.f(r41);
        goto L26
    L31:
        r31.a();
        r11.S = r31;
        LKUIDialog r42 = r31.l();
        r11.S.q();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r42);
    }

    public static void B(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static /* synthetic */ void C(TTVideoView r1) {
        r1.setWindowAlpha(1.0f);
    }

    public static String D(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r3;
    L5:
        if (r3.contains(OfflineDoc.DASH_DELIMITER) == false) goto L11;
        tt5.a.h("DRIVE_VideoPlayer", "get resolution");
        Pattern r1 = c.a;
        String[] r0 = r3.split(OfflineDoc.DASH_DELIMITER);
        if (r0 != null) goto L9;
        return r3;
    L9:
        return r0[r0.length - 1];
    L11:
        return r3;
    }

    private void setWindowAlpha(float r2) {
        if (CarUtils.a() == false) goto L6;
        return;
    L6:
        if ((getContext() instanceof Activity) == true) goto L8;
        return;
    L8:
        if (com.bytedance.ee.util.ui.b.b(getContext()) == false) goto L12;
        WindowManager.LayoutParams r0 = ((Activity) getContext()).getWindow().getAttributes();
        r0.alpha = r2;
        ((Activity) getContext()).getWindow().setAttributes(r0);
        return;
    }

    public final void F(String r6) {
        if (r6 == null) goto L12;
        w r1 = this.q;
        if (r1 == null) goto L12;
        long r2 = r1.getCurrentPosition();
        tt5.a.h("DRIVE_VideoPlayer", "switchVideoResolution... currentPosition=" + r2);
        w r0 = this.q;
        r0.g = "";
        r0.b(UriProtector.parse(r6));
        setCustomHeaders(((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).oc(r6));
        if (r2 <= 0) goto L10;
        this.q.setStartTime((int) r2);
    L10:
        y();
        return;
    L12:
        tt5.a.h("DRIVE_VideoPlayer", "uri == null switchVideoResolution failed");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView
    public final void i(VideoView.d r1) {
        super.i(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.VideoView
    public final void k(VideoView.d r3) {
        this.Q.clear();
        this.Q.putAll(r3.c);
        VideoPlayerControllerView r4 = this.e;
        if (this.Q.size() <= 1) goto L5;
        boolean r0 = true;
    L6:
        r4.setResolutionVisible(r0);
        tt5.a.h("DRIVE_VideoPlayer", "preViewUrls.size() " + this.Q.size());
        if (this.Q.size() <= 1) goto L18;
        LinkedHashMap<String, String> r5 = this.Q;
        if (r5 != null) goto L11;
    L16:
        String r1 = "";
    L17:
        this.u = r1;
        this.t = r1;
        this.e.setResolution(D(r1));
        goto L18
    L11:
        if (r5.isEmpty() == true) goto L16;
        r1 = "480p";
        if (r5.containsKey("480p") == true) goto L17;
        r1 = r5.keySet().iterator().next();
    L18:
        this.e.setResolutionClickListener(new ea5.c(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public TTVideoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.Q = new LinkedHashMap();
    }

    public final void E(String r5, String r6) {
        if (TextUtils.equals(this.t, r5) == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("quality", this.t);
        this.w.liveInnerReportMsg().a(new a0(28, r0));
        this.e.setResolution(r6);
        F(this.Q.get(r5));
        this.t = r5;
    }

    public TTVideoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.Q = new LinkedHashMap();
    }
}
