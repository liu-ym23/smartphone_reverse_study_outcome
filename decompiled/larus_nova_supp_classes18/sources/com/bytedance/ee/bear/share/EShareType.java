package com.bytedance.ee.bear.share;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/share/EShareType;", "", ResourceData.KEY_TYPE, "", "module", "", "extra", "", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;)V", "getType", "()I", "getModule", "()Ljava/lang/String;", "getExtra", "()Ljava/util/Map;", "FORM", "VIEW", "Record", "DASHBOARD_REDIRECT", "DASHBOARD", "BASE_ADD", "BASE_ADD_SUBMIT", "UNSUPPORT", "appendExtra", "", "key", "value", "Companion", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public static final /* synthetic */ EShareType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final Map<String, Object> extra;
    private final String module;
    private final int type;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EShareType a(int r5) {
            EShareType[] r0 = EShareType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            EShareType r3 = r0[r2];
            if (r3.getType() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return EShareType.UNSUPPORT;
        }
    }

    public static EnumEntries<EShareType> getEntries() {
        return b;
    }

    @JvmStatic
    public static final EShareType lookupShareType(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    static {
        EShareType r6 = new EShareType("FORM", 0, 1, DocumentType.BITABLE_FORM_NAME, new LinkedHashMap());
        FORM = r6;
        EShareType r0 = new EShareType("VIEW", 1, 2, "view", new LinkedHashMap());
        VIEW = r0;
        EShareType r1 = new EShareType("Record", 2, 3, "record", new LinkedHashMap());
        Record = r1;
        EShareType r2 = new EShareType("DASHBOARD_REDIRECT", 3, 4, "dashboard", new LinkedHashMap());
        DASHBOARD_REDIRECT = r2;
        EShareType r3 = new EShareType("DASHBOARD", 4, 5, "dashboard", new LinkedHashMap());
        DASHBOARD = r3;
        EShareType r4 = new EShareType("BASE_ADD", 5, 6, DocumentType.BASE_ADD_NAME, new LinkedHashMap());
        BASE_ADD = r4;
        EShareType r5 = new EShareType("BASE_ADD_SUBMIT", 6, 7, DocumentType.BASE_ADD_NAME, new LinkedHashMap());
        BASE_ADD_SUBMIT = r5;
        EShareType r13 = new EShareType("UNSUPPORT", 7, -1, "unsupport", new LinkedHashMap());
        UNSUPPORT = r13;
        EShareType[] r7 = {r6, r0, r1, r2, r3, r4, r5, r13};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static EShareType[] values() {
        return (EShareType[]) a.clone();
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

    public static EShareType valueOf(String r1) {
        return (EShareType) r27.a.a(EShareType.class, r1);
    }

    public final Object getExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.extra.get(r2);
    }

    public final void appendExtra(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.extra.put(r2, r3);
    }

    public EShareType(String r1, int r2, int r3, String r4, Map r5) {
        super(r1, r2);
        this.type = r3;
        this.module = r4;
        this.extra = r5;
    }
}
