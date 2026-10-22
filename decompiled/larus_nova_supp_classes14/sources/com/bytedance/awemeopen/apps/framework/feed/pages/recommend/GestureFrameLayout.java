package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", "a", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", "getGestureCallback", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", "setGestureCallback", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;)V", "gestureCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GestureFrameLayout extends FrameLayout {
    public a a;

    public interface a {
        void a();
    }

    public final a getGestureCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        return super.dispatchTouchEvent(r2);
    }

    public final void setGestureCallback(a r1) {
        this.a = r1;
    }

    public GestureFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        new LinkedHashMap();
        super(r2, r3);
    }
}
