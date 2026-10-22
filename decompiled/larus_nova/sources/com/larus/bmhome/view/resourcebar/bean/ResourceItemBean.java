package com.larus.bmhome.view.resourcebar.bean;

import com.larus.im.bean.message.Image;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mt8.b;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012$\b\u0002\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001f¢\u0006\u0004\b \u0010!J\u000e\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u0000J\u0013\u0010P\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010Q\u001a\u00020\u0003H\u0016J\b\u0010R\u001a\u00020\fH\u0016J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010Y\u001a\u00020\fHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u0010HÆ\u0003J\t\u0010\\\u001a\u00020\u0012HÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0010HÆ\u0003J\t\u0010d\u001a\u00020\u0010HÆ\u0003J\t\u0010e\u001a\u00020\fHÆ\u0003J%\u0010f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fHÆ\u0003Jñ\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\f2$\b\u0002\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00103\"\u0004\b4\u00105R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u001a\u0010\u0017\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00103\"\u0004\bC\u00105R\u001a\u0010\u0019\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00103\"\u0004\bE\u00105R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u00105R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006h"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Ljava/io/Serializable;", "key", "", "title", "fileSuffixes", DBDefinition.MIME_TYPE, "image", "Lcom/larus/im/bean/message/Image;", "video", "Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;", "upLinkProgress", "", "status", "Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "isExpire", "", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "itemWidth", "itemHeight", "paddingTop", "paddingBottom", "showEditImageBtn", "showEditVideoBtn", "showSubscriptView", "immersiveStyle", "subscriptIndex", "ext", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;ILcom/larus/bmhome/view/resourcebar/bean/ItemStatus;ZLcom/larus/bmhome/view/resourcebar/bean/ResourceType;IIIIZZZZILjava/util/HashMap;)V", "getKey", "()Ljava/lang/String;", "getTitle", "getFileSuffixes", "getMimeType", "getImage", "()Lcom/larus/im/bean/message/Image;", "getVideo", "()Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;", "getUpLinkProgress", "()I", "setUpLinkProgress", "(I)V", "getStatus", "()Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "setStatus", "(Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;)V", "()Z", "setExpire", "(Z)V", "getResourceType", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "setResourceType", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;)V", "getItemWidth", "setItemWidth", "getItemHeight", "setItemHeight", "getPaddingTop", "getPaddingBottom", "getShowEditImageBtn", "setShowEditImageBtn", "getShowEditVideoBtn", "setShowEditVideoBtn", "getShowSubscriptView", "setShowSubscriptView", "getImmersiveStyle", "setImmersiveStyle", "getSubscriptIndex", "setSubscriptIndex", "getExt", "()Ljava/util/HashMap;", "setExt", "(Ljava/util/HashMap;)V", "equalsExcludeProgress", "other", "equals", "toString", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceItemBean implements Serializable {
    private HashMap<String, Object> ext;
    private final String fileSuffixes;
    private final Image image;
    private boolean immersiveStyle;
    private boolean isExpire;
    private int itemHeight;
    private int itemWidth;
    private final String key;
    private final String mimeType;
    private final int paddingBottom;
    private final int paddingTop;
    private ResourceType resourceType;
    private boolean showEditImageBtn;
    private boolean showEditVideoBtn;
    private boolean showSubscriptView;
    private ItemStatus status;
    private int subscriptIndex;
    private final String title;
    private int upLinkProgress;
    private final b video;

    public ResourceItemBean() {
        this(null, null, null, null, null, null, 0, null, false, null, 0, 0, 0, 0, false, false, false, false, 0, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceItemBean copy$default(ResourceItemBean r110, String r111, String r112, String r210, String r211, Image r212, b r213, int r214, ItemStatus r215, boolean r216, ResourceType r217, int r218, int r219, int r310, int r311, boolean r312, boolean r313, boolean r314, boolean r315, int r316, HashMap r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r110.fileSuffixes;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r110.mimeType;
    L19:
        if ((r318 & 16) == 0) goto L21;
        Image r104 = r110.image;
    L23:
        if ((r318 & 32) == 0) goto L25;
        b r105 = r110.video;
    L27:
        if ((r318 & 64) == 0) goto L29;
        int r106 = r110.upLinkProgress;
    L31:
        if ((r318 & 128) == 0) goto L33;
        ItemStatus r107 = r110.status;
    L35:
        if ((r318 & 256) == 0) goto L37;
        boolean r113 = r110.isExpire;
    L39:
        if ((r318 & 512) == 0) goto L41;
        ResourceType r114 = r110.resourceType;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        int r115 = r110.itemWidth;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        int r116 = r110.itemHeight;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        int r117 = r110.paddingTop;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        int r118 = r110.paddingBottom;
    L58:
        int r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        boolean r119 = r110.showEditImageBtn;
    L62:
        boolean r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        boolean r120 = r110.showEditVideoBtn;
    L66:
        boolean r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        boolean r121 = r110.showSubscriptView;
    L70:
        boolean r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        boolean r122 = r110.immersiveStyle;
    L74:
        boolean r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        int r123 = r110.subscriptIndex;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        HashMap r108 = r110.ext;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final ResourceType component10() {
        return this.resourceType;
    }

    public final int component11() {
        return this.itemWidth;
    }

    public final int component12() {
        return this.itemHeight;
    }

    public final int component13() {
        return this.paddingTop;
    }

    public final int component14() {
        return this.paddingBottom;
    }

    public final boolean component15() {
        return this.showEditImageBtn;
    }

    public final boolean component16() {
        return this.showEditVideoBtn;
    }

    public final boolean component17() {
        return this.showSubscriptView;
    }

    public final boolean component18() {
        return this.immersiveStyle;
    }

    public final int component19() {
        return this.subscriptIndex;
    }

    public final String component2() {
        return this.title;
    }

    public final HashMap<String, Object> component20() {
        return this.ext;
    }

    public final String component3() {
        return this.fileSuffixes;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final Image component5() {
        return this.image;
    }

    public final b component6() {
        return this.video;
    }

    public final int component7() {
        return this.upLinkProgress;
    }

    public final ItemStatus component8() {
        return this.status;
    }

    public final boolean component9() {
        return this.isExpire;
    }

    public final ResourceItemBean copy(String r210, String r211, String r212, String r213, Image r214, b r215, int r310, ItemStatus r311, boolean r312, ResourceType r313, int r314, int r315, int r316, int r317, boolean r318, boolean r319, boolean r410, boolean r411, int r412, HashMap<String, Object> r413) {
        Intrinsics.checkNotNullParameter(r210, "key");
        Intrinsics.checkNotNullParameter(r211, "title");
        Intrinsics.checkNotNullParameter(r212, "fileSuffixes");
        Intrinsics.checkNotNullParameter(r213, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r311, "status");
        Intrinsics.checkNotNullParameter(r313, "resourceType");
        Intrinsics.checkNotNullParameter(r413, "ext");
        return new ResourceItemBean(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413);
    }

    public String toString() {
        return "key:" + this.key + ",title:" + this.title + ",mimeType:" + this.mimeType + ",upLinkProgress:" + this.upLinkProgress + ",status:" + this.status + ",resourceType:" + this.resourceType + ",image:" + this.image;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final HashMap<String, Object> getExt() {
        return this.ext;
    }

    public final String getFileSuffixes() {
        return this.fileSuffixes;
    }

    public final Image getImage() {
        return this.image;
    }

    public final boolean getImmersiveStyle() {
        return this.immersiveStyle;
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final ResourceType getResourceType() {
        return this.resourceType;
    }

    public final boolean getShowEditImageBtn() {
        return this.showEditImageBtn;
    }

    public final boolean getShowEditVideoBtn() {
        return this.showEditVideoBtn;
    }

    public final boolean getShowSubscriptView() {
        return this.showSubscriptView;
    }

    public final ItemStatus getStatus() {
        return this.status;
    }

    public final int getSubscriptIndex() {
        return this.subscriptIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUpLinkProgress() {
        return this.upLinkProgress;
    }

    public final b getVideo() {
        return this.video;
    }

    public final boolean isExpire() {
        return this.isExpire;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ResourceItemBean) == true) goto L5;
        return false;
    L5:
        ResourceItemBean r101 = (ResourceItemBean) r100;
        if (equalsExcludeProgress(r101) == true) goto L8;
        return false;
    L8:
        if (this.upLinkProgress != r101.upLinkProgress) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean equalsExcludeProgress(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (Intrinsics.areEqual(this.key, r100.key) == true) goto L5;
    L21:
        return false;
    L5:
        if (Intrinsics.areEqual(this.title, r100.title) == false) goto L21;
        if (Intrinsics.areEqual(this.mimeType, r100.mimeType) == false) goto L21;
        if (this.status != r100.status) goto L21;
        if (this.resourceType != r100.resourceType) goto L21;
        if (Intrinsics.areEqual(this.image, r100.image) == false) goto L21;
        if (Intrinsics.areEqual(this.video, r100.video) == false) goto L21;
        if (this.subscriptIndex != r100.subscriptIndex) goto L21;
        if (this.showSubscriptView != r100.showSubscriptView) goto L21;
        return true;
    }

    public final void setExpire(boolean r100) {
        this.isExpire = r100;
    }

    public final void setExt(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ext = r100;
    }

    public final void setImmersiveStyle(boolean r100) {
        this.immersiveStyle = r100;
    }

    public final void setItemHeight(int r100) {
        this.itemHeight = r100;
    }

    public final void setItemWidth(int r100) {
        this.itemWidth = r100;
    }

    public final void setResourceType(ResourceType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceType = r100;
    }

    public final void setShowEditImageBtn(boolean r100) {
        this.showEditImageBtn = r100;
    }

    public final void setShowEditVideoBtn(boolean r100) {
        this.showEditVideoBtn = r100;
    }

    public final void setShowSubscriptView(boolean r100) {
        this.showSubscriptView = r100;
    }

    public final void setStatus(ItemStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }

    public final void setSubscriptIndex(int r100) {
        this.subscriptIndex = r100;
    }

    public final void setUpLinkProgress(int r100) {
        this.upLinkProgress = r100;
    }

    public ResourceItemBean(String r110, String r111, String r112, String r113, Image r114, b r115, int r116, ItemStatus r117, boolean r118, ResourceType r119, int r210, int r211, int r212, int r213, boolean r214, boolean r215, boolean r216, boolean r217, int r218, HashMap<String, Object> r219) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "fileSuffixes");
        Intrinsics.checkNotNullParameter(r113, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r117, "status");
        Intrinsics.checkNotNullParameter(r119, "resourceType");
        Intrinsics.checkNotNullParameter(r219, "ext");
        this.key = r110;
        this.title = r111;
        this.fileSuffixes = r112;
        this.mimeType = r113;
        this.image = r114;
        this.video = r115;
        this.upLinkProgress = r116;
        this.status = r117;
        this.isExpire = r118;
        this.resourceType = r119;
        this.itemWidth = r210;
        this.itemHeight = r211;
        this.paddingTop = r212;
        this.paddingBottom = r213;
        this.showEditImageBtn = r214;
        this.showEditVideoBtn = r215;
        this.showSubscriptView = r216;
        this.immersiveStyle = r217;
        this.subscriptIndex = r218;
        this.ext = r219;
    }

    public /* synthetic */ ResourceItemBean(String r210, String r211, String r212, String r213, Image r214, b r215, int r216, ItemStatus r217, boolean r310, ResourceType r311, int r312, int r313, int r314, int r315, boolean r316, boolean r317, boolean r318, boolean r319, int r410, HashMap r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = UUID.randomUUID().toString();
    L6:
        String r101 = "";
        if ((r412 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r412 & 8) != 0) goto L18;
        r101 = r213;
    L18:
        b r104 = null;
        if ((r412 & 16) == 0) goto L21;
        Image r105 = null;
    L23:
        if ((r412 & 32) != 0) goto L27;
        r104 = r215;
    L27:
        if ((r412 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r412 & 128) == 0) goto L33;
        ItemStatus r107 = ItemStatus.SUCCESS;
    L35:
        if ((r412 & 256) == 0) goto L37;
        boolean r110 = false;
    L39:
        if ((r412 & 512) == 0) goto L41;
        ResourceType r111 = ResourceType.FILE;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        int r112 = i5.y();
    L47:
        if ((r412 & 2048) == 0) goto L49;
        int r113 = i5.f();
    L51:
        if ((r412 & 4096) == 0) goto L53;
        int r114 = i5.h();
    L55:
        if ((r412 & 8192) == 0) goto L57;
        int r115 = i5.h();
    L59:
        if ((r412 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        int r119 = 0;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        HashMap r109 = new HashMap();
    L82:
        this(r100, r102, r103, r101, r105, r104, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r110 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L21:
        r105 = r214;
        goto L23
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
