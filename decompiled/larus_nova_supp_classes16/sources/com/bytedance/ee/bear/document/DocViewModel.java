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
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ Bundle a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public a(Bundle r1) {
            this.a = r1;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            return new DocViewModel(this.a);
        }
    }

    public class b extends nw4.c {
        public b() {
        }
    }

    public DocViewModel() {
        this(null);
    }

    public static /* synthetic */ void Mo(DocViewModel r0, String r1) {
        r0.lambda$setToken$1(r1);
    }

    public static /* synthetic */ void yo(DocViewModel r0, DocumentInfo r1) {
        r0.lambda$new$0(r1);
    }

    public void onAutoShownSecretSetting() {
        this.hasAutoShownSecretSetting = true;
    }

    private String getDocMetaInfoTitle() {
        w05.i r0 = this.documentInfoProvider;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.g() == null) goto L19;
        DocumentInfo r1 = (DocumentInfo) this.documentInfoProvider.g().getValue();
        if (r1 != null) goto L10;
        return "";
    L10:
        if (r1.getDocMetaInfo() == null) goto L20;
        String r2 = r1.getTitle();
        if (TextUtils.isEmpty(r2) == false) goto L16;
        return "";
    L16:
        return r2;
    L20:
        return "";
    L19:
        return "";
    }

    private boolean isHistoryDoc() {
        String r0 = this.originUrl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.endsWith("#history") == false) goto L7;
        return true;
    }

    private void syncDocMetaInfo() {
        LiveData<DocumentInfo> r0 = this.docMetaInfoSource;
        DocMetaInfo r1 = null;
        if (r0 != null) goto L5;
        DocumentInfo r2 = null;
    L6:
        MutableLiveData<DocMetaInfo> r3 = this.docMetaInfo;
        if (r2 == null) goto L10;
        r1 = r2.getDocMetaInfo();
    L10:
        r3.setValue(r1);
        return;
    L5:
        r2 = (DocumentInfo) r0.getValue();
        goto L6
    }

    public String getCommonTemplatePreviewType() {
        this.documentCoreDependency.a();
        return "";
    }

    public String getDocEncryptId() {
        return (String) this.mDocEncryptId.getValue();
    }

    public String getDocTitle() {
        String r0 = (String) this.docName.getValue();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        CharSequence r1 = (CharSequence) this.title.getValue();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return r1.toString();
    L10:
        return getDocMetaInfoTitle();
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getDocumentType() {
        BearUrl r0 = this.bearUrl;
        if (r0 == null) goto L8;
        String r1 = r0.a;
        if (r1 == null) goto L8;
        return r1;
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
        String r0 = this.sourceType;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.d
    public String getToken() {
        return (String) this.token.getValue();
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
        Uri r0 = UriProtector.parse(this.originUrl);
        if (getOpenSource() == DocsOpenSource.calendar) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(UriProtector.getQueryParameter(r0, "sourceType"), "conference_records") == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.document.d
    public boolean isEditionDoc() {
        WikiInfo r0 = this.wikiInfo;
        if (r0 == null) goto L5;
        int r1 = r0.getObjType();
    L7:
        if (z05.i.b(r1) == true) goto L9;
    L13:
        return false;
    L9:
        if (TextUtils.isEmpty(this.editionId) == true) goto L13;
        if (getOpenSource() == DocsOpenSource.vc) goto L13;
        return true;
    L5:
        r1 = this.bearUrl.a();
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
        return TextUtils.equals(this.originBearUrl.a, sbb.e.y.getType());
    }

    public MutableLiveData<DocumentInfo> liveDocumentInfoData() {
        w05.i r0 = this.documentInfoProvider;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.j();
    }

    public MutableLiveData<DocumentInfo> liveOfflineDocumentInfoData() {
        w05.i r0 = this.documentInfoProvider;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.k();
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
        int r0 = f35.b.a;
        return f35.b.f(getDocumentInfoData());
    }

    public BenefitStore getBenefitStore() {
        return (BenefitStore) getDocumentInfoProvider().f().getValue();
    }

    public String getCreatorTenantId() {
        DocumentInfo r0 = getDocumentInfoData();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getCreatorTenantId();
    }

    public DocumentInfo getDocumentInfoData() {
        MutableLiveData<DocumentInfo> r0 = liveDocumentInfoData();
        if (r0 != null) goto L6;
        return null;
    L6:
        return (DocumentInfo) r0.getValue();
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
        DocumentInfo r0 = getDocumentInfoData();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getOwnerUid();
    }

    public String getRefToken() {
        BlockInfo r0 = getCurrentRefBlockInfo();
        if (r0 == null) goto L7;
        tt5.a.h(this.TAG, "getRefToken success");
        return r0.getToken();
    L7:
        return getToken();
    }

    @Override // com.bytedance.ee.bear.document.y3
    public /* bridge */ /* synthetic */ LiveData getTitleInfo() {
        return m166getTitleInfo();
    }

    public boolean isCanEdit() {
        DocumentInfo r0 = getDocumentInfoData();
        if (r0 == null) goto L10;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L9;
        int r1 = f35.b.a;
        return f35.b.c(r0, "EDIT", BizDomain.FileBizDomainCCM).getAllow();
    L9:
        return r0.canEdit();
    L10:
        tt5.a.d(this.TAG, "documentInfo is null!");
        return false;
    }

    @Override // com.bytedance.ee.bear.document.d
    public boolean isOwner() {
        DocumentInfo r0 = getDocumentInfoData();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOwner() == false) goto L7;
        return true;
    }

    public void onCleared() {
        super.onCleared();
        tt5.a.h(this.TAG, "onCleared");
        LiveData<DocumentInfo> r0 = this.docMetaInfoSource;
        if (r0 == null) goto L5;
        r0.removeObserver(this.docMetaInfoObserver);
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

    /* JADX INFO: renamed from: getTitleInfo, reason: collision with other method in class */
    public MutableLiveData<NavigationTitle> m166getTitleInfo() {
        return this.mTitleInfo;
    }

    public DocViewModel(Bundle r4) {
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
        b r0 = new b();
        this.mDocDataListener = r0;
        this.deleted = new MutableLiveData();
        this.docMetaInfo = new MutableLiveData();
        this.docMetaInfoObserver = new z1(this);
        this.blockInfoUpdate = new MutableLiveData();
        this.mDocEncryptId = new MutableLiveData();
        this.deleteCacheMap = new ConcurrentHashMap();
        this.syncBlockLinkEnable = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.synced_block.separate_page_mobile");
        nw4.b r1 = (nw4.b) LarkContext.spiByDwarf(nw4.b.class);
        this.documentCoreDependency = r1;
        r1.c(r0);
        readArgs(r4);
        parseOriginUrl(r4);
    }

    public static /* synthetic */ String access$100(DocViewModel r0) {
        return r0.TAG;
    }

    public static /* synthetic */ MutableLiveData access$200(DocViewModel r0) {
        return r0.deleted;
    }

    private void doSetToken(String r3) {
        d25.d.d = r3;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl " + du5.b.g(r3));
        WikiInfo r0 = this.wikiInfo;
        if (r0 != null) goto L5;
    L7:
        d25.d.k(r3);
    L9:
        if (TextUtils.equals(r3, (CharSequence) this.token.getValue()) == true) goto L12;
        this.token.setValue(r3);
        return;
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r0.getObjToken()) == true) goto L7;
        d25.d.k(this.wikiInfo.getObjToken());
        goto L9
    }

    private void initTraceId(Bundle r2) {
        Bundle r3 = r2.getBundle("doc_page_config");
        if (r3 != null) goto L6;
        tt5.a.h(this.TAG, "initTraceId failed due to has no page config");
        return;
    L6:
        String r4 = r3.getString("trace_id");
        if (TextUtils.isEmpty(r4) == false) goto L10;
        tt5.a.h(this.TAG, "initTraceId failed due to has no traceId");
        return;
    L10:
        setExtraData("OPEN_FILE_TRACE_ID", r4);
    }

    private /* synthetic */ void lambda$new$0(DocumentInfo r2) {
        MutableLiveData<DocMetaInfo> r0 = this.docMetaInfo;
        if (r2 != null) goto L5;
        DocMetaInfo r3 = null;
    L6:
        r0.setValue(r3);
        return;
    L5:
        r3 = r2.getDocMetaInfo();
        goto L6
    }

    private /* synthetic */ void lambda$setToken$1(String r1) {
        doSetToken(r1);
    }

    public static ViewModelProvider.Factory newFactory(Bundle r1) {
        return new a(r1);
    }

    private static String parseDocName(Bundle r1) {
        return r1.getString("node_name");
    }

    private void readArgs(Bundle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        BearUrl r0 = (BearUrl) r5.getParcelable("bear_url");
        if (r0 == null) goto L7;
        setBearUrl(r0);
    L8:
        this.docName.setValue(parseDocName(r5));
        this.parentToken = r5.getString(EXTRA_PARENT_TOKEN);
        this.docFeedId = r5.getString("doc_feed_id");
        this.sourceType = r5.getString("source_type");
        this.remindBinder = r5.getBundle("remind_binder");
        this.spaceId = r5.getString(EXTRA_SPACE_ID);
        this.associateAppUrl = r5.getString(ASSOCIATE_APP_URL);
        this.associateUrlMetaId = r5.getString(ASSOCIATE_URL_META_ID);
        this.fastAddToken = r5.getString(KEY_FAST_ADD_TOKEN);
        String r1 = r5.getString("chat_id");
        this.chatId = r1;
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (r0 == null) goto L13;
        r0.r = CHAT_DRAFT_APP_ID;
    L13:
        BearUrl r2 = this.originBearUrl;
        if (r2 == null) goto L17;
        r2.r = CHAT_DRAFT_APP_ID;
    L17:
        if (isAnnounceDoc() == true) goto L19;
    L26:
        WikiInfo r3 = (WikiInfo) r5.getSerializable("wiki_info");
        this.wikiInfo = r3;
        if (r3 == null) goto L33;
        BearUrl r4 = this.originBearUrl;
        if (r4 == null) goto L31;
        Map<String, String> r6 = r4.d;
    L32:
        setUrl(s45.p.a().Le(this.wikiInfo.getObjTypeString(), this.wikiInfo.getObjToken(), r6));
        goto L33
    L31:
        r6 = null;
    L33:
        Map r7 = (Map) r5.getSerializable("extra_data_map");
        if (r7 == null) goto L36;
        this.previewListStr = (String) r7.get(KEY_TEMPLATE_PREVIEW_LIST);
    L36:
        this.shadowFileEntity = (DriveShadowFileEntity) r5.getSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA);
        initTraceId(r5);
        return;
    L19:
        if (isDocumentType(sbb.e.o) == false) goto L26;
        if (r0 == null) goto L23;
        r0.r = CHAT_ANNOUNCE_APP_ID;
    L23:
        BearUrl r8 = this.originBearUrl;
        if (r8 == null) goto L26;
        r8.r = CHAT_ANNOUNCE_APP_ID;
        goto L26
    L7:
        setUrl(r5.getString("url"));
        goto L8
    }

    private void setBearUrl(BearUrl r4) {
        String r0 = s45.p.a().va(r4.e);
        r4.e = r0;
        this.url = r0;
        this.bearUrl = r4;
        BearUrl r1 = s45.p.a().Z(this.url);
        if (TextUtils.equals(r1.a, sbb.e.y.getType()) == false) goto L6;
        this.originUrl = r1.e;
        this.originBearUrl = r1;
        r1.r = r4.r;
    L8:
        setToken(r4.b);
        return;
    L6:
        if (this.originUrl != null) goto L8;
        this.originUrl = r4.e;
        this.originBearUrl = r4;
        goto L8
    }

    public Integer getDocViewState(String r2) {
        return this.docViewStateMap.get(r2);
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isDocumentType(sbb.e r2) {
        return r2.getType().equals(getDocumentType());
    }

    @Override // com.bytedance.ee.bear.document.y3
    public boolean isType(sbb.e r2) {
        return r2.getType().equals(this.originBearUrl.a);
    }

    public void parseOriginUrl(Bundle r4) {
    L27:
        tt5.a.d(this.TAG, "illegal url to judge !");
        return;
    L4:
        if (TextUtils.isEmpty(this.originUrl) == false) goto L6;
        return;
    L6:
        String r1 = UriProtector.getQueryParameter(UriProtector.parse(this.originUrl), DocRedirectToDocxPlugin.FROM);     // Catch: Exception -> L27
        if ((!TextUtils.isEmpty(com.bytedance.ee.bear.doc.follow.impl.t.a(r4))) == false) goto L9;
        this.openSource = DocsOpenSource.vc;     // Catch: Exception -> L27
    L25:
        tt5.a.h(this.TAG, "openSource:" + this.openSource);     // Catch: Exception -> L27
        return;
    L9:
        DocsOpenSource r5 = DocsOpenSource.calendar;     // Catch: Exception -> L27
        if (r5.name().equals(r1) == false) goto L12;
        this.openSource = r5;     // Catch: Exception -> L27
        goto L25
    L12:
        DocsOpenSource r6 = DocsOpenSource.docs_feed;     // Catch: Exception -> L27
        if (r6.name().equals(r1) == false) goto L15;
        this.openSource = r6;     // Catch: Exception -> L27
        goto L25
    L15:
        DocsOpenSource r7 = DocsOpenSource.template_preview;     // Catch: Exception -> L27
        if (r7.name().equals(r1) == false) goto L18;
        this.openSource = r7;     // Catch: Exception -> L27
        goto L25
    L18:
        DocsOpenSource r8 = DocsOpenSource.chat_tab;     // Catch: Exception -> L27
        if (r8.name().equals(r1) == false) goto L21;
        this.openSource = r8;     // Catch: Exception -> L27
        goto L25
    L21:
        DocsOpenSource r9 = DocsOpenSource.base_instruction_docx;     // Catch: Exception -> L27
        if (TextUtils.equals(r9.name(), r1) == false) goto L24;
        this.openSource = r9;     // Catch: Exception -> L27
        goto L25
    L24:
        this.documentCoreDependency.g();     // Catch: Exception -> L27
        this.openSource = DocsOpenSource.unknown;     // Catch: Exception -> L27
        goto L25
    }

    public void requestDocumentInfo(String r2) {
        requestDocumentInfo(r2, false);
    }

    public void setAssociateAppUrl(String r1) {
        this.associateAppUrl = r1;
    }

    public void setContainerType(int r1) {
        this.containerType = r1;
    }

    public void setCurrentRefBlockInfo(BlockInfo r4) {
        this.currentRefBlockInfo = r4;
        tt5.a.h(this.TAG, "setCurrentRefBlockInfo info=" + r4);
    }

    public void setDocEncryptId(String r2) {
        if (objEquals(this.mDocEncryptId.getValue(), r2) == true) goto L6;
        this.mDocEncryptId.setValue(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void setDocName(String r2) {
        if (TextUtils.equals((CharSequence) this.docName.getValue(), r2) == true) goto L7;
        if (r2 == null) goto L8;
        this.docName.setValue(r2);
        return;
    L8:
        return;
    }

    public void setDocumentInfoProvider(w05.i r4) {
        LiveData<DocumentInfo> r0 = this.docMetaInfoSource;
        if (r0 == null) goto L5;
        r0.removeObserver(this.docMetaInfoObserver);
        this.docMetaInfoSource = null;
    L5:
        this.documentInfoProvider = r4;
        MutableLiveData<DocumentInfo> r5 = r4.j();
        this.docMetaInfoSource = r5;
        if (r5 == null) goto L8;
        syncDocMetaInfo();
        this.docMetaInfoSource.observeForever(this.docMetaInfoObserver);
        return;
    L8:
        this.docMetaInfo.setValue(null);
    }

    public void setEditionId(String r1) {
        this.editionId = r1;
    }

    public void setEditionName(String r1) {
        this.editionName = r1;
    }

    public void setEditionToken(String r1) {
        this.editionToken = r1;
    }

    public void setPermissionUpdate(Boolean r2) {
        this.permissionUpdate.postValue(r2);
    }

    public void setShadowFileEntity(DriveShadowFileEntity r1) {
        this.shadowFileEntity = r1;
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void setTitle(CharSequence r2) {
        if (isCommonTemplatePreview() == false) goto L9;
        if (isDocumentType(sbb.e.i) == false) goto L9;
        this.title.setValue("");
        return;
    L9:
        if (TextUtils.equals((CharSequence) this.title.getValue(), r2) == true) goto L12;
        this.title.setValue(r2);
        return;
    }

    public void setTitleInfo(NavigationTitle r2) {
        if (Objects.equals(r2, this.mTitleInfo.getValue()) == true) goto L6;
        this.mTitleInfo.setValue(r2);
        return;
    }

    public void setToken(final String r2) {
        com.bytedance.ee.util.ui.j.f(new y1(this, r2));
    }

    public void setTranslateTargetData(TranslateTargetData r1) {
        this.translateTargetData = r1;
    }

    public void setUrl(String r4) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("setUrl:");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        Object r2 = "EMPTY";
    L6:
        r1.append(r2);
        tt5.a.h(r0, r1.toString());
        this.url = s45.p.a().v8(r4);
        BearUrl r3 = s45.p.a().Z(this.url);
        this.bearUrl = r3;
        if (this.originUrl != null) goto L9;
        this.originUrl = r4;
        this.originBearUrl = r3;
    L9:
        setToken(r3.b);
        return;
    L5:
        r2 = Integer.valueOf(r4.hashCode());
        goto L6
    }

    public void updateDocumentInfoData(DocumentInfo r2) {
        MutableLiveData<DocumentInfo> r0 = liveDocumentInfoData();
        if (r0 == null) goto L5;
        r0.setValue(r2);
        return;
    L5:
        MutableLiveData<DocMetaInfo> r1 = this.docMetaInfo;
        if (r2 != null) goto L8;
        DocMetaInfo r3 = null;
    L9:
        r1.setValue(r3);
        return;
    L8:
        r3 = r2.getDocMetaInfo();
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.y3
    public void updateTitle(NavigationTitle r3) {
        if (r3 == null) goto L19;
        this.documentCoreDependency.d();
        if (allowCustomTitle() == false) goto L7;
        setTitleInfo(r3);
        setTitle(r3.getTitle());
        getShowingIconInfo().setValue(r3.getIcon_info());
    L7:
        if (TextUtils.isEmpty(r3.getTitle()) == false) goto L9;
        String r0 = r3.getDocName();
    L11:
        if (TextUtils.isEmpty(r0) == true) goto L16;
        if (TextUtils.equals(ENTER_CHAR, r0) == true) goto L16;
        setDocName(r0);
    L16:
        if (isAnnounceDoc() == true) goto L21;
        setExternalUser(r3.getNeedDisplayTag(), r3.getTagValue());
        return;
    L21:
        return;
    L9:
        r0 = r3.getTitle();
        goto L11
    L19:
        tt5.a.k(this.TAG, "NavigationTitle is null or isAnnounceTemplatePreview");
    }

    public void updateUrlFragment(String r5) {
        String r0 = updateUrlWithFragment(this.url, r5);
        tt5.a.h(this.TAG, "updateUrlFragment, current: " + du5.b.h(this.url) + ", new: " + du5.b.h(r0));
        this.url = r0;
        this.originUrl = r0;
        BearUrl r1 = this.bearUrl;
        r1.e = r0;
        r1.p = r5;
        BearUrl r2 = this.originBearUrl;
        r2.e = r0;
        r2.p = r5;
    }

    public void updateUrlQueryParams(Map<String, String> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.size() == 0) goto L14;
        this.url = av5.c.b(this.url, r5, true);
        this.originUrl = av5.c.b(this.originUrl, r5, true);
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r6.next();
        BearUrl r1 = this.originBearUrl;
        String r2 = r0.getKey();
        String r3 = r0.getValue();
        r1.d.put(r2, r3);
        BearUrl r4 = this.bearUrl;
        String r7 = r0.getKey();
        String r8 = r0.getValue();
        r4.d.put(r7, r8);
        goto L8
    L10:
        BearUrl r9 = this.originBearUrl;
        r9.e = this.originUrl;
        BearUrl r10 = this.bearUrl;
        r10.e = this.url;
        return;
    }

    public DocViewModel(Object r2) {
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
        this.syncBlockLinkEnable = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.synced_block.separate_page_mobile");
        this.documentCoreDependency = (nw4.b) LarkContext.spiByDwarf(nw4.b.class);
    }

    private static boolean objEquals(Object r0, Object r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }

    private void setExternalUser(Boolean r2, String r3) {
        Pair r0 = new Pair(r2, r3);
        if (objEquals(this.externalInfo.getValue(), r0) == true) goto L6;
        this.externalInfo.setValue(r0);
        return;
    }

    private static String updateUrlWithFragment(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        int r0 = r4.indexOf(58);
        if (r0 >= 0) goto L9;
        r0 = 0;
    L9:
        int r1 = r4.indexOf(35, r0);
        if (r1 < 0) goto L15;
        if (r1 >= r4.length()) goto L15;
        r4 = r4.substring(0, r1);
    L15:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return r4;
    L17:
        return r4 + '#' + r5;
    }

    public PermissionResponse getPermissionResponseWithUserPermission(BizDomain r6, String r7) {
        DocumentInfo r0 = getDocumentInfoData();
        BaseEntity r1 = new BaseEntity(getToken(), sbb.e.d(getDocumentTypeValue()), r6, getCreatorTenantId());
        if (getDocumentInfoData() == null) goto L8;
        if (getDocumentInfoData().getDocPermission() == null) goto L8;
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r1, r7), new UserPermissionEntity(r0.getDocPermission().a, null));
    L8:
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r1, r7), null);
    }

    public void requestDocumentInfo(String r10, boolean r11) {
        String r0 = getToken();
        if (isSyncBlock() == false) goto L5;
        r0 = this.originBearUrl.b;
    L5:
        String r5 = r0;
        w05.i r1 = this.documentInfoProvider;
        String r3 = this.originUrl;
        String r4 = this.spaceId;
        if (this.openSource != DocsOpenSource.vc) goto L8;
        boolean r6 = true;
    L9:
        r1.d(r10, r3, r4, r5, r6, isType(sbb.e.n), r11);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public void setExtraData(String r2, Object r3) {
        Map r0 = (Map) this.extraData.getValue();
        if (r0 != null) goto L5;
        r0 = new HashMap();
    L5:
        r0.put(r2, r3);
        this.extraData.setValue(r0);
    }

    public void setNewCreateUrl(String r4, String r5) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("setNewCreateUrl:");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        Object r2 = "EMPTY";
    L6:
        r1.append(r2);
        tt5.a.h(r0, r1.toString());
        t45.c r3 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        String r6 = r3.v8(r4);
        this.url = r6;
        this.bearUrl = r3.Z(r6);
        String r7 = r3.v8(r5);
        this.originUrl = r7;
        this.originBearUrl = r3.Z(r7);
        setToken(this.bearUrl.b);
        return;
    L5:
        r2 = Integer.valueOf(r5.hashCode());
        goto L6
    }

    public void updateDocViewStateMap(String r2, Integer r3) {
        this.docViewStateMap.put(r2, r3);
    }
}
