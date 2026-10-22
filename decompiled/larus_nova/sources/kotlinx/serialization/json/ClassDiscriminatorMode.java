package kotlinx.serialization.json;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/ClassDiscriminatorMode;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "ALL_JSON_OBJECTS", "POLYMORPHIC", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ClassDiscriminatorMode extends Enum<ClassDiscriminatorMode> {
    public static final ClassDiscriminatorMode ALL_JSON_OBJECTS = null;
    public static final ClassDiscriminatorMode NONE = null;
    public static final ClassDiscriminatorMode POLYMORPHIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClassDiscriminatorMode[] f505368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505369b = null;

    public static EnumEntries<ClassDiscriminatorMode> getEntries() {
        return f505369b;
    }

    static {
        ClassDiscriminatorMode r100 = new ClassDiscriminatorMode(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ClassDiscriminatorMode r101 = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
        ALL_JSON_OBJECTS = r101;
        ClassDiscriminatorMode r102 = new ClassDiscriminatorMode("POLYMORPHIC", 2);
        POLYMORPHIC = r102;
        ClassDiscriminatorMode[] r103 = {r100, r101, r102};
        f505368a = r103;
        f505369b = EnumEntriesKt.enumEntries(r103);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) f505368a.clone();
    }

    public static ClassDiscriminatorMode valueOf(String r100) {
        return (ClassDiscriminatorMode) a.a(ClassDiscriminatorMode.class, r100);
    }

    public ClassDiscriminatorMode(String r100, int r101) {
        super(r100, r101);
    }
}
