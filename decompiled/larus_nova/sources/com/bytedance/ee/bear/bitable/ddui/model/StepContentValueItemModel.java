package com.bytedance.ee.bear.bitable.ddui.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00108\u001a\u000209R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001c\u0010.\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001e\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueItemModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "checked", "", "getChecked", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isShow", "setShow", "contentImg", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getContentImg", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setContentImg", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", RXScreenCaptureService.KEY_CONTENT_TEXT, "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getContentText", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "setContentText", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "rightIcon", "getRightIcon", "setRightIcon", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "leftIcon", "getLeftIcon", "setLeftIcon", "onInputChanged", "getOnInputChanged", "setOnInputChanged", GXTemplateKey.GAIAX_PLACEHOLDER, "getPlaceholder", "setPlaceholder", "text", "getText", "setText", TimeZoneItemV2.TIME_ZONE, "getTimeZone", "setTimeZone", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "intoChatterEntity", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StepContentValueItemModel extends BaseWidgetModel {
    private Boolean checked;
    private ImageWidgetModel contentImg;
    private TextWidgetModel contentText;
    private String description;
    private Boolean isShow;
    private ImageWidgetModel leftIcon;
    private String onInputChanged;
    private String placeholder;
    private ImageWidgetModel rightIcon;
    private String text;
    private String timeZone;
    private Long timestamp;

    public static final class a implements IChatterEntity {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepContentValueItemModel f211093a;

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final /* synthetic */ String getAvatarKey() {
            return null;
        }

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final /* synthetic */ boolean isCurrentUser() {
            return false;
        }

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final String getAvatarUrl() {
            ImageWidgetModel r100 = this.f211093a.getContentImg();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getUrl();
        }

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final String getDescription() {
            return this.f211093a.getDescription();
        }

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final String getId() {
            return this.f211093a.getOnClick();
        }

        public a(StepContentValueItemModel r100) {
            this.f211093a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
        public final String getLocalName(String r100) {
            TextWidgetModel r101 = this.f211093a.getContentText();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getText();
        }
    }

    public final IChatterEntity intoChatterEntity() {
        return new a(this);
    }

    public StepContentValueItemModel() {
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final ImageWidgetModel getContentImg() {
        return this.contentImg;
    }

    public final TextWidgetModel getContentText() {
        return this.contentText;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ImageWidgetModel getLeftIcon() {
        return this.leftIcon;
    }

    public final String getOnInputChanged() {
        return this.onInputChanged;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final ImageWidgetModel getRightIcon() {
        return this.rightIcon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Boolean isShow() {
        return this.isShow;
    }

    public final void setChecked(Boolean r100) {
        this.checked = r100;
    }

    public final void setContentImg(ImageWidgetModel r100) {
        this.contentImg = r100;
    }

    public final void setContentText(TextWidgetModel r100) {
        this.contentText = r100;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setLeftIcon(ImageWidgetModel r100) {
        this.leftIcon = r100;
    }

    public final void setOnInputChanged(String r100) {
        this.onInputChanged = r100;
    }

    public final void setPlaceholder(String r100) {
        this.placeholder = r100;
    }

    public final void setRightIcon(ImageWidgetModel r100) {
        this.rightIcon = r100;
    }

    public final void setShow(Boolean r100) {
        this.isShow = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTimeZone(String r100) {
        this.timeZone = r100;
    }

    public final void setTimestamp(Long r100) {
        this.timestamp = r100;
    }
}
