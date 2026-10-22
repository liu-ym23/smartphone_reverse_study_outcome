package com.ss.android.lark.storage.kv.repo;

import androidx.webkit.WebViewFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class KVRepoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f441065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends g> f441066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f441067c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/storage/kv/repo/KVRepoConfig$Mode;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "getMode", "()I", "SINGLE_PROCESS", WebViewFeature.MULTI_PROCESS, "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode MULTI_PROCESS = null;
        public static final Mode SINGLE_PROCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f441068a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441069b = null;
        private final int mode;

        public static EnumEntries<Mode> getEntries() {
            return f441069b;
        }

        static {
            Mode r100 = new Mode("SINGLE_PROCESS", 0, 1);
            SINGLE_PROCESS = r100;
            Mode r101 = new Mode(WebViewFeature.MULTI_PROCESS, 1, 2);
            MULTI_PROCESS = r101;
            Mode[] r102 = {r100, r101};
            f441068a = r102;
            f441069b = EnumEntriesKt.enumEntries(r102);
        }

        public static Mode[] values() {
            return (Mode[]) f441068a.clone();
        }

        public final int getMode() {
            return this.mode;
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KVRepoConfig) == true) goto L8;
        return false;
    L8:
        KVRepoConfig r101 = (KVRepoConfig) r100;
        if (this.f441065a == r101.f441065a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441066b, r101.f441066b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441067c, r101.f441067c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f441065a.hashCode() * 31) + this.f441066b.hashCode()) * 31) + this.f441067c.hashCode();
    }

    public final String toString() {
        return "KVRepoConfig(mode=" + this.f441065a + ", dataProxyProviders=" + this.f441066b + ", repoFactory=" + this.f441067c + ')';
    }

    public final void a(List<? extends g> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f441066b = r100;
    }

    public KVRepoConfig(Mode r100, List<? extends g> r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "dataProxyProviders");
        Intrinsics.checkNotNullParameter(r102, "repoFactory");
        this.f441065a = r100;
        this.f441066b = r101;
        this.f441067c = r102;
    }
}
