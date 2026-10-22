package com.larus.office.card.ppt;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageLoadingDrawPartType;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.home.impl.sdk.SdkSlidesServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.Cover;
import com.larus.im.bean.message.block.ImageMeta;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.office.card.databinding.LarusCardSlidePptBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
public final class k extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f361590f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f361591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f361592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChatParam f361593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f361594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f361595e;

    public static final class a {
    }

    static {
    }

    private final LarusCardSlidePptBinding getBinding() {
        return (LarusCardSlidePptBinding) this.f361591a.getValue();
    }

    private final int getDefaultPreviewAnimationHeight() {
        return ((Number) this.f361595e.getValue()).intValue();
    }

    public k(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f361591a = LazyKt.lazy(new d(r100, this));
        this.f361595e = LazyKt.lazy(new e(r100));
    }

    public static final /* synthetic */ LarusCardSlidePptBinding b(k r100) {
        return r100.getBinding();
    }

    public final void e(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r101 = getBinding().f361312d.getLayoutParams();
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        ImageWebpLoadingBgView r103 = getBinding().f361312d;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L16;
        r104.height = r100;
        r103.setLayoutParams(r104);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L7:
        if (r101.height != r100) goto L9;
        r102 = true;
        goto L9
    }

    public static final void c(k r100, Object r101, int r102) {
        if (r100.f361594d == false) goto L30;
        if (r102 <= 0) goto L34;
        if (r101 != null) goto L9;
        return;
    L9:
        if ((r101 instanceof ImageInfo) == false) goto L36;
        ImageInfo r103 = (ImageInfo) r101;
        Integer r104 = Integer.valueOf(r103.getWidth());
        boolean r105 = false;
        if (r104.intValue() <= 0) goto L14;
        boolean r106 = true;
    L15:
        Integer r107 = null;
        if (r106 == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L31;
        int r108 = r104.intValue();
        Integer r109 = Integer.valueOf(r103.getHeight());
        if (r109.intValue() <= 0) goto L23;
        r105 = true;
    L23:
        if (r105 == false) goto L25;
        r107 = r109;
    L25:
        if (r107 == null) goto L32;
        int r110 = RangesKt.coerceAtLeast(MathKt.roundToInt((r102 * r107.intValue()) / r108), 1);
        if (r110 >= r100.getDefaultPreviewAnimationHeight()) goto L33;
        r100.e(r110);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        r106 = false;
        goto L15
    L36:
        return;
    L34:
        return;
    }

    public static Unit a(k r100, int r101, PipelineDraweeControllerBuilder r102, Uri r103) {
        Intrinsics.checkNotNullParameter(r102, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r103, "it");
        r102.setOldController(r100.getBinding().f361311c.getController());
        r102.setControllerListener(new l(r100, r101));
        r102.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r103).build());
        return Unit.INSTANCE;
    }

    public final void d(final Fragment r210, final Block r211, final Message r212, final String r213, final int r214, ChatParam r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r211, "block");
        Intrinsics.checkNotNullParameter(r212, "message");
        FLogger r110 = FLogger.f375446a;
        StringBuilder r100 = new StringBuilder("Slides webview preload config: ");
        z2 r101 = z2.f365865a;
        r100.append(r101.v0());
        r110.i("SlidesPPTCard", r100.toString());
        if (LarkConnectorArtifactService.f365709a.c(r212) == false) goto L5;
    L9:
        BlockContent r102 = r211.getContent();
        if (r102 == null) goto L12;
        ArtifactBlock r111 = r102.getDocBlock();
    L13:
        this.f361593c = r215;
        this.f361594d = r216;
        if (r111 != null) goto L16;
        return;
    L16:
        LarusCardSlidePptBinding r103 = getBinding();
        if (r214 > 0) goto L19;
    L25:
        ViewGroup.LayoutParams r104 = r103.f361309a.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        r103.f361309a.setLayoutParams((ViewGroup.MarginLayoutParams) r104);
        final ArtifactBlock r105 = r111;
        e1.d(r103.f361309a, new h(this, r105, r212, r213, r210));
        r110.d("SlidesPPTCard", "updateBriefImage artifactBlock=" + GsonProtectorUtils.toJson(new Gson(), r111));
        Integer r106 = r111.getStatus();
        ArtifactStatus r107 = ArtifactStatus.GENERATED;
        int r108 = r107.getValue();
        boolean r109 = true;
        if (r106 != null) goto L29;
    L31:
        boolean r112 = false;
    L32:
        if (r112 == false) goto L34;
        getBinding().f361316h.setText(getContext().getString(R.string.larus_slides_artifact_btn_view));
        getBinding().f361316h.setTextColor(v19.c.a(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70));
        getBinding().f361310b.setImageResource(R.drawable.larus_officecard_ic_ppt_generation_orange);
        getBinding().f361310b.setImageTintList(null);
    L35:
        e1.x(getBinding().f361313e);
        e(getDefaultPreviewAnimationHeight());
        Cover r113 = r111.getBriefImage();
        if (r113 == null) goto L40;
        ImageMeta r114 = r113.getImageThumb();
        if (r114 == null) goto L40;
        String r115 = r114.getUrl();
    L42:
        if (o0.d(r115) == false) goto L44;
        String r116 = r115;
    L53:
        ImageLoaderKt.y(getBinding().f361311c, r116, "gen_ppt_preview", new f(this, r214), 4);
        Integer r117 = r111.getStatus();
        int r118 = r107.getValue();
        if (r117 != null) goto L57;
    L59:
        boolean r119 = false;
    L60:
        if (r119 == false) goto L62;
        ViewGroup.LayoutParams r120 = getBinding().f361314f.getLayoutParams();
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        r121.setMargins(0, 0, 0, 0);
        getBinding().f361314f.setLayoutParams(r121);
        getBinding().f361314f.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.larus_place_holder_ppt_generation_border));
        ImageLoadingDrawPartType r122 = null;
    L63:
        com.larus.bmhome.chat.layout.holder.progressloading.e r123 = IAIChatUgcAIGCService.f365905a.x0();
        ImageWebpLoadingBgView r124 = getBinding().f361312d;
        int r125 = ImageWebpLoadingBgView.f304021d;
        r124.f(r123, false, r122, "gen_ppt_preview_loading_bg");
        Integer r126 = r111.getStatus();
        int r127 = ArtifactStatus.OUTDATED.getValue();
        if (r126 != null) goto L67;
    L69:
        boolean r128 = false;
    L70:
        if (r128 == true) goto L81;
        Integer r129 = r111.getStatus();
        int r130 = ArtifactStatus.UNSUPPORTED.getValue();
        if (r129 != null) goto L75;
    L77:
        r109 = false;
    L78:
        if (r109 == true) goto L81;
        e1.x(getBinding().f361312d);
        e1.x(getBinding().f361314f);
        e1.o(getBinding().f361315g);
    L82:
        TextView r131 = getBinding().f361317i;
        String r132 = r111.getTitle();
        if (r132 != null) goto L86;
        r132 = "";
    L86:
        r131.setText(r132);
        int r133 = qn9.a.f534115a;
        qn9.a.a(getContext(), r111, r212, r213, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SlidesPPTCard$mobShowCard$1(r212, this, r111, null), 3, null);
        final ArtifactBlock r134 = r111;
        ExposeXTrackerExtKt.b(this, new g(r212, r211, this, r134, r213));
        return;
    L75:
        if (r129.intValue() != r130) goto L77;
    L81:
        e1.o(getBinding().f361312d);
        e1.o(getBinding().f361314f);
        e1.x(getBinding().f361315g);
        goto L82
    L67:
        if (r126.intValue() != r127) goto L69;
        r128 = true;
        goto L70
    L62:
        ViewGroup.LayoutParams r135 = getBinding().f361314f.getLayoutParams();
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r136 = (ViewGroup.MarginLayoutParams) r135;
        r136.setMargins(i5.Y(), i5.Y(), i5.Y(), i5.Y());
        getBinding().f361314f.setLayoutParams(r136);
        r122 = null;
        getBinding().f361314f.setBackground(null);
        goto L63
    L57:
        if (r117.intValue() != r118) goto L59;
        r119 = true;
        goto L60
    L44:
        if (r113 == null) goto L48;
        ImageMeta r137 = r113.getImagePreview();
        if (r137 == null) goto L48;
        r116 = r137.getUrl();
    L50:
        if (o0.d(r116) == true) goto L53;
        r116 = null;
    L48:
        r116 = null;
    L40:
        r115 = null;
        goto L42
    L34:
        getBinding().f361316h.setText(getContext().getString(R.string.larus_slides_push_header_generating));
        getBinding().f361316h.setTextColor(v19.c.a(R.attr.larus_neutral_transparent_3, getContext(), R.color.larus_neutral_transparent_3));
        getBinding().f361310b.setImageResource(R.drawable.larus_ic_ppt_generating);
        getBinding().f361310b.setImageTintList(ContextCompat.getColorStateList(getContext(), v19.c.b(R.attr.larus_neutral_transparent_3, getContext(), R.color.larus_neutral_transparent_3)));
        goto L35
    L29:
        if (r106.intValue() != r108) goto L31;
        r112 = true;
        goto L32
    L19:
        if (r103.f361309a.getWidth() == r214) goto L25;
        View r138 = r103.f361309a;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if (r139 == null) goto L24;
        r139.width = r214;
        r138.setLayoutParams(r139);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        r111 = null;
        goto L13
    L5:
        if (r101.v0() == false) goto L9;
        IFlowSdkDepend r140 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r140 == null) goto L9;
        r140.E0();
        SdkSlidesServiceImpl.f346131a.m();
        goto L9
    }
}
