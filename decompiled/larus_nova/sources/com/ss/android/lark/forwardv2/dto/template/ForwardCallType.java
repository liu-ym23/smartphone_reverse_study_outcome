package com.ss.android.lark.forwardv2.dto.template;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SHORT_CUT", "CLICK", "TOPIC_CLICK", "QUICK_CLICK", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardCallType extends Enum<ForwardCallType> {
    public static final ForwardCallType CLICK = null;
    public static final a Companion = null;
    public static final ForwardCallType QUICK_CLICK = null;
    public static final ForwardCallType SHORT_CUT = null;
    public static final ForwardCallType TOPIC_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardCallType[] f424823a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424824b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ForwardCallType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            switch(r100.hashCode()) {
                case -107997576: goto L18;
                case 94750088: goto L14;
                case 514222262: goto L10;
                case 1416500313: goto L6;
                default: goto L22;
            };
        L6:
            if (r100.equals("shortcutkey") == false) goto L22;
            return ForwardCallType.SHORT_CUT;
        L10:
            if (r100.equals("quick_click") == false) goto L22;
            return ForwardCallType.QUICK_CLICK;
        L14:
            if (r100.equals("click") == false) goto L22;
            return ForwardCallType.CLICK;
        L18:
            if (r100.equals("topic_click") == false) goto L22;
            return ForwardCallType.TOPIC_CLICK;
        L22:
            return ForwardCallType.CLICK;
        }
    }

    @JvmStatic
    public static final ForwardCallType forNumber(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<ForwardCallType> getEntries() {
        return f424824b;
    }

    static {
        ForwardCallType r100 = new ForwardCallType("SHORT_CUT", 0, "shortcutkey");
        SHORT_CUT = r100;
        ForwardCallType r101 = new ForwardCallType("CLICK", 1, "click");
        CLICK = r101;
        ForwardCallType r102 = new ForwardCallType("TOPIC_CLICK", 2, "topic_click");
        TOPIC_CLICK = r102;
        ForwardCallType r103 = new ForwardCallType("QUICK_CLICK", 3, "quick_click");
        QUICK_CLICK = r103;
        ForwardCallType[] r104 = {r100, r101, r102, r103};
        f424823a = r104;
        f424824b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ForwardCallType[] values() {
        return (ForwardCallType[]) f424823a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ForwardCallType valueOf(String r100) {
        return (ForwardCallType) r27.a.a(ForwardCallType.class, r100);
    }

    public ForwardCallType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
