package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class JvmMemberSignature {

    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.desc;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r101 = (Field) r100;
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public Field(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            super(null);
            this.name = r100;
            this.desc = r101;
        }
    }

    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public static /* synthetic */ Method copy$default(Method r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.name;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.desc;
        L9:
            return r100.copy(r101, r102);
        }

        public final Method copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            return new Method(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Method) == true) goto L8;
            return false;
        L8:
            Method r101 = (Method) r100;
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public Method(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            super(null);
            this.name = r100;
            this.desc = r101;
        }
    }

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker r100) {
        this();
    }

    public abstract String asString();

    public final String toString() {
        return asString();
    }
}
