package gp3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final C0128a c = null;
    public final String a;
    public final int b;

    /* JADX INFO: renamed from: gp3.a$a, reason: collision with other inner class name */
    public static final class C0128a {
        public C0128a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lgp3/a$b;", "", "", "removeTarget", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "removeIndex", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("remove_index")
        private final Integer removeIndex;

        @SerializedName("remove_target")
        private final String removeTarget;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.removeTarget, r4.removeTarget) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.removeIndex, r4.removeIndex) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.removeTarget;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.removeIndex;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RemoveAbilityDTO(removeTarget=" + this.removeTarget + ", removeIndex=" + this.removeIndex + ")";
        }

        public final Integer a() {
            return this.removeIndex;
        }

        public final String b() {
            return this.removeTarget;
        }
    }

    static {
        c = new C0128a();
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "removeTarget");
        this.a = r2;
        this.b = r3;
    }
}
