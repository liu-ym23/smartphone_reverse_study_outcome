package com.larus.uaigc.chat.block.widget.video;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
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
public final class VideoSuccessViewBinder implements cz9.g, b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f370759n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f370760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f370761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f370762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f370763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f370764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cz9.o f370765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f370766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f370767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f370768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f370769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f370770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Long> f370771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VideoSuccessViewBinder$appBackgroundListener$1 f370772m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final Function2<cz9.b, View, Unit> a() {
        return this.f370760a.a();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final Function2<cz9.b, iy9.b, Unit> b() {
        return this.f370760a.b();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final CoroutineScope c() {
        return this.f370760a.c();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
        return this.f370760a.d0();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final kc8.q g() {
        return this.f370760a.g();
    }

    @Override // cz9.g
    public final void updateSize(int r100, int r101) {
    }

    public final IVideoController e() {
        ps8.a r100 = IAIChatUgcAIGCService.f365905a.L();
        int r101 = hz9.a.f487718a;
        cz9.o r102 = this.f370765f;
        String r103 = null;
        if (r102 == null) goto L5;
        Message r104 = r102.f466131e;
    L6:
        if (r102 == null) goto L10;
        CreationItem r105 = r102.f466130d;
        if (r105 == null) goto L10;
        String r106 = r105.f346620id;
    L11:
        if (r102 == null) goto L14;
        r103 = Integer.valueOf(r102.f466132f).toString();
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
        if (this.f370769j == false) goto L5;
        AppHost.f326268a.a().c(this.f370772m);
        this.f370769j = false;
    L5:
        Job r100 = this.f370763d;
        String r101 = null;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.f370763d = null;
        Job r102 = this.f370764e;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f370764e = null;
        j();
        this.f370768i = null;
        IAIChatUgcAIGCService.Companion r103 = IAIChatUgcAIGCService.f365905a;
        ps8.a r104 = r103.L();
        int r105 = hz9.a.f487718a;
        cz9.o r106 = this.f370765f;
        if (r106 == null) goto L14;
        Message r107 = r106.f466131e;
    L15:
        if (r106 == null) goto L19;
        CreationItem r108 = r106.f466130d;
        if (r108 == null) goto L19;
        String r109 = r108.f346620id;
    L20:
        if (r106 == null) goto L22;
        String r110 = Integer.valueOf(r106.f466132f).toString();
    L23:
        r104.b(hz9.a.a(r107, r109, true, r110));
        ps8.a r111 = r103.L();
        cz9.o r112 = this.f370765f;
        if (r112 == null) goto L26;
        Message r113 = r112.f466131e;
    L27:
        if (r112 == null) goto L31;
        CreationItem r114 = r112.f466130d;
        if (r114 == null) goto L31;
        String r115 = r114.f346620id;
    L32:
        if (r112 == null) goto L34;
        r101 = Integer.valueOf(r112.f466132f).toString();
    L34:
        r111.b(hz9.a.a(r113, r115, false, r101));
        this.f370766g = false;
        return;
    L31:
        r115 = null;
        goto L32
    L26:
        r113 = null;
        goto L27
    L22:
        r110 = null;
    L19:
        r109 = null;
        goto L20
    L14:
        r107 = null;
        goto L15
    }

    public final IVideoController h() {
        ps8.a r100 = IAIChatUgcAIGCService.f365905a.L();
        int r101 = hz9.a.f487718a;
        cz9.o r102 = this.f370765f;
        String r103 = null;
        if (r102 == null) goto L5;
        Message r104 = r102.f466131e;
    L6:
        if (r102 == null) goto L10;
        CreationItem r105 = r102.f466130d;
        if (r105 == null) goto L10;
        String r106 = r105.f346620id;
    L11:
        if (r102 == null) goto L14;
        r103 = Integer.valueOf(r102.f466132f).toString();
    L14:
        return r100.a(hz9.a.a(r104, r106, false, r103), "ugc_video", "message_card");
    L10:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    public final void j() {
        String r100 = this.f370767h;
        if (r100 == null) goto L7;
        kh8.a r101 = d();
        if (r101 == null) goto L7;
        r101.c(r100);
    L7:
        this.f370767h = null;
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
        TextView r101 = r100.f373273f;
        if (r101 == null) goto L7;
        e1.d(r101, new o(this));
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r102 = d0();
        if (r102 == null) goto L12;
        ImageView r103 = r102.f373270c;
        if (r103 == null) goto L12;
        e1.d(r103, new p(this));
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r104 = d0();
        if (r104 == null) goto L17;
        ImageView r105 = r104.f373271d;
        if (r105 == null) goto L17;
        e1.d(r105, new q(this));
    L17:
        LarusWidgetMarkdownCreationSingleVideoBinding r106 = d0();
        if (r106 == null) goto L25;
        VideoPlayView r107 = r106.f373276i;
        if (r107 == null) goto L26;
        e1.d(r107, new r(this));
        cz9.o r108 = this.f370765f;
        if (r108 == null) goto L27;
        a().invoke(r108, r107);
        return;
    L27:
        return;
    L26:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$appBackgroundListener$1] */
    public VideoSuccessViewBinder(VideoItemViewHolder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        this.f370760a = r100;
        this.f370770k = new LinkedHashSet();
        this.f370771l = new LinkedHashMap();
        this.f370772m = new VideoSuccessViewBinder$appBackgroundListener$1(this);
    }

    @Override // cz9.g
    public final void p2(cz9.b r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        VideoPlayView r100 = null;
        if ((r210 instanceof cz9.o) == false) goto L5;
        cz9.o r101 = (cz9.o) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        CreationItem r102 = r101.f466130d;
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L46;
        j();
        this.f370768i = null;
        LarusWidgetMarkdownCreationSingleVideoBinding r106 = d0();
        if (r106 == null) goto L20;
        VideoPlayView r107 = r106.f373276i;
        if (r107 == null) goto L20;
        e1.o(r107);
    L20:
        LarusWidgetMarkdownCreationSingleVideoBinding r108 = d0();
        if (r108 == null) goto L25;
        ImageView r109 = r108.f373271d;
        if (r109 == null) goto L25;
        e1.o(r109);
    L25:
        LarusWidgetMarkdownCreationSingleVideoBinding r110 = d0();
        if (r110 == null) goto L30;
        ProgressBar r111 = r110.f373272e;
        if (r111 == null) goto L30;
        e1.o(r111);
    L30:
        LarusWidgetMarkdownCreationSingleVideoBinding r112 = d0();
        if (r112 == null) goto L35;
        ImageView r113 = r112.f373269b;
        if (r113 == null) goto L35;
        e1.o(r113);
    L35:
        LarusWidgetMarkdownCreationSingleVideoBinding r114 = d0();
        if (r114 == null) goto L40;
        ImageView r115 = r114.f373270c;
        if (r115 == null) goto L40;
        e1.o(r115);
    L40:
        LarusWidgetMarkdownCreationSingleVideoBinding r116 = d0();
        if (r116 == null) goto L336;
        TextView r117 = r116.f373273f;
        if (r117 == null) goto L337;
        e1.o(r117);
        return;
    L337:
        return;
    L336:
        return;
    L46:
        LarusWidgetMarkdownCreationSingleVideoBinding r118 = d0();
        if (r118 == null) goto L52;
        VideoPlayView r119 = r118.f373276i;
        if (r119 == null) goto L52;
        e1.x(r119);
    L52:
        if (this.f370769j == true) goto L54;
        AppHost.f326268a.a().j(this.f370772m);
        this.f370769j = true;
    L54:
        CreationItem r120 = r101.f466130d;
        VideoData r121 = r120.video;
        if (r121 != null) goto L58;
        FLogger.f375446a.e("VideoSuccessViewBinder", "videoContent is null");
        return;
    L58:
        String r122 = r120.f346620id;
        if (r122 != null) goto L61;
        r122 = "";
    L61:
        cz9.o r123 = this.f370765f;
        if (r123 == null) goto L66;
        CreationItem r124 = r123.f466130d;
        if (r124 == null) goto L66;
        String r125 = r124.f346620id;
    L67:
        if (r125 != null) goto L70;
        r125 = "";
    L70:
        if (Intrinsics.areEqual(r122, r125) == false) goto L79;
        cz9.o r126 = this.f370765f;
        if (r126 != null) goto L74;
    L76:
        boolean r127 = false;
    L77:
        if (r127 == false) goto L79;
        boolean r128 = true;
    L80:
        if (r128 == true) goto L82;
        this.f370766g = false;
    L82:
        String r129 = r121.vid;
        if (this.f370766g == true) goto L98;
        if (r129 == null) goto L98;
        if ((!StringsKt.isBlank(r129)) == true) goto L90;
        r129 = null;
    L90:
        if (r129 == null) goto L98;
        Long r130 = (Long) ((LinkedHashMap) this.f370771l).get(r129);
        if (r130 != null) goto L95;
    L97:
        boolean r131 = CreationNoWatermarkManager.f373832a.m0(r129);
    L100:
        if (r131 == false) goto L191;
        this.f370765f = r101;
        this.f370768i = null;
        CreationNoWatermarkManager r132 = CreationNoWatermarkManager.f373832a;
        String r133 = r121.vid;
        nr9.g r134 = bz9.a.l(r121);
        Cover r135 = r121.cover;
        if (r135 == null) goto L104;
        String r136 = r135.key;
    L105:
        nr9.g r137 = r132.c0(r133, r134, r136);
        if (r137 != null) goto L108;
        r137 = bz9.a.l(r121);
    L108:
        Job r138 = this.f370763d;
        if (r138 == null) goto L111;
        Job.DefaultImpls.cancel$default(r138, null, 1, null);
    L111:
        this.f370763d = null;
        Job r139 = this.f370764e;
        if (r139 == null) goto L114;
        Job.DefaultImpls.cancel$default(r139, null, 1, null);
    L114:
        this.f370764e = null;
        j();
        this.f370766g = false;
        LarusWidgetMarkdownCreationSingleVideoBinding r140 = d0();
        if (r140 == null) goto L144;
        VideoPlayView r141 = r140.f373276i;
        if (r141 == null) goto L144;
        VideoPlayView.z(r141, 0, 2);
        r141.setIsMuted(true);
        w0.e(r141, i5.r0());
        r141.setAlpha(1.0f);
        e1.x(r141);
        r141.setForceRefreshSurface(true);
        r141.setShowCoverWhenPause(true);
        r141.setBanInnerDismiss(true);
        r141.setIgnoreClick(true);
        r141.setEnableCreationPreviewCoverLoadOpt(true);
        r141.setBackgroundColor(ContextCompat.getColor(r141.getContext(), v19.c.b(R.attr.larus_neutral_transparent_1, r141.getContext(), R.color.larus_neutral_transparent_1)));
        r141.E();
        nr9.f r142 = r137.f520263g;
        if (r142 == null) goto L121;
        String r143 = r142.f520251a;
    L122:
        if (r142 == null) goto L124;
        String r144 = r142.f520252b;
    L125:
        if (r142 == null) goto L127;
        String r145 = r142.f520253c;
    L128:
        if (r142 == null) goto L130;
        Integer r146 = r142.f520254d;
    L131:
        if (r142 == null) goto L133;
        Integer r147 = r142.f520255e;
    L134:
        if (r142 == null) goto L136;
        Bitmap r148 = r142.f520256f;
    L137:
        cz9.o r149 = this.f370765f;
        if (r149 == null) goto L142;
        Message r150 = r149.f466131e;
        if (r150 == null) goto L142;
        String r211 = r150.getMessageId();
    L143:
        VideoPlayView.p(r141, r143, r144, r145, r146, r147, r148, null, r211, 64);
        r141.i(false);
    L142:
        r211 = null;
        goto L143
    L136:
        r148 = null;
        goto L137
    L133:
        r147 = null;
        goto L134
    L130:
        r146 = null;
        goto L131
    L127:
        r145 = null;
        goto L128
    L124:
        r144 = null;
        goto L125
    L121:
        r143 = null;
    L144:
        LarusWidgetMarkdownCreationSingleVideoBinding r151 = d0();
        if (r151 == null) goto L149;
        ImageView r152 = r151.f373269b;
        if (r152 == null) goto L149;
        e1.o(r152);
    L149:
        LarusWidgetMarkdownCreationSingleVideoBinding r153 = d0();
        if (r153 == null) goto L154;
        ImageView r154 = r153.f373271d;
        if (r154 == null) goto L154;
        e1.o(r154);
    L154:
        LarusWidgetMarkdownCreationSingleVideoBinding r155 = d0();
        if (r155 == null) goto L159;
        ProgressBar r156 = r155.f373272e;
        if (r156 == null) goto L159;
        e1.o(r156);
    L159:
        LarusWidgetMarkdownCreationSingleVideoBinding r157 = d0();
        if (r157 == null) goto L164;
        ImageView r158 = r157.f373270c;
        if (r158 == null) goto L164;
        e1.o(r158);
    L164:
        LarusWidgetMarkdownCreationSingleVideoBinding r159 = d0();
        if (r159 == null) goto L169;
        TextView r160 = r159.f373273f;
        if (r160 == null) goto L169;
        e1.o(r160);
    L169:
        String r161 = r121.vid;
        if (r161 != null) goto L172;
    L189:
        i();
        return;
    L172:
        if ((true ^ StringsKt.isBlank(r161)) == false) goto L174;
        String r162 = r161;
    L175:
        if (r162 == null) goto L189;
        if (this.f370770k.add(r162) == false) goto L189;
        Message r163 = r101.f466131e;
        if (r163 == null) goto L183;
        String r164 = r163.getMessageId();
    L184:
        CreationItem r165 = r101.f466130d;
        if (r165 == null) goto L187;
        String r166 = r165.f346620id;
    L188:
        BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$requestNoWatermarkVideo$1(this, r162, r164, r166, r101.f466132f, null), 3, null);
        goto L189
    L187:
        r166 = null;
        goto L188
    L183:
        r164 = null;
        goto L184
    L174:
        r162 = null;
        goto L175
    L104:
        r136 = null;
        goto L105
    L191:
        CreationNoWatermarkManager r167 = CreationNoWatermarkManager.f373832a;
        String r168 = r121.vid;
        nr9.g r169 = bz9.a.l(r121);
        Cover r170 = r121.cover;
        if (r170 == null) goto L194;
        String r171 = r170.key;
    L195:
        final nr9.g r172 = r167.c0(r168, r169, r171);
        if (r172 != null) goto L198;
        r172 = bz9.a.l(r121);
    L198:
        Object[] r173 = new Object[9];
        r173[0] = r172.f520257a;
        r173[1] = r172.f520258b;
        r173[2] = r172.f520259c;
        r173[3] = r172.f520260d;
        nr9.f r174 = r172.f520263g;
        if (r174 == null) goto L201;
        String r175 = r174.f520252b;
    L202:
        r173[4] = r175;
        if (r174 == null) goto L205;
        String r176 = r174.f520251a;
    L206:
        r173[5] = r176;
        if (r174 == null) goto L209;
        String r177 = r174.f520253c;
    L210:
        r173[6] = r177;
        if (r174 == null) goto L213;
        Integer r178 = r174.f520255e;
    L214:
        r173[7] = r178;
        if (r174 == null) goto L217;
        Integer r179 = r174.f520254d;
    L218:
        r173[8] = r179;
        String r180 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r173), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        if (r128 == true) goto L221;
    L223:
        this.f370765f = r101;
        this.f370768i = r180;
        Job r181 = this.f370763d;
        if (r181 == null) goto L226;
        Job.DefaultImpls.cancel$default(r181, null, 1, null);
    L226:
        this.f370763d = BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$bindObservers$1(this, r172, null), 3, null);
        Job r182 = this.f370764e;
        if (r182 == null) goto L229;
        Job.DefaultImpls.cancel$default(r182, null, 1, null);
    L229:
        this.f370764e = BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$bindObservers$2(this, r172, null), 3, null);
        LarusWidgetMarkdownCreationSingleVideoBinding r183 = d0();
        if (r183 == null) goto L280;
        final VideoPlayView r184 = r183.f373276i;
        if (r184 == null) goto L280;
        r184.setIsMuted(true);
        w0.e(r184, i5.r0());
        r184.setAlpha(1.0f);
        e1.x(r184);
        r184.setForceRefreshSurface(true);
        r184.setShowCoverWhenPause(true);
        r184.setBanInnerDismiss(true);
        r184.setIgnoreClick(true);
        r184.setEnableCreationPreviewCoverLoadOpt(true);
        r184.setBackgroundColor(ContextCompat.getColor(r184.getContext(), v19.c.b(R.attr.larus_neutral_transparent_1, r184.getContext(), R.color.larus_neutral_transparent_1)));
        r184.E();
        nr9.f r185 = r172.f520263g;
        if (r185 == null) goto L236;
        String r186 = r185.f520251a;
    L237:
        if (r185 == null) goto L239;
        String r187 = r185.f520252b;
    L240:
        if (r185 == null) goto L242;
        String r188 = r185.f520253c;
    L243:
        if (r185 == null) goto L245;
        Integer r189 = r185.f520254d;
    L246:
        if (r185 == null) goto L248;
        Integer r190 = r185.f520255e;
    L249:
        if (r185 == null) goto L251;
        Bitmap r212 = r185.f520256f;
    L252:
        cz9.o r191 = this.f370765f;
        if (r191 == null) goto L257;
        Message r192 = r191.f466131e;
        if (r192 == null) goto L257;
        String r213 = r192.getMessageId();
    L258:
        VideoPlayView.p(r184, r186, r187, r188, r189, r190, r212, null, r213, 64);
        r184.i(false);
        FlowFileProtectionService r193 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r193 != null) goto L261;
    L263:
        boolean r194 = false;
    L264:
        IVideoController r195 = h();
        if (r195 == null) goto L267;
        r195.C(true);
        IVideoController r196 = r195;
    L268:
        String r197 = r172.f520258b;
        if (r194 == true) goto L271;
        String r198 = r197;
    L272:
        String r199 = r172.f520259c;
        if (r194 == false) goto L275;
        String r1100 = r199;
    L276:
        if (r194 == false) goto L278;
        String r1101 = "";
    L279:
        VideoPlayView.e(r184, r196, r198, null, r1100, r1101, null, 36);
        r184.f327977d = new s(this, r172, r184);
        BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$refreshVideoView$1$6(this, r172, null), 3, null);
        goto L280
    L278:
        r1101 = null;
        goto L279
    L275:
        r1100 = null;
        goto L276
    L271:
        r198 = null;
        goto L272
    L267:
        r196 = null;
        goto L268
    L261:
        if (r193.I0() != true) goto L263;
        r194 = true;
    L257:
        r213 = null;
        goto L258
    L251:
        r212 = null;
        goto L252
    L248:
        r190 = null;
        goto L249
    L245:
        r189 = null;
        goto L246
    L242:
        r188 = null;
        goto L243
    L239:
        r187 = null;
        goto L240
    L236:
        r186 = null;
    L280:
        String r200 = r172.f520257a;
        if (r200 != null) goto L283;
    L297:
        LarusWidgetMarkdownCreationSingleVideoBinding r201 = d0();
        if (r201 == null) goto L302;
        ImageView r202 = r201.f373269b;
        if (r202 == null) goto L302;
        e1.x(r202);
    L302:
        LarusWidgetMarkdownCreationSingleVideoBinding r203 = d0();
        if (r203 == null) goto L311;
        ImageView r204 = r203.f373271d;
        if (r204 == null) goto L311;
        if (r101.f466133g == false) goto L309;
        int r205 = 0;
    L310:
        r204.setVisibility(r205);
        goto L311
    L309:
        r205 = 8;
    L311:
        LarusWidgetMarkdownCreationSingleVideoBinding r206 = d0();
        if (r206 == null) goto L325;
        TextView r207 = r206.f373273f;
        if (r207 == null) goto L325;
        if (r101.f466134h == false) goto L318;
    L320:
        r103 = false;
    L321:
        if (r103 == false) goto L323;
        int r208 = 0;
    L324:
        r207.setVisibility(r208);
        goto L325
    L323:
        r208 = 8;
        goto L324
    L318:
        if (z2.f365865a.getCreationExtendVideoConfig().a() == false) goto L320;
    L325:
        LarusWidgetMarkdownCreationSingleVideoBinding r209 = d0();
        if (r209 == null) goto L334;
        ImageView r214 = r209.f373270c;
        if (r214 == null) goto L334;
        if (r101.f466134h == true) goto L333;
        r104 = 8;
    L333:
        r214.setVisibility(r104);
    L334:
        i();
        hy9.d r215 = ICreationReportService.f373922a.j();
        String r216 = AppHost.f326268a.getApplication().getString(R.string.larus_extendVideo_label_btn_extend);
        LruCache<String, wc9.e> r217 = ko8.a.f504531a;
        hy9.d.a.b(r215, r216, null, null, "video_overview", "single_function", null, null, null, null, ko8.a.h(ko8.a.f504535e), null, null, null, "chat", null, null, null, null, 1039846);
        return;
    L283:
        if ((!StringsKt.isBlank(r200)) == true) goto L286;
        r200 = null;
    L286:
        if (r200 == null) goto L297;
        if (Intrinsics.areEqual(this.f370767h, r200) == true) goto L297;
        j();
        this.f370767h = r200;
        kh8.a r218 = d();
        if (r218 == null) goto L297;
        LarusWidgetMarkdownCreationSingleVideoBinding r219 = d0();
        if (r219 == null) goto L296;
        r100 = r219.f373276i;
    L296:
        r218.d(r200, r100);
        goto L297
    L221:
        if (Intrinsics.areEqual(r180, this.f370768i) == false) goto L223;
        return;
    L217:
        r179 = null;
        goto L218
    L213:
        r178 = null;
        goto L214
    L209:
        r177 = null;
        goto L210
    L205:
        r176 = null;
        goto L206
    L201:
        r175 = null;
        goto L202
    L194:
        r171 = null;
        goto L195
    L95:
        if ((System.currentTimeMillis() - r130.longValue()) >= 10000) goto L97;
    L98:
        r131 = false;
        goto L100
    L74:
        if (r101.f466132f != r126.f466132f) goto L76;
        r127 = true;
    L79:
        r128 = false;
    L66:
        r125 = null;
        goto L67
    L11:
        if (bz9.a.f(r102) != true) goto L13;
        r105 = true;
        goto L14
    L5:
        r101 = null;
        goto L6
    }
}
