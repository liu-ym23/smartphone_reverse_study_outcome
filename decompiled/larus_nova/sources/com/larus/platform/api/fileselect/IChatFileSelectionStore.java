package com.larus.platform.api.fileselect;

import aq9.f;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.u;
import com.obric.miniapp.alarm.AccountType;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes31.dex */
public interface IChatFileSelectionStore {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$Source;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "DRIVE", AccountType.LOCAL, "SELECTED_LIST", "UNKNOWN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DRIVE = null;
        public static final Source LOCAL = null;
        public static final Source RECENT = null;
        public static final Source SELECTED_LIST = null;
        public static final Source UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f365112a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f365113b = null;

        public static EnumEntries<Source> getEntries() {
            return f365113b;
        }

        static {
            Source r100 = new Source("RECENT", 0);
            RECENT = r100;
            Source r101 = new Source("DRIVE", 1);
            DRIVE = r101;
            Source r102 = new Source(AccountType.LOCAL, 2);
            LOCAL = r102;
            Source r103 = new Source("SELECTED_LIST", 3);
            SELECTED_LIST = r103;
            Source r104 = new Source("UNKNOWN", 4);
            UNKNOWN = r104;
            Source[] r105 = {r100, r101, r102, r103, r104};
            f365112a = r105;
            f365113b = EnumEntriesKt.enumEntries(r105);
        }

        public static Source[] values() {
            return (Source[]) f365112a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.larus.platform.api.fileselect.IChatFileSelectionStore$a$a, reason: collision with other inner class name */
        public static final class C4467a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f365114a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4467a) == true) goto L9;
                return false;
            L9:
                if (this.f365114a == ((C4467a) r100).f365114a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f365114a;
                return (int) (r100 ^ (r100 >>> 32));
            }

            public final String toString() {
                return "FileSizeNotAllowed(maxFileSize=" + this.f365114a + ')';
            }

            public C4467a(long r100) {
                this.f365114a = r100;
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f365115a = null;

            static {
                f365115a = new b();
            }

            public b() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                b r101 = (b) r100;
                return true;
            }

            public final int hashCode() {
                return 1813436526;
            }

            public final String toString() {
                return "InvalidExistingSelection";
            }
        }

        public static final class c implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f365116a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.f365116a == ((c) r100).f365116a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f365116a;
            }

            public final String toString() {
                return "MaxCountReached(maxCount=" + this.f365116a + ')';
            }

            public c(int r100) {
                this.f365116a = r100;
            }
        }

        public static final class d implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FlowDriveFileType f365117a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final FlowDriveFileType f365118b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L8;
                return false;
            L8:
                d r101 = (d) r100;
                if (this.f365117a == r101.f365117a) goto L12;
                return false;
            L12:
                if (this.f365118b == r101.f365118b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f365117a.hashCode() * 31) + this.f365118b.hashCode();
            }

            public final String toString() {
                return "MixedTypeNotSupported(selectedType=" + this.f365117a + ", incomingType=" + this.f365118b + ')';
            }

            public d(FlowDriveFileType r100, FlowDriveFileType r101) {
                Intrinsics.checkNotNullParameter(r100, "selectedType");
                Intrinsics.checkNotNullParameter(r101, "incomingType");
                this.f365117a = r100;
                this.f365118b = r101;
            }
        }

        public static final class e implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FlowDriveFileType f365119a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                if (this.f365119a == ((e) r100).f365119a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f365119a.hashCode();
            }

            public final String toString() {
                return "TypeNotAllowed(type=" + this.f365119a + ')';
            }

            public final FlowDriveFileType getType() {
                return this.f365119a;
            }

            public e(FlowDriveFileType r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                this.f365119a = r100;
            }
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f365120a = null;

            static {
                f365120a = new a();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                a r101 = (a) r100;
                return true;
            }

            public final int hashCode() {
                return 1017710447;
            }

            public final String toString() {
                return "Applied";
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.platform.api.fileselect.IChatFileSelectionStore$b$b, reason: collision with other inner class name */
        public static final class C4468b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f365121a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4468b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f365121a, ((C4468b) r100).f365121a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f365121a.hashCode();
            }

            public final String toString() {
                return "Rejected(reason=" + this.f365121a + ')';
            }

            public C4468b(a r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f365121a = r100;
            }
        }

        public b() {
        }
    }

    b.a a(String r100, Source r101);

    b b(u r100, Source r101);

    b c(u r100, Source r101);

    void d(f r100);

    Source e(String r100);

    StateFlowImpl getState();

    List<u> snapshot();
}
