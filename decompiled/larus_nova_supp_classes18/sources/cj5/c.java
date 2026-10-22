package cj5;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bitable.lynx.pro.d;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.export.j;
import com.larksuite.component.universe_design.dialog.UDDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import qe5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c extends j {

    public interface a {
        void a(JSONArray r1, ug5.a.b r2, ug5.a.c r3);
    }

    public static class b {
        public String a;
        public String b;
        public int c;
        public String d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public String k;
        public String l;

        public b() {
        }
    }

    void B7(FragmentActivity r1, String r2);

    void C8(Context r1, int r2, String r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, com.bytedance.ee.bear.middleground_permission_export.model.a r9, String r10, boolean r11, boolean r12);

    @Override // com.bytedance.ee.bear.share.export.j
    DialogFragment E0(ShareParams r1);

    void Ee(th5.b r1);

    void F0(FragmentActivity r1, String r2, int r3, String r4, String r5, String r6);

    void G8(Context r1, String r2, int r3, int r4);

    void H9(i r1, SharePanelState r2, km5.a r3);

    View I7(FragmentActivity r1, int r2, String r3, String r4, String r5, FolderVersion r6, boolean r7, boolean r8, Fragment r9);

    DialogFragment N2(ShareParams r1, Bundle r2, com.bytedance.ee.bear.document.share.a.a r3, ShareDocInfo r4);

    void O0(FragmentActivity r1, String r2, String r3, String r4, String r5, boolean r6, ArrayList<UserInfo> r7, ArrayList<UserInfo> r8);

    View S7(Context r1, ShareParams r2, boolean r3, boolean r4, boolean r5);

    View T8(Context r1, boolean r2, String r3);

    DialogFragment Xe(FragmentActivity r1, boolean r2, int r3);

    void ad(FragmentActivity r1, String r2, int r3, String r4, String r5, int r6, String r7, String r8, SecretLevel r9, SecretApprovalDefModel r10, Map<String, Serializable> r11, SecretLevel r12);

    void c5(Context r1, String r2, int r3, String r4, Fragment r5);

    DialogFragment fa(ShareParams r1);

    View g2(Context r1, ShareParams r2);

    void hb(Fragment r1, int r2, e.c r3, e.b r4, SecretApprovalInstanceModel r5, SecretApprovalDefModel r6, SecretLevel r7, SecretLevel r8);

    View i2(FragmentActivity r1, Fragment r2, int r3, String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, ArrayList r13);

    DialogFragment id(ShareParams r1, Bundle r2);

    DialogFragment k6(FragmentActivity r1, String r2, int r3, DocMetaInfo r4, String r5, String r6, boolean r7, Fragment r8, boolean r9);

    void l5(FragmentActivity r1, int r2, e.c r3, e.b r4, SecretApprovalInstanceModel r5, SecretApprovalDefModel r6, SecretLevel r7, SecretLevel r8);

    void le(Context r1, int r2, String r3, String r4, boolean r5, boolean r6, String r7, DialogInterface.OnClickListener r8, DialogInterface.OnClickListener r9, Integer r10, String r11);

    View n6(Context r1, boolean r2);

    UDDialog nc(Context r1, String r2);

    void o6(FragmentActivity r1, String r2, int r3, String r4, String r5);

    DialogFragment r3(FragmentActivity r1, String r2, int r3, DocMetaInfo r4, String r5, String r6);

    void rb(Context r1, b r2, HashMap<String, Serializable> r3, Fragment r4);

    View s7(Context r1, ShareParams r2);

    void w4(Fragment r1, String r2, int r3, String r4, String r5, int r6, String r7, SecretLevel r8, SecretApprovalDefModel r9, Map r10, SecretLevel r11);

    void wb(Context r1, TransferApplyInfo r2, Fragment r3, boolean r4);

    void xe(FragmentActivity r1, Fragment r2, String r3, String r4, ArrayList r5, ArrayList r6, ArrayList r7, d r8);
}
