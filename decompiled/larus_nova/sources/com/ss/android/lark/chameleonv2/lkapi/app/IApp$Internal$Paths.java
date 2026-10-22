package com.ss.android.lark.chameleonv2.lkapi.app;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Paths;", "Lcom/bytedance/ee/util/io/NonProguard;", ChameleonAssertResManager.ASSET_FOLDER, "", "iron", EffectConfiguration.KEY_PROVIDER_NAME, "log", "userData", "webContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssets", "()Ljava/lang/String;", "getIron", "getLibrary", "getLog", "getUserData", "getWebContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IApp$Internal$Paths implements NonProguard {
    private final String assets;
    private final String iron;
    private final String library;
    private final String log;
    private final String userData;
    private final String webContent;

    public static /* synthetic */ IApp$Internal$Paths copy$default(IApp$Internal$Paths r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.assets;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.iron;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.library;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.log;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.userData;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.webContent;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.assets;
    }

    public final String component2() {
        return this.iron;
    }

    public final String component3() {
        return this.library;
    }

    public final String component4() {
        return this.log;
    }

    public final String component5() {
        return this.userData;
    }

    public final String component6() {
        return this.webContent;
    }

    public final IApp$Internal$Paths copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r110, "iron");
        Intrinsics.checkNotNullParameter(r111, EffectConfiguration.KEY_PROVIDER_NAME);
        Intrinsics.checkNotNullParameter(r112, "log");
        Intrinsics.checkNotNullParameter(r113, "userData");
        Intrinsics.checkNotNullParameter(r114, "webContent");
        return new IApp$Internal$Paths(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IApp$Internal$Paths) == true) goto L8;
        return false;
    L8:
        IApp$Internal$Paths r101 = (IApp$Internal$Paths) r100;
        if (Intrinsics.areEqual(this.assets, r101.assets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iron, r101.iron) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.library, r101.library) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.log, r101.log) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userData, r101.userData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.webContent, r101.webContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.assets.hashCode() * 31) + this.iron.hashCode()) * 31) + this.library.hashCode()) * 31) + this.log.hashCode()) * 31) + this.userData.hashCode()) * 31) + this.webContent.hashCode();
    }

    public String toString() {
        return "Paths(assets=" + this.assets + ", iron=" + this.iron + ", library=" + this.library + ", log=" + this.log + ", userData=" + this.userData + ", webContent=" + this.webContent + ')';
    }

    public final String getAssets() {
        return this.assets;
    }

    public final String getIron() {
        return this.iron;
    }

    public final String getLibrary() {
        return this.library;
    }

    public final String getLog() {
        return this.log;
    }

    public final String getUserData() {
        return this.userData;
    }

    public final String getWebContent() {
        return this.webContent;
    }

    public IApp$Internal$Paths(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r101, "iron");
        Intrinsics.checkNotNullParameter(r102, EffectConfiguration.KEY_PROVIDER_NAME);
        Intrinsics.checkNotNullParameter(r103, "log");
        Intrinsics.checkNotNullParameter(r104, "userData");
        Intrinsics.checkNotNullParameter(r105, "webContent");
        this.assets = r100;
        this.iron = r101;
        this.library = r102;
        this.log = r103;
        this.userData = r104;
        this.webContent = r105;
    }
}
