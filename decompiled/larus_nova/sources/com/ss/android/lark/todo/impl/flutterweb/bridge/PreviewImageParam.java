package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/PreviewImageParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "Lcom/ss/android/lark/todo/impl/flutterweb/bridge/PreviewImageConfig;", "currentIndex", "", "<init>", "(Ljava/util/List;I)V", "getConfigs", "()Ljava/util/List;", "getCurrentIndex", "()I", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewImageParam implements NonProguard {
    private final List<PreviewImageConfig> configs;
    private final int currentIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewImageParam copy$default(PreviewImageParam r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.configs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.currentIndex;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<PreviewImageConfig> component1() {
        return this.configs;
    }

    public final int component2() {
        return this.currentIndex;
    }

    public final PreviewImageParam copy(List<PreviewImageConfig> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        return new PreviewImageParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewImageParam) == true) goto L8;
        return false;
    L8:
        PreviewImageParam r101 = (PreviewImageParam) r100;
        if (Intrinsics.areEqual(this.configs, r101.configs) == true) goto L12;
        return false;
    L12:
        if (this.currentIndex == r101.currentIndex) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.configs.hashCode() * 31) + this.currentIndex;
    }

    public String toString() {
        return "PreviewImageParam(configs='" + this.configs + "', currentIndex='" + this.currentIndex + "')";
    }

    public final List<PreviewImageConfig> getConfigs() {
        return this.configs;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public PreviewImageParam(List<PreviewImageConfig> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        this.configs = r100;
        this.currentIndex = r101;
    }
}
