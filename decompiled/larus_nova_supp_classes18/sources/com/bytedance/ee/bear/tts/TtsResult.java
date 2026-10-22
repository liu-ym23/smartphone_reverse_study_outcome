package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsResult {
    public static final TtsResult d = null;
    public static final TtsResult e = null;
    public final b a;
    public final String b;
    public final Throwable c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$AccessCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKONWN", "NETWORK_ERROR", "FILE_NOT_EXISTS", "NO_PERMISSION_DEFAULT", "NO_VIEW_PERMISSION", "NO_PREVIEW_PERMISSION", "NO_PERCEIVE_PERMISSION", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccessCode extends Enum<AccessCode> implements b {
        public static final AccessCode FILE_NOT_EXISTS = null;
        public static final AccessCode NETWORK_ERROR = null;
        public static final AccessCode NO_PERCEIVE_PERMISSION = null;
        public static final AccessCode NO_PERMISSION_DEFAULT = null;
        public static final AccessCode NO_PREVIEW_PERMISSION = null;
        public static final AccessCode NO_VIEW_PERMISSION = null;
        public static final AccessCode UNKONWN = null;
        public static final /* synthetic */ AccessCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int codeNum;

        public static EnumEntries<AccessCode> getEntries() {
            return b;
        }

        static {
            AccessCode r0 = new AccessCode("UNKONWN", 0, -401);
            UNKONWN = r0;
            AccessCode r1 = new AccessCode("NETWORK_ERROR", 1, -402);
            NETWORK_ERROR = r1;
            AccessCode r2 = new AccessCode("FILE_NOT_EXISTS", 2, -404);
            FILE_NOT_EXISTS = r2;
            AccessCode r4 = new AccessCode("NO_PERMISSION_DEFAULT", 3, -411);
            NO_PERMISSION_DEFAULT = r4;
            AccessCode r6 = new AccessCode("NO_VIEW_PERMISSION", 4, -412);
            NO_VIEW_PERMISSION = r6;
            AccessCode r8 = new AccessCode("NO_PREVIEW_PERMISSION", 5, -412);
            NO_PREVIEW_PERMISSION = r8;
            AccessCode r12 = new AccessCode("NO_PERCEIVE_PERMISSION", 6, -412);
            NO_PERCEIVE_PERMISSION = r12;
            AccessCode[] r11 = {r0, r1, r2, r4, r6, r8, r12};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static AccessCode[] values() {
            return (AccessCode[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static AccessCode valueOf(String r1) {
            return (AccessCode) r27.a.a(AccessCode.class, r1);
        }

        public AccessCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.codeNum = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$BaseCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "SUCCESS", "UNKNOWN", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BaseCode extends Enum<BaseCode> implements b {
        public static final BaseCode SUCCESS = null;
        public static final BaseCode UNKNOWN = null;
        public static final /* synthetic */ BaseCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int codeNum;

        public static EnumEntries<BaseCode> getEntries() {
            return b;
        }

        static {
            BaseCode r0 = new BaseCode("SUCCESS", 0, 0);
            SUCCESS = r0;
            BaseCode r1 = new BaseCode("UNKNOWN", 1, -1);
            UNKNOWN = r1;
            BaseCode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static BaseCode[] values() {
            return (BaseCode[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static BaseCode valueOf(String r1) {
            return (BaseCode) r27.a.a(BaseCode.class, r1);
        }

        public BaseCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.codeNum = r3;
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
        public static final /* synthetic */ ModelCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int codeNum;

        public static EnumEntries<ModelCode> getEntries() {
            return b;
        }

        static {
            ModelCode r0 = new ModelCode("UNKNOWN", 0, -101);
            UNKNOWN = r0;
            ModelCode r1 = new ModelCode("NOT_INIT", 1, -102);
            NOT_INIT = r1;
            ModelCode r2 = new ModelCode("CANCELLED", 2, -103);
            CANCELLED = r2;
            ModelCode r4 = new ModelCode("SAVE_FAILED", 3, -105);
            SAVE_FAILED = r4;
            ModelCode r6 = new ModelCode("DELETE_FAILED", 4, -106);
            DELETE_FAILED = r6;
            ModelCode r8 = new ModelCode("M3U8_INVALID", 5, -131);
            M3U8_INVALID = r8;
            ModelCode r10 = new ModelCode("M3U8_LINK_INVALID", 6, -132);
            M3U8_LINK_INVALID = r10;
            ModelCode r12 = new ModelCode("M3U8_SERVER_LIMIT", 7, -134);
            M3U8_SERVER_LIMIT = r12;
            ModelCode r14 = new ModelCode("TONE_LIST_INVALID", 8, -142);
            TONE_LIST_INVALID = r14;
            ModelCode r13 = new ModelCode("TONE_NOT_SUPPORTED", 9, -143);
            TONE_NOT_SUPPORTED = r13;
            ModelCode[] r11 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static ModelCode[] values() {
            return (ModelCode[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static ModelCode valueOf(String r1) {
            return (ModelCode) r27.a.a(ModelCode.class, r1);
        }

        public ModelCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.codeNum = r3;
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
        public static final /* synthetic */ OperationCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int codeNum;

        public static EnumEntries<OperationCode> getEntries() {
            return b;
        }

        static {
            OperationCode r0 = new OperationCode("UNKNOWN", 0, -201);
            UNKNOWN = r0;
            OperationCode r1 = new OperationCode("DROPPED", 1, -202);
            DROPPED = r1;
            OperationCode r2 = new OperationCode("PLAYER_NOT_INIT", 2, -211);
            PLAYER_NOT_INIT = r2;
            OperationCode r4 = new OperationCode("PLAYER_STATE_NOT_AVAILABLE", 3, -221);
            PLAYER_STATE_NOT_AVAILABLE = r4;
            OperationCode r6 = new OperationCode("PRELOAD_FAILED_NOT_PREPARED", 4, -302);
            PRELOAD_FAILED_NOT_PREPARED = r6;
            OperationCode r8 = new OperationCode("SEEK_FAILED_NOT_PLAYABLE", 5, -502);
            SEEK_FAILED_NOT_PLAYABLE = r8;
            OperationCode[] r10 = {r0, r1, r2, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static OperationCode[] values() {
            return (OperationCode[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static OperationCode valueOf(String r1) {
            return (OperationCode) r27.a.a(OperationCode.class, r1);
        }

        public OperationCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.codeNum = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsResult$PlayerCode;", "Lcom/bytedance/ee/bear/tts/TtsResult$ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "codeNum", "getCodeNum", "()I", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlayerCode extends Enum<PlayerCode> implements b {
        public static final PlayerCode UNKNOWN = null;
        public static final /* synthetic */ PlayerCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int codeNum;

        public static EnumEntries<PlayerCode> getEntries() {
            return b;
        }

        static {
            PlayerCode r0 = new PlayerCode();
            UNKNOWN = r0;
            PlayerCode[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public PlayerCode() {
            super("UNKNOWN", 0);
            this.codeNum = -301;
        }

        public static PlayerCode[] values() {
            return (PlayerCode[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.tts.TtsResult.b
        public int getCodeNum() {
            return this.codeNum;
        }

        public static PlayerCode valueOf(String r1) {
            return (PlayerCode) r27.a.a(PlayerCode.class, r1);
        }
    }

    public static final class a {
    }

    public interface b {
        int getCodeNum();
    }

    static {
        d = new TtsResult(BaseCode.SUCCESS);
        e = new TtsResult(BaseCode.UNKNOWN);
    }

    public final boolean a() {
        if (this.a != BaseCode.SUCCESS) goto L16;
        String r0 = this.b;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (this.c != null) goto L18;
        return true;
    L18:
        return false;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L16:
        return false;
    }

    public final String toString() {
        return "TtsResult{code: " + this.a + ", errMsg: " + this.b + ", throwable: " + this.c + '}';
    }

    public TtsResult(b r2) {
        Intrinsics.checkNotNullParameter(r2, "code");
        this.a = r2;
        this.b = null;
        this.c = null;
    }
}
