package zy4;

import android.view.View;
import com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements HorizontalOverScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f573932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.document.onboarding.c f573933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f573934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HorizontalOverScrollView f573935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f573936e;

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView.a
    public final void a(int r100) {
        if (this.f573932a != r100) goto L6;
        m r101 = this.f573936e;
        com.bytedance.ee.bear.document.onboarding.c r102 = this.f573933b;
        View r103 = this.f573934c;
        r101.getClass();
        m.d(r102, r103);
        ((ArrayList) this.f573935d.f226104a).remove(this);
        return;
    }

    public l(m r100, int r101, com.bytedance.ee.bear.document.onboarding.c r102, View r103, HorizontalOverScrollView r104) {
        this.f573936e = r100;
        this.f573932a = r101;
        this.f573933b = r102;
        this.f573934c = r103;
        this.f573935d = r104;
    }
}
