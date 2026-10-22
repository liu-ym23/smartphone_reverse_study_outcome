package com.bytedance.locallife.pdp.rv;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f261707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f261708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f261709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Set<Integer>> f261710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f261711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f261712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f261713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f261714h;

    public interface a {
        void a(String r100, JSONObject r101, int r102);
    }

    public final void a() {
        if (this.f261712f == true) goto L5;
        return;
    L5:
        int r100 = this.f261707a.getChildCount();
        if (r100 == 0) goto L41;
        int r101 = 0;
    L8:
        if (r101 >= r100) goto L60;
        View r102 = this.f261707a.getChildAt(r101);
        if (r102 == null) goto L40;
        if (this.f261707a.getGlobalVisibleRect(this.f261714h) == false) goto L14;
        if (r102.getGlobalVisibleRect(this.f261713g) == false) goto L40;
        if (this.f261713g.top <= 0) goto L40;
        b r103 = this.f261708b;
        if (r103 == null) goto L40;
        List<c> r104 = r103.f261703a;
        if (r104 == null) goto L40;
        Iterator<T> r105 = r104.iterator();
    L27:
        if (r105.hasNext() == false) goto L40;
        c r106 = (c) r105.next();
        if ((((double) this.f261713g.top) + (((double) r102.getMeasuredHeight()) * r106.f261705a)) >= this.f261714h.bottom) goto L27;
        JSONObject r107 = new JSONObject();
        r107.put("width", r102.getMeasuredWidth());
        r107.put("height", r102.getMeasuredHeight());
        r107.put("exposure_height", this.f261713g.height());
        r107.put("rate", r106.f261705a);
        r107.put("notice_name", r106.f261706b);
        String r108 = r106.f261706b;
        int r109 = this.f261707a.getChildAdapterPosition(r102);
        Set<Integer> r110 = (Set) ((LinkedHashMap) this.f261710d).get(r108);
        if (r110 != null) goto L33;
        r110 = new LinkedHashSet();
        this.f261710d.put(r108, r110);
    L33:
        if (r109 < 0) goto L27;
        if (r110.contains(Integer.valueOf(r109)) == true) goto L27;
        r107.put("index", r109);
        r110.add(Integer.valueOf(r109));
        a r111 = this.f261709c;
        if (r111 == null) goto L27;
        r111.a(r108, r107, r109);
        goto L27
    L14:
        return;
    L40:
        r101 = r101 + 1;
        goto L8
    L60:
        return;
    }

    public d(RecyclerView r100, b r101, NestedParentRecyclerView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "mRecyclerView");
        this.f261707a = r100;
        this.f261708b = r101;
        this.f261709c = r102;
        this.f261710d = new LinkedHashMap();
        this.f261712f = true;
        this.f261713g = new Rect();
        this.f261714h = new Rect();
        if (r101 == null) goto L10;
        List<c> r103 = r101.f261703a;
        if (r103 == null) goto L10;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        c r105 = (c) r104.next();
        this.f261710d.put(r105.f261706b, new LinkedHashSet());
    L10:
        this.f261707a.addOnScrollListener(new RVItemExposureListener$2(this));
    }
}
