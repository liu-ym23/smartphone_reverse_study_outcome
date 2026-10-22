package com.larus.uaigc.chat.block.widget.video;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
public final class LocalVideoSuccessViewBinder implements cz9.g, com.larus.uaigc.chat.block.widget.video.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f370725l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.uaigc.chat.block.widget.video.a f370726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f370727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f370728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f370729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f370730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cz9.n f370731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f370732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f370733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f370734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f370735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LocalVideoSuccessViewBinder$appBackgroundListener$1 f370736k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final Function2<cz9.b, View, Unit> a() {
        return this.f370726a.a();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final Function2<cz9.b, iy9.b, Unit> b() {
        return this.f370726a.b();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final CoroutineScope c() {
        return this.f370726a.c();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
        return this.f370726a.d0();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final kc8.q g() {
        return this.f370726a.g();
    }

    @Override // cz9.g
    public final void updateSize(int r100, int r101) {
    }

    public final IVideoController e() {
        ps8.a r100 = IAIChatUgcAIGCService.f365905a.L();
        int r101 = hz9.a.f487718a;
        cz9.n r102 = this.f370731f;
        String r103 = null;
        if (r102 == null) goto L5;
        Message r104 = r102.f466123e;
    L6:
        if (r102 == null) goto L10;
        CreationItem r105 = r102.f466122d;
        if (r105 == null) goto L10;
        String r106 = r105.f346620id;
    L11:
        if (r102 == null) goto L14;
        r103 = Integer.valueOf(r102.f466124f).toString();
    L14:
        return r100.a(hz9.a.a(r104, r106, true, r103), "ugc_video", "immersive_preview");
    L10:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // cz9.g
    public final void f() {
        if (this.f370735j == false) goto L5;
        AppHost.f326268a.a().c(this.f370736k);
        this.f370735j = false;
    L5:
        Job r100 = this.f370729d;
        String r101 = null;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.f370729d = null;
        Job r102 = this.f370730e;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f370730e = null;
        String r103 = this.f370733h;
        if (r103 == null) goto L16;
        kh8.a r104 = d();
        if (r104 == null) goto L16;
        r104.c(r103);
    L16:
        this.f370733h = null;
        this.f370734i = null;
        IAIChatUgcAIGCService.Companion r105 = IAIChatUgcAIGCService.f365905a;
        ps8.a r106 = r105.L();
        int r107 = hz9.a.f487718a;
        cz9.n r108 = this.f370731f;
        if (r108 == null) goto L19;
        Message r109 = r108.f466123e;
    L20:
        if (r108 == null) goto L24;
        CreationItem r110 = r108.f466122d;
        if (r110 == null) goto L24;
        String r111 = r110.f346620id;
    L25:
        if (r108 == null) goto L27;
        String r112 = Integer.valueOf(r108.f466124f).toString();
    L28:
        r106.b(hz9.a.a(r109, r111, true, r112));
        ps8.a r113 = r105.L();
        cz9.n r114 = this.f370731f;
        if (r114 == null) goto L31;
        Message r115 = r114.f466123e;
    L32:
        if (r114 == null) goto L36;
        CreationItem r116 = r114.f466122d;
        if (r116 == null) goto L36;
        String r117 = r116.f346620id;
    L37:
        if (r114 == null) goto L39;
        r101 = Integer.valueOf(r114.f466124f).toString();
    L39:
        r113.b(hz9.a.a(r115, r117, false, r101));
        this.f370732g = false;
        return;
    L36:
        r117 = null;
        goto L37
    L31:
        r115 = null;
        goto L32
    L27:
        r112 = null;
    L24:
        r111 = null;
        goto L25
    L19:
        r109 = null;
        goto L20
    }

    public final IVideoController h() {
        ps8.a r100 = IAIChatUgcAIGCService.f365905a.L();
        int r101 = hz9.a.f487718a;
        cz9.n r102 = this.f370731f;
        String r103 = null;
        if (r102 == null) goto L5;
        Message r104 = r102.f466123e;
    L6:
        if (r102 == null) goto L10;
        CreationItem r105 = r102.f466122d;
        if (r105 == null) goto L10;
        String r106 = r105.f346620id;
    L11:
        if (r102 == null) goto L14;
        r103 = Integer.valueOf(r102.f466124f).toString();
    L14:
        return r100.a(hz9.a.a(r104, r106, false, r103), "ugc_video", "message_card");
    L10:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    public final boolean j() {
        cz9.n r100 = this.f370731f;
        if (r100 == null) goto L16;
        CreationItem r101 = r100.f466122d;
        if (r101 == null) goto L17;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Integer r102 = r101.type;
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 != true) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r102.intValue() != 4) goto L12;
        r103 = true;
        goto L13
    L17:
        return false;
    L16:
        return false;
    }

    @Override // cz9.g
    public final View N0() {
        LarusWidgetMarkdownCreationSingleVideoBinding r100 = d0();
        if (r100 == null) goto L7;
        View r101 = r100.f373268a;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new View(AppHost.f326268a.getApplication());
    }

    public final kh8.a d() {
        kc8.q r100 = g();
        if (r100 == null) goto L7;
        rd8.b r101 = r100.f502552g;
        if (r101 == null) goto L7;
        return r101.q3();
    L7:
        return null;
    }

    public final void i() {
        LarusWidgetMarkdownCreationSingleVideoBinding r100 = d0();
        if (r100 == null) goto L7;
        ImageView r101 = r100.f373270c;
        if (r101 == null) goto L7;
        e1.d(r101, new f(this));
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r102 = d0();
        if (r102 == null) goto L12;
        ImageView r103 = r102.f373271d;
        if (r103 == null) goto L12;
        e1.d(r103, new g(this));
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r104 = d0();
        if (r104 == null) goto L20;
        VideoPlayView r105 = r104.f373276i;
        if (r105 == null) goto L21;
        e1.d(r105, new h(this));
        cz9.n r106 = this.f370731f;
        if (r106 == null) goto L22;
        a().invoke(r106, r105);
        return;
    L22:
        return;
    L21:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.uaigc.chat.block.widget.video.LocalVideoSuccessViewBinder$appBackgroundListener$1] */
    public LocalVideoSuccessViewBinder(LocalVideoItemViewHolder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        this.f370726a = r100;
        this.f370736k = new LocalVideoSuccessViewBinder$appBackgroundListener$1(this);
    }

    public final Job k(final nr9.g r110) {
        LarusWidgetMarkdownCreationSingleVideoBinding r100 = d0();
        if (r100 == null) goto L41;
        final VideoPlayView r101 = r100.f373276i;
        if (r101 == null) goto L42;
        r101.setIsMuted(true);
        w0.e(r101, i5.r0());
        r101.setAlpha(1.0f);
        e1.x(r101);
        r101.setForceRefreshSurface(true);
        r101.setShowCoverWhenPause(true);
        r101.setBanInnerDismiss(true);
        r101.setIgnoreClick(true);
        r101.setEnableCreationPreviewCoverLoadOpt(true);
        r101.setBackgroundColor(ContextCompat.getColor(r101.getContext(), v19.c.b(R.attr.larus_neutral_transparent_1, r101.getContext(), R.color.larus_neutral_transparent_1)));
        r101.E();
        nr9.f r102 = r110.f520263g;
        if (r102 == null) goto L9;
        String r103 = r102.f520251a;
    L10:
        if (r102 == null) goto L12;
        String r104 = r102.f520252b;
    L13:
        if (r102 == null) goto L15;
        String r105 = r102.f520253c;
    L16:
        if (r102 == null) goto L18;
        Integer r106 = r102.f520254d;
    L19:
        if (r102 == null) goto L21;
        Integer r107 = r102.f520255e;
    L22:
        if (r102 == null) goto L24;
        Bitmap r108 = r102.f520256f;
    L25:
        cz9.n r109 = this.f370731f;
        if (r109 == null) goto L30;
        Message r111 = r109.f466123e;
        if (r111 == null) goto L30;
        String r112 = r111.getMessageId();
    L31:
        VideoPlayView.p(r101, r103, r104, r105, r106, r107, r108, null, r112, 64);
        r101.i(false);
        IVideoController r113 = h();
        if (r113 == null) goto L34;
        r113.C(true);
        IVideoController r114 = r113;
    L35:
        String r115 = r110.f520258b;
        String r116 = r110.f520264h;
        if (j() == false) goto L38;
        String r117 = r116;
    L39:
        VideoPlayView.e(r101, r114, r115, r117, null, null, null, 56);
        r101.f327977d = new e(this, r110, r101);
        return BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$refreshVideoView$1$4(this, r110, null), 3, null);
    L38:
        r117 = null;
        goto L39
    L34:
        r114 = null;
    L30:
        r112 = null;
        goto L31
    L24:
        r108 = null;
        goto L25
    L21:
        r107 = null;
        goto L22
    L18:
        r106 = null;
        goto L19
    L15:
        r105 = null;
        goto L16
    L12:
        r104 = null;
        goto L13
    L9:
        r103 = null;
        goto L10
    L42:
        return null;
    L41:
        return null;
    }

    @Override // cz9.g
    public final void p2(cz9.b r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        VideoPlayView r100 = null;
        if ((r210 instanceof cz9.n) == false) goto L5;
        cz9.n r101 = (cz9.n) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        CreationItem r102 = r101.f466122d;
        int r103 = 0;
        if (r102 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L16;
        return;
    L16:
        LarusWidgetMarkdownCreationSingleVideoBinding r105 = d0();
        if (r105 == null) goto L22;
        VideoPlayView r106 = r105.f373276i;
        if (r106 == null) goto L22;
        e1.x(r106);
    L22:
        if (this.f370735j == true) goto L24;
        AppHost.f326268a.a().j(this.f370736k);
        this.f370735j = true;
    L24:
        String r107 = r101.f466122d.f346620id;
        String r108 = "";
        if (r107 != null) goto L27;
        r107 = "";
    L27:
        cz9.n r109 = this.f370731f;
        if (r109 == null) goto L32;
        CreationItem r110 = r109.f466122d;
        if (r110 == null) goto L32;
        String r111 = r110.f346620id;
    L33:
        if (r111 == null) goto L37;
        r108 = r111;
    L37:
        if (Intrinsics.areEqual(r107, r108) == false) goto L46;
        cz9.n r112 = this.f370731f;
        if (r112 != null) goto L41;
    L43:
        boolean r113 = false;
    L44:
        if (r113 == false) goto L46;
        boolean r114 = true;
    L47:
        if (r114 == true) goto L49;
        this.f370732g = false;
    L49:
        CreationItem r115 = r101.f466122d;
        if (r115 == null) goto L159;
        nr9.g r116 = bz9.c.p(r115);
        if (r116 == null) goto L159;
        Object[] r117 = new Object[9];
        r117[0] = r116.f520257a;
        r117[1] = r116.f520258b;
        r117[2] = r116.f520259c;
        r117[3] = r116.f520260d;
        nr9.f r118 = r116.f520263g;
        if (r118 == null) goto L57;
        String r119 = r118.f520252b;
    L58:
        r117[4] = r119;
        if (r118 == null) goto L61;
        String r120 = r118.f520251a;
    L62:
        r117[5] = r120;
        if (r118 == null) goto L65;
        String r121 = r118.f520253c;
    L66:
        r117[6] = r121;
        if (r118 == null) goto L69;
        Integer r122 = r118.f520255e;
    L70:
        r117[7] = r122;
        if (r118 == null) goto L73;
        Integer r123 = r118.f520254d;
    L74:
        r117[8] = r123;
        String r124 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r117), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        if (r114 == true) goto L77;
    L102:
        this.f370731f = r101;
        this.f370734i = r124;
        Job r125 = this.f370729d;
        if (r125 == null) goto L105;
        Job.DefaultImpls.cancel$default(r125, null, 1, null);
    L105:
        this.f370729d = BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$bindObservers$1(this, r116, null), 3, null);
        Job r126 = this.f370730e;
        if (r126 == null) goto L108;
        Job.DefaultImpls.cancel$default(r126, null, 1, null);
    L108:
        this.f370730e = BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$bindObservers$2(this, r116, null), 3, null);
        k(r116);
        String r127 = r116.f520257a;
        if (r127 != null) goto L111;
    L130:
        LarusWidgetMarkdownCreationSingleVideoBinding r128 = d0();
        if (r128 == null) goto L135;
        ImageView r129 = r128.f373269b;
        if (r129 == null) goto L135;
        e1.x(r129);
    L135:
        LarusWidgetMarkdownCreationSingleVideoBinding r130 = d0();
        if (r130 == null) goto L144;
        ImageView r131 = r130.f373271d;
        if (r131 == null) goto L144;
        if (r101.f466125g == false) goto L142;
        int r132 = 0;
    L143:
        r131.setVisibility(r132);
        goto L144
    L142:
        r132 = 8;
    L144:
        LarusWidgetMarkdownCreationSingleVideoBinding r133 = d0();
        if (r133 == null) goto L149;
        TextView r134 = r133.f373273f;
        if (r134 == null) goto L149;
        e1.o(r134);
    L149:
        LarusWidgetMarkdownCreationSingleVideoBinding r135 = d0();
        if (r135 == null) goto L158;
        ImageView r136 = r135.f373270c;
        if (r136 == null) goto L158;
        if (r101.f466126h == true) goto L157;
        r103 = 8;
    L157:
        r136.setVisibility(r103);
    L158:
        i();
        return;
    L111:
        if ((true ^ StringsKt.isBlank(r127)) == true) goto L114;
        r127 = null;
    L114:
        if (r127 == null) goto L130;
        if (Intrinsics.areEqual(this.f370733h, r127) == true) goto L130;
        String r137 = this.f370733h;
        if (r137 == null) goto L124;
        kh8.a r138 = d();
        if (r138 == null) goto L124;
        r138.c(r137);
    L124:
        this.f370733h = r127;
        kh8.a r139 = d();
        if (r139 == null) goto L130;
        LarusWidgetMarkdownCreationSingleVideoBinding r140 = d0();
        if (r140 == null) goto L129;
        r100 = r140.f373276i;
    L129:
        r139.d(r127, r100);
        goto L130
    L77:
        if (Intrinsics.areEqual(r124, this.f370734i) == false) goto L102;
        this.f370731f = r101;
        k(r116);
        LarusWidgetMarkdownCreationSingleVideoBinding r141 = d0();
        if (r141 == null) goto L83;
        ImageView r142 = r141.f373269b;
        if (r142 == null) goto L83;
        e1.x(r142);
    L83:
        LarusWidgetMarkdownCreationSingleVideoBinding r143 = d0();
        if (r143 == null) goto L92;
        ImageView r144 = r143.f373271d;
        if (r144 == null) goto L92;
        if (r101.f466125g == false) goto L90;
        int r145 = 0;
    L91:
        r144.setVisibility(r145);
        goto L92
    L90:
        r145 = 8;
    L92:
        LarusWidgetMarkdownCreationSingleVideoBinding r146 = d0();
        if (r146 == null) goto L101;
        ImageView r147 = r146.f373270c;
        if (r147 == null) goto L101;
        if (r101.f466126h == true) goto L100;
        r103 = 8;
    L100:
        r147.setVisibility(r103);
    L101:
        i();
        return;
    L73:
        r123 = null;
        goto L74
    L69:
        r122 = null;
        goto L70
    L65:
        r121 = null;
        goto L66
    L61:
        r120 = null;
        goto L62
    L57:
        r119 = null;
    L159:
        FLogger.f375446a.e("LocalVideoSuccessViewBinder", "local videoContent is null");
        return;
    L41:
        if (r101.f466124f != r112.f466124f) goto L43;
        r113 = true;
    L46:
        r114 = false;
    L32:
        r111 = null;
        goto L33
    L11:
        if (bz9.c.e(r102) != true) goto L13;
        r104 = true;
        goto L14
    L5:
        r101 = null;
        goto L6
    }
}
