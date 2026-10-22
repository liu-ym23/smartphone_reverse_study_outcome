package tg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface p extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void D0(String r100);

        void N(boolean r100);

        void W(UserInfo r100);

        void W2();

        ArrayList<UserInfo> e();

        void onBack();

        boolean r0();
    }

    void A8();

    void F(ArrayList<UserInfo> r100);

    void J7(List<? extends NotNotifyUserEntity> r100, String r101);

    void K5(String r100, String r101);

    void N1();

    void W0(List<? extends NotNotifyUserEntity> r100);

    void b2(Throwable r100, String r101, String r102);

    boolean b8();

    String getNotes();

    void h8(List<? extends NotNotifyUserEntity> r100);

    void hideLoading();

    void o6();

    void r1(List<? extends NotNotifyUserEntity> r100);

    void showLoading();

    boolean u6();

    void w5(String r100);
}
