package lu9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\\\b\u0086\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\u0093\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\b\b\u0002\u0010 \u001a\u00020\u0012\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u0012\u0012\b\b\u0002\u0010$\u001a\u00020\u0012\u0012\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&\u0012\u0012\b\u0002\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+¢\u0006\u0004\b/\u00100J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0010HÆ\u0003J\t\u0010h\u001a\u00020\u0012HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0006HÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\t\u0010n\u001a\u00020\u0012HÆ\u0003J\t\u0010o\u001a\u00020\u0012HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0012HÆ\u0003J\t\u0010r\u001a\u00020\u0012HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0012HÆ\u0003J\t\u0010u\u001a\u00020\u0012HÆ\u0003J\t\u0010v\u001a\u00020\u0012HÆ\u0003J\t\u0010w\u001a\u00020\u0012HÆ\u0003J\t\u0010x\u001a\u00020\u0012HÆ\u0003J\t\u0010y\u001a\u00020\u0012HÆ\u0003J\t\u0010z\u001a\u00020\u0012HÆ\u0003J\u0019\u0010{\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&HÆ\u0003J\u0013\u0010|\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010)HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\u0096\u0003\u0010\u0081\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&2\u0012\b\u0002\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+HÆ\u0001J\u0015\u0010\u0082\u0001\u001a\u00020\u00032\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010\u0085\u0001\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00102R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00102R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00105R\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0016\u0010\u0018\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0016\u0010\u0019\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010AR\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00102R\u0016\u0010\u001b\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010AR\u0016\u0010\u001c\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010AR\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0016\u0010\u001e\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010AR\u0016\u0010\u001f\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010AR\u0016\u0010 \u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010AR\u0016\u0010!\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010AR\u0016\u0010\"\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010AR\u0016\u0010#\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010AR\u0016\u0010$\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010AR&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0018\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010YR\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010YR\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010Y¨\u0006\u0087\u0001"}, d2 = {"Lcom/larus/settings/provider/disk/AppDiskCleanConfig;", XmlPullParser.NO_NAMESPACE, "enableDiskClean", XmlPullParser.NO_NAMESPACE, "enableManualDiskClean", "manualDiskCleanUiTimeoutSeconds", XmlPullParser.NO_NAMESPACE, "enableLowDiskAutoClean", "lowDiskSpaceThreshold", "enableLowDiskCleanCacheDir", "enableCustomBizDiskClean", "geckoCleanConfig", "Lcom/larus/settings/provider/disk/GeckoCleanConfig;", "enableExtendedAutoClean", "enableFileUsageMonitor", "fileUsageMonitorSampleRate", XmlPullParser.NO_NAMESPACE, "fileUsageMonitorVersion", XmlPullParser.NO_NAMESPACE, "enableManagedCacheClean", "enableDeleteUndeclaredPlugin", "keepExpiredPluginUntilInstallNew", "customBizDiskCleanInterval", "diskCleanInterval", "mediaExpireDays", "lowDiskMediaExpireDays", "enableExpiredMediaClean", "drivePreviewExpireDays", "lowDiskDrivePreviewExpireDays", "enableExpiredDrivePreviewClean", "managedCacheExpireDays", "lowDiskManagedCacheExpireDays", "messageCacheExpireDays", "lowDiskMessageCacheExpireDays", "messageCacheKeepLatestMainConversationCount", "voicePreloadCacheExpireDays", "lowDiskVoicePreloadCacheExpireDays", "diskModuleFileSizeThreshold", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "diskModuleCleanBizBlackList", XmlPullParser.NO_NAMESPACE, "internalCleanPathBlackConfig", "Lcom/larus/settings/provider/disk/PathConfig;", "internalCleanPathWhiteConfig", "externalCleanPathBlackConfig", "externalCleanPathWhiteConfig", "<init>", "(ZZJZJZZLcom/larus/settings/provider/disk/GeckoCleanConfig;ZZFIZZZJJIIZIIZIIIIIIILjava/util/Map;Ljava/util/List;Lcom/larus/settings/provider/disk/PathConfig;Lcom/larus/settings/provider/disk/PathConfig;Lcom/larus/settings/provider/disk/PathConfig;Lcom/larus/settings/provider/disk/PathConfig;)V", "getEnableDiskClean", "()Z", "getEnableManualDiskClean", "getManualDiskCleanUiTimeoutSeconds", "()J", "getEnableLowDiskAutoClean", "getLowDiskSpaceThreshold", "getEnableLowDiskCleanCacheDir", "getEnableCustomBizDiskClean", "getGeckoCleanConfig", "()Lcom/larus/settings/provider/disk/GeckoCleanConfig;", "getEnableExtendedAutoClean", "getEnableFileUsageMonitor", "getFileUsageMonitorSampleRate", "()F", "getFileUsageMonitorVersion", "()I", "getEnableManagedCacheClean", "getEnableDeleteUndeclaredPlugin", "getKeepExpiredPluginUntilInstallNew", "getCustomBizDiskCleanInterval", "getDiskCleanInterval", "getMediaExpireDays", "getLowDiskMediaExpireDays", "getEnableExpiredMediaClean", "getDrivePreviewExpireDays", "getLowDiskDrivePreviewExpireDays", "getEnableExpiredDrivePreviewClean", "getManagedCacheExpireDays", "getLowDiskManagedCacheExpireDays", "getMessageCacheExpireDays", "getLowDiskMessageCacheExpireDays", "getMessageCacheKeepLatestMainConversationCount", "getVoicePreloadCacheExpireDays", "getLowDiskVoicePreloadCacheExpireDays", "getDiskModuleFileSizeThreshold", "()Ljava/util/Map;", "getDiskModuleCleanBizBlackList", "()Ljava/util/List;", "getInternalCleanPathBlackConfig", "()Lcom/larus/settings/provider/disk/PathConfig;", "getInternalCleanPathWhiteConfig", "getExternalCleanPathBlackConfig", "getExternalCleanPathWhiteConfig", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "copy", "equals", "other", "hashCode", "toString", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class a {

    @SerializedName("custom_biz_disk_clean_interval")
    private final long customBizDiskCleanInterval;

    @SerializedName("disk_clean_interval")
    private final long diskCleanInterval;

    @SerializedName("disk_module_clean_biz_black_list")
    private final List<String> diskModuleCleanBizBlackList;

    @SerializedName("disk_module_file_size_threshold")
    private final Map<String, Long> diskModuleFileSizeThreshold;

    @SerializedName("drive_preview_expire_days")
    private final int drivePreviewExpireDays;

    @SerializedName("enable_custom_biz_disk_clean_cache")
    private final boolean enableCustomBizDiskClean;

    @SerializedName("enable_delete_undeclared_plugin")
    private final boolean enableDeleteUndeclaredPlugin;

    @SerializedName("enable_disk_clean")
    private final boolean enableDiskClean;

    @SerializedName("enable_expired_drive_preview_clean")
    private final boolean enableExpiredDrivePreviewClean;

    @SerializedName("enable_expired_media_clean")
    private final boolean enableExpiredMediaClean;

    @SerializedName("enable_extended_auto_clean")
    private final boolean enableExtendedAutoClean;

    @SerializedName("enable_file_usage_monitor")
    private final boolean enableFileUsageMonitor;

    @SerializedName("enable_low_disk_auto_clean")
    private final boolean enableLowDiskAutoClean;

    @SerializedName("enable_low_disk_clean_cache_dir")
    private final boolean enableLowDiskCleanCacheDir;

    @SerializedName("enable_managed_cache_clean")
    private final boolean enableManagedCacheClean;

    @SerializedName("enable_manual_disk_clean")
    private final boolean enableManualDiskClean;

    @SerializedName("external_clean_path_black_config")
    private final h externalCleanPathBlackConfig;

    @SerializedName("external_clean_path_white_config")
    private final h externalCleanPathWhiteConfig;

    @SerializedName("file_usage_monitor_sample_rate")
    private final float fileUsageMonitorSampleRate;

    @SerializedName("file_usage_monitor_version")
    private final int fileUsageMonitorVersion;

    @SerializedName("gecko_clean_config")
    private final g geckoCleanConfig;

    @SerializedName("internal_clean_path_black_config")
    private final h internalCleanPathBlackConfig;

    @SerializedName("internal_clean_path_white_config")
    private final h internalCleanPathWhiteConfig;

    @SerializedName("keep_expired_plugin_until_install_new")
    private final boolean keepExpiredPluginUntilInstallNew;

    @SerializedName("low_disk_drive_preview_expire_days")
    private final int lowDiskDrivePreviewExpireDays;

    @SerializedName("low_disk_managed_cache_expire_days")
    private final int lowDiskManagedCacheExpireDays;

    @SerializedName("low_disk_media_expire_days")
    private final int lowDiskMediaExpireDays;

    @SerializedName("low_disk_message_cache_expire_days")
    private final int lowDiskMessageCacheExpireDays;

    @SerializedName("low_disk_space_threshold")
    private final long lowDiskSpaceThreshold;

    @SerializedName("low_disk_voice_preload_cache_expire_days")
    private final int lowDiskVoicePreloadCacheExpireDays;

    @SerializedName("managed_cache_expire_days")
    private final int managedCacheExpireDays;

    @SerializedName("manual_disk_clean_ui_timeout_seconds")
    private final long manualDiskCleanUiTimeoutSeconds;

    @SerializedName("media_expire_days")
    private final int mediaExpireDays;

    @SerializedName("message_cache_expire_days")
    private final int messageCacheExpireDays;

    @SerializedName("message_cache_keep_latest_main_conversation_count")
    private final int messageCacheKeepLatestMainConversationCount;

    @SerializedName("voice_preload_cache_expire_days")
    private final int voicePreloadCacheExpireDays;

    /* JADX INFO: renamed from: lu9.a$a, reason: collision with other inner class name */
    public static final class C0010a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.enableDiskClean == r9.enableDiskClean) goto L12;
        return false;
    L12:
        if (this.enableManualDiskClean == r9.enableManualDiskClean) goto L15;
        return false;
    L15:
        if (this.manualDiskCleanUiTimeoutSeconds == r9.manualDiskCleanUiTimeoutSeconds) goto L18;
        return false;
    L18:
        if (this.enableLowDiskAutoClean == r9.enableLowDiskAutoClean) goto L21;
        return false;
    L21:
        if (this.lowDiskSpaceThreshold == r9.lowDiskSpaceThreshold) goto L24;
        return false;
    L24:
        if (this.enableLowDiskCleanCacheDir == r9.enableLowDiskCleanCacheDir) goto L27;
        return false;
    L27:
        if (this.enableCustomBizDiskClean == r9.enableCustomBizDiskClean) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.geckoCleanConfig, r9.geckoCleanConfig) == true) goto L33;
        return false;
    L33:
        if (this.enableExtendedAutoClean == r9.enableExtendedAutoClean) goto L36;
        return false;
    L36:
        if (this.enableFileUsageMonitor == r9.enableFileUsageMonitor) goto L39;
        return false;
    L39:
        if (Float.compare(this.fileUsageMonitorSampleRate, r9.fileUsageMonitorSampleRate) == 0) goto L42;
        return false;
    L42:
        if (this.fileUsageMonitorVersion == r9.fileUsageMonitorVersion) goto L45;
        return false;
    L45:
        if (this.enableManagedCacheClean == r9.enableManagedCacheClean) goto L48;
        return false;
    L48:
        if (this.enableDeleteUndeclaredPlugin == r9.enableDeleteUndeclaredPlugin) goto L51;
        return false;
    L51:
        if (this.keepExpiredPluginUntilInstallNew == r9.keepExpiredPluginUntilInstallNew) goto L54;
        return false;
    L54:
        if (this.customBizDiskCleanInterval == r9.customBizDiskCleanInterval) goto L57;
        return false;
    L57:
        if (this.diskCleanInterval == r9.diskCleanInterval) goto L60;
        return false;
    L60:
        if (this.mediaExpireDays == r9.mediaExpireDays) goto L63;
        return false;
    L63:
        if (this.lowDiskMediaExpireDays == r9.lowDiskMediaExpireDays) goto L66;
        return false;
    L66:
        if (this.enableExpiredMediaClean == r9.enableExpiredMediaClean) goto L69;
        return false;
    L69:
        if (this.drivePreviewExpireDays == r9.drivePreviewExpireDays) goto L72;
        return false;
    L72:
        if (this.lowDiskDrivePreviewExpireDays == r9.lowDiskDrivePreviewExpireDays) goto L75;
        return false;
    L75:
        if (this.enableExpiredDrivePreviewClean == r9.enableExpiredDrivePreviewClean) goto L78;
        return false;
    L78:
        if (this.managedCacheExpireDays == r9.managedCacheExpireDays) goto L81;
        return false;
    L81:
        if (this.lowDiskManagedCacheExpireDays == r9.lowDiskManagedCacheExpireDays) goto L84;
        return false;
    L84:
        if (this.messageCacheExpireDays == r9.messageCacheExpireDays) goto L87;
        return false;
    L87:
        if (this.lowDiskMessageCacheExpireDays == r9.lowDiskMessageCacheExpireDays) goto L90;
        return false;
    L90:
        if (this.messageCacheKeepLatestMainConversationCount == r9.messageCacheKeepLatestMainConversationCount) goto L93;
        return false;
    L93:
        if (this.voicePreloadCacheExpireDays == r9.voicePreloadCacheExpireDays) goto L96;
        return false;
    L96:
        if (this.lowDiskVoicePreloadCacheExpireDays == r9.lowDiskVoicePreloadCacheExpireDays) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.diskModuleFileSizeThreshold, r9.diskModuleFileSizeThreshold) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.diskModuleCleanBizBlackList, r9.diskModuleCleanBizBlackList) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.internalCleanPathBlackConfig, r9.internalCleanPathBlackConfig) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.internalCleanPathWhiteConfig, r9.internalCleanPathWhiteConfig) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.externalCleanPathBlackConfig, r9.externalCleanPathBlackConfig) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.externalCleanPathWhiteConfig, r9.externalCleanPathWhiteConfig) == true) goto L116;
        return false;
    L116:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableDiskClean == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableManualDiskClean == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        long r5 = this.manualDiskCleanUiTimeoutSeconds;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        if (this.enableLowDiskAutoClean == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        long r9 = this.lowDiskSpaceThreshold;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        if (this.enableLowDiskCleanCacheDir == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.enableCustomBizDiskClean == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        g r15 = this.geckoCleanConfig;
        int r16 = 0;
        if (r15 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r14 + r17) * 31;
        if (this.enableExtendedAutoClean == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.enableFileUsageMonitor == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (((((r20 + r21) * 31) + Float.floatToIntBits(this.fileUsageMonitorSampleRate)) * 31) + this.fileUsageMonitorVersion) * 31;
        if (this.enableManagedCacheClean == false) goto L37;
        int r23 = 1231;
    L38:
        int r24 = (r22 + r23) * 31;
        if (this.enableDeleteUndeclaredPlugin == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (r24 + r25) * 31;
        if (this.keepExpiredPluginUntilInstallNew == false) goto L45;
        int r28 = 1231;
    L46:
        long r29 = this.customBizDiskCleanInterval;
        int r30 = (((r26 + r28) * 31) + ((int) (r29 ^ (r29 >>> 32)))) * 31;
        long r31 = this.diskCleanInterval;
        int r32 = (((((r30 + ((int) (r31 ^ (r31 >>> 32)))) * 31) + this.mediaExpireDays) * 31) + this.lowDiskMediaExpireDays) * 31;
        if (this.enableExpiredMediaClean == false) goto L49;
        int r33 = 1231;
    L50:
        int r34 = (((((r32 + r33) * 31) + this.drivePreviewExpireDays) * 31) + this.lowDiskDrivePreviewExpireDays) * 31;
        if (this.enableExpiredDrivePreviewClean == true) goto L54;
        r1 = 1237;
    L54:
        int r35 = (((((((((((((((r34 + r1) * 31) + this.managedCacheExpireDays) * 31) + this.lowDiskManagedCacheExpireDays) * 31) + this.messageCacheExpireDays) * 31) + this.lowDiskMessageCacheExpireDays) * 31) + this.messageCacheKeepLatestMainConversationCount) * 31) + this.voicePreloadCacheExpireDays) * 31) + this.lowDiskVoicePreloadCacheExpireDays) * 31;
        Map<String, Long> r36 = this.diskModuleFileSizeThreshold;
        if (r36 != null) goto L57;
        int r37 = 0;
    L58:
        int r38 = (r35 + r37) * 31;
        List<String> r39 = this.diskModuleCleanBizBlackList;
        if (r39 != null) goto L61;
        int r40 = 0;
    L62:
        int r41 = (r38 + r40) * 31;
        h r42 = this.internalCleanPathBlackConfig;
        if (r42 != null) goto L65;
        int r43 = 0;
    L66:
        int r44 = (r41 + r43) * 31;
        h r45 = this.internalCleanPathWhiteConfig;
        if (r45 != null) goto L69;
        int r46 = 0;
    L70:
        int r47 = (r44 + r46) * 31;
        h r48 = this.externalCleanPathBlackConfig;
        if (r48 != null) goto L73;
        int r49 = 0;
    L74:
        int r50 = (r47 + r49) * 31;
        h r51 = this.externalCleanPathWhiteConfig;
        if (r51 == null) goto L79;
        r16 = r51.hashCode();
    L79:
        return r50 + r16;
    L73:
        r49 = r48.hashCode();
        goto L74
    L69:
        r46 = r45.hashCode();
        goto L70
    L65:
        r43 = r42.hashCode();
        goto L66
    L61:
        r40 = r39.hashCode();
        goto L62
    L57:
        r37 = r36.hashCode();
        goto L58
    L49:
        r33 = 1237;
        goto L50
    L45:
        r28 = 1237;
        goto L46
    L41:
        r25 = 1237;
        goto L42
    L37:
        r23 = 1237;
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = r15.hashCode();
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppDiskCleanConfig(enableDiskClean=" + this.enableDiskClean + ", enableManualDiskClean=" + this.enableManualDiskClean + ", manualDiskCleanUiTimeoutSeconds=" + this.manualDiskCleanUiTimeoutSeconds + ", enableLowDiskAutoClean=" + this.enableLowDiskAutoClean + ", lowDiskSpaceThreshold=" + this.lowDiskSpaceThreshold + ", enableLowDiskCleanCacheDir=" + this.enableLowDiskCleanCacheDir + ", enableCustomBizDiskClean=" + this.enableCustomBizDiskClean + ", geckoCleanConfig=" + this.geckoCleanConfig + ", enableExtendedAutoClean=" + this.enableExtendedAutoClean + ", enableFileUsageMonitor=" + this.enableFileUsageMonitor + ", fileUsageMonitorSampleRate=" + this.fileUsageMonitorSampleRate + ", fileUsageMonitorVersion=" + this.fileUsageMonitorVersion + ", enableManagedCacheClean=" + this.enableManagedCacheClean + ", enableDeleteUndeclaredPlugin=" + this.enableDeleteUndeclaredPlugin + ", keepExpiredPluginUntilInstallNew=" + this.keepExpiredPluginUntilInstallNew + ", customBizDiskCleanInterval=" + this.customBizDiskCleanInterval + ", diskCleanInterval=" + this.diskCleanInterval + ", mediaExpireDays=" + this.mediaExpireDays + ", lowDiskMediaExpireDays=" + this.lowDiskMediaExpireDays + ", enableExpiredMediaClean=" + this.enableExpiredMediaClean + ", drivePreviewExpireDays=" + this.drivePreviewExpireDays + ", lowDiskDrivePreviewExpireDays=" + this.lowDiskDrivePreviewExpireDays + ", enableExpiredDrivePreviewClean=" + this.enableExpiredDrivePreviewClean + ", managedCacheExpireDays=" + this.managedCacheExpireDays + ", lowDiskManagedCacheExpireDays=" + this.lowDiskManagedCacheExpireDays + ", messageCacheExpireDays=" + this.messageCacheExpireDays + ", lowDiskMessageCacheExpireDays=" + this.lowDiskMessageCacheExpireDays + ", messageCacheKeepLatestMainConversationCount=" + this.messageCacheKeepLatestMainConversationCount + ", voicePreloadCacheExpireDays=" + this.voicePreloadCacheExpireDays + ", lowDiskVoicePreloadCacheExpireDays=" + this.lowDiskVoicePreloadCacheExpireDays + ", diskModuleFileSizeThreshold=" + this.diskModuleFileSizeThreshold + ", diskModuleCleanBizBlackList=" + this.diskModuleCleanBizBlackList + ", internalCleanPathBlackConfig=" + this.internalCleanPathBlackConfig + ", internalCleanPathWhiteConfig=" + this.internalCleanPathWhiteConfig + ", externalCleanPathBlackConfig=" + this.externalCleanPathBlackConfig + ", externalCleanPathWhiteConfig=" + this.externalCleanPathWhiteConfig + ')';
    }

    public final long A() {
        return this.lowDiskSpaceThreshold;
    }

    public final int B() {
        return this.lowDiskVoicePreloadCacheExpireDays;
    }

    public final long C() {
        return this.manualDiskCleanUiTimeoutSeconds;
    }

    public final int D() {
        return this.mediaExpireDays;
    }

    public final int E() {
        return this.voicePreloadCacheExpireDays;
    }

    public final long a() {
        return this.customBizDiskCleanInterval;
    }

    public final long b() {
        return this.diskCleanInterval;
    }

    public final List<String> c() {
        return this.diskModuleCleanBizBlackList;
    }

    public final Map<String, Long> d() {
        return this.diskModuleFileSizeThreshold;
    }

    public final int e() {
        return this.drivePreviewExpireDays;
    }

    public final boolean f() {
        return this.enableCustomBizDiskClean;
    }

    public final boolean g() {
        return this.enableDeleteUndeclaredPlugin;
    }

    public final boolean h() {
        return this.enableDiskClean;
    }

    public final boolean i() {
        return this.enableExpiredDrivePreviewClean;
    }

    public final boolean j() {
        return this.enableExpiredMediaClean;
    }

    public final boolean k() {
        return this.enableExtendedAutoClean;
    }

    public final boolean l() {
        return this.enableFileUsageMonitor;
    }

    public final boolean m() {
        return this.enableLowDiskAutoClean;
    }

    public final boolean n() {
        return this.enableLowDiskCleanCacheDir;
    }

    public final boolean o() {
        return this.enableManagedCacheClean;
    }

    public final boolean p() {
        return this.enableManualDiskClean;
    }

    public final h q() {
        return this.externalCleanPathBlackConfig;
    }

    public final h r() {
        return this.externalCleanPathWhiteConfig;
    }

    public final float s() {
        return this.fileUsageMonitorSampleRate;
    }

    public final int t() {
        return this.fileUsageMonitorVersion;
    }

    public final g u() {
        return this.geckoCleanConfig;
    }

    public final h v() {
        return this.internalCleanPathBlackConfig;
    }

    public final h w() {
        return this.internalCleanPathWhiteConfig;
    }

    public final boolean x() {
        return this.keepExpiredPluginUntilInstallNew;
    }

    public final int y() {
        return this.lowDiskDrivePreviewExpireDays;
    }

    public final int z() {
        return this.lowDiskMediaExpireDays;
    }

    public a(Object r8) {
        g r9 = new g(null);
        Map<String, Long> r1 = MapsKt.emptyMap();
        List<String> r2 = CollectionsKt.emptyList();
        this.enableDiskClean = true;
        this.enableManualDiskClean = false;
        this.manualDiskCleanUiTimeoutSeconds = 120;
        this.enableLowDiskAutoClean = false;
        this.lowDiskSpaceThreshold = 3072;
        this.enableLowDiskCleanCacheDir = false;
        this.enableCustomBizDiskClean = false;
        this.geckoCleanConfig = r9;
        this.enableExtendedAutoClean = false;
        this.enableFileUsageMonitor = false;
        this.fileUsageMonitorSampleRate = 0.0f;
        this.fileUsageMonitorVersion = 0;
        this.enableManagedCacheClean = false;
        this.enableDeleteUndeclaredPlugin = false;
        this.keepExpiredPluginUntilInstallNew = true;
        this.customBizDiskCleanInterval = 604800000;
        this.diskCleanInterval = 86400000;
        this.mediaExpireDays = 14;
        this.lowDiskMediaExpireDays = 3;
        this.enableExpiredMediaClean = false;
        this.drivePreviewExpireDays = 30;
        this.lowDiskDrivePreviewExpireDays = 7;
        this.enableExpiredDrivePreviewClean = false;
        this.managedCacheExpireDays = 14;
        this.lowDiskManagedCacheExpireDays = 3;
        this.messageCacheExpireDays = 30;
        this.lowDiskMessageCacheExpireDays = 7;
        this.messageCacheKeepLatestMainConversationCount = 10;
        this.voicePreloadCacheExpireDays = 14;
        this.lowDiskVoicePreloadCacheExpireDays = 3;
        this.diskModuleFileSizeThreshold = r1;
        this.diskModuleCleanBizBlackList = r2;
        this.internalCleanPathBlackConfig = null;
        this.internalCleanPathWhiteConfig = null;
        this.externalCleanPathBlackConfig = null;
        this.externalCleanPathWhiteConfig = null;
    }
}
