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
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f567576a;

    public static final class a {
    }

    public static final class b implements ph5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f567577a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f567578a = null;

            static {
                int[] r100 = new int[Style.values().length];
                r100[Style.TOAST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f567578a = r100;
            }
        }

        public b(d r100) {
            this.f567577a = r100;
        }

        @Override // ph5.a
        public final void a(Context r100, ErrorResponse r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "response");
            this.f567577a.getClass();
            tt5.a.h("ErrorHandleService-PermissionSDK", "handleUIAction " + r101.getHasHandledUiAction());
            if (r101.getHasHandledUiAction() == true) goto L5;
            return;
        L5:
            UiStyle r102 = r101.getUiStyle();
            String r103 = null;
            if (r102 == null) goto L8;
            Style r104 = r102.getStyle();
        L9:
            if (r104 != null) goto L11;
            int r105 = -1;
        L13:
            if (r105 != 1) goto L26;
            UiStyle r106 = r101.getUiStyle();
            if (r106 == null) goto L17;
            String r107 = r106.getToastMsg();
        L19:
            if (TextUtils.isEmpty(r107) == false) goto L21;
            return;
        L21:
            Application r108 = eu5.b.f474075a;
            UiStyle r109 = r101.getUiStyle();
            if (r109 == null) goto L24;
            r103 = r109.getToastMsg();
        L24:
            Toast.showFailureText(r100, r103);
            return;
        L17:
            r107 = null;
            goto L19
        L26:
            return;
        L11:
            r105 = a.f567578a[r104.ordinal()];
            goto L13
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
    }

    public d() {
        this.f567576a = new b(this);
    }

    public final ErrorResponse a(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
    L22:
        th = move-exception;
        tt5.a.f("ErrorHandleService-PermissionSDK", th, false);
        return new ErrorResponse(false, this.f567576a);
    L4:
        if ((r102 instanceof NetService.ServerErrorException) == false) goto L6;
        int r103 = ((NetService.ServerErrorException) r102).getCode();     // Catch: Throwable -> L22
    L7:
        tt5.a.h("ErrorHandleService-PermissionSDK", "handlePermError errocode=" + r103 + ",operation=" + r101);     // Catch: Throwable -> L22
        if (r103 == 900099011) goto L24;
        switch(r103) {
            case 900099001: goto L12;
            case 900099002: goto L12;
            case 900099003: goto L12;
            case 900099004: goto L12;
            default: goto L21;
        };     // Catch: Throwable -> L22
    L21:
        return new ErrorResponse(false, this.f567576a);
    L12:
        if (Intrinsics.areEqual(r101, "CONTENT_COPY") == false) goto L14;
        String r104 = "CCM_CONTENT_COPY";
    L15:
        int r105 = f.f567580a;     // Catch: Throwable -> L22
        if (r100 != null) goto L18;
        r100 = "";
    L18:
        String r106 = f.a.b(r100, r104, r103);     // Catch: Throwable -> L22
        UiStyle r107 = new UiStyle(r106);     // Catch: Throwable -> L22
        ErrorResponse r108 = new ErrorResponse(!TextUtils.isEmpty(r106), this.f567576a);     // Catch: Throwable -> L22
        r108.setUiStyle(r107);     // Catch: Throwable -> L22
        return r108;
    L14:
        r104 = "";
        goto L15
    L24:
        ErrorResponse r109 = new ErrorResponse(true, this.f567576a);     // Catch: Throwable -> L22
        r109.setUiStyle(new UiStyle(Style.UNKNOWN));     // Catch: Throwable -> L22
        return r109;
    L6:
        r103 = 0;
        goto L7
    }
}
