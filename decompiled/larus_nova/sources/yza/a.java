package yza;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static final j a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.blueprint_block_key);
        if ((r101 instanceof j) == true) goto L7;
        return null;
    L7:
        return (j) r101;
    }

    public static final m<Object> b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.blueprint_cell);
        if ((r101 instanceof m) == true) goto L7;
        return null;
    L7:
        return (m) r101;
    }
}
