package com.bytedance.ee.bear.tts;

import com.ttnet.org.chromium.net.NetError;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class TtsResult {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TtsResult f239449d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TtsResult f239450e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f239451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f239453c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$AccessCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKONWN", "NETWORK_ERROR", "FILE_NOT_EXISTS", "NO_PERMISSION_DEFAULT", "NO_VIEW_PERMISSION", "NO_PREVIEW_PERMISSION", "NO_PERCEIVE_PERMISSION", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccessCode extends Enum<AccessCode> implements b {
        public static final AccessCode FILE_NOT_EXISTS = null;
        public static final AccessCode NETWORK_ERROR = null;
        public static final AccessCode NO_PERCEIVE_PERMISSION = null;
        public static final AccessCode NO_PERMISSION_DEFAULT = null;
        public static final AccessCode NO_PREVIEW_PERMISSION = null;
        public static final AccessCode NO_VIEW_PERMISSION = null;
        public static final AccessCode UNKONWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AccessCode[] f239454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239455b = null;
        private final int codeNum;

        public static EnumEntries<AccessCode> getEntries() {
            return f239455b;
        }

        static {
            AccessCode r100 = new AccessCode("UNKONWN", 0, -401);
            UNKONWN = r100;
            AccessCode r101 = new AccessCode("NETWORK_ERROR", 1, -402);
            NETWORK_ERROR = r101;
            AccessCode r102 = new AccessCode("FILE_NOT_EXISTS", 2, -404);
            FILE_NOT_EXISTS = r102;
            AccessCode r103 = new AccessCode("NO_PERMISSION_DEFAULT", 3, -411);
            NO_PERMISSION_DEFAULT = r103;
            AccessCode r104 = new AccessCode("NO_VIEW_PERMISSION", 4, -412);
            NO_VIEW_PERMISSION = r104;
            AccessCode r105 = new AccessCode("NO_PREVIEW_PERMISSION", 5, -412);
            NO_PREVIEW_PERMISSION = r105;
            AccessCode r110 = new AccessCode("NO_PERCEIVE_PERMISSION", 6, -412);
            NO_PERCEIVE_PERMISSION = r110;
            AccessCode[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f239454a = r111;
            f239455b = EnumEntriesKt.enumEntries(r111);
        }

        public static AccessCode[] values() {
            return (AccessCode[]) f239454a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static AccessCode valueOf(String r100) {
            return (AccessCode) r27.a.a(AccessCode.class, r100);
        }

        public AccessCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.codeNum = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$BaseCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "SUCCESS", "UNKNOWN", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BaseCode extends Enum<BaseCode> implements b {
        public static final BaseCode SUCCESS = null;
        public static final BaseCode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BaseCode[] f239456a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239457b = null;
        private final int codeNum;

        public static EnumEntries<BaseCode> getEntries() {
            return f239457b;
        }

        static {
            BaseCode r100 = new BaseCode("SUCCESS", 0, 0);
            SUCCESS = r100;
            BaseCode r101 = new BaseCode("UNKNOWN", 1, -1);
            UNKNOWN = r101;
            BaseCode[] r102 = {r100, r101};
            f239456a = r102;
            f239457b = EnumEntriesKt.enumEntries(r102);
        }

        public static BaseCode[] values() {
            return (BaseCode[]) f239456a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static BaseCode valueOf(String r100) {
            return (BaseCode) r27.a.a(BaseCode.class, r100);
        }

        public BaseCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.codeNum = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$ModelCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "NOT_INIT", "CANCELLED", "SAVE_FAILED", "DELETE_FAILED", "M3U8_INVALID", "M3U8_LINK_INVALID", "M3U8_SERVER_LIMIT", "TONE_LIST_INVALID", "TONE_NOT_SUPPORTED", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ModelCode extends Enum<ModelCode> implements b {
        public static final ModelCode CANCELLED = null;
        public static final ModelCode DELETE_FAILED = null;
        public static final ModelCode M3U8_INVALID = null;
        public static final ModelCode M3U8_LINK_INVALID = null;
        public static final ModelCode M3U8_SERVER_LIMIT = null;
        public static final ModelCode NOT_INIT = null;
        public static final ModelCode SAVE_FAILED = null;
        public static final ModelCode TONE_LIST_INVALID = null;
        public static final ModelCode TONE_NOT_SUPPORTED = null;
        public static final ModelCode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ModelCode[] f239458a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239459b = null;
        private final int codeNum;

        public static EnumEntries<ModelCode> getEntries() {
            return f239459b;
        }

        static {
            ModelCode r100 = new ModelCode("UNKNOWN", 0, -101);
            UNKNOWN = r100;
            ModelCode r101 = new ModelCode("NOT_INIT", 1, -102);
            NOT_INIT = r101;
            ModelCode r102 = new ModelCode("CANCELLED", 2, -103);
            CANCELLED = r102;
            ModelCode r103 = new ModelCode("SAVE_FAILED", 3, -105);
            SAVE_FAILED = r103;
            ModelCode r104 = new ModelCode("DELETE_FAILED", 4, -106);
            DELETE_FAILED = r104;
            ModelCode r105 = new ModelCode("M3U8_INVALID", 5, NetError.ERR_MANDATORY_PROXY_CONFIGURATION_FAILED);
            M3U8_INVALID = r105;
            ModelCode r110 = new ModelCode("M3U8_LINK_INVALID", 6, -132);
            M3U8_LINK_INVALID = r110;
            ModelCode r111 = new ModelCode("M3U8_SERVER_LIMIT", 7, NetError.ERR_SSL_CLIENT_AUTH_PRIVATE_KEY_ACCESS_DENIED);
            M3U8_SERVER_LIMIT = r111;
            ModelCode r112 = new ModelCode("TONE_LIST_INVALID", 8, NetError.ERR_MSG_TOO_BIG);
            TONE_LIST_INVALID = r112;
            ModelCode r113 = new ModelCode("TONE_NOT_SUPPORTED", 9, -143);
            TONE_NOT_SUPPORTED = r113;
            ModelCode[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f239458a = r114;
            f239459b = EnumEntriesKt.enumEntries(r114);
        }

        public static ModelCode[] values() {
            return (ModelCode[]) f239458a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static ModelCode valueOf(String r100) {
            return (ModelCode) r27.a.a(ModelCode.class, r100);
        }

        public ModelCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.codeNum = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$OperationCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "DROPPED", "PLAYER_NOT_INIT", "PLAYER_STATE_NOT_AVAILABLE", "PRELOAD_FAILED_NOT_PREPARED", "SEEK_FAILED_NOT_PLAYABLE", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OperationCode extends Enum<OperationCode> implements b {
        public static final OperationCode DROPPED = null;
        public static final OperationCode PLAYER_NOT_INIT = null;
        public static final OperationCode PLAYER_STATE_NOT_AVAILABLE = null;
        public static final OperationCode PRELOAD_FAILED_NOT_PREPARED = null;
        public static final OperationCode SEEK_FAILED_NOT_PLAYABLE = null;
        public static final OperationCode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OperationCode[] f239460a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239461b = null;
        private final int codeNum;

        public static EnumEntries<OperationCode> getEntries() {
            return f239461b;
        }

        static {
            OperationCode r100 = new OperationCode("UNKNOWN", 0, -201);
            UNKNOWN = r100;
            OperationCode r101 = new OperationCode("DROPPED", 1, -202);
            DROPPED = r101;
            OperationCode r102 = new OperationCode("PLAYER_NOT_INIT", 2, -211);
            PLAYER_NOT_INIT = r102;
            OperationCode r103 = new OperationCode("PLAYER_STATE_NOT_AVAILABLE", 3, -221);
            PLAYER_STATE_NOT_AVAILABLE = r103;
            OperationCode r104 = new OperationCode("PRELOAD_FAILED_NOT_PREPARED", 4, -302);
            PRELOAD_FAILED_NOT_PREPARED = r104;
            OperationCode r105 = new OperationCode("SEEK_FAILED_NOT_PLAYABLE", 5, -502);
            SEEK_FAILED_NOT_PLAYABLE = r105;
            OperationCode[] r110 = {r100, r101, r102, r103, r104, r105};
            f239460a = r110;
            f239461b = EnumEntriesKt.enumEntries(r110);
        }

        public static OperationCode[] values() {
            return (OperationCode[]) f239460a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static OperationCode valueOf(String r100) {
            return (OperationCode) r27.a.a(OperationCode.class, r100);
        }

        public OperationCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.codeNum = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$PlayerCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlayerCode extends Enum<PlayerCode> implements b {
        public static final PlayerCode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayerCode[] f239462a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239463b = null;
        private final int codeNum;

        public static EnumEntries<PlayerCode> getEntries() {
            return f239463b;
        }

        static {
            PlayerCode r100 = new PlayerCode();
            UNKNOWN = r100;
            PlayerCode[] r101 = {r100};
            f239462a = r101;
            f239463b = EnumEntriesKt.enumEntries(r101);
        }

        public PlayerCode() {
            super("UNKNOWN", 0);
            this.codeNum = -301;
        }

        public static PlayerCode[] values() {
            return (PlayerCode[]) f239462a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static PlayerCode valueOf(String r100) {
            return (PlayerCode) r27.a.a(PlayerCode.class, r100);
        }
    }

    public static final class a {
    }

    public interface b {
        int getCodeNum();
    }

    static {
        f239449d = new TtsResult(BaseCode.SUCCESS);
        f239450e = new TtsResult(BaseCode.UNKNOWN);
    }

    public final boolean a() {
        if (this.f239451a != BaseCode.SUCCESS) goto L16;
        String r100 = this.f239452b;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        return false;
    L13:
        if (this.f239453c != null) goto L18;
        return true;
    L18:
        return false;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L16:
        return false;
    }

    public final String toString() {
        return "TtsResult{code: " + this.f239451a + ", errMsg: " + this.f239452b + ", throwable: " + this.f239453c + '}';
    }

    public TtsResult(b r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        this.f239451a = r100;
        this.f239452b = null;
        this.f239453c = null;
    }
}
