package t70;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f544859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Widget f544860b;

    public static final class a implements w70.a<h70.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f544861a;

        public a(d r100) {
            this.f544861a = r100;
        }

        @Override // w70.a
        public final Widget a(h70.b r100) {
            Intrinsics.checkNotNullParameter(r100, "layerContext");
            return this.f544861a.f544860b;
        }
    }

    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return null;
    }

    @Override // j70.o
    public final ViewGroup e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // j70.o
    public final boolean f() {
        return false;
    }

    @Override // j70.o
    public final /* synthetic */ boolean g() {
        return true;
    }

    @Override // j70.o
    public final boolean i() {
        return false;
    }

    @Override // j70.o
    public final w70.a<? extends h70.b> j() {
        return new a(this);
    }

    @Override // j70.o
    public final boolean h() {
        return this.f544859a;
    }

    public d(boolean r100, LiveRecyclableWidget r101) {
        this.f544859a = r100;
        this.f544860b = r101;
    }
}
