package com.larus.platform.model.chat;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0013\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003Jì\u0001\u0010>\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006E"}, d2 = {"Lcom/larus/platform/model/chat/FlowMultiUploadConfig;", "", "uploadFileAllowedTypes", "", "", "driveUploadFileAllowedTypes", "uploadFileMaxSize", "", "uploadMultiEntityConf", "Lcom/larus/platform/model/chat/UploadMultiEntityConf;", "uploadAudioEntityConf", "Lcom/larus/platform/model/chat/UploadAudioEntityConf;", "enableLarkAudioAbility", "", "uploadVideoEntityConf", "Lcom/larus/platform/model/chat/UploadVideoEntityConf;", "downloadVideoEntityConf", "Lcom/larus/platform/model/chat/DownloadVideoEntityConf;", "taskModeFileTypeWhitelist", "taskModeFileTypeBlacklist", "enterpriseFileTypeWhitelist", "enterpriseFileTypeBlacklist", "taskModeUploadMaxSize", "normalModeFileTypeBlacklist", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lcom/larus/platform/model/chat/UploadMultiEntityConf;Lcom/larus/platform/model/chat/UploadAudioEntityConf;ZLcom/larus/platform/model/chat/UploadVideoEntityConf;Lcom/larus/platform/model/chat/DownloadVideoEntityConf;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/util/List;)V", "getUploadFileAllowedTypes", "()Ljava/util/List;", "getDriveUploadFileAllowedTypes", "getUploadFileMaxSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUploadMultiEntityConf", "()Lcom/larus/platform/model/chat/UploadMultiEntityConf;", "getUploadAudioEntityConf", "()Lcom/larus/platform/model/chat/UploadAudioEntityConf;", "getEnableLarkAudioAbility", "()Z", "getUploadVideoEntityConf", "()Lcom/larus/platform/model/chat/UploadVideoEntityConf;", "getDownloadVideoEntityConf", "()Lcom/larus/platform/model/chat/DownloadVideoEntityConf;", "getTaskModeFileTypeWhitelist", "getTaskModeFileTypeBlacklist", "getEnterpriseFileTypeWhitelist", "getEnterpriseFileTypeBlacklist", "getTaskModeUploadMaxSize", "getNormalModeFileTypeBlacklist", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lcom/larus/platform/model/chat/UploadMultiEntityConf;Lcom/larus/platform/model/chat/UploadAudioEntityConf;ZLcom/larus/platform/model/chat/UploadVideoEntityConf;Lcom/larus/platform/model/chat/DownloadVideoEntityConf;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/util/List;)Lcom/larus/platform/model/chat/FlowMultiUploadConfig;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName("download_video_entity_conf")
    private final r downloadVideoEntityConf;

    @SerializedName("drive_upload_file_allowed_types")
    private final List<String> driveUploadFileAllowedTypes;

    @SerializedName("enable_lark_audio_ability")
    private final boolean enableLarkAudioAbility;

    @SerializedName("enterprise_file_type_blacklist")
    private final List<String> enterpriseFileTypeBlacklist;

    @SerializedName("enterprise_file_type_whitelist")
    private final List<String> enterpriseFileTypeWhitelist;

    @SerializedName("normal_mode_file_type_blacklist")
    private final List<String> normalModeFileTypeBlacklist;

    @SerializedName("task_mode_file_type_blacklist")
    private final List<String> taskModeFileTypeBlacklist;

    @SerializedName("task_mode_file_type_whitelist")
    private final List<String> taskModeFileTypeWhitelist;

    @SerializedName("task_mode_upload_max_size")
    private final Long taskModeUploadMaxSize;

    @SerializedName("upload_audio_entity_conf")
    private final r0 uploadAudioEntityConf;

    @SerializedName("upload_file_allowed_types")
    private final List<String> uploadFileAllowedTypes;

    @SerializedName("upload_file_max_size")
    private final Long uploadFileMaxSize;

    @SerializedName("upload_multi_entity_conf")
    private final s0 uploadMultiEntityConf;

    @SerializedName("upload_video_entity_conf")
    private final t0 uploadVideoEntityConf;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.uploadFileAllowedTypes, r101.uploadFileAllowedTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.driveUploadFileAllowedTypes, r101.driveUploadFileAllowedTypes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadFileMaxSize, r101.uploadFileMaxSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadMultiEntityConf, r101.uploadMultiEntityConf) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uploadAudioEntityConf, r101.uploadAudioEntityConf) == true) goto L24;
        return false;
    L24:
        if (this.enableLarkAudioAbility == r101.enableLarkAudioAbility) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadVideoEntityConf, r101.uploadVideoEntityConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadVideoEntityConf, r101.downloadVideoEntityConf) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskModeFileTypeWhitelist, r101.taskModeFileTypeWhitelist) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.taskModeFileTypeBlacklist, r101.taskModeFileTypeBlacklist) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enterpriseFileTypeWhitelist, r101.enterpriseFileTypeWhitelist) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.enterpriseFileTypeBlacklist, r101.enterpriseFileTypeBlacklist) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskModeUploadMaxSize, r101.taskModeUploadMaxSize) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.normalModeFileTypeBlacklist, r101.normalModeFileTypeBlacklist) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.uploadFileAllowedTypes;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.driveUploadFileAllowedTypes;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.uploadFileMaxSize;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        s0 r110 = this.uploadMultiEntityConf;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        r0 r113 = this.uploadAudioEntityConf;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.enableLarkAudioAbility == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        t0 r118 = this.uploadVideoEntityConf;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        r r121 = this.downloadVideoEntityConf;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        List<String> r124 = this.taskModeFileTypeWhitelist;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        List<String> r127 = this.taskModeFileTypeBlacklist;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        List<String> r130 = this.enterpriseFileTypeWhitelist;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        List<String> r133 = this.enterpriseFileTypeBlacklist;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Long r136 = this.taskModeUploadMaxSize;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        List<String> r139 = this.normalModeFileTypeBlacklist;
        if (r139 == null) goto L59;
        r101 = r139.hashCode();
    L59:
        return r138 + r101;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "FlowMultiUploadConfig(uploadFileAllowedTypes=" + this.uploadFileAllowedTypes + ", driveUploadFileAllowedTypes=" + this.driveUploadFileAllowedTypes + ", uploadFileMaxSize=" + this.uploadFileMaxSize + ", uploadMultiEntityConf=" + this.uploadMultiEntityConf + ", uploadAudioEntityConf=" + this.uploadAudioEntityConf + ", enableLarkAudioAbility=" + this.enableLarkAudioAbility + ", uploadVideoEntityConf=" + this.uploadVideoEntityConf + ", downloadVideoEntityConf=" + this.downloadVideoEntityConf + ", taskModeFileTypeWhitelist=" + this.taskModeFileTypeWhitelist + ", taskModeFileTypeBlacklist=" + this.taskModeFileTypeBlacklist + ", enterpriseFileTypeWhitelist=" + this.enterpriseFileTypeWhitelist + ", enterpriseFileTypeBlacklist=" + this.enterpriseFileTypeBlacklist + ", taskModeUploadMaxSize=" + this.taskModeUploadMaxSize + ", normalModeFileTypeBlacklist=" + this.normalModeFileTypeBlacklist + ')';
    }

    public final r a() {
        return this.downloadVideoEntityConf;
    }

    public final List<String> b() {
        return this.driveUploadFileAllowedTypes;
    }

    public final boolean c() {
        return this.enableLarkAudioAbility;
    }

    public final List<String> d() {
        return this.enterpriseFileTypeBlacklist;
    }

    public final List<String> e() {
        return this.enterpriseFileTypeWhitelist;
    }

    public final List<String> f() {
        return this.normalModeFileTypeBlacklist;
    }

    public final List<String> g() {
        return this.taskModeFileTypeBlacklist;
    }

    public final List<String> h() {
        return this.taskModeFileTypeWhitelist;
    }

    public final Long i() {
        return this.taskModeUploadMaxSize;
    }

    public final r0 j() {
        return this.uploadAudioEntityConf;
    }

    public final List<String> k() {
        return this.uploadFileAllowedTypes;
    }

    public final Long l() {
        return this.uploadFileMaxSize;
    }

    public final s0 m() {
        return this.uploadMultiEntityConf;
    }

    public final t0 n() {
        return this.uploadVideoEntityConf;
    }

    public /* synthetic */ t(int r510) {
        int r100 = 0;
        this(CollectionsKt.listOf(new String[]{"csv", ExportFileExtension.PDF, "txt", "xls", "xlsx", "ppt", ExportFileExtension.PPTX, "doc", DocumentType.DOCX_NAME, "json", "log", "md", "ini", "cfg", "yaml", "sql", "java", "py", "cpp", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "php", GXTemplateKey.GAIAX_JS, GXTemplateKey.GAIAX_CSS, "scss", "less", "jsx", "ts", "bat", "sh", "yml", "asp", "aspx", "jsp", "cgi", "pl", "rb", "lua", "ps1", "conf", "gitignore", "htaccess", "dat", "tab", "tex", "html", "h", "go", "tsx", "c", "py3", "cxx", "cc", "mobi", "epub", "tiff", "dng"}), null, Long.valueOf(com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_CHECK_BYTES), new s0(0), new r0(r100), false, new t0(r100), new r(0), null, null, null, null, 524288000L, null);
    }

    public t(List<String> r100, List<String> r101, Long r102, s0 r103, r0 r104, boolean r105, t0 r106, r r107, List<String> r108, List<String> r110, List<String> r111, List<String> r112, Long r113, List<String> r114) {
        this.uploadFileAllowedTypes = r100;
        this.driveUploadFileAllowedTypes = r101;
        this.uploadFileMaxSize = r102;
        this.uploadMultiEntityConf = r103;
        this.uploadAudioEntityConf = r104;
        this.enableLarkAudioAbility = r105;
        this.uploadVideoEntityConf = r106;
        this.downloadVideoEntityConf = r107;
        this.taskModeFileTypeWhitelist = r108;
        this.taskModeFileTypeBlacklist = r110;
        this.enterpriseFileTypeWhitelist = r111;
        this.enterpriseFileTypeBlacklist = r112;
        this.taskModeUploadMaxSize = r113;
        this.normalModeFileTypeBlacklist = r114;
    }
}
