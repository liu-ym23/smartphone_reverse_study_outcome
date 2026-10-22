package com.larus.office.base.plugins.toolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/view/HorizontalOverScrollView;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOnScrollChangedListeners", "", "Lcom/larus/office/base/plugins/toolbar/view/HorizontalOverScrollView$OnScrollChangedListener;", "onScrollChanged", "", "l", "", "t", "oldl", "oldt", "addScrollChangedListener", "listener", "removeScrollChangedListener", "OnScrollChangedListener", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalOverScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f360971a;

    public interface a {
        void onScrollChanged();
    }

    public HorizontalOverScrollView(Context r100) {
        super(r100);
        this.f360971a = new ArrayList();
    }

    public HorizontalOverScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f360971a = new ArrayList();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (((ArrayList) this.f360971a).size() <= 0) goto L8;
        Iterator r104 = ((ArrayList) this.f360971a).iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        a r105 = (a) r104.next();
        getScrollX();
        getScrollY();
        r105.onScrollChanged();
        goto L6
    L10:
        return;
    }
}
