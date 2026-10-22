package xx8;

import android.content.Context;
import android.os.Handler;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.impl.ui.component.generalonly.p;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextSwitcher f565346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f565347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f565348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f565349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f565350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f565351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f565352g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f565347b.size() < 2) goto L8;
        FLogger.f375446a.i("TextViewSwitcherAdapter", "startSwitchInOrder curTextIndex=" + this.f565349d);
        Handler r100 = this.f565350e;
        if (r100 == null) goto L9;
        r100.postDelayed(new d(this), 2500);
        return;
    L9:
        return;
    }

    public final void c() {
        if (this.f565347b.size() < 2) goto L8;
        FLogger.f375446a.i("TextViewSwitcherAdapter", "startSwitchInOrder curTextIndex=" + this.f565349d);
        Handler r100 = this.f565350e;
        if (r100 == null) goto L9;
        r100.postDelayed(new g(this), 2500);
        return;
    L9:
        return;
    }

    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = (String) ListProtector.get(this.f565347b, ((Number) ListProtector.get((List) this.f565351f.getValue(), this.f565349d % this.f565347b.size())).intValue());
        TextSwitcher r102 = this.f565346a;
        if (r102 == null) goto L5;
        r102.setText(r101);
    L5:
        TextSwitcher r103 = this.f565346a;
        if (r103 == null) goto L8;
        r103.setInAnimation(r100, R.anim.larus_fade_in_slide_in_bottom);
    L8:
        TextSwitcher r104 = this.f565346a;
        if (r104 == null) goto L11;
        r104.setOutAnimation(r100, R.anim.larus_fade_out_slide_out_top);
    L11:
        this.f565349d++;
        return r101;
    }

    public h(TextSwitcher r100, List r101, p r102) {
        Intrinsics.checkNotNullParameter(r101, "textList");
        this.f565346a = r100;
        this.f565347b = r101;
        this.f565348c = r102;
        this.f565350e = new Handler();
        this.f565351f = LazyKt.lazy(new e(this));
        this.f565352g = LazyKt.lazy(new f(this));
    }
}
