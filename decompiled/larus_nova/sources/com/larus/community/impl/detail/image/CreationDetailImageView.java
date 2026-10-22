package com.larus.community.impl.detail.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailImageLayoutBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0018H\u0002J\n\u0010#\u001a\u0004\u0018\u00010 H\u0002J\u0014\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u00020&\"\u00020\u0018H\u0002J6\u0010'\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0016\u0010(\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationDetailImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailImageLayoutBinding;", "onImageLongPressListener", "Lkotlin/Function0;", "", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onImageDoubleTapListener", "getOnImageDoubleTapListener", "setOnImageDoubleTapListener", "screenWidth", "", "screenHeight", "getImageView", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "bindImageData", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "buildCreationResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "buildFullSizeResizeOptions", "resizeSize", "buildContainerResizeOptions", "firstValidSize", "sizes", "", "bindAction", "adjustContainerSize", "hasExtraList", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f329287g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationDetailImageLayoutBinding f329288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f329289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f329290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f329291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f329292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f329293f;

    public final CreationZoomableDraweeView getImageView() {
        return this.f329288a.f329045c;
    }

    public final Function0<Unit> getOnImageDoubleTapListener() {
        return this.f329291d;
    }

    public final Function0<Unit> getOnImageLongPressListener() {
        return this.f329289b;
    }

    public final Function0<Unit> getOnImageScaleListener() {
        return this.f329290c;
    }

    public CreationDetailImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final int R5(int... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        int r103 = r100[r102];
        boolean r104 = true;
        if (r103 > 1) goto L8;
        r104 = false;
    L8:
        if (r104 == true) goto L9;
        r102 = r102 + 1;
        goto L3
    L9:
        Integer r105 = Integer.valueOf(r103);
    L12:
        if (r105 != null) goto L14;
        return 0;
    L14:
        return r105.intValue();
    L11:
        r105 = null;
        goto L12
    }

    public final void setOnImageDoubleTapListener(Function0<Unit> r100) {
        this.f329291d = r100;
    }

    public final void setOnImageLongPressListener(Function0<Unit> r100) {
        this.f329289b = r100;
    }

    public final void setOnImageScaleListener(Function0<Unit> r100) {
        this.f329290c = r100;
    }

    public CreationDetailImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_creation_detail_image_layout, this);
        int r102 = R.id.container;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.container);
        if (r103 == null) goto L9;
        r102 = R.id.image_view;
        CreationZoomableDraweeView r104 = (CreationZoomableDraweeView) ViewBindings.findChildViewById(this, R.id.image_view);
        if (r104 == null) goto L9;
        this.f329288a = new LarusCommunityCreationDetailImageLayoutBinding(this, r103, r104);
        this.f329292e = com.larus.utils.i.d(r100);
        this.f329293f = com.larus.utils.i.c(r100);
        r104.getHierarchy().setActualImageColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(r100, R.color.larus_press), BlendModeCompat.DST_OVER));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
