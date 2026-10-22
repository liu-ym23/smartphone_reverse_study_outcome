package com.ss.android.lark.chameleonv2.lkapi.net;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GET", "POST", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum INet$Internal$HttpMethod extends Enum<INet$Internal$HttpMethod> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ INet$Internal$HttpMethod[] $VALUES = null;
    public static final INet$Internal$HttpMethod GET = null;
    public static final INet$Internal$HttpMethod POST = null;
    private final String value;

    private static final /* synthetic */ INet$Internal$HttpMethod[] $values() {
        return new INet$Internal$HttpMethod[]{GET, POST};
    }

    public static EnumEntries<INet$Internal$HttpMethod> getEntries() {
        return $ENTRIES;
    }

    static {
        GET = new INet$Internal$HttpMethod("GET", 0, "GET");
        POST = new INet$Internal$HttpMethod("POST", 1, "POST");
        INet$Internal$HttpMethod[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static INet$Internal$HttpMethod[] values() {
        return (INet$Internal$HttpMethod[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static INet$Internal$HttpMethod valueOf(String r100) {
        return (INet$Internal$HttpMethod) r27.a.a(INet$Internal$HttpMethod.class, r100);
    }

    private INet$Internal$HttpMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
