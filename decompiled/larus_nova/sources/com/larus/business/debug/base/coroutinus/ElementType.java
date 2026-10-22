package com.larus.business.debug.base.coroutinus;

import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/debug/base/coroutinus/ElementType;", "", "<init>", "(Ljava/lang/String;I)V", EventVerify.TYPE_LAUNCH, "withContext", "async", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ElementType extends Enum<ElementType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementType[] f320039a = null;
    public static final ElementType async = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320040b = null;
    public static final ElementType launch = null;
    public static final ElementType withContext = null;

    public static EnumEntries<ElementType> getEntries() {
        return f320040b;
    }

    static {
        ElementType r100 = new ElementType(EventVerify.TYPE_LAUNCH, 0);
        launch = r100;
        ElementType r101 = new ElementType("withContext", 1);
        withContext = r101;
        ElementType r102 = new ElementType("async", 2);
        async = r102;
        ElementType[] r103 = {r100, r101, r102};
        f320039a = r103;
        f320040b = EnumEntriesKt.enumEntries(r103);
    }

    public static ElementType[] values() {
        return (ElementType[]) f320039a.clone();
    }

    public static ElementType valueOf(String r100) {
        return (ElementType) a.a(ElementType.class, r100);
    }

    public ElementType(String r100, int r101) {
        super(r100, r101);
    }
}
