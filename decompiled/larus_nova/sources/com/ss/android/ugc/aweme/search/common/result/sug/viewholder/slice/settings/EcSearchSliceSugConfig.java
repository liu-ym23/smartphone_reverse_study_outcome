package com.ss.android.ugc.aweme.search.common.result.sug.viewholder.slice.settings;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR2\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00170\fj\b\u0012\u0004\u0012\u00020\u0017`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/viewholder/slice/settings/EcSearchSliceSugConfig;", "", "", "biz", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setBiz", "(Ljava/lang/String;)V", "geckoChannel", "b", "setGeckoChannel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "libraToSlice", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setLibraToSlice", "(Ljava/util/ArrayList;)V", "settingsToSlice", "e", "setSettingsToSlice", "Lcom/ss/android/ugc/aweme/search/common/result/sug/viewholder/slice/settings/EcSearchSliceSugConfig$PreloadConfig;", "preloadList", "d", "setPreloadList", "<init>", "()V", "PreloadConfig", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcSearchSliceSugConfig {

    @SerializedName("biz")
    private String biz;

    @SerializedName("gecko_channel")
    private String geckoChannel;

    @SerializedName("libra_to_slice")
    private ArrayList<String> libraToSlice;

    @SerializedName("preload_list")
    private ArrayList<PreloadConfig> preloadList;

    @SerializedName("settings_to_slice")
    private ArrayList<String> settingsToSlice;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/viewholder/slice/settings/EcSearchSliceSugConfig$PreloadConfig;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "inHouseUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ce.f26391f, "onlineUrl", "d", ce.f26395j, "", "num", "I", "c", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "viewHolderType", "f", "setViewHolderType", "viewHolderCachePoolSize", "e", "setViewHolderCachePoolSize", "<init>", "()V", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreloadConfig {

        @SerializedName("inhouse_url")
        private String inHouseUrl;

        @SerializedName("name")
        private String name;

        @SerializedName("num")
        private int num;

        @SerializedName("online_url")
        private String onlineUrl;

        @SerializedName("view_holder_cache_pool_size")
        private int viewHolderCachePoolSize;

        @SerializedName("view_holder_type")
        private int viewHolderType;

        public final void g() {
            Intrinsics.checkNotNullParameter("https://tosv.byted.org/obj/gecko-internal/ecsearch/fe/douyin/ec_search_slice_sug/sug/main.json", "<set-?>");
            this.inHouseUrl = "https://tosv.byted.org/obj/gecko-internal/ecsearch/fe/douyin/ec_search_slice_sug/sug/main.json";
        }

        public final void h() {
            Intrinsics.checkNotNullParameter("sug", "<set-?>");
            this.name = "sug";
        }

        public final void i() {
            this.num = 10;
        }

        public final void j() {
            Intrinsics.checkNotNullParameter("https://lf-dy-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/ecsearch/fe/douyin/ec_search_slice_sug/sug/main.json", "<set-?>");
            this.onlineUrl = "https://lf-dy-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/ecsearch/fe/douyin/ec_search_slice_sug/sug/main.json";
        }

        public PreloadConfig() {
            this.name = "";
            this.inHouseUrl = "";
            this.onlineUrl = "";
            this.viewHolderType = 3;
            this.viewHolderCachePoolSize = 10;
        }

        public final String a() {
            return this.inHouseUrl;
        }

        public final String b() {
            return this.name;
        }

        public final int c() {
            return this.num;
        }

        public final String d() {
            return this.onlineUrl;
        }

        public final int e() {
            return this.viewHolderCachePoolSize;
        }

        public final int f() {
            return this.viewHolderType;
        }
    }

    public EcSearchSliceSugConfig() {
        this.biz = "";
        this.geckoChannel = "";
        this.libraToSlice = new ArrayList();
        this.settingsToSlice = new ArrayList();
        this.preloadList = new ArrayList();
    }

    public final String a() {
        return this.biz;
    }

    public final String b() {
        return this.geckoChannel;
    }

    public final ArrayList<String> c() {
        return this.libraToSlice;
    }

    public final ArrayList<PreloadConfig> d() {
        return this.preloadList;
    }

    public final ArrayList<String> e() {
        return this.settingsToSlice;
    }
}
