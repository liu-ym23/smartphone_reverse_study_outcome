package com.bytedance.ee.bear.content.creation.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectCreationMenuFragment extends BaseFragment {
    public View e;
    public e f;
    public SelectCreationMenuConfig g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public CreateSelectResult o;
    public String p;

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.destroy();
    }

    public SelectCreationMenuFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        this.g = (SelectCreationMenuConfig) r5.getParcelable("key_config");
        this.h = r5.getString("key_module");
        this.i = r5.getString("key_parent_token", "");
        this.l = r5.getBoolean("key_is_folder", false);
        this.m = r5.getBoolean("key_is_from_empty", false);
        this.j = r5.getString("key_sub_module");
        this.k = r5.getString("key_src_module");
        this.n = r5.getBoolean("key_folder_version", false);
        CreateSelectResult r0 = (CreateSelectResult) r5.getParcelable("CREATION_LOCATION");
        this.o = r0;
        if (r0 != null) goto L7;
        this.o = CreateSelectResult.b();
    L7:
        this.p = r5.getString("SPACE_ID", "");
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r14, Bundle r16) {
        super.onViewCreated(r14, r16);
        tt5.a.h("SelectCreationMenuFragment", "initMVP()...");
        e r17 = new e(this, new h(getContext(), this, this.e, getChildFragmentManager(), this.h, this.j, this.i, this.l, this.m, this.g, this.o, this.p), new c(this.g, getContext()), this.h, this.i, this.l, this.m, this.j, this.k, this.n);
        this.f = r17;
        r17.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131559935, r3, false);
        this.e = r5;
        return r5;
    }
}
