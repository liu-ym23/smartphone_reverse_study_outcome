package com.bytedance.ee.bear.wikiv2.mylib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "onReloadListener", "Landroid/view/View$OnClickListener;", "onEmptyCreateListener", "showLibCreateFail", "", "showLibEmptyContent", "hide", "setOnReloadListener", "onClickListener", "setOnEmptyCreateListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeLibraryEmptyContentView extends FrameLayout {
    public final SpaceEmptyState a;
    public View.OnClickListener b;
    public View.OnClickListener c;

    public final void setOnEmptyCreateListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.c = r2;
    }

    public final void setOnReloadListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.widget.LinearLayout, com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState, com.larksuite.component.universe_design.emptystate.UDEmptyState] */
    public HomeLibraryEmptyContentView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ?? r4 = new SpaceEmptyState(r2);
        this.a = r4;
        r4.setBackgroundResource(2131100548);
        r4.setImageSizeResource(2131165486);
        addView(r4, -1, -1);
    }
}
