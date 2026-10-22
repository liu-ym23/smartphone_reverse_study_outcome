package mab;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public abstract class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f512736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f512737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f512738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f512739d;

    public abstract String a(int r100);

    @Override // android.widget.Adapter
    public abstract int getCount();

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public boolean b(int r100) {
        if (r100 < 0) goto L7;
        boolean[] r101 = this.f512736a;
        if (r100 < r101.length) goto L6;
        return false;
    L6:
        return r101[r100];
    L7:
        return false;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r100) {
        return a(r100);
    }

    public c(Context r100, int r101, int r102) {
        this.f512737b = r100;
        int r103 = getCount() / r101;
        this.f512739d = Math.round((r102 - ((r103 - 1) * r100.getResources().getDimension(R.dimen.dp_05))) / r103);
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        int r103 = R.color.text_caption;
        if (r101 != null) goto L5;
        TextView r104 = new TextView(r102.getContext());
        AbsListView.LayoutParams r105 = new AbsListView.LayoutParams(-1, this.f512739d);
        r104.setBackgroundColor(r102.getContext().getResources().getColor(R.color.bg_body));
        r104.setTextColor(r102.getContext().getResources().getColor(R.color.text_caption));
        r104.setLayoutParams(r105);
        r104.setGravity(17);
        r104.setTextSize(16.0f);
        r104.setVisibility(0);
        TextView r106 = r104;
        View r107 = r104;
    L6:
        Context r108 = r107.getContext();
        if (r100 >= 0) goto L9;
    L15:
        return r107;
    L9:
        if (r100 >= this.f512736a.length) goto L15;
        r106.setText(a(r100));
        if (this.f512736a[r100] == false) goto L13;
        Resources r109 = r108.getResources();
        r103 = R.color.primary_fill_default;
    L14:
        r106.setTextColor(r109.getColor(r103));
        goto L15
    L13:
        r109 = r108.getResources();
        goto L14
    L5:
        TextView r110 = (TextView) r101;
        r107 = r101;
        r106 = r110;
        goto L6
    }
}
