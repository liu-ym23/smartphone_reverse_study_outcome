package i90;

import android.view.View;
import com.bytedance.android.live.effect.adapter.LiveBeautyTemplateAdapter;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautyTemplateAdapter f488749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f488750b;

    public a(LiveBeautyTemplateAdapter r100, int r101) {
        this.f488749a = r100;
        this.f488750b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f488750b;
        LiveBeautyTemplateAdapter r102 = this.f488749a;
        if (r101 != r102.f66709e) goto L5;
        return;
    L5:
        LiveBeautyTemplateAdapter.b r103 = r102.f66710f;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r102.f66711g == false) goto L12;
        r103.onItemClick(r101);
        return;
    }
}
