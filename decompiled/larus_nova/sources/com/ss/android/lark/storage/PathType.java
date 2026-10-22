package com.ss.android.lark.storage;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.keva.KevaImpl;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/storage/PathType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ROOT", "CACHE", "CODE_CACHE", "FILES", "PICTURES", "valueOf", "", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PathType extends Enum<PathType> {
    public static final PathType CACHE = null;
    public static final PathType CODE_CACHE = null;
    public static final PathType FILES = null;
    public static final PathType PICTURES = null;
    public static final PathType ROOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PathType[] f440939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440940b = null;
    private final String value;

    public static EnumEntries<PathType> getEntries() {
        return f440940b;
    }

    public final void valueOf() {
    }

    static {
        PathType r100 = new PathType("ROOT", 0, RootDescription.ROOT_ELEMENT);
        ROOT = r100;
        PathType r101 = new PathType("CACHE", 1, "cache");
        CACHE = r101;
        PathType r102 = new PathType("CODE_CACHE", 2, "code.cache");
        CODE_CACHE = r102;
        PathType r103 = new PathType("FILES", 3, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        FILES = r103;
        PathType r104 = new PathType("PICTURES", 4, NoticeInfo.KEY_PICTURES);
        PICTURES = r104;
        PathType[] r105 = {r100, r101, r102, r103, r104};
        f440939a = r105;
        f440940b = EnumEntriesKt.enumEntries(r105);
    }

    public static PathType[] values() {
        return (PathType[]) f440939a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PathType valueOf(String r100) {
        return (PathType) r27.a.a(PathType.class, r100);
    }

    public PathType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
