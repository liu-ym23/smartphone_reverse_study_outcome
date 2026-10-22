package com.tencent.wcdb.base;

import com.amap.api.services.core.AMapException;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.network.http.ServiceType;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class WCDBException extends RuntimeException {
    public final Code code;
    public final Map<String, Object> info;
    public final Level level;

    /* JADX INFO: renamed from: com.tencent.wcdb.base.WCDBException$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$base$WCDBException$Level = null;

        static {
            int[] r100 = new int[Level.values().length];
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level = r100;
            r100[Level.Ignore.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level[Level.Debug.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level[Level.Notice.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level[Level.Warning.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level[Level.Error.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$tencent$wcdb$base$WCDBException$Level[Level.Fatal.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static final enum Code extends Enum<Code> {
        private static final /* synthetic */ Code[] $VALUES = null;
        public static final Code Abort = null;
        public static final Code Authorization = null;
        public static final Code Busy = null;
        public static final Code CantOpen = null;
        public static final Code Constraint = null;
        public static final Code Corrupt = null;
        public static final Code Done = null;
        public static final Code Empty = null;
        public static final Code Error = null;
        public static final Code Exceed = null;
        public static final Code Format = null;
        public static final Code Full = null;
        public static final Code IOError = null;
        public static final Code Internal = null;
        public static final Code Interrupt = null;
        public static final Code Locked = null;
        public static final Code Mismatch = null;
        public static final Code Misuse = null;
        public static final Code NoLargeFileSupport = null;
        public static final Code NoMemory = null;
        public static final Code NotADatabase = null;
        public static final Code NotFound = null;
        public static final Code Notice = null;
        public static final Code OK = null;
        public static final Code Permission = null;
        public static final Code Protocol = null;
        public static final Code Range = null;
        public static final Code Readonly = null;
        public static final Code Row = null;
        public static final Code Schema = null;
        public static final Code Unknown = null;
        public static final Code Warning = null;
        private final int value;

        private static /* synthetic */ Code[] $values() {
            return new Code[]{OK, Error, Internal, Permission, Abort, Busy, Locked, NoMemory, Readonly, Interrupt, IOError, Corrupt, NotFound, Full, CantOpen, Protocol, Empty, Schema, Exceed, Constraint, Mismatch, Misuse, NoLargeFileSupport, Authorization, Format, Range, NotADatabase, Notice, Warning, Row, Done, Unknown};
        }

        static {
            OK = new Code("OK", 0, 0);
            Error = new Code("Error", 1, 1);
            Internal = new Code("Internal", 2, 2);
            Permission = new Code("Permission", 3, 3);
            Abort = new Code("Abort", 4, 4);
            Busy = new Code("Busy", 5, 5);
            Locked = new Code("Locked", 6, 6);
            NoMemory = new Code("NoMemory", 7, 7);
            Readonly = new Code("Readonly", 8, 8);
            Interrupt = new Code("Interrupt", 9, 9);
            IOError = new Code("IOError", 10, 10);
            Corrupt = new Code("Corrupt", 11, 11);
            NotFound = new Code("NotFound", 12, 12);
            Full = new Code("Full", 13, 13);
            CantOpen = new Code("CantOpen", 14, 14);
            Protocol = new Code("Protocol", 15, 15);
            Empty = new Code("Empty", 16, 16);
            Schema = new Code("Schema", 17, 17);
            Exceed = new Code("Exceed", 18, 18);
            Constraint = new Code("Constraint", 19, 19);
            Mismatch = new Code("Mismatch", 20, 20);
            Misuse = new Code("Misuse", 21, 21);
            NoLargeFileSupport = new Code("NoLargeFileSupport", 22, 22);
            Authorization = new Code("Authorization", 23, 23);
            Format = new Code("Format", 24, 24);
            Range = new Code("Range", 25, 25);
            NotADatabase = new Code("NotADatabase", 26, 26);
            Notice = new Code("Notice", 27, 27);
            Warning = new Code("Warning", 28, 28);
            Row = new Code("Row", 29, 100);
            Done = new Code("Done", 30, 101);
            Unknown = new Code("Unknown", 31, -1);
            $VALUES = $values();
        }

        public static Code[] values() {
            return (Code[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static Code valueOf(int r100) {
            if (r100 == 100) goto L70;
            if (r100 == 101) goto L68;
            switch(r100) {
                case 0: goto L66;
                case 1: goto L64;
                case 2: goto L62;
                case 3: goto L60;
                case 4: goto L58;
                case 5: goto L56;
                case 6: goto L54;
                case 7: goto L52;
                case 8: goto L50;
                case 9: goto L48;
                case 10: goto L46;
                case 11: goto L44;
                case 12: goto L42;
                case 13: goto L40;
                case 14: goto L38;
                case 15: goto L36;
                case 16: goto L34;
                case 17: goto L32;
                case 18: goto L30;
                case 19: goto L28;
                case 20: goto L26;
                case 21: goto L24;
                case 22: goto L22;
                case 23: goto L20;
                case 24: goto L18;
                case 25: goto L16;
                case 26: goto L14;
                case 27: goto L12;
                case 28: goto L10;
                default: goto L8;
            };
        L8:
            return Unknown;
        L10:
            return Warning;
        L12:
            return Notice;
        L14:
            return NotADatabase;
        L16:
            return Range;
        L18:
            return Format;
        L20:
            return Authorization;
        L22:
            return NoLargeFileSupport;
        L24:
            return Misuse;
        L26:
            return Mismatch;
        L28:
            return Constraint;
        L30:
            return Exceed;
        L32:
            return Schema;
        L34:
            return Empty;
        L36:
            return Protocol;
        L38:
            return CantOpen;
        L40:
            return Full;
        L42:
            return NotFound;
        L44:
            return Corrupt;
        L46:
            return IOError;
        L48:
            return Interrupt;
        L50:
            return Readonly;
        L52:
            return NoMemory;
        L54:
            return Locked;
        L56:
            return Busy;
        L58:
            return Abort;
        L60:
            return Permission;
        L62:
            return Internal;
        L64:
            return Error;
        L66:
            return OK;
        L68:
            return Done;
        L70:
            return Row;
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        private Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ExtendCode extends Enum<ExtendCode> {
        private static final /* synthetic */ ExtendCode[] $VALUES = null;
        public static final ExtendCode AbortRollback = null;
        public static final ExtendCode AuthorizationUser = null;
        public static final ExtendCode BusyRecovery = null;
        public static final ExtendCode BusySnapshot = null;
        public static final ExtendCode CantOpenConvPath = null;
        public static final ExtendCode CantOpenDirtyWal = null;
        public static final ExtendCode CantOpenFullPath = null;
        public static final ExtendCode CantOpenIsDir = null;
        public static final ExtendCode CantOpenNoTempDir = null;
        public static final ExtendCode ConstraintCheck = null;
        public static final ExtendCode ConstraintCommitHook = null;
        public static final ExtendCode ConstraintForeignKey = null;
        public static final ExtendCode ConstraintFunction = null;
        public static final ExtendCode ConstraintNotNull = null;
        public static final ExtendCode ConstraintPrimaryKey = null;
        public static final ExtendCode ConstraintRowID = null;
        public static final ExtendCode ConstraintTrigger = null;
        public static final ExtendCode ConstraintUnique = null;
        public static final ExtendCode ConstraintVirtualTable = null;
        public static final ExtendCode CorruptSequence = null;
        public static final ExtendCode CorruptVirtualTable = null;
        public static final ExtendCode ErrorMissingCollseq = null;
        public static final ExtendCode ErrorRetry = null;
        public static final ExtendCode ErrorSnapshot = null;
        public static final ExtendCode IOErrorAccess = null;
        public static final ExtendCode IOErrorAuthorization = null;
        public static final ExtendCode IOErrorBeginAtomic = null;
        public static final ExtendCode IOErrorBlocked = null;
        public static final ExtendCode IOErrorCheckReservedLock = null;
        public static final ExtendCode IOErrorClose = null;
        public static final ExtendCode IOErrorCommitAtomic = null;
        public static final ExtendCode IOErrorConvPath = null;
        public static final ExtendCode IOErrorDelete = null;
        public static final ExtendCode IOErrorDeleteNoEntry = null;
        public static final ExtendCode IOErrorDirClose = null;
        public static final ExtendCode IOErrorDirFsync = null;
        public static final ExtendCode IOErrorFstat = null;
        public static final ExtendCode IOErrorFsync = null;
        public static final ExtendCode IOErrorGetTempPath = null;
        public static final ExtendCode IOErrorLock = null;
        public static final ExtendCode IOErrorMmap = null;
        public static final ExtendCode IOErrorNoMemory = null;
        public static final ExtendCode IOErrorRdlock = null;
        public static final ExtendCode IOErrorRead = null;
        public static final ExtendCode IOErrorRollbackAtomic = null;
        public static final ExtendCode IOErrorSeek = null;
        public static final ExtendCode IOErrorShmLock = null;
        public static final ExtendCode IOErrorShmMap = null;
        public static final ExtendCode IOErrorShmOpen = null;
        public static final ExtendCode IOErrorShmSize = null;
        public static final ExtendCode IOErrorShortRead = null;
        public static final ExtendCode IOErrorTruncate = null;
        public static final ExtendCode IOErrorUnlock = null;
        public static final ExtendCode IOErrorVnode = null;
        public static final ExtendCode IOErrorWrite = null;
        public static final ExtendCode LockedSharedCache = null;
        public static final ExtendCode LockedVirtualTable = null;
        public static final ExtendCode NoticeRecoverRollback = null;
        public static final ExtendCode NoticeRecoverWal = null;
        public static final ExtendCode OKLoadPermanently = null;
        public static final ExtendCode ReadonlyCantInit = null;
        public static final ExtendCode ReadonlyCantLock = null;
        public static final ExtendCode ReadonlyDatabaseMoved = null;
        public static final ExtendCode ReadonlyDirectory = null;
        public static final ExtendCode ReadonlyRecovery = null;
        public static final ExtendCode ReadonlyRollback = null;
        public static final ExtendCode Unknown = null;
        public static final ExtendCode WarningAutoIndex = null;
        private final int value;

        private static /* synthetic */ ExtendCode[] $values() {
            return new ExtendCode[]{ErrorMissingCollseq, ErrorRetry, ErrorSnapshot, IOErrorRead, IOErrorShortRead, IOErrorWrite, IOErrorFsync, IOErrorDirFsync, IOErrorTruncate, IOErrorFstat, IOErrorUnlock, IOErrorRdlock, IOErrorDelete, IOErrorBlocked, IOErrorNoMemory, IOErrorAccess, IOErrorCheckReservedLock, IOErrorLock, IOErrorClose, IOErrorDirClose, IOErrorShmOpen, IOErrorShmSize, IOErrorShmLock, IOErrorShmMap, IOErrorSeek, IOErrorDeleteNoEntry, IOErrorMmap, IOErrorGetTempPath, IOErrorConvPath, IOErrorVnode, IOErrorAuthorization, IOErrorBeginAtomic, IOErrorCommitAtomic, IOErrorRollbackAtomic, LockedSharedCache, LockedVirtualTable, BusyRecovery, BusySnapshot, CantOpenNoTempDir, CantOpenIsDir, CantOpenFullPath, CantOpenConvPath, CantOpenDirtyWal, CorruptVirtualTable, CorruptSequence, ReadonlyRecovery, ReadonlyCantLock, ReadonlyRollback, ReadonlyDatabaseMoved, ReadonlyCantInit, ReadonlyDirectory, AbortRollback, ConstraintCheck, ConstraintCommitHook, ConstraintForeignKey, ConstraintFunction, ConstraintNotNull, ConstraintPrimaryKey, ConstraintTrigger, ConstraintUnique, ConstraintVirtualTable, ConstraintRowID, NoticeRecoverWal, NoticeRecoverRollback, WarningAutoIndex, AuthorizationUser, OKLoadPermanently, Unknown};
        }

        static {
            ErrorMissingCollseq = new ExtendCode("ErrorMissingCollseq", 0, 257);
            ErrorRetry = new ExtendCode("ErrorRetry", 1, 513);
            ErrorSnapshot = new ExtendCode("ErrorSnapshot", 2, 769);
            IOErrorRead = new ExtendCode("IOErrorRead", 3, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME);
            IOErrorShortRead = new ExtendCode("IOErrorShortRead", 4, 522);
            IOErrorWrite = new ExtendCode("IOErrorWrite", 5, 778);
            IOErrorFsync = new ExtendCode("IOErrorFsync", 6, 1034);
            IOErrorDirFsync = new ExtendCode("IOErrorDirFsync", 7, 1290);
            IOErrorTruncate = new ExtendCode("IOErrorTruncate", 8, 1546);
            IOErrorFstat = new ExtendCode("IOErrorFstat", 9, 1802);
            IOErrorUnlock = new ExtendCode("IOErrorUnlock", 10, 2058);
            IOErrorRdlock = new ExtendCode("IOErrorRdlock", 11, 2314);
            IOErrorDelete = new ExtendCode("IOErrorDelete", 12, 2570);
            IOErrorBlocked = new ExtendCode("IOErrorBlocked", 13, 2826);
            IOErrorNoMemory = new ExtendCode("IOErrorNoMemory", 14, 3082);
            IOErrorAccess = new ExtendCode("IOErrorAccess", 15, 3338);
            IOErrorCheckReservedLock = new ExtendCode("IOErrorCheckReservedLock", 16, 3594);
            IOErrorLock = new ExtendCode("IOErrorLock", 17, 3850);
            IOErrorClose = new ExtendCode("IOErrorClose", 18, 4106);
            IOErrorDirClose = new ExtendCode("IOErrorDirClose", 19, 4362);
            IOErrorShmOpen = new ExtendCode("IOErrorShmOpen", 20, 4618);
            IOErrorShmSize = new ExtendCode("IOErrorShmSize", 21, 4874);
            IOErrorShmLock = new ExtendCode("IOErrorShmLock", 22, 5130);
            IOErrorShmMap = new ExtendCode("IOErrorShmMap", 23, 5386);
            IOErrorSeek = new ExtendCode("IOErrorSeek", 24, 5642);
            IOErrorDeleteNoEntry = new ExtendCode("IOErrorDeleteNoEntry", 25, 5898);
            IOErrorMmap = new ExtendCode("IOErrorMmap", 26, 6154);
            IOErrorGetTempPath = new ExtendCode("IOErrorGetTempPath", 27, 6410);
            IOErrorConvPath = new ExtendCode("IOErrorConvPath", 28, 6666);
            IOErrorVnode = new ExtendCode("IOErrorVnode", 29, 6922);
            IOErrorAuthorization = new ExtendCode("IOErrorAuthorization", 30, 7178);
            IOErrorBeginAtomic = new ExtendCode("IOErrorBeginAtomic", 31, AVMDLDataLoader.KeyIsPrecisePreloadConfig);
            IOErrorCommitAtomic = new ExtendCode("IOErrorCommitAtomic", 32, 7690);
            IOErrorRollbackAtomic = new ExtendCode("IOErrorRollbackAtomic", 33, 7946);
            LockedSharedCache = new ExtendCode("LockedSharedCache", 34, 262);
            LockedVirtualTable = new ExtendCode("LockedVirtualTable", 35, 518);
            BusyRecovery = new ExtendCode("BusyRecovery", 36, 261);
            BusySnapshot = new ExtendCode("BusySnapshot", 37, 517);
            CantOpenNoTempDir = new ExtendCode("CantOpenNoTempDir", 38, 270);
            CantOpenIsDir = new ExtendCode("CantOpenIsDir", 39, 526);
            CantOpenFullPath = new ExtendCode("CantOpenFullPath", 40, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PCDN_H2P_CACHE);
            CantOpenConvPath = new ExtendCode("CantOpenConvPath", 41, 1038);
            CantOpenDirtyWal = new ExtendCode("CantOpenDirtyWal", 42, 1294);
            CorruptVirtualTable = new ExtendCode("CorruptVirtualTable", 43, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME);
            CorruptSequence = new ExtendCode("CorruptSequence", 44, 523);
            ReadonlyRecovery = new ExtendCode("ReadonlyRecovery", 45, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME);
            ReadonlyCantLock = new ExtendCode("ReadonlyCantLock", 46, 520);
            ReadonlyRollback = new ExtendCode("ReadonlyRollback", 47, 776);
            ReadonlyDatabaseMoved = new ExtendCode("ReadonlyDatabaseMoved", 48, 1032);
            ReadonlyCantInit = new ExtendCode("ReadonlyCantInit", 49, 1288);
            ReadonlyDirectory = new ExtendCode("ReadonlyDirectory", 50, 1544);
            AbortRollback = new ExtendCode("AbortRollback", 51, 516);
            ConstraintCheck = new ExtendCode("ConstraintCheck", 52, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
            ConstraintCommitHook = new ExtendCode("ConstraintCommitHook", 53, 531);
            ConstraintForeignKey = new ExtendCode("ConstraintForeignKey", 54, 787);
            ConstraintFunction = new ExtendCode("ConstraintFunction", 55, 1043);
            ConstraintNotNull = new ExtendCode("ConstraintNotNull", 56, 1299);
            ConstraintPrimaryKey = new ExtendCode("ConstraintPrimaryKey", 57, 1555);
            ConstraintTrigger = new ExtendCode("ConstraintTrigger", 58, AMapException.CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
            ConstraintUnique = new ExtendCode("ConstraintUnique", 59, 2067);
            ConstraintVirtualTable = new ExtendCode("ConstraintVirtualTable", 60, 2323);
            ConstraintRowID = new ExtendCode("ConstraintRowID", 61, 2579);
            NoticeRecoverWal = new ExtendCode("NoticeRecoverWal", 62, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS);
            NoticeRecoverRollback = new ExtendCode("NoticeRecoverRollback", 63, 539);
            WarningAutoIndex = new ExtendCode("WarningAutoIndex", 64, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER);
            AuthorizationUser = new ExtendCode("AuthorizationUser", 65, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS);
            OKLoadPermanently = new ExtendCode("OKLoadPermanently", 66, 256);
            Unknown = new ExtendCode("Unknown", 67, -1);
            $VALUES = $values();
        }

        public static ExtendCode[] values() {
            return (ExtendCode[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static ExtendCode valueOf(int r100) {
            switch(r100) {
                case 256: goto L138;
                case 257: goto L136;
                case 261: goto L134;
                case 262: goto L132;
                case 264: goto L130;
                case 266: goto L128;
                case 267: goto L126;
                case 270: goto L124;
                case 275: goto L122;
                case 279: goto L120;
                case 283: goto L118;
                case 284: goto L116;
                case 513: goto L114;
                case 516: goto L112;
                case 517: goto L110;
                case 518: goto L108;
                case 520: goto L106;
                case 522: goto L104;
                case 523: goto L102;
                case 526: goto L100;
                case 531: goto L98;
                case 539: goto L96;
                case 769: goto L94;
                case 776: goto L92;
                case 778: goto L90;
                case 782: goto L88;
                case 787: goto L86;
                case 1032: goto L84;
                case 1034: goto L82;
                case 1038: goto L80;
                case 1043: goto L78;
                case 1288: goto L76;
                case 1290: goto L74;
                case 1294: goto L72;
                case 1299: goto L70;
                case 1544: goto L68;
                case 1546: goto L66;
                case 1555: goto L64;
                case 1802: goto L62;
                case 1811: goto L60;
                case 2058: goto L58;
                case 2067: goto L56;
                case 2314: goto L54;
                case 2323: goto L52;
                case 2570: goto L50;
                case 2579: goto L48;
                case 2826: goto L46;
                case 3082: goto L44;
                case 3338: goto L42;
                case 3594: goto L40;
                case 3850: goto L38;
                case 4106: goto L36;
                case 4362: goto L34;
                case 4618: goto L32;
                case 4874: goto L30;
                case 5130: goto L28;
                case 5386: goto L26;
                case 5642: goto L24;
                case 5898: goto L22;
                case 6154: goto L20;
                case 6410: goto L18;
                case 6666: goto L16;
                case 6922: goto L14;
                case 7178: goto L12;
                case 7434: goto L10;
                case 7690: goto L8;
                case 7946: goto L6;
                default: goto L4;
            };
        L4:
            return Unknown;
        L6:
            return IOErrorRollbackAtomic;
        L8:
            return IOErrorCommitAtomic;
        L10:
            return IOErrorBeginAtomic;
        L12:
            return IOErrorAuthorization;
        L14:
            return IOErrorVnode;
        L16:
            return IOErrorConvPath;
        L18:
            return IOErrorGetTempPath;
        L20:
            return IOErrorMmap;
        L22:
            return IOErrorDeleteNoEntry;
        L24:
            return IOErrorSeek;
        L26:
            return IOErrorShmMap;
        L28:
            return IOErrorShmLock;
        L30:
            return IOErrorShmSize;
        L32:
            return IOErrorShmOpen;
        L34:
            return IOErrorDirClose;
        L36:
            return IOErrorClose;
        L38:
            return IOErrorLock;
        L40:
            return IOErrorCheckReservedLock;
        L42:
            return IOErrorAccess;
        L44:
            return IOErrorNoMemory;
        L46:
            return IOErrorBlocked;
        L48:
            return ConstraintRowID;
        L50:
            return IOErrorDelete;
        L52:
            return ConstraintVirtualTable;
        L54:
            return IOErrorRdlock;
        L56:
            return ConstraintUnique;
        L58:
            return IOErrorUnlock;
        L60:
            return ConstraintTrigger;
        L62:
            return IOErrorFstat;
        L64:
            return ConstraintPrimaryKey;
        L66:
            return IOErrorTruncate;
        L68:
            return ReadonlyDirectory;
        L70:
            return ConstraintNotNull;
        L72:
            return CantOpenDirtyWal;
        L74:
            return IOErrorDirFsync;
        L76:
            return ReadonlyCantInit;
        L78:
            return ConstraintFunction;
        L80:
            return CantOpenConvPath;
        L82:
            return IOErrorFsync;
        L84:
            return ReadonlyDatabaseMoved;
        L86:
            return ConstraintForeignKey;
        L88:
            return CantOpenFullPath;
        L90:
            return IOErrorWrite;
        L92:
            return ReadonlyRollback;
        L94:
            return ErrorSnapshot;
        L96:
            return NoticeRecoverRollback;
        L98:
            return ConstraintCommitHook;
        L100:
            return CantOpenIsDir;
        L102:
            return CorruptSequence;
        L104:
            return IOErrorShortRead;
        L106:
            return ReadonlyCantLock;
        L108:
            return LockedVirtualTable;
        L110:
            return BusySnapshot;
        L112:
            return AbortRollback;
        L114:
            return ErrorRetry;
        L116:
            return WarningAutoIndex;
        L118:
            return NoticeRecoverWal;
        L120:
            return AuthorizationUser;
        L122:
            return ConstraintCheck;
        L124:
            return CantOpenNoTempDir;
        L126:
            return CorruptVirtualTable;
        L128:
            return IOErrorRead;
        L130:
            return ReadonlyRecovery;
        L132:
            return LockedSharedCache;
        L134:
            return BusyRecovery;
        L136:
            return ErrorMissingCollseq;
        L138:
            return OKLoadPermanently;
        }

        public static ExtendCode valueOf(String r100) {
            return (ExtendCode) a.a(ExtendCode.class, r100);
        }

        private ExtendCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Key extends Enum<Key> {
        private static final /* synthetic */ Key[] $VALUES = null;
        public static final Key SQL = null;
        public static final Key extendedCode = null;
        public static final Key message = null;
        public static final Key path = null;
        public static final Key source = null;
        public static final Key tag = null;
        public static final Key type = null;
        private final String value;

        private static /* synthetic */ Key[] $values() {
            return new Key[]{tag, path, type, source, SQL, extendedCode, message};
        }

        static {
            tag = new Key("tag", 0, "Tag");
            path = new Key("path", 1, "Path");
            type = new Key("type", 2, "Type");
            source = new Key("source", 3, "Source");
            SQL = new Key("SQL", 4, "SQL");
            extendedCode = new Key("extendedCode", 5, "ExtCode");
            message = new Key("message", 6, ServiceType.IM);
            $VALUES = $values();
        }

        public static Key[] values() {
            return (Key[]) $VALUES.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static /* synthetic */ String access$000(Key r100) {
            return r100.value;
        }

        public static Key valueOf(String r100) {
            return (Key) a.a(Key.class, r100);
        }

        private Key(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level Debug = null;
        public static final Level Error = null;
        public static final Level Fatal = null;
        public static final Level Ignore = null;
        public static final Level Notice = null;
        public static final Level Unknown = null;
        public static final Level Warning = null;

        private static /* synthetic */ Level[] $values() {
            return new Level[]{Ignore, Debug, Notice, Warning, Error, Fatal, Unknown};
        }

        static {
            Ignore = new Level("Ignore", 0);
            Debug = new Level("Debug", 1);
            Notice = new Level("Notice", 2);
            Warning = new Level("Warning", 3);
            Error = new Level("Error", 4);
            Fatal = new Level("Fatal", 5);
            Unknown = new Level("Unknown", 6);
            $VALUES = $values();
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            switch(AnonymousClass1.$SwitchMap$com$tencent$wcdb$base$WCDBException$Level[ordinal()]) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L4;
            };
        L4:
            return "UNKNOWN";
        L6:
            return SpeechEngineDefines.LOG_LEVEL_FATAL;
        L8:
            return "ERROR";
        L10:
            return "WARNING";
        L12:
            return "NOTICE";
        L14:
            return "DEBUG";
        L16:
            return "IGNORE";
        }

        public static Level valueOf(int r100) {
            switch(r100) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L4;
            };
        L4:
            return Unknown;
        L6:
            return Fatal;
        L8:
            return Error;
        L10:
            return Warning;
        L12:
            return Notice;
        L14:
            return Debug;
        L16:
            return Ignore;
        }

        public static Level valueOf(String r100) {
            return (Level) a.a(Level.class, r100);
        }

        private Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    private native void enumerateInfo(long r100);

    private static native int getCode(long r100);

    private static native int getLevel(long r100);

    private static native String getMessage(long r100);

    public ExtendCode extendCode() {
        Object r100 = this.info.get(Key.extendedCode.getValue());
        if (r100 == null) goto L7;
        return ExtendCode.valueOf(((Long) r100).intValue());
    L7:
        return ExtendCode.Unknown;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r100 = new StringBuilder(256);
        r100.append("Code: ");
        r100.append(this.code.value());
        Iterator<Map.Entry<String, Object>> r101 = this.info.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, Object> r102 = r101.next();
        r100.append("; ");
        r100.append(r102.getKey());
        r100.append(": ");
        r100.append(r102.getValue());
        goto L4
    L7:
        return r100.toString();
    }

    public String message() {
        return (String) this.info.get(Key.message.getValue());
    }

    public String path() {
        return (String) this.info.get(Key.path.getValue());
    }

    public String sql() {
        return (String) this.info.get(Key.SQL.getValue());
    }

    public long tag() {
        Object r100 = this.info.get(Key.tag.getValue());
        if (r100 != null) goto L5;
        return 0;
    L5:
        return ((Long) r100).longValue();
    }

    public String toStringForLog() {
        return "[WCDB] [" + this.level + "] " + getMessage();
    }

    public static WCDBException createException(long r100) {
        Level r101 = Level.valueOf(getLevel(r100));
        Code r102 = Code.valueOf(getCode(r100));
        if (r101 == Level.Error) goto L7;
        return new WCDBNormalException(r101, r102, r100);
    L7:
        if (r102 != Code.Interrupt) goto L11;
        return new WCDBInterruptException(r101, r102, r100);
    L11:
        if (r102 == Code.Permission) goto L28;
        if (r102 == Code.Readonly) goto L28;
        if (r102 == Code.IOError) goto L28;
        if (r102 == Code.Corrupt) goto L28;
        if (r102 == Code.Full) goto L28;
        if (r102 == Code.CantOpen) goto L28;
        if (r102 == Code.NotADatabase) goto L28;
        return new WCDBNormalException(r101, r102, r100);
    L28:
        return new WCDBCorruptOrIOException(r101, r102, r100);
    }

    public WCDBException(Level r100, Code r101, long r102) {
        this.level = r100;
        this.code = r101;
        String r103 = getMessage(r102);
        LinkedHashMap r104 = new LinkedHashMap();
        this.info = r104;
        r104.put(Key.access$000(Key.message), r103);
        enumerateInfo(r102);
    }

    private void addInfo(String r100, int r101, long r102, double r103, String r104) {
        if (r101 != 3) goto L6;
        this.info.put(r100, Long.valueOf(r102));
        return;
    L6:
        if (r101 != 5) goto L9;
        this.info.put(r100, Double.valueOf(r103));
        return;
    L9:
        if (r101 != 6) goto L14;
        this.info.put(r100, r104);
        return;
    }
}
