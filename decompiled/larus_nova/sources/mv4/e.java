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
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.larus.trace.CopyContentTypeString;
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

/* JADX INFO: loaded from: classes16.dex */
public final class e extends g implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f515883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableAnalytic f515884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Uri f515885f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515886a;

        public a(e r100) {
            this.f515886a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            this.f515886a.f515883d = true;
        L5:
            this.f515886a.f();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515887a;

        public b(e r100) {
            this.f515887a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d(this.f515887a.f515882c, "get exception while check workbench status " + ((Throwable) r100).getMessage());
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515888a;

        public c(e r100) {
            this.f515888a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L8:
            this.f515888a.getClass();
            Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_OperateFailed);
            return;
        L6:
            if (r101.intValue() != 0) goto L8;
            this.f515888a.getClass();
            Toast.showSuccessText(eu5.b.f474075a, R.string.Bitable_ShareToWorkplace_AddedToWorkplace_Toast);
            e r102 = this.f515888a;
            r102.f515883d = true;
            r102.f();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515889a;

        public d(e r100) {
            this.f515889a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d(this.f515889a.f515882c, "exception message is " + r101.getMessage());
            BitableAnalytic r102 = null;
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L5;
            NetService.ServerErrorException r103 = (NetService.ServerErrorException) r101;
        L6:
            if (r103 == null) goto L8;
            int r104 = r103.getCode();
        L10:
            if (r104 != 800004109) goto L17;
            this.f515889a.getClass();
            Toast.showFailureText(eu5.b.f474075a, R.string.Bitable_ShareToWorkplace_WorkplaceExceededLimit_Toast);
            BitableAnalytic r105 = this.f515889a.f515884e;
            if (r105 == null) goto L14;
            r102 = r105;
        L15:
            r102.getClass();
            HashMap r106 = new HashMap();
            r106.put("subType", "reach_limit");
            r102.t(BitableAnalytic.AddToWorkBenchEvent.BITABLE_ADD_WORKPLACE_TOAST_VIEW, r106);
            return;
        L14:
            Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
            goto L15
        L17:
            if (r104 != 80004110) goto L23;
            this.f515889a.getClass();
            Toast.showFailureText(eu5.b.f474075a, R.string.Bitable_ShareToWorkplace_NoMyFavoritesYet_Toast);
            BitableAnalytic r107 = this.f515889a.f515884e;
            if (r107 == null) goto L21;
            r102 = r107;
        L22:
            r102.getClass();
            HashMap r108 = new HashMap();
            r108.put("subType", "not_included_module");
            r102.t(BitableAnalytic.AddToWorkBenchEvent.BITABLE_ADD_WORKPLACE_TOAST_VIEW, r108);
            return;
        L21:
            Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
            goto L22
        L23:
            this.f515889a.getClass();
            Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_OperateFailed);
            return;
        L8:
            r104 = -1;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: mv4.e$e, reason: collision with other inner class name */
    public static final class C6859e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515890a;

        public C6859e(e r100) {
            this.f515890a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != 0) goto L9;
            this.f515890a.f515883d = false;
            Toast.showSuccessText(eu5.b.f474075a, R.string.Bitable_ShareToWorkplace_RemovedFromWorkplace_Toast);
            this.f515890a.f();
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f515891a;

        public f(e r100) {
            this.f515891a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d(this.f515891a.f515882c, "remove from brench with exception " + ((Throwable) r100).getMessage());
            this.f515891a.getClass();
            Toast.showFailureText(eu5.b.f474075a, R.string.Bitable_ShareToWorkplace_NoMyFavoritesYet_Toast);
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        com.bytedance.ee.bear.more.protocol3.f.c r100 = new com.bytedance.ee.bear.more.protocol3.f.c(this.f515883d);
        com.bytedance.ee.bear.more.protocol3.e.f r101 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
        sbb.e r102 = sbb.e.f541298i;
        com.bytedance.ee.bear.appsetting.c r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        List<? extends m> r104 = CollectionsKt.listOf(new j[]{new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{r102}), new BizChecker(r103.g("ccm.bitable.file_add_to_workbench"))});
        j[] r105 = new j[3];
        r105[0] = new BizChecker(r103.g("ccm.bitable.file_add_to_workbench"));
        oj5.c r106 = c();
        if (r106 == null) goto L5;
        boolean r107 = r106.m();
    L6:
        r105[1] = new BizChecker(!r107);
        r105[2] = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{r102});
        return h(r100, r101, r104, CollectionsKt.listOf(r105), this);
    L5:
        r107 = false;
        goto L6
    }

    public e() {
        this.f515882c = "AddToWorkBenchItem";
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void create() {
        oj5.c r100 = c();
        if (r100 != null) goto L5;
        return;
    L5:
        Uri r101 = UriProtector.parse(r100.getUrl());
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f515885f = r101;
        BitableAnalytic r102 = new BitableAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), p.a().Z(r100.getUrl()), null));
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f515884e = r102;
        if (r100.getType() != 8) goto L9;
        int r103 = mv4.d.f515881a;
        String r104 = r100.getToken();
        Intrinsics.checkNotNullParameter(r104, "token");
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        NetService.f r106 = new NetService.f(String.format("/space/api/bitable/%s/workbench/status", Arrays.copyOf(new Object[]{r104}, 1)));
        r106.f216906c = 2;
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new mv4.f()).a(r106).map(mv4.b.f515879a).subscribe(new a(this), new b(this));
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        oj5.c r111 = c();
        if (r111 != null) goto L5;
        return;
    L5:
        BitableAnalytic r100 = this.f515884e;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mBitableAnalytic");
        r100 = null;
    L9:
        boolean r101 = !this.f515883d;
        r100.getClass();
        HashMap r102 = new HashMap();
        if (r101 == false) goto L12;
        r102.put("click", "add_to_workplace");
    L13:
        r100.t("ccm_space_docs_more_menu_click", r102);
        if (this.f515883d == true) goto L41;
        Uri r103 = this.f515885f;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        r103 = null;
    L19:
        if (r103 == null) goto L22;
        String r104 = UriProtector.getQueryParameter(r103, CopyContentTypeString.TABLE);
        if (r104 == null) goto L22;
    L23:
        Uri r105 = this.f515885f;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        r105 = null;
    L27:
        if (r105 == null) goto L30;
        String r106 = UriProtector.getQueryParameter(r105, "view");
        if (r106 == null) goto L30;
    L32:
        if (TextUtils.isEmpty(StringsKt.trim(r111.getTitle()).toString()) == false) goto L34;
        String r107 = eu5.b.f474075a.getString(R.string.Doc_List_UntitledBitable);
    L35:
        Intrinsics.checkNotNull(r107);
        int r108 = mv4.d.f515881a;
        String r112 = r111.getToken();
        Intrinsics.checkNotNullParameter(r107, "name");
        Intrinsics.checkNotNullParameter(r112, "token");
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r109 = String.format("/space/api/bitable/workbench/%s/add", Arrays.copyOf(new Object[]{r112}, 1));
        AccountService$Account r114 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        NetService.f r115 = new NetService.f(r109);
        r115.f216906c = 1;
        JSONObject r116 = new JSONObject();
        r116.put("token", r112);
        if (r104 == null) goto L38;
        r116.put("tableId", r104);
    L38:
        if (r106 == null) goto L40;
        r116.put("viewId", r106);
    L40:
        r116.put("uid", r114.uid);
        r116.put("name", r107);
        r115.f216913j = r116.toString();
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r115).map(mv4.a.f515878a).subscribe(new c(this), new d(this));
    L42:
        sj5.b r117 = getHost();
        if (r117 == null) goto L46;
        r117.a();
        return;
    L46:
        return;
    L34:
        r107 = r111.getTitle();
    L30:
        r106 = null;
    L22:
        r104 = null;
        goto L23
    L41:
        int r118 = mv4.d.f515881a;
        String r119 = r111.getToken();
        Intrinsics.checkNotNullParameter(r119, "token");
        StringCompanionObject r120 = StringCompanionObject.INSTANCE;
        String r121 = String.format("/space/api/bitable/workbench/%s/remove", Arrays.copyOf(new Object[]{r119}, 1));
        AccountService$Account r122 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        NetService.f r123 = new NetService.f(r121);
        r123.f216906c = 1;
        JSONObject r124 = new JSONObject();
        r124.put("token", r119);
        r124.put("uid", r122.uid);
        r123.f216913j = r124.toString();
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r123).map(mv4.c.f515880a).subscribe(new C6859e(this), new f(this));
        goto L42
    L12:
        r102.put("click", "remove_from_workplace");
        goto L13
    }
}
