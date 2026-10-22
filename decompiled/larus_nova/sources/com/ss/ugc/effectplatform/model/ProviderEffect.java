package com.ss.ugc.effectplatform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \b\u0017\u0018\u00002\u00020\u0001:\u0001)Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012¨\u0006*"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "", "id", "", "title", ITwitterService.ResponseConstants.USER_NAME, "thumbnail_sticker", "Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "sticker", PromotionProductPrivilegesStruct.TAGS, "", "click_url", "path", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClick_url", "()Ljava/lang/String;", "setClick_url", "(Ljava/lang/String;)V", "getExtra", "setExtra", "getId", "setId", "getPath", "setPath", "value", "sticker_info", "getSticker_info", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "setSticker_info", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;)V", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getThumbnail_sticker", "setThumbnail_sticker", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getUser_name", "setUser_name", "StickerBean", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ProviderEffect {
    private String click_url;
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457408id;
    private String path;
    private StickerBean sticker;
    private List<String> tags;
    private StickerBean thumbnail_sticker;
    private String title;
    private String user_name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "", "url", "", "width", "height", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()Ljava/lang/String;", "setHeight", "(Ljava/lang/String;)V", "getSize", "setSize", "getUrl", "setUrl", "getWidth", "setWidth", "effect_model_release"}, k = 1, mv = {1, 1, 16})
    public static class StickerBean {
        private String height;
        private String size;
        private String url;
        private String width;

        public StickerBean() {
            this(null, null, null, null, 15, null);
        }

        public String getHeight() {
            return this.height;
        }

        public String getSize() {
            return this.size;
        }

        public String getUrl() {
            return this.url;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String r100) {
            this.height = r100;
        }

        public void setSize(String r100) {
            this.size = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }

        public void setWidth(String r100) {
            this.width = r100;
        }

        public StickerBean(String r100, String r101, String r102, String r103) {
            this.url = r100;
            this.width = r101;
            this.height = r102;
            this.size = r103;
        }

        public /* synthetic */ StickerBean(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public ProviderEffect() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public String getClick_url() {
        return this.click_url;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getId() {
        return this.f457408id;
    }

    public String getPath() {
        return this.path;
    }

    public final StickerBean getSticker_info() {
        return this.sticker;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public StickerBean getThumbnail_sticker() {
        return this.thumbnail_sticker;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setClick_url(String r100) {
        this.click_url = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setId(String r100) {
        this.f457408id = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public final void setSticker_info(StickerBean r100) {
        this.sticker = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setThumbnail_sticker(StickerBean r100) {
        this.thumbnail_sticker = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUser_name(String r100) {
        this.user_name = r100;
    }

    public ProviderEffect(String r100, String r101, String r102, StickerBean r103, StickerBean r104, List<String> r105, String r106, String r107, String r108) {
        this.f457408id = r100;
        this.title = r101;
        this.user_name = r102;
        this.thumbnail_sticker = r103;
        this.sticker = r104;
        this.tags = r105;
        this.click_url = r106;
        this.path = r107;
        this.extra = r108;
    }

    public /* synthetic */ ProviderEffect(String r110, String r111, String r112, StickerBean r113, StickerBean r114, List r115, String r116, String r117, String r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        String r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        StickerBean r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        StickerBean r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
