package kotlinx.datetime.format;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/format/Padding;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "ZERO", "SPACE", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Padding extends Enum<Padding> {
    public static final Padding NONE = null;
    public static final Padding SPACE = null;
    public static final Padding ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Padding[] f505187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505188b = null;

    public static EnumEntries<Padding> getEntries() {
        return f505188b;
    }

    static {
        Padding r100 = new Padding(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        Padding r101 = new Padding("ZERO", 1);
        ZERO = r101;
        Padding r102 = new Padding("SPACE", 2);
        SPACE = r102;
        Padding[] r103 = {r100, r101, r102};
        f505187a = r103;
        f505188b = EnumEntriesKt.enumEntries(r103);
    }

    public static Padding[] values() {
        return (Padding[]) f505187a.clone();
    }

    public static Padding valueOf(String r100) {
        return (Padding) r27.a.a(Padding.class, r100);
    }

    public Padding(String r100, int r101) {
        super(r100, r101);
    }
}
