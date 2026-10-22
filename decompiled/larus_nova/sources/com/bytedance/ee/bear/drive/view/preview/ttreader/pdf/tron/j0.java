package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.Structure;
import com.bytedance.ee.plugin.common.ttpdfreader.Bookmark;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f225362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, b> f225363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, List<String>> f225364c;

    public static final class a {
    }

    public static final class b extends Bookmark {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f225366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f225367c;

        public b(String r100, int r101, String r102, long r103, List r104) {
            Intrinsics.checkNotNullParameter(r100, faceverify.w.BLOB_ELEM_IMAGE_HASHCODE);
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r104, "children");
            super(r104, r102, r103);
            this.f225365a = r100;
            this.f225366b = false;
            this.f225367c = r101;
        }
    }

    static {
    }

    public j0(List<? extends Bookmark> r110) {
        Intrinsics.checkNotNullParameter(r110, "outline");
        this.f225362a = HTTP.URL_DEFAULT;
        HashMap<String, b> r100 = new HashMap();
        this.f225363b = r100;
        this.f225364c = new HashMap();
        b r101 = new b(HTTP.URL_DEFAULT, 0, "", 0, r110);
        r100.put(r101.f225365a, r101);
        b(HTTP.URL_DEFAULT, r101, r101.f225367c);
    }

    public final void a(String r110, ArrayList<Structure.Paragraph> r111) {
        b r100 = this.f225363b.get(r110);
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r110, this.f225362a) == true) goto L9;
        r111.add(new Structure.Paragraph(r100.f225365a, r100.getTitle(), r100.f225367c, 0, true, !hu5.a.d(r100.getChildren()), r100.f225366b));
    L9:
        if (r100.f225366b == false) goto L11;
        return;
    L11:
        if (this.f225364c.get(r110) == null) goto L18;
        List<String> r112 = this.f225364c.get(r110);
        Intrinsics.checkNotNull(r112);
        Iterator<String> r113 = r112.iterator();
    L14:
        if (r113.hasNext() == false) goto L19;
        a(r113.next(), r111);
        goto L14
    L19:
        return;
    }

    public final void b(String r110, Bookmark r111, int r112) {
        if (hu5.a.d(r111.getChildren()) == false) goto L5;
        return;
    L5:
        Iterator<Bookmark> r113 = r111.getChildren().iterator();
    L7:
        if (r113.hasNext() == false) goto L15;
        Bookmark r100 = r113.next();
        int r101 = r112 + 1;
        String r102 = du5.d.a(r100.getTitle() + r100.getPageIdx() + r101);
        Intrinsics.checkNotNull(r102);
        this.f225363b.put(r102, new b(r102, r101, r100.getTitle(), r100.getPageIdx(), r100.getChildren()));
        List<String> r103 = this.f225364c.get(r110);
        if ((r103 instanceof ArrayList) == false) goto L11;
        ArrayList r104 = (ArrayList) r103;
    L12:
        if (r104 != null) goto L14;
        r104 = new ArrayList();
        this.f225364c.put(r110, r104);
    L14:
        r104.add(r102);
        Intrinsics.checkNotNull(r100);
        b(r102, r100, r101);
        goto L7
    L11:
        r104 = null;
        goto L12
    }
}
