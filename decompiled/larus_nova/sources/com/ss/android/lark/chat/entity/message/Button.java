package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010\u000f\u001a\u00020\fJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/Button;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "text", "", "buttonJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getButtonJumpUrl", "isItemSame", "", "diffable", "isContentSame", "isValid", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Button implements b<Button>, Serializable {
    private final String buttonJumpUrl;
    private final String text;

    public static /* synthetic */ Button copy$default(Button r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.buttonJumpUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.buttonJumpUrl;
    }

    public final Button copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "buttonJumpUrl");
        return new Button(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Button) == true) goto L8;
        return false;
    L8:
        Button r101 = (Button) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonJumpUrl, r101.buttonJumpUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.buttonJumpUrl.hashCode();
    }

    public String toString() {
        return "Button(text=" + this.text + ", buttonJumpUrl=" + this.buttonJumpUrl + ')';
    }

    public final boolean isValid() {
        boolean r100 = true;
        if (this.text.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L13:
        r100 = false;
    L14:
        if (r100 == true) goto L16;
        Log.e("Button.isValid", "text: " + this.text + ", buttonJumpUrl: " + this.buttonJumpUrl);
    L16:
        return r100;
    L8:
        if (this.buttonJumpUrl.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public final String getButtonJumpUrl() {
        return this.buttonJumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public boolean isContentSame(Button r100) {
        String r101 = this.text;
        if (r100 == null) goto L5;
        String r102 = r100.text;
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.buttonJumpUrl, r100.buttonJumpUrl) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Button) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Button) r100);
    }

    public boolean isItemSame(Button r100) {
        return Intrinsics.areEqual(this, r100);
    }

    public Button(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "buttonJumpUrl");
        this.text = r100;
        this.buttonJumpUrl = r101;
    }
}
