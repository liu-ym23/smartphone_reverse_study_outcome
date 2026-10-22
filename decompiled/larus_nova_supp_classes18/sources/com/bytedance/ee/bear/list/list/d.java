package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface d {

    public interface a {
        void D(View r1, int r2, Document r3, boolean r4);
    }

    public interface b {
        void B0(View r1, int r2, Document r3, boolean r4);

        void P(View r1, int r2, Document r3);

        void Y(View r1, int r2, Document r3, boolean r4);

        boolean t0();

        void x0(View r1, int r2, Document r3, boolean r4);
    }

    public interface c {
        void h0(Document r1, boolean r2);
    }

    void I(a r1);

    void L(AccountService.Account r1);

    void M0(c r1);

    int addHeaderView(View r1);

    List<Document> getData();

    int getHeaderLayoutCount();

    int getItemCount();

    int getItemViewType(int r1);

    void notifyDataSetChanged();

    void notifyItemMoved(int r1, int r2);

    void notifyItemRangeChanged(int r1, int r2, Object r3);

    void notifyItemRangeInserted(int r1, int r2);

    void notifyItemRangeRemoved(int r1, int r2);

    void o0(b r1);

    void p2(int r1, Document r2);

    void removeHeaderView(View r1);

    void setData(List<Document> r1);

    void v(int r1);

    void x0(boolean r1);
}
