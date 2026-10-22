package dn9;

import android.view.View;
import com.bytedance.ee.docsdk.impl.utils.SafeClickListener;
import com.larus.office.base.plugins.toolbar.BaseToolbarV2PanelFragment;
import com.larus.office.base.plugins.toolbar.model.ItemId;

/* JADX INFO: loaded from: classes29.dex */
public final class f extends SafeClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f469379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseToolbarV2PanelFragment<com.larus.office.base.plugins.toolbar.model.a> f469380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemId f469381c;

    @Override // com.bytedance.ee.docsdk.impl.utils.SafeClickListener
    public final void onClicked(View r100) {
        String r101 = String.valueOf(this.f469379a);
        this.f469380b.Z90(this.f469381c, r101);
    }

    public f(boolean r100, BaseToolbarV2PanelFragment<com.larus.office.base.plugins.toolbar.model.a> r101, ItemId r102) {
        this.f469379a = r100;
        this.f469380b = r101;
        this.f469381c = r102;
    }
}
