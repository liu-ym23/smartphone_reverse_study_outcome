package hma;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C6169a f486001a;

    /* JADX INFO: renamed from: hma.a$a, reason: collision with other inner class name */
    public static final class C6169a implements d<a, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f486002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f486003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Consumer<b> f486004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<String> f486005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList<String> f486006e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f486007f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f486008g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final b f486009h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final b f486010i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final b f486011j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public gma.a f486012k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final C6170a f486013l;

        /* JADX INFO: renamed from: hma.a$a$a, reason: collision with other inner class name */
        public final class C6170a implements gma.a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C6169a f486014a;

            public C6170a(C6169a r100) {
                Intrinsics.checkNotNullParameter(r100, "this$0");
                this.f486014a = r100;
            }

            @Override // gma.a.c
            public final void a(int r100, int r101) {
                if (r100 != 0) goto L4;
                if (r101 < 0) goto L14;
                this.f486014a.f486009h.f486015a = r101;
            L14:
                C6169a r102 = this.f486014a;
                Consumer<b> r103 = r102.f486004c;
                if (r103 == null) goto L18;
                r103.accept(r102.f486009h);
            L18:
                C6169a r104 = this.f486014a;
                Consumer<b> r105 = r104.f486004c;
                if (r105 == null) goto L23;
                r105.accept(r104.f486009h);
                return;
            L23:
                return;
            L4:
                if (r100 != 1) goto L18;
                if (r101 < 0) goto L8;
                this.f486014a.f486009h.f486016b = r101;
            L8:
                C6169a r106 = this.f486014a;
                Consumer<b> r107 = r106.f486004c;
                if (r107 == null) goto L18;
                r107.accept(r106.f486009h);
                goto L18
            }
        }

        public C6169a() {
            this.f486002a = true;
            this.f486003b = true;
            this.f486005d = new ArrayList();
            this.f486006e = new ArrayList();
            this.f486007f = "";
            this.f486008g = "";
            this.f486009h = new b(0);
            this.f486010i = new b(0);
            this.f486011j = new b(0);
            this.f486013l = new C6170a(this);
        }

        @Override // hma.d
        public final a a(Context r110, AttributeSet r111, int r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            OReelPickerThreeReels.a r100 = new OReelPickerThreeReels.a();
            gma.a.b r101 = null;
            if (this.f486002a == true) goto L5;
            gma.a.b r102 = null;
        L21:
            if (r102 == null) goto L25;
            r100.a(r102);
        L25:
            if (this.f486003b == false) goto L43;
            ArrayList<String> r103 = this.f486006e;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r103.iterator();
            int r106 = 0;
        L29:
            if (r105.hasNext() == false) goto L42;
            Object r107 = r105.next();
            int r108 = r106 + 1;
            if (r106 >= 0) goto L33;
            CollectionsKt.throwIndexOverflow();
        L33:
            String r113 = (String) r107;
            b r114 = this.f486011j;
            if (r106 >= r114.f486015a) goto L36;
        L38:
            boolean r109 = false;
        L39:
            if (r109 == false) goto L41;
            r104.add(r107);
        L41:
            r106 = r108;
            goto L29
        L36:
            if (r106 > r114.f486016b) goto L38;
            r109 = true;
            goto L39
        L42:
            r101 = new gma.a.b(1, r104, this.f486008g, 0.0f, this.f486009h.f486016b, this.f486013l, 120);
        L43:
            if (r101 == null) goto L46;
            r100.a(r101);
        L46:
            gma.a r115 = r100.b(r110, r111, r112);
            a r116 = new a();
            this.f486012k = r115;
            r116.f486001a = this;
            return r116;
        L5:
            ArrayList<String> r117 = this.f486005d;
            ArrayList r118 = new ArrayList();
            Iterator<T> r119 = r117.iterator();
            int r120 = 0;
        L7:
            if (r119.hasNext() == false) goto L20;
            Object r121 = r119.next();
            int r122 = r120 + 1;
            if (r120 >= 0) goto L11;
            CollectionsKt.throwIndexOverflow();
        L11:
            String r123 = (String) r121;
            b r124 = this.f486010i;
            if (r120 >= r124.f486015a) goto L14;
        L16:
            boolean r125 = false;
        L17:
            if (r125 == false) goto L19;
            r118.add(r121);
        L19:
            r120 = r122;
            goto L7
        L14:
            if (r120 > r124.f486016b) goto L16;
            r125 = true;
            goto L17
        L20:
            r102 = new gma.a.b(0, r118, this.f486007f, 0.0f, this.f486009h.f486015a, this.f486013l, 120);
            goto L21
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f486015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f486016b;

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
            if (this.f486015a == r101.f486015a) goto L12;
            return false;
        L12:
            if (this.f486016b == r101.f486016b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f486015a * 31) + this.f486016b;
        }

        public final String toString() {
            return "CustomData(down=" + this.f486015a + ", up=" + this.f486016b + ')';
        }

        public b(int r100) {
            this.f486015a = 0;
            this.f486016b = 0;
        }
    }

    public a() {
    }
}
