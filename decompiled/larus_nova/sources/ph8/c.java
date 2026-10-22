package ph8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.s;
import fh8.u;
import java.util.Map;
import km8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements usc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f529302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f529303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f529304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f529305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f529306e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/markdown/memory/FlowMemoryWidget$listTypeToken$2$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/markdown/memory/MemoryItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<e> {
        public b() {
        }
    }

    static {
    }

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, usc.e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
    }

    @Override // usc.f
    public final View asView() {
        return ((hm8.c) this.f529303b.getValue()).b();
    }

    public final Context getContext() {
        return this.f529302a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f529302a = r100;
        this.f529303b = LazyKt.lazy(new ph8.a(this));
        this.f529305d = LazyKt.lazy(new ph8.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // usc.f
    public final Size d(TextView r210, Spanned r211, final usc.e r212, int r213, Map<String, ? extends Object> r214) {
        Intrinsics.checkNotNullParameter(r210, "textView");
        Intrinsics.checkNotNullParameter(r211, "text");
        Intrinsics.checkNotNullParameter(r212, "span");
        final b r100 = (b) this.f529305d.getValue();
        Intrinsics.checkNotNullParameter("FlowMemoryWidgetBinder", "source");
        Intrinsics.checkNotNullParameter(r211, "text");
        Intrinsics.checkNotNullParameter(r212, "span");
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = r211.getSpanStart(r212);
        int r102 = r211.getSpanEnd(r212);
        boolean r103 = true;
        if (r101 != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r102 == r211.length()) goto L10;
        r103 = false;
    L10:
        Message r105 = null;
        if (r214 != null) goto L62;
        Object r106 = null;
    L15:
        if ((r106 instanceof fh8.f) == false) goto L17;
        final fh8.f r107 = (fh8.f) r106;     // Catch: Exception -> L24
    L18:
        Function0 r110 = new u(r212, r107, r100);     // Catch: Exception -> L24
        if (TypeIntrinsics.isFunctionOfArity(r110, 0) == false) goto L21;
        u r111 = r110;
    L22:
        s r108 = new s(r107, r111, r104, r103);     // Catch: Exception -> L24
    L26:
        if (r108 == null) goto L30;
        fh8.f r109 = r108.f477153a;
        if (r109 == null) goto L30;
        q0 r112 = r109.f477087q;
    L31:
        if (r108 == null) goto L35;
        fh8.f r113 = r108.f477153a;
        if (r113 == null) goto L35;
        AttachReceiver r114 = r113.f477085o;
    L36:
        this.f529304c = new g(r114, null, null, null, null, r112, 30);
        if (r108 == null) goto L41;
        Function0<T> r115 = r108.f477154b;
        if (r115 == 0) goto L41;
        e r116 = (e) r115.invoke();
    L42:
        if (r116 != null) goto L46;
        return new Size(0, 0);
    L46:
        if (r108.f477155c == false) goto L50;
        Pair r117 = new Pair(0, Integer.valueOf(i5.r0()));
    L48:
        Pair r118 = r117;
        fh8.f r119 = r108.f477153a;
        if (r119 == null) goto L56;
        r105 = r119.f477072b;
    L56:
        Message r120 = r105;
        Integer r121 = this.f529306e;
        if (r121 != null) goto L60;
        ri8.c r122 = ri8.c.f537890a;
        r121 = ri8.c.k(r211, r212);
        this.f529306e = r121;
    L60:
        km8.a r123 = new km8.a(r118, r213, r120, r116, r121);
        ((hm8.c) this.f529303b.getValue()).a(r123, this.f529304c);
        hm8.c r124 = (hm8.c) this.f529303b.getValue();
        r124.getClass();
        Intrinsics.checkNotNullParameter(r123, "vmData");
        return r124.b().f(r124.f485954d, r213);
    L50:
        if (r108.f477156d == false) goto L52;
        r117 = new Pair(Integer.valueOf(i5.r0()), 0);
        goto L48
    L52:
        r117 = new Pair(Integer.valueOf(i5.r0()), Integer.valueOf(i5.r0()));
    L41:
        r116 = null;
    L35:
        r114 = null;
    L30:
        r112 = null;
    L24:
        e = move-exception;
        FLogger.f375446a.e("FlowMemoryWidgetBinder", "bindData called failed, " + e.getMessage());
        EnsureManager.ensureNotReachHere(e);
        r108 = null;
        goto L26
    L21:
        r111 = 0;
        goto L22
    L17:
        r107 = null;
        goto L18
    L62:
        r106 = r214.get("markdown_common_input_data");     // Catch: Exception -> L24
        goto L15
    L5:
        r104 = false;
        goto L7
    }
}
