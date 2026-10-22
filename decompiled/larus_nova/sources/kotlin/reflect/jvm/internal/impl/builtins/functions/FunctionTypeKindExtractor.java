package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class FunctionTypeKindExtractor {
    public static final Companion Companion = null;
    private static final FunctionTypeKindExtractor Default = null;
    private final List<FunctionTypeKind> kinds;
    private final Map<FqName, List<FunctionTypeKind>> knownKindsByPackageFqName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FunctionTypeKindExtractor getDefault() {
            return FunctionTypeKindExtractor.access$getDefault$cp();
        }
    }

    public static final class KindWithArity {
        private final int arity;
        private final FunctionTypeKind kind;

        public final FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof KindWithArity) == true) goto L8;
            return false;
        L8:
            KindWithArity r101 = (KindWithArity) r100;
            if (Intrinsics.areEqual(this.kind, r101.kind) == true) goto L12;
            return false;
        L12:
            if (this.arity == r101.arity) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
        }

        public final FunctionTypeKind getKind() {
            return this.kind;
        }

        public KindWithArity(FunctionTypeKind r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "kind");
            this.kind = r100;
            this.arity = r101;
        }
    }

    static {
        Companion = new Companion(null);
        Default = new FunctionTypeKindExtractor(CollectionsKt.listOf(new FunctionTypeKind[]{FunctionTypeKind.Function.INSTANCE, FunctionTypeKind.SuspendFunction.INSTANCE, FunctionTypeKind.KFunction.INSTANCE, FunctionTypeKind.KSuspendFunction.INSTANCE}));
    }

    public static final /* synthetic */ FunctionTypeKindExtractor access$getDefault$cp() {
        return Default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionTypeKindExtractor(List<? extends FunctionTypeKind> r100) {
        Intrinsics.checkNotNullParameter(r100, "kinds");
        this.kinds = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        FqName r104 = ((FunctionTypeKind) r103).getPackageFqName();
        Object r105 = r101.get(r104);
        if (r105 != null) goto L8;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L8:
        ((List) r105).add(r103);
        goto L4
    L9:
        this.knownKindsByPackageFqName = r101;
    }

    private final Integer toInt(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return null;
    L9:
        int r102 = r100.length();
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r103 >= r102) goto L21;
        int r105 = r100.charAt(r103) - '0';
        if (r105 >= 0) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L18;
        r104 = (r104 * 10) + r105;
        r103 = r103 + 1;
        goto L10
    L18:
        return null;
    L14:
        if (r105 >= 10) goto L16;
        r106 = true;
        goto L17
    L21:
        return Integer.valueOf(r104);
    L5:
        r101 = false;
        goto L7
    }

    public final FunctionTypeKind getFunctionalClassKind(FqName r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageFqName");
        Intrinsics.checkNotNullParameter(r101, PushClientConstants.TAG_CLASS_NAME);
        KindWithArity r102 = getFunctionalClassKindWithArity(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getKind();
    }

    public final KindWithArity getFunctionalClassKindWithArity(FqName r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageFqName");
        Intrinsics.checkNotNullParameter(r101, PushClientConstants.TAG_CLASS_NAME);
        List<FunctionTypeKind> r102 = this.knownKindsByPackageFqName.get(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        Iterator<FunctionTypeKind> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        FunctionTypeKind r104 = r103.next();
        if (StringsKt.startsWith$default(r101, r104.getClassNamePrefix(), false, 2, null) == false) goto L7;
        Integer r105 = toInt(r101.substring(r104.getClassNamePrefix().length()));
        if (r105 == null) goto L7;
        return new KindWithArity(r104, r105.intValue());
    L14:
        return null;
    }
}
