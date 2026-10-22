package com.ss.android.lark.export.entity.preview;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006!"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Url;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "url", "", "iosUrl", "androidUrl", "pcUrl", NativeDownloadModel.JsonKey.WEB_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getIosUrl", "getAndroidUrl", "getPcUrl", "getWebUrl", "isItemSame", "", "diffable", "isContentSame", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Url implements Serializable, b<Url> {
    private final String androidUrl;
    private final String iosUrl;
    private final String pcUrl;
    private final String url;
    private final String webUrl;

    public static /* synthetic */ Url copy$default(Url r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.iosUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.androidUrl;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.pcUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.webUrl;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.iosUrl;
    }

    public final String component3() {
        return this.androidUrl;
    }

    public final String component4() {
        return this.pcUrl;
    }

    public final String component5() {
        return this.webUrl;
    }

    public final Url copy(String r100, String r101, String r110, String r111, String r112) {
        return new Url(r100, r101, r110, r111, r112);
    }

    public String toString() {
        return "Url(url=" + this.url + ", iosUrl=" + this.iosUrl + ", androidUrl=" + this.androidUrl + ", pcUrl=" + this.pcUrl + ", webUrl=" + this.webUrl + ')';
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.iosUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.androidUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.pcUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.webUrl;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String getAndroidUrl() {
        return this.androidUrl;
    }

    public final String getIosUrl() {
        return this.iosUrl;
    }

    public final String getPcUrl() {
        return this.pcUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Url) == true) goto L8;
        return false;
    L8:
        Url r101 = (Url) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iosUrl, r101.iosUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.androidUrl, r101.androidUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pcUrl, r101.pcUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Url) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Url) r100);
    }

    public boolean isContentSame(Url r100) {
        return equals(r100);
    }

    public boolean isItemSame(Url r100) {
        return equals(r100);
    }

    public Url(String r100, String r101, String r102, String r103, String r104) {
        this.url = r100;
        this.iosUrl = r101;
        this.androidUrl = r102;
        this.pcUrl = r103;
        this.webUrl = r104;
    }
}
