package u49;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.ReelPicker$HeightMode;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.ReelPickerThreeReels;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import t49.c;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements t49.a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C7832a f548716a;

    /* JADX INFO: renamed from: u49.a$a, reason: collision with other inner class name */
    public static final class C7832a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f548717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f548718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f548719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Consumer<b> f548720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ReelPicker$HeightMode f548721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f548722f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final b f548723g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final b f548724h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ReelPickerThreeReels f548725i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final C7833a f548726j;

        /* JADX INFO: renamed from: u49.a$a$a, reason: collision with other inner class name */
        public final class C7833a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C7832a f548727a;

            public C7833a(C7832a r100) {
                this.f548727a = r100;
            }

            @Override // t49.c
            public final void a(int r100, int r101) {
                if (r100 != 0) goto L5;
                b(this, this.f548727a.f548723g.f548728a + r101, 0, 0, 6);
            L12:
                C7832a r102 = this.f548727a;
                Consumer<b> r103 = r102.f548720d;
                if (r103 == null) goto L16;
                r103.accept(r102.f548722f);
                return;
            L16:
                return;
            L5:
                if (r100 != 1) goto L7;
                b(this, 0, this.f548727a.f548723g.f548729b + r101, 0, 5);
                goto L12
            L7:
                if (r100 != 2) goto L12;
                b(this, 0, 0, this.f548727a.f548723g.f548730c + r101, 3);
                goto L12
            }

            public static void b(C7833a r100, int r101, int r102, int r103, int r104) {
                if ((r104 & 1) == 0) goto L6;
                r101 = -1;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r102 = -1;
            L9:
                if ((r104 & 4) == 0) goto L11;
                r103 = -1;
            L11:
                if (r101 < 0) goto L13;
                r100.f548727a.f548722f.f548728a = r101;
            L13:
                if (r102 < 0) goto L15;
                r100.f548727a.f548722f.f548729b = r102;
            L15:
                if (r103 < 0) goto L17;
                r100.f548727a.f548722f.f548730c = r103;
            L17:
                C7832a r105 = r100.f548727a;
                Consumer<b> r106 = r105.f548720d;
                if (r106 == null) goto L21;
                r106.accept(r105.f548722f);
                return;
            }
        }

        public C7832a() {
            this.f548718b = true;
            this.f548719c = true;
            this.f548721e = ReelPicker$HeightMode.FIVE_LINES;
            this.f548722f = new b(0);
            this.f548723g = new b(0);
            this.f548724h = new b(0);
            this.f548726j = new C7833a(this);
        }

        public final a a(Context r100, AttributeSet r101, int r110) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ReelPickerThreeReels.a r102 = new ReelPickerThreeReels.a(this.f548721e.getHeightInDp());
            t49.b r103 = null;
            if (this.f548717a == true) goto L5;
            t49.b r104 = null;
        L6:
            if (r104 == null) goto L9;
            r102.a(r104);
        L9:
            if (this.f548718b == true) goto L11;
            t49.b r105 = null;
        L12:
            if (r105 == null) goto L15;
            r102.a(r105);
        L15:
            if (this.f548719c == false) goto L18;
            int r106 = u49.b.f548731a;
            r103 = new t49.b(2, u49.b.a(this.f548723g.f548730c, this.f548724h.f548730c), this.f548722f.f548730c - this.f548723g.f548730c, this.f548726j);
        L18:
            if (r103 == null) goto L20;
            r102.a(r103);
        L20:
            ReelPickerThreeReels r107 = r102.b(r100, r101, r110);
            a r108 = new a();
            this.f548725i = r107;
            r108.f548716a = this;
            return r108;
        L11:
            int r109 = u49.b.f548731a;
            r105 = new t49.b(1, u49.b.a(this.f548723g.f548729b, this.f548724h.f548729b), this.f548722f.f548729b - this.f548723g.f548729b, this.f548726j);
            goto L12
        L5:
            int r111 = u49.b.f548731a;
            r104 = new t49.b(0, u49.b.a(this.f548723g.f548728a, this.f548724h.f548728a), this.f548722f.f548728a - this.f548723g.f548728a, this.f548726j);
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f548728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f548729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f548730c;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f548728a == r101.f548728a) goto L12;
            return false;
        L12:
            if (this.f548729b == r101.f548729b) goto L15;
            return false;
        L15:
            if (this.f548730c == r101.f548730c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f548728a * 31) + this.f548729b) * 31) + this.f548730c;
        }

        public final String toString() {
            return "TimeLength(hour=" + this.f548728a + ", minute=" + this.f548729b + ", second=" + this.f548730c + ')';
        }

        public b(int r100) {
            this.f548728a = 0;
            this.f548729b = 0;
            this.f548730c = 0;
        }
    }

    public a() {
    }

    @Override // t49.a
    public final ReelPickerThreeReels asView() {
        C7832a r100 = this.f548716a;
        if (r100 == null) goto L7;
        ReelPickerThreeReels r101 = r100.f548725i;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return null;
    }
}
