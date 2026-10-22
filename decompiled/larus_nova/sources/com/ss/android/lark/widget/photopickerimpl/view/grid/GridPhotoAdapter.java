package com.ss.android.lark.widget.photopickerimpl.view.grid;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002)*B)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00040\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u001c\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fJ\u0006\u0010!\u001a\u00020\u0018J\u0014\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0015\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020\u000f¢\u0006\u0002\u0010(R(\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00040\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fX\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\r\u001a:\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00040\u00070\u000ej\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/widget/photopickerimpl/view/grid/GridPhotoAdapter;", "DATA", "Lcom/ss/android/lark/widget/photopickerimpl/bean/Photo;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mFactory", "Lcom/ss/android/lark/widget/photopickerimpl/view/base/IShowPluginFactory;", "Lcom/ss/android/lark/widget/photopickerimpl/view/grid/GridShowPlugin;", "<init>", "(Lcom/ss/android/lark/widget/photopickerimpl/view/base/IShowPluginFactory;)V", "mData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "setData", "list", "", "updateAll", "", "getData", LiveCommonConstants.REASON_ON_DEDTROY, "mOnItemClickListener", "Lcom/ss/android/lark/widget/photopickerimpl/view/grid/GridPhotoAdapter$IOnItemClickListener;", "setOnItemClickListener", "listener", "getPositionById", "id", "(I)Ljava/lang/Integer;", "DiffCallback", "IOnItemClickListener", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridPhotoAdapter<DATA extends Photo> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final odc.b<DATA, pdc.a<DATA, ? extends RecyclerView.ViewHolder>> f447830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<DATA> f447831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, pdc.a<DATA, ? extends RecyclerView.ViewHolder>> f447832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a<DATA> f447833d;

    public interface a<DATA extends Photo> {
        void a(View r100, DATA r101, int r102);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridPhotoAdapter<DATA> f447834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DATA f447835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f447836c;

        public b(GridPhotoAdapter<DATA> r100, DATA r101, int r102) {
            this.f447834a = r100;
            this.f447835b = r101;
            this.f447836c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a<DATA> r101 = this.f447834a.f447833d;
            if (r101 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            r101.a(r100, this.f447835b, this.f447836c);
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f447831b.size();
    }

    public GridPhotoAdapter(odc.b<DATA, pdc.a<DATA, ? extends RecyclerView.ViewHolder>> r100) {
        Intrinsics.checkNotNullParameter(r100, "mFactory");
        this.f447830a = r100;
        this.f447831b = new ArrayList();
        this.f447832c = new HashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f447830a.getType(r100, (Photo) ListProtector.get(this.f447831b, r100));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        pdc.a<DATA, ? extends RecyclerView.ViewHolder> r102 = this.f447832c.get(Integer.valueOf(getItemViewType(r101)));
        if (r102 == null) goto L7;
        Photo r103 = (Photo) ListProtector.get(this.f447831b, r101);
        r100.itemView.setOnClickListener(new b(this, r103, r101));
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.a(r100, r103);
        return;
    L7:
        throw new IllegalArgumentException("type" + getItemViewType(r101) + " is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        pdc.a<DATA, ? extends RecyclerView.ViewHolder> r102 = (pdc.a) this.f447830a.a(r101);
        Integer r103 = Integer.valueOf(r101);
        this.f447832c.put(r103, r102);
        return r102.b(r100);
    }
}
