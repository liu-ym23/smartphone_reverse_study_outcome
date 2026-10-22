package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", "getGestureCallback", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;", "setGestureCallback", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/GestureFrameLayout$a;)V", "gestureCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GestureFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f195054a;

    public interface a {
        void a();
    }

    public final a getGestureCallback() {
        return this.f195054a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        a r101 = this.f195054a;
        if (r101 == null) goto L6;
        r101.a();
    L6:
        return super.dispatchTouchEvent(r100);
    }

    public final void setGestureCallback(a r100) {
        this.f195054a = r100;
    }

    public GestureFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        new LinkedHashMap();
        super(r100, r101);
    }
}
