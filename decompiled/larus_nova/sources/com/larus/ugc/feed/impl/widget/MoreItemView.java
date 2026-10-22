package com.larus.ugc.feed.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCommonMoreItemKmpBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import e1a.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/ugc/feed/impl/widget/MoreItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/ugc/feed/impl/databinding/LarusCommunityCommonMoreItemKmpBinding;", "onErrorClickListener", "Lkotlin/Function0;", "", "disableEndView", "", "setDisableEndView", "setOnErrorClickListener", "updateStatus", "state", "Lcom/larus/ugc/feed/api/state/LoadMoreState;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreItemView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f375093d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCommonMoreItemKmpBinding f375094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f375095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f375096c;

    public MoreItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MoreItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setDisableEndView(boolean r100) {
        this.f375096c = r100;
    }

    public final void setOnErrorClickListener(Function0<Unit> r100) {
        this.f375095b = r100;
    }

    public MoreItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_common_more_item_kmp, this);
        int r103 = R.id.end_view;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.end_view);
        if (r104 == null) goto L11;
        r103 = R.id.error_lay;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.error_lay);
        if (r105 == null) goto L11;
        r103 = R.id.loading_view;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view);
        if (r106 == null) goto L11;
        this.f375094a = new LarusCommunityCommonMoreItemKmpBinding(this, r104, r105, r106);
        e1.d(r105, new b(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ MoreItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
