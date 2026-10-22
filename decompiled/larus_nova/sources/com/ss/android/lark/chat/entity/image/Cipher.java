package com.ss.android.lark.chat.entity.image;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/image/Cipher;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "secret", "", "nonce", "additionalData", "<init>", "([B[B[B)V", "getSecret", "()[B", "getNonce", "getAdditionalData", "isItemSame", "", "diffable", "isContentSame", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Cipher implements Serializable, b<Cipher> {
    public static final a Companion = null;

    @SerializedName("additionalData")
    private final byte[] additionalData;

    @SerializedName("nonce")
    private final byte[] nonce;

    @SerializedName("secret")
    private final byte[] secret;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final byte[] getAdditionalData() {
        return this.additionalData;
    }

    public final byte[] getNonce() {
        return this.nonce;
    }

    public final byte[] getSecret() {
        return this.secret;
    }

    public boolean isContentSame(Cipher r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<Cipher> r101 = Cipher.class;
    L10:
        if (Intrinsics.areEqual(Cipher.class, r101) == true) goto L13;
        return false;
    L13:
        if (Arrays.equals(this.secret, r100.secret) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.nonce, r100.nonce) == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.additionalData, r100.additionalData) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Cipher) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Cipher) r100);
    }

    public boolean isItemSame(Cipher r100) {
        return isContentSame(r100);
    }

    public Cipher(byte[] r100, byte[] r101, byte[] r102) {
        this.secret = r100;
        this.nonce = r101;
        this.additionalData = r102;
    }
}
