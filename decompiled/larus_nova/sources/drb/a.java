package drb;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface a<D, VH extends RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f469801a = 0;

    long a(D r100);

    VH b(ViewGroup r100);

    void c(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102);

    void d(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102, List r103);

    static {
        f469801a = UIHelper.dp2px(40.0f);
        UIHelper.dp2px(24.0f);
    }
}
