package com.bytedance.ee.bear.document.plugin.media;

import android.graphics.BitmapFactory;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j25.t;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0004/012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0016J\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J$\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\u001c\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0002J \u0010'\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/media/OfficeSelectMediaPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/ability/InsertMediaAbility;", "<init>", "()V", "selectMediaCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "insertMedias", "mediaList", "", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "callback", "needFailed", "", "doInsertMediasInternal", "Lio/reactivex/disposables/Disposable;", "buildJsonData", "Lcom/alibaba/fastjson/JSONObject;", "buildFailedJsonData", "encodeUrl", "media", "handleRemoteMediaRequest", "data", "parseRemoteUrls", "createRemoteMediaItem", "activity", "Landroidx/fragment/app/FragmentActivity;", "remoteUrl", "ensureSelectableLocalPath", "downloadedFile", "Ljava/io/File;", "buildFileSuffix", "mimeType", "buildSelectedMediaItem", "path", "onDetachFromHost", "SelectMediaJSHandler", "SelectImageHandler", "GetRemoteMediaHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSelectMediaPlugin extends DocumentPluginV3 implements vz4.g {
    public static final a Companion = null;
    private static final String DEFAULT_REMOTE_MEDIA_MIME_TYPE = "image/jpeg";
    private static final String DEFAULT_REMOTE_MEDIA_SUFFIX = ".jpg";
    private static final String REMOTE_MEDIA_FILE_PREFIX = "remote_media_";
    private static final String REMOTE_URLS_KEY = "remoteUrls";
    private static final String TAG = "SelectMediaPlugin";
    private final CompositeDisposable mCompositeDisposable;
    private m selectMediaCallback;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(OfficeSelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            String r5 = (String) r3;
            StringBuilder r0 = new StringBuilder("GetRemoteMediaHandler handle... data is null ? ");
            if (r5 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            r0.append(r1);
            tt5.a.h(OfficeSelectMediaPlugin.TAG, r0.toString());
            OfficeSelectMediaPlugin.access$handleRemoteMediaRequest(this.a, r5, r4);
            return;
        L5:
            if (r5.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public final class c implements tb5.i<Void> {
        public final /* synthetic */ OfficeSelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeSelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            OfficeSelectMediaPlugin.access$setSelectMediaCallback$p(this.a, r2);
        }
    }

    public final class d implements tb5.i<Void> {
        public final /* synthetic */ OfficeSelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OfficeSelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            OfficeSelectMediaPlugin.access$setSelectMediaCallback$p(this.a, r2);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ List<SelectedMediaItem> a;
        public final /* synthetic */ OfficeSelectMediaPlugin b;

        public e(List<? extends SelectedMediaItem> r1, OfficeSelectMediaPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            List r5 = (List) r4;
            HashMap r6 = new HashMap();
            Iterator<SelectedMediaItem> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            SelectedMediaItem r1 = r0.next();
            r6.put(OfficeSelectMediaPlugin.access$encodeUrl(this.b, r1), r1.getMediaFile());
            goto L4
        L7:
            return t.a(this.b.getDocumentMetadata().getUrl(), r6, false, null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ OfficeSelectMediaPlugin a;
        public final /* synthetic */ List<SelectedMediaItem> b;
        public final /* synthetic */ m c;

        public f(OfficeSelectMediaPlugin r1, List<? extends SelectedMediaItem> r2, m r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            tt5.a.h(OfficeSelectMediaPlugin.TAG, "doInsertMediasInternal success: " + ((Boolean) r4) + ", callback");
            JSONObject r5 = OfficeSelectMediaPlugin.access$buildJsonData(this.a, this.b);
            tt5.a.h(OfficeSelectMediaPlugin.TAG, "sendMediaCallbackToFrontEnd: " + r5);
            this.c.b(r5);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ m b;
        public final /* synthetic */ OfficeSelectMediaPlugin c;

        public g(boolean r1, m r2, OfficeSelectMediaPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            tt5.a.e(OfficeSelectMediaPlugin.TAG, "doInsertMedias", (Throwable) r4, false);
            if (this.a == false) goto L6;
            this.b.b(OfficeSelectMediaPlugin.access$buildFailedJsonData(this.c));
            return;
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ OfficeSelectMediaPlugin a;
        public final /* synthetic */ FragmentActivity b;

        public h(OfficeSelectMediaPlugin r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            String r4 = (String) r3;
            Intrinsics.checkNotNullParameter(r4, "remoteUrl");
            return OfficeSelectMediaPlugin.access$createRemoteMediaItem(this.a, this.b, r4);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ m b;
        public final /* synthetic */ OfficeSelectMediaPlugin c;

        public i(List<String> r1, m r2, OfficeSelectMediaPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            List r6 = (List) r5;
            Intrinsics.checkNotNull(r6);
            List<? extends SelectedMediaItem> r7 = CollectionsKt.filterNotNull(r6);
            if (r7.size() == this.a.size()) goto L5;
            tt5.a.d(OfficeSelectMediaPlugin.TAG, "handleRemoteMediaRequest... some remoteUrls failed");
            this.b.b(OfficeSelectMediaPlugin.access$buildFailedJsonData(this.c));
            return;
        L5:
            OfficeSelectMediaPlugin.access$getMCompositeDisposable$p(this.c).add(this.c.doInsertMediasInternal(r7, this.b, true));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ m a;
        public final /* synthetic */ OfficeSelectMediaPlugin b;

        public j(m r1, OfficeSelectMediaPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.e(OfficeSelectMediaPlugin.TAG, "handleRemoteMediaRequest...", (Throwable) r4, false);
            this.a.b(OfficeSelectMediaPlugin.access$buildFailedJsonData(this.b));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final JSONObject buildFailedJsonData() {
        JSONObject r0 = new JSONObject();
        r0.put("code", -1);
        return r0;
    }

    public OfficeSelectMediaPlugin() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ JSONObject access$buildFailedJsonData(OfficeSelectMediaPlugin r0) {
        return r0.buildFailedJsonData();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(OfficeSelectMediaPlugin r0) {
        return r0.mCompositeDisposable;
    }

    private final JSONObject buildJsonData(List<? extends SelectedMediaItem> r6) {
        JSONArray r0 = new JSONArray();
        Iterator<? extends SelectedMediaItem> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        SelectedMediaItem r1 = r7.next();
        JSONObject r2 = new JSONObject();
        r2.put("contentType", r1.getContentType());
        r2.put("uuid", r1.getUuid());
        r2.put("src", encodeUrl(r1));
        r2.put("width", Integer.valueOf(r1.getWidth()));
        r2.put("height", Integer.valueOf(r1.getHeight()));
        r2.put("duration", Long.valueOf(r1.getDuration()));
        r2.put("fileSize", Long.valueOf(r1.getFileSize()));
        r2.put("fileName", r1.getFileName());
        r0.add(r2);
        goto L4
    L6:
        JSONObject r8 = new JSONObject();
        r8.put("code", 0);
        r8.put("thumbs", r0);
        tt5.a.b(TAG, "buildJsonData: " + r8);
        return r8;
    }

    private final String encodeUrl(SelectedMediaItem r9) {
        String r6 = r9.getMediaFile();
        StringBuilder r7 = new StringBuilder("docsource://com.bytedance.net/file/f/");
        r7.append(r9.getUuid());
        Intrinsics.checkNotNull(r6);
        r7.append(r6.substring(StringsKt.lastIndexOf$default(r6, ".", 0, false, 6, null)));
        return r7.toString();
    }

    private final List<String> parseRemoteUrls(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L25
        org.json.JSONArray r9 = new org.json.JSONObject(r8).optJSONArray(REMOTE_URLS_KEY);     // Catch: Throwable -> L25
        if (r9 == null) goto L15;
        int r4 = r9.length();     // Catch: Throwable -> L25
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L32;
        String r6 = r9.optString(r5);     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L25
        if (r6.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        r3.add(r6);     // Catch: Throwable -> L25
    L24:
        r5 = r5 + 1;
        goto L17
    L21:
        r7 = false;
        goto L22
    L32:
        return r3;
    L15:
        return CollectionsKt.emptyList();
    L25:
        th = move-exception;
        tt5.a.e(TAG, "parseRemoteUrls failed", th, false);
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.selectMedia", new d(this));
        r3.put("biz.util.selectImage", new c(this));
        r3.put("biz.util.getRemoteMedia", new b(this));
    }

    @Override // vz4.g
    public void insertMedias(List<? extends SelectedMediaItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "mediaList");
        m r0 = this.selectMediaCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        insertMedias(r3, r0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        r2.registerHostAbility(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        this.mCompositeDisposable.clear();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ JSONObject access$buildJsonData(OfficeSelectMediaPlugin r0, List r1) {
        return r0.buildJsonData(r1);
    }

    public static final /* synthetic */ String access$encodeUrl(OfficeSelectMediaPlugin r0, SelectedMediaItem r1) {
        return r0.encodeUrl(r1);
    }

    public static final /* synthetic */ void access$setSelectMediaCallback$p(OfficeSelectMediaPlugin r0, m r1) {
        r0.selectMediaCallback = r1;
    }

    private final String buildFileSuffix(String r7, String r8) {
        String r9 = MimeTypeMap.getFileExtensionFromUrl(r7);
        String r1 = null;
        boolean r2 = true;
        if (r9 != null) goto L5;
    L14:
        String r10 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r8);
        if (r10 != null) goto L17;
        return DEFAULT_REMOTE_MEDIA_SUFFIX;
    L17:
        if (r10.length() >= 2) goto L20;
        r2 = false;
    L20:
        if (r2 == false) goto L22;
        r1 = r10;
    L22:
        if (r1 != null) goto L24;
        return DEFAULT_REMOTE_MEDIA_SUFFIX;
    L24:
        return "." + r1.toLowerCase(Locale.ROOT);
    L5:
        if (r9.length() < 2) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L14;
        return "." + r9.toLowerCase(Locale.ROOT);
    L7:
        r5 = false;
        goto L8
    }

    private final SelectedMediaItem buildSelectedMediaItem(String r13, String r14) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        boolean r1 = true;
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r13, r0);
        if (r0.outWidth > 0) goto L5;
    L23:
        tt5.a.d(TAG, "buildSelectedMediaItem... invalid image bounds, path = " + r13);
        return null;
    L5:
        if (r0.outHeight <= 0) goto L23;
        String r2 = r0.outMimeType;
        if (r2 != null) goto L10;
    L18:
        String r3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.removePrefix(buildFileSuffix(r14, null), "."));
        if (r3 != null) goto L22;
        r3 = DEFAULT_REMOTE_MEDIA_MIME_TYPE;
    L22:
        return new SelectedMediaItem(r3, UUID.randomUUID().toString(), r13, r0.outWidth, r0.outHeight, 0, new PolarisFileWrapper(r13).length(), new PolarisFileWrapper(r13).getName());
    L10:
        if (r2.length() > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r3 = r2;
        goto L22
    }

    private final SelectedMediaItem createRemoteMediaItem(FragmentActivity r6, String r7) {
        File r0 = (File) Glide.with(r6.getApplicationContext()).load(new BearGlideUrl(r7)).diskCacheStrategy(DiskCacheStrategy.DATA).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get();
        Object r1 = null;
        if (r0 != null) goto L19;
        tt5.a.d(TAG, "createRemoteMediaItem... downloadedFile is null, remoteUrl = " + r7);
        return null;
    L19:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(buildSelectedMediaItem(ensureSelectableLocalPath(r6, r0, r7), r7));     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L14;
        tt5.a.e(TAG, "createRemoteMediaItem... build media item failed, remoteUrl = " + r7, r2, false);
    L14:
        if (Result.isFailure-impl(r8) == true) goto L18;
        r1 = r8;
    L18:
        return (SelectedMediaItem) r1;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleRemoteMediaRequest(String r4, m r5) {
        if (r5 != null) goto L6;
        tt5.a.d(TAG, "handleRemoteMediaRequest... callback is null");
        return;
    L6:
        ChameleonPluginHost r1 = getHost();
        if (r1 == null) goto L17;
        FragmentActivity r2 = r1.getActivity();
        if (r2 == null) goto L17;
        List<String> r6 = parseRemoteUrls(r4);
        if (r6.isEmpty() == false) goto L15;
        tt5.a.d(TAG, "handleRemoteMediaRequest... remoteUrls is empty");
        r5.b(buildFailedJsonData());
        return;
    L15:
        Disposable r7 = Flowable.fromIterable(r6).map(new h(this, r2)).toList().toFlowable().subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new i(r6, r5, this), new j(r5, this));
        this.mCompositeDisposable.add(r7);
        return;
    L17:
        tt5.a.d(TAG, "handleRemoteMediaRequest... activity is null");
        r5.b(buildFailedJsonData());
    }

    public static final /* synthetic */ SelectedMediaItem access$createRemoteMediaItem(OfficeSelectMediaPlugin r0, FragmentActivity r1, String r2) {
        return r0.createRemoteMediaItem(r1, r2);
    }

    public static final /* synthetic */ void access$handleRemoteMediaRequest(OfficeSelectMediaPlugin r0, String r1, m r2) {
        r0.handleRemoteMediaRequest(r1, r2);
    }

    private final String ensureSelectableLocalPath(FragmentActivity r8, File r9, String r10) {
        String r0 = FilesKt.getExtension(r9);
        String r1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r0);
        boolean r2 = true;
        if (r0.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L16;
        if (r1 != null) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L16;
        return r9.getAbsolutePath();
    L10:
        if (StringsKt.startsWith$default(r1, "image/", false, 2, null) != true) goto L12;
    L16:
        File r11 = File.createTempFile(REMOTE_MEDIA_FILE_PREFIX, buildFileSuffix(r10, null), r8.getCacheDir());
        Intrinsics.checkNotNull(r11);
        FilesKt.copyTo$default(r9, r11, true, 0, 4, null);
        return r11.getAbsolutePath();
    L5:
        r3 = false;
        goto L7
    }

    public final Disposable doInsertMediasInternal(List<? extends SelectedMediaItem> r3, m r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "mediaList");
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.h(TAG, "doInsertMediasInternal, mediaList.size = " + r3.size());
        return Flowable.just(r3).flatMap(new e(r3, this)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new f(this, r3, r4), new g(r5, r4, this));
    }

    public final void insertMedias(List<? extends SelectedMediaItem> r2, m r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "mediaList");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.mCompositeDisposable.add(doInsertMediasInternal(r2, r3, r4));
    }
}
