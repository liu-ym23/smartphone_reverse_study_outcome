package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.net.AutoRetryManager;
import com.ss.android.ugc.tools.net.NetworkState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/statusview/AbsAVNetErrorStatusView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "condition", "", "setAutoRetryCondition", "callback", "setRetryCallback", "", RemoteMessageConst.Notification.VISIBILITY, "setVisibility", "Lcom/ss/android/ugc/tools/net/AutoRetryManager;", "c", "Lkotlin/Lazy;", "getAutoRetryManager", "()Lcom/ss/android/ugc/tools/net/AutoRetryManager;", "autoRetryManager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class AbsAVNetErrorStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f455184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<AutoRetryManager> f455185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f455186c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsAVNetErrorStatusView f455187a;

        public a(AbsAVNetErrorStatusView r100) {
            this.f455187a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f455187a.f455184a.invoke();
        }
    }

    public AbsAVNetErrorStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsAVNetErrorStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final AutoRetryManager getAutoRetryManager() {
        return (AutoRetryManager) this.f455186c.getValue();
    }

    public abstract void a();

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f455185b.isInitialized() == false) goto L6;
        AutoRetryManager r100 = getAutoRetryManager();
        r100.f454834a = false;
        com.ss.android.ugc.tools.net.a r101 = com.ss.android.ugc.tools.net.b.f454841a;
        Function2<NetworkState, NetworkState, Unit> r102 = r100.f454835b;
        Intrinsics.checkNotNullParameter(r102, "observer");
        com.ss.android.ugc.tools.net.b.f454841a.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        return;
    }

    public final void setAutoRetryCondition(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        AutoRetryManager r101 = getAutoRetryManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        r101.f454836c = r100;
    }

    public final void setRetryCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f455184a = r100;
        setOnClickListener(new a(this));
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L6;
        a();
        return;
    L6:
        if (this.f455185b.isInitialized() == false) goto L10;
        AutoRetryManager r101 = getAutoRetryManager();
        r101.f454834a = false;
        com.ss.android.ugc.tools.net.a r102 = com.ss.android.ugc.tools.net.b.f454841a;
        Function2<NetworkState, NetworkState, Unit> r103 = r101.f454835b;
        Intrinsics.checkNotNullParameter(r103, "observer");
        com.ss.android.ugc.tools.net.b.f454841a.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        return;
    }

    public AbsAVNetErrorStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f455184a = AbsAVNetErrorStatusView$retryCallback$1.INSTANCE;
        Lazy<AutoRetryManager> r103 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsAVNetErrorStatusView$autoRetryInitializer$1(this));
        this.f455185b = r103;
        this.f455186c = r103;
    }

    public /* synthetic */ AbsAVNetErrorStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
