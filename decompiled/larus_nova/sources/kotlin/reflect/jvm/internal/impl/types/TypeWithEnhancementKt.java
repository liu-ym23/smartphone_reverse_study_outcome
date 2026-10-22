package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeWithEnhancementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KotlinType getEnhancement(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof TypeWithEnhancement) == true) goto L7;
        return null;
    L7:
        return ((TypeWithEnhancement) r100).getEnhancement();
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r100, KotlinType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        return wrapEnhancement(r100, getEnhancement(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final UnwrappedType wrapEnhancement(UnwrappedType r100, KotlinType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof TypeWithEnhancement) == true) goto L5;
        if (r101 != null) goto L8;
    L19:
        return r100;
    L8:
        if (Intrinsics.areEqual(r101, r100) == true) goto L19;
        if ((r100 instanceof SimpleType) == false) goto L14;
        return new SimpleTypeWithEnhancement((SimpleType) r100, r101);
    L14:
        if ((r100 instanceof FlexibleType) == false) goto L18;
        return new FlexibleTypeWithEnhancement((FlexibleType) r100, r101);
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        return wrapEnhancement(((TypeWithEnhancement) r100).getOrigin(), r101);
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r100, KotlinType r101, Function1<? super KotlinType, ? extends KotlinType> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r102, "transform");
        KotlinType r103 = getEnhancement(r101);
        if (r103 == null) goto L5;
        KotlinType r104 = r102.invoke(r103);
    L7:
        return wrapEnhancement(r100, r104);
    L5:
        r104 = null;
        goto L7
    }
}
