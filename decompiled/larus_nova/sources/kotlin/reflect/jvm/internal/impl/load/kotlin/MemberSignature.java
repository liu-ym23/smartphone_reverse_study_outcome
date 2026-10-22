package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.tencent.open.SocialConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* JADX INFO: loaded from: classes42.dex */
public final class MemberSignature {
    public static final Companion Companion = null;
    private final String signature;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature r100) {
            Intrinsics.checkNotNullParameter(r100, "signature");
            if ((r100 instanceof JvmMemberSignature.Method) == false) goto L6;
            JvmMemberSignature.Method r101 = (JvmMemberSignature.Method) r100;
            return fromMethodNameAndDesc(r101.getName(), r101.getDesc());
        L6:
            if ((r100 instanceof JvmMemberSignature.Field) == false) goto L10;
            JvmMemberSignature.Field r102 = (JvmMemberSignature.Field) r100;
            return fromFieldNameAndDesc(r102.getName(), r102.getDesc());
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            return new MemberSignature(r100 + '#' + r101, null);
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver r100, JvmProtoBuf.JvmMethodSignature r101) {
            Intrinsics.checkNotNullParameter(r100, "nameResolver");
            Intrinsics.checkNotNullParameter(r101, "signature");
            return fromMethodNameAndDesc(r100.getString(r101.getName()), r100.getString(r101.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            return new MemberSignature(r100 + r101, null);
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "signature");
            return new MemberSignature(r100.getSignature() + '@' + r101, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MemberSignature(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MemberSignature) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.signature, ((MemberSignature) r100).signature) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }

    public final String getSignature() {
        return this.signature;
    }

    private MemberSignature(String r100) {
        this.signature = r100;
    }
}
