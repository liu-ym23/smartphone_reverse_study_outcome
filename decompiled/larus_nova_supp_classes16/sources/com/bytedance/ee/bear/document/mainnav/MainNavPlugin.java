package com.bytedance.ee.bear.document.mainnav;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.pageedit.PageEditPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.lark.dependency.s;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/mainnav/MainNavPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "needAddVisitRecord", "", "setNeedAddVisitRecord", "", PageEditPlugin.ADD, "onPause", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getMainNavInfoWithPermissionCheck", "Lcom/bytedance/ee/bear/lark/dependency/params/MainNavParams;", "getMainNavInfo", "name", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainNavPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String FG_BITABLE_RECORD_SHARE_OPEN_HISTORY = "bitable.record.share.open.history";
    private static final String RECORD_SHARE_PATH = "/record/";
    private static final String TAG = "MainNavPlugin";
    private boolean needAddVisitRecord;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            rc5.a r0 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
            String r5 = r0.E((String) r4);
            if (r5 != null) goto L6;
            return "";
        L6:
            return r5;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ wb5.d a;

        public c(wb5.d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            if (TextUtils.isEmpty(r4) == true) goto L5;
            tt5.a.h(MainNavPlugin.TAG, "getDocNameByObjToken success doc name: " + r4 + ' ');
            wb5.d r0 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r0.c = r4;
        L5:
            ((s) org.koin.java.a.c(s.class, null, null, 6)).b(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ wb5.d a;

        public d(wb5.d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.d(MainNavPlugin.TAG, "getDocNameByObjToken err: " + ((Throwable) r3).getMessage() + ' ');
            ((s) org.koin.java.a.c(s.class, null, null, 6)).b(this.a);
        }
    }

    static {
        Companion = new a();
    }

    private final wb5.d getMainNavInfoWithPermissionCheck() {
        if (Intrinsics.areEqual(((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().a(), Boolean.FALSE) == true) goto L7;
        tt5.a.h(TAG, "getMainNavInfoWithPermissionCheck can read");
        return getMainNavInfo("");
    L7:
        return getMainNavInfo(getActivity().getResources().getString(2131889846));
    }

    public MainNavPlugin() {
        this.needAddVisitRecord = true;
    }

    private final wb5.d getMainNavInfo(String r10) {
        y3 r0 = getEditorAbility().getDocumentMetadata();
        String r1 = (String) r0.getDocName().getValue();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r2 = r0.getOriginBearUrl().a();
        if ((getActivity() instanceof BaseActivity) == false) goto L19;
        BaseActivity r4 = getActivity();
        if (r4 == null) goto L19;
        xj5.a r3 = r4.vb(xj5.a.class);
        if (r3 == null) goto L14;
        msb.a r5 = r3.a;
        if (r5 == null) goto L14;
        r5.b();
    L14:
        if (r3 == null) goto L18;
        msb.a r6 = r3.a;
        if (r6 == null) goto L18;
        r6.b();
    L18:
        tt5.a.h(TAG, "getMainNavInfo: " + du5.b.k(""));
        r1 = "";
    L19:
        int r7 = r0.getDocumentTypeValue();
        if (TextUtils.isEmpty(r10) == true) goto L22;
        int r8 = -1;
    L23:
        tt5.a.h(TAG, "getMainNavInfo: " + du5.b.k(""));
        return new wb5.d("", r10, r0.getOriginUrl(), r8, String.valueOf(r7));
    L22:
        r10 = r1;
        r8 = r2;
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onPause(PluginHost r7) {
        super.onPause(r7);
        if (this.needAddVisitRecord == true) goto L5;
        return;
    L5:
        wb5.d r8 = getMainNavInfoWithPermissionCheck();
        if (com.bytedance.ee.bear.appsetting.c.a.a.h(FG_BITABLE_RECORD_SHARE_OPEN_HISTORY) == false) goto L22;
    L16:
        String r0 = getEditorAbility().getDocumentMetadata().getToken();
        if (TextUtils.isEmpty(r0) == false) goto L20;
        tt5.a.d(TAG, "onPause docToken null.");
        return;
    L20:
        Flowable.just(r0).subscribeOn(fo5.d.b()).map(b.a).observeOn(fo5.d.d()).subscribe(new c(r8), new d(r8));
        return;
    L22:
    L14:
        e = move-exception;
        tt5.a.d(TAG, "check record share page exception " + e.getMessage());
        goto L16
    L8:
        if (8 != r8.getType()) goto L16;
        URL r1 = new URL(r8.d);     // Catch: Exception -> L14
        if (r1.getPath() == null) goto L16;
        if (StringsKt.startsWith$default(r1.getPath(), RECORD_SHARE_PATH, false, 2, null) == false) goto L16;
    }

    public final void setNeedAddVisitRecord(boolean r1) {
        this.needAddVisitRecord = r1;
    }

    public static /* synthetic */ wb5.d getMainNavInfo$default(MainNavPlugin r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return r0.getMainNavInfo(r1);
    }
}
