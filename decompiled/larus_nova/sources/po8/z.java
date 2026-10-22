package po8;

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

/* JADX INFO: loaded from: classes26.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextSwitcher f530133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f530134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f530135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f530136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f530137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f530138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f530139g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        Handler r100 = this.f530138f;     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        r100.removeCallbacksAndMessages(null);     // Catch: Exception -> L7
    L9:
        this.f530138f = null;
        this.f530133a = null;
        this.f530136d = null;
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("SearchingSwitcherAdapter", "onDestroy e=" + e);
        goto L9
    }

    public final void c() {
        if (this.f530134b.size() >= 2) goto L5;
        return;
    L5:
        if (this.f530137e > 60) goto L11;
        Handler r100 = this.f530138f;
        if (r100 == null) goto L12;
        r100.postDelayed(new y(this), this.f530135c);
        return;
    L12:
        return;
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextSwitcher r101 = this.f530133a;
        if (r101 == null) goto L5;
        r101.setText((CharSequence) ListProtector.get(this.f530134b, ((Number) ListProtector.get((List) this.f530139g.getValue(), this.f530137e % this.f530134b.size())).intValue()));
    L5:
        TextSwitcher r102 = this.f530133a;
        if (r102 == null) goto L8;
        r102.setInAnimation(r100, R.anim.larus_fade_in_300);
    L8:
        TextSwitcher r103 = this.f530133a;
        if (r103 == null) goto L11;
        r103.setOutAnimation(r100, R.anim.larus_fade_out_300);
    L11:
        this.f530137e++;
        Function0<Unit> r104 = this.f530136d;
        if (r104 == null) goto L15;
        r104.invoke();
        return;
    }

    public /* synthetic */ z(TextSwitcher r100, List r101) {
        this(r100, r101, 800, null);
    }

    public z(TextSwitcher r100, List<String> r101, long r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "textList");
        this.f530133a = r100;
        this.f530134b = r101;
        this.f530135c = r102;
        this.f530136d = r103;
        this.f530138f = new Handler();
        this.f530139g = LazyKt.lazy(new x(this));
    }
}
