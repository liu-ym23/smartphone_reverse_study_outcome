package com.suite.lark.platform.component.widget_biz_chatfunctionview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xab.a;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u001a\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0014\u0010\u001c\u001a\u00020\u00162\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_chatfunctionview/ChatFunctionView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/desktopmode/frame/drawer/ISideMenuView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sideMenuViewDelegate", "getSideMenuViewDelegate", "()Lcom/ss/android/lark/desktopmode/frame/drawer/ISideMenuView;", "setSideMenuViewDelegate", "(Lcom/ss/android/lark/desktopmode/frame/drawer/ISideMenuView;)V", "getRecyclerView", "initRV", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onDrawerClosed", "onDrawerOpened", WidgetService.PARAM_FRAGMENT, "Lcom/ss/android/lark/desktopmode/app/DesktopCompatFragment;", "widget-biz-chatfunctionview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFunctionView extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f460796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f460797b;

    public final RecyclerView getRecyclerView() {
        return this.f460796a;
    }

    public final a getSideMenuViewDelegate() {
        return this.f460797b;
    }

    public ChatFunctionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        RecyclerView r101 = new RecyclerView(getContext());
        this.f460796a = r101;
        setBackgroundColor(d.c(getContext(), R.color.bg_body));
        setPaddingRelative(UIHelper.dp2px(20.0f), 0, UIHelper.dp2px(20.0f), UIHelper.dp2px(8.0f));
        addView(r101, -1, -2);
    }

    public final void setSideMenuViewDelegate(a r100) {
        this.f460797b = r100;
    }

    public ChatFunctionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        RecyclerView r102 = new RecyclerView(getContext());
        this.f460796a = r102;
        setBackgroundColor(d.c(getContext(), R.color.bg_body));
        setPaddingRelative(UIHelper.dp2px(20.0f), 0, UIHelper.dp2px(20.0f), UIHelper.dp2px(8.0f));
        addView(r102, -1, -2);
    }

    public ChatFunctionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        RecyclerView r103 = new RecyclerView(getContext());
        this.f460796a = r103;
        setBackgroundColor(d.c(getContext(), R.color.bg_body));
        setPaddingRelative(UIHelper.dp2px(20.0f), 0, UIHelper.dp2px(20.0f), UIHelper.dp2px(8.0f));
        addView(r103, -1, -2);
    }
}
