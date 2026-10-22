package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/view/TitleAvatarImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleAvatarImageView extends SimpleDraweeView {
    public TitleAvatarImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        init(r100, null);
    }

    public TitleAvatarImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        GenericDraweeHierarchy r102 = getHierarchy();
        RoundingParams r103 = getHierarchy().getRoundingParams();
        if (r103 == null) goto L6;
        RoundingParams r104 = r103.setRoundAsCircle(true);
        if (r104 == null) goto L6;
    L7:
        r102.setRoundingParams(r104);
        Integer r105 = com.larus.platform.api.d2.f365089a.a();
        if (r105 == null) goto L10;
        r102.setFailureImage(r105.intValue());
    L10:
        r102.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
    L6:
        r104 = RoundingParams.asCircle();
        goto L7
    }

    public TitleAvatarImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        init(r100, r101);
    }
}
