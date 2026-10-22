package com.bytedance.ee.bear.bitable.homepage.activity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableActivityResp;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableActivityResp$ActivityData;", "<init>", "()V", "ActivityData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableActivityResp extends Result<ActivityData> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableActivityResp$ActivityData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "homePageData", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/HomePageData;", "Lkotlin/collections/ArrayList;", "getHomePageData", "()Ljava/util/ArrayList;", "setHomePageData", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActivityData implements NonProguard {

        @JSONField(name = "homePageData")
        private ArrayList<HomePageData> homePageData;

        public ActivityData() {
            this.homePageData = new ArrayList();
        }

        public final ArrayList<HomePageData> getHomePageData() {
            return this.homePageData;
        }

        public final void setHomePageData(ArrayList<HomePageData> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.homePageData = r100;
        }
    }

    public BitableActivityResp() {
    }
}
