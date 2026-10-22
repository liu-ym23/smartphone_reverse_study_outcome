package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J)\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003J{\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\b\u0010'\u001a\u00020\u0006H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R:\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lcom/ss/android/lark/chameleon/api/RouteConfig;", "Ljava/io/Serializable;", "hostConfig", "Lcom/ss/android/lark/chameleon/api/HostConfig;", "urlInterceptPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlInterceptBlackListSchemes", "microAppInterceptConfig", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chameleon/api/MicroAppInterceptConfig;", "Lkotlin/collections/HashMap;", "(Lcom/ss/android/lark/chameleon/api/HostConfig;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getHostConfig", "()Lcom/ss/android/lark/chameleon/api/HostConfig;", "setHostConfig", "(Lcom/ss/android/lark/chameleon/api/HostConfig;)V", "getMicroAppInterceptConfig", "()Ljava/util/HashMap;", "setMicroAppInterceptConfig", "(Ljava/util/HashMap;)V", "getUrlInterceptBlackListSchemes", "()Ljava/util/ArrayList;", "setUrlInterceptBlackListSchemes", "(Ljava/util/ArrayList;)V", "getUrlInterceptPaths", "setUrlInterceptPaths", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RouteConfig implements Serializable {
    private HostConfig hostConfig;
    private HashMap<String, MicroAppInterceptConfig> microAppInterceptConfig;
    private ArrayList<String> urlInterceptBlackListSchemes;
    private ArrayList<String> urlInterceptPaths;

    public RouteConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteConfig copy$default(RouteConfig r100, HostConfig r101, ArrayList r102, ArrayList r103, HashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.hostConfig;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.urlInterceptPaths;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.urlInterceptBlackListSchemes;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.microAppInterceptConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final HostConfig component1() {
        return this.hostConfig;
    }

    public final ArrayList<String> component2() {
        return this.urlInterceptPaths;
    }

    public final ArrayList<String> component3() {
        return this.urlInterceptBlackListSchemes;
    }

    public final HashMap<String, MicroAppInterceptConfig> component4() {
        return this.microAppInterceptConfig;
    }

    public final RouteConfig copy(HostConfig r100, ArrayList<String> r101, ArrayList<String> r102, HashMap<String, MicroAppInterceptConfig> r103) {
        return new RouteConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RouteConfig) == true) goto L8;
        return false;
    L8:
        RouteConfig r101 = (RouteConfig) r100;
        if (Intrinsics.areEqual(this.hostConfig, r101.hostConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlInterceptPaths, r101.urlInterceptPaths) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlInterceptBlackListSchemes, r101.urlInterceptBlackListSchemes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.microAppInterceptConfig, r101.microAppInterceptConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        HostConfig r100 = this.hostConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<String> r104 = this.urlInterceptPaths;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.urlInterceptBlackListSchemes;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, MicroAppInterceptConfig> r110 = this.microAppInterceptConfig;
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
        return "RouteConfig(hostConfig=" + this.hostConfig + ", urlInterceptPaths=" + this.urlInterceptPaths + ", urlInterceptBlackListSchemes=" + this.urlInterceptBlackListSchemes + ", microAppInterceptConfig=" + this.microAppInterceptConfig + ')';
    }

    public final HostConfig getHostConfig() {
        return this.hostConfig;
    }

    public final HashMap<String, MicroAppInterceptConfig> getMicroAppInterceptConfig() {
        return this.microAppInterceptConfig;
    }

    public final ArrayList<String> getUrlInterceptBlackListSchemes() {
        return this.urlInterceptBlackListSchemes;
    }

    public final ArrayList<String> getUrlInterceptPaths() {
        return this.urlInterceptPaths;
    }

    public final void setHostConfig(HostConfig r100) {
        this.hostConfig = r100;
    }

    public final void setMicroAppInterceptConfig(HashMap<String, MicroAppInterceptConfig> r100) {
        this.microAppInterceptConfig = r100;
    }

    public final void setUrlInterceptBlackListSchemes(ArrayList<String> r100) {
        this.urlInterceptBlackListSchemes = r100;
    }

    public final void setUrlInterceptPaths(ArrayList<String> r100) {
        this.urlInterceptPaths = r100;
    }

    public RouteConfig(HostConfig r100, ArrayList<String> r101, ArrayList<String> r102, HashMap<String, MicroAppInterceptConfig> r103) {
        this.hostConfig = r100;
        this.urlInterceptPaths = r101;
        this.urlInterceptBlackListSchemes = r102;
        this.microAppInterceptConfig = r103;
    }

    public /* synthetic */ RouteConfig(HostConfig r100, ArrayList r101, ArrayList r102, HashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
