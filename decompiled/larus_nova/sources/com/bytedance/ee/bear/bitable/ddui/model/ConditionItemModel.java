package com.bytedance.ee.bear.bitable.ddui.model;

import android.content.Context;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "title", "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getTitle", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", d.f25925o, "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "rightIcon", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getRightIcon", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setRightIcon", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", "cells", "", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "getCells", "()[Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "setCells", "([Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;)V", "[Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "conditionId", "", "getConditionId", "()Ljava/lang/String;", "setConditionId", "(Ljava/lang/String;)V", "invalidType", "", "getInvalidType", "()Ljava/lang/Integer;", "setInvalidType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "warning", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemWarningModel;", "getWarning", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemWarningModel;", "setWarning", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemWarningModel;)V", "into", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemConfig;", "ctx", "Landroid/content/Context;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionItemModel extends BaseWidgetModel {
    private ConditionCellModel[] cells;
    private String conditionId;
    private Integer invalidType;
    private ImageWidgetModel rightIcon;
    private TextWidgetModel title;
    private ConditionItemWarningModel warning;

    public static final class a implements cs4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionItemModel f211085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f211086b;

        @Override // cs4.a
        public final Integer c() {
            return this.f211085a.getInvalidType();
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
        public final List<ConditionListView.b> e() {
            ArrayList r100 = new ArrayList();
            ConditionItemModel r101 = this.f211085a;
            Context r102 = this.f211086b;
            ConditionCellModel[] r103 = r101.getCells();
            int r104 = r103.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L5;
            r100.add(r103[r105].into(r102));
            r105 = r105 + 1;
            goto L3
        L5:
            return r100;
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
        public final String getCallbackId() {
            ImageWidgetModel r100 = this.f211085a.getRightIcon();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getOnClick();
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
        public final void a(ConditionView r100) {
            Intrinsics.checkNotNullParameter(r100, "conditionView");
            TextWidgetModel r101 = this.f211085a.getTitle();
            if (r101 == null) goto L7;
            String r102 = r101.getText();
            if (r102 == null) goto L7;
            r100.setConditionTitle(r102);
        L7:
            boolean r103 = true;
            if (this.f211085a.getRightIcon() == null) goto L10;
            boolean r104 = true;
        L11:
            r100.setConditionCloseVisible(r104);
            if (this.f211085a.getWarning() != null) goto L15;
            r103 = false;
        L15:
            r100.setWarningInfoVisible(r103);
            if (this.f211085a.getWarning() == null) goto L31;
            ConditionItemWarningModel r105 = this.f211085a.getWarning();
            if (r105 == null) goto L20;
            TextWidgetModel r106 = r105.getWarningText();
        L21:
            if (r106 == null) goto L32;
            ConditionItemWarningModel r107 = this.f211085a.getWarning();
            if (r107 == null) goto L28;
            TextWidgetModel r108 = r107.getWarningText();
            if (r108 == null) goto L28;
            String r109 = r108.getText();
            if (r109 == null) goto L28;
        L29:
            r100.setWarningInfo(r109);
            return;
        L28:
            r109 = "";
            goto L29
        L32:
            return;
        L20:
            r106 = null;
            goto L21
        L31:
            return;
        L10:
            r104 = false;
            goto L11
        }

        public a(ConditionItemModel r100, Context r101) {
            this.f211085a = r100;
            this.f211086b = r101;
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
        public final void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r102, "conditionItem");
            if (r101 == 2) goto L5;
            return;
        L5:
            if (r102.isChecked() == null) goto L9;
            Context r103 = this.f211086b;
            r100.setPadding(0, n.d(6), 0, n.d(6));
            r100.setBackgroundColor(r103.getResources().getColor(R.color.lkui_transparent));
            r100.setLeftIconVisible(false);
            r100.setCellTextVisible(false);
            r100.setRightIconVisible(false);
            r100.setCheckBoxChecked(Intrinsics.areEqual(r102.isChecked(), Boolean.TRUE));
            return;
        }
    }

    public ConditionItemModel() {
        this.cells = new ConditionCellModel[0];
    }

    public final ConditionCellModel[] getCells() {
        return this.cells;
    }

    public final String getConditionId() {
        return this.conditionId;
    }

    public final Integer getInvalidType() {
        return this.invalidType;
    }

    public final ImageWidgetModel getRightIcon() {
        return this.rightIcon;
    }

    public final TextWidgetModel getTitle() {
        return this.title;
    }

    public final ConditionItemWarningModel getWarning() {
        return this.warning;
    }

    public final cs4.a into(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return new a(this, r100);
    }

    public final void setCells(ConditionCellModel[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cells = r100;
    }

    public final void setConditionId(String r100) {
        this.conditionId = r100;
    }

    public final void setInvalidType(Integer r100) {
        this.invalidType = r100;
    }

    public final void setRightIcon(ImageWidgetModel r100) {
        this.rightIcon = r100;
    }

    public final void setTitle(TextWidgetModel r100) {
        this.title = r100;
    }

    public final void setWarning(ConditionItemWarningModel r100) {
        this.warning = r100;
    }
}
