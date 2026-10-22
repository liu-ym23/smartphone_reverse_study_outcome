package mt8;

import android.view.View;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    ResourceItemBean a(String r100);

    void b(ResourceBarConfig r100, ArrayList<ResourceItemBean> r101, BaseResourceViewHolder.a r102);

    void c(String r100);

    void d();

    void e(ArrayList<ResourceItemBean> r100);

    void f(ResourceItemBean r100);

    void g(String r100, int r101);

    ArrayList<ResourceItemBean> getList();

    View getView();

    void h(ResourceBarConfig r100, ArrayList<ResourceItemBean> r101, BaseResourceViewHolder.a r102);

    void i(ResourceItemBean r100);
}
