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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        c r0 = c.d();
        String r1 = getUrl();
        String r2 = this.version;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L11;
        String r3 = "";
        monitor-exit(r0);
    L17:
        this.mETag = r3;
        goto L21
    L11:
        String r4 = r0.c(r1, r2);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r4) == false) goto L15;
        r3 = r0.b(r1, r2);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);
        goto L17
    L15:
        r3 = r4;
    L21:
        String r5 = this.mETag;
        if (r5 != null) goto L27;
        return "";
    L27:
        return r5;
    }

    public ImageView getImageView() {
        return this.mImageViewWeakReference.get();
    }

    public String getVersion() {
        String r0 = this.version;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mOriginUrl, this.mEncryptUrl, Integer.valueOf(this.mDocType), Integer.valueOf(this.mDecodeType), this.mDecodeKey, this.mDecodeNonce, this.mETag, this.mSource, Boolean.valueOf(this.isValid), Boolean.valueOf(this.isForceEncryption), this.version, Boolean.valueOf(this.isIcon), Boolean.valueOf(this.isConnect)});
    }

    public boolean isConnected() {
        return j.a.a.getNetworkState().a();
    }

    public boolean isEncrypt() {
        if (this.isForceEncryption == false) goto L6;
        return true;
    L6:
        return !TextUtils.isEmpty(this.mEncryptUrl);
    }

    public boolean isFileIconUseDefault() {
        if (this.mDocType == e.l.b) goto L5;
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

    public String getCacheKey() {
        if (TextUtils.isEmpty(getUrl()) == false) goto L5;
        String r0 = "";
    L7:
        return r0 + this.mDecodeType + getETag();
    L5:
        r0 = getUrl();
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

    private URL getURL(String r2) {
        return new URL(Uri.encode(r2, ALLOWED_URI_CHARS));
    L4:
        return null;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L42:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L42;
        if (super.equals(r5) == true) goto L13;
        return false;
    L13:
        ThumbGlideUrl r6 = (ThumbGlideUrl) r5;
        if (this.mDocType == r6.mDocType) goto L16;
    L40:
        return false;
    L16:
        if (this.mDecodeType != r6.mDecodeType) goto L40;
        if (this.isValid != r6.isValid) goto L40;
        if (this.isForceEncryption != r6.isForceEncryption) goto L40;
        if (this.isIcon != r6.isIcon) goto L40;
        if (this.isConnect != r6.isConnect) goto L40;
        if (Objects.equals(this.mOriginUrl, r6.mOriginUrl) == false) goto L40;
        if (Objects.equals(this.mEncryptUrl, r6.mEncryptUrl) == false) goto L40;
        if (Objects.equals(this.mDecodeKey, r6.mDecodeKey) == false) goto L40;
        if (Objects.equals(this.mDecodeNonce, r6.mDecodeNonce) == false) goto L40;
        if (Objects.equals(this.mETag, r6.mETag) == false) goto L40;
        if (Objects.equals(this.mSource, r6.mSource) == false) goto L40;
        if (Objects.equals(this.version, r6.version) == false) goto L40;
        return true;
    }

    public boolean isIconHasPerm(String r3) {
    L7:
        e = move-exception;
        a.d("ThumbGlideUrl", e.getMessage());
    L9:
        return true;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        return new JSONObject(r3).optBoolean("icon_has_perm", true);
    }

    public boolean needUpdate(String r4) {
        boolean r2 = true;
        if (this.mDocType == e.l.b) goto L5;
    L10:
        boolean r5 = TextUtils.isEmpty(c.d().c(r4, getVersion()));
        if (this.isConnect == false) goto L13;
    L16:
        if (r2 == true) goto L18;
        return false;
    L18:
        return r5;
    L13:
        if (isConnected() == true) goto L16;
        r2 = false;
        goto L16
    L5:
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST) == true) goto L9;
        if (TextUtils.equals(this.mSource, SOURCE_SPACE_LIST_ICON) == false) goto L10;
    L9:
        return !isIconHasPerm(this.extra);
    }

    public void setETag(String r1) {
        this.mETag = r1;
    }

    public void setErrorBody(String r1) {
        this.errorBody = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setIcon(boolean r1) {
        this.isIcon = r1;
    }

    public void setIsConnect(Boolean r1) {
        this.isConnect = r1.booleanValue();
    }

    public void setResponseHeaders(Map<String, List<String>> r1) {
        this.responseHeaders = r1;
    }

    public void setStatusCode(int r1) {
        this.statusCode = r1;
    }

    public void setSubType(String r1) {
        this.subType = r1;
    }

    public ThumbGlideUrl(String r12, String r13, int r14, int r15, String r16, String r17, String r18, boolean r19, ImageView r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, "", r20);
    }

    public ThumbGlideUrl(String r13, String r14, int r15, int r16, String r17, String r18, String r19, boolean r20, String r21, ImageView r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, null);
    }

    public ThumbGlideUrl(String r2, String r3, int r4, int r5, String r6, String r7, String r8, boolean r9, String r10, ImageView r11, Headers r12) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        String r0 = "isValid";
    L6:
        if (r12 != null) goto L9;
        r12 = Headers.DEFAULT;
    L9:
        super(r0, r12);
        this.mOriginUrl = r2;
        this.mEncryptUrl = r3;
        this.mDocType = r4;
        this.mDecodeType = r5;
        this.mDecodeKey = r6;
        this.mDecodeNonce = r7;
        this.mSource = r8;
        this.version = r10;
        this.mImageViewWeakReference = new WeakReference(r11);
        this.isForceEncryption = r9;
        this.isValid = !TextUtils.isEmpty(getUrl());
        return;
    L5:
        r0 = r2;
        goto L6
    }
}
