package com.bytedance.locallife.cube.api.model;

import android.net.Uri;
import com.bytedance.forest.model.j;
import com.bytedance.locallife.biz.base.cube.l;
import com.bytedance.locallife.cube.c;
import com.bytedance.locallife.cube.d;
import com.bytedance.mt.protector.impl.UriProtector;
import fp6.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/GeckoInfo;", "", "channel", "", "bundle", "(Ljava/lang/String;Ljava/lang/String;)V", "getBundle", "()Ljava/lang/String;", "getChannel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GeckoInfo {
    public static final Companion Companion = null;
    private final String bundle;
    private final String channel;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/GeckoInfo$Companion;", "", "Landroid/net/Uri;", "uri", "", "getLynxChannelByQuery", "getLynxBundleByQuery", "Lcom/bytedance/forest/model/j;", "parseGeckoModel", "url", "Lcom/bytedance/locallife/cube/api/model/GeckoInfo;", "parse", "parseUri", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final String getLynxBundleByQuery(Uri r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r100, "bundle"));     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r102) == false) goto L10;
            r102 = null;
        L10:
            return (String) r102;
        L4:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        private final String getLynxChannelByQuery(Uri r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r100, "channel"));     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r102) == false) goto L10;
            r102 = null;
        L10:
            return (String) r102;
        L4:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        private final j parseGeckoModel(Uri r100) {
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
            k r103 = c.e();     // Catch: Throwable -> L9
            if (r103 == null) goto L6;
            j r104 = ((l) r103).d(r100);     // Catch: Throwable -> L9
        L7:
            Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r105) == true) goto L16;
            r101 = r105;
        L16:
            return (j) r101;
        L6:
            r104 = null;
        L9:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public final GeckoInfo parse(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            Object r102 = null;
            if (r101 == false) goto L21;
            return null;
        L21:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
            Object r104 = Result.m9449constructorimpl(GeckoInfo.Companion.parseUri(UriProtector.parse(r100)));     // Catch: Throwable -> L13
        L15:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 != null) goto L18;
            r102 = r104;
        L20:
            return (GeckoInfo) r102;
        L18:
            fp6.j r106 = d.f257194a;
            d.c("parse GeckoInfo failed lynxSchema:" + r100, r105);
        L13:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L4:
            if (StringsKt.isBlank(r100) == true) goto L7;
            r101 = false;
            goto L8
        }

        public final GeckoInfo parseUri(Uri r100) {
            Object r101 = null;
            if (r100 != null) goto L45;
            return null;
        L45:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L37
            Companion r103 = GeckoInfo.Companion;     // Catch: Throwable -> L37
            String r104 = r103.getLynxChannelByQuery(r100);     // Catch: Throwable -> L37
            String r105 = r103.getLynxBundleByQuery(r100);     // Catch: Throwable -> L37
            boolean r106 = true;
            if (r104 != null) goto L8;
        L11:
            boolean r107 = true;
        L12:
            if (r107 == false) goto L17;
            j r108 = r103.parseGeckoModel(r100);     // Catch: Throwable -> L37
            if (r108 == null) goto L16;
            String r109 = r108.f244349b;     // Catch: Throwable -> L37
        L18:
            if (r105 != null) goto L20;
        L23:
            if (r106 == false) goto L31;
            if (r108 != null) goto L26;
            r108 = r103.parseGeckoModel(r100);     // Catch: Throwable -> L37
        L26:
            if (r108 == null) goto L28;
            r105 = r108.f244350c;     // Catch: Throwable -> L37
            goto L31
        L28:
            r105 = null;
        L31:
            if (r109 != null) goto L33;
            r109 = "";
        L33:
            if (r105 != null) goto L35;
            r105 = "";
        L35:
            Object r110 = Result.m9449constructorimpl(new GeckoInfo(r109, r105));     // Catch: Throwable -> L37
        L39:
            Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
            if (r111 != null) goto L42;
            r101 = r110;
        L44:
            return (GeckoInfo) r101;
        L42:
            fp6.j r112 = d.f257194a;
            d.c("parse GeckoInfo failed lynxSchema:" + r100, r111);
            goto L44
        L20:
            if (r105.length() == 0) goto L23;
            r106 = false;
            goto L23
        L16:
            r109 = null;
            goto L18
        L17:
            r109 = r104;
            r108 = null;
            goto L18
        L8:
            if (r104.length() == 0) goto L11;
            r107 = false;
        L37:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L39
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GeckoInfo copy$default(GeckoInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.channel;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bundle;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.channel;
    }

    public final String component2() {
        return this.bundle;
    }

    public final GeckoInfo copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        return new GeckoInfo(r100, r101);
    }

    public String toString() {
        return "GeckoInfo(channel=" + this.channel + ", bundle=" + this.bundle + ')';
    }

    public int hashCode() {
        return (this.channel.hashCode() * 31) + this.bundle.hashCode();
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getChannel() {
        return this.channel;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GeckoInfo) == false) goto L10;
        GeckoInfo r101 = (GeckoInfo) r100;
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public GeckoInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        this.channel = r100;
        this.bundle = r101;
    }
}
