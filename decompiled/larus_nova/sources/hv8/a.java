package hv8;

import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f487348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f487349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f487350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f487351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f487352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<BrowserTakeoverOpenResult, Unit> f487353i;

    public final void a(BrowserTakeoverOpenResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Function1<BrowserTakeoverOpenResult, Unit> r102 = this.f487353i;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.invoke(r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, String r102, int r103, String r104, String r105, c r106, String r107, Function1<? super BrowserTakeoverOpenResult, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r104, "toolCallId");
        Intrinsics.checkNotNullParameter(r106, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r107, "takeoverId");
        this.f487345a = r100;
        this.f487346b = r101;
        this.f487347c = r102;
        this.f487348d = r103;
        this.f487349e = r104;
        this.f487350f = r105;
        this.f487351g = r106;
        this.f487352h = r107;
        this.f487353i = r110;
    }
}
