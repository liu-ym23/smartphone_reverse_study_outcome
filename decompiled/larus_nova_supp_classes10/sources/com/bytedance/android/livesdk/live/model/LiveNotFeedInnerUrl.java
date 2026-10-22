package com.bytedance.android.livesdk.live.model;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.jd0;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/LiveNotFeedInnerUrl;", "", "", "isValid", "", "component1", "component2", "key", "path", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveNotFeedInnerUrl {
    public static final a Companion = null;

    @SerializedName("key")
    private final String key;

    @SerializedName("path")
    private final String path;

    public static final class a {
        public a() {
        }

        public static LiveNotFeedInnerUrl a(String r13, String r14) {
            List r0 = (List) jd0.a.getValue();
            List r1 = r0;
            boolean r2 = true;
            if (r1 != null) goto L5;
        L8:
            boolean r3 = true;
        L10:
            if (r3 == true) goto L61;
            if (r13 != null) goto L13;
        L16:
            boolean r4 = true;
        L17:
            if (r4 == true) goto L61;
            if (r14 != null) goto L20;
        L23:
            if (r2 == true) goto L61;
            String r15 = r13 + "_" + r14;
            Iterator r16 = r0.iterator();
            LiveNotFeedInnerUrl r5 = null;
        L27:
            if (r16.hasNext() == false) goto L60;
            LiveNotFeedInnerUrl r6 = (LiveNotFeedInnerUrl) r16.next();
            if (r6 == null) goto L31;
            String r7 = r6.getKey();
        L33:
            if (TextUtils.isEmpty(r7) == true) goto L27;
            if (r6 == null) goto L37;
            String r8 = r6.getKey();
        L39:
            if (TextUtils.equals(r8, r15) == true) goto L40;
            if (r6 == null) goto L43;
            String r9 = r6.getKey();
        L45:
            if (r9 != null) goto L47;
        L51:
            if (r6 == null) goto L53;
            String r10 = r6.getKey();
        L54:
            if (r10 == null) goto L27;
            if (StringsKt.endsWith$default(r6.getKey(), "*", false, 2, null) == false) goto L27;
            if (StringsKt.startsWith$default(r15, StringsKt.replace$default(r6.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L27;
        L59:
            r5 = r6;
            goto L27
        L53:
            r10 = null;
            goto L54
        L47:
            if (StringsKt.startsWith$default(r6.getKey(), "*", false, 2, null) == false) goto L51;
            if (StringsKt.endsWith$default(r15, StringsKt.replace$default(r6.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L51;
        L43:
            r9 = null;
            goto L45
        L40:
            return r6;
        L37:
            r8 = null;
            goto L39
        L31:
            r7 = null;
            goto L33
        L60:
            return r5;
        L20:
            if (r14.length() == 0) goto L23;
            r2 = false;
            goto L23
        L13:
            if (r13.length() == 0) goto L16;
            r4 = false;
        L61:
            return null;
        L5:
            if (r1.isEmpty() == true) goto L8;
            r3 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LiveNotFeedInnerUrl copy$default(LiveNotFeedInnerUrl r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.path;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.path;
    }

    public final LiveNotFeedInnerUrl copy(String r2, String r3) {
        return new LiveNotFeedInnerUrl(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveNotFeedInnerUrl) == false) goto L10;
        LiveNotFeedInnerUrl r4 = (LiveNotFeedInnerUrl) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.path, r4.path) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
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
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveNotFeedInnerUrl(key=" + this.key + ", path=" + this.path + ")";
    }

    public final boolean isValid() {
        int r0 = ln1.a.a.a;
        return ln1.a.a.a(this.path);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPath() {
        return this.path;
    }

    public LiveNotFeedInnerUrl(String r1, String r2) {
        this.key = r1;
        this.path = r2;
    }
}
