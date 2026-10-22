package tv4;

import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.AntiScreenshotsViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public final InterfaceC0299a a;
    public final String b;
    public MutableLiveData<Integer> c;
    public final b d;

    /* JADX INFO: renamed from: tv4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0299a {
        FragmentActivity getActivity();

        Dialog getDialog();
    }

    public final void a() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L8;
        MutableLiveData<Integer> r1 = ((AntiScreenshotsViewModel) new ViewModelProvider(r0).get(AntiScreenshotsViewModel.class)).getEnableScreenshotsLivaData();
        this.c = r1;
        if (r1 == null) goto L9;
        r1.observe(r0, this.d);
        return;
    L9:
        return;
    }

    public a(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "contextGetter");
        this.a = r2;
        this.b = "AntiScreenshotsDelegate#";
        this.d = new b(this);
    }

    public final void b(int r8) {
        Dialog r0 = this.a.getDialog();
        String r1 = this.b;
        StringBuilder r2 = new StringBuilder("setScreenshotsEnable()... level = ");
        int r3 = AntiScreenshotsViewModel.a.a;
        if (r8 == 0) goto L9;
        if (r8 == 1) goto L8;
        if (r8 == 2) goto L7;
        String r5 = "UNKNOWN";
    L10:
        r2.append(r5);
        r2.append(", dialog = null? ");
        boolean r6 = false;
        if (r0 != null) goto L13;
        boolean r7 = true;
    L14:
        r2.append(r7);
        r2.append(", window = null? ");
        if (r0 == null) goto L17;
        Window r9 = r0.getWindow();
    L18:
        if (r9 != null) goto L20;
        r6 = true;
    L20:
        r2.append(r6);
        tt5.a.h(r1, r2.toString());
        if (r0 != null) goto L23;
        return;
    L23:
        if (r0.getWindow() != null) goto L26;
        return;
    L26:
        if (r8 == 0) goto L50;
        if (r8 == 1) goto L34;
        if (r8 != 2) goto L60;
        Window r10 = r0.getWindow();
        if (r10 == null) goto L33;
        r10.addFlags(8192);
    L33:
        tt5.a.h(this.b, "setScreenshotsEnable FROM_GLOBAL addFlags");
        return;
    L60:
        return;
    L34:
        d r11 = (d) this;
        com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a r4 = r11.e;
        if ((r4 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a) == true) goto L37;
    L44:
        Dialog r12 = r11.e.getDialog();
        if (r12 == null) goto L49;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L49;
        r13.clearFlags(8192);
    L49:
        tt5.a.h("DialogFragmentAntiScreenshotsDelegate", "setScreenshotsEnableFromDocument FROM_DOCUMENT clearFlags");
        return;
    L37:
        if (r4.Cl() == false) goto L44;
        Dialog r14 = r11.e.getDialog();
        if (r14 == null) goto L43;
        Window r16 = r14.getWindow();
        if (r16 == null) goto L43;
        r16.addFlags(8192);
    L43:
        tt5.a.h("DialogFragmentAntiScreenshotsDelegate", "setScreenshotsEnableFromDocument FROM_DOCUMENT addFlags");
        return;
    L50:
        Window r17 = r0.getWindow();
        if (r17 == null) goto L53;
        r17.clearFlags(8192);
    L53:
        tt5.a.h(this.b, "setScreenshotsEnable FROM_GLOBAL clearFlags");
        return;
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = false;
        goto L14
    L7:
        r5 = "PROTECTION_FROM_GLOBAL";
        goto L10
    L8:
        r5 = "PROTECTION_FROM_DOCUMENT";
        goto L10
    L9:
        r5 = "NO_PROTECTION";
        goto L10
    }
}
