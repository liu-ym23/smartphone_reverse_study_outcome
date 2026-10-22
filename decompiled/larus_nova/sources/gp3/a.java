package gp3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C6047a f481993c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481995b;

    /* JADX INFO: renamed from: gp3.a$a, reason: collision with other inner class name */
    public static final class C6047a {
        public C6047a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lgp3/a$b;", "", "", "removeTarget", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "removeIndex", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("remove_index")
        private final Integer removeIndex;

        @SerializedName("remove_target")
        private final String removeTarget;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.removeTarget, r101.removeTarget) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.removeIndex, r101.removeIndex) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.removeTarget;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.removeIndex;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
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
        f481993c = new C6047a();
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "removeTarget");
        this.f481994a = r100;
        this.f481995b = r101;
    }
}
