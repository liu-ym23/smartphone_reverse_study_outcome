package ou4;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentActivity r11, Fragment r12, BitableSharePermSetInfo r13, ShareUserInfoResult r14, UserInfo r16) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "permSetInfo");
        Intrinsics.checkNotNullParameter(r14, TipCallBackData.RESULT);
        tt5.a.h("JumpCollaboratorManagerUtils", "onClickCollaboratorList");
        Bundle r6 = new Bundle();
        r6.putInt("type", r13.getType());
        r6.putParcelable("permission_doc_info", r13);
        ArrayList<? extends Parcelable> r0 = r14.getUserInfoList();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r6.putParcelableArrayList("permission_users", r0);
        r6.putParcelable("collaborator_users", r14);
        r6.putString("permission_module", "");
        HashMap r4 = new HashMap();
        r4.put("url", r13.a);
        r4.put("token", r13.c);
        r4.put("type", Integer.valueOf(r13.getType()));
        r4.put("shareToken", r13.d.getShareToken());
        r4.put("bitableSubType", Integer.valueOf(r13.d.getShareType().getType()));
        r4.put("account", com.bytedance.ee.bear.middleground.permission.collaborator.invite.c.a());
        HashMap r17 = new HashMap();
        r17.put("file_id", du5.b.g(r13.c));
        r17.put("file_type", e.f(r13.getType()));
        r17.put("app_form", "none");
        r17.put("module", "");
        r17.put("file_permission", r13.e.b.getReportJson());
        boolean r1 = false;
        if (r16 != null) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == false) goto L13;
        String r19 = "true";
    L14:
        r17.put("is_owner", r19);
        r4.put("statisticParams", r17);
        LarkAppContext.Companion.getClass();
        r4.put("isOfficeSdk", Boolean.valueOf(LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK()));
        String r110 = null;
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r11, 1203, new de5.a(l0.a().toString(), r4, null, r6, CollectionsKt.arrayListOf(new Class[]{ah5.e.class, ah5.d.class, nu4.a.class, ah5.b.class, ah5.c.class}), r12, false, 68));
        int r111 = f.a;
        EShareType r112 = r13.d.getShareType();
        Intrinsics.checkNotNullParameter(r112, "shareType");
        if (r112 != EShareType.FORM) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        r110 = "ccm_bitable_form_permission_collaborator_view";
    L19:
        if (r110 != null) goto L21;
        r110 = "ccm_bitable_external_permission_management_collaborator_view";
    L21:
        f.c("manage_collaborator", r110, r112);
        return;
    L13:
        r19 = "false";
        goto L14
    L8:
        if (r16.isOwner() != true) goto L10;
        r18 = true;
        goto L11
    }
}
