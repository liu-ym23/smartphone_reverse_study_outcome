package wq5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.contract.AnalyticConstant$OpenType;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TreeNode f560754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f560755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f560756e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Bundle r101 = new Bundle();
        r101.putString("ccm_open_type", AnalyticConstant$OpenType.WIKI_CREATE_NEW.getType());
        TreeNode r102 = this.f560754c;
        String r103 = r102.space_id;
        String r104 = this.f560755d.f560741d;
        String r105 = r102.wiki_token;
        int r106 = lw4.a.f511011g;
        o.a(r103, r104, r105, r101, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(this.f560756e)));
    }

    public l(TreeNode r100, j r101, Activity r102) {
        this.f560754c = r100;
        this.f560755d = r101;
        this.f560756e = r102;
    }
}
