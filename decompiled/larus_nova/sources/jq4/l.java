package jq4;

import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;

/* JADX INFO: loaded from: classes15.dex */
public interface l extends com.bytedance.ee.bear.bitable.card.view.table.n {

    public interface a {
        void a();

        void b(Boolean r100);

        void c(String r100);
    }

    void b(EFieldUIType r100, String r101);

    void c();

    void d(String r100);

    void e(a r100);

    void g(int r100);

    void h(boolean r100);

    void i();

    void j(cp4.a r100);

    void k(boolean r100, ETableType r101, boolean r102);

    void m(a r100);

    void setAddRecordTitleBarVisibility(Boolean r100);

    void setFiltered(boolean r100);

    void setHeaderColor(int r100);

    void setTableTitle(String r100);

    void setTitle(dp4.a r100);

    void setTitle(String r100);
}
