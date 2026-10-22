package com.bytedance.android.shopping.api.mall.opt;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/d;", "", "Lcom/bytedance/android/shopping/api/mall/opt/f;", "topMall", "Lcom/bytedance/android/shopping/api/mall/opt/f;", "getTopMall", "()Lcom/bytedance/android/shopping/api/mall/opt/f;", "bottomMall", "getBottomMall", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "", "commonRequestPreload", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "preInflate", "e", "", "enableAnimaXPages", "Ljava/util/List;", "b", "()Ljava/util/List;", "enableAudioTT", "c", "inflateTiming", "Ljava/lang/Integer;", "getInflateTiming", "()Ljava/lang/Integer;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("bottom_mall")
    private final f bottomMall;

    @SerializedName("common_request_preload")
    private final Map<String, f> commonRequestPreload;

    @SerializedName("mall_enable_animax_pages")
    private final List<String> enableAnimaXPages;

    @SerializedName("audio_tt_inject_resource_loader")
    private final List<String> enableAudioTT;

    @SerializedName("async_inflate_native_view_timing")
    private final Integer inflateTiming;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
    private final ArrayList<String> pageName;

    @SerializedName("async_inflate_view")
    private final Map<String, Integer> preInflate;

    @SerializedName("top_mall")
    private final f topMall;

    public d() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L22;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.topMall, r4.topMall) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomMall, r4.bottomMall) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonRequestPreload, r4.commonRequestPreload) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preInflate, r4.preInflate) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enableAnimaXPages, r4.enableAnimaXPages) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableAudioTT, r4.enableAudioTT) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.inflateTiming, r4.inflateTiming) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        f r0 = this.topMall;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        f r4 = this.bottomMall;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<String> r7 = this.pageName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, f> r10 = this.commonRequestPreload;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, Integer> r13 = this.preInflate;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.enableAnimaXPages;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.enableAudioTT;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.inflateTiming;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallListEngineOptConfig(topMall=" + this.topMall + ", bottomMall=" + this.bottomMall + ", pageName=" + this.pageName + ", commonRequestPreload=" + this.commonRequestPreload + ", preInflate=" + this.preInflate + ", enableAnimaXPages=" + this.enableAnimaXPages + ", enableAudioTT=" + this.enableAudioTT + ", inflateTiming=" + this.inflateTiming + ")";
    }

    public final Map<String, f> a() {
        return this.commonRequestPreload;
    }

    public final List<String> b() {
        return this.enableAnimaXPages;
    }

    public final List<String> c() {
        return this.enableAudioTT;
    }

    public final ArrayList<String> d() {
        return this.pageName;
    }

    public final Map<String, Integer> e() {
        return this.preInflate;
    }

    public d(Object r1) {
        this.topMall = null;
        this.bottomMall = null;
        this.pageName = null;
        this.commonRequestPreload = null;
        this.preInflate = null;
        this.enableAnimaXPages = null;
        this.enableAudioTT = null;
        this.inflateTiming = null;
    }
}
