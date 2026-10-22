package a04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationLayout;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<n, o> {
    public LinearLayout e;
    public DiggAnimationLayout f;
    public TextView g;

    public static final class a extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ m d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((n) this.d.b).a.b(Unit.INSTANCE);
        }

        public a(m r1) {
            this.d = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.e = (LinearLayout) b().findViewById(2131369103);
        this.f = (DiggAnimationLayout) b().findViewById(2131369088);
        this.g = (TextView) b().findViewById(2131369093);
        DiggAnimationLayout r0 = this.f;
        LinearLayout r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("diggAnimationLayout");
        r0 = null;
    L6:
        if (r0.a.containsKey(r0.getType()) == true) goto L11;
        String r2 = r0.getType();
        if (r2 != null) goto L10;
        r2 = "common";
    L10:
        r0.a(r2);
    L11:
        Iterator<Map.Entry<String, View>> r3 = r0.a.entrySet().iterator();
        boolean r5 = false;
    L13:
        if (r3.hasNext() == false) goto L18;
        Map.Entry<String, View> r6 = r3.next();
        if (Intrinsics.areEqual(r6.getKey(), r0.getType()) == true) goto L16;
        r6.getValue().setVisibility(8);
        goto L13
    L16:
        r6.getValue().setVisibility(0);
        r6.getValue().setSelected(r0.isSelected());
        r5 = true;
        goto L13
    L18:
        if (r5 == true) goto L24;
        r0.a.size();
        r0.a("common");
        View r4 = r0.a.get("common");
        if (r4 == null) goto L24;
        r4.setVisibility(0);
    L24:
        LinearLayout r7 = this.e;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("diggContainer");
    L28:
        r1.setOnClickListener(new a(this));
        o r8 = (o) this.c;
        Observer<Boolean> r9 = new j(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.a.a(r9);
        o r10 = (o) this.c;
        Observer<Boolean> r11 = new k(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "observer");
        r10.c.a(r11);
        o r12 = (o) this.c;
        Observer<Long> r13 = new l(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "observer");
        r12.b.a(r13);
        return;
    L27:
        r1 = r7;
        goto L28
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558611, r4, false);
    }

    public m(Context r2, n r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
