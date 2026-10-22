package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433761a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.fileupload.h$a$a, reason: collision with other inner class name */
        public static final class C5157a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MmMinutesFileUploadErrorCode f433762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f433763b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5157a) == true) goto L8;
                return false;
            L8:
                C5157a r101 = (C5157a) r100;
                if (this.f433762a == r101.f433762a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f433763b, r101.f433763b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f433762a.hashCode() * 31) + this.f433763b.hashCode();
            }

            public final String toString() {
                return "Failure(code=" + this.f433762a + ", message=" + this.f433763b + ')';
            }

            public C5157a(MmMinutesFileUploadErrorCode r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "code");
                Intrinsics.checkNotNullParameter(r101, "message");
                this.f433762a = r100;
                this.f433763b = r101;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final File f433764a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f433764a, ((b) r100).f433764a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f433764a.hashCode();
            }

            public final String toString() {
                return "Success(oggFile=" + this.f433764a + ')';
            }

            public b(VFSFile r100) {
                Intrinsics.checkNotNullParameter(r100, "oggFile");
                this.f433764a = r100;
            }
        }

        public a() {
        }
    }

    static {
    }
}
