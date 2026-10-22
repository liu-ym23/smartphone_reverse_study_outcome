package com.ss.android.ugc.aweme.search.tabguide;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/search/tabguide/TabGuideInfoForKevaV2;", "", "", "tabType", "Ljava/lang/String;", "getTabType", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "Ljava/util/LinkedList;", "", "clickNumList", "Ljava/util/LinkedList;", "getClickNumList", "()Ljava/util/LinkedList;", "setClickNumList", "(Ljava/util/LinkedList;)V", "showNumList", "getShowNumList", "setShowNumList", "", "lastClickTime", "J", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastStoreTime", "getLastStoreTime", "setLastStoreTime", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabGuideInfoForKevaV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f453395a = null;

    @SerializedName("click_num_list")
    private volatile LinkedList<Integer> clickNumList;

    @SerializedName("last_click_time")
    private volatile long lastClickTime;

    @SerializedName("last_store_time")
    private volatile long lastStoreTime;

    @SerializedName("show_num_list")
    private volatile LinkedList<Integer> showNumList;

    @SerializedName("tab_type")
    private volatile String tabType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/tabguide/TabGuideInfoForKevaV2$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f453395a = new Companion(0);
    }

    public final void a() {
        this.tabType = null;
    }

    public TabGuideInfoForKevaV2() {
        this.tabType = "";
    }
}
