package com.bytedance.creativex.mediaimport.view.internal.scroller;

import com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout;
import io.reactivex.subjects.PublishSubject;
import ti4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements TouchableFrameLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f204088a;

    @Override // com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout.a
    public final void onDragEnd() {
        b r100 = this.f204088a;
        PublishSubject<Long> r101 = r100.f204074g;
        b.a r102 = r100.f204071d;
        long r103 = r102.f204084d;
        long r104 = r102.f204083c;
        if (r103 != 0) goto L5;
        r104 = r104 + 400;
    L5:
        r101.onNext(Long.valueOf(r104));
        this.f204088a.f204073f.onNext(new f.a.C7729a(true));
        this.f204088a.f204070c.a();
    }

    @Override // com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout.a
    public final void onDragStart() {
        this.f204088a.f204074g.onNext(0L);
        this.f204088a.f204073f.onNext(new f.a.b(true));
    }

    public c(b r100) {
        this.f204088a = r100;
    }

    @Override // com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout.a
    public final void a(int r100, int r101) {
        this.f204088a.f204070c.b();
        this.f204088a.f204075h.onNext(0L);
        b r102 = this.f204088a;
        r102.f204075h.onNext(Long.valueOf(r102.f204071d.f204085e));
        b r103 = this.f204088a;
        int r104 = r103.f204068a.getHeight();
        int r105 = r103.f204068a.getBottom();
        if (r100 != 0) goto L6;
        float r106 = 0.0f;
    L9:
        r103.f204072e.onNext(Float.valueOf(r106));
        return;
    L6:
        if (r101 < (r105 - 5)) goto L8;
        r106 = 1.0f;
        goto L9
    L8:
        r106 = r100 / r104;
        goto L9
    }
}
