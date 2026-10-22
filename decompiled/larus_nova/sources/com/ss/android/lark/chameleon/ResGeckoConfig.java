package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0000J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J%\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J)\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003Jc\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR6\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/ResGeckoConfig;", "Ljava/io/Serializable;", "enable", "", "accessKey", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "channels", "<init>", "(ZLjava/util/HashMap;Ljava/util/HashMap;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getAccessKey", "()Ljava/util/HashMap;", "setAccessKey", "(Ljava/util/HashMap;)V", "getChannels", "setChannels", "copy", "toString", "component1", "component2", "component3", "equals", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResGeckoConfig implements Serializable {
    private HashMap<String, String> accessKey;
    private HashMap<String, String> channels;
    private boolean enable;

    public ResGeckoConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResGeckoConfig copy$default(ResGeckoConfig r100, boolean r101, HashMap r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.accessKey;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.channels;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final HashMap<String, String> component2() {
        return this.accessKey;
    }

    public final HashMap<String, String> component3() {
        return this.channels;
    }

    public final ResGeckoConfig copy(boolean r100, HashMap<String, String> r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "accessKey");
        return new ResGeckoConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResGeckoConfig) == true) goto L8;
        return false;
    L8:
        ResGeckoConfig r101 = (ResGeckoConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.accessKey, r101.accessKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.channels, r101.channels) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.accessKey.hashCode()) * 31;
        HashMap<String, String> r102 = this.channels;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final ResGeckoConfig copy() {
        boolean r100 = this.enable;
        HashMap r101 = new HashMap(this.accessKey);
        HashMap<String, String> r102 = this.channels;
        if (r102 == null) goto L5;
        HashMap r103 = new HashMap(r102);
    L7:
        return new ResGeckoConfig(r100, r101, r103);
    L5:
        r103 = null;
        goto L7
    }

    public String toString() {
        return "ResGeckoConfig(enable=" + this.enable + ", accessKey=" + this.accessKey + ", channels=" + this.channels + ')';
    }

    public final HashMap<String, String> getAccessKey() {
        return this.accessKey;
    }

    public final HashMap<String, String> getChannels() {
        return this.channels;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setAccessKey(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.accessKey = r100;
    }

    public final void setChannels(HashMap<String, String> r100) {
        this.channels = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public ResGeckoConfig(boolean r100, HashMap<String, String> r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "accessKey");
        this.enable = r100;
        this.accessKey = r101;
        this.channels = r102;
    }

    public /* synthetic */ ResGeckoConfig(boolean r100, HashMap r101, HashMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("release", "6ac1e1277e39294dbc3844f302d9b66c"), TuplesKt.to("debug", "80f3d6f8eb94aad0dc181ca3a881adcc"), TuplesKt.to("boe", "285fded323223388f4aedf68b975d216")});
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
