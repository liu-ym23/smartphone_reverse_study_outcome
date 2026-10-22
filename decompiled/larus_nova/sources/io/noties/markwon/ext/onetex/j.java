package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends wsc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super String, Object, Unit> f492444a;

    /* JADX INFO: loaded from: classes41.dex */
    public static final class a {
        public a() {
        }
    }

    @Override // wsc.b
    public final void a(wsc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
    }

    @Override // wsc.b
    public final void c(wsc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new WeakReference(r100);
    }

    @Override // wsc.b
    public final void b(wsc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Function2<? super String, Object, Unit> r101 = this.f492444a;
        if (r101 == null) goto L6;
        r101.invoke(r100.f561116a, new a());
        return;
    }

    private final void setResult(wsc.a r100, Drawable r101, ImageSpanStatus r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBounds().isEmpty() == false) goto L7;
        r101.setBounds(wsc.m.a(r101));
    L7:
        if (r100.getCallback() == null) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L12;
        return;
    L12:
        if (r102 != ImageSpanStatus.SUCC) goto L15;
        r100.setResult(r101);
    L18:
        r100.invalidateSelf();
        return;
    L15:
        if (r100.f561127l == true) goto L18;
        r100.setResult(r101);
        goto L18
    L9:
        r103 = false;
        goto L10
    }
}
