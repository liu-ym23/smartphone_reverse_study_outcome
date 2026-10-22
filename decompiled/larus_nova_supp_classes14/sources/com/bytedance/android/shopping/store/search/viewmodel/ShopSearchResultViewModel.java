package com.bytedance.android.shopping.store.search.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0000H\u0002J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u0019X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/store/search/viewmodel/ShopSearchResultViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "()V", "data", "Landroid/content/Intent;", "getData", "()Landroid/content/Intent;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "isFormSearchActivity", "", "()Z", "setFormSearchActivity", "(Z)V", "mRecordTime", "getMRecordTime", "setMRecordTime", "mToNewPage", "getMToNewPage", "setMToNewPage", "pageBtm", "", "getPageBtm", "()Ljava/lang/String;", "searchParam", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "initData", "", "bundle", "Landroid/os/Bundle;", "reportDuration", "viewModel", "traceTimeEnd", "traceTimePause", "traceTimeStart", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultViewModel extends BaseViewModel {
    private final Intent data;
    private long duration;
    private boolean isFormSearchActivity;
    private long mRecordTime;
    private boolean mToNewPage;
    private final String pageBtm;
    public ECShopSearchParam searchParam;

    public ShopSearchResultViewModel() {
        super(null, null, 3, null);
        this.pageBtm = "a1.b7881";
        this.mRecordTime = SystemClock.elapsedRealtime();
        this.mToNewPage = true;
        this.data = new Intent();
        this.isFormSearchActivity = true;
    }

    public final ECShopSearchParam getSearchParam() {
        ECShopSearchParam r0 = this.searchParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        return r0;
    }

    public final void traceTimePause() {
        this.duration += SystemClock.elapsedRealtime() - this.mRecordTime;
    }

    public final void traceTimeStart() {
        this.mRecordTime = SystemClock.elapsedRealtime();
    }

    public final Intent getData() {
        return this.data;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getMRecordTime() {
        return this.mRecordTime;
    }

    public final boolean getMToNewPage() {
        return this.mToNewPage;
    }

    public final String getPageBtm() {
        return this.pageBtm;
    }

    public final boolean isFormSearchActivity() {
        return this.isFormSearchActivity;
    }

    public final void traceTimeEnd() {
        reportDuration(this);
    }

    private final void reportDuration(ShopSearchResultViewModel r11) {
        String r0 = this.pageBtm;
        PageFinder r1 = PageFinder.via(this);
        Pair[] r3 = new Pair[2];
        r3[0] = TuplesKt.to("duration", String.valueOf(this.duration / ((long) ECDraweeView.SQUARE)));
        ECShopSearchParam r4 = r11.searchParam;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        r3[1] = TuplesKt.to("search_word", r4.getSearchKeyword());
        Map r5 = MapsKt.mutableMapOf(r3);
        Pair[] r6 = new Pair[16];
        ECShopSearchParam r8 = r11.searchParam;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L8:
        r6[0] = TuplesKt.to("shop_id", r8.getShopId());
        ECShopSearchParam r7 = r11.searchParam;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L11:
        r6[1] = TuplesKt.to("follow_status", String.valueOf(r7.getFollowStatus()));
        ECShopSearchParam r9 = r11.searchParam;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L14:
        r6[2] = TuplesKt.to("entrance_info", r9.getEntranceInfo());
        ECShopSearchParam r2 = r11.searchParam;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L17:
        r6[3] = TuplesKt.to("author_id", r2.getAuthorId());
        ECShopSearchParam r10 = r11.searchParam;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L20:
        r6[4] = TuplesKt.to("entrance_location", r10.getEntranceLocation());
        ECShopSearchParam r12 = r11.searchParam;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L24:
        if (r12.isPreview() == false) goto L26;
        String r13 = CommentScene.COMMENTSCENE_NO_AWEME;
    L27:
        r6[5] = TuplesKt.to("is_enter_preview", r13);
        r6[6] = TuplesKt.to("brand_verified", "0");
        r6[7] = TuplesKt.to("content_source", "shop");
        r6[8] = TuplesKt.to("source_page", "store_page");
        r6[9] = TuplesKt.to("store_type", "shop");
        ECShopSearchParam r14 = r11.searchParam;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L30:
        r6[10] = TuplesKt.to("page_name", r14.getPageName());
        ECShopSearchParam r15 = r11.searchParam;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L33:
        String r16 = "";
        if (r15.isEcShare() == false) goto L42;
        ECShopSearchParam r17 = r11.searchParam;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L38:
        String r18 = r17.getShareContent();
        if (r18 != null) goto L41;
        r18 = "";
    L41:
        Pair r19 = TuplesKt.to("share_content", r18);
    L43:
        r6[11] = r19;
        ECShopSearchParam r20 = r11.searchParam;
        if (r20 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L47:
        if (r20.isEcShare() == false) goto L56;
        ECShopSearchParam r21 = r11.searchParam;
        if (r21 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L51:
        String r22 = r21.getShareObject();
        if (r22 == null) goto L55;
        r16 = r22;
    L55:
        Pair r23 = TuplesKt.to("share_object", r16);
    L57:
        r6[12] = r23;
        r6[13] = TuplesKt.to("bst_group_type", "product");
        ECShopSearchParam r24 = r11.searchParam;
        if (r24 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L60:
        r6[14] = TuplesKt.to("shop_search_enter_method", r24.getEnterMethod());
        r6[15] = TuplesKt.to("bst_tag", "bst_tag");
        r5.putAll(MapsKt.mapOf(r6));
        Unit r25 = Unit.INSTANCE;
        r11.doEventAction("search_result_page_view", r0, r1, r5);
        return;
    L56:
        r23 = TuplesKt.to("", "");
        goto L57
    L42:
        r19 = TuplesKt.to("", "");
        goto L43
    L26:
        r13 = "0";
        goto L27
    }

    public final void initData(Bundle r2) {
        if (r2 == null) goto L4;
        Serializable r3 = r2.getSerializable("search_param");
    L5:
        if (r3 == null) goto L9;
        ECShopSearchParam r4 = (ECShopSearchParam) r3;
        this.searchParam = r4;
        this.isFormSearchActivity = r4.isFromSearchActivity();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L4:
        r3 = null;
        goto L5
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setFormSearchActivity(boolean r1) {
        this.isFormSearchActivity = r1;
    }

    public final void setMRecordTime(long r1) {
        this.mRecordTime = r1;
    }

    public final void setMToNewPage(boolean r1) {
        this.mToNewPage = r1;
    }

    public final void setSearchParam(ECShopSearchParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchParam = r2;
    }
}
