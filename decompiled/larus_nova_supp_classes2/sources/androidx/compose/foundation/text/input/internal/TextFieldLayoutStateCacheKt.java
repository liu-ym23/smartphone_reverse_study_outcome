package androidx.compose.foundation.text.input.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a6\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0002¨\u0006\u0005"}, d2 = {"mergeNullableLists", "", "T", "first", "second", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCacheKt {
    public static final /* synthetic */ List access$mergeNullableLists(List r0, List r1) {
        return mergeNullableLists(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> mergeNullableLists(List<? extends T> r4, List<? extends T> r5) {
        List<? extends T> r0 = r4;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L20;
        List<? extends T> r6 = r5;
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L20;
        return null;
    L13:
        if (r6.isEmpty() == true) goto L16;
        r7 = false;
    L20:
        if (r0 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        return r5;
    L28:
        List<? extends T> r9 = r5;
        if (r9 != null) goto L31;
    L32:
        r1 = true;
    L33:
        if (r1 == false) goto L35;
        return r4;
    L35:
        List r10 = CollectionsKt.createListBuilder();
        r10.addAll(r0);
        r10.addAll(r9);
        return CollectionsKt.build(r10);
    L31:
        if (r9.isEmpty() == false) goto L33;
    L22:
        if (r0.isEmpty() == true) goto L25;
        r8 = false;
        goto L26
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }
}
