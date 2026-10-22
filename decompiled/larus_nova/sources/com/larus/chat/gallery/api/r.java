package com.larus.chat.gallery.api;

import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class r {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<AttachmentSnapshot> f324177a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f324177a, ((a) r100).f324177a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f324177a.hashCode();
        }

        public final String toString() {
            return "Append(attachments=" + this.f324177a + ')';
        }

        public a(List<AttachmentSnapshot> r100) {
            Intrinsics.checkNotNullParameter(r100, "attachments");
            this.f324177a = r100;
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f324178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AttachmentSnapshot f324179b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f324178a, r101.f324178a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f324179b, r101.f324179b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f324178a.hashCode() * 31) + this.f324179b.hashCode();
        }

        public final String toString() {
            return "Replace(originStableId=" + this.f324178a + ", edited=" + this.f324179b + ')';
        }

        public b(String r100, AttachmentSnapshot r101) {
            Intrinsics.checkNotNullParameter(r100, "originStableId");
            Intrinsics.checkNotNullParameter(r101, "edited");
            this.f324178a = r100;
            this.f324179b = r101;
        }
    }

    public r() {
    }
}
