package com.larus.bmhome.chat.markdown.videogroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.double_post.view.AwemeRecommendContentView;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdVideoGroupV2Binding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.b;
import fh8.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rh8.d;
import rh8.j;
import usc.e;
import usc.f;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J.\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0002J,\u0010-\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J\u0012\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u000100H\u0002J\u0012\u00103\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u000100H\u0002J\b\u00104\u001a\u000205H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/bmhome/chat/markdown/videogroup/VideoGroupV2Widget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdVideoGroupV2Binding;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "mobConversationId", "", "mobBotId", "mobCurrentPage", "mobPreviousPage", "mobLruSet", "Lcom/larus/bmhome/chat/search/LruSet;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", WsConstants.KEY_PAYLOAD, "", "", "updateVideoTitle", "", "showVideoTitle", "", "videoTitle", "updateVideoContent", "videoGroupData", "Lcom/larus/bmhome/chat/markdown/videogroup/VideoGroupData;", "convert2Content", "Lcom/larus/bmhome/video/Content;", "openVideoActivity", "videoInfos", "", "Lcom/larus/bmhome/chat/search/VideoInfo;", "mobCardShow", "videoItem", "mobCardClick", "asView", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoGroupV2Widget extends FrameLayout implements f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f307291i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusMdVideoGroupV2Binding f307292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Message f307293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f307294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f307295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f307296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f307297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LruSet<String> f307298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fh8.f f307299h;

    public static final class a {
    }

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final View asView() {
        return this;
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
    }

    static {
        f307291i = i5.y0(c.b(R.attr.larus_dp_157, null, R.dimen.larus_dp_157));
    }

    public VideoGroupV2Widget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public VideoGroupV2Widget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // usc.f
    public final Size d(TextView r410, Spanned r411, e r412, int r413, Map<String, ? extends Object> r414) {
        Intrinsics.checkNotNullParameter(r410, "textView");
        Intrinsics.checkNotNullParameter(r411, "text");
        Intrinsics.checkNotNullParameter(r412, "span");
        LarusMdVideoGroupV2Binding r100 = null;
        if (r414 == null) goto L5;
        fh8.f r101 = h.b(r414);
    L6:
        this.f307299h = r101;
        if (r101 == null) goto L9;
        Message r102 = r101.f477072b;
    L10:
        this.f307293b = r102;
        if (r101 == null) goto L13;
        String r103 = r101.f477073c;
    L14:
        this.f307294c = r103;
        if (r101 == null) goto L17;
        String r104 = r101.f477075e;
    L18:
        this.f307296e = r104;
        if (r101 == null) goto L21;
        String r105 = r101.f477076f;
    L22:
        this.f307297f = r105;
        if (r101 == null) goto L25;
        String r106 = r101.f477074d;
    L26:
        this.f307295d = r106;
        if (r101 == null) goto L29;
        LruSet<String> r107 = r101.f477077g;
    L30:
        this.f307298g = r107;
    L109:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return new Size(0, 0);
    L33:
        if (r412.k().length() != 0) goto L35;
        boolean r108 = true;
    L36:
        String r109 = "";
        if (r108 == false) goto L39;
        final String r110 = r412.h();     // Catch: Exception -> L109
    L48:
        String r111 = SliceInitService.DEFAULT_SWITCH;
        if (r110 != null) goto L51;
        r110 = SliceInitService.DEFAULT_SWITCH;
    L51:
        rh8.a r112 = (rh8.a) b.a(r412, new d(r110));     // Catch: Exception -> L109
        String r113 = r412.l();     // Catch: Exception -> L58
        if (r113 == null) goto L56;
        r111 = r113;
    L56:
        JSONObject r114 = new JSONObject(r111);     // Catch: Exception -> L58
    L59:
        boolean r115 = r114.optBoolean("video_title_show");
        View r116 = LayoutInflater.from(getContext()).inflate(R.layout.larus_md_video_group_v2, this, false);
        addView(r116);
        int r117 = R.id.video_content;
        AwemeRecommendContentView r118 = (AwemeRecommendContentView) ViewBindings.findChildViewById(r116, R.id.video_content);
        if (r118 == null) goto L108;
        r117 = R.id.videoTitle;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r116, R.id.videoTitle);
        if (r119 == null) goto L108;
        this.f307292a = new LarusMdVideoGroupV2Binding((LinearLayout) r116, r118, r119);
        String r120 = r112.a();
        LarusMdVideoGroupV2Binding r121 = this.f307292a;
        if (r121 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L66:
        TextView r122 = r121.f358775c;
        if (r115 == true) goto L69;
        Intrinsics.checkNotNull(r122);
        e1.o(r122);
    L74:
        Intrinsics.checkNotNull(r112);
        LarusMdVideoGroupV2Binding r123 = this.f307292a;
        if (r123 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r123 = null;
    L77:
        AwemeRecommendContentView r124 = r123.f358774b;
        List<VideoInfo> r125 = r112.b();
        if (r125 == null) goto L91;
        VideoInfo r126 = (VideoInfo) ListProtector.get(r125, 0);
        if (r126 == null) goto L91;
        String r127 = r126.getItemId();
        int r128 = ItemType.VIDEO.getValue();
        ContentDescription r129 = new ContentDescription(null, r126.getDescription(), 1, null);
        CardRatioStrategy r210 = CardRatioStrategy.FixRatio;
        String r310 = r126.getImageUrl();
        Integer r130 = r126.getWidth();
        if (r130 == null) goto L85;
        int r311 = r130.intValue();
    L86:
        Integer r131 = r126.getHeight();
        if (r131 == null) goto L89;
        int r312 = r131.intValue();
    L90:
        ContentCover r132 = new ContentCover(new IconImage(null, null, new ImageObj(r310, r311, r312, null, null, 24, null), 3, null), null, null, 6, null);
        Content r133 = new Content(r127, Integer.valueOf(r128), null, null, r126.getAuthorInfo(), r132, r129, r126.getInteractionInfo(), null, null, null, null, null, r210, false, null, null, 122636, null);
    L92:
        r124.a(r133, new j(r112, this, r414, r410));
        List<VideoInfo> r134 = r112.b();
        if (r134 == null) goto L98;
        final VideoInfo r135 = (VideoInfo) ListProtector.get(r134, 0);
        LarusMdVideoGroupV2Binding r136 = this.f307292a;
        if (r136 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r136 = null;
    L97:
        ExposureTrackerExtKt.a(r136.f358774b, new rh8.e(r135, this));
    L98:
        LarusMdVideoGroupV2Binding r137 = this.f307292a;
        if (r137 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r137 = null;
    L101:
        r137.f358773a.measure(0, 0);
        LarusMdVideoGroupV2Binding r138 = this.f307292a;
        if (r138 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L106:
        return new Size(r413, r100.f358773a.getMeasuredHeight());
    L104:
        r100 = r138;
        goto L106
    L89:
        r312 = 0;
        goto L90
    L85:
        r311 = 0;
    L91:
        r133 = null;
        goto L92
    L69:
        Intrinsics.checkNotNull(r122);
        e1.x(r122);
        we8.a.b(r122, i5.t(), false, null, null, 12);
        r122.getLayoutParams().height = (int) we8.a.a(((Number) i5.f552558y.getValue()).intValue(), false);
        if (r120 == null) goto L73;
        r109 = r120;
    L73:
        r122.setText(r109);
    L108:
        throw new NullPointerException("Missing required view with ID: ".concat(r116.getResources().getResourceName(r117)));
    L58:
        r114 = new JSONObject();
        goto L59
    L39:
        Message r139 = this.f307293b;     // Catch: Exception -> L109
        if (r139 == null) goto L47;
        wc8.b r140 = wc8.b.f559187a;     // Catch: Exception -> L109
        String r141 = r139.getMessageId();     // Catch: Exception -> L109
        if (r141 != null) goto L45;
        r141 = "";
    L45:
        r110 = r140.c(r141, r412.k(), "VideoGroupV2Widget");     // Catch: Exception -> L109
        if (r110 != null) goto L48;
    L47:
        r110 = wc8.b.f559187a.b(r412.k(), "VideoGroupV2Widget");     // Catch: Exception -> L109
        goto L48
    L35:
        r108 = false;
        goto L36
    L29:
        r107 = null;
        goto L30
    L25:
        r106 = null;
        goto L26
    L21:
        r105 = null;
        goto L22
    L17:
        r104 = null;
        goto L18
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
