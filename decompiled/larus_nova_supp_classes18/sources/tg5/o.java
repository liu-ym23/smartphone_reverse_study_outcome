package tg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface o extends IModel {
    void D1(boolean r1, String r2, EscapeRuleBean r3, vg5.d r4);

    void F1(String r1);

    void N(boolean r1);

    void c7(boolean r1, boolean r2, String r3, ax4.e<InviteResult> r4);

    ArrayList<UserInfo> e();

    void m7(UserInfo r1);

    boolean r0();
}
