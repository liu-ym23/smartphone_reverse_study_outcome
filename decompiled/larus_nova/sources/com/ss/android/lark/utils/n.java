package com.ss.android.lark.utils;

import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444741a = 0;

    static {
        String r100 = UIHelper.getString(R.string.Lark_Search_EnableMicVoiceSearch_Desc);
        ICUUtils.FormatArgsBuilder r101 = new ICUUtils.FormatArgsBuilder();
        r101.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        ICUUtils.icuFormat(r100, r101.f285892a);
        String r102 = UIHelper.getString(R.string.Lark_Settings_AccessToContacts_Android_Title);
        ICUUtils.FormatArgsBuilder r103 = new ICUUtils.FormatArgsBuilder();
        r103.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        ICUUtils.icuFormat(r102, r103.f285892a);
        String r104 = UIHelper.getString(R.string.Lark_Settings_AccessToContacts_Android_Desc);
        ICUUtils.FormatArgsBuilder r105 = new ICUUtils.FormatArgsBuilder();
        r105.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        ICUUtils.icuFormat(r104, r105.f285892a);
    }

    public static final l a() {
        return new l(R.string.Lark_Core_StorageAccess_Title, R.string.Lark_Legacy_ApplyStoragePermission, R.string.Lark_Core_StorageAccess_Title, R.string.Lark_Legacy_ApplyStoragePermission, null, null, 240);
    }

    public static final l b() {
        return new l(R.string.Lark_Core_StorageAccess_Title, R.string.Lark_IM_EnableStoragePermissionToSelectImageOrVideo_AndroidText, R.string.Lark_Core_StorageAccess_Title, R.string.Lark_IM_EnableStoragePermissionToSelectImageOrVideo_AndroidText, null, null, 240);
    }

    public static final l c() {
        return new l(R.string.Lark_Core_StorageAccess_Title, R.string.Lark_Core_EnableStorageAccess_ToSavePhotos, R.string.Lark_Core_StorageAccess_Title, R.string.Lark_Core_EnableStorageAccess_ToSavePhotos, null, null, 240);
    }
}
