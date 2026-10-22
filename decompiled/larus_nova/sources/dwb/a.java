package dwb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingNestedScrollMode;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: dwb.a$a, reason: collision with other inner class name */
    public static final class C5719a extends a {
        @Override // dwb.a
        public final MmRecordingNestedScrollMode a() {
            return null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5719a) == true) goto L8;
            return false;
        L8:
            ((C5719a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "FragmentSlot(factory=null, nestedScrollMode=null)";
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<Context, com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d, View> f470393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MmRecordingNestedScrollMode f470394b;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f470393a, r101.f470393a) == true) goto L12;
            return false;
        L12:
            if (this.f470394b == r101.f470394b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f470393a.hashCode() * 31) + this.f470394b.hashCode();
        }

        public final String toString() {
            return "ViewSlot(factory=" + this.f470393a + ", nestedScrollMode=" + this.f470394b + ')';
        }

        @Override // dwb.a
        public final MmRecordingNestedScrollMode a() {
            return this.f470394b;
        }

        public b(Function2 r100) {
            MmRecordingNestedScrollMode r101 = MmRecordingNestedScrollMode.Disabled;
            Intrinsics.checkNotNullParameter(r100, "factory");
            Intrinsics.checkNotNullParameter(r101, "nestedScrollMode");
            super(r101);
            this.f470393a = r100;
            this.f470394b = r101;
        }
    }

    public abstract MmRecordingNestedScrollMode a();

    public a(MmRecordingNestedScrollMode r100) {
    }
}
