package iqb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.location.dto.POIInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f495407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<POIInfo> f495408b;

    /* JADX INFO: renamed from: iqb.a$a, reason: collision with other inner class name */
    public static final class C6350a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f495409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f495410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f495411c;

        public C6350a() {
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f495408b.size();
    }

    public final POIInfo a(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f495408b.size()) goto L7;
        return null;
    L7:
        return (POIInfo) ListProtector.get(this.f495408b, r100);
    }

    public final void b(List<POIInfo> r100) {
        this.f495408b = new ArrayList(r100);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return Integer.valueOf(r100);
    }

    public a(Context r100, List<POIInfo> r101) {
        new ArrayList();
        this.f495407a = r100;
        this.f495408b = r101;
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L5;
        r101 = LayoutInflater.from(this.f495407a).inflate(R.layout.location_position_item, r102, false);
        C6350a r103 = new C6350a();
        r103.f495409a = (TextView) r101.findViewById(R.id.tv_location_name);
        r103.f495411c = (ImageView) r101.findViewById(R.id.iv_location_current);
        r103.f495410b = (TextView) r101.findViewById(R.id.tv_location_desc);
        r101.setTag(r103);
    L6:
        POIInfo r104 = (POIInfo) ListProtector.get(this.f495408b, r100);
        r103.f495409a.setText(r104.getLocationName());
        r103.f495410b.setText(r104.getLocationAddress());
        ImageView r105 = r103.f495411c;
        if (r104.getIsCurrent() == false) goto L9;
        int r106 = 0;
    L10:
        r105.setVisibility(r106);
        if (TextUtils.isEmpty(r104.getLocationAddress()) == false) goto L13;
        r103.f495410b.setVisibility(8);
    L15:
        if (r104.getIsSelfDefine() == true) goto L17;
    L19:
        Context r107 = this.f495407a;
        Drawable r108 = UDIconUtils.getIconDrawable(r107, R.drawable.ud_icon_local_outlined, UIUtils.getColor(r107, R.color.ud_N400));
    L20:
        if (r108 == null) goto L22;
        int r109 = UIUtils.dp2px(this.f495407a, 16.0f);
        r108.setBounds(0, 0, r109, r109);
    L22:
        r103.f495409a.setCompoundDrawables(r108, null, null, null);
        return r101;
    L17:
        if (r104.getIsCurrent() == true) goto L19;
        r108 = this.f495407a.getResources().getDrawable(R.drawable.location_icon_location_self_define);
        goto L20
    L13:
        r103.f495410b.setVisibility(0);
        goto L15
    L9:
        r106 = 8;
        goto L10
    L5:
        r103 = (C6350a) r101.getTag();
        goto L6
    }
}
