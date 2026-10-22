package wg5;

import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends vg5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DocPermSetInfo f559558e;

    public a(dh5.b r100, DocPermSetInfo r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "permSetInfo");
        super(r100, r101);
        this.f559558e = r101;
    }

    @Override // vg5.a
    public final HashMap<String, String> k(ArrayList<UserInfo> r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "selectedUsers");
        Intrinsics.checkNotNullParameter(r103, "notes");
        HashMap<String, String> r104 = new HashMap();
        r104.put("token", this.f559558e.f234429c);
        r104.put("type", String.valueOf(this.f559558e.getType()));
        r104.put("owners", vg5.a.p(r100));
        String r105 = "1";
        r104.put(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, "1");
        if (r101 == true) goto L6;
        r105 = "0";
    L6:
        r104.put("notify_lark", r105);
        h(r104);
        return r104;
    }
}
