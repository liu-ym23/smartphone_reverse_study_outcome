package com.ss.android.lark.biz.im.api.bundle;

import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/SourceType;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "FEED", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "SHORTCUT", "SEARCH", "CARD", "PROFILE", "LINK", "VC", "IPC", "UNKNOWN", "CHAT", "THREAD", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SourceType extends Enum<SourceType> {
    public static final SourceType CARD = null;
    public static final SourceType CHAT = null;
    public static final a Companion = null;
    public static final SourceType FEED = null;
    public static final SourceType IPC = null;
    public static final SourceType LINK = null;
    public static final SourceType PROFILE = null;
    public static final SourceType PUSH = null;
    public static final SourceType SEARCH = null;
    public static final SourceType SHORTCUT = null;
    public static final SourceType THREAD = null;
    public static final SourceType UNKNOWN = null;
    public static final SourceType VC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceType[] f409964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409965b = null;
    public int index;
    public String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SourceType> getEntries() {
        return f409965b;
    }

    static {
        SourceType r100 = new SourceType("FEED", 0, "feed", 1);
        FEED = r100;
        SourceType r101 = new SourceType(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 1, "push", 2);
        PUSH = r101;
        SourceType r102 = new SourceType("SHORTCUT", 2, "shortcut", 3);
        SHORTCUT = r102;
        SourceType r103 = new SourceType("SEARCH", 3, "search", 5);
        SEARCH = r103;
        SourceType r104 = new SourceType("CARD", 4, BrowserDependency.UrlClickType.CARD, 7);
        CARD = r104;
        SourceType r105 = new SourceType("PROFILE", 5, "profile", 8);
        PROFILE = r105;
        SourceType r110 = new SourceType("LINK", 6, "link", 9);
        LINK = r110;
        SourceType r111 = new SourceType("VC", 7, ThumbGlideUrl.SOURCE_VC, 10);
        VC = r111;
        SourceType r112 = new SourceType("IPC", 8, "ipc", 0);
        IPC = r112;
        SourceType r113 = new SourceType("UNKNOWN", 9, "unknown", 0);
        UNKNOWN = r113;
        SourceType r114 = new SourceType("CHAT", 10, "chat", 0);
        CHAT = r114;
        SourceType r106 = new SourceType("THREAD", 11, "thread", 0);
        THREAD = r106;
        SourceType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
        f409964a = r107;
        f409965b = EnumEntriesKt.enumEntries(r107);
        Companion = new a();
    }

    public static SourceType[] values() {
        return (SourceType[]) f409964a.clone();
    }

    @JvmStatic
    public static final SourceType fromValue(String r100) {
        Companion.getClass();
        SourceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        SourceType r104 = r101[r103];
        if (TextUtils.equals(r104.value, r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static SourceType valueOf(String r100) {
        return (SourceType) r27.a.a(SourceType.class, r100);
    }

    public SourceType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.index = r103;
    }
}
