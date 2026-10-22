package com.bytedance.ee.bear.wikiv2.wikitreev2;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0018\u0010L\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0015H\u0016J\b\u0010O\u001a\u00020\u0015H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001c\u0010/\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR\u001c\u00102\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR\u001c\u00105\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010\rR\u001a\u00108\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000b\"\u0004\bB\u0010\rR\u001c\u0010C\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000b\"\u0004\bE\u0010\rR\u001a\u0010F\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "spaceId", "", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "documentToken", "getDocumentToken", "setDocumentToken", "documentName", "getDocumentName", "setDocumentName", "pageMode", "", "getPageMode", "()I", "setPageMode", "(I)V", "srcToken", "getSrcToken", "setSrcToken", "srcParentToken", "getSrcParentToken", "setSrcParentToken", "srcIsLock", "getSrcIsLock", "setSrcIsLock", "createDocumentType", "getCreateDocumentType", "setCreateDocumentType", "wikiDocument", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiDocument;", "getWikiDocument", "()Lcom/bytedance/ee/bear/contract/route/parcelable/WikiDocument;", "setWikiDocument", "(Lcom/bytedance/ee/bear/contract/route/parcelable/WikiDocument;)V", "srcObjType", "getSrcObjType", "setSrcObjType", "srcSpaceId", "getSrcSpaceId", "setSrcSpaceId", "srcTitle", "getSrcTitle", "setSrcTitle", "triggerLocation", "getTriggerLocation", "setTriggerLocation", "isFromShareLink", "setFromShareLink", "srcIsShortcut", "", "getSrcIsShortcut", "()Z", "setSrcIsShortcut", "(Z)V", "srcOriginWikiToken", "getSrcOriginWikiToken", "setSrcOriginWikiToken", "srcOriginSpaceId", "getSrcOriginSpaceId", "setSrcOriginSpaceId", "srcFileSize", "", "getSrcFileSize", "()J", "setSrcFileSize", "(J)V", "writeToParcel", "", "flags", "describeContents", "CREATOR", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreeActivityContract implements Parcelable, NonProguard {
    public static final a CREATOR = null;
    private int createDocumentType;
    private String documentName;
    private String documentToken;
    private int isFromShareLink;
    private int pageMode;
    private String spaceId;
    private long srcFileSize;
    private int srcIsLock;
    private boolean srcIsShortcut;
    private int srcObjType;
    private String srcOriginSpaceId;
    private String srcOriginWikiToken;
    private String srcParentToken;
    private String srcSpaceId;
    private String srcTitle;
    private String srcToken;
    private String triggerLocation;
    private WikiDocument wikiDocument;

    public static final class a implements Parcelable.Creator<WikiTreeActivityContract> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiTreeActivityContract createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new WikiTreeActivityContract(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiTreeActivityContract[] newArray(int r1) {
            return new WikiTreeActivityContract[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WikiTreeActivityContract() {
        this.spaceId = "";
        this.documentToken = "";
        this.documentName = "";
        this.srcToken = "";
        this.srcParentToken = "";
        this.srcIsLock = -1;
        this.createDocumentType = -1;
        this.srcObjType = -1;
        this.srcSpaceId = "";
        this.srcTitle = "";
        this.triggerLocation = "";
        this.srcOriginWikiToken = "";
        this.srcOriginSpaceId = "";
    }

    public final int getCreateDocumentType() {
        return this.createDocumentType;
    }

    public final String getDocumentName() {
        return this.documentName;
    }

    public final String getDocumentToken() {
        return this.documentToken;
    }

    public final int getPageMode() {
        return this.pageMode;
    }

    public final String getSpaceId() {
        return this.spaceId;
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

    public final String getSrcTitle() {
        return this.srcTitle;
    }

    public final String getSrcToken() {
        return this.srcToken;
    }

    public final String getTriggerLocation() {
        return this.triggerLocation;
    }

    public final WikiDocument getWikiDocument() {
        return this.wikiDocument;
    }

    public final int isFromShareLink() {
        return this.isFromShareLink;
    }

    public WikiTreeActivityContract(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this();
        String r0 = r3.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.spaceId = r0;
        String r2 = r3.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.documentToken = r2;
        String r4 = r3.readString();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        this.documentName = r4;
        this.pageMode = r3.readInt();
        String r5 = r3.readString();
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        this.srcToken = r5;
        String r6 = r3.readString();
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        this.srcParentToken = r1;
        this.srcIsLock = r3.readInt();
        this.createDocumentType = r3.readInt();
        this.wikiDocument = r3.readParcelable(WikiDocument.class.getClassLoader());
        this.srcObjType = r3.readInt();
        this.srcSpaceId = r3.readString();
        this.srcTitle = r3.readString();
        this.triggerLocation = r3.readString();
        this.isFromShareLink = r3.readInt();
        if (r3.readInt() == 0) goto L21;
        boolean r7 = true;
    L22:
        this.srcIsShortcut = r7;
        this.srcOriginWikiToken = r3.readString();
        this.srcOriginSpaceId = r3.readString();
        this.srcFileSize = r3.readLong();
        return;
    L21:
        r7 = false;
        goto L22
    }

    public final void setCreateDocumentType(int r1) {
        this.createDocumentType = r1;
    }

    public final void setDocumentName(String r1) {
        this.documentName = r1;
    }

    public final void setDocumentToken(String r1) {
        this.documentToken = r1;
    }

    public final void setFromShareLink(int r1) {
        this.isFromShareLink = r1;
    }

    public final void setPageMode(int r1) {
        this.pageMode = r1;
    }

    public final void setSpaceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceId = r2;
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

    public final void setSrcTitle(String r1) {
        this.srcTitle = r1;
    }

    public final void setSrcToken(String r1) {
        this.srcToken = r1;
    }

    public final void setTriggerLocation(String r1) {
        this.triggerLocation = r1;
    }

    public final void setWikiDocument(WikiDocument r1) {
        this.wikiDocument = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.spaceId);
        r3.writeString(this.documentToken);
        r3.writeString(this.documentName);
        r3.writeInt(this.pageMode);
        r3.writeString(this.srcToken);
        r3.writeString(this.srcParentToken);
        r3.writeInt(this.srcIsLock);
        r3.writeInt(this.createDocumentType);
        r3.writeParcelable(this.wikiDocument, r4);
        r3.writeInt(this.srcObjType);
        r3.writeString(this.srcSpaceId);
        r3.writeString(this.srcTitle);
        r3.writeString(this.triggerLocation);
        r3.writeInt(this.isFromShareLink);
        r3.writeInt(this.srcIsShortcut ? 1 : 0);
        r3.writeString(this.srcOriginWikiToken);
        r3.writeString(this.srcOriginSpaceId);
        r3.writeLong(this.srcFileSize);
    }
}
