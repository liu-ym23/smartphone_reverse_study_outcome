package com.bytedance.ies.bullet.base.settings;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR*\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\t¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/l;", "", "", "", "disallowListWeb", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "setDisallowListWeb", "(Ljava/util/List;)V", "disallowListLynx", "f", "setDisallowListLynx", "allowListWeb", "c", "setAllowListWeb", "allowListLynx", "b", "setAllowListLynx", "", "enableSession", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "l", "(Ljava/lang/Boolean;)V", "bufferMode", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setBufferMode", "(Ljava/lang/String;)V", "delegateUpdateByGecko", "e", "setDelegateUpdateByGecko", "allowFeelingRedirection", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAllowFeelingRedirection", "enableTTWebViewDelegate", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "setEnableTTWebViewDelegate", "(Z)V", "ttWebViewDelegateAllowList", ce.f26395j, "setTtWebViewDelegateAllowList", "ttWebViewDelegateDisallowList", ce.f26396k, "setTtWebViewDelegateDisallowList", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("allow_feeling_redirection")
    private Boolean allowFeelingRedirection;

    @SerializedName("allow_list_lynx")
    private List<String> allowListLynx;

    @SerializedName("allow_list_web")
    private List<String> allowListWeb;

    @SerializedName("buffer_mode")
    private String bufferMode;

    @SerializedName("delegate_update_by_gecko")
    private Boolean delegateUpdateByGecko;

    @SerializedName("disallow_list_lynx")
    private List<String> disallowListLynx;

    @SerializedName("disallow_list_web")
    private List<String> disallowListWeb;

    @SerializedName("enable_session")
    private Boolean enableSession;

    @SerializedName("enable_ttwebview_delegate")
    private boolean enableTTWebViewDelegate;

    @SerializedName("ttwebview_delegate_allow_list")
    private List<String> ttWebViewDelegateAllowList;

    @SerializedName("ttwebview_delegate_disallow_list")
    private List<String> ttWebViewDelegateDisallowList;

    public l() {
        this.disallowListWeb = CollectionsKt.emptyList();
        this.disallowListLynx = CollectionsKt.emptyList();
        this.allowListWeb = CollectionsKt.emptyList();
        this.allowListLynx = CollectionsKt.emptyList();
        Boolean r100 = Boolean.TRUE;
        this.enableSession = r100;
        this.bufferMode = "normal";
        this.delegateUpdateByGecko = Boolean.FALSE;
        this.allowFeelingRedirection = r100;
        this.enableTTWebViewDelegate = true;
    }

    public final Boolean a() {
        return this.allowFeelingRedirection;
    }

    public final List<String> b() {
        return this.allowListLynx;
    }

    public final List<String> c() {
        return this.allowListWeb;
    }

    public final String d() {
        return this.bufferMode;
    }

    public final Boolean e() {
        return this.delegateUpdateByGecko;
    }

    public final List<String> f() {
        return this.disallowListLynx;
    }

    public final List<String> g() {
        return this.disallowListWeb;
    }

    public final Boolean h() {
        return this.enableSession;
    }

    public final boolean i() {
        return this.enableTTWebViewDelegate;
    }

    public final List<String> j() {
        return this.ttWebViewDelegateAllowList;
    }

    public final List<String> k() {
        return this.ttWebViewDelegateDisallowList;
    }

    public final void l(Boolean r100) {
        this.enableSession = r100;
    }
}
