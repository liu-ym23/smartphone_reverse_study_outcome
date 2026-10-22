package iib;

import android.content.Context;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        boolean H2(int r100);

        void K2(Context r100, List<ForwardTarget> r101, RichText r102);

        s5c.d O0(List<SearchBaseInfo> r100);

        void T6(SearchBaseInfo r100);

        void e1(SearchBaseInfo r100, boolean r101);

        void i2(Context r100, List<SearchBaseInfo> r101, RichText r102);

        void i7(SearchBaseInfo r100);

        void n1(SearchBaseInfo r100, boolean r101);

        void n5();

        void s3(int r100);
    }

    void G4(List<SearchBaseInfo> r100);

    void L0(String r100, boolean r101);

    void U3(com.ss.android.lark.forwardv2.impl.model.b r100, List r101);

    void e6(String r100, String r101, boolean r102);

    void k8(List<SearchBaseInfo> r100);

    void onCancelClick();

    void s7(List<SearchBaseInfo> r100);

    void t8();

    void z6(List<SearchBaseInfo> r100);
}
