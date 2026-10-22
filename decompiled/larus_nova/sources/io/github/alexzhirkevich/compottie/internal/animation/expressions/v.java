package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes41.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Character, Character> f490994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Character> f490995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f490996c = null;

    static {
        List r100 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.toList(new CharRange('a', 'z')), CollectionsKt.toList(new CharRange('A', Matrix.MATRIX_TYPE_ZERO))), Character.valueOf(Typography.dollar)), '_');
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(Character.valueOf(((Character) r103).charValue()), r103);
        goto L4
    L6:
        f490994a = r101;
        EnumEntries<NumberFormat> r104 = NumberFormat.getEntries();
        ArrayList r105 = new ArrayList();
        Iterator<NumberFormat> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Character r107 = r106.next().getPrefix();
        if (r107 == null) goto L8;
        r105.add(r107);
        goto L8
    L12:
        f490995b = r105;
        f490996c = SetsKt.setOf(new String[]{"function", "return", SRStrategy.KEY_DOWNGRADE, "while", SlcElement.KEY_FOR});
    }

    public static final void b(List<?> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "func");
        if (r100 == null) goto L6;
        return;
    L6:
        throw new IllegalStateException((r101 + " call was missing").toString());
    }

    public static final void a(List<?> r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "func");
        if (r100 == null) goto L13;
        if (r100.size() != r101) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException((r102 + " takes " + r101 + " arguments, but " + r100.size() + " got").toString());
    L7:
        r103 = false;
        goto L8
    L13:
        throw new IllegalStateException((r102 + " call was missing").toString());
    }
}
