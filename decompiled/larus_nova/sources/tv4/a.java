package tv4;

import android.app.Dialog;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.AntiScreenshotsViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC7782a f547690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<Integer> f547692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f547693d;

    /* JADX INFO: renamed from: tv4.a$a, reason: collision with other inner class name */
    public interface InterfaceC7782a {
        FragmentActivity getActivity();

        Dialog getDialog();
    }

    public final void a() {
        FragmentActivity r100 = this.f547690a.getActivity();
        if (r100 == null) goto L8;
        MutableLiveData<Integer> r101 = ((AntiScreenshotsViewModel) new ViewModelProvider(r100).get(AntiScreenshotsViewModel.class)).getEnableScreenshotsLivaData();
        this.f547692c = r101;
        if (r101 == null) goto L9;
        r101.observe(r100, this.f547693d);
        return;
    L9:
        return;
    }

    public a(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "contextGetter");
        this.f547690a = r100;
        this.f547691b = "AntiScreenshotsDelegate#";
        this.f547693d = new b(this);
    }

    public final void b(int r100) {
        Dialog r101 = this.f547690a.getDialog();
        String r102 = this.f547691b;
        StringBuilder r103 = new StringBuilder("setScreenshotsEnable()... level = ");
        int r104 = AntiScreenshotsViewModel.a.f216405a;
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L7;
        String r105 = "UNKNOWN";
    L10:
        r103.append(r105);
        r103.append(", dialog = null? ");
        boolean r106 = false;
        if (r101 != null) goto L13;
        boolean r107 = true;
    L14:
        r103.append(r107);
        r103.append(", window = null? ");
        if (r101 == null) goto L17;
        Window r108 = r101.getWindow();
    L18:
        if (r108 != null) goto L20;
        r106 = true;
    L20:
        r103.append(r106);
        tt5.a.h(r102, r103.toString());
        if (r101 != null) goto L23;
        return;
    L23:
        if (r101.getWindow() != null) goto L26;
        return;
    L26:
        if (r100 == 0) goto L50;
        if (r100 == 1) goto L34;
        if (r100 != 2) goto L60;
        Window r109 = r101.getWindow();
        if (r109 == null) goto L33;
        r109.addFlags(8192);
    L33:
        tt5.a.h(this.f547691b, "setScreenshotsEnable FROM_GLOBAL addFlags");
        return;
    L60:
        return;
    L34:
        d r110 = (d) this;
        ActivityResultCaller r111 = r110.f547695e;
        if ((r111 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a) == true) goto L37;
    L44:
        Dialog r112 = r110.f547695e.getDialog();
        if (r112 == null) goto L49;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L49;
        r113.clearFlags(8192);
    L49:
        tt5.a.h("DialogFragmentAntiScreenshotsDelegate", "setScreenshotsEnableFromDocument FROM_DOCUMENT clearFlags");
        return;
    L37:
        if (((com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a) r111).Cl() == false) goto L44;
        Dialog r114 = r110.f547695e.getDialog();
        if (r114 == null) goto L43;
        Window r115 = r114.getWindow();
        if (r115 == null) goto L43;
        r115.addFlags(8192);
    L43:
        tt5.a.h("DialogFragmentAntiScreenshotsDelegate", "setScreenshotsEnableFromDocument FROM_DOCUMENT addFlags");
        return;
    L50:
        Window r116 = r101.getWindow();
        if (r116 == null) goto L53;
        r116.clearFlags(8192);
    L53:
        tt5.a.h(this.f547691b, "setScreenshotsEnable FROM_GLOBAL clearFlags");
        return;
    L17:
        r108 = null;
        goto L18
    L13:
        r107 = false;
        goto L14
    L7:
        r105 = "PROTECTION_FROM_GLOBAL";
        goto L10
    L8:
        r105 = "PROTECTION_FROM_DOCUMENT";
        goto L10
    L9:
        r105 = "NO_PROTECTION";
        goto L10
    }
}
