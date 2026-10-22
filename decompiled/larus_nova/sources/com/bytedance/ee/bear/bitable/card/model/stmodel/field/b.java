package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import fp4.g;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TableMetaModel.FieldBean f207149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<TableMetaModel.ColorsMap> f207150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public cp4.b f207151p;

    public final boolean a() {
        TableMetaModel.FieldBean r100 = this.f207149n;
        if (r100 == null) goto L13;
        EFieldType r101 = r100.type;
        if (r101 == null) goto L13;
        if (r101 == EFieldType.NOT_SUPPORT) goto L13;
        EFieldUIType r102 = r100.fieldUIType;
        if (r102 == null) goto L13;
        if (r102 == EFieldUIType.NOT_SUPPORT) goto L13;
        return true;
    L13:
        return false;
    }

    public b(g r100, TableMetaModel.FieldBean r101, List r102) {
        super(r100);
        this.f207149n = r101;
        this.f207150o = r102;
    }
}
