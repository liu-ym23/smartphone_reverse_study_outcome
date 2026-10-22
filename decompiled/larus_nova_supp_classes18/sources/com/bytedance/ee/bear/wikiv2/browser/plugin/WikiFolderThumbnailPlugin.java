package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiFolderThumbnailPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Companion", "WikiFolderThumbnailHandler", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiFolderThumbnailPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "WikiFolderThumbnailPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<ThumbnailInfo> {
        public final /* synthetic */ WikiFolderThumbnailPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(WikiFolderThumbnailPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r13, tb5.m r14) {
            ThumbnailInfo r15 = (ThumbnailInfo) r13;
            tt5.a.h(WikiFolderThumbnailPlugin.TAG, "get ThumbnailInfo");
            if (r15 != null) goto L10;
            tt5.a.d(WikiFolderThumbnailPlugin.TAG, "ThumbnailInfo is null, return");
            return;
        L10:
            ThumbGlideUrl r0 = new ThumbGlideUrl(r15.getUrl(), r15.getUrl(), 22, r15.getEncryptType(), r15.getEncryptKey(), r15.getEncryptNonce(), ThumbGlideUrl.SOURCE_FOLDER_BLOCK_ICON, false, null);     // Catch: Throwable -> L7
            r0.setIsConnect(Boolean.valueOf(com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()));     // Catch: Throwable -> L7
            Intrinsics.checkNotNull(Glide.with(WikiFolderThumbnailPlugin.access$getContext(this.a)).asBitmap().load(r0).skipMemoryCache(r0.needUpdate(r0.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).into(new g0(r0, r14)));     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            tt5.a.f(WikiFolderThumbnailPlugin.TAG, th, false);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiFolderThumbnailPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(WikiFolderThumbnailPlugin r0) {
        return r0.getContext();
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost, bindBridgeHandler");
        bindBridgeHandler("biz.wiki.getThumbnail", new b(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
