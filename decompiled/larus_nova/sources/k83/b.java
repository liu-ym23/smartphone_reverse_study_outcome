package k83;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.larus.apm.impl.protector.RunnableProtector;
import i83.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502093a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f502094a;

        public a(RecyclerView r100) {
            this.f502094a = r100;
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
            if (this.f502094a.isComputingLayout() == true) goto L11;
            RecyclerView.Adapter r100 = this.f502094a.getAdapter();     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.notifyDataSetChanged();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    public static void a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
    L3:
        if (r100 == null) goto L13;
        if (r100.getClipChildren() != true) goto L19;
        r100.setClipChildren(false);
        if ((r100 instanceof c) == true) goto L20;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L12;
        r101 = null;
    L12:
        r100 = (ViewGroup) r101;
        goto L3
    L20:
        return;
    L19:
        return;
    }

    public static int b(s r100) {
        Intrinsics.checkNotNullParameter(r100, "headAbility");
        AnchorV4HeadV2VO r101 = r100.P70();
        if (r101 == null) goto L7;
        Integer r102 = r101.getBottomHeight();
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L9:
        return com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r103));
    L7:
        r103 = 12;
        goto L9
    }

    public static void c(RecyclerView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isComputingLayout() == false) goto L6;
        r100.post(new a(r100));
        return;
    L6:
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L12;
        r101.notifyDataSetChanged();
        return;
    }
}
