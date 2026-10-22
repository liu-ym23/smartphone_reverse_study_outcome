package com.bytedance.ee.bear.contract.drive;

import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB-\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001c\u001a\u00020\bJ\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/contract/drive/DriveFilePath;", "Lcom/bytedance/ee/util/io/NonProguard;", "biz", "Lcom/bytedance/ee/bear/diskmanager/Biz;", "relativePath", "", "fileName", CustomHeaderConfig.TitleConfig.TitleIcon.EMPTY, "", "<init>", "(Lcom/bytedance/ee/bear/diskmanager/Biz;Ljava/lang/String;Ljava/lang/String;Z)V", "getBiz", "()Lcom/bytedance/ee/bear/diskmanager/Biz;", "getRelativePath", "()Ljava/lang/String;", "setRelativePath", "(Ljava/lang/String;)V", "getFileName", "setFileName", "getEmpty", "()Z", "decryptPath", "Lcom/ss/android/lark/vfs/VFSPath;", "getDecryptPath", "()Lcom/ss/android/lark/vfs/VFSPath;", "setDecryptPath", "(Lcom/ss/android/lark/vfs/VFSPath;)V", "cacheName", "isEmpty", "toString", "Companion", "Builder", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveFilePath implements NonProguard {
    public static final a Companion = null;
    private static final String TAG = "DriveFilePath";
    private final Biz biz;
    private transient VFSPath decryptPath;
    private final boolean empty;
    private String fileName;
    private String relativePath;

    public static final class a {
        public static DriveFilePath a() {
            return new DriveFilePath(Biz.DRIVE, "", "", true);
        }

        public a() {
        }

        public static DriveFilePath b(String r2) {
            DriveFilePath r3 = (DriveFilePath) new Gson().fromJson(r2, DriveFilePath.class);     // Catch: Exception -> L4
        L6:
            if (r3 == null) goto L8;
            return r3;
        L8:
            return a();
        L4:
            e = move-exception;
            tt5.a.d(DriveFilePath.TAG, "buildFromJsonPath fail: " + e);
            r3 = null;
            goto L6
        }

        public static String c(DriveFilePath r1) {
            if (r1 != null) goto L4;
            return "";
        L4:
            return GsonProtectorUtils.toJson(new Gson(), r1);
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "DriveFilePath(biz=" + this.biz + ", relativePath='" + this.relativePath + "', empty=" + this.empty + ", fileName='" + this.fileName + "', decryptPath='" + this.decryptPath + "')";
    }

    public final Biz getBiz() {
        return this.biz;
    }

    public final VFSPath getDecryptPath() {
        return this.decryptPath;
    }

    public final boolean getEmpty() {
        return this.empty;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final boolean isEmpty() {
        return this.empty;
    }

    public final DriveFilePath cacheName(String r1) {
        if (r1 == null) goto L4;
        this.fileName = r1;
    L4:
        return this;
    }

    public final void setDecryptPath(VFSPath r1) {
        this.decryptPath = r1;
    }

    public final void setFileName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setRelativePath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.relativePath = r2;
    }

    public DriveFilePath(Biz r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "relativePath");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        this.biz = r2;
        this.relativePath = r3;
        this.fileName = r4;
        this.empty = r5;
    }

    public /* synthetic */ DriveFilePath(Biz r1, String r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        this(r1, r2, r3, r4);
    }
}
