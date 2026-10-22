package ol5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.quoto.cta.CTAStatusViewModel;
import com.bytedance.ee.bear.quoto.cta.DriveCTAQuotaConfig;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static long a;
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: ol5.a$a, reason: collision with other inner class name */
    public static final class C0282a implements goc.a {
        public final /* synthetic */ CTAStatusViewModel a;
        public final /* synthetic */ DialogInterface.OnDismissListener b;
        public final /* synthetic */ FragmentActivity c;
        public final /* synthetic */ View.OnClickListener d;

        public final void onDismiss() {
            this.a.isCTAShown().postValue(Boolean.FALSE);
            DialogInterface.OnDismissListener r0 = this.b;
            if (r0 == null) goto L6;
            r0.onDismiss(new Dialog(this.c));
            return;
        }

        public final void onShow() {
            this.a.isCTAShown().postValue(Boolean.TRUE);
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "buttonTag");
            View.OnClickListener r4 = this.d;
            if (r4 == null) goto L6;
            r4.onClick(new View(this.c));
            return;
        }

        public final void onError(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.isCTAShown().postValue(Boolean.TRUE);
        }

        public C0282a(CTAStatusViewModel r1, DialogInterface.OnDismissListener r2, FragmentActivity r3, View.OnClickListener r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public static void a(FragmentActivity r12, LifecycleOwner r13, DriveCTAQuotaConfig r14, goc.a r15) {
        if ((System.currentTimeMillis() - a) > BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL) goto L6;
        tt5.a.h("DriveCTAWrapper", "return by decoded");
        return;
    L6:
        tt5.a.h("DriveCTAWrapper", "innerShowCTADialog, key=" + r14.getFeatureKey() + ", scene=" + r14.getScene());
        String r7 = r14.getFeatureKey();
        String r8 = r14.getScene();
        String r0 = r14.getCheckpointTenantId();
        if (r0 != null) goto L9;
        String r9 = "0";
    L10:
        String r16 = r14.getCheckpointUserId();
        if (r16 != null) goto L13;
        String r10 = "0";
    L14:
        com.suite.lark.platform.component.cta.a.a(r12, r13, r7, r8, r9, r10, r15);
        a = System.currentTimeMillis();
        return;
    L13:
        r10 = r16;
        goto L14
    L9:
        r9 = r0;
        goto L10
    }

    @JvmStatic
    public static final void b(FragmentActivity r4, LifecycleOwner r5, DriveCTAQuotaConfig r6, View.OnClickListener r7, DialogInterface.OnDismissListener r8) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "config");
        Lifecycle.State r0 = r4.getLifecycle().getCurrentState();
        tt5.a.h("DriveCTAWrapper", "currentState =" + r0);
        if (r0.isAtLeast(Lifecycle.State.RESUMED) == true) goto L14;
        return;
    L14:
        CTAStatusViewModel r1 = (CTAStatusViewModel) new ViewModelProvider(r4).get(CTAStatusViewModel.class);     // Catch: Exception -> L11
        if (Intrinsics.areEqual(r1.isCTAShown().getValue(), Boolean.TRUE) == false) goto L9;
        tt5.a.k("DriveCTAWrapper", "showCTADialogWithInnerCallback cta isShown");     // Catch: Exception -> L11
        return;
    L9:
        a(r4, r5, r6, new C0282a(r1, r8, r4, r7));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.d("DriveCTAWrapper", "showCTADialogWithInnerCallback fail: " + e);
        a(r4, r5, r6, null);
    }
}
