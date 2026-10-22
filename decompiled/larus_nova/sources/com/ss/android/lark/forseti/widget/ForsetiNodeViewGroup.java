package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNodeViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/api/ui/IForsetiNodeDisplayListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "curDisplayMode", "Lcom/ss/android/lark/api/bean/ForsetiNodeMode;", "displayListenerList", "", "onDisplayModeChanged", "", "mode", "addDisplayListener", "listener", "removeDisplayListener", "onDetachedFromWindow", "requestLayout", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNodeViewGroup extends FrameLayout implements com.ss.android.lark.api.ui.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ForsetiNodeMode f424622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.api.ui.c> f424623b;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((ArrayList) this.f424623b).clear();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    public ForsetiNodeViewGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.ss.android.lark.api.ui.c
    public final void a(ForsetiNodeMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (this.f424622a != r100) goto L5;
        return;
    L5:
        this.f424622a = r100;
        Iterator<T> r101 = this.f424623b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((com.ss.android.lark.api.ui.c) r101.next()).a(r100);
        goto L7
    }

    public ForsetiNodeViewGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f424623b = new ArrayList();
    }
}
