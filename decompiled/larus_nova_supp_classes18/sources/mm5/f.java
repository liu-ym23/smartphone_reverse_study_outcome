package mm5;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends e0 {
    public final View b;
    public final boolean c;
    public final View.OnClickListener d;
    public final View.OnClickListener e;
    public final String f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ View b;

        public a(f r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (TextUtils.isEmpty(this.a.f) == true) goto L6;
            Toast.showFailureText(this.b.getContext(), this.a.f);
            return;
        L6:
            View.OnClickListener r3 = this.a.d;
            if (r3 == null) goto L10;
            r3.onClick(null);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public b(View.OnClickListener r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.onClick(null);
        }
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ViewGroup.LayoutParams r4 = new ViewGroup.LayoutParams(-1, -2);
        this.b.setLayoutParams(r4);
        return this.b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final boolean d(e0 r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof f) == false) goto L13;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L13;
        if (Intrinsics.areEqual(this.b, r4.b) == false) goto L13;
        if (this.c != r4.c) goto L13;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r2, "itemView");
        if (this.c == true) goto L6;
        r2.setAlpha(0.3f);
        r2.setOnClickListener(new a(this, r2));
        return;
    L6:
        r2.setAlpha(1.0f);
        r2.setEnabled(true);
        r2.setOnClickListener(null);
        View.OnClickListener r4 = this.e;
        if (r4 == null) goto L10;
        r2.setOnClickListener(new b(r4));
        return;
    }

    public f(String r2, View r3, boolean r4, View.OnClickListener r5, View.OnClickListener r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
