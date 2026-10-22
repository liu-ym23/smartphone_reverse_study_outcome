package ey;

import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdk.link.model.v4;
import d11.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f474753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474754b;

    public static final class a extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d11.b f474755c;

        public a(d11.b r100) {
            Intrinsics.checkNotNullParameter(r100, "applyParams");
            super(7, "ApplyRequestEvent");
            this.f474755c = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d11.c f474757d;

        public b(i6 r100, d11.c r101) {
            super(3, "CancelEvent");
            this.f474756c = r100;
            this.f474757d = r101;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474758c;

        public c(i6 r100) {
            Intrinsics.checkNotNullParameter(r100, "closeMessage");
            super(12, "CloseEvent");
            this.f474758c = r100;
        }
    }

    public static final class d {
    }

    /* JADX INFO: renamed from: ey.e$e, reason: collision with other inner class name */
    public static final class C5831e extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474759c;

        public C5831e(i6 r100) {
            Intrinsics.checkNotNullParameter(r100, "inviteMessage");
            super(2, "InviteMessageEvent");
            this.f474759c = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d11.d f474760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final m0 f474761d;

        public f(d11.d r100, v4 r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "inviteResult");
            super(1, "InviteRequestEvent");
            this.f474760c = r100;
            this.f474761d = r101;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.livesdk.link.model.bridge.f f474762c;

        public g(fy.f r100, com.bytedance.android.livesdk.link.model.bridge.f r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "JoinChannelResult");
            super(14, "JoinChannelResultEvent");
            this.f474762c = r101;
        }
    }

    public static final class h extends e {
        public h() {
            this(0);
        }

        public h(int r100) {
            super(13, "LeaveEvent");
        }
    }

    public static final class i extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474763c;

        public i(i6 r100) {
            Intrinsics.checkNotNullParameter(r100, "permitMessage");
            super(9, "PermitMessageEvent");
            this.f474763c = r100;
        }
    }

    public static final class j extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d11.f f474764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.android.livesdk.link.model.bridge.m f474765d;

        public j(d11.f r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "permitParams");
            super(8, "PermitResultEvent");
            this.f474764c = r100;
            this.f474765d = r101;
        }
    }

    public static final class k extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474766c;

        public k(i6 r100) {
            Intrinsics.checkNotNullParameter(r100, "replyMessage");
            super(6, "ReplyMessageEvent");
            this.f474766c = r100;
        }
    }

    public static final class l extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d11.g f474767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d1 f474768d;

        public l(d11.g r100, q5 r101) {
            Intrinsics.checkNotNullParameter(r100, "replyParams");
            super(5, "ReplyResultEvent");
            this.f474767c = r100;
            this.f474768d = r101;
        }
    }

    public static final class m extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1 f474769c;

        public m(i6 r100) {
            super(11, "SwitchSceneEvent");
            this.f474769c = r100;
        }
    }

    public static final class n extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r f474770c;

        public n(r r100) {
            Intrinsics.checkNotNullParameter(r100, "timeOutParams");
            super(10, "TimeOutEvent");
            this.f474770c = r100;
        }
    }

    static {
    }

    public final String toString() {
        return this.f474754b + "(eventType=" + this.f474753a + ", name='" + this.f474754b + "')";
    }

    public e(int r100, String r101) {
        this.f474753a = r100;
        this.f474754b = r101;
    }
}
