package com.ss.android.lark.widget.photopickernew.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.widget.photopickerimpl.bean.b> f447946a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f447947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f447948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f447949c;

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            View r101 = r100.findViewById(R.id.iv_dir_cover);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.ImageView");
            this.f447947a = (ImageView) r101;
            View r102 = r100.findViewById(R.id.tv_dir_name);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.TextView");
            this.f447948b = (TextView) r102;
            View r103 = r100.findViewById(R.id.tv_dir_count);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.TextView");
            this.f447949c = (TextView) r103;
        }

        public final void a(Context r100, com.ss.android.lark.widget.photopickerimpl.bean.b r101) {
            Intrinsics.checkNotNullParameter(r101, "directory");
            ImageLoader.with(r100).load(r101.f447755e).thumbnail(0.1f).into(this.f447947a);
            this.f447948b.setText(r101.f447752b);
            this.f447949c.setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_PickerImageCount, FrescoMonitorConst.IMAGE_COUNT, String.valueOf(r101.f447754d)));
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return ((ArrayList) this.f447946a).size();
    }

    public i(List<com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList r101 = new ArrayList();
        this.f447946a = r101;
        r101.addAll(r100);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return (com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447946a, r100);
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r102, "parent");
        if (r101 != null) goto L6;
        View r103 = LayoutInflater.from(r102.getContext()).inflate(R.layout.__picker_item_directory, r102, false);
        Intrinsics.checkNotNull(r103);
        a r104 = new a(r103);
        r103.setTag(r104);
        r104.a(r102.getContext(), (com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447946a, r100));
        Intrinsics.checkNotNull(r103);
        return r103;
    L6:
        Object r105 = r101.getTag();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.ss.android.lark.widget.photopickernew.grid.PopupPhotoDirListAdapter.ViewHolder");
        ((a) r105).a(r102.getContext(), (com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447946a, r100));
        return r101;
    }
}
