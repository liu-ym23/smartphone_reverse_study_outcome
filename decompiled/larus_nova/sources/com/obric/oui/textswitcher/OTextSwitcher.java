package com.obric.oui.textswitcher;

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

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "", "Landroid/os/Handler;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander", "Landroid/widget/ViewSwitcher$ViewFactory;", "b", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OTextSwitcher extends TextSwitcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f403343c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f403344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f403345b;

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.f403345b.getValue();
    }

    private final Handler getMUiHander() {
        return (Handler) this.f403344a.getValue();
    }

    public OTextSwitcher(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OTextSwitcher(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f403344a = LazyKt.lazy(OTextSwitcher$mUiHander$2.INSTANCE);
        this.f403345b = LazyKt.lazy(new OTextSwitcher$defaultViewFactory$2(r100, this));
    }
}
