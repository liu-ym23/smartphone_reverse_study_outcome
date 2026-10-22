package sq4;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardOperation;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardActionModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.OpenDiscussPanelType;
import fp4.d;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public interface b {

    public interface a {
        void onCallBack(String r100, String r101);
    }

    void a(cp4.b r100, String r101, String r102);

    void addOperationListener(a r100);

    void b(ECardOperation r100, CardOperationModel.FormRecordParams r101);

    void c(String r100, String r101, boolean r102);

    void d(cp4.b r100, String r101);

    void e(cp4.b r100, String r101, String r102, cp4.b r103, String r104, Object r105);

    void f();

    void g();

    void h(d r100, cp4.a r101);

    void i(cp4.b r100, String r101, String r102, String r103, Object r104);

    MutableLiveData<Boolean> j();

    void k(String r100, String r101, OpenDiscussPanelType r102);

    void l(String r100, String r101, String r102, String r103, String r104, JSONObject r105);

    void m(String r100, String r101, Boolean r102);

    void n(cp4.b r100, String r101, String r102, boolean r103);

    void o();

    void p(String r100, String r101);

    void q();

    void r();

    void s(CardActionModel.TopTipType r100);

    void t(d r100, cp4.a r101, String r102, CardOperationModel.FormRecordParams r103);

    void u(a r100);

    void v(cp4.b r100);

    void w(String r100, String r101, String r102, String r103, String r104, JSONObject r105);

    void x(String r100, String r101);

    void y(cp4.b r100, String r101, String r102, String r103, Object r104, CardOperationModel.FormRecordParams r105);

    void z(m r100);
}
