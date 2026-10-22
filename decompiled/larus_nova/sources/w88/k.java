package w88;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class k {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f558686a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f558686a, ((a) r100).f558686a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f558686a.hashCode();
        }

        public final String toString() {
            return "ForceReplace(item=" + this.f558686a + ')';
        }

        public a(l r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f558686a = r100;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f558687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f558688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f558689c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f558687a == r101.f558687a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558688b, r101.f558688b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f558689c, r101.f558689c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f558687a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f558688b.hashCode()) * 31) + this.f558689c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Sentence(isTranslation=" + this.f558687a + ", id=" + this.f558688b + ", content=" + this.f558689c + ')';
        }

        public b(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "id");
            Intrinsics.checkNotNullParameter(r102, "content");
            this.f558687a = r100;
            this.f558688b = r101;
            this.f558689c = r102;
        }
    }

    public k() {
    }
}
