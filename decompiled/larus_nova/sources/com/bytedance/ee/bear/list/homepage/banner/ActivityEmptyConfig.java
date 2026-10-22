package com.bytedance.ee.bear.list.homepage.banner;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/ActivityEmptyConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "button", "getButton", "setButton", "buttonUrl", "getButtonUrl", "setButtonUrl", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityEmptyConfig implements NonProguard {
    private String button;
    private String buttonUrl;
    private String desc;
    private String title;

    public ActivityEmptyConfig() {
        this.title = "";
        this.desc = "";
        this.button = "";
        this.buttonUrl = "";
    }

    public final String getButton() {
        return this.button;
    }

    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setButton(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.button = r100;
    }

    public final void setButtonUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonUrl = r100;
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }
}
