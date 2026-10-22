package h52;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tb2.d f483871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f483872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f483873c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f483871a, r101.f483871a) == true) goto L8;
            return false;
        L8:
            if (this.f483872b == r101.f483872b) goto L10;
            return false;
        L10:
            if (this.f483873c == r101.f483873c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            tb2.d r100 = this.f483871a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f483872b;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r102 + r105) * 31;
            boolean r107 = this.f483873c;
            if (r107 == true) goto L14;
            r104 = r107;
        L14:
            return r106 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "PSMessageModelTextInfo(renderText=" + this.f483871a + ", hasEmoji=" + this.f483872b + ", hasAnim=" + this.f483873c + ")";
        }

        public a(tb2.d r100) {
            Intrinsics.checkNotNullParameter(r100, "renderText");
            this.f483871a = r100;
            this.f483872b = false;
            this.f483873c = false;
        }
    }

    MessageBinderType a();

    e b();

    void c(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d r100);

    long d();

    long getMessageId();

    a getTextInfo();

    IBaseUser getUser();
}
