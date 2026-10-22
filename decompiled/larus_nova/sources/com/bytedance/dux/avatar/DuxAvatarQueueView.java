package com.bytedance.dux.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.widget.DuxCircleImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enable", "", "setAdaptLargeFont", "(Ljava/lang/Boolean;)V", "", "Lcom/bytedance/dux/avatar/DuxAvatar;", "getAvatars", "Landroid/graphics/drawable/Drawable;", "drawables", "setAvatars", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxAvatarQueueView extends ConstraintLayout {
    public DuxAvatarQueueView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 14);
    }

    public DuxAvatarQueueView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 12);
    }

    public final List<DuxAvatar> getAvatars() {
        ArrayList r100 = new ArrayList();
        Iterator<View> r101 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        View r102 = r101.next();
        if ((r102 instanceof DuxAvatar) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public final void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        DuxLargeFontHelper.a(DuxAvatar.f204807i, r100);
    }

    public final void setAvatars(List<? extends Drawable> r100) {
        Intrinsics.checkNotNullParameter(r100, "drawables");
        int r101 = 0;
        Iterator<T> r102 = r100.subList(0, 5).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        int r104 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r105 = getChildAt(r101);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.dux.avatar.DuxAvatar");
        DuxCircleImageView r106 = ((DuxAvatar) r105).getContentImageView();
        r106.setImageDrawable((Drawable) r103);
        r101 = r104;
        goto L4
    }

    public DuxAvatarQueueView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Lazy r103 = DuxLargeFontHelper.f205243a;
        DuxLargeFontHelper.a(DuxAvatar.f204807i, null);
        ViewGroup.inflate(r100, R.layout.dux_widget_avatar_queue, this);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.limitLargeFontScale});
        if (r104.hasValue(0) == false) goto L9;
        setAdaptLargeFont(Boolean.valueOf(r104.getBoolean(0, false)));
    L9:
        if (r104.hasValue(1) == false) goto L11;
        r104.getBoolean(1, false);
    L11:
        r104.recycle();
    }
}
