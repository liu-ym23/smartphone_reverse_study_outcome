package fh8;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x {
    public static final List<lw8.k> b(lw8.l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<k> r101 = o.a(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((k) r103.next()).f477125b);
        goto L4
    L6:
        return r102;
    }

    public static final void a(lw8.l r100, final View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Iterator r103 = ((ArrayList) o.a(r100)).iterator();     // Catch: Throwable -> L12
        final int r104 = 0;
    L5:
        if (r103.hasNext() == false) goto L10;
        Object r105 = r103.next();     // Catch: Throwable -> L12
        int r106 = r104 + 1;     // Catch: Throwable -> L12
        if (r104 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L12
    L9:
        final k r107 = (k) r105;     // Catch: Throwable -> L12
        CustomLinkSpan r108 = r107.f477124a;     // Catch: Throwable -> L12
        r108.f492293g = new v(r104, r107, r101);     // Catch: Throwable -> L12
        r104 = r106;
        goto L5
    L10:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
