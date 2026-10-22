package tr0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import sr0.i;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f547283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f547284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ur0.b f547285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f547286d;

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return ((ArrayList) this.f547284b).size();
    }

    public final void a(int r100) {
        List<Integer> r101 = this.f547284b;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(Integer.valueOf(r100)) == true) goto L6;
        List<Integer> r103 = this.f547284b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(Integer.valueOf(r100));
        notifyDataSetChanged();
        return;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return (Integer) ListProtector.get(this.f547284b, r100);
    }

    public g(Context r100, i r101) {
        this.f547284b = new ArrayList();
        this.f547286d = 0;
        this.f547283a = r100;
        this.f547285c = r101;
    }

    @Override // android.widget.Adapter
    public final View getView(final int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L4;
        r101 = LayoutInflater.from(this.f547283a).inflate(R.layout.item_performance_type_debug, null);
    L4:
        Button r103 = (Button) r101.findViewById(R.id.button_performance_type);
        String r104 = wr0.b.h(((Integer) ListProtector.get(this.f547284b, r100)).intValue()).get("data_performance_title");
        if (r103 != null) goto L7;
    L10:
        return r101;
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r103.setText(r104);
        r103.setOnClickListener(new f(this, r100));
        goto L10
    }
}
