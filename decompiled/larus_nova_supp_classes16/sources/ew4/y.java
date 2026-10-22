package ew4;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public interface y extends IOfficeSDKProtocol {
    void openAlbum(FragmentActivity r1, j r2, m r3);

    void openCamera(FragmentActivity r1, k r2, m r3);

    void showFileSelector(FragmentActivity r1, n r2, m r3);
}
