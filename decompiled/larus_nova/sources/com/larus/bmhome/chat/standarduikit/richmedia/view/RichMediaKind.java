package com.larus.bmhome.chat.standarduikit.richmedia.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaKind;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaKind extends Enum<RichMediaKind> {
    public static final RichMediaKind IMAGE = null;
    public static final RichMediaKind VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichMediaKind[] f309592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309593b = null;

    public static EnumEntries<RichMediaKind> getEntries() {
        return f309593b;
    }

    static {
        RichMediaKind r100 = new RichMediaKind("IMAGE", 0);
        IMAGE = r100;
        RichMediaKind r101 = new RichMediaKind("VIDEO", 1);
        VIDEO = r101;
        RichMediaKind[] r102 = {r100, r101};
        f309592a = r102;
        f309593b = EnumEntriesKt.enumEntries(r102);
    }

    public static RichMediaKind[] values() {
        return (RichMediaKind[]) f309592a.clone();
    }

    public static RichMediaKind valueOf(String r100) {
        return (RichMediaKind) a.a(RichMediaKind.class, r100);
    }

    public RichMediaKind(String r100, int r101) {
        super(r100, r101);
    }
}
