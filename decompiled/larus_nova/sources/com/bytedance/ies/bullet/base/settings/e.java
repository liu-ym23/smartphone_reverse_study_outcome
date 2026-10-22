package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/e;", "", "", "", "anniexSLPageBlockList", "Ljava/util/List;", "getAnniexSLPageBlockList", "()Ljava/util/List;", "setAnniexSLPageBlockList", "(Ljava/util/List;)V", "anniexSLPageWhiteList", "getAnniexSLPageWhiteList", "setAnniexSLPageWhiteList", "anniexSLPopupBlockList", "getAnniexSLPopupBlockList", "setAnniexSLPopupBlockList", "anniexSLPopupWhiteList", "getAnniexSLPopupWhiteList", "setAnniexSLPopupWhiteList", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("anniex_sl_page_block_list")
    private List<String> anniexSLPageBlockList;

    @SerializedName("anniex_sl_page_white_list")
    private List<String> anniexSLPageWhiteList;

    @SerializedName("anniex_sl_popup_block_list")
    private List<String> anniexSLPopupBlockList;

    @SerializedName("anniex_sl_popup_white_list")
    private List<String> anniexSLPopupWhiteList;

    public e() {
        this.anniexSLPageBlockList = CollectionsKt.emptyList();
        this.anniexSLPageWhiteList = CollectionsKt.emptyList();
        this.anniexSLPopupBlockList = CollectionsKt.emptyList();
        this.anniexSLPopupWhiteList = CollectionsKt.emptyList();
    }
}
