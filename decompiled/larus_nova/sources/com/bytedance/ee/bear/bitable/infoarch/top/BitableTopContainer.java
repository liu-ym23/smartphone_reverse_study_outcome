package com.bytedance.ee.bear.bitable.infoarch.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.bitable.core.nested.ElasticAppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/top/BitableTopContainer;", "Lcom/bytedance/ee/bear/bitable/core/nested/ElasticAppBarLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interceptTouchEvent", "", "setInterceptListener", "", "listener", "Lkotlin/Function0;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTopContainer extends ElasticAppBarLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f213710b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f213711a;

        public a(Function0<Unit> r100) {
            this.f213711a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f213711a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public BitableTopContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f213710b == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setInterceptListener(Function0<Unit> r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.f213710b = r101;
        if (r100 == null) goto L8;
        setOnClickListener(new a(r100));
        return;
    L8:
        setOnClickListener(null);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public BitableTopContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_top_container_layout, this, true);
        setClipChildren(false);
    }
}
