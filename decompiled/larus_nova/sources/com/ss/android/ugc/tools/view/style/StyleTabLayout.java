package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleTabLayout;", "Lcom/ss/android/ugc/aweme/shortvideo/sticker/widget/tablayout/TabLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleTabLayout extends TabLayout {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f454969J;
    public int K;
    public int L;

    public static final class a {
    }

    static {
    }

    public StyleTabLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout
    public final void b(TabLayout.OnTabSelectedListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f454969J = r100;
    }

    public StyleTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.K = r100.getResources().getColor(R.color.tools_styleview_text_selected);
        this.L = r100.getResources().getColor(R.color.tools_styleview_text_unselected);
        setOverScrollMode(2);
        int r103 = this.L;
        int r104 = this.K;
        setTabTextColors(new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r104, r103}));
        setSelectedTabIndicatorColor(this.K);
        setTabMargin(14);
        super.b(new d(this));
    }

    public /* synthetic */ StyleTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
