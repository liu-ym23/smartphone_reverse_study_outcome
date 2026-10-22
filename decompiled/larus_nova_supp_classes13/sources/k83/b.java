package k83;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.larus.apm.impl.protector.RunnableProtector;
import i83.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ RecyclerView a;

        public a(RecyclerView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.a.isComputingLayout() == true) goto L11;
            RecyclerView.Adapter r0 = this.a.getAdapter();     // Catch: Throwable -> L8
            if (r0 == null) goto L15;
            r0.notifyDataSetChanged();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    public static void a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
    L3:
        if (r2 == null) goto L13;
        if (r2.getClipChildren() != true) goto L19;
        r2.setClipChildren(false);
        if ((r2 instanceof c) == true) goto L20;
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == true) goto L12;
        r3 = null;
    L12:
        r2 = (ViewGroup) r3;
        goto L3
    L20:
        return;
    L19:
        return;
    }

    public static int b(s r1) {
        Intrinsics.checkNotNullParameter(r1, "headAbility");
        AnchorV4HeadV2VO r2 = r1.P70();
        if (r2 == null) goto L7;
        Integer r3 = r2.getBottomHeight();
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L9:
        return com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r4));
    L7:
        r4 = 12;
        goto L9
    }

    public static void c(RecyclerView r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isComputingLayout() == false) goto L6;
        r1.post(new a(r1));
        return;
    L6:
        RecyclerView.Adapter r2 = r1.getAdapter();
        if (r2 == null) goto L12;
        r2.notifyDataSetChanged();
        return;
    }
}
