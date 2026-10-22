package com.larus.bmhome.chat.stop;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/stop/MobileInputStopSceneConfig;", "", "version", "", "globalEnabled", "", "sceneEnabled", "", "", "<init>", "(IZLjava/util/Map;)V", "getVersion", "()I", "getGlobalEnabled", "()Z", "getSceneEnabled", "()Ljava/util/Map;", "isSceneEnabled", "scene", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("global_enabled")
    private final boolean globalEnabled;

    @SerializedName("scene_enabled")
    private final Map<String, Boolean> sceneEnabled;

    @SerializedName("version")
    private final int version;

    public static final class a {
    }

    static {
    }

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.version == r101.version) goto L12;
        return false;
    L12:
        if (this.globalEnabled == r101.globalEnabled) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sceneEnabled, r101.sceneEnabled) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.version * 31;
        if (this.globalEnabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Map<String, Boolean> r103 = this.sceneEnabled;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MobileInputStopSceneConfig(version=" + this.version + ", globalEnabled=" + this.globalEnabled + ", sceneEnabled=" + this.sceneEnabled + ')';
    }

    public final boolean a() {
        return this.globalEnabled;
    }

    public final int b() {
        return this.version;
    }

    public c(Object r100) {
        this.version = 0;
        this.globalEnabled = false;
        this.sceneEnabled = null;
    }

    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.version > 0) goto L5;
        return false;
    L5:
        if (this.globalEnabled == false) goto L14;
        Map<String, Boolean> r101 = this.sceneEnabled;
        if (r101 == null) goto L9;
        boolean r102 = Intrinsics.areEqual(r101.get(r100), Boolean.TRUE);
    L10:
        if (r102 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L14:
        return false;
    }
}
