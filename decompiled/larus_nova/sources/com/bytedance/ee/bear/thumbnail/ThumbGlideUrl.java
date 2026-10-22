package com.bytedance.ee.bear.thumbnail;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bytedance.ee.bear.contract.j;
import du5.b;
import ho5.c;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;
import sbb.e;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class ThumbGlideUrl extends GlideUrl {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    public static final int DECODE_TYPE_AES_CBC = 2;
    public static final int DECODE_TYPE_AES_GCM = 1;
    public static final int DECODE_TYPE_NONE = 0;
    public static final int DECODE_TYPE_SM4_GCM = 3;
    public static final String SOURCE_ANNOUNCEMENT = "announcement";
    public static final String SOURCE_CHAT = "chat";
    public static final String SOURCE_FOLDER_BLOCK_ICON = "folderblock_icon";
    public static final String SOURCE_SEARCH = "search";
    public static final String SOURCE_SHARE_WORDS = "share_words";
    public static final String SOURCE_SPACE_LIST = "space_list";
    public static final String SOURCE_SPACE_LIST_ICON = "space_list_icon";
    public static final String SOURCE_TEMPLATE = "template";
    public static final String SOURCE_VC = "vc";
    private String errorBody;
    private String extra;
    private boolean isConnect;
    private boolean isForceEncryption;
    private boolean isIcon;
    private boolean isValid;
    private String mDecodeKey;
    private String mDecodeNonce;
    private int mDecodeType;
    private int mDocType;
    private String mETag;
    private String mEncryptUrl;
    private WeakReference<ImageView> mImageViewWeakReference;
    private String mOriginUrl;
    private String mSource;
    private Map<String, List<String>> responseHeaders;
    private int statusCode;
    private String subType;
    private String version;

    public String getETag() {
        if (this.mETag != null) goto L21;
        c r100 = c.d();
        String r101 = getUrl();
        String r102 = this.version;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        String r103 = "";
        monitor-exit(r100);
    L17:
        this.mETag = r103;
        goto L21
    L11:
        String r104 = r100.c(r101, r102);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r104) == false) goto L15;
        r103 = r100.b(r101, r102);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r100);
        goto L17
    L15:
        r103 = r104;
    L21:
        String r105 = this.mETag;
        if (r105 != null) goto L27;
        return "";
    L27:
        return r105;
    }

    public ImageView getImageView() {
        return this.mImageViewWeakReference.get();
    }

    public String getVersion() {
        String r100 = this.version;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.mOriginUrl, this.mEncryptUrl, Integer.valueOf(this.mDocType), Integer.valueOf(this.mDecodeType), this.mDecodeKey, this.mDecodeNonce, this.mETag, this.mSource, Boolean.valueOf(this.isValid), Boolean.valueOf(this.isForceEncryption), this.version, Boolean.valueOf(this.isIcon), Boolean.valueOf(this.isConnect)});
    }

    public boolean isConnected() {
        return j.a.f217090a.getNetworkState().a();
    }

    public boolean isEncrypt() {
        if (this.isForceEncryption == false) goto L6;
        return true;
    L6:
        return !TextUtils.isEmpty(this.mEncryptUrl);
    }

    public boolean isFileIconUseDefault() {
        if (this.mDocType == e.f541301l.f541317b) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST) == true) goto L9;
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST_ICON) == false) goto L11;
    L9:
        if (isIconHasPerm(this.extra) == true) goto L11;
        return true;
    }

    public URL toURLForOriginUrl() {
        if (TextUtils.isEmpty(this.mOriginUrl) == false) goto L6;
        return null;
    L6:
        return getURL(this.mOriginUrl);
    }

    @Override // com.bumptech.glide.load.model.GlideUrl
    public String getCacheKey() {
        if (TextUtils.isEmpty(getUrl()) == false) goto L5;
        String r100 = "";
    L7:
        return r100 + this.mDecodeType + getETag();
    L5:
        r100 = getUrl();
        goto L7
    }

    public String getEncryptCacheKey() {
        return b.g(getCacheKey());
    }

    public String getUrl() {
        if (isEncrypt() == false) goto L6;
        return this.mEncryptUrl;
    L6:
        return this.mOriginUrl;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl
    public URL toURL() {
        return getURL(getUrl());
    }

    public String getDecodeKey() {
        return this.mDecodeKey;
    }

    public String getDecodeNonce() {
        return this.mDecodeNonce;
    }

    public int getDecodeType() {
        return this.mDecodeType;
    }

    public int getDocType() {
        return this.mDocType;
    }

    public String getErrorBody() {
        return this.errorBody;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.responseHeaders;
    }

    public String getSource() {
        return this.mSource;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean isForceEncryption() {
        return this.isForceEncryption;
    }

    public boolean isIcon() {
        return this.isIcon;
    }

    public boolean isValid() {
        return this.isValid;
    }

    private URL getURL(String r100) {
        return new URL(Uri.encode(r100, ALLOWED_URI_CHARS));
    L4:
        return null;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L42:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L42;
        if (super.equals(r100) == true) goto L13;
        return false;
    L13:
        ThumbGlideUrl r101 = (ThumbGlideUrl) r100;
        if (this.mDocType == r101.mDocType) goto L16;
    L40:
        return false;
    L16:
        if (this.mDecodeType != r101.mDecodeType) goto L40;
        if (this.isValid != r101.isValid) goto L40;
        if (this.isForceEncryption != r101.isForceEncryption) goto L40;
        if (this.isIcon != r101.isIcon) goto L40;
        if (this.isConnect != r101.isConnect) goto L40;
        if (Objects.equals(this.mOriginUrl, r101.mOriginUrl) == false) goto L40;
        if (Objects.equals(this.mEncryptUrl, r101.mEncryptUrl) == false) goto L40;
        if (Objects.equals(this.mDecodeKey, r101.mDecodeKey) == false) goto L40;
        if (Objects.equals(this.mDecodeNonce, r101.mDecodeNonce) == false) goto L40;
        if (Objects.equals(this.mETag, r101.mETag) == false) goto L40;
        if (Objects.equals(this.mSource, r101.mSource) == false) goto L40;
        if (Objects.equals(this.version, r101.version) == false) goto L40;
        return true;
    }

    public boolean isIconHasPerm(String r100) {
    L7:
        e = move-exception;
        a.d("ThumbGlideUrl", e.getMessage());
    L9:
        return true;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return new JSONObject(r100).optBoolean("icon_has_perm", true);
    }

    public boolean needUpdate(String r100) {
        boolean r101 = true;
        if (this.mDocType == e.f541301l.f541317b) goto L5;
    L10:
        boolean r102 = TextUtils.isEmpty(c.d().c(r100, getVersion()));
        if (this.isConnect == false) goto L13;
    L16:
        if (r101 == true) goto L18;
        return false;
    L18:
        return r102;
    L13:
        if (isConnected() == true) goto L16;
        r101 = false;
        goto L16
    L5:
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST) == true) goto L9;
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST_ICON) == false) goto L10;
    L9:
        return !isIconHasPerm(this.extra);
    }

    public void setETag(String r100) {
        this.mETag = r100;
    }

    public void setErrorBody(String r100) {
        this.errorBody = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setIcon(boolean r100) {
        this.isIcon = r100;
    }

    public void setIsConnect(Boolean r100) {
        this.isConnect = r100.booleanValue();
    }

    public void setResponseHeaders(Map<String, List<String>> r100) {
        this.responseHeaders = r100;
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public void setSubType(String r100) {
        this.subType = r100;
    }

    public ThumbGlideUrl(String r110, String r111, int r112, int r113, String r114, String r115, String r116, boolean r117, ImageView r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, "", r210);
    }

    public ThumbGlideUrl(String r110, String r111, int r112, int r113, String r114, String r115, String r116, boolean r210, String r211, ImageView r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, null);
    }

    public ThumbGlideUrl(String r100, String r101, int r102, int r103, String r104, String r105, String r106, boolean r107, String r110, ImageView r111, Headers r112) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r108 = "isValid";
    L6:
        if (r112 != null) goto L9;
        r112 = Headers.DEFAULT;
    L9:
        super(r108, r112);
        this.mOriginUrl = r100;
        this.mEncryptUrl = r101;
        this.mDocType = r102;
        this.mDecodeType = r103;
        this.mDecodeKey = r104;
        this.mDecodeNonce = r105;
        this.mSource = r106;
        this.version = r110;
        this.mImageViewWeakReference = new WeakReference(r111);
        this.isForceEncryption = r107;
        this.isValid = !TextUtils.isEmpty(getUrl());
        return;
    L5:
        r108 = r100;
        goto L6
    }
}
