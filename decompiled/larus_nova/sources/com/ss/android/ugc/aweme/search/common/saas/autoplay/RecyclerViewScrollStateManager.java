package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
public class RecyclerViewScrollStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerViewAbstract f452009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<ScrollStateObserver> f452010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f452011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IHittingArea f452012d;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewScrollStateManager$1, reason: invalid class name */
    class AnonymousClass1 extends OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewScrollStateManager f452013a;

        public AnonymousClass1(RecyclerViewScrollStateManager r100) {
            this.f452013a = r100;
        }
    }

    public final void a() {
        if (CollectionUtils.isEmpty(this.f452010b) == false) goto L5;
        return;
    L5:
        Iterator<ScrollStateObserver> r100 = this.f452010b.iterator();
    L7:
        if (r100.hasNext() == false) goto L12;
        ScrollStateObserver r101 = r100.next();
        int r102 = r101.f452017b;
        int r103 = r101.f452016a;
        if (r102 == r103) goto L11;
        r101.f452017b = r103;
    L11:
        r101.f452016a = 0;
        goto L7
    }

    public final void b() {
        if (this.f452011c != 2) goto L6;
        return;
    L6:
        if (CollectionUtils.isEmpty(this.f452010b) == false) goto L8;
        return;
    L8:
        Set<ScrollStateObserver> r100 = this.f452012d.a(this.f452010b);
        if (r100 != null) goto L11;
        return;
    L11:
        Iterator<ScrollStateObserver> r101 = r100.iterator();
    L13:
        if (r101.hasNext() == false) goto L15;
        r101.next().d();
        goto L13
    }

    public RecyclerViewScrollStateManager(RecyclerView r100) {
        RecyclerViewWrapper r101 = new RecyclerViewWrapper(r100);
        this.f452011c = 0;
        this.f452012d = null;
        this.f452009a = r101;
        r101.a(new AnonymousClass1(this));
        this.f452010b = new LinkedHashSet();
    }
}
