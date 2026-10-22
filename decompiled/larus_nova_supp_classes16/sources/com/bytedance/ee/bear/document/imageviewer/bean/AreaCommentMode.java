package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/bean/AreaCommentMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CREATE", "EDIT", "value", "getValue", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AreaCommentMode extends Enum<AreaCommentMode> {
    public static final AreaCommentMode CREATE = null;
    public static final a Companion = null;
    public static final AreaCommentMode EDIT = null;
    public static final /* synthetic */ AreaCommentMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AreaCommentMode> getEntries() {
        return b;
    }

    static {
        AreaCommentMode r0 = new AreaCommentMode("CREATE", 0, "create");
        CREATE = r0;
        AreaCommentMode r1 = new AreaCommentMode("EDIT", 1, JSEventListener.ACTION_EDIT);
        EDIT = r1;
        AreaCommentMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static AreaCommentMode[] values() {
        return (AreaCommentMode[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static final /* synthetic */ String access$getValue$p(AreaCommentMode r0) {
        return r0.value;
    }

    public static AreaCommentMode valueOf(String r1) {
        return (AreaCommentMode) r27.a.a(AreaCommentMode.class, r1);
    }

    public AreaCommentMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
