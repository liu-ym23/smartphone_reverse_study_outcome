package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes5.dex */
public final class ErrorType extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final String debugMessage;
    private final String[] formatParams;
    private final boolean isMarkedNullable;
    private final ErrorTypeKind kind;
    private final MemberScope memberScope;

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public ErrorType refine(KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "newAttributes");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r100) {
        TypeConstructor r101 = getConstructor();
        MemberScope r102 = getMemberScope();
        ErrorTypeKind r103 = this.kind;
        List<TypeProjection> r104 = getArguments();
        String[] r105 = this.formatParams;
        return new ErrorType(r101, r102, r103, r104, r100, (String[]) Arrays.copyOf(r105, r105.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    public final ErrorType replaceArguments(List<? extends TypeProjection> r100) {
        Intrinsics.checkNotNullParameter(r100, "newArguments");
        TypeConstructor r101 = getConstructor();
        MemberScope r102 = getMemberScope();
        ErrorTypeKind r103 = this.kind;
        boolean r104 = isMarkedNullable();
        String[] r105 = this.formatParams;
        return new ErrorType(r101, r102, r103, r100, r104, (String[]) Arrays.copyOf(r105, r105.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r100) {
        return replaceAttributes(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r100) {
        return makeNullableAsSpecified(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType(TypeConstructor r100, MemberScope r101, ErrorTypeKind r102, List<? extends TypeProjection> r103, boolean r104, String... r105) {
        Intrinsics.checkNotNullParameter(r100, "constructor");
        Intrinsics.checkNotNullParameter(r101, "memberScope");
        Intrinsics.checkNotNullParameter(r102, "kind");
        Intrinsics.checkNotNullParameter(r103, "arguments");
        Intrinsics.checkNotNullParameter(r105, "formatParams");
        this.constructor = r100;
        this.memberScope = r101;
        this.kind = r102;
        this.arguments = r103;
        this.isMarkedNullable = r104;
        this.formatParams = r105;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        String r107 = r102.getDebugMessage();
        Object[] r108 = Arrays.copyOf(r105, r105.length);
        this.debugMessage = String.format(r107, Arrays.copyOf(r108, r108.length));
    }

    public /* synthetic */ ErrorType(TypeConstructor r100, MemberScope r101, ErrorTypeKind r110, List r111, boolean r112, String[] r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        r111 = CollectionsKt.emptyList();
    L5:
        List r102 = r111;
        if ((r114 & 16) == 0) goto L8;
        boolean r103 = false;
    L9:
        this(r100, r101, r110, r102, r103, r113);
        return;
    L8:
        r103 = r112;
        goto L9
    }
}
