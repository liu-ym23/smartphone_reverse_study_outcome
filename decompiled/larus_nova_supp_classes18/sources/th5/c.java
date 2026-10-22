package th5;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.external.AdjustExternalResult;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.secret.p;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements th5.a {
    public String a;
    public String b;
    public int c;
    public boolean d;
    public WeakReference<Activity> e;
    public final CompositeDisposable f;
    public th5.d g;

    public static final class a {
    }

    public static final class b {
        public final VisibleSecretResult a;
        public final DocPermission b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "SecretAndPermissionResult(secretResult=" + this.a + ", docPermission=" + this.b + ')';
        }

        public b(VisibleSecretResult r2, DocPermission r3) {
            Intrinsics.checkNotNullParameter(r2, "secretResult");
            Intrinsics.checkNotNullParameter(r3, "docPermission");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: th5.c$c, reason: collision with other inner class name */
    public static final class C0311c<T1, T2, R> implements BiFunction {
        public static final C0311c<T1, T2, R> a = null;

        static {
            a = new C0311c();
        }

        public C0311c() {
        }

        public final Object apply(Object r2, Object r3) {
            VisibleSecretResult r4 = (VisibleSecretResult) r2;
            DocPermission r5 = (DocPermission) r3;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter(r5, "t2");
            return new b(r4, r5);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ Activity b;

        public d(c r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r14) {
            b r15 = (b) r14;
            tt5.a.h("DocExternalPanelHandler", "fetchVisibleSecretAndPermission success, visibleSecretResult = " + ((Result) r15.a).data + ", userPermission = " + r15.b.a.getReportJson() + ", publicPermission = " + r15.b.b.getReportJson());
            Toast.cancelLoading();
            c r0 = this.a;
            Activity r3 = this.b;
            Intrinsics.checkNotNull(r15);
            r0.getClass();
            tt5.a.h("DocExternalPanelHandler", "showAdjustExternalPanel()...");
            SceneType r7 = SceneType.CALENDER_DOC_CARD;
            String r4 = r0.b;
            int r5 = r0.c;
            boolean r6 = r0.d;
            int r9 = r15.b.a.getShareExternal();
            int r10 = r15.b.a.getSharePartnerTenant();
            DocPermission r16 = r15.b;
            HashMap r11 = new HashMap();
            r11.put("file_id", du5.b.g(r0.b));
            r11.put("file_type", sbb.e.f(r0.c));
            r11.put("app_form", "none");
            r11.put("sub_file_type", "");
            r11.put("module", "");
            r11.put("user_permission", r16.a.getReportJson());
            r11.put("file_permission", r16.b.getReportJson());
            if (r16.b.isOwner() == false) goto L5;
            String r17 = "true";
        L6:
            r11.put("is_owner", r17);
            th5.b r1 = new th5.b(r3, r4, r5, r6, r7, null, r9, r10, r11);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
            j.j = new WeakReference(r0);
            ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).Ee(r1);
            return;
        L5:
            r17 = "false";
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Activity a;

        public e(Activity r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.d("DocExternalPanelHandler", "fetchVisibleSecretAndPermission failed, error = " + ((Throwable) r3));
            Toast.cancelLoading();
            Activity r4 = this.a;
            Toast.showFailureText(r4, r4.getString(2131887133));
        }
    }

    static {
    }

    public final void a() {
        tt5.a.h("DocExternalPanelHandler", "fetchUsableSecretList()...");
        WeakReference<Activity> r0 = this.e;
        if (r0 == null) goto L11;
        Activity r1 = r0.get();
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.f.isDisposed() == true) goto L9;
        this.f.clear();
    L9:
        Toast.showLoading(r1, r1.getString(2131887769));
        j r2 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r4 = this.b;
        int r5 = this.c;
        r2.getClass();
        Disposable r3 = Flowable.zip(p.a(r4, r5), ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(this.b, this.c), C0311c.a).subscribe(new d(this, r1), new e(r1));
        this.f.add(r3);
        return;
    }

    public c() {
        this.a = "";
        this.b = "";
        this.f = new CompositeDisposable();
    }

    @Override // th5.a
    public final void rU(int r3) {
        tt5.a.h("DocExternalPanelHandler", "onAdjustFinished()...result = " + r3);
        if (r3 == AdjustExternalResult.SUCCESS.getValue()) goto L7;
        if (r3 == AdjustExternalResult.FAIL.getValue()) goto L7;
        return;
    L7:
        if (this.g == null) goto L11;
        CCMApiImpl.b(r3);
        return;
    }

    @Override // th5.a
    public final void QQ(qe5.e.c r12, qe5.e.b r13, SecretApprovalInstanceModel r14, SecretApprovalDefModel r15, SecretLevel r16, SecretLevel r17) {
        Intrinsics.checkNotNullParameter(r14, "secretApprovalInstanceModel");
        Intrinsics.checkNotNullParameter(r15, "secretApprovalDefModel");
        Intrinsics.checkNotNullParameter(r16, "targetSecretLevel");
        Intrinsics.checkNotNullParameter(r17, "originSecretLevel");
        tt5.a.h("DocExternalPanelHandler", "notifyShowSecLabelResubmitApprovalDialog()...");
        WeakReference<Activity> r1 = this.e;
        if (r1 == null) goto L10;
        FragmentActivity r2 = (Activity) r1.get();
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof FragmentActivity) == false) goto L12;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).l5(r2, this.c, r12, r13, r14, r15, r16, r17);
        return;
    L12:
        return;
    }

    @Override // th5.a
    public final void sJ(String r15, int r16, String r17, String r18, int r19, String r20, String r21, SecretLevel r22, SecretApprovalDefModel r23, Map<String, ? extends Serializable> r24, SecretLevel r25) {
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "secLabelId");
        Intrinsics.checkNotNullParameter(r18, "secLabelName");
        Intrinsics.checkNotNullParameter(r20, "applyTips");
        Intrinsics.checkNotNullParameter(r21, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r22, "oldSecretLevel");
        Intrinsics.checkNotNullParameter(r23, "defModel");
        tt5.a.h("DocExternalPanelHandler", "notifyShowSecretApprovalDialog()...");
        WeakReference<Activity> r1 = this.e;
        if (r1 == null) goto L10;
        FragmentActivity r2 = (Activity) r1.get();
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof FragmentActivity) == false) goto L12;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).ad(r2, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        return;
    L12:
        return;
    }
}
