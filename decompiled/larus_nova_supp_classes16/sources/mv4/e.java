package mv4;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends g implements View.OnClickListener {
    public final String c;
    public boolean d;
    public BitableAnalytic e;
    public Uri f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            this.a.d = true;
        L5:
            this.a.f();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.c, "get exception while check workbench status " + ((Throwable) r4).getMessage());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L8:
            this.a.getClass();
            Toast.showFailureText(eu5.b.a, 2131887802);
            return;
        L6:
            if (r3.intValue() != 0) goto L8;
            this.a.getClass();
            Toast.showSuccessText(eu5.b.a, 2131886821);
            e r4 = this.a;
            r4.d = true;
            r4.f();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            tt5.a.d(this.a.c, "exception message is " + r7.getMessage());
            BitableAnalytic r1 = null;
            if ((r7 instanceof NetService.ServerErrorException) == false) goto L5;
            NetService.ServerErrorException r8 = (NetService.ServerErrorException) r7;
        L6:
            if (r8 == null) goto L8;
            int r9 = r8.getCode();
        L10:
            if (r9 != 800004109) goto L17;
            this.a.getClass();
            Toast.showFailureText(eu5.b.a, 2131886826);
            BitableAnalytic r10 = this.a.e;
            if (r10 == null) goto L14;
            r1 = r10;
        L15:
            r1.getClass();
            HashMap r11 = new HashMap();
            r11.put("subType", "reach_limit");
            r1.t("ccm_bitable_add_to_workplace_toast_view", r11);
            return;
        L14:
            Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
            goto L15
        L17:
            if (r9 != 80004110) goto L23;
            this.a.getClass();
            Toast.showFailureText(eu5.b.a, 2131886822);
            BitableAnalytic r12 = this.a.e;
            if (r12 == null) goto L21;
            r1 = r12;
        L22:
            r1.getClass();
            HashMap r13 = new HashMap();
            r13.put("subType", "not_included_module");
            r1.t("ccm_bitable_add_to_workplace_toast_view", r13);
            return;
        L21:
            Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
            goto L22
        L23:
            this.a.getClass();
            Toast.showFailureText(eu5.b.a, 2131887802);
            return;
        L8:
            r9 = -1;
            goto L10
        L5:
            r8 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: mv4.e$e, reason: collision with other inner class name */
    public static final class C0256e<T> implements Consumer {
        public final /* synthetic */ e a;

        public C0256e(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() != 0) goto L9;
            this.a.d = false;
            Toast.showSuccessText(eu5.b.a, 2131886823);
            this.a.f();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ e a;

        public f(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.c, "remove from brench with exception " + ((Throwable) r4).getMessage());
            this.a.getClass();
            Toast.showFailureText(eu5.b.a, 2131886822);
        }
    }

    public final k a() {
        com.bytedance.ee.bear.more.protocol3.f.c r1 = new com.bytedance.ee.bear.more.protocol3.f.c(this.d);
        com.bytedance.ee.bear.more.protocol3.e.f r2 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
        sbb.e r8 = sbb.e.i;
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        List r4 = CollectionsKt.listOf(new j[]{new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{r8}), new BizChecker(r7.g("ccm.bitable.file_add_to_workbench"))});
        j[] r5 = new j[3];
        r5[0] = new BizChecker(r7.g("ccm.bitable.file_add_to_workbench"));
        oj5.c r9 = c();
        if (r9 == null) goto L5;
        boolean r10 = r9.m();
    L6:
        r5[1] = new BizChecker(!r10);
        r5[2] = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{r8});
        return h(r1, r2, r4, CollectionsKt.listOf(r5), this);
    L5:
        r10 = false;
        goto L6
    }

    public e() {
        this.c = "AddToWorkBenchItem";
    }

    public final void create() {
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        Uri r1 = UriProtector.parse(r0.getUrl());
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.f = r1;
        BitableAnalytic r2 = new BitableAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), p.a().Z(r0.getUrl()), null));
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
        if (r0.getType() != 8) goto L9;
        int r3 = mv4.d.a;
        String r4 = r0.getToken();
        Intrinsics.checkNotNullParameter(r4, "token");
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        NetService.f r6 = new NetService.f(String.format("/space/api/bitable/%s/workbench/status", Arrays.copyOf(new Object[]{r4}, 1)));
        r6.c = 2;
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new mv4.f()).a(r6).map(mv4.b.a).subscribe(new a(this), new b(this));
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        oj5.c r14 = c();
        if (r14 != null) goto L5;
        return;
    L5:
        BitableAnalytic r0 = this.e;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
        r0 = null;
    L9:
        boolean r2 = !this.d;
        r0.getClass();
        HashMap r4 = new HashMap();
        if (r2 == false) goto L12;
        r4.put("click", "add_to_workplace");
    L13:
        r0.t("ccm_space_docs_more_menu_click", r4);
        if (this.d == true) goto L41;
        Uri r1 = this.f;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        r1 = null;
    L19:
        if (r1 == null) goto L22;
        String r3 = UriProtector.getQueryParameter(r1, "table");
        if (r3 == null) goto L22;
    L23:
        Uri r8 = this.f;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        r8 = null;
    L27:
        if (r8 == null) goto L30;
        String r7 = UriProtector.getQueryParameter(r8, "view");
        if (r7 == null) goto L30;
    L32:
        if (TextUtils.isEmpty(StringsKt.trim(r14.getTitle()).toString()) == false) goto L34;
        String r9 = eu5.b.a.getString(2131888006);
    L35:
        Intrinsics.checkNotNull(r9);
        int r10 = mv4.d.a;
        String r16 = r14.getToken();
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r16, "token");
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        String r5 = String.format("/space/api/bitable/workbench/%s/add", Arrays.copyOf(new Object[]{r16}, 1));
        AccountService$Account r12 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        NetService.f r17 = new NetService.f(r5);
        r17.c = 1;
        JSONObject r6 = new JSONObject();
        r6.put("token", r16);
        if (r3 == null) goto L38;
        r6.put("tableId", r3);
    L38:
        if (r7 == null) goto L40;
        r6.put("viewId", r7);
    L40:
        r6.put("uid", r12.uid);
        r6.put("name", r9);
        r17.j = r6.toString();
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r17).map(mv4.a.a).subscribe(new c(this), new d(this));
    L42:
        sj5.b r18 = getHost();
        if (r18 == null) goto L46;
        r18.a();
        return;
    L46:
        return;
    L34:
        r9 = r14.getTitle();
    L30:
        r7 = null;
    L22:
        r3 = null;
        goto L23
    L41:
        int r19 = mv4.d.a;
        String r110 = r14.getToken();
        Intrinsics.checkNotNullParameter(r110, "token");
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        String r21 = String.format("/space/api/bitable/workbench/%s/remove", Arrays.copyOf(new Object[]{r110}, 1));
        AccountService$Account r22 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        NetService.f r23 = new NetService.f(r21);
        r23.c = 1;
        JSONObject r24 = new JSONObject();
        r24.put("token", r110);
        r24.put("uid", r22.uid);
        r23.j = r24.toString();
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r23).map(mv4.c.a).subscribe(new C0256e(this), new f(this));
        goto L42
    L12:
        r4.put("click", "remove_from_workplace");
        goto L13
    }
}
