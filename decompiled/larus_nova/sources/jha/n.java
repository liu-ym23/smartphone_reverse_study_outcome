package jha;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import jha.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes33.dex */
public interface n<S extends o> {

    public static final class a<S extends o> implements n<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Deferred<Unit> f499143a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499143a, ((a) r100).f499143a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499143a.hashCode();
        }

        public final String toString() {
            return "Closing(closed=" + this.f499143a + ')';
        }

        public a(CompletableDeferred r100) {
            Intrinsics.checkNotNullParameter(r100, PTYSocketStateCallback.CLOSED);
            this.f499143a = r100;
        }
    }

    public static final class b<S extends o> implements n<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<S> f499144a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499144a, ((b) r100).f499144a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499144a.hashCode();
        }

        public final String toString() {
            return "ExistingOpen(handle=" + this.f499144a + ')';
        }

        public b(l<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            this.f499144a = r100;
        }
    }

    public static final class c<S extends o> implements n<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TaskDispatchResult f499145a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f499145a == ((c) r100).f499145a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499145a.hashCode();
        }

        public final String toString() {
            return "Failed(result=" + this.f499145a + ')';
        }

        public c(TaskDispatchResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f499145a = r100;
        }
    }

    public static final class d<S extends o> implements n<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<S> f499146a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499146a, ((d) r100).f499146a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499146a.hashCode();
        }

        public final String toString() {
            return "Started(handle=" + this.f499146a + ')';
        }

        public d(l<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            this.f499146a = r100;
        }
    }
}
