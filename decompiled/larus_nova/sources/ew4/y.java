package ew4;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public interface y extends IOfficeSDKProtocol {
    void openAlbum(FragmentActivity r100, j r101, m r102);

    void openCamera(FragmentActivity r100, k r101, m r102);

    void showFileSelector(FragmentActivity r100, n r101, m r102);
}
