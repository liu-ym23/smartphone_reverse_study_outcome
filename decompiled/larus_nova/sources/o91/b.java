package o91;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    public static final class a extends n {
        public a() {
            super("anchor_text", "主播侧可动态更新文案展示");
        }
    }

    /* JADX INFO: renamed from: o91.b$b, reason: collision with other inner class name */
    public static final class C7023b extends n {
        public C7023b() {
            super("audience_image", "看播侧常驻icon类型展示");
        }
    }

    public static final class c extends n {
        public c() {
            super("audience_image_and_text", "看播侧常驻icon+文案类型展示");
        }
    }

    public static final class d extends n {
        public d() {
            super("audience_text", "看播侧常驻文案展示类型");
        }
    }

    public static final class e {
    }

    public static final class f extends n {
        public f() {
            super("digg", "点赞");
        }
    }

    public static final class g extends n {
        public g() {
            super("digg_temporary", "临时展示的点赞，会自动消失");
        }
    }

    public static final class h extends n {
        public h() {
            super("double_like", "双赞加成");
        }
    }

    public static final class i extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f522438b = null;

        static {
            f522438b = new i();
        }

        public i() {
            super("empty", "占位，不携带任何数据");
        }
    }

    public static final class j extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f522439b = null;

        static {
            f522439b = new j();
        }

        public j() {
            super(InstantPlayContext.NICKNAME, "昵称");
        }
    }

    public static final class k extends n {
        public k() {
            super("pv", "观看人次");
        }
    }

    public static final class l extends n {
        public l() {
            super("ticket", "音浪");
        }
    }

    public static final class m extends n {
        public m() {
            super("uv", "在线人数");
        }
    }

    public static class n extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f522440a;

        public final int hashCode() {
            return this.f522440a.hashCode();
        }

        public final String toString() {
            return "WithNameTab(name='" + this.f522440a + "')";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            Class<?> r101 = getClass();
            if (r100 == null) goto L8;
            Class<?> r102 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(r101, r102)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L18;
            if ((!Intrinsics.areEqual(this.f522440a, ((n) r100).f522440a)) == false) goto L16;
            return false;
        L16:
            return true;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo_p.flipper.business.TabType.WithNameTab");
        L8:
            r102 = null;
            goto L10
        }

        public n(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            this.f522440a = r100;
        }
    }

    static {
    }

    public b() {
    }
}
