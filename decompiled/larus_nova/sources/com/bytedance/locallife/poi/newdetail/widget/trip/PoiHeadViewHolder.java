package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/PoiHeadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class PoiHeadViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f263523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.widget.contentplayer.c f263524b;

    public static final class a {
    }

    static {
    }

    public void T3(com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r100, int r101, int r102, List<AlbumTabListModel> r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r103, "subTabItemList");
    }

    public abstract void U3(PoiPhoto r100, int r101, int r102);

    public boolean V3() {
        return false;
    }

    public abstract void W3();

    public abstract void X3();

    public abstract void Y3();

    public abstract void Z3();

    public void a4(int r100, int r101) {
    }

    public abstract void b4();

    public abstract void c4();

    public void d4(int r100) {
    }

    public abstract void onDestroy();

    public PoiHeadViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f263523a = -1;
    }
}
