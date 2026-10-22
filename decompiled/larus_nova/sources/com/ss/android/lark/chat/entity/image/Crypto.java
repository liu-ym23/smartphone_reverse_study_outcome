package com.ss.android.lark.chat.entity.image;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/image/Crypto;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "type", "", "cipher", "Lcom/ss/android/lark/chat/entity/image/Cipher;", "<init>", "(ILcom/ss/android/lark/chat/entity/image/Cipher;)V", "getType", "()I", "getCipher", "()Lcom/ss/android/lark/chat/entity/image/Cipher;", "isItemSame", "", "diffable", "isContentSame", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Crypto implements Serializable, b<Crypto> {
    public static final a Companion = null;

    @SerializedName("cipher")
    private final Cipher cipher;

    @SerializedName("type")
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public final int getType() {
        return this.type;
    }

    public boolean isContentSame(Crypto r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<Crypto> r101 = Crypto.class;
    L10:
        if (Intrinsics.areEqual(Crypto.class, r101) == true) goto L13;
        return false;
    L13:
        if (this.type == r100.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cipher, r100.cipher) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Crypto) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Crypto) r100);
    }

    public boolean isItemSame(Crypto r100) {
        return isContentSame(r100);
    }

    public Crypto(int r100, Cipher r101) {
        this.type = r100;
        this.cipher = r101;
    }
}
