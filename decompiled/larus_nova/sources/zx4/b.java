package zx4;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yx4.f;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements yx4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpaceEmptyState f573882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f573883b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f573884a;

        public a(f r100) {
            this.f573884a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f573884a.f569414f;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public b() {
    }

    @Override // yx4.c
    public final void hideError() {
    }

    @Override // yx4.c
    public final void a(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_default_error, r100, true);
        this.f573882a = (SpaceEmptyState) r101.findViewById(R.id.facade_no_data_empty_state);
        this.f573883b = (TextView) r101.findViewById(R.id.err_code);
    }

    @Override // yx4.c
    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "officeErrorInfo");
        SpaceEmptyState r101 = this.f573882a;
        if (r101 == null) goto L5;
        r101.setImageRes(Integer.valueOf(r100.f569410b));
    L5:
        SpaceEmptyState r102 = this.f573882a;
        if (r102 == null) goto L8;
        r102.setDesc(r100.f569409a);
    L8:
        SpaceEmptyState r103 = this.f573882a;
        int r104 = 0;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        SpaceEmptyState r105 = this.f573882a;
        if (r105 == null) goto L14;
        r105.setPrimaryText(r100.f569412d);
    L14:
        TextView r106 = this.f573883b;
        if (r106 == null) goto L17;
        r106.setText(r100.f569413e);
    L17:
        TextView r107 = this.f573883b;
        if (r107 == null) goto L29;
        String r108 = r100.f569413e;
        if (r108 != null) goto L22;
    L25:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L28;
        r104 = 8;
    L28:
        r107.setVisibility(r104);
        goto L29
    L22:
        if (r108.length() == 0) goto L25;
        r109 = false;
    L29:
        SpaceEmptyState r110 = this.f573882a;
        if (r110 == null) goto L33;
        r110.setPrimaryClickListener(new a(r100));
        return;
    }
}
