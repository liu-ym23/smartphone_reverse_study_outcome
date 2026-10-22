package wrc;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class r {
    public static final Object a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Offset) == false) goto L6;
        Offset r101 = (Offset) r100;
        return CollectionsKt.mutableListOf(new Number[]{Float.valueOf(Float.intBitsToFloat((int) (r101.m4592unboximpl() >> 32))), Float.valueOf(Float.intBitsToFloat((int) (r101.m4592unboximpl() & BodyPartID.bodyIdMax)))});
    L6:
        if ((r100 instanceof Color) == false) goto L10;
        Color r102 = (Color) r100;
        return CollectionsKt.mutableListOf(new Number[]{Float.valueOf(Color.m4833getRedimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4832getGreenimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4830getBlueimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4829getAlphaimpl(r102.m4837unboximpl()))});
    L10:
        return r100;
    }
}
