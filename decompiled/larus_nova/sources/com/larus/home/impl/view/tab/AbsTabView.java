package com.larus.home.impl.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.main.tab.config.BottomTabConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 /2\u00020\u0001:\u0001/B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u0007H&J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH&J\u001a\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0007H&J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0007H&J\b\u0010'\u001a\u00020\u0007H&J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H&J\b\u0010+\u001a\u00020\u0017H&J\b\u0010,\u001a\u00020\u0017H&J\b\u0010-\u001a\u00020\u0017H&J\b\u0010.\u001a\u00020\u0017H&R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00060"}, d2 = {"Lcom/larus/home/impl/view/tab/AbsTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "bottomTabConfig", "Lcom/larus/home/impl/main/tab/config/BottomTabConfig;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/home/impl/main/tab/config/BottomTabConfig;)V", "getBottomTabConfig", "()Lcom/larus/home/impl/main/tab/config/BottomTabConfig;", "setBottomTabConfig", "(Lcom/larus/home/impl/main/tab/config/BottomTabConfig;)V", "bindTab", "Lcom/larus/home/impl/main/tab/MainTabFragment$MainTab;", "getBindTab", "()Lcom/larus/home/impl/main/tab/MainTabFragment$MainTab;", "setBindTab", "(Lcom/larus/home/impl/main/tab/MainTabFragment$MainTab;)V", "setTabIcon", "", "selectId", "unselectId", "setTabText", "text", "", "isForce", "", "updateSelectStatus", "select", "tabMode", "Lcom/larus/home/impl/view/tab/TabMode;", "updateRedPointVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateUnreadCount", "count", "getUnreadCount", "setIconSize", "width", "height", "showRefreshAnimator", "dismissRefreshAnimator", "showMineRedDot", "dismissMineRedDot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsTabView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomTabConfig f346363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MainTabFragment.MainTab f346364b;

    public static final class a {
    }

    static {
    }

    public abstract void R5();

    public abstract void S5();

    public abstract void T5(int r100, int r101);

    public abstract void U5(String r100, boolean r101);

    public abstract void V5();

    public abstract void Y5();

    public abstract void Z5();

    public abstract void b6(boolean r100, TabMode r101);

    public abstract void c6(int r100);

    public abstract int getUnreadCount();

    public final MainTabFragment.MainTab getBindTab() {
        return this.f346364b;
    }

    public final BottomTabConfig getBottomTabConfig() {
        return this.f346363a;
    }

    public final void setBindTab(MainTabFragment.MainTab r100) {
        this.f346364b = r100;
    }

    public final void setBottomTabConfig(BottomTabConfig r100) {
        this.f346363a = r100;
    }

    public AbsTabView(Context r100, AttributeSet r101, int r102, BottomTabConfig r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f346363a = r103;
    }

    public /* synthetic */ AbsTabView(Context r100, AttributeSet r101, BottomTabConfig r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0, r102);
    }
}
