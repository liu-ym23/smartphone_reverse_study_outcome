package com.bytedance.ee.bear.document;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.documentinfo.TranslateTargetData;
import com.bytedance.ee.bear.document.titlebar.NavigationTitle;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes16.dex */
public class DocViewModel extends ViewModel implements y3 {
    public static final String ANNOUNCE = "announce";
    public static final String ASSOCIATE_APP_URL = "associate_app_url";
    public static final String ASSOCIATE_URL_META_ID = "associate_url_meta_id";
    public static final String CHAT_ANNOUNCE_APP_ID = "401";
    public static final String CHAT_DRAFT_APP_ID = "403";
    public static final String ENTER_CHAR = "\n";
    public static final String EXTRA_CHAT_ID = "chat_id";
    public static final String EXTRA_PARENT_TOKEN = "parent_token";
    public static final String EXTRA_SPACE_ID = "space_id";
    public static final String KEY_FAST_ADD_TOKEN = "add_token";
    public static final String KEY_TEMPLATE_PREVIEW_LIST = "template_preview_list";
    private final String TAG;
    private String associateAppUrl;
    private String associateUrlMetaId;
    private BearUrl bearUrl;
    private MutableLiveData<Boolean> blockInfoUpdate;
    private String chatId;
    private int containerType;
    private BlockInfo currentRefBlockInfo;
    private ConcurrentHashMap<String, Boolean> deleteCacheMap;
    private final MutableLiveData<Boolean> deleted;
    private String docFeedId;
    private final MutableLiveData<DocMetaInfo> docMetaInfo;
    private final Observer<DocumentInfo> docMetaInfoObserver;
    private LiveData<DocumentInfo> docMetaInfoSource;
    private final MutableLiveData<String> docName;
    private HashMap<String, Integer> docViewStateMap;
    private final nw4.b documentCoreDependency;
    private w05.i documentInfoProvider;
    private String editionId;
    private String editionName;
    private String editionToken;
    private final MutableLiveData<Pair<Boolean, String>> externalInfo;
    private MutableLiveData<Map<String, Object>> extraData;
    private String fastAddToken;
    private boolean hasAutoShownSecretSetting;
    private MutableLiveData<Boolean> isShowingHistory;
    private final b mDocDataListener;
    private final MutableLiveData<String> mDocEncryptId;
    private MutableLiveData<DocShareUserInfo> mDocShareInfo;
    private MutableLiveData<IconInfo> mIconInfo;
    private MutableLiveData<IconInfo> mIconInfoData;
    private final MutableLiveData<NavigationTitle> mTitleInfo;
    protected DocsOpenSource openSource;
    private BearUrl originBearUrl;
    private String originUrl;
    private String parentToken;
    private MutableLiveData<Boolean> permissionUpdate;
    private String previewListStr;
    private Bundle remindBinder;
    private DriveShadowFileEntity shadowFileEntity;
    private String sourceType;
    private String spaceId;
    private boolean syncBlockLinkEnable;
    private String templatePreviewTitle;
    private final MutableLiveData<CharSequence> title;
    private final MutableLiveData<String> token;
    private TranslateTargetData translateTargetData;
    private String url;
    private WikiInfo wikiInfo;

