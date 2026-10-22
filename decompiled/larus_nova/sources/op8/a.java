package op8;

import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: op8.a$a, reason: collision with other inner class name */
    public static final class C7085a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<AttachmentSnapshot> f524740a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7085a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f524740a, ((C7085a) r100).f524740a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f524740a.hashCode();
        }

        public final String toString() {
            return "AppendAttachments(attachments=" + this.f524740a + ')';
        }

        public C7085a(List<AttachmentSnapshot> r100) {
            Intrinsics.checkNotNullParameter(r100, "attachments");
            this.f524740a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f524742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AttachmentSnapshot f524743c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f524741a, r101.f524741a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f524742b, r101.f524742b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f524743c, r101.f524743c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f524741a.hashCode() * 31;
            String r101 = this.f524742b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            AttachmentSnapshot r105 = this.f524743c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CommitAlbumSelection(originStableId=" + this.f524741a + ", originUri=" + this.f524742b + ", attachment=" + this.f524743c + ')';
        }

        public b(String r100, String r101, AttachmentSnapshot r102) {
            Intrinsics.checkNotNullParameter(r100, "originStableId");
            this.f524741a = r100;
            this.f524742b = r101;
            this.f524743c = r102;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f524745b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f524744a, r101.f524744a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f524745b, r101.f524745b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f524744a.hashCode() * 31;
            String r101 = this.f524745b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RemoveAttachment(originStableId=" + this.f524744a + ", originUri=" + this.f524745b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "originStableId");
            this.f524744a = r100;
            this.f524745b = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f524747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AttachmentSnapshot f524748c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f524746a, r101.f524746a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f524747b, r101.f524747b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f524748c, r101.f524748c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f524746a.hashCode() * 31;
            String r101 = this.f524747b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f524748c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReplaceAttachment(originStableId=" + this.f524746a + ", originUri=" + this.f524747b + ", edited=" + this.f524748c + ')';
        }

        public d(String r100, String r101, AttachmentSnapshot r102) {
            Intrinsics.checkNotNullParameter(r100, "originStableId");
            Intrinsics.checkNotNullParameter(r102, "edited");
            this.f524746a = r100;
            this.f524747b = r101;
            this.f524748c = r102;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524749a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f524749a, ((e) r100).f524749a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f524749a.hashCode();
        }

        public final String toString() {
            return "UpdateText(text=" + this.f524749a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f524749a = r100;
        }
    }

    public a() {
    }
}
