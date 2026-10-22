package vw6;

import android.app.Activity;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.pdp.container.view.m;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f557430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f557431b;

    @Override // vw6.b
    public final void onHide() {
    }

    @Override // vw6.b
    public final void onShow() {
        m r100 = this.f557430a;
        Intrinsics.checkNotNullParameter(r100, "trackResponder");
        r100.a("show_favourite_hint", MapsKt.plus(r100.b(), MapsKt.mapOf(TuplesKt.to("enter_from", "project_detail_page"))));
    }

    @Override // vw6.b
    public final void a(String r100) {
        m r101 = this.f557430a;
        Intrinsics.checkNotNullParameter(r101, "trackResponder");
        r101.a("click_favourite_hint", MapsKt.plus(r101.b(), MapsKt.mapOf(TuplesKt.to("enter_from", "project_detail_page"))));
        if (r100 == null) goto L6;
        Activity r102 = this.f557431b;
        HostServiceUtilsKt.a0().openSchema(r102, r100);
        return;
    }

    public c(com.bytedance.locallife.pdp.container.view.a r100, Activity r101) {
        this.f557430a = r100;
        this.f557431b = r101;
    }
}
