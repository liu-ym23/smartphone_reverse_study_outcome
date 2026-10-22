package com.bytedance.ee.bear.bitable.formpreload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/formpreload/FormExeEvn;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Web", "Base", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FormExeEvn extends Enum<FormExeEvn> {
    public static final FormExeEvn Base = null;
    public static final FormExeEvn Web = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormExeEvn[] f212138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212139b = null;

    public static EnumEntries<FormExeEvn> getEntries() {
        return f212139b;
    }

    static {
        FormExeEvn r100 = new FormExeEvn("Web", 0);
        Web = r100;
        FormExeEvn r101 = new FormExeEvn("Base", 1);
        Base = r101;
        FormExeEvn[] r102 = {r100, r101};
        f212138a = r102;
        f212139b = EnumEntriesKt.enumEntries(r102);
    }

    public static FormExeEvn[] values() {
        return (FormExeEvn[]) f212138a.clone();
    }

    public static FormExeEvn valueOf(String r100) {
        return (FormExeEvn) a.a(FormExeEvn.class, r100);
    }

    public FormExeEvn(String r100, int r101) {
        super(r100, r101);
    }
}
