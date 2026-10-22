package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class UserFilterConditionView extends com.bytedance.ee.bear.bitable.filter.condition.a<UserEntity[]> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UserEntity[] f211841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f211842q;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/condition/UserFilterConditionView$UserListResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "getData", "()[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "setData", "([Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;)V", "[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserListResult implements NonProguard {
        private UserEntity[] data;

        public UserListResult() {
        }

        public final UserEntity[] getData() {
            return this.data;
        }

        public final void setData(UserEntity[] r100) {
            this.data = r100;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List b(Object r110) {
        UserEntity[] r111 = (UserEntity[]) r110;
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        if (r111 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        String r103 = this.f211842q;
        if (r103 != null) goto L19;
        r103 = Locale.getDefault().getLanguage();
    L19:
        ArrayList r104 = new ArrayList();
        int r105 = r111.length;
    L20:
        if (r101 >= r105) goto L27;
        UserEntity r106 = r111[r101];
        if (r106.isCurrentUser() == false) goto L24;
        r104.add(getContext().getString(R.string.Bitable_FieldType_PeopleField_CurrentVisitor_Option));
    L25:
        r101 = r101 + 1;
        goto L20
    L24:
        r104.add(ou5.a.a(r103, r106.getDisplayName(), r106.getName(), r106.getEnName()));
        goto L25
    L27:
        if ((!r104.isEmpty()) == false) goto L29;
        String r112 = yu5.c.l(r104, ", ");
    L30:
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r112, this.f211848f, null, false, 12));
    L31:
        return r100;
    L29:
        r112 = null;
        goto L30
    L14:
        if (m() == false) goto L31;
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
        goto L31
    L5:
        if (r111.length != 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r107 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a
    public final boolean h(UserEntity[] r100) {
        UserEntity[] r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        UserEntity[] r102 = this.f211841p;
        if (r102 == null) goto L10;
        int r103 = r101.length;
        int r104 = 0;
        boolean r105 = false;
    L5:
        if (r104 >= r103) goto L32;
        if (ArraysKt.contains(r102, r101[r104]) == true) goto L9;
        r105 = true;
    L9:
        r104 = r104 + 1;
        goto L5
    L32:
        return r105;
    L10:
        int r106 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("ccm.bitable.get_field_user_options_disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.get_field_user_options_disable") == false) goto L28;
        k.a r107 = this.f211849g;
        Disposable r108 = null;
        if (r107 == null) goto L25;
        EQueryType r109 = EQueryType.GET_FIELD_USER_OPTIONS;
        JSONObject r110 = new JSONObject();
        FilterFieldOption r111 = this.f211857o;
        if (r111 == null) goto L17;
        String r112 = r111.getId();
    L18:
        r110.put("fieldId", r112);
        Unit r113 = Unit.INSTANCE;
        Observable r114 = r107.d(r109, r110, UserListResult.class);
        if (r114 == null) goto L25;
        Observable r115 = r114.map(r.f211866a);
        if (r115 == null) goto L25;
        Observable r116 = r115.doOnNext(new s(this));
        if (r116 == null) goto L25;
        r108 = r116.subscribe(new t(this, r101), u.f211870a);
        goto L25
    L17:
        r112 = null;
    L25:
        if (r108 == null) goto L28;
        this.f211850h.add(r108);
    L28:
        return this.f211852j;
    }

    public UserFilterConditionView(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
        this.f211842q = r100.getResources().getConfiguration().locale.getLanguage();
    }
}
