package ha4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends ArrayAdapter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f484372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484373b;

    public e(Context r100, String[] r101, int r102) {
        super(r100, R.id.bdp_text1, r101);
        this.f484372a = (LayoutInflater) r100.getSystemService("layout_inflater");
        this.f484373b = r102;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L4;
        r101 = this.f484372a.inflate(R.layout.bdp_select_dialog_item, r102, false);
        TextView r103 = (TextView) r101.findViewById(R.id.bdp_text1);
        r101.setTag(r103);
    L5:
        r103.setTextColor(this.f484373b);
        return super.getView(r100, r101, r102);
    L4:
        r103 = (TextView) r101.getTag();
        goto L5
    }
}
