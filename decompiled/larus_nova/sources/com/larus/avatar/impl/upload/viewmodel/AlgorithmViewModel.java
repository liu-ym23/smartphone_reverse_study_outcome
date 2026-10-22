package com.larus.avatar.impl.upload.viewmodel;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import androidx.lifecycle.ViewModel;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.avatar.impl.upload.model.ScanUploadFilteredReason;
import com.larus.avatar.impl.upload.utils.ApiCallConfig;
import com.larus.avatar.impl.upload.utils.ViewModelUtilsKt;
import com.larus.platform.api.creation.IBachService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0010\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u000fH\u0002J\u0018\u00108\u001a\u0002002\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002JU\u00109\u001a\u00020(2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010;2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010<\u001a\u00020&2)\u0010=\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0;¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(\u0018\u00010>H\u0016J\u0018\u0010A\u001a\u00020(2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J&\u0010B\u001a\u00020(2\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010;2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010C\u001a\u00020(H\u0014J\u0010\u0010D\u001a\u00020E2\u0006\u0010.\u001a\u00020\u000eH\u0016J\u0010\u0010F\u001a\u00020&2\u0006\u0010.\u001a\u00020\u000eH\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/avatar/impl/upload/viewmodel/AlgorithmViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/avatar/impl/upload/viewmodel/IAlgorithmViewModel;", "<init>", "()V", "passScanFrontFeature", "", "", "getPassScanFrontFeature", "()Ljava/util/List;", "setPassScanFrontFeature", "(Ljava/util/List;)V", "photoFeaturesCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/net/Uri;", "", "getPhotoFeaturesCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "faceCountCache", "", "getFaceCountCache", "afterEffectSharpnessCache", "getAfterEffectSharpnessCache", "afterEffectFaceScoreCache", "getAfterEffectFaceScoreCache", "bitmapDownSamplingCache", "getBitmapDownSamplingCache", "faceShieldCache", "getFaceShieldCache", "pitchCache", "getPitchCache", "yawCache", "getYawCache", "ipaScoreCache", "getIpaScoreCache", "bachAvatarDetectAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "bachLibAvailable", "", "initAlgorithm", "", "releaseAlgorithm", "startAlgorithmProcess", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "getFaceCount", "uri", "getSimilarity", "", "uri1", "uri2", "cosineSimilarity", "vec1", "vec2", "vectorMagnitude", "vec", "dotProduct", "goThroughAlgorithm", "uris", "", "async", "asyncCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "processBitmapForUri", "innerGoThroughAlgorithm", "onCleared", "judgeFilterReason", "Lcom/larus/avatar/impl/upload/model/ScanUploadFilteredReason;", "judgeSharpNessAndColorScale", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlgorithmViewModel extends ViewModel implements h {
    private final ConcurrentHashMap<Uri, Float> afterEffectFaceScoreCache;
    private final ConcurrentHashMap<Uri, Float> afterEffectSharpnessCache;
    private zp9.i bachAvatarDetectAbility;
    private volatile boolean bachLibAvailable;
    private final ConcurrentHashMap<Uri, Float> bitmapDownSamplingCache;
    private final ConcurrentHashMap<Uri, Integer> faceCountCache;
    private final ConcurrentHashMap<Uri, Float> faceShieldCache;
    private final ConcurrentHashMap<Uri, Float> ipaScoreCache;
    private List<Float> passScanFrontFeature;
    private final ConcurrentHashMap<Uri, double[]> photoFeaturesCache;
    private final ConcurrentHashMap<Uri, Float> pitchCache;
    private final ConcurrentHashMap<Uri, Float> yawCache;

    public static /* synthetic */ Unit yo(AlgorithmViewModel r100, List r101, Bitmap r102, Function1 r103, ApiCallConfig r104) {
        return goThroughAlgorithm$lambda$0(r100, r101, r102, r103, r104);
    }

    public void initAlgorithm() {
        if (this.bachLibAvailable == false) goto L5;
        return;
    L5:
        IBachService r100 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r100 == null) goto L8;
        zp9.i r101 = r100.a();
    L9:
        this.bachAvatarDetectAbility = r101;
        this.bachLibAvailable = true;
        return;
    L8:
        r101 = null;
        goto L9
    }

    public void releaseAlgorithm() {
        if (this.bachLibAvailable == true) goto L5;
        return;
    L5:
        this.bachLibAvailable = false;
        zp9.i r100 = this.bachAvatarDetectAbility;
        if (r100 == null) goto L9;
        r100.release();
        return;
    }

    public AlgorithmViewModel() {
        this.photoFeaturesCache = new ConcurrentHashMap();
        this.faceCountCache = new ConcurrentHashMap();
        this.afterEffectSharpnessCache = new ConcurrentHashMap();
        this.afterEffectFaceScoreCache = new ConcurrentHashMap();
        this.bitmapDownSamplingCache = new ConcurrentHashMap();
        this.faceShieldCache = new ConcurrentHashMap();
        this.pitchCache = new ConcurrentHashMap();
        this.yawCache = new ConcurrentHashMap();
        this.ipaScoreCache = new ConcurrentHashMap();
        initAlgorithm();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        releaseAlgorithm();
    }

    public ConcurrentHashMap<Uri, Float> getAfterEffectFaceScoreCache() {
        return this.afterEffectFaceScoreCache;
    }

    public ConcurrentHashMap<Uri, Float> getAfterEffectSharpnessCache() {
        return this.afterEffectSharpnessCache;
    }

    public ConcurrentHashMap<Uri, Float> getBitmapDownSamplingCache() {
        return this.bitmapDownSamplingCache;
    }

    public ConcurrentHashMap<Uri, Integer> getFaceCountCache() {
        return this.faceCountCache;
    }

    public ConcurrentHashMap<Uri, Float> getFaceShieldCache() {
        return this.faceShieldCache;
    }

    public ConcurrentHashMap<Uri, Float> getIpaScoreCache() {
        return this.ipaScoreCache;
    }

    public List<Float> getPassScanFrontFeature() {
        return this.passScanFrontFeature;
    }

    public ConcurrentHashMap<Uri, double[]> getPhotoFeaturesCache() {
        return this.photoFeaturesCache;
    }

    public ConcurrentHashMap<Uri, Float> getPitchCache() {
        return this.pitchCache;
    }

    public ConcurrentHashMap<Uri, Float> getYawCache() {
        return this.yawCache;
    }

    private final double vectorMagnitude(double[] r100) {
        int r101 = r100.length;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        double r104 = r100[r103];
        r102 = r102 + (r104 * r104);
        r103 = r103 + 1;
        goto L3
    L6:
        return Math.sqrt(r102);
    }

    public int getFaceCount(Uri r100) {
        if (this.bachLibAvailable == true) goto L5;
        return 0;
    L5:
        if (r100 != null) goto L8;
        return 0;
    L8:
        if (getFaceCountCache().containsKey(r100) == false) goto L13;
        Integer r101 = getFaceCountCache().get(r100);
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.intValue();
    L13:
        innerGoThroughAlgorithm$default(this, CollectionsKt.listOf(r100), null, 2, null);
        Integer r102 = getFaceCountCache().get(r100);
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.intValue();
    }

    public ScanUploadFilteredReason judgeFilterReason(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Integer r101 = getFaceCountCache().get(r100);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        if (r102 > 1) goto L9;
        if (r102 == 0) goto L12;
        Float r103 = getAfterEffectSharpnessCache().get(r100);
        float r104 = -1.0f;
        if (r103 == null) goto L16;
        float r105 = r103.floatValue();
    L17:
        Float r106 = getAfterEffectFaceScoreCache().get(r100);
        if (r106 == null) goto L20;
        r104 = r106.floatValue();
    L20:
        z2 r107 = z2.f365865a;
        if (r105 >= r107.O().d()) goto L25;
        return ScanUploadFilteredReason.UN_SHARP;
    L25:
        if (r105 <= r107.O().c()) goto L27;
    L30:
        Float r108 = getFaceShieldCache().get(r100);
        if (r108 == null) goto L33;
        float r109 = r108.floatValue();
    L35:
        if (r109 > r107.O().b()) goto L37;
        Float r110 = getYawCache().get(r100);
        float r111 = Float.MAX_VALUE;
        if (r110 == null) goto L41;
        float r112 = r110.floatValue();
    L43:
        if (r112 < r107.O().h()) goto L60;
        if (r112 > r107.O().i()) goto L60;
        Float r113 = getPitchCache().get(r100);
        if (r113 == null) goto L51;
        r111 = r113.floatValue();
    L51:
        if (r111 < r107.O().e()) goto L58;
        if (r111 > r107.O().f()) goto L58;
        return ScanUploadFilteredReason.NOT_YOURSELF;
    L58:
        return ScanUploadFilteredReason.PITCH_FAIL;
    L60:
        return ScanUploadFilteredReason.YAW_FAIL;
    L41:
        r112 = Float.MAX_VALUE;
        goto L43
    L37:
        return ScanUploadFilteredReason.FACE_SHIELD;
    L33:
        r109 = Float.MIN_VALUE;
        goto L35
    L27:
        if (r104 > r107.O().a()) goto L30;
        return ScanUploadFilteredReason.UN_SHARP;
    L16:
        r105 = -1.0f;
        goto L17
    L12:
        return ScanUploadFilteredReason.NO_FACE;
    L9:
        return ScanUploadFilteredReason.MULTI_FACE;
    L5:
        r102 = -1;
        goto L7
    }

    public boolean judgeSharpNessAndColorScale(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Float r101 = getAfterEffectSharpnessCache().get(r100);
        float r102 = -1.0f;
        if (r101 == null) goto L5;
        float r103 = r101.floatValue();
    L6:
        Float r104 = getAfterEffectFaceScoreCache().get(r100);
        if (r104 == null) goto L9;
        r102 = r104.floatValue();
    L9:
        z2 r105 = z2.f365865a;
        if (r103 >= r105.O().d()) goto L14;
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + " afterEffectSharpnessScore error");
        return false;
    L14:
        if (r103 >= r105.O().d()) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r106 == true) goto L21;
    L24:
        Float r107 = getFaceShieldCache().get(r100);
        if (r107 == null) goto L27;
        float r108 = r107.floatValue();
    L29:
        if (r108 <= r105.O().b()) goto L32;
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + " faceShieldRate error");
        return false;
    L32:
        Float r109 = getYawCache().get(r100);
        float r110 = Float.MAX_VALUE;
        if (r109 == null) goto L35;
        float r111 = r109.floatValue();
    L37:
        if (r111 >= r105.O().h()) goto L39;
    L53:
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + " yawCache error");
        return false;
    L39:
        if (r111 > r105.O().i()) goto L53;
        Float r112 = getPitchCache().get(r100);
        if (r112 == null) goto L45;
        r110 = r112.floatValue();
    L45:
        if (r110 >= r105.O().e()) goto L47;
    L51:
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + " pitchCache error");
        return false;
    L47:
        if (r110 > r105.O().f()) goto L51;
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + "  pass");
        return true;
    L35:
        r111 = Float.MAX_VALUE;
        goto L37
    L27:
        r108 = Float.MIN_VALUE;
        goto L29
    L21:
        if (r102 > r105.O().a()) goto L24;
        FLogger.f375446a.i("AlgorithmViewModel", "judgeSharpNessAndColorScale,uri:" + r100 + " afterEffectFaceScore error");
        return false;
    L16:
        if (r103 >= r105.O().c()) goto L18;
        r106 = true;
        goto L19
    L5:
        r103 = -1.0f;
        goto L6
    }

    public void setPassScanFrontFeature(List<Float> r100) {
        this.passScanFrontFeature = r100;
    }

    public void startAlgorithmProcess(Bitmap r100) {
        if (this.bachLibAvailable == false) goto L12;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isRecycled() == true) goto L15;
        zp9.i r101 = this.bachAvatarDetectAbility;
        if (r101 == null) goto L14;
        r101.a(r100);
        return;
    L14:
        return;
    L15:
        return;
    }

    private final double cosineSimilarity(double[] r110, double[] r111) {
        if (r110.length == r111.length) goto L6;
        FLogger.f375446a.i("AlgorithmViewModel", "cosineSimilarity Error: Vectors must have the same dimension.");
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        double r100 = dotProduct(r110, r111);
        double r101 = vectorMagnitude(r110);
        double r112 = vectorMagnitude(r111);
        boolean r102 = true;
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L18:
        FLogger.f375446a.i("AlgorithmViewModel", "cosineSimilarity Error: One of the vectors has zero magnitude.");
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        if (r112 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r102 = false;
    L15:
        if (r102 == true) goto L18;
        return r100 / (r101 * r112);
    L9:
        r103 = false;
        goto L10
    }

    private final double dotProduct(double[] r100, double[] r110) {
        int r101 = r100.length;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 + (r100[r103] * r110[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [android.net.Uri, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.StringBuilder] */
    private final void innerGoThroughAlgorithm(List<? extends Uri> r110, Bitmap r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L73
        boolean r101 = true;
        if (r111 != null) goto L6;
    L8:
        List<? extends Uri> r112 = r110;     // Catch: Throwable -> L73
        if (r112 != null) goto L11;
    L14:
        if (r101 == true) goto L17;
        Object r113 = CollectionsKt.first(r110);     // Catch: Throwable -> L73
        int r102 = com.larus.avatar.impl.upload.utils.a.f291325a;     // Catch: Throwable -> L73
        float r103 = com.larus.avatar.impl.upload.utils.a.a((Uri) r113);     // Catch: Throwable -> L73
        Bitmap r104 = com.larus.avatar.impl.upload.utils.a.b((Uri) r113);     // Catch: Throwable -> L73
        getBitmapDownSamplingCache().put(r113, Float.valueOf(r103));     // Catch: Throwable -> L73
        ?? r114 = r113;
    L19:
        int r105 = 0;
    L20:
        if (r104 == null) goto L71;
        if (r114 != 0) goto L80;
    L64:
        r104.recycle();     // Catch: Throwable -> L73
        r105 = r105 + 1;     // Catch: Throwable -> L73
        if (r110 == null) goto L67;
        r114 = (Uri) CollectionsKt.getOrNull(r110, r105);     // Catch: Throwable -> L73
    L68:
        if (r114 != 0) goto L69;
        r104 = null;
        goto L20
    L69:
        int r106 = com.larus.avatar.impl.upload.utils.a.f291325a;     // Catch: Throwable -> L73
        float r107 = com.larus.avatar.impl.upload.utils.a.a(r114);     // Catch: Throwable -> L73
        Bitmap r108 = com.larus.avatar.impl.upload.utils.a.b(r114);     // Catch: Throwable -> L73
        Float r109 = (Float) getBitmapDownSamplingCache().put(r114, Float.valueOf(r107));     // Catch: Throwable -> L73
        r104 = r108;
        goto L20
    L67:
        r114 = 0;
        goto L68
    L80:
        if (getFaceCountCache().containsKey(r114) == true) goto L64;
        zp9.i r115 = this.bachAvatarDetectAbility;     // Catch: Exception -> L62 Throwable -> L73
        if (r115 == null) goto L27;
        zp9.b r116 = r115.a(r104);     // Catch: Exception -> L62 Throwable -> L73
    L28:
        ConcurrentHashMap r117 = getFaceCountCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L31;
        int r118 = r116.f573209a;     // Catch: Exception -> L62 Throwable -> L73
    L32:
        r117.put(r114, Integer.valueOf(r118));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r119 = getAfterEffectSharpnessCache();     // Catch: Exception -> L62 Throwable -> L73
        float r120 = 0.0f;
        if (r116 == null) goto L35;
        float r121 = r116.f573210b;     // Catch: Exception -> L62 Throwable -> L73
    L36:
        r119.put(r114, Float.valueOf(r121));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r122 = getAfterEffectFaceScoreCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L39;
        float r123 = r116.f573213e;     // Catch: Exception -> L62 Throwable -> L73
    L40:
        r122.put(r114, Float.valueOf(r123));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r124 = getFaceShieldCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L43;
        float r125 = r116.f573214f;     // Catch: Exception -> L62 Throwable -> L73
    L44:
        r124.put(r114, Float.valueOf(r125));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r126 = getPhotoFeaturesCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L48;
        double[] r127 = r116.f573212d;     // Catch: Exception -> L62 Throwable -> L73
        if (r127 == null) goto L48;
    L49:
        r126.put(r114, r127);     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r128 = getYawCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L52;
        float r129 = r116.f573215g;     // Catch: Exception -> L62 Throwable -> L73
    L53:
        r128.put(r114, Float.valueOf(r129));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r130 = getPitchCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L56;
        float r131 = r116.f573216h;     // Catch: Exception -> L62 Throwable -> L73
    L57:
        r130.put(r114, Float.valueOf(r131));     // Catch: Exception -> L62 Throwable -> L73
        ConcurrentHashMap r132 = getIpaScoreCache();     // Catch: Exception -> L62 Throwable -> L73
        if (r116 == null) goto L60;
        r120 = r116.f573211c;     // Catch: Exception -> L62 Throwable -> L73
    L60:
        r132.put(r114, Float.valueOf(r120));     // Catch: Exception -> L62 Throwable -> L73
        FLogger.f375446a.i("AlgorithmViewModel", "innerGoThroughAlgorithm,curProcessUri:" + r114 + " faceCountCache:" + getFaceCountCache().get(r114) + " afterEffectSharpnessCache:" + getAfterEffectSharpnessCache().get(r114) + " afterEffectFaceScoreCache:" + getAfterEffectFaceScoreCache().get(r114) + " faceShieldCache:" + getFaceShieldCache().get(r114));     // Catch: Exception -> L62 Throwable -> L73
        goto L64
    L56:
        r131 = 0.0f;
        goto L57
    L52:
        r129 = 0.0f;
    L48:
        r127 = new double[0];     // Catch: Exception -> L62 Throwable -> L73
        goto L49
    L43:
        r125 = 0.0f;
        goto L44
    L39:
        r123 = 0.0f;
        goto L40
    L35:
        r121 = 0.0f;
        goto L36
    L31:
        r118 = 0;
        goto L32
    L27:
        r116 = null;
        goto L28
    L62:
        e = move-exception;
        FLogger.f375446a.e("AlgorithmViewModel", "innerGoThroughAlgorithm, loop" + r105 + "，faceDetect error", e);     // Catch: Throwable -> L73
        goto L64
    L71:
        Object r133 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L90;
        FLogger.f375446a.e("AlgorithmViewModel", "innerGoThroughAlgorithm error", r134);
        return;
    L90:
        return;
    L17:
        Bitmap r135 = null;
    L18:
        r104 = r135;
        r114 = 0;
        goto L19
    L11:
        if (r112.isEmpty() == true) goto L14;
        r101 = false;
        goto L14
    L6:
        if (r111.isRecycled() == true) goto L8;
        r135 = r111.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    }

    public double getSimilarity(Uri r100, Uri r101) {
        if (this.bachLibAvailable == true) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        if (r101 != null) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        if (getPhotoFeaturesCache().containsKey(r100) == false) goto L12;
        double[] r102 = getPhotoFeaturesCache().get(r100);
    L14:
        if (getPhotoFeaturesCache().containsKey(r101) == false) goto L16;
        double[] r103 = getPhotoFeaturesCache().get(r101);
    L17:
        if (r102 != null) goto L19;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L19:
        if (r103 != null) goto L22;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L22:
        return cosineSimilarity(r102, r103);
    L16:
        innerGoThroughAlgorithm$default(this, CollectionsKt.listOf(r101), null, 2, null);
        r103 = getPhotoFeaturesCache().get(r101);
        goto L17
    L12:
        innerGoThroughAlgorithm$default(this, CollectionsKt.listOf(r100), null, 2, null);
        r102 = getPhotoFeaturesCache().get(r100);
        goto L14
    }

    public void processBitmapForUri(Uri r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        if (r101.isRecycled() == false) goto L5;
        return;
    L5:
        if (getFaceCountCache().containsKey(r100) == true) goto L58;
        Bitmap r102 = r101.copy(Bitmap.Config.ARGB_8888, true);
        zp9.i r103 = this.bachAvatarDetectAbility;     // Catch: Throwable -> L46 Exception -> L48
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L46 Exception -> L48
        zp9.b r104 = r103.a(r102);     // Catch: Throwable -> L46 Exception -> L48
    L12:
        ConcurrentHashMap<Uri, Integer> r105 = getFaceCountCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L15;
        int r106 = r104.f573209a;     // Catch: Throwable -> L46 Exception -> L48
    L16:
        r105.put(r100, Integer.valueOf(r106));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r107 = getAfterEffectSharpnessCache();     // Catch: Throwable -> L46 Exception -> L48
        float r108 = 0.0f;
        if (r104 == null) goto L19;
        float r109 = r104.f573210b;     // Catch: Throwable -> L46 Exception -> L48
    L20:
        r107.put(r100, Float.valueOf(r109));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r110 = getAfterEffectFaceScoreCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L23;
        float r111 = r104.f573213e;     // Catch: Throwable -> L46 Exception -> L48
    L24:
        r110.put(r100, Float.valueOf(r111));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r112 = getFaceShieldCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L27;
        float r113 = r104.f573214f;     // Catch: Throwable -> L46 Exception -> L48
    L28:
        r112.put(r100, Float.valueOf(r113));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, double[]> r114 = getPhotoFeaturesCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L32;
        double[] r115 = r104.f573212d;     // Catch: Throwable -> L46 Exception -> L48
        if (r115 == null) goto L32;
    L33:
        r114.put(r100, r115);     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r116 = getYawCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L36;
        float r117 = r104.f573215g;     // Catch: Throwable -> L46 Exception -> L48
    L37:
        r116.put(r100, Float.valueOf(r117));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r118 = getPitchCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L40;
        float r119 = r104.f573216h;     // Catch: Throwable -> L46 Exception -> L48
    L41:
        r118.put(r100, Float.valueOf(r119));     // Catch: Throwable -> L46 Exception -> L48
        ConcurrentHashMap<Uri, Float> r120 = getIpaScoreCache();     // Catch: Throwable -> L46 Exception -> L48
        if (r104 == null) goto L44;
        r108 = r104.f573211c;     // Catch: Throwable -> L46 Exception -> L48
    L44:
        r120.put(r100, Float.valueOf(r108));     // Catch: Throwable -> L46 Exception -> L48
    L50:
        r102.recycle();
        return;
    L40:
        r119 = 0.0f;
        goto L41
    L36:
        r117 = 0.0f;
    L32:
        r115 = new double[0];     // Catch: Throwable -> L46 Exception -> L48
        goto L33
    L27:
        r113 = 0.0f;
        goto L28
    L23:
        r111 = 0.0f;
        goto L24
    L19:
        r109 = 0.0f;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L11:
        r104 = null;
    L48:
        e = move-exception;
        FLogger.f375446a.e("AlgorithmViewModel", "processBitmapForUri detect error", e);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    public static final /* synthetic */ void access$innerGoThroughAlgorithm(AlgorithmViewModel r100, List r101, Bitmap r102) {
        r100.innerGoThroughAlgorithm(r101, r102);
    }

    @Override // com.larus.avatar.impl.upload.viewmodel.h
    public void goThroughAlgorithm(List<? extends Uri> r100, Bitmap r101, boolean r102, Function1<? super List<? extends Uri>, Unit> r103) {
        if (r102 == false) goto L4;
        ViewModelUtilsKt.d(this, new a(this, r100, r101, r103));
        return;
    L4:
        innerGoThroughAlgorithm(r100, r101);
    }

    private static final Unit goThroughAlgorithm$lambda$0(AlgorithmViewModel r100, List r101, Bitmap r102, Function1 r110, ApiCallConfig r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$viewModelApiCall");
        AlgorithmViewModel$goThroughAlgorithm$1$1 r103 = new AlgorithmViewModel$goThroughAlgorithm$1$1(r100, r101, r102, r110, null);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r103, "apiCall");
        r111.f291318a = r103;
        AlgorithmViewModel$goThroughAlgorithm$1$2 r104 = new AlgorithmViewModel$goThroughAlgorithm$1$2(r110, null);
        Intrinsics.checkNotNullParameter(r104, "failureCallback");
        r111.f291319b = r104;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void innerGoThroughAlgorithm$default(AlgorithmViewModel r100, List r101, Bitmap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.innerGoThroughAlgorithm(r101, r102);
    }
}
