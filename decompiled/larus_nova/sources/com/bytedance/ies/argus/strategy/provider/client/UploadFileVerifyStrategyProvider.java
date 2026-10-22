package com.bytedance.ies.argus.strategy.provider.client;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.ArgusUploadFileVerifyReason;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import t06.s;
import t06.v;

/* JADX INFO: loaded from: classes19.dex */
public final class UploadFileVerifyStrategyProvider extends u06.a {

    public static final class Detector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f246183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f246184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f246185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f246186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f246187e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v20 */
        /* JADX WARN: Type inference failed for: r8v21 */
        /* JADX WARN: Type inference failed for: r8v22 */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
        public final Object a(Context r100, Continuation<? super b> r101) {
            if ((r101 instanceof UploadFileVerifyStrategyProvider$Detector$detectFile$1) == false) goto L7;
            UploadFileVerifyStrategyProvider$Detector$detectFile$1 r102 = (UploadFileVerifyStrategyProvider$Detector$detectFile$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L20;
            if (r106 != 1) goto L19;
            Closeable r107 = (Closeable) r102.L$0;
            ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            r100 = r107;
        L54:
            Object r108 = (b) r104;     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            ?? r109 = r100;
        L58:
            CloseableKt.closeFinally(r109, null);
            return r108;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            ResultKt.throwOnFailure(r104);
            String r110 = this.f246183a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "filePath");
            Uri r111 = UriProtector.parse(r110);     // Catch: Exception -> L47
            String r112 = r111.getScheme();     // Catch: Exception -> L47
            if (r112 != null) goto L24;
        L27:
            boolean r113 = true;
        L28:
            if (r113 == false) goto L30;
        L35:
            String r114 = r111.getPath();     // Catch: Exception -> L47
            if (r114 == null) goto L48;
            PolarisFileWrapper r115 = new PolarisFileWrapper(r114);     // Catch: Exception -> L47
            if (r115.isFile() == false) goto L48;
            if (r115.exists() == false) goto L48;
            if (r115.canRead() == false) goto L48;
            InputStream r116 = new PolarisFileInputStreamWrapper(r115);     // Catch: Exception -> L47
        L49:
            if (r116 != null) goto L51;
            return null;
        L51:
            long r117 = this.f246186d;     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            UploadFileVerifyStrategyProvider$Detector$detectFile$2$1 r118 = new UploadFileVerifyStrategyProvider$Detector$detectFile$2$1(this, r116, null);     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            r102.L$0 = r116;     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            r102.label = 1;     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            r104 = TimeoutKt.b(r117, r118, r102);     // Catch: Throwable -> L14 Exception -> L16 TimeoutCancellationException -> L57
            r100 = r116;
            if (r104 != r105) goto L54;
            return r105;
        L30:
            if (StringsKt.equals("file", r112, true) == true) goto L35;
            if (StringsKt.equals("content", r112, true) == false) goto L48;
            r116 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r111);     // Catch: Exception -> L47
            goto L49
        L24:
            if (r112.length() == 0) goto L27;
            r113 = false;
        L48:
            r116 = null;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            CloseableKt.closeFinally(r100, th);
            throw th;
        L57:
            r108 = b.e.f246194a;     // Catch: Throwable -> L14
            r109 = r100;
        L16:
            e = move-exception;
            r108 = new b.a(e);     // Catch: Throwable -> L14
            r109 = r100;
        L7:
            r102 = new UploadFileVerifyStrategyProvider$Detector$detectFile$1(this, r101);
            goto L8
        }

        public Detector(String r100, List r101, long r102) {
            c r103 = new c(0);
            Intrinsics.checkNotNullParameter(r100, "filePath");
            Intrinsics.checkNotNullParameter(r103, "config");
            this.f246183a = r100;
            this.f246184b = null;
            this.f246185c = r101;
            this.f246186d = r102;
            this.f246187e = r103;
        }
    }

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f246188a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f246188a, ((a) r100).f246188a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f246188a.hashCode();
            }

            public final String toString() {
                return "Error(reason=" + this.f246188a + ')';
            }

            public a(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f246188a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$b$b, reason: collision with other inner class name */
        public static final class C3518b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f246189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f246190b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3518b) == true) goto L8;
                return false;
            L8:
                C3518b r101 = (C3518b) r100;
                if (this.f246189a == r101.f246189a) goto L12;
                return false;
            L12:
                if (this.f246190b == r101.f246190b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f246189a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f246190b;
                return r101 + ((int) (r102 ^ (r102 >>> 32)));
            }

            public final String toString() {
                return "Fixed(startByte=" + this.f246189a + ", endByte=" + this.f246190b + ')';
            }

            public C3518b(long r100, long r101) {
                this.f246189a = r100;
                this.f246190b = r101;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f246191a = null;

            static {
                f246191a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f246192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f246193b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L8;
                return false;
            L8:
                d r101 = (d) r100;
                if (this.f246192a == r101.f246192a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f246193b, r101.f246193b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f246192a * 31) + this.f246193b.hashCode();
            }

            public final String toString() {
                return "RegexHit(patternIndex=" + this.f246192a + ", matchText=" + this.f246193b + ')';
            }

            public d(int r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "matchText");
                this.f246192a = r100;
                this.f246193b = r101;
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f246194a = null;

            static {
                f246194a = new e();
            }

            public e() {
            }
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f246195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f246196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f246197c;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f246195a == r101.f246195a) goto L12;
            return false;
        L12:
            if (this.f246196b == r101.f246196b) goto L15;
            return false;
        L15:
            if (this.f246197c == r101.f246197c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f246195a * 31) + this.f246196b) * 31) + this.f246197c;
        }

        public final String toString() {
            return "DetectorConfig(ioBufferBytes=" + this.f246195a + ", regexWindowChars=" + this.f246196b + ", regexOverlapChars=" + this.f246197c + ')';
        }

        public c(int r100) {
            this.f246195a = 65536;
            this.f246196b = 65536;
            this.f246197c = 1024;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f246198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f246199b;

        public /* synthetic */ d() {
            this(false, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f246198a == r101.f246198a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f246199b, r101.f246199b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f246198a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            Long r102 = this.f246199b;
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

        public final String toString() {
            return "FileCheckResult(canRead=" + this.f246198a + ", fileSizeInKB=" + this.f246199b + ')';
        }

        public d(boolean r100, Long r101) {
            this.f246198a = r100;
            this.f246199b = r101;
        }
    }

    static {
    }

    public UploadFileVerifyStrategyProvider() {
    }

    @Override // u06.a
    public final ArgusStrategyProviderType b() {
        return ArgusStrategyProviderType.UploadFileVerify;
    }

    public static ParcelFileDescriptor c(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // u06.a
    public final void a(AspectConfigItem.a r110, t06.d r111, AspectContext<? extends BaseAspectParams<?>, ? extends com.bytedance.ies.argus.strategy.a>.a r112) {
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        PARAMS r100 = r112.f246005d.f245987b;
        com.bytedance.ies.argus.bean.i<REWRITE_PAYLOAD> r101 = r112.f246003b;
        if ((r100 instanceof com.bytedance.ies.argus.api.params.b) == true) goto L6;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, 6);
        return;
    L6:
        if (r111 == null) goto L8;
        v r102 = r111.p();
    L9:
        if (r102 != null) goto L12;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusCommonVerifyReason.STRATEGY_CONFIG_IS_NULL, null, 6);
        return;
    L12:
        com.bytedance.ies.argus.api.params.b r103 = (com.bytedance.ies.argus.api.params.b) r100;
        String r104 = r103.f245724b;
        String r105 = r103.f245725c;
        List<String> r106 = r102.f();
        if (r106 != null) goto L15;
        r106 = CollectionsKt.emptyList();
    L15:
        List<String> r107 = r106;
        boolean r108 = false;
        if ((r107 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r109 = r107.iterator();
    L22:
        if (r109.hasNext() == false) goto L26;
        if (CommonUtils.h(r104, (String) r109.next()) == false) goto L22;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L30;
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.FILE_PATH_IN_SKIP_LIST, null, 6);
        return;
    L30:
        Lazy<ArgusEnv> r114 = ArgusEnv.f245917d;
        r06.a r115 = ArgusEnv.b.a().f245918a;
        if (r115 == null) goto L33;
        Application r116 = r115.f535465d;
    L34:
        if (r116 != null) goto L37;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.APPLICATION_IS_NULL, null, 6);
        return;
    L37:
        Uri r117 = UriProtector.parse(r104);
        String r118 = r117.getScheme();
        if (r118 != null) goto L40;
    L43:
        boolean r119 = true;
    L45:
        if (r119 == false) goto L47;
    L66:
        String r120 = r117.getPath();
        if (r120 != null) goto L69;
        d r121 = new d();
    L90:
        r101.a("file_can_read", Boolean.valueOf(r121.f246198a));
        Long r122 = r121.f246199b;
        if (r122 == null) goto L93;
        long r123 = r122.longValue();
    L94:
        r101.a("file_size_in_kb", Long.valueOf(r123));
        if (r121.f246198a == true) goto L98;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.FILE_CAN_NOT_READ, null, 6);
        return;
    L98:
        Long r124 = r121.f246199b;
        if (r124 != null) goto L102;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.CAN_NOT_GET_FILE_SIZE, null, 6);
        return;
    L102:
        Integer r125 = r102.c();
        if (r125 == null) goto L105;
        int r126 = r125.intValue();
    L106:
        if (r126 <= 0) goto L112;
        if (r124.longValue() <= r126) goto L112;
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.FILE_SIZE_EXCEED_LIMIT, null, 6);
        return;
    L112:
        if (r102.b() == false) goto L115;
        Lazy<ArgusEnv> r127 = ArgusEnv.f245917d;
        r06.a r128 = ArgusEnv.b.a().f245918a;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.CAN_NOT_GET_SESSION_ID, null, 6);
        return;
    L115:
        List<s> r129 = r102.d();
        if (r129 != null) goto L118;
        r129 = CollectionsKt.emptyList();
    L118:
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L120:
        if (r131.hasNext() == false) goto L124;
        String r132 = ((s) r131.next()).b();
        if (r132 == null) goto L120;
        r130.add(r132);
        goto L120
    L124:
        Integer r133 = r102.a();
        int r134 = 3000;
        if (r133 == null) goto L127;
        r134 = RangesKt.coerceAtMost(r133.intValue(), 3000);
    L127:
        b r135 = (b) BuildersKt.runBlocking$default(null, new UploadFileVerifyStrategyProvider$calculate$result$1(new Detector(r104, r130, r134), r116, null), 1, null);
        if ((r135 instanceof b.C3518b) == false) goto L138;
        List<String> r136 = r102.e();
        if (r136 != null) goto L132;
    L134:
        if (r108 == false) goto L136;
        com.bytedance.ies.argus.bean.i.f(r101, ArgusUploadFileVerifyReason.SESSION_ID_FOUND_MODE_BLOCK, null, null, 6);
        return;
    L136:
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.SESSION_ID_FOUND_MODE_REPORT, null, 6);
        return;
    L132:
        if (r136.contains(r105) != true) goto L134;
        r108 = true;
        goto L134
    L138:
        if ((r135 instanceof b.d) == false) goto L155;
        b.d r137 = (b.d) r135;
        r101.a("regex_hit_index", Integer.valueOf(r137.f246192a));
        String r138 = (String) CollectionsKt.getOrNull(r130, r137.f246192a);
        if (r138 != null) goto L142;
        r138 = "unknown";
    L142:
        r101.a("regex_hit_pattern", r138);
        int r139 = r137.f246192a;
        List<s> r140 = r102.d();
        if (r140 == null) goto L151;
        s r141 = (s) CollectionsKt.getOrNull(r140, r139);
        if (r141 == null) goto L151;
        List<String> r142 = r141.a();
        if (r142 == null) goto L151;
        if (r142.contains(r105) != true) goto L151;
        r108 = true;
    L151:
        if (r108 == false) goto L153;
        com.bytedance.ies.argus.bean.i.f(r101, ArgusUploadFileVerifyReason.REGEX_HIT_MODE_BLOCK, null, null, 6);
        return;
    L153:
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.REGEX_HIT_MODE_REPORT, null, 6);
        return;
    L155:
        if ((r135 instanceof b.c) == false) goto L158;
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.FILE_MATCH_NOTHING, null, 6);
        return;
    L158:
        if ((r135 instanceof b.e) == false) goto L161;
        com.bytedance.ies.argus.bean.i.i(r101, ArgusUploadFileVerifyReason.FILE_DETECT_TIMEOUT, null, 6);
        return;
    L161:
        if ((r135 instanceof b.a) == false) goto L163;
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.UNEXPECTED_DETECT_RESULT, "errMsg: " + ((b.a) r135).f246188a.getMessage(), 4);
        return;
    L163:
        com.bytedance.ies.argus.bean.i.g(r101, ArgusUploadFileVerifyReason.UNEXPECTED_DETECT_RESULT, "errMsg: unknown", 4);
        return;
    L105:
        r126 = -1;
        goto L106
    L93:
        r123 = -1;
        goto L94
    L69:
        PolarisFileWrapper r143 = new PolarisFileWrapper(r120);
        if (r143.exists() == true) goto L72;
    L89:
        r121 = new d();
        goto L90
    L72:
        if (r143.isFile() == false) goto L89;
        if (r143.canRead() == false) goto L89;
        PolarisFileInputStreamWrapper r144 = new PolarisFileInputStreamWrapper(r143);     // Catch: Exception -> L88
        r121 = new d(true, Long.valueOf(r143.length() / ((long) 1024)));     // Catch: Throwable -> L81
    L79:
        CloseableKt.closeFinally(r144, null);     // Catch: Exception -> L88
    L81:
        th = move-exception;
        throw th;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        CloseableKt.closeFinally(r144, th);     // Catch: Exception -> L88
        throw th;     // Catch: Exception -> L88
    L88:
        r121 = new d();
        goto L90
    L47:
        if (StringsKt.equals("file", r118, true) == true) goto L66;
        if (Intrinsics.areEqual(r118, "content") == true) goto L172;
    L65:
        r121 = new d();
        goto L90
    L172:
        ParcelFileDescriptor r145 = c(r116.getContentResolver(), r117);     // Catch: Exception -> L64
        if (r145 == null) goto L65;
        r121 = new d(true, Long.valueOf(r145.getStatSize() / ((long) 1024)));     // Catch: Throwable -> L57
        CloseableKt.closeFinally(r145, null);     // Catch: Exception -> L64
        goto L90
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r145, th);     // Catch: Exception -> L64
        throw th;     // Catch: Exception -> L64
    L64:
        r121 = new d();
        goto L90
    L40:
        if (r118.length() == 0) goto L43;
        r119 = false;
        goto L45
    L33:
        r116 = null;
    L26:
        r113 = false;
        goto L27
    L18:
        if (r107.isEmpty() == false) goto L20;
    L8:
        r102 = null;
        goto L9
    }
}
