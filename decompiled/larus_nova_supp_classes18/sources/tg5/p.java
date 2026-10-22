package tg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface p extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void D0(String r1);

        void N(boolean r1);

        void W(UserInfo r1);

        void W2();

        ArrayList<UserInfo> e();

        void onBack();

        boolean r0();
    }

    void A8();

    void F(ArrayList<UserInfo> r1);

    void J7(List<? extends NotNotifyUserEntity> r1, String r2);

    void K5(String r1, String r2);

    void N1();

    void W0(List<? extends NotNotifyUserEntity> r1);

    void b2(Throwable r1, String r2, String r3);

    boolean b8();

    String getNotes();

    void h8(List<? extends NotNotifyUserEntity> r1);

    void hideLoading();

    void o6();

    void r1(List<? extends NotNotifyUserEntity> r1);

    void showLoading();

    boolean u6();

    void w5(String r1);
}
