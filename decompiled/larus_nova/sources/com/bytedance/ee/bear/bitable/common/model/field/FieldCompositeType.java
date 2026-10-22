package com.bytedance.ee.bear.bitable.common.model.field;

import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bB\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "uiType", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "getType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "getUiType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "icon", "getIcon", "()I", "reportValue", "getReportValue", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldCompositeType implements NonProguard {
    private final EFieldType type;
    private final EFieldUIType uiType;

    public FieldCompositeType() {
        this(EFieldType.NOT_SUPPORT, EFieldUIType.NOT_SUPPORT);
    }

    public final int getIcon() {
        if (this.uiType != EFieldUIType.CURRENCY) goto L11;
        Locale r100 = ((i0) a.c(i0.class, null, null, 6)).c();
        if (Intrinsics.areEqual(r100.getCountry(), Locale.SIMPLIFIED_CHINESE.getCountry()) == false) goto L11;
        if (Intrinsics.areEqual(r100.getLanguage(), Locale.SIMPLIFIED_CHINESE.getLanguage()) == false) goto L11;
        return R.drawable.ud_icon_currency_yuan_outlined;
    L11:
        return this.uiType.getIconRes();
    }

    public final String getReportValue() {
        return this.uiType.getReportValue();
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.uiType.hashCode();
    }

    public final EFieldType getType() {
        return this.type;
    }

    public final EFieldUIType getUiType() {
        return this.uiType;
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(FieldCompositeType.class, r101) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType");
        FieldCompositeType r102 = (FieldCompositeType) r100;
        if (this.type == r102.type) goto L13;
        return false;
    L13:
        if (this.uiType == r102.uiType) goto L15;
        return false;
    L15:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public FieldCompositeType(Integer r100, String r101) {
        EFieldType.Companion.getClass();
        EFieldType r102 = EFieldType.a.a(r100);
        EFieldUIType.Companion.getClass();
        this(r102, EFieldUIType.a.a(r101));
    }

    public FieldCompositeType(EFieldType r100, EFieldUIType r101) {
        if (r100 != null) goto L5;
        r100 = EFieldType.NOT_SUPPORT;
    L5:
        this.type = r100;
        if (r101 != null) goto L8;
        r101 = EFieldUIType.NOT_SUPPORT;
    L8:
        this.uiType = r101;
    }
}
