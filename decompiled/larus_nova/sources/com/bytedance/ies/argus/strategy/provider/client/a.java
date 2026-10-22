package com.bytedance.ies.argus.strategy.provider.client;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001:\u0003\u0005\u0011\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/a;", "", "", "token", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/strategy/provider/client/a$c;", "config", "Lcom/bytedance/ies/argus/strategy/provider/client/a$c;", "getConfig", "()Lcom/bytedance/ies/argus/strategy/provider/client/a$c;", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "b", "c", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("conf")
    private final c config;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("token")
    private final String token;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.strategy.provider.client.a$a, reason: collision with other inner class name */
    public static final class C3519a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f246205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f246206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f246207c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f246205a == r101.f246205a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f246206b, r101.f246206b) == true) goto L15;
            return false;
        L15:
            if (this.f246207c == r101.f246207c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f246205a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f246206b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return ((r101 + r103) * 31) + this.f246207c;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(enable=" + this.f246205a + ", secToken=" + this.f246206b + ", maxUploadFileSize=" + this.f246207c + ')';
        }

        public b(boolean r100, String r101, int r102) {
            this.f246205a = r100;
            this.f246206b = r101;
            this.f246207c = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/a$c;", "", "", "maxSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE)
        private final Integer maxSize;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.maxSize, ((c) r100).maxSize) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.maxSize;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SecLinkWsMsgConfigModel(maxSize=" + this.maxSize + ')';
        }

        public c() {
            this.maxSize = null;
        }

        public final Integer a() {
            return this.maxSize;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.config;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.status;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusWebDomMonitorUserSecTokenRawServerModel(token=" + this.token + ", config=" + this.config + ", status=" + this.status + ')';
    }

    public final b b() {
        String r100 = this.token;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L16;
        Integer r103 = this.status;
        if (r103 == null) goto L16;
        if (r103.intValue() != 0) goto L16;
        r101 = true;
    L16:
        c r104 = this.config;
        int r105 = 25;
        if (r104 == null) goto L21;
        Integer r106 = r104.a();
        if (r106 == null) goto L21;
        int r107 = r106.intValue();
    L22:
        if (r107 <= 0) goto L26;
        r105 = r107;
    L26:
        if (r101 == false) goto L28;
        String r108 = this.token;
    L30:
        return new b(r101, r108, r105);
    L28:
        r108 = null;
    L21:
        r107 = 25;
        goto L22
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public a() {
        this.token = null;
        this.config = null;
        this.status = null;
    }

    public final String a() {
        return this.token;
    }
}
