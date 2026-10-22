package com.bytedance.ee.bear.doc.syncblock;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockLoadingLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnRetryListener", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout$OnRetryListener;", "setOnRetryListener", "", "fail", "errCode", "errMsg", "", "loading", "show", "hide", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncBlockLoadingLayout extends FrameLayout {
    public LoadingLayout.c a;

    public SyncBlockLoadingLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0, 0);
    }

    public final void a(int r8) {
        setOnClickListener(null);
        setVisibility(0);
        View r1 = findViewById(2131378741);
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        SpaceEmptyState r2 = findViewById(2131372043);
        r2.setVisibility(0);
        if (r8 != 4) goto L8;
        r2.setImageRes(2131232545);
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        r2.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(2131888103)}, 1)));
        return;
    L8:
        if (r8 == 1002) goto L10;
        r2.setImageRes(2131232542);
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        r2.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(2131887767)}, 1)));
        setOnClickListener(new d(this, r8));
        return;
    L10:
        r2.setImageRes(2131232580);
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        r2.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(2131889296)}, 1)));
    }

    public final void setOnRetryListener(LoadingLayout.c r2) {
        Intrinsics.checkNotNullParameter(r2, "mOnRetryListener");
        this.a = r2;
    }

    public SyncBlockLoadingLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0, 0);
    }

    public SyncBlockLoadingLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    public SyncBlockLoadingLayout(Context r1, AttributeSet r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3, 0);
        FrameLayout.inflate(getContext(), 2131560079, this);
    }
}
