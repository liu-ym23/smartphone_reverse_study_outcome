package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt8.c0;
import bt8.d0;
import bt8.e0;
import bt8.f0;
import bt8.g0;
import bt8.h0;
import bt8.i0;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J,\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMultiMediaSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "subTitleView", "Landroid/widget/TextView;", "contentRow", "Landroid/widget/LinearLayout;", "init", "", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "Lcom/larus/bmhome/instruction/core/model/widget/MultiMediaSelectorDescriptor;", "createAddTile", "Landroid/view/View;", "text", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "createThumbnail", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "onRemove", "loadThumbnail", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "thumbLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "withLeftMargin", "", "dp", "value", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMultiMediaSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f316656h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f316657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f316658g;

    public static final class a {
    }

    static {
    }

    public KmpMultiMediaSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpMultiMediaSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [bt8.d0] */
    /* JADX WARN: Type inference failed for: r13v0, types: [bt8.e0] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        a0 r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((r100 instanceof k0) == true) goto L5;
        r100 = null;
    L5:
        final k0 r101 = (k0) r100;
        if (r101 == null) goto L74;
        List<MediaAttachment> r102 = r101.f464873f;
        FLogger.f375446a.i("KmpMultiMediaSelectorWidget", "[bind] attachments:" + r102.size());
        String r103 = r101.f464875h;
        boolean r104 = false;
        if (o0.d(r103) == false) goto L17;
        TextView r105 = this.f316657f;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r105 = null;
    L13:
        r105.setText(r103);
        TextView r106 = this.f316657f;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r106 = null;
    L16:
        r106.setVisibility(0);
    L21:
        LinearLayout r107 = this.f316658g;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        r107 = null;
    L24:
        r107.removeAllViews();
        String r108 = r101.f464874g;
        if (r108 != null) goto L27;
    L31:
        r108 = "参考图";
    L33:
        if (r102.isEmpty() == false) goto L39;
        LinearLayout r109 = this.f316658g;
        if (r109 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        LinearLayout r111 = null;
    L38:
        r111.addView(V5(r108, new c0(r101)), Z5(false));
        return;
    L37:
        r111 = r109;
        goto L38
    L39:
        Iterator<T> r112 = r102.iterator();
        int r113 = 0;
    L41:
        if (r112.hasNext() == false) goto L64;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        final MediaAttachment r116 = (MediaAttachment) r114;
        LinearLayout r117 = this.f316658g;
        LinearLayout r118 = r117;
        if (r117 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        r118 = null;
    L48:
        final ?? r119 = new d0(r101, r116);
        final ?? r120 = new e0(r101, r116);
        FrameLayout r121 = new FrameLayout(getContext());
        CardView r122 = new CardView(getContext());
        r122.setRadius(Y5(6));
        r122.setCardElevation(0.0f);
        r122.setUseCompatPadding(r104);
        r122.setLayoutParams(new FrameLayout.LayoutParams(Y5(84), Y5(84)));
        SimpleDraweeView r123 = new SimpleDraweeView(getContext());
        r123.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        e1.d(r123, new h0(r119));
        String r124 = r116.getLocalFilePath();
        if (o0.d(r124) == false) goto L53;
        Intrinsics.checkNotNull(r124);
        if (new PolarisFileWrapper(r124).exists() == false) goto L53;
        ImageLoaderKt.s(r123, Uri.fromFile(new PolarisFileWrapper(r124)), null);
    L59:
        r122.addView(r123);
        r121.addView(r122);
        AppCompatImageView r125 = new AppCompatImageView(getContext());
        r125.setImageResource(R.drawable.larus_kmp_ic_multi_media_remove);
        FrameLayout.LayoutParams r126 = new FrameLayout.LayoutParams(Y5(16), Y5(16));
        r126.gravity = 8388661;
        r126.topMargin = Y5(4);
        r126.rightMargin = Y5(4);
        r125.setLayoutParams(r126);
        e1.d(r125, new i0(r120));
        r121.addView(r125);
        if (r113 <= 0) goto L62;
        boolean r127 = true;
    L63:
        r118.addView(r121, Z5(r127));
        r113 = r115;
        r104 = false;
        goto L41
    L62:
        r127 = false;
    L53:
        String r128 = r116.getPreviewUrl();
        if (r128 != null) goto L58;
        r128 = r116.getUrl();
        if (r128 != null) goto L58;
        r128 = r116.getOriginUrl();
    L58:
        ImageLoaderKt.u(r123, r128, "instruction_reference_image");
        goto L59
    L64:
        LinearLayout r129 = this.f316658g;
        if (r129 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        LinearLayout r130 = null;
    L68:
        r130.addView(V5(r108, new f0(r101)), Z5(true));
        return;
    L67:
        r130 = r129;
        goto L68
    L27:
        if ((!StringsKt.isBlank(r108)) == true) goto L30;
        r108 = null;
    L30:
        if (r108 != null) goto L33;
    L17:
        TextView r131 = this.f316657f;
        if (r131 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r131 = null;
    L20:
        r131.setVisibility(8);
        goto L21
    }

    public final int Y5(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final LinearLayout.LayoutParams Z5(boolean r100) {
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(Y5(84), Y5(84));
        if (r100 == false) goto L5;
        r101.leftMargin = Y5(8);
    L5:
        return r101;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r102 = new LinearLayout(r100);
        r102.setOrientation(1);
        r102.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        TextView r103 = new TextView(r100);
        r103.setTextColor(-1728053248);
        r103.setTextSize(2, 12.0f);
        r103.setVisibility(8);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.leftMargin = Y5(14);
        r104.bottomMargin = Y5(6);
        r103.setLayoutParams(r104);
        this.f316657f = r103;
        LinearLayout r105 = new LinearLayout(r100);
        r105.setOrientation(0);
        r105.setPadding(Y5(14), 0, Y5(14), Y5(12));
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f316658g = r105;
        TextView r106 = this.f316657f;
        LinearLayout r107 = null;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r106 = null;
    L5:
        r102.addView(r106);
        LinearLayout r108 = this.f316658g;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
    L9:
        r102.addView(r107);
        addView(r102);
        return;
    L8:
        r107 = r108;
        goto L9
    }

    public final View V5(String r100, final Function0<Unit> r101) {
        LinearLayout r102 = new LinearLayout(getContext());
        r102.setOrientation(1);
        r102.setGravity(17);
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(Y5(6));
        r103.setColor(251684607);
        r102.setBackground(r103);
        e1.d(r102, new g0(r101));
        AppCompatImageView r104 = new AppCompatImageView(getContext());
        r104.setImageResource(R.drawable.larus_kmp_ic_multi_media_add);
        r102.addView(r104, new LinearLayout.LayoutParams(Y5(20), Y5(20)));
        TextView r105 = new TextView(getContext());
        r105.setText(r100);
        r105.setTextColor(-16750849);
        r105.setTextSize(2, 11.0f);
        r105.setGravity(17);
        r105.setIncludeFontPadding(false);
        r105.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.topMargin = Y5(6);
        Unit r107 = Unit.INSTANCE;
        r102.addView(r105, r106);
        return r102;
    }

    public KmpMultiMediaSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KmpMultiMediaSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
