package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.model.field.RichOptionItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fp4.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f207152o = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<d> f207153n;

    public static final class a {
        public static List a(List r110, FieldProperty r111) {
            Intrinsics.checkNotNullParameter(r110, "colors");
            if (r111 == null) goto L9;
            RichOptionItem[] r112 = r111.getOptions();
            if (r112 == null) goto L9;
            ArrayList r100 = new ArrayList(r112.length);
            int r101 = r112.length;
            int r102 = 0;
        L7:
            if (r102 >= r101) goto L12;
            RichOptionItem r103 = r112[r102];
            int r104 = r103.getColor() % r110.size();
            r100.add(new d(r103, new com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a(r103.getId(), r103.getName(), r104, ((TableMetaModel.ColorsMap) ListProtector.get(r110, r104)).color, ((TableMetaModel.ColorsMap) ListProtector.get(r110, r104)).textColor, ((TableMetaModel.ColorsMap) ListProtector.get(r110, r104)).borderColor)));
            r102 = r102 + 1;
            goto L7
        L12:
            return r100;
        L9:
            return null;
        }
    }

    static {
    }

    public c(g r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "baseSTField");
        super(r100);
        this.f207153n = r101;
    }
}
