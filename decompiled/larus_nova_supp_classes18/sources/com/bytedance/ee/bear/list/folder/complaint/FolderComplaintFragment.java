package com.bytedance.ee.bear.list.folder.complaint;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderComplaintFragment extends BaseFragment implements f.a {
    public String e;
    public int f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public View k;
    public f l;

    public FolderComplaintFragment() {
        this.j = false;
    }

    public final void U90() {
        if ((getActivity() instanceof FolderComplaintActivity) == false) goto L10;
        FragmentActivity r0 = (FolderComplaintActivity) getActivity();
        r0.getClass();
        tt5.a.h("FolderComplaintActivity", "showSendComplaintSuccess()...");
        r0.h = true;
        Fragment r1 = Fragment.instantiate(r0, FolderComplaintSuccessFragment.class.getName(), r0.C1());
        FragmentTransaction r2 = r0.getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L8;
        r2 = r2.add(R.id.content, r1);
    L8:
        r2.addToBackStack(null).commitAllowingStateLoss();
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        f r0 = this.l;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        tt5.a.h("FolderComplaintFragment", "onDestroy()...");
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        tt5.a.h("FolderComplaintFragment", "onCreate()...");
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.e = r4.getString(ResourceData.KEY_TOKEN);
        this.g = r4.getString("title");
        this.h = r4.getString("desc");
        this.f = r4.getInt(ResourceData.KEY_TYPE);
        this.i = r4.getBoolean("desc");
        this.j = r4.getBoolean(DocumentType.FILE_NAME, false);
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        super.onViewCreated(r8, r9);
        tt5.a.h("FolderComplaintFragment", "initMVP()...");
        FolderComplaintView r10 = new FolderComplaintView(this.k, this.g, this.h, this.i, this.j);
        f r11 = new f(new a(this.e, this.f), r10, this, getContext(), this.i, this.j);
        this.l = r11;
        r11.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563481, r3, false);
        this.k = r5;
        return r5;
    }
}
