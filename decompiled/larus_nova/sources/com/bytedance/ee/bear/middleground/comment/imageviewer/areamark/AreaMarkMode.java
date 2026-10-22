package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/imageviewer/areamark/AreaMarkMode;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", "READ", "createTextRes", "", "getCreateTextRes", "()I", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum AreaMarkMode extends Enum<AreaMarkMode> {
    public static final AreaMarkMode EDIT = null;
    public static final AreaMarkMode READ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AreaMarkMode[] f231658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231659b = null;

    public AreaMarkMode() {
        throw null;
    }

    public static EnumEntries<AreaMarkMode> getEntries() {
        return f231659b;
    }

    public abstract int getCreateTextRes();

    static {
        final String r100 = "EDIT";
        final int r101 = 0;
        AreaMarkMode r102 = new EDIT(r100, r101);
        EDIT = r102;
        final String r103 = "READ";
        final int r104 = 1;
        AreaMarkMode r105 = new READ(r103, r104);
        READ = r105;
        AreaMarkMode[] r106 = {r102, r105};
        f231658a = r106;
        f231659b = EnumEntriesKt.enumEntries(r106);
    }

    public static AreaMarkMode[] values() {
        return (AreaMarkMode[]) f231658a.clone();
    }

    public static AreaMarkMode valueOf(String r100) {
        return (AreaMarkMode) r27.a.a(AreaMarkMode.class, r100);
    }

    public AreaMarkMode(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
