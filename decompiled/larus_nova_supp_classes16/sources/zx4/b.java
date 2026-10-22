package zx4;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yx4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements yx4.c {
    public SpaceEmptyState a;
    public TextView b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public b() {
    }

    @Override // yx4.c
    public final void hideError() {
    }

    @Override // yx4.c
    public final void a(FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "frameLayout");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563302, r4, true);
        this.a = r5.findViewById(2131372043);
        this.b = (TextView) r5.findViewById(2131371737);
    }

    @Override // yx4.c
    public final void b(f r4) {
        Intrinsics.checkNotNullParameter(r4, "officeErrorInfo");
        SpaceEmptyState r0 = this.a;
        if (r0 == null) goto L5;
        r0.setImageRes(Integer.valueOf(r4.b));
    L5:
        SpaceEmptyState r1 = this.a;
        if (r1 == null) goto L8;
        r1.setDesc(r4.a);
    L8:
        SpaceEmptyState r2 = this.a;
        int r3 = 0;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        SpaceEmptyState r5 = this.a;
        if (r5 == null) goto L14;
        r5.setPrimaryText(r4.d);
    L14:
        TextView r6 = this.b;
        if (r6 == null) goto L17;
        r6.setText(r4.e);
    L17:
        TextView r7 = this.b;
        if (r7 == null) goto L29;
        String r8 = r4.e;
        if (r8 != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 == false) goto L28;
        r3 = 8;
    L28:
        r7.setVisibility(r3);
        goto L29
    L22:
        if (r8.length() == 0) goto L25;
        r9 = false;
    L29:
        SpaceEmptyState r10 = this.a;
        if (r10 == null) goto L33;
        r10.setPrimaryClickListener(new a(r4));
        return;
    }
}
