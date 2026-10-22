package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Normal", ComposerHelper.CONFIG_LINK, "ShareRecord", "AddRecord", "AddLink", "Template", "DrillDown", "Form", "StageView", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditorMode extends Enum<EditorMode> {
    public static final EditorMode AddLink = null;
    public static final EditorMode AddRecord = null;
    public static final EditorMode DrillDown = null;
    public static final EditorMode Form = null;
    public static final EditorMode Link = null;
    public static final EditorMode Normal = null;
    public static final EditorMode ShareRecord = null;
    public static final EditorMode StageView = null;
    public static final EditorMode Template = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditorMode[] f209318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209319b = null;
    private final int value;

    public static EnumEntries<EditorMode> getEntries() {
        return f209319b;
    }

    static {
        EditorMode r100 = new EditorMode("Normal", 0, 0);
        Normal = r100;
        EditorMode r101 = new EditorMode(ComposerHelper.CONFIG_LINK, 1, 1);
        Link = r101;
        EditorMode r102 = new EditorMode("ShareRecord", 2, 2);
        ShareRecord = r102;
        EditorMode r103 = new EditorMode("AddRecord", 3, 3);
        AddRecord = r103;
        EditorMode r104 = new EditorMode("AddLink", 4, 4);
        AddLink = r104;
        EditorMode r105 = new EditorMode("Template", 5, 5);
        Template = r105;
        EditorMode r110 = new EditorMode("DrillDown", 6, 6);
        DrillDown = r110;
        EditorMode r111 = new EditorMode("Form", 7, 7);
        Form = r111;
        EditorMode r112 = new EditorMode("StageView", 8, 8);
        StageView = r112;
        EditorMode[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f209318a = r113;
        f209319b = EnumEntriesKt.enumEntries(r113);
    }

    public static EditorMode[] values() {
        return (EditorMode[]) f209318a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EditorMode valueOf(String r100) {
        return (EditorMode) a.a(EditorMode.class, r100);
    }

    public EditorMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
