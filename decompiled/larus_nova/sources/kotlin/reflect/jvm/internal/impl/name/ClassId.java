package kotlin.reflect.jvm.internal.impl.name;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ClassId {
    public static final Companion Companion = null;
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final ClassId topLevel(FqName r100) {
            Intrinsics.checkNotNullParameter(r100, "topLevelFqName");
            return new ClassId(r100.parent(), r100.shortName());
        }

        @JvmStatic
        public final ClassId fromString(String r100, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "string");
            int r101 = StringsKt.indexOf$default(r100, '`', 0, false, 6, null);
            if (r101 != (-1)) goto L5;
            r101 = r100.length();
        L5:
            int r102 = StringsKt.lastIndexOf$default(r100, HTTP.URL_DEFAULT, r101, false, 4, null);
            if (r102 != (-1)) goto L8;
            String r103 = StringsKt.replace$default(r100, InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "", false, 4, null);
            String r104 = "";
        L10:
            return new ClassId(new FqName(r104), new FqName(r103), r110);
        L8:
            String r105 = StringsKt.replace$default(r100.substring(0, r102), '/', '.', false, 4, null);
            r103 = StringsKt.replace$default(r100.substring(r102 + 1), InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "", false, 4, null);
            r104 = r105;
            goto L10
        }

        public static /* synthetic */ ClassId fromString$default(Companion r100, String r101, boolean r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            return r100.fromString(r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final ClassId topLevel(FqName r100) {
        return Companion.topLevel(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClassId) == true) goto L8;
        return false;
    L8:
        ClassId r101 = (ClassId) r100;
        if (Intrinsics.areEqual(this.packageFqName, r101.packageFqName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.relativeClassName, r101.relativeClassName) == true) goto L15;
        return false;
    L15:
        if (this.isLocal == r101.isLocal) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31;
        if (this.isLocal == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return this.relativeClassName;
    L6:
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    public final String asString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return asString$escapeSlashes(this.relativeClassName);
    L6:
        return StringsKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, null) + HTTP.URL_DEFAULT + asString$escapeSlashes(this.relativeClassName);
    }

    public final ClassId getOuterClassId() {
        FqName r100 = this.relativeClassName.parent();
        if ((!r100.isRoot()) == true) goto L7;
        return null;
    L7:
        return new ClassId(this.packageFqName, r100, this.isLocal);
    }

    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return HTTP.URL_DEFAULT + asString();
    L6:
        return asString();
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    private static final String asString$escapeSlashes(FqName r100) {
        String r101 = r100.asString();
        if (StringsKt.contains$default(r101, '/', false, 2, null) == true) goto L5;
        return r101;
    L5:
        return InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER + r101 + '`';
    }

    public final ClassId createNestedClassId(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new ClassId(this.packageFqName, this.relativeClassName.child(r100), this.isLocal);
    }

    public ClassId(FqName r100, Name r101) {
        Intrinsics.checkNotNullParameter(r100, "packageFqName");
        Intrinsics.checkNotNullParameter(r101, "topLevelName");
        this(r100, FqName.topLevel(r101), false);
    }

    public ClassId(FqName r100, FqName r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "packageFqName");
        Intrinsics.checkNotNullParameter(r101, "relativeClassName");
        this.packageFqName = r100;
        this.relativeClassName = r101;
        this.isLocal = r102;
        r101.isRoot();
    }
}
