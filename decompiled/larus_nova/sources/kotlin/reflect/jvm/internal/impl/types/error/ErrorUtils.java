package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ErrorUtils {
    public static final ErrorUtils INSTANCE = null;
    private static final ErrorClassDescriptor errorClass = null;
    private static final ModuleDescriptor errorModule = null;
    private static final PropertyDescriptor errorProperty = null;
    private static final Set<PropertyDescriptor> errorPropertyGroup = null;
    private static final KotlinType errorPropertyType = null;
    private static final KotlinType errorTypeForLoopInSupertypes = null;

    private ErrorUtils() {
    }

    static {
        INSTANCE = new ErrorUtils();
        errorModule = ErrorModuleDescriptor.INSTANCE;
        errorClass = new ErrorClassDescriptor(Name.special(String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1))));
        errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        ErrorPropertyDescriptor r100 = new ErrorPropertyDescriptor();
        errorProperty = r100;
        errorPropertyGroup = SetsKt.setOf(r100);
    }

    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    @JvmStatic
    public static final boolean isError(DeclarationDescriptor r100) {
        if (r100 == null) goto L10;
        ErrorUtils r101 = INSTANCE;
        if (r101.isErrorClass(r100) == false) goto L6;
    L9:
        return true;
    L6:
        if (r101.isErrorClass(r100.getContainingDeclaration()) == true) goto L9;
        if (r100 == errorModule) goto L9;
    L10:
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor r100) {
        return r100 instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(KotlinType r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        TypeConstructor r101 = r100.getConstructor();
        if ((r101 instanceof ErrorTypeConstructor) == true) goto L8;
        return false;
    L8:
        if (((ErrorTypeConstructor) r101).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) goto L12;
        return true;
    L12:
        return false;
    }

    public final String unresolvedTypeAsItIs(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        TypeUtilsKt.isUnresolvedType(r100);
        TypeConstructor r101 = r100.getConstructor();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((ErrorTypeConstructor) r101).getParam(0);
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "formatParams");
        return createErrorScope(r100, false, (String[]) Arrays.copyOf(r101, r101.length));
    }

    @JvmStatic
    public static final ErrorType createErrorType(ErrorTypeKind r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(r100, CollectionsKt.emptyList(), (String[]) Arrays.copyOf(r101, r101.length));
    }

    public final ErrorTypeConstructor createErrorTypeConstructor(ErrorTypeKind r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "formatParams");
        return new ErrorTypeConstructor(r100, (String[]) Arrays.copyOf(r101, r101.length));
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r100, boolean r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r102, "formatParams");
        if (r101 == false) goto L6;
        return new ThrowingScope(r100, (String[]) Arrays.copyOf(r102, r102.length));
    L6:
        return new ErrorScope(r100, (String[]) Arrays.copyOf(r102, r102.length));
    }

    public final ErrorType createErrorType(ErrorTypeKind r100, TypeConstructor r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "typeConstructor");
        Intrinsics.checkNotNullParameter(r102, "formatParams");
        return createErrorTypeWithArguments(r100, CollectionsKt.emptyList(), r101, (String[]) Arrays.copyOf(r102, r102.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r100, List<? extends TypeProjection> r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "arguments");
        Intrinsics.checkNotNullParameter(r102, "formatParams");
        return createErrorTypeWithArguments(r100, r101, createErrorTypeConstructor(r100, (String[]) Arrays.copyOf(r102, r102.length)), (String[]) Arrays.copyOf(r102, r102.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r100, List<? extends TypeProjection> r110, TypeConstructor r111, String... r112) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r110, "arguments");
        Intrinsics.checkNotNullParameter(r111, "typeConstructor");
        Intrinsics.checkNotNullParameter(r112, "formatParams");
        return new ErrorType(r111, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, new String[]{r111.toString()}), r100, r110, false, (String[]) Arrays.copyOf(r112, r112.length));
    }
}
