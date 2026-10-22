package y6c;

import android.util.SparseIntArray;
import com.larus.nova.R;
import com.ss.android.lark.thirdshare.base.export.item.BaseItemAdapter;
import com.ss.android.lark.thirdshare.base.export.item.ItemViewHolder;
import y6c.a;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<T extends a<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseIntArray f566558c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseItemAdapter<T> f566560b;

    public abstract void a(ItemViewHolder r100);

    static {
        f566558c = new SparseIntArray();
    }

    public void update() {
        BaseItemAdapter<T> r100 = this.f566560b;
        int r101 = r100.f441215a.indexOf(this);
        if (r101 == (-1)) goto L6;
        r100.notifyItemRangeChanged(r101, 1, null);
        return;
    }

    public a() {
        int r100 = getClass().hashCode() + R.layout.ts_share_dialog_item;
        this.f566559a = r100;
        f566558c.put(r100, R.layout.ts_share_dialog_item);
    }
}
