package com.bytedance.ee.bear.bitable.ddui.model;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "leftIcon", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", "content", "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getContent", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "setContent", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "checkBox", "Lcom/bytedance/ee/bear/bitable/ddui/model/CheckBoxModel;", "getCheckBox", "()Lcom/bytedance/ee/bear/bitable/ddui/model/CheckBoxModel;", "setCheckBox", "(Lcom/bytedance/ee/bear/bitable/ddui/model/CheckBoxModel;)V", "rightIcon", "getRightIcon", "setRightIcon", "isSync", "", "()Z", "setSync", "(Z)V", "into", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItem;", "ctx", "Landroid/content/Context;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionCellModel extends BaseWidgetModel {
    private CheckBoxModel checkBox;
    private TextWidgetModel content;
    private boolean isSync;
    private ImageWidgetModel leftIcon;
    private ImageWidgetModel rightIcon;

    public static final class a implements ConditionListView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionCellModel f211083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f211084b;

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final String getCallbackId() {
            return this.f211083a.getOnClick();
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final CharSequence getHintTitle() {
            TextWidgetModel r100 = this.f211083a.getContent();
            if (r100 == null) goto L7;
            String r101 = r100.getPlaceholder();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return "";
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final Integer getIconRes() {
            ImageWidgetModel r100 = this.f211083a.getLeftIcon();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getIconRes(this.f211084b);
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final Integer getRightIconRes() {
            ImageWidgetModel r100 = this.f211083a.getRightIcon();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getIconRes(this.f211084b);
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final CharSequence getTitle() {
            TextWidgetModel r100 = this.f211083a.getContent();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getText();
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final Boolean isChecked() {
            CheckBoxModel r100 = this.f211083a.getCheckBox();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getChecked();
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
        public final boolean isSync() {
            return this.f211083a.isSync();
        }

        public a(ConditionCellModel r100, Context r101) {
            this.f211083a = r100;
            this.f211084b = r101;
        }
    }

    public ConditionCellModel() {
    }

    public final CheckBoxModel getCheckBox() {
        return this.checkBox;
    }

    public final TextWidgetModel getContent() {
        return this.content;
    }

    public final ImageWidgetModel getLeftIcon() {
        return this.leftIcon;
    }

    public final ImageWidgetModel getRightIcon() {
        return this.rightIcon;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final ConditionListView.b into(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return new a(this, r100);
    }

    public final void setCheckBox(CheckBoxModel r100) {
        this.checkBox = r100;
    }

    public final void setContent(TextWidgetModel r100) {
        this.content = r100;
    }

    public final void setLeftIcon(ImageWidgetModel r100) {
        this.leftIcon = r100;
    }

    public final void setRightIcon(ImageWidgetModel r100) {
        this.rightIcon = r100;
    }

    public final void setSync(boolean r100) {
        this.isSync = r100;
    }
}
