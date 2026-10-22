package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class p {
    public static o a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "expression");
        return new o(r100);
    }

    public static final Object b(Object r100) {
        if ((r100 instanceof Map) == false) goto L6;
        return CollectionsKt.toList(((Map) r100).values());
    L6:
        if ((r100 instanceof Offset) == false) goto L9;
        Offset r101 = (Offset) r100;
        return CollectionsKt.listOf(new Float[]{Float.valueOf(Float.intBitsToFloat((int) (r101.m4592unboximpl() >> 32))), Float.valueOf(Float.intBitsToFloat((int) (r101.m4592unboximpl() & BodyPartID.bodyIdMax)))});
    L9:
        if ((r100 instanceof Color) == false) goto L12;
        Color r102 = (Color) r100;
        return CollectionsKt.listOf(new Float[]{Float.valueOf(Color.m4833getRedimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4832getGreenimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4830getBlueimpl(r102.m4837unboximpl())), Float.valueOf(Color.m4829getAlphaimpl(r102.m4837unboximpl()))});
    L12:
        if ((r100 instanceof Object[]) == true) goto L14;
        return r100;
    L14:
        return ArraysKt.toList((Object[]) r100);
    }
}
