package yh5;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.Style;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final b a;

    public static final class a {
    }

    public static final class b implements ph5.a {
        public final /* synthetic */ d a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Style.values().length];
                r0[Style.TOAST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // ph5.a
        public final void a(Context r4, ErrorResponse r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "response");
            this.a.getClass();
            tt5.a.h("ErrorHandleService-PermissionSDK", "handleUIAction " + r5.getHasHandledUiAction());
            if (r5.getHasHandledUiAction() == true) goto L5;
            return;
        L5:
            UiStyle r0 = r5.getUiStyle();
            String r1 = null;
            if (r0 == null) goto L8;
            Style r2 = r0.getStyle();
        L9:
            if (r2 != null) goto L11;
            int r3 = -1;
        L13:
            if (r3 != 1) goto L26;
            UiStyle r6 = r5.getUiStyle();
            if (r6 == null) goto L17;
            String r7 = r6.getToastMsg();
        L19:
            if (TextUtils.isEmpty(r7) == false) goto L21;
            return;
        L21:
            Application r8 = eu5.b.a;
            UiStyle r9 = r5.getUiStyle();
            if (r9 == null) goto L24;
            r1 = r9.getToastMsg();
        L24:
            Toast.showFailureText(r4, r1);
            return;
        L17:
            r7 = null;
            goto L19
        L26:
            return;
        L11:
            r3 = a.a[r2.ordinal()];
            goto L13
        L8:
            r2 = null;
            goto L9
        }
    }

    static {
    }

    public d() {
        this.a = new b(this);
    }

    public final ErrorResponse a(String r6, String r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r8, "throwable");
    L22:
        th = move-exception;
        tt5.a.f("ErrorHandleService-PermissionSDK", th, false);
        return new ErrorResponse(false, this.a);
    L4:
        if ((r8 instanceof NetService.ServerErrorException) == false) goto L6;
        int r9 = ((NetService.ServerErrorException) r8).getCode();     // Catch: Throwable -> L22
    L7:
        tt5.a.h("ErrorHandleService-PermissionSDK", "handlePermError errocode=" + r9 + ",operation=" + r7);     // Catch: Throwable -> L22
        if (r9 == 900099011) goto L24;
        switch(r9) {
            case 900099001: goto L12;
            case 900099002: goto L12;
            case 900099003: goto L12;
            case 900099004: goto L12;
            default: goto L21;
        };     // Catch: Throwable -> L22
    L21:
        return new ErrorResponse(false, this.a);
    L12:
        if (Intrinsics.areEqual(r7, "CONTENT_COPY") == false) goto L14;
        String r10 = "CCM_CONTENT_COPY";
    L15:
        int r4 = f.a;     // Catch: Throwable -> L22
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        String r11 = f.a.b(r6, r10, r9);     // Catch: Throwable -> L22
        UiStyle r12 = new UiStyle(r11);     // Catch: Throwable -> L22
        ErrorResponse r13 = new ErrorResponse(!TextUtils.isEmpty(r11), this.a);     // Catch: Throwable -> L22
        r13.setUiStyle(r12);     // Catch: Throwable -> L22
        return r13;
    L14:
        r10 = "";
        goto L15
    L24:
        ErrorResponse r14 = new ErrorResponse(true, this.a);     // Catch: Throwable -> L22
        r14.setUiStyle(new UiStyle(Style.UNKNOWN));     // Catch: Throwable -> L22
        return r14;
    L6:
        r9 = 0;
        goto L7
    }
}
