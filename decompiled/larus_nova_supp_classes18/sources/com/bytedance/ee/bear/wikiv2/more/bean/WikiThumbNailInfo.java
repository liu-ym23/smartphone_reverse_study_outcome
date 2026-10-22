package com.bytedance.ee.bear.wikiv2.more.bean;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/more/bean/WikiThumbNailInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "cipherType", "", "getCipherType", "()I", "setCipherType", "(I)V", "decryptKey", "", "getDecryptKey", "()Ljava/lang/String;", "setDecryptKey", "(Ljava/lang/String;)V", "nonce", "getNonce", "setNonce", "permitted", "", "getPermitted", "()Z", "setPermitted", "(Z)V", ResourceData.KEY_URL, "getUrl", "setUrl", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiThumbNailInfo implements NonProguard {

    @SerializedName("cipher_type")
    private int cipherType;

    @SerializedName("decrypt_key")
    private String decryptKey;
    private String nonce;
    private boolean permitted;
    private String url;

    public WikiThumbNailInfo() {
        this.decryptKey = "";
        this.nonce = "";
        this.permitted = true;
        this.url = "";
    }

    public final int getCipherType() {
        return this.cipherType;
    }

    public final String getDecryptKey() {
        return this.decryptKey;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final boolean getPermitted() {
        return this.permitted;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCipherType(int r1) {
        this.cipherType = r1;
    }

    public final void setDecryptKey(String r1) {
        this.decryptKey = r1;
    }

    public final void setNonce(String r1) {
        this.nonce = r1;
    }

    public final void setPermitted(boolean r1) {
        this.permitted = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }
}
