package com.ss.android.lark.forsetiutils.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "forseti_dynamic_config")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forsetiutils/config/ForsetiDynamicConfig;", "", "leftNavigationThreshold", "", "blackList", "", "", "<init>", "(ILjava/util/List;)V", "getLeftNavigationThreshold", "()I", "getBlackList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiDynamicConfig {

    @SerializedName("black_list")
    private final List<String> blackList;

    @SerializedName("left_navigation_threshold")
    private final int leftNavigationThreshold;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ForsetiDynamicConfig) == true) goto L8;
        return false;
    L8:
        ForsetiDynamicConfig r101 = (ForsetiDynamicConfig) r100;
        if (this.leftNavigationThreshold == r101.leftNavigationThreshold) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blackList, r101.blackList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.leftNavigationThreshold * 31;
        List<String> r101 = this.blackList;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ForsetiDynamicConfig(leftNavigationThreshold=" + this.leftNavigationThreshold + ", blackList=" + this.blackList + ')';
    }

    public ForsetiDynamicConfig() {
        List<String> r100 = CollectionsKt.emptyList();
        this.leftNavigationThreshold = MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME;
        this.blackList = r100;
    }

    public final List<String> a() {
        return this.blackList;
    }

    public final int b() {
        return this.leftNavigationThreshold;
    }
}
