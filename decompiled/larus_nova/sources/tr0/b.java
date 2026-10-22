package tr0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f547273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f547274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ur0.a f547275c;

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return ((ArrayList) this.f547274b).size();
    }

    public final void a(int r100) {
        List<Integer> r101 = this.f547274b;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(Integer.valueOf(r100)) == true) goto L5;
        List<Integer> r103 = this.f547274b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(Integer.valueOf(r100));
    L5:
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return ListProtector.get(this.f547274b, r100);
    }

    public b(Context r100, ur0.a r101) {
        this.f547274b = new ArrayList();
        this.f547273a = r100;
        this.f547275c = r101;
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L4;
        r101 = LayoutInflater.from(this.f547273a).inflate(R.layout.item_popup_entrance_debug, null);
    L4:
        LinearLayout r103 = (LinearLayout) r101.findViewById(R.id.entrance_button);
        final int r104 = ((Integer) ListProtector.get(this.f547274b, r100)).intValue();
        r103.setOnClickListener(new a(this, r104));
        TextView r105 = (TextView) r101.findViewById(R.id.entrance_text);
        ImageView r106 = (ImageView) r101.findViewById(R.id.entrance_image);
        switch(r104) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L16;
        };
    L7:
        r105.setText(R.string.ttlive_tools_entrance);
        r106.setImageDrawable(s1.m(R.drawable.tools));
        goto L16
    L8:
        r105.setText(R.string.ttlive_settings_entrance);
        r106.setImageDrawable(s1.m(R.drawable.settings));
        goto L16
    L9:
        r105.setText(R.string.ttlive_diagnose_entrance);
        r106.setImageDrawable(s1.m(R.drawable.diagnose));
        goto L16
    L10:
        r105.setText(R.string.ttlive_anti_degradation_entrance);
        r106.setImageDrawable(s1.m(R.drawable.anti_degradation));
        goto L16
    L11:
        r105.setText(R.string.ttlive_performance_entrance);
        r106.setImageDrawable(s1.m(R.drawable.performance_info));
        goto L16
    L12:
        r105.setText(R.string.ttlive_message_entrance);
        r106.setImageDrawable(s1.m(R.drawable.message_info));
        goto L16
    L13:
        r105.setText(R.string.ttlive_scene_entrance);
        r106.setImageDrawable(s1.m(R.drawable.scene_info));
        goto L16
    L14:
        r105.setText(R.string.ttlive_end_entrance);
        r106.setImageDrawable(s1.m(R.drawable.video_info));
        goto L16
    L15:
        r105.setText(R.string.ttlive_base_info_entrance);
        r106.setImageDrawable(s1.m(R.drawable.ic_baseline_info_24));
    L16:
        r105.setTextColor(-1);
        if (wr0.b.f(r104).isEmpty() == false) goto L19;
        r101.setVisibility(8);
    L19:
        return r101;
    }
}
