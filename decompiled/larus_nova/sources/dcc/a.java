package dcc;

import com.ss.android.lark.log.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467914a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(LinkedList<Integer> r100, int r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        float r103 = r101 - ((r100.size() - 1) * 6.0f);
        if (r100.isEmpty() == true) goto L23;
        Iterator<T> r104 = r100.iterator();
    L16:
        if (r104.hasNext() == false) goto L23;
        if (((Number) r104.next()).intValue() > 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L16;
        boolean r106 = true;
    L24:
        if (r106 != true) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        Collections.fill(r100, 100);
    L29:
        int r108 = CollectionsKt.sumOfInt(r100);
        int r109 = ((Number) CollectionsKt.m9880minOrThrow(r100)).intValue();
        Log.i("ColumnsRelatedUtils", "minWidth = " + r109);
        Log.i("ColumnsRelatedUtils", "columnsWidthRatioSum = " + r108);
        float r110 = ((float) r109) / ((float) r108);
        Log.i("ColumnsRelatedUtils", "singleColumnsMinWidthRatio = " + r110);
        float r111 = r110 * r103;
        Log.i("ColumnsRelatedUtils", "singleColumnsMinWidth = " + r111);
        if (r111 >= 56.0f) goto L38;
        return true;
    L38:
        return false;
    L26:
        r107 = false;
        goto L27
    L20:
        r105 = false;
    L23:
        r106 = false;
        goto L24
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
