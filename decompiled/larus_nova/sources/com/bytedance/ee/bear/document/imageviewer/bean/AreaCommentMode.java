package com.bytedance.ee.bear.document.imageviewer.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/bean/AreaCommentMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CREATE", "EDIT", "value", "getValue", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AreaCommentMode extends Enum<AreaCommentMode> {
    public static final AreaCommentMode CREATE = null;
    public static final a Companion = null;
    public static final AreaCommentMode EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AreaCommentMode[] f220096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f220097b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AreaCommentMode> getEntries() {
        return f220097b;
    }

    static {
        AreaCommentMode r100 = new AreaCommentMode("CREATE", 0, "create");
        CREATE = r100;
        AreaCommentMode r101 = new AreaCommentMode("EDIT", 1, "edit");
        EDIT = r101;
        AreaCommentMode[] r102 = {r100, r101};
        f220096a = r102;
        f220097b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static AreaCommentMode[] values() {
        return (AreaCommentMode[]) f220096a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static final /* synthetic */ String access$getValue$p(AreaCommentMode r100) {
        return r100.value;
    }

    public static AreaCommentMode valueOf(String r100) {
        return (AreaCommentMode) r27.a.a(AreaCommentMode.class, r100);
    }

    public AreaCommentMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
