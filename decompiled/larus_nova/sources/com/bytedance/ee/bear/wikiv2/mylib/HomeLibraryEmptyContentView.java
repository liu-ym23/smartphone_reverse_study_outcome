package com.bytedance.ee.bear.wikiv2.mylib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "onReloadListener", "Landroid/view/View$OnClickListener;", "onEmptyCreateListener", "showLibCreateFail", "", "showLibEmptyContent", "hide", "setOnReloadListener", "onClickListener", "setOnEmptyCreateListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeLibraryEmptyContentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpaceEmptyState f241023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f241024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f241025c;

    public final void setOnEmptyCreateListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.f241025c = r100;
    }

    public final void setOnReloadListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.f241024b = r100;
    }

    public HomeLibraryEmptyContentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        SpaceEmptyState r102 = new SpaceEmptyState(r100);
        this.f241023a = r102;
        r102.setBackgroundResource(R.color.bg_body);
        r102.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        addView(r102, -1, -1);
    }
}
