package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.Location;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/location/LocationEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/Location;", "<init>", "()V", RemoteMessageConst.INPUT_TYPE, "", "getInputType", "()Ljava/lang/String;", "setInputType", "(Ljava/lang/String;)V", "fieldName", "getFieldName", "setFieldName", "isInForm", "", "()Z", "setInForm", "(Z)V", "isOnlyMobile", "isNotLimit", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationEditorModel extends CommonEditorModel<Location> {
    public static final a Companion = null;
    public static final String NOT_LIMIT = "NOT_LIMIT";
    public static final String ONLY_MOBILE = "ONLY_MOBILE";
    private String fieldName;
    private String inputType;
    private boolean isInForm;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isNotLimit() {
        return TextUtils.equals(this.inputType, NOT_LIMIT);
    }

    public final boolean isOnlyMobile() {
        return TextUtils.equals(this.inputType, ONLY_MOBILE);
    }

    public LocationEditorModel() {
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getInputType() {
        return this.inputType;
    }

    public final boolean isInForm() {
        return this.isInForm;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setInForm(boolean r100) {
        this.isInForm = r100;
    }

    public final void setInputType(String r100) {
        this.inputType = r100;
    }
}
