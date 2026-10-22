package mab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f512742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f512743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<RruleListItem> f512744c;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f512745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f512746b;

        public a() {
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f512744c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return ((RruleListItem) ListProtector.get(this.f512744c, r100)).getDisplayText();
    }

    public e(List<RruleListItem> r100, int r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "rruleList");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f512742a = r101;
        this.f512743b = r102;
        ArrayList<RruleListItem> r103 = new ArrayList();
        r103.addAll(r100);
        this.f512744c = r103;
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r102, "parent");
        if (r101 != null) goto L5;
        a r103 = new a();
        View r104 = LayoutInflater.from(this.f512743b).inflate(R.layout.item_choose_repeat, null, true);
        r103.f512745a = (TextView) r104.findViewById(R.id.tv_repeat_desc);
        r103.f512746b = (ImageView) r104.findViewById(R.id.iv_repeat_check_state);
        r104.setTag(r103);
    L6:
        TextView r105 = r103.f512745a;
        if (r105 == null) goto L9;
        r105.setText(((RruleListItem) ListProtector.get(this.f512744c, r100)).getDisplayText());
    L9:
        TextView r106 = r103.f512745a;
        if (r106 == null) goto L12;
        r106.setTextColor(qab.c.a(this.f512743b, R.color.text_title));
    L12:
        ImageView r107 = r103.f512746b;
        if (r107 == null) goto L16;
        r107.setVisibility(8);
    L16:
        if (this.f512742a != r100) goto L23;
        TextView r108 = r103.f512745a;
        if (r108 == null) goto L20;
        r108.setTextColor(qab.c.a(this.f512743b, R.color.function_info_content_default));
    L20:
        ImageView r109 = r103.f512746b;
        if (r109 == null) goto L23;
        r109.setVisibility(0);
    L23:
        return r104;
    L5:
        Object r110 = r101.getTag();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.custom.repeat.adapter.RepeatAdapter.ViewHolder");
        a r111 = (a) r110;
        r104 = r101;
        r103 = r111;
        goto L6
    }
}
