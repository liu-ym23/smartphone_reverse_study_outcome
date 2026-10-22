package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    public static final class AtLeast extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f504589n;

        public AtLeast(int r100) {
            StringBuilder r101 = new StringBuilder("must have at least ");
            r101.append(r100);
            r101.append(" value parameter");
            if (r100 <= 1) goto L5;
            String r102 = "s";
        L6:
            r101.append(r102);
            super(r101.toString(), null);
            this.f504589n = r100;
            return;
        L5:
            r102 = "";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
            if (r100.getValueParameters().size() < this.f504589n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class Equals extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f504590n;

        public Equals(int r100) {
            super("must have exactly " + r100 + " value parameters", null);
            this.f504590n = r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
            if (r100.getValueParameters().size() != this.f504590n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = null;

        static {
            INSTANCE = new NoValueParameters();
        }

        private NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
            return r100.getValueParameters().isEmpty();
        }
    }

    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = null;

        static {
            INSTANCE = new SingleValueParameter();
        }

        private SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
            if (r100.getValueParameters().size() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    public /* synthetic */ ValueParameterCountCheck(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    private ValueParameterCountCheck(String r100) {
        this.description = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r100) {
        return Check.DefaultImpls.invoke(this, r100);
    }
}
