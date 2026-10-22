package com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.legacy.widget.Space;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.databinding.LarusLayoutBotBgImagePreviewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJA\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\rJ\u0012\u0010\u0019\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/BotBgImagePreviewView;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/FixedAspectRatioConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotBgImagePreviewBinding;", "setBgImage", "", "uri", "Landroid/net/Uri;", "disableCache", "", "onFinalImageSet", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "setCurBitmapAsPlaceholder", "showColorPicking", "refreshShading", "color", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotBgImagePreviewView extends FixedAspectRatioConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f319034e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusLayoutBotBgImagePreviewBinding f319035d;

    public static final class a {
    }

    static {
    }

    public BotBgImagePreviewView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BotBgImagePreviewView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public BotBgImagePreviewView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_bot_bg_image_preview, this);
        int r102 = R.id.bubble1;
        FixedAspectRatioConstraintLayout r103 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, R.id.bubble1);
        if (r103 == null) goto L19;
        r102 = R.id.bubble2;
        FixedAspectRatioConstraintLayout r104 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, R.id.bubble2);
        if (r104 == null) goto L19;
        r102 = R.id.bubble3;
        FixedAspectRatioConstraintLayout r105 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, R.id.bubble3);
        if (r105 == null) goto L19;
        r102 = R.id.image;
        SimpleDraweeView r106 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.image);
        if (r106 == null) goto L19;
        r102 = R.id.shading;
        View r107 = ViewBindings.findChildViewById(this, R.id.shading);
        if (r107 == null) goto L19;
        r102 = R.id.space_left;
        if (((Space) ViewBindings.findChildViewById(this, R.id.space_left)) == null) goto L19;
        r102 = R.id.space_right;
        if (((Space) ViewBindings.findChildViewById(this, R.id.space_right)) == null) goto L19;
        this.f319035d = new LarusLayoutBotBgImagePreviewBinding(this, r103, r104, r105, r106, r107);
        setAspectRatio(0.5f);
        setRadiusHeightRatio(0.0625f);
        setBackgroundColor(r100.getResources().getColor(R.color.larus_neutral_transparent_1));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ BotBgImagePreviewView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
