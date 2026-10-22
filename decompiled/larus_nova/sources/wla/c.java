package wla;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f560228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f560229b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f560230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f560231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f560232c;

        public a(Context r100, XmlPullParser r101) {
            this.f560231b = new ArrayList();
            this.f560232c = -1;
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.id, com.larus.nova.R.attr.constraints});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L11;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L8;
            this.f560230a = r102.getResourceId(r105, this.f560230a);
        L10:
            r104 = r104 + 1;
            goto L3
        L8:
            if (r105 != 1) goto L10;
            int r106 = r102.getResourceId(r105, this.f560232c);
            this.f560232c = r106;
            String r107 = r100.getResources().getResourceTypeName(r106);
            r100.getResources().getResourceName(r106);
            "layout".equals(r107);
            goto L10
        L11:
            r102.recycle();
        }

        public final int a(float r100, float r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.f560231b.size()) goto L9;
            if (((b) ListProtector.get(this.f560231b, r102)).a(r100, r101) == true) goto L7;
            r102 = r102 + 1;
            goto L4
        L7:
            return r102;
        L9:
            return -1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f560233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f560234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f560235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f560236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f560237e;

        public b(Context r100, XmlPullParser r101) {
            this.f560233a = Float.NaN;
            this.f560234b = Float.NaN;
            this.f560235c = Float.NaN;
            this.f560236d = Float.NaN;
            this.f560237e = -1;
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{com.larus.nova.R.attr.constraints, com.larus.nova.R.attr.region_heightLessThan, com.larus.nova.R.attr.region_heightMoreThan, com.larus.nova.R.attr.region_widthLessThan, com.larus.nova.R.attr.region_widthMoreThan});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L20;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L8;
            int r106 = r102.getResourceId(r105, this.f560237e);
            this.f560237e = r106;
            String r107 = r100.getResources().getResourceTypeName(r106);
            r100.getResources().getResourceName(r106);
            "layout".equals(r107);
        L19:
            r104 = r104 + 1;
            goto L3
        L8:
            if (r105 != 1) goto L11;
            this.f560236d = r102.getDimension(r105, this.f560236d);
            goto L19
        L11:
            if (r105 != 2) goto L14;
            this.f560234b = r102.getDimension(r105, this.f560234b);
            goto L19
        L14:
            if (r105 != 3) goto L17;
            this.f560235c = r102.getDimension(r105, this.f560235c);
            goto L19
        L17:
            if (r105 != 4) goto L19;
            this.f560233a = r102.getDimension(r105, this.f560233a);
            goto L19
        L20:
            r102.recycle();
        }

        public final boolean a(float r100, float r101) {
            if (Float.isNaN(this.f560233a) == true) goto L8;
            if (r100 >= this.f560233a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f560234b) == true) goto L13;
            if (r101 >= this.f560234b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f560235c) == true) goto L18;
            if (r100 <= this.f560235c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f560236d) == false) goto L20;
            return true;
        L20:
            if (r101 <= this.f560236d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public final int a(int r100) {
        float r101 = -1;
        if ((-1) != r100) goto L15;
        if (r100 != (-1)) goto L6;
        a r102 = this.f560229b.valueAt(0);
    L7:
        if (r102 == null) goto L24;
        int r103 = r102.a(r101, r101);
        if ((-1) == r103) goto L25;
        if (r103 != (-1)) goto L14;
        int r104 = r102.f560232c;
    L23:
        return r104;
    L14:
        r104 = ((b) ListProtector.get(r102.f560231b, r103)).f560237e;
        goto L23
    L25:
        return -1;
    L24:
        return -1;
    L6:
        r102 = this.f560229b.get(-1);
        goto L7
    L15:
        a r105 = this.f560229b.get(r100);
        if (r105 == null) goto L26;
        int r106 = r105.a(r101, r101);
        if (r106 != (-1)) goto L21;
        r104 = r105.f560232c;
        goto L23
    L21:
        r104 = ((b) ListProtector.get(r105.f560231b, r106)).f560237e;
        goto L23
    L26:
        return -1;
    }

    public c(Context r110, XmlPullParser r111) {
        this.f560228a = -1;
        this.f560229b = new SparseArray();
        TypedArray r100 = r110.obtainStyledAttributes(Xml.asAttributeSet(r111), new int[]{com.larus.nova.R.attr.defaultState});
        int r101 = r100.getIndexCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        int r103 = r100.getIndex(r102);
        if (r103 != 0) goto L7;
        this.f560228a = r100.getResourceId(r103, this.f560228a);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        r100.recycle();
        int r104 = r111.getEventType();     // Catch: Throwable -> L45
        a r105 = null;
    L11:
        if (r104 == 1) goto L60;
        if (r104 == 2) goto L19;
        if (r104 != 3) goto L42;
        if ("StateSet".equals(r111.getName()) == false) goto L42;
        return;
    L42:
        r104 = r111.next();     // Catch: Throwable -> L45 Throwable -> L45
        goto L11
    L19:
        String r106 = r111.getName();     // Catch: Throwable -> L45 Throwable -> L45
        switch(r106.hashCode()) {
            case 80204913: goto L32;
            case 1301459538: goto L29;
            case 1382829617: goto L26;
            case 1901439077: goto L23;
            default: goto L34;
        };     // Catch: Throwable -> L45 Throwable -> L45
    L34:
        byte r107 = -1;
    L35:
        if (r107 == 2) goto L41;
        if (r107 != 3) goto L42;
        b r108 = new b(r110, r111);     // Catch: Throwable -> L45 Throwable -> L45
        if (r105 == null) goto L42;
        r105.f560231b.add(r108);     // Catch: Throwable -> L45 Throwable -> L45
        goto L42
    L41:
        a r109 = new a(r110, r111);     // Catch: Throwable -> L45 Throwable -> L45
        this.f560229b.put(r109.f560230a, r109);     // Catch: Throwable -> L45 Throwable -> L45
        r105 = r109;
        goto L42
    L23:
        if (r106.equals("Variant") == false) goto L34;
        r107 = 3;
        goto L35
    L26:
        if (r106.equals("StateSet") == false) goto L34;
        r107 = 1;
        goto L35
    L29:
        if (r106.equals("LayoutDescription") == false) goto L34;
        r107 = 0;
        goto L35
    L32:
        if (r106.equals("State") == false) goto L34;
        r107 = 2;
        goto L35
    L60:
        return;
    }
}
