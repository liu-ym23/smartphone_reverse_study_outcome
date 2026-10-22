package com.bytedance.ee.bear.share;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/share/EShareType;", "", "type", "", EventConstant.Key.MODULE, "", "extra", "", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;)V", "getType", "()I", "getModule", "()Ljava/lang/String;", "getExtra", "()Ljava/util/Map;", "FORM", "VIEW", "Record", "DASHBOARD_REDIRECT", "DASHBOARD", "BASE_ADD", "BASE_ADD_SUBMIT", "UNSUPPORT", "appendExtra", "", "key", "value", "Companion", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EShareType extends Enum<EShareType> {
    public static final EShareType BASE_ADD = null;
    public static final EShareType BASE_ADD_SUBMIT = null;
    public static final a Companion = null;
    public static final EShareType DASHBOARD = null;
    public static final EShareType DASHBOARD_REDIRECT = null;
    public static final EShareType FORM = null;
    public static final EShareType Record = null;
    public static final EShareType UNSUPPORT = null;
    public static final EShareType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EShareType[] f236991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236992b = null;
    private final Map<String, Object> extra;
    private final String module;
    private final int type;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EShareType a(int r100) {
            EShareType[] r101 = EShareType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            EShareType r104 = r101[r103];
            if (r104.getType() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return EShareType.UNSUPPORT;
        }
    }

    public static EnumEntries<EShareType> getEntries() {
        return f236992b;
    }

    @JvmStatic
    public static final EShareType lookupShareType(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        EShareType r100 = new EShareType("FORM", 0, 1, "form", new LinkedHashMap());
        FORM = r100;
        EShareType r101 = new EShareType("VIEW", 1, 2, "view", new LinkedHashMap());
        VIEW = r101;
        EShareType r102 = new EShareType("Record", 2, 3, "record", new LinkedHashMap());
        Record = r102;
        EShareType r103 = new EShareType("DASHBOARD_REDIRECT", 3, 4, "dashboard", new LinkedHashMap());
        DASHBOARD_REDIRECT = r103;
        EShareType r104 = new EShareType("DASHBOARD", 4, 5, "dashboard", new LinkedHashMap());
        DASHBOARD = r104;
        EShareType r105 = new EShareType("BASE_ADD", 5, 6, DocumentType.BASE_ADD_NAME, new LinkedHashMap());
        BASE_ADD = r105;
        EShareType r106 = new EShareType("BASE_ADD_SUBMIT", 6, 7, DocumentType.BASE_ADD_NAME, new LinkedHashMap());
        BASE_ADD_SUBMIT = r106;
        EShareType r110 = new EShareType("UNSUPPORT", 7, -1, "unsupport", new LinkedHashMap());
        UNSUPPORT = r110;
        EShareType[] r107 = {r100, r101, r102, r103, r104, r105, r106, r110};
        f236991a = r107;
        f236992b = EnumEntriesKt.enumEntries(r107);
        Companion = new a();
    }

    public static EShareType[] values() {
        return (EShareType[]) f236991a.clone();
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getModule() {
        return this.module;
    }

    public final int getType() {
        return this.type;
    }

    public static EShareType valueOf(String r100) {
        return (EShareType) r27.a.a(EShareType.class, r100);
    }

    public final Object getExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.extra.get(r100);
    }

    public final void appendExtra(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.extra.put(r100, r101);
    }

    public EShareType(String r100, int r101, int r102, String r103, Map r104) {
        super(r100, r101);
        this.type = r102;
        this.module = r103;
        this.extra = r104;
    }
}
