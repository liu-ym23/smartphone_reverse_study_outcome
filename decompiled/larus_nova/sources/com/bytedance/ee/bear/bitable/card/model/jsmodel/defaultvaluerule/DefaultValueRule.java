package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRule;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "getType", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "value", "", "getValue", "()Ljava/lang/Object;", "getValueWhenAddRecord", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "isEmptyRule", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DefaultValueRule extends NonProguard {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getValue(DefaultValueRule r100) {
            return null;
        }

        public static Object $default$getValueWhenAddRecord(DefaultValueRule r100, EFieldType r101) {
            return null;
        }

        public static boolean $default$isEmptyRule(DefaultValueRule r100) {
            return true;
        }

        public static /* synthetic */ Object getValueWhenAddRecord$default(DefaultValueRule r100, EFieldType r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.getValueWhenAddRecord(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getValueWhenAddRecord");
        }
    }

    DefaultValueRuleType getType();

    Object getValue();

    Object getValueWhenAddRecord(EFieldType r100);

    boolean isEmptyRule();
}
