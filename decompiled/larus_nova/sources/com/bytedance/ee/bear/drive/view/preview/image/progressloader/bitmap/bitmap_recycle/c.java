package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class c<K extends f, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V> f224935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, a<K, V>> f224936b;

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f224937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<V> f224938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a<K, V> f224939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a<K, V> f224940d;

        public a() {
            this(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(g.b r100) {
            this.f224940d = this;
            this.f224939c = this;
            this.f224937a = r100;
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("GroupedLinkedMap( ");
        a r101 = this.f224935a.f224939c;
        boolean r102 = false;
    L4:
        if (r101.equals(this.f224935a) == true) goto L10;
        r100.append('{');
        r100.append(r101.f224937a);
        r100.append(':');
        List<V> r103 = r101.f224938b;
        if (r103 == null) goto L8;
        int r104 = ((ArrayList) r103).size();
    L9:
        r100.append(r104);
        r100.append("}, ");
        r101 = r101.f224939c;
        r102 = true;
        goto L4
    L8:
        r104 = 0;
        goto L9
    L10:
        if (r102 == false) goto L12;
        r100.delete(r100.length() - 2, r100.length());
    L12:
        r100.append(" )");
        return r100.toString();
    }

    public c() {
        this.f224935a = new a();
        this.f224936b = new HashMap();
    }
}
