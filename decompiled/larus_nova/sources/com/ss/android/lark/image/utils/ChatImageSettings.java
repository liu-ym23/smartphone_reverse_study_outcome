package com.ss.android.lark.image.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001:\nABCDEFGHIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR!\u0010\u000f\u001a\u00020\u00108FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\u00020\u00168FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\tR!\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000b\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\"R!\u0010$\u001a\u00020%8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b)\u0010\u000b\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010(R!\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b1\u0010.Ru\u00103\u001aV\u0012\u0004\u0012\u000205\u0012 \u0012\u001e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504j\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205`604j*\u0012\u0004\u0012\u000205\u0012 \u0012\u001e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504j\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205`6`68FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b:\u0010\u000b\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u00109R!\u0010;\u001a\u00020<8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b@\u0010\u000b\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010?¨\u0006K"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings;", "", "<init>", "()V", "TAG", "", "chatImageJson", "Lorg/json/JSONObject;", "getChatImageJson", "()Lorg/json/JSONObject;", "chatImageJson$delegate", "Lkotlin/Lazy;", "messageImageLoadSetting", "getMessageImageLoadSetting", "messageImageLoadSetting$delegate", "messageImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "getMessageImageCache$annotations", "getMessageImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "messageImageCache$delegate", "messageImageRemote", "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "getMessageImageRemote$annotations", "getMessageImageRemote", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "messageImageRemote$delegate", "largeImageLoadSetting", "getLargeImageLoadSetting", "largeImageLoadSetting$delegate", "largeImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "getLargeImageCache$annotations", "getLargeImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "largeImageCache$delegate", "largeImageRemote", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "getLargeImageRemote$annotations", "getLargeImageRemote", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "largeImageRemote$delegate", "imageLoadDownSampleDefaultConfigs", "", "Lcom/ss/android/lark/image/utils/ChatImageSettings$DownSampleConfig;", "getImageLoadDownSampleDefaultConfigs", "()Ljava/util/List;", "imageLoadDownSampleDefaultConfigs$delegate", "imageLoadDownSampleConfigs", "getImageLoadDownSampleConfigs", "imageLoadDownSampleConfigs$delegate", "imageLoadDownSampleDictionary", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getImageLoadDownSampleDictionary$annotations", "getImageLoadDownSampleDictionary", "()Ljava/util/HashMap;", "imageLoadDownSampleDictionary$delegate", "glideImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "getGlideImageCache$annotations", "getGlideImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "glideImageCache$delegate", "ChatImageSetting", "MessageImageCache", "MessageImageRemote", "MessageImageRemoteTarget", "LargeImageCache", "LargeImageRemote", "LargeImageRemoteTarget", "LargeImageRemoteFirstThumb", "DownSampleConfig", "GlideImageCache", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatImageSettings {
    public static final ChatImageSettings INSTANCE = null;
    private static final String TAG = "ChatImageSettings";
    private static final Lazy chatImageJson$delegate = null;
    private static final Lazy glideImageCache$delegate = null;
    private static final Lazy imageLoadDownSampleConfigs$delegate = null;
    private static final Lazy imageLoadDownSampleDefaultConfigs$delegate = null;
    private static final Lazy imageLoadDownSampleDictionary$delegate = null;
    private static final Lazy largeImageCache$delegate = null;
    private static final Lazy largeImageLoadSetting$delegate = null;
    private static final Lazy largeImageRemote$delegate = null;
    private static final Lazy messageImageCache$delegate = null;
    private static final Lazy messageImageLoadSetting$delegate = null;
    private static final Lazy messageImageRemote$delegate = null;

    @AppConfig(key = "chat_image_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$ChatImageSetting;", "", "<init>", "()V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatImageSetting {
        public ChatImageSetting() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$DownSampleConfig;", "", "fromTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "diskPercentage", "memoryPercentage", "<init>", "(Ljava/util/ArrayList;II)V", "getFromTypes", "()Ljava/util/ArrayList;", "setFromTypes", "(Ljava/util/ArrayList;)V", "getDiskPercentage", "()I", "setDiskPercentage", "(I)V", "getMemoryPercentage", "setMemoryPercentage", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DownSampleConfig {

        @SerializedName("disk_percentage")
        private int diskPercentage;

        @SerializedName("from_types")
        private ArrayList<Integer> fromTypes;

        @SerializedName("memory_percentage")
        private int memoryPercentage;

        public DownSampleConfig() {
            this(null, 0, 0, 7, null);
        }

        public final int getDiskPercentage() {
            return this.diskPercentage;
        }

        public final ArrayList<Integer> getFromTypes() {
            return this.fromTypes;
        }

        public final int getMemoryPercentage() {
            return this.memoryPercentage;
        }

        public final void setDiskPercentage(int r100) {
            this.diskPercentage = r100;
        }

        public final void setFromTypes(ArrayList<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.fromTypes = r100;
        }

        public final void setMemoryPercentage(int r100) {
            this.memoryPercentage = r100;
        }

        public DownSampleConfig(ArrayList<Integer> r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "fromTypes");
            this.fromTypes = r100;
            this.diskPercentage = r101;
            this.memoryPercentage = r102;
        }

        public /* synthetic */ DownSampleConfig(ArrayList r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = CollectionsKt.arrayListOf(new Integer[]{5});
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 50;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 10;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "", "noCacheOnLowDiskSpace", "", "noCacheEncrypt", "noCacheOnDiskCacheException", "noCachePreload", "minDiskSpace", "<init>", "(IIIII)V", "getNoCacheOnLowDiskSpace", "()I", "setNoCacheOnLowDiskSpace", "(I)V", "getNoCacheEncrypt", "setNoCacheEncrypt", "getNoCacheOnDiskCacheException", "setNoCacheOnDiskCacheException", "getNoCachePreload", "setNoCachePreload", "getMinDiskSpace", "setMinDiskSpace", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GlideImageCache {

        @SerializedName("min_disk_space")
        private int minDiskSpace;

        @SerializedName("no_cache_encrypt")
        private int noCacheEncrypt;

        @SerializedName("no_cache_disk_cache_exception")
        private int noCacheOnDiskCacheException;

        @SerializedName("no_cache_low_disk_space")
        private int noCacheOnLowDiskSpace;

        @SerializedName("no_cache_preload")
        private int noCachePreload;

        public GlideImageCache() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public final int getMinDiskSpace() {
            return this.minDiskSpace;
        }

        public final int getNoCacheEncrypt() {
            return this.noCacheEncrypt;
        }

        public final int getNoCacheOnDiskCacheException() {
            return this.noCacheOnDiskCacheException;
        }

        public final int getNoCacheOnLowDiskSpace() {
            return this.noCacheOnLowDiskSpace;
        }

        public final int getNoCachePreload() {
            return this.noCachePreload;
        }

        public final void setMinDiskSpace(int r100) {
            this.minDiskSpace = r100;
        }

        public final void setNoCacheEncrypt(int r100) {
            this.noCacheEncrypt = r100;
        }

        public final void setNoCacheOnDiskCacheException(int r100) {
            this.noCacheOnDiskCacheException = r100;
        }

        public final void setNoCacheOnLowDiskSpace(int r100) {
            this.noCacheOnLowDiskSpace = r100;
        }

        public final void setNoCachePreload(int r100) {
            this.noCachePreload = r100;
        }

        public GlideImageCache(int r100, int r101, int r102, int r103, int r104) {
            this.noCacheOnLowDiskSpace = r100;
            this.noCacheEncrypt = r101;
            this.noCacheOnDiskCacheException = r102;
            this.noCachePreload = r103;
            this.minDiskSpace = r104;
        }

        public /* synthetic */ GlideImageCache(int r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r110) {
            int r106 = 1;
            if ((r105 & 1) == 0) goto L5;
            int r111 = 1;
        L7:
            if ((r105 & 2) == 0) goto L9;
            int r107 = 1;
        L11:
            if ((r105 & 4) == 0) goto L13;
            int r108 = 1;
        L15:
            if ((r105 & 8) != 0) goto L19;
            r106 = r103;
        L19:
            if ((r105 & 16) == 0) goto L21;
            int r109 = 100;
        L22:
            this(r111, r107, r108, r106, r109);
            return;
        L21:
            r109 = r104;
            goto L22
        L13:
            r108 = r102;
            goto L15
        L9:
            r107 = r101;
            goto L11
        L5:
            r111 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "", "enable", "", "<init>", "(I)V", "getEnable", "()I", "setEnable", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeImageCache {

        @SerializedName("cache_enable")
        private int enable;

        public LargeImageCache() {
            int r100 = 0;
            this(r100, 1, null);
        }

        public final int getEnable() {
            return this.enable;
        }

        public LargeImageCache(int r100) {
            this.enable = r100;
        }

        public final void setEnable(int r100) {
            this.enable = r100;
        }

        public /* synthetic */ LargeImageCache(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 1;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "", PickerReporterConstants.KEY.TARGET, "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "firstThumb", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "<init>", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;)V", "getTarget", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "setTarget", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;)V", "getFirstThumb", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "setFirstThumb", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;)V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeImageRemote {

        @SerializedName("first_load_thumb")
        private LargeImageRemoteFirstThumb firstThumb;

        @SerializedName(PickerReporterConstants.KEY.TARGET)
        private LargeImageRemoteTarget target;

        /* JADX WARN: Multi-variable type inference failed */
        public LargeImageRemote() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final LargeImageRemoteFirstThumb getFirstThumb() {
            return this.firstThumb;
        }

        public final LargeImageRemoteTarget getTarget() {
            return this.target;
        }

        public final void setFirstThumb(LargeImageRemoteFirstThumb r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.firstThumb = r100;
        }

        public final void setTarget(LargeImageRemoteTarget r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.target = r100;
        }

        public LargeImageRemote(LargeImageRemoteTarget r100, LargeImageRemoteFirstThumb r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, "firstThumb");
            this.target = r100;
            this.firstThumb = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ LargeImageRemote(LargeImageRemoteTarget r100, LargeImageRemoteFirstThumb r101, int r102, DefaultConstructorMarker r103) {
            int r104 = 3;
            String r105 = null;
            Object[] r106 = 0;
            Object[] r107 = 0;
            if ((r102 & 1) == 0) goto L6;
            r100 = new LargeImageRemoteTarget(0, r105, r104, r107 == true ? 1 : 0);
        L6:
            if ((r102 & 2) == 0) goto L8;
            float r108 = 0.0f;
            r101 = new LargeImageRemoteFirstThumb(r108, r108, r104, r106 == true ? 1 : 0);
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "", "autoOriginMax", "", "autoOriginWeakMax", "<init>", "(FF)V", "getAutoOriginMax", "()F", "setAutoOriginMax", "(F)V", "getAutoOriginWeakMax", "setAutoOriginWeakMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeImageRemoteFirstThumb {

        @SerializedName("origin_common_min")
        private float autoOriginMax;

        @SerializedName("origin_weak_net_min")
        private float autoOriginWeakMax;

        public LargeImageRemoteFirstThumb() {
            float r100 = 0.0f;
            this(r100, r100, 3, null);
        }

        public final float getAutoOriginMax() {
            return this.autoOriginMax;
        }

        public final float getAutoOriginWeakMax() {
            return this.autoOriginWeakMax;
        }

        public final void setAutoOriginMax(float r100) {
            this.autoOriginMax = r100;
        }

        public final void setAutoOriginWeakMax(float r100) {
            this.autoOriginWeakMax = r100;
        }

        public LargeImageRemoteFirstThumb(float r100, float r101) {
            this.autoOriginMax = r100;
            this.autoOriginWeakMax = r101;
        }

        public /* synthetic */ LargeImageRemoteFirstThumb(float r100, float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 4.5f;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 1.5f;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "", "autoOriginMax", "", "defaultTarget", "", "<init>", "(ILjava/lang/String;)V", "getAutoOriginMax", "()I", "setAutoOriginMax", "(I)V", "getDefaultTarget", "()Ljava/lang/String;", "setDefaultTarget", "(Ljava/lang/String;)V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeImageRemoteTarget {

        @SerializedName("remote_auto_origin_max")
        private int autoOriginMax;

        @SerializedName("remote_default_target")
        private String defaultTarget;

        /* JADX WARN: Multi-variable type inference failed */
        public LargeImageRemoteTarget() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public final int getAutoOriginMax() {
            return this.autoOriginMax;
        }

        public final String getDefaultTarget() {
            return this.defaultTarget;
        }

        public final void setAutoOriginMax(int r100) {
            this.autoOriginMax = r100;
        }

        public final void setDefaultTarget(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.defaultTarget = r100;
        }

        public LargeImageRemoteTarget(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "defaultTarget");
            this.autoOriginMax = r100;
            this.defaultTarget = r101;
        }

        public /* synthetic */ LargeImageRemoteTarget(int r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 500;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "middle";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "", "enable", "", "originMax", "<init>", "(II)V", "getEnable", "()I", "setEnable", "(I)V", "getOriginMax", "setOriginMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageImageCache {

        @SerializedName("cache_enable")
        private int enable;

        @SerializedName("cache_load_origin_max")
        private int originMax;

        public MessageImageCache() {
            int r100 = 0;
            this(r100, r100, 3, null);
        }

        public final int getEnable() {
            return this.enable;
        }

        public final int getOriginMax() {
            return this.originMax;
        }

        public final void setEnable(int r100) {
            this.enable = r100;
        }

        public final void setOriginMax(int r100) {
            this.originMax = r100;
        }

        public MessageImageCache(int r100, int r101) {
            this.enable = r100;
            this.originMax = r101;
        }

        public /* synthetic */ MessageImageCache(int r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 1;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 25;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "", PickerReporterConstants.KEY.TARGET, "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "<init>", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;)V", "getTarget", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "setTarget", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageImageRemote {

        @SerializedName(PickerReporterConstants.KEY.TARGET)
        private MessageImageRemoteTarget target;

        /* JADX WARN: Multi-variable type inference failed */
        public MessageImageRemote() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final MessageImageRemoteTarget getTarget() {
            return this.target;
        }

        public MessageImageRemote(MessageImageRemoteTarget r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.target = r100;
        }

        public final void setTarget(MessageImageRemoteTarget r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.target = r100;
        }

        public /* synthetic */ MessageImageRemote(MessageImageRemoteTarget r100, int r101, DefaultConstructorMarker r102) {
            int r103 = 1;
            if ((r101 & 1) == 0) goto L5;
            r100 = new MessageImageRemoteTarget(0, r103, null);
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "", "thumbWidthMax", "", "<init>", "(I)V", "getThumbWidthMax", "()I", "setThumbWidthMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageImageRemoteTarget {

        @SerializedName("remote_auto_thumb_screen_width_max")
        private int thumbWidthMax;

        public MessageImageRemoteTarget() {
            int r100 = 0;
            this(r100, 1, null);
        }

        public final int getThumbWidthMax() {
            return this.thumbWidthMax;
        }

        public MessageImageRemoteTarget(int r100) {
            this.thumbWidthMax = r100;
        }

        public final void setThumbWidthMax(int r100) {
            this.thumbWidthMax = r100;
        }

        public /* synthetic */ MessageImageRemoteTarget(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 830;
        L5:
            this(r100);
        }
    }

    private ChatImageSettings() {
    }

    @JvmStatic
    public static /* synthetic */ void getGlideImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getImageLoadDownSampleDictionary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLargeImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLargeImageRemote$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMessageImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMessageImageRemote$annotations() {
    }

    static {
        INSTANCE = new ChatImageSettings();
        chatImageJson$delegate = LazyKt.lazy(ChatImageSettings$chatImageJson$2.INSTANCE);
        messageImageLoadSetting$delegate = LazyKt.lazy(ChatImageSettings$messageImageLoadSetting$2.INSTANCE);
        messageImageCache$delegate = LazyKt.lazy(ChatImageSettings$messageImageCache$2.INSTANCE);
        messageImageRemote$delegate = LazyKt.lazy(ChatImageSettings$messageImageRemote$2.INSTANCE);
        largeImageLoadSetting$delegate = LazyKt.lazy(ChatImageSettings$largeImageLoadSetting$2.INSTANCE);
        largeImageCache$delegate = LazyKt.lazy(ChatImageSettings$largeImageCache$2.INSTANCE);
        largeImageRemote$delegate = LazyKt.lazy(ChatImageSettings$largeImageRemote$2.INSTANCE);
        imageLoadDownSampleDefaultConfigs$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleDefaultConfigs$2.INSTANCE);
        imageLoadDownSampleConfigs$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleConfigs$2.INSTANCE);
        imageLoadDownSampleDictionary$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleDictionary$2.INSTANCE);
        glideImageCache$delegate = LazyKt.lazy(ChatImageSettings$glideImageCache$2.INSTANCE);
    }

    private final JSONObject getChatImageJson() {
        return (JSONObject) chatImageJson$delegate.getValue();
    }

    public static final GlideImageCache getGlideImageCache() {
        return (GlideImageCache) glideImageCache$delegate.getValue();
    }

    private final List<DownSampleConfig> getImageLoadDownSampleConfigs() {
        return (List) imageLoadDownSampleConfigs$delegate.getValue();
    }

    private final List<DownSampleConfig> getImageLoadDownSampleDefaultConfigs() {
        return (List) imageLoadDownSampleDefaultConfigs$delegate.getValue();
    }

    public static final HashMap<Integer, HashMap<Integer, Integer>> getImageLoadDownSampleDictionary() {
        return (HashMap) imageLoadDownSampleDictionary$delegate.getValue();
    }

    public static final LargeImageCache getLargeImageCache() {
        return (LargeImageCache) largeImageCache$delegate.getValue();
    }

    private final JSONObject getLargeImageLoadSetting() {
        return (JSONObject) largeImageLoadSetting$delegate.getValue();
    }

    public static final LargeImageRemote getLargeImageRemote() {
        return (LargeImageRemote) largeImageRemote$delegate.getValue();
    }

    public static final MessageImageCache getMessageImageCache() {
        return (MessageImageCache) messageImageCache$delegate.getValue();
    }

    private final JSONObject getMessageImageLoadSetting() {
        return (JSONObject) messageImageLoadSetting$delegate.getValue();
    }

    public static final MessageImageRemote getMessageImageRemote() {
        return (MessageImageRemote) messageImageRemote$delegate.getValue();
    }

    public static final /* synthetic */ JSONObject access$getChatImageJson(ChatImageSettings r100) {
        return r100.getChatImageJson();
    }

    public static final /* synthetic */ List access$getImageLoadDownSampleConfigs(ChatImageSettings r100) {
        return r100.getImageLoadDownSampleConfigs();
    }

    public static final /* synthetic */ List access$getImageLoadDownSampleDefaultConfigs(ChatImageSettings r100) {
        return r100.getImageLoadDownSampleDefaultConfigs();
    }

    public static final /* synthetic */ JSONObject access$getLargeImageLoadSetting(ChatImageSettings r100) {
        return r100.getLargeImageLoadSetting();
    }

    public static final /* synthetic */ JSONObject access$getMessageImageLoadSetting(ChatImageSettings r100) {
        return r100.getMessageImageLoadSetting();
    }
}
