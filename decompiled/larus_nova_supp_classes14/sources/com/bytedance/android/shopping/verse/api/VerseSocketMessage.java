package com.bytedance.android.shopping.verse.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001#B9\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003JL\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/VerseSocketMessage;", "", "", "component1", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "key", "path", "code", "msg", "data", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lcom/bytedance/android/shopping/verse/api/VerseSocketMessage;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getPath", "Ljava/lang/Integer;", "getCode", "getMsg", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "a", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerseSocketMessage {
    public static final a Companion = null;

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final Object data;

    @SerializedName("key")
    private final String key;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("path")
    private final String path;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ VerseSocketMessage copy$default(VerseSocketMessage r3, String r4, String r5, Integer r6, String r7, Object r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.key;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.path;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.code;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.msg;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.data;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.path;
    }

    public final Integer component3() {
        return this.code;
    }

    public final String component4() {
        return this.msg;
    }

    public final Object component5() {
        return this.data;
    }

    public final VerseSocketMessage copy(String r8, String r9, Integer r10, String r11, Object r12) {
        return new VerseSocketMessage(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof VerseSocketMessage) == false) goto L16;
        VerseSocketMessage r4 = (VerseSocketMessage) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.path, r4.path) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.code, r4.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.path;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.code;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.msg;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Object r13 = this.data;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "VerseSocketMessage(key=" + this.key + ", path=" + this.path + ", code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public final Integer getCode() {
        return this.code;
    }

    public final Object getData() {
        return this.data;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPath() {
        return this.path;
    }

    public VerseSocketMessage(String r1, String r2, Integer r3, String r4, Object r5) {
        this.key = r1;
        this.path = r2;
        this.code = r3;
        this.msg = r4;
        this.data = r5;
    }
}
