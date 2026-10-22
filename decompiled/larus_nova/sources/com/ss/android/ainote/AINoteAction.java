package com.ss.android.ainote;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface AINoteAction {

    public static final class NoteEventNotify implements AINoteAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f406455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f406456b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ainote/AINoteAction$NoteEventNotify$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "MODIFY", "DELETE", "CLICK", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Type extends Enum<Type> {
            public static final Type ADD = null;
            public static final Type CLICK = null;
            public static final Type DELETE = null;
            public static final Type MODIFY = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f406457a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f406458b = null;

            public static EnumEntries<Type> getEntries() {
                return f406458b;
            }

            static {
                Type r100 = new Type("ADD", 0);
                ADD = r100;
                Type r101 = new Type("MODIFY", 1);
                MODIFY = r101;
                Type r102 = new Type("DELETE", 2);
                DELETE = r102;
                Type r103 = new Type("CLICK", 3);
                CLICK = r103;
                Type[] r104 = {r100, r101, r102, r103};
                f406457a = r104;
                f406458b = EnumEntriesKt.enumEntries(r104);
            }

            public static Type[] values() {
                return (Type[]) f406457a.clone();
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public Type(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NoteEventNotify) == true) goto L8;
            return false;
        L8:
            NoteEventNotify r101 = (NoteEventNotify) r100;
            if (this.f406455a == r101.f406455a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406456b, r101.f406456b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f406455a.hashCode() * 31) + this.f406456b.hashCode();
        }

        public final String toString() {
            return "NoteEventNotify(type=" + this.f406455a + ", note=" + this.f406456b + ')';
        }

        public final Type getType() {
            return this.f406455a;
        }

        public NoteEventNotify(Type r100, p r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "note");
            this.f406455a = r100;
            this.f406456b = r101;
        }
    }

    @Deprecated(message = "Use NoteEventNotify(Type.CLICK, note) instead.")
    public static final class a implements AINoteAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f406460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f406461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f406462d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f406459a == r101.f406459a) goto L12;
            return false;
        L12:
            if (this.f406460b == r101.f406460b) goto L15;
            return false;
        L15:
            if (this.f406461c == r101.f406461c) goto L18;
            return false;
        L18:
            if (this.f406462d == r101.f406462d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406459a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f406460b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f406461c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f406462d;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public final String toString() {
            return "GoToSubtitle(noteId=" + this.f406459a + ", clientCreateTimeMs=" + this.f406460b + ", createRelMeetingTimeMs=" + this.f406461c + ", createRelAudioTimeMs=" + this.f406462d + ')';
        }

        public a(long r100, long r101, long r102, long r103) {
            this.f406459a = r100;
            this.f406460b = r101;
            this.f406461c = r102;
            this.f406462d = r103;
        }
    }

    public static final class b implements AINoteAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f406463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<q> f406464b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f406463a == r101.f406463a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406464b, r101.f406464b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f406463a * 31) + this.f406464b.hashCode();
        }

        public final String toString() {
            return "ImageClick(index=" + this.f406463a + ", images=" + this.f406464b + ')';
        }

        public b(int r100, List<q> r101) {
            Intrinsics.checkNotNullParameter(r101, "images");
            this.f406463a = r100;
            this.f406464b = r101;
        }
    }

    public static final class c implements AINoteAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406465a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f406465a, ((c) r100).f406465a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f406465a.hashCode();
        }

        public final String toString() {
            return "LinkClick(url=" + this.f406465a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f406465a = r100;
        }
    }

    public static final class d implements AINoteAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406467b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f406466a, r101.f406466a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406467b, r101.f406467b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f406466a.hashCode() * 31) + this.f406467b.hashCode();
        }

        public final String toString() {
            return "TaskClick(taskId=" + this.f406466a + ", guid=" + this.f406467b + ')';
        }

        public d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "guid");
            this.f406466a = r100;
            this.f406467b = r101;
        }
    }
}
