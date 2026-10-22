package com.bytedance.timonbase.network;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/network/b;", "", "Lcom/bytedance/timonbase/network/b$a;", "config", "Lcom/bytedance/timonbase/network/b$a;", "b", "()Lcom/bytedance/timonbase/network/b$a;", "", "validMark", "Ljava/lang/String;", "getValidMark", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("custom_settings")
    private final a config;

    @SerializedName("valid_mark")
    private final String validMark;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/network/b$a;", "", "", "timonConfig", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "rulerEngineConfig", "b", "sensitivePathConfig", "c", "timonEncryptionList", "e", "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("rule_engine_strategy_sets_v2")
        private final String rulerEngineConfig;

        @SerializedName("sensitive_path_config")
        private final String sensitivePathConfig;

        @SerializedName("sdk_kit_config")
        private final String timonConfig;

        @SerializedName("timon_encryption_list")
        private final String timonEncryptionList;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.timonConfig, r101.timonConfig) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.rulerEngineConfig, r101.rulerEngineConfig) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.sensitivePathConfig, r101.sensitivePathConfig) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.timonEncryptionList, r101.timonEncryptionList) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.timonConfig;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.rulerEngineConfig;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.sensitivePathConfig;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.timonEncryptionList;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(timonConfig=" + this.timonConfig + ", rulerEngineConfig=" + this.rulerEngineConfig + ", sensitivePathConfig=" + this.sensitivePathConfig + ", timonEncryptionList=" + this.timonEncryptionList + ")";
        }

        public final String b() {
            return this.rulerEngineConfig;
        }

        public final String c() {
            return this.sensitivePathConfig;
        }

        public final String d() {
            return this.timonConfig;
        }

        public final String e() {
            return this.timonEncryptionList;
        }

        public /* synthetic */ a(int r100) {
            this("", "", "", "");
        }

        public a(String r100, String r101, String r102, String r103) {
            this.timonConfig = r100;
            this.rulerEngineConfig = r101;
            this.sensitivePathConfig = r102;
            this.timonEncryptionList = r103;
        }

        public static a a(a r100, String r101, String r102, String r103, String r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.timonConfig;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.rulerEngineConfig;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.sensitivePathConfig;
        L12:
            if ((r105 & 8) == 0) goto L14;
            r104 = r100.timonEncryptionList;
        L14:
            r100.getClass();
            return new a(r101, r102, r103, r104);
        }
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.validMark, r101.validMark) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a r100 = this.config;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.validMark;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Settings(config=" + this.config + ", validMark=" + this.validMark + ")";
    }

    public final a b() {
        return this.config;
    }

    public /* synthetic */ b(int r100) {
        this(new a(0), null);
    }

    public b(a r100, String r101) {
        this.config = r100;
        this.validMark = r101;
    }

    public static b a(b r100, a r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.config;
    L6:
        if ((r102 & 2) == 0) goto L8;
        String r103 = r100.validMark;
    L10:
        return new b(r101, r103);
    L8:
        r103 = null;
        goto L10
    }
}
