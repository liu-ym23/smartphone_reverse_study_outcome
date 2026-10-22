package xib;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class e<Data extends SearchBaseInfo> extends a<Data, RecentForwardViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecentForwardAdapterV3.b f564013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecentForwardAdapterV3.a f564014c;

    public abstract void b(SearchBaseInfo r100, RecentForwardViewHolder r101);

    public e(RecentForwardAdapterV3.b r100, RecentForwardAdapterV3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r101, "onItemBusinessConsumeClickListener");
        this.f564013b = r100;
        this.f564014c = r101;
    }

    public final void a(int r100, Data r101, RecentForwardViewHolder r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = r102.f425518d;
        if (r103 == null) goto L5;
        r103.setText(r101.getTitle());
    L5:
        UDCheckBox r104 = r102.f425517c;
        if (r104 != null) goto L8;
    L12:
        UDCheckBox r105 = r102.f425517c;
        if (r105 == null) goto L15;
        r105.setChecked(r101.isSelected());
    L15:
        b(r101, r102);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "holder");
        LinearLayout r106 = r102.f425520f;
        if (r106 == null) goto L19;
        r106.setOnClickListener(new d(this, r101, r100));
        return;
    L19:
        return;
    L8:
        if (this.f564006a == false) goto L10;
        int r107 = 0;
    L11:
        r104.setVisibility(r107);
        goto L12
    L10:
        r107 = 8;
        goto L11
    }

    public final void c(SearchBaseInfo r100, RecentForwardViewHolder r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r103.next(), "view_checkbox") == false) goto L4;
        UDCheckBox r104 = r101.f425517c;
        if (r104 != null) goto L10;
    L14:
        UDCheckBox r105 = r101.f425517c;
        if (r105 == null) goto L4;
        r105.setChecked(r100.isSelected());
        goto L4
    L10:
        if (this.f564006a == false) goto L12;
        int r106 = 0;
    L13:
        r104.setVisibility(r106);
        goto L14
    L12:
        r106 = 8;
        goto L13
    }
}
