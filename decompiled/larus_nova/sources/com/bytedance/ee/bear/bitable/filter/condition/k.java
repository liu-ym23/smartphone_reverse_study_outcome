package com.bytedance.ee.bear.bitable.filter.condition;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public interface k<T> extends ConditionListView.a, ConditionListView.c {

    public interface a {
        void a(FilterCondition r100);

        void b(int r100);

        Single c(BitableAsyncRequestBiz r100, Map r101, Function1 r102);

        <T> Observable<T> d(EQueryType r100, JSONObject r101, Class<T> r102);
    }

    List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(T r100);

    FilterFieldOption f();

    FilterCondition g();

    void onDetach();
}
