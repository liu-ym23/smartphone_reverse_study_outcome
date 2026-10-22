package com.larus.bmhome.chat.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VLMImage;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusDtImageAnalysisViewBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh8.c;
import sh8.g;
import sh8.h;
import sh8.i;
import sh8.j;
import sh8.m;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ \u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u001a\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J%\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00142\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0002J\"\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010/\u001a\u00020\u0012R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/markdown/view/DeepThinkImageAnalysisViewArch;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDtImageAnalysisViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusDtImageAnalysisViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "analysisImageMaxWidth", "", "analysisImageMaxHeight", "bindData", "", "imageList", "", "Lcom/larus/im/bean/message/VLMImage;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "maxWidth", "loadAnalysisImage", "loadBackgroundImage", "setImageLayoutParams", "imageWidth", "imageHeight", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "adjustImageRatio", "", "widthParams", "heightParams", "(Ljava/lang/Integer;Ljava/lang/Integer;)F", "openBigImage", "analysisImage", "getBigImageInfoList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "image", "mobCardShow", "view", "Landroid/view/View;", "imageCard", "realMobCardShow", "mobCardClick", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkImageAnalysisViewArch extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f307304d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f307305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f307306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f307307c;

    public static final class a {
    }

    static {
    }

    public final LarusDtImageAnalysisViewBinding getBinding() {
        return (LarusDtImageAnalysisViewBinding) this.f307305a.getValue();
    }

    public DeepThinkImageAnalysisViewArch(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DeepThinkImageAnalysisViewArch(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f307305a = LazyKt.lazy(new c(r100, this));
        this.f307307c = c7.b(164);
    }

    public final void a(List<VLMImage> r210, final f r211, int r212) {
        Intrinsics.checkNotNullParameter(r211, "markdownCommonInputData");
        this.f307306b = r212 - c7.b(16);
        String r100 = null;
        if (r210 == null) goto L38;
        Iterator<T> r101 = r210.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if ((!Intrinsics.areEqual(((VLMImage) r102).isBlurBackground(), Boolean.TRUE)) == false) goto L6;
    L11:
        final VLMImage r103 = (VLMImage) r102;
        if (r103 == null) goto L38;
        Integer r104 = r103.getWidth();
        Integer r105 = r103.getHeight();
        int r106 = 0;
        if (r104 == null) goto L17;
        int r107 = r104.intValue();
    L18:
        if (r105 == null) goto L20;
        r106 = r105.intValue();
    L20:
        if (r107 <= 0) goto L24;
        if (r106 <= 0) goto L24;
        float r108 = Math.max(0.4f, Math.min(2.5f, r107 / r106));
    L25:
        int r109 = this.f307307c;
        float r110 = r109 * r108;
        float r111 = this.f307306b;
        if (r110 <= r111) goto L28;
        r109 = (int) (r111 / r108);
        r110 = r111;
    L28:
        SimpleDraweeView r112 = getBinding().f358591b;
        int r113 = (int) r110;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(r113, r109);
        r114.gravity = 17;
        r112.setLayoutParams(r114);
        ShimmerMaskView r115 = getBinding().f358593d;
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(r113, r109);
        r116.gravity = 17;
        r115.setLayoutParams(r116);
        MessageImageLoader r117 = MessageImageLoader.f308183a;
        Message r118 = r211.f477072b;
        if (r118 == null) goto L31;
        String r119 = r118.getMessageId();
    L32:
        MessageImageType r120 = MessageImageType.IMAGE;
        SimpleDraweeView r121 = getBinding().f358591b;
        String r122 = r103.getThumbUrl();
        if (r122 != null) goto L35;
        r122 = "";
    L35:
        IMessageImageLoaderService.a.b(r117, r119, r120, r121, r122, "DeepThinkImageAnalysisView", null, null, new g(this), new h(this), new i(this), false, 1120);
        e1.d(getBinding().f358591b, new j(this, r103, r211));
        SimpleDraweeView r123 = getBinding().f358591b;
        if (r123 == null) goto L38;
        ExposeXTrackerExtKt.b(r123, new m(r103, this, r211));
        goto L38
    L31:
        r119 = null;
    L24:
        r108 = 1.0f;
        goto L25
    L17:
        r107 = 0;
        goto L18
    L10:
        r102 = null;
    L38:
        if (r210 == null) goto L47;
        Iterator<T> r124 = r210.iterator();
    L41:
        if (r124.hasNext() == false) goto L45;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((VLMImage) r125).isBlurBackground(), Boolean.TRUE) == false) goto L41;
    L46:
        VLMImage r126 = (VLMImage) r125;
    L48:
        SimpleDraweeView r127 = getBinding().f358592c;
        if (r126 == null) goto L51;
        String r128 = r126.getThumbUrl();
    L52:
        ImageLoaderKt.u(r127, r128, "DeepThinkImageAnalysisView");
        MessageImageLoader r129 = MessageImageLoader.f308183a;
        Message r130 = r211.f477072b;
        if (r130 == null) goto L55;
        String r131 = r130.getMessageId();
    L56:
        MessageImageType r132 = MessageImageType.IMAGE;
        SimpleDraweeView r133 = getBinding().f358592c;
        if (r126 == null) goto L59;
        r100 = r126.getThumbUrl();
    L59:
        IMessageImageLoaderService.a.a(r129, r131, r132, r133, r100, "DeepThinkImageAnalysisView", new sh8.f(this), 32);
        return;
    L55:
        r131 = null;
        goto L56
    L51:
        r128 = null;
        goto L52
    L45:
        r125 = null;
        goto L46
    L47:
        r126 = null;
        goto L48
    }
}
