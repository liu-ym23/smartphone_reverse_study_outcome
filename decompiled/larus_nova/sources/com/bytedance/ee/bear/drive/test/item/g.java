package com.bytedance.ee.bear.drive.test.item;

import android.widget.CompoundButton;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveUploadTestItem f224682a;

    public g(DriveUploadTestItem r100) {
        this.f224682a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        DriveUploadTestItem r102 = this.f224682a;
        if (r101 == false) goto L5;
        int r103 = R.string.test_upload_type_share_token;
    L6:
        TextView r104 = r102.f224653d;
        SpaceEditText r105 = null;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadType");
        r104 = null;
    L9:
        r104.setText(r103);
        SpaceEditText r106 = r102.f224654e;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r106 = null;
    L12:
        r106.setHint(r103);
        if (r101 == false) goto L19;
        SpaceEditText r107 = r102.f224654e;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
    L18:
        r105.setText(r102.getActivity().getString(R.string.test_upload_file_auth_code));
        return;
    L17:
        r105 = r107;
        goto L18
    L19:
        SpaceEditText r108 = r102.f224654e;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
    L23:
        r105.setText("");
        return;
    L22:
        r105 = r108;
        goto L23
    L5:
        r103 = R.string.test_upload_type_mount_node_token;
        goto L6
    }
}
