package com.ss.android.lark.filedetail.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0002ijB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010^\u001a\u00020_2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0011H\u0016J\b\u0010a\u001a\u00020\u0011H\u0016J \u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001c\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001a\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u001a\u0010L\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0013\"\u0004\bN\u0010\u0015R\u001c\u0010O\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\n\"\u0004\bQ\u0010\fR\u001c\u0010R\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010\fR\u001c\u0010U\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\n\"\u0004\bW\u0010\fR\u001c\u0010X\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010\fR\u001a\u0010[\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0013\"\u0004\b]\u0010\u0015¨\u0006k"}, d2 = {"Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "messageId", "", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "chatId", "getChatId", "setChatId", "jumpPosition", "", "getJumpPosition", "()I", "setJumpPosition", "(I)V", "needHitPoint", "", "getNeedHitPoint", "()Z", "setNeedHitPoint", "(Z)V", "from", "getFrom", "setFrom", "downloadFileScene", "getDownloadFileScene", "setDownloadFileScene", "folderKey", "getFolderKey", "setFolderKey", "folderName", "getFolderName", "setFolderName", "mergeMsgId", "getMergeMsgId", "setMergeMsgId", "mergeChatId", "getMergeChatId", "setMergeChatId", "threadId", "getThreadId", "setThreadId", "threadPosition", "getThreadPosition", "setThreadPosition", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "folderSize", "", "getFolderSize", "()J", "setFolderSize", "(J)V", "favoriteMessageInfo", "Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "getFavoriteMessageInfo", "()Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "setFavoriteMessageInfo", "(Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;)V", "showSaveToDrive", "getShowSaveToDrive", "setShowSaveToDrive", "showForward", "getShowForward", "setShowForward", "previewFileType", "getPreviewFileType", "setPreviewFileType", "previewId", "getPreviewId", "setPreviewId", "msgLinkToken", "getMsgLinkToken", "setMsgLinkToken", "authFileKey", "getAuthFileKey", "setAuthFileKey", "originMergeForwardId", "getOriginMergeForwardId", "setOriginMergeForwardId", "chatType", "getChatType", "setChatType", "writeToParcel", "", "flags", "describeContents", "convertFileDetailParams", "Lcom/ss/android/lark/filedetail/dto/FileDetailLaunchParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "mergeForwardMsgId", "Builder", "CREATOR", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderManageLaunchParams implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f421494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f421495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f421496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f421497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f421498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f421499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f421500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f421501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f421502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f421503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f421504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f421505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Message f421506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f421507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FavoriteMessageInfo f421508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f421509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f421510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f421511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f421512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f421513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f421514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f421515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f421516w;

    public static final class a implements Parcelable.Creator<FolderManageLaunchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderManageLaunchParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            FolderManageLaunchParams r101 = new FolderManageLaunchParams();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f421494a = r102;
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f421495b = r104;
            r101.f421496c = r100.readInt();
            boolean r105 = true;
            if (r100.readByte() == 0) goto L11;
            boolean r106 = true;
        L12:
            r101.f421497d = r106;
            r101.f421498e = r100.readInt();
            r101.f421499f = r100.readInt();
            String r107 = r100.readString();
            if (r107 != null) goto L15;
            r107 = "";
        L15:
            r101.f421500g = r107;
            String r108 = r100.readString();
            if (r108 == null) goto L19;
            r103 = r108;
        L19:
            r101.f421501h = r103;
            r101.f421502i = r100.readString();
            r101.f421503j = r100.readString();
            r101.f421504k = r100.readString();
            r101.f421505l = r100.readInt();
            r101.f421506m = (Message) r100.readSerializable();
            r101.f421507n = r100.readLong();
            r101.f421508o = (FavoriteMessageInfo) r100.readSerializable();
            if (r100.readByte() == 0) goto L22;
            boolean r109 = true;
        L23:
            r101.f421509p = r109;
            if (r100.readByte() != 0) goto L27;
            r105 = false;
        L27:
            r101.f421510q = r105;
            r101.f421511r = r100.readInt();
            r101.f421512s = r100.readString();
            r101.f421514u = r100.readString();
            r101.f421513t = r100.readString();
            r101.f421515v = r100.readString();
            r101.f421516w = r100.readInt();
            return r101;
        L22:
            r109 = false;
            goto L23
        L11:
            r106 = false;
            goto L12
        }

        @Override // android.os.Parcelable.Creator
        public final FolderManageLaunchParams[] newArray(int r100) {
            return new FolderManageLaunchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public FolderManageLaunchParams() {
        this.f421494a = "";
        this.f421495b = "";
        this.f421496c = -1;
        this.f421499f = -99;
        this.f421500g = "";
        this.f421501h = "";
        this.f421505l = -1;
        this.f421511r = 1;
        this.f421516w = Chat.Type.UNKNOWN.getNumber();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f421494a);
        r100.writeString(this.f421495b);
        r100.writeInt(this.f421496c);
        r100.writeByte(this.f421497d ? 1 : 0);
        r100.writeInt(this.f421498e);
        r100.writeInt(this.f421499f);
        r100.writeString(this.f421500g);
        r100.writeString(this.f421501h);
        r100.writeString(this.f421502i);
        r100.writeString(this.f421503j);
        r100.writeString(this.f421504k);
        r100.writeInt(this.f421505l);
        r100.writeSerializable(this.f421506m);
        r100.writeLong(this.f421507n);
        r100.writeSerializable(this.f421508o);
        r100.writeByte(this.f421509p ? 1 : 0);
        r100.writeByte(this.f421510q ? 1 : 0);
        r100.writeInt(this.f421511r);
        r100.writeString(this.f421512s);
        r100.writeString(this.f421514u);
        r100.writeString(this.f421513t);
        r100.writeString(this.f421515v);
        r100.writeInt(this.f421516w);
    }
}
