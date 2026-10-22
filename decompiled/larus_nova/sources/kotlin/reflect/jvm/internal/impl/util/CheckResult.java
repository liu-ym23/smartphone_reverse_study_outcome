package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CheckResult {
    private final boolean isSuccess;

    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = null;

        static {
            INSTANCE = new IllegalFunctionName();
        }

        private IllegalFunctionName() {
            super(false, null);
        }
    }

    public static final class IllegalSignature extends CheckResult {
        private final String error;

        public IllegalSignature(String r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            super(false, null);
            this.error = r100;
        }
    }

    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = null;

        static {
            INSTANCE = new SuccessCheck();
        }

        private SuccessCheck() {
            super(true, null);
        }
    }

    public /* synthetic */ CheckResult(boolean r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    private CheckResult(boolean r100) {
        this.isSuccess = r100;
    }
}
