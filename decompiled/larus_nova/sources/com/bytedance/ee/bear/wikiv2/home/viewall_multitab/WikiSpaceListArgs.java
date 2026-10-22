package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0097\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u00108\u001a\u00020\u0004J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "pageMode", "", "createDocumentType", "srcToken", "", "srcObjType", "srcParentToken", "srcIsLock", "srcSpaceId", "title", "triggerLocation", "srcIsShortcut", "", "srcOriginWikiToken", "srcOriginSpaceId", "srcFileSize", "", "<init>", "(IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;J)V", "getPageMode", "()I", "setPageMode", "(I)V", "getCreateDocumentType", "setCreateDocumentType", "getSrcToken", "()Ljava/lang/String;", "setSrcToken", "(Ljava/lang/String;)V", "getSrcObjType", "setSrcObjType", "getSrcParentToken", "setSrcParentToken", "getSrcIsLock", "setSrcIsLock", "getSrcSpaceId", "setSrcSpaceId", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getTriggerLocation", "setTriggerLocation", "getSrcIsShortcut", "()Z", "setSrcIsShortcut", "(Z)V", "getSrcOriginWikiToken", "setSrcOriginWikiToken", "getSrcOriginSpaceId", "setSrcOriginSpaceId", "getSrcFileSize", "()J", "setSrcFileSize", "(J)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final WikiSpaceListArgs createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            int r101 = r110.readInt();
            String r102 = r110.readString();
            int r103 = r110.readInt();
            String r104 = r110.readString();
            int r105 = r110.readInt();
            String r106 = r110.readString();
            String r107 = r110.readString();
            String r111 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r112 = true;
        L7:
            return new WikiSpaceListArgs(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r110.readString(), r110.readString(), r110.readLong());
        L5:
            r112 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSpaceListArgs[] newArray(int r100) {
            return new WikiSpaceListArgs[r100];
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
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.pageMode);
        r100.writeInt(this.createDocumentType);
        r100.writeString(this.srcToken);
        r100.writeInt(this.srcObjType);
        r100.writeString(this.srcParentToken);
        r100.writeInt(this.srcIsLock);
        r100.writeString(this.srcSpaceId);
        r100.writeString(this.title);
        r100.writeString(this.triggerLocation);
        r100.writeInt(this.srcIsShortcut ? 1 : 0);
        r100.writeString(this.srcOriginWikiToken);
        r100.writeString(this.srcOriginSpaceId);
        r100.writeLong(this.srcFileSize);
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

    public final void setCreateDocumentType(int r100) {
        this.createDocumentType = r100;
    }

    public final void setPageMode(int r100) {
        this.pageMode = r100;
    }

    public final void setSrcFileSize(long r100) {
        this.srcFileSize = r100;
    }

    public final void setSrcIsLock(int r100) {
        this.srcIsLock = r100;
    }

    public final void setSrcIsShortcut(boolean r100) {
        this.srcIsShortcut = r100;
    }

    public final void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }

    public final void setSrcOriginSpaceId(String r100) {
        this.srcOriginSpaceId = r100;
    }

    public final void setSrcOriginWikiToken(String r100) {
        this.srcOriginWikiToken = r100;
    }

    public final void setSrcParentToken(String r100) {
        this.srcParentToken = r100;
    }

    public final void setSrcSpaceId(String r100) {
        this.srcSpaceId = r100;
    }

    public final void setSrcToken(String r100) {
        this.srcToken = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTriggerLocation(String r100) {
        this.triggerLocation = r100;
    }

    public WikiSpaceListArgs(int r100, int r101, String r102, int r103, String r104, int r105, String r106, String r107, String r108, boolean r110, String r111, String r112, long r113) {
        this.pageMode = r100;
        this.createDocumentType = r101;
        this.srcToken = r102;
        this.srcObjType = r103;
        this.srcParentToken = r104;
        this.srcIsLock = r105;
        this.srcSpaceId = r106;
        this.title = r107;
        this.triggerLocation = r108;
        this.srcIsShortcut = r110;
        this.srcOriginWikiToken = r111;
        this.srcOriginSpaceId = r112;
        this.srcFileSize = r113;
    }

    public /* synthetic */ WikiSpaceListArgs(int r110, int r111, String r112, int r113, String r210, int r211, String r212, String r213, String r214, boolean r215, String r216, String r217, long r218, int r310, DefaultConstructorMarker r311) {
        boolean r100 = false;
        if ((r310 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        int r102 = -1;
        if ((r310 & 2) == 0) goto L9;
        int r103 = -1;
    L10:
        String r104 = null;
        if ((r310 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        int r106 = -1;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r310 & 32) != 0) goto L27;
        r102 = r211;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r310 & 512) != 0) goto L43;
        r100 = r215;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) != 0) goto L51;
        r104 = r217;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        long r117 = 0;
    L54:
        this(r101, r103, r105, r106, r107, r102, r108, r114, r115, r100, r116, r104, r117);
        return;
    L53:
        r117 = r218;
        goto L54
    L45:
        r116 = r216;
        goto L47
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r108 = r212;
        goto L31
    L21:
        r107 = r210;
        goto L23
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L6
    }
}
