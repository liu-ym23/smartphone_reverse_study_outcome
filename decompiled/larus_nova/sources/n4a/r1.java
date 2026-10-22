package n4a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dv f517636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dv f517637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u2 f517638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f517639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<dv> f517640e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f517641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f517642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public dv f517643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public dv f517644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public dv f517645e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<dv> f517646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<dv> f517647g;

        public a() {
            this.f517646f = new ArrayList();
            this.f517647g = new ArrayList();
        }

        public static boolean b(dv r100, dv r101) {
            if (r100 == null) goto L48;
            if (r101 == null) goto L48;
            if ((r100 instanceof dx) == false) goto L17;
            if ((r101 instanceof dx) == false) goto L17;
            dx r102 = (dx) r100;
            dx r103 = (dx) r101;
            if (r102.f380022j == r103.f380022j) goto L13;
        L15:
            return false;
        L13:
            if (r102.f380023k != r103.f380023k) goto L15;
            return true;
        L17:
            if ((r100 instanceof dw) == false) goto L29;
            if ((r101 instanceof dw) == false) goto L29;
            dw r104 = (dw) r100;
            dw r105 = (dw) r101;
            if (r104.f380019l == r105.f380019l) goto L23;
        L27:
            return false;
        L23:
            if (r104.f380018k != r105.f380018k) goto L27;
            if (r104.f380017j != r105.f380017j) goto L27;
            return true;
        L29:
            if ((r100 instanceof dy) == false) goto L39;
            if ((r101 instanceof dy) == false) goto L39;
            dy r106 = (dy) r100;
            dy r107 = (dy) r101;
            if (r106.f380028j == r107.f380028j) goto L35;
        L37:
            return false;
        L35:
            if (r106.f380029k != r107.f380029k) goto L37;
            return true;
        L39:
            if ((r100 instanceof dz) == true) goto L41;
        L47:
            return false;
        L41:
            if ((r101 instanceof dz) == false) goto L47;
            dz r108 = (dz) r100;
            dz r109 = (dz) r101;
            if (r108.f380033j != r109.f380033j) goto L47;
            if (r108.f380034k != r109.f380034k) goto L47;
            return true;
        L48:
            if (r100 != null) goto L50;
            boolean r110 = true;
        L51:
            if (r101 != null) goto L53;
            boolean r111 = true;
        L54:
            if (r110 != r111) goto L56;
            return true;
        L56:
            return false;
        L53:
            r111 = false;
            goto L54
        L50:
            r110 = false;
            goto L51
        }

        public final void a() {
            this.f517641a = 0;
            this.f517642b = "";
            this.f517643c = null;
            this.f517644d = null;
            this.f517645e = null;
            ((ArrayList) this.f517646f).clear();
            ((ArrayList) this.f517647g).clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + this.f517641a + ", operator='" + this.f517642b + "', mainCell=" + this.f517643c + ", mainOldInterCell=" + this.f517644d + ", mainNewInterCell=" + this.f517645e + ", cells=" + this.f517646f + ", historyMainCellList=" + this.f517647g + '}';
        }
    }

    public r1() {
        this.f517639d = new a();
        this.f517640e = new ArrayList(3);
    }

    public final void a(dv r110) {
        int r100 = ((ArrayList) this.f517640e).size();
        if (r100 == 0) goto L20;
        int r101 = -1;
        long r102 = Long.MAX_VALUE;
        int r103 = 0;
        int r104 = -1;
    L6:
        if (r103 >= r100) goto L16;
        dv r105 = (dv) ListProtector.get(this.f517640e, r103);
        if (r110.equals(r105) == true) goto L9;
        r102 = Math.min(r102, r105.f380012e);
        if (r102 != r105.f380012e) goto L15;
        r104 = r103;
    L15:
        r103 = r103 + 1;
        goto L6
    L9:
        int r106 = r110.f380010c;
        if (r106 == r105.f380010c) goto L17;
        r105.f380012e = r106;
        r105.f380010c = r106;
    L17:
        if (r101 >= 0) goto L19;
        return;
    L19:
        if (r100 < 3) goto L20;
        if (r110.f380012e <= r102) goto L32;
        if (r101 >= r100) goto L33;
        ListProtector.remove(this.f517640e, r101);
        ((ArrayList) this.f517640e).add(r110);
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r101 = r104;
    L20:
        ((ArrayList) this.f517640e).add(r110);
    }
}
