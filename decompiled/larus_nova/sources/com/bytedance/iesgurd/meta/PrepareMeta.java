package com.bytedance.iesgurd.meta;

import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.policy.meta.MetaDataItemNew;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.strategy.f;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u000b\b\u0016¢\u0006\u0006\b¿\u0001\u0010À\u0001B\u001b\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020\r¢\u0006\u0006\b¿\u0001\u0010Á\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R$\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\r8\u0002X\u0083D¢\u0006\u0006\n\u0004\b(\u0010 R$\u0010)\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001a\u0010-\u001a\u00020,8\u0006X\u0087D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0083D¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R*\u0010>\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\bD\u00102\u001a\u0004\bE\u00104R\"\u0010F\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010 \u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\"\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00102\u001a\u0004\bJ\u00104\"\u0004\bK\u00106R\"\u0010L\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00102\u001a\u0004\bM\u00104\"\u0004\bN\u00106R\"\u0010O\u001a\u00020,8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010.\u001a\u0004\bP\u00100\"\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u00109\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u00102\u001a\u0004\be\u00104\"\u0004\bf\u00106R$\u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bh\u00102\u001a\u0004\bi\u00104R$\u0010j\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bj\u00102\u001a\u0004\bk\u00104R\"\u0010l\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010.\u001a\u0004\bm\u00100\"\u0004\bn\u0010RR\"\u0010o\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010.\u001a\u0004\bp\u00100\"\u0004\bq\u0010RR\"\u0010r\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010 \u001a\u0004\bs\u0010\"\"\u0004\bt\u0010$R\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010 R*\u0010w\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bw\u00102\u001a\u0004\bx\u00104\"\u0004\by\u00106R\"\u0010z\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u00109\u001a\u0004\b{\u0010[\"\u0004\b|\u0010]R$\u0010}\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010 \u001a\u0004\b~\u0010\"\"\u0004\b\u007f\u0010$R(\u0010\u0080\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010 \u001a\u0005\b\u0081\u0001\u0010\"\"\u0005\b\u0082\u0001\u0010$R&\u0010\u0083\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u00102\u001a\u0005\b\u0083\u0001\u00104\"\u0005\b\u0084\u0001\u00106R,\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R*\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R*\u0010\u009a\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u0095\u0001\u001a\u0006\b\u009b\u0001\u0010\u0097\u0001\"\u0006\b\u009c\u0001\u0010\u0099\u0001R*\u0010\u009d\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0095\u0001\u001a\u0006\b\u009e\u0001\u0010\u0097\u0001\"\u0006\b\u009f\u0001\u0010\u0099\u0001R&\u0010 \u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010.\u001a\u0005\b¡\u0001\u00100\"\u0005\b¢\u0001\u0010RR&\u0010£\u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010.\u001a\u0005\b¤\u0001\u00100\"\u0005\b¥\u0001\u0010RR&\u0010¦\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u00102\u001a\u0005\b§\u0001\u00104\"\u0005\b¨\u0001\u00106R(\u0010©\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010 \u001a\u0005\bª\u0001\u0010\"\"\u0005\b«\u0001\u0010$R\u001a\u0010¬\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010 R\u0018\u0010\u00ad\u0001\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010 R\u0018\u0010®\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010.R\u0018\u0010¯\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010.R\u0018\u0010°\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010.R\u0018\u0010±\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010.R\u0018\u0010²\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010.R*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R+\u0010º\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\bº\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMeta;", "", "", "updateOnDemandBySettings", "", "isOccasionUpdate", "uploadPrepareMeta", "Lorg/json/JSONObject;", "jsonObject", "putCommonData", "ignoreBlocks", "Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "getPackage", "", "toString", "checkValid", "Lcom/bytedance/iesgurd/core/ReqType;", "reqType", "initByRequest", "checkOnDemandWhenUpdate", "updateBlockType", "upload", "fullPackage", "Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "getFullPackage", "()Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "setFullPackage", "(Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;)V", "patch", "getPatch", "setPatch", "accessKey", "Ljava/lang/String;", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "resourceType", "groupName", "getGroupName", "setGroupName", "", "downloadDelay", "J", "getDownloadDelay", "()J", "useZstd", "Z", "getUseZstd", "()Z", "setUseZstd", "(Z)V", "", "onDemandEnum", "I", "usePcdn", "getUsePcdn", "setUsePcdn", "", "groups", "Ljava/util/List;", "getGroups", "()Ljava/util/List;", "setGroups", "(Ljava/util/List;)V", "needAppLog", "getNeedAppLog", "hashVersion", "getHashVersion", "setHashVersion", "onDemand", "getOnDemand", "setOnDemand", "alwaysOnDemand", "getAlwaysOnDemand", "setAlwaysOnDemand", "version", "getVersion", "setVersion", "(J)V", "metaReqType", "Lcom/bytedance/iesgurd/core/ReqType;", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "updatePriority", "getUpdatePriority", "()I", "setUpdatePriority", "(I)V", "Lcom/bytedance/iesgurd/core/BlockType;", "blockType", "Lcom/bytedance/iesgurd/core/BlockType;", "getBlockType", "()Lcom/bytedance/iesgurd/core/BlockType;", "setBlockType", "(Lcom/bytedance/iesgurd/core/BlockType;)V", "isSingleFile", "setSingleFile", "<set-?>", "ignoreStorage", "getIgnoreStorage", "ignoreBlockList", "getIgnoreBlockList", "localVersion", "getLocalVersion", "setLocalVersion", "localVersionOld", "getLocalVersionOld", "setLocalVersionOld", "oldVersionDir", "getOldVersionDir", "setOldVersionDir", "fullPatchStr", "value", "updateWithPatch", "getUpdateWithPatch", "setUpdateWithPatch", "notUsePatchReason", "getNotUsePatchReason", "setNotUsePatchReason", "logId", "getLogId", "setLogId", com.alipay.sdk.m.l.c.f25508m, "getApiVersion", "setApiVersion", "isRetry", "setRetry", "Lcom/bytedance/iesgurd/meta/c;", "statisticModel", "Lcom/bytedance/iesgurd/meta/c;", "getStatisticModel", "()Lcom/bytedance/iesgurd/meta/c;", "setStatisticModel", "(Lcom/bytedance/iesgurd/meta/c;)V", "Lny5/a;", "updateBuffer", "Lny5/a;", "getUpdateBuffer", "()Lny5/a;", "setUpdateBuffer", "(Lny5/a;)V", "Ljava/io/File;", "destDir", "Ljava/io/File;", "getDestDir", "()Ljava/io/File;", "setDestDir", "(Ljava/io/File;)V", "updatingDir", "getUpdatingDir", "setUpdatingDir", "downloadFile", "getDownloadFile", "setDownloadFile", "timeAddQueue", "getTimeAddQueue", "setTimeAddQueue", "timeUpdateStart", "getTimeUpdateStart", "setTimeUpdateStart", "inQueue", "getInQueue", "setInQueue", "preTriggerChannel", "getPreTriggerChannel", "setPreTriggerChannel", "odlFallbackReason", "odlUseUrl", "odlDuration", "odlP2PReceivedBytes", "odlCDNReceivedBytes", "originCDNDuration", "originCDNReceivedBytes", "Lcom/bytedance/geckox/model/UpdatePackage;", "pack", "Lcom/bytedance/geckox/model/UpdatePackage;", "getPack", "()Lcom/bytedance/geckox/model/UpdatePackage;", "setPack", "(Lcom/bytedance/geckox/model/UpdatePackage;)V", "isMiniApp", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setMiniApp", "(Ljava/lang/Boolean;)V", "<init>", "()V", "(Ljava/lang/String;Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class PrepareMeta {

    @SerializedName("access_key")
    private String accessKey;
    private boolean alwaysOnDemand;
    private String apiVersion;
    private BlockType blockType;

    @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
    private String channel;
    public File destDir;

    @SerializedName("download_delay")
    private final long downloadDelay;
    public File downloadFile;

    @SerializedName("package")
    private PrepareMetaPackage fullPackage;
    private String fullPatchStr;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("hash_version")
    private String hashVersion;
    private boolean ignoreBlockList;
    private boolean ignoreStorage;
    private boolean inQueue;
    private Boolean isMiniApp;
    private boolean isRetry;
    private boolean isSingleFile;
    private long localVersion;
    private long localVersionOld;
    private String logId;
    private ReqType metaReqType;

    @SerializedName("need_app_log")
    private final boolean needAppLog;
    private int notUsePatchReason;
    public long odlCDNReceivedBytes;
    public long odlDuration;
    public String odlFallbackReason;
    public long odlP2PReceivedBytes;
    public String odlUseUrl;
    private String oldVersionDir;
    private boolean onDemand;

    @SerializedName("on_demand")
    private final int onDemandEnum;
    public long originCDNDuration;
    public long originCDNReceivedBytes;
    public UpdatePackage pack;

    @SerializedName("patch")
    private PrepareMetaPackage patch;
    private String preTriggerChannel;
    private ReqType reqType;

    @SerializedName("resource_type")
    private final String resourceType;
    private c statisticModel;
    private long timeAddQueue;
    private long timeUpdateStart;
    private ny5.a updateBuffer;
    private int updatePriority;
    private boolean updateWithPatch;
    public File updatingDir;

    @SerializedName("use_pcdn")
    private boolean usePcdn;

    @SerializedName("use_zstd")
    private boolean useZstd;
    private long version;

    public final void ignoreBlocks() {
        this.ignoreStorage = true;
        this.ignoreBlockList = true;
    }

    public final void updateBlockType() {
        String r100 = null;
        this.blockType = null;
        if (checkOnDemandWhenUpdate() == false) goto L5;
        this.blockType = BlockType.LAZY_UPDATE;
        return;
    L5:
        Map<String, ConcurrentHashMap<String, MetaDataItemNew>> r101 = yy5.c.f569477a;
        long r102 = System.currentTimeMillis();
        String r103 = getAccessKey();
        Map<String, String> r104 = AppSettingsManager.b.f245071a.f245060a;
        if (r104 == null) goto L8;
        r100 = r104.get(r103);
    L8:
        if (r100 == null) goto L29;
        ConcurrentHashMap r110 = yy5.c.e(r103);
        if (r110 == null) goto L29;
        String r111 = getChannel();
        List<String> r105 = getGroups();
        if (r105 == null) goto L27;
        if (r105.contains(r100) == false) goto L27;
        if (r110.get(r111) != null) goto L19;
        r110.put(r111, new MetaDataItemNew(r102, false, 0, 6, null));
        Map<String, Boolean> r106 = yy5.c.f569479c;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(r103, Boolean.TRUE);
        goto L29
    L19:
        if (getInQueue() == true) goto L29;
        Object r108 = r110.get(r111);
        if (r108 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        if (((MetaDataItemNew) r108).getAllowUpdate() == true) goto L29;
        boolean r109 = true;
    L30:
        if (r109 == false) goto L33;
        this.blockType = BlockType.CLEAN_BLOCKLIST;
        return;
    L33:
        if (isOccasionUpdate() == false) goto L36;
        this.blockType = BlockType.OCCASION_UPDATE;
        return;
    L36:
        if (f.a(this) == true) goto L42;
        this.blockType = BlockType.LOW_STORAGE;
        return;
    L42:
        return;
    L27:
        if (r110.get(r111) == null) goto L29;
        r110.remove(r111);
        Map<String, Boolean> r112 = yy5.c.f569479c;
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;
        r113.put(r103, Boolean.TRUE);
    L29:
        r109 = false;
        goto L30
    }

    private final boolean isOccasionUpdate() {
        ReqType r100 = this.reqType;
        if (r100 != ReqType.POLLING) goto L5;
    L7:
        Map<String, Map<String, DeploymentsData>> r101 = cz5.a.f466050a;
        Map<String, Map<String, DeploymentsData>> r102 = cz5.a.f466050a;
        monitor-enter(r102);
        Iterator r103 = ((HashMap) r102).values().iterator();     // Catch: Throwable -> L21
    L11:
        if (r103.hasNext() == false) goto L18;
        DeploymentsData r104 = (DeploymentsData) ((Map) r103.next()).get(getAccessKey());     // Catch: Throwable -> L21
        if (r104 == null) goto L11;
        if (r104.isHit(getGroups(), getChannel()) == false) goto L11;
        monitor-exit(r102);
        return true;
    L18:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r102);
        return false;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r100 == ReqType.QUEUE) goto L7;
        return false;
    }

    private final void updateOnDemandBySettings() {
        AppSettingsManager.IGeckoAppSettings r100 = AppSettingsManager.b.f245071a.b();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getOnDemandPolicy() != 0) goto L7;
        return;
    L7:
        Map<String, Resources> r101 = r100.getOnDemandList();
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
        return;
    L16:
        Resources r103 = r100.getOnDemandList().get(this.accessKey);
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.getChannels() != null) goto L24;
        if (r103.getGroups() != null) goto L24;
        return;
    L24:
        if (r103.isHit$geckox_noasanRelease(this.groups, this.channel) == true) goto L27;
        return;
    L27:
        if (r100.getOnDemandPolicy() != 1) goto L30;
        this.onDemand = true;
        return;
    L30:
        if (r100.getOnDemandPolicy() != 2) goto L36;
        this.onDemand = true;
        this.alwaysOnDemand = true;
        return;
    L36:
        return;
    L10:
        if (r101.isEmpty() == true) goto L13;
        r102 = false;
        goto L14
    }

    private final void uploadPrepareMeta() {
        JSONObject r100 = new JSONObject();
        putCommonData(r100);
        if (this.usePcdn == false) goto L5;
        r100.put("use_pcdn", 1);
    L5:
        PrepareMetaPackage r101 = this.fullPackage;
        if (r101 == null) goto L10;
        UltraUpdateResource r102 = r101.getUltraUpdateResource();
        if (r102 == null) goto L10;
        r100.put("ultra_update_resource", r102.toString());
    L10:
        y86.a.c("geckosdk_prepare_meta_stats", r100);
    }

    public final String checkValid() {
        String r100 = this.accessKey;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L34;
        String r103 = this.channel;
        if (r103 != null) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == true) goto L34;
        if (getVersion() <= 0) goto L34;
        PrepareMetaPackage r104 = this.fullPackage;
        if (r104 != null) goto L22;
    L25:
        PrepareMetaPackage r105 = this.patch;
        if (r105 != null) goto L28;
        return null;
    L28:
        if (r105.checkValid() == false) goto L30;
        return null;
    L30:
        return String.valueOf(this.patch);
    L22:
        if (r104.checkValid() == true) goto L25;
        return String.valueOf(this.fullPackage);
    L13:
        if (r103.length() != 0) goto L15;
    L34:
        return toString();
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final File getDestDir() {
        File r100 = this.destDir;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("destDir");
    L5:
        return r100;
    }

    public final File getDownloadFile() {
        File r100 = this.downloadFile;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("downloadFile");
    L5:
        return r100;
    }

    public final UpdatePackage getPack() {
        UpdatePackage r100 = this.pack;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pack");
    L5:
        return r100;
    }

    public final PrepareMetaPackage getPackage() {
        if (this.updateWithPatch == false) goto L7;
        PrepareMetaPackage r100 = this.patch;
        if (r100 != null) goto L10;
    L6:
        Intrinsics.throwNpe();
    L10:
        return r100;
    L7:
        r100 = this.fullPackage;
        if (r100 != null) goto L10;
        goto L10
    }

    public final File getUpdatingDir() {
        File r100 = this.updatingDir;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("updatingDir");
    L5:
        return r100;
    }

    public final long getVersion() {
        PrepareMetaPackage r100 = this.fullPackage;
        if (r100 == null) goto L6;
        return r100.getId();
    L6:
        return this.version;
    }

    public String toString() {
        return this.accessKey + '-' + this.channel + '-' + getVersion() + '-' + this.fullPatchStr;
    }

    public final void upload() {
        JSONObject r100 = new JSONObject();
        putCommonData(r100);
        r100.put("time_update_start", this.timeUpdateStart);
        r100.put("dur_wait_download", this.timeUpdateStart - this.timeAddQueue);
        r100.put("meta_req_type", this.metaReqType.getType());
        long r101 = this.localVersionOld;
        if (r101 == 0) goto L5;
        r100.put("local_version_old", r101);
    L5:
        int r102 = this.notUsePatchReason;
        if (r102 == 0) goto L8;
        r100.put("not_use_patch_reason", r102);
    L8:
        Long r103 = null;
        if (this.updateWithPatch == false) goto L14;
        PrepareMetaPackage r104 = this.patch;
        if (r104 == null) goto L13;
        r103 = Long.valueOf(r104.getLength());
    L13:
        r100.put(EventConstants.ExtraJson.PACKAGE_SIZE, r103);
    L18:
        c r105 = this.statisticModel;
        boolean r106 = false;
        if (r105 == null) goto L65;
        r100.put("update_result", !r105.f250770a ? 1 : 0);
        long r107 = r105.f250771b;
        if (r107 <= 0) goto L23;
        r100.put("dur_total", r107);
    L23:
        long r108 = r105.f250772c;
        if (r108 <= 0) goto L26;
        r100.put("dur_last_stage", r108);
    L26:
        long r109 = r105.f250773d;
        if (r109 <= 0) goto L29;
        r100.put("dur_download", r109);
    L29:
        long r110 = r105.f250774e;
        if (r110 <= 0) goto L32;
        r100.put("dur_download_last_time", r110);
    L32:
        long r111 = r105.f250775f;
        if (r111 <= 0) goto L35;
        r100.put("dur_active", r111);
    L35:
        long r112 = r105.f250776g;
        if (r112 <= 0) goto L38;
        r100.put("dur_unzip", r112);
    L38:
        long r113 = r105.f250777h;
        if (r113 <= 0) goto L41;
        r100.put("dur_decompress_zstd", r113);
    L41:
        long r114 = r105.f250778i;
        if (r114 <= 0) goto L44;
        r100.put("dur_bytepatch", r114);
    L44:
        long r115 = r105.f250779j;
        if (r115 <= 0) goto L47;
        r100.put("dur_zip_patch", r115);
    L47:
        Iterator r116 = ((HashMap) r105.f250780k).values().iterator();
    L49:
        if (r116.hasNext() == false) goto L65;
        c.a r117 = (c.a) r116.next();
        r117.getClass();
        r100.put(r117.f250787g + "result", !r117.f250781a ? 1 : 0);
        r100.put(r117.f250787g + "url", r117.f250784d);
        String r118 = r117.f250783c;
        if (r118 != null) goto L53;
    L56:
        boolean r119 = true;
    L57:
        if (r119 == true) goto L60;
        r100.put(r117.f250787g + LocationMonitorConst.ERR_MSG, r117.f250783c);
    L60:
        if (r117.f250782b == 0) goto L63;
        r100.put(r117.f250787g + "err_code", r117.f250782b);
    L63:
        if (r117.f250785e <= 0) goto L49;
        r100.put(r117.f250787g + "download_failed_times", r117.f250785e);
        goto L49
    L53:
        if (r118.length() == 0) goto L56;
        r119 = false;
    L65:
        String r120 = this.preTriggerChannel;
        if (r120 == null) goto L69;
        r100.put("pre_trigger_channel", r120);
    L69:
        if (this.isRetry == false) goto L72;
        r100.put("is_retry", 1);
    L72:
        if (this.usePcdn == false) goto L78;
        r100.put("should_use_odl", 1);
        String r121 = this.odlFallbackReason;
        if (r121 != null) goto L76;
        r121 = "";
    L76:
        r100.put("odl_fallback_reason", r121);
        r100.put("odl_use_url", this.odlUseUrl);
        r100.put("odl_duration", this.odlDuration);
        r100.put("odl_p2p_received_bytes", this.odlP2PReceivedBytes);
        r100.put("odl_cdn_received_bytes", this.odlCDNReceivedBytes);
        r100.put("origin_cdn_duration", this.originCDNDuration);
        r100.put("origin_cdn_received_bytes", this.originCDNReceivedBytes);
    L78:
        if (Intrinsics.areEqual(this.isMiniApp, Boolean.TRUE) == false) goto L81;
        r100.put("is_mini_app", 1);
    L81:
        if (this.oldVersionDir.length() <= 0) goto L83;
        r106 = true;
    L83:
        if (r106 == false) goto L85;
        r100.put("custom_old_version_dir", this.oldVersionDir);
    L85:
        y86.a.c("geckosdk_update_aggr_stats", r100);
        return;
    L14:
        PrepareMetaPackage r122 = this.fullPackage;
        if (r122 == null) goto L17;
        r103 = Long.valueOf(r122.getLength());
    L17:
        r100.put(EventConstants.ExtraJson.PACKAGE_SIZE, r103);
        goto L18
    }

    public PrepareMeta() {
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        ReqType r100 = ReqType.NONE;
        this.metaReqType = r100;
        this.reqType = r100;
        this.updatePriority = -1;
        this.oldVersionDir = "";
        this.fullPatchStr = "full";
        this.odlUseUrl = "";
        this.odlDuration = -1;
        this.odlP2PReceivedBytes = -1;
        this.odlCDNReceivedBytes = -1;
        this.originCDNDuration = -1;
        this.originCDNReceivedBytes = -1;
    }

    public final boolean checkOnDemandWhenUpdate() {
        updateOnDemandBySettings();
        if (this.onDemand == true) goto L5;
        return false;
    L5:
        String r100 = this.accessKey;
        String r101 = this.channel;
        if (this.alwaysOnDemand == false) goto L8;
        return true;
    L8:
        if (com.bytedance.iesgurd.utils.a.b(r100, r101) == false) goto L13;
        GeckoLogger.d(r100 + '-' + r101 + " used, do update");
        return false;
    L13:
        return true;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getAlwaysOnDemand() {
        return this.alwaysOnDemand;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final BlockType getBlockType() {
        return this.blockType;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final long getDownloadDelay() {
        return this.downloadDelay;
    }

    public final PrepareMetaPackage getFullPackage() {
        return this.fullPackage;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final String getHashVersion() {
        return this.hashVersion;
    }

    public final boolean getIgnoreBlockList() {
        return this.ignoreBlockList;
    }

    public final boolean getIgnoreStorage() {
        return this.ignoreStorage;
    }

    public final boolean getInQueue() {
        return this.inQueue;
    }

    public final long getLocalVersion() {
        return this.localVersion;
    }

    public final long getLocalVersionOld() {
        return this.localVersionOld;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final boolean getNeedAppLog() {
        return this.needAppLog;
    }

    public final int getNotUsePatchReason() {
        return this.notUsePatchReason;
    }

    public final String getOldVersionDir() {
        return this.oldVersionDir;
    }

    public final boolean getOnDemand() {
        return this.onDemand;
    }

    public final PrepareMetaPackage getPatch() {
        return this.patch;
    }

    public final String getPreTriggerChannel() {
        return this.preTriggerChannel;
    }

    public final ReqType getReqType() {
        return this.reqType;
    }

    public final c getStatisticModel() {
        return this.statisticModel;
    }

    public final long getTimeAddQueue() {
        return this.timeAddQueue;
    }

    public final long getTimeUpdateStart() {
        return this.timeUpdateStart;
    }

    public final ny5.a getUpdateBuffer() {
        return this.updateBuffer;
    }

    public final int getUpdatePriority() {
        return this.updatePriority;
    }

    public final boolean getUpdateWithPatch() {
        return this.updateWithPatch;
    }

    public final boolean getUsePcdn() {
        return this.usePcdn;
    }

    public final boolean getUseZstd() {
        return this.useZstd;
    }

    public final Boolean isMiniApp() {
        return this.isMiniApp;
    }

    public final boolean isRetry() {
        return this.isRetry;
    }

    public final boolean isSingleFile() {
        return this.isSingleFile;
    }

    private final void putCommonData(JSONObject r100) {
        r100.put("access_key", this.accessKey);
        r100.put("channel", this.channel);
        r100.put("req_type", this.reqType.getType());
        r100.put("id", getVersion());
        r100.put("is_zstd", this.useZstd ? 1 : 0);
        r100.put("api_version", this.apiVersion);
        r100.put("update_priority", this.updatePriority);
        r100.put("hash_version", this.hashVersion);
        boolean r101 = true;
        if (this.isSingleFile == false) goto L5;
        r100.put("is_single_file", 1);
    L5:
        String r102 = this.groupName;
        if (r102 == null) goto L8;
        r100.put("group_name", r102);
    L8:
        String r103 = this.logId;
        if (r103 != null) goto L11;
    L14:
        if (r101 == true) goto L16;
        r100.put("x_tt_logid", this.logId);
    L16:
        long r104 = this.localVersion;
        if (r104 == 0) goto L19;
        r100.put("local_version", r104);
    L19:
        PrepareMetaPackage r105 = this.patch;
        if (r105 == null) goto L24;
        if (r105 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r100.put("patch_id", r105.getId());
    L24:
        BlockType r106 = this.blockType;
        if (r106 == null) goto L27;
        r100.put("block_type", r106.getType());
    L27:
        long r107 = this.downloadDelay;
        if (r107 <= 0) goto L30;
        r100.put("download_delay", r107);
    L30:
        List<String> r108 = this.groups;
        if (r108 == null) goto L34;
        r100.put("groups", r108.toString());
        return;
    L34:
        return;
    L11:
        if (r103.length() == 0) goto L14;
        r101 = false;
        goto L14
    }

    public final void initByRequest(ReqType r100) {
        this.pack = new UpdatePackage(this.accessKey, this.channel, getVersion());
        this.reqType = r100;
        this.metaReqType = r100;
        this.isSingleFile = Intrinsics.areEqual(this.resourceType, "UNCOMPRESSED_SINGLE_FILE");
        int r101 = this.onDemandEnum;
        if (r101 != 1) goto L6;
        this.onDemand = true;
    L9:
        if (this.needAppLog == true) goto L11;
        int r102 = ry5.a.f539908a;
        return;
    L11:
        updateBlockType();
        uploadPrepareMeta();
        return;
    L6:
        if (r101 != 2) goto L9;
        this.onDemand = true;
        this.alwaysOnDemand = true;
        goto L9
    }

    public final void setAccessKey(String r100) {
        this.accessKey = r100;
    }

    public final void setAlwaysOnDemand(boolean r100) {
        this.alwaysOnDemand = r100;
    }

    public final void setApiVersion(String r100) {
        this.apiVersion = r100;
    }

    public final void setBlockType(BlockType r100) {
        this.blockType = r100;
    }

    public final void setChannel(String r100) {
        this.channel = r100;
    }

    public final void setDestDir(File r100) {
        this.destDir = r100;
    }

    public final void setDownloadFile(File r100) {
        this.downloadFile = r100;
    }

    public final void setFullPackage(PrepareMetaPackage r100) {
        this.fullPackage = r100;
    }

    public final void setGroupName(String r100) {
        this.groupName = r100;
    }

    public final void setGroups(List<String> r100) {
        this.groups = r100;
    }

    public final void setHashVersion(String r100) {
        this.hashVersion = r100;
    }

    public final void setInQueue(boolean r100) {
        this.inQueue = r100;
    }

    public final void setLocalVersion(long r100) {
        this.localVersion = r100;
    }

    public final void setLocalVersionOld(long r100) {
        this.localVersionOld = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setMiniApp(Boolean r100) {
        this.isMiniApp = r100;
    }

    public final void setNotUsePatchReason(int r100) {
        this.notUsePatchReason = r100;
    }

    public final void setOldVersionDir(String r100) {
        this.oldVersionDir = r100;
    }

    public final void setOnDemand(boolean r100) {
        this.onDemand = r100;
    }

    public final void setPack(UpdatePackage r100) {
        this.pack = r100;
    }

    public final void setPatch(PrepareMetaPackage r100) {
        this.patch = r100;
    }

    public final void setPreTriggerChannel(String r100) {
        this.preTriggerChannel = r100;
    }

    public final void setReqType(ReqType r100) {
        this.reqType = r100;
    }

    public final void setRetry(boolean r100) {
        this.isRetry = r100;
    }

    public final void setSingleFile(boolean r100) {
        this.isSingleFile = r100;
    }

    public final void setStatisticModel(c r100) {
        this.statisticModel = r100;
    }

    public final void setTimeAddQueue(long r100) {
        this.timeAddQueue = r100;
    }

    public final void setTimeUpdateStart(long r100) {
        this.timeUpdateStart = r100;
    }

    public final void setUpdateBuffer(ny5.a r100) {
        this.updateBuffer = r100;
    }

    public final void setUpdatePriority(int r100) {
        this.updatePriority = r100;
    }

    public final void setUpdateWithPatch(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "patch";
    L5:
        this.fullPatchStr = r101;
        this.updateWithPatch = r100;
        return;
    L4:
        r101 = "full";
        goto L5
    }

    public final void setUpdatingDir(File r100) {
        this.updatingDir = r100;
    }

    public final void setUsePcdn(boolean r100) {
        this.usePcdn = r100;
    }

    public final void setUseZstd(boolean r100) {
        this.useZstd = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }

    public PrepareMeta(String r110, String r111) {
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        ReqType r100 = ReqType.NONE;
        this.metaReqType = r100;
        this.reqType = r100;
        this.updatePriority = -1;
        this.oldVersionDir = "";
        this.fullPatchStr = "full";
        this.odlUseUrl = "";
        this.odlDuration = -1;
        this.odlP2PReceivedBytes = -1;
        this.odlCDNReceivedBytes = -1;
        this.originCDNDuration = -1;
        this.originCDNReceivedBytes = -1;
        this.channel = r111;
        this.accessKey = r110;
        this.pack = new UpdatePackage(r110, r111, 0, 4, null);
    }
}
