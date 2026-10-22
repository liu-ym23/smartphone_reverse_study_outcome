package w91;

import android.view.ViewGroup;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
import w91.f;

/* JADX INFO: loaded from: classes47.dex */
public interface b<D, VH extends f> {
    void a(VH r100, int r101);

    CommonTabHolder b(ViewGroup r100, int r101);

    void c(j91.b<D> r100);

    u91.a getData(int r100);

    int getDataPosition(D r100);

    int getItemSize();

    int getItemViewType(int r100);

    void notifyDataSetChange();
}
