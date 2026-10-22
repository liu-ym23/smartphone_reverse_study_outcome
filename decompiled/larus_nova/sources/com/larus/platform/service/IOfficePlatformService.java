package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/service/IOfficePlatformService;", "", "buildFeishuLink", "", "docType", "Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "token", "isSupportedDriveFileType", "", "driveFileType", "", "(Ljava/lang/Integer;)Z", "toFeishuDocType", "(Ljava/lang/Integer;)Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "handleCopyFeishuLink", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "feishuLink", "sharePanelDialog", "Landroidx/fragment/app/DialogFragment;", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "FeishuDocType", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficePlatformService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "", "path", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "SLIDES", "SHEET", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeishuDocType extends Enum<FeishuDocType> {
        public static final FeishuDocType DOCX = null;
        public static final FeishuDocType SHEET = null;
        public static final FeishuDocType SLIDES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeishuDocType[] f365707a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f365708b = null;
        private final String path;

        public static EnumEntries<FeishuDocType> getEntries() {
            return f365708b;
        }

        static {
            FeishuDocType r100 = new FeishuDocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, DocumentType.DOCX_NAME);
            DOCX = r100;
            FeishuDocType r101 = new FeishuDocType("SLIDES", 1, "slides");
            SLIDES = r101;
            FeishuDocType r102 = new FeishuDocType("SHEET", 2, "sheets");
            SHEET = r102;
            FeishuDocType[] r103 = {r100, r101, r102};
            f365707a = r103;
            f365708b = EnumEntriesKt.enumEntries(r103);
        }

        public static FeishuDocType[] values() {
            return (FeishuDocType[]) f365707a.clone();
        }

        public final String getPath() {
            return this.path;
        }

        public static FeishuDocType valueOf(String r100) {
            return (FeishuDocType) r27.a.a(FeishuDocType.class, r100);
        }

        public FeishuDocType(String r100, int r101, String r102) {
            super(r100, r101);
            this.path = r102;
        }
    }

    String a(FeishuDocType r100, String r101);

    void b(Context r100, String r101, DialogFragment r102, jr9.a r103);

    boolean c(Integer r100);

    FeishuDocType d(Integer r100);
}
