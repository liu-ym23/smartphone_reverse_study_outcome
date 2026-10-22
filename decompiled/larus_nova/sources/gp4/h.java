package gp4;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.bitable.card.model.enums.EItemViewSceneType;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardActionModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public interface h {

    public interface a {
        void a(String r100);
    }

    ViewGroup A();

    void B();

    void C(String[] r100, cp4.a r101, FieldCompositeType r102);

    void D();

    void E(FieldCompositeType r100, Map<String, Object> r101);

    boolean F();

    void G();

    void H(String r100);

    DocViewModel H0();

    void I(CardActionModel.TopTipType r100);

    void J();

    void K(sa5.d r100);

    void L(fp4.d r100, cp4.a r101, String r102, CardOperationModel.FormRecordParams r103);

    String M();

    boolean N();

    void O(String r100, String r101);

    Disposable P(String r100, String r101, String r102, String r103);

    PermissionResponse Q(boolean r100);

    String R();

    void S();

    com.bytedance.ee.bear.bitable.card.view.cell.number.a T();

    void U();

    void V();

    a W();

    void X();

    boolean Y();

    void Z();

    com.bytedance.ee.bear.contract.d a();

    void a0();

    void b(w r100);

    void c(w r100);

    DocumentInfo d();

    String e();

    void f();

    void g(String r100, String r101, String r102);

    FragmentActivity getActivity();

    LiveData<Boolean> getCommentAble();

    String getDocName();

    Fragment getFragment();

    String getObjToken();

    int getType();

    String getUrl();

    void h(String r100);

    View i();

    boolean j(ETableType r100);

    void k();

    void l(String r100);

    String m();

    void n();

    mr4.a o();

    void p(String r100);

    boolean q();

    BitableAnalytic q0();

    void r(String r100);

    void s(String r100);

    EItemViewSceneType t();

    void u(sa5.d r100);

    View v();

    boolean w();

    void x(FieldCompositeType r100, Map<String, Object> r101, String r102);

    gj5.c y();

    void z();
}
