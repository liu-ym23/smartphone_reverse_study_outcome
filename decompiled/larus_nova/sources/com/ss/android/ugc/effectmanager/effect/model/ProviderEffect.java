package com.ss.android.ugc.effectmanager.effect.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00017B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\n\u00103\u001a\u0004\u0018\u00010!H\u0016J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010!H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR4\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0006\u001a\u0004\u0018\u00010!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0006\u001a\u0004\u0018\u00010'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR(\u00100\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\f¨\u00068"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectTemplate;", "Ljava/io/Serializable;", "kProviderEffect", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect;)V", "value", "", "clickUrl", "getClickUrl", "()Ljava/lang/String;", "setClickUrl", "(Ljava/lang/String;)V", "click_url", "getClick_url", "setClick_url", "extra", "getExtra", "setExtra", "id", "getId", "setId", "getKProviderEffect", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "path", "getPath", "setPath", "", PromotionProductPrivilegesStruct.TAGS, "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;", "thumbnailSticker", "getThumbnailSticker", "()Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;", "setThumbnailSticker", "(Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;)V", "Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "thumbnail_sticker", "getThumbnail_sticker", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "setThumbnail_sticker", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;)V", "title", "getTitle", d.f25925o, ITwitterService.ResponseConstants.USER_NAME, "getUser_name", "setUser_name", "getSticker", "setSticker", "", "stickerBean", "StickerBean", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class ProviderEffect extends ProviderEffectTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.ProviderEffect kProviderEffect;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR(\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectTemplate$StickerBeanTemplate;", "Ljava/io/Serializable;", "kStickerBean", "Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;)V", "value", "", "height", "getHeight", "()Ljava/lang/String;", "setHeight", "(Ljava/lang/String;)V", "getKStickerBean", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "size", "getSize", "setSize", "url", "getUrl", "setUrl", "width", "getWidth", "setWidth", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class StickerBean extends ProviderEffectTemplate.StickerBeanTemplate implements Serializable {
        private final transient com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean kStickerBean;

        /* JADX WARN: Multi-variable type inference failed */
        public StickerBean() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public String getHeight() {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100 = getKStickerBean();
            if (r100 == null) goto L8;
            String r101 = r100.getHeight();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getHeight();
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public String getSize() {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100 = getKStickerBean();
            if (r100 == null) goto L8;
            String r101 = r100.getSize();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getSize();
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public String getUrl() {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100 = getKStickerBean();
            if (r100 == null) goto L8;
            String r101 = r100.getUrl();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getUrl();
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public String getWidth() {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100 = getKStickerBean();
            if (r100 == null) goto L8;
            String r101 = r100.getWidth();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getWidth();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate.StickerBeanTemplate
        public com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean getKStickerBean() {
            return this.kStickerBean;
        }

        public StickerBean(com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100) {
            super(r100);
            this.kStickerBean = r100;
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = getKStickerBean();
            if (r101 == null) goto L17;
            String r102 = r101.getHeight();
            if (r102 == null) goto L7;
            super.setHeight(r102);
        L7:
            String r103 = r101.getSize();
            if (r103 == null) goto L10;
            super.setSize(r103);
        L10:
            String r104 = r101.getUrl();
            if (r104 == null) goto L13;
            super.setUrl(r104);
        L13:
            String r105 = r101.getWidth();
            if (r105 == null) goto L18;
            super.setWidth(r105);
            return;
        L18:
            return;
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public void setHeight(String r100) {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = getKStickerBean();
            if (r101 == null) goto L5;
            r101.setHeight(r100);
        L5:
            super.setHeight(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public void setSize(String r100) {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = getKStickerBean();
            if (r101 == null) goto L5;
            r101.setSize(r100);
        L5:
            super.setSize(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public void setUrl(String r100) {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = getKStickerBean();
            if (r101 == null) goto L5;
            r101.setUrl(r100);
        L5:
            super.setUrl(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean
        public void setWidth(String r100) {
            com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = getKStickerBean();
            if (r101 == null) goto L5;
            r101.setWidth(r100);
        L5:
            super.setWidth(r100);
        }

        public /* synthetic */ StickerBean(com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderEffect() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public String getClickUrl() {
        return super.getClickUrl();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getClick_url() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getClick_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getClick_url();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getExtra() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getId() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getId();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getPath() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getPath();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getPath();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public StickerBean getSticker() {
        return super.getSticker();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public List<String> getTags() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTags();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public StickerBean getThumbnailSticker() {
        return super.getThumbnailSticker();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean getThumbnail_sticker() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r101 = r100.getThumbnail_sticker();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getThumbnail_sticker();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getTitle() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getTitle();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTitle();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public String getUser_name() {
        com.ss.ugc.effectplatform.model.ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getUser_name();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUser_name();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public com.ss.ugc.effectplatform.model.ProviderEffect getKProviderEffect() {
        return this.kProviderEffect;
    }

    public ProviderEffect(com.ss.ugc.effectplatform.model.ProviderEffect r100) {
        super(r100);
        this.kProviderEffect = r100;
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L32;
        String r102 = r101.getClick_url();
        if (r102 == null) goto L7;
        super.setClick_url(r102);
    L7:
        String r103 = r101.getExtra();
        if (r103 == null) goto L10;
        super.setExtra(r103);
    L10:
        String r104 = r101.getId();
        if (r104 == null) goto L13;
        super.setId(r104);
    L13:
        String r105 = r101.getPath();
        if (r105 == null) goto L16;
        super.setPath(r105);
    L16:
        com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r106 = r101.getSticker_info();
        if (r106 == null) goto L19;
        super.setSticker_info(r106);
    L19:
        List<String> r107 = r101.getTags();
        if (r107 == null) goto L22;
        super.setTags(r107);
    L22:
        com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r108 = r101.getThumbnail_sticker();
        if (r108 == null) goto L25;
        super.setThumbnail_sticker(r108);
    L25:
        String r109 = r101.getTitle();
        if (r109 == null) goto L28;
        super.setTitle(r109);
    L28:
        String r110 = r101.getUser_name();
        if (r110 == null) goto L33;
        super.setUser_name(r110);
        return;
    L33:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public void setClickUrl(String r100) {
        super.setClickUrl(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setClick_url(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setClick_url(r100);
    L5:
        super.setClick_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setId(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setId(r100);
    L5:
        super.setId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setPath(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setPath(r100);
    L5:
        super.setPath(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public void setSticker(StickerBean r100) {
        super.setSticker(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setTags(List<String> r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setTags(r100);
    L5:
        super.setTags(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectTemplate
    public void setThumbnailSticker(StickerBean r100) {
        super.setThumbnailSticker(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setThumbnail_sticker(com.ss.ugc.effectplatform.model.ProviderEffect.StickerBean r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setThumbnail_sticker(r100);
    L5:
        super.setThumbnail_sticker(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setTitle(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setTitle(r100);
    L5:
        super.setTitle(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffect
    public void setUser_name(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setUser_name(r100);
    L5:
        super.setUser_name(r100);
    }

    public /* synthetic */ ProviderEffect(com.ss.ugc.effectplatform.model.ProviderEffect r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
