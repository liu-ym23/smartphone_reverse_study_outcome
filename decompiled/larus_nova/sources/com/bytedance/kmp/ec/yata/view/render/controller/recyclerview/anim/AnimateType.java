package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/controller/recyclerview/anim/AnimateType;", "", "ADD", "MOVE", "REMOVE", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum AnimateType extends Enum<AnimateType> {
    public static final AnimateType ADD = null;
    public static final AnimateType MOVE = null;
    public static final AnimateType REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimateType[] f251913a = null;

    public static AnimateType valueOf(String r100) {
        return (AnimateType) r27.a.a(AnimateType.class, r100);
    }

    public static AnimateType[] values() {
        return (AnimateType[]) f251913a.clone();
    }

    static {
        AnimateType r100 = new AnimateType("ADD", 0);
        ADD = r100;
        AnimateType r101 = new AnimateType("MOVE", 1);
        MOVE = r101;
        AnimateType r102 = new AnimateType("REMOVE", 2);
        REMOVE = r102;
        f251913a = new AnimateType[]{r100, r101, r102};
    }

    public AnimateType(String r100, int r101) {
        super(r100, r101);
    }
}
