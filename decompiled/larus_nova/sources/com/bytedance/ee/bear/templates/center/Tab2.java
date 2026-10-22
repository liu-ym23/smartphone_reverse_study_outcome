package com.bytedance.ee.bear.templates.center;

import com.larus.media.MediaScene;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/Tab2;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", MediaScene.SYSTEM, "CUSTOM", "BUSNISS", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Tab2 extends Enum<Tab2> {
    public static final Tab2 BUSNISS = null;
    public static final Tab2 CUSTOM = null;
    public static final Tab2 SYSTEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Tab2[] f238891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f238892b = null;
    private final int value;

    public static EnumEntries<Tab2> getEntries() {
        return f238892b;
    }

    static {
        Tab2 r100 = new Tab2(MediaScene.SYSTEM, 0, R.string.Doc_List_v4TemplateGallery);
        SYSTEM = r100;
        Tab2 r101 = new Tab2("CUSTOM", 1, R.string.Doc_List_CustomTemplate);
        CUSTOM = r101;
        Tab2 r102 = new Tab2("BUSNISS", 2, R.string.Doc_List_EnterpriseTemplate);
        BUSNISS = r102;
        Tab2[] r103 = {r100, r101, r102};
        f238891a = r103;
        f238892b = EnumEntriesKt.enumEntries(r103);
    }

    public static Tab2[] values() {
        return (Tab2[]) f238891a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Tab2 valueOf(String r100) {
        return (Tab2) r27.a.a(Tab2.class, r100);
    }

    public Tab2(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
