package sq5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements td5.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f542999h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f543000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sq5.a f543003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpaceSelectorBean f543004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f543005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larksuite.component.universe_design.toast.c f543006g;

    public static final class a {
    }

    /* JADX INFO: renamed from: sq5.b$b, reason: collision with other inner class name */
    public static final class C7641b<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7641b<T> f543007a = null;

        static {
            f543007a = new C7641b();
        }

        public C7641b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<TreeNode> parse(String r100) {
            JSONObject r101 = new JSONObject(r100);
            Result<TreeNode> r102 = new Result();
            r102.data = (DATA) GsonProtectorUtils.fromJson(new Gson(), r101.optString("data"), TreeNode.class);
            r102.code = r101.optInt("code");
            r102.msg = r101.optString("msg");
            return r102;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543008a;

        public c(b r100) {
            this.f543008a = r100;
        }

        /* JADX WARN: Type inference failed for: r1v9, types: [T, android.app.Activity] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            tt5.a.h("SpaceMakeCopyToWikiCommand", "execute()...make copy success. wikiToken = " + du5.b.g(((TreeNode) r101.data).wiki_token));
            SpaceSelectorBean r102 = this.f543008a.f543004e;
            if (r102 == null) goto L5;
            Integer r103 = Integer.valueOf(r102.f229385a);
        L6:
            jw4.a.g("copy", r103);
            b r104 = this.f543008a;
            TreeNode r105 = (TreeNode) r101.data;
            r104.getClass();
            Toast.cancelLoading();
            r104.f543003d.ww(null);
            com.bytedance.ee.bear.route.h r106 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            Ref.ObjectRef r107 = new Ref.ObjectRef();
            ?? r108 = (T) r106.getActivity();
            r107.element = r108;
            if (com.bytedance.ee.util.ui.b.a(r108) == false) goto L15;
            Activity r109 = (Activity) r107.element;
            if (r109 != null) goto L11;
            return;
        L11:
            if (AppInfoUtils.f().booleanValue() == false) goto L13;
            Toast.showSuccessText(r109, R.string.Doc_Facade_MakeCopySucceed);
            return;
        L13:
            UDToast.a r110 = UDToast.build(r109);
            r110.f285429b.e(R.string.Doc_Facade_MakeCopySucceed);
            r110.b(R.string.CreationMobile_Doc_Facade_MakeCopySucceed_open_btn, new sq5.c(r105));
            r110.f(new sq5.d(r107, r104));
            com.ss.android.lark.compose.foundation.toast.g r111 = r110.a();
            r104.f543006g = r111;
            r111.show();
            return;
        L15:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543009a;

        public d(b r100) {
            this.f543009a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...make copy failed, error = " + r101);
            SpaceSelectorBean r102 = this.f543009a.f543004e;
            Integer r103 = null;
            if (r102 == null) goto L5;
            Integer r104 = Integer.valueOf(r102.f229385a);
        L6:
            jw4.a.h("copy", r101, r104);
            Toast.cancelLoading();
            Context r105 = this.f543009a.f543000a.getContext();
            if (r105 == null) goto L48;
            b r106 = this.f543009a;
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L11;
            int r107 = ((NetService.ServerErrorException) r101).getCode();
        L13:
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r101, r105) == false) goto L16;
            return;
        L16:
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).p(r101, r105, false) == true) goto L54;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L29;
            ph5.b r108 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            SpaceSelectorBean r109 = r106.f543004e;
            if (r109 == null) goto L23;
            String r110 = r109.f229386b;
        L24:
            if (r109 == null) goto L26;
            r103 = Integer.valueOf(r109.f229385a);
        L26:
            Intrinsics.checkNotNull(r101);
            ErrorResponse r111 = r108.e(r110, r103, "CREATE_COPY", r101);
            if (r111.getHasHandledUiAction() == false) goto L37;
            r111.getCallback().a(r105, r111);
            return;
        L37:
            int r112 = b.f542999h;
            if (r107 != 4000080) goto L40;
        L46:
            Toast.showFailureText(r105, R.string.CreationMobile_Docs_duplicate_inProgress_toast);
            return;
        L40:
            if (r107 == 800004046) goto L46;
            if (r107 != 1201) goto L45;
            Toast.showFailureText(r105, R.string.LarkCCM_Sheets_Protect_CantDuplicate_Toast);
            return;
        L45:
            Map<String, Integer> r113 = q.f242003a;
            Toast.showFailureText(r105, q.d(WikiAction.MAKE_COPY, r101));
            return;
        L23:
            r110 = null;
            goto L24
        L29:
            com.bytedance.ee.bear.middleground_permission_export.model.d r114 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
            SpaceSelectorBean r115 = r106.f543004e;
            if (r115 == null) goto L33;
            String r116 = r115.f229386b;
            if (r116 == null) goto L33;
        L34:
            String r117 = r114.f(r116, "CCM_CREATE_COPY", r107);
            if (TextUtils.isEmpty(r117) == true) goto L37;
            Toast.showFailureText(r105, r117);
            return;
        L33:
            r116 = "";
            goto L34
        L54:
            return;
        L11:
            r107 = -1;
            goto L13
        L48:
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r100 = this.f543005f;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L13;
        Disposable r102 = this.f543005f;
        if (r102 == null) goto L13;
        r102.dispose();
    L13:
        if (this.f543006g != null) goto L16;
        Toast.cancelLoading();
        return;
    L16:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // td5.d
    public final void execute() {
        if (this.f543004e != null) goto L6;
        tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...spaceSelectorBean is null. return");
        return;
    L6:
        Fragment r100 = this.f543000a;
        if (r100 == null) goto L9;
        Context r101 = r100.getContext();
    L10:
        if (r101 != null) goto L13;
        tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...context is null. return");
        return;
    L13:
        com.larksuite.component.universe_design.toast.c r102 = this.f543006g;
        if (r102 != null) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == false) goto L22;
        tt5.a.h("SpaceMakeCopyToWikiCommand", "already make copy success, return");
        return;
    L22:
        tt5.a.h("SpaceMakeCopyToWikiCommand", "execute()...");
        Disposable r104 = this.f543005f;
        if (r104 != null) goto L25;
    L27:
        boolean r105 = false;
    L28:
        if (r105 == false) goto L32;
        Disposable r106 = this.f543005f;
        if (r106 == null) goto L32;
        r106.dispose();
    L32:
        Context r107 = this.f543000a.getContext();
        Fragment r108 = this.f543000a;
        Map<String, Integer> r109 = q.f242003a;
        Toast.showLoading(r107, r108.getString(q.e(WikiAction.MAKE_COPY)));
        NetService.f r110 = new NetService.f("/space/api/wiki/v2/tree/node/copy_by_obj/");
        SpaceSelectorBean r111 = this.f543004e;
        String r112 = "";
        if (r111 == null) goto L57;
        JSONObject r113 = new JSONObject();
        r113.put("obj_token", r111.f229386b);
        r113.put("obj_type", r111.f229385a);
        r113.put("target_space_id", this.f543001b);
        r113.put("target_wiki_token", this.f543002c);
        SpaceSelectorBean r114 = this.f543004e;
        if (r114 == null) goto L51;
        Fragment r115 = this.f543000a;
        if (r115 == null) goto L43;
        String r116 = r115.getString(R.string.Doc_Facade_CopyDocSuffix);
        if (r116 == null) goto L43;
        r112 = r116;
    L43:
        if (r114.f229385a == sbb.e.f541301l.f541317b) goto L45;
    L49:
        String r117 = r114.f229390f + ' ' + r112;
    L50:
        r112 = r117;
        goto L51
    L45:
        if (TextUtils.isEmpty(r114.f229389e) == true) goto L49;
        if (((r114.f229390f.length() - r114.f229389e.length()) - 1) < 0) goto L49;
        String r118 = r114.f229390f;
        r117 = r118.substring(0, (r118.length() - r114.f229389e.length()) - 1) + ' ' + r112 + '.' + r114.f229389e;
    L51:
        r113.put("title", r112);
        r113.put("time_zone", zu5.b.c());
        if (r111.f229385a == sbb.e.f541297h.f541317b) goto L54;
    L56:
        r112 = r113.toString();
        goto L57
    L54:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.sheet.async_make_copy") == false) goto L56;
        r113.put("async", true);
    L57:
        r110.f216906c = 1;
        r110.f216913j = r112;
        this.f543005f = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(C7641b.f543007a).a(r110).subscribe(new c(this), new d(this));
        return;
    L25:
        if (r104.isDisposed() == true) goto L27;
        r105 = true;
        goto L28
    L16:
        if (r102.isShowing() != true) goto L18;
        r103 = true;
        goto L19
    L9:
        r101 = null;
        goto L10
    }

    public b(Fragment r100, Bundle r101, String r102, String r103, sq5.a r104) {
        Intrinsics.checkNotNullParameter(r102, "destSpaceId");
        Intrinsics.checkNotNullParameter(r103, "destWikiToken");
        Intrinsics.checkNotNullParameter(r104, "dependence");
        this.f543000a = r100;
        this.f543001b = r102;
        this.f543002c = r103;
        this.f543003d = r104;
        if (r101 == null) goto L5;
        SpaceSelectorBean r105 = (SpaceSelectorBean) r101.getParcelable("extra_space_bean");
    L6:
        this.f543004e = r105;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
