package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$XToastType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ERROR", "INFO", "LOADING", "SUCCESS", "WARNING", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$Internal$XToastType extends Enum<IWidget$Internal$XToastType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$Internal$XToastType[] $VALUES = null;
    public static final a Companion = null;
    public static final IWidget$Internal$XToastType ERROR = null;
    public static final IWidget$Internal$XToastType INFO = null;
    public static final IWidget$Internal$XToastType LOADING = null;
    public static final IWidget$Internal$XToastType SUCCESS = null;
    public static final IWidget$Internal$XToastType WARNING = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ IWidget$Internal$XToastType[] $values() {
        return new IWidget$Internal$XToastType[]{ERROR, INFO, LOADING, SUCCESS, WARNING};
    }

    public static EnumEntries<IWidget$Internal$XToastType> getEntries() {
        return $ENTRIES;
    }

    static {
        ERROR = new IWidget$Internal$XToastType("ERROR", 0, "error");
        INFO = new IWidget$Internal$XToastType("INFO", 1, "info");
        LOADING = new IWidget$Internal$XToastType("LOADING", 2, "loading");
        SUCCESS = new IWidget$Internal$XToastType("SUCCESS", 3, "success");
        WARNING = new IWidget$Internal$XToastType("WARNING", 4, "warning");
        IWidget$Internal$XToastType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static IWidget$Internal$XToastType[] values() {
        return (IWidget$Internal$XToastType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IWidget$Internal$XToastType valueOf(String r100) {
        return (IWidget$Internal$XToastType) r27.a.a(IWidget$Internal$XToastType.class, r100);
    }

    private IWidget$Internal$XToastType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
