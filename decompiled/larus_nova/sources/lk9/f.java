package lk9;

import com.larus.media.MediaLevel;
import com.larus.media.MediaState;
import com.larus.media.MixPriority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f509627c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lk9.a f509628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f509629b;

    public static final class a {
        public static f a(com.larus.media.model.a r110) {
            Intrinsics.checkNotNullParameter(r110, "applicant");
            f r100 = r110.f359126n;
            if (r100 == null) goto L5;
            return r100;
        L5:
            int r101 = lk9.a.f509608i;
            Intrinsics.checkNotNullParameter(r110, "applicant");
            String r102 = r110.f359114b;
            int r103 = r110.f359117e;
            MediaLevel.a r104 = MediaLevel.Companion;
            int r105 = r110.f359122j;
            r104.getClass();
            MediaLevel[] r106 = MediaLevel.values();
            int r107 = r106.length;
            int r108 = 0;
        L6:
            MixPriority r109 = null;
            if (r108 >= r107) goto L15;
            MediaLevel r111 = r106[r108];
            if (r111.getValue() != r105) goto L11;
            boolean r112 = true;
        L12:
            if (r112 == true) goto L16;
            r108 = r108 + 1;
        L16:
            if (r111 != null) goto L18;
            MediaLevel r113 = MediaLevel.PLAY_DEFAULT;
        L19:
            MixPriority.a r114 = MixPriority.Companion;
            int r115 = r110.f359119g;
            r114.getClass();
            MixPriority[] r116 = MixPriority.values();
            int r117 = r116.length;
            int r118 = 0;
        L20:
            if (r118 >= r117) goto L28;
            MixPriority r119 = r116[r118];
            if (r119.getValue() != r115) goto L24;
            boolean r120 = true;
        L25:
            if (r120 == true) goto L26;
            r118 = r118 + 1;
            goto L20
        L26:
            r109 = r119;
            goto L28
        L24:
            r120 = false;
        L28:
            if (r109 != null) goto L30;
            MixPriority r121 = MixPriority.DEFAULT;
        L31:
            f r122 = new f(new lk9.a(r102, r103, r113, r121, r110.f359116d, r110.f359121i, r110.f359120h, r110.f359115c), new e(r110.f359124l));
            r122.a(r110.f359125m);
            r110.f359126n = r122;
            return r122;
        L30:
            r121 = r109;
            goto L31
        L18:
            r113 = r111;
            goto L19
        L11:
            r112 = false;
            goto L12
        L15:
            r111 = null;
            goto L16
        }
    }

    static {
    }

    @Override // lk9.g
    public final String getScene() {
        return this.f509628a.f509609a;
    }

    public final String toString() {
        return "[AudioSession: scene(" + this.f509628a.f509609a + "), state(" + this.f509629b.f509626b + "), mediaType(" + this.f509628a.f509610b + "), level(" + this.f509628a.f509611c + "), mixPriority(" + this.f509628a.f509612d + "), hashcode(" + hashCode() + ")]";
    }

    public final void a(MediaState r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e r101 = this.f509629b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "newState");
        r101.f509626b = r100;
    }

    public f(lk9.a r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "audioController");
        this.f509628a = r100;
        this.f509629b = r101;
    }
}
