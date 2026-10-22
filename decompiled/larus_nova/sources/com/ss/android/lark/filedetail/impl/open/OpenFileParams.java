package com.ss.android.lark.filedetail.impl.open;

import com.ss.android.lark.chat.entity.message.content.FileContent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001e\b\u0016\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010 R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010 R\u0014\u0010\f\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0014\u0010\u0011\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0014\u0010\u0013\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010 R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001c¨\u0006-"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/open/OpenFileParams;", "Ljava/io/Serializable;", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "messageId", "", "chatId", "jumpPosition", "", "isSecret", "", "isCrossWithKA", "showDownload", "showForward", "menuFlag", "", "mergeMsgChatId", "downloadFileScene", "threadId", "isFromFolderManager", "previewId", "authFileKey", "msgLinkToken", "<init>", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent;Ljava/lang/String;Ljava/lang/String;IZZZZJLjava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileContent", "()Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "getMessageId", "()Ljava/lang/String;", "getChatId", "getJumpPosition", "()I", "()Z", "getShowDownload", "getShowForward", "getMenuFlag", "()J", "getMergeMsgChatId", "getDownloadFileScene", "getThreadId", "getPreviewId", "getAuthFileKey", "getMsgLinkToken", "Companion", "Builder", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OpenFileParams implements Serializable {
    public static final b Companion = null;
    private final String authFileKey;
    private final String chatId;
    private final int downloadFileScene;
    private final FileContent fileContent;
    private final boolean isCrossWithKA;
    private final boolean isFromFolderManager;
    private final boolean isSecret;
    private final int jumpPosition;
    private final long menuFlag;
    private final String mergeMsgChatId;
    private final String messageId;
    private final String msgLinkToken;
    private final String previewId;
    private final boolean showDownload;
    private final boolean showForward;
    private final String threadId;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FileContent f421806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f421807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f421808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f421809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f421810e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f421811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f421812g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f421813h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f421814i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f421815j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f421816k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f421817l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f421818m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f421819n;

        public final OpenFileParams a() {
            FileContent r100 = this.f421806a;
            if (r100 == null) goto L5;
            FileContent r101 = r100;
        L6:
            String r102 = this.f421807b;
            if (r102 == null) goto L9;
            String r210 = r102;
        L11:
            return new OpenFileParams(r101, r210, this.f421809d, this.f421808c, this.f421810e, this.f421811f, this.f421812g, this.f421813h, this.f421814i, this.f421815j, this.f421816k, null, false, this.f421817l, this.f421818m, this.f421819n);
        L9:
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            r210 = null;
            goto L11
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("fileContent");
            r101 = null;
            goto L6
        }

        public a() {
            this.f421808c = -1;
            this.f421809d = "";
            this.f421812g = true;
            this.f421813h = true;
            this.f421814i = 15;
            this.f421815j = "";
            this.f421816k = -99;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public String getAuthFileKey() {
        return this.authFileKey;
    }

    public String getChatId() {
        return this.chatId;
    }

    public int getDownloadFileScene() {
        return this.downloadFileScene;
    }

    public FileContent getFileContent() {
        return this.fileContent;
    }

    public int getJumpPosition() {
        return this.jumpPosition;
    }

    public long getMenuFlag() {
        return this.menuFlag;
    }

    public String getMergeMsgChatId() {
        return this.mergeMsgChatId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsgLinkToken() {
        return this.msgLinkToken;
    }

    public String getPreviewId() {
        return this.previewId;
    }

    public boolean getShowDownload() {
        return this.showDownload;
    }

    public boolean getShowForward() {
        return this.showForward;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public boolean isCrossWithKA() {
        return this.isCrossWithKA;
    }

    public boolean isFromFolderManager() {
        return this.isFromFolderManager;
    }

    public boolean isSecret() {
        return this.isSecret;
    }

    public OpenFileParams(FileContent r100, String r101, String r102, int r110, boolean r111, boolean r112, boolean r113, boolean r114, long r115, String r116, int r117, String r118, boolean r210, String r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r100, "fileContent");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "chatId");
        Intrinsics.checkNotNullParameter(r116, "mergeMsgChatId");
        this.fileContent = r100;
        this.messageId = r101;
        this.chatId = r102;
        this.jumpPosition = r110;
        this.isSecret = r111;
        this.isCrossWithKA = r112;
        this.showDownload = r113;
        this.showForward = r114;
        this.menuFlag = r115;
        this.mergeMsgChatId = r116;
        this.downloadFileScene = r117;
        this.threadId = r118;
        this.isFromFolderManager = r210;
        this.previewId = r211;
        this.authFileKey = r212;
        this.msgLinkToken = r213;
    }

    public /* synthetic */ OpenFileParams(FileContent r210, String r211, String r212, int r213, boolean r214, boolean r215, boolean r216, boolean r217, long r218, String r310, int r311, String r312, boolean r313, String r314, String r315, String r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 1024) == 0) goto L5;
        int r110 = -99;
    L6:
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r110, r312, r313, r314, r315, r316);
        return;
    L5:
        r110 = r311;
        goto L6
    }
}
