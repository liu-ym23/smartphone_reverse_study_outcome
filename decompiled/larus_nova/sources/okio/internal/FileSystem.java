package okio.internal;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import okio.b0;
import okio.k;
import okio.l;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: loaded from: classes42.dex */
public final class FileSystem {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.lang.Object, kotlin.sequences.SequenceScope, kotlin.sequences.SequenceScope<? super okio.b0>] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final Object a(SequenceScope<? super b0> r210, l r211, ArrayDeque<b0> r212, b0 r213, boolean r214, boolean r215, Continuation<? super Unit> r216) {
        b0 r100 = r213;
        boolean r101 = r215;
        if ((r216 instanceof FileSystem$collectRecursively$1) == false) goto L7;
        FileSystem$collectRecursively$1 r102 = (FileSystem$collectRecursively$1) r216;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L78:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r107 = r102.Z$1;
        boolean r108 = r102.Z$0;
        Iterator<b0> r109 = (Iterator) r102.L$4;
        b0 r110 = (b0) r102.L$3;
        ArrayDeque<b0> r111 = (ArrayDeque) r102.L$2;
        l r112 = (l) r102.L$1;
        SequenceScope r113 = (SequenceScope) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L19
        boolean r114 = r108;
        Iterator<b0> r115 = r109;
        ArrayDeque<b0> r116 = r111;
        l r117 = r112;
        b0 r118 = r110;
        ?? r119 = r113;
    L81:
    L64:
        th = th;
        r111 = r116;
    L68:
        r111.removeLast();
        throw th;
    L54:
        if (r115.hasNext() == false) goto L63;
        b0 r120 = r115.next();     // Catch: Throwable -> L64
        if (r107 == false) goto L58;
        boolean r121 = true;
    L59:
        r102.L$0 = r119;     // Catch: Throwable -> L64
        r102.L$1 = r117;     // Catch: Throwable -> L64
        r102.L$2 = r116;     // Catch: Throwable -> L64
        r102.L$3 = r118;     // Catch: Throwable -> L64
        r102.L$4 = r115;     // Catch: Throwable -> L64
        r102.Z$0 = r114;     // Catch: Throwable -> L64
        r102.Z$1 = r107;     // Catch: Throwable -> L64
        r102.label = 2;     // Catch: Throwable -> L64
        ?? r122 = r119;
        boolean r123 = r121;
        l r124 = r117;
        if (a(r119, r117, r116, r120, r114, r123, r102) == r105) goto L61;
        r117 = r124;
        r119 = r122;
        goto L81
    L61:
        return r105;
    L58:
        r121 = false;
        goto L59
    L63:
        r116.removeLast();
        r101 = r107;
        r102 = r102;
        r105 = r105;
        r100 = r118;
        ?? r125 = r119;
    L73:
        if (r101 == false) goto L80;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.label = 3;
        if (r125.yield(r100, r102) != r105) goto L78;
        return r105;
    L80:
        return Unit.INSTANCE;
    L19:
        th = th;
        goto L68
    L21:
        boolean r126 = r102.Z$1;
        boolean r127 = r102.Z$0;
        b0 r128 = (b0) r102.L$3;
        ArrayDeque<b0> r129 = (ArrayDeque) r102.L$2;
        l r130 = (l) r102.L$1;
        SequenceScope r131 = (SequenceScope) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r101 = r126;
        boolean r132 = r127;
        r100 = r128;
        r125 = r131;
    L29:
        List<b0> r133 = r130.c(r100);
        if (r133 != null) goto L33;
        r133 = CollectionsKt.emptyList();
    L33:
        if ((!r133.isEmpty()) == false) goto L73;
        b0 r134 = r100;
        int r135 = 0;
    L35:
        if (r132 == true) goto L37;
    L41:
        Intrinsics.checkNotNullParameter(r130, "<this>");
        Intrinsics.checkNotNullParameter(r134, "path");
        Intrinsics.checkNotNullParameter(r134, "path");
        Intrinsics.checkNotNullParameter(r130, "<this>");
        Intrinsics.checkNotNullParameter(r134, "path");
        k r136 = r130.d(r134);
        if (r136 == null) goto L72;
        b0 r137 = r136.f524079c;
        if (r137 != null) goto L46;
        b0 r138 = null;
    L47:
        if (r138 == null) goto L48;
        r135 = r135 + 1;
        r134 = r138;
        goto L35
    L48:
        if (r132 == true) goto L50;
        if (r135 != 0) goto L73;
    L50:
        r129.addLast(r134);
        r114 = r132;
        r118 = r100;
        r107 = r101;
        r115 = r133.iterator();     // Catch: Throwable -> L66
        r116 = r129;
        r117 = r130;
        r119 = r125;
    L66:
        th = th;
        r111 = r129;
        goto L68
    L46:
        b0 r139 = r134.b();
        Intrinsics.checkNotNull(r139);
        r139.getClass();
        Intrinsics.checkNotNullParameter(r137, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r138 = c.b(r139, r137, false);
        goto L47
    L72:
        throw new FileNotFoundException("no such file: " + r134);
    L37:
        if (r129.contains(r134) == false) goto L41;
        throw new IOException("symlink cycle at " + r100);
    L22:
        ResultKt.throwOnFailure(r104);
        if (r101 == true) goto L27;
        r102.L$0 = r210;
        l r140 = r211;
        r102.L$1 = r140;
        r129 = r212;
        r102.L$2 = r129;
        r102.L$3 = r100;
        boolean r141 = r214;
        r102.Z$0 = r141;
        r102.Z$1 = r101;
        r102.label = 1;
        if (r210.yield(r100, r102) != r105) goto L28;
        return r105;
    L28:
        r125 = r210;
        r132 = r141;
        r130 = r140;
        goto L29
    L27:
        r140 = r211;
        r129 = r212;
        r141 = r214;
    L7:
        r102 = new FileSystem$collectRecursively$1(r216);
        goto L8
    }
}
