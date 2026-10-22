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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements td5.d {
    public static final /* synthetic */ int h = 0;
    public final Fragment a;
    public final String b;
    public final String c;
    public final sq5.a d;
    public final SpaceSelectorBean e;
    public Disposable f;
    public com.larksuite.component.universe_design.toast.c g;

    public static final class a {
    }

    /* JADX INFO: renamed from: sq5.b$b, reason: collision with other inner class name */
    public static final class C0307b<T extends Result> implements NetService.c {
        public static final C0307b<T> a = null;

        static {
            a = new C0307b();
        }

        public C0307b() {
        }

        public final Result<TreeNode> parse(String r5) {
            JSONObject r0 = new JSONObject(r5);
            Result<TreeNode> r6 = new Result();
            r6.data = (Serializable) GsonProtectorUtils.fromJson(new Gson(), r0.optString(WikiFolderPushPlugin.DATA), TreeNode.class);
            r6.code = r0.optInt("code");
            r6.msg = r0.optString("msg");
            return r6;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Result r7 = (Result) r6;
            tt5.a.h("SpaceMakeCopyToWikiCommand", "execute()...make copy success. wikiToken = " + du5.b.g(((TreeNode) r7.data).wiki_token));
            SpaceSelectorBean r0 = this.a.e;
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.a);
        L6:
            jw4.a.g("copy", r1);
            b r2 = this.a;
            TreeNode r8 = (TreeNode) r7.data;
            r2.getClass();
            Toast.cancelLoading();
            r2.d.ww(null);
            com.bytedance.ee.bear.route.h r3 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            Ref.ObjectRef r4 = new Ref.ObjectRef();
            Activity r5 = r3.getActivity();
            r4.element = r5;
            if (com.bytedance.ee.util.ui.b.a(r5) == false) goto L15;
            Activity r9 = (Activity) r4.element;
            if (r9 != null) goto L11;
            return;
        L11:
            if (AppInfoUtils.f().booleanValue() == false) goto L13;
            Toast.showSuccessText(r9, 2131887772);
            return;
        L13:
            UDToast.a r10 = UDToast.build(r9);
            r10.b.e(2131887772);
            r10.b(2131887161, new sq5.c(r8));
            r10.f(new sq5.d(r4, r2));
            com.ss.android.lark.compose.foundation.toast.g r11 = r10.a();
            r2.g = r11;
            r11.show();
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            NetService.ServerErrorException r9 = (Throwable) r8;
            tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...make copy failed, error = " + r9);
            SpaceSelectorBean r0 = this.a.e;
            Integer r1 = null;
            if (r0 == null) goto L5;
            Integer r2 = Integer.valueOf(r0.a);
        L6:
            jw4.a.h("copy", r9, r2);
            Toast.cancelLoading();
            Context r3 = this.a.a.getContext();
            if (r3 == null) goto L48;
            b r4 = this.a;
            if ((r9 instanceof NetService.ServerErrorException) == false) goto L11;
            int r5 = r9.getCode();
        L13:
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r9, r3) == false) goto L16;
            return;
        L16:
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).p(r9, r3, false) == true) goto L54;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L29;
            ph5.b r6 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            SpaceSelectorBean r7 = r4.e;
            if (r7 == null) goto L23;
            String r10 = r7.b;
        L24:
            if (r7 == null) goto L26;
            r1 = Integer.valueOf(r7.a);
        L26:
            Intrinsics.checkNotNull(r9);
            ErrorResponse r11 = r6.e(r10, r1, "CREATE_COPY", r9);
            if (r11.getHasHandledUiAction() == false) goto L37;
            r11.getCallback().a(r3, r11);
            return;
        L37:
            int r12 = b.h;
            if (r5 != 4000080) goto L40;
        L46:
            Toast.showFailureText(r3, 2131887226);
            return;
        L40:
            if (r5 == 800004046) goto L46;
            if (r5 != 1201) goto L45;
            Toast.showFailureText(r3, 2131889748);
            return;
        L45:
            Map<String, Integer> r13 = q.a;
            Toast.showFailureText(r3, q.d(WikiAction.MAKE_COPY, r9));
            return;
        L23:
            r10 = null;
            goto L24
        L29:
            com.bytedance.ee.bear.middleground_permission_export.model.d r14 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
            SpaceSelectorBean r15 = r4.e;
            if (r15 == null) goto L33;
            String r16 = r15.b;
            if (r16 == null) goto L33;
        L34:
            String r17 = r14.f(r16, "CCM_CREATE_COPY", r5);
            if (TextUtils.isEmpty(r17) == true) goto L37;
            Toast.showFailureText(r3, r17);
            return;
        L33:
            r16 = "";
            goto L34
        L54:
            return;
        L11:
            r5 = -1;
            goto L13
        L48:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        Disposable r2 = this.f;
        if (r2 == null) goto L13;
        r2.dispose();
    L13:
        if (this.g != null) goto L16;
        Toast.cancelLoading();
        return;
    L16:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // td5.d
    public final void execute() {
        if (this.e != null) goto L6;
        tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...spaceSelectorBean is null. return");
        return;
    L6:
        Fragment r0 = this.a;
        if (r0 == null) goto L9;
        Context r1 = r0.getContext();
    L10:
        if (r1 != null) goto L13;
        tt5.a.d("SpaceMakeCopyToWikiCommand", "execute()...context is null. return");
        return;
    L13:
        com.larksuite.component.universe_design.toast.c r2 = this.g;
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L22;
        tt5.a.h("SpaceMakeCopyToWikiCommand", "already make copy success, return");
        return;
    L22:
        tt5.a.h("SpaceMakeCopyToWikiCommand", "execute()...");
        Disposable r4 = this.f;
        if (r4 != null) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L32;
        Disposable r6 = this.f;
        if (r6 == null) goto L32;
        r6.dispose();
    L32:
        Context r7 = this.a.getContext();
        Fragment r8 = this.a;
        Map<String, Integer> r9 = q.a;
        Toast.showLoading(r7, r8.getString(q.e(WikiAction.MAKE_COPY)));
        NetService.f r10 = new NetService.f("/space/api/wiki/v2/tree/node/copy_by_obj/");
        SpaceSelectorBean r11 = this.e;
        String r12 = "";
        if (r11 == null) goto L57;
        JSONObject r13 = new JSONObject();
        r13.put(ResourceData.KEY_OBJ_TOKEN, r11.b);
        r13.put("obj_type", r11.a);
        r13.put("target_space_id", this.b);
        r13.put("target_wiki_token", this.c);
        SpaceSelectorBean r14 = this.e;
        if (r14 == null) goto L51;
        Fragment r15 = this.a;
        if (r15 == null) goto L43;
        String r16 = r15.getString(2131887720);
        if (r16 == null) goto L43;
        r12 = r16;
    L43:
        if (r14.a == sbb.e.l.b) goto L45;
    L49:
        String r17 = r14.f + ' ' + r12;
    L50:
        r12 = r17;
        goto L51
    L45:
        if (TextUtils.isEmpty(r14.e) == true) goto L49;
        if (((r14.f.length() - r14.e.length()) - 1) < 0) goto L49;
        String r18 = r14.f;
        r17 = r18.substring(0, (r18.length() - r14.e.length()) - 1) + ' ' + r12 + '.' + r14.e;
    L51:
        r13.put("title", r12);
        r13.put("time_zone", zu5.b.c());
        if (r11.a == sbb.e.h.b) goto L54;
    L56:
        r12 = r13.toString();
        goto L57
    L54:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.sheet.async_make_copy") == false) goto L56;
        r13.put("async", true);
    L57:
        ((NetService.e) r10).c = 1;
        ((NetService.e) r10).j = r12;
        this.f = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(C0307b.a).a(r10).subscribe(new c(this), new d(this));
        return;
    L25:
        if (r4.isDisposed() == true) goto L27;
        r5 = true;
        goto L28
    L16:
        if (r2.isShowing() != true) goto L18;
        r3 = true;
        goto L19
    L9:
        r1 = null;
        goto L10
    }

    public b(Fragment r2, Bundle r3, String r4, String r5, sq5.a r6) {
        Intrinsics.checkNotNullParameter(r4, "destSpaceId");
        Intrinsics.checkNotNullParameter(r5, "destWikiToken");
        Intrinsics.checkNotNullParameter(r6, "dependence");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        if (r3 == null) goto L5;
        SpaceSelectorBean r7 = (SpaceSelectorBean) r3.getParcelable("extra_space_bean");
    L6:
        this.e = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
