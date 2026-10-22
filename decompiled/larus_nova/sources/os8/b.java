package os8;

import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.utils.c4;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AiGenVideoContentData f526543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4 f526544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f526545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f526546d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f526543a, r101.f526543a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f526544b, r101.f526544b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f526545c, r101.f526545c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f526546d, r101.f526546d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f526543a.hashCode() * 31) + this.f526544b.hashCode()) * 31) + this.f526545c.hashCode()) * 31) + this.f526546d.hashCode();
        }

        public final String toString() {
            return "AiGeneration(aiGenVideoContentData=" + this.f526543a + ", eventParams=" + this.f526544b + ", videoEngineTag=" + this.f526545c + ", videoEngineSubTag=" + this.f526546d + ')';
        }

        public a(AiGenVideoContentData r100, c4 r101) {
            Intrinsics.checkNotNullParameter(r100, "aiGenVideoContentData");
            Intrinsics.checkNotNullParameter(r101, "eventParams");
            Intrinsics.checkNotNullParameter("ugc_video", "videoEngineTag");
            Intrinsics.checkNotNullParameter("immersive_preview", "videoEngineSubTag");
            this.f526543a = r100;
            this.f526544b = r101;
            this.f526545c = "ugc_video";
            this.f526546d = "immersive_preview";
        }
    }

    /* JADX INFO: renamed from: os8.b$b, reason: collision with other inner class name */
    public static final class C7108b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7108b f526547a = null;

        static {
            f526547a = new C7108b();
        }

        public C7108b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f526548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4 f526549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f526550c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f526548a, r101.f526548a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f526549b, r101.f526549b) == true) goto L15;
            return false;
        L15:
            if (this.f526550c == r101.f526550c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f526548a.hashCode() * 31) + this.f526549b.hashCode()) * 31;
            if (this.f526550c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "UserUpload(videoPlayData=" + this.f526548a + ", eventParams=" + this.f526549b + ", disableShare=" + this.f526550c + ')';
        }

        public c(g r100, c4 r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "videoPlayData");
            Intrinsics.checkNotNullParameter(r101, "eventParams");
            this.f526548a = r100;
            this.f526549b = r101;
            this.f526550c = r102;
        }
    }

    public b() {
    }
}
