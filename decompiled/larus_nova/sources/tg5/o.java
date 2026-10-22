package tg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface o extends IModel {
    void D1(boolean r100, String r101, EscapeRuleBean r102, vg5.d r103);

    void F1(String r100);

    void N(boolean r100);

    void c7(boolean r100, boolean r101, String r102, ax4.e<InviteResult> r103);

    ArrayList<UserInfo> e();

    void m7(UserInfo r100);

    boolean r0();
}
