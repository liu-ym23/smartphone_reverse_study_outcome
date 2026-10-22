package wla;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f560213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f560214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f560215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<C8130a> f560216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<com.obric.oui.constraintlayout.widget.a> f560217e;

    /* JADX INFO: renamed from: wla.a$a, reason: collision with other inner class name */
    public static class C8130a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f560218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f560219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f560220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.obric.oui.constraintlayout.widget.a f560221d;

        public C8130a(Context r100, XmlPullParser r101) {
            this.f560219b = new ArrayList();
            this.f560220c = -1;
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.id, com.larus.nova.R.attr.constraints});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L13;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L8;
            this.f560218a = r102.getResourceId(r105, this.f560218a);
        L12:
            r104 = r104 + 1;
            goto L3
        L8:
            if (r105 != 1) goto L12;
            int r106 = r102.getResourceId(r105, this.f560220c);
            this.f560220c = r106;
            String r107 = r100.getResources().getResourceTypeName(r106);
            r100.getResources().getResourceName(r106);
            if ("layout".equals(r107) == false) goto L12;
            com.obric.oui.constraintlayout.widget.a r108 = new com.obric.oui.constraintlayout.widget.a();
            this.f560221d = r108;
            r108.e(r100, r106);
            goto L12
        L13:
            r102.recycle();
        }

        public final int a(float r100, float r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.f560219b.size()) goto L9;
            if (((b) ListProtector.get(this.f560219b, r102)).a(r100, r101) == true) goto L7;
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
        public final float f560222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f560223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f560224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f560225d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f560226e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.obric.oui.constraintlayout.widget.a f560227f;

        public b(Context r100, XmlPullParser r101) {
            this.f560222a = Float.NaN;
            this.f560223b = Float.NaN;
            this.f560224c = Float.NaN;
            this.f560225d = Float.NaN;
            this.f560226e = -1;
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{com.larus.nova.R.attr.constraints, com.larus.nova.R.attr.region_heightLessThan, com.larus.nova.R.attr.region_heightMoreThan, com.larus.nova.R.attr.region_widthLessThan, com.larus.nova.R.attr.region_widthMoreThan});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L22;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L10;
            int r106 = r102.getResourceId(r105, this.f560226e);
            this.f560226e = r106;
            String r107 = r100.getResources().getResourceTypeName(r106);
            r100.getResources().getResourceName(r106);
            if ("layout".equals(r107) == false) goto L21;
            com.obric.oui.constraintlayout.widget.a r108 = new com.obric.oui.constraintlayout.widget.a();
            this.f560227f = r108;
            r108.e(r100, r106);
        L21:
            r104 = r104 + 1;
            goto L3
        L10:
            if (r105 != 1) goto L13;
            this.f560225d = r102.getDimension(r105, this.f560225d);
            goto L21
        L13:
            if (r105 != 2) goto L16;
            this.f560223b = r102.getDimension(r105, this.f560223b);
            goto L21
        L16:
            if (r105 != 3) goto L19;
            this.f560224c = r102.getDimension(r105, this.f560224c);
            goto L21
        L19:
            if (r105 != 4) goto L21;
            this.f560222a = r102.getDimension(r105, this.f560222a);
            goto L21
        L22:
            r102.recycle();
        }

        public final boolean a(float r100, float r101) {
            if (Float.isNaN(this.f560222a) == true) goto L8;
            if (r100 >= this.f560222a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f560223b) == true) goto L13;
            if (r101 >= this.f560223b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f560224c) == true) goto L18;
            if (r100 <= this.f560224c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f560225d) == false) goto L20;
            return true;
        L20:
            if (r101 <= this.f560225d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public final void a(Context r100, XmlPullParser r110) {
        com.obric.oui.constraintlayout.widget.a r101 = new com.obric.oui.constraintlayout.widget.a();
        int r102 = r110.getAttributeCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L26;
        String r104 = r110.getAttributeName(r103);
        String r105 = r110.getAttributeValue(r103);
        if (r104 == null) goto L19;
        if (r105 == null) goto L19;
        if ("id".equals(r104) == false) goto L19;
        if (r105.contains(HTTP.URL_DEFAULT) == false) goto L13;
        String r106 = r105.substring(r105.indexOf(47) + 1);
        int r107 = r100.getResources().getIdentifier(r106, "id", r100.getPackageName());
    L14:
        if (r107 == (-1)) goto L16;
    L18:
        r101.k(r100, r110);
        this.f560217e.put(r107, r101);
        return;
    L16:
        if (r105.length() <= 1) goto L18;
        r107 = CastIntegerProtector.parseInt(r105.substring(1));
        goto L18
    L13:
        r107 = -1;
    L19:
        r103 = r103 + 1;
        goto L3
    }

    public a(Context r100, ConstraintLayout r101, int r110) {
        this.f560214b = -1;
        this.f560215c = -1;
        this.f560216d = new SparseArray();
        this.f560217e = new SparseArray();
        this.f560213a = r101;
        XmlResourceParser r102 = r100.getResources().getXml(r110);
        int r111 = r102.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L40
        C8130a r103 = null;
    L4:
        byte r104 = 1;
        if (r111 == 1) goto L53;
        if (r111 != 2) goto L37;
        String r112 = r102.getName();     // Catch: IOException -> L39 XmlPullParserException -> L40
        switch(r112.hashCode()) {
            case -1349929691: goto L25;
            case 80204913: goto L22;
            case 1382829617: goto L19;
            case 1657696882: goto L16;
            case 1901439077: goto L13;
            default: goto L27;
        };     // Catch: IOException -> L39 XmlPullParserException -> L40
    L27:
        r104 = -1;
    L28:
        if (r104 == 2) goto L36;
        if (r104 == 3) goto L33;
        if (r104 != 4) goto L37;
        a(r100, r102);     // Catch: IOException -> L39 XmlPullParserException -> L40
        goto L37
    L33:
        b r113 = new b(r100, r102);     // Catch: IOException -> L39 XmlPullParserException -> L40
        if (r103 == null) goto L37;
        r103.f560219b.add(r113);     // Catch: IOException -> L39 XmlPullParserException -> L40
        goto L37
    L36:
        C8130a r114 = new C8130a(r100, r102);     // Catch: IOException -> L39 XmlPullParserException -> L40
        this.f560216d.put(r114.f560218a, r114);     // Catch: IOException -> L39 XmlPullParserException -> L40
        r103 = r114;
        goto L37
    L13:
        if (r112.equals("Variant") == false) goto L27;
        r104 = 3;
        goto L28
    L16:
        if (r112.equals("layoutDescription") == false) goto L27;
        r104 = 0;
        goto L28
    L19:
        if (r112.equals("StateSet") == false) goto L27;
    L22:
        if (r112.equals("State") == false) goto L27;
        r104 = 2;
        goto L28
    L25:
        if (r112.equals("ConstraintSet") == false) goto L27;
        r104 = 4;
    L37:
        r111 = r102.next();     // Catch: IOException -> L39 XmlPullParserException -> L40
    L53:
        return;
    L52:
        return;
    }
}
