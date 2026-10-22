package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_res.common_ui.databinding.LarusLayoutAvatarTagViewBinding;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0007J$\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/AvatarTagView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutAvatarTagViewBinding;", "setStrokeBackgroundDrawable", "", "corner", "", "normalColor", "pressedColor", LynxTemplateRender.RENDER_PHASE_SETUP, "iconLightUrl", "", "iconDarkUrl", "enableCircle", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarTagView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f328381b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutAvatarTagViewBinding f328382a;

    public static final class a {
    }

    static {
    }

    public AvatarTagView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AvatarTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public AvatarTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_avatar_tag_view, this);
        int r103 = R.id.avatar_tag_icon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.avatar_tag_icon);
        if (r104 == null) goto L9;
        r103 = R.id.avatar_tag_parent;
        CircleFrameLayout r105 = (CircleFrameLayout) ViewBindings.findChildViewById(this, R.id.avatar_tag_parent);
        if (r105 == null) goto L9;
        this.f328382a = new LarusLayoutAvatarTagViewBinding(this, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public static void a(AvatarTagView r100, String r101, String r102) {
        r100.f328382a.f326748c.a(true);
        SimpleDraweeView r103 = r100.f328382a.f326747b;
        r103.getHierarchy().setFailureImage(R.drawable.larus_ic_avatar_tag_call);
        boolean r104 = h.f552477a;
        if (h.b(r103.getContext()) == false) goto L5;
        FLogger.f375446a.d("AvatarTagView", "[setupAvatarTag] iconDarkUrl: " + r102);
        r101 = r102;
    L6:
        ImageLoaderKt.v(r103, r101, "bot_ic_avatar_tag", null, new z19.a());
        return;
    L5:
        FLogger.f375446a.d("AvatarTagView", "[setupAvatarTag] iconLightUrl: " + r101);
        goto L6
    }

    public /* synthetic */ AvatarTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