    public class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f218582a;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        public a(Bundle r100) {
            this.f218582a = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            return new DocViewModel(this.f218582a);
        }
    }

    public class b extends nw4.c {
        public b() {
        }
    }

    public DocViewModel() {
        this(null);
    }

    public static /* synthetic */ void Mo(DocViewModel r100, String r101) {
        r100.lambda$setToken$1(r101);
    }

    public static /* synthetic */ void yo(DocViewModel r100, DocumentInfo r101) {
        r100.lambda$new$0(r101);
    }

    public void onAutoShownSecretSetting() {
        this.hasAutoShownSecretSetting = true;
    }

    private String getDocMetaInfoTitle() {
        w05.i r100 = this.documentInfoProvider;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.g() == null) goto L19;
        DocumentInfo r101 = this.documentInfoProvider.g().getValue();
        if (r101 != null) goto L10;
        return "";
    L10:
        if (r101.getDocMetaInfo() == null) goto L20;
        String r102 = r101.getTitle();
        if (TextUtils.isEmpty(r102) == false) goto L16;
        return "";
    L16:
        return r102;
    L20:
        return "";
    L19:
        return "";
    }

    private boolean isHistoryDoc() {
        String r100 = this.originUrl;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.endsWith("#history") == false) goto L7;
        return true;
    }

    private void syncDocMetaInfo() {
        LiveData<DocumentInfo> r100 = this.docMetaInfoSource;
        DocMetaInfo r101 = null;
        if (r100 != null) goto L5;
        DocumentInfo r102 = null;
    L6:
        MutableLiveData<DocMetaInfo> r103 = this.docMetaInfo;
        if (r102 == null) goto L10;
        r101 = r102.getDocMetaInfo();
    L10:
        r103.setValue(r101);
        return;
    L5:
        r102 = r100.getValue();
        goto L6
    }

    public String getCommonTemplatePreviewType() {
        this.documentCoreDependency.a();
        return "";
    }

    public String getDocEncryptId() {
        return this.mDocEncryptId.getValue();
    }

    public String getDocTitle() {
        String r100 = this.docName.getValue();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        CharSequence r101 = this.title.getValue();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        return r101.toString();
    L10:
        return getDocMetaInfoTitle();
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getDocumentType() {
        BearUrl r100 = this.bearUrl;
        if (r100 == null) goto L8;
        String r101 = r100.f222560a;
        if (r101 == null) goto L8;
        return r101;
    L8:
        tt5.a.k(this.TAG, "getDocumentRealTypeName While bear url null!");
        return "";
    }

    public MutableLiveData<IconInfo> getIconInfoData() {
        if (this.mIconInfoData != null) goto L6;
        this.mIconInfoData = new MutableLiveData();
    L6:
        return this.mIconInfoData;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public MutableLiveData<IconInfo> getShowingIconInfo() {
        if (this.mIconInfo != null) goto L6;
        this.mIconInfo = new MutableLiveData();
    L6:
        return this.mIconInfo;
    }

    public String getSourceType() {
        String r100 = this.sourceType;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getToken() {
        return this.token.getValue();
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isAnnounceDoc() {
        return fx4.a.a(this.originUrl);
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isAnnounceTemplatePreview() {
        this.documentCoreDependency.d();
        return false;
    }

    public boolean isBitableRecordShare() {
        return fx4.a.b(this.originBearUrl);
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isCommonTemplatePreview() {
        this.documentCoreDependency.isCommonTemplatePreview();
        return false;
    }

    public boolean isConferenceRecords() {
        Uri r100 = UriProtector.parse(this.originUrl);
        if (getOpenSource() == DocsOpenSource.calendar) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(UriProtector.getQueryParameter(r100, "sourceType"), "conference_records") == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.document.d
    public boolean isEditionDoc() {
        WikiInfo r100 = this.wikiInfo;
        if (r100 == null) goto L5;
        int r101 = r100.getObjType();
    L7:
        if (z05.i.b(r101) == true) goto L9;
    L13:
        return false;
    L9:
        if (TextUtils.isEmpty(this.editionId) == true) goto L13;
        if (getOpenSource() == DocsOpenSource.f216966vc) goto L13;
        return true;
    L5:
        r101 = this.bearUrl.a();
        goto L7
    }

    public boolean isOpenFromLarkFeed() {
        return iu5.b.a(this.originUrl);
    }

    public MutableLiveData<Boolean> isShowingHistory() {
        if (this.isShowingHistory != null) goto L6;
        this.isShowingHistory = new MutableLiveData();
    L6:
        return this.isShowingHistory;
    }

    public boolean isSubscriptDoc() {
        return fx4.a.f(this.originUrl);
    }

    @Override // com.bytedance.ee.bear.document.y3, com.bytedance.ee.bear.document.d
    public boolean isSyncBlock() {
        return TextUtils.equals(this.originBearUrl.f222560a, sbb.e.f541314y.getType());
    }

    public MutableLiveData<DocumentInfo> liveDocumentInfoData() {
        w05.i r100 = this.documentInfoProvider;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.j();
    }

    public MutableLiveData<DocumentInfo> liveOfflineDocumentInfoData() {
        w05.i r100 = this.documentInfoProvider;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.k();
    }

    public void notifyBlockInfoUpdate() {
        this.blockInfoUpdate.postValue(Boolean.TRUE);
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean allowCustomTitle() {
        return !isHistoryDoc();
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean allowCustomTitleMenu() {
        return !isHistoryDoc();
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean canCopy() {
        if (TextUtils.isEmpty(getDocEncryptId()) == true) goto L7;
        return true;
    L7:
        if (getDocumentInfoData() != null) goto L10;
        return false;
    L10:
        int r100 = f35.b.f475390a;
        return f35.b.f(getDocumentInfoData());
    }

    public BenefitStore getBenefitStore() {
        return getDocumentInfoProvider().f().getValue();
    }

    public String getCreatorTenantId() {
        DocumentInfo r100 = getDocumentInfoData();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getCreatorTenantId();
    }

    public DocumentInfo getDocumentInfoData() {
        MutableLiveData<DocumentInfo> r100 = liveDocumentInfoData();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getValue();
    }

    @Override // com.bytedance.ee.bear.document.d
    public int getDocumentTypeValue() {
        return sbb.e.g(getDocumentType());
    }

    public String getDocumentTypeValueString() {
        return String.valueOf(getDocumentTypeValue());
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getOwnerUserId() {
        DocumentInfo r100 = getDocumentInfoData();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getOwnerUid();
    }

    public String getRefToken() {
        BlockInfo r100 = getCurrentRefBlockInfo();
        if (r100 == null) goto L7;
        tt5.a.h(this.TAG, "getRefToken success");
        return r100.getToken();
    L7:
        return getToken();
    }

    @Override // com.bytedance.ee.bear.document.y3
    public /* bridge */ /* synthetic */ LiveData getTitleInfo() {
        return getTitleInfo();
    }

    public boolean isCanEdit() {
        DocumentInfo r100 = getDocumentInfoData();
        if (r100 == null) goto L10;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L9;
        int r101 = f35.b.f475390a;
        return f35.b.c(r100, "EDIT", BizDomain.FileBizDomainCCM).getAllow();
    L9:
        return r100.canEdit();
    L10:
        tt5.a.d(this.TAG, "documentInfo is null!");
        return false;
    }

    @Override // com.bytedance.ee.bear.document.d
    public boolean isOwner() {
        DocumentInfo r100 = getDocumentInfoData();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOwner() == false) goto L7;
        return true;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        tt5.a.h(this.TAG, "onCleared");
        LiveData<DocumentInfo> r100 = this.docMetaInfoSource;
        if (r100 == null) goto L5;
        r100.removeObserver(this.docMetaInfoObserver);
    L5:
        this.documentCoreDependency.f(this.mDocDataListener);
    }

    public String getAssociateAppUrl() {
        return this.associateAppUrl;
    }

    public String getAssociateUrlMetaId() {
        return this.associateUrlMetaId;
    }

    @Override // com.bytedance.ee.bear.document.d
    public BearUrl getBearUrl() {
        return this.bearUrl;
    }

    public MutableLiveData<Boolean> getBlockInfoUpdate() {
        return this.blockInfoUpdate;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public String getChatId() {
        return this.chatId;
    }

    public int getContainerType() {
        return this.containerType;
    }

    public BlockInfo getCurrentRefBlockInfo() {
        return this.currentRefBlockInfo;
    }

    public ConcurrentHashMap<String, Boolean> getDeleteCacheMap() {
        return this.deleteCacheMap;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public LiveData<Boolean> getDeleted() {
        return this.deleted;
    }

    public MutableLiveData<Map<String, Object>> getDocExtra() {
        return this.extraData;
    }

    public String getDocFeedId() {
        return this.docFeedId;
    }

    public LiveData<DocMetaInfo> getDocMetaInfo() {
        return this.docMetaInfo;
    }

    @Override // com.bytedance.ee.bear.document.d
    public LiveData<String> getDocName() {
        return this.docName;
    }

    public w05.i getDocumentInfoProvider() {
        return this.documentInfoProvider;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getEditionId() {
        return this.editionId;
    }

    public String getEditionName() {
        return this.editionName;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getEditionToken() {
        return this.editionToken;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public LiveData<Pair<Boolean, String>> getExternalInfo() {
        return this.externalInfo;
    }

    public String getFastAddToken() {
        return this.fastAddToken;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public DocsOpenSource getOpenSource() {
        return this.openSource;
    }

    @Override // com.bytedance.ee.bear.document.d
    public BearUrl getOriginBearUrl() {
        return this.originBearUrl;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getOriginUrl() {
        return this.originUrl;
    }

    public String getParentToken() {
        return this.parentToken;
    }

    public MutableLiveData<Boolean> getPermissionUpdate() {
        return this.permissionUpdate;
    }

    public String getPreviewListStr() {
        return this.previewListStr;
    }

    public Bundle getRemindBinder() {
        return this.remindBinder;
    }

    public DriveShadowFileEntity getShadowFileEntity() {
        return this.shadowFileEntity;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public LiveData<CharSequence> getTitle() {
        return this.title;
    }

    public TranslateTargetData getTranslateTargetData() {
        return this.translateTargetData;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getUrl() {
        return this.url;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public WikiInfo getWikiInfo() {
        return this.wikiInfo;
    }

    public MutableLiveData<DocShareUserInfo> getmDocShareInfo() {
        return this.mDocShareInfo;
    }

    public boolean hasAutoShownSecretSetting() {
        return this.hasAutoShownSecretSetting;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public LiveData<String> liveDocObjToken() {
        return this.token;
    }

    public String toString() {
        return this.TAG;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public MutableLiveData<NavigationTitle> getTitleInfo() {
        return this.mTitleInfo;
    }

    public DocViewModel(Bundle r100) {
        this.TAG = "DocViewModel#" + Integer.toHexString(hashCode());
        this.token = new MutableLiveData();
        this.permissionUpdate = new MutableLiveData();
        this.openSource = DocsOpenSource.unknown;
        this.docViewStateMap = new HashMap();
        this.title = new MutableLiveData();
        this.mDocShareInfo = new MutableLiveData();
        this.mTitleInfo = new MutableLiveData();
        this.docName = new MutableLiveData();
        this.externalInfo = new MutableLiveData();
        this.extraData = new MutableLiveData();
        b r101 = new b();
        this.mDocDataListener = r101;
        this.deleted = new MutableLiveData();
        this.docMetaInfo = new MutableLiveData();
        this.docMetaInfoObserver = new z1(this);
        this.blockInfoUpdate = new MutableLiveData();
        this.mDocEncryptId = new MutableLiveData();
        this.deleteCacheMap = new ConcurrentHashMap();
        this.syncBlockLinkEnable = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.synced_block.separate_page_mobile");
        nw4.b r102 = (nw4.b) LarkContext.spiByDwarf(nw4.b.class);
        this.documentCoreDependency = r102;
        r102.c(r101);
        readArgs(r100);
        parseOriginUrl(r100);
    }

    public static /* synthetic */ String access$100(DocViewModel r100) {
        return r100.TAG;
    }

    public static /* synthetic */ MutableLiveData access$200(DocViewModel r100) {
        return r100.deleted;
    }

    private void doSetToken(String r100) {
        d25.d.f466517d = r100;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl " + du5.b.g(r100));
        WikiInfo r101 = this.wikiInfo;
        if (r101 != null) goto L5;
    L7:
        d25.d.k(r100);
    L9:
        if (TextUtils.equals(r100, this.token.getValue()) == true) goto L12;
        this.token.setValue(r100);
        return;
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r101.getObjToken()) == true) goto L7;
        d25.d.k(this.wikiInfo.getObjToken());
        goto L9
    }

    private void initTraceId(Bundle r100) {
        Bundle r101 = r100.getBundle("doc_page_config");
        if (r101 != null) goto L6;
        tt5.a.h(this.TAG, "initTraceId failed due to has no page config");
        return;
    L6:
        String r102 = r101.getString(BindCardPayConfirmConstants.Key.TRACE_ID);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        tt5.a.h(this.TAG, "initTraceId failed due to has no traceId");
        return;
    L10:
        setExtraData("OPEN_FILE_TRACE_ID", r102);
    }

    private /* synthetic */ void lambda$new$0(DocumentInfo r100) {
        MutableLiveData<DocMetaInfo> r101 = this.docMetaInfo;
        if (r100 != null) goto L5;
        DocMetaInfo r102 = null;
    L6:
        r101.setValue(r102);
        return;
    L5:
        r102 = r100.getDocMetaInfo();
        goto L6
    }

    private /* synthetic */ void lambda$setToken$1(String r100) {
        doSetToken(r100);
    }

    public static ViewModelProvider.Factory newFactory(Bundle r100) {
        return new a(r100);
    }

    private static String parseDocName(Bundle r100) {
        return r100.getString("node_name");
    }

    private void readArgs(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BearUrl r101 = (BearUrl) r100.getParcelable("bear_url");
        if (r101 == null) goto L7;
        setBearUrl(r101);
    L8:
        this.docName.setValue(parseDocName(r100));
        this.parentToken = r100.getString(EXTRA_PARENT_TOKEN);
        this.docFeedId = r100.getString("doc_feed_id");
        this.sourceType = r100.getString("source_type");
        this.remindBinder = r100.getBundle("remind_binder");
        this.spaceId = r100.getString(EXTRA_SPACE_ID);
        this.associateAppUrl = r100.getString(ASSOCIATE_APP_URL);
        this.associateUrlMetaId = r100.getString(ASSOCIATE_URL_META_ID);
        this.fastAddToken = r100.getString(KEY_FAST_ADD_TOKEN);
        String r102 = r100.getString("chat_id");
        this.chatId = r102;
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (r101 == null) goto L13;
        r101.f222577r = CHAT_DRAFT_APP_ID;
    L13:
        BearUrl r103 = this.originBearUrl;
        if (r103 == null) goto L17;
        r103.f222577r = CHAT_DRAFT_APP_ID;
    L17:
        if (isAnnounceDoc() == true) goto L19;
    L26:
        WikiInfo r104 = (WikiInfo) r100.getSerializable("wiki_info");
        this.wikiInfo = r104;
        if (r104 == null) goto L33;
        BearUrl r105 = this.originBearUrl;
        if (r105 == null) goto L31;
        Map<String, String> r106 = r105.f222563d;
    L32:
        setUrl(s45.p.a().Le(this.wikiInfo.getObjTypeString(), this.wikiInfo.getObjToken(), r106));
        goto L33
    L31:
        r106 = null;
    L33:
        Map r107 = (Map) r100.getSerializable("extra_data_map");
        if (r107 == null) goto L36;
        this.previewListStr = (String) r107.get(KEY_TEMPLATE_PREVIEW_LIST);
    L36:
        this.shadowFileEntity = (DriveShadowFileEntity) r100.getSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA);
        initTraceId(r100);
        return;
    L19:
        if (isDocumentType(sbb.e.f541304o) == false) goto L26;
        if (r101 == null) goto L23;
        r101.f222577r = "401";
    L23:
        BearUrl r108 = this.originBearUrl;
        if (r108 == null) goto L26;
        r108.f222577r = "401";
        goto L26
    L7:
        setUrl(r100.getString("url"));
        goto L8
    }

    private void setBearUrl(BearUrl r100) {
        String r101 = s45.p.a().va(r100.f222564e);
        r100.f222564e = r101;
        this.url = r101;
        this.bearUrl = r100;
        BearUrl r102 = s45.p.a().Z(this.url);
        if (TextUtils.equals(r102.f222560a, sbb.e.f541314y.getType()) == false) goto L6;
        this.originUrl = r102.f222564e;
        this.originBearUrl = r102;
        r102.f222577r = r100.f222577r;
    L8:
        setToken(r100.f222561b);
        return;
    L6:
        if (this.originUrl != null) goto L8;
        this.originUrl = r100.f222564e;
        this.originBearUrl = r100;
        goto L8
    }

    public Integer getDocViewState(String r100) {
        return this.docViewStateMap.get(r100);
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isDocumentType(sbb.e r100) {
        return r100.getType().equals(getDocumentType());
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isType(sbb.e r100) {
        return r100.getType().equals(this.originBearUrl.f222560a);
    }

    public void parseOriginUrl(Bundle r100) {
    L27:
        tt5.a.d(this.TAG, "illegal url to judge !");
        return;
    L4:
        if (TextUtils.isEmpty(this.originUrl) == false) goto L6;
        return;
    L6:
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(this.originUrl), "from");     // Catch: Exception -> L27
        if ((!TextUtils.isEmpty(com.bytedance.ee.bear.doc.follow.impl.t.a(r100))) == false) goto L9;
        this.openSource = DocsOpenSource.f216966vc;     // Catch: Exception -> L27
    L25:
        tt5.a.h(this.TAG, "openSource:" + this.openSource);     // Catch: Exception -> L27
        return;
    L9:
        DocsOpenSource r102 = DocsOpenSource.calendar;     // Catch: Exception -> L27
        if (r102.name().equals(r101) == false) goto L12;
        this.openSource = r102;     // Catch: Exception -> L27
        goto L25
    L12:
        DocsOpenSource r103 = DocsOpenSource.docs_feed;     // Catch: Exception -> L27
        if (r103.name().equals(r101) == false) goto L15;
        this.openSource = r103;     // Catch: Exception -> L27
        goto L25
    L15:
        DocsOpenSource r104 = DocsOpenSource.template_preview;     // Catch: Exception -> L27
        if (r104.name().equals(r101) == false) goto L18;
        this.openSource = r104;     // Catch: Exception -> L27
        goto L25
    L18:
        DocsOpenSource r105 = DocsOpenSource.chat_tab;     // Catch: Exception -> L27
        if (r105.name().equals(r101) == false) goto L21;
        this.openSource = r105;     // Catch: Exception -> L27
        goto L25
    L21:
        DocsOpenSource r106 = DocsOpenSource.base_instruction_docx;     // Catch: Exception -> L27
        if (TextUtils.equals(r106.name(), r101) == false) goto L24;
        this.openSource = r106;     // Catch: Exception -> L27
        goto L25
    L24:
        this.documentCoreDependency.g();     // Catch: Exception -> L27
        this.openSource = DocsOpenSource.unknown;     // Catch: Exception -> L27
        goto L25
    }

    public void requestDocumentInfo(String r100) {
        requestDocumentInfo(r100, false);
    }

    public void setAssociateAppUrl(String r100) {
        this.associateAppUrl = r100;
    }

    public void setContainerType(int r100) {
        this.containerType = r100;
    }

    public void setCurrentRefBlockInfo(BlockInfo r100) {
        this.currentRefBlockInfo = r100;
        tt5.a.h(this.TAG, "setCurrentRefBlockInfo info=" + r100);
    }

    public void setDocEncryptId(String r100) {
        if (objEquals(this.mDocEncryptId.getValue(), r100) == true) goto L6;
        this.mDocEncryptId.setValue(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void setDocName(String r100) {
        if (TextUtils.equals(this.docName.getValue(), r100) == true) goto L7;
        if (r100 == null) goto L8;
        this.docName.setValue(r100);
        return;
    L8:
        return;
    }

    public void setDocumentInfoProvider(w05.i r100) {
        LiveData<DocumentInfo> r101 = this.docMetaInfoSource;
        if (r101 == null) goto L5;
        r101.removeObserver(this.docMetaInfoObserver);
        this.docMetaInfoSource = null;
    L5:
        this.documentInfoProvider = r100;
        MutableLiveData<DocumentInfo> r102 = r100.j();
        this.docMetaInfoSource = r102;
        if (r102 == null) goto L8;
        syncDocMetaInfo();
        this.docMetaInfoSource.observeForever(this.docMetaInfoObserver);
        return;
    L8:
        this.docMetaInfo.setValue(null);
    }

    public void setEditionId(String r100) {
        this.editionId = r100;
    }

    public void setEditionName(String r100) {
        this.editionName = r100;
    }

    public void setEditionToken(String r100) {
        this.editionToken = r100;
    }

    public void setPermissionUpdate(Boolean r100) {
        this.permissionUpdate.postValue(r100);
    }

    public void setShadowFileEntity(DriveShadowFileEntity r100) {
        this.shadowFileEntity = r100;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void setTitle(CharSequence r100) {
        if (isCommonTemplatePreview() == false) goto L9;
        if (isDocumentType(sbb.e.f541298i) == false) goto L9;
        this.title.setValue("");
        return;
    L9:
        if (TextUtils.equals(this.title.getValue(), r100) == true) goto L12;
        this.title.setValue(r100);
        return;
    }

    public void setTitleInfo(NavigationTitle r100) {
        if (Objects.equals(r100, this.mTitleInfo.getValue()) == true) goto L6;
        this.mTitleInfo.setValue(r100);
        return;
    }

    public void setToken(final String r100) {
        com.bytedance.ee.util.ui.j.f(new y1(this, r100));
    }

    public void setTranslateTargetData(TranslateTargetData r100) {
        this.translateTargetData = r100;
    }

    public void setUrl(String r100) {
        String r101 = this.TAG;
        StringBuilder r102 = new StringBuilder("setUrl:");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        Object r103 = "EMPTY";
    L6:
        r102.append(r103);
        tt5.a.h(r101, r102.toString());
        this.url = s45.p.a().v8(r100);
        BearUrl r104 = s45.p.a().Z(this.url);
        this.bearUrl = r104;
        if (this.originUrl != null) goto L9;
        this.originUrl = r100;
        this.originBearUrl = r104;
    L9:
        setToken(r104.f222561b);
        return;
    L5:
        r103 = Integer.valueOf(r100.hashCode());
        goto L6
    }

    public void updateDocumentInfoData(DocumentInfo r100) {
        MutableLiveData<DocumentInfo> r101 = liveDocumentInfoData();
        if (r101 == null) goto L5;
        r101.setValue(r100);
        return;
    L5:
        MutableLiveData<DocMetaInfo> r102 = this.docMetaInfo;
        if (r100 != null) goto L8;
        DocMetaInfo r103 = null;
    L9:
        r102.setValue(r103);
        return;
    L8:
        r103 = r100.getDocMetaInfo();
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void updateTitle(NavigationTitle r100) {
        if (r100 == null) goto L19;
        this.documentCoreDependency.d();
        if (allowCustomTitle() == false) goto L7;
        setTitleInfo(r100);
        setTitle(r100.getTitle());
        getShowingIconInfo().setValue(r100.getIcon_info());
    L7:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L9;
        String r101 = r100.getDocName();
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (TextUtils.equals("\n", r101) == true) goto L16;
        setDocName(r101);
    L16:
        if (isAnnounceDoc() == true) goto L21;
        setExternalUser(r100.getNeedDisplayTag(), r100.getTagValue());
        return;
    L21:
        return;
    L9:
        r101 = r100.getTitle();
        goto L11
    L19:
        tt5.a.k(this.TAG, "NavigationTitle is null or isAnnounceTemplatePreview");
    }

    public void updateUrlFragment(String r100) {
        String r101 = updateUrlWithFragment(this.url, r100);
        tt5.a.h(this.TAG, "updateUrlFragment, current: " + du5.b.h(this.url) + ", new: " + du5.b.h(r101));
        this.url = r101;
        this.originUrl = r101;
        BearUrl r102 = this.bearUrl;
        r102.f222564e = r101;
        r102.f222575p = r100;
        BearUrl r103 = this.originBearUrl;
        r103.f222564e = r101;
        r103.f222575p = r100;
    }

    public void updateUrlQueryParams(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L14;
        this.url = av5.c.b(this.url, r100, true);
        this.originUrl = av5.c.b(this.originUrl, r100, true);
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, String> r102 = r101.next();
        BearUrl r103 = this.originBearUrl;
        String r104 = r102.getKey();
        String r105 = r102.getValue();
        r103.f222563d.put(r104, r105);
        BearUrl r106 = this.bearUrl;
        String r107 = r102.getKey();
        String r108 = r102.getValue();
        r106.f222563d.put(r107, r108);
        goto L8
    L10:
        BearUrl r109 = this.originBearUrl;
        r109.f222564e = this.originUrl;
        BearUrl r110 = this.bearUrl;
        r110.f222564e = this.url;
        return;
    }

    public DocViewModel(Object r100) {
        this.TAG = "DocViewModel#" + Integer.toHexString(hashCode());
        this.token = new MutableLiveData();
        this.permissionUpdate = new MutableLiveData();
        this.openSource = DocsOpenSource.unknown;
        this.docViewStateMap = new HashMap();
        this.title = new MutableLiveData();
        this.mDocShareInfo = new MutableLiveData();
        this.mTitleInfo = new MutableLiveData();
        this.docName = new MutableLiveData();
        this.externalInfo = new MutableLiveData();
        this.extraData = new MutableLiveData();
        this.mDocDataListener = new b();
        this.deleted = new MutableLiveData();
        this.docMetaInfo = new MutableLiveData();
        this.docMetaInfoObserver = new z1(this);
        this.blockInfoUpdate = new MutableLiveData();
        this.mDocEncryptId = new MutableLiveData();
        this.deleteCacheMap = new ConcurrentHashMap();
        this.syncBlockLinkEnable = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.synced_block.separate_page_mobile");
        this.documentCoreDependency = (nw4.b) LarkContext.spiByDwarf(nw4.b.class);
    }

    private static boolean objEquals(Object r100, Object r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r100.equals(r101);
    }

    private void setExternalUser(Boolean r100, String r101) {
        Pair<Boolean, String> r102 = new Pair(r100, r101);
        if (objEquals(this.externalInfo.getValue(), r102) == true) goto L6;
        this.externalInfo.setValue(r102);
        return;
    }

    private static String updateUrlWithFragment(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        int r102 = r100.indexOf(58);
        if (r102 >= 0) goto L9;
        r102 = 0;
    L9:
        int r103 = r100.indexOf(35, r102);
        if (r103 < 0) goto L15;
        if (r103 >= r100.length()) goto L15;
        r100 = r100.substring(0, r103);
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return r100;
    L17:
        return r100 + '#' + r101;
    }

    public PermissionResponse getPermissionResponseWithUserPermission(BizDomain r100, String r101) {
        DocumentInfo r102 = getDocumentInfoData();
        BaseEntity r103 = new BaseEntity(getToken(), sbb.e.d(getDocumentTypeValue()), r100, getCreatorTenantId());
        if (getDocumentInfoData() == null) goto L8;
        if (getDocumentInfoData().getDocPermission() == null) goto L8;
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r103, r101), new UserPermissionEntity(r102.getDocPermission().f234419a, null));
    L8:
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r103, r101), null);
    }

    public void requestDocumentInfo(String r110, boolean r111) {
        String r100 = getToken();
        if (isSyncBlock() == false) goto L5;
        r100 = this.originBearUrl.f222561b;
    L5:
        String r101 = r100;
        w05.i r102 = this.documentInfoProvider;
        String r103 = this.originUrl;
        String r104 = this.spaceId;
        if (this.openSource != DocsOpenSource.f216966vc) goto L8;
        boolean r105 = true;
    L9:
        r102.d(r110, r103, r104, r101, r105, isType(sbb.e.f541303n), r111);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public void setExtraData(String r100, Object r101) {
        Map<String, Object> r102 = this.extraData.getValue();
        if (r102 != null) goto L5;
        r102 = new HashMap();
    L5:
        r102.put(r100, r101);
        this.extraData.setValue(r102);
    }

    public void setNewCreateUrl(String r100, String r101) {
        String r102 = this.TAG;
        StringBuilder r103 = new StringBuilder("setNewCreateUrl:");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        Object r104 = "EMPTY";
    L6:
        r103.append(r104);
        tt5.a.h(r102, r103.toString());
        t45.c r105 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        String r106 = r105.v8(r100);
        this.url = r106;
        this.bearUrl = r105.Z(r106);
        String r107 = r105.v8(r101);
        this.originUrl = r107;
        this.originBearUrl = r105.Z(r107);
        setToken(this.bearUrl.f222561b);
        return;
    L5:
        r104 = Integer.valueOf(r101.hashCode());
        goto L6
    }

    public void updateDocViewStateMap(String r100, Integer r101) {
        this.docViewStateMap.put(r100, r101);
    }
}
