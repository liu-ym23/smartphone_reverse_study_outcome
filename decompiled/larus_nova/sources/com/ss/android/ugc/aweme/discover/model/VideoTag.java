package com.ss.android.ugc.aweme.discover.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.WireField;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/VideoTag;", "Ljava/io/Serializable;", "()V", "backgroundColor", "", "fontColor", "iconUrl", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "id", "", GXTemplateKey.FLEXBOX_PADDING, "title", "type", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class VideoTag implements Serializable {

    @SerializedName("background_color")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public String backgroundColor;

    @SerializedName("font_color")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public String fontColor;

    @SerializedName("url")
    @WireField(adapter = "com.ss.ugc.aweme.UrlStructV2#ADAPTER", tag = 5)
    public UrlModel iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public int f450501id;

    @SerializedName("left_right_padding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public int padding;

    @SerializedName("title")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public String title;

    @SerializedName(a.KEY_TAG_TYPE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public int type;

    public VideoTag() {
    }
}
