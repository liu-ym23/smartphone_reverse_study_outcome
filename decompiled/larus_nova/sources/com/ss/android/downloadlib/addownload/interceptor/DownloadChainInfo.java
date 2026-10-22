package com.ss.android.downloadlib.addownload.interceptor;

import android.content.Context;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.CommonDownloadHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003Je\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00063"}, d2 = {"Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;", "", "nativeDownloadModel", "Lcom/ss/android/downloadad/api/model/NativeDownloadModel;", "clickType", "", "source", "isNormalScene", "", "downloadHandler", "Lcom/ss/android/downloadlib/addownload/CommonDownloadHandler;", "downloadModel", "Lcom/ss/android/download/api/download/DownloadModel;", "downloadInfo", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "downloadExtraInfo", "Lorg/json/JSONObject;", "(Lcom/ss/android/downloadad/api/model/NativeDownloadModel;IIZLcom/ss/android/downloadlib/addownload/CommonDownloadHandler;Lcom/ss/android/download/api/download/DownloadModel;Lcom/ss/android/socialbase/downloader/model/DownloadInfo;Landroid/content/Context;Lorg/json/JSONObject;)V", "getClickType", "()I", "getContext", "()Landroid/content/Context;", "getDownloadExtraInfo", "()Lorg/json/JSONObject;", "getDownloadHandler", "()Lcom/ss/android/downloadlib/addownload/CommonDownloadHandler;", "getDownloadInfo", "()Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "getDownloadModel", "()Lcom/ss/android/download/api/download/DownloadModel;", "()Z", "getNativeDownloadModel", "()Lcom/ss/android/downloadad/api/model/NativeDownloadModel;", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class DownloadChainInfo {
    private final int clickType;
    private final Context context;
    private final JSONObject downloadExtraInfo;
    private final CommonDownloadHandler downloadHandler;
    private final DownloadInfo downloadInfo;
    private final DownloadModel downloadModel;
    private final boolean isNormalScene;
    private final NativeDownloadModel nativeDownloadModel;
    private final int source;

    public static /* synthetic */ DownloadChainInfo copy$default(DownloadChainInfo r110, NativeDownloadModel r111, int r112, int r113, boolean r114, CommonDownloadHandler r115, DownloadModel r116, DownloadInfo r117, Context r118, JSONObject r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        NativeDownloadModel r100 = r110.nativeDownloadModel;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.clickType;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.source;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.isNormalScene;
    L19:
        if ((r210 & 16) == 0) goto L21;
        CommonDownloadHandler r104 = r110.downloadHandler;
    L23:
        if ((r210 & 32) == 0) goto L25;
        DownloadModel r105 = r110.downloadModel;
    L27:
        if ((r210 & 64) == 0) goto L29;
        DownloadInfo r106 = r110.downloadInfo;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Context r107 = r110.context;
    L35:
        if ((r210 & 256) == 0) goto L37;
        JSONObject r108 = r110.downloadExtraInfo;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final NativeDownloadModel component1() {
        return this.nativeDownloadModel;
    }

    public final int component2() {
        return this.clickType;
    }

    public final int component3() {
        return this.source;
    }

    public final boolean component4() {
        return this.isNormalScene;
    }

    public final CommonDownloadHandler component5() {
        return this.downloadHandler;
    }

    public final DownloadModel component6() {
        return this.downloadModel;
    }

    public final DownloadInfo component7() {
        return this.downloadInfo;
    }

    public final Context component8() {
        return this.context;
    }

    public final JSONObject component9() {
        return this.downloadExtraInfo;
    }

    public final DownloadChainInfo copy(NativeDownloadModel r110, int r111, int r112, boolean r113, CommonDownloadHandler r114, DownloadModel r115, DownloadInfo r116, Context r117, JSONObject r210) {
        return new DownloadChainInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DownloadChainInfo) == false) goto L24;
        DownloadChainInfo r101 = (DownloadChainInfo) r100;
        if (Intrinsics.areEqual(this.nativeDownloadModel, r101.nativeDownloadModel) == true) goto L8;
        return false;
    L8:
        if (this.clickType == r101.clickType) goto L10;
        return false;
    L10:
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (this.isNormalScene == r101.isNormalScene) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.downloadHandler, r101.downloadHandler) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.downloadModel, r101.downloadModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.downloadInfo, r101.downloadInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.downloadExtraInfo, r101.downloadExtraInfo) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public int hashCode() {
        NativeDownloadModel r100 = this.nativeDownloadModel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.clickType) * 31) + this.source) * 31;
        boolean r104 = this.isNormalScene;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        CommonDownloadHandler r107 = this.downloadHandler;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        DownloadModel r110 = this.downloadModel;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        DownloadInfo r113 = this.downloadInfo;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Context r116 = this.context;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.downloadExtraInfo;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DownloadChainInfo(nativeDownloadModel=" + this.nativeDownloadModel + ", clickType=" + this.clickType + ", source=" + this.source + ", isNormalScene=" + this.isNormalScene + ", downloadHandler=" + this.downloadHandler + ", downloadModel=" + this.downloadModel + ", downloadInfo=" + this.downloadInfo + ", context=" + this.context + ", downloadExtraInfo=" + this.downloadExtraInfo + ")";
    }

    public final int getClickType() {
        return this.clickType;
    }

    public final Context getContext() {
        return this.context;
    }

    public final JSONObject getDownloadExtraInfo() {
        return this.downloadExtraInfo;
    }

    public final CommonDownloadHandler getDownloadHandler() {
        return this.downloadHandler;
    }

    public final DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public final DownloadModel getDownloadModel() {
        return this.downloadModel;
    }

    public final NativeDownloadModel getNativeDownloadModel() {
        return this.nativeDownloadModel;
    }

    public final int getSource() {
        return this.source;
    }

    public final boolean isNormalScene() {
        return this.isNormalScene;
    }

    public DownloadChainInfo(NativeDownloadModel r100, int r101, int r102, boolean r103, CommonDownloadHandler r104, DownloadModel r105, DownloadInfo r106, Context r107, JSONObject r108) {
        this.nativeDownloadModel = r100;
        this.clickType = r101;
        this.source = r102;
        this.isNormalScene = r103;
        this.downloadHandler = r104;
        this.downloadModel = r105;
        this.downloadInfo = r106;
        this.context = r107;
        this.downloadExtraInfo = r108;
    }
}
