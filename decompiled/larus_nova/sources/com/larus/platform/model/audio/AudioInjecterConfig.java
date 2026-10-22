package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/AudioInjecterConfig;", "", "tosAccessKey", "", "tosSecretKey", "tosBucketName", "tosEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTosAccessKey", "()Ljava/lang/String;", "getTosSecretKey", "getTosBucketName", "getTosEndpoint", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioInjecterConfig {

    @SerializedName("tos_access_key")
    private final String tosAccessKey;

    @SerializedName("tos_bucket_name")
    private final String tosBucketName;

    @SerializedName("tos_endpoint")
    private final String tosEndpoint;

    @SerializedName("tos_secret_key")
    private final String tosSecretKey;

    public AudioInjecterConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AudioInjecterConfig copy$default(AudioInjecterConfig r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.tosAccessKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.tosSecretKey;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.tosBucketName;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.tosEndpoint;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.tosAccessKey;
    }

    public final String component2() {
        return this.tosSecretKey;
    }

    public final String component3() {
        return this.tosBucketName;
    }

    public final String component4() {
        return this.tosEndpoint;
    }

    public final AudioInjecterConfig copy(String r100, String r101, String r102, String r103) {
        return new AudioInjecterConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioInjecterConfig) == true) goto L8;
        return false;
    L8:
        AudioInjecterConfig r101 = (AudioInjecterConfig) r100;
        if (Intrinsics.areEqual(this.tosAccessKey, r101.tosAccessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tosSecretKey, r101.tosSecretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tosBucketName, r101.tosBucketName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tosEndpoint, r101.tosEndpoint) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.tosAccessKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tosSecretKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tosBucketName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tosEndpoint;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AudioInjecterConfig(tosAccessKey=" + this.tosAccessKey + ", tosSecretKey=" + this.tosSecretKey + ", tosBucketName=" + this.tosBucketName + ", tosEndpoint=" + this.tosEndpoint + ')';
    }

    public final String getTosAccessKey() {
        return this.tosAccessKey;
    }

    public final String getTosBucketName() {
        return this.tosBucketName;
    }

    public final String getTosEndpoint() {
        return this.tosEndpoint;
    }

    public final String getTosSecretKey() {
        return this.tosSecretKey;
    }

    public AudioInjecterConfig(String r100, String r101, String r102, String r103) {
        this.tosAccessKey = r100;
        this.tosSecretKey = r101;
        this.tosBucketName = r102;
        this.tosEndpoint = r103;
    }

    public /* synthetic */ AudioInjecterConfig(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
