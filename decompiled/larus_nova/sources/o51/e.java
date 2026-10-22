package o51;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o51.f f522037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IAnchorUpdateLayoutContent.AnchorLayoutRange f522039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAnchorUpdateLayoutContent.UpdateAnchorLayoutType f522040d;

    public static final class a extends e {
        public a(o51.f r100) {
            Intrinsics.checkNotNullParameter(r100, "index");
            super(r100, "common", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f522037a.f522058c != r100.f522037a.f522058c) goto L7;
            return true;
        }
    }

    public static final class b {
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f522041e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f522042f;

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof c) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(((c) r100).f522041e, this.f522041e) == false) goto L9;
            if (r100.f522039c != this.f522039c) goto L9;
            return true;
        }

        public c(String r100, String r101, IAnchorUpdateLayoutContent.AnchorLayoutRange r102, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r103) {
            Intrinsics.checkNotNullParameter(r100, "enlargeUID");
            Intrinsics.checkNotNullParameter(r101, "enlargeLinkerID");
            Intrinsics.checkNotNullParameter(r102, "layoutRange");
            Intrinsics.checkNotNullParameter(r103, "updateType");
            super(o51.f.b.f522060e, ButtonColorBean.StateFocus, r102, r103);
            this.f522041e = r100;
            this.f522042f = r101;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f522043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f522044f;

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof d) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(((d) r100).f522043e, this.f522043e) == false) goto L9;
            if (r100.f522039c != this.f522039c) goto L9;
            return true;
        }

        public d(String r100, String r101, IAnchorUpdateLayoutContent.AnchorLayoutRange r102, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r103) {
            Intrinsics.checkNotNullParameter(r100, "fullUID");
            Intrinsics.checkNotNullParameter(r101, "fullLinkerID");
            Intrinsics.checkNotNullParameter(r102, "layoutRange");
            Intrinsics.checkNotNullParameter(r103, "updateType");
            super(o51.f.c.f522061e, "full", r102, r103);
            this.f522043e = r100;
            this.f522044f = r101;
        }
    }

    /* JADX INFO: renamed from: o51.e$e, reason: collision with other inner class name */
    public static final class C7015e extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f522045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f522046f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f522047g;

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof C7015e) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f522045e != ((C7015e) r100).f522045e) goto L9;
            String r101 = this.f522046f;
            if (Intrinsics.areEqual(r101, r101) == false) goto L9;
            return true;
        }

        public C7015e(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fullUID");
            Intrinsics.checkNotNullParameter(r102, "fullLinkerID");
            if (r100 == false) goto L5;
            o51.f r103 = o51.f.d.f522062e;
        L6:
            if (r100 == false) goto L8;
            String r104 = "full_record";
        L9:
            super(r103, r104, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.f522045e = r100;
            this.f522046f = r101;
            this.f522047g = r102;
            return;
        L8:
            r104 = "full_record_normal";
            goto L9
        L5:
            r103 = o51.f.e.f522063e;
            goto L6
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f522048e = null;

        static {
            f522048e = new f();
        }

        public f() {
            super(o51.f.j.f522068e, "normal", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            return r100 instanceof f;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f522049e = null;

        static {
            f522049e = new g();
        }

        public g() {
            super(o51.f.k.f522069e, PbRequest.SwitchType.PK, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            return r100 instanceof g;
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f522050e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f522051f;

        public h(boolean r100) {
            if (r100 == false) goto L4;
            o51.f r101 = o51.f.m.f522071e;
        L5:
            if (r100 == false) goto L7;
            String r102 = "pkGameFull";
        L8:
            super(r101, r102, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.f522050e = r100;
            this.f522051f = 0;
            return;
        L7:
            r102 = "pkGame";
            goto L8
        L4:
            r101 = o51.f.l.f522070e;
            goto L5
        }

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof h) == false) goto L9;
            h r101 = (h) r100;
            if (r101.f522050e != this.f522050e) goto L9;
            long r102 = r101.f522051f;
            if (r102 != r102) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class i extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f522052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f522053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f522054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f522055h;

        @Override // o51.e
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "uiLayout");
            if ((r100 instanceof i) == false) goto L9;
            i r101 = (i) r100;
            if (r101.f522052e != this.f522052e) goto L9;
            if (r101.f522053f != this.f522053f) goto L9;
            return true;
        L9:
            return false;
        }

        public i(boolean r100, boolean r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "selfUID");
            Intrinsics.checkNotNullParameter(r103, "guestUID");
            super(o51.f.n.f522072e, "pkWithAudience", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.f522052e = r100;
            this.f522053f = r101;
            this.f522054g = r102;
            this.f522055h = r103;
        }
    }

    static {
    }

    public abstract boolean a(e r100);

    public e(o51.f r100, String r101, IAnchorUpdateLayoutContent.AnchorLayoutRange r102, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r103) {
        this.f522037a = r100;
        this.f522038b = r101;
        this.f522039c = r102;
        this.f522040d = r103;
    }
}
