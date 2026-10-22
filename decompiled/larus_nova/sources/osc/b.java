package osc;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.h;
import org.commonmark.internal.o;
import org.commonmark.internal.p;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.OrderedList;
import wvc.f;
import wvc.g;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f526603e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ListBlock f526604d;

    public static final class a {
        public static boolean a(CharSequence r100, int r101) {
            if (r101 >= r100.length()) goto L15;
            char r102 = r100.charAt(r101);
            if (r102 != ' ') goto L8;
        L9:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L16;
            return false;
        L16:
            return true;
        L8:
            if (r102 == '\t') goto L9;
            r103 = false;
            goto L11
        L15:
            return true;
        }
    }

    /* JADX INFO: renamed from: osc.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes5.dex */
    public static final class C7109b extends wvc.b {
        public C7109b() {
        }

        @Override // wvc.e
        public final f a(g r110, h.a r111) {
            Intrinsics.checkNotNullParameter(r110, "state");
            Intrinsics.checkNotNullParameter(r111, "matchedBlockParser");
            wvc.d r100 = r111.f525705a;
            h r101 = (h) r110;
            int r102 = r101.f525694e;
            int r103 = r101.f525692c + r101.f525696g;
            if (r111.a() == null) goto L5;
            boolean r104 = true;
        L6:
            int r105 = b.f526603e;
            CharSequence r106 = r101.f525690a;
            int r107 = r101.f525696g;
            char r108 = r106.charAt(r102);
            if (r108 != '-') goto L10;
        L11:
            boolean r112 = true;
        L13:
            if (r112 == false) goto L16;
        L17:
            boolean r113 = true;
        L20:
            if (r113 == false) goto L24;
            int r114 = r102 + 1;
            if (a.a(r106, r114) == false) goto L98;
            BulletList r115 = new BulletList();
            r115.f525759i = r108;
            osc.a.b(r115, r107);
            d r109 = new d(r115, r114);
        L99:
            if (r109 == null) goto L115;
            ListBlock r116 = r109.f526607a;
            int r117 = r109.f526608b;
            int r118 = r103 + (r117 - r102);
            int r119 = r106.length();
            int r120 = r118;
        L103:
            if (r117 >= r119) goto L112;
            char r121 = r106.charAt(r117);
            if (r121 != '\t') goto L108;
            r120 = r120 + (4 - (r120 % 4));
        L110:
            r117 = r117 + 1;
            goto L103
        L108:
            if (r121 != ' ') goto L111;
            r120 = r120 + 1;
            goto L110
        L111:
            boolean r122 = true;
        L113:
            if (r104 == false) goto L116;
            if (r122 == false) goto L115;
        L116:
            if (r122 == true) goto L118;
        L119:
            r120 = r118 + 1;
        L120:
            c r123 = new c(r116, r120);
        L121:
            if (r123 != null) goto L123;
            return null;
        L123:
            int r124 = r123.f526606b;
            p r125 = new p(r124 - r101.f525692c);
            if ((r100 instanceof b) == false) goto L147;
            int r126 = b.f526603e;
            Block r127 = r100.a();
            Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type org.commonmark.node.ListBlock");
            ListBlock r128 = (ListBlock) r127;
            ListBlock r129 = r123.f526605a;
            if ((r128 instanceof BulletList) == false) goto L135;
            if ((r129 instanceof BulletList) == false) goto L135;
            Character r130 = Character.valueOf(((BulletList) r128).f525759i);
            Character r131 = Character.valueOf(((BulletList) r129).f525759i);
            if (r130 != null) goto L133;
            if (r131 != null) goto L143;
        L132:
            boolean r132 = true;
        L144:
            if (r132 == false) goto L147;
            org.commonmark.internal.d r133 = new org.commonmark.internal.d(new wvc.d[]{r125});
            r133.f525670c = r124;
            return r133;
        L143:
            r132 = false;
            goto L144
        L133:
            r132 = Intrinsics.areEqual(r130, r131);
        L135:
            if ((r128 instanceof OrderedList) == false) goto L143;
            if ((r129 instanceof OrderedList) == false) goto L143;
            Character r134 = Character.valueOf(((OrderedList) r128).f525781k);
            Character r135 = Character.valueOf(((OrderedList) r129).f525781k);
            if (r134 != null) goto L142;
            if (r135 != null) goto L143;
        L142:
            r132 = Intrinsics.areEqual(r134, r135);
        L147:
            b r136 = new b(r123.f526605a);
            r123.f526605a.f525778h = true;
            org.commonmark.internal.d r137 = new org.commonmark.internal.d(new wvc.d[]{r136, r125});
            r137.f525670c = r124;
            return r137;
        L118:
            if ((r120 - r118) <= 4) goto L120;
        L112:
            r122 = false;
        L115:
            r123 = null;
        L98:
            r109 = null;
            goto L99
        L24:
            int r138 = r106.length();
            int r139 = r102;
            int r140 = 0;
        L25:
            if (r139 >= r138) goto L98;
            char r141 = r106.charAt(r139);
            if (r141 != '0') goto L30;
        L31:
            boolean r142 = true;
        L33:
            if (r142 == false) goto L36;
        L37:
            boolean r143 = true;
        L39:
            if (r143 == false) goto L42;
        L43:
            boolean r144 = true;
        L45:
            if (r144 == false) goto L48;
        L49:
            boolean r145 = true;
        L51:
            if (r145 == false) goto L54;
        L55:
            boolean r146 = true;
        L57:
            if (r146 == false) goto L60;
        L61:
            boolean r147 = true;
        L63:
            if (r147 == false) goto L66;
        L67:
            boolean r148 = true;
        L69:
            if (r148 == false) goto L72;
        L73:
            boolean r149 = true;
        L75:
            if (r149 == false) goto L78;
        L79:
            boolean r150 = true;
        L81:
            if (r150 == false) goto L87;
            r140 = r140 + 1;
            if (r140 > 9) goto L98;
            r139 = r139 + 1;
            goto L25
        L87:
            if (r141 != '.') goto L90;
        L91:
            boolean r151 = true;
        L93:
            if (r151 == false) goto L98;
            if (r140 < 1) goto L98;
            int r152 = r139 + 1;
            if (a.a(r106, r152) == false) goto L98;
            String r153 = r106.subSequence(r102, r139).toString();
            OrderedList r154 = new OrderedList();
            r154.f525779i = CastIntegerProtector.parseInt(r153);
            r154.f525781k = r141;
            osc.a.b(r154, r107);
            r109 = new d(r154, r152);
            goto L99
        L90:
            if (r141 == ')') goto L91;
            r151 = false;
            goto L93
        L78:
            if (r141 == '9') goto L79;
            r150 = false;
            goto L81
        L72:
            if (r141 == '8') goto L73;
            r149 = false;
            goto L75
        L66:
            if (r141 == '7') goto L67;
            r148 = false;
            goto L69
        L60:
            if (r141 == '6') goto L61;
            r147 = false;
            goto L63
        L54:
            if (r141 == '5') goto L55;
            r146 = false;
            goto L57
        L48:
            if (r141 == '4') goto L49;
            r145 = false;
            goto L51
        L42:
            if (r141 == '3') goto L43;
            r144 = false;
            goto L45
        L36:
            if (r141 == '2') goto L37;
            r143 = false;
            goto L39
        L30:
            if (r141 == '1') goto L31;
            r142 = false;
            goto L33
        L16:
            if (r108 == '*') goto L17;
            r113 = false;
            goto L20
        L10:
            if (r108 == '+') goto L11;
            r112 = false;
            goto L13
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBlock f526605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f526606b;

        public c(ListBlock r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "listBlock");
            this.f526605a = r100;
            this.f526606b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBlock f526607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f526608b;

        public d(ListBlock r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "listBlock");
            this.f526607a = r100;
            this.f526608b = r101;
        }
    }

    static {
    }

    public b(ListBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        super(r100);
        this.f526604d = r100;
    }

    @Override // org.commonmark.internal.o, wvc.d
    public final wvc.c f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = ((h) r100).f525696g;
        osc.a.a(this.f526604d);
        return super.f(r100);
    }
}
