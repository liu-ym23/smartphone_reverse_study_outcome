package gg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements com.ss.android.lark.reaction.widget.panel.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f481129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f481130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f481131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f481132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TranslateConfig f481133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f481134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f481135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f481136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f481137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Integer f481138j;

    public d(boolean r100, String r101, b r102, int r103, TranslateConfig r104, String r105, String r106, boolean r107, String r108, Integer r110) {
        this.f481129a = r100;
        this.f481130b = r101;
        this.f481131c = r102;
        this.f481132d = r103;
        this.f481133e = r104;
        this.f481134f = r105;
        this.f481135g = r106;
        this.f481136h = r107;
        this.f481137i = r108;
        this.f481138j = r110;
    }

    @Override // com.ss.android.lark.reaction.widget.panel.e.a
    public final void a(View r100) {
        if (this.f481129a == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.f481130b, Boolean.TRUE);
        this.f481131c.f481123a.invoke(Integer.valueOf(this.f481132d));
        return;
    L6:
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).c(this.f481133e, this.f481130b, this.f481134f, this.f481135g) == false) goto L12;
        Boolean r101 = ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().get(this.f481130b);
        if (r101 != null) goto L10;
        r101 = Boolean.FALSE;
    L10:
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.f481130b, Boolean.valueOf(!r101.booleanValue()));
        this.f481131c.f481123a.invoke(Integer.valueOf(this.f481132d));
        return;
    L12:
        if (this.f481136h == true) goto L14;
        this.f481131c.f481124b.invoke(this.f481137i, this.f481130b, this.f481138j);
        return;
    L14:
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().remove(this.f481130b);
        this.f481131c.f481123a.invoke(Integer.valueOf(this.f481132d));
    }
}
