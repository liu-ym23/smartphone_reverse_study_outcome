package com.ss.android.ugc.aweme.search.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/SugExtra;", "Ljava/io/Serializable;", "()V", "sugServerExtra", "", "getSugServerExtra", "()Ljava/lang/String;", "setSugServerExtra", "(Ljava/lang/String;)V", "sugSource", "getSugSource", "setSugSource", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SugExtra implements Serializable {
    public static final Companion Companion = null;

    @SerializedName("sug_server_extra")
    private String sugServerExtra;

    @SerializedName("sug_source")
    private String sugSource;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/SugExtra$Companion;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public SugExtra() {
    }

    public final String getSugServerExtra() {
        return this.sugServerExtra;
    }

    public final String getSugSource() {
        return this.sugSource;
    }

    @JvmStatic
    public static final String getSugSource(SearchEnterParam r100) {
        Companion.getClass();
        if (r100 == null) goto L8;
        SugExtra r101 = r100.getSugExtra();
        if (r101 == null) goto L8;
        String r102 = r101.getSugSource();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "ecom_order";
    }

    public final void setSugServerExtra(String r100) {
        this.sugServerExtra = r100;
    }

    public final void setSugSource(String r100) {
        this.sugSource = r100;
    }
}
