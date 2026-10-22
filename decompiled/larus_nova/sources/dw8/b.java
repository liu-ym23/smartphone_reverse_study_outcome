package dw8;

import com.larus.business.floatchat.api.AIChatActionBarCapability;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIChatActionBarCapability f470328a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f470328a == ((a) r100).f470328a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f470328a.hashCode();
        }

        public final String toString() {
            return "OpenCapability(capability=" + this.f470328a + ')';
        }

        public a(AIChatActionBarCapability r100) {
            Intrinsics.checkNotNullParameter(r100, "capability");
            this.f470328a = r100;
        }
    }

    /* JADX INFO: renamed from: dw8.b$b, reason: collision with other inner class name */
    public static final class C5717b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f470329a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5717b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f470329a, ((C5717b) r100).f470329a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f470329a.hashCode();
        }

        public final String toString() {
            return "OpenSchema(schema=" + this.f470329a + ')';
        }

        public C5717b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            this.f470329a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f470330a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f470330a, ((c) r100).f470330a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f470330a.hashCode();
        }

        public final String toString() {
            return "SendPrompt(prompt=" + this.f470330a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
            this.f470330a = r100;
        }
    }

    public b() {
    }
}
