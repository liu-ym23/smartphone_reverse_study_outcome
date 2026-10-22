package com.ss.android.lark.export.entity.preview;

import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0003VWXB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010M\u001a\u00020\u00152\b\u0010N\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010O\u001a\u00020\u00152\b\u0010N\u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u0013\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010R\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\"HÖ\u0001J\t\u0010U\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u001dR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0017R\u001e\u0010<\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010?\u001a\u0004\bE\u0010FR\u0013\u0010G\u001a\u0004\u0018\u00010H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010J¨\u0006Y"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "Ljava/io/Serializable;", "", "Lcom/larksuite/framework/utils/diff/Diffable;", "builder", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$Builder;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$Builder;)V", "getBuilder", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$Builder;", "sourceId", "", "getSourceId", "()Ljava/lang/String;", "previewId", "getPreviewId", "url", "Lcom/ss/android/lark/export/entity/preview/Url;", "getUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "needReload", "", "getNeedReload", "()Z", "netIconKey", "getNetIconKey", "title", "getTitle", d.f25925o, "(Ljava/lang/String;)V", "netUrlTag", "getNetUrlTag", "setNetUrlTag", "version", "", "getVersion", "()I", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "passThroughImage", "Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;", "getPassThroughImage", "()Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;", "setPassThroughImage", "(Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;)V", "isSdkPreview", "appInfo", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "getAppInfo", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "headerInfo", "Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;", "getHeaderInfo", "()Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;", "setHeaderInfo", "(Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;)V", "useColorIcon", "getUseColorIcon", "lastUpdateInfo", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;", "getLastUpdateInfo$annotations", "()V", "getLastUpdateInfo", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;", "singleCardMode", "Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "getSingleCardMode$annotations", "getSingleCardMode", "()Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "ext", "Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;", "getExt", "()Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;", "compareTo", "other", "isItemSame", "diffable", "isContentSame", "component1", "copy", "equals", "", "hashCode", "toString", "Builder", "AppInfo", "LastUpdateInfo", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlInlinePreviewEntity implements Serializable, Comparable<UrlInlinePreviewEntity>, b<UrlInlinePreviewEntity> {
    private final AppInfo appInfo;
    private final Builder builder;
    private final UrlPreviewEntityExt ext;
    private UnifiedHeaderInfo headerInfo;
    private final boolean isSdkPreview;
    private final LastUpdateInfo lastUpdateInfo;
    private final boolean needReload;
    private final String netIconKey;
    private String netUrlTag;
    private ImagePassThrough passThroughImage;
    private final String previewId;
    private final UrlPreviewEntity.SingleCardMode singleCardMode;
    private final String sourceId;
    private String title;
    private final UDIcon udIcon;
    private final Url url;
    private final boolean useColorIcon;
    private final int version;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "Ljava/io/Serializable;", "appId", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getAppId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSceneType", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppInfo implements Serializable {
        private final Long appId;
        private final Long sceneType;

        public static /* synthetic */ AppInfo copy$default(AppInfo r100, Long r101, Long r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.appId;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.sceneType;
        L9:
            return r100.copy(r101, r102);
        }

        public final Long component1() {
            return this.appId;
        }

        public final Long component2() {
            return this.sceneType;
        }

        public final AppInfo copy(Long r100, Long r101) {
            return new AppInfo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AppInfo) == true) goto L8;
            return false;
        L8:
            AppInfo r101 = (AppInfo) r100;
            if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Long r100 = this.appId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.sceneType;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "AppInfo(appId=" + this.appId + ", sceneType=" + this.sceneType + ')';
        }

        public final Long getAppId() {
            return this.appId;
        }

        public final Long getSceneType() {
            return this.sceneType;
        }

        public AppInfo(Long r100, Long r101) {
            this.appId = r100;
            this.sceneType = r101;
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u0010\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010.\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0014J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000108J\u0010\u0010=\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0014J\u0010\u0010F\u001a\u00020\u00002\b\u0010F\u001a\u0004\u0018\u00010GJ\u0010\u0010L\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010MJ\u0010\u0010R\u001a\u00020\u00002\b\u0010R\u001a\u0004\u0018\u00010SJ\u0006\u0010X\u001a\u00020YR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001c\u00107\u001a\u0004\u0018\u000108X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$Builder;", "Ljava/io/Serializable;", "<init>", "()V", "sourceId", "", "getSourceId$chat_preview_export_release", "()Ljava/lang/String;", "setSourceId$chat_preview_export_release", "(Ljava/lang/String;)V", "previewId", "getPreviewId$chat_preview_export_release", "setPreviewId$chat_preview_export_release", "url", "Lcom/ss/android/lark/export/entity/preview/Url;", "getUrl$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/Url;", "setUrl$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/Url;)V", "needReload", "", "getNeedReload$chat_preview_export_release", "()Z", "setNeedReload$chat_preview_export_release", "(Z)V", "netIconKey", "getNetIconKey$chat_preview_export_release", "setNetIconKey$chat_preview_export_release", "title", "getTitle$chat_preview_export_release", "setTitle$chat_preview_export_release", "netUrlTag", "getNetUrlTag$chat_preview_export_release", "setNetUrlTag$chat_preview_export_release", "version", "", "getVersion$chat_preview_export_release", "()I", "setVersion$chat_preview_export_release", "(I)V", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "getUdIcon$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "passThroughImage", "Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;", "getPassThroughImage$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;", "setPassThroughImage$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/ImagePassThrough;)V", "isSdkPreview", "isSdkPreview$chat_preview_export_release", "setSdkPreview$chat_preview_export_release", "appInfo", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "getAppInfo$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;", "setAppInfo$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$AppInfo;)V", "headerInfo", "Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;", "getHeaderInfo$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;", "setHeaderInfo$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;)V", "useColorIcon", "getUseColorIcon$chat_preview_export_release", "setUseColorIcon$chat_preview_export_release", "lastUpdateInfo", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;", "getLastUpdateInfo$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;", "setLastUpdateInfo$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;)V", "singleCardMode", "Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "getSingleCardMode$chat_preview_export_release", "()Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "setSingleCardMode$chat_preview_export_release", "(Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity$SingleCardMode;)V", "ext", "Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;", "getExt$chat_preview_export_release", "()Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;", "setExt$chat_preview_export_release", "(Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;)V", "build", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder implements Serializable {
        private AppInfo appInfo;
        private UrlPreviewEntityExt ext;
        private UnifiedHeaderInfo headerInfo;
        private boolean isSdkPreview;
        private LastUpdateInfo lastUpdateInfo;
        private boolean needReload;
        private String netIconKey;
        private String netUrlTag;
        private ImagePassThrough passThroughImage;
        private String previewId;
        private UrlPreviewEntity.SingleCardMode singleCardMode;
        private String sourceId;
        private String title;
        private UDIcon udIcon;
        private Url url;
        private boolean useColorIcon;
        private int version;

        public final UrlInlinePreviewEntity build() {
            return new UrlInlinePreviewEntity(this);
        }

        public Builder() {
            this.sourceId = "";
            this.previewId = "";
        }

        public final AppInfo getAppInfo$chat_preview_export_release() {
            return this.appInfo;
        }

        public final UrlPreviewEntityExt getExt$chat_preview_export_release() {
            return this.ext;
        }

        public final UnifiedHeaderInfo getHeaderInfo$chat_preview_export_release() {
            return this.headerInfo;
        }

        public final LastUpdateInfo getLastUpdateInfo$chat_preview_export_release() {
            return this.lastUpdateInfo;
        }

        public final boolean getNeedReload$chat_preview_export_release() {
            return this.needReload;
        }

        public final String getNetIconKey$chat_preview_export_release() {
            return this.netIconKey;
        }

        public final String getNetUrlTag$chat_preview_export_release() {
            return this.netUrlTag;
        }

        public final ImagePassThrough getPassThroughImage$chat_preview_export_release() {
            return this.passThroughImage;
        }

        public final String getPreviewId$chat_preview_export_release() {
            return this.previewId;
        }

        public final UrlPreviewEntity.SingleCardMode getSingleCardMode$chat_preview_export_release() {
            return this.singleCardMode;
        }

        public final String getSourceId$chat_preview_export_release() {
            return this.sourceId;
        }

        public final String getTitle$chat_preview_export_release() {
            return this.title;
        }

        public final UDIcon getUdIcon$chat_preview_export_release() {
            return this.udIcon;
        }

        public final Url getUrl$chat_preview_export_release() {
            return this.url;
        }

        public final boolean getUseColorIcon$chat_preview_export_release() {
            return this.useColorIcon;
        }

        public final int getVersion$chat_preview_export_release() {
            return this.version;
        }

        public final boolean isSdkPreview$chat_preview_export_release() {
            return this.isSdkPreview;
        }

        public final Builder appInfo(AppInfo r100) {
            this.appInfo = r100;
            return this;
        }

        public final Builder ext(UrlPreviewEntityExt r100) {
            this.ext = r100;
            return this;
        }

        public final Builder headerInfo(UnifiedHeaderInfo r100) {
            this.headerInfo = r100;
            return this;
        }

        public final Builder isSdkPreview(boolean r100) {
            this.isSdkPreview = r100;
            return this;
        }

        public final Builder lastUpdateInfo(LastUpdateInfo r100) {
            this.lastUpdateInfo = r100;
            return this;
        }

        public final Builder needReload(boolean r100) {
            this.needReload = r100;
            return this;
        }

        public final Builder netIconKey(String r100) {
            this.netIconKey = r100;
            return this;
        }

        public final Builder netUrlTag(String r100) {
            this.netUrlTag = r100;
            return this;
        }

        public final Builder passThroughImage(ImagePassThrough r100) {
            this.passThroughImage = r100;
            return this;
        }

        public final Builder previewId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            this.previewId = r100;
            return this;
        }

        public final void setAppInfo$chat_preview_export_release(AppInfo r100) {
            this.appInfo = r100;
        }

        public final void setExt$chat_preview_export_release(UrlPreviewEntityExt r100) {
            this.ext = r100;
        }

        public final void setHeaderInfo$chat_preview_export_release(UnifiedHeaderInfo r100) {
            this.headerInfo = r100;
        }

        public final void setLastUpdateInfo$chat_preview_export_release(LastUpdateInfo r100) {
            this.lastUpdateInfo = r100;
        }

        public final void setNeedReload$chat_preview_export_release(boolean r100) {
            this.needReload = r100;
        }

        public final void setNetIconKey$chat_preview_export_release(String r100) {
            this.netIconKey = r100;
        }

        public final void setNetUrlTag$chat_preview_export_release(String r100) {
            this.netUrlTag = r100;
        }

        public final void setPassThroughImage$chat_preview_export_release(ImagePassThrough r100) {
            this.passThroughImage = r100;
        }

        public final void setPreviewId$chat_preview_export_release(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.previewId = r100;
        }

        public final void setSdkPreview$chat_preview_export_release(boolean r100) {
            this.isSdkPreview = r100;
        }

        public final void setSingleCardMode$chat_preview_export_release(UrlPreviewEntity.SingleCardMode r100) {
            this.singleCardMode = r100;
        }

        public final void setSourceId$chat_preview_export_release(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.sourceId = r100;
        }

        public final void setTitle$chat_preview_export_release(String r100) {
            this.title = r100;
        }

        public final void setUdIcon$chat_preview_export_release(UDIcon r100) {
            this.udIcon = r100;
        }

        public final void setUrl$chat_preview_export_release(Url r100) {
            this.url = r100;
        }

        public final void setUseColorIcon$chat_preview_export_release(boolean r100) {
            this.useColorIcon = r100;
        }

        public final void setVersion$chat_preview_export_release(int r100) {
            this.version = r100;
        }

        public final Builder singleCardMode(UrlPreviewEntity.SingleCardMode r100) {
            this.singleCardMode = r100;
            return this;
        }

        public final Builder sourceId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sourceId");
            this.sourceId = r100;
            return this;
        }

        public final Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public final Builder udIcon(UDIcon r100) {
            this.udIcon = r100;
            return this;
        }

        public final Builder url(Url r100) {
            this.url = r100;
            return this;
        }

        public final Builder useColorIcon(boolean r100) {
            this.useColorIcon = r100;
            return this;
        }

        public final Builder version(int r100) {
            this.version = r100;
            return this;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity$LastUpdateInfo;", "Ljava/io/Serializable;", "timestampInSeconds", "", "textColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "visible", "", "<init>", "(JLcom/ss/android/lark/export/entity/preview/ThemeColor;Z)V", "getTimestampInSeconds", "()J", "getTextColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getVisible", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LastUpdateInfo implements Serializable {
        private final ThemeColor textColor;
        private final long timestampInSeconds;
        private final boolean visible;

        public static /* synthetic */ LastUpdateInfo copy$default(LastUpdateInfo r100, long r101, ThemeColor r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.timestampInSeconds;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.textColor;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.visible;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final long component1() {
            return this.timestampInSeconds;
        }

        public final ThemeColor component2() {
            return this.textColor;
        }

        public final boolean component3() {
            return this.visible;
        }

        public final LastUpdateInfo copy(long r100, ThemeColor r101, boolean r102) {
            return new LastUpdateInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LastUpdateInfo) == true) goto L8;
            return false;
        L8:
            LastUpdateInfo r101 = (LastUpdateInfo) r100;
            if (this.timestampInSeconds == r101.timestampInSeconds) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
            return false;
        L15:
            if (this.visible == r101.visible) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            long r100 = this.timestampInSeconds;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            ThemeColor r102 = this.textColor;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r101 + r103) * 31;
            if (this.visible == false) goto L9;
            int r105 = 1231;
        L11:
            return r104 + r105;
        L9:
            r105 = 1237;
            goto L11
        L5:
            r103 = r102.hashCode();
            goto L6
        }

        public String toString() {
            return "LastUpdateInfo(timestampInSeconds=" + this.timestampInSeconds + ", textColor=" + this.textColor + ", visible=" + this.visible + ')';
        }

        public final ThemeColor getTextColor() {
            return this.textColor;
        }

        public final long getTimestampInSeconds() {
            return this.timestampInSeconds;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public LastUpdateInfo(long r100, ThemeColor r101, boolean r102) {
            this.timestampInSeconds = r100;
            this.textColor = r101;
            this.visible = r102;
        }
    }

    public static /* synthetic */ UrlInlinePreviewEntity copy$default(UrlInlinePreviewEntity r100, Builder r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.builder;
    L6:
        return r100.copy(r101);
    }

    @Deprecated(message = "迁移到 ext 中")
    public static /* synthetic */ void getLastUpdateInfo$annotations() {
    }

    @Deprecated(message = "迁移到 ext 中")
    public static /* synthetic */ void getSingleCardMode$annotations() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UrlInlinePreviewEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return 0;
    }

    public final Builder component1() {
        return this.builder;
    }

    public final UrlInlinePreviewEntity copy(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        return new UrlInlinePreviewEntity(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlInlinePreviewEntity) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.builder, ((UrlInlinePreviewEntity) r100).builder) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public String toString() {
        return "UrlInlinePreviewEntity(builder=" + this.builder + ')';
    }

    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    public final UrlPreviewEntityExt getExt() {
        return this.ext;
    }

    public final UnifiedHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public final LastUpdateInfo getLastUpdateInfo() {
        return this.lastUpdateInfo;
    }

    public final boolean getNeedReload() {
        return this.needReload;
    }

    public final String getNetIconKey() {
        return this.netIconKey;
    }

    public final String getNetUrlTag() {
        return this.netUrlTag;
    }

    public final ImagePassThrough getPassThroughImage() {
        return this.passThroughImage;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final UrlPreviewEntity.SingleCardMode getSingleCardMode() {
        return this.singleCardMode;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public final Url getUrl() {
        return this.url;
    }

    public final boolean getUseColorIcon() {
        return this.useColorIcon;
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean isSdkPreview() {
        return this.isSdkPreview;
    }

    public UrlInlinePreviewEntity(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.builder = r100;
        this.sourceId = r100.getSourceId$chat_preview_export_release();
        this.previewId = r100.getPreviewId$chat_preview_export_release();
        this.url = r100.getUrl$chat_preview_export_release();
        this.needReload = r100.getNeedReload$chat_preview_export_release();
        this.netIconKey = r100.getNetIconKey$chat_preview_export_release();
        this.title = r100.getTitle$chat_preview_export_release();
        this.netUrlTag = r100.getNetUrlTag$chat_preview_export_release();
        this.version = r100.getVersion$chat_preview_export_release();
        this.udIcon = r100.getUdIcon$chat_preview_export_release();
        this.passThroughImage = r100.getPassThroughImage$chat_preview_export_release();
        this.isSdkPreview = r100.isSdkPreview$chat_preview_export_release();
        this.appInfo = r100.getAppInfo$chat_preview_export_release();
        this.headerInfo = r100.getHeaderInfo$chat_preview_export_release();
        this.useColorIcon = r100.getUseColorIcon$chat_preview_export_release();
        this.lastUpdateInfo = r100.getLastUpdateInfo$chat_preview_export_release();
        this.singleCardMode = r100.getSingleCardMode$chat_preview_export_release();
        this.ext = r100.getExt$chat_preview_export_release();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UrlInlinePreviewEntity r100) {
        return compareTo2(r100);
    }

    public boolean isContentSame(UrlInlinePreviewEntity r100) {
        Url r101 = this.url;
        if (r100 == null) goto L5;
        Url r102 = r100.url;
    L7:
        if (y28.a.c(r101, r102) == true) goto L10;
        return false;
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.netIconKey, r100.netIconKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r100.title) == true) goto L24;
        return false;
    L24:
        if (y28.a.c(this.udIcon, r100.udIcon) == true) goto L27;
        return false;
    L27:
        if (y28.a.c(this.passThroughImage, r100.passThroughImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.headerInfo, r100.headerInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lastUpdateInfo, r100.lastUpdateInfo) == true) goto L36;
        return false;
    L36:
        if (this.singleCardMode == r100.singleCardMode) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.ext, r100.ext) == true) goto L41;
        return false;
    L41:
        return true;
    L12:
        if (this.needReload != r100.needReload) goto L14;
        r103 = true;
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    public boolean isItemSame(UrlInlinePreviewEntity r100) {
        String r101 = this.sourceId;
        if (r100 == null) goto L5;
        String r102 = r100.sourceId;
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.previewId, r100.previewId) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public final void setHeaderInfo(UnifiedHeaderInfo r100) {
        this.headerInfo = r100;
    }

    public final void setNetUrlTag(String r100) {
        this.netUrlTag = r100;
    }

    public final void setPassThroughImage(ImagePassThrough r100) {
        this.passThroughImage = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UrlInlinePreviewEntity) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UrlInlinePreviewEntity) r100);
    }
}
