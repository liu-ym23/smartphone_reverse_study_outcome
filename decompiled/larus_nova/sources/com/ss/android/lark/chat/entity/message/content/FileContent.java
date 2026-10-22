package com.ss.android.lark.chat.entity.message.content;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002OPB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0012\u0010G\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0015\u0010K\u001a\u0004\u0018\u00010\u001f2\u0006\u0010L\u001a\u00020M¢\u0006\u0002\u0010NR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R6\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000202`3X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010!\"\u0004\b@\u0010#R\u001c\u0010A\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001c\u0010D\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000b¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "Lcom/ss/android/lark/chat/entity/message/content/BaseFileContent;", "<init>", "()V", "content", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent;)V", "mime", "", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "filePath", "getFilePath", "setFilePath", "uriString", "getUriString", "setUriString", "fileState", "Lcom/ss/android/lark/chat/entity/message/content/FileState;", "getFileState", "()Lcom/ss/android/lark/chat/entity/message/content/FileState;", "setFileState", "(Lcom/ss/android/lark/chat/entity/message/content/FileState;)V", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "speed", "", "getSpeed", "()J", "setSpeed", "(J)V", "isEncrypted", "", "()Z", "setEncrypted", "(Z)V", "riskObjectKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRiskObjectKeys", "()Ljava/util/ArrayList;", "setRiskObjectKeys", "(Ljava/util/ArrayList;)V", "previewHangPoints", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Lkotlin/collections/LinkedHashMap;", "getPreviewHangPoints", "()Ljava/util/LinkedHashMap;", "setPreviewHangPoints", "(Ljava/util/LinkedHashMap;)V", "fileAbility", "Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", "getFileAbility", "()Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", "setFileAbility", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;)V", "lastUpdateTime", "getLastUpdateTime", "setLastUpdateTime", "lastUpdateChatterName", "getLastUpdateChatterName", "setLastUpdateChatterName", "fileUploadId", "getFileUploadId", "setFileUploadId", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "isItemSame", "getFd", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Long;", "Companion", "FileAbility", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "FileContent")
public final class FileContent extends BaseFileContent<FileContent> {
    public static final a Companion = null;
    private FileAbility fileAbility;
    private String filePath;
    private FileState fileState;
    private String fileUploadId;
    private boolean isEncrypted;
    private String lastUpdateChatterName;
    private long lastUpdateTime;
    private String mime;
    private LinkedHashMap<String, PreviewHangPoint> previewHangPoints;
    private int progress;
    private ArrayList<String> riskObjectKeys;
    private long speed;
    private String uriString;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SUPPORT_EDIT", "SUPPORT_PREVIEW", "NOT_SUPPORT_PREVIEW", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileAbility extends Enum<FileAbility> {
        public static final a Companion = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileAbility[] f415333a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415334b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FileAbility> getEntries() {
            return f415334b;
        }

        static {
            FileAbility r100 = new FileAbility("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FileAbility r101 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r101;
            FileAbility r102 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r102;
            FileAbility r103 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r103;
            FileAbility[] r104 = {r100, r101, r102, r103};
            f415333a = r104;
            f415334b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static FileAbility[] values() {
            return (FileAbility[]) f415333a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FileAbility fromValue(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L14;
            return UNKNOWN;
        L14:
            return NOT_SUPPORT_PREVIEW;
        L15:
            return SUPPORT_PREVIEW;
        L12:
            return SUPPORT_EDIT;
        }

        public static FileAbility valueOf(String r100) {
            return (FileAbility) r27.a.a(FileAbility.class, r100);
        }

        public FileAbility(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FileContent() {
        this.mime = "";
        this.fileState = FileState.DOWNLOAD;
        this.previewHangPoints = new LinkedHashMap();
    }

    public final FileAbility getFileAbility() {
        return this.fileAbility;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final FileState getFileState() {
        return this.fileState;
    }

    public final String getFileUploadId() {
        return this.fileUploadId;
    }

    public final String getLastUpdateChatterName() {
        return this.lastUpdateChatterName;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final String getMime() {
        return this.mime;
    }

    public final LinkedHashMap<String, PreviewHangPoint> getPreviewHangPoints() {
        return this.previewHangPoints;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final ArrayList<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public final long getSpeed() {
        return this.speed;
    }

    public final String getUriString() {
        return this.uriString;
    }

    public final boolean isEncrypted() {
        return this.isEncrypted;
    }

    public FileContent(FileContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.mime = "";
        this.fileState = FileState.DOWNLOAD;
        this.previewHangPoints = new LinkedHashMap();
        setKey(r100.getKey());
        setName(r100.getName());
        setSize(r100.getSize());
        this.mime = r100.mime;
        this.filePath = r100.filePath;
        setNameSpace(r100.getNameSpace());
        setSource(r100.getSource());
        setSaveToDrive(r100.getSaveToDrive());
        this.progress = r100.progress;
        this.fileState = r100.fileState;
        setInMyNutStore(r100.isInMyNutStore());
        setLanTransStatus(r100.getLanTransStatus());
        this.uriString = r100.uriString;
        this.speed = r100.speed;
        this.isEncrypted = r100.isEncrypted;
        this.riskObjectKeys = r100.riskObjectKeys;
        this.previewHangPoints = r100.previewHangPoints;
        this.fileAbility = r100.fileAbility;
        this.lastUpdateTime = r100.lastUpdateTime;
        this.lastUpdateChatterName = r100.lastUpdateChatterName;
        this.fileUploadId = r100.fileUploadId;
    }

    public final Long getFd(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = this.uriString;
        if (r101 == null) goto L20;
        Uri r102 = UriProtector.parse(r101);
        ContentResolver r103 = r100.getContentResolver();
        if (r103 == null) goto L20;
        ParcelFileDescriptor r104 = a(r103, r102);     // Catch: Exception -> L8
    L17:
        if (r104 == null) goto L20;
        return Long.valueOf(r104.detachFd());
    L8:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L12;
    L15:
        Log.e("FileContent", "cannot open fd in r, message: " + e.getMessage() + ", uri: " + this.uriString);
    L16:
        r104 = null;
        goto L17
    L12:
        if ((e instanceof SecurityException) == true) goto L15;
        Log.e("FileContent", "cannot open fd in r, message: " + e.getMessage() + ", uri: " + this.uriString);
    L20:
        return null;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if (super.isContentSame(r100) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FileContent) == false) goto L47;
        FileContent r101 = (FileContent) r100;
        if (this.progress == r101.progress) goto L9;
        return false;
    L9:
        if (this.speed == r101.speed) goto L11;
        return false;
    L11:
        if (this.isEncrypted != r101.isEncrypted) goto L50;
        ArrayList<String> r102 = this.riskObjectKeys;
        Integer r103 = null;
        if (r102 == null) goto L15;
        Integer r104 = Integer.valueOf(r102.size());
    L16:
        ArrayList<String> r105 = r101.riskObjectKeys;
        if (r105 == null) goto L20;
        r103 = Integer.valueOf(r105.size());
    L20:
        if (Intrinsics.areEqual(r104, r103) == true) goto L22;
        return false;
    L22:
        if (this.fileAbility == r101.fileAbility) goto L24;
        return false;
    L24:
        if (this.lastUpdateTime == r101.lastUpdateTime) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.lastUpdateChatterName, r101.lastUpdateChatterName) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.fileUploadId, r101.fileUploadId) == true) goto L30;
        return false;
    L30:
        if (this.previewHangPoints.size() != r101.previewHangPoints.size()) goto L56;
        LinkedHashMap<String, PreviewHangPoint> r106 = this.previewHangPoints;
        if (r106.isEmpty() == false) goto L34;
    L33:
        boolean r107 = true;
    L40:
        if (r107 == false) goto L57;
        return true;
    L57:
        return false;
    L34:
        Iterator<Map.Entry<String, PreviewHangPoint>> r108 = r106.entrySet().iterator();
    L36:
        if (r108.hasNext() == false) goto L33;
        Map.Entry<String, PreviewHangPoint> r109 = r108.next();
        if (y28.a.c(r109.getValue(), r101.previewHangPoints.get(r109.getKey())) == true) goto L36;
        r107 = false;
        goto L40
    L56:
        return false;
    L15:
        r104 = null;
        goto L16
    L50:
        return false;
    L47:
        return false;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r100 instanceof FileContent) == false) goto L8;
        if (Intrinsics.areEqual(getKey(), ((FileContent) r100).getKey()) == false) goto L8;
        return true;
    }

    public final void setEncrypted(boolean r100) {
        this.isEncrypted = r100;
    }

    public final void setFileAbility(FileAbility r100) {
        this.fileAbility = r100;
    }

    public final void setFilePath(String r100) {
        this.filePath = r100;
    }

    public final void setFileState(FileState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileState = r100;
    }

    public final void setFileUploadId(String r100) {
        this.fileUploadId = r100;
    }

    public final void setLastUpdateChatterName(String r100) {
        this.lastUpdateChatterName = r100;
    }

    public final void setLastUpdateTime(long r100) {
        this.lastUpdateTime = r100;
    }

    public final void setMime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mime = r100;
    }

    public final void setPreviewHangPoints(LinkedHashMap<String, PreviewHangPoint> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previewHangPoints = r100;
    }

    public final void setProgress(int r100) {
        this.progress = r100;
    }

    public final void setRiskObjectKeys(ArrayList<String> r100) {
        this.riskObjectKeys = r100;
    }

    public final void setSpeed(long r100) {
        this.speed = r100;
    }

    public final void setUriString(String r100) {
        this.uriString = r100;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
