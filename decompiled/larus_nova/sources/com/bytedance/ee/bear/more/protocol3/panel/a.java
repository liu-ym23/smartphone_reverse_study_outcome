package com.bytedance.ee.bear.more.protocol3.panel;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f234927d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.panel.a$a, reason: collision with other inner class name */
    public static final class C3368a {
    }

    static {
    }

    public final String toString() {
        return this.f234924a + " -> " + super.toString();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final i a(x r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = this.f234927d.invoke().booleanValue();     // Catch: Throwable -> L5
    L7:
        if (r101 == false) goto L9;
        tt5.a.h("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction success, itemId=" + this.f234924a);
        return i.a.f234979a;
    L9:
        tt5.a.h("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction not handled, itemId=" + this.f234924a);
        return i.b.f234980a;
    L5:
        th = move-exception;
        tt5.a.e("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction error, itemId=" + this.f234924a, th, false);
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean b(x r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f234925b;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean c(x r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f234926c;
    }

    public a(String r100, boolean r101, boolean r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r103, "clickAction");
        this.f234924a = r100;
        this.f234925b = r101;
        this.f234926c = r102;
        this.f234927d = r103;
    }
}
