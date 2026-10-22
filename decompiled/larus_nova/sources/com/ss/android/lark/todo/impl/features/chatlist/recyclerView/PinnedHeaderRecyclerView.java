package com.ss.android.lark.todo.impl.features.chatlist.recyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ss.android.lark.todo.impl.features.chatlist.adapter.PinnedHeaderAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w7c.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/recyclerView/PinnedHeaderRecyclerView;", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isChatTodoList", "", "isChatTodoList$todo_productionChinaRelease", "()Z", "setChatTodoList$todo_productionChinaRelease", "(Z)V", "mPinnedHeaderHandle", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "ev", "getPinnedHeaderDecoration", "Lcom/ss/android/lark/todo/impl/features/chatlist/recyclerView/IPinnedHeaderDecoration;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinnedHeaderRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f442415k;

    public PinnedHeaderRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinnedHeaderRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setChatTodoList$todo_productionChinaRelease(boolean r100) {
    }

    private final a getPinnedHeaderDecoration() {
        int r100 = getItemDecorationCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        Object r102 = getItemDecorationAt(r101);
        if ((r102 instanceof a) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return (a) r102;
    L9:
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        a r101 = getPinnedHeaderDecoration();
        if (r101 == null) goto L5;
        Rect r102 = r101.f();
        int r103 = r101.e();
        if (r102 == null) goto L20;
        if (r103 == (-1)) goto L20;
        if (r100.getAction() != 0) goto L18;
        if (r102.contains((int) r100.getX(), (int) r100.getY()) == false) goto L18;
        return true;
    L18:
        return super.onInterceptTouchEvent(r100);
    L20:
        return super.onInterceptTouchEvent(r100);
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        a r101 = getPinnedHeaderDecoration();
        if (r101 == null) goto L5;
        Rect r102 = r101.f();
        int r103 = r101.e();
        if (r102 == null) goto L45;
        if (r103 == (-1)) goto L45;
        int r104 = r100.getAction();
        if (r104 == 0) goto L38;
        if (r104 != 1) goto L15;
    L24:
        float r105 = r100.getX();
        float r106 = r100.getY();
        if (this.f442415k == true) goto L27;
    L37:
        this.f442415k = false;
    L43:
        return super.onTouchEvent(r100);
    L27:
        if (r102.contains((int) r105, (int) r106) == false) goto L37;
        LinearLayoutManager r107 = (LinearLayoutManager) getLayoutManager();
        if (r107 == null) goto L31;
        int r108 = r107.findFirstVisibleItemPosition();
    L32:
        PinnedHeaderAdapter r109 = (PinnedHeaderAdapter) getAdapter();
        if (r109 == null) goto L35;
        r109.B2(r108);
    L35:
        this.f442415k = false;
        return true;
    L31:
        r108 = 0;
        goto L32
    L15:
        if (r104 == 2) goto L19;
        if (r104 == 3) goto L24;
    L19:
        if (this.f442415k == false) goto L43;
        if (r102.contains((int) r100.getX(), (int) r100.getY()) == true) goto L46;
        MotionEvent r110 = MotionEvent.obtain(r100);
        r110.setAction(3);
        dispatchTouchEvent(r110);
        MotionEvent r111 = MotionEvent.obtain(r100);
        r111.setAction(0);
        return dispatchTouchEvent(r111);
    L46:
        return true;
    L38:
        this.f442415k = false;
        if (r102.contains((int) r100.getX(), (int) r100.getY()) == false) goto L43;
        this.f442415k = true;
        return true;
    L45:
        return super.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public PinnedHeaderRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PinnedHeaderRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
