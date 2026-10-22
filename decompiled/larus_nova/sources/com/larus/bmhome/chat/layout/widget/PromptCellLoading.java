package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusPromptLoadingBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/PromptCellLoading;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusPromptLoadingBinding;", "setLoadingStyle", "", "style", "CellLoadingStyle", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptCellLoading extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusPromptLoadingBinding f304853a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/PromptCellLoading$CellLoadingStyle;", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CellLoadingStyle {
        public static final a Companion = null;
        public static final int Horizontal = 2;
        public static final int Undefined = 0;
        public static final int Vertical = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f304854a = null;

            static {
                f304854a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f304854a;
        }
    }

    public PromptCellLoading(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromptCellLoading(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setLoadingStyle(int r100) {
        if (r100 != 1) goto L5;
        this.f304853a.f324061c.setVisibility(0);
        this.f304853a.f324060b.setVisibility(8);
        return;
    L5:
        if (r100 != 2) goto L11;
        this.f304853a.f324060b.setVisibility(0);
        this.f304853a.f324061c.setVisibility(8);
        return;
    }

    public PromptCellLoading(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_prompt_loading, this);
        int r103 = R.id.loading_1;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_1)) == null) goto L29;
        r103 = R.id.loading_2;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_2)) == null) goto L29;
        r103 = R.id.loading_3;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_3)) == null) goto L29;
        r103 = R.id.loading_4;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_4)) == null) goto L29;
        r103 = R.id.loading_container_first_met;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.loading_container_first_met);
        if (r104 == null) goto L29;
        r103 = R.id.loading_container_wcb;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.loading_container_wcb);
        if (r105 == null) goto L29;
        r103 = R.id.loading_first_1;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_1)) == null) goto L29;
        r103 = R.id.loading_first_2;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_2)) == null) goto L29;
        r103 = R.id.loading_first_3;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_3)) == null) goto L29;
        r103 = R.id.loading_first_4;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_4)) == null) goto L29;
        r103 = R.id.loading_first_5;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_5)) == null) goto L29;
        r103 = R.id.loading_first_6;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loading_first_6)) == null) goto L29;
        this.f304853a = new LarusPromptLoadingBinding(this, r104, r105);
        return;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ PromptCellLoading(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
