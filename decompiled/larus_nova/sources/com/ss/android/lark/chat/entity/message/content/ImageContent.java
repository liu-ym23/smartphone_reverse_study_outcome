package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u0004\u0018\u00010 J\u0012\u00102\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u00104\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0016J\u0006\u00105\u001a\u00020\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR6\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020 `!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ImageContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "imageSet", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "(Lcom/ss/android/lark/chat/entity/image/ImageSet;)V", "getImageSet", "()Lcom/ss/android/lark/chat/entity/image/ImageSet;", "setImageSet", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "imageTranslateProperty", "Lcom/ss/android/lark/chat/entity/message/content/ImageTranslateProperty;", "getImageTranslateProperty", "()Lcom/ss/android/lark/chat/entity/message/content/ImageTranslateProperty;", "setImageTranslateProperty", "(Lcom/ss/android/lark/chat/entity/message/content/ImageTranslateProperty;)V", "riskObjectKeys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRiskObjectKeys", "()Ljava/util/ArrayList;", "setRiskObjectKeys", "(Ljava/util/ArrayList;)V", "cleanResourceKeyScene", "Ljava/util/HashMap;", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "Lkotlin/collections/HashMap;", "getCleanResourceKeyScene", "()Ljava/util/HashMap;", "setCleanResourceKeyScene", "(Ljava/util/HashMap;)V", "imageUploadId", "getImageUploadId", "()Ljava/lang/String;", "setImageUploadId", "(Ljava/lang/String;)V", "resourceIsCleaned", "", "currentResourceScene", "isOnTimeDel", "()Z", "setOnTimeDel", "(Z)V", "isContentSame", "diffable", "isItemSame", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "ImageContent")
public final class ImageContent extends Content {
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private ImageSet imageSet;
    private ImageTranslateProperty imageTranslateProperty;
    private String imageUploadId;
    private boolean isOnTimeDel;
    private int progress;
    private ArrayList<String> riskObjectKeys;

    public final ImageContent copy() {
        ImageContent r100 = new ImageContent();
        r100.imageSet = this.imageSet;
        r100.progress = this.progress;
        return r100;
    }

    public final ResourceCleanScene currentResourceScene() {
        ImageSet r100 = this.imageSet;
        if (r100 == null) goto L12;
        String r101 = r100.getKey();
        if (r101 == null) goto L12;
        ResourceCleanScene r102 = this.cleanResourceKeyScene.get(r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    L12:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageContent() {
        this.progress = 100;
        Object[] r100 = 0 == true ? 1 : 0;
        this.imageTranslateProperty = new ImageTranslateProperty(null, r100, 3, 0 == true ? 1 : 0);
        this.cleanResourceKeyScene = new HashMap();
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final ImageTranslateProperty getImageTranslateProperty() {
        return this.imageTranslateProperty;
    }

    public final String getImageUploadId() {
        return this.imageUploadId;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final ArrayList<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public final boolean isOnTimeDel() {
        return this.isOnTimeDel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageContent(ImageSet r100) {
        Intrinsics.checkNotNullParameter(r100, "imageSet");
        this.progress = 100;
        Object[] r101 = 0 == true ? 1 : 0;
        this.imageTranslateProperty = new ImageTranslateProperty(null, r101, 3, 0 == true ? 1 : 0);
        this.cleanResourceKeyScene = new HashMap();
        this.imageSet = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if (r100 != null) goto L4;
    L21:
        return false;
    L4:
        if ((r100 instanceof ImageContent) == false) goto L21;
        ImageContent r101 = (ImageContent) r100;
        if (this.progress != r101.progress) goto L21;
        ArrayList<String> r102 = this.riskObjectKeys;
        Integer r103 = null;
        if (r102 == null) goto L10;
        Integer r104 = Integer.valueOf(r102.size());
    L11:
        ArrayList<String> r105 = r101.riskObjectKeys;
        if (r105 == null) goto L15;
        r103 = Integer.valueOf(r105.size());
    L15:
        if (Intrinsics.areEqual(r104, r103) == false) goto L21;
        if (Intrinsics.areEqual(this.cleanResourceKeyScene, r101.cleanResourceKeyScene) == false) goto L21;
        if (Intrinsics.areEqual(this.imageUploadId, r101.imageUploadId) == false) goto L21;
        return true;
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        if ((r100 instanceof ImageContent) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        ImageSet r101 = ((ImageContent) r100).imageSet;
        ImageSet r102 = this.imageSet;
        if (r102 == null) goto L14;
        if (r101 == null) goto L15;
        Intrinsics.checkNotNull(r102);
        return Intrinsics.areEqual(r102.getKey(), r101.getKey());
    L15:
        return false;
    L14:
        return false;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cleanResourceKeyScene = r100;
    }

    public final void setImageSet(ImageSet r100) {
        this.imageSet = r100;
    }

    public final void setImageTranslateProperty(ImageTranslateProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageTranslateProperty = r100;
    }

    public final void setImageUploadId(String r100) {
        this.imageUploadId = r100;
    }

    public final void setOnTimeDel(boolean r100) {
        this.isOnTimeDel = r100;
    }

    public final void setProgress(int r100) {
        this.progress = r100;
    }

    public final void setRiskObjectKeys(ArrayList<String> r100) {
        this.riskObjectKeys = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }
}
