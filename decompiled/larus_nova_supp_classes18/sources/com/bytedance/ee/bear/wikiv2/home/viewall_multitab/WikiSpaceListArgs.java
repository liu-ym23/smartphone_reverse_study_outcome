package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0097\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u00108\u001a\u00020\u0004J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "pageMode", "", "createDocumentType", "srcToken", "", "srcObjType", "srcParentToken", "srcIsLock", "srcSpaceId", "title", "triggerLocation", "srcIsShortcut", "", "srcOriginWikiToken", "srcOriginSpaceId", "srcFileSize", "", "<init>", "(IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;J)V", "getPageMode", "()I", "setPageMode", "(I)V", "getCreateDocumentType", "setCreateDocumentType", "getSrcToken", "()Ljava/lang/String;", "setSrcToken", "(Ljava/lang/String;)V", "getSrcObjType", "setSrcObjType", "getSrcParentToken", "setSrcParentToken", "getSrcIsLock", "setSrcIsLock", "getSrcSpaceId", "setSrcSpaceId", "getTitle", "setTitle", "getTriggerLocation", "setTriggerLocation", "getSrcIsShortcut", "()Z", "setSrcIsShortcut", "(Z)V", "getSrcOriginWikiToken", "setSrcOriginWikiToken", "getSrcOriginSpaceId", "setSrcOriginSpaceId", "getSrcFileSize", "()J", "setSrcFileSize", "(J)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListArgs implements Parcelable, NonProguard {
    public static final Parcelable.Creator<WikiSpaceListArgs> CREATOR = null;
    private int createDocumentType;
    private int pageMode;
    private long srcFileSize;
    private int srcIsLock;
    private boolean srcIsShortcut;
    private int srcObjType;
    private String srcOriginSpaceId;
    private String srcOriginWikiToken;
    private String srcParentToken;
    private String srcSpaceId;
    private String srcToken;
    private String title;
    private String triggerLocation;

    public static final class a implements Parcelable.Creator<WikiSpaceListArgs> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSpaceListArgs createFromParcel(Parcel r17) {
            Intrinsics.checkNotNullParameter(r17, "parcel");
            int r2 = r17.readInt();
            int r3 = r17.readInt();
            String r4 = r17.readString();
            int r5 = r17.readInt();
            String r6 = r17.readString();
            int r7 = r17.readInt();
            String r8 = r17.readString();
            String r9 = r17.readString();
            String r10 = r17.readString();
            if (r17.readInt() == 0) goto L5;
            boolean r11 = true;
        L7:
            return new WikiSpaceListArgs(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r17.readString(), r17.readString(), r17.readLong());
        L5:
            r11 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSpaceListArgs[] newArray(int r1) {
            return new WikiSpaceListArgs[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public WikiSpaceListArgs() {
        this(0, 0, null, 0, null, 0, null, null, null, false, null, null, 0, 8191, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.pageMode);
        r3.writeInt(this.createDocumentType);
        r3.writeString(this.srcToken);
        r3.writeInt(this.srcObjType);
        r3.writeString(this.srcParentToken);
        r3.writeInt(this.srcIsLock);
        r3.writeString(this.srcSpaceId);
        r3.writeString(this.title);
        r3.writeString(this.triggerLocation);
        r3.writeInt(this.srcIsShortcut ? 1 : 0);
        r3.writeString(this.srcOriginWikiToken);
        r3.writeString(this.srcOriginSpaceId);
        r3.writeLong(this.srcFileSize);
    }

    public final int getCreateDocumentType() {
        return this.createDocumentType;
    }

    public final int getPageMode() {
        return this.pageMode;
    }

    public final long getSrcFileSize() {
        return this.srcFileSize;
    }

    public final int getSrcIsLock() {
        return this.srcIsLock;
    }

    public final boolean getSrcIsShortcut() {
        return this.srcIsShortcut;
    }

    public final int getSrcObjType() {
        return this.srcObjType;
    }

    public final String getSrcOriginSpaceId() {
        return this.srcOriginSpaceId;
    }

    public final String getSrcOriginWikiToken() {
        return this.srcOriginWikiToken;
    }

    public final String getSrcParentToken() {
        return this.srcParentToken;
    }

    public final String getSrcSpaceId() {
        return this.srcSpaceId;
    }

    public final String getSrcToken() {
        return this.srcToken;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTriggerLocation() {
        return this.triggerLocation;
    }

    public final void setCreateDocumentType(int r1) {
        this.createDocumentType = r1;
    }

    public final void setPageMode(int r1) {
        this.pageMode = r1;
    }

    public final void setSrcFileSize(long r1) {
        this.srcFileSize = r1;
    }

    public final void setSrcIsLock(int r1) {
        this.srcIsLock = r1;
    }

    public final void setSrcIsShortcut(boolean r1) {
        this.srcIsShortcut = r1;
    }

    public final void setSrcObjType(int r1) {
        this.srcObjType = r1;
    }

    public final void setSrcOriginSpaceId(String r1) {
        this.srcOriginSpaceId = r1;
    }

    public final void setSrcOriginWikiToken(String r1) {
        this.srcOriginWikiToken = r1;
    }

    public final void setSrcParentToken(String r1) {
        this.srcParentToken = r1;
    }

    public final void setSrcSpaceId(String r1) {
        this.srcSpaceId = r1;
    }

    public final void setSrcToken(String r1) {
        this.srcToken = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setTriggerLocation(String r1) {
        this.triggerLocation = r1;
    }

    public WikiSpaceListArgs(int r1, int r2, String r3, int r4, String r5, int r6, String r7, String r8, String r9, boolean r10, String r11, String r12, long r13) {
        this.pageMode = r1;
        this.createDocumentType = r2;
        this.srcToken = r3;
        this.srcObjType = r4;
        this.srcParentToken = r5;
        this.srcIsLock = r6;
        this.srcSpaceId = r7;
        this.title = r8;
        this.triggerLocation = r9;
        this.srcIsShortcut = r10;
        this.srcOriginWikiToken = r11;
        this.srcOriginSpaceId = r12;
        this.srcFileSize = r13;
    }

    public /* synthetic */ WikiSpaceListArgs(int r16, int r17, String r18, int r19, String r20, int r21, String r22, String r23, String r24, boolean r25, String r26, String r27, long r28, int r30, DefaultConstructorMarker r31) {
        boolean r2 = false;
        if ((r30 & 1) == 0) goto L5;
        int r1 = 0;
    L6:
        int r4 = -1;
        if ((r30 & 2) == 0) goto L9;
        int r3 = -1;
    L10:
        String r6 = null;
        if ((r30 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        int r7 = -1;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r30 & 32) != 0) goto L27;
        r4 = r21;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r30 & 512) != 0) goto L43;
        r2 = r25;
    L43:
        if ((r30 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r30 & DocUserPermission.USER_PREVIEW) != 0) goto L51;
        r6 = r27;
    L51:
        if ((r30 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        long r13 = 0;
    L54:
        this(r1, r3, r5, r7, r8, r4, r9, r10, r11, r2, r12, r6, r13);
        return;
    L53:
        r13 = r28;
        goto L54
    L45:
        r12 = r26;
        goto L47
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L10
    L5:
        r1 = r16;
        goto L6
    }
}
