package com.ss.android.lark.ai;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum IComposeController$EditorType extends Enum<IComposeController$EditorType> {
    public static final IComposeController$EditorType RTE = null;
    public static final IComposeController$EditorType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IComposeController$EditorType[] f408635a = null;
    private String value;

    static {
        IComposeController$EditorType r100 = new IComposeController$EditorType(CardAdapter.TEXT, 0, "text");
        TEXT = r100;
        IComposeController$EditorType r101 = new IComposeController$EditorType("RTE", 1, "rte");
        RTE = r101;
        f408635a = new IComposeController$EditorType[]{r100, r101};
    }

    public static IComposeController$EditorType[] values() {
        return (IComposeController$EditorType[]) f408635a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static IComposeController$EditorType valueOf(String r100) {
        return (IComposeController$EditorType) a.a(IComposeController$EditorType.class, r100);
    }

    public IComposeController$EditorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
