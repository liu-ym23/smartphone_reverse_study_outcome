package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "Ljava/io/Serializable;", "scene", "", "policy", "Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "timeout", "", "templateUrl", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/PreloadPolicy;JLjava/lang/String;)V", "getPolicy", "()Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "setPolicy", "(Lcom/ss/android/lark/chameleon/api/PreloadPolicy;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getTemplateUrl", "setTemplateUrl", "getTimeout", "()J", "setTimeout", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreloadConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_TIMEOUT = 60000;
    private PreloadPolicy policy;
    private String scene;
    private String templateUrl;
    private long timeout;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadConfig$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PreloadConfig() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ PreloadConfig copy$default(PreloadConfig r100, String r101, PreloadPolicy r102, long r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.policy;
    L8:
        PreloadPolicy r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.timeout;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.templateUrl;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.scene;
    }

    public final PreloadPolicy component2() {
        return this.policy;
    }

    public final long component3() {
        return this.timeout;
    }

    public final String component4() {
        return this.templateUrl;
    }

    public final PreloadConfig copy(String r100, PreloadPolicy r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "policy");
        Intrinsics.checkNotNullParameter(r111, "templateUrl");
        return new PreloadConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreloadConfig) == true) goto L8;
        return false;
    L8:
        PreloadConfig r101 = (PreloadConfig) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (this.policy == r101.policy) goto L15;
        return false;
    L15:
        if (this.timeout == r101.timeout) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.scene.hashCode() * 31) + this.policy.hashCode()) * 31;
        long r101 = this.timeout;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.templateUrl.hashCode();
    }

    public String toString() {
        return "PreloadConfig(scene=" + this.scene + ", policy=" + this.policy + ", templateUrl='" + this.templateUrl + "', timeout=" + this.timeout + ')';
    }

    public final PreloadPolicy getPolicy() {
        return this.policy;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final void setPolicy(PreloadPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.policy = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setTemplateUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateUrl = r100;
    }

    public final void setTimeout(long r100) {
        this.timeout = r100;
    }

    public PreloadConfig(String r100, PreloadPolicy r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "policy");
        Intrinsics.checkNotNullParameter(r103, "templateUrl");
        this.scene = r100;
        this.policy = r101;
        this.timeout = r102;
        this.templateUrl = r103;
    }

    public /* synthetic */ PreloadConfig(String r100, PreloadPolicy r101, long r102, String r103, int r104, DefaultConstructorMarker r110) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "DEFAULT";
    L6:
        if ((r104 & 2) == 0) goto L8;
        r101 = PreloadPolicy.NO_PRELOAD;
    L8:
        PreloadPolicy r111 = r101;
        if ((r104 & 4) == 0) goto L11;
        r102 = 60000;
    L11:
        long r105 = r102;
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        String r106 = r100;
        this(r106, r111, r105, r103);
    }
}
