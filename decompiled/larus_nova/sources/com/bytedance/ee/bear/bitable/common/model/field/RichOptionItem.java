package com.bytedance.ee.bear.bitable.common.model.field;

import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageFieldConfigInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/RichOptionItem;", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "<init>", "()V", "transitionRule", "", "getTransitionRule", "()Ljava/lang/String;", "setTransitionRule", "(Ljava/lang/String;)V", "fieldsConfigInfo", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageFieldConfigInfo;", "Lkotlin/collections/ArrayList;", "getFieldsConfigInfo", "()Ljava/util/ArrayList;", "setFieldsConfigInfo", "(Ljava/util/ArrayList;)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichOptionItem extends OptionItem {
    public static final a Companion = null;
    private ArrayList<StageFieldConfigInfo> fieldsConfigInfo;
    private String transitionRule;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static RichOptionItem a(OptionItem r100) {
            Intrinsics.checkNotNullParameter(r100, "optionItem");
            RichOptionItem r101 = new RichOptionItem();
            r101.setId(r100.getId());
            r101.setName(r100.getName());
            r101.setColor(r100.getColor());
            r101.setBorderColor(r100.getBorderColor());
            r101.setType(r100.getType());
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final RichOptionItem from(OptionItem r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public RichOptionItem() {
    }

    public final ArrayList<StageFieldConfigInfo> getFieldsConfigInfo() {
        return this.fieldsConfigInfo;
    }

    public final String getTransitionRule() {
        return this.transitionRule;
    }

    public final void setFieldsConfigInfo(ArrayList<StageFieldConfigInfo> r100) {
        this.fieldsConfigInfo = r100;
    }

    public final void setTransitionRule(String r100) {
        this.transitionRule = r100;
    }
}
