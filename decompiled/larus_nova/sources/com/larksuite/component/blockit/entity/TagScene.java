package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum TagScene extends Enum<TagScene> {
    public static final TagScene Default = null;
    public static final TagScene PrivateCollection = null;
    public static final TagScene PublicTopic = null;
    public static final TagScene TeamKnowledge = null;
    public static final TagScene Teamwork = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagScene[] f282988a = null;
    int value;

    static {
        TagScene r100 = new TagScene("Default", 0, 0);
        Default = r100;
        TagScene r101 = new TagScene("Teamwork", 1, 1);
        Teamwork = r101;
        TagScene r102 = new TagScene("TeamKnowledge", 2, 2);
        TeamKnowledge = r102;
        TagScene r103 = new TagScene("PrivateCollection", 3, 3);
        PrivateCollection = r103;
        TagScene r104 = new TagScene("PublicTopic", 4, 4);
        PublicTopic = r104;
        f282988a = new TagScene[]{r100, r101, r102, r103, r104};
    }

    public static TagScene[] values() {
        return (TagScene[]) f282988a.clone();
    }

    public int value() {
        return this.value;
    }

    public static TagScene valueOf(String r100) {
        return (TagScene) r27.a.a(TagScene.class, r100);
    }

    public TagScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
