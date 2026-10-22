package qrc;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static final Object a(Object r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = b(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalStateException(("Index " + r101 + " out of bounds of " + r100 + " length").toString());
    }

    public static final Object b(Object r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Map) == false) goto L6;
        Object r102 = ((Map) r100).get(Integer.valueOf(r101));
    L34:
        Intrinsics.checkNotNull(r102);
        return r102;
    L6:
        if ((r100 instanceof List) == false) goto L9;
        r102 = CollectionsKt.getOrNull((List) r100, r101);
        goto L34
    L9:
        if ((r100 instanceof Object[]) == false) goto L12;
        r102 = ArraysKt.getOrNull((Object[]) r100, r101);
        goto L34
    L12:
        if ((r100 instanceof Offset) == false) goto L19;
        if (r101 == 0) goto L17;
        if (r101 == 1) goto L16;
    L15:
        r102 = null;
        goto L34
    L16:
        r102 = Float.valueOf(Float.intBitsToFloat((int) (((Offset) r100).m4592unboximpl() & BodyPartID.bodyIdMax)));
        goto L34
    L17:
        r102 = Float.valueOf(Float.intBitsToFloat((int) (((Offset) r100).m4592unboximpl() >> 32)));
        goto L34
    L19:
        if ((r100 instanceof CharSequence) == false) goto L22;
        r102 = StringsKt.getOrNull((CharSequence) r100, r101);
        goto L34
    L22:
        if ((r100 instanceof Color) == false) goto L37;
        if (r101 == 0) goto L33;
        if (r101 != 1) goto L26;
        r102 = Float.valueOf(Color.m4832getGreenimpl(((Color) r100).m4837unboximpl()));
        goto L34
    L26:
        if (r101 != 2) goto L28;
        r102 = Float.valueOf(Color.m4830getBlueimpl(((Color) r100).m4837unboximpl()));
        goto L34
    L28:
        if (r101 != 3) goto L15;
        r102 = Float.valueOf(Color.m4829getAlphaimpl(((Color) r100).m4837unboximpl()));
        goto L34
    L33:
        r102 = Float.valueOf(Color.m4833getRedimpl(((Color) r100).m4837unboximpl()));
        goto L34
    L37:
        throw new IllegalStateException(("Can't get value by index from " + r100).toString());
    }

    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.REF);
        if (r101 == null) goto L7;
        throw new IllegalStateException(("Unresolved reference '" + r100 + "' for " + r101).toString());
    L7:
        throw new IllegalStateException(("Unresolved reference: " + r100).toString());
    }
}
