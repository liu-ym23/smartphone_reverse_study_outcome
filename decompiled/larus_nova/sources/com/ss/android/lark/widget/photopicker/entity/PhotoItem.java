package com.ss.android.lark.widget.photopicker.entity;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.lark.pb.im.v1.ImageTranslateScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.ImageFormat;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photo.preview.menu.action.ReceiveAuthorizationState;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoItem implements Serializable {
    public static final int AVATAR_IMAGE = 4;
    public static final int DOC_IMAGE = 7;
    public static final int ENCRYPT_IMAGE = 3;
    public static final int IMAGE = 2;
    public static final int PASS_THROUGH_IMAGE = 6;
    public static final int STICKER_IMAGE = 5;
    private AuditExtraV2 auditExtraV2;
    protected int currentIndex;
    private int downloadCheckFlag;
    private String entityId;
    private ImageTranslationInfo.EntityType entityType;
    protected String fsUnit;
    private boolean hasPreviewPermission;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final long f447478id;
    private ImageFormat imageFormat;
    protected String imageKey;
    private ByteString inlinePreview;
    private PicInfo intactPicInfo;
    private Boolean isAnimatedImage;
    private boolean isOriginSource;
    private boolean isOriginal;
    private Serializable loadModel;
    private LOAD_STATUS loadStatus;
    private MediaExtra mediaExtra;
    private MessageIdentity messageIdentity;
    private PicInfo middlePicInfo;
    private PicInfo originPicInfo;
    private long originSize;
    protected final List<String> paths;
    private Photo photo;
    private PhotoState photoState;
    private int receiveAuthorizationStateValue;
    private ResourceCleanScene resourceCleanScene;
    public boolean resourceIsCleaned;
    private Matrix.ScaleToFit scaleToFit;
    protected SerCrypto serCrypto;
    protected Object tag;
    private Drawable thumbnail;
    private PicInfo thumbnailPicInfo;
    private String token;
    private Serializable translateOriginModel;
    private final TranslateProperty translateProperty;
    private ImageTranslateScene translateScene;
    private int type;
    private ValidateIMFileResult validateIMFileResult;
    private int width;

    public static final enum LOAD_STATUS extends Enum<LOAD_STATUS> {
        public static final LOAD_STATUS FAILED = null;
        public static final LOAD_STATUS LOADING = null;
        public static final LOAD_STATUS SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LOAD_STATUS[] f447479a = null;

        static {
            LOAD_STATUS r100 = new LOAD_STATUS("SUCCESS", 0);
            SUCCESS = r100;
            LOAD_STATUS r101 = new LOAD_STATUS("FAILED", 1);
            FAILED = r101;
            LOAD_STATUS r102 = new LOAD_STATUS("LOADING", 2);
            LOADING = r102;
            f447479a = new LOAD_STATUS[]{r100, r101, r102};
        }

        public static LOAD_STATUS[] values() {
            return (LOAD_STATUS[]) f447479a.clone();
        }

        public static LOAD_STATUS valueOf(String r100) {
            return (LOAD_STATUS) r27.a.a(LOAD_STATUS.class, r100);
        }

        public LOAD_STATUS(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class PicInfo implements Serializable {
        public final int height;
        public final String key;
        public Serializable loadModel;
        public final List<String> urls;
        public final int width;

        public boolean isEmpty() {
            if (this.key.equals("") == true) goto L5;
        L11:
            return false;
        L5:
            if (this.width != 0) goto L11;
            if (this.height != 0) goto L11;
            if (this.urls.isEmpty() == false) goto L11;
            return true;
        }

        public PicInfo() {
            this.key = "";
            this.width = 0;
            this.height = 0;
            this.urls = new ArrayList();
            this.loadModel = null;
        }

        public PicInfo(String r100, List<String> r101, int r102, int r103) {
            this.key = r100;
            this.width = r102;
            this.height = r103;
            this.urls = r101;
            this.loadModel = null;
        }

        public PicInfo(String r100, List<String> r101, int r102, int r103, Object r104) {
            this.key = r100;
            this.width = r102;
            this.height = r103;
            this.urls = r101;
            if ((r104 instanceof Serializable) == false) goto L5;
            this.loadModel = (Serializable) r104;
            return;
        L5:
            Log.e("PhotoItem", "loadModel is not serializable:" + r104);
        }
    }

    public class TranslateProperty implements Serializable {
        private boolean canTranslate;
        private boolean isTranslated;
        private List<String> srcLanguages;
        final /* synthetic */ PhotoItem this$0;

        public boolean canTranslate() {
            return this.canTranslate;
        }

        public List<String> getSrcLanguages() {
            return this.srcLanguages;
        }

        public boolean isTranslated() {
            return this.isTranslated;
        }

        public TranslateProperty(PhotoItem r100) {
            this.this$0 = r100;
            this.srcLanguages = new ArrayList();
        }

        public void setCanTranslate(boolean r100) {
            if (this.canTranslate != r100) goto L5;
            return;
        L5:
            this.canTranslate = r100;
            String r101 = "";
            boolean r102 = false;
            if (CollectionUtils.isNotEmpty(this.srcLanguages) == false) goto L8;
            String r103 = (String) ListProtector.get(this.srcLanguages, 0);
        L10:
            if (w6b.a.f558472a != null) goto L12;
            w6b.a.f558472a = UserSP.getInstance().getString("main_language");
        L12:
            String r104 = w6b.a.f558472a;
            if (r104 == null) goto L17;
            r101 = r104;
        L17:
            if (this.isTranslated == true) goto L25;
            if (r100 == true) goto L20;
        L26:
            Log.i("TranslateProperty", "setCanTranslate, key:" + this.this$0.imageKey + ",isTranslated:" + this.isTranslated + ",canTranslate:" + r100 + ",imageLanguage:" + r103 + ",mainLanguage:" + r101 + ",showTranslate:" + r102);
            PhotoItem.access$000(this.this$0).getShowTranslate().postValue(Boolean.valueOf(r102));
            return;
        L20:
            if (TextUtils.isEmpty(r103) == true) goto L26;
            if (TextUtils.isEmpty(r101) == true) goto L26;
            if (r103.equals(r101) == true) goto L26;
        L25:
            r102 = true;
            goto L26
        L8:
            r103 = "";
            goto L10
        }

        public void setSrcLanguages(List<String> r100) {
            this.srcLanguages = r100;
        }

        public void setTranslated(boolean r100) {
            this.isTranslated = r100;
        }
    }

    public String getCurrentUrl() {
        Serializable r100 = this.loadModel;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if (CollectionUtils.isEmpty(this.paths) == false) goto L11;
        return this.imageKey;
    L11:
        return (String) ListProtector.get(this.paths, this.currentIndex);
    }

    public long getDuration() {
        return this.photo.getDuration();
    }

    public String getMessageId() {
        MessageIdentity r100 = this.messageIdentity;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getMessageId();
    }

    public String getMimeType() {
        return this.photo.getMimeType();
    }

    public String getVideoKey() {
        MediaExtra r100 = this.mediaExtra;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getKey();
    }

    public boolean hasReceivePermission() {
        int r100 = ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS.getValue();
        int r101 = ReceiveAuthorizationState.NORMAL_STATE.getValue();
        int r102 = this.receiveAuthorizationStateValue;
        if (r102 == r100) goto L7;
        if (r102 == r101) goto L7;
        return false;
    L7:
        return true;
    }

    public int hashCode() {
        Serializable r100 = this.loadModel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L9:
        int r103 = r102 * 31;
        String r104 = this.imageKey;
        if (r104 == null) goto L13;
        r101 = r104.hashCode();
    L13:
        return r103 + r101;
    L5:
        List<String> r105 = this.paths;
        if (r105 == null) goto L8;
        r102 = r105.hashCode();
        goto L9
    L8:
        r102 = 0;
        goto L9
    }

    public boolean isAnimatedImage() {
        File r100 = this.photoState.getShowFile().getValue();
        if (this.isAnimatedImage != null) goto L14;
        if (r100 != null) goto L6;
    L8:
        Serializable r101 = this.loadModel;
        if ((r101 instanceof String) == false) goto L14;
        if (FileUtils.s((String) r101) == false) goto L14;
        this.isAnimatedImage = Boolean.valueOf(ImageUtils.e(VFSFiles.f444819b.i((String) this.loadModel)));
        goto L14
    L6:
        if (r100.exists() == false) goto L8;
        this.isAnimatedImage = Boolean.valueOf(ImageUtils.e(r100));
    L14:
        return Boolean.TRUE.equals(this.isAnimatedImage);
    }

    public boolean isVideo() {
        Photo r100 = this.photo;
        if (r100 == null) goto L7;
        if (r100.isVideo() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mediaExtra != null) goto L8;
        return false;
    }

    public void resetState() {
        this.photoState = new PhotoState();
    }

    public PhotoItem() {
        this.f447478id = UUID.randomUUID().toString().hashCode();
        this.paths = new ArrayList();
        this.currentIndex = 0;
        this.entityType = ImageTranslationInfo.EntityType.MESSAGE_ENTITY;
        this.translateScene = ImageTranslateScene.IMAGE_TRANSLATION_SCENE_CHAT;
        this.intactPicInfo = new PicInfo();
        this.originPicInfo = new PicInfo();
        this.middlePicInfo = new PicInfo();
        this.thumbnailPicInfo = new PicInfo();
        this.type = 2;
        this.width = 0;
        this.height = 0;
        this.scaleToFit = Matrix.ScaleToFit.FILL;
        this.translateProperty = new TranslateProperty(this);
        this.isOriginSource = false;
        this.originSize = 0;
        this.loadStatus = LOAD_STATUS.LOADING;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
        this.photoState = new PhotoState();
        this.isAnimatedImage = null;
        this.downloadCheckFlag = 0;
    }

    public ResourceCleanScene getResourceCleanScene() {
        if (PhotoPagerFgUtils.a() == true) goto L5;
        return null;
    L5:
        return this.resourceCleanScene;
    }

    public AuditExtraV2 getAuditExtraV2() {
        return this.auditExtraV2;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getDownloadCheckFlag() {
        return this.downloadCheckFlag;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public ImageTranslationInfo.EntityType getEntityType() {
        return this.entityType;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public ByteString getInlinePreview() {
        return this.inlinePreview;
    }

    public PicInfo getIntactPicInfo() {
        return this.intactPicInfo;
    }

    public Serializable getLoadModel() {
        return this.loadModel;
    }

    public LOAD_STATUS getLoadStatus() {
        return this.loadStatus;
    }

    public MediaExtra getMediaExtra() {
        return this.mediaExtra;
    }

    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    public PicInfo getMiddlePicInfo() {
        return this.middlePicInfo;
    }

    public PicInfo getOriginPicInfo() {
        return this.originPicInfo;
    }

    public long getOriginSize() {
        return this.originSize;
    }

    public List<String> getPaths() {
        return this.paths;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public PhotoState getPhotoState() {
        return this.photoState;
    }

    public int getReceiveAuthorizationStateValue() {
        return this.receiveAuthorizationStateValue;
    }

    public Matrix.ScaleToFit getScaleToFit() {
        return this.scaleToFit;
    }

    public SerCrypto getSerCrypto() {
        return this.serCrypto;
    }

    public Object getTag() {
        return this.tag;
    }

    public Drawable getThumbnail() {
        return this.thumbnail;
    }

    public PicInfo getThumbnailPicInfo() {
        return this.thumbnailPicInfo;
    }

    public String getToken() {
        return this.token;
    }

    public Object getTranslateOriginModel() {
        return this.translateOriginModel;
    }

    public TranslateProperty getTranslateProperty() {
        return this.translateProperty;
    }

    public ImageTranslateScene getTranslateScene() {
        return this.translateScene;
    }

    public int getType() {
        return this.type;
    }

    public ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isHasPreviewPermission() {
        return this.hasPreviewPermission;
    }

    public boolean isOriginSource() {
        return this.isOriginSource;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public static /* synthetic */ PhotoState access$000(PhotoItem r100) {
        return r100.photoState;
    }

    public static PhotoItem getPhotoItemByPhoto(Photo r100) {
        PhotoItem r101 = new PhotoItem();
        r101.setPhoto(r100);
        r101.setLoadModel(r100.getPath());
        return r101;
    }

    public static ArrayList<PhotoItem> getPhotoItemsByPhotos(List<Photo> r100) {
        ArrayList<PhotoItem> r101 = new ArrayList();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<Photo> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Photo r103 = r102.next();
        if (r103 == null) goto L7;
        r101.add(getPhotoItemByPhoto(r103));
        goto L7
    L11:
        return r101;
    }

    public static ArrayList<PhotoItem> getPhotoItemsByUrls(List<String> r100) {
        ArrayList<PhotoItem> r101 = new ArrayList();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        PhotoItem r104 = new PhotoItem().setPaths(Collections.singletonList(r103));
        r104.setLoadModel(r103);
        r101.add(r104);
        goto L7
    L9:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoItem) == true) goto L8;
        return false;
    L8:
        PhotoItem r101 = (PhotoItem) r100;
        if (Objects.equals(this.loadModel, r101.loadModel) == true) goto L11;
        return false;
    L11:
        List<String> r102 = this.paths;
        if (r102 == null) goto L17;
        if (r102.equals(r101.paths) == false) goto L18;
    L19:
        String r103 = this.imageKey;
        String r104 = r101.imageKey;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L18:
        return false;
    L17:
        if (r101.paths == null) goto L19;
        goto L18
    }

    public void setAuditExtraV2(AuditExtraV2 r100) {
        this.auditExtraV2 = r100;
    }

    public PhotoItem setCurrentIndex(int r100) {
        this.currentIndex = r100;
        return this;
    }

    public void setDownloadCheckFlag(DownloadCheckUtil.a r100) {
        r100.getClass();
        this.downloadCheckFlag = 0;
    }

    public PhotoItem setEntityId(String r100) {
        this.entityId = r100;
        return this;
    }

    public void setEntityType(ImageTranslationInfo.EntityType r100) {
        this.entityType = r100;
    }

    public PhotoItem setFsUnit(String r100) {
        this.fsUnit = r100;
        return this;
    }

    public PhotoItem setHasPreviewPermission(boolean r100) {
        this.hasPreviewPermission = r100;
        return this;
    }

    public PhotoItem setHeight(int r100) {
        this.height = r100;
        return this;
    }

    public PhotoItem setImageFormat(ImageFormat r100) {
        this.imageFormat = r100;
        return this;
    }

    public PhotoItem setImageKey(String r100) {
        this.imageKey = r100;
        return this;
    }

    public PhotoItem setInlinePreview(ByteString r100) {
        this.inlinePreview = r100;
        return this;
    }

    public PhotoItem setIntactPicInfo(PicInfo r100) {
        this.intactPicInfo = r100;
        return this;
    }

    public PhotoItem setLoadModel(Object r100) {
        if ((r100 instanceof Serializable) == false) goto L5;
        this.loadModel = (Serializable) r100;
    L6:
        return this;
    L5:
        Log.e("PhotoItem", "model is not serializable, skip set:" + r100);
        goto L6
    }

    public void setLoadStatus(LOAD_STATUS r100) {
        this.loadStatus = r100;
    }

    public PhotoItem setMediaExtra(MediaExtra r100) {
        this.mediaExtra = r100;
        return this;
    }

    public PhotoItem setMessageId(String r100) {
        this.messageIdentity = new MessageIdentity(r100, "");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.entityType = ImageTranslationInfo.EntityType.MESSAGE_ENTITY;
    L5:
        return this;
    }

    public PhotoItem setMessageIdentity(MessageIdentity r100) {
        this.messageIdentity = r100;
        if (r100 == null) goto L5;
        this.entityType = ImageTranslationInfo.EntityType.MESSAGE_ENTITY;
    L5:
        return this;
    }

    public PhotoItem setMiddlePicInfo(PicInfo r100) {
        this.middlePicInfo = r100;
        return this;
    }

    public PhotoItem setOriginPicInfo(PicInfo r100) {
        this.originPicInfo = r100;
        return this;
    }

    public PhotoItem setOriginSize(long r100) {
        this.originSize = r100;
        return this;
    }

    public PhotoItem setOriginSource(boolean r100) {
        this.isOriginSource = r100;
        return this;
    }

    public void setOriginal(boolean r100) {
        this.isOriginal = r100;
    }

    public PhotoItem setPaths(List<String> r100) {
        this.paths.addAll(r100);
        return this;
    }

    public void setPhoto(Photo r100) {
        this.photo = r100;
    }

    public PhotoItem setReceiveAuthorizationStateValue(int r100) {
        this.receiveAuthorizationStateValue = r100;
        return this;
    }

    public PhotoItem setResourceCleanScene(ResourceCleanScene r100) {
        if (PhotoPagerFgUtils.a() == false) goto L5;
        this.resourceCleanScene = r100;
    L5:
        return this;
    }

    public PhotoItem setResourceIsCleaned(boolean r100) {
        if (PhotoPagerFgUtils.a() == false) goto L5;
        this.resourceIsCleaned = r100;
    L5:
        return this;
    }

    public PhotoItem setScaleToFit(Matrix.ScaleToFit r100) {
        this.scaleToFit = r100;
        return this;
    }

    public PhotoItem setSerCrypto(SerCrypto r100) {
        this.serCrypto = r100;
        return this;
    }

    public PhotoItem setTag(Object r100) {
        this.tag = r100;
        return this;
    }

    public void setThumbnail(Drawable r100) {
        this.thumbnail = r100;
    }

    public PhotoItem setThumbnailPicInfo(PicInfo r100) {
        this.thumbnailPicInfo = r100;
        return this;
    }

    public PhotoItem setToken(String r100) {
        this.token = r100;
        return this;
    }

    public PhotoItem setTranslateOriginModel(Object r100) {
        if ((r100 instanceof Serializable) == false) goto L5;
        this.translateOriginModel = (Serializable) r100;
    L6:
        return this;
    L5:
        Log.e("PhotoItem", "model is not serializable, skip set:" + r100);
        goto L6
    }

    public void setTranslateScene(ImageTranslateScene r100) {
        this.translateScene = r100;
    }

    public PhotoItem setType(int r100) {
        this.type = r100;
        return this;
    }

    public PhotoItem setValidateIMFileResult(ValidateIMFileResult r100) {
        this.validateIMFileResult = r100;
        return this;
    }

    public PhotoItem setWidth(int r100) {
        this.width = r100;
        return this;
    }
}
