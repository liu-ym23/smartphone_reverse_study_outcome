package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.entity.preview.DocType;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0002J\b\u0010/\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/DocImageProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "docType", "Lcom/ss/android/lark/chat/entity/preview/DocType;", "token", "", "thumbnailUrl", "secretUrl", "secretType", "", "secretKey", "secretNonce", "supportPreview", "", "<init>", "(Lcom/ss/android/lark/chat/entity/preview/DocType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "getDocType", "()Lcom/ss/android/lark/chat/entity/preview/DocType;", "setDocType", "(Lcom/ss/android/lark/chat/entity/preview/DocType;)V", "getToken", "()Ljava/lang/String;", "getThumbnailUrl", "setThumbnailUrl", "(Ljava/lang/String;)V", "getSecretUrl", "setSecretUrl", "getSecretType", "()Ljava/lang/Integer;", "setSecretType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSecretKey", "setSecretKey", "getSecretNonce", "setSecretNonce", "getSupportPreview", "()Z", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", "other", "", "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocImageProperty extends BaseProperty {
    private DocType docType;
    private String secretKey;
    private String secretNonce;
    private Integer secretType;
    private String secretUrl;
    private final boolean supportPreview;
    private String thumbnailUrl;
    private final String token;

    public DocImageProperty() {
        this(null, null, null, null, null, null, null, false, 255, null);
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public Props clone() {
        return new DocImageProperty(this.docType, this.token, this.thumbnailUrl, this.secretUrl, this.secretType, this.secretKey, this.secretNonce, this.supportPreview);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((super.hashCode() * 31) + this.docType.hashCode()) * 31;
        String r101 = this.thumbnailUrl;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.secretUrl;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.secretType;
        if (r108 == null) goto L13;
        int r109 = r108.intValue();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.secretKey;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.secretNonce;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final DocType getDocType() {
        return this.docType;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSecretNonce() {
        return this.secretNonce;
    }

    public final Integer getSecretType() {
        return this.secretType;
    }

    public final String getSecretUrl() {
        return this.secretUrl;
    }

    public final boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocImageProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        DocImageProperty r101 = (DocImageProperty) r100;
        if (this.docType == r101.docType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.thumbnailUrl, r101.thumbnailUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secretUrl, r101.secretUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secretType, r101.secretType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secretKey, r101.secretKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.secretNonce, r101.secretNonce) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L46;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.doc_type.getValue()) goto L9;
        String r104 = null;
        String r105 = null;
        String r106 = null;
        Integer r107 = null;
        String r108 = null;
        if (r103 == ComponentAttribute.thumbnail_url.getValue()) goto L18;
        if (r103 == ComponentAttribute.secret_url.getValue()) goto L24;
        if (r103 == ComponentAttribute.secret_type.getValue()) goto L30;
        if (r103 == ComponentAttribute.secret_key.getValue()) goto L36;
        if (r103 != ComponentAttribute.secret_nonce.getValue()) goto L6;
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L45;
        r105 = r109.getString();
    L45:
        this.secretNonce = r105;
        goto L6
    L36:
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L39;
        r106 = r110.getString();
    L39:
        this.secretKey = r106;
        goto L6
    L30:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L33;
        r107 = r111.getInt();
    L33:
        this.secretType = r107;
        goto L6
    L24:
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L27;
        r108 = r112.getString();
    L27:
        this.secretUrl = r108;
        goto L6
    L18:
        PreviewData r113 = r102.getValue();
        if (r113 == null) goto L21;
        r104 = r113.getString();
    L21:
        this.thumbnailUrl = r104;
        goto L6
    L9:
        DocType.a r114 = DocType.Companion;
        PreviewData r115 = r102.getValue();
        if (r115 == null) goto L14;
        Integer r116 = r115.getInt();
        if (r116 == null) goto L14;
        int r117 = r116.intValue();
    L15:
        r114.getClass();
        this.docType = DocType.a.a(r117);
    L14:
        r117 = 0;
        goto L15
    }

    public final void setDocType(DocType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docType = r100;
    }

    public final void setSecretKey(String r100) {
        this.secretKey = r100;
    }

    public final void setSecretNonce(String r100) {
        this.secretNonce = r100;
    }

    public final void setSecretType(Integer r100) {
        this.secretType = r100;
    }

    public final void setSecretUrl(String r100) {
        this.secretUrl = r100;
    }

    public final void setThumbnailUrl(String r100) {
        this.thumbnailUrl = r100;
    }

    public DocImageProperty(DocType r100, String r101, String r102, String r103, Integer r104, String r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        super(Type.DOC_IMAGE);
        this.docType = r100;
        this.token = r101;
        this.thumbnailUrl = r102;
        this.secretUrl = r103;
        this.secretType = r104;
        this.secretKey = r105;
        this.secretNonce = r106;
        this.supportPreview = r107;
    }

    public /* synthetic */ DocImageProperty(DocType r110, String r111, String r112, String r113, Integer r114, String r115, String r116, boolean r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 1) == 0) goto L5;
        DocType r100 = DocType.UNKNOWN;
    L6:
        String r101 = null;
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L18:
        boolean r105 = false;
        if ((r118 & 16) == 0) goto L21;
        Integer r106 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r105 = r117;
    L34:
        this(r100, r102, r103, r104, r106, r107, r101, r105);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
