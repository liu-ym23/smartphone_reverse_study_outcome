package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433775a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.fileupload.n$a$a, reason: collision with other inner class name */
        public static final class C5158a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MmMinutesFileUploadTaskState f433776a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5158a) == true) goto L9;
                return false;
            L9:
                if (this.f433776a == ((C5158a) r100).f433776a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f433776a.hashCode();
            }

            public final String toString() {
                return "EnterState(state=" + this.f433776a + ')';
            }

            public C5158a(MmMinutesFileUploadTaskState r100) {
                Intrinsics.checkNotNullParameter(r100, "state");
                this.f433776a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final eub.b f433777a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f433777a, ((b) r100).f433777a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f433777a.hashCode();
            }

            public final String toString() {
                return "Interrupt(error=" + this.f433777a + ')';
            }

            public b(eub.b r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f433777a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f433778a = null;

            static {
                f433778a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433779a = null;

        static {
            int[] r100 = new int[MmMinutesFileUploadTaskState.values().length];
            r100[MmMinutesFileUploadTaskState.Interrupted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmMinutesFileUploadTaskState.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmMinutesFileUploadTaskState.Init.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f433779a = r100;
        }
    }

    static {
    }

    public static eub.g a(eub.g r110, a r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "event");
        if ((r111 instanceof a.C5158a) == true) goto L22;
        MmMinutesFileUploadTaskState r100 = null;
        if ((r111 instanceof a.b) == false) goto L17;
        MmMinutesFileUploadTaskState r101 = MmMinutesFileUploadTaskState.Interrupted;
        eub.b r102 = ((a.b) r111).f433777a;
        MmMinutesFileUploadTaskState r112 = r110.f474162a;
        int r113 = b.f433779a[r112.ordinal()];
        if (r113 != 1) goto L10;
    L14:
        r100 = r110.f474169h;
    L23:
        return eub.g.a(r110, r101, 0, 0, null, null, null, r102, r100, 62);
    L10:
        if (r113 == 2) goto L14;
        if (r113 == 3) goto L23;
        r100 = r110.f474162a;
        goto L23
    L17:
        if (Intrinsics.areEqual(r111, a.c.f433778a) == false) goto L21;
        return new eub.g(MmMinutesFileUploadTaskState.Init, null, 254);
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        return eub.g.a(r110, ((a.C5158a) r111).f433776a, 0, 0, null, null, null, null, null, 62);
    }
}
