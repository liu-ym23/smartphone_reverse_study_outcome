package com.ss.android.ugc.effectmanager.effect.model.template;

import com.ss.ugc.effectplatform.model.ProviderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectTemplate;", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "kProviderEffect", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect;)V", "value", "", "clickUrl", "getClickUrl", "()Ljava/lang/String;", "setClickUrl", "(Ljava/lang/String;)V", "getKProviderEffect", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;", "thumbnailSticker", "getThumbnailSticker", "()Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;", "setThumbnailSticker", "(Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect$StickerBean;)V", "getSticker", "setSticker", "", "stickerBean", "StickerBeanTemplate", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class ProviderEffectTemplate extends ProviderEffect {
    private String clickUrl;
    private final transient ProviderEffect kProviderEffect;
    private com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean thumbnailSticker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectTemplate$StickerBeanTemplate;", "Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "kStickerBean", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;)V", "getKStickerBean", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static class StickerBeanTemplate extends ProviderEffect.StickerBean {
        private final transient ProviderEffect.StickerBean kStickerBean;

        /* JADX WARN: Multi-variable type inference failed */
        public StickerBeanTemplate() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ProviderEffect.StickerBean getKStickerBean() {
            return this.kStickerBean;
        }

        public StickerBeanTemplate(ProviderEffect.StickerBean r100) {
            super(null, null, null, null, 15, null);
            this.kStickerBean = r100;
        }

        public /* synthetic */ StickerBeanTemplate(ProviderEffect.StickerBean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderEffectTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean getSticker() {
        ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L7;
        ProviderEffect.StickerBean r101 = r100.getSticker_info();
        if (r101 == null) goto L7;
    L9:
        return new com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean(r101);
    L7:
        r101 = super.getSticker_info();
        goto L9
    }

    public com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean getThumbnailSticker() {
        ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L7;
        ProviderEffect.StickerBean r101 = r100.getThumbnail_sticker();
        if (r101 == null) goto L7;
    L9:
        return new com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean(r101);
    L7:
        r101 = super.getThumbnail_sticker();
        goto L9
    }

    public String getClickUrl() {
        ProviderEffect r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getClick_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getClick_url();
    }

    public ProviderEffect getKProviderEffect() {
        return this.kProviderEffect;
    }

    public ProviderEffectTemplate(ProviderEffect r110) {
        super(null, null, null, null, null, null, null, null, null, 511, null);
        this.kProviderEffect = r110;
    }

    public void setClickUrl(String r100) {
        this.clickUrl = r100;
        ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setClick_url(r100);
    L5:
        super.setClick_url(r100);
    }

    public void setSticker(com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean r100) {
        ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSticker_info(r100);
    L5:
        super.setSticker_info(r100);
    }

    public void setThumbnailSticker(com.ss.android.ugc.effectmanager.effect.model.ProviderEffect.StickerBean r100) {
        this.thumbnailSticker = r100;
        ProviderEffect r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setThumbnail_sticker(r100);
    L5:
        super.setThumbnail_sticker(r100);
    }

    public /* synthetic */ ProviderEffectTemplate(ProviderEffect r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
