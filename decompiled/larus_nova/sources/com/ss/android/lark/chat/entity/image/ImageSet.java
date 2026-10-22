package com.ss.android.lark.chat.entity.image;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.BaseImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public class ImageSet extends BaseImageSet {
    private static final long serialVersionUID = 3501109319906571184L;
    private boolean hasPreviewPermission;
    private ImageAuthAction imageAuthAction;
    protected ByteString inlinePreview;
    protected Image intact;
    private boolean isFromMe;
    private boolean isOriginSource;
    protected boolean isTranslated;
    protected MessageIdentity messageIdentity;
    private long originSize;
    private int receiveAuthorizationStateValue;
    private ResourceCleanScene resourceCleanScene;
    boolean resourceIsCleaned;
    private String senderTenantId;
    private ValidateIMFileResult validateIMFileResult;

    public ImageSet() {
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public ImageAuthAction getImageAuthAction() {
        return this.imageAuthAction;
    }

    public ByteString getInlinePreview() {
        return this.inlinePreview;
    }

    public Image getIntact() {
        return this.intact;
    }

    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    public long getOriginSize() {
        return this.originSize;
    }

    public int getReceiveAuthorizationStateValue() {
        return this.receiveAuthorizationStateValue;
    }

    public ResourceCleanScene getResourceCleanScene() {
        return this.resourceCleanScene;
    }

    public String getSenderTenantId() {
        return this.senderTenantId;
    }

    public ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public boolean isFromMe() {
        return this.isFromMe;
    }

    public boolean isHasPreviewPermission() {
        return this.hasPreviewPermission;
    }

    public boolean isOriginSource() {
        return this.isOriginSource;
    }

    public boolean isTranslated() {
        return this.isTranslated;
    }

    public void setFromMe(boolean r100) {
        this.isFromMe = r100;
    }

    public void setHasPreviewPermission(boolean r100) {
        this.hasPreviewPermission = r100;
    }

    public void setImageAuthAction(ImageAuthAction r100) {
        this.imageAuthAction = r100;
    }

    public void setInlinePreview(ByteString r100) {
        this.inlinePreview = r100;
    }

    public void setIntact(Image r100) {
        this.intact = r100;
    }

    public void setMessageIdentity(MessageIdentity r100) {
        this.messageIdentity = r100;
    }

    public void setOriginSize(long r100) {
        this.originSize = r100;
    }

    public void setOriginSource(boolean r100) {
        this.isOriginSource = r100;
    }

    public void setReceiveAuthorizationStateValue(int r100) {
        this.receiveAuthorizationStateValue = r100;
    }

    public void setResourceCleanScene(ResourceCleanScene r100) {
        this.resourceCleanScene = r100;
    }

    public void setResourceIsCleaned(boolean r100) {
        this.resourceIsCleaned = r100;
    }

    public void setSenderTenantId(String r100) {
        this.senderTenantId = r100;
    }

    public void setTranslated(boolean r100) {
        this.isTranslated = r100;
    }

    public void setValidateIMFileResult(ValidateIMFileResult r100) {
        this.validateIMFileResult = r100;
    }

    public ImageSet(String r100, Image r101, Image r102) {
        super(r100, r101, r102);
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public ImageSet(String r100, Image r101, Image r102, Image r103, ByteString r104, MessageIdentity r105) {
        super(r100, r101, r102);
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
        this.middle = r103;
        this.inlinePreview = r104;
        this.messageIdentity = r105;
    }
}
