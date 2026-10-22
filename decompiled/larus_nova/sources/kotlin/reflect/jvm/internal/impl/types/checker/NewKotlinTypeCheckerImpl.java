package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes5.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner r100, KotlinTypePreparator r101) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r101, "kotlinTypePreparator");
        this.kotlinTypeRefiner = r100;
        this.kotlinTypePreparator = r101;
        this.overridingUtil = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType r100, KotlinType r110) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r110, "b");
        KotlinTypeRefiner r101 = getKotlinTypeRefiner();
        return equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, getKotlinTypePreparator(), r101, 6, null), r100.unwrap(), r110.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType r100, KotlinType r110) {
        Intrinsics.checkNotNullParameter(r100, PushAction$ESubType.KEY_NAME);
        Intrinsics.checkNotNullParameter(r110, "supertype");
        KotlinTypeRefiner r101 = getKotlinTypeRefiner();
        return isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, getKotlinTypePreparator(), r101, 6, null), r100.unwrap(), r110.unwrap());
    }

    public final boolean equalTypes(TypeCheckerState r100, UnwrappedType r101, UnwrappedType r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r102, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(r100, r101, r102);
    }

    public final boolean isSubtypeOf(TypeCheckerState r100, UnwrappedType r110, UnwrappedType r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "subType");
        Intrinsics.checkNotNullParameter(r111, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, r100, r110, r111, false, 8, null);
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner r100, KotlinTypePreparator r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = KotlinTypePreparator.Default.INSTANCE;
    L5:
        this(r100, r101);
    }
}
