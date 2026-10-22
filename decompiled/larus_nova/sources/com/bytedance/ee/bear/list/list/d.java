package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface d {

    public interface a {
        void D(View r100, int r101, Document r102, boolean r103);
    }

    public interface b {
        void B0(View r100, int r101, Document r102, boolean r103);

        void P(View r100, int r101, Document r102);

        void Y(View r100, int r101, Document r102, boolean r103);

        boolean t0();

        void x0(View r100, int r101, Document r102, boolean r103);
    }

    public interface c {
        void h0(Document r100, boolean r101);
    }

    void I(a r100);

    void L(AccountService$Account r100);

    void M0(c r100);

    int addHeaderView(View r100);

    List<Document> getData();

    int getHeaderLayoutCount();

    int getItemCount();

    int getItemViewType(int r100);

    void notifyDataSetChanged();

    void notifyItemMoved(int r100, int r101);

    void notifyItemRangeChanged(int r100, int r101, Object r102);

    void notifyItemRangeInserted(int r100, int r101);

    void notifyItemRangeRemoved(int r100, int r101);

    void o0(b r100);

    void p2(int r100, Document r101);

    void removeHeaderView(View r100);

    void setData(List<Document> r100);

    void v(int r100);

    void x0(boolean r100);
}
