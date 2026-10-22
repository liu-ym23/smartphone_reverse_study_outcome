package com.larus.uaigc.chat.block.create;

import android.graphics.Bitmap;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.w0;
import fn8.s;
import kc8.a0;
import kc8.d0;
import kc8.s0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.a4;
import tx9.c2;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
public final class RichMediaCreationVideoPlaybackController implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoPlayView f370488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Message f370489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CreationItem f370490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f370491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kc8.q f370492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CoroutineScope f370493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f370494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f370495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f370496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f370497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f370498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f370499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f370500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f370501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RichMediaCreationVideoPlaybackController$appBackgroundListener$1 f370502o;

    @Override // kc8.d0
    public final s0 a() {
        VideoPlayView r100 = this.f370488a;
        if (r100 != null) goto L6;
        return null;
    L6:
        VideoPlayView.z(r100, 0, 2);
        return new s0(r100.getCurrentPlaybackTime(), r100.getMVideoView().getBitmap());
    }

    public final kh8.a c() {
        kc8.q r100 = this.f370492e;
        if (r100 == null) goto L7;
        rd8.b r101 = r100.f502552g;
        if (r101 == null) goto L7;
        return r101.q3();
    L7:
        return null;
    }

    @Override // kc8.d0
    public final void recycle() {
        Job r100 = this.f370497j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f370497j = null;
        Job r101 = this.f370498k;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f370498k = null;
        String r102 = this.f370495h;
        if (r102 == null) goto L13;
        kh8.a r103 = c();
        if (r103 == null) goto L13;
        r103.c(r102);
    L13:
        this.f370495h = null;
        VideoPlayView r104 = this.f370488a;
        if (r104 == null) goto L16;
        r104.f327977d = null;
        VideoPlayView.z(r104, 0, 2);
    L16:
        String r105 = this.f370496i;
        if (r105 == null) goto L19;
        IAIChatUgcAIGCService.f365905a.L().b(r105);
    L19:
        this.f370496i = null;
        if (this.f370501n == false) goto L22;
        AppHost.f326268a.a().c(this.f370502o);
        this.f370501n = false;
    L22:
        this.f370488a = null;
        this.f370489b = null;
        this.f370490c = null;
        this.f370492e = null;
        this.f370493f = null;
        this.f370494g = null;
        this.f370499l = false;
        this.f370500m = false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.chat.block.create.RichMediaCreationVideoPlaybackController$appBackgroundListener$1] */
    public RichMediaCreationVideoPlaybackController() {
        this.f370502o = new RichMediaCreationVideoPlaybackController$appBackgroundListener$1(this);
    }

    public final void d(String r110, boolean r210) {
        Message r100 = this.f370489b;
        if (r100 != null) goto L5;
        return;
    L5:
        CreationItem r101 = this.f370490c;
        if (r101 != null) goto L8;
        return;
    L8:
        VideoPlayView r102 = this.f370488a;
        if (r102 != null) goto L11;
        return;
    L11:
        String r103 = this.f370495h;
        String r104 = r100.getMessageId();
        kc8.q r105 = this.f370492e;
        if (r105 == null) goto L16;
        a0 r106 = r105.f502549d;
        if (r106 == null) goto L16;
        String r107 = r106.getBotId();
    L17:
        String r108 = r107;
        IAIChatControlTraceService.Companion r109 = IAIChatControlTraceService.f365889a;
        String r111 = r109.bb(r109.gb());
        long r112 = x19.a.b(r102, r210);
        String r113 = r101.f346620id;
        boolean r114 = a4.a(r110);
        boolean r115 = a4.b(AppHost.f326268a.getApplication(), Boolean.valueOf(r102.f327998s));
        JSONObject r116 = new JSONObject();
        c2.a(r116, this.f370494g);
        a4.m(r103, r104, r108, Boolean.TRUE, r111, Long.valueOf(r112), Boolean.valueOf(r210), "0", "chat", r113, r116, Boolean.valueOf(r114), Boolean.valueOf(r115), 16762880);
        return;
    L16:
        r107 = null;
        goto L17
    }

    @Override // kc8.d0
    public final void b(VideoPlayView r210, Message r211, CreationItem r212, int r213, kc8.q r214, CoroutineScope r215, JSONObject r216, fn8.r r310, final s r311) {
        Intrinsics.checkNotNullParameter(r210, "playbackView");
        Intrinsics.checkNotNullParameter(r211, "message");
        Intrinsics.checkNotNullParameter(r212, "clickItem");
        Intrinsics.checkNotNullParameter(r215, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r310, "onPlaybackReadyChanged");
        Intrinsics.checkNotNullParameter(r311, "onPlayingChanged");
        recycle();
        VideoData r100 = r212.video;
        if (r100 != null) goto L6;
        r310.invoke(Boolean.FALSE);
        return;
    L6:
        String r101 = r100.vid;
        if (r101 != null) goto L9;
    L59:
        r310.invoke(Boolean.FALSE);
        return;
    L9:
        if ((!StringsKt.isBlank(r101)) == false) goto L11;
        String r102 = r101;
    L12:
        if (r102 == null) goto L59;
        CreationNoWatermarkManager r103 = CreationNoWatermarkManager.f373832a;
        String r104 = r100.vid;
        nr9.g r105 = bz9.a.l(r100);
        Cover r106 = r100.cover;
        if (r106 == null) goto L17;
        String r107 = r106.key;
    L18:
        nr9.g r108 = r103.c0(r104, r105, r107);
        if (r108 != null) goto L21;
        r108 = bz9.a.l(r100);
    L21:
        final nr9.g r109 = r108;
        this.f370488a = r210;
        this.f370489b = r211;
        this.f370490c = r212;
        this.f370491d = r213;
        this.f370492e = r214;
        this.f370493f = r215;
        this.f370494g = r216;
        this.f370495h = r102;
        int r110 = hz9.a.f487718a;
        this.f370496i = hz9.a.a(r211, r212.f346620id, false, String.valueOf(r213));
        this.f370499l = false;
        this.f370500m = false;
        r210.K();
        r210.setIsMuted(true);
        w0.e(r210, i5.r0());
        r210.setAlpha(1.0f);
        r210.setForceRefreshSurface(true);
        r210.setShowCoverWhenPause(true);
        r210.setBanInnerDismiss(true);
        r210.setIgnoreClick(true);
        r210.setEnableCreationPreviewCoverLoadOpt(true);
        r210.E();
        nr9.f r111 = r109.f520263g;
        if (r111 == null) goto L24;
        String r112 = r111.f520251a;
    L25:
        if (r111 == null) goto L27;
        String r113 = r111.f520252b;
    L28:
        if (r111 == null) goto L30;
        String r114 = r111.f520253c;
    L31:
        if (r111 == null) goto L33;
        Integer r115 = r111.f520254d;
    L34:
        if (r111 == null) goto L36;
        Integer r116 = r111.f520255e;
    L37:
        if (r111 == null) goto L39;
        Bitmap r117 = r111.f520256f;
    L40:
        String r217 = r102;
        VideoPlayView.p(r210, r112, r113, r114, r115, r116, r117, null, r211.getMessageId(), 64);
        r210.i(false);
        String r118 = this.f370496i;
        if (r118 != null) goto L43;
        IVideoController r119 = null;
    L44:
        if (r119 == null) goto L46;
        r119.C(true);
        IVideoController r120 = r119;
    L47:
        VideoPlayView.e(r210, r120, r20.f520258b, r20.f520264h, r20.f520259c, null, null, 48);
        r210.f327977d = new r(this, r311, r109);
        kh8.a r121 = c();
        if (r121 == null) goto L50;
        r121.d(r217, r210);
    L50:
        CoroutineScope r122 = this.f370493f;
        if (r122 != null) goto L53;
        Continuation r123 = null;
    L55:
        if (this.f370501n == true) goto L57;
        AppHost.f326268a.a().j(this.f370502o);
        this.f370501n = true;
    L57:
        r310.invoke(Boolean.TRUE);
        BuildersKt.launch$default(r215, null, null, new RichMediaCreationVideoPlaybackController$bind$2(this, r123), 3, null);
        return;
    L53:
        r123 = null;
        this.f370497j = BuildersKt.launch$default(r122, null, null, new RichMediaCreationVideoPlaybackController$bindPlayObservers$1(this, r217, null), 3, null);
        this.f370498k = BuildersKt.launch$default(r122, null, null, new RichMediaCreationVideoPlaybackController$bindPlayObservers$2(this, r217, null), 3, null);
        goto L55
    L46:
        r120 = null;
        goto L47
    L43:
        r119 = IAIChatUgcAIGCService.f365905a.L().a(r118, "ugc_video", "message_card");
        goto L44
    L39:
        r117 = null;
        goto L40
    L36:
        r116 = null;
        goto L37
    L33:
        r115 = null;
        goto L34
    L30:
        r114 = null;
        goto L31
    L27:
        r113 = null;
        goto L28
    L24:
        r112 = null;
        goto L25
    L17:
        r107 = null;
        goto L18
    L11:
        r102 = null;
        goto L12
    }
}
