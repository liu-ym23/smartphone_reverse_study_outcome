package com.bytedance.iesgurd.core;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b+\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/bytedance/iesgurd/core/EventSubType;", "", "", "type", "I", "getType", "()I", "RIGISTER_CLASS", "EXTERNAL_DIR", "OVERRIDE_PATH", "DIFFERENT_PATH_FOR_AK", "SERVICE_MANAGER", "BLOCK_IO_ERROR", "BLOCK_DOWNLOAD_ERROR", "META_DATA_MOVE", "FILE_BROKEN", "META_PARSE_KEY_ERROR", "META_PARSE_VALUE_ERROR", "META_PARSE_ERROR", "META_PRE_DOWNLOAD_ERROR", "META_CHECK_DIR_ERROR", "META_CHANNEL_FILE_NOT_EXIST", "META_VERSION_FILE_NOT_EXIST", "CHUNK_TIDY_UP_ERROR", "CHUNK_CONTENT_BROKEN", "BLOCK_FILE_NOT_EXIST", "BLOCK_INDEXING_NOT_EXIST", "BUILD_MMAP_BLOCK_BUFFER_FAILED", "AVAILABLE_CHUNK_SIZE_NOT_EQUALS_BLOCK_FILE_SIZE", "NON_HEAP_BUFFER_ALLOCATE_FAILED", "READ_GKFS_IN_SUB_PROCESS", "BUFFER_CREATE_OVER_CACHE_SIZE", "DELETE_GKFS_FILE", "DELETE_ORIGIN_FILE_FAILED", "ORIGIN_FILE_EXISTS", "MULTI_VERSION", "WRITE_AFTER_FINISH", "WRITE_AFTER_RELEASE", "MIGRATE_RES", "REGISTER_LATER_WITH_CUSTOM", "REGISTER_LATER_WITHOUT_CUSTOM", "REGISTER_MISS", "MIGRATE_RES_SKIP", "FORBIDDEN", "UNFORBIDDEN", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum EventSubType extends Enum<EventSubType> {
    public static final EventSubType AVAILABLE_CHUNK_SIZE_NOT_EQUALS_BLOCK_FILE_SIZE = null;
    public static final EventSubType BLOCK_DOWNLOAD_ERROR = null;
    public static final EventSubType BLOCK_FILE_NOT_EXIST = null;
    public static final EventSubType BLOCK_INDEXING_NOT_EXIST = null;
    public static final EventSubType BLOCK_IO_ERROR = null;
    public static final EventSubType BUFFER_CREATE_OVER_CACHE_SIZE = null;
    public static final EventSubType BUILD_MMAP_BLOCK_BUFFER_FAILED = null;
    public static final EventSubType CHUNK_CONTENT_BROKEN = null;
    public static final EventSubType CHUNK_TIDY_UP_ERROR = null;
    public static final EventSubType DELETE_GKFS_FILE = null;
    public static final EventSubType DELETE_ORIGIN_FILE_FAILED = null;
    public static final EventSubType DIFFERENT_PATH_FOR_AK = null;
    public static final EventSubType EXTERNAL_DIR = null;
    public static final EventSubType FILE_BROKEN = null;
    public static final EventSubType FORBIDDEN = null;
    public static final EventSubType META_CHANNEL_FILE_NOT_EXIST = null;
    public static final EventSubType META_CHECK_DIR_ERROR = null;
    public static final EventSubType META_DATA_MOVE = null;
    public static final EventSubType META_PARSE_ERROR = null;
    public static final EventSubType META_PARSE_KEY_ERROR = null;
    public static final EventSubType META_PARSE_VALUE_ERROR = null;
    public static final EventSubType META_PRE_DOWNLOAD_ERROR = null;
    public static final EventSubType META_VERSION_FILE_NOT_EXIST = null;
    public static final EventSubType MIGRATE_RES = null;
    public static final EventSubType MIGRATE_RES_SKIP = null;
    public static final EventSubType MULTI_VERSION = null;
    public static final EventSubType NON_HEAP_BUFFER_ALLOCATE_FAILED = null;
    public static final EventSubType ORIGIN_FILE_EXISTS = null;
    public static final EventSubType OVERRIDE_PATH = null;
    public static final EventSubType READ_GKFS_IN_SUB_PROCESS = null;
    public static final EventSubType REGISTER_LATER_WITHOUT_CUSTOM = null;
    public static final EventSubType REGISTER_LATER_WITH_CUSTOM = null;
    public static final EventSubType REGISTER_MISS = null;
    public static final EventSubType RIGISTER_CLASS = null;
    public static final EventSubType SERVICE_MANAGER = null;
    public static final EventSubType UNFORBIDDEN = null;
    public static final EventSubType WRITE_AFTER_FINISH = null;
    public static final EventSubType WRITE_AFTER_RELEASE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventSubType[] f250631a = null;
    private final int type;

    public static EventSubType valueOf(String r100) {
        return (EventSubType) r27.a.a(EventSubType.class, r100);
    }

    public static EventSubType[] values() {
        return (EventSubType[]) f250631a.clone();
    }

    static {
        EventSubType r100 = new EventSubType("RIGISTER_CLASS", 0, -1001);
        RIGISTER_CLASS = r100;
        EventSubType r101 = new EventSubType("EXTERNAL_DIR", 1, 9);
        EXTERNAL_DIR = r101;
        EventSubType r102 = new EventSubType("OVERRIDE_PATH", 2, 10);
        OVERRIDE_PATH = r102;
        EventSubType r103 = new EventSubType("DIFFERENT_PATH_FOR_AK", 3, 11);
        DIFFERENT_PATH_FOR_AK = r103;
        EventSubType r104 = new EventSubType("SERVICE_MANAGER", 4, 12);
        SERVICE_MANAGER = r104;
        EventSubType r105 = new EventSubType("BLOCK_IO_ERROR", 5, 49);
        BLOCK_IO_ERROR = r105;
        EventSubType r106 = new EventSubType("BLOCK_DOWNLOAD_ERROR", 6, 50);
        BLOCK_DOWNLOAD_ERROR = r106;
        EventSubType r107 = new EventSubType("META_DATA_MOVE", 7, 51);
        META_DATA_MOVE = r107;
        EventSubType r108 = new EventSubType("FILE_BROKEN", 8, 1101);
        FILE_BROKEN = r108;
        EventSubType r109 = new EventSubType("META_PARSE_KEY_ERROR", 9, 3010);
        META_PARSE_KEY_ERROR = r109;
        EventSubType r110 = new EventSubType("META_PARSE_VALUE_ERROR", 10, 3011);
        META_PARSE_VALUE_ERROR = r110;
        EventSubType r111 = new EventSubType("META_PARSE_ERROR", 11, 3012);
        META_PARSE_ERROR = r111;
        EventSubType r112 = new EventSubType("META_PRE_DOWNLOAD_ERROR", 12, SpeechEngineDefines.CODE_TTS_INVALID_AUDIO_FORMAT);
        META_PRE_DOWNLOAD_ERROR = r112;
        EventSubType r113 = new EventSubType("META_CHECK_DIR_ERROR", 13, SpeechEngineDefines.CODE_TTS_INVALID_ENCODE_PARAMS);
        META_CHECK_DIR_ERROR = r113;
        EventSubType r114 = new EventSubType("META_CHANNEL_FILE_NOT_EXIST", 14, SpeechEngineDefines.CODE_TTS_ENCODE_ERROR);
        META_CHANNEL_FILE_NOT_EXIST = r114;
        EventSubType r115 = new EventSubType("META_VERSION_FILE_NOT_EXIST", 15, 3023);
        META_VERSION_FILE_NOT_EXIST = r115;
        EventSubType r116 = new EventSubType("CHUNK_TIDY_UP_ERROR", 16, 4001);
        CHUNK_TIDY_UP_ERROR = r116;
        EventSubType r117 = new EventSubType("CHUNK_CONTENT_BROKEN", 17, 4002);
        CHUNK_CONTENT_BROKEN = r117;
        EventSubType r118 = new EventSubType("BLOCK_FILE_NOT_EXIST", 18, 4003);
        BLOCK_FILE_NOT_EXIST = r118;
        EventSubType r119 = new EventSubType("BLOCK_INDEXING_NOT_EXIST", 19, 4004);
        BLOCK_INDEXING_NOT_EXIST = r119;
        EventSubType r120 = new EventSubType("BUILD_MMAP_BLOCK_BUFFER_FAILED", 20, 4005);
        BUILD_MMAP_BLOCK_BUFFER_FAILED = r120;
        EventSubType r121 = new EventSubType("AVAILABLE_CHUNK_SIZE_NOT_EQUALS_BLOCK_FILE_SIZE", 21, 4006);
        AVAILABLE_CHUNK_SIZE_NOT_EQUALS_BLOCK_FILE_SIZE = r121;
        EventSubType r122 = new EventSubType("NON_HEAP_BUFFER_ALLOCATE_FAILED", 22, 4007);
        NON_HEAP_BUFFER_ALLOCATE_FAILED = r122;
        EventSubType r123 = new EventSubType("READ_GKFS_IN_SUB_PROCESS", 23, 4008);
        READ_GKFS_IN_SUB_PROCESS = r123;
        EventSubType r124 = new EventSubType("BUFFER_CREATE_OVER_CACHE_SIZE", 24, 4009);
        BUFFER_CREATE_OVER_CACHE_SIZE = r124;
        EventSubType r125 = new EventSubType("DELETE_GKFS_FILE", 25, 5001);
        DELETE_GKFS_FILE = r125;
        EventSubType r126 = new EventSubType("DELETE_ORIGIN_FILE_FAILED", 26, 5002);
        DELETE_ORIGIN_FILE_FAILED = r126;
        EventSubType r127 = new EventSubType("ORIGIN_FILE_EXISTS", 27, 5003);
        ORIGIN_FILE_EXISTS = r127;
        EventSubType r128 = new EventSubType("MULTI_VERSION", 28, 20250301);
        MULTI_VERSION = r128;
        EventSubType r129 = new EventSubType("WRITE_AFTER_FINISH", 29, 20250403);
        WRITE_AFTER_FINISH = r129;
        EventSubType r130 = new EventSubType("WRITE_AFTER_RELEASE", 30, 20250404);
        WRITE_AFTER_RELEASE = r130;
        EventSubType r131 = new EventSubType("MIGRATE_RES", 31, 20250701);
        MIGRATE_RES = r131;
        EventSubType r132 = new EventSubType("REGISTER_LATER_WITH_CUSTOM", 32, 20250702);
        REGISTER_LATER_WITH_CUSTOM = r132;
        EventSubType r133 = new EventSubType("REGISTER_LATER_WITHOUT_CUSTOM", 33, 20250703);
        REGISTER_LATER_WITHOUT_CUSTOM = r133;
        EventSubType r134 = new EventSubType("REGISTER_MISS", 34, 20250704);
        REGISTER_MISS = r134;
        EventSubType r135 = new EventSubType("MIGRATE_RES_SKIP", 35, 20250705);
        MIGRATE_RES_SKIP = r135;
        EventSubType r136 = new EventSubType("FORBIDDEN", 36, 20250801);
        FORBIDDEN = r136;
        EventSubType r137 = new EventSubType("UNFORBIDDEN", 37, 20250802);
        UNFORBIDDEN = r137;
        f250631a = new EventSubType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137};
    }

    public final int getType() {
        return this.type;
    }

    public EventSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
