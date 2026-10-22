package com.ss.android.lark.core.keyboard;

import android.content.Context;
import android.text.Annotation;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.d;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@ClaymoreImpl(d.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J.\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020#H\u0016J\f\u0010(\u001a\u00020\u0007*\u00020\u0007H\u0002¨\u0006*"}, d2 = {"Lcom/ss/android/lark/core/keyboard/KeyboardBaseModuleDependencyImpl;", "Lcom/ss/android/lark/KeyboardBaseModuleDependency;", "<init>", "()V", "isFeatureGatingEnable", "", "key", "", "isFeatureGatingCurrentEnable", "getDocFromContent", "", "content", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/DocResult;", "getUrlInlineFromContent", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", "getTempPreviewFromContent", "url", "appId", "", "type", "getTempPreview", "callbackWrapper", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getCallbackWrapper", "getColorByThemeColor", "", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", RuleConditionBean.OPEN_URL_KEY, PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "scene", "decodeAndGetRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "span", "Landroid/text/Annotation;", "encodePbRichText", "richText", "trimUrl", "Companion", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardBaseModuleDependencyImpl implements d {
    public static final a Companion = null;
    private static final String TAG = "KeyboardBaseModuleDependencyImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public KeyboardBaseModuleDependencyImpl() {
    }

    public void getDocFromContent(String r100, IGetDataCallback<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.ss.android.lark.d
    public void openUrl(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "scene");
    }

    private final int getColorByThemeColor(ThemeColor r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return com.ss.android.lark.export.entity.preview.a.a(r100, UIHelper.getContext(), null);
    }

    private final String trimUrl(String r100) {
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        int r103 = r100.length() - 1;
    L10:
        if (r101 >= r100.length()) goto L14;
        if (r100.charAt(r101) != ' ') goto L14;
        r101 = r101 + 1;
    L14:
        if (r103 < 0) goto L19;
        if (r100.charAt(r103) != '\n') goto L19;
        r103 = r103 - 1;
    L19:
        return r100.substring(r101, r103 + 1);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.d
    public RichText decodeAndGetRichText(Annotation r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        ByteString.a r101 = ByteString.Companion;     // Catch: Exception -> L11
        String r102 = r100.getValue();     // Catch: Exception -> L11
        r101.getClass();     // Catch: Exception -> L11
        ByteString r103 = ByteString.a.a(r102);     // Catch: Exception -> L11
        if (r103 != null) goto L6;
        return null;
    L6:
        com.bytedance.lark.pb.basic.v1.RichText r104 = com.bytedance.lark.pb.basic.v1.RichText.ADAPTER.decode(r103);     // Catch: Exception -> L11
        if (r104 != null) goto L9;
        return null;
    L9:
        return g0.e(r104, null);
    L11:
        e = move-exception;
        Log.e(TAG, "decodeAndGetRichText: decode error: " + ExceptionsKt.stackTraceToString(e));
        return null;
    }

    @Override // com.ss.android.lark.d
    public String encodePbRichText(RichText r100) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        com.bytedance.lark.pb.basic.v1.RichText r101 = g0.d(r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        byte[] r102 = r101.encode();     // Catch: Exception -> L8
        ByteString.a r103 = ByteString.Companion;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L8
        return ByteString.a.e(r103, r102).base64();
    L8:
        e = move-exception;
        Log.e(TAG, "encodePbRichText: encode error: " + ExceptionsKt.stackTraceToString(e));
        return "";
    }

    @Override // com.ss.android.lark.d
    public boolean isFeatureGatingCurrentEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r100);
    }

    @Override // com.ss.android.lark.d
    public boolean isFeatureGatingEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }

    public static final /* synthetic */ int access$getColorByThemeColor(KeyboardBaseModuleDependencyImpl r100, ThemeColor r101) {
        return r100.getColorByThemeColor(r101);
    }

    private final IGetDataCallback<UrlInlinePreviewEntity> getCallbackWrapper(final String r100, final IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r101) {
        return new AnonymousClass1(r101, this, r100);
    }

    @Override // com.ss.android.lark.d
    public void getUrlInlineFromContent(String r100, IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = trimUrl(r100);
        IGetDataCallback<UrlInlinePreviewEntity> r103 = getCallbackWrapper(r102, r101);
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).getUrlInlineFromContent(r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl$getTempPreview$1] */
    private final void getTempPreview(String r100, long r110, long r111, final IGetDataCallback<UrlInlinePreviewEntity> r112) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatPreviewApi().b(r100, r110, r111, new C118301(r112));
    }

    @Override // com.ss.android.lark.d
    public void getTempPreviewFromContent(String r100, long r110, long r111, IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = trimUrl(r100);
        getTempPreview(r101, r110, r111, getCallbackWrapper(r101, r112));
    }
}
