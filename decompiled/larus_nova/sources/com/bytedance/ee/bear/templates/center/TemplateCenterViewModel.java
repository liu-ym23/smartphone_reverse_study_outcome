package com.bytedance.ee.bear.templates.center;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006J\u000e\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020\u0013J\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010J\u001a\u00020D2\u0006\u0010G\u001a\u00020\nJ\u0006\u0010K\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\u0016J\u0012\u0010M\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010\nH\u0002J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0OJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0OJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\n0OJ\u000e\u0010R\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0016J\u000e\u0010S\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006J\u000e\u0010T\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006J\u000e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0OJ\u0006\u0010V\u001a\u00020\u000eJ\b\u0010W\u001a\u0004\u0018\u00010\u0013J\b\u0010X\u001a\u00020\u000eH\u0002J\u0006\u0010Y\u001a\u00020\u000eJ\u0006\u0010Z\u001a\u00020\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u00105\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010/\"\u0004\b6\u00101R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\u001a\u0010@\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentTab", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterLiveData;", "Lcom/bytedance/ee/bear/templates/center/Tab2;", "getCurrentTab", "()Lcom/bytedance/ee/bear/templates/center/TemplateCenterLiveData;", "systemFilter", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "customFilter", "businessFilter", "currentTabFilterStatus", "", "systemFilterStatus", "customFilterStatus", "businessFilterStatus", "searchContent", "", "getSearchContent", "categoryIndex", "", "getCategoryIndex", "deleteToken", "getDeleteToken", "selectedTemplate", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "getSelectedTemplate", "()Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "setSelectedTemplate", "(Lcom/bytedance/ee/bear/templates/data/TemplateV4;)V", EventConstant.Key.MODULE, "getModule", "()Ljava/lang/String;", "setModule", "(Ljava/lang/String;)V", "enterSource", "getEnterSource", "setEnterSource", "initFilterType", "getInitFilterType", "()I", "setInitFilterType", "(I)V", "createBlank", "getCreateBlank", "()Z", "setCreateBlank", "(Z)V", "fixedFilter", "getFixedFilter", "setFixedFilter", "isSpaceV2", "setSpaceV2", "createSelectResult", "Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;", "getCreateSelectResult", "()Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;", "setCreateSelectResult", "(Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;)V", "spaceId", "getSpaceId", "setSpaceId", "templateSource", "getTemplateSource", "setTemplateSource", "setCurrentTab", "", "tab", "saveCurrentTabFilter", "type", "getCurrentTabTag", "entryFormCreateNew", "saveCurrentTabFilterForTopic", "getCurrentTabFilter", "getCurrentTabFilterIndex", "getIndexByDocumentType", "getSystemFilterLiveData", "Landroidx/lifecycle/LiveData;", "getCustomFilterLiveData", "getBusinessFilterLiveData", "saveFilter", "hideFilter", "showFilter", "getCurrentTabFilterStatus", "getCurrentTabFilterStatusValue", "getSearchFilterType", "forbidFilterModify", "isOnlyNewLarkForm", "filterEnable", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCenterViewModel extends ViewModel {
    private static long CATEGORY_ID = 0;
    public static final a Companion = null;
    private static int LAST_INDEX = 0;
    private static final String SP_NAME = "sp_name_template";
    private static final String TAG = "TemplateCenterViewModel";
    private final TemplateCenterLiveData<sbb.e> businessFilter;
    private final TemplateCenterLiveData<Boolean> businessFilterStatus;
    private final TemplateCenterLiveData<Integer> categoryIndex;
    private boolean createBlank;
    private CreateSelectResult createSelectResult;
    private final TemplateCenterLiveData<Tab2> currentTab;
    private final TemplateCenterLiveData<Boolean> currentTabFilterStatus;
    private final TemplateCenterLiveData<sbb.e> customFilter;
    private final TemplateCenterLiveData<Boolean> customFilterStatus;
    private final TemplateCenterLiveData<String> deleteToken;
    private String enterSource;
    private boolean fixedFilter;
    private int initFilterType;
    private boolean isSpaceV2;
    private String module;
    private final TemplateCenterLiveData<String> searchContent;
    private TemplateV4 selectedTemplate;
    private String spaceId;
    private final TemplateCenterLiveData<sbb.e> systemFilter;
    private final TemplateCenterLiveData<Boolean> systemFilterStatus;
    private String templateSource;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238910a = null;

        static {
            int[] r100 = new int[Tab2.values().length];
            r100[Tab2.SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Tab2.BUSNISS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Tab2.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f238910a = r100;
        }
    }

    static {
        Companion = new a();
        CATEGORY_ID = -1;
    }

    public final boolean entryFormCreateNew() {
        if (Intrinsics.areEqual(this.enterSource, "create_new") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(this.enterSource, "create_new_recent") == true) goto L10;
        if (Intrinsics.areEqual(this.enterSource, "create_new_folder_block") == true) goto L10;
        return false;
    }

    public final boolean filterEnable() {
        BenefitStore r100 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        boolean r101 = r100.hasBenefit("ccm_create_doc");
        boolean r102 = r100.hasBenefit("ccm_create_base");
        if (isOnlyNewLarkForm() == true) goto L7;
        if (r101 == true) goto L6;
        if (r102 == false) goto L7;
    L6:
        return true;
    L7:
        return false;
    }

    public final sbb.e getCurrentTabFilter() {
        Tab2 r100 = this.currentTab.getValue();
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != 1) goto L9;
        sbb.e r102 = this.systemFilter.getValue();
    L16:
        if (r102 == null) goto L18;
        return r102;
    L18:
        return sbb.e.f541294e;
    L9:
        if (r101 != 2) goto L11;
        r102 = this.businessFilter.getValue();
        goto L16
    L11:
        if (r101 == 3) goto L13;
        r102 = this.systemFilter.getValue();
        goto L16
    L13:
        r102 = this.customFilter.getValue();
        goto L16
    L5:
        r101 = b.f238910a[r100.ordinal()];
        goto L7
    }

    public final int getCurrentTabFilterIndex() {
        Tab2 r100 = this.currentTab.getValue();
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        return getIndexByDocumentType(this.systemFilter.getValue());
    L18:
        return getIndexByDocumentType(this.customFilter.getValue());
    L19:
        return getIndexByDocumentType(this.businessFilter.getValue());
    L16:
        return getIndexByDocumentType(this.systemFilter.getValue());
    L5:
        r101 = b.f238910a[r100.ordinal()];
        goto L7
    }

    public final boolean getCurrentTabFilterStatusValue() {
        Tab2 r100 = this.currentTab.getValue();
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != 1) goto L9;
        Boolean r102 = this.systemFilterStatus.getValue();
        if (r102 != null) goto L24;
        return false;
    L24:
        return r102.booleanValue();
    L9:
        if (r101 != 2) goto L11;
        Boolean r103 = this.businessFilterStatus.getValue();
        if (r103 != null) goto L30;
        return false;
    L30:
        return r103.booleanValue();
    L11:
        if (r101 == 3) goto L15;
        Boolean r104 = this.systemFilterStatus.getValue();
        if (r104 != null) goto L26;
        return false;
    L26:
        return r104.booleanValue();
    L15:
        Boolean r105 = this.customFilterStatus.getValue();
        if (r105 != null) goto L28;
        return false;
    L28:
        return r105.booleanValue();
    L5:
        r101 = b.f238910a[r100.ordinal()];
        goto L7
    }

    public final String getCurrentTabTag() {
        Tab2 r100 = this.currentTab.getValue();
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != 2) goto L9;
        return "corporate";
    L9:
        if (r101 == 3) goto L11;
        return CameraParam.TYPE_SYSTEM_CAMERA;
    L11:
        return "custom";
    L5:
        r101 = b.f238910a[r100.ordinal()];
        goto L7
    }

    public final String getSearchFilterType() {
        if (this.fixedFilter == true) goto L7;
        return null;
    L7:
        return String.valueOf(this.initFilterType);
    }

    public final boolean isOnlyNewLarkForm() {
        if (com.bytedance.ee.bear.templates.h.a(this.templateSource) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.larkform.new.enable") == false) goto L7;
        return true;
    }

    public TemplateCenterViewModel() {
        this.currentTab = new TemplateCenterLiveData();
        sbb.e r100 = sbb.e.f541294e;
        this.systemFilter = new TemplateCenterLiveData(r100);
        this.customFilter = new TemplateCenterLiveData(r100);
        this.businessFilter = new TemplateCenterLiveData(r100);
        this.currentTabFilterStatus = new TemplateCenterLiveData();
        this.systemFilterStatus = new TemplateCenterLiveData();
        this.customFilterStatus = new TemplateCenterLiveData();
        this.businessFilterStatus = new TemplateCenterLiveData();
        this.searchContent = new TemplateCenterLiveData();
        this.categoryIndex = new TemplateCenterLiveData();
        this.deleteToken = new TemplateCenterLiveData();
        this.module = "";
        this.enterSource = "";
        this.initFilterType = -1;
        CreateSelectResult.CREATOR.getClass();
        this.createSelectResult = CreateSelectResult.a.b();
        this.spaceId = "";
        this.templateSource = "";
    }

    public static final /* synthetic */ long access$getCATEGORY_ID$cp() {
        return CATEGORY_ID;
    }

    public static final /* synthetic */ int access$getLAST_INDEX$cp() {
        return LAST_INDEX;
    }

    private final boolean forbidFilterModify() {
        return this.fixedFilter;
    }

    public final LiveData<sbb.e> getBusinessFilterLiveData() {
        return this.businessFilter;
    }

    public final TemplateCenterLiveData<Integer> getCategoryIndex() {
        return this.categoryIndex;
    }

    public final boolean getCreateBlank() {
        return this.createBlank;
    }

    public final CreateSelectResult getCreateSelectResult() {
        return this.createSelectResult;
    }

    public final TemplateCenterLiveData<Tab2> getCurrentTab() {
        return this.currentTab;
    }

    public final LiveData<Boolean> getCurrentTabFilterStatus() {
        return this.currentTabFilterStatus;
    }

    public final LiveData<sbb.e> getCustomFilterLiveData() {
        return this.customFilter;
    }

    public final TemplateCenterLiveData<String> getDeleteToken() {
        return this.deleteToken;
    }

    public final String getEnterSource() {
        return this.enterSource;
    }

    public final boolean getFixedFilter() {
        return this.fixedFilter;
    }

    public final int getInitFilterType() {
        return this.initFilterType;
    }

    public final String getModule() {
        return this.module;
    }

    public final TemplateCenterLiveData<String> getSearchContent() {
        return this.searchContent;
    }

    public final TemplateV4 getSelectedTemplate() {
        return this.selectedTemplate;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final LiveData<sbb.e> getSystemFilterLiveData() {
        return this.systemFilter;
    }

    public final String getTemplateSource() {
        return this.templateSource;
    }

    public final boolean isSpaceV2() {
        return this.isSpaceV2;
    }

    public static final /* synthetic */ void access$setCATEGORY_ID$cp(long r100) {
        CATEGORY_ID = r100;
    }

    public static final /* synthetic */ void access$setLAST_INDEX$cp(int r100) {
        LAST_INDEX = r100;
    }

    private final int getIndexByDocumentType(sbb.e r100) {
        if (Intrinsics.areEqual(sbb.e.f541296g, r100) == false) goto L6;
        return 1;
    L6:
        if (Intrinsics.areEqual(sbb.e.f541304o, r100) == false) goto L9;
        return 1;
    L9:
        if (Intrinsics.areEqual(sbb.e.f541297h, r100) == false) goto L12;
        return 2;
    L12:
        if (Intrinsics.areEqual(sbb.e.f541300k, r100) == false) goto L15;
        return 3;
    L15:
        if (Intrinsics.areEqual(sbb.e.f541298i, r100) == false) goto L17;
        return 4;
    L17:
        return 0;
    }

    public final void hideFilter(Tab2 r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (forbidFilterModify() == false) goto L6;
        return;
    L6:
        if (r100 != this.currentTab.getValue()) goto L8;
        this.currentTabFilterStatus.setValue(Boolean.FALSE);
    L8:
        int r101 = b.f238910a[r100.ordinal()];
        if (r101 != 1) goto L11;
        this.systemFilterStatus.setValue(Boolean.FALSE);
        return;
    L11:
        if (r101 != 2) goto L13;
        this.businessFilterStatus.setValue(Boolean.FALSE);
        return;
    L13:
        if (r101 != 3) goto L16;
        this.customFilterStatus.setValue(Boolean.FALSE);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void saveCurrentTabFilter(sbb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (Intrinsics.areEqual(r100, getCurrentTabFilter()) == false) goto L6;
        tt5.a.h(TAG, "saveCurrentTabFilter()...but type not change");
        return;
    L6:
        Tab2 r101 = this.currentTab.getValue();
        if (r101 != null) goto L9;
        int r102 = -1;
    L11:
        if (r102 != 1) goto L13;
        this.systemFilter.setValue(r100);
        return;
    L13:
        if (r102 != 2) goto L15;
        this.businessFilter.setValue(r100);
        return;
    L15:
        if (r102 == 3) goto L17;
        this.systemFilter.setValue(r100);
        return;
    L17:
        this.customFilter.setValue(r100);
        return;
    L9:
        r102 = b.f238910a[r101.ordinal()];
        goto L11
    }

    public final void saveCurrentTabFilterForTopic(sbb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.systemFilter.setValue(r100);
    }

    public final void saveFilter(int r100) {
        sbb.e r101 = sbb.e.d(r100);
        this.systemFilter.setValue(r101);
        this.customFilter.setValue(r101);
        this.businessFilter.setValue(r101);
    }

    public final void setCreateBlank(boolean r100) {
        this.createBlank = r100;
    }

    public final void setCreateSelectResult(CreateSelectResult r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.createSelectResult = r100;
    }

    public final void setCurrentTab(Tab2 r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.currentTab.setValue(r100);
    }

    public final void setEnterSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterSource = r100;
    }

    public final void setFixedFilter(boolean r100) {
        this.fixedFilter = r100;
    }

    public final void setInitFilterType(int r100) {
        this.initFilterType = r100;
    }

    public final void setModule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.module = r100;
    }

    public final void setSelectedTemplate(TemplateV4 r100) {
        this.selectedTemplate = r100;
    }

    public final void setSpaceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceId = r100;
    }

    public final void setSpaceV2(boolean r100) {
        this.isSpaceV2 = r100;
    }

    public final void setTemplateSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateSource = r100;
    }

    public final void showFilter(Tab2 r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (forbidFilterModify() == false) goto L6;
        return;
    L6:
        if (r100 != this.currentTab.getValue()) goto L8;
        this.currentTabFilterStatus.setValue(Boolean.TRUE);
    L8:
        int r101 = b.f238910a[r100.ordinal()];
        if (r101 != 1) goto L11;
        this.systemFilterStatus.setValue(Boolean.TRUE);
        return;
    L11:
        if (r101 != 2) goto L13;
        this.businessFilterStatus.setValue(Boolean.TRUE);
        return;
    L13:
        if (r101 != 3) goto L16;
        this.customFilterStatus.setValue(Boolean.TRUE);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
