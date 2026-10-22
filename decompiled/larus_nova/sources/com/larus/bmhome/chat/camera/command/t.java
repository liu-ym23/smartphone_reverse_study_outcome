package com.larus.bmhome.chat.camera.command;

import android.os.Bundle;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f297608a;

    public static final class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CameraOutputContext f297609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SuggestedAction f297610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f297611d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f297609b, r101.f297609b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297610c, r101.f297610c) == true) goto L15;
            return false;
        L15:
            if (this.f297611d == r101.f297611d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f297609b.hashCode() * 31;
            SuggestedAction r101 = this.f297610c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f297611d;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CameraOutput(outputContext=" + this.f297609b + ", selectedSuggestedAction=" + this.f297610c + ", createTimeMs=" + this.f297611d + ')';
        }

        @Override // com.larus.bmhome.chat.camera.command.t
        public final long a() {
            return this.f297611d;
        }

        public a(CameraOutputContext r100, SuggestedAction r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "outputContext");
            super(r102);
            this.f297609b = r100;
            this.f297610c = r101;
            this.f297611d = r102;
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f297612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f297613c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f297612b, r101.f297612b) == true) goto L12;
            return false;
        L12:
            if (this.f297613c == r101.f297613c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f297612b.hashCode() * 31;
            long r101 = this.f297613c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "CreationPageReturn(resultBundle=" + this.f297612b + ", createTimeMs=" + this.f297613c + ')';
        }

        @Override // com.larus.bmhome.chat.camera.command.t
        public final long a() {
            return this.f297613c;
        }

        public b(Bundle r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "resultBundle");
            super(r101);
            this.f297612b = r100;
            this.f297613c = r101;
        }
    }

    public long a() {
        return this.f297608a;
    }

    public t(long r100) {
        this.f297608a = r100;
    }
}
