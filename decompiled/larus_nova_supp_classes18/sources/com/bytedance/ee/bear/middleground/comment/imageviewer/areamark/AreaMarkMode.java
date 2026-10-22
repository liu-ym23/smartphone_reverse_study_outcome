package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/imageviewer/areamark/AreaMarkMode;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", "READ", "createTextRes", "", "getCreateTextRes", "()I", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum AreaMarkMode extends Enum<AreaMarkMode> {
    public static final AreaMarkMode EDIT = null;
    public static final AreaMarkMode READ = null;
    public static final /* synthetic */ AreaMarkMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public AreaMarkMode() {
        throw null;
    }

    public static EnumEntries<AreaMarkMode> getEntries() {
        return b;
    }

    public abstract int getCreateTextRes();

    static {
        final String r1 = "EDIT";
        final int r2 = 0;
        AreaMarkMode r0 = new EDIT(r1, r2);
        EDIT = r0;
        final String r3 = "READ";
        final int r4 = 1;
        AreaMarkMode r5 = new READ(r3, r4);
        READ = r5;
        AreaMarkMode[] r6 = {r0, r5};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static AreaMarkMode[] values() {
        return (AreaMarkMode[]) a.clone();
    }

    public static AreaMarkMode valueOf(String r1) {
        return (AreaMarkMode) r27.a.a(AreaMarkMode.class, r1);
    }

    public AreaMarkMode(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
