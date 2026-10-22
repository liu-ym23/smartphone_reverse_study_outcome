package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/ECMallPopupRenderOptConfig;", "Ljava/io/Serializable;", "", "strategy", "I", "getStrategy", "()I", "setStrategy", "(I)V", "pageCardStrategy", "getPageCardStrategy", "setPageCardStrategy", "", "", "enabledPages", "Ljava/util/List;", "getEnabledPages", "()Ljava/util/List;", "setEnabledPages", "(Ljava/util/List;)V", "<init>", "()V", "Companion", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPopupRenderOptConfig implements Serializable {
    public static final a Companion = null;
    public static final Lazy a = null;

    @SerializedName("enabled_pages")
    private List<String> enabledPages;

    @SerializedName("page_card_strategy")
    private int pageCardStrategy;

    @SerializedName("strategy")
    private int strategy;

    public static final class a {
        public a() {
        }

        public static ECMallPopupRenderOptConfig a() {
            return (ECMallPopupRenderOptConfig) ECMallPopupRenderOptConfig.access$getConfig$cp().getValue();
        }

        public static int b(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return 0;
        L11:
            List<String> r4 = a().getEnabledPages();
            if (r4 != null) goto L14;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == true) goto L26;
            List<String> r6 = a().getEnabledPages();
            if (r6 != null) goto L22;
        L24:
            return 0;
        L22:
            if (r6.contains(r3) != true) goto L24;
        L26:
            return a().getStrategy();
        L14:
            if (r4.isEmpty() == true) goto L17;
            r5 = false;
            goto L18
        L5:
            if (r3.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    public ECMallPopupRenderOptConfig() {
    }

    static {
        Companion = new a();
        a = LazyKt.lazy(ECMallPopupRenderOptConfig$Companion$config$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getConfig$cp() {
        return a;
    }

    public final List<String> getEnabledPages() {
        return this.enabledPages;
    }

    public final int getPageCardStrategy() {
        return this.pageCardStrategy;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public final void setEnabledPages(List<String> r1) {
        this.enabledPages = r1;
    }

    public final void setPageCardStrategy(int r1) {
        this.pageCardStrategy = r1;
    }

    public final void setStrategy(int r1) {
        this.strategy = r1;
    }
}
