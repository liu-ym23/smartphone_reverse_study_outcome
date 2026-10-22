package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u001c\u00107\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "", "<init>", "()V", "title", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "optionList", "getOptionList", "()Ljava/util/List;", "setOptionList", "(Ljava/util/List;)V", "optionDataMap", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "Lkotlin/collections/HashMap;", "getOptionDataMap", "()Ljava/util/HashMap;", "setOptionDataMap", "(Ljava/util/HashMap;)V", "empty", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "getEmpty", "()Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "setEmpty", "(Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;)V", "canEditOption", "", "getCanEditOption", "()Z", "setCanEditOption", "(Z)V", "shouldShowDelete", "getShouldShowDelete", "setShouldShowDelete", "shouldShowMoreIcon", "getShouldShowMoreIcon", "setShouldShowMoreIcon", "enableMultiSelect", "getEnableMultiSelect", "setEnableMultiSelect", "enableSelectPreviewShow", "getEnableSelectPreviewShow", "setEnableSelectPreviewShow", "addOrEditOption", "getAddOrEditOption", "()Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "setAddOrEditOption", "(Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;)V", "randomColorId", "getRandomColorId", "setRandomColorId", "colorList", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "getColorList", "setColorList", "IEditorOption", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectEditorModel extends CommonEditorModel<List<? extends String>> {
    private IEditorOption addOrEditOption;
    private boolean canEditOption;
    private List<? extends ColorBean> colorList;
    private EmptyData empty;
    private boolean enableMultiSelect;
    private boolean enableSelectPreviewShow;
    private HashMap<String, IEditorOption> optionDataMap;
    private List<String> optionList;
    private Integer randomColorId;
    private boolean shouldShowDelete;
    private boolean shouldShowMoreIcon;
    private Integer status;
    private String title;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\t¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "colorId", "", "getColorId", "()Ljava/lang/Integer;", "setColorId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "color", "getColor", "setColor", "textColor", "getTextColor", "setTextColor", "borderColor", "getBorderColor", "setBorderColor", "iconColor", "getIconColor", "setIconColor", "toOptionEntity", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IEditorOption implements NonProguard {
        private String borderColor;
        private String color;
        private Integer colorId;
        private String iconColor;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f209459id;
        private String name;
        private String textColor;

        public IEditorOption() {
        }

        public final com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a toOptionEntity() {
            String r100 = this.f209459id;
            String r101 = this.name;
            Integer r102 = this.colorId;
            if (r102 == null) goto L5;
            int r103 = r102.intValue();
        L6:
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r104 = new com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a(r100, r101, r103, this.color, this.textColor);
            r104.f207146f = this.borderColor;
            r104.f207147g = this.iconColor;
            return r104;
        L5:
            r103 = 0;
            goto L6
        }

        public final String getBorderColor() {
            return this.borderColor;
        }

        public final String getColor() {
            return this.color;
        }

        public final Integer getColorId() {
            return this.colorId;
        }

        public final String getIconColor() {
            return this.iconColor;
        }

        public final String getId() {
            return this.f209459id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final void setBorderColor(String r100) {
            this.borderColor = r100;
        }

        public final void setColor(String r100) {
            this.color = r100;
        }

        public final void setColorId(Integer r100) {
            this.colorId = r100;
        }

        public final void setIconColor(String r100) {
            this.iconColor = r100;
        }

        public final void setId(String r100) {
            this.f209459id = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setTextColor(String r100) {
            this.textColor = r100;
        }
    }

    public SelectEditorModel() {
        this.optionDataMap = new HashMap();
    }

    public final IEditorOption getAddOrEditOption() {
        return this.addOrEditOption;
    }

    public final boolean getCanEditOption() {
        return this.canEditOption;
    }

    public final List<ColorBean> getColorList() {
        return this.colorList;
    }

    public final EmptyData getEmpty() {
        return this.empty;
    }

    public final boolean getEnableMultiSelect() {
        return this.enableMultiSelect;
    }

    public final boolean getEnableSelectPreviewShow() {
        return this.enableSelectPreviewShow;
    }

    public final HashMap<String, IEditorOption> getOptionDataMap() {
        return this.optionDataMap;
    }

    public final List<String> getOptionList() {
        return this.optionList;
    }

    public final Integer getRandomColorId() {
        return this.randomColorId;
    }

    public final boolean getShouldShowDelete() {
        return this.shouldShowDelete;
    }

    public final boolean getShouldShowMoreIcon() {
        return this.shouldShowMoreIcon;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAddOrEditOption(IEditorOption r100) {
        this.addOrEditOption = r100;
    }

    public final void setCanEditOption(boolean r100) {
        this.canEditOption = r100;
    }

    public final void setColorList(List<? extends ColorBean> r100) {
        this.colorList = r100;
    }

    public final void setEmpty(EmptyData r100) {
        this.empty = r100;
    }

    public final void setEnableMultiSelect(boolean r100) {
        this.enableMultiSelect = r100;
    }

    public final void setEnableSelectPreviewShow(boolean r100) {
        this.enableSelectPreviewShow = r100;
    }

    public final void setOptionDataMap(HashMap<String, IEditorOption> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionDataMap = r100;
    }

    public final void setOptionList(List<String> r100) {
        this.optionList = r100;
    }

    public final void setRandomColorId(Integer r100) {
        this.randomColorId = r100;
    }

    public final void setShouldShowDelete(boolean r100) {
        this.shouldShowDelete = r100;
    }

    public final void setShouldShowMoreIcon(boolean r100) {
        this.shouldShowMoreIcon = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
