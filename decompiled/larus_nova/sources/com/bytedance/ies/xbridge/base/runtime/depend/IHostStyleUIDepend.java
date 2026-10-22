package com.bytedance.ies.xbridge.base.runtime.depend;

import android.app.Activity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import g66.c;
import kotlin.Metadata;
import s56.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001 J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ!\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u001e\u001a\u00020\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend;", "", "Lcom/bytedance/ies/xbridge/base/runtime/depend/DialogBuilder;", "dialogBuilder", "", "showDialog", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/DialogBuilder;)Ljava/lang/Boolean;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "toastBuilder", "showToast", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "Lg66/c;", "contextProviderFactory", DyPayConstant.KEY_SHOW_LOADING, "(Lg66/c;)Ljava/lang/Boolean;", "Ls56/f;", "showLoadingParams", "(Ls56/f;Lg66/c;)Ljava/lang/Boolean;", "hideLoading", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ActionSheetBuilder;", "actionSheetBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ShowActionSheetListener;", "showActionSheetListener", "showActionSheet", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ActionSheetBuilder;Lcom/bytedance/ies/xbridge/base/runtime/depend/ShowActionSheetListener;)Ljava/lang/Boolean;", "Landroid/app/Activity;", "activity", "Lcom/bytedance/ies/xbridge/base/runtime/depend/PageTitleBar;", "title", "", "setPageNaviStyle", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostStyleUIDepend {
    public static final a Companion = null;
    public static final String TOAST_TYPE_ERROR = "error";
    public static final String TOAST_TYPE_SUCCESS = "success";
    public static final String TOAST_TYPE_WARN = "warn";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f249446a = null;

        static {
            f249446a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f249446a;
    }

    Boolean hideLoading(c r100);

    void setPageNaviStyle(c r100, Activity r101, PageTitleBar r102);

    Boolean showActionSheet(ActionSheetBuilder r100, ShowActionSheetListener r101);

    Boolean showDialog(DialogBuilder r100);

    Boolean showLoading(c r100);

    Boolean showLoading(f r100, c r101);

    Boolean showToast(ToastBuilder r100);
}
