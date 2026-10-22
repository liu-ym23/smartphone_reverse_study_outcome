package com.bytedance.dux.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/dux/textswitcher/DuxTextSwitcher;", "Landroid/widget/TextSwitcher;", "", "", "newIndex", "", "setIndex", "newCount", "setHistoryRepeatCount", "Landroid/os/Handler;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander", "Landroid/widget/ViewSwitcher$ViewFactory;", "b", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxTextSwitcher extends TextSwitcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f205763c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f205764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f205765b;

    public final void setHistoryRepeatCount(int r100) {
    }

    public final void setIndex(int r100) {
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.f205765b.getValue();
    }

    private final Handler getMUiHander() {
        return (Handler) this.f205764a.getValue();
    }

    public DuxTextSwitcher(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DuxTextSwitcher(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205764a = LazyKt.lazy(DuxTextSwitcher$mUiHander$2.INSTANCE);
        this.f205765b = LazyKt.lazy(new DuxTextSwitcher$defaultViewFactory$2(r100, this));
    }
}
