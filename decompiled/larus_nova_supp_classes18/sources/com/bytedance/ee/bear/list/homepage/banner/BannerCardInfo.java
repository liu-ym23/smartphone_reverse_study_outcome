package com.bytedance.ee.bear.list.homepage.banner;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/BannerCardInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "cover", "getCover", "setCover", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerCardInfo implements NonProguard {
    private String cover;
    private String redirectUrl;
    private String title;

    public BannerCardInfo() {
        this.title = "";
        this.cover = "";
        this.redirectUrl = "";
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCover(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cover = r2;
    }

    public final void setRedirectUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.redirectUrl = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }
}
