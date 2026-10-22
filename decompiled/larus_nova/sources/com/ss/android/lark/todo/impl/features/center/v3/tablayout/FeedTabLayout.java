package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/FeedTabLayout;", "Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstTabFilter", "Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;", "getFirstTabFilter", "updateFirstFilter", "", "feedFilter", "changeFixedGroup", KtvSubElement.CONTAINER, "Companion", "LayoutParams", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FeedTabLayout extends RefactoredFeedTabLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ContainerType f441742w;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000eB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0006\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/FeedTabLayout$LayoutParams;", "Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "width", "", "height", "(II)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "(IIF)V", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends RefactoredFeedTabLayout.LayoutParams {
        public LayoutParams() {
            super(-1);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final ContainerType getFirstTabFilter() {
        return this.f441742w;
    }

    public final void g(ContainerType r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (((ArrayList) getFeedSelector().f420837c).size() >= 2) goto L6;
        return;
    L6:
        if (r100 != ContainerType.OWNED_BY_ME_CONTAINER) goto L9;
        this.f441742w = r100;
        RefactoredFeedTabLayout.e(this, 0, true, 4);
        return;
    L9:
        if (r100 != ContainerType.FOLLOWED_BY_ME_CONTAINER) goto L13;
        RefactoredFeedTabLayout.e(this, 1, true, 4);
        return;
    }

    public FeedTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f441742w = ContainerType.OWNED_BY_ME_CONTAINER;
    }
}
