package com.larus.camera.impl.vlm;

import android.graphics.Bitmap;
import android.util.Base64;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.camera.api.vlm.VLMIntent;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes26.dex */
public final class VLMIntentDetectRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VLMIntentDetectRepository f322806a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentApi;", "", "requestVLMIntent", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "request", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;", "(Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface VLMIntentApi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f322807a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f322808a = null;

            static {
                f322808a = new a();
            }

            public a() {
            }
        }

        static {
            f322807a = a.f322808a;
        }

        @POST("/biz/vlm/intent")
        Object requestVLMIntent(@Body f r100, Continuation<? super BizResponse<g>> r101);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f322809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f322810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f322811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f322812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f322813e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f322809a, r101.f322809a) == true) goto L12;
            return false;
        L12:
            if (this.f322810b == r101.f322810b) goto L15;
            return false;
        L15:
            if (this.f322811c == r101.f322811c) goto L18;
            return false;
        L18:
            if (this.f322812d == r101.f322812d) goto L21;
            return false;
        L21:
            if (this.f322813e == r101.f322813e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f322809a.hashCode() * 31) + this.f322810b) * 31) + this.f322811c) * 31) + this.f322812d) * 31) + this.f322813e;
        }

        public final String toString() {
            return "BuildHttpFileResult(fileData=" + this.f322809a + ", width=" + this.f322810b + ", height=" + this.f322811c + ", originImageSize=" + this.f322812d + ", compressedImageSize=" + this.f322813e + ')';
        }

        public a(e r100, int r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "fileData");
            this.f322809a = r100;
            this.f322810b = r101;
            this.f322811c = r102;
            this.f322812d = r103;
            this.f322813e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f322814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f322815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f322816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ix8.g f322817d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f322814a, r101.f322814a) == true) goto L12;
            return false;
        L12:
            if (this.f322815b == r101.f322815b) goto L15;
            return false;
        L15:
            if (this.f322816c == r101.f322816c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f322817d, r101.f322817d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f322814a.hashCode() * 31) + this.f322815b) * 31) + this.f322816c) * 31) + this.f322817d.hashCode();
        }

        public final String toString() {
            return "BuildHttpRequestResult(request=" + this.f322814a + ", firstImageWidth=" + this.f322815b + ", firstImageHeight=" + this.f322816c + ", preProcessInfo=" + this.f322817d + ')';
        }

        public b(f r100, int r101, int r102, ix8.g r103) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r103, "preProcessInfo");
            this.f322814a = r100;
            this.f322815b = r101;
            this.f322816c = r102;
            this.f322817d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f322818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f322819b;

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
            if (Intrinsics.areEqual(this.f322818a, r101.f322818a) == true) goto L12;
            return false;
        L12:
            if (this.f322819b == r101.f322819b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f322818a.hashCode() * 31) + this.f322819b;
        }

        public final String toString() {
            return "CompressResult(base64Data=" + this.f322818a + ", compressedImageSize=" + this.f322819b + ')';
        }

        public /* synthetic */ c(int r100) {
            this("", 0);
        }

        public c(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "base64Data");
            this.f322818a = r100;
            this.f322819b = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "", "needIntent", "", "needDewarp", "eduSceneType", "", "needDetection", "<init>", "(ZZLjava/lang/Long;Z)V", "getNeedIntent", "()Z", "getNeedDewarp", "getEduSceneType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNeedDetection", "component1", "component2", "component3", "component4", "copy", "(ZZLjava/lang/Long;Z)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("edu_scene_type")
        private final Long eduSceneType;

        @SerializedName("need_detection")
        private final boolean needDetection;

        @SerializedName("need_dewarp")
        private final boolean needDewarp;

        @SerializedName("need_intent")
        private final boolean needIntent;

        public d() {
            this(true, false, null, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.needIntent == r101.needIntent) goto L12;
            return false;
        L12:
            if (this.needDewarp == r101.needDewarp) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.eduSceneType, r101.eduSceneType) == true) goto L18;
            return false;
        L18:
            if (this.needDetection == r101.needDetection) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.needIntent == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.needDewarp == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            Long r105 = this.eduSceneType;
            if (r105 != null) goto L13;
            int r106 = 0;
        L14:
            int r107 = (r104 + r106) * 31;
            if (this.needDetection == true) goto L19;
            r100 = 1237;
        L19:
            return r107 + r100;
        L13:
            r106 = r105.hashCode();
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "EduFileData(needIntent=" + this.needIntent + ", needDewarp=" + this.needDewarp + ", eduSceneType=" + this.eduSceneType + ", needDetection=" + this.needDetection + ')';
        }

        public d(boolean r100, boolean r101, Long r102, boolean r103) {
            this.needIntent = r100;
            this.needDewarp = r101;
            this.eduSceneType = r102;
            this.needDetection = r103;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", "", "fileData", "", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getFileData", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        @SerializedName("file_data")
        private final String fileData;

        @SerializedName("type")
        private final Integer type;

        public e() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.fileData, r101.fileData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.fileData;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.type;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "VLMFileData(fileData=" + this.fileData + ", type=" + this.type + ')';
        }

        public final Integer getType() {
            return this.type;
        }

        public e(String r100, Integer r101) {
            this.fileData = r100;
            this.type = r101;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;", "", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "eduFileData", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "<init>", "(Ljava/util/List;ILcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;)V", "getFiles", "()Ljava/util/List;", "getSceneType", "()I", "getEduFileData", "()Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f {

        @SerializedName("edu_file_data")
        private final d eduFileData;

        @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
        private final List<e> files;

        @SerializedName("scene_type")
        private final int sceneType;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.files, r101.files) == true) goto L12;
            return false;
        L12:
            if (this.sceneType == r101.sceneType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.eduFileData, r101.eduFileData) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            List<e> r100 = this.files;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.sceneType) * 31;
            d r104 = this.eduFileData;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "VLMIntentRequest(files=" + this.files + ", sceneType=" + this.sceneType + ", eduFileData=" + this.eduFileData + ')';
        }

        public f() {
            this(null, VLMSceneType.TAKE_PICTURE.getValue(), null);
        }

        public f(List<e> r100, int r101, d r102) {
            this.files = r100;
            this.sceneType = r101;
            this.eduFileData = r102;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "", "vlmIntent", "", "enableChoice", "Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;", "requestId", "", "eduIntentData", "eduExtraParam", "<init>", "(Ljava/lang/Integer;Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVlmIntent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableChoice", "()Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;", "getRequestId", "()Ljava/lang/String;", "getEduIntentData", "getEduExtraParam", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g {

        @SerializedName("edu_extra_param")
        private final String eduExtraParam;

        @SerializedName("edu_data")
        private final String eduIntentData;

        @SerializedName("enable_choice")
        private final ix8.f enableChoice;

        @SerializedName("request_id")
        private final String requestId;

        @SerializedName("vlm_intent")
        private final Integer vlmIntent;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.vlmIntent, r101.vlmIntent) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enableChoice, r101.enableChoice) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.eduIntentData, r101.eduIntentData) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.eduExtraParam, r101.eduExtraParam) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.vlmIntent;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ix8.f r104 = this.enableChoice;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.requestId;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.eduIntentData;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.eduExtraParam;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
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

        public final String toString() {
            return "VLMIntentResponse(vlmIntent=" + this.vlmIntent + ", enableChoice=" + this.enableChoice + ", requestId=" + this.requestId + ", eduIntentData=" + this.eduIntentData + ", eduExtraParam=" + this.eduExtraParam + ')';
        }

        public g() {
            this.vlmIntent = Integer.valueOf(VLMIntent.COMMON.getValue());
            this.enableChoice = null;
            this.requestId = null;
            this.eduIntentData = null;
            this.eduExtraParam = null;
        }

        public final String a() {
            return this.eduExtraParam;
        }

        public final String b() {
            return this.eduIntentData;
        }

        public final ix8.f c() {
            return this.enableChoice;
        }

        public final String d() {
            return this.requestId;
        }

        public final Integer e() {
            return this.vlmIntent;
        }
    }

    public /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f322820a = null;

        static {
            int[] r100 = new int[VLMIntent.values().length];
            r100[VLMIntent.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VLMIntent.EDU.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f322820a = r100;
        }
    }

    static {
        f322806a = new VLMIntentDetectRepository();
    }

    public VLMIntentDetectRepository() {
    }

    public static c a(Bitmap r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        r100.compress(Bitmap.CompressFormat.JPEG, r101, r103);     // Catch: Throwable -> L7
        byte[] r104 = r103.toByteArray();     // Catch: Throwable -> L7
        c r105 = new c(Base64.encodeToString(r104, 2), r104.length);     // Catch: Throwable -> L7
    L5:
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L19;
        FLogger.f375446a.e("VLMIntentDetectRepository", "[bitmapToBase64] error, " + r107);
        r106 = new c(0);
    L19:
        return (c) r106;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final Object b(ix8.c r110, Continuation<? super ix8.d> r111) {
        if ((r111 instanceof VLMIntentDetectRepository$requestDetect$1) == false) goto L7;
        VLMIntentDetectRepository$requestDetect$1 r100 = (VLMIntentDetectRepository$requestDetect$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L38:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.larus.camera.impl.vlm.a r113 = (com.larus.camera.impl.vlm.a) r100.L$1;
        ix8.c r104 = (ix8.c) r100.L$0;
        ResultKt.throwOnFailure(r112);
        com.larus.camera.impl.vlm.a r105 = r113;
    L31:
        ix8.d r114 = (ix8.d) r112;
        if (r114 != null) goto L39;
        FLogger.f375446a.e("VLMIntentDetectRepository", "[VLMIntentRequest] failed, timeout");
        r105.a("-1", -1, "", 0, "");
        return new ix8.d.a(ix8.e.a.f496404a);
    L39:
        return r114;
    L16:
        ResultKt.throwOnFailure(r112);
        Long r115 = r110.f496388c.f496378a;
        if (r115 != null) goto L19;
    L24:
        r115 = null;
    L25:
        com.larus.camera.impl.vlm.a r106 = new com.larus.camera.impl.vlm.a(r110.f496390e, r110.f496388c);
        if (r115 == null) goto L35;
        r115.longValue();
        long r107 = r115.longValue();
        VLMIntentDetectRepository$requestDetect$2$1 r116 = new VLMIntentDetectRepository$requestDetect$2$1(r110, r106, null);
        r100.L$0 = r110;
        r100.L$1 = r106;
        r100.label = 1;
        r112 = TimeoutKt.c(r107, r116, r100);
        if (r112 != r102) goto L30;
        return r102;
    L30:
        r105 = r106;
        goto L31
    L35:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        r112 = c(r110, r106, r100);
        if (r112 != r102) goto L38;
        return r102;
    L19:
        if (r115.longValue() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L24;
    L21:
        r108 = false;
    L7:
        r100 = new VLMIntentDetectRepository$requestDetect$1(this, r111);
        goto L8
    }

    public final Object c(ix8.c r210, com.larus.camera.impl.vlm.a r211, Continuation<? super ix8.d> r212) {
        if ((r212 instanceof VLMIntentDetectRepository$requestDetectInternal$1) == false) goto L7;
        VLMIntentDetectRepository$requestDetectInternal$1 r100 = (VLMIntentDetectRepository$requestDetectInternal$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        VLMIntentDetectRepository$requestDetectInternal$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        Integer r111 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        b r105 = (b) r110.L$1;
        com.larus.camera.impl.vlm.a r106 = (com.larus.camera.impl.vlm.a) r110.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        dm9.a r107 = (dm9.a) r102;
        if ((r107 instanceof dm9.a.C5690a) == false) goto L32;
        FLogger.f375446a.e("VLMIntentDetectRepository", "[VLMIntentRequest] failed, " + r107);
        dm9.a.C5690a r108 = (dm9.a.C5690a) r107;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r108, "error");
        if (r108.f469230c == null) goto L29;
        String r109 = "network";
    L30:
        r106.a("0", -1, r109, r108.f469228a, r108.f469229b);
        return new ix8.d.a(new ix8.e.b(r108.f469229b), r105.f322817d);
    L29:
        r109 = "business";
        goto L30
    L32:
        if ((r107 instanceof dm9.a.b) == false) goto L55;
        g r112 = (g) ((dm9.a.b) r107).f469231a.getData();
        if (r112 == null) goto L36;
        r111 = r112.e();
    L36:
        if (r111 != null) goto L39;
        r106.getClass();
        Intrinsics.checkNotNullParameter("empty or invalid response", "errorMsg");
        r106.a("0", -1, "decode", 0, "empty or invalid response");
        ix8.d.a r113 = new ix8.d.a(new ix8.e.b("empty or invalid response"), r105.f322817d);
    L56:
        return r113;
    L39:
        VLMIntent.a r114 = VLMIntent.Companion;
        int r115 = r111.intValue();
        r114.getClass();
        VLMIntent r116 = VLMIntent.EDU;
        if (r115 != r116.getValue()) goto L42;
        VLMIntent r117 = r116;
    L43:
        if (r117 != r116) goto L45;
        int r118 = 1;
    L46:
        r106.a("1", r118, "", 0, "");
        int r119 = h.f322820a[r117.ordinal()];
        if (r119 == 1) goto L52;
        if (r119 != 2) goto L51;
        return new ix8.d.b(ix8.e.d.f496407a, r105.f322815b, r105.f322816c, r112.b(), r112.c(), r112.d(), r112.a(), r105.f322817d);
    L51:
        throw new NoWhenBranchMatchedException();
    L52:
        r113 = new ix8.d.a(ix8.e.d.f496407a, r105.f322817d);
        goto L56
    L45:
        r118 = 0;
        goto L46
    L42:
        r117 = VLMIntent.COMMON;
        goto L43
    L55:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.larus.camera.impl.vlm.a r120 = (com.larus.camera.impl.vlm.a) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r121 = r102;
        com.larus.camera.impl.vlm.a r122 = r120;
    L20:
        b r123 = (b) r121;
        ix8.g r124 = r123.f322817d;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r124, "preProcessInfo");
        r122.f322825e = System.currentTimeMillis();
        r122.f322826f = r124;
        VLMIntentApi.a r125 = VLMIntentApi.f322807a;
        VLMIntentDetectRepository$requestDetectInternal$2 r126 = new VLMIntentDetectRepository$requestDetectInternal$2(r123, null);
        r110.L$0 = r122;
        r110.L$1 = r123;
        r110.label = 2;
        r125.getClass();
        FlowHttpConnection r127 = FlowHttpConnection.f359975a;
        Object r128 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, VLMIntentApi.class, r126, true, null, null, null, r110, 240);
        if (r128 != r103) goto L23;
        return r103;
    L23:
        r105 = r123;
        r106 = r122;
        r102 = r128;
        goto L24
    L16:
        ResultKt.throwOnFailure(r102);
        CoroutineDispatcher r129 = Dispatchers.getDefault();
        VLMIntentDetectRepository$requestDetectInternal$httpRequest$1 r130 = new VLMIntentDetectRepository$requestDetectInternal$httpRequest$1(r210, null);
        r110.L$0 = r211;
        r110.label = 1;
        Object r131 = BuildersKt.withContext(r129, r130, r110);
        if (r131 != r103) goto L19;
        return r103;
    L19:
        r121 = r131;
        r122 = r211;
    L7:
        r100 = new VLMIntentDetectRepository$requestDetectInternal$1(this, r212);
        goto L8
    }
}
