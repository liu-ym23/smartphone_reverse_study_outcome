package com.larus.camera.impl.widget.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.databinding.LarusLayoutTitleRightIconViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0011J\u001f\u0010\u0012\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0011J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/widget/title/TitleRightIconView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutTitleRightIconViewBinding;", "setHint", "", "func", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "setIcon", "Landroid/widget/ImageView;", "useCenteredCircularIcon", "iconSize", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightIconView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutTitleRightIconViewBinding f322927a;

    public TitleRightIconView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleRightIconView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setHint(Function1<? super TextView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f322927a.f321513b);
    }

    public final void setIcon(Function1<? super ImageView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f322927a.f321514c);
    }

    public TitleRightIconView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_title_right_icon_view, this, false);
        addView(r103);
        int r104 = R.id.hint;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.hint);
        if (r105 == null) goto L9;
        r104 = R.id.icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r103, R.id.icon);
        if (r106 == null) goto L9;
        this.f322927a = new LarusLayoutTitleRightIconViewBinding((LinearLayout) r103, r105, r106);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ TitleRightIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
