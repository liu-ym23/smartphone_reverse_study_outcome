package com.ss.android.lark.profile.v2.entity;

import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u00012\u00020\u0002B\u009b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R:\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'¨\u0006*"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/AliasDescriptionField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "description", "", "image", "Lcom/bytedance/lark/pb/basic/v1/ImageSetPassThrough;", "descriptionRichText", "Lcom/bytedance/lark/pb/basic/v1/RichText;", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hangPointMap", "Ljava/util/HashMap;", "Lcom/bytedance/lark/pb/basic/v1/PreviewHangPoint;", "Lkotlin/collections/HashMap;", "previewEntityMap", "Lcom/bytedance/lark/pb/basic/v1/UrlPreviewEntity;", "<init>", "(Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/ImageSetPassThrough;Lcom/bytedance/lark/pb/basic/v1/RichText;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getImage", "()Lcom/bytedance/lark/pb/basic/v1/ImageSetPassThrough;", "setImage", "(Lcom/bytedance/lark/pb/basic/v1/ImageSetPassThrough;)V", "getDescriptionRichText", "()Lcom/bytedance/lark/pb/basic/v1/RichText;", "setDescriptionRichText", "(Lcom/bytedance/lark/pb/basic/v1/RichText;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "getHangPointMap", "()Ljava/util/HashMap;", "setHangPointMap", "(Ljava/util/HashMap;)V", "getPreviewEntityMap", "setPreviewEntityMap", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AliasDescriptionField extends BaseField {
    private String description;
    private RichText descriptionRichText;
    private HashMap<String, PreviewHangPoint> hangPointMap;
    private ImageSetPassThrough image;
    private ArrayList<ImageSetPassThrough> imageList;
    private HashMap<String, UrlPreviewEntity> previewEntityMap;

    public AliasDescriptionField() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final String getDescription() {
        return this.description;
    }

    public final RichText getDescriptionRichText() {
        return this.descriptionRichText;
    }

    public final HashMap<String, PreviewHangPoint> getHangPointMap() {
        return this.hangPointMap;
    }

    public final ImageSetPassThrough getImage() {
        return this.image;
    }

    public final ArrayList<ImageSetPassThrough> getImageList() {
        return this.imageList;
    }

    public final HashMap<String, UrlPreviewEntity> getPreviewEntityMap() {
        return this.previewEntityMap;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setDescriptionRichText(RichText r100) {
        this.descriptionRichText = r100;
    }

    public final void setHangPointMap(HashMap<String, PreviewHangPoint> r100) {
        this.hangPointMap = r100;
    }

    public final void setImage(ImageSetPassThrough r100) {
        this.image = r100;
    }

    public final void setImageList(ArrayList<ImageSetPassThrough> r100) {
        this.imageList = r100;
    }

    public final void setPreviewEntityMap(HashMap<String, UrlPreviewEntity> r100) {
        this.previewEntityMap = r100;
    }

    public AliasDescriptionField(String r100, ImageSetPassThrough r101, RichText r102, ArrayList<ImageSetPassThrough> r103, HashMap<String, PreviewHangPoint> r104, HashMap<String, UrlPreviewEntity> r105) {
        Intrinsics.checkNotNullParameter(r100, "description");
        this.description = r100;
        this.image = r101;
        this.descriptionRichText = r102;
        this.imageList = r103;
        this.hangPointMap = r104;
        this.previewEntityMap = r105;
    }

    public /* synthetic */ AliasDescriptionField(String r100, ImageSetPassThrough r101, RichText r102, ArrayList r103, HashMap r104, HashMap r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        HashMap r105 = null;
        if ((r111 & 2) == 0) goto L8;
        ImageSetPassThrough r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        RichText r106 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        ArrayList r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        HashMap r108 = null;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
