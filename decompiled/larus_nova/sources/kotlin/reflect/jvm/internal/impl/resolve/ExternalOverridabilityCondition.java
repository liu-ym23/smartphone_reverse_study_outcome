package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public interface ExternalOverridabilityCondition {

    /* JADX INFO: loaded from: classes42.dex */
    public static final enum Contract extends Enum<Contract> {
        private static final /* synthetic */ Contract[] $VALUES = null;
        public static final Contract BOTH = null;
        public static final Contract CONFLICTS_ONLY = null;
        public static final Contract SUCCESS_ONLY = null;

        static {
            Contract r100 = new Contract("CONFLICTS_ONLY", 0);
            CONFLICTS_ONLY = r100;
            Contract r101 = new Contract("SUCCESS_ONLY", 1);
            SUCCESS_ONLY = r101;
            Contract r102 = new Contract("BOTH", 2);
            BOTH = r102;
            $VALUES = new Contract[]{r100, r101, r102};
        }

        public static Contract[] values() {
            return (Contract[]) $VALUES.clone();
        }

        public static Contract valueOf(String r100) {
            return (Contract) a.a(Contract.class, r100);
        }

        private Contract(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result INCOMPATIBLE = null;
        public static final Result OVERRIDABLE = null;
        public static final Result UNKNOWN = null;

        static {
            Result r100 = new Result("OVERRIDABLE", 0);
            OVERRIDABLE = r100;
            Result r101 = new Result("INCOMPATIBLE", 1);
            INCOMPATIBLE = r101;
            Result r102 = new Result("UNKNOWN", 2);
            UNKNOWN = r102;
            $VALUES = new Result[]{r100, r101, r102};
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) a.a(Result.class, r100);
        }

        private Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    Contract getContract();

    Result isOverridable(CallableDescriptor r100, CallableDescriptor r101, ClassDescriptor r102);
}
