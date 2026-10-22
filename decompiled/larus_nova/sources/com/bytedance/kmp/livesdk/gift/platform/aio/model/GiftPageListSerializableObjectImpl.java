package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kc6.i;
import kc6.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftPageListSerializableObjectImpl;", "Lkc6/r;", "", "Lkc6/i;", "giftList", "Ljava/util/List;", "getGiftList", "()Ljava/util/List;", "Q3", "(Ljava/util/List;)V", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "Lpy/k;", "backgroundImage", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "", "pageType", "I", "getPageType", "()I", "setPageType", "(I)V", "Lcom/bytedance/android/livesdk/gift/model/x2;", "pageInfo", "Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "setPageInfo", "(Lcom/bytedance/android/livesdk/gift/model/x2;)V", "receiverBackgroundImg", "getReceiverBackgroundImg", "G5", "pageSortStrategy", "getPageSortStrategy", "setPageSortStrategy", "Lcom/bytedance/android/livesdk/gift/model/b3;", "pageNameStyleInfo", "Lcom/bytedance/android/livesdk/gift/model/b3;", "getPageNameStyleInfo", "()Lcom/bytedance/android/livesdk/gift/model/b3;", "setPageNameStyleInfo", "(Lcom/bytedance/android/livesdk/gift/model/b3;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPageListSerializableObjectImpl implements r {

    @SerializedName("background_image")
    private k backgroundImage;

    @SerializedName("gift_list")
    private List<? extends i> giftList;

    @SerializedName("page_info")
    private x2 pageInfo;

    @SerializedName("page_name_style_info")
    private b3 pageNameStyleInfo;

    @SerializedName("sort_strategy")
    private int pageSortStrategy;

    @SerializedName("page_type")
    private int pageType;

    @SerializedName("receiver_background_img")
    private k receiverBackgroundImg;

    @SerializedName(a.KEY_TAB_NAME)
    private String tabName;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftPageListSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPageListSerializableObjectImpl.class);
        }
    }

    public GiftPageListSerializableObjectImpl() {
        this.giftList = d.a();
        this.tabName = "";
    }

    @Override // kc6.r
    public final List<i> getGiftList() {
        return this.giftList;
    }

    @Override // kc6.r
    public final int getPageType() {
        return this.pageType;
    }

    @Override // kc6.r
    public final String getTabName() {
        return this.tabName;
    }

    @Override // kc6.r
    public final void G5(k r100) {
        this.receiverBackgroundImg = r100;
    }

    @Override // kc6.r
    public final void Q3(List<? extends i> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftList = r100;
    }

    @Override // kc6.r
    public final void setBackgroundImage(k r100) {
        this.backgroundImage = r100;
    }

    @Override // kc6.r
    public final void setPageInfo(x2 r100) {
        this.pageInfo = r100;
    }

    @Override // kc6.r
    public final void setPageNameStyleInfo(b3 r100) {
        this.pageNameStyleInfo = r100;
    }

    @Override // kc6.r
    public final void setPageSortStrategy(int r100) {
        this.pageSortStrategy = r100;
    }

    @Override // kc6.r
    public final void setPageType(int r100) {
        this.pageType = r100;
    }

    @Override // kc6.r
    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabName = r100;
    }
}
