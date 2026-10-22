package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            r100[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int r100) {
        LinkedList r101 = new LinkedList();
        LinkedList r102 = new LinkedList();
        boolean r103 = false;
    L4:
        if (r100 == (-1)) goto L18;
        ProtoBuf.QualifiedNameTable.QualifiedName r104 = this.qualifiedNames.getQualifiedName(r100);
        String r105 = this.strings.getString(r104.getShortName());
        ProtoBuf.QualifiedNameTable.QualifiedName.Kind r106 = r104.getKind();
        Intrinsics.checkNotNull(r106);
        int r107 = WhenMappings.$EnumSwitchMapping$0[r106.ordinal()];
        if (r107 != 1) goto L8;
        r102.addFirst(r105);
    L16:
        r100 = r104.getParentQualifiedName();
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r101.addFirst(r105);
        goto L16
    L10:
        if (r107 != 3) goto L13;
        r102.addFirst(r105);
        r103 = true;
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return new Triple(r101, r102, Boolean.valueOf(r103));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r110) {
        Triple<List<String>, List<String>, Boolean> r111 = traverseIds(r110);
        List<String> r100 = r111.component1();
        String r112 = CollectionsKt.joinToString$default(r111.component2(), ".", null, null, 0, null, null, 62, null);
        if (r100.isEmpty() == false) goto L6;
        return r112;
    L6:
        return CollectionsKt.joinToString$default(r100, HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null) + '/' + r112;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r100) {
        return this.strings.getString(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r100) {
        return traverseIds(r100).getThird().booleanValue();
    }

    public NameResolverImpl(ProtoBuf.StringTable r100, ProtoBuf.QualifiedNameTable r101) {
        Intrinsics.checkNotNullParameter(r100, "strings");
        Intrinsics.checkNotNullParameter(r101, "qualifiedNames");
        this.strings = r100;
        this.qualifiedNames = r101;
    }
}
