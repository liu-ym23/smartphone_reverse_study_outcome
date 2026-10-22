package g70;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f480204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e70.f f480205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f480206c;

    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final ViewGroup e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // j70.o
    public final /* synthetic */ boolean g() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ((e70.h) this.f480205b).m();
    }

    @Override // j70.o
    public final boolean f() {
        ((e70.h) this.f480205b).s(this.f480204a.f480210b);
        return false;
    }

    @Override // j70.o
    public final boolean h() {
        return ((e70.h) this.f480205b).o(this.f480204a.f480210b);
    }

    @Override // j70.o
    public final w70.a j() {
        return new b(this);
    }

    @Override // j70.o
    public final boolean i() {
        return this.f480206c;
    }

    public c(e r100, e70.f r101, boolean r102) {
        this.f480204a = r100;
        this.f480205b = r101;
        this.f480206c = r102;
    }
}
