package iw8;

import android.content.Context;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<wsc.a> f496240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f496241b;

    public d() {
        this.f496240a = new CopyOnWriteArrayList();
    }

    public final wsc.a a(Context r100, Function1<? super wsc.a, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "predict");
        int r102 = 0;
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L6;
        boolean r103 = true;
    L8:
        if (Intrinsics.areEqual(Boolean.valueOf(r103), this.f496241b) == true) goto L10;
        this.f496240a.clear();     // Catch: Exception -> L22
        this.f496241b = Boolean.valueOf(r103);     // Catch: Exception -> L22
    L10:
        Iterator<wsc.a> r104 = this.f496240a.iterator();     // Catch: Exception -> L22
    L12:
        if (r104.hasNext() == false) goto L17;
        if (r101.invoke(r104.next()).booleanValue() == true) goto L18;
        r102 = r102 + 1;     // Catch: Exception -> L22
    L18:
        if (r102 < 0) goto L31;
        return this.f496240a.get(r102);
    L31:
        return null;
    L17:
        r102 = -1;
        goto L18
    L6:
        r103 = false;
    L22:
        e = move-exception;
        com.larus.business.markdown.api.depend.c r105 = IMarkdownEnsureManagerKt.a();
        if (r105 == null) goto L26;
        r105.ensureNotReachHere(e, "ReuseDrawablePoolNew obtain exception");
    L26:
        return null;
    }
}
