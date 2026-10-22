package px0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530859a = 0;

    /* JADX INFO: renamed from: px0.a$a, reason: collision with other inner class name */
    public static final class C7250a {
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IEpisode f530860b;

        @Override // px0.a
        public final boolean c() {
            return true;
        }

        @Override // px0.a
        public final String a() {
            IBaseUser r100 = this.f530860b.getOwnerExt();
            if (r100 == null) goto L5;
            String r101 = r100.getIdString();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // px0.a
        public final long b() {
            return this.f530860b.getRoomIdExt();
        }

        public b(IEpisode r100) {
            Intrinsics.checkNotNullParameter(r100, "episode");
            this.f530860b = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IRoom f530861b;

        @Override // px0.a
        public final String a() {
            IBaseUser r100 = this.f530861b.getOwner();
            if (r100 == null) goto L5;
            String r101 = r100.getIdString();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // px0.a
        public final long b() {
            return this.f530861b.getRoomId();
        }

        @Override // px0.a
        public final boolean c() {
            return this.f530861b.isVsRoom();
        }

        public c(IRoom r100) {
            Intrinsics.checkNotNullParameter(r100, "room");
            this.f530861b = r100;
        }
    }

    static {
    }

    public a() {
    }

    public abstract String a();

    public abstract long b();

    public abstract boolean c();
}
