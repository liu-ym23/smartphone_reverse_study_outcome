package org.commonmark.internal;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;

/* JADX INFO: loaded from: classes42.dex */
public class o extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListBlock f525743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f525744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f525745c;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r110, h.a r111) {
            wvc.d r100 = r111.f525705a;
            h r101 = (h) r110;
            int r102 = r101.f525696g;
            if (r102 < 4) goto L5;
            return null;
        L5:
            int r103 = r101.f525694e;
            int r104 = r101.f525692c + r102;
            if (r111.a() == null) goto L8;
            boolean r105 = true;
        L9:
            CharSequence r106 = r101.f525690a;
            char r112 = r106.charAt(r103);
            if (r112 != '*') goto L12;
        L37:
            int r107 = r103 + 1;
            if (r107 >= r106.length()) goto L43;
            char r113 = r106.charAt(r107);
            if (r113 == '\t') goto L43;
            if (r113 == ' ') goto L43;
            boolean r114 = false;
        L44:
            if (r114 == false) goto L46;
            BulletList r115 = new BulletList();
            r115.f525759i = r112;
            c r116 = new c(r115, r107);
        L47:
            if (r116 == null) goto L66;
            ListBlock r108 = r116.f525748a;
            int r117 = r116.f525749b;
            int r109 = r104 + (r117 - r103);
            int r118 = r106.length();
            int r119 = r109;
        L50:
            if (r117 >= r118) goto L58;
            char r120 = r106.charAt(r117);
            if (r120 != '\t') goto L54;
            r119 = r119 + (4 - (r119 % 4));
        L56:
            r117 = r117 + 1;
            goto L50
        L54:
            if (r120 != ' ') goto L57;
            r119 = r119 + 1;
            goto L56
        L57:
            boolean r121 = true;
        L59:
            if (r105 == true) goto L61;
        L67:
            if (r121 == true) goto L69;
        L70:
            r119 = r109 + 1;
        L71:
            b r122 = new b(r108, r119);
        L72:
            if (r122 != null) goto L74;
            return null;
        L74:
            int r123 = r122.f525747b;
            p r124 = new p(r123 - r101.f525692c);
            if ((r100 instanceof o) == false) goto L99;
            ListBlock r125 = (ListBlock) r100.a();
            ListBlock r126 = r122.f525746a;
            if ((r125 instanceof BulletList) == false) goto L86;
            if ((r126 instanceof BulletList) == false) goto L86;
            Character r127 = Character.valueOf(((BulletList) r125).f525759i);
            Character r128 = Character.valueOf(((BulletList) r126).f525759i);
            if (r127 != null) goto L84;
            if (r128 != null) goto L94;
        L83:
            boolean r129 = true;
        L95:
            if (r129 == false) goto L99;
            d r130 = new d(new wvc.d[]{r124});
            r130.f525670c = r123;
            return r130;
        L94:
            r129 = false;
            goto L95
        L84:
            r129 = r127.equals(r128);
        L86:
            if ((r125 instanceof OrderedList) == false) goto L94;
            if ((r126 instanceof OrderedList) == false) goto L94;
            Character r131 = Character.valueOf(((OrderedList) r125).f525781k);
            Character r132 = Character.valueOf(((OrderedList) r126).f525781k);
            if (r131 != null) goto L93;
            if (r132 != null) goto L94;
        L93:
            r129 = r131.equals(r132);
        L99:
            ListBlock r133 = r122.f525746a;
            o r134 = new o(r133);
            r133.f525778h = true;
            d r135 = new d(new wvc.d[]{r134, r124});
            r135.f525670c = r123;
            return r135;
        L69:
            if ((r119 - r109) <= 4) goto L71;
        L61:
            if ((r108 instanceof OrderedList) == true) goto L63;
        L65:
            if (r121 == true) goto L67;
        L63:
            if (((OrderedList) r108).f525779i == 1) goto L65;
        L58:
            r121 = false;
        L66:
            r122 = null;
        L46:
            r116 = null;
        L43:
            r114 = true;
            goto L44
        L12:
            if (r112 == '+') goto L37;
            if (r112 == '-') goto L37;
            int r136 = r106.length();
            int r137 = r103;
            int r138 = 0;
        L16:
            if (r137 >= r136) goto L46;
            char r139 = r106.charAt(r137);
            if (r139 == ')') goto L27;
            if (r139 == '.') goto L27;
            switch(r139) {
                case 48: goto L23;
                case 49: goto L23;
                case 50: goto L23;
                case 51: goto L23;
                case 52: goto L23;
                case 53: goto L23;
                case 54: goto L23;
                case 55: goto L23;
                case 56: goto L23;
                case 57: goto L23;
                default: goto L46;
            };
        L23:
            r138 = r138 + 1;
            if (r138 > 9) goto L46;
            r137 = r137 + 1;
        L27:
            if (r138 < 1) goto L46;
            int r140 = r137 + 1;
            if (r140 >= r106.length()) goto L34;
            char r141 = r106.charAt(r140);
            if (r141 == '\t') goto L34;
            if (r141 == ' ') goto L34;
            boolean r142 = false;
        L35:
            if (r142 == false) goto L46;
            String r143 = r106.subSequence(r103, r137).toString();
            OrderedList r144 = new OrderedList();
            r144.f525779i = CastIntegerProtector.parseInt(r143);
            r144.f525780j = CastIntegerProtector.parseInt(r143);
            r144.f525781k = r139;
            r116 = new c(r144, r140);
        L34:
            r142 = true;
            goto L35
        L8:
            r105 = false;
            goto L9
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBlock f525746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f525747b;

        public b(ListBlock r100, int r101) {
            this.f525746a = r100;
            this.f525747b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBlock f525748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f525749b;

        public c(ListBlock r100, int r101) {
            this.f525748a = r100;
            this.f525749b = r101;
        }
    }

    @Override // wvc.a, wvc.d
    public final boolean isContainer() {
        return true;
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525743a;
    }

    public o(ListBlock r100) {
        this.f525743a = r100;
    }

    @Override // wvc.a, wvc.d
    public final boolean e(Block r100) {
        if ((r100 instanceof ListItem) == true) goto L5;
        return false;
    L5:
        if (this.f525744b == true) goto L7;
    L9:
        return true;
    L7:
        if (this.f525745c != 1) goto L9;
        this.f525743a.f525778h = false;
        this.f525744b = false;
        goto L9
    }

    @Override // wvc.d
    public wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        if (r101.f525697h == false) goto L6;
        this.f525744b = true;
        this.f525745c = 0;
    L9:
        return wvc.c.a(r101.f525691b);
    L6:
        if (this.f525744b == false) goto L9;
        this.f525745c++;
        goto L9
    }
}
