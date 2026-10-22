package com.bytedance.ee.bear.bitable.filter.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.bitable.common.model.field.OptionsType;
import com.bytedance.ee.util.io.NonProguard;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002LMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0016J\u0006\u0010H\u001a\u00020FJ\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR$\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001e\u0010:\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\u001a\u0010<\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001e\u0010>\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00105\"\u0004\bD\u00107R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "type", "", "fieldUIType", "valueType", "Ljava/lang/Integer;", "operators", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "getOperators", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "setOperators", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", BdpAppEventConstant.MULTIPLE, "", "getMultiple", "()Ljava/lang/Boolean;", "setMultiple", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dateFormat", "getDateFormat", "setDateFormat", "timeFormat", "getTimeFormat", "setTimeFormat", "selectFieldOptions", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "getSelectFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "setSelectFieldOptions", "([Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;)V", "[Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$SimpleFieldProperty;", "getProperty", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$SimpleFieldProperty;", "setProperty", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$SimpleFieldProperty;)V", "isDeniedField", "()Z", "setDeniedField", "(Z)V", "isHidden", "setHidden", "isPartialDenied", "setPartialDenied", "isRemoteCompute", "setRemoteCompute", "invalidType", "getInvalidType", "()Ljava/lang/Integer;", "setInvalidType", "(Ljava/lang/Integer;)V", "isSync", "setSync", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "getAvaliableOperatorOption", "getFieldCompositeType", "getValueFieldType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "isProxyType", "OperatorOption", "SimpleFieldProperty", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FilterFieldOption implements NonProguard {
    private String dateFormat;
    private FieldCompositeType fieldCompositeType;
    private final String fieldUIType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f211882id;
    private Integer invalidType;
    private boolean isDeniedField;
    private boolean isHidden;
    private Boolean isPartialDenied;
    private boolean isRemoteCompute;
    private boolean isSync;
    private Boolean multiple;
    private String name;
    private OperatorOption[] operators;
    private SimpleFieldProperty property;
    private OptionItem[] selectFieldOptions;
    private String timeFormat;
    private final int type;
    private final Integer valueType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "text", "getText", "setText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OperatorOption implements NonProguard {
        private String text;
        private String value;

        public OperatorOption() {
        }

        public final String getText() {
            return this.text;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setValue(String r100) {
            this.value = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$SimpleFieldProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "optionsType", "", "getOptionsType", "()I", "setOptionsType", "(I)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SimpleFieldProperty implements NonProguard {
        private int optionsType;

        public SimpleFieldProperty() {
            this.optionsType = OptionsType.STATIC.getValue();
        }

        public final int getOptionsType() {
            return this.optionsType;
        }

        public final void setOptionsType(int r100) {
            this.optionsType = r100;
        }
    }

    public FilterFieldOption() {
    }

    public final OperatorOption[] getAvaliableOperatorOption() {
        OperatorOption[] r100 = this.operators;
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L19;
        OperatorOption r104 = r100[r103];
        EFilterOperator.a r105 = EFilterOperator.Companion;
        String r106 = r104.getValue();
        r105.getClass();
        if (EFilterOperator.a.a(r106) == EFilterOperator.UnSupport) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == false) goto L12;
        r101.add(r104);
    L12:
        r103 = r103 + 1;
        goto L5
    L9:
        r107 = false;
        goto L10
    L19:
        return (OperatorOption[]) r101.toArray(new OperatorOption[0]);
    L14:
        return null;
    }

    public final FieldCompositeType getFieldCompositeType() {
        FieldCompositeType r100 = this.fieldCompositeType;
        if (r100 != null) goto L6;
        FieldCompositeType r101 = new FieldCompositeType(Integer.valueOf(this.type), this.fieldUIType);
        this.fieldCompositeType = r101;
        return r101;
    L6:
        return r100;
    }

    public final EFieldType getValueFieldType() {
        EFieldType.a r100 = EFieldType.Companion;
        Integer r101 = this.valueType;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = Integer.valueOf(r102);
        r100.getClass();
        return EFieldType.a.a(r103);
    L5:
        r102 = this.type;
        goto L6
    }

    public final boolean isProxyType() {
        Integer r100 = this.valueType;
        if (r100 == null) goto L10;
        int r101 = this.type;
        if (r100 != null) goto L8;
    L9:
        return true;
    L8:
        if (r101 != r100.intValue()) goto L9;
    L10:
        return false;
    }

    public final String getDateFormat() {
        return this.dateFormat;
    }

    public final String getId() {
        return this.f211882id;
    }

    public final Integer getInvalidType() {
        return this.invalidType;
    }

    public final Boolean getMultiple() {
        return this.multiple;
    }

    public final String getName() {
        return this.name;
    }

    public final OperatorOption[] getOperators() {
        return this.operators;
    }

    public final SimpleFieldProperty getProperty() {
        return this.property;
    }

    public final OptionItem[] getSelectFieldOptions() {
        return this.selectFieldOptions;
    }

    public final String getTimeFormat() {
        return this.timeFormat;
    }

    public final boolean isDeniedField() {
        return this.isDeniedField;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final Boolean isPartialDenied() {
        return this.isPartialDenied;
    }

    public final boolean isRemoteCompute() {
        return this.isRemoteCompute;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final void setDateFormat(String r100) {
        this.dateFormat = r100;
    }

    public final void setDeniedField(boolean r100) {
        this.isDeniedField = r100;
    }

    public final void setHidden(boolean r100) {
        this.isHidden = r100;
    }

    public final void setId(String r100) {
        this.f211882id = r100;
    }

    public final void setInvalidType(Integer r100) {
        this.invalidType = r100;
    }

    public final void setMultiple(Boolean r100) {
        this.multiple = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setOperators(OperatorOption[] r100) {
        this.operators = r100;
    }

    public final void setPartialDenied(Boolean r100) {
        this.isPartialDenied = r100;
    }

    public final void setProperty(SimpleFieldProperty r100) {
        this.property = r100;
    }

    public final void setRemoteCompute(boolean r100) {
        this.isRemoteCompute = r100;
    }

    public final void setSelectFieldOptions(OptionItem[] r100) {
        this.selectFieldOptions = r100;
    }

    public final void setSync(boolean r100) {
        this.isSync = r100;
    }

    public final void setTimeFormat(String r100) {
        this.timeFormat = r100;
    }
}
