package com.larksuite.component.blockit.hashtag.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f283094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f283095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<SwipeLayout> f283096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py7.a f283097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Attributes$Mode f283098e;

    public class a implements SwipeLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f283099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f283100b;

        @Override // com.larksuite.component.blockit.hashtag.widget.SwipeLayout.f
        public final void a(SwipeLayout r100) {
            b r101 = this.f283100b;
            int r102 = this.f283099a;
            if (r101.f283098e != Attributes$Mode.Multiple) goto L6;
            Set<Integer> r103 = r101.f283095b;
            HashSet r104 = (HashSet) r103;
            boolean r105 = r104.contains(Integer.valueOf(r102));
        L9:
            if (r105 == false) goto L11;
            r100.i(false, false);
            return;
        L11:
            r100.b(false, false);
            return;
        L6:
            if (r101.f283094a != r102) goto L8;
            r105 = true;
            goto L9
        L8:
            r105 = false;
            goto L9
        }

        public a(b r100, int r101) {
            this.f283100b = r100;
            this.f283099a = r101;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.blockit.hashtag.widget.b$b, reason: collision with other inner class name */
    public class C3889b extends com.larksuite.component.blockit.hashtag.widget.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f283101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f283102b;

        @Override // com.larksuite.component.blockit.hashtag.widget.a, com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void onClose() {
            b r100 = this.f283102b;
            if (r100.f283098e != Attributes$Mode.Multiple) goto L5;
            Set<Integer> r101 = r100.f283095b;
            HashSet r102 = (HashSet) r101;
            r102.remove(Integer.valueOf(this.f283101a));
            return;
        L5:
            r100.f283094a = -1;
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void c(SwipeLayout r100) {
            b r101 = this.f283102b;
            if (r101.f283098e != Attributes$Mode.Multiple) goto L5;
            Set<Integer> r102 = r101.f283095b;
            HashSet r103 = (HashSet) r102;
            r103.add(Integer.valueOf(this.f283101a));
            return;
        L5:
            Iterator r104 = ((HashSet) r101.f283096c).iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            SwipeLayout r105 = (SwipeLayout) r104.next();
            if (r105 == r100) goto L7;
            r105.b(true, true);
            goto L7
        L11:
            b r106 = this.f283102b;
            r106.f283094a = this.f283101a;
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.a, com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void d(SwipeLayout r100) {
            b r101 = this.f283102b;
            if (r101.f283098e != Attributes$Mode.Single) goto L10;
            Iterator r102 = ((HashSet) r101.f283096c).iterator();
        L6:
            if (r102.hasNext() == false) goto L16;
            SwipeLayout r103 = (SwipeLayout) r102.next();
            if (r103 == r100) goto L6;
            r103.b(true, true);
            goto L6
        L16:
            return;
        }

        public C3889b(b r100, int r101) {
            this.f283102b = r100;
            this.f283101a = r101;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f283103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C3889b f283104b;

        public c(C3889b r100, a r101) {
            this.f283104b = r100;
            this.f283103a = r101;
        }
    }

    public b(py7.a r100) {
        this.f283094a = -1;
        this.f283095b = new HashSet();
        this.f283096c = new HashSet();
        this.f283098e = Attributes$Mode.Single;
        if (r100 == null) goto L7;
        this.f283097d = r100;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public final void b(boolean r100) {
        if (this.f283098e != Attributes$Mode.Multiple) goto L5;
        ((HashSet) this.f283095b).clear();
    L6:
        Iterator r101 = ((HashSet) this.f283096c).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((SwipeLayout) r101.next()).b(r100, true);
        goto L8
    L10:
        return;
    L5:
        this.f283094a = -1;
        goto L6
    }

    public final void a(View r100, int r101) {
        int r102 = this.f283097d.B0();
        SwipeLayout r103 = (SwipeLayout) r100.findViewById(r102);
        if (r103 == null) goto L13;
        if (r103.getTag(r102) != null) goto L10;
        a r104 = new a(this, r101);
        C3889b r105 = new C3889b(this, r101);
        ((ArrayList) r103.f283068j).add(r105);
        if (r103.f283080v != null) goto L9;
        r103.f283080v = new ArrayList();
    L9:
        ((ArrayList) r103.f283080v).add(r104);
        r103.setTag(r102, new c(r105, r104));
        ((HashSet) this.f283096c).add(r103);
        return;
    L10:
        c r106 = (c) r103.getTag(r102);
        r106.f283104b.f283101a = r101;
        r106.f283103a.f283099a = r101;
        return;
    L13:
        throw new IllegalStateException("can not find SwipeLayout in target view");
    }
}
