package eca;

import android.content.Context;
import android.os.Handler;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextSwitcher f472159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f472160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f472161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f472162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f472163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f472164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f472165g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        Handler r100 = this.f472164f;     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        r100.removeCallbacksAndMessages(null);     // Catch: Exception -> L7
    L9:
        this.f472164f = null;
        this.f472159a = null;
        this.f472162d = null;
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("ObricSearchSwitcherAdapter", "onDestroy e=" + e);
        goto L9
    }

    public final void c() {
        if (this.f472160b.size() >= 2) goto L5;
        return;
    L5:
        if (this.f472163e > 60) goto L11;
        Handler r100 = this.f472164f;
        if (r100 == null) goto L12;
        r100.postDelayed(new b(this), this.f472161c);
        return;
    L12:
        return;
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextSwitcher r101 = this.f472159a;
        if (r101 == null) goto L5;
        r101.setText((CharSequence) ListProtector.get(this.f472160b, ((Number) ListProtector.get((List) this.f472165g.getValue(), this.f472163e % this.f472160b.size())).intValue()));
    L5:
        TextSwitcher r102 = this.f472159a;
        if (r102 == null) goto L8;
        r102.setInAnimation(r100, R.anim.larus_fade_in_300);
    L8:
        TextSwitcher r103 = this.f472159a;
        if (r103 == null) goto L11;
        r103.setOutAnimation(r100, R.anim.larus_fade_out_300);
    L11:
        this.f472163e++;
        Function0<Unit> r104 = this.f472162d;
        if (r104 == null) goto L15;
        r104.invoke();
        return;
    }

    public c(TextSwitcher r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "textList");
        this.f472159a = r100;
        this.f472160b = r101;
        this.f472161c = 800;
        this.f472162d = null;
        this.f472164f = new Handler();
        this.f472165g = LazyKt.lazy(new eca.a(this));
    }
}
