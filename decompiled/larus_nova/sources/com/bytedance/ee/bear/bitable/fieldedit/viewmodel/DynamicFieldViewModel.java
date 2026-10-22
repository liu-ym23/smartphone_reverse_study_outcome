package com.bytedance.ee.bear.bitable.fieldedit.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.SelectFieldCondition;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0003bcdB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%09H\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0006\u0010?\u001a\u00020\u0006J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020=2\b\u0010D\u001a\u0004\u0018\u00010!J\u000e\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u0013J\b\u0010G\u001a\u0004\u0018\u00010BJ\u000e\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020\u0013J\u000e\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020%J\u000e\u0010L\u001a\u00020=2\u0006\u0010K\u001a\u00020%J\u0014\u0010M\u001a\u00020=2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020%0\u0012J\u001c\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0016090P2\b\b\u0002\u0010Q\u001a\u00020\u0006J\u001c\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0013090P2\b\b\u0002\u0010Q\u001a\u00020\u0006J\u001c\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0013090P2\b\b\u0002\u0010Q\u001a\u00020\u0006J\u0012\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010V\u001a\u00020\u00132\u0006\u0010W\u001a\u00020!H\u0016J\u0010\u0010X\u001a\u00020\u00132\u0006\u0010W\u001a\u00020!H\u0016J\u001e\u0010Y\u001a\u00020\u00132\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u0013092\u0006\u0010[\u001a\u00020!H\u0002J\u001e\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0013090P2\b\u0010]\u001a\u0004\u0018\u00010!H\u0002J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020!0P2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!09J\b\u0010`\u001a\u0004\u0018\u000104J\u0006\u0010a\u001a\u00020=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00120\u0018¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR \u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001c\u0010+\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/SelectFieldDataSource;", "<init>", "()V", "hasInjectProperty", "", "getHasInjectProperty", "()Z", "setHasInjectProperty", "(Z)V", "fetchDelegate", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel$FetchDelegate;", "getFetchDelegate", "()Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel$FetchDelegate;", "setFetchDelegate", "(Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel$FetchDelegate;)V", "currentTableFields", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "targetTableFields", "tableList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "targetTableBean", "Landroidx/lifecycle/MutableLiveData;", "getTargetTableBean", "()Landroidx/lifecycle/MutableLiveData;", "setTargetTableBean", "(Landroidx/lifecycle/MutableLiveData;)V", "targetFieldBean", "getTargetFieldBean", "setTargetFieldBean", "conjunction", "", "getConjunction", "setConjunction", "conditionList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/SelectFieldConditionWrap;", "getConditionList", "editConditionIndex", "", "getEditConditionIndex", "setEditConditionIndex", "currentTableId", "getCurrentTableId", "()Ljava/lang/String;", "setCurrentTableId", "(Ljava/lang/String;)V", "currentFieldId", "getCurrentFieldId", "setCurrentFieldId", "bitableFieldEditAnalytic", "Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "getBitableFieldEditAnalytic", "()Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "setBitableFieldEditAnalytic", "(Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;)V", "", "getTargetTable", "getTargetField", "selectNewTableBean", "", "tableBean", "verifyConditionList", "conditionIsVerify", FilterData.FilterSheetItem.Id.FILTER_CONDITION, "Lcom/bytedance/ee/bear/bitable/filter/model/SelectFieldCondition;", "updateCurrentConditonOperator", OnekeyLoginConstants.CU_KEY_OPERATOR, "updateCurrentConditonTargetField", "targetField", "getCurrentEditCondition", "updateCurrentConditonValue", "currentField", "removeFilterConditionWrap", "filterConditionWrap", "addFilterConditionWrap", "addFilterConditionWrapList", "filterConditionWrapList", "getCurrentTableList", "Lio/reactivex/Observable;", "forceRefresh", "getCurrentTableFields", "getTargetTableFields", "getOperatorByCondition", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "getConditionCurrentFieldById", "fieldId", "getConditionTargetFieldById", "getFiledOptionById", "fieldList", "findFieldId", "getFieldListByTableId", "tableId", "getNewConditionId", "ids", "getBitableAnalytic", "clear", "FetchDelegate", "DeleteTable", "DeleteField", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicFieldViewModel extends ViewModel implements com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d {
    private BitableFieldEditAnalytic bitableFieldEditAnalytic;
    private final MutableLiveData<List<com.bytedance.ee.bear.bitable.fieldedit.model.a>> conditionList;
    private MutableLiveData<String> conjunction;
    private String currentFieldId;
    private List<FilterFieldOption> currentTableFields;
    private String currentTableId;
    private MutableLiveData<Integer> editConditionIndex;
    private a fetchDelegate;
    private boolean hasInjectProperty;
    private List<FieldEditPanelData.TableBean> tableList;
    private MutableLiveData<FilterFieldOption> targetFieldBean;
    private MutableLiveData<FieldEditPanelData.TableBean> targetTableBean;
    private List<FilterFieldOption> targetTableFields;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel$DeleteField;", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeleteField extends FilterFieldOption {
        public DeleteField() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/DynamicFieldViewModel$DeleteTable;", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeleteTable extends FieldEditPanelData.TableBean {
        public DeleteTable() {
        }
    }

    public interface a {
        <T> Observable<T> c(CommonActionType r100, JSONObject r101, Class<T> r102);
    }

    public static final class b<T> implements ObservableSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f211813b;

        public b(DynamicFieldViewModel r100, boolean r101) {
            this.f211812a = r100;
            this.f211813b = r101;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super List<? extends FilterFieldOption>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            if (DynamicFieldViewModel.access$getCurrentTableFields$p(this.f211812a).isEmpty() == true) goto L8;
            if (this.f211813b == true) goto L8;
            r100.onNext(DynamicFieldViewModel.access$getCurrentTableFields$p(this.f211812a));
        L8:
            if (this.f211813b == false) goto L10;
            DynamicFieldViewModel.access$getCurrentTableFields$p(this.f211812a).clear();
        L10:
            r100.onComplete();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211814a;

        public c(DynamicFieldViewModel r100) {
            this.f211814a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            DynamicFieldViewModel.access$getCurrentTableFields$p(this.f211814a).clear();
            List r102 = DynamicFieldViewModel.access$getCurrentTableFields$p(this.f211814a);
            Intrinsics.checkNotNull(r101);
            r102.addAll(r101);
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f211816b;

        public d(DynamicFieldViewModel r100, boolean r101) {
            this.f211815a = r100;
            this.f211816b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<List<FieldEditPanelData.TableBean>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (DynamicFieldViewModel.access$getTableList$p(this.f211815a).isEmpty() == true) goto L8;
            if (this.f211816b == true) goto L8;
            r100.onNext(DynamicFieldViewModel.access$getTableList$p(this.f211815a));
        L8:
            if (this.f211816b == false) goto L10;
            DynamicFieldViewModel.access$getTableList$p(this.f211815a).clear();
        L10:
            r100.onComplete();
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f211817a = null;

        static {
            f211817a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            List r102 = (List) GsonProtectorUtils.fromJson(new Gson(), r101, new com.bytedance.ee.bear.bitable.fieldedit.viewmodel.b().getType());
            if (r102 == null) goto L5;
            return r102;
        L5:
            return CollectionsKt.emptyList();
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211818a;

        public f(DynamicFieldViewModel r100) {
            this.f211818a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            DynamicFieldViewModel.access$getTableList$p(this.f211818a).clear();
            List r102 = DynamicFieldViewModel.access$getTableList$p(this.f211818a);
            Intrinsics.checkNotNull(r101);
            r102.addAll(r101);
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T, R> f211819a = null;

        static {
            f211819a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            List r102 = (List) GsonProtectorUtils.fromJson(new Gson(), r101, new com.bytedance.ee.bear.bitable.fieldedit.viewmodel.c().getType());
            if (r102 == null) goto L5;
            return r102;
        L5:
            return CollectionsKt.emptyList();
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T, R> f211820a = null;

        static {
            f211820a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            String[] r102 = (String[]) GsonProtectorUtils.fromJson(new Gson(), r101, String[].class);
            Intrinsics.checkNotNull(r102);
            if (r102.length != 0) goto L5;
            boolean r103 = true;
        L7:
            if ((!r103) == true) goto L10;
            r102 = null;
        L10:
            if (r102 == null) goto L13;
            String r104 = r102[0];
            if (r104 == null) goto L13;
            return r104;
        L13:
            return "";
        L5:
            r103 = false;
            goto L7
        }
    }

    public static final class i<T> implements ObservableSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f211822b;

        public i(DynamicFieldViewModel r100, boolean r101) {
            this.f211821a = r100;
            this.f211822b = r101;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super List<? extends FilterFieldOption>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            if (DynamicFieldViewModel.access$getTargetTableFields$p(this.f211821a).isEmpty() == true) goto L8;
            if (this.f211822b == true) goto L8;
            r100.onNext(DynamicFieldViewModel.access$getTargetTableFields$p(this.f211821a));
        L8:
            if (this.f211822b == false) goto L10;
            DynamicFieldViewModel.access$getTargetTableFields$p(this.f211821a).clear();
        L10:
            r100.onComplete();
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicFieldViewModel f211823a;

        public j(DynamicFieldViewModel r100) {
            this.f211823a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            DynamicFieldViewModel.access$getTargetTableFields$p(this.f211823a).clear();
            List r102 = DynamicFieldViewModel.access$getTargetTableFields$p(this.f211823a);
            Intrinsics.checkNotNull(r101);
            r102.addAll(r101);
        }
    }

    public final void clear() {
        this.targetTableBean.setValue(null);
        this.targetFieldBean.setValue(null);
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r100 = this.conditionList.getValue();
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.currentTableFields.clear();
        this.targetTableFields.clear();
        this.conjunction.setValue(null);
        this.tableList.clear();
        this.editConditionIndex.setValue(-1);
        this.hasInjectProperty = false;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    /* JADX INFO: renamed from: getConditionList, reason: collision with other method in class */
    public List<com.bytedance.ee.bear.bitable.fieldedit.model.a> mo8313getConditionList() {
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r100 = this.conditionList.getValue();
        if (r100 == null) goto L7;
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = CollectionsKt.toList(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public final SelectFieldCondition getCurrentEditCondition() {
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r100 = this.conditionList.getValue();
        if (r100 == null) goto L8;
        Integer r101 = this.editConditionIndex.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r100, r101.intValue())).f211141b;
    L8:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    public FilterFieldOption getTargetField() {
        return this.targetFieldBean.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    public FieldEditPanelData.TableBean getTargetTable() {
        return this.targetTableBean.getValue();
    }

    public final boolean verifyConditionList() {
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r100 = this.conditionList.getValue();
        if (r100 == null) goto L14;
        Iterator<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        if (conditionIsVerify(r101.next().f211141b) == true) goto L6;
        return false;
    L15:
        return true;
    L14:
        return true;
    }

    public DynamicFieldViewModel() {
        this.currentTableFields = new ArrayList();
        this.targetTableFields = new ArrayList();
        this.tableList = new ArrayList();
        this.targetTableBean = new MutableLiveData();
        this.targetFieldBean = new MutableLiveData();
        this.conjunction = new MutableLiveData();
        this.conditionList = new MutableLiveData(new ArrayList());
        this.editConditionIndex = new MutableLiveData(-1);
    }

    public final BitableFieldEditAnalytic getBitableAnalytic() {
        return this.bitableFieldEditAnalytic;
    }

    public final BitableFieldEditAnalytic getBitableFieldEditAnalytic() {
        return this.bitableFieldEditAnalytic;
    }

    public final MutableLiveData<String> getConjunction() {
        return this.conjunction;
    }

    public final String getCurrentFieldId() {
        return this.currentFieldId;
    }

    public final String getCurrentTableId() {
        return this.currentTableId;
    }

    public final MutableLiveData<Integer> getEditConditionIndex() {
        return this.editConditionIndex;
    }

    public final a getFetchDelegate() {
        return this.fetchDelegate;
    }

    public final boolean getHasInjectProperty() {
        return this.hasInjectProperty;
    }

    public final MutableLiveData<FilterFieldOption> getTargetFieldBean() {
        return this.targetFieldBean;
    }

    public final MutableLiveData<FieldEditPanelData.TableBean> getTargetTableBean() {
        return this.targetTableBean;
    }

    public final MutableLiveData<List<com.bytedance.ee.bear.bitable.fieldedit.model.a>> getConditionList() {
        return this.conditionList;
    }

    public static final /* synthetic */ List access$getCurrentTableFields$p(DynamicFieldViewModel r100) {
        return r100.currentTableFields;
    }

    public static final /* synthetic */ List access$getTableList$p(DynamicFieldViewModel r100) {
        return r100.tableList;
    }

    public static final /* synthetic */ List access$getTargetTableFields$p(DynamicFieldViewModel r100) {
        return r100.targetTableFields;
    }

    private final boolean conditionIsVerify(SelectFieldCondition r100) {
        if (TextUtils.isEmpty(r100.getFieldId()) == false) goto L5;
    L16:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getOperator()) == true) goto L16;
        if (com.bytedance.ee.bear.bitable.filter.model.a.a(r100.getOperator()) == false) goto L10;
        return true;
    L10:
        if (r100.getValue() != null) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(String.valueOf(r100.getValue())) == true) goto L18;
        return true;
    L18:
        return false;
    }

    private final Observable<List<FilterFieldOption>> getFieldListByTableId(String r100) {
        a r101 = this.fetchDelegate;
        if (r101 == null) goto L10;
        CommonActionType r102 = CommonActionType.GET_FIELD_LIST;
        JSONObject r103 = new JSONObject();
        r103.put2("tableId", r100);
        Unit r104 = Unit.INSTANCE;
        Observable r105 = r101.c(r102, r103, String.class);
        if (r105 == null) goto L10;
        Observable<List<FilterFieldOption>> r106 = r105.map(g.f211819a);
        if (r106 == null) goto L10;
        return r106;
    L10:
        return Observable.just(CollectionsKt.emptyList());
    }

    public final void addFilterConditionWrap(com.bytedance.ee.bear.bitable.fieldedit.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "filterConditionWrap");
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L6;
        r101.add(r100);
        this.conditionList.setValue(r101);
        return;
    }

    public final void addFilterConditionWrapList(List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "filterConditionWrapList");
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L6;
        r101.addAll(r100);
        this.conditionList.setValue(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    public FilterFieldOption getConditionCurrentFieldById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldId");
        return getFiledOptionById(this.currentTableFields, r100);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    public FilterFieldOption getConditionTargetFieldById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldId");
        return getFiledOptionById(this.targetTableFields, r100);
    }

    public final Observable<List<FilterFieldOption>> getCurrentTableFields(boolean r100) {
        b r101 = new b(this, r100);
        String r102 = this.currentTableId;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return Observable.concat(r101, getFieldListByTableId(r102).doOnNext(new c(this))).firstElement().toObservable();
    }

    public final Observable<List<FieldEditPanelData.TableBean>> getCurrentTableList(boolean r100) {
        Observable r101 = Observable.create(new d(this, r100));
        a r102 = this.fetchDelegate;
        if (r102 == null) goto L11;
        Observable r103 = r102.c(CommonActionType.GET_CURRENT_TABLE_LIST, new JSONObject(), String.class);
        if (r103 == null) goto L11;
        Observable r104 = r103.map(e.f211817a);
        if (r104 == null) goto L11;
        Observable r105 = r104.doOnNext(new f(this));
        if (r105 == null) goto L11;
    L13:
        return Observable.concat(r101, r105).firstElement().toObservable();
    L11:
        r105 = Observable.just(CollectionsKt.emptyList());
        goto L13
    }

    public final Observable<String> getNewConditionId(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        a r101 = this.fetchDelegate;
        if (r101 == null) goto L10;
        CommonActionType r102 = CommonActionType.GET_NEW_CONDITION_IDS;
        JSONObject r103 = new JSONObject();
        r103.put2("ids", r100);
        r103.put2("total", 1);
        Unit r104 = Unit.INSTANCE;
        Observable r105 = r101.c(r102, r103, String.class);
        if (r105 == null) goto L10;
        Observable<String> r106 = r105.map(h.f211820a);
        if (r106 == null) goto L10;
        return r106;
    L10:
        return Observable.just("");
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d
    public FilterFieldOption.OperatorOption getOperatorByCondition(SelectFieldCondition r100) {
        Intrinsics.checkNotNullParameter(r100, FilterData.FilterSheetItem.Id.FILTER_CONDITION);
        Iterator<T> r101 = this.targetTableFields.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (TextUtils.equals(r100.getFieldId(), ((FilterFieldOption) r102).getId()) == false) goto L4;
    L9:
        FilterFieldOption r103 = (FilterFieldOption) r102;
        if (r103 == null) goto L22;
        FilterFieldOption.OperatorOption[] r104 = r103.getAvaliableOperatorOption();
        if (r104 == null) goto L22;
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L19;
        FilterFieldOption.OperatorOption r107 = r104[r106];
        if (TextUtils.equals(r100.getOperator(), r107.getValue()) == true) goto L20;
        r106 = r106 + 1;
    L20:
        if (r107 == null) goto L22;
        return r107;
    L19:
        r107 = null;
    L22:
        String r108 = r100.getOperator();
        if (r108 == null) goto L32;
        FilterFieldOption.OperatorOption r109 = new FilterFieldOption.OperatorOption();
        r109.setValue(r108);
        r109.setText(null);
        return r109;
    L32:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public final Observable<List<FilterFieldOption>> getTargetTableFields(boolean r100) {
        i r101 = new i(this, r100);
        FieldEditPanelData.TableBean r102 = this.targetTableBean.getValue();
        if (r102 == null) goto L5;
        String r103 = r102.getTableId();
    L7:
        return Observable.concat(r101, getFieldListByTableId(r103).doOnNext(new j(this))).firstElement().toObservable();
    L5:
        r103 = null;
        goto L7
    }

    public final void removeFilterConditionWrap(com.bytedance.ee.bear.bitable.fieldedit.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "filterConditionWrap");
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L6;
        r101.remove(r100);
        this.conditionList.setValue(r101);
        return;
    }

    public final void selectNewTableBean(FieldEditPanelData.TableBean r100) {
        this.targetTableBean.setValue(r100);
        this.targetFieldBean.setValue(null);
        MutableLiveData<List<com.bytedance.ee.bear.bitable.fieldedit.model.a>> r101 = this.conditionList;
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r102 = r101.getValue();
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r103 = r102;
        if (r103 == null) goto L5;
        r103.clear();
    L5:
        r101.setValue(r102);
    }

    public final void setBitableFieldEditAnalytic(BitableFieldEditAnalytic r100) {
        this.bitableFieldEditAnalytic = r100;
    }

    public final void setConjunction(MutableLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.conjunction = r100;
    }

    public final void setCurrentFieldId(String r100) {
        this.currentFieldId = r100;
    }

    public final void setCurrentTableId(String r100) {
        this.currentTableId = r100;
    }

    public final void setEditConditionIndex(MutableLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.editConditionIndex = r100;
    }

    public final void setFetchDelegate(a r100) {
        this.fetchDelegate = r100;
    }

    public final void setHasInjectProperty(boolean r100) {
        this.hasInjectProperty = r100;
    }

    public final void setTargetFieldBean(MutableLiveData<FilterFieldOption> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.targetFieldBean = r100;
    }

    public final void setTargetTableBean(MutableLiveData<FieldEditPanelData.TableBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.targetTableBean = r100;
    }

    public final void updateCurrentConditonOperator(String r100) {
        if (r100 == null) goto L18;
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L19;
        Integer r102 = this.editConditionIndex.getValue();
        if (r102 == null) goto L20;
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 >= 0) goto L10;
    L12:
        if (r104 == false) goto L21;
        ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r101, r103)).f211141b.setOperator(r100);
        if (com.bytedance.ee.bear.bitable.filter.model.a.a(r100) == false) goto L16;
        ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r101, r103)).f211141b.setValue(null);
    L16:
        this.editConditionIndex.setValue(Integer.valueOf(r103));
        return;
    L21:
        return;
    L10:
        if (r103 >= r101.size()) goto L12;
        r104 = true;
        goto L12
    L20:
        return;
    L19:
        return;
    }

    public final void updateCurrentConditonTargetField(FilterFieldOption r100) {
        Intrinsics.checkNotNullParameter(r100, "targetField");
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L19;
        Integer r102 = this.editConditionIndex.getValue();
        if (r102 == null) goto L20;
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 >= 0) goto L9;
    L11:
        if (r104 == false) goto L21;
        SelectFieldCondition r105 = ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r101, r103)).f211141b;
        if (TextUtils.equals(r105.getFieldId(), r100.getId()) == true) goto L15;
    L17:
        r105.setFieldId(r100.getId());
        r105.setFieldType(r100.getFieldCompositeType().getType().getValue());
        r105.setOperator(null);
        this.editConditionIndex.setValue(Integer.valueOf(r103));
        return;
    L15:
        if (r105.getFieldType() != r100.getFieldCompositeType().getType().getValue()) goto L17;
        return;
    L21:
        return;
    L9:
        if (r103 >= r101.size()) goto L11;
        r104 = true;
        goto L11
    L20:
        return;
    }

    public final void updateCurrentConditonValue(FilterFieldOption r100) {
        Intrinsics.checkNotNullParameter(r100, "currentField");
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101 = this.conditionList.getValue();
        if (r101 == null) goto L20;
        Integer r102 = this.editConditionIndex.getValue();
        if (r102 == null) goto L21;
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 >= 0) goto L9;
    L11:
        if (r104 == false) goto L22;
        String r105 = ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r101, r103)).f211141b.getValue();
        if (r105 != null) goto L17;
        r105 = null;
    L17:
        if (TextUtils.equals(r105, r100.getId()) == true) goto L23;
        ((com.bytedance.ee.bear.bitable.fieldedit.model.a) ListProtector.get(r101, r103)).f211141b.setValue(r100.getId());
        this.editConditionIndex.setValue(Integer.valueOf(r103));
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if (r103 >= r101.size()) goto L11;
        r104 = true;
        goto L11
    L21:
        return;
    }

    private final FilterFieldOption getFiledOptionById(List<? extends FilterFieldOption> r100, String r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (TextUtils.equals(r101, ((FilterFieldOption) r103).getId()) == false) goto L4;
    L9:
        FilterFieldOption r104 = (FilterFieldOption) r103;
        if (r104 != null) goto L16;
        DeleteField r105 = new DeleteField();
        r105.setId(r101);
        r105.setName(UIHelper.getString(R.string.Bitable_SingleOption_ReferencedFieldDeletedTip_Mobile));
        return r105;
    L16:
        return r104;
    L8:
        r103 = null;
        goto L9
    }

    public static /* synthetic */ Observable getCurrentTableFields$default(DynamicFieldViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.getCurrentTableFields(r101);
    }

    public static /* synthetic */ Observable getCurrentTableList$default(DynamicFieldViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.getCurrentTableList(r101);
    }

    public static /* synthetic */ Observable getTargetTableFields$default(DynamicFieldViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.getTargetTableFields(r101);
    }
}
