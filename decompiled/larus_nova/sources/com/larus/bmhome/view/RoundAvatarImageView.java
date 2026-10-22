package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J6\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/view/RoundAvatarImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "setAvatarUrl", "url", "", "bizTag", "needResize", "", "controllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundAvatarImageView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315590a = 0;

    public RoundAvatarImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        init(r100, null);
    }

    public RoundAvatarImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.avatar_placeholder});
        int r103 = r102.getResourceId(0, -1);
        r102.recycle();
    L6:
        GenericDraweeHierarchy r104 = getHierarchy();
        RoundingParams r105 = getHierarchy().getRoundingParams();
        if (r105 == null) goto L10;
        RoundingParams r106 = r105.setRoundAsCircle(true);
        if (r106 == null) goto L10;
    L11:
        r104.setRoundingParams(r106);
        if (r103 != (-1)) goto L14;
        r103 = R.drawable.larus_common_ui_avatar_placeholder;
    L14:
        r104.setPlaceholderImage(r103);
        r104.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
    L10:
        r106 = RoundingParams.asCircle();
        goto L11
    L5:
        r103 = -1;
        goto L6
    }

    public RoundAvatarImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        init(r100, r101);
    }

    public static void f(final RoundAvatarImageView r100, String r101, String r102, final boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.getClass();
        final BaseControllerListener r105 = null;
        ImageLoaderKt.y(r100, r101, r102, new c4(r100, r105, r103), 4);
    }
}
