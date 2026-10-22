package com.larus.business.arc.api;

import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/arc/api/ArcPlatform;", "", "<init>", "(Ljava/lang/String;I)V", "ANDROID", "HARMONY", "IOS", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcPlatform extends Enum<ArcPlatform> {

    @SerialName("android")
    public static final ArcPlatform ANDROID = null;
    public static final a Companion = null;

    @SerialName(RomUtils.OS_HARMONY)
    public static final ArcPlatform HARMONY = null;

    @SerialName(BackupSeiMessage.SOURCE_IOS)
    public static final ArcPlatform IOS = null;

    @SerialName("unknown")
    public static final ArcPlatform UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcPlatform[] f319860b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319861c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcPlatform> serializer() {
            return (juc.d) ArcPlatform.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcPlatform> getEntries() {
        return f319861c;
    }

    static {
        ArcPlatform r100 = new ArcPlatform("ANDROID", 0);
        ANDROID = r100;
        ArcPlatform r101 = new ArcPlatform("HARMONY", 1);
        HARMONY = r101;
        ArcPlatform r102 = new ArcPlatform("IOS", 2);
        IOS = r102;
        ArcPlatform r103 = new ArcPlatform("UNKNOWN", 3);
        UNKNOWN = r103;
        ArcPlatform[] r104 = {r100, r101, r102, r103};
        f319860b = r104;
        f319861c = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
        f319859a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q());
    }

    public static ArcPlatform[] values() {
        return (ArcPlatform[]) f319860b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319859a;
    }

    public static ArcPlatform valueOf(String r100) {
        return (ArcPlatform) r27.a.a(ArcPlatform.class, r100);
    }

    public ArcPlatform(String r100, int r101) {
        super(r100, r101);
    }
}
