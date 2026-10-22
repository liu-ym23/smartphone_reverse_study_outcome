package r2;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {

    /* JADX INFO: renamed from: r2.a$a, reason: collision with other inner class name */
    public static final class C7424a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppletChatActionBarCapability f535690a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7424a) == true) goto L9;
            return false;
        L9:
            if (this.f535690a == ((C7424a) r100).f535690a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f535690a.hashCode();
        }

        public final String toString() {
            return "OpenCapability(capability=" + this.f535690a + ')';
        }

        public C7424a(AppletChatActionBarCapability r100) {
            Intrinsics.checkNotNullParameter(r100, "capability");
            this.f535690a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535691a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f535691a, ((b) r100).f535691a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f535691a.hashCode();
        }

        public final String toString() {
            return "OpenSchema(schema=" + this.f535691a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            this.f535691a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535692a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f535692a, ((c) r100).f535692a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f535692a.hashCode();
        }

        public final String toString() {
            return "SendPrompt(prompt=" + this.f535692a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
            this.f535692a = r100;
        }
    }

    public a() {
    }
}
