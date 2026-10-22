package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.graphics.drawable.Drawable;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JT\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotParams;", "", "webView", "Landroid/webkit/WebView;", "url", "", "inputViewHeight", "", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "justShowLoading", "", "<init>", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Z)V", "getWebView", "()Landroid/webkit/WebView;", "getUrl", "()Ljava/lang/String;", "getInputViewHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgDrawable", "()Landroid/graphics/drawable/Drawable;", "getListener", "()Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "getJustShowLoading", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Z)Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotParams;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotParams {
    private final Drawable bgDrawable;
    private final Integer inputViewHeight;
    private final boolean justShowLoading;
    private final h listener;
    private final String url;
    private final WebView webView;

    public static /* synthetic */ DocShotParams copy$default(DocShotParams r100, WebView r101, String r102, Integer r103, Drawable r104, h r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.webView;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.url;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.inputViewHeight;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.bgDrawable;
    L14:
        Drawable r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.listener;
    L17:
        h r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.justShowLoading;
    L20:
        WebView r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final WebView component1() {
        return this.webView;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.inputViewHeight;
    }

    public final Drawable component4() {
        return this.bgDrawable;
    }

    public final h component5() {
        return this.listener;
    }

    public final boolean component6() {
        return this.justShowLoading;
    }

    public final DocShotParams copy(WebView r100, String r110, Integer r111, Drawable r112, h r113, boolean r114) {
        return new DocShotParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocShotParams) == true) goto L8;
        return false;
    L8:
        DocShotParams r101 = (DocShotParams) r100;
        if (Intrinsics.areEqual(this.webView, r101.webView) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputViewHeight, r101.inputViewHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgDrawable, r101.bgDrawable) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.listener, r101.listener) == true) goto L24;
        return false;
    L24:
        if (this.justShowLoading == r101.justShowLoading) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        WebView r100 = this.webView;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.inputViewHeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Drawable r110 = this.bgDrawable;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        h r113 = this.listener;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.justShowLoading == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DocShotParams(webView=" + this.webView + ", url=" + this.url + ", inputViewHeight=" + this.inputViewHeight + ", bgDrawable=" + this.bgDrawable + ", listener=" + this.listener + ", justShowLoading=" + this.justShowLoading + ')';
    }

    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    public final Integer getInputViewHeight() {
        return this.inputViewHeight;
    }

    public final boolean getJustShowLoading() {
        return this.justShowLoading;
    }

    public final h getListener() {
        return this.listener;
    }

    public final String getUrl() {
        return this.url;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public DocShotParams(WebView r100, String r101, Integer r102, Drawable r103, h r104, boolean r105) {
        this.webView = r100;
        this.url = r101;
        this.inputViewHeight = r102;
        this.bgDrawable = r103;
        this.listener = r104;
        this.justShowLoading = r105;
    }

    public /* synthetic */ DocShotParams(WebView r100, String r101, Integer r110, Drawable r111, h r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        boolean r102 = false;
    L6:
        this(r100, r101, r110, r111, r112, r102);
        return;
    L5:
        r102 = r113;
        goto L6
    }
}
