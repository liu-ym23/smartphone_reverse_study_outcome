package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "Ljava/io/Serializable;", "<init>", "()V", "RootMine", "Folder", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget$Folder;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget$RootMine;", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OfficeSpaceUploadTarget implements Serializable {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget$Folder;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "folderToken", "", "<init>", "(Ljava/lang/String;)V", "getFolderToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Folder extends OfficeSpaceUploadTarget {
        private final String folderToken;

        public static /* synthetic */ Folder copy$default(Folder r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.folderToken;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.folderToken;
        }

        public final Folder copy(String r2) {
            Intrinsics.checkNotNullParameter(r2, "folderToken");
            return new Folder(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Folder) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.folderToken, ((Folder) r4).folderToken) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.folderToken.hashCode();
        }

        public String toString() {
            return "Folder(folderToken=" + this.folderToken + ')';
        }

        public final String getFolderToken() {
            return this.folderToken;
        }

        public Folder(String r2) {
            Intrinsics.checkNotNullParameter(r2, "folderToken");
            super(null);
            this.folderToken = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget$RootMine;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "<init>", "()V", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RootMine extends OfficeSpaceUploadTarget {
        public static final RootMine INSTANCE = null;

        static {
            INSTANCE = new RootMine();
        }

        private RootMine() {
            super(null);
        }
    }

    private OfficeSpaceUploadTarget() {
    }

    public /* synthetic */ OfficeSpaceUploadTarget(DefaultConstructorMarker r1) {
        this();
    }
}
