package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.security.compliance.api.model.filepolicy.InteractionType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ph5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00106\u001a\u00020\u001dH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "", "denySource", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenySource;", "allow", "", "callback", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionUiCallback;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenySource;ZLcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionUiCallback;)V", "getDenySource", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenySource;", "setDenySource", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenySource;)V", "getAllow", "()Z", "setAllow", "(Z)V", "getCallback", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionUiCallback;", "setCallback", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionUiCallback;)V", "cacheReqRequest", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionRequest;", "getCacheReqRequest", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionRequest;", "setCacheReqRequest", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionRequest;)V", WikiFolderPushPlugin.OPT, "", "getOperation", "()Ljava/lang/String;", "setOperation", "(Ljava/lang/String;)V", "uiStyle", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;", "getUiStyle", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;", "setUiStyle", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;)V", "serviceIdentifyKey", "getServiceIdentifyKey", "setServiceIdentifyKey", "secSdkResult", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "getSecSdkResult", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "setSecSdkResult", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;)V", "sdkCacheEntity", "getSdkCacheEntity", "()Ljava/lang/Object;", "setSdkCacheEntity", "(Ljava/lang/Object;)V", "toString", "Companion", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionResponse {
    public static final a Companion = null;
    public static final String TAG = "PermissionResponse";
    private boolean allow;
    private PermissionRequest cacheReqRequest;
    private e callback;
    private DenySource denySource;
    private String operation;
    private Object sdkCacheEntity;
    private ValidateResult secSdkResult;
    private String serviceIdentifyKey;
    private UiStyle uiStyle;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse$a$a, reason: collision with other inner class name */
        public static final class C0109a implements e {
            public C0109a() {
            }

            @Override // ph5.e
            public final void a(Context r2, PermissionResponse r3) {
                Intrinsics.checkNotNullParameter(r2, "context");
                Intrinsics.checkNotNullParameter(r3, "response");
                tt5.a.d(PermissionResponse.TAG, "should not calld here");
            }
        }

        public static final class b implements e {
            public b() {
            }

            @Override // ph5.e
            public final void a(Context r2, PermissionResponse r3) {
                Intrinsics.checkNotNullParameter(r2, "context");
                Intrinsics.checkNotNullParameter(r3, "response");
                tt5.a.d(PermissionResponse.TAG, "getPassResponse");
            }
        }

        public static PermissionResponse a() {
            return new PermissionResponse(new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT), true, new C0109a());
        }

        public static PermissionResponse b() {
            return new PermissionResponse(new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT), true, new b());
        }

        public a() {
        }

        public static boolean c(PermissionResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "permissionResponse");
            if (r2.getDenySource().getDenyType() != DenyType.DLP_SENSATIVE) goto L15;
            ValidateResult r3 = r2.getSecSdkResult();
            if (r3 == null) goto L11;
            ValidateResult.ValidateResultExtra r4 = r3.getValidateResultExtra();
            if (r4 == null) goto L11;
            InteractionType r5 = r4.getInteractionType();
            if (r5 == null) goto L11;
        L12:
            tt5.a.h(PermissionResponse.TAG, "isDlpBannerShow " + r5);
            if (r5 == InteractionType.HIDDEN) goto L15;
            return true;
        L11:
            r5 = InteractionType.DEFAULT;
        L15:
            return false;
        }

        public static boolean d(PermissionResponse r4) {
            Intrinsics.checkNotNullParameter(r4, "permissionResponse");
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            boolean r0 = jg5.e.a.a.g();
            if (r4.getAllow() == false) goto L5;
        L7:
            boolean r5 = false;
        L8:
            if (r0 == false) goto L12;
            if (r5 == false) goto L13;
            return true;
        L13:
            return false;
        L12:
            return false;
        L5:
            if (DenyType.USER_PERMISSION == r4.getDenySource().getDenyType()) goto L7;
            r5 = true;
            goto L8
        }

        public static boolean e(PermissionResponse r4) {
            Intrinsics.checkNotNullParameter(r4, "permissionResponse");
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            boolean r0 = jg5.e.a.a.g();
            if (r4.getAllow() == false) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r0 == false) goto L12;
            if (r5 == false) goto L12;
            return true;
        L12:
            return false;
        L5:
            if (r4.getDenySource().getUiType() != UiType.HIDDEN) goto L8;
            r5 = false;
            goto L9
        }

        public static boolean f(PermissionResponse r3) {
            Intrinsics.checkNotNullParameter(r3, "permissionResponse");
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == true) goto L5;
            return false;
        L5:
            if (r3.getDenySource().getDenyType() != DenyType.AUDIT_CONTROL) goto L10;
            return true;
        L10:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "PermissionResponse@" + hashCode() + "{request: " + this.cacheReqRequest + ", allow: " + this.allow + ", denySource: " + this.denySource + '}';
    }

    public final boolean getAllow() {
        return this.allow;
    }

    public final PermissionRequest getCacheReqRequest() {
        return this.cacheReqRequest;
    }

    public final e getCallback() {
        return this.callback;
    }

    public final DenySource getDenySource() {
        return this.denySource;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final Object getSdkCacheEntity() {
        return this.sdkCacheEntity;
    }

    public final ValidateResult getSecSdkResult() {
        return this.secSdkResult;
    }

    public final String getServiceIdentifyKey() {
        return this.serviceIdentifyKey;
    }

    public final UiStyle getUiStyle() {
        return this.uiStyle;
    }

    public final void setAllow(boolean r1) {
        this.allow = r1;
    }

    public final void setCacheReqRequest(PermissionRequest r1) {
        this.cacheReqRequest = r1;
    }

    public final void setCallback(e r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callback = r2;
    }

    public final void setDenySource(DenySource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.denySource = r2;
    }

    public final void setOperation(String r1) {
        this.operation = r1;
    }

    public final void setSdkCacheEntity(Object r1) {
        this.sdkCacheEntity = r1;
    }

    public final void setSecSdkResult(ValidateResult r1) {
        this.secSdkResult = r1;
    }

    public final void setServiceIdentifyKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.serviceIdentifyKey = r2;
    }

    public final void setUiStyle(UiStyle r1) {
        this.uiStyle = r1;
    }

    public PermissionResponse(DenySource r4, boolean r5, e r6) {
        Intrinsics.checkNotNullParameter(r4, "denySource");
        Intrinsics.checkNotNullParameter(r6, "callback");
        new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT);
        this.serviceIdentifyKey = "";
        this.denySource = r4;
        this.allow = r5;
        this.callback = r6;
    }
}
