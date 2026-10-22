package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.UserList;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserListRule;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRule;", "value", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserListValue;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserListValue;)V", "getValue", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserListValue;", "type", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "getType", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "getValueWhenAddRecord", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/UserList;", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "getUserList", "isEmptyRule", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserListRule implements DefaultValueRule {
    public static final a Companion = null;
    public static final String TAG = "UserListRule";
    private final DefaultValueRuleType type;
    private final UserListValue value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserListRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final UserList getUserList() {
        UserListValue r100 = getValue();
        if (r100 == null) goto L5;
        List<UserDefaultValueRule> r101 = r100.getList();
    L6:
        List<UserDefaultValueRule> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return null;
    L15:
        ArrayList r104 = new ArrayList();
        Iterator<UserDefaultValueRule> r105 = r101.iterator();
    L17:
        if (r105.hasNext() == false) goto L22;
        UserEntity r106 = r105.next().getUser();
        if (r106 == null) goto L17;
        r104.add(r106);
        goto L17
    L22:
        return new UserList(r104);
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public boolean isEmptyRule() {
        UserListValue r100 = getValue();
        if (r100 == null) goto L5;
        List<UserDefaultValueRule> r101 = r100.getList();
    L6:
        List<UserDefaultValueRule> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        return true;
    L9:
        if (r102.isEmpty() == true) goto L12;
        return false;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public DefaultValueRuleType getType() {
        return this.type;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public UserListValue getValue() {
        return this.value;
    }

    public UserListRule(UserListValue r100) {
        this.value = r100;
        this.type = DefaultValueRuleType.USER_LIST;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public List<UserList> getValueWhenAddRecord(EFieldType r100) {
        UserList r101 = getUserList();
        if (r101 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.listOf(r101);
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public /* bridge */ /* synthetic */ Object getValueWhenAddRecord(EFieldType r100) {
        return getValueWhenAddRecord(r100);
    }

    public /* synthetic */ UserListRule(UserListValue r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
