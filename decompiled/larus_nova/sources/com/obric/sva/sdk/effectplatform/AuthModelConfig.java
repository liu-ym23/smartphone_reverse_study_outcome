package com.obric.sva.sdk.effectplatform;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\u001a\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007J$\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelConfig;", "", "<init>", "()V", "TAG", "", ErrorType.MANIFEST, "Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "ready", "", "authModelPath", "authKeyInfoPath", "qnnLibDir", "isReady", "getAuthModelVersion", "getAuthRawFileMd5", "getAuthModelPath", "getAuthKeyInfoPath", "getQnnLibDir", "refreshBuiltinQnn", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "source", "loadFromLatestIfExists", "", "cleanupDeprecatedAuthModels", "updateFromLatest", "invalidate", "reason", "applyIfValid", MapBundleKey.MapObjKey.OBJ_DIR, "mf", "loadManifest", "loadManifestWithStatus", "Lcom/obric/sva/sdk/effectplatform/AuthModelConfig$ManifestLoadResult;", "checkAuthDigest", "isSameAuthPackage", "left", "right", "compareMd5", "baseDir", "file", "md5", "ManifestLoadResult", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthModelConfig {
    public static final AuthModelConfig INSTANCE = null;
    private static final String TAG = "AuthModelConfig";
    private static volatile String authKeyInfoPath;
    private static volatile String authModelPath;
    private static volatile AuthModelManifest manifest;
    private static volatile String qnnLibDir;
    private static volatile boolean ready;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelConfig$ManifestLoadResult;", "", ErrorType.MANIFEST, "Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "code", "", "<init>", "(Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;I)V", "getManifest", "()Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "getCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ManifestLoadResult {
        private final int code;
        private final AuthModelManifest manifest;

        public static /* synthetic */ ManifestLoadResult copy$default(ManifestLoadResult r100, AuthModelManifest r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.code;
        L9:
            return r100.copy(r101, r102);
        }

        public final AuthModelManifest component1() {
            return this.manifest;
        }

        public final int component2() {
            return this.code;
        }

        public final ManifestLoadResult copy(AuthModelManifest r100, int r101) {
            return new ManifestLoadResult(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ManifestLoadResult) == true) goto L8;
            return false;
        L8:
            ManifestLoadResult r101 = (ManifestLoadResult) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (this.code == r101.code) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            AuthModelManifest r100 = this.manifest;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.code;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public String toString() {
            return "ManifestLoadResult(manifest=" + this.manifest + ", code=" + this.code + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final AuthModelManifest getManifest() {
            return this.manifest;
        }

        public ManifestLoadResult(AuthModelManifest r100, int r101) {
            this.manifest = r100;
            this.code = r101;
        }
    }

    private AuthModelConfig() {
    }

    static {
        INSTANCE = new AuthModelConfig();
        authModelPath = "";
        authKeyInfoPath = "";
        qnnLibDir = "";
    }

    public final void cleanupDeprecatedAuthModels() {
        Iterator<T> r100 = EffectConstant.INSTANCE.getDEPRECATED_AUTH_MODEL_ROOTS().iterator();
    L4:
        if (r100.hasNext() == false) goto L25;
        PolarisFileWrapper r101 = new PolarisFileWrapper((String) r100.next());
        if (r101.exists() == false) goto L4;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r101)));     // Catch: Throwable -> L10
    L12:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        LogUtils.w(TAG, "cleanupDeprecatedAuthModels delete exception path=" + r101.getAbsolutePath() + " error=" + r104.getMessage(), new Object[0]);
    L15:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = r105;
    L19:
        if (((Boolean) r103).booleanValue() == true) goto L24;
        if (r101.exists() == false) goto L24;
        LogUtils.w(TAG, "cleanupDeprecatedAuthModels delete failed path=" + r101.getAbsolutePath(), new Object[0]);
    L24:
        LogUtils.i(TAG, "cleanupDeprecatedAuthModels deleted path=" + r101.getAbsolutePath(), new Object[0]);
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final String getAuthKeyInfoPath() {
        if (ready == true) goto L7;
        return "";
    L7:
        return authKeyInfoPath;
    }

    public final String getAuthModelPath() {
        if (ready == true) goto L7;
        return "";
    L7:
        return authModelPath;
    }

    public final String getAuthModelVersion() {
        AuthModelManifest r100 = manifest;
        if (r100 == null) goto L5;
        String r101 = r100.getAuthModelVersion();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getAuthRawFileMd5() {
        AuthModelManifest r100 = manifest;
        if (r100 == null) goto L5;
        String r101 = r100.getAuthRawFileMd5();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getQnnLibDir() {
        return qnnLibDir;
    }

    public final boolean isReady() {
        return ready;
    }

    public final void invalidate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        LogUtils.w(TAG, "invalidate auth config: " + r100, new Object[0]);
        ready = false;
        manifest = null;
        authModelPath = "";
        authKeyInfoPath = "";
    }

    public final void loadFromLatestIfExists(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = EffectConstant.INSTANCE.getAuthLatestRoot();
        AuthModelManifest r102 = loadManifest(r101);
        if (r102 != null) goto L6;
        LogUtils.i(TAG, "loadFromLatestIfExists no manifest under " + r101, new Object[0]);
        return;
    L6:
        applyIfValid(r100.getApplicationContext(), r101, r102, "loadFromLatestIfExists");
    }

    public final AuthModelManifest loadManifest(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        return loadManifestWithStatus(r100).getManifest();
    }

    public final ManifestLoadResult loadManifestWithStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, EffectConstant.AUTH_MODEL_MANIFEST_FILE_NAME);
        if (r101.exists() == false) goto L31;
        if (r101.isFile() == false) goto L31;
        JsonElement r102 = JsonParser.parseString(FilesKt.readText(r101, Charsets.UTF_8));     // Catch: Exception -> L27
        if (r102 != null) goto L11;
    L25:
        LogUtils.e(TAG, "loadManifest root not object dir=" + r100, new Object[0]);     // Catch: Exception -> L27
        return new ManifestLoadResult(null, -3);
    L11:
        if (r102.isJsonObject() == false) goto L25;
        JsonObject r103 = r102.getAsJsonObject();     // Catch: Exception -> L27
        JsonElement r104 = r103.get("model_info");     // Catch: Exception -> L27
        if (r104 != null) goto L17;
    L21:
        AuthModelManifest r105 = (AuthModelManifest) new Gson().fromJson(r103, AuthModelManifest.class);     // Catch: Exception -> L27
        if (r105 != null) goto L34;
        return new ManifestLoadResult(null, -3);
    L34:
        return new ManifestLoadResult(r105, 0);
    L17:
        if (r104.isJsonObject() == true) goto L20;
        LogUtils.e(TAG, "loadManifest bad model_info dir=" + r100, new Object[0]);     // Catch: Exception -> L27
        return new ManifestLoadResult(null, -3);
    L20:
        r103 = r104.getAsJsonObject();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        LogUtils.e(TAG, "loadManifest fail dir=" + r100 + " error=" + e.getMessage(), new Object[0]);
        return new ManifestLoadResult(null, -3);
    L31:
        return new ManifestLoadResult(null, -2);
    }

    public final boolean updateFromLatest(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = EffectConstant.INSTANCE.getAuthLatestRoot();
        AuthModelManifest r102 = loadManifest(r101);
        if (r102 != null) goto L7;
        LogUtils.w(TAG, "updateFromLatest manifest missing under " + r101, new Object[0]);
        invalidate("manifest missing");
        return false;
    L7:
        return applyIfValid(r100.getApplicationContext(), r101, r102, "updateFromLatest");
    }

    public final boolean checkAuthDigest(String r100, AuthModelManifest r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        if (r101 != null) goto L5;
        return false;
    L5:
        String r102 = r101.getAuthRawFileMd5();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L16:
        boolean r104 = false;
    L17:
        boolean r105 = compareMd5(r100, r101.getAuthModelFile(), r101.getAuthModelMd5());
        boolean r106 = compareMd5(r100, r101.getAuthKeyFile(), r101.getAuthKeyMd5());
        LogUtils.d(TAG, "checkAuthDigest dir=" + r100 + " version=" + r101.getVersion() + " modelMd5=" + r105 + " keyMd5=" + r106 + " rawMd5=" + r104 + " qnn=builtin", new Object[0]);
        if (r104 == false) goto L23;
        if (r105 == false) goto L24;
        if (r106 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L14:
        if (r101.getAuthRawFileMd5().length() != 32) goto L16;
        r104 = true;
        goto L17
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public final boolean isSameAuthPackage(AuthModelManifest r100, AuthModelManifest r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        String r102 = r100.getVersion();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r100.getVersion(), r101.getVersion()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r100.getAuthModelVersion(), r101.getAuthModelVersion()) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(r100.getAuthRawFileMd5(), r101.getAuthRawFileMd5()) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r100.getAuthModelMd5(), r101.getAuthModelMd5()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(r100.getAuthKeyMd5(), r101.getAuthKeyMd5()) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(r100.getAuthModelFile(), r101.getAuthModelFile()) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(r100.getAuthKeyFile(), r101.getAuthKeyFile()) == false) goto L38;
        return true;
    L38:
        return false;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    }

    public final boolean refreshBuiltinQnn(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        String r102 = r100.getApplicationInfo().nativeLibraryDir;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L16:
        LogUtils.w(TAG, "refreshBuiltinQnn native lib dir missing source=" + r101 + " dir=" + r102, new Object[0]);
        qnnLibDir = "";
        return false;
    L12:
        if (new PolarisFileWrapper(r102).isDirectory() == false) goto L16;
        qnnLibDir = r102;
        LogUtils.i(TAG, "refreshBuiltinQnn ready source=" + r101 + " qnnDir=" + qnnLibDir, new Object[0]);
        return true;
    L8:
        r103 = false;
        goto L10
    }

    private final boolean compareMd5(String r100, String r101, String r102) {
        boolean r103 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        if (r102 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        return true;
    L12:
        if (r102.length() == 0) goto L15;
        r105 = false;
    L18:
        if (r101 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L37;
        if (r102 != null) goto L27;
    L30:
        if (r103 == true) goto L37;
        if (r102.length() == 32) goto L35;
        return false;
    L35:
        String r107 = KtUtils.md5(r100 + File.separator + r101);
        Locale r108 = Locale.ROOT;
        return Intrinsics.areEqual(r102.toLowerCase(r108), r107.toLowerCase(r108));
    L27:
        if (r102.length() == 0) goto L30;
        r103 = false;
    L37:
        return false;
    L20:
        if (r101.length() == 0) goto L23;
        r106 = false;
        goto L24
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    private final boolean applyIfValid(Context r110, String r111, AuthModelManifest r112, String r113) {
        if (checkAuthDigest(r111, r112) == true) goto L6;
        LogUtils.w(TAG, "applyIfValid digest fail source=" + r113 + " dir=" + r111 + " version=" + r112.getVersion(), new Object[0]);
        StringBuilder r114 = new StringBuilder("digest fail from ");
        r114.append(r113);
        invalidate(r114.toString());
        return false;
    L6:
        StringBuilder r100 = new StringBuilder();
        r100.append(r111);
        String r101 = File.separator;
        r100.append(r101);
        String r102 = r112.getAuthModelFile();
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100.append(r102);
        String r104 = r100.toString();
        StringBuilder r105 = new StringBuilder();
        r105.append(r111);
        r105.append(r101);
        String r115 = r112.getAuthKeyFile();
        if (r115 == null) goto L13;
        r103 = r115;
    L13:
        r105.append(r103);
        String r116 = r105.toString();
        String r106 = r112.getAuthModelFile();
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L21:
        if (r107 == true) goto L37;
        String r108 = r112.getAuthKeyFile();
        if (r108 != null) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r109 == true) goto L37;
        if (new PolarisFileWrapper(r104).isFile() == false) goto L37;
        if (new PolarisFileWrapper(r116).isFile() == false) goto L37;
        refreshBuiltinQnn(r110, "applyIfValid:" + r113);
        manifest = r112;
        authModelPath = r104;
        authKeyInfoPath = r116;
        ready = true;
        LogUtils.i(TAG, "applyIfValid ready source=" + r113 + " version=" + r112.getVersion() + " model=" + r104 + " key=" + r116 + " qnnDir=" + qnnLibDir, new Object[0]);
        return true;
    L25:
        if (r108.length() == 0) goto L28;
        r109 = false;
    L37:
        LogUtils.w(TAG, "applyIfValid file missing source=" + r113 + " model=" + r104 + " key=" + r116, new Object[0]);
        StringBuilder r117 = new StringBuilder("file missing from ");
        r117.append(r113);
        invalidate(r117.toString());
        return false;
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
        goto L21
    }
}
