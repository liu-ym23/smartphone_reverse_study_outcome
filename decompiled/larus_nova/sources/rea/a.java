package rea;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a {

    /* JADX INFO: renamed from: rea.a$a, reason: collision with other inner class name */
    public static final class C7470a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537454a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7470a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537454a, ((C7470a) r100).f537454a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537454a.hashCode();
        }

        public final String toString() {
            return "CloseRealtimeCall(intent=" + this.f537454a + ')';
        }

        public C7470a(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537454a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537455a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537455a, ((b) r100).f537455a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537455a.hashCode();
        }

        public final String toString() {
            return "CloseTTS(intent=" + this.f537455a + ')';
        }

        public b(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537455a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537456a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537456a, ((c) r100).f537456a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537456a.hashCode();
        }

        public final String toString() {
            return "EnterDialogue(intent=" + this.f537456a + ')';
        }

        public c(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537456a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537457a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537457a, ((d) r100).f537457a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537457a.hashCode();
        }

        public final String toString() {
            return "JumpToChatPage(intent=" + this.f537457a + ')';
        }

        public d(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537457a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537458a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537458a, ((e) r100).f537458a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537458a.hashCode();
        }

        public final String toString() {
            return "MuteRealtimeCall(intent=" + this.f537458a + ')';
        }

        public e(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537458a = r100;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537459a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537459a, ((f) r100).f537459a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537459a.hashCode();
        }

        public final String toString() {
            return "NA(intent=" + this.f537459a + ')';
        }

        public f(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537459a = r100;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537460a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537460a, ((g) r100).f537460a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537460a.hashCode();
        }

        public final String toString() {
            return "OpenSpecialInput(intent=" + this.f537460a + ')';
        }

        public g(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537460a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537461a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537461a, ((h) r100).f537461a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537461a.hashCode();
        }

        public final String toString() {
            return "ReplayCallForMe(intent=" + this.f537461a + ')';
        }

        public h(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537461a = r100;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f537462a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f537462a, ((i) r100).f537462a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f537462a.hashCode();
        }

        public final String toString() {
            return "UnMuteRealtimeCall(intent=" + this.f537462a + ')';
        }

        public i(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            this.f537462a = r100;
        }
    }

    public a() {
    }
}
