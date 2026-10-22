package com.bytedance.ee.bear;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.security.DlpUploadAction;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public interface i {
    void a(String r100, DlpUploadAction r101);

    void b(j r100);

    void c(Context r100, BaseOpenEntity r101);

    UserContainerDriveMainFragment d(SpaceFileOpenEntity r100, Bundle r101);

    void e(BaseOpenEntity r100);

    void f(Context r100, ArrayList<? extends BaseOpenEntity> r101, int r102, ma5.a r103, Bundle r104);

    void g(j r100);

    void h(Context r100, ArrayList<? extends BaseOpenEntity> r101, int r102);
}
