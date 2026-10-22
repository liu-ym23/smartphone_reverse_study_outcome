package o51;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revlink.link.core.UILayoutIOSIndex;
import com.bytedance.android.live.revlink.link.core.UILayoutLayoutConfigIndex;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;

/* JADX INFO: loaded from: classes47.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f522057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f522058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f522059d;

    public static final class a extends f {
        public a(int r100) {
            super("common", UILayoutServerIndex.Normal.ordinal(), r100, r100);
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f522060e = null;

        static {
            f522060e = new b();
        }

        public b() {
            super(ButtonColorBean.StateFocus, UILayoutServerIndex.Focus.ordinal(), UILayoutLayoutConfigIndex.Focus.getLayoutKey(), UILayoutIOSIndex.MultiFocus.ordinal());
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f522061e = null;

        static {
            f522061e = new c();
        }

        public c() {
            super("full", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.Full.getLayoutKey(), UILayoutIOSIndex.MultiFullIncludeScreenV.ordinal());
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f522062e = null;

        static {
            f522062e = new d();
        }

        public d() {
            super("full_record", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.FullRecord.getLayoutKey(), UILayoutIOSIndex.MultiFullScreenH.ordinal());
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f522063e = null;

        static {
            f522063e = new e();
        }

        public e() {
            super("full_record_norma", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.FullRecordNormal.getLayoutKey(), UILayoutIOSIndex.MultiFullIncludeScreenV.ordinal());
        }
    }

    /* JADX INFO: renamed from: o51.f$f, reason: collision with other inner class name */
    public static final class C7016f extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C7016f f522064e = null;

        static {
            f522064e = new C7016f();
        }

        public C7016f() {
            super("link_game_horizontal", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.LinkGameHorizontal.getLayoutKey(), UILayoutIOSIndex.LinkGameHorizontal.ordinal());
        }
    }

    public static final class g extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f522065e = null;

        static {
            f522065e = new g();
        }

        public g() {
            super("link_game_landscape", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.LinkGameLandscape.ordinal(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class h extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f522066e = null;

        static {
            f522066e = new h();
        }

        public h() {
            super("media_focus", UILayoutServerIndex.Focus.ordinal(), UILayoutLayoutConfigIndex.Focus.getLayoutKey(), UILayoutIOSIndex.MultiFocus.ordinal());
        }
    }

    public static final class i extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final i f522067e = null;

        static {
            f522067e = new i();
        }

        public i() {
            super("media_normal", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.Normal.getLayoutKey(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class j extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final j f522068e = null;

        static {
            f522068e = new j();
        }

        public j() {
            super("normal", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.Normal.getLayoutKey(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class k extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final k f522069e = null;

        static {
            f522069e = new k();
        }

        public k() {
            super(PbRequest.SwitchType.PK, UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PK.getLayoutKey(), UILayoutIOSIndex.DoublePK.ordinal());
        }
    }

    public static final class l extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final l f522070e = null;

        static {
            f522070e = new l();
        }

        public l() {
            super("pk_game", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKGame.getLayoutKey(), UILayoutIOSIndex.PKGame.ordinal());
        }
    }

    public static final class m extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final m f522071e = null;

        static {
            f522071e = new m();
        }

        public m() {
            super("pk_game_full", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKGameFull.getLayoutKey(), UILayoutIOSIndex.PKGame.ordinal());
        }
    }

    public static final class n extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final n f522072e = null;

        static {
            f522072e = new n();
        }

        public n() {
            super("pk_with_audience", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKWithAudience.getLayoutKey(), UILayoutIOSIndex.PKWithGuest.ordinal());
        }
    }

    public final boolean a() {
        if ((this instanceof c) == false) goto L5;
    L10:
        return true;
    L5:
        if ((this instanceof d) == true) goto L10;
        if ((this instanceof e) == true) goto L10;
        return false;
    }

    public f(String r100, int r101, int r102, int r103) {
        this.f522056a = r100;
        this.f522057b = r101;
        this.f522058c = r102;
        this.f522059d = r103;
    }
}
