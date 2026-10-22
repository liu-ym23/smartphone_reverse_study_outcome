package com.larus.mirabridge.api.bean;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class PluginLoadBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f359294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f359295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<zk9.a> f359296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PluginLoadTime f359297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PluginLoadType f359298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f359299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f359300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f359301h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/mirabridge/api/bean/PluginLoadBuilder$PluginLoadTime;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "IMMEDIATE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PluginLoadTime extends Enum<PluginLoadTime> {
        public static final PluginLoadTime IMMEDIATE = null;
        public static final PluginLoadTime NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PluginLoadTime[] f359302a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359303b = null;

        public static EnumEntries<PluginLoadTime> getEntries() {
            return f359303b;
        }

        static {
            PluginLoadTime r100 = new PluginLoadTime(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            PluginLoadTime r101 = new PluginLoadTime("IMMEDIATE", 1);
            IMMEDIATE = r101;
            PluginLoadTime[] r102 = {r100, r101};
            f359302a = r102;
            f359303b = EnumEntriesKt.enumEntries(r102);
        }

        public static PluginLoadTime[] values() {
            return (PluginLoadTime[]) f359302a.clone();
        }

        public static PluginLoadTime valueOf(String r100) {
            return (PluginLoadTime) r27.a.a(PluginLoadTime.class, r100);
        }

        public PluginLoadTime(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/mirabridge/api/bean/PluginLoadBuilder$PluginLoadType;", "", "<init>", "(Ljava/lang/String;I)V", BridgeSyncType.ASYNC, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PluginLoadType extends Enum<PluginLoadType> {
        public static final PluginLoadType ASYNC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PluginLoadType[] f359304a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359305b = null;

        public static EnumEntries<PluginLoadType> getEntries() {
            return f359305b;
        }

        static {
            PluginLoadType r100 = new PluginLoadType();
            ASYNC = r100;
            PluginLoadType[] r101 = {r100};
            f359304a = r101;
            f359305b = EnumEntriesKt.enumEntries(r101);
        }

        public PluginLoadType() {
            super(BridgeSyncType.ASYNC, 0);
        }

        public static PluginLoadType[] values() {
            return (PluginLoadType[]) f359304a.clone();
        }

        public static PluginLoadType valueOf(String r100) {
            return (PluginLoadType) r27.a.a(PluginLoadType.class, r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f359306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f359307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<zk9.a> f359308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final PluginLoadTime f359309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PluginLoadType f359310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f359311f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f359312g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f359313h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f359314i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f359306a, r101.f359306a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359307b, r101.f359307b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f359308c, r101.f359308c) == true) goto L18;
            return false;
        L18:
            if (this.f359309d == r101.f359309d) goto L21;
            return false;
        L21:
            if (this.f359310e == r101.f359310e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f359311f, r101.f359311f) == true) goto L27;
            return false;
        L27:
            if (this.f359312g == r101.f359312g) goto L30;
            return false;
        L30:
            if (this.f359313h == r101.f359313h) goto L33;
            return false;
        L33:
            if (this.f359314i == r101.f359314i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f359306a.hashCode() * 31;
            Class<?> r101 = this.f359307b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            WeakReference<zk9.a> r105 = this.f359308c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (((((r104 + r106) * 31) + this.f359309d.hashCode()) * 31) + this.f359310e.hashCode()) * 31;
            b r108 = this.f359311f;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            int r109 = (r107 + r102) * 31;
            int r110 = 1231;
            if (this.f359312g == false) goto L17;
            int r111 = 1231;
        L18:
            long r112 = this.f359313h;
            int r113 = (((r109 + r111) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            if (this.f359314i == true) goto L23;
            r110 = 1237;
        L23:
            return r113 + r110;
        L17:
            r111 = 1237;
            goto L18
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PluginLoadConfig(packageName=" + this.f359306a + ", serviceInterface=" + this.f359307b + ", pluginLoadingUI=" + this.f359308c + ", pluginLoadTime=" + this.f359309d + ", pluginLoadType=" + this.f359310e + ", pluginLoadResult=" + this.f359311f + ", downloadNewPlugin=" + this.f359312g + ", waitTime=" + this.f359313h + ", onlyDownload=" + this.f359314i + ')';
        }

        public c(String r100, Class r101, WeakReference r102, PluginLoadTime r103, PluginLoadType r104, b r105, long r106, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            Intrinsics.checkNotNullParameter(r103, "pluginLoadTime");
            Intrinsics.checkNotNullParameter(r104, "pluginLoadType");
            this.f359306a = r100;
            this.f359307b = r101;
            this.f359308c = r102;
            this.f359309d = r103;
            this.f359310e = r104;
            this.f359311f = r105;
            this.f359312g = false;
            this.f359313h = r106;
            this.f359314i = r110;
        }
    }

    static {
    }

    public final c a() {
        boolean r100 = true;
        if ((!StringsKt.isBlank(this.f359294a)) == false) goto L14;
        Class<?> r101 = this.f359295b;
        if (r101 != null) goto L8;
        r100 = false;
    L8:
        if (r100 == false) goto L12;
        return new c(this.f359294a, r101, this.f359296c, this.f359297d, this.f359298e, this.f359299f, this.f359300g, this.f359301h);
    L12:
        throw new IllegalArgumentException("Service interface must be set".toString());
    L14:
        throw new IllegalArgumentException("Package name cannot be empty".toString());
    }

    public PluginLoadBuilder() {
        this.f359294a = "";
        this.f359297d = PluginLoadTime.IMMEDIATE;
        this.f359298e = PluginLoadType.ASYNC;
        this.f359300g = -1;
    }
}
