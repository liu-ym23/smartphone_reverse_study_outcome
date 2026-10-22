package com.larus.dora.impl.dynamic;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/dynamic/GeneraItem;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "itemType", "", "getItemType", "()Ljava/lang/String;", "title", "Lcom/larus/dora/impl/dynamic/Identifier;", "getTitle", "()Lcom/larus/dora/impl/dynamic/Identifier;", "subtitle", "getSubtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "actionUrl", "getActionUrl", "rightIcon", "getRightIcon", "redDot", "", "getRedDot", "()Ljava/util/List;", "shouldVisible", "", PTYSocketStateCallback.CONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p1 implements d59.j {

    @SerializedName("action_url")
    private final String actionUrl;

    @SerializedName("image_link")
    private final t1 imageLink;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final String itemType;

    @SerializedName("red_dot")
    private final List<String> redDot;

    @SerializedName("right_icon")
    private final String rightIcon;

    @SerializedName("subtitle")
    private final s1 subtitle;

    @SerializedName("title")
    private final s1 title;

    public p1() {
    }

    @Override // d59.j
    public final boolean a(boolean r100) {
        return !r100;
    }

    public final String b() {
        return this.actionUrl;
    }

    public final String c() {
        return this.itemType;
    }

    public final String d() {
        return this.rightIcon;
    }

    public final s1 e() {
        return this.title;
    }
}
