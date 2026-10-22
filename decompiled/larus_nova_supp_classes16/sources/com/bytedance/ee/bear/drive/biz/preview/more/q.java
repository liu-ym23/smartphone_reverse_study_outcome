package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q extends com.bytedance.ee.bear.drive.biz.preview.more.b {
    public final FragmentActivity g;
    public final e65.a h;
    public final com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ BaseMoreMenuAction b;

        public b(q r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (com.bytedance.ee.util.ui.b.a(this.a.i.getActivity()) == false) goto L6;
            q.j(this.a, this.b);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ BaseMoreMenuAction b;

        public c(q r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (com.bytedance.ee.util.ui.b.a(this.a.i.getActivity()) == false) goto L6;
            q.j(this.a, this.b);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ BaseMoreMenuAction b;

        public d(q r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (com.bytedance.ee.util.ui.b.a(this.a.i.getActivity()) == false) goto L6;
            q.k(this.a, this.b);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ BaseMoreMenuAction b;

        public e(q r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (com.bytedance.ee.util.ui.b.a(this.a.i.getActivity()) == false) goto L6;
            q.k(this.a, this.b);
            return;
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ q a;
        public final /* synthetic */ BaseMoreMenuAction b;

        public f(q r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            DefaultResponse r7 = (DefaultResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            String r8 = new JSONObject((String) r7.data).optString("data");     // Catch: Exception -> L14
            if (r8 != null) goto L6;
            r8 = "";
        L6:
            boolean r9 = new JSONObject(r8).optBoolean("isLatest");     // Catch: Exception -> L14
            tt5.a.h("DriveImSheetMoreMenuCreator", "isLatest == " + r9);     // Catch: Exception -> L14
            if (r9 == true) goto L17;
            q r10 = this.a;     // Catch: Exception -> L14
            FragmentActivity r1 = r10.g;     // Catch: Exception -> L14
            if ((this.b instanceof SaveToSpaceMenu) == false) goto L11;
            q.l(r10, false);     // Catch: Exception -> L14
            String r11 = this.a.g.getResources().getString(2131889747);     // Catch: Exception -> L14
        L12:
            Intrinsics.checkNotNull(r11);     // Catch: Exception -> L14
            UDToast.show(r1, r11);     // Catch: Exception -> L14
            goto L17
        L11:
            q.l(r10, true);     // Catch: Exception -> L14
            r11 = this.a.g.getResources().getString(2131889746);     // Catch: Exception -> L14
        L17:
            return Unit.INSTANCE;
        L14:
            e = move-exception;
            tt5.a.f("DriveImSheetMoreMenuCreator", e, false);
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.b
    public final void f(BaseMoreMenuAction r4) {
        Intrinsics.checkNotNullParameter(r4, "menuAction");
        m(r4).subscribe(new b(this, r4), new c(this, r4));
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.b
    public final void g(BaseMoreMenuAction r4) {
        Intrinsics.checkNotNullParameter(r4, "menuAction");
        if (com.bytedance.ee.bear.drive.biz.preview.more.b.i(r4) == false) goto L5;
    L8:
        m(r4).subscribe(new d(this, r4), new e(this, r4));
        return;
    L5:
        if ((r4 instanceof SaveToSpaceMenu) == true) goto L8;
        super.g(r4);
    }

    public final Flowable<Object> m(BaseMoreMenuAction r5) {
        NetService.d r0 = ((NetService) this.i.c.getHost().getUserComponent().a(NetService.class)).Vc(new ax4.a());
        BaseOpenEntity r2 = this.h.a;
        if (r2 == null) goto L5;
        String r3 = r2.getFileId();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        return r0.a(new NetService.f("/space/api/v2/sheet/im_file_state/".concat(r3))).map(new f(this, r5));
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ void j(q r0, BaseMoreMenuAction r1) {
        super.f(r1);
    }

    public static final /* synthetic */ void k(q r0, BaseMoreMenuAction r1) {
        super.g(r1);
    }

    public static final void l(q r3, boolean r4) {
        r3.getClass();
        com.bytedance.ee.bear.contract.d r5 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r1 = new HashMap(r5.m("docCommonParams"));
        r1.putAll(r5.t("sheetCommonParams"));
        r1.put("click", "non_updated_version_toast_view");
        if (r4 == false) goto L5;
        String r6 = "download";
    L6:
        r1.put("toast_type", r6);
        r5.n("ccm_sheet_content_page_click", r1);
        return;
    L5:
        r6 = "upload";
        goto L6
    }

    public q(FragmentActivity r2, e65.a r3, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "menuContext");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        super(r2, r3, r4);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
