package com.bytedance.ee.bear.drive.core.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDrivePreviewFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import iu5.d;
import java.util.ArrayList;
import java.util.List;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DrivePreviewFragmentAdapter extends FragmentStatePagerAdapter {
    public final List<BaseOpenEntity> a;
    public final Bundle b;

    public final int getCount() {
        return this.a.size();
    }

    public final void finishUpdate(View r3) {
        super/*androidx.viewpager.widget.PagerAdapter*/.finishUpdate(r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.d("DrivePreviewFraAdapter", "finishUpdate(View) error: " + e);
        d.a("DrivePreviewFraAdapter", e);
    }

    public final Fragment getItem(int r4) {
        UserContainerDrivePreviewFragment r0 = new UserContainerDrivePreviewFragment();
        Bundle r1 = new Bundle();
        Bundle r2 = this.b;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        PassportcConvention.f(r1, LarkContext.getApplication());
        r1.putParcelable("extra_drive_sdk_open_entity", (BaseOpenEntity) ListProtector.get(this.a, r4));
        r0.setArguments(r1);
        return r0;
    }

    public final void finishUpdate(ViewGroup r3) {
        super.finishUpdate(r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.d("DrivePreviewFraAdapter", "finishUpdate(ViewGroup) error: " + e);
        d.a("DrivePreviewFraAdapter", e);
    }

    public DrivePreviewFragmentAdapter(Bundle r1, FragmentManager r2, List<BaseOpenEntity> r3) {
        super(r2);
        this.a = new ArrayList();
        this.b = r1;
        this.a = r3;
    }
}
