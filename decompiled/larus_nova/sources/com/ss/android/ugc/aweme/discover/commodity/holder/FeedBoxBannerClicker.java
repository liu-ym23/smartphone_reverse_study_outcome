package com.ss.android.ugc.aweme.discover.commodity.holder;

import android.view.View;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/FeedBoxBannerClicker;", "", "Params", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FeedBoxBannerClicker {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/FeedBoxBannerClicker$Params;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f450056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f450057b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Params) == false) goto L10;
            Params r101 = (Params) r100;
            if (Intrinsics.areEqual(this.f450056a, r101.f450056a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f450057b, r101.f450057b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            JSONObject r100 = this.f450056a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f450057b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(searchParams=" + this.f450056a + ", sourceMethod=" + this.f450057b + ")";
        }

        public Params(JSONObject r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "searchParams");
            Intrinsics.checkNotNullParameter(r101, "sourceMethod");
            this.f450056a = r100;
            this.f450057b = r101;
        }
    }

    void a(View r100, SearchAggregateCommodity r101, Function1<? super Params, Unit> r102);
}
